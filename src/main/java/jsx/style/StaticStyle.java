/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import java.util.HashMap;
import java.util.Map;

import js.dom.Element;
import js.lang.NativeArray;
import jsx.collection.DualList;
import booton.Necessary;

/**
 * @version 2015/01/28 2:25:04
 */
@Necessary
public class StaticStyle implements Style {

    /** The static style pool. */
    static final Map<String, StaticStyle> pool = new HashMap();

    /** The class name of this style. */
    private final String name;

    /**
     * <p>
     * A named static style.
     * </p>
     * 
     * @param className
     */
    private StaticStyle(String className) {
        this.name = className;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void declare() {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String id() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(Element dom) {
        dom.classList().add(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unapplyFrom(Element dom) {
        dom.classList().remove(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        styles.push(this);
    }

    /**
     * <p>
     * Find the {@link StaticStyle} of the specified class name in cache.
     * </p>
     * 
     * @param className A class name you want.
     * @return A cached {@link StaticStyle}.
     */
    @SuppressWarnings("unused")
    private static StaticStyle of(String className) {
        return pool.computeIfAbsent(className, name -> {
            return new StaticStyle(name);
        });
    }
}
