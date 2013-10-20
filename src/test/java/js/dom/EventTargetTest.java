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
import js.dom.event.Click;
import js.dom.event.MouseOver;
import jsx.Subscribable;
import jsx.bwt.UIEvent;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

/**
 * @version 2013/10/18 12:37:54
 */
@RunWith(ScriptRunner.class)
public class EventTargetTest {

    @Test
    public void fromAPI() throws Exception {
        Listener listener = new Listener();
        assert listener.invoked == 0;

        Element element = document.createElement("div");
        element.register(listener);

        element.publish(new Click());
        assert listener.invoked == 1;

        element.publish(new MouseOver());
        assert listener.invoked == 1;

        element.unregister(listener);

        element.publish(new Click());
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

        element.publish(new MouseOver());
        assert listener.invoked == 1;

        element.unregister(listener);

        element.publish(new Click());
        assert listener.invoked == 1;
    }

    /**
     * <p>
     * Helper method to create click event.
     * </p>
     * 
     * @return
     */
    private UIEvent click() {
        UIEvent event = new UIEvent();
        event.type = "click";

        return event;
    }

    /**
     * <p>
     * Helper method to create mousedown event.
     * </p>
     * 
     * @return
     */
    private UIEvent mousedown() {
        UIEvent event = new UIEvent();
        event.type = "mousedown";

        return event;
    }

    /**
     * @version 2013/10/18 12:39:19
     */
    private static class Listener {

        private int invoked = 0;

        @Subscribable
        private void click(Click event) {
            invoked++;
        }
    }
}
