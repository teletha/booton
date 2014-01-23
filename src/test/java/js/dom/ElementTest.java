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

import static js.lang.Global.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/06/30 12:23:59
 */
@RunWith(ScriptRunner.class)
public class ElementTest {

    @Test
    public void element() throws Exception {
        Element element = document.createElement("span");
        assert element != null;
        assert element.tagName().equals("SPAN"); // use native Element method
        assert element.textContent().equals(""); // use native Node method

        assert element.text().equals(""); // use extended Element method
        Element child = element.child("child"); // use extended Node method
        assert child != null;
        assert child.tagName().equals("CHILD");
        assert child.parentElement() == element; // use native Element method
        assert child.parent() == element;
    }

    @Test
    public void matches() throws Exception {
        Element root = document.createElement("div");
        Element e = document.createElement("em");

        document.documentElement().append(root);
        root.append(e);

        assert e.matches("em");
    }
}
