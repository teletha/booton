/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

/**
 * @version 2014/09/01 10:59:35
 */
public class Key {

    /**
     * Constant for the {@code Enter} key.
     */
    public static final Key ENTER = new Key(0x0A, "Enter");

    /**
     * Constant for the {@code Backspace} key.
     */
    public static final Key BACK_SPACE = new Key(0x08, "Backspace");

    /**
     * Constant for the {@code Tab} key.
     */
    public static final Key TAB = new Key(0x09, "Tab");

    /**
     * Constant for the {@code Cancel} key.
     */
    public static final Key CANCEL = new Key(0x03, "Cancel");

    /**
     * Constant for the {@code Clear} key.
     */
    public static final Key CLEAR = new Key(0x0C, "Clear");

    /**
     * Constant for the {@code Shift} key.
     */
    public static final Key SHIFT = new Key(0x10, "Shift");

    /**
     * Constant for the {@code Ctrl} key.
     */
    public static final Key CONTROL = new Key(0x11, "Ctrl");

    /**
     * Constant for the {@code Alt} key.
     */
    public static final Key ALT = new Key(0x12, "Alt");

    /**
     * Constant for the {@code Pause} key.
     */
    public static final Key PAUSE = new Key(0x13, "Pause");

    /**
     * Constant for the {@code Caps Lock} key.
     */
    public static final Key CAPS = new Key(0x14, "Caps Lock");

    /**
     * Constant for the {@code Esc} key.
     */
    public static final Key ESCAPE = new Key(0x1B, "Esc");

    /**
     * Constant for the {@code Space} key.
     */
    public static final Key SPACE = new Key(0x20, "Space");

    /**
     * Constant for the {@code Page Up} key.
     */
    public static final Key PAGE_UP = new Key(0x21, "Page Up");

    /**
     * Constant for the {@code Page Down} key.
     */
    public static final Key PAGE_DOWN = new Key(0x22, "Page Down");

    /**
     * Constant for the {@code End} key.
     */
    public static final Key END = new Key(0x23, "End");

    /**
     * Constant for the {@code Home} key.
     */
    public static final Key HOME = new Key(0x24, "Home");

    /**
     * Constant for the non-numpad <b>left</b> arrow key.
     */
    public static final Key LEFT = new Key(0x25, "Left");

    /**
     * Constant for the non-numpad <b>up</b> arrow key.
     */
    public static final Key UP = new Key(0x26, "Up");

    /**
     * Constant for the non-numpad <b>right</b> arrow key.
     */
    public static final Key RIGHT = new Key(0x27, "Right");

    /**
     * Constant for the non-numpad <b>down</b> arrow key.
     */
    public static final Key DOWN = new Key(0x28, "Down");

    /**
     * Constant for the comma key, ","
     */
    public static final Key COMMA = new Key(0x2C, "Comma");

    /**
     * Constant for the minus key, "-"
     */
    public static final Key MINUS = new Key(0x2D, "Minus");

    /**
     * Constant for the period key, "."
     */
    public static final Key PERIOD = new Key(0x2E, "Period");

    /**
     * Constant for the forward slash key, "/"
     */
    public static final Key SLASH = new Key(0x2F, "Slash");

    /**
     * Constant for the {@code 0} key.
     */
    public static final Key DIGIT0 = new Key(0x30, "0");

    /**
     * Constant for the {@code 1} key.
     */
    public static final Key DIGIT1 = new Key(0x31, "1");

    /**
     * Constant for the {@code 2} key.
     */
    public static final Key DIGIT2 = new Key(0x32, "2");

    /**
     * Constant for the {@code 3} key.
     */
    public static final Key DIGIT3 = new Key(0x33, "3");

    /**
     * Constant for the {@code 4} key.
     */
    public static final Key DIGIT4 = new Key(0x34, "4");

    /**
     * Constant for the {@code 5} key.
     */
    public static final Key DIGIT5 = new Key(0x35, "5");

