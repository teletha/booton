/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @version 2013/01/16 16:12:01
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimitiveMarker {

    /**
     * <p>
     * Primitive value.
     * </p>
     * 
     * @return
     */
    int intValue() default 10;

    /**
     * <p>
     * Primitive value.
     * </p>
     * 
     * @return
     */
    long longValue() default 10;

    /**
     * <p>
     * Primitive value.
     * </p>
     * 
     * @return
     */
    float floatValue() default 10;

    /**
     * <p>
     * Primitive value.
     * </p>
     * 
     * @return
     */
    double doubleValue() default 10;

    /**
     * <p>
     * Primitive value.
     * </p>
     * 
     * @return
     */
    short shortValue() default 10;

    /**
     * <p>
     * Primitive value.
     * </p>
     * 
     * @return
     */
    byte byteValue() default 10;

    /**
     * <p>
     * Primitive value.
     * </p>
     * 
     * @return
     */
    boolean booleanValue() default true;
}
