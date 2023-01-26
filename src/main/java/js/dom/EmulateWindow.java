/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import java.util.Locale;

import kiss.Managed;
import kiss.Singleton;

/**
 * @version 2015/06/09 12:29:41
 */
@Managed(Singleton.class)
public class EmulateWindow extends Window {

    public String language = Locale.getDefault().getDisplayLanguage();
}
