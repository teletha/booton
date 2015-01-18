/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import js.dom.Element;
import jsx.ui.Widget.Listener;

/**
 * @version 2014/09/10 13:10:45
 */
class VirtualWidget extends VirtualElement {

    /** The associated widget. */
    final Widget widget;

    /**
     * @param id
     * @param widget
     */
    protected VirtualWidget(int id, Widget widget) {
        super(id, "widget");

        this.widget = widget;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Element materialize() {
        Element e = super.materialize();

        if (widget.listeners != null) {
            // search only child
            if (items.length() == 1) {
                e = e.firstElementChild();
            }

            for (int i = 0, length = widget.listeners.length(); i < length; i++) {
                Listener listener = widget.listeners.get(i);
                e.addEventListener(listener.type.name, listener.dom);
            }
        }

        return e;
    }

}
