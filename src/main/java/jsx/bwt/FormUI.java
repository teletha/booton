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
import js.dom.UIAction;
import jsx.bwt.FormUIStyle.Disable;
import jsx.bwt.FormUIStyle.Focus;
import jsx.bwt.FormUIStyle.FormRoot;
import jsx.event.SubscribeUI;
import kiss.Disposable;

/**
 * @version 2013/07/29 2:08:45
 */
public class FormUI<T extends FormUI> extends UI<T> {

    /** The actual form element. */
    public final Element form;

    /** The enable flag. */
    private boolean enable = true;

    /** The enable supporter. */
    private Disposable disabler;

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
        form.subscribe(this);
    }

    /**
     * <p>
     * Make this form disabled.
     * </p>
     * 
     * @return
     */
    public T disable() {
        if (enable) {
            enable = false;
            root.add(Disable.class);
            form.attr("disabled", "true");
            disabler = root.observe(Click, ClickRight, MouseDoubleClick, PointerOver, PointerOut, PointerMove)
                    .subscribe(event -> {
                        event.stopImmediatePropagation();
                    });
        }

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
        if (!enable) {
            enable = true;
            root.remove(Disable.class);
            form.remove("disabled");
            disabler.dispose();
            disabler = null;
        }

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
