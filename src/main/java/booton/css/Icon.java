/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2013/04/01 20:01:08
 */
public enum Icon {

    /** The icon. */
    BottomArrow("e75c");

    /** The unicode. */
    public final String code;

    /**
     * <p>
     * Specify character code for icon.
     * </p>
     * 
     * @param unicode
     */
    private Icon(String unicode) {
        this.code = "\\" + unicode;
    }
}