    /**
     * Constant for the {@code 6} key.
     */
    public static final Key DIGIT6 = new Key(0x36, "6");

    /**
     * Constant for the {@code 7} key.
     */
    public static final Key DIGIT7 = new Key(0x37, "7");

    /**
     * Constant for the {@code 8} key.
     */
    public static final Key DIGIT8 = new Key(0x38, "8");

    /**
     * Constant for the {@code 9} key.
     */
    public static final Key DIGIT9 = new Key(0x39, "9");

    /**
     * Constant for the semicolon key, ";"
     */
    public static final Key SEMICOLON = new Key(0x3B, "Semicolon");

    /**
     * Constant for the equals key, "="
     */
    public static final Key EQUALS = new Key(0x3D, "Equals");

    /**
     * Constant for the {@code A} key.
     */
    public static final Key A = new Key(0x41, "A");

    /**
     * Constant for the {@code B} key.
     */
    public static final Key B = new Key(0x42, "B");

    /**
     * Constant for the {@code C} key.
     */
    public static final Key C = new Key(0x43, "C");

    /**
     * Constant for the {@code D} key.
     */
    public static final Key D = new Key(0x44, "D");

    /**
     * Constant for the {@code E} key.
     */
    public static final Key E = new Key(0x45, "E");

    /**
     * Constant for the {@code F} key.
     */
    public static final Key F = new Key(0x46, "F");

    /**
     * Constant for the {@code G} key.
     */
    public static final Key G = new Key(0x47, "G");

    /**
     * Constant for the {@code H} key.
     */
    public static final Key H = new Key(0x48, "H");

    /**
     * Constant for the {@code I} key.
     */
    public static final Key I = new Key(0x49, "I");

    /**
     * Constant for the {@code J} key.
     */
    public static final Key J = new Key(0x4A, "J");

    /**
     * Constant for the {@code K} key.
     */
    public static final Key K = new Key(0x4B, "K");

    /**
     * Constant for the {@code L} key.
     */
    public static final Key L = new Key(0x4C, "L");

    /**
     * Constant for the {@code M} key.
     */
    public static final Key M = new Key(0x4D, "M");

    /**
     * Constant for the {@code N} key.
     */
    public static final Key N = new Key(0x4E, "N");

    /**
     * Constant for the {@code O} key.
     */
    public static final Key O = new Key(0x4F, "O");

    /**
     * Constant for the {@code P} key.
     */
    public static final Key P = new Key(0x50, "P");

    /**
     * Constant for the {@code Q} key.
     */
    public static final Key Q = new Key(0x51, "Q");

    /**
     * Constant for the {@code R} key.
     */
    public static final Key R = new Key(0x52, "R");

    /**
     * Constant for the {@code S} key.
     */
    public static final Key S = new Key(0x53, "S");

    /**
     * Constant for the {@code T} key.
     */
    public static final Key T = new Key(0x54, "T");

    /**
     * Constant for the {@code U} key.
     */
    public static final Key U = new Key(0x55, "U");

    /**
     * Constant for the {@code V} key.
     */
    public static final Key V = new Key(0x56, "V");

    /**
     * Constant for the {@code W} key.
     */
    public static final Key W = new Key(0x57, "W");

    /**
     * Constant for the {@code X} key.
     */
    public static final Key X = new Key(0x58, "X");

    /**
     * Constant for the {@code Y} key.
     */
    public static final Key Y = new Key(0x59, "Y");

    /**
     * Constant for the {@code Z} key.
     */
    public static final Key Z = new Key(0x5A, "Z");

    /**
     * Constant for the open bracket key, "["
     */
    public static final Key OPEN_BRACKET = new Key(0x5B, "Open Bracket");

    /**
     * Constant for the back slash key, "\"
     */
    public static final Key BACK_SLASH = new Key(0x5C, "Back Slash");

