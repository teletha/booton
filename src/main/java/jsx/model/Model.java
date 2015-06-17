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

/**
 * @version 2013/04/09 15:41:04
 */
public interface Model<T> {

    /**
     * <p>
     * Get value of this model.
     * </p>
     * 
     * @return A value.
     */
    T get();

    /**
     * <p>
     * Set value of this model.
     * </p>
     * 
     * @param value A value to set.
     */
    void set(T value);
}
