/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.stream;

import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/05 16:37:04
 */
@JavaAPIProvider(java.util.stream.StreamSupport.class)
class StreamSupport {

    /**
     * Creates a new sequential or parallel {@code Stream} from a {@code Spliterator}.
     * <p>
     * The spliterator is only traversed, split, or queried for estimated size after the terminal
     * operation of the stream pipeline commences.
     * <p>
     * It is strongly recommended the spliterator report a characteristic of {@code IMMUTABLE} or
     * {@code CONCURRENT}, or be <a href="../Spliterator.html#binding">late-binding</a>. Otherwise,
     * {@link #stream(java.util.function.Supplier, int, boolean)} should be used to reduce the scope
     * of potential interference with the source. See <a
     * href="package-summary.html#Non-Interference">Non-Interference</a> for more details.
     * 
     * @param <T> the type of stream elements
     * @param spliterator a {@code Spliterator} describing the stream elements
     * @param parallel if {@code true} then the returned stream is a parallel stream; if
     *            {@code false} the returned stream is a sequential stream.
     * @return a new sequential or parallel {@code Stream}
     */
    public static <T> Stream<T> stream(Spliterator<T> spliterator, boolean parallel) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Creates a new sequential or parallel {@code Stream} from a {@code Supplier} of
     * {@code Spliterator}.
     * <p>
     * The {@link Supplier#get()} method will be invoked on the supplier no more than once, and only
     * after the terminal operation of the stream pipeline commences.
     * <p>
     * For spliterators that report a characteristic of {@code IMMUTABLE} or {@code CONCURRENT}, or
     * that are <a href="../Spliterator.html#binding">late-binding</a>, it is likely more efficient
     * to use {@link #stream(java.util.Spliterator, boolean)} instead.
     * <p>
     * The use of a {@code Supplier} in this form provides a level of indirection that reduces the
     * scope of potential interference with the source. Since the supplier is only invoked after the
     * terminal operation commences, any modifications to the source up to the start of the terminal
     * operation are reflected in the stream result. See <a
     * href="package-summary.html#Non-Interference">Non-Interference</a> for more details.
     * 
     * @param <T> the type of stream elements
     * @param supplier a {@code Supplier} of a {@code Spliterator}
     * @param characteristics Spliterator characteristics of the supplied {@code Spliterator}. The
     *            characteristics must be equal to {@code supplier.get().characteristics()}.
     * @param parallel if {@code true} then the returned stream is a parallel stream; if
     *            {@code false} the returned stream is a sequential stream.
     * @return a new sequential or parallel {@code Stream}
     * @see #stream(java.util.Spliterator, boolean)
     */
    public static <T> Stream<T> stream(Supplier<? extends Spliterator<T>> supplier, int characteristics, boolean parallel) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Creates a new sequential or parallel {@code IntStream} from a {@code Spliterator.OfInt}.
     * <p>
     * The spliterator is only traversed, split, or queried for estimated size after the terminal
     * operation of the stream pipeline commences.
     * <p>
     * It is strongly recommended the spliterator report a characteristic of {@code IMMUTABLE} or
     * {@code CONCURRENT}, or be <a href="../Spliterator.html#binding">late-binding</a>. Otherwise,
     * {@link #intStream(java.util.function.Supplier, int, boolean)} should be used to reduce the
     * scope of potential interference with the source. See <a
     * href="package-summary.html#Non-Interference">Non-Interference</a> for more details.
     * 
     * @param spliterator a {@code Spliterator.OfInt} describing the stream elements
     * @param parallel if {@code true} then the returned stream is a parallel stream; if
     *            {@code false} the returned stream is a sequential stream.
     * @return a new sequential or parallel {@code IntStream}
     */
    public static IntStream intStream(Spliterator.OfInt spliterator, boolean parallel) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Creates a new sequential or parallel {@code IntStream} from a {@code Supplier} of
     * {@code Spliterator.OfInt}.
     * <p>
     * The {@link Supplier#get()} method will be invoked on the supplier no more than once, and only
     * after the terminal operation of the stream pipeline commences.
     * <p>
     * For spliterators that report a characteristic of {@code IMMUTABLE} or {@code CONCURRENT}, or
     * that are <a href="../Spliterator.html#binding">late-binding</a>, it is likely more efficient
     * to use {@link #intStream(java.util.Spliterator.OfInt, boolean)} instead.
     * <p>
     * The use of a {@code Supplier} in this form provides a level of indirection that reduces the
     * scope of potential interference with the source. Since the supplier is only invoked after the
     * terminal operation commences, any modifications to the source up to the start of the terminal
     * operation are reflected in the stream result. See <a
     * href="package-summary.html#Non-Interference">Non-Interference</a> for more details.
     * 
     * @param supplier a {@code Supplier} of a {@code Spliterator.OfInt}
     * @param characteristics Spliterator characteristics of the supplied {@code Spliterator.OfInt}.
     *            The characteristics must be equal to {@code supplier.get().characteristics()}
     * @param parallel if {@code true} then the returned stream is a parallel stream; if
     *            {@code false} the returned stream is a sequential stream.
     * @return a new sequential or parallel {@code IntStream}
     * @see #intStream(java.util.Spliterator.OfInt, boolean)
     */
    public static IntStream intStream(Supplier<? extends Spliterator.OfInt> supplier, int characteristics, boolean parallel) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
