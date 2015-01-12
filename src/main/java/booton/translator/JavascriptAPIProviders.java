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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import kiss.ClassListener;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2013/08/15 23:02:07
 */
@Manageable(lifestyle = Singleton.class)
class JavascriptAPIProviders implements ClassListener<JavascriptAPIProvider> {

    /** The provider classes. */
    private static final Set<Class> providers = new HashSet();

    /** The class name mapping. */
    private static final Map<String, Class> definitions = new HashMap();

    static boolean shouldOmitCode(Class clazz) {
        return providers.contains(clazz);
    }

    /**
     * <p>
     * Find {@link JavascriptAPIProvider} provider.
     * </p>
     * 
     * @param type
     * @return
     */
    static Class findProvider(String type) {
        return definitions.get(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(Class<JavascriptAPIProvider> clazz) {
        JavascriptAPIProvider provider = clazz.getAnnotation(JavascriptAPIProvider.class);
        String type = provider.value();

        if (type.length() == 0) {
            type = clazz.getSimpleName();
        }
        definitions.put(type, clazz);

        if (provider.omitCode()) {
            providers.add(clazz);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unload(Class<JavascriptAPIProvider> clazz) {
        providers.remove(clazz);
    }
}