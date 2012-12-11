/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import teemowork.model.Champion;

/**
 * @version 2012/12/11 11:30:34
 */
public class ChampionNameSnippet {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        for (Field field : Champion.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
                System.out.println("/** The champion definition. */");
                System.out.println("public static Champion " + field.getName() + " = new Champion(\"" + field.get(null) + "\");");
            }
        }
    }
}
