/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import booton.translator.web.jQuery;

/**
 * @version 2012/12/14 10:43:21
 */
public abstract class View {

    /**
     * <p>
     * Create html view.
     * </p>
     */
    protected abstract void buildView(jQuery root);
}
