/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import static jsx.ui.piece.PieceStyle.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure.ContainerDescriptor;

/**
 * @version 2014/11/22 14:48:23
 */
public class SpriteImage extends LowLevelWidget<SpriteImage> {

    /** The image uri. */
    private final String uri;

    /** The item size. */
    private final int size;

    /** The current item position. */
    private final IntegerProperty index = new SimpleIntegerProperty();

    /**
     * 
     */
    SpriteImage(String uri, int size) {
        this.uri = "background-image:url(" + uri + ");";
        this.size = size - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String virtualizeName() {
        return "span";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeStructure(ContainerDescriptor $〡) {
        $〡.〡ª("style", uri + "background-position:" + index.get() / size * 100 + "% 0%").〡(SpriteBackground);
    }
}
