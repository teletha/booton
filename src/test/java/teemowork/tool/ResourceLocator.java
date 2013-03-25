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

import java.nio.file.Path;

import kiss.I;

/**
 * @version 2013/03/25 9:46:52
 */
public class ResourceLocator {

    /** The resource root. */
    private static final String Resources = "src/main/resources/teemowork/";

    /** The champion icons. */
    public static final Path ChampionIcons = I.locate(Resources + "icon");

    /** The item icons. */
    public static final Path ItemIcons = I.locate(Resources + "item");

    /** The mastery icons. */
    public static final Path MasteryIcon = I.locate(Resources + "mastery/s3");

    /** The skill icons. */
    public static final Path SkillIcon = I.locate(Resources + "skill");
}
