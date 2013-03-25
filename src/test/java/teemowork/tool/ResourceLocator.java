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
    public static final Path Resources = I.locate("src/main/resources/teemowork");

    /** The champion icons. */
    public static final Path ChampionIcons = Resources.resolve("icon");

    /** The item icons. */
    public static final Path ItemIcons = Resources.resolve("item");

    /** The mastery icons. */
    public static final Path MasteryIcon = Resources.resolve("mastery/s3");

    /** The skill icons. */
    public static final Path SkillIcon = Resources.resolve("skill");
}
