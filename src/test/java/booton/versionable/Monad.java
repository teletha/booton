/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.versionable;

import java.util.function.Function;

/**
 * @version 2014/09/22 17:17:37
 */
public interface Monad<A> {

    public static <T> Monad<T> unit(T value) {
        return null;
    }

    public <B> Monad<B> bind(Monad<A> value, Function<A, Monad<B>> function);

    public <B> Monad<B> flatMap(Function<A, Monad<B>> function);

    public default <B> Monad<B> map(Function<A, B> function) {
        return flatMap(value -> unit(function.apply(value)));
    }
}
