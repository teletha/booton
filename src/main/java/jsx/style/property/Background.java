/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.property;

import jsx.style.value.Color;
import booton.css.Unit;

/**
 * @version 2014/10/27 16:28:21
 */
public class Background extends Colorable<Background> {

    // /**
    // * {@inheritDoc}
    // */
    // @Override
    // public Color color() {
    // Color backgroundColor = color;
    //
    // if (backgroundColor == null) {
    // for (Object image : images) {
    // if (image instanceof LinearGradient) {
    // backgroundColor = ((LinearGradient) image).getEndColor();
    // break;
    // }
    // }
    // }
    //
    // if (backgroundColor == null) {
    // backgroundColor = Color.Transparent;
    // }
    // return backgroundColor;
    // }

    /**
     * {@inheritDoc}
     */
    @Override
    public Background color(Color color) {
        return value("background-color", color);
    }

    /**
     * <p>
     * The CSS background-image property sets the background images for an element. The images are
     * drawn on successive stacking context layers, with the first specified being drawn as if it is
     * the closest to the user. The borders of the element are then drawn on top of them, and the
     * background-color is drawn beneath them.
     * </p>
     * 
     * @param uri
     * @return
     */
    public Background none() {
        return value("background-image", "none");
    }

    /**
     * <p>
     * The CSS background-image property sets one or several background images for an element. The
     * images are drawn on stacking context layers on top of each other. The first layer specified
     * is drawn as if it is closest to the user. The borders of the element are then drawn on top of
     * them, and the background-color is drawn beneath them.
     * </p>
     * <p>
     * If a specified image cannot be drawn (for example, when the file denoted by the specified URI
     * cannot be loaded), browsers handle it as they would a none value.
     * </p>
     * 
     * @param images
     */
    public Background image(BackgroundImage... images) {
        value("background-image", join(images, 0));
        value("background-attachment", join(images, 1));
        value("background-position", join(images, image -> image.properties[2] + " " + image.properties[3]));
        value("background-repeat", join(images, 4));
        value("background-size", join(images, 5));

        return this;
    }

    /**
     * <p>
     * Join all values.
     * </p>
     */
    private String join(BackgroundImage[] images, int index) {
        return join(images, image -> image.properties[index].toString());
    }

    /**
     * <p>
     * The background-origin CSS property determines the background positioning area, that is the
     * position of the origin of an image specified using the background-image CSS property.
     * </p>
     * <p>
     * No background is drawn below the border (background extends to the outside edge of the
     * padding).
     * </p>
     * 
     * @return
     */
    public Background paddingBox() {
        return value("background-origin", "padding-box");
    }

    /**
     * <p>
     * The background-origin CSS property determines the background positioning area, that is the
     * position of the origin of an image specified using the background-image CSS property.
     * </p>
     * <p>
     * The background is painted within (clipped to) the content box.
     * </p>
     * 
     * @return
     */
    public Background contentBox() {
        return value("background-origin", "content-box");
    }

    /**
     * <p>
     * The background-origin CSS property determines the background positioning area, that is the
     * position of the origin of an image specified using the background-image CSS property.
     * </p>
     * <p>
     * The background extends to the outside edge of the border (but underneath the border in
     * z-ordering).
     * </p>
     * 
     * @return
     */
    public Background borderBox() {
        return value("background-origin", "border-box");
    }

    /**
     * @version 2014/10/27 22:43:16
     */
    public static class BackgroundImage {

        /**
         * The background related properties.
         * <ul>
         * <li>[0] Image</li>
         * <li>[1] Attachment</li>
         * <li>[2] Horizontal Position</li>
         * <li>[3] Vertical Position</li>
         * <li>[4] Repeat</li>
         * <li>[5] Size</li>
         * </ul>
         */
        private Object[] properties = {"none", "scroll", "0%", "0%", "repeat", "auto"};

