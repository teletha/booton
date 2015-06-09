/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;

/**
 * @version 2015/06/09 16:52:21
 */
public final class TextHelper {

    /**
     * <p>
     * Create text expression.
     * </p>
     * 
     * @param texts
     * @return
     */
    public static StringExpression $(Object... texts) {
        StringExpression label = new SimpleStringProperty("");

        for (Object text : texts) {
            label = label.concat(text);
        }
        return label;
    }
}
