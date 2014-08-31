/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import js.dom.Node;

/**
 * @version 2014/08/31 10:09:03
 */
public abstract class PatchOperation<T> {

    protected abstract void operate(T target);

    /**
     * @version 2014/08/31 14:18:16
     */
    public static class Replace extends PatchOperation<Node> {

        /**
         * {@inheritDoc}
         */
        @Override
        public void operate(Node node) {
        }
    }
}
