/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

/**
 * @version 2013/01/24 9:21:47
 */
public interface Improvable {

    /**
     * <p>
     * Calcurate status value.
     * </p>
     * 
     * @param status A target status.
     * @param patch A version.
     * @return A calcurated value of the specified status.
     */
    double get(Status status, Patch patch);
}
