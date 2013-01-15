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

import java.nio.file.Path;

import kiss.I;

/**
 * @version 2012/12/11 3:17:53
 */
public class ImageScanner {

    private static final String ROOT = "f:\\Game\\League of Legends";

    private static final Path output = I.locate("").resolve("src/main/resources/teemowork");

    /**
     * <p>
     * Find and retrieve lol related data.
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        Path latest = null;

        for (Path dir : I.walkDirectory(I.locate(ROOT).resolve("RADS/projects/lol_air_client/releases"), "*")) {
            latest = dir;
        }

        Path images = latest.resolve("deploy/assets/images");
        loadChampionIcon(images.resolve("champions"));
        loadChampionSplashArt(images.resolve("champions"));
    }

    /**
     * <p>
     * Helper method to find icons.
     * </p>
     * 
     * @param root
     */
    private static void loadChampionIcon(Path root) {
        for (Path file : I.walk(root, "*_Square_0.png")) {
            String name = file.getFileName().toString();
            name = name.substring(0, name.indexOf('_'));

            if (name.equals("MonkeyKing")) {
                name = "Wukong";
            }

            I.copy(file, output.resolve("icon/" + name + ".png"));
        }
    }

    /**
     * <p>
     * Helper method to find splash art.
     * </p>
     * 
     * @param root
     */
    private static void loadChampionSplashArt(Path root) {
        for (Path file : I.walk(root, "*_Splash_0.jpg")) {
            String name = file.getFileName().toString();
            name = name.substring(0, name.indexOf('_'));

            if (name.equals("MonkeyKing")) {
                name = "Wukong";
            }

            I.copy(file, output.resolve("splash/" + name + ".jpg"));
        }
    }
}
