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

import static js.lang.Global.*;

import javafx.beans.value.ObservableValue;

import js.dom.Element;
import kiss.Disposable;
import kiss.Events;
import kiss.I;

/**
 * @version 2014/09/05 13:03:04
 */
class VirtualReactiveElement extends VirtualElement implements Disposable {

    /** The binded value. */
    private final Events events;

    /** The disposer. */
    private Disposable disposable;

    /**
     * @param tagName
     */
    public VirtualReactiveElement(int id, String tagName, ObservableValue value) {
        this(id, tagName, I.observe(value));
    }

    /**
     * @param tagName
     */
    public VirtualReactiveElement(int id, String tagName, Events events) {
        super(id, tagName);

        this.events = events;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Element materialize() {
        Element e = document.createElement("span");

        disposable = events.to(v -> {
            e.text(String.valueOf(v));
        });
        return e;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose() {
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
