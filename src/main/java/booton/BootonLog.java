/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import java.nio.file.Path;
import java.util.Objects;

import jsx.debug.Profile;
import psychopath.Location;
import psychopath.Locator;

public enum BootonLog implements Profile<Class, Object, Object> {

    RunTest1, RunTestAsJava, ParseTest1, RunTestMethod1, RunTest2, ParseTest2, RunTestMethod2, JavascriptConstructor, WriteTo, WriteJS, WriteSuperClass, WriteInterface, WriteJSActually, WriteDependency, Compile, PraseByteCode, CompileAnnotation, LoadLibrary;

    /**
     * {@inheritDoc}
     */
    @Override
    public String name(Class key1, Object key2, Object key3) {
        Path archive = null;
        if (key1 != null) {
            Location loc = Locator.locate(key1);
            if (loc != null) {
                archive = loc.asJavaPath();
            }
        }
        return name() + "(" + (archive == null ? "JDK" : archive.getFileName()) + ")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object group(Class key1, Object key2, Object key3) {
        Path archive = null;
        if (key1 != null) {
            Location loc = Locator.locate(key1);
            if (loc != null) {
                archive = loc.asJavaPath();
            }
        }
        return Objects.hash(name(key1, key2, key3), archive);
    }
}
