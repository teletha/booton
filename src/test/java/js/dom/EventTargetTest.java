/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import static js.lang.Global.*;
import jsx.event.Publishable;
import jsx.event.SubscribeUI;
import kiss.I;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2015/01/18 15:03:41
 */
@RunWith(ScriptRunner.class)
public class EventTargetTest {

    static {
        I.load(Publishable.class, true);
    }

    @Test
    public void fromUserAction() throws Exception {
        Listener listener = new Listener();
        assert listener.invoked == 0;

        Element element = document.createElement("div");
        element.subscribe(listener);

        User.click(element);
        assert listener.invoked == 1;

        User.mouseDown(element);
        assert listener.invoked == 1;

        element.unsubscribe(listener);

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
