/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/07 22:37:30
 */
@JavaAPIProvider(java.lang.Iterable.class)
@FunctionalInterface
public interface Iterable<T> {

    /**
     * Returns an iterator over elements of type {@code T}.
     * 
     * @return an Iterator.
     */
    Iterator<T> iterator();

    /**
     * Performs the given action on the contents of the {@code Iterable}, in the order elements
     * occur when iterating, until all elements have been processed or the action throws an
     * exception. Errors or runtime exceptions thrown by the action are relayed to the caller.
     * 
     * @implSpec <p>
     *           The default implementation behaves as if:
     * 
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);

        for (T t : (java.lang.Iterable<T>) (Object) this) {
            action.accept(t);
        }
    }

    /**
     * Creates a {@link Spliterator} over the elements described by this {@code Iterable}.
     * 
     * @implSpec The default implementation creates an
     *           <em><a href="Spliterator.html#binding">early-binding</a></em> spliterator from the
     *           iterable's {@code Iterator}. The spliterator inherits the <em>fail-fast</em>
     *           properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden. The spliterator returned
     *           by the default implementation has poor splitting capabilities, is unsized, and does
     *           not report any spliterator characteristics. Implementing classes can nearly always
     *           provide a better implementation.
     * @return a {@code Spliterator} over the elements described by this {@code Iterable}.
     * @since 1.8
     */
    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}
