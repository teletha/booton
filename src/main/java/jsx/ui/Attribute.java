/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.Optional;

import jsx.style.Style;

/**
 * @version 2014/12/26 15:10:29
 */
public class Attribute {

    /** The attribute name. */
    private final String name;

    /** The attribute value. */
    private final Optional<String> value;

    /** The additional info. */
    private Style[] styles;

    /**
     * @param name
     * @param value
     */
    private Attribute(String name, Optional<String> value) {
        this.name = name;
        this.value = value;
    }

    /**
     * <p>
     * Create title attribute.
     * </p>
     * 
     * @param title A title value.
     * @return A created attribute.
     */
    public static Attribute title(String title) {
        return title(Optional.ofNullable(title));
    }

    /**
     * <p>
     * Create title attribute.
     * </p>
     * 
     * @param title A title value.
     * @return A created attribute.
     */
    public static Attribute title(Optional<String> title) {
        return new Attribute("title", title);
    }

    /**
     * <p>
     * If this attibute is valid, apply the specified class name to a target element.
     * </p>
     * 
     * @param style
     * @return
     */
    public Attribute with(Style style) {
        if (style != null) {
            this.styles = new Style[] {style};
        }
        return this;
    }

    /**
     * <p>
     * If this attibute is valid, apply the specified class name to a target element.
     * </p>
     * 
     * @param style
     * @return
     */
    public Attribute with(Style... styles) {
        if (styles != null) {
            this.styles = styles;
        }
        return this;
    }
}
