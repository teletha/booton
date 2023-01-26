/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.io.File;
import java.io.IOException;
import java.lang.Runtime.Version;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/31 0:37:41
 */
@JavaAPIProvider(Runtime.class)
class JSRuntime {

    /** The singleton. */
    private static final JSRuntime runtime = new JSRuntime();

    /**
     * Returns the runtime object associated with the current Java application. Most of the methods
     * of class <code>Runtime</code> are instance methods and must be invoked with respect to the
     * current runtime object.
     * 
     * @return the <code>Runtime</code> object associated with the current Java application.
     */
    public static Runtime getRuntime() {
        return (Runtime) (Object) runtime;
    }

    /**
     * Returns the number of processors available to the Java virtual machine.
     * <p>
     * This value may change during a particular invocation of the virtual machine. Applications
     * that are sensitive to the number of available processors should therefore occasionally poll
     * this property and adjust their resource usage appropriately.
     * </p>
     * 
     * @return the maximum number of processors available to the virtual machine; never smaller than
     *         one
     * @since 1.4
     */
    public int availableProcessors() {
        return 1;
    }

    /**
     * Executes the specified command and arguments in a separate process.
     * <p>
     * This is a convenience method. An invocation of the form {@code exec(cmdarray)} behaves in
     * exactly the same way as the invocation {@link #exec(String[], String[], File)
     * exec}{@code (cmdarray, null, null)}.
     *
     * @param cmdarray array containing the command to call and its arguments.
     * @return A new {@link Process} object for managing the subprocess
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkExec checkExec} method doesn't allow creation of the
     *             subprocess
     * @throws IOException If an I/O error occurs
     * @throws NullPointerException If {@code cmdarray} is {@code null}, or one of the elements of
     *             {@code cmdarray} is {@code null}
     * @throws IndexOutOfBoundsException If {@code cmdarray} is an empty array (has length
     *             {@code 0})
     * @see ProcessBuilder
     */
    public Process exec(String[] cmdarray) throws IOException {
        return exec(cmdarray, null, null);
    }

    /**
     * Executes the specified command and arguments in a separate process with the specified
     * environment.
     * <p>
     * This is a convenience method. An invocation of the form {@code exec(cmdarray, envp)} behaves
     * in exactly the same way as the invocation {@link #exec(String[], String[], File)
     * exec}{@code (cmdarray, envp, null)}.
     *
     * @param cmdarray array containing the command to call and its arguments.
     * @param envp array of strings, each element of which has environment variable settings in the
     *            format <i>name</i>=<i>value</i>, or {@code null} if the subprocess should inherit
     *            the environment of the current process.
     * @return A new {@link Process} object for managing the subprocess
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkExec checkExec} method doesn't allow creation of the
     *             subprocess
     * @throws IOException If an I/O error occurs
     * @throws NullPointerException If {@code cmdarray} is {@code null}, or one of the elements of
     *             {@code cmdarray} is {@code null}, or one of the elements of {@code envp} is
     *             {@code null}
     * @throws IndexOutOfBoundsException If {@code cmdarray} is an empty array (has length
     *             {@code 0})
     * @see ProcessBuilder
     */
    public Process exec(String[] cmdarray, String[] envp) throws IOException {
        return exec(cmdarray, envp, null);
    }

    /**
     * Executes the specified command and arguments in a separate process with the specified
     * environment and working directory.
     * <p>
     * Given an array of strings {@code cmdarray}, representing the tokens of a command line, and an
     * array of strings {@code envp}, representing "environment" variable settings, this method
     * creates a new process in which to execute the specified command.
     * <p>
     * This method checks that {@code cmdarray} is a valid operating system command. Which commands
     * are valid is system-dependent, but at the very least the command must be a non-empty list of
     * non-null strings.
     * <p>
     * If {@code envp} is {@code null}, the subprocess inherits the environment settings of the
     * current process.
     * <p>
     * A minimal set of system dependent environment variables may be required to start a process on
     * some operating systems. As a result, the subprocess may inherit additional environment
     * variable settings beyond those in the specified environment.
     * <p>
     * {@link ProcessBuilder#start()} is now the preferred way to start a process with a modified
     * environment.
     * <p>
     * The working directory of the new subprocess is specified by {@code dir}. If {@code dir} is
     * {@code null}, the subprocess inherits the current working directory of the current process.
     * <p>
     * If a security manager exists, its {@link SecurityManager#checkExec checkExec} method is
     * invoked with the first component of the array {@code cmdarray} as its argument. This may
     * result in a {@link SecurityException} being thrown.
     * <p>
     * Starting an operating system process is highly system-dependent. Among the many things that
     * can go wrong are:
     * <ul>
     * <li>The operating system program file was not found.
     * <li>Access to the program file was denied.
     * <li>The working directory does not exist.
     * </ul>
     * <p>
     * In such cases an exception will be thrown. The exact nature of the exception is
     * system-dependent, but it will always be a subclass of {@link IOException}.
     * <p>
     * If the operating system does not support the creation of processes, an
     * {@link UnsupportedOperationException} will be thrown.
     *
     * @param cmdarray array containing the command to call and its arguments.
     * @param envp array of strings, each element of which has environment variable settings in the
     *            format <i>name</i>=<i>value</i>, or {@code null} if the subprocess should inherit
     *            the environment of the current process.
     * @param dir the working directory of the subprocess, or {@code null} if the subprocess should
     *            inherit the working directory of the current process.
     * @return A new {@link Process} object for managing the subprocess
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkExec checkExec} method doesn't allow creation of the
     *             subprocess
     * @throws UnsupportedOperationException If the operating system does not support the creation
     *             of processes.
     * @throws IOException If an I/O error occurs
     * @throws NullPointerException If {@code cmdarray} is {@code null}, or one of the elements of
     *             {@code cmdarray} is {@code null}, or one of the elements of {@code envp} is
     *             {@code null}
     * @throws IndexOutOfBoundsException If {@code cmdarray} is an empty array (has length
     *             {@code 0})
     * @see ProcessBuilder
     * @since 1.3
     */
    public Process exec(String[] cmdarray, String[] envp, File dir) throws IOException {
        throw new Error();
    }

    /**
     * Returns the version of the Java Runtime Environment as a {@link Version}.
     *
     * @return the {@link Version} of the Java Runtime Environment
     * @since 9
     */
    public static Version version() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
