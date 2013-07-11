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
 * @version 2013/03/11 11:46:14
 */
public interface HTMLizable {

    /**
     * <p>
     * Generate DOM representation of this object state.
     * </p>
     * 
     * @param root
     */
    void toDOM(jQuery root);
}
