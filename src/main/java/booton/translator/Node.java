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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import booton.translator.JavaMethodCompiler.TryCatch;

/**
 * @version 2013/01/14 12:28:02
 */
class Node {

    /** The re-usable operand. */
    private static final Operand END = new OperandExpression(";");

    /** The identified label for this node. */
    final int id;

    /** The actual operand stack. */
    final LinkedList<Operand> stack = new LinkedList();

    /** The node list. */
    final CopyOnWriteArrayList<Node> incoming = new CopyOnWriteArrayList();

    /** The node list. */
    final CopyOnWriteArrayList<Node> outgoing = new CopyOnWriteArrayList();

    /** The node list. */
    final CopyOnWriteArrayList<Node> backedges = new CopyOnWriteArrayList();

    /** The previous node. */
    Node previous;

    /** The following node. */
    Node follower;

    /** The dominator try-catch block. */
    Deque<TryCatch> catches = new ArrayDeque();

    /** This node is switch starting node. */
    private Switch switchy;

    /** The dominator node. */
    private Node dominator;

    // /** The finally blocks. */
    // private List<TryBlock> catcheTries = new ArrayList();
    //

    //
    // /** The finally blocks. */
    // private List<TryBlock> finallyTries = new ArrayList();
    //
    // /** The finally blocks. */
    // private Deque<TryBlock> finallies = new ArrayDeque();

    /** The flag whether this node has already written or not. */
    private boolean written = false;

    private int stoppable = 0;

    /**
     * @param label
     */
    Node(int id) {
        this.id = id;
    }

    /**
     * <p>
     * Helper method to add new operand to the top of operands stack.
     * </p>
     * 
     * @param operand A new operand to add.
     */
    final void addOperand(Object operand) {
        if (operand instanceof Operand) {
            stack.add((Operand) operand);
        } else if (operand instanceof Integer) {
            stack.add(new OperandNumber((Integer) operand));
        } else {
            stack.add(new OperandExpression(operand));
        }
    }

    /**
     * @param operands
     */
    final void addExpression(Object... operands) {
        for (Object operand : operands) {
            addOperand(operand);
        }
        stack.add(END);
    }

    /**
     * <p>
     * Helper method to add new conditional operand on the top of this stack.
     * </p>
     * 
     * @param left A left operand.
     * @param operator A condition operator.
     * @param right A right operand.
     * @param transition A transition node.
     */
    final void condition(Operand left, int operator, Operand right, Node transition) {
        stack.add(new OperandCondition(left, operator, right, transition));
    }

    /**
     * <p>
     * Helper method to remove the operand which is stored in the specified index from the operands
     * stack.
     * </p>
     * 
     * @param index An index that you want to remove from the operands stack.
     * @return A removed operand.
     */
    final Operand remove(int index) {
        return remove(index, true);
    }

    /**
     * <p>
     * Helper method to remove the operand which is stored in the specified index from the operands
     * stack.
     * </p>
     * 
     * @param index An index that you want to remove from the operands stack.
     * @return A removed operand.
     */
    final Operand remove(int index, boolean processDuplication) {
        // Calculate index
        index = stack.size() - 1 - index;

        if (index < 0) {
            // Remove operand from the previous node if we can.
            //
            // calculated = stack.size() - 1 - index
            // index - stack.size() = -calculated - 1;
            return previous == null ? null : previous.remove(-index - 1);
        }

        // Retrieve and remove it
        Operand operand = stack.remove(index);

        if (processDuplication && operand.duplicated) {
            operand.duplicated = false;

            // Duplicate pointer
            stack.add(index, operand);
        }

        // API definition
        return operand;
    }

    /**
     * <p>
     * Helper method to peek the operand which is stored in the specified index from the operands
     * stack.
     * </p>
     * 
     * @param index An index that you want to peek from the operands stack.
     * @return A target operand.
     */
    final Operand peek(int index) {
        // Calculate index
        index = stack.size() - 1 - index;

        if (index < 0) {
            // Peek operand from the previous node if we can.
            //
            // calculated = stack.size() - 1 - index
            // index - stack.size() = -calculated - 1;
            return previous == null ? null : previous.peek(-index - 1);
        }

        // Retrieve it
        Operand operand = stack.get(index);

        // API definition
        return operand;
    }

    /**
     * Helper method to join latest two operands.
     * 
     * @param separator
     * @return Chainable API.
     */
    final Node join(String separator) {
        stack.add(new OperandExpression(remove(1) + separator + remove(0)));

        // API definition
        return this;
    }

    /**
     * <p>
     * Helper method to enclose current opperand.
     * </p>
     * 
     * @return Chainable API.
     */
    final Node enclose() {
        stack.add(new OperandExpression("(" + remove(0) + ")"));

        // API definition
        return this;
    }

