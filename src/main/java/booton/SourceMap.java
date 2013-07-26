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

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import kiss.I;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2013/07/27 3:27:58
 */
@Manageable(lifestyle = Singleton.class)
public class SourceMap {

    /** The class name mapping. */
    private Map<String, Class> classNames = new HashMap();

    /** The source map file. */
    private Path file = I.locate("sourcemap.xml").toAbsolutePath();

    /**
     * Get the classNames property of this {@link SourceMap}.
     * 
     * @return The classNames property.
     */
    public Map<String, Class> getClassNames() {
        return classNames;
    }

    /**
     * Set the classNames property of this {@link SourceMap}.
     * 
     * @param classNames The classNames value to set.
     */
    public void setClassNames(Map<String, Class> classNames) {
        this.classNames = classNames;
    }

    public void write() {
        I.write(this, file, false);
    }

    public void read() {
        classNames.clear();
        I.read(file, this);
    }

    /**
     * @param className
     * @return
     */
    public String decodeClassName(String className) {
        className = className.substring(5);

        Class clazz = classNames.get(className);

        if (clazz == null) {
            return className;
        }
        return clazz.getName();
    }
}
