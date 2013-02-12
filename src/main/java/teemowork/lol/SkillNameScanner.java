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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kiss.I;
import kiss.XML;

/**
 * @version 2013/01/28 13:56:34
 */
public class SkillNameScanner {

    public static void main(String[] args) {
        XML xml = I.xml("http://loljp-clone.tk/wiki/index.php?%A5%C7%A1%BC%A5%BF%A5%D9%A1%BC%A5%B9%2F%A5%C1%A5%E3%A5%F3%A5%D4%A5%AA%A5%F3");

        root: for (XML item : xml.find(".champion_summary")) {
            String name = item.find(".intro a:nth-type-child(2)").text();

            switch (name) {
            case "Fizz":
            case "Ahri":
            case "Akali":
            case "Alistar":
            case "Annie":
            case "Amumu":
            case "Anivia":
            case "Ashe":
            case "Blitzcrank":
            case "Brand":
            case "Caitlyn":
            case "Ryze":
                continue root;
            }
            System.out.println("");
            System.out.println("/** " + name + " */");

            for (XML skill : item.find(".abilities dt")) {
                String skillName = skill.text();
                String text = skill.find("+dd").text();

                int start = 0;
                int end = text.lastIndexOf('。') + 1;

                String description = text.substring(start, end);
                String range = find(text, RANGE);
                String cd = find(text, CD);
                String mana = find(text, MANA);

                System.out.print(rename(skillName) + ".update()");

                start = description.indexOf("Active");

                if (start == 0) {
                    System.out.print(".active(\"" + description.substring(7).trim() + "\")");
                } else if (start == -1) {
                    System.out.print(".passive(\"" + description.substring(8).trim() + "\")");
                } else {
                    System.out.print(".passive(\"" + description.substring(8, start).trim() + "\")");
                    System.out.print(".active(\"" + description.substring(start + 7).trim() + "\")");
                }

                if (cd.endsWith("s")) {
                    cd = cd.substring(0, cd.length() - 1);
                }
                write("cost", mana);
                write("cd", cd);
                write("range", range);

                System.out.println(";");
            }
        }
    }

    private static void write(String methodName, String text) {
        if (text.length() == 0) {
            return;
        }

        if (!text.contains("/")) {
            System.out.print("." + methodName + "(" + text + ")");
        } else {
            String[] values = text.split("\\s*/\\s*");
            double base = Double.valueOf(values[0]);
            double next = Double.valueOf(values[1]);
            double diff = next - base;

            System.out.print("." + methodName + "(" + write(base) + ", " + write(diff) + ")");
        }
    }

    private static String write(double value) {
        if (value == (int) value) {
            String text = String.valueOf(value);
            int index = text.indexOf(".");

            if (index == -1) {
                return text;
            } else {
                return text.substring(0, index);
            }
        } else {
            return String.valueOf(value);
        }
    }

    private static Pattern RANGE = Pattern.compile(".*Range:\\s*([\\d/]+).*");

    private static Pattern CD = Pattern.compile(".*CD:\\s*([\\d/\\.s]+).*");

    private static Pattern MANA = Pattern.compile(".*MN:\\s*([\\d/\\.]+).*");

    private static String find(String text, Pattern pattern) {
        Matcher matcher = pattern.matcher(text);

        if (!matcher.matches()) {
            return "";
        }

        return matcher.group(1);
    }

    public static final String rename(String name) {
        return name.replaceAll(" of ", "Of")
                .replaceAll(" the ", "The")
                .replaceAll("'", "")
                .replaceAll(":", "")
                .replaceAll(",", "")
                .replaceAll("-", "")
                .replaceAll("\\.", "")
                .replaceAll("/", "")
                .replaceAll("!", "")
                .replaceAll("\\s", "");
    }
}
