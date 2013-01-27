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

import kiss.I;
import kiss.XML;

/**
 * @version 2013/01/25 18:29:22
 */
public class ItemIdScanner {

    /**
     * <p>
     * Retrieve item names and id.
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        XML table = I.xml("http://leagueoflegends.wikia.com/wiki/Recommended_item_code").find("table tr");

        for (XML row : table) {
            String id = row.find("td:nth-child(1) b").text();
            String name = row.find("td:nth-child(2) span a span").text();
            String enchantment = row.find("td:nth-child(3)").text();

            if (name.endsWith(", The")) {
                name = "The " + name.substring(0, name.length() - 5);
            }

            if (enchantment.startsWith("Enchantment:")) {
                name = name + " " + enchantment.substring(13).trim();
            }

            if (id.length() != 0) {
                String enumName = name.replaceAll(" of ", "Of")
                        .replaceAll(" the ", "The")
                        .replaceAll("'", "")
                        .replaceAll(":", "")
                        .replaceAll(",", "")
                        .replaceAll("-", "")
                        .replaceAll("\\.", "")
                        .replaceAll("\\s", "");

                System.out.println("/** " + name + " */");
                System.out.println("public static final Item " + enumName + " = new Item(" + id + ", \"" + name + "\");\r\n");
            }
        }
    }
}
