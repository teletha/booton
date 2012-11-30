/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import java.util.Collections;
import java.util.List;

/**
 * @version 2012/11/30 15:31:13
 */
public class NodeDebugger {

    /**
     * <p>
     * Dump node tree.
     * </p>
     * 
     * @param nodes
     */
    public static void dump(List<Node> nodes) {
        System.out.println(format(nodes));
    }

    /**
     * <p>
     * Dump node tree.
     * </p>
     * 
     * @param node
     */
    public static void dump(Node node) {
        System.out.println(format(Collections.singletonList(node)));
    }

    /**
     * <p>
     * Helper method to format node tree.
     * </p>
     * 
     * @param nodes
     * @return
     */
    private static String format(List<Node> nodes) {
        // compute max id length
        int max = 1;

        for (Node node : nodes) {
            max = Math.max(max, String.valueOf(node.id).length());
        }

        int incoming = 0;
        int outgoing = 0;
        int backedge = 0;

        for (Node node : nodes) {
            incoming = Math.max(incoming, node.incoming.size() * max + (node.incoming.size() - 1) * 2);
            outgoing = Math.max(outgoing, node.outgoing.size() * max + (node.outgoing.size() - 1) * 2);
            backedge = Math.max(backedge, node.backedges.size() * max + (node.backedges.size() - 1) * 2);
        }

        StringBuilder builder = new StringBuilder();

        for (Node node : nodes) {
            builder.append(format(max, String.valueOf(node.id)));
            builder.append("  in : ");
            builder.append(format(max, incoming, node.incoming));
            builder.append("out : ");
            builder.append(format(max, outgoing, node.outgoing));
            builder.append("back : ");
            builder.append(format(max, backedge, node.backedges));
            builder.append("\r\n");
        }
        return builder.toString();
    }

    /**
     * Helper method to padding.
     * 
     * @param max
     * @param value
     * @return
     */
    private static String format(int max, String value) {
        if (max == value.length()) {
            return value;
        } else {
            // StringBuilder builder = new StringBuilder();
            //
            // for (int i = 0; i < max - value.length(); i++) {
            // builder.append(" ");
            // }
            // builder.append(value);
            //
            // return builder.toString();
            return value;
        }
    }

    /**
     * Helper method to padding.
     * 
     * @param max
     * @param nodes
     * @return
     */
    private static String format(int itemMax, int max, List<Node> nodes) {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < nodes.size(); i++) {
            builder.append(format(itemMax, String.valueOf(nodes.get(i).id)));

            if (i != nodes.size() - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");

        int remaining = max - builder.length() + 2;
        int count = (remaining - remaining % 4) / 4 + (remaining % 4 == 0 ? 1 : 2);

        for (int i = 0; i < count; i++) {
            builder.append("\t");
        }

        return format(max, builder.toString());
    }
}
