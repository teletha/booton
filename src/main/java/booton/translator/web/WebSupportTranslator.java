/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.web;

import java.io.File;

import booton.translator.Translator;

/**
 * @version 2012/11/29 10:11:38
 */
class WebSupportTranslator extends Translator<File> {

    public String document = "document";

    /**
     * <p>
     * Provide JQuery support.
     * </p>
     * 
     * @param expresion
     * @return
     */
    public String $(String expresion) {
        return "$(" + param(0) + ")";
    }
}
