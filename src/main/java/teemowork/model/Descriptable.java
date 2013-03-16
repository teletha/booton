/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/03/16 12:53:49
 */
public abstract class Descriptable<T extends Descriptor> {

    /** The version manager. */
    private final List<T> versions = new ArrayList(Version.values().length);

    /**
     * <p>
     * Retrieve a descriptor of the specified version.
     * </p>
     */
    public final T getDescriptor(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            T descriptor = versions.get(i);

            if (descriptor != null) {
                return descriptor;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @return A oldest descriptor.
     */
    protected final T update() {
        return update(Version.P0000);
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @return A descriptor of the specified version.
     */
    protected final T update(Version version) {
        T descriptor = createDescriptor(getDescriptor(version));

        // versioning management
        versions.set(version.ordinal(), descriptor);

        // API definition
        return descriptor;
    }

    /**
     * <p>
     * Create new descriptor.
     * </p>
     * 
     * @param previous
     * @return
     */
    protected abstract T createDescriptor(T previous);
}
