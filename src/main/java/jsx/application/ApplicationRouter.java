/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import java.util.function.Supplier;

import jsx.ui.Widget;

/**
 * @version 2016/11/06 11:21:43
 */
public interface ApplicationRouter {

    /**
     * <p>
     * Retrieve the default widget.
     * </p>
     */
    Supplier<Widget> defaultWidget();

    /**
     * <p>
     * Retrieve the general error widget.
     * </p>
     * 
     * @return
     */
    default Supplier<Widget> errorWidget() {
        return defaultWidget();
    }
}
