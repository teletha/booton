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

/**
 * @version 2014/09/10 13:10:45
 */
class VirtualWidget extends VirtualFragment {

    /** The associated widget. */
    final Widget widget;

    /**
     * @param id
     * @param widget
     */
    protected VirtualWidget(int id, Widget widget) {
        super(id);

        this.widget = widget;
    }
}
