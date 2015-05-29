/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

/**
 * @version 2015/01/20 11:11:42
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
}
