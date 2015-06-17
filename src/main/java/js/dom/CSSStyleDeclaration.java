/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.HashMap;
import java.util.Map;

import js.lang.NativeObject;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;

/**
 * <p>
 * A CSSStyleDeclaration is an interface to the declaration block returned by the style property of
 * a cssRule in a stylesheet, when the rule is a CSSStyleRule.
 * </p>
 * 
 * @version 2013/07/29 13:31:25
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "CSSStyleDeclaration")
public abstract class CSSStyleDeclaration implements JavascriptNative {

    /** The property name mapping. */
    private static final Map<String, String> names = new HashMap();

    /** The vendor prefix. */
    private static final String[] prefixes = {"-webkit-", "-ms-", "-moz-"};

    static {
        names.put("float", "cssFloat");
    }

    /**
     * <p>
     * Get the property value.
     * </p>
     * 
     * @param name A property name to retrieve.
     * @return A property value.
     */
    public String get(String name) {
        return getPropertyValue(convert(name));
    }

    /**
     * <p>
     * Set the property value.
     * </p>
     * 
     * @param name A property name to set.
     * @param value A property value to set.
     */
    public void set(String name, String value) {
        setProperty(convert(name), value);
    }

    /**
     * <p>
     * Remove the property value.
     * </p>
     * 
     * @param name A property name to remove.
     */
    public void remove(String name) {
        removeProperty(convert(name));
    }

    /**
     * <p>
     * Helper method to convert property name for css.
     * </p>
     * 
     * @param name
     * @return
     */
    private String convert(String name) {
        String converted = names.get(name);

        if (converted != null) {
            return converted;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

            if (c == '-') {
                i++;
                builder.append(Character.toUpperCase(name.charAt(i)));
            } else {
                builder.append(c);
            }
        }

        String cameled = builder.toString();

        if (NativeObject.hasProperty(this, cameled)) {
            names.put(name, cameled);
            return cameled;
        }

        for (String prefix : prefixes) {
            String prefixed = prefix + cameled;

            if (NativeObject.hasProperty(this, prefixed)) {
                names.put(name, prefixed);
                return prefixed;
            }
        }
        return cameled;
    }

    /**
     * <p>
     * Returns the property value.
     * </p>
     * 
     * @param name A property name to retrieve.
     * @return A property value.
     */
    protected native String getPropertyValue(String name);

    /**
     * <p>
     * Set the property value.
     * </p>
     * 
     * @param name A property name to set.
     * @param value A property value to set.
     */
    protected native void setProperty(String name, String value);

    /**
     * <p>
     * Remove the property value.
     * </p>
     * 
     * @param name A property name to retrieve.
     */
    protected native void removeProperty(String name);
}
