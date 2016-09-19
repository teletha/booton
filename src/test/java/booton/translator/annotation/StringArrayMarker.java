/*
 * Copyright (C) 2016 Nameless Production Committee
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
 * @version 2013/01/17 20:51:40
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface StringArrayMarker {

    /**
     * <p>
     * Array value.
     * </p>
     * 
     * @return
     */
    String[] value();
}
