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
public interface Skinnable<S extends SkinBase> {

    default S skin() {
        return (S) I.make(ClassUtil.getParameter(getClass(), Skinnable.class)[0]);
    }
}
