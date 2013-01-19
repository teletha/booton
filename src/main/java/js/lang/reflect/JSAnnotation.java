/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.annotation.Annotation;

/**
 * @version 2013/01/19 14:12:27
 */
class JSAnnotation {

    /** The annotation class. */
    private final Class<? extends Annotation> type;

    /**
     * 
     */
    JSAnnotation(Class<? extends Annotation> type) {
        this.type = type;
    }

    /**
     * <p>
     * Returns the annotation type of this annotation.
     * </p>
     */
    public Class<? extends Annotation> annotationType() {
        return type;
    }
}
