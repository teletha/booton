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
import java.util.ArrayList;
import java.util.List;

import kiss.I;
import teemowork.model.Mastery;
import teemowork.tool.image.EditableImage;

/**
 * @version 2013/03/27 11:57:26
 */
public class MasteryIconBuilder {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        List<Mastery> masteries = new ArrayList();

        for (Field field : Mastery.class.getFields()) {
            if (field.getType() == Mastery.class) {
                masteries.add((Mastery) field.get(null));
            }
        }

        EditableImage container = new EditableImage();

        for (Mastery mastery : masteries) {
            EditableImage image = new EditableImage(I.locate(mastery.getIcon()));
            image.resize(45);

            container.concat(image);
        }
        container.write(ResourceLocator.Resources.resolve("masteryS3.jpg"));
    }
}
