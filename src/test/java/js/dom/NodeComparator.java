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

import java.util.List;

/**
 * @version 2014/08/31 11:08:37
 */
public class NodeComparator {

    /**
     * Helper method to validate node structure.
     * 
     * @param one
     * @param other
     */
    public static void equals(Node one, Node other) {
        if (one == null && other == null) {
            return;
        }

        if (one == null) {
            throw new AssertionError("One is null but the other is not null.");
        }

        if (other == null) {
            throw new AssertionError("One is null but the other is not null.");
        }

        if (one instanceof Element) {
            if (other instanceof Element == false) {
                throw new AssertionError("One is element but the other is not element.");
            }
            equals((Element) one, (Element) other);
        } else if (one instanceof Text) {
            if (other instanceof Element == false) {
                throw new AssertionError("One is text but the other is not text.");
            }
            equals((Text) one, (Text) other);
        } else {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }
    }

    /**
     * @param one
     * @param other
     */
    public static void equals(Text one, Text other) {
        assert one.textContent().equals(other.textContent());
    }

    /**
     * @param one
     * @param other
     */
    public static void equals(Element one, Element other) {
        assert one.tagName().equals(other.tagName());

        Attributes attributes1 = one.attributes();
        Attributes attributes2 = other.attributes();
        assert attributes1.length() == attributes2.length();

        for (int i = 0; i < attributes1.length(); i++) {
            Attribute attribute1 = attributes1.get(i);
            Attribute attribute2 = attributes2.get(i);
            assert attribute1.namespaceURI().equals(attribute2.namespaceURI());
            assert attribute1.name().equals(attribute2.name());
            assert attribute1.value().equals(attribute2.value());
        }

        List<Element> children1 = one.children();
        List<Element> children2 = other.children();
        assert children1.size() == children2.size();

        for (int i = 0; i < children1.size(); i++) {
            equals(children1.get(i), children2.get(i));
        }
    }
}
