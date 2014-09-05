/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import static js.lang.Global.*;

import javafx.beans.value.ObservableValue;

import js.dom.Element;
import js.dom.Node;
import kiss.Disposable;
import kiss.Events;
import kiss.I;

/**
 * @version 2014/09/05 13:03:04
 */
public class VirtualReactiveElement extends VirtualElement implements Disposable {

    /** The binded value. */
    private final Events events;

    /** The disposer. */
    private Disposable disposable;

    /**
     * @param tagName
     */
    public VirtualReactiveElement(String tagName, ObservableValue value) {
        this(tagName, I.observe(value));
    }

    /**
     * @param tagName
     */
    public VirtualReactiveElement(String tagName, Events events) {
        super(tagName);

        this.events = events;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Node createNode() {
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
