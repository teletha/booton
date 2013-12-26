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

/**
 * @version 2013/12/26 9:20:13
 */
class SubscribeUIUIDetail extends ListenerDetail<SubscribeUI> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected Object type(SubscribeUI anntation, Method method) {
        return anntation.type();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected long debounce(SubscribeUI annotation) {
        return annotation.debounce();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected long throttle(SubscribeUI annotation) {
        return annotation.throttle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected long delay(SubscribeUI annotation) {
        return annotation.delay();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int count(SubscribeUI annotation) {
        return annotation.count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean abort(SubscribeUI annotation) {
        return annotation.abort();
    }
}
