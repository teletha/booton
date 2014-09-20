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

import java.util.ArrayList;
import java.util.List;

import js.dom.Node;

/**
 * @version 2014/09/02 10:16:32
 */
public class UIQuery {

    /**
     * @param widget
     * @param childWidgetType
     * @return
     */
    public static <T extends Widget> List<T> find(Widget widget, Class<T> childWidgetType) {
        StructureAwareLifestyle.hierarchy.push(widget.getClass(), widget);
        StructureDSL structure = new StructureDSL();
        widget.virtualize(structure);
        VirtualElement root = structure.getRoot();
        StructureAwareLifestyle.hierarchy.pull(widget.getClass(), widget);

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
     * @param fragment
     */
    private static <T extends Widget> void find(List<T> list, Class<T> type, VirtualFragment<? extends Node> fragment) {
        if (fragment instanceof VirtualWidget) {
            Widget widget = ((VirtualWidget) fragment).widget;

            if (type.isAssignableFrom(widget.getClass())) {
                list.add((T) widget);
            }
        }

        for (int i = 0; i < fragment.items.length(); i++) {
            VirtualNode child = fragment.items.get(i);

            if (child instanceof VirtualFragment) {
                find(list, type, (VirtualFragment) child);
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
