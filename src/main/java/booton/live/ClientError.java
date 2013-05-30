/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import java.util.ArrayList;
import java.util.List;

import jsx.model.Property;

/**
 * @version 2013/05/26 11:30:35
 */
public class ClientError {

    /** The error message. */
    @Property
    public String message;

    /** The stack trace. */
    @Property
    public List<ClientStackTrace> trace = new ArrayList();
}