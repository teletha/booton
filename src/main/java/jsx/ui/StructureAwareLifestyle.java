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

import kiss.Prototype;
import kiss.Table;

/**
 * @version 2014/09/20 16:49:00
 */
class StructureAwareLifestyle extends Prototype<Widget> {

    static Table<Class, Widget> hierarchy = new Table();

    /**
     * @param modelClass
     */
    protected StructureAwareLifestyle(Class modelClass) {
        super(modelClass);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Widget get() {
        Widget widget = hierarchy.find(instantiator.getDeclaringClass());

        if (widget == null) {
            widget = super.get();
        }
        return widget;
    }
}
