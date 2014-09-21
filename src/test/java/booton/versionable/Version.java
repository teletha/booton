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

/**
 * @version 2014/09/21 12:35:55
 */
public class Version {

    /** The version id. */
    private final int id;

    /**
     * 
     */
    Version(int id) {
        this.id = id;
    }

    /**
     * <p>
     * Increment version.
     * </p>
     * 
     * @return A new {@link Version}.
     */
    Version next() {
        return new Version(id + 1);
    }
}
