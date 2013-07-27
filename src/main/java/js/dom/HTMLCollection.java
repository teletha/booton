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

import java.util.Iterator;

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativePropertyAccessor;

/**
 * @version 2013/07/27 15:57:10
 */
@JavascriptAPIProvider
public abstract class HTMLCollection implements Iterable<Element>, JavascriptNative {

    /**
     * <p>
     * The number of elements in the collection.
     * </p>
     * 
     * @return The length property.
     */
    @JavascriptNativePropertyAccessor
    public abstract int length();

    /**
     * <p>
     * Returns the element with index index from the collection. The elements are sorted in tree
     * order.
     * </p>
     * 
     * @param index A element index.
     * @return A indexth element.
     */
    public native Element item(int index);

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<Element> iterator() {
        return new Iterator<Element>() {

            /** The cursor. */
            private int cursor = 0;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return cursor < length();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public Element next() {
                return item(cursor++);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
