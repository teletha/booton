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

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.junit.Test;

/**
 * @version 2014/10/06 23:29:29
 */
public class VirtualStructureReferenceTest {

    @Test
    public void testname() throws Exception {
        VirtualElement base = new VirtualElement(0, "div");

        Widget1 widget = Widget.of(Widget1.class);
        VirtualElement previous = virtualize(widget);

        List<Patch> diff = Diff.diff(base, previous);

        // widget.property.set("change");
        // VirtualElement next = virtualize(widget);

    }

    /**
     * @version 2014/10/06 23:42:12
     */
    private static class Widget1 extends Widget {

        private StringProperty property = new SimpleStringProperty("base");

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.asis.〡(property);
        }
    }

    private VirtualElement virtualize(Widget widget) {
        VirtualStructure structure = new VirtualStructure();
        widget.virtualize(structure);

        return structure.getRoot();
    }
}
