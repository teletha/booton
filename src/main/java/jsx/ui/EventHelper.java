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

import java.util.function.Predicate;

import kiss.Events;

/**
 * @version 2014/08/21 21:43:04
 */
public class EventHelper {

    /** The reusable function. */
    public static final Predicate<String> Empty = value -> {
        return value.isEmpty();
    };

    /** The reusable function. */
    public static final Predicate<String> NotEmpty = value -> {
        return !value.isEmpty();
    };

    public static final <T> Events<T> which(Events<Boolean> condition, T truePhase, T falsePhase) {
        return null;
    }
}
