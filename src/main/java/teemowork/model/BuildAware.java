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
 * @version 2013/01/30 14:53:09
 */
public interface BuildAware {

    /**
     * <p>
     * Compute value from build.
     * </p>
     * 
     * @param status
     * @param build
     * @return
     */
    double get(Status status, Build build);
}
