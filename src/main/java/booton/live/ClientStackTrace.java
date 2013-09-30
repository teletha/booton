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
import java.util.List;

/**
 * @version 2013/08/08 11:48:26
 */
public class ClientStackTrace {

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

    /**
     * <p>
     * Decode error message.
     * </p>
     * 
     * @param data
     * @param map
     * @return
     */
    public static Throwable decode(String data, Source... maps) {
        List<String> elements = new ArrayList();

        for (String line : data.split("\\r\\n")) {
            elements.add(line);
        }

        String className = maps[0].decodeClassName(elements.remove(0));
        String message = elements.remove(0);

        try {
            Throwable throwable = null;
            Class clazz = Class.forName(className);

            try {
                throwable = (Throwable) clazz.getConstructor(String.class).newInstance(message);
            } catch (NoSuchMethodException e) {
                throwable = (Throwable) clazz.getConstructor().newInstance();
            }

            List<StackTraceElement> stacks = new ArrayList();

            for (String line : elements) {
                String[] info = line.split(" ");

                for (Source source : maps) {
                    if (info[1].contains(source.name)) {
                        stacks.add(source.search(Integer.parseInt(info[2])));
                    }
                }
            }
            throwable.setStackTrace(stacks.toArray(new StackTraceElement[stacks.size()]));
            return throwable;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}