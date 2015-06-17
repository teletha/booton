/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.model;

import java.util.EventListener;

/**
 * @version 2013/04/05 9:32:19
 */
public interface SelectableListener<T> extends EventListener {

    /**
     * <p>
     * Notify item selection event.
     * </p>
     * 
     * @param item
     */
    public void select(int index, T item);

    /**
     * <p>
     * Notiify item deselection event.
     * </p>
     * 
     * @param item
     */
    public void deselect(int index, T item);

    /**
     * <p>
     * Notify item selection event.
     * </p>
     * 
     * @param item
     */
    public void add(int index, T item);

    /**
     * <p>
     * Notiify item deselection event.
     * </p>
     * 
     * @param index TODO
     * @param item
     */
    public void remove(int index, T item);
}
