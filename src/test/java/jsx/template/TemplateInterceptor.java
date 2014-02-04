/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.template;

import kiss.I;
import kiss.Interceptor;

/**
 * @version 2014/02/04 13:59:28
 */
public class TemplateInterceptor extends Interceptor<Template> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object invoke(Object... params) {
        Object[] mocks = new Object[params.length];

        for (int i = 0; i < mocks.length; i++) {
            System.out.println("crete mock " + params[i]);
            mocks[i] = I.mock(params[i]);
        }

        return super.invoke(mocks);
    }
}
