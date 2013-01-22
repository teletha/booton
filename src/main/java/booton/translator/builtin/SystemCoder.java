/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import booton.translator.Translator;

/**
 * @version 2012/11/27 23:25:12
 */
class SystemCoder extends Translator<System> {

    public String out = "console";

    public String err = "console";

    public String arraycopy(Object param0, int param1, Object param2, int param3, int param4) {
        return param(0) + ".copy(" + param(1) + "," + param(2) + "," + param(3) + "," + param(4) + ")";
    }
}
