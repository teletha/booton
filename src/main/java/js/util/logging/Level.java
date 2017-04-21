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

import java.util.Locale;

import booton.translator.JavaAPIProvider;

/**
 * @version 2017/04/21 20:25:01
 */
@JavaAPIProvider(java.util.logging.Level.class)
class Level {

    // localized level name
    private transient String localizedLevelName;

    private transient Locale cachedLocale;

    /**
     * OFF is a special level that can be used to turn off logging. This level is initialized to
     * <CODE>Integer.MAX_VALUE</CODE>.
     */
    public static final Level OFF = new Level("OFF", Integer.MAX_VALUE);

    /**
     * SEVERE is a message level indicating a serious failure.
     * <p>
     * In general SEVERE messages should describe events that are of considerable importance and
     * which will prevent normal program execution. They should be reasonably intelligible to end
     * users and to system administrators. This level is initialized to <CODE>1000</CODE>.
     */
    public static final Level SEVERE = new Level("SEVERE", 1000);

    /**
     * WARNING is a message level indicating a potential problem.
     * <p>
     * In general WARNING messages should describe events that will be of interest to end users or
     * system managers, or which indicate potential problems. This level is initialized to
     * <CODE>900</CODE>.
     */
    public static final Level WARNING = new Level("WARNING", 900);

    /**
     * INFO is a message level for informational messages.
     * <p>
     * Typically INFO messages will be written to the console or its equivalent. So the INFO level
     * should only be used for reasonably significant messages that will make sense to end users and
     * system administrators. This level is initialized to <CODE>800</CODE>.
     */
    public static final Level INFO = new Level("INFO", 800);

    /**
     * CONFIG is a message level for static configuration messages.
     * <p>
     * CONFIG messages are intended to provide a variety of static configuration information, to
     * assist in debugging problems that may be associated with particular configurations. For
     * example, CONFIG message might include the CPU type, the graphics depth, the GUI
     * look-and-feel, etc. This level is initialized to <CODE>700</CODE>.
     */
    public static final Level CONFIG = new Level("CONFIG", 700);

    /**
     * FINE is a message level providing tracing information.
     * <p>
     * All of FINE, FINER, and FINEST are intended for relatively detailed tracing. The exact
     * meaning of the three levels will vary between subsystems, but in general, FINEST should be
     * used for the most voluminous detailed output, FINER for somewhat less detailed output, and
     * FINE for the lowest volume (and most important) messages.
     * <p>
     * In general the FINE level should be used for information that will be broadly interesting to
     * developers who do not have a specialized interest in the specific subsystem.
     * <p>
     * FINE messages might include things like minor (recoverable) failures. Issues indicating
     * potential performance problems are also worth logging as FINE. This level is initialized to
     * <CODE>500</CODE>.
     */
    public static final Level FINE = new Level("FINE", 500);

    /**
     * FINER indicates a fairly detailed tracing message. By default logging calls for entering,
     * returning, or throwing an exception are traced at this level. This level is initialized to
     * <CODE>400</CODE>.
     */
    public static final Level FINER = new Level("FINER", 400);

    /**
     * FINEST indicates a highly detailed tracing message. This level is initialized to
     * <CODE>300</CODE>.
     */
    public static final Level FINEST = new Level("FINEST", 300);

    /**
     * ALL indicates that all messages should be logged. This level is initialized to
     * <CODE>Integer.MIN_VALUE</CODE>.
     */
    public static final Level ALL = new Level("ALL", Integer.MIN_VALUE);

    /**
     * @serial The non-localized name of the level.
     */
    private final String name;

    /**
     * @serial The integer value of the level.
     */
    private final int value;

    /**
     * Create a named Level with a given integer value and a given localization resource name.
     * <p>
     * 
     * @param name the name of the Level, for example "SEVERE".
     * @param value an integer value for the level.
     * @throws NullPointerException if the name is null
     */
    protected Level(String name, int value) {
        if (name == null) {
            throw new NullPointerException();
        }

        this.name = name;
        this.value = value;
    }

    /**
     * Get the integer value for this level. This integer value can be used for efficient ordering
     * comparisons between Level objects.
     * 
     * @return the integer value for this level.
     */
    public final int intValue() {
        return value;
    }
}
