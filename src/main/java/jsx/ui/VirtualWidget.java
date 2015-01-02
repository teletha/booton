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
    protected Element materializeRoot() {
        Element e = super.materializeRoot();

        if (widget.listeners != null) {
            for (int i = 0, length = widget.listeners.length(); i < length; i++) {
                Listener listener = widget.listeners.get(i);
                e.addEventListener(listener.type.name, listener.dom);
            }
        }

        return e;
    }

}
