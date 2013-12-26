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

import kiss.Extensible;

/**
 * @version 2013/12/26 9:15:03
 */
public abstract class ListenerDetail<A extends Annotation> implements Extensible {

    /** The event type. */
    protected abstract Object type(A anntation, Method method);

    /**
     * <p>
     * Set the execution debounce time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    protected long debounce(A annotation) {
        return 0;
    }

    /**
     * <p>
     * Set the execution throttle time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    protected long throttle(A annotation) {
        return 0;
    }

    /**
     * <p>
     * Set the execution delay time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    protected long delay(A annotation) {
        return 0;
    }

    /**
     * <p>
     * Set a number of execution.
     * </p>
     * 
     * @return
     */
    protected int count(A annotation) {
        return 0;
    }

    /**
     * <p>
     * Stop event propagation and default behavior.
     * </p>
     * 
     * @return The <code>true</code> will stop the current processing event.
     */
    protected boolean abort(A annotation) {
        return false;
    }
}
