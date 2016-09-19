/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import antibug.powerassert.PowerAssertRenderer;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/28 15:43:34
 */
@JavaAPIProvider(PowerAssertRenderer.class)
public class PowerAssertRendererProvider {

    /**
     * <p>
     * Format the target object.
     * </p>
     * 
     * @param object A object to format.
     * @return A formatted message.
     */
    public static final String format(Object object) {
        return object.toString();
    }
}
