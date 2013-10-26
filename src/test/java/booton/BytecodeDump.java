/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import org.objectweb.asm.util.ASMifier;

/**
 * @version 2013/10/24 14:44:43
 */
public class BytecodeDump {

    public static void main(String[] args) throws Exception {
        dump(js.util.OptionalDouble.class);
    }

    private static void dump(Class type) throws Exception {
        ASMifier.main(new String[] {"-debug", type.getName()});
    }
}
