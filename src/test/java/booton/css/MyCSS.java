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

import static booton.css.Vendor.*;
import kiss.I;
import booton.Booton;

/**
 * @version 2013/07/24 0:37:47
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
    public boolean has(String name) {
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
    public boolean has(String name, String value) {
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
    public boolean has(Vendor vendor) {
        return toString().contains(vendor.toString());
    }

    /**
     * <p>
     * Test property with vendor prefix.
     * </p>
     * 
     * @param vendor
     * @return
     */
    public boolean no(Vendor... vendors) {
        String code = toString();

        for (Vendor vendor : vendors) {
            if (code.contains(vendor.toString())) {
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
    public boolean noVendor() {
        return no(IE, Mozilla, Webkit);
    }

    /**
     * <p>
     * Count a number of selectors.
     * </p>
     * 
     * @return A number of selectors.
     */
    public int countSelector() {
        int counter = 1;
        String code = toString();
        code = code.substring(0, code.indexOf('{'));
        int index = code.indexOf(',');

        while (index != -1) {
            counter++;

            index = code.indexOf(',', index + 1);
        }
        return counter;
    }

    /**
     * <p>
     * Count a number of properties.
     * </p>
     * 
     * @return A number of properties.
     */
    public int countProperty() {
        int counter = 0;
        String code = toString();
        int index = code.indexOf(';');

        while (index != -1) {
            counter++;

            index = code.indexOf(';', index + 1);
        }
        return counter;
    }
}
