/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @version 2012/12/01 2:41:16
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {

    /**
     * <p>
     * Provide int values.
     * </p>
     * 
     * @return
     */
    int[] ints() default {};

    /**
     * <p>
     * Provide long values.
     * </p>
     * 
     * @return
     */
    long[] longs() default {};

    /**
     * <p>
     * Provide float values.
     * </p>
     * 
     * @return
     */
    float[] floats() default {};

    /**
     * <p>
     * Provide double values.
     * </p>
     * 
     * @return
     */
    double[] doubles() default {};

    /**
     * <p>
     * Provide byte values.
     * </p>
     * 
     * @return
     */
    byte[] bytes() default {};

    /**
     * <p>
     * Provide short values.
     * </p>
     * 
     * @return
     */
    short[] shorts() default {};

    /**
     * <p>
     * Provide char values.
     * </p>
     * 
     * @return
     */
    char[] chars() default {};

    /**
     * <p>
     * Provide {@link String} values.
     * </p>
     * 
     * @return
     */
    String[] strings() default {};
}
