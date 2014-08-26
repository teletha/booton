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
import kiss.Reactive;
import kiss.model.ClassUtil;

/**
 * @version 2014/03/08 11:24:56
 */
class SubscribeDetail implements Subscribable<Subscribe> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object detect(Method method, Subscribe annotation) {
        return ClassUtil.wrap(method.getParameterTypes().length == 1 ? method.getParameterTypes()[0]
                : annotation.value());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Reactive create(Reactive<?> base, Subscribe annotation) {
        base = base.take(annotation.count())
                .delay(annotation.delay(), MILLISECONDS)
                .throttle(annotation.throttle(), MILLISECONDS)
                .debounce(annotation.debounce(), MILLISECONDS);

        if (annotation.abort()) {
            base = base.on((observer, value) -> {
                if (value instanceof Disposable) {
                    ((Disposable) value).dispose();
                }
                observer.onNext(value);
            });
        }

        return base;
    }
}
