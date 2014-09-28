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

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/11/07 19:40:07
 */
@JavaAPIProvider(java.util.EnumSet.class)
class EnumSet<E extends Enum<E>> extends AbstractSet<E> {

    /** The target enum. */
    private final Class<E> type;

    /** The size. */
    private int size = 0;

    /** The items. */
    private boolean[] items;

    /**
     * Hide constructor.
     */
    private EnumSet(Class<E> type) {
        this.type = type;
        this.items = new boolean[type.getEnumConstants().length];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Object o) {
        if (o instanceof Enum) {
            return items[((Enum) o).ordinal()];
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            /** The current index. */
            private int index = 0;

            /** The last returned index. */
            private int last = -1;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                for (int i = index; i < items.length; i++) {
                    if (items[i]) {
                        return true;
                    }
                }
                return false;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public E next() {
                for (; index < items.length; index++) {
                    if (items[index]) {
                        last = index++;
                        return type.getEnumConstants()[index - 1];
                    }
                }
                throw new NoSuchElementException();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void remove() {
                if (last == -1) {
                    throw new IllegalStateException();
                }
                items[last] = false;
                last = -1;
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {
        int index = e.ordinal();

        if (items[index]) {
            return false;
        }
        size++;
        items[index] = true;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(Object o) {
        if (o instanceof Enum) {
            int index = ((Enum) o).ordinal();

            if (!items[index]) {
                return false;
            }
            size--;
            items[index] = false;
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        Arrays.fill(items, false);
    }

    /**
     * Creates an enum set containing all of the elements in the specified element type.
     * 
     * @param <E> The class of the elements in the set
     * @param elementType the class object of the element type for this enum set
     * @return An enum set containing all the elements in the specified type.
     * @throws NullPointerException if <tt>elementType</tt> is null
     */
    public static <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType) {
        EnumSet<E> set = new EnumSet(elementType);
        set.size = set.items.length;
        Arrays.fill(set.items, true);

        return set;
    }

    /**
     * Creates an enum set with the same element type as the specified enum set, initially
     * containing the same elements (if any).
     * 
     * @param <E> The class of the elements in the set
     * @param set the enum set from which to initialize this enum set
     * @return A copy of the specified enum set.
     * @throws NullPointerException if <tt>s</tt> is null
     */
    public static <E extends Enum<E>> EnumSet<E> copyOf(java.util.EnumSet<E> set) {
        EnumSet<E> copy = new EnumSet(((EnumSet) (Object) set).type);
        copy.addAll(set);

        return copy;
    }

    /**
     * Creates an enum set initialized from the specified collection. If the specified collection is
     * an <tt>EnumSet</tt> instance, this static factory method behaves identically to
     * {@link #copyOf(EnumSet)}. Otherwise, the specified collection must contain at least one
     * element (in order to determine the new enum set's element type).
     * 
     * @param <E> The class of the elements in the collection
     * @param collection the collection from which to initialize this enum set
     * @return An enum set initialized from the given collection.
     * @throws IllegalArgumentException if <tt>c</tt> is not an <tt>EnumSet</tt> instance and
     *             contains no elements
     * @throws NullPointerException if <tt>c</tt> is null
     */
    public static <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Collection is empty");
        }

        Iterator<E> iterator = collection.iterator();
        EnumSet<E> result = EnumSet.of(iterator.next());

        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;
    }

    /**
     * Creates an enum set with the same element type as the specified enum set, initially
     * containing all the elements of this type that are <i>not</i> contained in the specified set.
     * 
     * @param <E> The class of the elements in the enum set
     * @param set the enum set from whose complement to initialize this enum set
     * @return The complement of the specified set in this set
     * @throws NullPointerException if <tt>s</tt> is null
     */
    public static <E extends Enum<E>> EnumSet<E> complementOf(java.util.EnumSet<E> set) {
        EnumSet<E> copy = copyOf(set);

        for (int i = 0; i < copy.items.length; i++) {
            copy.items[i] = !copy.items[i];
        }
        copy.size = copy.items.length - copy.size;

        return copy;
    }

    /**
     * Creates an empty enum set with the specified element type.
     * 
     * @param <E> The class of the elements in the set
     * @param elementType the class object of the element type for this enum set
     * @return An empty enum set of the specified type.
     * @throws NullPointerException if <tt>elementType</tt> is null
     */
    public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
        return new EnumSet(elementType);
    }

    /**
     * Creates an enum set initially containing the specified element. Overloadings of this method
     * exist to initialize an enum set with one through five elements. A sixth overloading is
     * provided that uses the varargs feature. This overloading may be used to create an enum set
     * initially containing an arbitrary number of elements, but is likely to run slower than the
     * overloadings that do not use varargs.
     * 
     * @param <E> The class of the specified element and of the set
     * @param e the element that this set is to contain initially
     * @throws NullPointerException if <tt>e</tt> is null
     * @return an enum set initially containing the specified element
     */
    public static <E extends Enum<E>> EnumSet<E> of(E e) {
        EnumSet<E> set = new EnumSet(e.getDeclaringClass());
        set.add(e);

        return set;
    }

    /**
     * Creates an enum set initially containing the specified elements. Overloadings of this method
     * exist to initialize an enum set with one through five elements. A sixth overloading is
     * provided that uses the varargs feature. This overloading may be used to create an enum set
     * initially containing an arbitrary number of elements, but is likely to run slower than the
     * overloadings that do not use varargs.
     * 
     * @param <E> The class of the parameter elements and of the set
     * @param e1 an element that this set is to contain initially
     * @param e2 another element that this set is to contain initially
     * @throws NullPointerException if any parameters are null
     * @return an enum set initially containing the specified elements
     */
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2) {
        EnumSet<E> set = new EnumSet(e1.getDeclaringClass());
        set.add(e1);
        set.add(e2);

        return set;
    }

    /**
     * Creates an enum set initially containing the specified elements. Overloadings of this method
     * exist to initialize an enum set with one through five elements. A sixth overloading is
     * provided that uses the varargs feature. This overloading may be used to create an enum set
     * initially containing an arbitrary number of elements, but is likely to run slower than the
     * overloadings that do not use varargs.
     * 
     * @param <E> The class of the parameter elements and of the set
     * @param e1 an element that this set is to contain initially
     * @param e2 another element that this set is to contain initially
     * @param e3 another element that this set is to contain initially
     * @throws NullPointerException if any parameters are null
     * @return an enum set initially containing the specified elements
     */
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3) {
        EnumSet<E> set = new EnumSet(e1.getDeclaringClass());
        set.add(e1);
        set.add(e2);
        set.add(e3);

        return set;
    }

