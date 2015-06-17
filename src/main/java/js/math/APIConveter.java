/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import booton.translator.Translator;

/**
 * @version 2014/03/24 23:49:09
 */
class APIConveter {

    /**
     * <p>
     * API conversion.
     * </p>
     * 
     * @param integer
     * @return
     */
    static JSBigInteger $(BigInteger integer) {
        return new JSBigInteger("0");
    }

    /**
     * <p>
     * API conversion.
     * </p>
     * 
     * @param integer
     * @return
     */
    static BigInteger $(JSBigInteger integer) {
        return BigInteger.ZERO;
    }

    /**
     * <p>
     * API conversion.
     * </p>
     * 
     * @param value
     * @return
     */
    static JSBigDecimal $(BigDecimal value) {
        return new JSBigDecimal(value.toString());
    }

    /**
     * <p>
     * API conversion.
     * </p>
     * 
     * @param value
     * @return
     */
    static MathContext $(JSMathContext value) {
        return new MathContext(value.getPrecision(), value.getRoundingMode());
    }

    /**
     * <p>
     * API conversion.
     * </p>
     * 
     * @param value
     * @return
     */
    static JSMathContext $(MathContext value) {
        return new JSMathContext(value.getPrecision(), value.getRoundingMode());
    }

    /**
     * <p>
     * API conversion.
     * </p>
     * 
     * @param value
     * @return
     */
    static BigDecimal $(JSBigDecimal value) {
        return new BigDecimal(value.toString());
    }

    /**
     * @version 2014/03/15 10:24:09
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<APIConveter> {

        /**
         * <p>
         * API conversion.
         * </p>
         * 
         * @param value
         * @return
         */
        public String $(BigInteger value) {
            return param(0);
        }

        /**
         * <p>
         * API conversion.
         * </p>
         * 
         * @param value
         * @return
         */
        public String $(JSBigInteger value) {
            return param(0);
        }

        /**
         * <p>
         * API conversion.
         * </p>
         * 
         * @param value
         * @return
         */
        public String $(BigDecimal value) {
            return param(0);
        }

        /**
         * <p>
         * API conversion.
         * </p>
         * 
         * @param value
         * @return
         */
        public String $(JSBigDecimal value) {
            return param(0);
        }

        /**
         * <p>
         * API conversion.
         * </p>
         * 
         * @param value
         * @return
         */
        public String $(MathContext value) {
            return param(0);
        }

        /**
         * <p>
         * API conversion.
         * </p>
         * 
         * @param value
         * @return
         */
        public String $(JSMathContext value) {
            return param(0);
        }
    }
}
