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

    /**
     * @param name
     */
    public Output(StringProperty a) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected VirtualElement virtualize() {
        return null;
    }
}