    /**
     * Constant for the close bracket key, "]"
     */
    public static final Key CLOSE_BRACKET = new Key(0x5D, "Close Bracket");

    /**
     * Constant for the {@code Numpad 0} key.
     */
    public static final Key NUMPAD0 = new Key(0x60, "Numpad 0");

    /**
     * Constant for the {@code Numpad 1} key.
     */
    public static final Key NUMPAD1 = new Key(0x61, "Numpad 1");

    /**
     * Constant for the {@code Numpad 2} key.
     */
    public static final Key NUMPAD2 = new Key(0x62, "Numpad 2");

    /**
     * Constant for the {@code Numpad 3} key.
     */
    public static final Key NUMPAD3 = new Key(0x63, "Numpad 3");

    /**
     * Constant for the {@code Numpad 4} key.
     */
    public static final Key NUMPAD4 = new Key(0x64, "Numpad 4");

    /**
     * Constant for the {@code Numpad 5} key.
     */
    public static final Key NUMPAD5 = new Key(0x65, "Numpad 5");

    /**
     * Constant for the {@code Numpad 6} key.
     */
    public static final Key NUMPAD6 = new Key(0x66, "Numpad 6");

    /**
     * Constant for the {@code Numpad 7} key.
     */
    public static final Key NUMPAD7 = new Key(0x67, "Numpad 7");

    /**
     * Constant for the {@code Numpad 8} key.
     */
    public static final Key NUMPAD8 = new Key(0x68, "Numpad 8");

    /**
     * Constant for the {@code Numpad 9} key.
     */
    public static final Key NUMPAD9 = new Key(0x69, "Numpad 9");

    /**
     * Constant for the {@code Multiply} key.
     */
    public static final Key MULTIPLY = new Key(0x6A, "Multiply");

    /**
     * Constant for the {@code Add} key.
     */
    public static final Key ADD = new Key(0x6B, "Add");

    /**
     * Constant for the Numpad Separator key.
     */
    public static final Key SEPARATOR = new Key(0x6C, "Separator");

    /**
     * Constant for the {@code Subtract} key.
     */
    public static final Key SUBTRACT = new Key(0x6D, "Subtract");

    /**
     * Constant for the {@code Decimal} key.
     */
    public static final Key DECIMAL = new Key(0x6E, "Decimal");

    /**
     * Constant for the {@code Divide} key.
     */
    public static final Key DIVIDE = new Key(0x6F, "Divide");

    /**
     * Constant for the {@code Delete} key.
     */
    public static final Key DELETE = new Key(0x7F, "Delete"); /* ASCII:Integer DEL */

    /**
     * Constant for the {@code Num Lock} key.
     */
    public static final Key NUM_LOCK = new Key(0x90, "Num Lock");

    /**
     * Constant for the {@code Scroll Lock} key.
     */
    public static final Key SCROLL_LOCK = new Key(0x91, "Scroll Lock");

    /**
     * Constant for the F1 function key.
     */
    public static final Key F1 = new Key(0x70, "F1");

    /**
     * Constant for the F2 function key.
     */
    public static final Key F2 = new Key(0x71, "F2");

    /**
     * Constant for the F3 function key.
     */
    public static final Key F3 = new Key(0x72, "F3");

    /**
     * Constant for the F4 function key.
     */
    public static final Key F4 = new Key(0x73, "F4");

    /**
     * Constant for the F5 function key.
     */
    public static final Key F5 = new Key(0x74, "F5");

    /**
     * Constant for the F6 function key.
     */
    public static final Key F6 = new Key(0x75, "F6");

    /**
     * Constant for the F7 function key.
     */
    public static final Key F7 = new Key(0x76, "F7");

    /**
     * Constant for the F8 function key.
     */
    public static final Key F8 = new Key(0x77, "F8");

    /**
     * Constant for the F9 function key.
     */
    public static final Key F9 = new Key(0x78, "F9");

