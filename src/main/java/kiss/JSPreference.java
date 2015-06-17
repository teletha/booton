/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/03 11:17:46
 */
@JavaAPIProvider(Preference.class)
class JSPreference<M> extends Singleton<M> {

    /**
     * Create Preference instance.
     * 
     * @param modelClass
     */
    protected JSPreference(Class<M> modelClass) {
        super(modelClass);

        // this.path =
        // I.$working.resolve("preferences").resolve(modelClass.getName().concat(".xml"));
        //
        // try {
        // if (Files.exists(path) && Files.size(path) != 0) {
        // I.read(path, instance);
        // }
        // } catch (Exception e) {
        // throw I.quiet(e);
        // }
        //
        // Runtime.getRuntime().addShutdownHook(new Thread(this));
    }
}
