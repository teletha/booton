/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.widget;

/**
 * @version 2013/06/29 15:08:59
 */
public class Text extends Widget {

    /** The text contents. */
    private String text;

    /**
     * Get the text property of this {@link Text}.
     * 
     * @return The text property.
     */
    public String getText() {
        return text;
    }

    /**
     * Set the text property of this {@link Text}.
     * 
     * @param text The text value to set.
     */
    public void setText(String text) {
        this.text = text;
    }
}
