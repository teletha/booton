/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

import booton.ExternalResource;
import booton.Obfuscator;

/**
 * @version 2012/12/21 16:30:58
 */
public class ClassName implements ExternalResource {

    /** The class counter. */
    private static int count = 0;

    /** The class name. */
    private final String id;

    /**
     * 
     */
    public ClassName() {
        this.id = Obfuscator.mung52(count++);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return id;
    }
}
