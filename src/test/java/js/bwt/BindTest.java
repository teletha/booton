/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

import org.junit.Test;

/**
 * @version 2013/02/03 21:47:34
 */
public class BindTest {

    @Test
    public void bind() throws Exception {
        Item item = new Item();
        assert item.text == null;

        Value<String> value = new Value();
        value.bind(item);
        value.set("test");
        assert item.text.equals("test");
    }

    /**
     * @version 2013/02/03 21:53:31
     */
    private static class Item implements Bindable<String> {

        private String text;

        /**
         * {@inheritDoc}
         */
        @Override
        public void update(String value) {
            text = value;
        }
    }

    @Test
    public void nest() throws Exception {
        Nest nest = new Nest();
        assert nest.item == null;

        Item item1 = new Item();
        item1.text = "text";

        Item item2 = new Item();

        Value<Item> first = new Value();
        first.bind(nest);
        first.set(item1);
        assert nest.item == item1;

        first.set(item2);
        assert nest.item == item2;
    }

    /**
     * @version 2013/02/03 21:55:52
     */
    private static class Nest implements Bindable<Item> {

        private Item item;

        /**
         * {@inheritDoc}
         */
        @Override
        public void update(Item value) {
            this.item = value;
        }
    }
}
