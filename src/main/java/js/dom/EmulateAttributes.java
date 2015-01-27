/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2014/08/31 13:34:53
 */
class EmulateAttributes extends Attributes {

    /** The manager. */
    final List<Attribute> entries = new ArrayList();

    /** The class attribute. */
    final EmulateDOMTokenList classes = new EmulateDOMTokenList();

    /**
     * {@inheritDoc}
     */
    @Override
    protected int length() {
        return entries.size() + classes.length() == 0 ? 0 : 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Attribute get(int index) {
        if (classes.length() == 0 || entries.size() != index) {
            return entries.get(index);
        } else {
            return new EmulateAttribute("class", classes.toString());
        }
    }

    /**
     * <p>
     * Add attribute.
     * </p>
     * 
     * @param namespace
     * @param name
     * @param value
     */
    void add(String namespace, String name, String value) {
        namespace = String.valueOf(namespace).toLowerCase();
        name = String.valueOf(name).toLowerCase();
        value = String.valueOf(value);

        if (isClass(namespace, name)) {
            classes.clear();

            for (String className : value.trim().split(" ")) {
                classes.add(className);
            }
        }

        Attribute entry = find(namespace, name);

        if (entry == null) {
            entry = new EmulateAttribute(name, value);
            entries.add(entry);
        } else {
            entry.value(value);
        }
    }

    /**
     * <p>
     * Remove attribute.
     * </p>
     * 
     * @param namespace
     * @param name
     */
    void remove(String namespace, String name) {
        namespace = String.valueOf(namespace).toLowerCase();
        name = String.valueOf(name).toLowerCase();

        if (isClass(namespace, name)) {
            classes.clear();
        }

        Attribute entry = find(namespace, name);

        if (entry != null) {
            entries.remove(entry);
        }
    }

    /**
     * <p>
     * Test attribute.
     * </p>
     * 
     * @param namespace
     * @param name
     * @return
     */
    boolean has(String namespace, String name) {
        namespace = String.valueOf(namespace).toLowerCase();
        name = String.valueOf(name).toLowerCase();

        if (isClass(namespace, name)) {
            return classes.length() != 0;
        } else {
            return find(namespace, name) != null;
        }
    }

    /**
     * <p>
     * Get attribute.
     * </p>
     * 
     * @param namespace
     * @param name
     * @return
     */
    String get(String namespace, String name) {
        if (isClass(namespace, name)) {
            return classes.toString();
        }

        namespace = String.valueOf(namespace).toLowerCase();
        name = String.valueOf(name).toLowerCase();
        Attribute entry = find(namespace, name);

        if (entry == null) {
            return null;
        } else {
            return entry.value();
        }
    }

    /**
     * <p>
     * Chech this pattern represents class attribute.
     * </p>
     * 
     * @param uri
     * @param name
     * @return
     */
    private boolean isClass(String uri, String name) {
        if (name == null) {
            return false;
        }
        return name.equalsIgnoreCase("class");
    }

    /**
     * <p>
     * Helper method to find entry.
     * </p>
     * 
     * @param name
     * @return
     */
    private Attribute find(String namespace, String name) {
        for (Attribute attribute : entries) {
            if (name.equalsIgnoreCase(attribute.name()) && namespace.equalsIgnoreCase(attribute.namespaceURI())) {
                return attribute;
            }
        }
        return null;
    }
}