    /**
     * Constant for the F10 function key.
     */
    public static final Key F10 = new Key(0x79, "F10");

    /**
     * Constant for the F11 function key.
     */
    public static final Key F11 = new Key(0x7A, "F11");

    /**
     * Constant for the F12 function key.
     */
    public static final Key F12 = new Key(0x7B, "F12");

    /**
     * Constant for the F13 function key.
     */
    public static final Key F13 = new Key(0xF000, "F13");

    /**
     * Constant for the F14 function key.
     */
    public static final Key F14 = new Key(0xF001, "F14");

    /**
     * Constant for the F15 function key.
     */
    public static final Key F15 = new Key(0xF002, "F15");

    /**
     * Constant for the F16 function key.
     */
    public static final Key F16 = new Key(0xF003, "F16");

    /**
     * Constant for the F17 function key.
     */
    public static final Key F17 = new Key(0xF004, "F17");

    /**
     * Constant for the F18 function key.
     */
    public static final Key F18 = new Key(0xF005, "F18");

    /**
     * Constant for the F19 function key.
     */
    public static final Key F19 = new Key(0xF006, "F19");

    /**
     * Constant for the F20 function key.
     */
    public static final Key F20 = new Key(0xF007, "F20");

    /**
     * Constant for the F21 function key.
     */
    public static final Key F21 = new Key(0xF008, "F21");

    /**
     * Constant for the F22 function key.
     */
    public static final Key F22 = new Key(0xF009, "F22");

    /**
     * Constant for the F23 function key.
     */
    public static final Key F23 = new Key(0xF00A, "F23");

    /**
     * Constant for the F24 function key.
     */
    public static final Key F24 = new Key(0xF00B, "F24");

    /**
     * Constant for the {@code Print Screen} key.
     */
    public static final Key PRINTSCREEN = new Key(0x9A, "Print Screen");

    /**
     * Constant for the {@code Insert} key.
     */
    public static final Key INSERT = new Key(0x9B, "Insert");

    /**
     * Constant for the {@code Help} key.
     */
    public static final Key HELP = new Key(0x9C, "Help");

    /**
     * Constant for the {@code Meta} key.
     */
    public static final Key META = new Key(0x9D, "Meta");

    /**
     * Constant for the {@code Back Quote} key.
     */
    public static final Key BACK_QUOTE = new Key(0xC0, "Back Quote");

    /**
     * Constant for the {@code Quote} key.
     */
    public static final Key QUOTE = new Key(0xDE, "Quote");

    /**
     * Constant for the numeric keypad <b>up</b> arrow key.
     */
    public static final Key KP_UP = new Key(0xE0, "Numpad Up");

    /**
     * Constant for the numeric keypad <b>down</b> arrow key.
     */
    public static final Key KP_DOWN = new Key(0xE1, "Numpad Down");

    /**
     * Constant for the numeric keypad <b>left</b> arrow key.
     */
    public static final Key KP_LEFT = new Key(0xE2, "Numpad Left");

    /**
     * Constant for the numeric keypad <b>right</b> arrow key.
     */
    public static final Key KP_RIGHT = new Key(0xE3, "Numpad Right");

    /**
     * Constant for the {@code Dead Grave} key.
     */
    public static final Key DEAD_GRAVE = new Key(0x80, "Dead Grave");

    /**
     * Constant for the {@code Dead Acute} key.
     */
    public static final Key DEAD_ACUTE = new Key(0x81, "Dead Acute");

    /**
     * Constant for the {@code Dead Circumflex} key.
     */
    public static final Key DEAD_CIRCUMFLEX = new Key(0x82, "Dead Circumflex");

    /**
     * Constant for the {@code Dead Tilde} key.
     */
    public static final Key DEAD_TILDE = new Key(0x83, "Dead Tilde");

