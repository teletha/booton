/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.tool.image;

/**
 * @version 2013/03/25 14:00:14
 */
public interface ResampleFilter {

    public float getSamplingRadius();

    float apply(float v);

    public abstract String getName();

}
