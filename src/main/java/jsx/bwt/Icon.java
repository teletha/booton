/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

/**
 * @version 2013/04/19 13:27:20
 */
public enum Icon {

    /** The icon. */
    BottomArrow("\ue75c");

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
        this.code = unicode;
    }
}
