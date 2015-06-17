/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import org.junit.Test;

/**
 * @version 2012/12/22 9:47:50
 */
public class ObfuscatorTest {

    @Test
    public void mung32() throws Exception {
        assert Obfuscator.mung32(0).equals("A");
        assert Obfuscator.mung32(1).equals("B");
        assert Obfuscator.mung32(25).equals("Z");
        assert Obfuscator.mung32(26).equals("u");
    }

    @Test
    public void mung52() throws Exception {
        assert Obfuscator.mung52(0).equals("a");
        assert Obfuscator.mung52(1).equals("b");
        assert Obfuscator.mung52(25).equals("z");
        assert Obfuscator.mung52(26).equals("A");
        assert Obfuscator.mung52(27).equals("B");
        assert Obfuscator.mung52(51).equals("Z");
        assert Obfuscator.mung52(52).equals("ba");
    }
}
