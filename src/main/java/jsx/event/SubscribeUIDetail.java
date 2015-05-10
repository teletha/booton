/*
 * Copyright (C) 2014 Nameless Production Committee
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

import kiss.Disposable;
import kiss.Events;

/**
 * @version 2014/03/08 11:24:41
 */
class SubscribeUIDetail implements Subscribable<SubscribeUI> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object detect(Method method, SubscribeUI annotation) {
        return annotation.type();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Events create(Events<?> base, SubscribeUI annotation) {
        base = base.take(annotation.count())
                .delay(annotation.delay(), MILLISECONDS)
                .throttle(annotation.throttle(), MILLISECONDS)
                .debounce(annotation.debounce(), MILLISECONDS);

        if (annotation.abort()) {
            base = base.on((observer, value) -> {
                if (value instanceof Disposable) {
                    ((Disposable) value).dispose();
                }
                observer.accept(value);
            });
        }

        return base;
    }
}
