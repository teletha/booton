/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.concurrent;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/11 10:30:48
 */
@JavaAPIProvider(java.util.concurrent.CopyOnWriteArraySet.class)
class CopyOnWriteArraySet<E> extends AbstractSet<E> {

    private final CopyOnWriteArrayList<E> list;

    /**
     * Creates an empty set.
     */
    public CopyOnWriteArraySet() {
        list = new CopyOnWriteArrayList<E>();
    }

    /**
     * Creates a set containing all of the elements of the specified collection.
     * 
     * @param collection the collection of elements to initially contain
     * @throws NullPointerException if the specified collection is null
     */
    public CopyOnWriteArraySet(Collection<? extends E> collection) {
        list = new CopyOnWriteArrayList<E>();
        list.addAllAbsent(collection);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns <tt>true</tt> if this set contains no elements.
     * 
     * @return <tt>true</tt> if this set contains no elements
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns <tt>true</tt> if this set contains the specified element. More formally, returns
     * <tt>true</tt> if and only if this set contains an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     * 
     * @param o element whose presence in this set is to be tested
     * @return <tt>true</tt> if this set contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    /**
     * Returns an array containing all of the elements in this set. If this set makes any guarantees
     * as to what order its elements are returned by its iterator, this method must return the
     * elements in the same order.
     * <p>
     * The returned array will be "safe" in that no references to it are maintained by this set. (In
     * other words, this method must allocate a new array even if this set is backed by an array).
     * The caller is thus free to modify the returned array.
     * <p>
     * This method acts as bridge between array-based and collection-based APIs.
     * 
     * @return an array containing all the elements in this set
     */
    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    /**
     * Returns an array containing all of the elements in this set; the runtime type of the returned
     * array is that of the specified array. If the set fits in the specified array, it is returned
     * therein. Otherwise, a new array is allocated with the runtime type of the specified array and
     * the size of this set.
     * <p>
     * If this set fits in the specified array with room to spare (i.e., the array has more elements
     * than this set), the element in the array immediately following the end of the set is set to
     * <tt>null</tt>. (This is useful in determining the length of this set <i>only</i> if the
     * caller knows that this set does not contain any null elements.)
     * <p>
     * If this set makes any guarantees as to what order its elements are returned by its iterator,
     * this method must return the elements in the same order.
     * <p>
     * Like the {@link #toArray()} method, this method acts as bridge between array-based and
     * collection-based APIs. Further, this method allows precise control over the runtime type of
     * the output array, and may, under certain circumstances, be used to save allocation costs.
     * <p>
     * Suppose <tt>x</tt> is a set known to contain only strings. The following code can be used to
     * dump the set into a newly allocated array of <tt>String</tt>:
     * 
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to <tt>toArray()</tt>.
     * 
     * @param a the array into which the elements of this set are to be stored, if it is big enough;
     *            otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing all the elements in this set
     * @throws ArrayStoreException if the runtime type of the specified array is not a supertype of
     *             the runtime type of every element in this set
     * @throws NullPointerException if the specified array is null
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    /**
     * Removes all of the elements from this set. The set will be empty after this call returns.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Removes the specified element from this set if it is present. More formally, removes an
     * element <tt>e</tt> such that <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>,
     * if this set contains such an element. Returns <tt>true</tt> if this set contained the element
     * (or equivalently, if this set changed as a result of the call). (This set will not contain
     * the element once the call returns.)
     * 
     * @param o object to be removed from this set, if present
     * @return <tt>true</tt> if this set contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    /**
     * Adds the specified element to this set if it is not already present. More formally, adds the
     * specified element <tt>e</tt> to this set if the set contains no element <tt>e2</tt> such that
     * <tt>(e==null&nbsp;?&nbsp;e2==null&nbsp;:&nbsp;e.equals(e2))</tt>. If this set already
     * contains the element, the call leaves the set unchanged and returns <tt>false</tt>.
     * 
     * @param e element to be added to this set
     * @return <tt>true</tt> if this set did not already contain the specified element
     */
    @Override
    public boolean add(E e) {
        return list.addIfAbsent(e);
    }

    /**
     * Returns <tt>true</tt> if this set contains all of the elements of the specified collection.
     * If the specified collection is also a set, this method returns <tt>true</tt> if it is a
     * <i>subset</i> of this set.
     * 
     * @param c collection to be checked for containment in this set
     * @return <tt>true</tt> if this set contains all of the elements of the specified collection
     * @throws NullPointerException if the specified collection is null
     * @see #contains(Object)
     */
    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    /**
     * Adds all of the elements in the specified collection to this set if they're not already
     * present. If the specified collection is also a set, the <tt>addAll</tt> operation effectively
     * modifies this set so that its value is the <i>union</i> of the two sets. The behavior of this
     * operation is undefined if the specified collection is modified while the operation is in
     * progress.
     * 
     * @param c collection containing elements to be added to this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see #add(Object)
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        return list.addAllAbsent(c) > 0;
    }

    /**
     * Removes from this set all of its elements that are contained in the specified collection. If
     * the specified collection is also a set, this operation effectively modifies this set so that
     * its value is the <i>asymmetric set difference</i> of the two sets.
     * 
     * @param c collection containing elements to be removed from this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws ClassCastException if the class of an element of this set is incompatible with the
     *             specified collection (optional)
     * @throws NullPointerException if this set contains a null element and the specified collection
     *             does not permit null elements (optional), or if the specified collection is null
     * @see #remove(Object)
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    /**
     * Retains only the elements in this set that are contained in the specified collection. In
     * other words, removes from this set all of its elements that are not contained in the
     * specified collection. If the specified collection is also a set, this operation effectively
     * modifies this set so that its value is the <i>intersection</i> of the two sets.
     * 
     * @param c collection containing elements to be retained in this set
     * @return <tt>true</tt> if this set changed as a result of the call
     * @throws ClassCastException if the class of an element of this set is incompatible with the
     *             specified collection (optional)
     * @throws NullPointerException if this set contains a null element and the specified collection
     *             does not permit null elements (optional), or if the specified collection is null
     * @see #remove(Object)
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    /**
     * Returns an iterator over the elements contained in this set in the order in which these
     * elements were added.
     * <p>
     * The returned iterator provides a snapshot of the state of the set when the iterator was
     * constructed. No synchronization is needed while traversing the iterator. The iterator does
     * <em>NOT</em> support the <tt>remove</tt> method.
     * 
     * @return an iterator over the elements in this set
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
