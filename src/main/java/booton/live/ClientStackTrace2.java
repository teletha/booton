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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version 2013/05/26 11:31:27
 */
public class ClientStackTrace2 {

    /**
     * <p>
     * Encode error message.
     * </p>
     * 
     * @param throwable
     * @return
     */
    public static String encode(Throwable throwable) {
        StringBuilder builder = new StringBuilder();
        builder.append(throwable.getClass().getName()).append("\r\n");
        builder.append(throwable.getMessage()).append("\r\n");

        for (StackTraceElement element : throwable.getStackTrace()) {
            builder.append(element.getMethodName())
                    .append(" ")
                    .append(element.getFileName())
                    .append(" ")
                    .append(element.getLineNumber())
                    .append("\r\n");
        }
        return builder.toString();
    }

    public static void decode(String data, String source) {
        Source application = new Source(source);
        List<String> elements = new ArrayList();

        for (String line : data.split("\\r\\n")) {
            elements.add(line);
        }
        String className = application.decodeClassName(elements.remove(0));
        String message = elements.remove(0);

        System.err.println("Exception in thread \"main\" " + className + ": " + message);

        for (String element : elements) {
            String[] info = element.split(" ");

            application.search(Integer.parseInt(info[2]));
        }
    }

    /**
     * @version 2013/07/28 3:43:53
     */
    private static class Source {

        /** The source code. */
        private final String[] lines;

        /** The class name mapping. */
        private final Map<String, String> classNames = new HashMap();

        /**
         * @param file
         */
        private Source(String source) {
            lines = source.split("\\r\\n");

            // construct class name mapping
            Pattern pattern = Pattern.compile("^\\s*//\\sclass\\s(.+)\\s(.+)");

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
        private void search(int lineNumber) {
            Pattern line = Pattern.compile("^\\s*//\\s(\\d+)");
            String number = find(lineNumber - 1, line).group(1);

            Pattern pattern = Pattern.compile("^\\s*//\\s+(.+)#(.+)\\(.*\\)");
            Matcher matcher = find(lineNumber, pattern);
            String className = matcher.group(1);
            String method = matcher.group(2);

            System.err.println("\tat " + className + "." + method + "(" + className.substring(className.lastIndexOf(".") + 1) + ".java:" + number + ")");
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
        private String decodeClassName(String name) {
            if (name.startsWith("boot.")) {
                name = name.substring(5);
            }

            String decrypted = classNames.get(name);
            return decrypted == null ? name : decrypted;
        }
    }
}