/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui.event;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 2013/04/07 15:44:59
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenKey {

    /**
     * <p>
     * Specify key.
     * </p>
     * 
     * @return
     */
    Key value();

    /**
     * <p>
     * Specify control(command) key state.
     * </p>
     * 
     * @return A state of control(command) key.
     */
    boolean ctrl() default false;

    /**
     * <p>
     * Specify shift key state.
     * </p>
     * 
     * @return A state of shift key.
     */
    boolean shift() default false;

    /**
     * <p>
     * Specify alt key state.
     * </p>
     * 
     * @return A state of alt key.
     */
    boolean alt() default false;
}