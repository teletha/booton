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
}