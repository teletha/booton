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
import teemowork.tool.image.ImageConverter;

/**
 * @version 2013/03/25 9:45:25
 */
public class ChampionIconBuilder {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        ImageConverter container = new ImageConverter();

        for (Path icon : I.walk(ResourceLocator.ChampionIcons)) {
            ImageConverter image = new ImageConverter(icon);
            image.trim(7).resize(70);

            container.concat(image);
        }
        container.write(ResourceLocator.Resources.resolve("champions.jpg"));
    }
}