    /**
     * <p>
     * Set catch block for this node.
     * <p>
     * 
     * @param block
     */
    final void addCatch(TryCatch block) {
        catches.add(block);

        if (block.next != null) {
            block.end.stoppable += block.next.incoming.size();
        }

        // //
        // for (TryCatch item : catcheTries) {
        // if (item.base == block.base && item.end == block.end) {
        // return;
        // }
        // }
        //
        // catcheTries.add(block);
        // block.end.stoppable++;
    }

    // /**
    // * <p>
    // * Set finally block for this node.
    // * <p>
    // *
    // * @param block
    // */
    // final void addFinally(TryBlock block) {
    // for (TryBlock item : finallyTries) {
    // if (item.start == block.start) {
    // return;
    // }
    // }
    //
    // finallies.add(block);
    // finallyTries.add(block);
    //
    // block.start.stoppable += block.start.incoming.size();
    // block.end.stoppable += block.end.incoming.size();
    //
    // }

    /**
     * Helper method to check whether the specified node dominate this node or not.
     * 
     * @param dominator A dominator node.
     * @return A result.
     */
    private boolean hasDominator(Node dominator) {
        Node current = this;

        while (current != null) {
            if (current == dominator) {
                return true;
            }
            current = current.getDominator();
        }

        // Not Found
        return false;
    }

    /**
     * Compute the immediate dominator of this node.
     * 
     * @return A dominator node. If this node is root, <code>null</code>.
     */
    private Node getDominator() {
        // check cache
        if (dominator == null) {
            // We must search a immediate dominator.
            //
            // At first, we can ignore the older incoming nodes.
            List<Node> candidates = new CopyOnWriteArrayList(incoming);

            // compute backedges
            for (Node node : candidates) {
                if (backedges.contains(node)) {
                    candidates.remove(node);
                }
            }

            int size = candidates.size();

            switch (size) {
            case 0: // this is root node
                dominator = null;
                break;

            case 1: // only one incoming node
                dominator = candidates.get(0);
                break;

            default: // multiple incoming nodes
                Node candidate = candidates.get(0);

                while (true) {
                    boolean result = true;

                    for (int i = 1; i < size; i++) {
                        if (!candidates.get(i).hasDominator(candidate)) {
                            result = false;
                            break;
                        }
                    }

                    if (result) {
                        dominator = candidate;
                        break;
                    } else {
                        if (candidate == null) {
                            return null;
                        }
                        candidate = candidate.getDominator();
                    }
                }
                break;
            }
        }

        // API definition
        return dominator;
    }

    /**
     * Helper method to search the nearest common dominator for this node and the specified node.
     * 
     * @param node A target node.
     * @return A dominator. If it is not found, <code>null</code>.
     */
    private Node getNearestCommonDominator(Node node) {
        Node current = this;

        while (current != null) {
            if (node.hasDominator(current)) {
                return current;
            }
            current = current.getDominator();
        }

        return null;
    }

