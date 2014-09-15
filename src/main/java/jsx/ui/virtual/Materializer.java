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

import js.dom.Node;

/**
 * @version 2014/09/15 21:22:53
 */
public interface Materializer<D extends Node> {

    /**
     * <p>
     * Create actual DOM {@link Node}.
     * </p>
     * 
     * @return A created node.
     */
    D materialize();
}
