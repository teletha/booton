/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.event;


/**
 * @version 2013/12/24 23:08:46
 */
public class Info {

    /** The event type. */
    public Object type;

    /**
     * <p>
     * Set the execution debounce time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    public long debounce;

    /**
     * <p>
     * Set the execution throttle time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    public long throttle;

    /**
     * <p>
     * Set the execution delay time (ms).
     * </p>
     * 
     * @return A time (ms);
     */
    public long delay;

    /**
     * <p>
     * Set a number of execution.
     * </p>
     * 
     * @return
     */
    public int count;

    /**
     * <p>
     * Stop event propagation and default behavior.
     * </p>
     * 
     * @return The <code>true</code> will stop the current processing event.
     */
    public boolean abort;
}
