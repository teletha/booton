/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.emulate.sun.util.locale.provider;

import java.util.ResourceBundle;

/**
 * @version 2014/04/10 9:31:21
 */
// @JavaAPIProvider(sun.util.locale.provider.LocaleResources.class)
class LocaleResources {

    public ResourceBundle getJavaTimeFormatData() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    public String getJavaTimeDateTimePattern(int a, int b, String c) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
