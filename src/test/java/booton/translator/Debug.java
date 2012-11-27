/*
 * Copyright (C) 2009 Nameless Production Committee.
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

import java.util.List;

/**
 * @version 2009/08/02 12:28:11
 */
public class Debug {

    public static void dump(List<Node> nodes) {
        // for (Node node : nodes) {
        // dump(node);
        // }
    }

    public static void dump(Node node) {
        // System.out.print(node.id + "    in : " + format(node.incoming) + "     out : " +
        // format(node.outgoing) + "     back : " + format(node.backedges));
        //
        // System.out.println("");
    }

    private static String format(List<Node> nodes) {
        StringBuilder builder = new StringBuilder("[");

        for (Node node : nodes) {
            builder.append(node.id);
            builder.append(", ");
        }

        if (1 < builder.length()) {
            builder.delete(builder.length() - 2, builder.length());
        }

        builder.append("]");

        return builder.toString();
    }
}
