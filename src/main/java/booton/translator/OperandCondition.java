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

/**
 * <h1>Algorithm for restoration of logical expression</h1>
 * <p>
 * Please note that the necessary information are transition label of JumpInstruction and
 * LabelInstruction when you restore the logical expression. Do not use other information because it
 * change depending on the content of the description of the logical expression.
 * </p>
 * 
 * @version 2013/08/31 21:33:37
 */
class OperandCondition extends Operand {

    /** The relational operator. */
    static final int AND = 0x00;

    /** The relational operator. */
    static final int OR = ~AND;

    /** The relational operator. */
    static final int EQ = 0x01;

    /** The relational operator. */
    static final int NE = ~EQ;

    /** The relational operator. */
    static final int GT = 0x02;

    /** The relational operator. */
    static final int LE = ~GT;

    /** The relational operator. */
    static final int LT = 0x03;

    /** The relational operator. */
    static final int GE = ~LT;

    /** The left operand of this conditional expression. */
    Operand left;

    /** The right operand of this conditional expression. */
    Operand right;

    /** The transition node. */
    final Node transition;

    Node transitionThen;

    /** The operator of this conditional expression. */
    private int operator;

    /** The flag of grouping. */
    private boolean group = false;

    /** The next transition node of the node that this condition belongs to. */
    Node next;

    /**
     * @param left
     * @param operator
     * @param right
     * @param transition
     */
    OperandCondition(Operand left, int operator, Operand right, Node transition) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.transition = transition;
    }

    /**
     * 
     */
    OperandCondition(OperandCondition left, OperandCondition right) {
        if (left.group || !(left.right instanceof OperandCondition)) {
            this.left = left;
            this.right = right;
            this.operator = OR;
        } else {
            this.left = left.left;
            this.right = new OperandCondition((OperandCondition) left.right, right);
            this.operator = left.operator;
        }
        this.transition = right.transition;
        this.next = right.next;

        if (left.transition != right.transition) {
            this.left.invert();
            this.operator = ~this.operator;
        }

        // Make group if left transition node equals to transition node or next node of the
        // right condition node.
        group = (left.transition == right.next || left.transition == right.transition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    int computeMultiplicity() {
        return left.computeMultiplicity() + right.computeMultiplicity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    InferredType infer() {
        return new InferredType(boolean.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Operand invert() {
        // invert each operands
        left.invert();
        right.invert();

        // invert operator
        operator = ~operator;

        // API definition
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    Operand disclose() {
        group = false;

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        // convert int to char if needed
        Class leftType = left.infer().type();
        Class rightType = right.infer().type();

        if (leftType == char.class && rightType != char.class) {
            right = right.cast(char.class);
        }

        if (rightType == char.class && leftType != char.class) {
            left = left.cast(char.class);
        }

        // write out
        StringBuilder builder = new StringBuilder();

        if (group) {
            builder.append('(');
        }

        builder.append(left);

        switch (this.operator) {
        case AND:
            builder.append("&&");
            break;

        case OR:
            builder.append("||");
            break;

        case EQ:
            builder.append("==");
            break;

        case NE:
            builder.append("!=");
            break;

        case LT:
            builder.append('<');
            break;

        case GT:
            builder.append('>');
            break;

        case LE:
            builder.append("<=");
            break;

        case GE:
            builder.append(">=");
            break;
        }

        builder.append(right);

        if (group) {
            builder.append(')');
        }

        // API definition
        return builder.toString();
    }
}
