/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 2013/10/05 10:19:36
 */
class EmulateCSSStyleDeclaration extends CSSStyleDeclaration {

    /** The style manager. */
    private final Map<String, String> properties = new HashMap();

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPropertyValue(String name) {
        return properties.get(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProperty(String name, String value) {
        properties.put(name, value);
    }
}
