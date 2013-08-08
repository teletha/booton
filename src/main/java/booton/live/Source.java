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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 2013/08/08 11:48:31
 */
public class Source {

    /** The source code name. */
    public final String name;

    /** The source code. */
    private final String[] lines;

    /** The class name mapping. */
    private final Map<String, String> classNames = new HashMap();

    /**
     * <p>
     * Create source code map.
     * </p>
     * 
     * @param source A source code.
     */
    public Source(String name, String source) {
        this(name, source.split("\\r\\n"));
    }

    /**
     * <p>
     * Create source code map.
     * </p>
     * 
     * @param lines A source code.
     */
    public Source(String name, List<String> lines) {
        this(name, lines.toArray(new String[lines.size()]));
    }

    /**
     * <p>
     * Create source code map.
     * </p>
     * 
     * @param lines A source code.
     */
    public Source(String name, String[] lines) {
        this.name = name;
        this.lines = lines;

        // construct class name mapping
        Pattern pattern = Pattern.compile("^\\s*\\/\\/\\sclass\\s(.+)\\s(.+)");

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);

            if (matcher.matches()) {
                classNames.put(matcher.group(2), matcher.group(1));
            }
        }
    }

    /**
     * <p>
     * </p>
     * 
     * @param lineNumber
     */
    StackTraceElement search(int lineNumber) {
        Pattern line = Pattern.compile("^\\s*\\/\\/\\s(\\d+)");
        String number = find(lineNumber - 1, line).group(1);

        Pattern pattern = Pattern.compile("^\\s*\\/\\/\\s+(.+)#(.+)\\(.*\\)");
        Matcher matcher = find(lineNumber, pattern);
        String fqcn = matcher.group(1);
        String method = matcher.group(2);
        int index = fqcn.lastIndexOf(".");
        String className = index == -1 ? fqcn : fqcn.substring(index + 1);

        return new StackTraceElement(fqcn, method, className + ".java", Integer.parseInt(number));
    }

    /**
     * <p>
     * </p>
     * 
     * @param start
     * @param pattern
     * @return
     */
    private Matcher find(int start, Pattern pattern) {
        Matcher matcher = pattern.matcher(lines[start]);

        while (!matcher.matches()) {
            matcher = pattern.matcher(lines[start--]);
        }
        return matcher;
    }

    /**
     * <p>
     * Decrypt class name.
     * </p>
     * 
     * @param name
     * @return
     */
    String decodeClassName(String name) {
        if (name.startsWith("boot.")) {
            name = name.substring(5);
        }

        String decrypted = classNames.get(name);
        return decrypted == null ? name : decrypted;
    }
}