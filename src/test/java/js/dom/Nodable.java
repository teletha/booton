/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;


/**
 * @version 2013/07/02 10:00:16
 */
public interface Nodable {

    /**
     * <p>
     * Build DOM tree.
     * </p>
     * 
     * @param parent
     */
    void setParent(EmulateElement parent);
}
