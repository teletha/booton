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

import jsx.event.EventType;

/**
 * @version 2013/10/10 13:45:14
 */
public enum UIAction implements EventType<UIEvent> {

    /** The ui event type. */
    PointerDown,

    /** The ui event type. */
    PointerUp,

    /** The ui event type. */
    PointerMove,

    /** The ui event type. */
    PointerOver,

    /** The ui event type. */
    PointerOut,

    /** The ui event type. */
    PointerEnter,

    /** The ui event type. */
    PointerLeave,

    /** The ui event type. */
    PointerCancel,

    /** The ui event type. */
    Popup,

    /** The ui event type. */
    HashChange,

    /** The ui event type. */
    Load(0),

    /** The ui event type. */
    Unload(0),

    /** The ui event type. */
    PageLoad(0),

    /** The ui event type. */
    PageUnload(0),

    /** The ui event type. */
    Close,

    /** The ui event type. */
    Minimize,

    /** The ui event type. */
    Maximize,

    /** The ui event type. */
    Activate,

    /** The ui event type. */
    Deactivate,

    /** The ui event type. */
    Focus,

    /** The ui event type. */
    Blur,

    /** The ui event type. */
    Resize,

    /** The ui event type. */
    Click,

    /** The ui event type. */
    ClickRight("contextmenu"),

    /** The ui event type. */
    Scroll,

    /** The ui event type. */
    KeyDown,

    /** The ui event type. */
    KeyUp,

    /** The ui event type. */
    KeyPress,

    /** The ui event type. */
    MouseDown,

    /** The ui event type. */
    MouseUp,

    /** The ui event type. */
    MouseMove,

    /** The ui event type. */
    MouseDoubleClick,

    /** The ui event type. */
    MouseEnter,

    /** The ui event type. */
    MouseLeave,

    /** The ui event type. */
    Selection,

    /** The ui key input type. */
    Key_N0(48),

    /** The ui key input type. */
    Key_N1(49),

    /** The ui key input type. */
    Key_N2(50),

    /** The ui key input type. */
    Key_N3(51),

    /** The ui key input type. */
    Key_N4(52),

    /** The ui key input type. */
    Key_N5(53),

    /** The ui key input type. */
    Key_N6(54),

    /** The ui key input type. */
    Key_N7(55),

    /** The ui key input type. */
    Key_N8(56),

    /** Vitual Key Code */
    Key_N9(57),

    /** The ui key input type. */
    Key_A(65),

    /** The ui key input type. */
    Key_B(66),

    /** The ui key input type. */
    Key_C(67),

    /** The ui key input type. */
    Key_D(68),

    /** The ui key input type. */
    Key_E(69),

    /** The ui key input type. */
    Key_F(70),

    /** The ui key input type. */
    Key_G(71),

    /** The ui key input type. */
    Key_H(72),

    /** The ui key input type. */
    Key_I(73),

    /** The ui key input type. */
    Key_J(74),

    /** The ui key input type. */
    Key_K(75),

    /** The ui key input type. */
    Key_L(76),

    /** The ui key input type. */
    Key_M(77),

    /** The ui key input type. */
    Key_N(78),

    /** The ui key input type. */
    Key_O(79),

    /** The ui key input type. */
    Key_P(80),

    /** The ui key input type. */
    Key_Q(81),

    /** The ui key input type. */
    Key_R(82),

    /** The ui key input type. */
    Key_S(83),

    /** The ui key input type. */
    Key_T(84),

    /** The ui key input type. */
    Key_U(85),

    /** The ui key input type. */
    Key_V(86),

    /** The ui key input type. */
    Key_W(87),

    /** The ui key input type. */
    Key_X(88),

    /** The ui key input type. */
    Key_Y(89),

    /** The ui key input type. */
    Key_Z(90),

    /** The ui key input type. */
    Key_Up(38),

    /** The ui key input type. */
    Key_Down(40),

    /** The ui key input type. */
    Key_Right(39),

    /** The ui key input type. */
    Key_Left(37),

    /** The ui key input type. */
    Key_Space(32),

    /** The ui key input type. */
    Key_Backspace(8),

    /** The ui key input type. */
    Key_Enter(13),

    /** The ui key input type. */
    Key_Delete(46),

    /** The ui key input type. */
    Key_Escape(27),

    /** The ui key input type. */
    Key_Insert(45),

    /** The ui key input type. */
    Key_Tab(9),

    /** The ui key input type. */
    Key_Home(38),

    /** The ui key input type. */
    Key_End(35),

    /** The ui key input type. */
    Key_PageUp(33),

    /** The ui key input type. */
    Key_PageDown(34),

    /** The ui key input type. */
    Key_Control(17),

    /** The ui key input type. */
    Key_Shift(16),

    /** The ui key input type. */
    Key_Alt(18),

    /** The ui key input type. */
    Key_F1(112),

    /** The ui key input type. */
    Key_F2(113),

    /** The ui key input type. */
    Key_F3(114),

    /** The ui key input type. */
    Key_F4(115),

    /** The ui key input type. */
    Key_F5(116),

    /** The ui key input type. */
    Key_F6(117),

    /** The ui key input type. */
    Key_F7(118),

    /** The ui key input type. */
    Key_F8(119),

    /** The ui key input type. */
    Key_F9(120),

    /** The ui key input type. */
    Key_F10(121),

    /** The ui key input type. */
    Key_F11(122),

    /** The ui key input type. */
    Key_F12(123);

    /** The key code. */
    public final int code;

    /** The event type name. */
    public final String name;

    /** The event type. */
    public final boolean global;

    /**
     * 
     */
    private UIAction() {
        this(-1);
    }

    /**
     * @param name
     */
    private UIAction(String name) {
        this.code = -1;
        this.global = false;
        this.name = name;
    }

    /**
     * <p>
     * Native key.
     * </p>
     * 
     * @param code
     */
    private UIAction(int code) {
        this.code = code;
        this.global = code == 0;
        this.name = 0 < code ? "keydown" : name().toLowerCase();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(UIEvent event) {
        return code == -1 || event.which == code;
    }
}