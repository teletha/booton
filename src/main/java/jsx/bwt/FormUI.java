/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static js.dom.UIAction.*;
import js.dom.Element;
import js.dom.EventListener;
import js.dom.UIAction;
import jsx.bwt.FormUIStyle.Disable;
import jsx.bwt.FormUIStyle.Focus;
import jsx.bwt.FormUIStyle.FormRoot;
import jsx.event.SubscribeUI;

/**
 * @version 2013/07/29 2:08:45
 */
public class FormUI<T extends FormUI> extends UI {

    /** The event types. */
    private static final UIAction[] Actions = {Click, ClickRight, MouseDoubleClick, PointerOver, PointerOut,
            PointerMove};

    /** The event disabler. */
    private static final EventListener Disabler = event -> {
        event.stopImmediatePropagation();
    };

    /** The actual form element. */
    public final Element form;

    /** The enable flag. */
    private boolean enable = true;

    /**
     * 
     */
    public FormUI() {
        this("input");
    }

    /**
     * 
     */
    public FormUI(String elementName) {
        root.add(FormRoot.class);

        form = root.child(elementName);
        form.bind(this);
    }

    /**
     * <p>
     * Make this form disabled.
     * </p>
     * 
     * @return
     */
    public T disable() {
        enable = false;
        root.add(Disable.class);
        root.on(Actions, Disabler);
        form.attr("disabled", "true");

        return (T) this;
    }

    /**
     * <p>
     * Make this form disabled.
     * </p>
     * 
     * @return
     */
    public T enable() {
        enable = true;
        root.remove(Disable.class);
        root.off(Actions, Disabler);
        form.remove("disabled");

        return (T) this;
    }

    @SubscribeUI(type = UIAction.Focus)
    private void startInput() {
        root.add(Focus.class);
    }

    @SubscribeUI(type = UIAction.Blur)
    private void endInput() {
        root.remove(Focus.class);
    }

    /**
     * <p>
     * Focus this form.
     * </p>
     */
    public void focus() {
    }
}
