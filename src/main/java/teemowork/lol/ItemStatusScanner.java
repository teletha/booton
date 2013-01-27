/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import kiss.I;
import kiss.XML;
import teemowork.model.Item;

/**
 * @version 2013/01/25 21:19:38
 */
public class ItemStatusScanner {

    public static void main(String[] args) {
        XML xml = I.xml("http://loljp-clone.tk/wiki/index.php?Item");

        for (XML row : xml.find(".item_description")) {
            String name = row.find(".name a").text();
            String cost = row.find(".cost").text();
            XML built = row.find(".built_from");
            String stats = row.find(".stats").text();

            Item item = find(name);

            if (item != null) {
                System.out.print("P0000.update(Item." + item.name() + ")");

                String from = computeBuild(built);

                if (from.length() != 0) {
                    System.out.print(".build(" + from + ")");
                }

                System.out.print(".cost(" + computeCost(cost) + ")");

                for (Entry<String, String> set : computeStats(stats).entrySet()) {
                    System.out.print("." + set.getKey() + "(" + set.getValue() + ")");
                }
                System.out.println(";");
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
        List<Item> items = new ArrayList();

        for (XML xml : built.find("img")) {
            Item item = find(xml.attr("alt"));

            if (item != null) {
                items.add(item);
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < items.size(); i++) {
            builder.append("Item." + items.get(i).name());

            if (i < items.size() - 1) {
                builder.append(", ");
            }
        }

        return builder.toString();
    }

    private static Item find(String name) {
        for (Item item : Item.values()) {
            if (item.name.equals(name) || item.name().toLowerCase().equals(name)) {
                return item;
            }
        }
        return null;
    }

    private static Map<String, String> computeStats(String text) {
        Map<String, String> map = new HashMap();

        for (String entry : text.split("\\+")) {
            int index = entry.indexOf(' ');

            if (index != -1) {
                String number = entry.substring(0, index);
                String type = entry.substring(index + 1);

                switch (type) {
                case "Ability Power":
                    map.put("ap", number);
                    break;

                case "Attack Speed":
                    map.put("as", trim(number));
                    break;

                case "Health Regen per 5 seconds":
                case "Health Regen/5":
                    map.put("hreg", number);
                    break;

                case "Health":
                    map.put("health", number);
                    break;

                case "Mana":
                    map.put("mana", number);
                    break;

                case "Magic Resist":
                    map.put("mr", number);
                    break;

                case "Life Steal":
                    map.put("ls", trim(number));
                    break;

                case "Attack Damage":
                    map.put("ad", number);
                    break;

                case "Mana Regen per 5 seconds":
                case "Mana Regen/5":
                    map.put("mreg", number);
                    break;

                case "Cooldown Reduction":
                case "cooldown reduction":
                    map.put("cdr", trim(number));
                    break;

                case "Movement Speed":
                    map.put("" + "ms", trim(number));
                    break;

                case "Critical Chance":
                case "Critical Strike Chance":
                    map.put("critical", trim(number));
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
}
