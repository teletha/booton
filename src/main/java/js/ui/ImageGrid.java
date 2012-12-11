/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import java.util.Collection;

/**
 * @version 2012/12/11 13:50:08
 */
public abstract class ImageGrid<T> implements UI {

    private Collection<T> sources;

    /**
     * <p>
     * Set image sources.
     * </p>
     * 
     * @return
     */
    protected abstract Collection<T> sources();

    /**
     * <p>
     * Find name of the specified source.
     * </p>
     * 
     * @param source A images source.
     * @return
     */
    protected abstract String name(T source);

    /**
     * <p>
     * Find uri of the specified image source.
     * </p>
     * 
     * @param source A images source.
     * @return
     */
    protected abstract String uri(T source);
}
