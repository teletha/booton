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

import js.dom.Element.EventListener;
import js.lang.Function;
import jsx.bwt.UIAction;
import jsx.bwt.UIEvent;
import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;

/**
 * @version 2013/07/06 19:46:02
 */
@JavascriptAPIProvider(polyfill = true)
public class MutationObserver implements JavascriptNative {

    private MutationListener listener;

    public MutationObserver(MutationListener listener) {
        this.listener = listener;
    }

    @JavascriptNativeProperty
    public void observe(final Element target, MutationObserverOption option) {
        target.bind(UIAction.DOMNodeInserted, new EventListener() {

            @Override
            public void handleEvent(UIEvent event) {
                if (event.target == target) {
                    System.out.println(event);
                }
            }
        });
    }

    /**
     * @version 2013/07/06 20:02:35
     */
    public static interface MutationListener extends Function {

        void change(MutationRecord[] events);
    }

    /**
     * @version 2013/07/06 20:03:09
     */
    public static class MutationRecord {

    }

    public static class MutationObserverOption implements JavascriptNative {

        @JavascriptNativeProperty
        public boolean attributes = false;

        @JavascriptNativeProperty
        public boolean childList = true;

        @JavascriptNativeProperty
        public boolean subtree = true;
    }
}
