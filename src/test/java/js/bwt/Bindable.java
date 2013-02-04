/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

/**
 * @version 2013/02/03 15:02:24
 */
public interface Bindable<T> {

    /**
     * <p>
     * This method is invoked whenever the bound value is updated.
     * </p>
     * 
     * @param value A new value.
     */
    void update(T value);
}
