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

        assert element.children().size() == 0;

        element.append(child);
        assert element.children().size() == 1;
        assert element.children().get(0) == child;
    }

    @Test
    public void appendMultiple() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement();
        Element child2 = new EmulateElement();

        assert element.children().size() == 0;

        element.append(child1).append(child2);
        assert element.children().size() == 2;
        assert element.children().get(0) == child1;
        assert element.children().get(1) == child2;
    }

    @Test
    public void appendDuplication() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement();
        Element child2 = new EmulateElement();

        assert element.children().size() == 0;

        element.append(child1).append(child2).append(child1);
        assert element.children().size() == 2;
        assert element.children().get(0) == child2;
        assert element.children().get(1) == child1;
    }

    @Test
    public void prepend() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement();
        Element child2 = new EmulateElement();

        assert element.children().size() == 0;

        element.prepend(child1).prepend(child2);
        assert element.children().size() == 2;
        assert element.children().get(0) == child2;
        assert element.children().get(1) == child1;
    }

    @Test
    public void empty() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement().text("1");
        Element child2 = new EmulateElement().text("2");
        element.append(child1).append(child2);

        assert element.children().size() == 2;
        assert element.text().equals("12");

        element.empty();
        assert element.children().size() == 0;
        assert element.text().equals("");
    }
}
