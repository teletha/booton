/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.css;

/**
 * @version 2012/12/11 22:07:42
 */
public class Margin extends CSSValue {

    /** The top value. */
    private String top;

    /** The right value. */
    private String right;

    /** The bottom value. */
    private String bottom;

    /** The left value. */
    private String left;

    /**
     * @param css
     */
    protected Margin(CSS css) {
        super(css);
    }

    /**
     * <p>
     * The margin-top CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Margin top(double size, Unit unit) {
        top = compute(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-bottom CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Margin bottom(double size, Unit unit) {
        bottom = compute(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-left CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Margin left(double size, Unit unit) {
        left = compute(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-right CSS property of an element sets the margin space required on the top of an
     * element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Margin right(double size, Unit unit) {
        right = compute(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-left and margin-right CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Margin horizontal(double size, Unit unit) {
        left(size, unit);
        right(size, unit);

        // Chainable API
        return this;
    }

    /**
     * <p>
     * The margin-top and margin-bottom CSS property of an element sets the margin space required on
     * the top of an element. A negative value is also allowed.
     * </p>
     * 
     * @param size
     * @param unit
     * @return
     */
    public Margin vertical(double size, Unit unit) {
        top(size, unit);
        bottom(size, unit);

        // Chainable API
        return this;
    }
}
