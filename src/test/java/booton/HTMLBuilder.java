/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

/**
 * @version 2014/08/20 16:53:55
 */
public class HTMLBuilder {

    public static void main(String[] args) {

        @Style
        Div root = () -> {
        };
    }

    public static interface Div {

        void child();
    }

    public static void html(Runnable child) {

    }

    /**
     * @version 2014/08/20 16:55:52
     */
    private static @interface Style {

    }
}
