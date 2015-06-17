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

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @version 2014/10/10 9:28:00
 */
public class FunctionHelper {

    /** The reusable function. */
    public static final Predicate<String> Empty = value -> {
        return value.isEmpty();
    };

    /** The reusable function. */
    public static final Predicate<String> NotEmpty = value -> {
        return !value.isEmpty();
    };

    /**
     * <p>
     * Partial apply.
     * </p>
     * 
     * @param consumer
     * @param param
     * @return
     */
    public static <P> Runnable $(Consumer<P> consumer, P param) {
        return () -> {
            consumer.accept(param);
        };
    }

    public static <T> Predicate not(Predicate<T> predicate) {
        return predicate.negate();
    }
}