    /**
     * Constant for the {@code Dead Macron} key.
     */
    public static final Key DEAD_MACRON = new Key(0x84, "Dead Macron");

    /**
     * Constant for the {@code Dead Breve} key.
     */
    public static final Key DEAD_BREVE = new Key(0x85, "Dead Breve");

    /**
     * Constant for the {@code Dead Abovedot} key.
     */
    public static final Key DEAD_ABOVEDOT = new Key(0x86, "Dead Abovedot");

    /**
     * Constant for the {@code Dead Diaeresis} key.
     */
    public static final Key DEAD_DIAERESIS = new Key(0x87, "Dead Diaeresis");

    /**
     * Constant for the {@code Dead Abovering} key.
     */
    public static final Key DEAD_ABOVERING = new Key(0x88, "Dead Abovering");

    /**
     * Constant for the {@code Dead Doubleacute} key.
     */
    public static final Key DEAD_DOUBLEACUTE = new Key(0x89, "Dead Doubleacute");

    /**
     * Constant for the {@code Dead Caron} key.
     */
    public static final Key DEAD_CARON = new Key(0x8a, "Dead Caron");

    /**
     * Constant for the {@code Dead Cedilla} key.
     */
    public static final Key DEAD_CEDILLA = new Key(0x8b, "Dead Cedilla");

    /**
     * Constant for the {@code Dead Ogonek} key.
     */
    public static final Key DEAD_OGONEK = new Key(0x8c, "Dead Ogonek");

    /**
     * Constant for the {@code Dead Iota} key.
     */
    public static final Key DEAD_IOTA = new Key(0x8d, "Dead Iota");

    /**
     * Constant for the {@code Dead Voiced Sound} key.
     */
    public static final Key DEAD_VOICED_SOUND = new Key(0x8e, "Dead Voiced Sound");

    /**
     * Constant for the {@code Dead Semivoiced Sound} key.
     */
    public static final Key DEAD_SEMIVOICED_SOUND = new Key(0x8f, "Dead Semivoiced Sound");

    /**
     * Constant for the {@code Ampersand} key.
     */
    public static final Key AMPERSAND = new Key(0x96, "Ampersand");

    /**
     * Constant for the {@code Asterisk} key.
     */
    public static final Key ASTERISK = new Key(0x97, "Asterisk");

    /**
     * Constant for the {@code Double Quote} key.
     */
    public static final Key QUOTEDBL = new Key(0x98, "Double Quote");

    /**
     * Constant for the {@code Less} key.
     */
    public static final Key LESS = new Key(0x99, "Less");

    /**
     * Constant for the {@code Greater} key.
     */
    public static final Key GREATER = new Key(0xa0, "Greater");

    /**
     * Constant for the {@code Left Brace} key.
     */
    public static final Key BRACELEFT = new Key(0xa1, "Left Brace");

    /**
     * Constant for the {@code Right Brace} key.
     */
    public static final Key BRACERIGHT = new Key(0xa2, "Right Brace");

    /**
     * Constant for the "@" key.
     */
    public static final Key AT = new Key(0x0200, "At");

    /**
     * Constant for the ":" key.
     */
    public static final Key COLON = new Key(0x0201, "Colon");

    /**
     * Constant for the "^" key.
     */
    public static final Key CIRCUMFLEX = new Key(0x0202, "Circumflex");

    /**
     * Constant for the "$" key.
     */
    public static final Key DOLLAR = new Key(0x0203, "Dollar");

    /**
     * Constant for the Euro currency sign key.
     */
    public static final Key EURO_SIGN = new Key(0x0204, "Euro Sign");

    /**
     * Constant for the "!" key.
     */
    public static final Key EXCLAMATION_MARK = new Key(0x0205, "Exclamation Mark");

    /**
     * Constant for the inverted exclamation mark key.
     */
    public static final Key INVERTED_EXCLAMATION_MARK = new Key(0x0206, "Inverted Exclamation Mark");

