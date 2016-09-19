/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import booton.translator.JavascriptAPIProvider;

/**
 * @version 2013/07/01 12:01:48
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "Text")
public abstract class Text extends Node<Text> {

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract String textContent();

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void textContent(String textContent);
}
