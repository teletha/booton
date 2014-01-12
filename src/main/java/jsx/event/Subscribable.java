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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import jsx.rx.Observable;
import kiss.Extensible;
import booton.Necessary;

/**
 * @version 2013/12/27 10:48:28
 */
@Necessary
public interface Subscribable<A extends Annotation> extends Extensible {

    /** The event type. */
    Object type(A annotation, Method method);

    Observable observe(Observable base, A annotation);
}
