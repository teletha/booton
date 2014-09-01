/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.model;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.SingleSelectionModel;

/**
 * @version 2014/09/01 19:09:20
 */
public class SingleSelectableProperty<T> extends SingleSelectionModel<T> {

    /** The item list. */
    private final List<T> items = new ArrayList();

    /**
     * 
     */
    public SingleSelectableProperty(Enum initialSelection) {
        for (Enum constant : initialSelection.getClass().getEnumConstants()) {
            items.add((T) constant);
        }
        select((T) initialSelection);
    }

    /**
     * 
     */
    public SingleSelectableProperty(Class<? extends Enum> selectionClass) {
        for (Enum constant : selectionClass.getEnumConstants()) {
            items.add((T) constant);
        }
    }

    /**
     * 
     */
    public SingleSelectableProperty(List<T> selections) {
        items.addAll(selections);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int getItemCount() {
        return items.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected T getModelItem(int index) {
        return items.get(index);
    }
}
