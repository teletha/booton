/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

import java.lang.reflect.Method;

import kiss.model.ClassUtil;

/**
 * @version 2013/12/26 9:16:15
 */
class SubscribeDetail extends ListenerDetail<Subscribe> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object type(Subscribe anntation, Method method) {
        return ClassUtil.wrap(method.getParameterTypes().length == 1 ? method.getParameterTypes()[0]
                : anntation.value());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected long debounce(Subscribe annotation) {
        return annotation.debounce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected long throttle(Subscribe annotation) {
        return annotation.throttle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected long delay(Subscribe annotation) {
        return annotation.delay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int count(Subscribe annotation) {
        return annotation.count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean abort(Subscribe annotation) {
        return annotation.abort();
    }
}
