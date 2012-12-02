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

import java.util.List;

/**
 * @version 2012/12/02 13:48:37
 */
class TranslatableTranslator extends Translator<Translatable> {

    /**
     * {@inheritDoc}
     */
    @Override
    String translateMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
        StringBuilder builder = new StringBuilder();
        builder.append(context.get(0).toString());
        builder.append('.').append(name).append('(');
        for (int i = 0; i < types.length; i++) {
            builder.append(context.get(i + 1).cast(types[i]));

            if (i != types.length - 1) {
                builder.append(',');
            }
        }
        builder.append(')');

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    String translateStaticMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append('(');
        for (int i = 0; i < types.length; i++) {
            builder.append(context.get(i + 1).cast(types[i]));

            if (i != types.length - 1) {
                builder.append(',');
            }
        }
        builder.append(')');

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    String translateStaticField(Class owner, String fieldName, boolean isNotStatic) {
        return fieldName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    String translateSuperMethod(Class owner, String name, String desc, Class[] types, List<Operand> context) {
        return super.translateSuperMethod(owner, name, desc, types, context);
    }

    /**
     * <p>
     * Helper method to write method call.
     * </p>
     * 
     * @param name
     * @param types
     * @param context
     * @return
     */
    private String writeMethodCall(String name, Class[] types, List<Operand> context) {
        StringBuilder builder = new StringBuilder();
        builder.append(context.get(0).toString());
        builder.append('.').append(name).append('(');
        for (int i = 0; i < types.length; i++) {
            builder.append(context.get(i + 1).cast(types[i]));

            if (i != types.length - 1) {
                builder.append(',');
            }
        }
        builder.append(')');

        return builder.toString();
    }
}
