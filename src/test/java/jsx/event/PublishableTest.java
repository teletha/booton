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

import jsx.bwt.UIAction;
import jsx.bwt.UIEvent;
import kiss.Disposable;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.Async;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/12/12 15:59:17
 */
@RunWith(ScriptRunner.class)
public class PublishableTest {

    /**
     * @version 2013/12/11 10:07:25
     */
    private static class EventHub extends Publishable {
    }

    @Test
    public void subscribe() throws Exception {
        EventHub eventhub = new EventHub();

        Single reciever = new Single();
        eventhub.register(reciever);
        assert reciever.name == null;

        eventhub.publish("Nadeko");
        assert reciever.name.equals("Nadeko");

        eventhub.publish("Tubasa");
        assert reciever.name.equals("Tubasa");
    }

    @Test
    public void unsubscribe() throws Exception {
        EventHub eventhub = new EventHub();

        Single reciever = new Single();
        eventhub.register(reciever);
        assert reciever.name == null;

        eventhub.publish("Nadeko");
        assert reciever.name.equals("Nadeko");

        eventhub.unregister(reciever);
        eventhub.publish("Tubasa");
        assert reciever.name.equals("Nadeko");
    }

    /**
     * @version 2013/12/11 9:48:31
     */
    private static class Single {

        private String name;

        @Subscribe
        private void recieve(String name) {
            this.name = name;
        }
    }

    @Test
    public void multipleSameTypes() throws Exception {
        EventHub eventhub = new EventHub();

        MultipleSameType reciever = new MultipleSameType();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish("Sinobu");
        assert reciever.count == 2;
    }

    /**
     * @version 2013/12/11 9:48:31
     */
    private static class MultipleSameType {

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

    @Test
    public void primitive() throws Exception {
        EventHub eventhub = new EventHub();

        Primitive reciever = new Primitive();
        eventhub.register(reciever);
        assert reciever.value == 0;

        eventhub.publish(2);
        assert reciever.value == 2;

        eventhub.publish(Integer.valueOf(10));
        assert reciever.value == 10;
    }

    /**
     * @version 2013/12/11 10:07:32
     */
    private static class Primitive {

        private int value;

        @Subscribe
        private void recieve(int value) {
            this.value = value;
        }
    }

    @Test
    public void wrapper() throws Exception {
        EventHub eventhub = new EventHub();

        Wrapper reciever = new Wrapper();
        eventhub.register(reciever);
        assert reciever.value == 0;

        eventhub.publish(Integer.valueOf(10));
        assert reciever.value == 10;

        eventhub.publish(2);
        assert reciever.value == 2;
    }

    /**
     * @version 2013/12/11 10:07:32
     */
    private static class Wrapper {

        private int value;

        @Subscribe
        private void recieve(Integer value) {
            this.value = value;
        }
    }

    @Test
    public void methods() throws Exception {
        EventHub eventhub = new EventHub();

        Methods reciever = new Methods();
        eventhub.register(reciever);

        eventhub.publish("Hitagi");
        assert reciever.name.equals("Hitagi");

        eventhub.publish(2);
        assert reciever.value == 2;
    }

    /**
     * @version 2013/12/11 10:07:30
     */
    private static class Methods {

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

    @Test
    public void noParam() throws Exception {
        EventHub eventhub = new EventHub();

        NoParam reciever = new NoParam();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish("Hitagi");
        assert reciever.count == 1;
    }

    /**
     * @version 2013/12/11 9:48:31
     */
    private static class NoParam {

        private int count;

        @Subscribe(String.class)
        private void recieve() {
            this.count++;
        }
    }

    @Test
    public void subscribes() throws Exception {
        EventHub eventhub = new EventHub();

        MultipleSubscribers reciever = new MultipleSubscribers();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish("Hitagi");
        assert reciever.count == 1;

        eventhub.publish(17);
        assert reciever.count == 2;

        eventhub.publish(new IllegalStateException());
        assert reciever.count == 2;
    }

    /**
     * @version 2013/12/11 10:07:30
     */
    private static class MultipleSubscribers {

        private int count;

        @Subscribe(int.class)
        @Subscribe(String.class)
        private void recieve() {
            this.count++;
        }
    }

    @Test
    public void hierarchy() throws Exception {
        EventHub eventhub = new EventHub();

        Hierarchy reciever = new Hierarchy();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish("string and char sequence");
        assert reciever.count == 2;

        eventhub.publish(new StringBuilder("not string"));
        assert reciever.count == 3;
    }

    /**
     * @version 2013/12/11 10:09:23
     */
    private static class Hierarchy {

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

    @Test
    public void count() throws Exception {
        EventHub eventhub = new EventHub();

        Count reciever = new Count();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish("Hitagi");
        assert reciever.count == 1;

        eventhub.publish("Nadeko");
        assert reciever.count == 2;

        eventhub.publish("Suruga");
        assert reciever.count == 2;
    }

    /**
     * @version 2013/12/12 15:59:21
     */
    private static class Count {

        private int count;

        @Subscribe(count = 2)
        private void string(String name) {
            this.count++;
        }
    }

    /**
     * @version 2013/12/18 9:37:44
     */
    private static class TimeEvent {

        private final int value;

        /**
         * @param value
         */
        private TimeEvent() {
            this(0);
        }

        /**
         * @param value
         */
        private TimeEvent(int value) {
            this.value = value;
        }
    }

    @Test
    public void throttle() throws Exception {
        EventHub eventhub = new EventHub();

        Throttle reciever = new Throttle();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish(new TimeEvent());
        assert reciever.count == 1;

        eventhub.publish(new TimeEvent());
        eventhub.publish(new TimeEvent());
        eventhub.publish(new TimeEvent());
        assert reciever.count == 1;

        Async.wait(80);
        eventhub.publish(new TimeEvent());
        assert reciever.count == 2;
    }