        /**
         * <p>
         * The CSS background-image property sets one or several background images for an element.
         * The images are drawn on stacking context layers on top of each other. The first layer
         * specified is drawn as if it is closest to the user. The borders of the element are then
         * drawn on top of them, and the background-color is drawn beneath them.
         * </p>
         * <p>
         * If a specified image cannot be drawn (for example, when the file denoted by the specified
         * URI cannot be loaded), browsers handle it as they would a none value.
         * </p>
         * 
         * @param image
         */
        public static final BackgroundImage url(String image) {
            if (!image.startsWith("url(")) {
                image = "url(" + image + ")";
            }

            BackgroundImage created = new BackgroundImage();
            created.properties[0] = image;

            return created;
        }

        /**
         * <p>
         * The background-position CSS property sets the initial position, relative to the
         * background position layer defined by background-origin for each defined background image.
         * </p>
         */
        public BackgroundImage top() {
            properties[3] = "0%";

            return this;
        }

        /**
         * <p>
         * The background-position CSS property sets the initial position, relative to the
         * background position layer defined by background-origin for each defined background image.
         * </p>
         */
        public BackgroundImage bottom() {
            properties[3] = "100%";

            return this;
        }

        /**
         * <p>
         * The background-position CSS property sets the initial position, relative to the
         * background position layer defined by background-origin for each defined background image.
         * </p>
         */
        public BackgroundImage vertical(double size, Unit unit) {
            properties[3] = compute(size, unit);

            return this;
        }

        /**
         * <p>
         * The background-position CSS property sets the initial position, relative to the
         * background position layer defined by background-origin for each defined background image.
         * </p>
         */
        public BackgroundImage left() {
            properties[2] = "0%";

            return this;
        }

        /**
         * <p>
         * The background-position CSS property sets the initial position, relative to the
         * background position layer defined by background-origin for each defined background image.
         * </p>
         */
        public BackgroundImage right() {
            properties[2] = "100%";

            return this;
        }

        /**
         * <p>
         * The background-position CSS property sets the initial position, relative to the
         * background position layer defined by background-origin for each defined background image.
         * </p>
         */
        public BackgroundImage horizontal(double size, Unit unit) {
            properties[2] = compute(size, unit);

            return this;
        }

        /**
         * <p>
         * The background-size CSS property specifies the size of the background images. The size of
         * the image can be fully constrained or only partially in order to preserve its intrinsic
         * ratio.
         * </p>
         * <p>
         * A value that scales the background image to the specified length in the corresponding
         * dimension. Negative lengths are not allowed.
         * </p>
         * 
         * @return
         */
        public BackgroundImage size(double size, Unit unit) {
            properties[5] = compute(size, unit).toString();

            return this;
        }

        /**
         * <p>
         * The background-size CSS property specifies the size of the background images. The size of
         * the image can be fully constrained or only partially in order to preserve its intrinsic
         * ratio.
         * </p>
         * <p>
         * This keyword specifies that the background image should be scaled to be as small as
         * possible while ensuring both its dimensions are greater than or equal to the
         * corresponding dimensions of the background positioning area.
         * </p>
         * 
         * @return
         */
        public BackgroundImage cover() {
            properties[5] = "cover";

            return this;
        }

        /**
         * <p>
         * The background-size CSS property specifies the size of the background images. The size of
         * the image can be fully constrained or only partially in order to preserve its intrinsic
         * ratio.
         * </p>
         * <p>
         * This keyword specifies that the background image should be scaled to be as large as
         * possible while ensuring both its dimensions are less than or equal to the corresponding
         * dimensions of the background positioning area.
         * </p>
         * 
         * @return
         */
        public BackgroundImage contain() {
            properties[5] = "contain";

            return this;
        }

        /**
         * <p>
         * If a background-image is specified, the background-attachment CSS property determines
         * whether that image's position is fixed within the viewport, or scrolls along with its
         * containing block.
         * </p>
         * <p>
         * The background image will scroll within the viewport along with the block the image is
         * contained within.
         * </p>
         */
        public BackgroundImage scroll() {
            properties[1] = "scroll";

            return this;
        }

