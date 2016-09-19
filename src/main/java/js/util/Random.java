/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/02/07 10:29:01
 */
@JavaAPIProvider(java.util.Random.class)
class Random {

    /**
     * Returns the next pseudorandom, uniformly distributed {@code int} value from this random
     * number generator's sequence. The general contract of {@code nextInt} is that one {@code int}
     * value is pseudorandomly generated and returned. All 2<sup>32</sup> possible {@code int}
     * values are produced with (approximately) equal probability.
     * <p>
     * The method {@code nextInt} is implemented by class {@code Random} as if by:
     * 
     * <pre> {@code
     * public int nextInt() {
     *   return next(32);
     * }}</pre>
     *
     * @return the next pseudorandom, uniformly distributed {@code int} value from this random
     *         number generator's sequence
     */
    public int nextInt() {
        return nextInt(Integer.MAX_VALUE);
    }

    /**
     * Returns a pseudorandom, uniformly distributed {@code int} value between 0 (inclusive) and the
     * specified value (exclusive), drawn from this random number generator's sequence. The general
     * contract of {@code nextInt} is that one {@code int} value in the specified range is
     * pseudorandomly generated and returned. All {@code bound} possible {@code int} values are
     * produced with (approximately) equal probability. The method {@code nextInt(int bound)} is
     * implemented by class {@code Random} as if by:
     * 
     * <pre> {@code
     * public int nextInt(int bound) {
     *   if (bound <= 0)
     *     throw new IllegalArgumentException("bound must be positive");
     *
     *   if ((bound & -bound) == bound)  // i.e., bound is a power of 2
     *     return (int)((bound * (long)next(31)) >> 31);
     *
     *   int bits, val;
     *   do {
     *       bits = next(31);
     *       val = bits % bound;
     *   } while (bits - val + (bound-1) < 0);
     *   return val;
     * }}</pre>
     * <p>
     * The hedge "approximately" is used in the foregoing description only because the next method
     * is only approximately an unbiased source of independently chosen bits. If it were a perfect
     * source of randomly chosen bits, then the algorithm shown would choose {@code int} values from
     * the stated range with perfect uniformity.
     * <p>
     * The algorithm is slightly tricky. It rejects values that would result in an uneven
     * distribution (due to the fact that 2^31 is not divisible by n). The probability of a value
     * being rejected depends on n. The worst case is n=2^30+1, for which the probability of a
     * reject is 1/2, and the expected number of iterations before the loop terminates is 2.
     * <p>
     * The algorithm treats the case where n is a power of two specially: it returns the correct
     * number of high-order bits from the underlying pseudo-random number generator. In the absence
     * of special treatment, the correct number of <i>low-order</i> bits would be returned. Linear
     * congruential pseudo-random number generators such as the one implemented by this class are
     * known to have short periods in the sequence of values of their low-order bits. Thus, this
     * special case greatly increases the length of the sequence of values returned by successive
     * calls to this method if n is a small power of two.
     *
     * @param bound the upper bound (exclusive). Must be positive.
     * @return the next pseudorandom, uniformly distributed {@code int} value between zero
     *         (inclusive) and {@code bound} (exclusive) from this random number generator's
     *         sequence
     * @throws IllegalArgumentException if bound is not positive
     * @since 1.2
     */
    public int nextInt(int bound) {
        return (int) Math.floor(Math.random() * bound);
    }

    /**
     * Generates random bytes and places them into a user-supplied byte array. The number of random
     * bytes produced is equal to the length of the byte array.
     * <p>
     * The method {@code nextBytes} is implemented by class {@code Random} as if by:
     * 
     * <pre> {@code
     * public void nextBytes(byte[] bytes) {
     *   for (int i = 0; i < bytes.length; )
     *     for (int rnd = nextInt(), n = Math.min(bytes.length - i, 4);
     *          n-- > 0; rnd >>= 8)
     *       bytes[i++] = (byte)rnd;
     * }}</pre>
     *
     * @param bytes the byte array to fill with random bytes
     * @throws NullPointerException if the byte array is null
     * @since 1.1
     */
    public void nextBytes(byte[] bytes) {
        for (int i = 0, len = bytes.length; i < len;) {
            for (int rnd = nextInt(), n = Math.min(len - i, Integer.SIZE / Byte.SIZE); n-- > 0; rnd >>= Byte.SIZE) {
                bytes[i++] = (byte) rnd;
            }
        }
    }
}
