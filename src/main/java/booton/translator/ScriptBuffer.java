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

import kiss.I;

import org.objectweb.asm.Type;

import booton.BootonConfiguration;

/**
 * @version 2013/04/15 11:12:28
 */
class ScriptBuffer {

    /** The optimization flag. */
    private final BootonConfiguration config = I.make(BootonConfiguration.class);

    /** The actual buffer. */
    private final StringBuilder buffer = new StringBuilder();

    private int mark = 0;

    /** The current depth of indentation for debug. */
    private int depth = 0;

    /**
     * <p>
     * </p>
     * 
     * @param comment
     */
    public void comment(Object comment) {
        if (!config.optimization) {
            buffer.append("// ");
            write(comment);
            line();
        }
    }

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
        if (!config.optimization) {
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
    }

    /**
     * <p>
     * Formt line for debug.
     * </p>
     * 
     * @return A chainable API.
     */
    public ScriptBuffer line() {
        if (!config.optimization) {
            // write line separator
            buffer.append("\r\n");

            // write indent
            for (int i = 0; i < depth; i++) {
                buffer.append('\t');
            }
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
     * <p>
     * Helper method to write script code with white space.
     * </p>
     */
    public ScriptBuffer write(Object... fragments) {
        for (int i = 0; i < fragments.length; i++) {
            write(fragments[i], false);

            if (!config.optimization && i + 1 != fragments.length) {
                write(" ");
            }
        }
        // API definition
        return this;
    }

    /**
     * Helper method to write String literal.
     * 
     * @param fragments
     * @return
     */
    public ScriptBuffer string(String literal) {
        return append('"', literal, '"');
    }

    /**
     * <p>
     * Helper method to write separator ",".
     * </p>
     */
    public ScriptBuffer separator() {
        return append(",").line();
    }

    /**
     * <p>
     * Optimize source code.
     * </p>
     * <ol>
     * <li>Remove tail whitespaces.</li>
     * <li>Remove tail separator comma.</li>
     * <li>Remove tail "return;" expression.</li>
     * </ol>
     */
    public void optimize() {
        remove(",");
        remove("return;");
    }

    /**
     * <p>
     * Remove tailing characters if it is matched.
     * </p>
     * 
     * @param c A character to remove.
     * @return A last position.
     */
    private int remove(String chracters) {
        int last = removeWhitespaces();
        int length = chracters.length() - 1;

        if (last < length) {
            return last;
        }

        if (buffer.substring(last - length).equals(chracters)) {
            buffer.delete(last - length, last + 1);
            last -= length;
        }
        return last;
    }

    /**
     * <p>
     * Remove tailing whitespaces.
     * </p>
     * 
     * @return A last position.
     */
    private int removeWhitespaces() {
        int last = buffer.length() - 1;

        if (last < 0) {
            return 0;
        }

        while (Character.isWhitespace(buffer.charAt(last))) {
            buffer.deleteCharAt(last--);
        }
        return last;
    }

    /**
     * Helper method to write script source.
     * 
     * @param fragment
     * @return
     */
    private ScriptBuffer write(Object fragment) {
        return write(fragment, true);
    }

    /**
     * Helper method to write script source.
     * 
     * @param fragment
     * @return
     */
    private ScriptBuffer write(Object fragment, boolean line) {
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
        buffer.append(value);

        // brace makes indentation
        if (length != 0) {
            char last = value.charAt(length - 1);

            switch (last) {
            case '{':
                startIndent();
                break;

            case ';':
                if (line) line();
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return buffer.toString();
    }
}
