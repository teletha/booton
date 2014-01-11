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

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import js.dom.UIAction;
import js.dom.UIEvent;
import jsx.rx.EventEmitter;
import jsx.rx.Observable;
import kiss.Disposable;

import org.junit.Test;
import org.junit.runner.RunWith;

import antibug.Async;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/12/20 11:24:49
 */
@RunWith(ScriptRunner.class)
public class PublishableTest {

    static {
        Observable.tasks = Async.use();
    }

    /**
     * @version 2013/12/20 10:06:34
     */
    private static abstract class PubSub extends Publishable {

        /** The counter or value holder. */
        protected int value;

        /** The String value holder. */
        protected String string;

        /**
         * 
         */
        protected PubSub() {
            register(this);
        }
    }

    @Test
    public void registerAndUnregister() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void recieve(String name) {
                this.string = name;
            }
        };
        assert reciever.string == null;

        reciever.publish("Nadeko");
        assert reciever.string.equals("Nadeko");

        reciever.publish("Tubasa");
        assert reciever.string.equals("Tubasa");

        reciever.unregister(reciever);
        reciever.publish("Nadeko");
        assert reciever.string.equals("Tubasa");
    }

    @Test
    public void registerSameObjectMultiple() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void recieve(String name) {
                value++;
            }
        };
        reciever.register(reciever);
        reciever.register(reciever);

        reciever.publish("Sinobu");
        assert reciever.value == 1;
    }

    @Test
    public void primitive() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void recieve(int value) {
                this.value = value;
            }
        };

        reciever.publish(2);
        assert reciever.value == 2;

        reciever.publish(Integer.valueOf(10));
        assert reciever.value == 10;
    }

    @Test
    public void wrapper() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void recieve(Integer value) {
                this.value = value;
            }
        };

        reciever.publish(Integer.valueOf(10));
        assert reciever.value == 10;

        reciever.publish(2);
        assert reciever.value == 2;
    }

    @Test
    public void noParam() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe(String.class)
            private void recieve() {
                value++;
            }
        };

        reciever.publish("Hitagi");
        assert reciever.value == 1;
    }

    @Test
    public void multipleSameTypes() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void recieve1(String name) {
                value++;
            }

            @Subscribe
            private void recieve2(String name) {
                value++;
            }
        };

        reciever.publish("Sinobu");
        assert reciever.value == 2;
    }

    @Test
    public void multipleDifferenceType() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void name(String name) {
                this.string = name;
            }

            @Subscribe
            private void recieve2(int value) {
                this.value = value;
            }
        };

        reciever.publish("Hitagi");
        assert reciever.string.equals("Hitagi");

        reciever.publish(2);
        assert reciever.value == 2;
    }

    @Test
    public void multipleAnnotationsOnSameMethod() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe(int.class)
            @Subscribe(String.class)
            private void recieve() {
                value++;
            }
        };

        reciever.publish("Hitagi");
        assert reciever.value == 1;

        reciever.publish(17);
        assert reciever.value == 2;

        reciever.publish(new IllegalStateException());
        assert reciever.value == 2;
    }

    @Test
    public void hierarchy() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void string(String name) {
                this.value++;
            }

            @Subscribe
            private void charSequence(CharSequence value) {
                this.value++;
            }
        };
        assert reciever.value == 0;

        reciever.publish("string and char sequence");
        assert reciever.value == 2;

        reciever.publish(new StringBuilder("not string"));
        assert reciever.value == 3;
    }

    @Test
    public void count() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe(count = 2)
            private void countValue(String name) {
                value++;
            }
        };

        reciever.publish("Hitagi");
        assert reciever.value == 1;

        reciever.publish("Nadeko");
        assert reciever.value == 2;

        reciever.publish("Suruga");
        assert reciever.value == 2;
    }

    @Test
    public void throttle() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe(throttle = 50)
            private void string(int event) {
                value++;
            }
        };

        assert reciever.value == 0;

        reciever.publish(100);
        assert reciever.value == 1;

        reciever.publish(100);
        reciever.publish(100);
        reciever.publish(100);
        assert reciever.value == 1;

        Async.wait(80);
        reciever.publish(100);
        assert reciever.value == 2;
    }

    @Test
    public void debounce() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe(debounce = 10)
            private void time(int value) {
                this.value = value;
            }
        };

        reciever.publish(10);
        reciever.publish(20);
        reciever.publish(30);
        assert reciever.value == 0;

        Async.awaitTasks();
        assert reciever.value == 30;
    }

    @Test
    public void delay() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe(delay = 30)
            private void time(int value) {
                this.value += value;
            }
        };

        reciever.publish(10);
        reciever.publish(20);
        reciever.publish(30);
        assert reciever.value == 0;

        Async.awaitTasks();
        assert reciever.value == 60;
    }

    @Test
    public void abort() throws Exception {
        Abort reciever = new Abort();

        assert reciever.value == 0;
        assert reciever.disposed == false;

        reciever.publish(reciever);
        assert reciever.value == 1;
        assert reciever.disposed == true;
    }

    /**
     * @version 2013/12/18 10:10:09
     */
    private static class Abort extends PubSub implements Disposable {

        private boolean disposed;

        @Subscribe(abort = true)
        private void string(Abort event) {
            value++;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void dispose() {
            disposed = true;
        }
    }

    @Test
    public void subscribeUI() throws Exception {
        PubSub reciever = new PubSub() {

            @SubscribeUI(type = UIAction.Click)
            private void action() {
                value++;
            }
        };

        reciever.publish(event(UIAction.Click));
        assert reciever.value == 1;

        reciever.publish(event(UIAction.Focus));
        assert reciever.value == 1;
    }

    @Test
    public void subscribeUIWithEventObject() throws Exception {
        PubSub reciever = new PubSub() {

            @SubscribeUI(type = UIAction.Click)
            private void action(UIEvent event) {
                string = event.type;
            }
        };

        reciever.publish(event(UIAction.Click));
        assert reciever.string.equals("click");

        reciever.publish(event(UIAction.Focus));
        assert !reciever.string.equals("focus");
    }

    @Test
    public void key() throws Exception {
        PubSub reciever = new PubSub() {

            @SubscribeUI(type = UIAction.Key_Space)
            private void detect1() {
                this.value++;
            }

            @SubscribeUI(type = UIAction.Key_F1)
            private void detect2() {
                this.value++;
            }
        };

        reciever.publish(event(UIAction.Key_Space));
        assert reciever.value == 1;

        reciever.publish(event(UIAction.Key_A));
        reciever.publish(event(UIAction.Key_Enter));
        assert reciever.value == 1;
    }

    /**
     * <p>
     * Helper method to create ui event.
     * </p>
     * 
     * @param action
     * @return
     */
    private static UIEvent event(UIAction action) {
        UIEvent event = new UIEvent();
        event.type = action.name;
        event.action = action;
        event.which = action.code;

        return event;
    }

    @Test
    public void internalEvent() throws Exception {
        InternalEvent internal = new InternalEvent();
        assert internal.starts.isEmpty();
        assert internal.stops.isEmpty();

        internal.register(internal);
        assert internal.starts.contains(Object.class);
        assert internal.starts.contains(String.class);
        assert internal.stops.isEmpty();

        internal.unregister(internal);
        assert internal.stops.contains(Object.class);
        assert internal.stops.contains(String.class);
    }

    /**
     * @version 2013/12/18 12:51:34
     */
    private static class InternalEvent extends Publishable {

        private Set starts = new HashSet();

        private Set stops = new HashSet();

        /**
         * {@inheritDoc}
         */
        @Override
        protected void startListening(Object type) {
            starts.add(type);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void stopListening(Object type) {
            stops.add(type);
        }

        @Subscribe
        private void recieve(String name) {
            // do nothing
        }
    }

    /**
     * @version 2013/12/20 11:29:24
     */
    private static class FunctionalPubSub extends Publishable {

        private int runnable;

        private void runnable() {
            runnable++;
        }

        private String consumeString = "";

        private void consumeString(String value) {
            consumeString = consumeString.concat(value);
        }

        private int consumeInt;

        private void consumeInt(int value) {
            consumeInt += value;
        }

        private int consumeUI;

        private void consumeUIEvent(UIEvent value) {
            consumeUI++;
        }
    }

    @Test
    public void registerRunnable() throws Exception {
        FunctionalPubSub pubsub = new FunctionalPubSub();
        Runnable runnable = pubsub::runnable;
        pubsub.register(String.class, runnable);

        pubsub.publish("string");
        assert pubsub.runnable == 1;

        pubsub.publish(1);
        assert pubsub.runnable == 1;

        pubsub.unregister(String.class, runnable);
        pubsub.publish("unsubscribe");
        assert pubsub.runnable == 1;
    }

    @Test
    public void registerRunnableEnum() throws Exception {
        FunctionalPubSub pubsub = new FunctionalPubSub();
        Runnable runnable = pubsub::runnable;
        pubsub.register(UIAction.Click, runnable);

        pubsub.publish(event(UIAction.Click));
        assert pubsub.runnable == 1;

        pubsub.publish(event(UIAction.Click));
        assert pubsub.runnable == 2;

        pubsub.unregister(UIAction.Click, runnable);
        pubsub.publish(event(UIAction.Click));
        assert pubsub.runnable == 2;
    }

    @Test
    public void registerRunnableMultiple() throws Exception {
        FunctionalPubSub pubsub = new FunctionalPubSub();
        Runnable runnable = pubsub::runnable;
        pubsub.register(String.class, runnable);
        pubsub.register(String.class, runnable);
        pubsub.register(String.class, runnable);

        pubsub.publish("string");
        assert pubsub.runnable == 1;
    }

    @Test
    public void registerConsumerInt() throws Exception {
        FunctionalPubSub pubsub = new FunctionalPubSub();
        Consumer<Integer> consumer = pubsub::consumeInt;
        pubsub.register(int.class, consumer);

        pubsub.publish(10);
        assert pubsub.consumeInt == 10;

        pubsub.publish(20);
        assert pubsub.consumeInt == 30;

        pubsub.publish("string");
        assert pubsub.consumeString.isEmpty();

        pubsub.unregister(int.class, consumer);
        pubsub.publish(10);
        assert pubsub.consumeInt == 30;
    }

    @Test
    public void registerConsumerString() throws Exception {
        FunctionalPubSub pubsub = new FunctionalPubSub();
        Consumer<String> consumer = pubsub::consumeString;
        pubsub.register(String.class, consumer);

        pubsub.publish("Hanekawa");
        assert pubsub.consumeString.equals("Hanekawa");

        pubsub.publish("Tubasa");
        assert pubsub.consumeString.equals("HanekawaTubasa");

        pubsub.publish(10);
        assert pubsub.consumeInt == 0;

        pubsub.unregister(String.class, consumer);
        pubsub.publish("None");
        assert pubsub.consumeString.equals("HanekawaTubasa");
    }

    @Test
    public void registerConsumerEnum() throws Exception {
        FunctionalPubSub pubsub = new FunctionalPubSub();
        Consumer<UIEvent> consumer = pubsub::consumeUIEvent;
        pubsub.register(UIAction.Click, consumer);

        pubsub.publish(event(UIAction.Click));
        assert pubsub.consumeUI == 1;

        pubsub.publish(event(UIAction.Click));
        assert pubsub.consumeUI == 2;

        pubsub.publish(event(UIAction.Focus));
        assert pubsub.consumeUI == 2;

        pubsub.unregister(UIAction.Click, consumer);
        pubsub.publish(event(UIAction.Click));
        assert pubsub.consumeUI == 2;
    }

    @Test
    public void registerConsumerMultiple() throws Exception {
        FunctionalPubSub pubsub = new FunctionalPubSub();
        Consumer<Integer> consumer = pubsub::consumeInt;
        pubsub.register(int.class, consumer);
        pubsub.register(int.class, consumer);
        pubsub.register(int.class, consumer);

        pubsub.publish(10);
        assert pubsub.consumeInt == 10;
    }

    @Test
    public void unregisterImmediately() throws Exception {
        Publishable instance = new Publishable();
        instance.unregister();
        instance.unregister(String.class);
        instance.unregister(UIAction.Click);
    }

    @Test
    public void unregisterByType() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void recieve(String name) {
                value++;
            }
        };

        reciever.publish("Sinobu");
        assert reciever.value == 1;

        reciever.unregister(String.class);
        reciever.publish("Sinobu");
        assert reciever.value == 1;
    }

    @Test
    public void unregisterAll() throws Exception {
        PubSub reciever = new PubSub() {

            @Subscribe
            private void recieve(String name) {
                value++;
            }

            @Subscribe
            private void recieve(int name) {
                value++;
            }
        };

        reciever.publish("Sinobu");
        reciever.publish(1);
        assert reciever.value == 2;

        reciever.unregister();
        reciever.publish("Sinobu");
        assert reciever.value == 2;

        reciever.publish(1);
        assert reciever.value == 2;
    }

    @Test
    public void observe() throws Exception {
        EventEmitter<String> reciever = new EventEmitter();
        Publishable publishable = new Publishable();
        Disposable disposable = publishable.observe(String.class).subscribe(reciever);

        publishable.publish("1");
        assert reciever.retrieve() == "1";

        disposable.dispose();
        publishable.publish("3");
        assert reciever.retrieve() == null;
    }

    @Test
    public void observeMultiple() throws Exception {
        EventEmitter<String> reciever = new EventEmitter();
        Publishable publishable = new Publishable();
        publishable.observe(String.class).subscribe(reciever);
        publishable.observe(String.class).subscribe(reciever);

        publishable.publish("1");
        assert reciever.retrieve() == "1";
    }
}
