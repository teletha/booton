/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import sun.util.logging.PlatformLogger;
import sun.util.logging.PlatformLogger.Level;
import booton.translator.Translator;

/**
 * @version 2014/02/06 22:47:36
 */
public class PlatformLoggerCoder extends Translator<PlatformLogger> {

    public String getLogger(String param0) {
        return "console";
    }

    public String config(String param0) {
        return that + ".log(" + param(0) + ")";
    }

    public String info(String param0, Throwable param1) {
        return that + ".info(" + param(0) + "," + param(1) + ")";
    }

    public String warning(String param0) {
        return that + ".warn(" + param(0) + ")";
    }

    public String warning(String param0, Throwable param1) {
        return that + ".warn(" + param(0) + "," + param(1) + ")";
    }

    public String severe(String param0, Throwable param1) {
        return that + ".warn(" + param(0) + "," + param(1) + ")";
    }

    public String finest(String param0, Object[] param1) {
        return that + ".finest(" + param(0) + "," + param(1) + ")";
    }

    public String isLoggable(Level param0) {
        return "true";
    }
}
