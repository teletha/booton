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

        Node node = element.appedChild(child1);
        assert element.children().size() == 1;
        assert element.children().get(0) == child1;
        assert node == child1;
    }

    @Test(expected = Error.class)
    public void apendChildNull() throws Exception {
        Element element = new EmulateElement();
        element.appedChild(null);
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

        element.appedChild("c");
        element.appedChild("a");
        element.appedChild("t");
        assert element.textContent().equals("cat");
    }

    @Test
    public void textContentWithElement() throws Exception {
        Element element = new EmulateElement();
        assert element.textContent().equals("");

        element.appedChild("c");
        Element child = new EmulateElement();
        child.appedChild("a");
        element.appedChild(child);
        element.appedChild("t");
        assert element.textContent().equals("cat");
    }
}
