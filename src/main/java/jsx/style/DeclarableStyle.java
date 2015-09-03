/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

import jsx.html.Declarable;

/**
 * @version 2015/09/04 2:22:38
 */
public interface DeclarableStyle extends Declarable {

    /**
     * {@inheritDoc}
     */
    @Override
    default void declare() {
        StyleRule style = new StyleRule();

        // swap context rule and execute it
        PropertyDefinition.declarable = style;
        style();
        PropertyDefinition.declarable = null;
    }

    void style();
}
