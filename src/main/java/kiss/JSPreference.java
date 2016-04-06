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

import static js.lang.Global.*;

import booton.translator.JavaAPIProvider;
import js.dom.User;
import js.lang.NativeFunction;

/**
 * @version 2015/10/20 2:07:28
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

        String key = "PREFERENCE::" + modelClass.getName();

        // restore
        String json = localStorage.getItem(key);

        if (json != null && !json.isEmpty()) {
            I.read(json, instance);
        }

        // store
        window.addEventListener(User.BeforeUnload.name, new NativeFunction(() -> {
            StringBuilder builder = new StringBuilder();
            I.write(instance, builder);
            localStorage.setItem(key, builder.toString());
        }));
    }
}
