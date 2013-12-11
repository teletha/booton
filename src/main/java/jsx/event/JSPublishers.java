/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/11 9:40:18
 */
@JavaAPIProvider(Publishers.class)
class JSPublishers {

    /**
     * @param publishable
     * @return
     */
    static Publisher get(Publishable publishable, boolean require) {
        NativeObject object = (NativeObject) (Object) publishable;
        Publisher publisher = object.getPropertyAs(Publisher.class, "$publisher$");

        if (publisher == null && require) {
            publisher = new Publisher();
            object.setProperty("$publisher$", publisher);
        }
        return publisher;
    }
}
