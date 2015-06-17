/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import java.util.EventListener;

/**
 * @version 2013/04/09 11:54:20
 */
public interface PropertyChangeListener<S> extends EventListener {

    void change(Object object, String propertyName, S oldValue, S newValue);
}
