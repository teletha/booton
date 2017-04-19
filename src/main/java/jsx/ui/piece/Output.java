/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import jsx.style.StyleDSL;
import jsx.ui.LowLevelWidget;
import jsx.ui.StructureDSL;
import kiss.Variable;

/**
 * @version 2017/04/19 11:33:26
 */
public class Output extends LowLevelWidget<StyleDSL, Output> {

    /** The text contents. */
    public final Variable<String> text;

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    Output(Variable<String> text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize() {
        new StructureDSL() {
            {
                text(text.get());
            }
        };
    }
}
