/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 2014/06/07 10:10:31
 */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.CLASS)
public @interface Debuggable {

    /**
     * <p>
     * Show debug info in detail.
     * </p>
     * 
     * @return
     */
    boolean beforeLabel() default false;

    /**
     * <p>
     * Show debug info in detail.
     * </p>
     * 
     * @return
     */
    boolean afterLabel() default false;
}
