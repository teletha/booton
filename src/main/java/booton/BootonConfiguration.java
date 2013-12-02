/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2013/04/15 11:14:52
 */
@Manageable(lifestyle = Singleton.class)
public class BootonConfiguration {

    /** The oprimization flag. */
    public boolean optimization = true;

}
