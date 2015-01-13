/*
 * Copyright (C) 2015 Nameless Production Committee
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Annotated class provides the specified JavaScript class API in Java runtime.
 * </p>
 * <p>
 * Normaly, the annotated class provides the simplified implementation of API and it is not used by
 * booton user. So it is recommended that the class has package private modifier.
 * </p>
 * 
 * @version 2015/01/13 10:37:56
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JavascriptAPIProvider {

    /**
     * <p>
     * Specify the JavaScript class name to provide API.
     * </p>
     * 
     * @return A target JavaScript class name.
     */
    String targetJavaScriptClassName() default "";
}