    /**
     * Constant for the "(" key.
     */
    public static final Key LEFT_PARENTHESIS = new Key(0x0207, "Left Parenthesis");

    /**
     * Constant for the "#" key.
     */
    public static final Key NUMBER_SIGN = new Key(0x0208, "Number Sign");

    /**
     * Constant for the "+" key.
     */
    public static final Key PLUS = new Key(0x0209, "Plus");

    /**
     * Constant for the ")" key.
     */
    public static final Key RIGHT_PARENTHESIS = new Key(0x020A, "Right Parenthesis");

    /**
     * Constant for the "_" key.
     */
    public static final Key UNDERSCORE = new Key(0x020B, "Underscore");

    /**
     * Constant for the Microsoft Windows "Windows" key. It is used for both the left and right
     * version of the key.
     */
    public static final Key WINDOWS = new Key(0x020C, "Windows");

    /**
     * Constant for the Microsoft Windows Context Menu key.
     */
    public static final Key CONTEXT_MENU = new Key(0x020D, "Context Menu");

    /**
     * Constant for input method support on Asian Keyboards.
     */
    public static final Key FINAL = new Key(0x0018, "Final");

    /**
     * Constant for the Convert function key.
     */
    public static final Key CONVERT = new Key(0x001C, "Convert");

    /**
     * Constant for the Don't Convert function key.
     */
    public static final Key NONCONVERT = new Key(0x001D, "Nonconvert");

    /**
     * Constant for the Accept or Commit function key.
     */
    public static final Key ACCEPT = new Key(0x001E, "Accept");

    /**
     * Constant for the {@code Mode Change} key.
     */
    public static final Key MODECHANGE = new Key(0x001F, "Mode Change");

    /**
     * Constant for the {@code Kana} key.
     */
    public static final Key KANA = new Key(0x0015, "Kana");

    /**
     * Constant for the {@code Kanji} key.
     */
    public static final Key KANJI = new Key(0x0019, "Kanji");

    /**
     * Constant for the Alphanumeric function key.
     */
    public static final Key ALPHANUMERIC = new Key(0x00F0, "Alphanumeric");

    /**
     * Constant for the Katakana function key.
     */
    public static final Key KATAKANA = new Key(0x00F1, "Katakana");

    /**
     * Constant for the Hiragana function key.
     */
    public static final Key HIRAGANA = new Key(0x00F2, "Hiragana");

    /**
     * Constant for the Full-Width Characters function key.
     */
    public static final Key FULL_WIDTH = new Key(0x00F3, "Full Width");

    /**
     * Constant for the Half-Width Characters function key.
     */
    public static final Key HALF_WIDTH = new Key(0x00F4, "Half Width");

    /**
     * Constant for the Roman Characters function key.
     */
    public static final Key ROMAN_CHARACTERS = new Key(0x00F5, "Roman Characters");

    /**
     * Constant for the All Candidates function key.
     */
    public static final Key ALL_CANDIDATES = new Key(0x0100, "All Candidates");

    /**
     * Constant for the Previous Candidate function key.
     */
    public static final Key PREVIOUS_CANDIDATE = new Key(0x0101, "Previous Candidate");

    /**
     * Constant for the Code Input function key.
     */
    public static final Key CODE_INPUT = new Key(0x0102, "Code Input");

    /**
     * Constant for the Japanese-Katakana function key. This key switches to a Japanese input method
     * and selects its Katakana input mode.
     */
    public static final Key JAPANESE_KATAKANA = new Key(0x0103, "Japanese Katakana");

    /**
     * Constant for the Japanese-Hiragana function key. This key switches to a Japanese input method
     * and selects its Hiragana input mode.
     */
    public static final Key JAPANESE_HIRAGANA = new Key(0x0104, "Japanese Hiragana");

