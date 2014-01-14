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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import kiss.Extensible;
import kiss.Observable;
import booton.Necessary;

/**
 * @version 2014/01/13 11:04:40
 */
@Necessary
public interface Subscribable<A extends Annotation> extends Extensible {

    /**
     * <p>
     * Detect event type.
     * </p>
     * 
     * @param method A subscriber method.
     * @param annotation A subscribe marker.
     * @return An event type.
     */
    Object detect(Method method, A annotation);

    /**
     * <p>
     * Build {@link Observable} using the specified information.
     * </p>
     * 
     * @param base A base {@link Observable}.
     * @param annotation A subscriber info.
     * @return
     */
    Observable create(Observable<?> base, A annotation);
}
