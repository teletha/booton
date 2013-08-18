/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import static js.lang.NativeGlobal.*;

import org.junit.Test;

/**
 * @version 2013/07/12 20:42:51
 */
public class DocumentTest {

    @Test
    public void text() throws Exception {
        Text text = document.createTextNode("text");
        assert text.textContent().equals("text");
    }

    @Test
    public void textNull() throws Exception {
        Text text = document.createTextNode(null);
        assert text.textContent().equals("null");
    }

    @Test
    public void textEmpty() throws Exception {
        Text text = document.createTextNode("");
        assert text.textContent().equals("");
    }
}
