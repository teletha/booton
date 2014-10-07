/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import static js.lang.Global.*;
import js.dom.Node;
import js.lang.NativeArray;

/**
 * @version 2014/09/18 9:37:03
 */
abstract class VirtualFragment<N extends Node> extends VirtualNode<N> {

    /** The items nodes. */
    final NativeArray<VirtualNode> items = new NativeArray();

    /**
     * @param id
     */
    VirtualFragment(int id) {
        super(id);
    }

    /**
     * <p>
     * Find index for the specified node.
     * </p>
     * 
     * @param node A target node to search.
     * @return A index of the specified node.
     */
    int indexOf(VirtualNode node) {
        for (int index = 0, length = items.length(); index < length; index++) {
            if (items.get(index).id == node.id) {
                return index;
            }
        }
        return -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final N materialize() {
        N root = materializeRoot();

        for (int i = 0, length = items.length(); i < length; i++) {
            root.append(items.get(i).materialize());
        }
        return root;
    }

    /**
     * <p>
     * Materialize root node for this fragment. Subclass should override this method to modify the
     * root node.
     * </p>
     * 
     * @return
     */
    N materializeRoot() {
        return dom = (N) document.createDocumentFragment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        super.dispose();

        for (int i = items.length() - 1; 0 <= i; i--) {
            items.get(i).dispose();
        }
    }
}
