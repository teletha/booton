/*
 * Copyright (C) 2017 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util.logging;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;

import booton.translator.JavaAPIProvider;
import js.lang.builtin.Console;

/**
 * @version 2017/04/21 15:44:44
 */
@JavaAPIProvider(java.util.logging.Logger.class)
class Logger {

    /** The category name. */
    private final String name;

    /** The list of {@link Handler}. */
    private final List<Handler> handlers = new ArrayList();

    /**
     * <p>
     * Create Logger with category name.
     * </p>
     * 
     * @param name A category name.
     */
    private Logger(String name) {
        this.name = name;
    }

    /**
     * Find or create a logger for a named subsystem. If a logger has already been created with the
     * given name it is returned. Otherwise a new logger is created.
     * <p>
     * If a new logger is created its log level will be configured based on the LogManager
     * configuration and it will configured to also send logging output to its parent's Handlers. It
     * will be registered in the LogManager global namespace.
     * <p>
     * Note: The LogManager may only retain a weak reference to the newly created Logger. It is
     * important to understand that a previously created Logger with the given name may be garbage
     * collected at any time if there is no strong reference to the Logger. In particular, this
     * means that two back-to-back calls like {@code getLogger("MyLogger").log(...)} may use
     * different Logger objects named "MyLogger" if there is no strong reference to the Logger named
     * "MyLogger" elsewhere in the program.
     *
     * @param name A name for the logger. This should be a dot-separated name and should normally be
     *            based on the package name or class name of the subsystem, such as java.net or
     *            javax.swing
     * @return a suitable Logger
     * @throws NullPointerException if the name is null.
     */
    public static Logger getLogger(String name) {
        return new Logger(name);
    }

    /**
     * Get the Handlers associated with this logger.
     * <p>
     * 
     * @return an array of all registered Handlers
     */
    public Handler[] getHandlers() {
        return handlers.toArray(new Handler[handlers.size()]);
    }

    public void addHandler(Handler handler) {
        if (handler != null) {
            handlers.add(handler);
        }
    }

    /**
     * Remove a log Handler.
     * <P>
     * Returns silently if the given Handler is not found or is null
     *
     * @param handler a logging Handler
     * @throws SecurityException if a security manager exists, this logger is not anonymous, and the
     *             caller does not have LoggingPermission("control").
     */
    public void removeHandler(Handler handler) throws SecurityException {
        if (handler != null) {
            handlers.remove(handler);
        }
    }

    /**
     * Log a message, specifying source class and method, with no arguments.
     * <p>
     * If the logger is currently enabled for the given message level then the given message is
     * forwarded to all the registered output Handler objects.
     * <p>
     * 
     * @param level One of the message level identifiers, e.g., SEVERE
     * @param sourceClass name of class that issued the logging request
     * @param sourceMethod name of method that issued the logging request
     * @param msg The string message (or a key in the message catalog)
     */
    public void logp(Level level, String sourceClass, String sourceMethod, String msg) {
        Console.log(msg);
    }

    public void logp(Level level, String sourceClass, String sourceMethod, String msg, Object[] param) {
        Console.log(msg);
    }
}
