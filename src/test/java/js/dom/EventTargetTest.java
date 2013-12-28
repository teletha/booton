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

import static js.lang.Global.*;
import jsx.event.SubscribeUI;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/18 12:37:54
 */
@RunWith(ScriptRunner.class)
public class EventTargetTest {

    private UIEvent event(UIAction action) {
        UIEvent event = new UIEvent();
        event.action = action;

        return event;
    }

    @Test
    public void fromAPI() throws Exception {
        Listener listener = new Listener();
        assert listener.invoked == 0;

        Element element = document.createElement("div");
        element.register(listener);

        element.publish(event(UIAction.Click));
        assert listener.invoked == 1;

        element.publish(event(UIAction.MouseMove));
        assert listener.invoked == 1;

        element.unregister(listener);

        element.publish(event(UIAction.Click));
        assert listener.invoked == 1;
    }

    @Test
    public void fromUserAction() throws Exception {
        Listener listener = new Listener();
        assert listener.invoked == 0;

        Element element = document.createElement("div");
        element.register(listener);

        User.click(element);
        assert listener.invoked == 1;

        User.mouseDown(element);
        assert listener.invoked == 1;

        element.unregister(listener);

        User.click(element);
        assert listener.invoked == 1;
    }

    /**
     * @version 2013/10/18 12:39:19
     */
    private static class Listener {

        private int invoked = 0;

        @SubscribeUI(type = UIAction.Click)
        private void click() {
            invoked++;
        }
    }
}
