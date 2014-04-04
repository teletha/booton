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

import java.util.Objects;

import kiss.model.Model;
import kiss.model.Property;

/**
 * @version 2013/10/13 11:18:42
 */
public class BindableInput<M> extends FormUI {

    /**
     * <p>
     * Binding property.
     * </p>
     * 
     * @param instance
     */
    @Bind
    protected void bind(M instance, String path) {
        Objects.requireNonNull(instance);
        Objects.requireNonNull(path);

        Model model = Model.load(instance.getClass());
        Property property = model.getProperty(path);

        if (property == null) {
            throw new IllegalArgumentException("'" + path + "' is not property for [" + model.type + "].");
        }
        form.val(model.get(instance, property));
    }
}
