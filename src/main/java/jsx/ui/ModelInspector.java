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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;

import kiss.I;

/**
 * @version 2014/10/02 12:57:49
 */
class ModelInspector<T> implements ListChangeListener<T>, ChangeListener<T> {

    /** The refilter method. */
    private static final Method refilter;

    static {
        try {
            refilter = FilteredList.class.getDeclaredMethod("refilter");
            refilter.setAccessible(true);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /** The filtered list. */
    private final FilteredList<T> filtered;

    /**
     * @param filter
     */
    ModelInspector(FilteredList<T> filtered) {
        this.filtered = filtered;
    }

    void inspect(Object model) {
        try {
            for (Field field : InspectableFieldDefinition.of(model.getClass())) {
                Property property = (Property) field.get(model);

                if (property instanceof ListProperty) {
                    ((ListProperty) property).addListener((ListChangeListener) this);
                } else {
                    property.addListener(this);
                }
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onChanged(Change<? extends T> change) {
        while (change.next()) {
            if (change.wasAdded()) {
                for (T item : change.getAddedSubList()) {
                    inspect(item);
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
        refilter();
    }

    private void refilter() {
        try {
            refilter.invoke(filtered);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2014/10/02 13:00:58
     */
    private static class InspectableFieldDefinition {

        /** The cache. */
        private static final Map<Class, InspectableFieldDefinition> cache = new HashMap();

        /** The field list to inspect. */
        private final List<Field> fields = new ArrayList();

        /**
         * @param type
         */
        private InspectableFieldDefinition(Class type) {
            for (Field field : type.getDeclaredFields()) {
                if (Modifier.isFinal(field.getModifiers()) && Property.class.isAssignableFrom(field.getType())) {
                    fields.add(field);
                }
            }
        }

        /**
         * <p>
         * Find field info to inspect.
         * </p>
         * 
         * @param type A target type.
         * @return A definition of inspection.
         */
        private static List<Field> of(Class type) {
            ModelInspector.InspectableFieldDefinition inspectableFields = cache.get(type);

            if (inspectableFields == null) {
                inspectableFields = new InspectableFieldDefinition(type);
                cache.put(type, inspectableFields);
            }
            return inspectableFields.fields;
        }
    }
}