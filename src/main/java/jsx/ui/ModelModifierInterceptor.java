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

import kiss.Interceptor;

/**
 * @version 2014/09/22 12:21:07
 */
class ModelModifierInterceptor extends Interceptor<ModelModifier> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object invoke(Object... params) {
        Object result = super.invoke(params);

        // notify model modification
        if (that instanceof Widget) {
            System.out.println("model change from " + name);
        }

        return result;
    }
}
