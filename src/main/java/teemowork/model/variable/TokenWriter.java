/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model.variable;

import jsx.jQuery;

/**
 * @version 2013/03/08 11:18:11
 */
public interface TokenWriter {

    /**
     * <p>
     * Write string expression.
     * </p>
     * 
     * @param root
     * @param token
     */
    void write(jQuery root, String token);

    /**
     * <p>
     * Write variable expression.
     * </p>
     * 
     * @param root
     * @param token
     */
    void write(jQuery root, Variable token);
}