    /**
     * Creates an enum set initially containing the specified elements. Overloadings of this method
     * exist to initialize an enum set with one through five elements. A sixth overloading is
     * provided that uses the varargs feature. This overloading may be used to create an enum set
     * initially containing an arbitrary number of elements, but is likely to run slower than the
     * overloadings that do not use varargs.
     * 
     * @param <E> The class of the parameter elements and of the set
     * @param e1 an element that this set is to contain initially
     * @param e2 another element that this set is to contain initially
     * @param e3 another element that this set is to contain initially
     * @param e4 another element that this set is to contain initially
     * @throws NullPointerException if any parameters are null
     * @return an enum set initially containing the specified elements
     */
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4) {
        EnumSet<E> set = new EnumSet(e1.getDeclaringClass());
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        return set;
    }

    /**
     * Creates an enum set initially containing the specified elements. Overloadings of this method
     * exist to initialize an enum set with one through five elements. A sixth overloading is
     * provided that uses the varargs feature. This overloading may be used to create an enum set
     * initially containing an arbitrary number of elements, but is likely to run slower than the
     * overloadings that do not use varargs.
     * 
     * @param <E> The class of the parameter elements and of the set
     * @param e1 an element that this set is to contain initially
     * @param e2 another element that this set is to contain initially
     * @param e3 another element that this set is to contain initially
     * @param e4 another element that this set is to contain initially
     * @param e5 another element that this set is to contain initially
     * @throws NullPointerException if any parameters are null
     * @return an enum set initially containing the specified elements
     */
    public static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4, E e5) {
        EnumSet<E> set = new EnumSet(e1.getDeclaringClass());
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        return set;
    }

    /**
     * Creates an enum set initially containing the specified elements. This factory, whose
     * parameter list uses the varargs feature, may be used to create an enum set initially
     * containing an arbitrary number of elements, but it is likely to run slower than the
     * overloadings that do not use varargs.
     * 
     * @param <E> The class of the parameter elements and of the set
     * @param first an element that the set is to contain initially
     * @param rest the remaining elements the set is to contain initially
     * @throws NullPointerException if any of the specified elements are null, or if <tt>rest</tt>
     *             is null
     * @return an enum set initially containing the specified elements
     */
    @SafeVarargs
    public static <E extends Enum<E>> EnumSet<E> of(E first, E... rest) {
        EnumSet<E> set = new EnumSet(first.getDeclaringClass());
        set.add(first);

        for (E item : rest) {
            set.add(item);
        }
        return set;
    }

    /**
     * Creates an enum set initially containing all of the elements in the range defined by the two
     * specified endpoints. The returned set will contain the endpoints themselves, which may be
     * identical but must not be out of order.
     * 
     * @param <E> The class of the parameter elements and of the set
     * @param from the first element in the range
     * @param to the last element in the range
     * @throws NullPointerException if {@code from} or {@code to} are null
     * @throws IllegalArgumentException if {@code from.compareTo(to) > 0}
     * @return an enum set initially containing all of the elements in the range defined by the two
     *         specified endpoints
     */
    public static <E extends Enum<E>> EnumSet<E> range(E from, E to) {
        if (from.compareTo(to) > 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }

        EnumSet<E> set = noneOf(from.getDeclaringClass());

        for (int i = from.ordinal(); i <= to.ordinal(); i++) {
            set.size++;
            set.items[i] = true;
        }
        return set;
    }
}
