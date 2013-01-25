/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import java.util.Map;

import js.util.HashMap;

/**
 * @version 2013/01/25 15:28:37
 */
public class Rune {

    /** The item manager. */
    private static final Map<String, Rune> runes = new HashMap();

    /** The kind. */
    private static final int Mark = 0;

    /** The kind. */
    private static final int Seal = 0;

    /** The kind. */
    private static final int Glyph = 0;

    /** The kind. */
    private static final int Quintessence = 0;

    /** The rune. */
    public static final Rune VitalityMark = new Rune("Vitality", Mark);

    /** The rune. */
    public static final Rune VitalitySeal = new Rune("Vitality", Seal);

    /** The rune. */
    public static final Rune VitalityGlyph = new Rune("Vitality", Glyph);

    /** The rune. */
    public static final Rune VitalityQuintessence = new Rune("Vitality", Quintessence);

    /** The name of this rune. */
    public final String name;

    /** The kind of rune. */
    public final int kind;

    /** The status. */
    Improvement improvement;

    /**
     * @param name
     * @param kind
     */
    private Rune(String name, int kind) {
        this.name = name;
        this.kind = kind;

        // register by name
        runes.put(name, this);
    }
}
