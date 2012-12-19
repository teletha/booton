/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import kiss.Interceptor;

/**
 * @version 2012/12/19 21:00:40
 */
class SelectorInterceptor extends Interceptor<Selector> {

    /** The current processing css. */
    static CSS current;

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object invoke(Object... params) {
        System.out.println("inbokec");
        Object result = super.invoke(params);

        return result;
    }
}
