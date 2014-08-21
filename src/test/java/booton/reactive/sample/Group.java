/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.sample;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

/**
 * @version 2014/08/21 16:33:35
 */
public class Group {

    /** The property. */
    public final ListProperty<Person> members = new SimpleListProperty();
}
