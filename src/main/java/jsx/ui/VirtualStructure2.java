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

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

import jsx.style.Style;

/**
 * @version 2014/12/05 9:13:16
 */
public class VirtualStructure2 {

    /** The node route. */
    private final Deque<VirtualElement> parents = new ArrayDeque();

    /**
     * 
     */
    public VirtualStructure2() {
        this(new VirtualElement(0, "div"));
    }

    /**
     * 
     */
    public VirtualStructure2(VirtualElement root) {
        parents.add(root);
    }

    /**
     * <p>
     * Define children.
     * </p>
     * 
     * @param children A list of child widget.
     */
    public final <T> void e(Style style, Class<? extends Widget1<T>> childType, Collection<T> children) {
        // precess into child widget
        int index = 0;
        Object[] childrenUI = new Object[children.size()];

        for (T child : children) {
            childrenUI[index++] = Widget.of(childType, child);
        }

        element(LocalId.findContextLineNumber(), "div", style, childrenUI);
    }

    public void e(Style style, Runnable children) {
        element(LocalId.findContextLineNumber(), "div", style, children);
    }

    public void e(Style style, Object... children) {
        element(LocalId.findContextLineNumber(), "div", style, children);
    }

    public void element(int id, String name, Style style, Object... children) {
        // create new element
        VirtualElement element = new VirtualElement(id, name);
        element.classList.push(style);

        // make tree
        parents.peekLast().items.push(element);

        // store new parent
        parents.addLast(element);

        for (Object child : children) {
            if (child instanceof Widget) {
                e((Widget) child);
            } else if (child instanceof LowLevelWidget) {

            } else if (child instanceof Runnable) {
                ((Runnable) child).run();
            } else {
                e(String.valueOf(child));
            }
        }

        // restore old parent
        parents.pollLast();
    }

    public void e(Widget child) {
        child.virtualize(this);
    }

    public void e(String child) {
        parents.peekLast().items.push(new VirtualText(child));
    }

    public void asis(Object... children) {
        for (Object child : children) {
            if (child instanceof Widget) {
                ((Widget) child).virtualize(this);
            } else if (child instanceof LowLevelWidget) {

            } else if (child instanceof Runnable) {
                ((Runnable) child).run();
            } else {
                parents.peekLast().items.push(new VirtualText(String.valueOf(child)));
            }
        }
    }

    // public final void e(Object... children) {
    // for (Object child : children) {
    // if (child instanceof Widget) {
    // ((Widget) child).virtualize(this);
    // } else if (child instanceof LowLevelWidget) {
    // e((LowLevelWidget) child);
    // } else if (child instanceof Runnable) {
    // ((Runnable) child).run();
    // } else {
    // parents.peekLast().items.push(new VirtualText(String.valueOf(child)));
    // }
    // }
    // }

    /**
     * <p>
     * Retrieve the root {@link VirtualElement}.
     * </p>
     * 
     * @return A single root element.
     */
    protected final VirtualElement getRoot() {
        return parents.peekLast();
    }
}
