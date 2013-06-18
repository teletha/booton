/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import java.util.EventListener;

/**
 * @version 2013/06/17 14:00:12
 */
public interface PageListener extends EventListener {

    /**
     * <p>
     * This method is called whenever the user enter an application page.
     * </p>
     */
    void load();

    /**
     * <p>
     * This method is called whenever the user leave an application page.
     * </p>
     */
    void unload();
}
