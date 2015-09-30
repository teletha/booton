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

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import js.lang.NativeArray;
import jsx.ui.Style;

/**
 * @version 2015/09/30 14:06:23
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "SVGElement")
public abstract class SVGElement extends Element implements JavascriptNative {

    /** The namespace uri for XLINK. */
    private static final String XLINK = "http://www.w3.org/1999/xlink";

    /** The class manager. */
    private NativeArray<String> classes;

    /**
     * <p>
     * Get the value of the specified attribute.
     * </p>
     * 
     * @param name The name of the attribute to get.
     * @return The specified attribute value.
     */
    @Override
    public String attr(String name) {
        if (name.startsWith("xlink:")) {
            return getAttributeNS(XLINK, name.substring(6));
        } else {
            return getAttribute(name);
        }
    }

    /**
     * <p>
     * Set attribute for this element.
     * </p>
     * 
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    @Override
    public SVGElement attr(String name, Object value) {
        if (name.startsWith("xlink:")) {
            attr(XLINK, name.substring(6), value);
        } else {
            setAttribute(name, String.valueOf(value));
        }
        return this;
    }

    /**
     * <p>
     * Set attribute with namespace for this element.
     * </p>
     * 
     * @param namespace The namespace uri of the attribute.
     * @param name An attribute name.
     * @param value An attribute value.
     * @return A chainable API.
     */
    @Override
    public SVGElement attr(String namespace, String name, Object value) {
        setAttributeNS(namespace, name, String.valueOf(value));

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element add(Style style) {
        NativeArray<String> classes = classes();
        String name = style.className();
        int index = classes.indexOf(name);

        if (index == -1) {
            classes.push(name);
            attr("class", classes.join(" "));

            CSSStyleSheet.define(style);
        }

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean has(Style style) {
        return classes().indexOf(style.className()) != -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element remove(Style style) {
        NativeArray<String> classes = classes();
        String name = style.className();
        int index = classes.indexOf(name);

        if (index != -1) {
            classes.remove(index);
            attr("class", classes.join(" "));
        }

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element toggle(Style style) {
        NativeArray<String> classes = classes();
        String name = style.className();
        int index = classes.indexOf(name);

        if (index == -1) {
            classes.push(name);
            CSSStyleSheet.define(style);
        } else {
            classes.remove(index);
        }
        attr("class", classes.join(" "));

        // API definition
        return this;
    }

    /**
     * <p>
     * Helper method to create
     * </p>
     * 
     * @return
     */
    private NativeArray<String> classes() {
        if (classes == null) {
            classes = new NativeArray();
        }
        return classes;
    }
}
