/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.stream;

import booton.JDKEmulator;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/04 19:05:57
 */
@JavaAPIProvider(JDKEmulator.class)
class Tripwire {

    /** Should debugging checks be enabled? */
    static final boolean ENABLED = false;

    /**
     * Produces a log warning, using {@code PlatformLogger.getLogger(className)}, using the supplied
     * message. The class name of {@code trippingClass} will be used as the first parameter to the
     * message.
     * 
     * @param trippingClass Name of the class generating the message
     * @param msg A message format string of the type expected by {@link PlatformLogger}
     */
    static void trip(Class<?> trippingClass, String msg) {
    }
}
