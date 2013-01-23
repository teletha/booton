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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * Annotated class replaces the specified Java class from javascript compilation process.
 * </p>
 * <p>
 * Normaly, the replacement class provides the simplified implementation of the replaced class. The
 * replacement class is not used by booton user, so it is recommended that the class has package
 * private modifier.
 * </p>
 * 
 * @version 2013/01/19 9:32:47
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JavaNative {

    /**
     * <p>
     * Specify the class to replace.
     * </p>
     * 
     * @return A class to replace.
     */
    Class value();
}