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

import java.util.EnumSet;

/**
 * @version 2013/07/23 18:53:33
 */
public abstract class CSSValue {

    /** For reuse. */
    protected static final EnumSet<Vendor> NoVendors = EnumSet.noneOf(Vendor.class);

    /**
     * <p>
     * Detect dependent vendors.
     * </p>
     * 
     * @return
     */
    protected EnumSet<Vendor> vendors() {
        return NoVendors;
    }

    /**
     * <p>
     * Write vendor specific value. Returning <code>null</code> or empty string, {@link CSSWriter}
     * will omit the target property.
     * </p>
     * 
     * @param vendor A target vendor.
     */
    protected abstract String valueFor(Vendor vendor);

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        return valueFor(Vendor.Standard);
    }
}
