/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.view;

import js.util.jQuery;
import js.util.jQuery.Listener;
import jsx.bwt.UI;
import jsx.bwt.UIEvent;
import jsx.bwt.view.PopupViewStyle.Root;

/**
 * @version 2013/06/09 18:45:21
 */
public abstract class Popup extends UI {

    /** The root element. */
    private jQuery root;

    /** The popup element. */
    private jQuery popup;

    public Popup(jQuery parent) {
        root = parent.css("position", "relative");

        parent.mouseenter(new Listener() {

            @Override
            public void handler(UIEvent event) {
                popup = root.child(Root.class);
                show(popup);
            }
        }).mouseleave(new Listener() {

            @Override
            public void handler(UIEvent event) {
                popup.remove();
                popup = null;
            }
        });

    }

    protected abstract void show(jQuery root);
}
