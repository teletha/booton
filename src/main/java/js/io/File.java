/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.io;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:46:03
 */
@JavaAPIProvider(java.io.File.class)
class File {

    /**
     * The system-dependent default name-separator character. This field is initialized to contain
     * the first character of the value of the system property <code>file.separator</code>. On UNIX
     * systems the value of this field is <code>'/'</code>; on Microsoft Windows systems it is
     * <code>'\\'</code>.
     *
     * @see java.lang.System#getProperty(java.lang.String)
     */
    public static final char separatorChar = '/';

    /**
     * The system-dependent default name-separator character, represented as a string for
     * convenience. This string contains a single character, namely
     * <code>{@link #separatorChar}</code>.
     */
    public static final String separator = "/";

    /**
     * Tests whether the file or directory denoted by this abstract pathname exists.
     *
     * @return <code>true</code> if and only if the file or directory denoted by this abstract
     *         pathname exists; <code>false</code> otherwise
     * @throws SecurityException If a security manager exists and its <code>{@link
     *          java.lang.SecurityManager#checkRead(java.lang.String)}</code> method denies read
     *             access to the file or directory
     */
    public boolean exists() {
        return false;
    }

    /**
     * Check if the file has an invalid path. Currently, the inspection of a file path is very
     * limited, and it only covers Nul character check. Returning true means the path is definitely
     * invalid/garbage. But returning false does not guarantee that the path is valid.
     *
     * @return true if the file path is invalid.
     */
    final boolean isInvalid() {
        return true;
    }

    /**
     * Converts this abstract pathname into a pathname string. The resulting string uses the
     * {@link #separator default name-separator character} to separate the names in the name
     * sequence.
     *
     * @return The string form of this abstract pathname
     */
    public String getPath() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
