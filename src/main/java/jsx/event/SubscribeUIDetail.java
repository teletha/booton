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

import static java.util.concurrent.TimeUnit.*;

import java.lang.reflect.Method;

import jsx.rx.Observable;
import kiss.Disposable;
import booton.Necessary;

/**
 * @version 2013/12/26 9:20:13
 */
@Necessary
class SubscribeUIUIDetail implements Subscribable<SubscribeUI> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object type(SubscribeUI annotation, Method method) {
        return annotation.type();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Observable observe(Observable base, SubscribeUI annotation) {
        base = base.take(annotation.count())
                .delay(annotation.delay(), MILLISECONDS)
                .throttle(annotation.throttle(), MILLISECONDS)
                .debounce(annotation.debounce(), MILLISECONDS);

        if (annotation.abort()) {
            base = base.on(value -> {
                if (value instanceof Disposable) {
                    ((Disposable) value).dispose();
                }
            });
        }

        return base;
    }
}
