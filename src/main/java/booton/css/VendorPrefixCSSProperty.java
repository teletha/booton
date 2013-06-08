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
 * @version 2013/06/08 9:14:53
 */
public class VendorPrefixCSSProperty {

    /** The each value. */
    private String[] ie;

    /** The each value. */
    private String[] moz;

    /** The each value. */
    private String[] webkit;

    /** The each value. */
    private String[] standard;

    /**
     * <p>
     * Set standard property name and value.
     * </p>
     * 
     * @param name
     * @param value
     */
    VendorPrefixCSSProperty(String name, String value) {
        this.standard = new String[] {name, value};

        ie(value);
        moz(value);
        webkit(value);
    }

    /**
     * <p>
     * Set property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public VendorPrefixCSSProperty ie(String value) {
        this.ie = new String[] {VendorPrefix.IE.prefix + standard[0], value};

        return this;
    }

    /**
     * <p>
     * Set property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public VendorPrefixCSSProperty ie(String name, String value) {
        this.ie = new String[] {name, value};

        return this;
    }

    /**
     * <p>
     * Set property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public VendorPrefixCSSProperty moz(String value) {
        this.moz = new String[] {VendorPrefix.Mozilla.prefix + standard[0], value};

        return this;
    }

    /**
     * <p>
     * Set property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public VendorPrefixCSSProperty moz(String name, String value) {
        this.moz = new String[] {name, value};

        return this;
    }

    /**
     * <p>
     * Set property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public VendorPrefixCSSProperty webkit(String value) {
        this.webkit = new String[] {VendorPrefix.Webkit.prefix + standard[0], value};

        return this;
    }

    /**
     * <p>
     * Set property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public VendorPrefixCSSProperty webkit(String name, String value) {
        this.webkit = new String[] {name, value};

        return this;
    }

    /**
     * <p>
     * Set property name and value.
     * </p>
     * 
     * @param name
     * @param value
     * @return
     */
    public VendorPrefixCSSProperty standard(String name, String value) {
        this.ie = new String[] {name, value};

        return this;
    }

    /**
     * <p>
     * Provide all names and values
     * </p>
     * 
     * @return
     */
    String[][] values() {
        String[][] values = new String[VendorPrefix.values().length][];
        values[0] = ie;
        values[1] = moz;
        values[2] = webkit;
        values[3] = standard;

        return values;
    }
}
