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

import java.util.concurrent.CopyOnWriteArrayList;

import kiss.I;

/**
 * 
 * @version 2015/09/30 13:37:47
 */
class EmulateDOMTokenList extends DOMTokenList {

    /** The class manager. */
    private final CopyOnWriteArrayList<String> classes = new CopyOnWriteArrayList();

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(String className) {
        classes.addIfAbsent(normalize(className));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(String className) {
        classes.remove(normalize(className));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toggle(String className) {
        if (contains(className)) {
            remove(className);
            return false;
        } else {
            add(className);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(String className) {
        return classes.contains(normalize(className));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int length() {
        return classes.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String item(int index) {
        return classes.get(index);
    }

    /**
     * <p>
     * Helper method to clear all classes.
     * </p>
     */
    void clear() {
        classes.clear();
    }

    /**
     * <p>
     * Helper method to normalize class name.
     * </p>
     * 
     * @param className
     * @return
     */
    private String normalize(String className) {
        if (className == null) {
            className = "null";
        }

        if (className.length() == 0) {
            throw new EmulateDOMError();
        }

        for (int i = 0; i < className.length(); i++) {
            char c = className.charAt(i);

            if (Character.isWhitespace(c)) {
                throw new EmulateDOMError();
            }
        }
        return className;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return I.join(" ", classes);
    }
}
