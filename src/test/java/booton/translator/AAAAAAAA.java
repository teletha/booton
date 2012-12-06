/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

/**
 * @version 2012/12/06 16:29:11
 */
public class AAAAAAAA {

    public String name = "AAA";

    public String act = "act";

    public static class B extends AAAAAAAA {

        public String name = "B";
    }

    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.act);
        b.name = "a";
    }
}
