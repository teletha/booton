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
 * @version 2012/12/12 0:00:13
 */
public class Background extends Color<Background> {

    private String repeat;

    private String verticalPosition;

    private String horizontalPosition;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return property("background-color", color) + property("background-repeat", repeat) + property("background-position", horizontalPosition, verticalPosition);
    }

    /**
     * <p>
     * The background-repeat CSS property defines how background images are repeated. A background
     * image can be repeated along the horizontal axis, the vertical axis, both, or not repeated at
     * all. When the repetition of the image tiles doesn't let them exactly cover the background,
     * the way adjustments are done can be controlled by the author: by default, the last image is
     * clipped, but the different tiles can instead be re-sized, or space can be inserted between
     * the tiles.
     * </p>
     * 
     * @return
     */
    public Background repeatX() {
        repeat = "repeat-x";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-repeat CSS property defines how background images are repeated. A background
     * image can be repeated along the horizontal axis, the vertical axis, both, or not repeated at
     * all. When the repetition of the image tiles doesn't let them exactly cover the background,
     * the way adjustments are done can be controlled by the author: by default, the last image is
     * clipped, but the different tiles can instead be re-sized, or space can be inserted between
     * the tiles.
     * </p>
     * 
     * @return
     */
    public Background repeatY() {
        repeat = "repeat-y";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-repeat CSS property defines how background images are repeated. A background
     * image can be repeated along the horizontal axis, the vertical axis, both, or not repeated at
     * all. When the repetition of the image tiles doesn't let them exactly cover the background,
     * the way adjustments are done can be controlled by the author: by default, the last image is
     * clipped, but the different tiles can instead be re-sized, or space can be inserted between
     * the tiles.
     * </p>
     * 
     * @return
     */
    public Background repeat() {
        repeat = "repeat";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-repeat CSS property defines how background images are repeated. A background
     * image can be repeated along the horizontal axis, the vertical axis, both, or not repeated at
     * all. When the repetition of the image tiles doesn't let them exactly cover the background,
     * the way adjustments are done can be controlled by the author: by default, the last image is
     * clipped, but the different tiles can instead be re-sized, or space can be inserted between
     * the tiles.
     * </p>
     * 
     * @return
     */
    public Background space() {
        repeat = "space";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-repeat CSS property defines how background images are repeated. A background
     * image can be repeated along the horizontal axis, the vertical axis, both, or not repeated at
     * all. When the repetition of the image tiles doesn't let them exactly cover the background,
     * the way adjustments are done can be controlled by the author: by default, the last image is
     * clipped, but the different tiles can instead be re-sized, or space can be inserted between
     * the tiles.
     * </p>
     * 
     * @return
     */
    public Background round() {
        repeat = "round";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-repeat CSS property defines how background images are repeated. A background
     * image can be repeated along the horizontal axis, the vertical axis, both, or not repeated at
     * all. When the repetition of the image tiles doesn't let them exactly cover the background,
     * the way adjustments are done can be controlled by the author: by default, the last image is
     * clipped, but the different tiles can instead be re-sized, or space can be inserted between
     * the tiles.
     * </p>
     * 
     * @return
     */
    public Background noRepeat() {
        repeat = "no-repeat";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-position CSS property sets the initial position, relative to the background
     * position layer defined by background-origin for each defined background image.
     * </p>
     * 
     * @return
     */
    public Background top() {
        verticalPosition = "top";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-position CSS property sets the initial position, relative to the background
     * position layer defined by background-origin for each defined background image.
     * </p>
     * 
     * @return
     */
    public Background bottom() {
        verticalPosition = "bottom";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-position CSS property sets the initial position, relative to the background
     * position layer defined by background-origin for each defined background image.
     * </p>
     * 
     * @return
     */
    public Background left() {
        horizontalPosition = "left";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-position CSS property sets the initial position, relative to the background
     * position layer defined by background-origin for each defined background image.
     * </p>
     * 
     * @return
     */
    public Background right() {
        horizontalPosition = "right";

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-position CSS property sets the initial position, relative to the background
     * position layer defined by background-origin for each defined background image.
     * </p>
     * 
     * @return
     */
    public Background vertical(double size, Unit unit) {
        horizontalPosition = compute(size, unit);

        // Chainable API
        return chain();
    }

    /**
     * <p>
     * The background-position CSS property sets the initial position, relative to the background
     * position layer defined by background-origin for each defined background image.
     * </p>
     * 
     * @return
     */
    public Background horizontal(double size, Unit unit) {
        horizontalPosition = compute(size, unit);

        // Chainable API
        return chain();
    }
}
