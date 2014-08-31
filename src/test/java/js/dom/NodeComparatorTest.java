/*
 * Copyright (C) 2014 Nameless Production Committee
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
 * @version 2014/08/31 11:25:51
 */
public class NodeComparatorTest {

    @Test
    public void element() {
        EmulateElement e1 = new EmulateElement("div");
        EmulateElement e2 = new EmulateElement("div");

        NodeComparator.equals(e1, e2);
    }

    @Test(expected = AssertionError.class)
    public void elementNot() {
        EmulateElement e1 = new EmulateElement("div");
        EmulateElement e2 = new EmulateElement("span");

        NodeComparator.equals(e1, e2);
    }

    @Test
    public void child() {
        EmulateElement e1 = new EmulateElement("div");
        e1.child("c1");
        EmulateElement e2 = new EmulateElement("div");
        e2.child("c1");

        NodeComparator.equals(e1, e2);
    }

    @Test(expected = AssertionError.class)
    public void childNot() {
        EmulateElement e1 = new EmulateElement("div");
        e1.child("c1");
        EmulateElement e2 = new EmulateElement("div");
        e2.child("c2");

        NodeComparator.equals(e1, e2);
    }

    @Test
    public void attribute() {
        Element e1 = new EmulateElement("div").attr("a", "A");
        Element e2 = new EmulateElement("div").attr("a", "A");

        NodeComparator.equals(e1, e2);
    }

    @Test(expected = AssertionError.class)
    public void attributeNot() {
        Element e1 = new EmulateElement("div").attr("a", "A");
        Element e2 = new EmulateElement("div").attr("a", "B");

        NodeComparator.equals(e1, e2);
    }
}
