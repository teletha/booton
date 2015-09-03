/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.html;

import js.lang.NativeArray;
import jsx.collection.DualList;
import jsx.style.Style;

/**
 * @version 2014/12/02 13:51:27
 */
public class DSL {

    private VElement current;

    protected final void text(String text) {

    }

    protected final void div(Declarable... declarables) {
        e("div", declarables);
    }

    protected final void e(String name, Declarable... declarables) {
        current = new VElement(name);

        for (Declarable declarable : declarables) {
            declarable.declare();
        }
    }

    protected final Declarable title(String title) {
        return new Attribute("title", title);
    }

    /**
     * @version 2015/09/04 0:02:09
     */
    private static class VElement {

        private final String name;

        /** The attributes. */
        private final DualList<String, String> attributes = new DualList();

        /** The class attributes. */
        private final NativeArray<Style> styles = new NativeArray();

        /** The The inline styles. */
        private final DualList<String, String> inlineStyles = new DualList();

        /** The items nodes. */
        private final NativeArray<VElement> items = new NativeArray();

        /**
         * @param name
         */
        private VElement(String name) {
            this.name = name;
        }
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
