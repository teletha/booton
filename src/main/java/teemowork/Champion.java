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
import booton.translator.web.JQuery.Event;
import booton.translator.web.JQuery.EventListener;

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
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Champion) {
            return name.equals(((Champion) obj).name);
        }
        return false;
    }

    /**
     * @param level
     * @return
     */
    public int getHealthAtLvele(int level) {
        return healthInitial + healthPerLevel * level;
    }

    public static void jsmain() {
        Champion champion = new Champion("Teemo", 100, 10);
        Object some = champion;

        System.out.println(champion.name + "  " + champion.getHealthAtLvele(7));
        System.out.println($("p").after("<p/>").next().text("test").attr("class", "new").css("color", "red"));

        System.out.println(champion.hashCode());
        System.out.println(champion.hashCode());
        System.out.println(some.equals(champion));
        System.out.println(new Champion("Teemso", 0, 0).equals(champion));

        $("p").click(new EventListener() {

            @Override
            public void handler(Event event) {
                System.out.println(event);
                System.out.println(event.target);
            }
        });

        // List<Champion> list = new ArrayList();
        // list.add(champion);
        // System.out.println(list.get(0));
        //
        // HashMap<String, Champion> map = new HashMap();
        // map.put("test", champion);
        // System.out.println(map);
        // System.out.println(map.get("test"));
    }
}
