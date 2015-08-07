/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 2015/08/04 13:50:18
 */
public class Source {

    /** The re-usable pattern. */
    private static final Pattern pattern = Pattern.compile("^\\s*\\/\\/\\sclass\\s(.+)\\s(.+)");

    /** The source code name. */
    public final String name;

    /** The source code. */
    public final List<String> lines = new ArrayList();

    /** The class name mapping. */
    private final Map<String, String> classNames = new HashMap();

    /**
     * <p>
     * Create source code map.
     * </p>
     * 
     * @param lines A source code.
     */
    public Source(String name) {
        this.name = name;
    }

    /**
     * <p>
     * Record source code.
     * </p>
     * 
     * @param lines A code fragment to record.
     */
    public void add(CharSequence code) {
        String value = code.toString();

        int start = 0;
        int end = value.indexOf("\r\n", start);
        while (end != -1) {
            add(value.substring(start, end));

            start = end + 2;
            end = value.indexOf("\r\n", start);
        }
        add(value.substring(start));
    }

    /**
     * <p>
     * Record source code.
     * </p>
     * 
     * @param codes A code fragment to record.
     */
    public void add(List<String> codes) {
        // construct class name mapping
        for (String code : codes) {
            add(code);
        }
    }

    /**
     * <p>
     * Record source code.
     * </p>
     * 
     * @param lines A code fragment to record.
     */
    private void add(String code) {
        lines.add(code);

        Matcher matcher = pattern.matcher(code);

        if (matcher.matches()) {
            classNames.put(matcher.group(2), matcher.group(1));
        }
    }

    /**
     * <p>
     * Create stack trace by the specified line.
     * </p>
     * 
     * @param lineNumber
     */
    public StackTraceElement search(int lineNumber) {
        Pattern line = Pattern.compile("^\\s*\\/\\/\\s(\\d+)");
        String number = find(lineNumber - 1, line).group(1);

        Pattern pattern = Pattern.compile("^\\s*\\/\\/\\s+(.+)#(.+)\\(.*\\)");
        Matcher matcher = find(lineNumber, pattern);
        String fqcn = matcher.group(1);
        String method = matcher.group(2);
        int index = fqcn.lastIndexOf(".");
        String className = index == -1 ? fqcn : fqcn.substring(index + 1);
        index = className.indexOf("$");
        className = index == -1 ? className : className.substring(0, index);

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
        Matcher matcher = pattern.matcher(lines.get(start));

        while (!matcher.matches()) {
            matcher = pattern.matcher(lines.get(start--));
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

    /**
     * <p>
     * Helper method to find method block from the specified line number.
     * </p>
     * 
     * @param number
     * @return
     */
    public String findBlock(int number) {
        int start = findMethodStart(number);
        int end = findMethodEnd(number, lines.get(start).indexOf("//"));

        StringBuilder builder = new StringBuilder();

        for (int i = start; i < end; i++) {
            builder.append(lines.get(i).replaceAll("\t", "  "));

            if (i == number - 1) {
                builder.append("        <<<  ERROR");
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }

    /**
     * <p>
     * Search start position of the method declaration.
     * </p>
     * 
     * @param number
     * @return
     */
    private int findMethodStart(int number) {
        number = Math.min(number, lines.size() - 1);

        for (int i = number; 0 <= i; i--) {
            if (lines.get(i).contains(":function(")) {
                return i - 1;
            }
        }

        return 1;
    }

    /**
     * <p>
     * Search end position of the method declaration.
     * </p>
     * 
     * @param number
     * @return
     */
    private int findMethodEnd(int number, int size) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            builder.append("\t");
        }
        builder.append("}");

        String prefix = builder.toString();

        for (int i = number; i < lines.size(); i++) {
            if (lines.get(i).startsWith(prefix)) {
                return i + 1;
            }
        }
        return lines.size() - 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (String line : lines) {
            builder.append(line).append("\r\n");
        }
        return builder.toString();
    }
}
