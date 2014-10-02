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
import java.util.function.Predicate;

import javafx.beans.property.ListProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;

import kiss.I;

/**
 * @version 2014/10/02 12:40:07
 */
public class BindingHelper {

    /**
     * @param list
     * @param object
     * @return
     */
    public static <T> ListProperty<T> filter(ListProperty<T> list, Predicate<T> filter) {
        FilteredList<T> filtered = list.filtered(filter);
        Inspector<T> inspector = new Inspector(filtered);

        for (T item : list) {
            inspector.inspect(item);
        }
        return new SimpleListProperty(filtered);
    }

    /**
     * @version 2014/10/02 12:57:49
     */
    private static class Inspector<T> implements ListChangeListener<T>, ChangeListener<T> {

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
        private Inspector(FilteredList<T> filtered) {
            this.filtered = filtered;
        }

        private void inspect(Object model) {
            try {
                for (Field field : InspectableFields.of(model.getClass())) {
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
            System.out.println("invoke list change");
            refilter();
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
                System.out.println("refilter before size: " + filtered.size());
                refilter.invoke(filtered);
                System.out.println("refilter after size: " + filtered.size());
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
    }

    /**
     * @version 2014/10/02 13:00:58
     */
    private static class InspectableFields {

        /** The cache. */
        private static final Map<Class, InspectableFields> cache = new HashMap();

        /** The field list to inspect. */
        private final List<Field> fields = new ArrayList();

        /**
         * @param type
         */
        private InspectableFields(Class type) {
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
            InspectableFields inspectableFields = cache.get(type);

            if (inspectableFields == null) {
                inspectableFields = new InspectableFields(type);
                cache.put(type, inspectableFields);
            }
            return inspectableFields.fields;
        }
    }
}
