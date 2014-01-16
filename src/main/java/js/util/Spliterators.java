/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import booton.JDKEmulator;
import booton.translator.JavaAPIProvider;

/**
 * @version 2014/01/16 16:26:21
 */
class Spliterators {

    /**
     * @version 2014/01/16 16:28:45
     */
    @JavaAPIProvider(JDKEmulator.class)
    private static class IteratorSpliterator<T> implements Spliterator<T> {

        static final int BATCH_UNIT = 1 << 10; // batch array size increment

        static final int MAX_BATCH = 1 << 25; // max batch array size;

        private final Collection<? extends T> collection; // null OK

        private Iterator<? extends T> it;

        private final int characteristics;

        private long est; // size estimate

        private int batch; // batch size for splits

/**
         * Creates a spliterator using the given given
         * collection's {@link java.util.Collection#iterator()) for traversal,
         * and reporting its {@link java.util.Collection#size()) as its initial
         * size.
         *
         * @param c the collection
         * @param characteristics properties of this spliterator's
         *        source or elements.
         */
        public IteratorSpliterator(Collection<? extends T> collection, int characteristics) {
            this.collection = collection;
            this.it = null;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0 ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                    : characteristics;
        }

        /**
         * Creates a spliterator using the given iterator for traversal, and reporting the given
         * initial size and characteristics.
         * 
         * @param iterator the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public IteratorSpliterator(Iterator<? extends T> iterator, long size, int characteristics) {
            this.collection = null;
            this.it = iterator;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0 ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                    : characteristics;
        }

        /**
         * Creates a spliterator using the given iterator for traversal, and reporting the given
         * initial size and characteristics.
         * 
         * @param iterator the iterator for the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public IteratorSpliterator(Iterator<? extends T> iterator, int characteristics) {
            this.collection = null;
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
        }

        @Override
        public Spliterator<T> trySplit() {
            /*
             * Split into arrays of arithmetically increasing batch sizes. This will only improve
             * parallel performance if per-element Consumer actions are more costly than
             * transferring them into an array. The use of an arithmetic progression in split sizes
             * provides overhead vs parallelism bounds that do not particularly favor or penalize
             * cases of lightweight vs heavyweight element operations, across combinations of
             * #elements vs #cores, whether or not either are known. We generate O(sqrt(#elements))
             * splits, allowing O(sqrt(#cores)) potential speedup.
             */
            Iterator<? extends T> i;
            long s;
            if ((i = it) == null) {
                i = it = collection.iterator();
                s = est = (long) collection.size();
            } else
                s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s) n = (int) s;
                if (n > MAX_BATCH) n = MAX_BATCH;
                Object[] a = new Object[n];
                int j = 0;
                a[j] = i.next();