    /**
     * @version 2013/12/12 15:59:21
     */
    private static class Throttle {

        private int count;

        @Subscribe(throttle = 50)
        private void string(TimeEvent event) {
            this.count++;
        }
    }

    @Test
    public void debounce() throws Exception {
        EventHub eventhub = new EventHub();

        Debounce reciever = new Debounce();
        eventhub.register(reciever);
        assert reciever.value == 0;

        eventhub.publish(new TimeEvent(10));
        eventhub.publish(new TimeEvent(20));
        eventhub.publish(new TimeEvent(30));
        assert reciever.value == 0;

        Async.awaitTasks();
        assert reciever.value == 30;
    }

    /**
     * @version 2013/12/12 15:59:21
     */
    private static class Debounce {

        private int value;

        @Subscribe(debounce = 50)
        private void time(TimeEvent event) {
            this.value = event.value;
        }
    }

    @Test
    public void delay() throws Exception {
        EventHub eventhub = new EventHub();

        Delay reciever = new Delay();
        eventhub.register(reciever);
        assert reciever.value == 0;

        eventhub.publish(new TimeEvent(10));
        eventhub.publish(new TimeEvent(20));
        eventhub.publish(new TimeEvent(30));
        assert reciever.value == 0;

        Async.awaitTasks();
        assert reciever.value == 60;
    }

    /**
     * @version 2013/12/12 15:59:21
     */
    private static class Delay {

        private int value;

        @Subscribe(delay = 50)
        private void time(TimeEvent event) {
            this.value += event.value;
        }
    }

    @Test
    public void key() throws Exception {
        EventHub eventhub = new EventHub();

        Space reciever = new Space();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish(press(UIAction.Key_Space));
        assert reciever.count == 1;

        eventhub.publish(press(UIAction.Key_A));
        eventhub.publish(press(UIAction.Key_Enter));
        assert reciever.count == 1;
    }

    private static UIEvent press(UIAction action) {
        UIEvent event = new UIEvent();
        event.type = action.name;
        event.action = action;
        event.which = action.code;

        return event;
    }

    /**
     * @version 2013/12/18 10:04:53
     */
    private static class Space {

        private int count;

        @SubscribeUI(type = UIAction.Key_Space)
        private void detect() {
            this.count++;
        }

        @SubscribeUI(type = UIAction.Key_F1)
        private void detect2() {
            this.count++;
        }
    }

    @Test
    public void abort() throws Exception {
        EventHub eventhub = new EventHub();

        Abort reciever = new Abort();
        eventhub.register(reciever);
        assert reciever.count == 0;
        assert reciever.disposed == false;

        eventhub.publish(reciever);
        assert reciever.count == 1;
        assert reciever.disposed == true;
    }

    /**
     * @version 2013/12/18 10:10:09
     */
    private static class Abort implements Disposable {

        private int count;

        private boolean disposed;

        @Subscribe(abort = true)
        private void string(Abort event) {
            count++;
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
    public void duplicate() throws Exception {
        EventHub eventhub = new EventHub();

        Duplicate reciever = new Duplicate();
        eventhub.register(reciever);
        eventhub.register(reciever);

        eventhub.publish("Sinobu");
        assert reciever.count == 1;
    }

    /**
     * @version 2013/12/11 9:48:31
     */
    private static class Duplicate {

        private int count;

        @Subscribe
        private void recieve(String name) {
            count++;
        }
    }

    @Test
    public void event() throws Exception {
        EventLog eventLog = new EventLog();
        assert eventLog.starts.isEmpty();
        assert eventLog.stops.isEmpty();

        Single reciever = new Single();
        eventLog.register(reciever);
        assert eventLog.starts.contains(Object.class);
        assert eventLog.starts.contains(String.class);
        assert eventLog.stops.isEmpty();

        eventLog.unregister(reciever);
        assert eventLog.stops.contains(Object.class);
        assert eventLog.stops.contains(String.class);
    }

    /**
     * @version 2013/12/18 12:51:34
     */
    private static class EventLog extends Publishable {

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
    }

    @Test
    public void subscribeUI() throws Exception {
        EventHub eventhub = new EventHub();

        ClickLisnter reciever = new ClickLisnter();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish(click());
        assert reciever.count == 1;

        eventhub.publish(focus());
        assert reciever.count == 1;
    }

    /**
     * @version 2013/12/18 15:21:06
     */
    private static class ClickLisnter {

        private int count;

        @SubscribeUI(type = UIAction.Click)
        private void action() {
            count++;
        }
    }

    private static UIEvent click() {
        UIEvent event = new UIEvent();
        event.type = "click";
        event.action = UIAction.Click;

        return event;
    }

    private static UIEvent focus() {
        UIEvent event = new UIEvent();
        event.type = "focus";
        event.action = UIAction.Focus;

        return event;
    }

    @Test
    public void subscribeUIWithEvent() throws Exception {
        EventHub eventhub = new EventHub();

        ClickLisnterWithEvent reciever = new ClickLisnterWithEvent();
        eventhub.register(reciever);
        assert reciever.count == 0;

        eventhub.publish(click());
        assert reciever.count == 1;

        eventhub.publish(focus());
        assert reciever.count == 1;
    }

    /**
     * @version 2013/12/18 15:21:06
     */
    private static class ClickLisnterWithEvent {

        private int count;

        @SubscribeUI(type = UIAction.Click)
        private void action(UIEvent event) {
            count++;
        }
    }
}
