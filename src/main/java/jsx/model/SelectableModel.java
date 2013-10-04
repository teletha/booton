/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jsx.bwt.widget.EventHub;

/**
 * @version 2013/04/05 9:31:56
 */
public class SelectableModel<T> extends EventHub implements Iterable<T> {

    /** The index of current selected item. */
    private int index = -1;

    /** The item manager. */
    private List<T> items = new ArrayList();

    /**
     * <p>
     * Create {@link SelectableModel} model with no items.
     * </p>
     */
    public SelectableModel() {
    }

    /**
     * <p>
     * Create {@link SelectableModel} model with the given items.
     * </p>
     * 
     * @param items
     */
    public SelectableModel(T... items) {
        add(items);
    }

    /**
     * Get the index property of this {@link SelectableModel}.
     * 
     * @return The index property.
     */
    public int getSelectionIndex() {
        return index;
    }

    /**
     * Set the index property of this {@link SelectableModel}.
     * 
     * @param index The index value to set.
     */
    public void setSelectionIndex(int index) {
        int old = this.index;
        int size = items.size();

        if (size == 0) {
            index = -1;
        } else if (index < 0) {
            index = 0;
        } else if (size <= index) {
            index = size - 1;
        }
        this.index = index;

        // notify
        if (old != -1) {
            System.out.println(" notify " + index);
            // publish(SelectableListener.class).deselect(old, items.get(old));
            publish(new Deselect(index, items.get(index)));
        }

        if (index != -1) {
            System.out.println("publish selection " + index);
            // publish(SelectableListener.class).select(index, items.get(index));
            publish(new Select(index, items.get(index)));
        }
    }

    /**
     * Get the items property of this {@link SelectableModel}.
     * 
     * @return The items property.
     */
    protected List<T> getItems() {
        return items;
    }

    /**
     * Set the items property of this {@link SelectableModel}.
     * 
     * @param items The items value to set.
     */
    protected void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * <p>
     * Retrieve the selected item. If no item is selected, <code>null</code> will be returned.
     * </p>
     * 
     * @return
     */
    public T getSelection() {
        return index == -1 || items.size() == 0 ? null : items.get(index);
    }

    /**
     * <p>
     * Select the specified item.
     * </p>
     */
    public void setSelection(T item) {
        if (item == null) {
            deselect();
        } else {
            setSelectionIndex(add(item));
        }
    }

    /**
     * <p>
     * Deselect item.
     * </p>
     */
    public final void deselect() {
        setSelectionIndex(-1);
    }

    /**
     * <p>
     * Select next item.
     * </p>
     * 
     * @return
     */
    public final T selectNext() {
        setSelectionIndex(index + 1);

        return getSelection();
    }

    /**
     * <p>
     * Select previous item.
     * </p>
     * 
     * @return
     */
    public final T selectPrevious() {
        setSelectionIndex(index - 1);

        return getSelection();
    }

    /**
     * <p>
     * Select first item.
     * </p>
     * 
     * @return
     */
    public final T selectFirst() {
        setSelectionIndex(0);

        return getSelection();
    }

    /**
     * <p>
     * Select last item.
     * </p>
     * 
     * @return
     */
    public final T selectLast() {
        setSelectionIndex(items.size() - 1);

        return getSelection();
    }

    /**
     * <p>
     * Appends the specified item to the end of this model.
     * </p>
     * 
     * @param item An item to be appended to this model.
     * @return The index of the added item in this model.
     */
    public final int add(T item) {
        int index = items.indexOf(item);

        if (index == -1) {
            index = items.size();
            items.add(item);

            // publish(SelectableListener.class).add(index, item);
            publish(new Add(index, item));
        }
        return index;
    }

    /**
     * <p>
     * Appends the specified item to the end of this model.
     * </p>
     * 
     * @param item An item to be appended to this model.
     */
    public final void add(T... items) {
        for (T item : items) {
            add(item);
        }
    }

    /**
     * <p>
     * Appends the specified item to the end of this model.
     * </p>
     * 
     * @param item An item to be appended to this model.
     */
    public final void add(Iterable<T> items) {
        for (T item : items) {
            add(item);
        }
    }

    /**
     * <p>
     * Removes the first occurrence of the specified item from this model, if it is present . If
     * this model does not contain the item, it is unchanged.
     * </p>
     * 
     * @param item An item to be removed from this model, if present.
     */
    public final void remove(T item) {
        int index = items.indexOf(item);

        if (index != -1) {
            T removed = items.remove(index);

            // synchronize actual model item position and the selected item position
            if (index <= this.index) {
                this.index--;
            }

            // At first, notify item removing.
            publish(new Remove(index, removed));
            // publish(SelectableListener.class).remove(index, removed);

            // Then notify selection changing.
            setSelectionIndex(index);
        }
    }

    /**
     * <p>
     * Returns the item at the specified position in this model.
     * </p>
     * 
     * @param index A index of the item to return
     * @return The item at the specified position in this model.
     */
    public final T get(int index) {
        return items.get(index);
    }

    /**
     * <p>
     * Returns the number of items in this model.
     * </p>
     * 
     * @return The number of items in this model.
     */
    public final int size() {
        return items.size();
    }

    /**
     * <p>
     * Returns the index of the first occurrence of the specified item in this list, or -1 if this
     * model does not contain the item.
     * </p>
     * 
     * @param item An item to search for.
     * @return The index of the first occurrence of the specified item in this model, or -1 if this
     *         list does not contain the item.
     */
    public final int indexOf(T item) {
        return items.indexOf(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Iterator<T> iterator() {
        return items.iterator();
    }

    /**
     * @version 2013/06/19 14:06:38
     */
    public static class Add<T> {

        /** The item index. */
        public final int index;

        /** The selected item. */
        public final T item;

        /**
         * @param index
         * @param item
         */
        private Add(int index, T item) {
            this.index = index;
            this.item = item;
        }
    }

    /**
     * @version 2013/06/19 14:06:38
     */
    public static class Remove<T> {

        /** The item index. */
        public final int index;

        /** The selected item. */
        public final T item;

        /**
         * @param index
         * @param item
         */
        private Remove(int index, T item) {
            this.index = index;
            this.item = item;
        }
    }

    /**
     * @version 2013/06/19 14:06:38
     */
    public static class Select<T> {

        /** The item index. */
        public final int index;

        /** The selected item. */
        public final T item;

        /**
         * @param index
         * @param item
         */
        private Select(int index, T item) {
            this.index = index;
            this.item = item;
        }
    }

    /**
     * @version 2013/06/19 14:06:38
     */
    public static class Deselect<T> {

        /** The item index. */
        public final int index;

        /** The selected item. */
        public final T item;

        /**
         * @param index
         * @param item
         */
        private Deselect(int index, T item) {
            this.index = index;
            this.item = item;
        }
    }
}