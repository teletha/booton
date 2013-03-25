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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import kiss.I;
import teemowork.tool.image.ImageConverter;
import teemowork.tool.image.ImageType;

/**
 * @version 2013/03/25 9:45:25
 */
public class ChampionIconBuilder {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Path output = I.locate(".act/");

        try {
            Files.createDirectories(output);
        } catch (IOException e) {
            throw I.quiet(e);
        }

        for (Path icon : I.walk(ResourceLocator.ChampionIcons)) {

            ImageConverter image = new ImageConverter(icon);
            image.trim(10).resizeX(70);

            image.write(output, ImageType.JPG);
            break;
        }
    }
}