        /**
         * <p>
         * If a background-image is specified, the background-attachment CSS property determines
         * whether that image's position is fixed within the viewport, or scrolls along with its
         * containing block.
         * </p>
         * <p>
         * The background image will not scroll with its containing element, instead remaining
         * stationary within the viewport.
         * </p>
         */
        public BackgroundImage fixed() {
            properties[1] = "fixed";

            return this;
        }

        /**
         * <p>
         * If a background-image is specified, the background-attachment CSS property determines
         * whether that image's position is fixed within the viewport, or scrolls along with its
         * containing block.
         * </p>
         * <p>
         * The background image will not scroll with its containing element, but will scroll when
         * the element's content scrolls: it is fixed regarding the element's content.
         * </p>
         */
        public BackgroundImage local() {
            properties[1] = "local";

            return this;
        }

        /**
         * <p>
         * The background-repeat CSS property defines how background images are repeated. A
         * background image can be repeated along the horizontal axis, the vertical axis, both, or
         * not repeated at all. When the repetition of the image tiles doesn't let them exactly
         * cover the background, the way adjustments are done can be controlled by the author: by
         * default, the last image is clipped, but the different tiles can instead be re-sized, or
         * space can be inserted between the tiles.
         * </p>
         */
        public BackgroundImage repeatX() {
            properties[4] = "repeat-x";

            return this;
        }

        /**
         * <p>
         * The background-repeat CSS property defines how background images are repeated. A
         * background image can be repeated along the horizontal axis, the vertical axis, both, or
         * not repeated at all. When the repetition of the image tiles doesn't let them exactly
         * cover the background, the way adjustments are done can be controlled by the author: by
         * default, the last image is clipped, but the different tiles can instead be re-sized, or
         * space can be inserted between the tiles.
         * </p>
         */
        public BackgroundImage repeatY() {
            properties[4] = "repeat-y";

            return this;
        }

        /**
         * <p>
         * The background-repeat CSS property defines how background images are repeated. A
         * background image can be repeated along the horizontal axis, the vertical axis, both, or
         * not repeated at all. When the repetition of the image tiles doesn't let them exactly
         * cover the background, the way adjustments are done can be controlled by the author: by
         * default, the last image is clipped, but the different tiles can instead be re-sized, or
         * space can be inserted between the tiles.
         * </p>
         */
        public BackgroundImage repeat() {
            properties[4] = "repeat";

            return this;
        }

        /**
         * <p>
         * The background-repeat CSS property defines how background images are repeated. A
         * background image can be repeated along the horizontal axis, the vertical axis, both, or
         * not repeated at all. When the repetition of the image tiles doesn't let them exactly
         * cover the background, the way adjustments are done can be controlled by the author: by
         * default, the last image is clipped, but the different tiles can instead be re-sized, or
         * space can be inserted between the tiles.
         * </p>
         */
        public BackgroundImage space() {
            properties[4] = "space";

            return this;
        }

        /**
         * <p>
         * The background-repeat CSS property defines how background images are repeated. A
         * background image can be repeated along the horizontal axis, the vertical axis, both, or
         * not repeated at all. When the repetition of the image tiles doesn't let them exactly
         * cover the background, the way adjustments are done can be controlled by the author: by
         * default, the last image is clipped, but the different tiles can instead be re-sized, or
         * space can be inserted between the tiles.
         * </p>
         */
        public BackgroundImage round() {
            properties[4] = "round";

            return this;
        }

        /**
         * <p>
         * The background-repeat CSS property defines how background images are repeated. A
         * background image can be repeated along the horizontal axis, the vertical axis, both, or
         * not repeated at all. When the repetition of the image tiles doesn't let them exactly
         * cover the background, the way adjustments are done can be controlled by the author: by
         * default, the last image is clipped, but the different tiles can instead be re-sized, or
         * space can be inserted between the tiles.
         * </p>
         */
        public BackgroundImage noRepeat() {
            properties[4] = "no-repeat";

            return this;
        }
    }
}
