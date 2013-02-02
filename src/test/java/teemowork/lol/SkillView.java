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

import js.util.jQuery;

/**
 * @version 2013/02/02 23:26:12
 */
public class SkillView {

    /** The skill. */
    private Skill skill;

    /** The skill version. */
    private Version version;

    /**
     * <p>
     * Build skill description as HTML.
     * </p>
     * 
     * @param root
     * @param skill
     * @param version
     * @param level
     */
    public static void buildText(jQuery root, Skill skill, Version version, int level) {
        SkillDescriptor descriptor = skill.getDescriptor(version);
        String text = descriptor.getText();

    }
}
