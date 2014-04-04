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

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import kiss.I;
import teemowork.model.Item;
import teemowork.model.MasterySeason4;
import teemowork.tool.image.EditableImage;

/**
 * @version 2013/06/09 11:58:12
 */
public class ClientImageBuilder {

    /** The client root. */
    public Path root;

    /** The latest version directory. */
    public Path version;

    /** The image directory. */
    public Path images;

    /**
     * 
     */
    public ClientImageBuilder() {
        String path = System.getenv("LOL_HOME");

        if (path == null) {
            System.out.println("Environment variable 'LOL_HOME' is not found.");
            return;
        }
        root = I.locate(path);

        Path latest = null;

        for (Path dir : I.walkDirectory(root.resolve("RADS/projects/lol_air_client/releases"), "*")) {
            latest = dir;
        }
        version = latest;
        images = latest.resolve("deploy/assets/images");
    }

    /**
     * <p>
     * Helper method to find icons.
     * </p>
     * 
     * @param root
     */
    public void copyChampionIcon() {
        if (images != null) {
            for (Path file : I.walk(images.resolve("champions"), "*_Square_0.png")) {
                String name = file.getFileName().toString();
                name = name.substring(0, name.indexOf('_'));

                if (name.equals("MonkeyKing")) {
                    name = "Wukong";
                }
                I.copy(file, ResourceLocator.ChampionIcon.resolve(name + ".png"));
            }
        }
    }

    /**
     * <p>
     * Create champion icon set.
     * </p>
     */
    public void buildChampionIconSet() {
        copyChampionIcon();

        EditableImage container = new EditableImage();

        for (Path icon : I.walk(ResourceLocator.ChampionIcon)) {
            EditableImage image = new EditableImage(icon);
            image.trim(7).resize(70);

            container.concat(image);
        }
        container.write(ResourceLocator.Resources.resolve("champions.jpg"));
    }

    /**
     * <p>
     * Helper method to find splash art.
     * </p>
     * 
     * @param root
     */
    public void copyChampionSplashArt() {
        if (images != null) {
            for (Path file : I.walk(images.resolve("champions"), "*_Splash_0.jpg")) {
                String name = file.getFileName().toString();
                name = name.substring(0, name.indexOf('_'));

                if (name.equals("MonkeyKing")) {
                    name = "Wukong";
                }
                I.copy(file, ResourceLocator.ChampionSplash.resolve(name + ".jpg"));
            }
        }
    }

    /**
     * <p>
     * Create mastery icon set.
     * </p>
     */
    public void buildMasteryIconSet() {
        List<MasterySeason4> masteries = new ArrayList();

        for (Field field : MasterySeason4.class.getFields()) {
            if (field.getType() == MasterySeason4.class) {
                try {
                    masteries.add((MasterySeason4) field.get(null));
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }

        EditableImage container = new EditableImage();

        for (MasterySeason4 mastery : masteries) {
            EditableImage image = new EditableImage(I.locate(mastery.getIcon()));
            image.resize(45);

            container.concat(image);
        }
        container.write(ResourceLocator.Resources.resolve("masteryS4.jpg"));
    }

    /**
     * <p>
     * Create item icon set.
     * </p>
     */
    public void buildItemIconSet() {
        List<Item> items = new ArrayList();

        for (Field field : Item.class.getFields()) {
            if (field.getType() == Item.class) {
                try {
                    items.add((Item) field.get(null));
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }

        EditableImage container = new EditableImage();

        for (Item item : items) {
            EditableImage image = new EditableImage(ResourceLocator.ItemIcons.resolve(item.id + ".png"));
            image.trim(2).resize(45);

            container.concat(image);
        }
        container.write(ResourceLocator.Resources.resolve("items.jpg"));
    }

    /**
     * <p>
     * Entry point.
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        ClientImageBuilder builder = new ClientImageBuilder();
        builder.buildChampionIconSet();
        builder.buildMasteryIconSet();
        builder.buildItemIconSet();
    }
}
