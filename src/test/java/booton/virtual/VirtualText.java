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

import static js.lang.Global.*;

import java.util.Collections;
import java.util.List;

import js.dom.Node;
import js.dom.Text;

/**
 * @version 2014/09/04 23:22:51
 */
public class VirtualText extends VirtualNode {

    /** The text content. */
    public final String text;

    /**
     * <p>
     * Create text contents.
     * </p>
     * 
     * @param text
     */
    public VirtualText(String text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node createNode() {
        return document.createTextNode(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PatchOperation> diff(VirtualNode node) {
        if (node instanceof VirtualText) {
            VirtualText virtual = (VirtualText) node;

            if (text.equals(virtual.text)) {
                return Collections.EMPTY_LIST;
            } else {
                return Collections.singletonList(new Modify(virtual.text));
            }
        }
        return null;
    }

    /**
     * @version 2014/09/05 2:18:41
     */
    private static class Modify extends PatchOperation<Text> {

        /** The text to replace. */
        private final String text;

        /**
         * @param text
         */
        private Modify(String text) {
            this.text = text;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void operate(Text target) {
            target.textContent(text);
        }
    }
}
