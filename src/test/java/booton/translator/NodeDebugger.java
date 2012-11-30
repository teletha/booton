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

        FormattedBuilder builder = new FormattedBuilder();

        for (Node node : nodes) {
            builder.append(String.valueOf(node.id), max);
            builder.append("  in : ");
            builder.append(format(max, incoming, node.incoming));
            builder.append("out : ");
            builder.append(format(max, outgoing, node.outgoing));
            builder.append("back : ");
            builder.append(format(max, backedge, node.backedges));
            builder.append("code : ");
            builder.append(formatCodeFragment(node.stack));
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

    /**
     * Helper method to format code fragment.
     * 
     * @param operands
     * @return
     */
    private static String formatCodeFragment(List<Operand> operands) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < operands.size(); i++) {
            Operand operand = operands.get(i);
            builder.append(operand);
            builder.append(" [");
            if (operand instanceof OperandString) {
                builder.append("String");
            } else if (operand instanceof OperandExpression) {
                builder.append("Expression");
            } else if (operand instanceof OperandCondition) {
                builder.append("Condition");
            } else if (operand instanceof OperandArray) {
                builder.append("Array");
            } else if (operand instanceof OperandNumber) {
                builder.append("Number");
            } else {
                builder.append("Operand");
            }
            builder.append("]");

            if (i != operands.size() - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    /**
     * @version 2012/11/30 16:09:26
     */
    private static final class FormattedBuilder {

        /** The actual buffer. */
        private final StringBuilder builder = new StringBuilder();

        /** The tab length. */
        private final int tab = 4;

        /** The current message length. */
        private int count = 0;

        /**
         * Helper method to write message.
         * 
         * @param message
         * @return
         */
        private FormattedBuilder append(String message) {
            builder.append(message);

            // chainable API
            return this;
        }

        /**
         * Helper method to write message.
         * 
         * @param message
         * @return
         */
        private FormattedBuilder append(String message, int max) {
            builder.append(message);

            // calcurate required tab
            int requireTab = 1;

            while (requireTab * tab <= max) {
                requireTab++;
            }

            // calcurate remaining spaces
            int remaining = requireTab * tab - message.length();
            int actualTab = 0;

            while (0 < remaining - tab * actualTab) {
                actualTab++;
            }

            for (int i = 0; i < actualTab; i++) {
                builder.append('\t');
            }

            // chainable API
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return builder.toString();
        }
    }
}
