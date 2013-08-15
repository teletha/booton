/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import kiss.ClassListener;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2013/08/15 11:14:35
 */
@Manageable(lifestyle = Singleton.class)
class JavascriptAPIProviders implements ClassListener<JavascriptAPIProvider> {

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(Class clazz) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unload(Class clazz) {
    }
}