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

import jsx.style.PropertyDefinition;
import jsx.style.Vendor;

/**
 * @version 2015/10/01 1:21:02
 */
public class Appearance extends PropertyDefinition<Appearance> {

    /**
     * 
     */
    public Appearance() {
        super("appearance", null, Vendor.Mozilla, Vendor.Webkit, Vendor.IE);
    }

    /**
     * No special styling is applied. This is the default.
     */
    public Appearance none() {
        return value("none");
    }
}
