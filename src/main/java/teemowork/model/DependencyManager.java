/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Skill.*;

import java.util.Set;

import js.util.HashSet;

/**
 * @version 2013/03/12 10:43:36
 */
public class DependencyManager {

    /** The circular dependency manager. */
    private static final Set<Skill> dependencies = new HashSet();

    /**
     * <p>
     * Manage status dependency graph.
     * </p>
     * 
     * @param skill A target skill.
     * @return A result.
     */
    public static boolean use(Skill skill) {
        if (!dependencies.add(skill)) {
            if (skill == CrimsonPact || skill == LivingShadow) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Manage status dependency graph.
     * </p>
     * 
     * @param skill A target skill.
     */
    public static void unuse(Skill skill) {
        dependencies.remove(skill);
    }
}
