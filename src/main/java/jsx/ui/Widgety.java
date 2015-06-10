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

import jsx.ui.i18n.TextLocalizer;
import kiss.I;
import kiss.model.ClassUtil;

/**
 * @version 2015/06/10 10:11:12
 */
public abstract class Widgety<M, Text extends TextLocalizer> extends Widget1<M> {

    /** The localized ui text. */
    protected final Text text;

    /**
     * 
     */
    protected Widgety() {
        Class[] parameters = ClassUtil.getParameter(getClass(), Widgety.class);

        this.text = (Text) I.i18n(parameters[1]);
    }
}
