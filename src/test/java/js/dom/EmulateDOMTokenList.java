/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.concurrent.CopyOnWriteArrayList;

import js.dom.DOMTokenList;
import kiss.I;
import booton.Obfuscator;
import booton.css.CSS;

/**
 * @version 2013/07/11 16:14:29
 */
public class EmulateDOMTokenList extends DOMTokenList {

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
    public void add(Class<? extends CSS> className) {
        if (className == null) {
            add((String) null);
        } else {
            add(Obfuscator.computeCSSName(className));
        }
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
    public void remove(Class<? extends CSS> className) {
        if (className == null) {
            remove((String) null);
        } else {
            remove(Obfuscator.computeCSSName(className));
        }
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
    public boolean toggle(Class<? extends CSS> className) {
        if (className == null) {
            return toggle((String) null);
        } else {
            return toggle(Obfuscator.computeCSSName(className));
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
    public boolean contains(Class<? extends CSS> className) {
        if (className == null) {
            return contains((String) null);
        } else {
            return contains(Obfuscator.computeCSSName(className));
        }
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
            throw new DOMError();
        }

        for (int i = 0; i < className.length(); i++) {
            char c = className.charAt(i);

            if (Character.isWhitespace(c)) {
                throw new DOMError();
            }
        }
        return className;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return I.join(classes, " ");
    }
}