    /**
     * <p>
     * Write script fragment.
     * </p>
     * 
     * @param buffer
     */
    void write(ScriptBuffer buffer) {
        if (!written) {
            written = true;

            // =============================================================
            // Switch Block
            // =============================================================
            // Switch block is independent from other blocks, so we must return at the end.
            if (switchy != null) {
                Node exit = switchy.searchExit();

                // enter switch
                buffer.append("switch(", switchy.value, "){");

                // each cases
                for (Node node : switchy.cases()) {
                    for (int value : switchy.values(node)) {
                        buffer.append("case ", value, ":").line();
                    }
                    node.write(buffer);
                }

                // default case
                if (!switchy.noDefault) {
                    buffer.append("default:").line();
                    switchy.defaults.write(buffer);
                }

                // exit switch
                buffer.append("}").line();

                // write following nodes if needed
                if (exit != null) exit.write(buffer);

                return; // must
            }

            // =============================================================
            // Other Block
            // =============================================================
            // check try-catch-finally
            if (!catches.isEmpty()) {
                buffer.append("try{");
            }

            int outs = outgoing.size();
            int backs = backedges.size();

            if (outs == 0) {
                // end node
                buffer.append(this);
            } else if (outs == 1) {
                // do while or normal
                if (backs == 0) {
                    // normal node with follower
                    buffer.append(this);
                    process(outgoing.get(0), buffer);
                } else {
                    // do while

                    // setup condition expression node
                    Node condition = backedges.get(0);
                    condition.written = true;

                    // setup actual do-while block and its following node
                    condition.follower = condition.outgoing.get(condition.outgoing.size() - 1);

                    // write script fragment
                    buffer.append("l", condition.id, ":do {");
                    buffer.append(this);
                    process(this.outgoing.get(0), buffer);
                    buffer.append("} while (", condition, ")");
                    condition.process(condition.follower, buffer);
                }
            } else if (outs == 2) {
                // while, for or if
                if (backs == 0) {
                    // if
                    OperandCondition ccc = (OperandCondition) stack.peekLast();

                    if (ccc != null && ccc.next == outgoing.get(0)) {
                        ccc.invert();
                    }

                    if (outgoing.get(0).incoming.size() == 1) {
                        buffer.append("if(", this, "){");
                        process(outgoing.get(0), buffer);
                        buffer.append("}else{");
                        process(outgoing.get(1), buffer);
                        buffer.append("}");
                        process(follower, buffer);
                    } else {
                        buffer.append("if(", this, "){");
                        buffer.append("}else{");
                        process(outgoing.get(1), buffer);
                        buffer.append("}");
                        process(outgoing.get(0), buffer);
                    }
                } else if (backs == 1) {
                    // while or for
                    if (backedges.get(0).outgoing.size() == 1) {
                        // for

                        // setup update expression node
                        Node update = backedges.get(0);
                        update.written = true;

                        // literalize
                        if (update.stack.peekLast() == END) {
                            update.remove(0);
                        }

                        // setup following node
                        follower = outgoing.get(1);

                        // write script fragment
                        buffer.append("l", id, ":for (;", this, ";", update, ") {");
                        process(outgoing.get(0), buffer);
                        buffer.append("}");
                        process(follower, buffer);
                    } else {
                        // while with break only

                        // setup following node
                        follower = outgoing.get(1);

                        // write script fragment
                        buffer.append("l", id, ":while (", this, ") {");
                        process(outgoing.get(0), buffer);
                        buffer.append("}");
                        process(follower, buffer);
                    }
                } else {
                    // while with continue and break

                    // setup following node
                    follower = outgoing.get(1);

                    // write script fragment
                    buffer.append("l", id, ":while (", this, ") {");
                    process(outgoing.get(0), buffer);
                    buffer.append("}");
                    process(follower, buffer);
                }
            }

            if (!catches.isEmpty()) {
                // try-catch
                if (catches.size() != 0) {
                    buffer.append("} catch ($) {");

                    Node next = null;
                    Iterator<TryCatch> iterator = catches.descendingIterator();

                    while (iterator.hasNext()) {
                        TryCatch block = iterator.next();

                        buffer.append("if ($ instanceof " + block.exception + ") {");
                        block.handler.write(buffer);
                        buffer.append("}");

                        next = block.next;
                    }
                    buffer.append("}");

                    process(next, buffer);
                }
            }
            // for (TryCatch block : tries) {
            // if (block.isCompleted()) {
            // process(block.handler, buffer);
            // }
            // }

            // // check try-catch-finally
            // if (catches.size() != 0 || finallies.size() != 0) {
            // Node end = null;
            //
            // // catch
            // if (catches.size() != 0) {
            // buffer.append("} catch ($) {");
            //
            // Iterator<TryBlock> iterator = catches.descendingIterator();
            //
            // while (iterator.hasNext()) {
            // TryBlock block = iterator.next();
            //
            // buffer.append("if ($ instanceof " + block.exception + ") {");
            // block.start.write(buffer);
            // buffer.append("}");
            //
            // end = block.end;
            // // process2(end, buffer);
            // }
            // buffer.append("}");
            // }
            //
            // // finally
            // if (finallies.size() != 0) {
            // Iterator<TryBlock> iterator = finallies.descendingIterator();
            //
            // while (iterator.hasNext()) {
            // TryBlock block = iterator.next();
            //
            // if (catches.size() == 0) {
            // buffer.append("} finally {");
            // } else {
            // buffer.append(" finally {");
            // }
            //
            // block.start.write(buffer);
            // buffer.append("}");
            //
            // end = block.end;
            // process2(end, buffer);
            // }
            // }
            //
            // process2(end, buffer);
            // // root.start.process(root.end, buffer);
            // }
        }
    }

    private void process2(Node dest, ScriptBuffer buffer) {
        if (dest != null) {
            // if (dest.stoppable != 0) {
            // dest.stoppable--;
            // } else {
            dest.write(buffer);
            // }
        }
    }

    /**
     * Helper method to process script writing.
     * 
     * @param dest
     * @param buffer
     */
    private void process(Node dest, ScriptBuffer buffer) {
        if (dest != null) {
            if (dest.stoppable != 0) {
                dest.stoppable--;
                return;
            }

            Node dominator = dest.getDominator();

            if (dominator == null || dominator == this) {
                // normal process
                dest.write(buffer);
                return;
            }

            if (hasDominator(dest)) {
                buffer.append("continue l", dest.id, ";");
                return;
            }

            if (dominator.backedges.size() == 0) {
                // stop here
                dest.getDominator().follower = dest;
            } else {
                buffer.append("break l", dominator.id, ";");
            };
        }
    }

