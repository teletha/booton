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
public class DOMElementTest {

    @Test
    public void apendChild() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement();

        assert element.children().size() == 0;

        Node node = element.appendChild(child1);
        assert element.children().size() == 1;
        assert element.children().get(0) == child1;
        assert node == child1;
    }

    @Test(expected = Error.class)
    public void apendChildNull() throws Exception {
        Element element = new EmulateElement();
        element.appendChild(null);
    }

    @Test
    public void removeChild() throws Exception {
        Element element = new EmulateElement();
        Element child = new EmulateElement();
        element.appendChild(child);

        assert element.children().size() == 1;
        assert element.children().get(0) == child;

        Node removed = element.removeChild(child);
        assert element.children().size() == 0;
        assert removed == child;
    }

    @Test(expected = Error.class)
    public void removeChildNull() throws Exception {
        Element element = new EmulateElement();
        element.appendChild(null);
    }

    @Test(expected = Error.class)
    public void removeNonChild() throws Exception {
        Element element = new EmulateElement();
        Element child = new EmulateElement();
        element.removeChild(child);
    }

    @Test
    public void insertBefore() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement();
        Element child2 = new EmulateElement();

        assert element.children().size() == 0;

        element.append(child1).insertBefore(child2, child1);
        assert element.children().size() == 2;
        assert element.children().get(0) == child2;
        assert element.children().get(1) == child1;
    }

    @Test
    public void insertBeforeNull() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement();
        Element child2 = new EmulateElement();

        assert element.children().size() == 0;

        element.append(child1).insertBefore(child2, null);
        assert element.children().size() == 2;
        assert element.children().get(0) == child1;
        assert element.children().get(1) == child2;
    }

    @Test(expected = Error.class)
    public void insertBeforeNotChildReference() throws Exception {
        Element element = new EmulateElement();
        Element child1 = new EmulateElement();
        Element child2 = new EmulateElement();

        element.insertBefore(child2, child1);
    }

    @Test
    public void textContent() throws Exception {
        Element element = new EmulateElement();
        assert element.textContent().equals("");

        element.appendChild("c");
        element.appendChild("a");
        element.appendChild("t");
        assert element.textContent().equals("cat");
    }

    @Test
    public void textContentWithElement() throws Exception {
        Element element = new EmulateElement();
        assert element.textContent().equals("");

        element.appendChild("c");
        Element child = new EmulateElement();
        child.appendChild("a");
        element.appendChild(child);
        element.appendChild("t");
        assert element.textContent().equals("cat");
    }
}