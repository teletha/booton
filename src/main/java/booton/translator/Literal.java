/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import kiss.Extensible;

/**
 * @version 2012/12/22 14:44:11
 */
public interface Literal<T> extends Extensible {

    /**
     * <p>
     * Write javascript literal expression for the specified class.
     * </p>
     * 
     * @param clazz A target class to write down.
     * @return A literal expression.
     */
    String write(Class<? extends T> clazz);
}
