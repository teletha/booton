/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import static jsx.ui.StructureDSL.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2015/10/05 2:01:20
 */
public class WidgetQuery {

    /**
     * @param widget
     * @param childWidgetType
     * @return
     */
    public static <T extends Widget> List<T> find(Widget widget, Class<T> childWidgetType) {
        VirtualElement root = createWidget(widget.id, widget);

        List<T> list = new ArrayList();
        find(list, childWidgetType, root);

        return list;
    }

    /**
     * <p>
     * Find all child widgets.
     * </p>
     * 
     * @param list
     * @param type
     * @param element
     */
    private static <T extends Widget> void find(List<T> list, Class<T> type, VirtualElement element) {
        if (element instanceof VirtualWidget) {
            Widget widget = ((VirtualWidget) element).widget;

            if (type.isAssignableFrom(widget.getClass())) {
                list.add((T) widget);
            }
        }

        for (int i = 0; i < element.items.length(); i++) {
            VirtualNode child = element.items.get(i);

            if (child instanceof VirtualElement) {
                find(list, type, (VirtualElement) child);
            }
        }
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
