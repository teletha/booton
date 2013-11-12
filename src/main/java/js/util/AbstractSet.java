/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import booton.translator.Debuggable;
import booton.translator.JavaAPIProvider;

/**
 * @version 2012/12/08 22:07:59
 */
@JavaAPIProvider(java.util.AbstractSet.class)
abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (!(object instanceof Set)) {
            return false;
        }

        Collection collection = (Collection) object;

        if (collection.size() != size()) {
            return false;
        }
        try {
            return containsAll(collection);
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int h = 0;
        Iterator<E> i = iterator();
        while (i.hasNext()) {
            E obj = i.next();

            if (obj != null) {
                h += obj.hashCode();
            }
        }
        return h;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Debuggable
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;

        if (size() > collection.size()) {
            for (Iterator<?> i = collection.iterator(); i.hasNext();) {
                modified |= remove(i.next());
            }
        } else {
            for (Iterator<?> i = iterator(); i.hasNext();) {
                if (collection.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
    }
}
