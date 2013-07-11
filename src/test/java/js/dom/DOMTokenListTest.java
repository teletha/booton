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

import booton.css.CSS;

/**
 * @version 2013/07/11 11:56:28
 */
public class DOMTokenListTest {

    @Test
    public void add() throws Exception {
        DOMTokenList list = new EmulateDOMTokenList();

        assert !list.contains(CSS1.class);

        list.add(CSS1.class);
        assert list.contains(CSS1.class);
    }

    @Test
    public void addMultiple() throws Exception {
        DOMTokenList list = new EmulateDOMTokenList();

        assert !list.contains(CSS1.class);
        assert !list.contains(CSS2.class);

        list.add(CSS1.class);
        assert list.contains(CSS1.class);
        assert !list.contains(CSS2.class);
        assert list.length() == 1;

        list.add(CSS2.class);
        assert list.contains(CSS1.class);
        assert list.contains(CSS2.class);
        assert list.length() == 2;
    }

    @Test
    public void addDuplicated() throws Exception {
        DOMTokenList list = new EmulateDOMTokenList();

        assert !list.contains(CSS1.class);

        list.add(CSS1.class);
        assert list.contains(CSS1.class);
        assert list.length() == 1;

        list.add(CSS1.class);
        assert list.contains(CSS1.class);
        assert list.length() == 1;
    }

    @Test
    public void addNull() throws Exception {
        DOMTokenList list = new EmulateDOMTokenList();

        list.add((String) null);
        assert list.contains("null");

        list.add((Class) null);
        assert list.contains("null");
    }

    @Test
    public void remove() throws Exception {
        DOMTokenList list = new EmulateDOMTokenList();

        list.add(CSS1.class);
        assert list.contains(CSS1.class);

        list.remove(CSS1.class);
        assert !list.contains(CSS1.class);
        assert list.length() == 0;
    }

    /**
     * @version 2013/07/11 11:54:32
     */
    private static class CSS1 extends CSS {
    }

    /**
     * @version 2013/07/11 11:54:32
     */
    private static class CSS2 extends CSS {
    }
}
