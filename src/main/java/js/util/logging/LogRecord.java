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

import java.util.ResourceBundle;
import java.util.logging.Level;

import booton.translator.JavaAPIProvider;

/**
 * @version 2017/04/21 20:29:08
 */
@JavaAPIProvider(java.util.logging.LogRecord.class)
class LogRecord {

    /**
     * @serial Logging message level
     */
    private Level level;

    /**
     * @serial Non-localized raw message text
     */
    private String message;

    /**
     * Construct a LogRecord with the given level and message values.
     * <p>
     * The sequence property will be initialized with a new unique value. These sequence values are
     * allocated in increasing order within a VM.
     * <p>
     * The millis property will be initialized to the current time.
     * <p>
     * The thread ID property will be initialized with a unique ID for the current thread.
     * <p>
     * All other properties will be initialized to "null".
     *
     * @param level a logging level value
     * @param msg the raw non-localized logging message (may be null)
     */
    public LogRecord(Level level, String msg) {
        this.level = level;
        this.message = msg;
    }

    /**
     * Get the logging message level, for example Level.SEVERE.
     * 
     * @return the logging message level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Get the "raw" log message, before localization or formatting.
     * <p>
     * May be null, which is equivalent to the empty string "".
     * <p>
     * This message may be either the final text or a localization key.
     * <p>
     * During formatting, if the source logger has a localization ResourceBundle and if that
     * ResourceBundle has an entry for this message string, then the message string is replaced with
     * the localized value.
     *
     * @return the raw message string
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the "raw" log message, before localization or formatting.
     *
     * @param message the raw message string (may be null)
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Get the localization resource bundle
     * <p>
     * This is the ResourceBundle that should be used to localize the message string before
     * formatting it. The result may be null if the message is not localizable, or if no suitable
     * ResourceBundle is available.
     * 
     * @return the localization resource bundle
     */
    public ResourceBundle getResourceBundle() {
        return null;
    }
}