    /**
     * Constant for the Japanese-Roman function key. This key switches to a Japanese input method
     * and selects its Roman-Direct input mode.
     */
    public static final Key JAPANESE_ROMAN = new Key(0x0105, "Japanese Roman");

    /**
     * Constant for the locking Kana function key. This key locks the keyboard into a Kana layout.
     */
    public static final Key KANA_LOCK = new Key(0x0106, "Kana Lock");

    /**
     * Constant for the input method on/off key.
     */
    public static final Key INPUT_METHOD_ON_OFF = new Key(0x0107, "Input Method On/Off");

    /**
     * Constant for the {@code Cut} key.
     */
    public static final Key CUT = new Key(0xFFD1, "Cut");

    /**
     * Constant for the {@code Copy} key.
     */
    public static final Key COPY = new Key(0xFFCD, "Copy");

    /**
     * Constant for the {@code Paste} key.
     */
    public static final Key PASTE = new Key(0xFFCF, "Paste");

    /**
     * Constant for the {@code Undo} key.
     */
    public static final Key UNDO = new Key(0xFFCB, "Undo");

    /**
     * Constant for the {@code Again} key.
     */
    public static final Key AGAIN = new Key(0xFFC9, "Again");

    /**
     * Constant for the {@code Find} key.
     */
    public static final Key FIND = new Key(0xFFD0, "Find");

    /**
     * Constant for the {@code Properties} key.
     */
    public static final Key PROPS = new Key(0xFFCA, "Properties");

    /**
     * Constant for the {@code Stop} key.
     */
    public static final Key STOP = new Key(0xFFC8, "Stop");

    /**
     * Constant for the input method on/off key.
     */
    public static final Key COMPOSE = new Key(0xFF20, "Compose");

    /**
     * Constant for the AltGraph function key.
     */
    public static final Key ALT_GRAPH = new Key(0xFF7E, "Alt Graph");

    /**
     * Constant for the Begin key.
     */
    public static final Key BEGIN = new Key(0xFF58, "Begin");

    /**
     * This value is used to indicate that the keyCode is unknown. Key typed events do not have a
     * keyCode value; this value is used instead.
     */
    public static final Key UNDEFINED = new Key(0x0, "Undefined");

    // --------------------------------------------------------------
    //
    // Mobile and Embedded Specific Key Codes
    //
    // --------------------------------------------------------------

    /**
     * Constant for the {@code Softkey 0} key.
     */
    public static final Key SOFTKEY_0 = new Key(0x1000, "Softkey 0");

    /**
     * Constant for the {@code Softkey 1} key.
     */
    public static final Key SOFTKEY_1 = new Key(0x1001, "Softkey 1");

    /**
     * Constant for the {@code Softkey 2} key.
     */
    public static final Key SOFTKEY_2 = new Key(0x1002, "Softkey 2");

    /**
     * Constant for the {@code Softkey 3} key.
     */
    public static final Key SOFTKEY_3 = new Key(0x1003, "Softkey 3");

    /**
     * Constant for the {@code Softkey 4} key.
     */
    public static final Key SOFTKEY_4 = new Key(0x1004, "Softkey 4");

    /**
     * Constant for the {@code Softkey 5} key.
     */
    public static final Key SOFTKEY_5 = new Key(0x1005, "Softkey 5");

    /**
     * Constant for the {@code Softkey 6} key.
     */
    public static final Key SOFTKEY_6 = new Key(0x1006, "Softkey 6");

    /**
     * Constant for the {@code Softkey 7} key.
     */
    public static final Key SOFTKEY_7 = new Key(0x1007, "Softkey 7");

    /**
     * Constant for the {@code Softkey 8} key.
     */
    public static final Key SOFTKEY_8 = new Key(0x1008, "Softkey 8");

    /**
     * Constant for the {@code Softkey 9} key.
     */
    public static final Key SOFTKEY_9 = new Key(0x1009, "Softkey 9");

    /**
     * Constant for the {@code Game A} key.
     */
    public static final Key GAME_A = new Key(0x100A, "Game A");

