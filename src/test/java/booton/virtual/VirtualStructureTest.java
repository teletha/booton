/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import org.junit.Test;

import antibug.xml.XML;

/**
 * @version 2014/09/11 14:57:41
 */
public class VirtualStructureTest {

    @Test
    public void text() {
        VirtualStructure $〡 = new VirtualStructure();
        $〡.asis〡("text");

        assertXML($〡, "<div>text</div>");
    }

    @Test
    public void hbox() {
        VirtualStructure $〡 = new VirtualStructure();
        $〡.hbox〡("text");

        assertXML($〡, "<div><div>text</div></div>");
    }

    /**
     * Assertion helper for XML.
     * 
     * @param virtual〡
     * @param string
     */
    private void assertXML(VirtualStructure virtual, String xmlText) {
        XML xml = XML.xml(virtual.getRoot().createNode().toString());
        assert xml.isIdenticalTo(xmlText);
    }

}
