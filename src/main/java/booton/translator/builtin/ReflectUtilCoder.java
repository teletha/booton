/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import sun.reflect.misc.ReflectUtil;

import booton.translator.Translator;

/**
 * @version 2014/06/26 11:33:31
 */
public class ReflectUtilCoder extends Translator<ReflectUtil> {

    public String checkPackageAccess(String param0) {
        return "";
    }

    public String checkPackageAccess(Class param0) {
        return "";
    }

    public String isPackageAccessible(Class param0) {
        return "true";
    }

    public String needsPackageAccessCheck(ClassLoader one, ClassLoader other) {
        return "true";
    }
}
