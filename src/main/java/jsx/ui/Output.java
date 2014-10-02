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

import javafx.beans.property.StringProperty;

/**
 * @version 2014/08/22 11:27:22
 */
public class Output extends LowLevelElement<Output> {

    /** The text contents. */
    public final StringProperty text;

    /**
     * <p>
     * Create text {@link Output} with the specified value.
     * </p>
     * 
     * @param text
     */
    public Output(StringProperty text) {
        this.text = text;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualize(VirtualStructure $〡) {
        $〡.e("div", 0).〡(text.get());
    }
}
