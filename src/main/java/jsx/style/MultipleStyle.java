/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import js.dom.Element;
import js.lang.NativeArray;
import jsx.collection.DualList;

/**
 * @version 2014/12/17 13:06:39
 */
class MultipleStyle implements Style {

    /** The style contianer. */
    private final NativeArray<Style> styles = new NativeArray();

    /**
     * @param base
     * @param dynamic
     */
    public MultipleStyle(Style base, Style dynamic) {
        this.styles.push(base);
        this.styles.push(dynamic);
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
    public void applyTo(Element dom) {
        for (int i = 0, size = this.styles.length(); i < size; i++) {
            this.styles.get(i).applyTo(dom);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unapplyFrom(Element dom) {
        for (int i = 0, size = this.styles.length(); i < size; i++) {
            this.styles.get(i).unapplyFrom(dom);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void assignTo(NativeArray<Style> styles, DualList<String, String> inlines) {
        for (int i = 0, size = this.styles.length(); i < size; i++) {
            this.styles.get(i).assignTo(styles, inlines);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Style with(Style other) {
        if (other != null) {
            this.styles.push(other);
        }
        return this;
    }
}