                while (++j < n && i.hasNext()) {
                    a[j] = i.next();
                }
                batch = j;
                if (est != Long.MAX_VALUE) est -= j;
                // return new ArraySpliterator(a, 0, j, characteristics);
                throw new Error();
            }
            return null;
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            if (action == null) throw new NullPointerException();
            Iterator<? extends T> i;
            if ((i = it) == null) {
                i = it = collection.iterator();
                est = (long) collection.size();
            }
            i.forEachRemaining(action);
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            if (action == null) throw new NullPointerException();
            if (it == null) {
                it = collection.iterator();
                est = (long) collection.size();
            }
            if (it.hasNext()) {
                action.accept(it.next());
                return true;
            }
            return false;
        }

        @Override
        public long estimateSize() {
            if (it == null) {
                it = collection.iterator();
                return est = (long) collection.size();
            }
            return est;
        }

        @Override
        public int characteristics() {
            return characteristics;
        }

        @Override
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }

    /**
     * A Spliterator.OfInt using a given IntStream.IntIterator for element operations. The
     * spliterator implements {@code trySplit} to permit limited parallelism.
     */
    @JavaAPIProvider(JDKEmulator.class)
    static final class IntIteratorSpliterator implements Spliterator.OfInt {

        static final int BATCH_UNIT = IteratorSpliterator.BATCH_UNIT;

        static final int MAX_BATCH = IteratorSpliterator.MAX_BATCH;

        private PrimitiveIterator.OfInt it;

        private final int characteristics;

        private long est; // size estimate

        private int batch; // batch size for splits

        /**
         * Creates a spliterator using the given iterator for traversal, and reporting the given
         * initial size and characteristics.
         * 
         * @param iterator the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public IntIteratorSpliterator(PrimitiveIterator.OfInt iterator, long size, int characteristics) {
            this.it = iterator;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0 ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                    : characteristics;
        }

        /**
         * Creates a spliterator using the given iterator for a source of unknown size, reporting
         * the given characteristics.
         * 
         * @param iterator the iterator for the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public IntIteratorSpliterator(PrimitiveIterator.OfInt iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
        }

        @Override
        public OfInt trySplit() {
            PrimitiveIterator.OfInt i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s) n = (int) s;
                if (n > MAX_BATCH) n = MAX_BATCH;
                int[] a = new int[n];
                int j = 0;
                a[j] = i.nextInt();

                while (++j < n && i.hasNext()) {
                    a[j] = i.nextInt();
                }

                batch = j;
                if (est != Long.MAX_VALUE) est -= j;
                // return new IntArraySpliterator(a, 0, j, characteristics);

                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error();
            }
            return null;
        }

        @Override
        public void forEachRemaining(IntConsumer action) {
            if (action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }

        @Override
        public boolean tryAdvance(IntConsumer action) {
            if (action == null) throw new NullPointerException();
            if (it.hasNext()) {
                action.accept(it.nextInt());
                return true;
            }
            return false;
        }

        @Override
        public long estimateSize() {
            return est;
        }

        @Override
        public int characteristics() {
            return characteristics;
        }

        @Override
        public Comparator<? super Integer> getComparator() {
            if (hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }

    /**
     * @version 2014/01/16 16:32:53
     */
    @JavaAPIProvider(JDKEmulator.class)
    static final class LongIteratorSpliterator implements Spliterator.OfLong {

        static final int BATCH_UNIT = IteratorSpliterator.BATCH_UNIT;

        static final int MAX_BATCH = IteratorSpliterator.MAX_BATCH;

        private PrimitiveIterator.OfLong it;

        private final int characteristics;

        private long est; // size estimate

        private int batch; // batch size for splits

        /**
         * Creates a spliterator using the given iterator for traversal, and reporting the given
         * initial size and characteristics.
         * 
         * @param iterator the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public LongIteratorSpliterator(PrimitiveIterator.OfLong iterator, long size, int characteristics) {
            this.it = iterator;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0 ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                    : characteristics;
        }

        /**
         * Creates a spliterator using the given iterator for a source of unknown size, reporting
         * the given characteristics.
         * 
         * @param iterator the iterator for the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public LongIteratorSpliterator(PrimitiveIterator.OfLong iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
        }

        @Override
        public OfLong trySplit() {
            PrimitiveIterator.OfLong i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s) n = (int) s;
                if (n > MAX_BATCH) n = MAX_BATCH;
                long[] a = new long[n];
                int j = 0;
                a[j] = i.nextLong();

                while (++j < n && i.hasNext()) {
                    a[j] = i.nextLong();
                }
                batch = j;
                if (est != Long.MAX_VALUE) est -= j;
                // return new LongArraySpliterator(a, 0, j, characteristics);

                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error();
            }
            return null;
        }

        @Override
        public void forEachRemaining(LongConsumer action) {
            if (action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }

        @Override
        public boolean tryAdvance(LongConsumer action) {
            if (action == null) throw new NullPointerException();
            if (it.hasNext()) {
                action.accept(it.nextLong());
                return true;
            }
            return false;
        }

        @Override
        public long estimateSize() {
            return est;
        }

        @Override
        public int characteristics() {
            return characteristics;
        }

        @Override
        public Comparator<? super Long> getComparator() {
            if (hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }

    /**
     * @version 2014/01/16 16:33:57
     */
    @JavaAPIProvider(JDKEmulator.class)
    static final class DoubleIteratorSpliterator implements Spliterator.OfDouble {

        static final int BATCH_UNIT = IteratorSpliterator.BATCH_UNIT;

        static final int MAX_BATCH = IteratorSpliterator.MAX_BATCH;

        private PrimitiveIterator.OfDouble it;

        private final int characteristics;

        private long est; // size estimate

        private int batch; // batch size for splits

        /**
         * Creates a spliterator using the given iterator for traversal, and reporting the given
         * initial size and characteristics.
         * 
         * @param iterator the iterator for the source
         * @param size the number of elements in the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public DoubleIteratorSpliterator(PrimitiveIterator.OfDouble iterator, long size, int characteristics) {
            this.it = iterator;
            this.est = size;
            this.characteristics = (characteristics & Spliterator.CONCURRENT) == 0 ? characteristics | Spliterator.SIZED | Spliterator.SUBSIZED
                    : characteristics;
        }

        /**
         * Creates a spliterator using the given iterator for a source of unknown size, reporting
         * the given characteristics.
         * 
         * @param iterator the iterator for the source
         * @param characteristics properties of this spliterator's source or elements.
         */
        public DoubleIteratorSpliterator(PrimitiveIterator.OfDouble iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & ~(Spliterator.SIZED | Spliterator.SUBSIZED);
        }

        @Override
        public OfDouble trySplit() {
            PrimitiveIterator.OfDouble i = it;
            long s = est;
            if (s > 1 && i.hasNext()) {
                int n = batch + BATCH_UNIT;
                if (n > s) n = (int) s;
                if (n > MAX_BATCH) n = MAX_BATCH;
                double[] a = new double[n];
                int j = 0;
                a[j] = i.nextDouble();

                while (++j < n && i.hasNext()) {
                    a[j] = i.nextDouble();
                }

                batch = j;
                if (est != Long.MAX_VALUE) est -= j;
                // return new DoubleArraySpliterator(a, 0, j, characteristics);

                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error();
            }
            return null;
        }

        @Override
        public void forEachRemaining(DoubleConsumer action) {
            if (action == null) throw new NullPointerException();
            it.forEachRemaining(action);
        }

        @Override
        public boolean tryAdvance(DoubleConsumer action) {
            if (action == null) throw new NullPointerException();
            if (it.hasNext()) {
                action.accept(it.nextDouble());
                return true;
            }
            return false;
        }

        @Override
        public long estimateSize() {
            return est;
        }

        @Override
        public int characteristics() {
            return characteristics;
        }

        @Override
        public Comparator<? super Double> getComparator() {
            if (hasCharacteristics(Spliterator.SORTED)) return null;
            throw new IllegalStateException();
        }
    }
}
