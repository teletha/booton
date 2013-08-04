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

import booton.translator.JavaAPIProvider;

/**
 * @version 2012/12/08 22:07:59
 */
@JavaAPIProvider(java.util.AbstractSet.class)
abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (o == this) return true;

        if (!(o instanceof Set)) return false;
        Collection c = (Collection) o;
        if (c.size() != size()) return false;
        try {
            return containsAll(c);
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        int h = 0;
        Iterator<E> i = iterator();
        while (i.hasNext()) {
            E obj = i.next();
            if (obj != null) h += obj.hashCode();
        }
        return h;
    }

    /**
     * {@inheritDoc}
     */
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        if (size() > c.size()) {
            for (Iterator<?> i = c.iterator(); i.hasNext();)
                modified |= remove(i.next());
        } else {
            for (Iterator<?> i = iterator(); i.hasNext();) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
    }
}
