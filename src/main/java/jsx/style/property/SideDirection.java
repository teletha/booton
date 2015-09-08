/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

/**
 * @version 2015/09/08 13:18:31
 */
enum SideDirection {
    Top, Right, Bottom, Left;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name().toLowerCase();
    };
}
