/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static booton.translator.web.WebSupport.*;

import org.w3c.dom.NodeList;

/**
 * @version 2012/11/27 18:19:08
 */
public class Champion {

    /** The name. */
    private String name;

    /** The initial status. */
    private int healthInitial;

    /** The per level status. */
    private int healthPerLevel;

    /**
     * @param name
     * @param healthInitial
     * @param healthPerLevel
     */
    public Champion(String name, int healthInitial, int healthPerLevel) {
        this.name = name;
        this.healthInitial = healthInitial;
        this.healthPerLevel = healthPerLevel;
    }

    /**
     * @param level
     * @return
     */
    public int getHealthAtLvele(int level) {
        return healthInitial + healthPerLevel * level;
    }

    public static void jsmain() {
        System.out.println("start!!!");

        Champion champion = new Champion("Teemo", 100, 10);

        System.out.println(champion.name + "  " + champion.getHealthAtLvele(7));

        NodeList list = document.getElementsByTagName("p");

        for (int i = 0; i < list.getLength(); i++) {
            list.item(i).setTextContent(champion.name + "  " + champion.getHealthAtLvele(i));
        }
    }
}
