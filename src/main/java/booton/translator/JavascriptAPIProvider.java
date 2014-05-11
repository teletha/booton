/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Annotated class provides the specified Java class API in Javascript runtime.
 * </p>
 * <p>
 * Normaly, the annotated class provides the simplified implementation of API and it is not used by
 * booton user. So it is recommended that the class has package private modifier.
 * </p>
 * 
 * @version 2013/04/14 14:02:55
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JavascriptAPIProvider {

    /**
     * <p>
     * Specify the class to provide API.
     * </p>
     * 
     * @return A target class.
     */
    String value() default "";

    boolean polyfill() default false;
}
