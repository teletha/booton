/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import booton.Emulator;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/29 16:19:18
 */
@JavaAPIProvider(java.util.Spliterators.class)
class Spliterators {

    /**
     * @version 2013/10/29 16:28:27
     */
    @JavaAPIProvider(Emulator.class)
    static class ArraySpliterator {

    }
}
