/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

/**
 * @version 2014/10/24 13:58:41
 */
public interface StyleClass {

    /**
     * <p>
     * Declare styles.
     * </p>
     */
    void declare();

    /**
     * <p>
     * Compute internal class name.
     * </p>
     * 
     * @return
     */
    public default String intern() {
        return "STYLE" + hashCode();
    }
}
