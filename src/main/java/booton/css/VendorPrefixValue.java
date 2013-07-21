/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2013/07/22 0:06:11
 */
public abstract class VendorPrefixValue {

    /**
     * <p>
     * Write vendor specific value. Returning <code>null</code> or empty string, {@link CSSWriter}
     * will omit the target property.
     * </p>
     * 
     * @param vendor A target vendor.
     */
    protected abstract String toString(Vendor vendor);
}
