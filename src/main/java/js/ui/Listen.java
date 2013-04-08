/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 2013/04/07 2:37:20
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Listen {

    /**
     * <p>
     * Define event type.
     * </p>
     * 
     * @return
     */
    UIEvent[] value();

    /**
     * <p>
     * Set execution {@link Timing}.
     * </p>
     * 
     * @return
     */
    Timing executeAt() default Timing.Immediate;

    /**
     * @return
     */
    long executeTime() default 0;

    /**
     * <p>
     * Set a number of execution.
     * </p>
     * 
     * @return
     */
    int count() default 0;
}
