/*
 * Copyright (C) 2008 Nameless Production Committee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package booton.translator;

import org.objectweb.asm.Type;

/**
 * @version 2009/08/06 9:03:19
 */
class ScriptBuffer {

    /** The actual buffer. */
    private final StringBuilder buffer = new StringBuilder();

    private int mark = 0;

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
        buffer.append("\r\n// ");
        buffer.append(owner.getName()).append("#").append(methodName).append("(");

        Type type = Type.getMethodType(description);
        Type[] args = type.getArgumentTypes();

        for (int i = 0; i < args.length; i++) {
            buffer.append(args[i].getClassName());

            if (i < args.length - 1) {
                buffer.append(", ");
            }
        }
        buffer.append(")\r\n");
    }

    /**
     * Helper method to write script source.
     * 
     * @param fragments
     * @return
     */
    public ScriptBuffer append(Object... fragments) {
        for (Object fragment : fragments) {
            buffer.append(fragment);
        }

        // API definition
        return this;
    }

    /**
     * Helper method to write script source.
     * 
     * @param fragments
     * @return
     */
    ScriptBuffer append(Object fragments) {
        buffer.append(fragments);

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

    void optimize() {
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
