/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.collection;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @version 2015/01/14 16:21:46
 */
public class Box<V> {

    public Manipulator<V> filter(Predicate<V> condition) {
        return new Manipulator();
    }

    public void apply(Consumer<V> items) {

    }

    public Box<V> take(Predicate<V> condition) {
        return null;
    }

    public Box<V> skip(Predicate<V> condition) {
        return null;
    }

    /**
     * @version 2015/01/14 16:31:43
     */
    public static class Manipulator<V> {

    }
}
