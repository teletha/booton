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

import java.util.HashMap;
import java.util.Map;

import kiss.Prototype;

/**
 * @version 2014/09/20 16:49:00
 */
class VirtualStructureHierarchy extends Prototype<Widget> {

    /** The hierarchy manager. */
    static final Map<Class, Widget> hierarchy = new HashMap();

    /** The widget class. */
    private final Class widgetClass;

    /**
     * @param modelClass
     */
    protected VirtualStructureHierarchy(Class modelClass) {
        super(modelClass);

        this.widgetClass = modelClass;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Widget get() {
        Widget widget = hierarchy.get(widgetClass);

        if (widget == null) {
            WidgetLog.GetWidget.start();
            widget = super.get();
            WidgetLog.GetWidget.stop();
        }
        return widget;
    }
}