    // /**
    // * Helper method to process script writing.
    // *
    // * @param dest
    // * @param buffer
    // */
    // private void process(ScriptBuffer buffer) {
    // Node dest = follower;
    //
    // if (dest != null) {
    // Node dominator = dest.getDominator();
    //
    // if (dominator == null || dominator == this) {
    // // normal process
    // dest.write(buffer);
    // return;
    // }
    //
    // if (hasDominator(dest)) {
    // buffer.append("continue l", dest.id, ";");
    // return;
    // }
    //
    // if (dominator.backedges.size() == 0) {
    // // stop here
    // dest.getDominator().follower = dest;
    // } else {
    // buffer.append("break l", dominator.id, ";");
    // };
    // }
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Operand operand : stack) {
            builder.append(operand);
        }
        return builder.toString();
    }

    /**
     * @param out
     */
    final void disconnect(Node out) {
        outgoing.remove(out);
        out.incoming.remove(this);
    }

    /**
     * @param node
     */
    final void connect(Node node) {
        outgoing.addIfAbsent(node);
        node.incoming.addIfAbsent(this);
    }

    /**
     * <p>
     * Create switch statement.
     * </p>
     * 
     * @param defaults A default node.
     * @param keys A case key values.
     * @param cases A list of case nodes.
     */
    final void createSwitch(Node defaults, int[] keys, List<Node> cases) {
        switchy = new Switch(this, defaults, keys, cases);

        // connect enter node with each case node
        for (Node node : cases) {
            if (node != defaults) {
                connect(node);
            }
        }

        // connect enter node with default node
        connect(defaults);
    }

    /**
     * @version 2013/01/23 9:25:08
     */
    static class Switch {

        /** The entering node. */
        private final Node enter;

        /** The evaluated value. */
        private final Operand value;

        /** The default node of this switch statement. */
        private final Node defaults;

        /** The case nodes of this switch statement. */
        private final List<Node> cases;

        /** The case value of this switch statement. */
        private final List<Integer> keys = new ArrayList();

        /** Whether this switch has default node or not. */
        private boolean noDefault = false;

        /**
         * <p>
         * Creat switch block infomation holder.
         * </p>
         * 
         * @param enter
         * @param defaults
         * @param keys
         * @param cases
         */
        private Switch(Node enter, Node defaults, int[] keys, List<Node> cases) {
            this.enter = enter;
            this.value = enter.remove(0);
            this.defaults = defaults;
            this.cases = cases;

            for (int key : keys) {
                this.keys.add(key);
            }
        }

        /**
         * <p>
         * Find all case values for the specified node.
         * </p>
         * 
         * @param node A target node.
         * @return A collected case values.
         */
        private List<Integer> values(Node node) {
            CopyOnWriteArrayList<Integer> values = new CopyOnWriteArrayList();

            for (int i = 0; i < cases.size(); i++) {
                if (cases.get(i) == node) {
                    values.addIfAbsent(keys.get(i));
                }
            }
            return values;
        }

        /**
         * <p>
         * Find all unique cases for the specified node.
         * </p>
         * 
         * @param node A target node.
         * @return A collected case values.
         */
        private List<Node> cases() {
            CopyOnWriteArrayList<Node> nodes = new CopyOnWriteArrayList();

            for (int i = 0; i < cases.size(); i++) {
                if (cases.get(i) != defaults) {
                    nodes.addIfAbsent(cases.get(i));
                }
            }
            return nodes;
        }

        /**
         * <p>
         * Search exit node of this switch block.
         * </p>
         * 
         * @return Null or exit node.
         */
        private Node searchExit() {
            if (defaults.outgoing.isEmpty() && defaults.incoming.contains(enter)) {
                // default node is no exist
                noDefault = true;

                for (Node node : defaults.incoming) {
                    if (node != enter) {
                        node.addExpression("break");
                    }
                }
                return defaults;
            }

            List<Node> nodes = new LinkedList();
            nodes.addAll(defaults.outgoing);

            while (!nodes.isEmpty()) {
                Node node = nodes.remove(0);

                if (node.getDominator() == enter) {
                    // add break statement to each incoming node
                    for (Node incoming : node.incoming) {
                        incoming.addExpression("break");
                    }

                    return node;
                }
                nodes.addAll(node.outgoing);
            }
            return null;
        }

        /**
         * <p>
         * Helper method to detect special enum method.
         * </p>
         * 
         * @param name
         * @param description
         * @return
         */
        static boolean isEnumSwitchTable(String name, String description) {
            // For Eclipse JDT compiler.
            if (name.startsWith("$SWITCH_TABLE$")) {
                return true;
            }

            // For JDK compiler.
            if (name.startsWith("$SwitchMap$")) {
                return true;
            }
            return false;
        }
    }
}
