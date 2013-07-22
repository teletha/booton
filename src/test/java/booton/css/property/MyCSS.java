/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css.property;

import static booton.css.Vendor.*;
import kiss.I;
import booton.Booton;
import booton.css.CSS;
import booton.css.Vendor;

/**
 * 13/07/16 16:10:32
 */
public class MyCSS extends CSS {

    static {
        I.load(Booton.class, false);
    }

    /**
     * <p>
     * Test property name.
     * </p>
     * 
     * @param name
     * @return
     */
    boolean has(String name) {
        return toString().contains(name + ":");
    }

    /**
     * <p>
     * Test property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    boolean has(String name, String value) {
        return toString().contains(name + ": " + value + ";");
    }

    /**
     * <p>
     * Test property name with vendor prefix.
     * </p>
     * 
     * @param vendor
     * @return
     */
    boolean has(Vendor vendor) {
        return toString().contains(vendor.prefix);
    }

    /**
     * <p>
     * Test property with vendor prefix.
     * </p>
     * 
     * @param vendor
     * @return
     */
    boolean no(Vendor... vendors) {
        String code = toString();

        for (Vendor vendor : vendors) {
            if (code.contains(vendor.prefix)) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * Test property with vendor prefix.
     * </p>
     * 
     * @param vendor
     * @return
     */
    boolean noVendor() {
        return no(IE, Mozilla, Webkit);
    }
}
