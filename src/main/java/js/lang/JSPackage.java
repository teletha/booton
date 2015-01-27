/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/30 12:31:01
 */
@JavaAPIProvider(Package.class)
class JSPackage {

    /** The package name. */
    private final String name;

    /**
     * @param name A package name.
     */
    private JSPackage(String name) {
        this.name = name;
    }

    /**
     * Return the name of this package.
     * 
     * @return The fully-qualified name of this package as defined in section 6.5.3 of <cite>The
     *         Java&trade; Language Specification</cite>, for example, {@code java.lang}
     */
    public String getName() {
        return name;
    }

    /**
     * Find a package by name in the callers {@code ClassLoader} instance. The callers
     * {@code ClassLoader} instance is used to find the package instance corresponding to the named
     * class. If the callers {@code ClassLoader} instance is null then the set of packages loaded by
     * the system {@code ClassLoader} instance is searched to find the named package.
     * <p>
     * Packages have attributes for versions and specifications only if the class loader created the
     * package instance with the appropriate attributes. Typically, those attributes are defined in
     * the manifests that accompany the classes.
     * 
     * @param name a package name, for example, java.lang.
     * @return the package of the requested name. It may be null if no package information is
     *         available from the archive or codebase.
     */
    public static Package getPackage(String name) {
        return (Package) (Object) new JSPackage(name);
    }
}
