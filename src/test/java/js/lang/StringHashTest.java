/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/12/02 11:28:37
 */
@RunWith(ScriptRunner.class)
public class StringHashTest {

    @Test
    public void hash1() throws Exception {
        int hash1 = "ABCDEFGHIJKLMN1".hashCode();
        int hash2 = "ABCDEFGHIJKLMN2".hashCode();
        assert hash1 != hash2;
    }

    @Test
    public void hash2() throws Exception {
        int hash1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1".hashCode();
        int hash2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ2".hashCode();
        assert hash1 != hash2;
    }
}
