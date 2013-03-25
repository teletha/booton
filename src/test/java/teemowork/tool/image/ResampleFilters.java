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
 * @version 2013/03/25 14:04:38
 */
public class ResampleFilters {

    private static BiCubicFilter biCubicFilter = new BiCubicFilter();

    private static Lanczos3Filter lanczos3Filter = new Lanczos3Filter();

    public static ResampleFilter getBiCubicFilter() {
        return biCubicFilter;
    }

    public static ResampleFilter getLanczos3Filter() {
        return lanczos3Filter;
    }

}
