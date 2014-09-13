/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.virtual;

import js.lang.NativeArray;

/**
 * <p>
 * Optimized list for child node container.
 * </p>
 * 
 * @version 2014/09/07 21:34:34
 */
public class VirtualNodeList {

    /** The child nodes. */
    public final NativeArray<VirtualNode> items = new NativeArray();

    /**
     * @param children
     */
    public VirtualNodeList() {
    }

    /**
     * <p>
     * Find index for the specified node.
     * </p>
     * 
     * @param node A target node to search.
     * @return A index of the specified node.
     */
    public int indexOf(VirtualNode node) {
        for (int index = 0, length = items.length(); index < length; index++) {
            if (items.get(index).id == node.id) {
                return index;
            }
        }
        return -1;
    }
}
