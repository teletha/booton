/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.value;

import static booton.css.Vendor.*;

import java.util.EnumSet;

import booton.css.CSSValue;
import booton.css.Vendor;

/**
 * @version 2013/07/23 19:01:31
 */
public class Gradient extends CSSValue {

    /** The start color. */
    public final Color start;

    /** The end color. */
    public final Color end;

    /**
     * @param start
     * @param end
     */
    public Gradient(Color start, Color end) {
        this.start = start;
        this.end = end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String valueFor(Vendor vendor) {
        switch (vendor) {
        case Webkit:
            return vendor.prefix + "linear-gradient(" + start + "," + end + ")";

        default:
            return "linear-gradient(" + start + "," + end + ")";
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected EnumSet<Vendor> vendors() {
        return EnumSet.of(Standard, Webkit);
    }
}
