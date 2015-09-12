/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import js.lang.NativeArray;

/**
 * @version 2014/12/02 13:51:27
 */
public class DSL {

    private VirtualElement current;

    public final NativeArray<VirtualElement> items = new NativeArray();

    protected final void text(String text) {
    }

    protected final void div(Declarable... declarables) {
        e("div", declarables);
    }

    protected final void e(String name, Declarable... declarables) {
        e(0, name, declarables);
    }

    protected final void e(int id, String name, Declarable... declarables) {
        // store parent element
        VirtualElement parent = current;

        current = new VirtualElement(id, name);

        if (parent == null) {
            items.push(current);
        }

        for (Declarable declarable : declarables) {
            declarable.declare();
        }

        // restore parent element
        current = parent;
    }

    protected final Declarable title(String title) {
        return new Attribute("title", title);
    }

    /**
     * @version 2015/09/03 19:43:10
     */
    private class Attribute implements Declarable {

        private final String name;

        private final String value;

        /**
         * @param name
         * @param value
         */
        private Attribute(String name, String value) {
            this.name = name;
            this.value = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void declare() {
            current.attributes.add(name, value);
        }
    }
}
