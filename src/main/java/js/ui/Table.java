/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import java.util.Collection;

import js.util.jQuery;

/**
 * @version 2013/02/15 15:27:46
 */
public abstract class Table<T> extends UI {

    /**
     * {@inheritDoc}
     */
    @Override
    public void compose(jQuery parent) {
        for (T item : sources()) {

        }
    }

    /**
     * <p>
     * Set image sources.
     * </p>
     * 
     * @return
     */
    protected abstract Collection<T> sources();
}