    /**
     * Constant for the {@code Game B} key.
     */
    public static final Key GAME_B = new Key(0x100B, "Game B");

    /**
     * Constant for the {@code Game C} key.
     */
    public static final Key GAME_C = new Key(0x100C, "Game C");

    /**
     * Constant for the {@code Game D} key.
     */
    public static final Key GAME_D = new Key(0x100D, "Game D");

    /**
     * Constant for the {@code Star} key.
     */
    public static final Key STAR = new Key(0x100E, "Star");

    /**
     * Constant for the {@code Pound} key.
     */
    public static final Key POUND = new Key(0x100F, "Pound");

    /**
     * Constant for the {@code Power} key.
     */
    public static final Key POWER = new Key(0x199, "Power");

    /**
     * Constant for the {@code Info} key.
     */
    public static final Key INFO = new Key(0x1C9, "Info");

    /**
     * Constant for the {@code Colored Key 0} key.
     */
    public static final Key COLORED_KEY_0 = new Key(0x193, "Colored Key 0");

    /**
     * Constant for the {@code Colored Key 1} key.
     */
    public static final Key COLORED_KEY_1 = new Key(0x194, "Colored Key 1");

    /**
     * Constant for the {@code Colored Key 2} key.
     */
    public static final Key COLORED_KEY_2 = new Key(0x195, "Colored Key 2");

    /**
     * Constant for the {@code Colored Key 3} key.
     */
    public static final Key COLORED_KEY_3 = new Key(0x196, "Colored Key 3");

    /**
     * Constant for the {@code Eject} key.
     */
    public static final Key EJECT_TOGGLE = new Key(0x19E, "Eject");

    /**
     * Constant for the {@code Play} key.
     */
    public static final Key PLAY = new Key(0x19F, "Play");

    /**
     * Constant for the {@code Record} key.
     */
    public static final Key RECORD = new Key(0x1A0, "Record");

    /**
     * Constant for the {@code Fast Forward} key.
     */
    public static final Key FAST_FWD = new Key(0x1A1, "Fast Forward");

    /**
     * Constant for the {@code Rewind} key.
     */
    public static final Key REWIND = new Key(0x19C, "Rewind");

    /**
     * Constant for the {@code Previous Track} key.
     */
    public static final Key TRACK_PREV = new Key(0x1A8, "Previous Track");

    /**
     * Constant for the {@code Next Track} key.
     */
    public static final Key TRACK_NEXT = new Key(0x1A9, "Next Track");

    /**
     * Constant for the {@code Channel Up} key.
     */
    public static final Key CHANNEL_UP = new Key(0x1AB, "Channel Up");

    /**
     * Constant for the {@code Channel Down} key.
     */
    public static final Key CHANNEL_DOWN = new Key(0x1AC, "Channel Down");

    /**
     * Constant for the {@code Volume Up} key.
     */
    public static final Key VOLUME_UP = new Key(0x1bf, "Volume Up");

    /**
     * Constant for the {@code Volume Down} key.
     */
    public static final Key VOLUME_DOWN = new Key(0x1C0, "Volume Down");

    /**
     * Constant for the {@code Mute} key.
     */
    public static final Key MUTE = new Key(0x1C1, "Mute");

    /**
     * Constant for the Apple {@code Command} key.
     */
    public static final Key COMMAND = new Key(0x300, "Command");

    /**
     * Constant for the {@code Shortcut} key.
     */
    public static final Key SHORTCUT = new Key(-1, "Shortcut");

    /** The native key code. */
    public final int nativeCode;

    /**
     * @param nativeCode A native key code.
     */
    private Key(int nativeCode, String name) {
        this.nativeCode = nativeCode;
    }

    public Key ctrl() {
        return null;
    }

    public Key shift() {
        return null;
    }

    public Key alt() {
        return null;
    }
}
