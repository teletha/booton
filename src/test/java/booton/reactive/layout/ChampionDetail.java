/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.layout;

import javafx.beans.property.IntegerProperty;

import booton.reactive.Output;
import booton.reactive.Widget;
import booton.virtual.VirtualStructure;

/**
 * @version 2014/09/10 16:36:48
 */
public class ChampionDetail extends Widget {

    public IntegerProperty level;

    public Icon icon;

    @Override
    protected void virtualize(VirtualStructure box) {

    }

    private class Icon {

        private Output level;
    }
}
