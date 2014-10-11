/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import kiss.I;
import kiss.model.ClassUtil;

/**
 * @version 2014/10/10 22:37:09
 */
public interface Appearance<S extends AppearanceDescriptor> {

    default S visualize() {
        return (S) I.find(AppearanceDescriptor.class, ClassUtil.getParameter(getClass(), Appearance.class)[0]);
    }
}
