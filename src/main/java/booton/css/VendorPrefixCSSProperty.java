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
 * @version 2013/06/09 3:29:17
 */
public class VendorPrefixCSSProperty {

    /** The each value. */
    private String[] standard;

    /** The each value. */
    private String[] ie;

    /** The each value. */
    private String[] moz;

    /** The each value. */
    private String[] webkit;

    /** The prefix flag. */
    private boolean namePrefix;

    /** The prefix flag. */
    private boolean valuePrefix;

    /**
     * <p>
     * Set standard property name and value.
     * </p>
     * 
     * @param name
     * @param value
     */
    VendorPrefixCSSProperty(String name, String value, boolean namePrefix, boolean valuePrefix) {
        this.standard = new String[] {name, value};
        this.namePrefix = namePrefix;
        this.valuePrefix = valuePrefix;

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
        return ie(standard[0], value);
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
        this.ie = compute(Vendor.IE, name, value);

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
        return moz(standard[0], value);
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
        this.moz = compute(Vendor.Mozilla, name, value);

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
        return webkit(standard[0], value);
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
        this.webkit = compute(Vendor.Webkit, name, value);

        return this;
    }

    /**
     * <p>
     * Helper method to construct property name and value pair.
     * </p>
     * 
     * @param vendor
     * @param name
     * @param value
     * @return
     */
    private String[] compute(Vendor vendor, String name, String value) {
        String[] values = new String[2];
        values[0] = namePrefix ? vendor.prefix + name : name;
        values[1] = valuePrefix ? vendor.prefix + value : value;

        return values;
    }

    /**
     * <p>
     * Provide all names and values
     * </p>
     * 
     * @return
     */
    String[][] values() {
        String[][] values = new String[Vendor.values().length][];
        values[0] = ie;
        values[1] = moz;
        values[2] = webkit;
        values[3] = standard;

        return values;
    }
}
