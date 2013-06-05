/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.tool;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kiss.I;
import kiss.XML;
import teemowork.model.Item;
import teemowork.model.Status;

/**
 * @version 2013/01/25 21:19:38
 */
public class ItemStatusScanner {

    public static void main(String[] args) {
        XML xml = I.xml("http://loljp-clone.tk/wiki/index.php?Item");

        boolean ok = false;

        for (XML row : xml.find(".item_description")) {
            String name = row.find(".name a").text();

            if (ok) {
                XML list = row.find(".effect .list1");

                for (XML dt : list.find("dt")) {
                    String item = findItemName(name);

                    if (item != null) {
                        String title = dt.text();
                        String description = dt.next().text();

                        boolean isActive = title.toLowerCase().contains("active");
                        boolean isUnique = title.toLowerCase().contains("unique");

                        int start = title.indexOf("-");
                        int end = title.indexOf(":");

                        if (start == -1) {
                            title = "";
                        } else {
                            title = title.substring(start + 2, end);
                        }

                        if (title.length() != 0) {
                            System.out.print(convert(title));
                        } else {
                            System.out.print(convert(name));
                        }
                        System.out.print(".update()");

                        if (!isUnique) {
                            System.out.print(".ununique()");
                        }

                        if (isActive) {
                            System.out.println(".active(\"" + description + "\");");
                        } else {
                            System.out.println(".passive(\"" + description + "\");");
                        }
                    }
                }
            } else if (name.equals("Madred's Razors")) {
                ok = true;
            }
        }
    }

    /**
     * <p>
     * </p>
     * 
     * @param built
     * @return
     */
    private static String computeBuild(XML built) {
        List<String> items = new ArrayList();

        for (XML xml : built.find("img")) {
            String item = xml.attr("src");

            if (item != null) {
                item = findItemName(item.substring(item.indexOf("item_") + 5, item.indexOf(".jpg")));

                if (item != null) {
                    items.add(item);

                }
            }
        }

        return I.join(items, ",");
    }

    private static String findItemName(String name) {
        name = name.replaceAll(" of ", "Of")
                .replaceAll(" the ", "The")
                .replaceAll("'", "")
                .replaceAll(":", "")
                .replaceAll(",", "")
                .replaceAll("-", "")
                .replaceAll("\\.", "")
                .replaceAll("\\s", "");

        for (Field field : Item.class.getFields()) {
            try {
                if (field.getName().toLowerCase().equals(name.toLowerCase())) {
                    return field.getName();
                }
            } catch (IllegalArgumentException e) {
                throw I.quiet(e);
            }
        }

        return null;
    }

    private static Map<Status, String> computeStats(String text) {
        Map<Status, String> map = new HashMap();

        for (String entry : text.split("\\+")) {
            int index = entry.indexOf(' ');

            if (index != -1) {
                String number = entry.substring(0, index);
                String type = entry.substring(index + 1);

                switch (type) {
                case "Ability Power":
                    map.put(Status.AP, number);
                    break;

                case "Attack Speed":
                    map.put(Status.ASRatio, trim(number));
                    break;

                case "Health Regen per 5 seconds":
                case "Health Regen/5":
                    map.put(Status.Hreg, number);
                    break;

                case "Health":
                    map.put(Status.Health, number);
                    break;

                case "Mana":
                    map.put(Status.Mana, number);
                    break;

                case "Armor":
                    map.put(Status.AR, number);
                    break;

                case "Magic Resist":
                    map.put(Status.MR, number);
                    break;

                case "Life Steal":
                    map.put(Status.LS, trim(number));
                    break;

                case "Attack Damage":
                    map.put(Status.AD, number);
                    break;

                case "Mana Regen per 5 seconds":
                case "Mana Regen/5":
                    map.put(Status.Mreg, number);
                    break;

                case "Cooldown Reduction":
                case "cooldown reduction":
                    map.put(Status.CDR, trim(number));
                    break;

                case "Movement Speed":
                    map.put(Status.MSRatio, trim(number));
                    break;

                case "Critical Chance":
                case "Critical Strike Chance":
                    map.put(Status.Critical, trim(number));
                    break;
                }
            }
        }
        return map;
    }

    private static String trim(String text) {
        if (text.endsWith("%")) {
            return text.substring(0, text.length() - 1);
        } else {
            return text;
        }
    }

    private static String computeCost(String text) {
        text = text.replaceAll(",", "");

        int start = text.indexOf('(');
        int end = text.indexOf(')', start);

        String cost = text.substring(start + 1, end).trim();

        if (cost.equals("-")) {
            return text.substring(0, start).trim();
        } else if (cost.equalsIgnoreCase("special")) {
            return "0";
        } else {
            return cost;
        }
    }

    private static String convert(String name) {
        return name.replaceAll(" of ", "Of")
                .replaceAll(" the ", "The")
                .replaceAll("'", "")
                .replaceAll(":", "")
                .replaceAll(",", "")
                .replaceAll("-", "")
                .replaceAll("\\.", "")
                .replaceAll("\\s", "");
    }
}
