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
import teemowork.tool.image.EditableImage;

/**
 * @version 2013/03/25 9:45:25
 */
public class ChampionIconBuilder {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        EditableImage container = new EditableImage();

        for (Path icon : I.walk(ResourceLocator.ChampionIcons)) {
            EditableImage image = new EditableImage(icon);
            image.trim(7).resize(70);

            container.concat(image);
        }
        container.write(ResourceLocator.Resources.resolve("champions.jpg"));
    }
}
