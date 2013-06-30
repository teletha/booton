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

import org.junit.Test;

/**
 * @version 2013/06/30 12:23:59
 */
public class ElementTest {

    @Test
    public void attribute() throws Exception {
        Element element = new EmulateElement();
        assert element.attr("key") == null;

        element.attr("key", "value");
        assert element.attr("key").equals("value");

        element.remove("key");
        assert element.attr("key") == null;
    }

    @Test
    public void attributeWithNull() throws Exception {
        Element element = new EmulateElement();
        assert element.attr(null) == null;
        assert element.attr("null") == null;

        element.attr(null, null);
        assert element.attr(null).equals("null");
        assert element.attr("null").equals("null");

        element.remove((String) null);
        assert element.attr(null) == null;
        assert element.attr("null") == null;
    }

    @Test
    public void append() throws Exception {
        Element element = new EmulateElement();
        Element child = new EmulateElement();

        assert element.children.length == 0;

        element.append(child);
        assert element.children.length == 1;
    }
}
