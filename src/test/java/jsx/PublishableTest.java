/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx;

import jsx.Publishable;
import jsx.Subscribable;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/10/05 11:24:20
 */
@RunWith(ScriptRunner.class)
public class PublishableTest {

    @Test
    public void register() throws Exception {
        ObjectListener listener = new ObjectListener();
        assert listener.name == null;

        Publishable hub = new Publishable();
        hub.register(listener);
        hub.publish("Yukinosita Yukino");
        assert listener.name.equals("Yukinosita Yukino");
    }

    @Test
    public void registerDuplication() throws Exception {
        ObjectListener listener = new ObjectListener();
        assert listener.name == null;

        Publishable hub = new Publishable();
        hub.register(listener);
        hub.register(listener);
        hub.publish("Yukinosita Yukino");
        assert listener.count == 1;
    }

    @Test
    public void registerMultiple() throws Exception {
        ObjectListener listener1 = new ObjectListener();
        assert listener1.name == null;
        ObjectListener listener2 = new ObjectListener();
        assert listener2.name == null;

        Publishable hub = new Publishable();
        hub.register(listener1);
        hub.register(listener2);
        hub.publish("Yukinosita Yukino");
        assert listener1.count == 1;
        assert listener2.count == 1;
    }

    @Test
    public void unregister() throws Exception {
        ObjectListener listener = new ObjectListener();
        assert listener.name == null;

        Publishable hub = new Publishable();
        hub.register(listener);
        hub.publish("Yukinosita Yukino");
        assert listener.name.equals("Yukinosita Yukino");

        hub.unregister(listener);
        hub.publish("Yuigahama Yui");
        assert listener.name.equals("Yukinosita Yukino");
    }

    @Test
    public void publishPrimitive() throws Exception {
        PrimitiveListener primitive = new PrimitiveListener();
        assert primitive.intValue == 0;

        Publishable hub = new Publishable();
        hub.register(primitive);
        hub.publish(10);
        assert primitive.intValue == 10;
    }

    @Test
    public void subscribeFromSuperType() throws Exception {
        PrimitiveListener primitive = new PrimitiveListener();
        assert primitive.name == null;

        Publishable hub = new Publishable();
        hub.register(primitive);
        hub.publish("Yukinosita Yukino");
        assert primitive.name.equals("Yukinosita Yukino");
    }

    /**
     * @version 2013/10/05 11:25:52
     */
    protected static class ObjectListener {

        protected int count = 0;

        protected String name;

        /**
         * @param name
         */
        @Subscribable
        protected void listen(String name) {
            this.count++;
            this.name = name;
        }
    }

    /**
     * @version 2013/10/05 11:51:41
     */
    private static class PrimitiveListener extends ObjectListener {

        private int intValue;

        private double doubleValue;

        @Subscribable
        private void listen(int value) {
            this.intValue = value;
        }

        @Subscribable
        private void listen(double value) {
            this.doubleValue = value;
        }
    }
}
