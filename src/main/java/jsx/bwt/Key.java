/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mitlicense.php
 */

package jsx.bwt;

/**
 * @version 2013/06/21 14:39:33
 */
public enum Key {

    /** The ui key input type. */
    N0(48),

    /** The ui key input type. */
    N1(49),

    /** The ui key input type. */
    N2(50),

    /** The ui key input type. */
    N3(51),

    /** The ui key input type. */
    N4(52),

    /** The ui key input type. */
    N5(53),

    /** The ui key input type. */
    N6(54),

    /** The ui key input type. */
    N7(55),

    /** The ui key input type. */
    N8(56),

    /** Vitual Key Code */
    N9(57),

    /** The ui key input type. */
    A(65),

    /** The ui key input type. */
    B(66),

    /** The ui key input type. */
    C(67),

    /** The ui key input type. */
    D(68),

    /** The ui key input type. */
    E(69),

    /** The ui key input type. */
    F(70),

    /** The ui key input type. */
    G(71),

    /** The ui key input type. */
    H(72),

    /** The ui key input type. */
    I(73),

    /** The ui key input type. */
    J(74),

    /** The ui key input type. */
    K(75),

    /** The ui key input type. */
    L(76),

    /** The ui key input type. */
    M(77),

    /** The ui key input type. */
    N(78),

    /** The ui key input type. */
    O(79),

    /** The ui key input type. */
    P(80),

    /** The ui key input type. */
    Q(81),

    /** The ui key input type. */
    R(82),

    /** The ui key input type. */
    S(83),

    /** The ui key input type. */
    T(84),

    /** The ui key input type. */
    U(85),

    /** The ui key input type. */
    V(86),

    /** The ui key input type. */
    W(87),

    /** The ui key input type. */
    X(88),

    /** The ui key input type. */
    Y(89),

    /** The ui key input type. */
    Z(90),

    /** The ui key input type. */
    Up(38),

    /** The ui key input type. */
    Down(40),

    /** The ui key input type. */
    Right(39),

    /** The ui key input type. */
    Left(37),

    /** The ui key input type. */
    Space(32),

    /** The ui key input type. */
    Backspace(8),

    /** The ui key input type. */
    Enter(13),

    /** The ui key input type. */
    Delete(46),

    /** The ui key input type. */
    Escape(27),

    /** The ui key input type. */
    Insert(45),

    /** The ui key input type. */
    Tab(9),

    /** The ui key input type. */
    Home(38),

    /** The ui key input type. */
    End(35),

    /** The ui key input type. */
    PageUp(33),

    /** The ui key input type. */
    PageDown(34),

    /** The ui key input type. */
    Control(17),

    /** The ui key input type. */
    Shift(16),

    /** The ui key input type. */
    Alt(18),

    /** The ui key input type. */
    F1(112),

    /** The ui key input type. */
    F2(113),

    /** The ui key input type. */
    F3(114),

    /** The ui key input type. */
    F4(115),

    /** The ui key input type. */
    F5(116),

    /** The ui key input type. */
    F6(117),

    /** The ui key input type. */
    F7(118),

    /** The ui key input type. */
    F8(119),

    /** The ui key input type. */
    F9(120),

    /** The ui key input type. */
    F10(121),

    /** The ui key input type. */
    F11(122),

    /** The ui key input type. */
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
}
