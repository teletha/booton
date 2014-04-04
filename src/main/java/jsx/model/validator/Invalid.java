/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.model.validator;

/**
 * @version 2013/04/12 12:02:16
 */
@SuppressWarnings("serial")
public class Invalid extends RuntimeException {

    /**
     * <p>
     * The message for invalid state.
     * </p>
     * 
     * @param message
     */
    public Invalid(String message) {
        super(message);
    }
}
