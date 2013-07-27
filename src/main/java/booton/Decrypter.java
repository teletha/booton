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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import kiss.I;

/**
 * @version 2013/07/28 3:08:43
 */
public class Decrypter {

    /** The class name mapping. */
    public Map<String, Class> classNames = new HashMap();

    /** The method name mapping. */
    public Map<String, String> methodNames = new HashMap();

    /** The source infomation. */
    private final Path file = I.locate("source-info.xml").toAbsolutePath();

    /**
     * 
     */
    public Decrypter() {
        if (Files.exists(file)) {
            I.read(file, this);
        }
    }

    /**
     * <p>
     * Save decrypter info.
     * </p>
     */
    public void save() {
        I.write(this, file, false);
    }

    /**
     * <p>
     * Decrypt method name.
     * </p>
     * 
     * @param name
     * @return
     */
    public String decryptMethodName(String name) {
        if (name.startsWith(".")) {
            name = name.substring(1);
        }

        String decrypted = methodNames.get(name);
        return decrypted == null ? name : decrypted;
    }

    /**
     * <p>
     * Decrypt class name.
     * </p>
     * 
     * @param name
     * @return
     */
    public String decryptClassName(String name) {
        if (name.startsWith("boot.")) {
            name = name.substring(5);
        }

        Class decrypted = classNames.get(name);
        return decrypted == null ? name : decrypted.getName();
    }
}
