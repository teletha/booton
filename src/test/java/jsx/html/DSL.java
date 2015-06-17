/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.html;

/**
 * @version 2014/12/02 13:51:27
 */
public class DSL {

    public static void text(String text) {

    }

    public static final DSLElement div() {
        return new DSLElement();
    }
}
