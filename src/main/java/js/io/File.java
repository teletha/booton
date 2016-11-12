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

import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.LinkOption;
import java.nio.file.Path;

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
     * Tests whether the file denoted by this abstract pathname is a normal file. A file is
     * <em>normal</em> if it is not a directory and, in addition, satisfies other system-dependent
     * criteria. Any non-directory file created by a Java application is guaranteed to be a normal
     * file.
     * <p>
     * Where it is required to distinguish an I/O exception from the case that the file is not a
     * normal file, or where several attributes of the same file are required at the same time, then
     * the {@link java.nio.file.Files#readAttributes(Path,Class,LinkOption[]) Files.readAttributes}
     * method may be used.
     *
     * @return <code>true</code> if and only if the file denoted by this abstract pathname exists
     *         <em>and</em> is a normal file; <code>false</code> otherwise
     * @throws SecurityException If a security manager exists and its <code>{@link
     *          java.lang.SecurityManager#checkRead(java.lang.String)}</code> method denies read
     *             access to the file
     */
    public boolean isFile() {
        return true;
    }

    /**
     * Tests whether the file denoted by this abstract pathname is a directory.
     * <p>
     * Where it is required to distinguish an I/O exception from the case that the file is not a
     * directory, or where several attributes of the same file are required at the same time, then
     * the {@link java.nio.file.Files#readAttributes(Path,Class,LinkOption[]) Files.readAttributes}
     * method may be used.
     *
     * @return <code>true</code> if and only if the file denoted by this abstract pathname exists
     *         <em>and</em> is a directory; <code>false</code> otherwise
     * @throws SecurityException If a security manager exists and its <code>{@link
     *          java.lang.SecurityManager#checkRead(java.lang.String)}</code> method denies read
     *             access to the file
     */
    public boolean isDirectory() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
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

    /**
     * Returns the absolute form of this abstract pathname. Equivalent to
     * <code>new&nbsp;File(this.{@link #getAbsolutePath})</code>.
     *
     * @return The absolute abstract pathname denoting the same file or directory as this abstract
     *         pathname
     * @throws SecurityException If a required system property value cannot be accessed.
     * @since 1.2
     */
    public File getAbsoluteFile() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns the absolute pathname string of this abstract pathname.
     * <p>
     * If this abstract pathname is already absolute, then the pathname string is simply returned as
     * if by the <code>{@link #getPath}</code> method. If this abstract pathname is the empty
     * abstract pathname then the pathname string of the current user directory, which is named by
     * the system property <code>user.dir</code>, is returned. Otherwise this pathname is resolved
     * in a system-dependent way. On UNIX systems, a relative pathname is made absolute by resolving
     * it against the current user directory. On Microsoft Windows systems, a relative pathname is
     * made absolute by resolving it against the current directory of the drive named by the
     * pathname, if any; if not, it is resolved against the current user directory.
     *
     * @return The absolute pathname string denoting the same file or directory as this abstract
     *         pathname
     * @throws SecurityException If a required system property value cannot be accessed.
     * @see java.io.File#isAbsolute()
     */
    public String getAbsolutePath() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns an array of abstract pathnames denoting the files in the directory denoted by this
     * abstract pathname.
     * <p>
     * If this abstract pathname does not denote a directory, then this method returns {@code null}.
     * Otherwise an array of {@code File} objects is returned, one for each file or directory in the
     * directory. Pathnames denoting the directory itself and the directory's parent directory are
     * not included in the result. Each resulting abstract pathname is constructed from this
     * abstract pathname using the {@link #File(File, String) File(File,&nbsp;String)} constructor.
     * Therefore if this pathname is absolute then each resulting pathname is absolute; if this
     * pathname is relative then each resulting pathname will be relative to the same directory.
     * <p>
     * There is no guarantee that the name strings in the resulting array will appear in any
     * specific order; they are not, in particular, guaranteed to appear in alphabetical order.
     * <p>
     * Note that the {@link java.nio.file.Files} class defines the
     * {@link java.nio.file.Files#newDirectoryStream(Path) newDirectoryStream} method to open a
     * directory and iterate over the names of the files in the directory. This may use less
     * resources when working with very large directories.
     *
     * @return An array of abstract pathnames denoting the files and directories in the directory
     *         denoted by this abstract pathname. The array will be empty if the directory is empty.
     *         Returns {@code null} if this abstract pathname does not denote a directory, or if an
     *         I/O error occurs.
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkRead(String)} method denies read access to the
     *             directory
     * @since 1.2
     */
    public File[] listFiles() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Returns an array of abstract pathnames denoting the files and directories in the directory
     * denoted by this abstract pathname that satisfy the specified filter. The behavior of this
     * method is the same as that of the {@link #listFiles()} method, except that the pathnames in
     * the returned array must satisfy the filter. If the given {@code filter} is {@code null} then
     * all pathnames are accepted. Otherwise, a pathname satisfies the filter if and only if the
     * value {@code true} results when the {@link FilenameFilter#accept
     * FilenameFilter.accept(File,&nbsp;String)} method of the filter is invoked on this abstract
     * pathname and the name of a file or directory in the directory that it denotes.
     *
     * @param filter A filename filter
     * @return An array of abstract pathnames denoting the files and directories in the directory
     *         denoted by this abstract pathname. The array will be empty if the directory is empty.
     *         Returns {@code null} if this abstract pathname does not denote a directory, or if an
     *         I/O error occurs.
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkRead(String)} method denies read access to the
     *             directory
     * @since 1.2
     * @see java.nio.file.Files#newDirectoryStream(Path,String)
     */
    public File[] listFiles(FilenameFilter filter) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Constructs a <tt>file:</tt> URI that represents this abstract pathname.
     * <p>
     * The exact form of the URI is system-dependent. If it can be determined that the file denoted
     * by this abstract pathname is a directory, then the resulting URI will end with a slash.
     * <p>
     * For a given abstract pathname <i>f</i>, it is guaranteed that <blockquote><tt>
     * new {@link #File(java.net.URI) File}(</tt><i>&nbsp;f</i><tt>.toURI()).equals(</tt>
     * <i>&nbsp;f</i><tt>.{@link #getAbsoluteFile() getAbsoluteFile}())
     * </tt></blockquote> so long as the original abstract pathname, the URI, and the new abstract
     * pathname are all created in (possibly different invocations of) the same Java virtual
     * machine. Due to the system-dependent nature of abstract pathnames, however, this relationship
     * typically does not hold when a <tt>file:</tt> URI that is created in a virtual machine on one
     * operating system is converted into an abstract pathname in a virtual machine on a different
     * operating system.
     * <p>
     * Note that when this abstract pathname represents a UNC pathname then all components of the
     * UNC (including the server name component) are encoded in the {@code URI} path. The authority
     * component is undefined, meaning that it is represented as {@code null}. The {@link Path}
     * class defines the {@link Path#toUri toUri} method to encode the server name in the authority
     * component of the resulting {@code URI}. The {@link #toPath toPath} method may be used to
     * obtain a {@code Path} representing this abstract pathname.
     *
     * @return An absolute, hierarchical URI with a scheme equal to <tt>"file"</tt>, a path
     *         representing this abstract pathname, and undefined authority, query, and fragment
     *         components
     * @throws SecurityException If a required system property value cannot be accessed.
     * @see #File(java.net.URI)
     * @see java.net.URI
     * @see java.net.URI#toURL()
     * @since 1.4
     */
    public URI toURI() {
        try {
            File f = getAbsoluteFile();
            String sp = f.getPath();
            if (sp.startsWith("//")) sp = "//" + sp;
            return new URI("file", null, sp, null);
        } catch (URISyntaxException x) {
            throw new Error(x); // Can't happen
        }
    }

    /**
     * Converts this abstract pathname into a <code>file:</code> URL. The exact form of the URL is
     * system-dependent. If it can be determined that the file denoted by this abstract pathname is
     * a directory, then the resulting URL will end with a slash.
     *
     * @return A URL object representing the equivalent file URL
     * @throws MalformedURLException If the path cannot be parsed as a URL
     * @see #toURI()
     * @see java.net.URI
     * @see java.net.URI#toURL()
     * @see java.net.URL
     * @since 1.2
     * @deprecated This method does not automatically escape characters that are illegal in URLs. It
     *             is recommended that new code convert an abstract pathname into a URL by first
     *             converting it into a URI, via the {@link #toURI() toURI} method, and then
     *             converting the URI into a URL via the {@link java.net.URI#toURL() URI.toURL}
     *             method.
     */
    @Deprecated
    public URL toURL() throws MalformedURLException {
        if (isInvalid()) {
            throw new MalformedURLException("Invalid file path");
        }
        return new URL("file", "", getAbsolutePath());
    }

}
