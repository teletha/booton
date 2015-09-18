/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

/**
 * @version 2015/09/15 14:54:27
 */
public interface Declarable {

    /**
     * <p>
     * Declare the definition.
     * </p>
     */
    void declare();

    /**
     * Define the declaration.
     */
    default void define() {
        declare();
    }
}
