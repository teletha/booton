/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui.event;

import java.lang.reflect.Method;

/**
 * @version 2013/04/07 15:45:08
 */
public enum Key {
    /** Virtual Key Code */
    N0(48),

    /** Virtual Key Code */
    N1(49),

    /** Virtual Key Code */
    N2(50),

    /** Virtual Key Code */
    N3(51),

    /** Virtual Key Code */
    N4(52),

    /** Virtual Key Code */
    N5(53),

    /** Virtual Key Code */
    N6(54),

    /** Virtual Key Code */
    N7(55),

    /** Virtual Key Code */
    N8(56),

    /** Vitual Key Code */
    N9(57),

    /** Virtual Key Code */
    A(65),

    /** Virtual Key Code */
    B(66),

    /** Virtual Key Code */
    C(67),

    /** Virtual Key Code */
    D(68),

    /** Virtual Key Code */
    E(69),

    /** Virtual Key Code */
    F(70),

    /** Virtual Key Code */
    G(71),

    /** Virtual Key Code */
    H(72),

    /** Virtual Key Code */
    I(73),

    /** Virtual Key Code */
    J(74),

    /** Virtual Key Code */
    K(75),

    /** Virtual Key Code */
    L(76),

    /** Virtual Key Code */
    M(77),

    /** Virtual Key Code */
    N(78),

    /** Virtual Key Code */
    O(79),

    /** Virtual Key Code */
    P(80),

    /** Virtual Key Code */
    Q(81),

    /** Virtual Key Code */
    R(82),

    /** Virtual Key Code */
    S(83),

    /** Virtual Key Code */
    T(84),

    /** Virtual Key Code */
    U(85),

    /** Virtual Key Code */
    V(86),

    /** Virtual Key Code */
    W(87),

    /** Virtual Key Code */
    X(88),

    /** Virtual Key Code */
    Y(89),

    /** Virtual Key Code */
    Z(90),

    /** Virtual Key Code */
    Up(38),

    /** Virtual Key Code */
    Down(40),

    /** Virtual Key Code */
    Right(39),

    /** Virtual Key Code */
    Left(37),

    /** Virtual Key Code */
    Space(32),

    /** Virtual Key Code */
    Backspace(8),

    /** Virtual Key Code */
    Enter(13),

    /** Virtual Key Code */
    Delete(46),

    /** Virtual Key Code */
    Escape(27),

    /** Virtual Key Code */
    Insert(45),

    /** Virtual Key Code */
    Tab(9),

    /** Virtual Key Code */
    Home(38),

    /** Virtual Key Code */
    End(35),

    /** Virtual Key Code */
    PageUp(33),

    /** Virtual Key Code */
    PageDown(34),

    /** Virtual Key Code */
    Control(17),

    /** Virtual Key Code */
    Shift(16),

    /** Virtual Key Code */
    Alt(18),

    /** Virtual Key Code */
    F1(112),

    /** Virtual Key Code */
    F2(113),

    /** Virtual Key Code */
    F3(114),

    /** Virtual Key Code */
    F4(115),

    /** Virtual Key Code */
    F5(116),

    /** Virtual Key Code */
    F6(117),

    /** Virtual Key Code */
    F7(118),

    /** Virtual Key Code */
    F8(119),

    /** Virtual Key Code */
    F9(120),

    /** Virtual Key Code */
    F10(121),

    /** Virtual Key Code */
    F11(122),

    /** Virtual Key Code */
    F12(123);

    /** The key code. */
    public final int code;

    /**
     * <p>
     * Native key.
     * </p>
     * 
     * @param code
     */
    private Key(int code) {
        this.code = code;
    }

    /**
     * @version 2013/04/07 15:47:35
     */
    private static class KeyBinding {

        /** The binding method owner. */
        private final Object owner;

        /** The binding method. */
        private final Method binder;

        /**
         * @param owner
         * @param binder
         */
        private KeyBinding(Object owner, Method binder) {
            this.owner = owner;
            this.binder = binder;
        }

        /**
         * <p>
         * Invoke key binding.
         * </p>
         * 
         * @return
         */
        private boolean invoke() {
            try {
                binder.invoke(owner);

                return false;
            } catch (Exception e) {
                return true;
            }
        }
    }
}
