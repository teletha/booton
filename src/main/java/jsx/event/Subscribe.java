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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import js.dom.Event;

/**
 * @version 2013/10/05 11:27:24
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Subscribes.class)
public @interface Subscribe {

    /**
     * <p>
     * Specify event type.
     * </p>
     * 
     * @return
     */
    Class value() default Object.class;

    /**
     * <p>
     * Set the execution debounce time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    long debounce() default 0;

    /**
     * <p>
     * Set the execution throttle time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    long throttle() default 0;

    /**
     * <p>
     * Set the execution delay time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    long delay() default 0;

    /**
     * <p>
     * Set a number of execution.
     * </p>
     * 
     * @return
     */
    int count() default 0;

    /**
     * <p>
     * Stop event propagation and default behavior. {@link Event#stopPropagation()} and
     * {@link Event#preventDefault()} methods will be called.
     * </p>
     * 
     * @return The <code>true</code> will stop the current processing event.
     */
    boolean abort() default false;
}
