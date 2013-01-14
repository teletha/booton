/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import org.objectweb.asm.Type;

/**
 * @version 2013/01/14 11:59:19
 */
class ScriptBuffer {

    /** The actual buffer. */
    private final StringBuilder buffer = new StringBuilder();

    private int mark = 0;

    /** The current depth of indentation for debug. */
    private int depth = 0;

    /**
     * <p>
     * Append debug infomation.
     * </p>
     * 
     * @param owner
     * @param methodName
     * @param description
     */
    public void debug(Class owner, String methodName, String description) {
        line();
        buffer.append("// ");
        buffer.append(owner.getName()).append("#").append(methodName).append("(");

        Type type = Type.getMethodType(description);
        Type[] args = type.getArgumentTypes();

        for (int i = 0; i < args.length; i++) {
            buffer.append(args[i].getClassName());

            if (i < args.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append(")");
        line();
    }

    /**
     * <p>
     * Formt line for debug.
     * </p>
     * 
     * @return A chainable API.
     */
    public ScriptBuffer line() {
        // write line separator
        buffer.append("\r\n");

        // write indent
        for (int i = 0; i < depth; i++) {
            buffer.append('\t');
        }

        return this;
    }

    /**
     * <p>
     * Format code for degug.
     * </p>
     * 
     * @return A chainable API.
     */
    private ScriptBuffer startIndent() {
        depth++;
        return line();
    }

    /**
     * <p>
     * Format code for degug.
     * </p>
     * 
     * @return A chainable API.
     */
    private ScriptBuffer endIndent() {
        depth--;
        return line();
    }

    /**
     * Helper method to write script source.
     * 
     * @param fragments
     * @return
     */
    public ScriptBuffer append(Object... fragments) {
        for (Object fragment : fragments) {
            write(fragment);
        }

        // API definition
        return this;
    }

    /**
     * Helper method to write script source.
     * 
     * @param fragment
     * @return
     */
    private ScriptBuffer write(Object fragment) {
        String value = fragment.toString();
        int length = value.length();

        // brace makes indentation
        if (length != 0 && value.charAt(0) == '}') {
            int last = buffer.length() - 1;

            if (buffer.charAt(last) == '\t') {
                buffer.deleteCharAt(last);
                depth--;
            } else {
                endIndent();
            }
        }

        // write actual code
        buffer.append(fragment);

        // brace makes indentation
        if (length != 0) {
            char last = value.charAt(length - 1);

            switch (last) {
            case '{':
                startIndent();
                break;

            case ';':
                line();
                break;
            }
        }

        // API definition
        return this;
    }

    /**
     * Remove semicolon at the end.
     */
    void literalize() {
        int index = buffer.length() - 1;

        if (index != -1 && buffer.charAt(index) == ';') {
            buffer.deleteCharAt(index);
        }
    }

    /**
     * Clear data.
     */
    void clear() {
        buffer.delete(0, buffer.length());
    }

    void mark() {
        mark = buffer.length();
    }

    String toFragment() {
        return buffer.substring(mark);
    }

    /**
     * <p>
     * Optimize source code.
     * </p>
     */
    void optimize() {
        // Remove tail white spaces.
        while (Character.isWhitespace(buffer.charAt(buffer.length() - 1))) {
            buffer.deleteCharAt(buffer.length() - 1);
        }

        // Remove tail "return;" expression.
        int length = buffer.length();

        if (buffer.substring(length - 7, length).equals("return;")) {
            buffer.delete(length - 7, length);
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return buffer.toString();
    }
}
