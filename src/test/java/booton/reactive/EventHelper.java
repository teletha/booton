/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.function.Predicate;

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
}
