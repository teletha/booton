/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/12/11 9:46:40
 */
@RunWith(ScriptRunner.class)
public class PublishableTest {

    @Test
    public void base() throws Exception {
        EventHub eventhub = new EventHub();

        Single reciever = new Single();
        reciever.subscribe(eventhub);
        assert reciever.name == null;

        eventhub.publish("Nadeko");
        assert reciever.name.equals("Nadeko");

        eventhub.publish("Tubasa");
        assert reciever.name.equals("Tubasa");
    }

    @Test
    public void primitive() throws Exception {
        EventHub eventhub = new EventHub();

        Primitive reciever = new Primitive();
        reciever.subscribe(eventhub);
        assert reciever.value == 0;

        eventhub.publish(2);
        assert reciever.value == 2;

        eventhub.publish(Integer.valueOf(10));
        assert reciever.value == 10;
    }

    @Test
    public void wrapper() throws Exception {
        EventHub eventhub = new EventHub();

        Wrapper reciever = new Wrapper();
        reciever.subscribe(eventhub);
        assert reciever.value == 0;

        eventhub.publish(Integer.valueOf(10));
        assert reciever.value == 10;

        eventhub.publish(2);
        assert reciever.value == 2;
    }

    @Test
    public void multipleSameTypes() throws Exception {
        EventHub eventhub = new EventHub();

        MultipleSameType reciever = new MultipleSameType();
        reciever.subscribe(eventhub);
        assert reciever.count == 0;

        eventhub.publish("Sinobu");
        assert reciever.count == 2;
    }

    @Test
    public void methods() throws Exception {
        EventHub eventhub = new EventHub();

        Methods reciever = new Methods();
        reciever.subscribe(eventhub);

        eventhub.publish("Hitagi");
        assert reciever.name.equals("Hitagi");

        eventhub.publish(2);
        assert reciever.value == 2;
    }

    @Test
    public void noParam() throws Exception {
        EventHub eventhub = new EventHub();

        NoParam reciever = new NoParam();
        reciever.subscribe(eventhub);
        assert reciever.count == 0;

        eventhub.publish("Hitagi");
        assert reciever.count == 1;
    }

    @Test
    public void subscribes() throws Exception {
        EventHub eventhub = new EventHub();

        MultipleSubscribers reciever = new MultipleSubscribers();
        reciever.subscribe(eventhub);
        assert reciever.count == 0;

        eventhub.publish("Hitagi");
        assert reciever.count == 1;

        eventhub.publish(17);
        assert reciever.count == 2;

        eventhub.publish(new IllegalStateException());
        assert reciever.count == 2;
    }

    @Test
    public void hierarchy() throws Exception {
        EventHub eventhub = new EventHub();

        Hierarchy reciever = new Hierarchy();
        reciever.subscribe(eventhub);
        assert reciever.count == 0;

        eventhub.publish("string and char sequence");
        assert reciever.count == 2;

        eventhub.publish(new StringBuilder("not string"));
        assert reciever.count == 3;
    }

    /**
     * @version 2013/12/11 10:07:25
     */
    private static class EventHub implements Publishable {
    }

    /**
     * @version 2013/12/11 9:48:31
     */
    private static class Single implements Subscribable {

        private String name;

        @Subscribe
        private void recieve(String name) {
            this.name = name;
        }
    }

    /**
     * @version 2013/12/11 9:48:31
     */
    private static class MultipleSameType implements Subscribable {

        private int count;

        @Subscribe
        private void recieve1(String name) {
            count++;
        }

        @Subscribe
        private void recieve2(String name) {
            count++;
        }
    }

    /**
     * @version 2013/12/11 10:07:32
     */
    private static class Primitive implements Subscribable {

        private int value;

        @Subscribe
        private void recieve(int value) {
            this.value = value;
        }
    }

    /**
     * @version 2013/12/11 10:07:32
     */
    private static class Wrapper implements Subscribable {

        private int value;

        @Subscribe
        private void recieve(Integer value) {
            this.value = value;
        }
    }

    /**
     * @version 2013/12/11 10:07:30
     */
    private static class Methods implements Subscribable {

        private String name;

        @Subscribe
        private void name(String name) {
            this.name = name;
        }

        private int value;

        @Subscribe
        private void recieve2(int value) {
            this.value = value;
        }
    }

    /**
     * @version 2013/12/11 9:48:31
     */
    private static class NoParam implements Subscribable {

        private int count;

        @Subscribe(String.class)
        private void recieve() {
            this.count++;
        }
    }

    /**
     * @version 2013/12/11 10:07:30
     */
    private static class MultipleSubscribers implements Subscribable {

        private int count;

        @Subscribe(int.class)
        @Subscribe(String.class)
        private void recieve() {
            this.count++;
        }
    }

    /**
     * @version 2013/12/11 10:09:23
     */
    private static class Hierarchy implements Subscribable {

        private int count;

        @Subscribe
        private void string(String name) {
            this.count++;
        }

        @Subscribe
        private void charSequence(CharSequence value) {
            this.count++;
        }
    }
}
