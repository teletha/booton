/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.function.Consumer;

import javafx.collections.ObservableList;

/**
 * @version 2014/08/22 7:53:03
 */
public class Vox {

    /** The type of this {@link Vox}. */
    private final Type type;

    /**
     * <p>
     * Hide constructor.
     * </p>
     * 
     * @param vertical
     */
    private Vox(Type type) {
        this.type = type;
    }

    public Vox vbox(UI... pieces) {
        return null;
    }

    public Vox hbox(UI... pieces) {
        return null;
    }

    public <T> Vox hbox(ObservableList<T> list, Consumer<T> builder) {
        return null;
    }

    /**
     * <p>
     * Create empty horizontal box.
     * </p>
     * 
     * @return
     */
    public static final Vox hbox() {
        return new Vox(Type.Horizontal);
    }

    /**
     * <p>
     * Create empty vertical box.
     * </p>
     * 
     * @return
     */
    public static final Vox vbox() {
        return new Vox(Type.Vertical);
    }

    /**
     * @version 2014/08/22 7:54:33
     */
    private static enum Type {

        /** Horizontal box. */
        Horizontal,

        /** Vertical box. */
        Vertical;
    }
}
