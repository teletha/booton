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
import kiss.I;

/**
 * @version 2015/08/05 12:50:25
 */
public enum BootonLog implements Profile<Class, Object, Object> {

    RunTest1, RunTestAsJava, ParseTest1, RunTestMethod1, RunTest2, ParseTest2, RunTestMethod2, JavascriptConstructor, WriteTo, WriteJS, WriteSuperClass, WriteInterface, WriteJSActually, WriteDependency, Compile, PraseByteCode, CompileAnnotation, LoadLibrary;

    /**
     * {@inheritDoc}
     */
    @Override
    public String name(Class key1, Object key2, Object key3) {
        Path archive = key1 == null ? null : I.locate(key1);

        return name() + "(" + (archive == null ? "JDK" : archive.getFileName()) + ")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object group(Class key1, Object key2, Object key3) {
        Path archive = key1 == null ? null : I.locate(key1);

        return Objects.hash(name(key1, key2, key3), archive);
    }
}
