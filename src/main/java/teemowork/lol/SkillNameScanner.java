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
import java.util.List;

import kiss.I;
import kiss.XML;

/**
 * @version 2013/01/28 13:56:34
 */
public class SkillNameScanner {

    public static void main(String[] args) {
        XML xml = I.xml("http://loljp-clone.tk/wiki/index.php?%A5%C7%A1%BC%A5%BF%A5%D9%A1%BC%A5%B9%2F%A5%C1%A5%E3%A5%F3%A5%D4%A5%AA%A5%F3");

        for (XML item : xml.find(".champion_summary")) {
            String name = item.find(".intro a:nth-type-child(2)").text();

            int order = 0;
            List<String> names = new ArrayList<String>();

            for (XML skill : item.find(".abilities dt")) {
                String skillName = skill.text();
                SkillKey key = SkillKey.values()[order++];

                // System.out.println("/** The skill name. */");
                // System.out.println(rename(skillName) + "(\"" + skillName + "\", SkillKey." + key
                // + "),\r\n");
                names.add(rename(skillName));
            }
            System.out.println("/** The champion name. */");
            System.out.println(rename(name) + "(\"" + name + "\", " + I.join(names, ", ") + "),\r\n");
        }
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
