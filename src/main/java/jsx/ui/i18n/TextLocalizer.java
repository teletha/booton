/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.i18n;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;

import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2015/06/10 10:06:48
 */
@Manageable(lifestyle = Singleton.class)
public abstract class TextLocalizer {

    /**
     * <p>
     * Create text expression.
     * </p>
     * 
     * @param texts
     * @return
     */
    protected StringExpression $(Object... texts) {
        StringExpression label = new SimpleStringProperty("");

        for (Object text : texts) {
            label = label.concat(text);
        }
        return label;
    }
}
