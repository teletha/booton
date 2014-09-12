/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.List;

import booton.virtual.Widget;

/**
 * @version 2014/09/02 10:16:32
 */
public class Virtualizer {

    /**
     * @param widget
     * @param childWidgetType
     * @return
     */
    public static <T extends Widget> List<T> find(Widget widget, Class<T> childWidgetType) {
        widget.virtualize();
        return null;
    }

    /**
     * <p>
     * Helper method to materialize first virtual element.
     * </p>
     * 
     * @param widget
     * @param childWidgetType
     * @return
     */
    public static <T extends Widget> T findFirst(Widget widget, Class<T> childWidgetType) {
        List<T> list = find(widget, childWidgetType);
        assert list != null;
        assert list.isEmpty() == false;
        return list.get(0);
    }

    /**
     * <p>
     * Helper method to materialize last virtual element.
     * </p>
     * 
     * @param widget
     * @param childWidgetType
     * @return
     */
    public static <T extends Widget> T findLast(Widget widget, Class<T> childWidgetType) {
        List<T> list = find(widget, childWidgetType);
        assert list != null;
        assert list.isEmpty() == false;
        return list.get(list.size() - 1);
    }
}
