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

import kiss.Disposable;
import kiss.Observable;
import kiss.model.ClassUtil;
import booton.Necessary;

/**
 * @version 2013/12/26 9:16:15
 */
@Necessary
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
    public Observable create(Observable<?> base, Subscribe annotation) {
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
