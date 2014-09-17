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


/**
 * @version 2014/08/21 13:31:25
 */
public abstract class Widget<V> {

    protected V model;

    /** The current associated virtual element. */
    private VirtualNode current;

    /**
     * <p>
     * Create virtual element.
     * </p>
     * 
     * @param $〡 Domain Specific Language for virtual element.
     */
    protected abstract void virtualize(StructureDSL $〡);
}
