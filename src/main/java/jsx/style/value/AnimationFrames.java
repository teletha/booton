/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style.value;

import js.lang.NativeArray;
import jsx.style.StyleRule;
import jsx.ui.Style;

/**
 * @version 2015/10/06 14:00:26
 */
public class AnimationFrames {

    /** The frame name. */
    public final String name;

    /** The list of animation frames. */
    private NativeArray<Frame> frames = new NativeArray();

    /**
     * @param frames
     */
    public AnimationFrames() {
        this.name = "Anima" + hashCode();
    }

    /**
     * <p>
     * Add new keyframe to this {@link AnimationFrames}.
     * </p>
     * 
     * @param progress A point of the animation frame.
     * @param style A style state at the point.
     * @return Chainable API.
     */
    public AnimationFrames frame(int progress, Style style) {
        frames.push(new Frame(style, progress));

        return this;
    }

    /**
     * <p>
     * Add new keyframe to this {@link AnimationFrames}.
     * </p>
     * 
     * @param progress1 A point of the animation frame.
     * @param progress2 A point of the animation frame.
     * @param style A style state at the point.
     * @return Chainable API.
     */
    public AnimationFrames frame(int progress1, int progress2, Style style) {
        frames.push(new Frame(style, progress1, progress2));

        return this;
    }

    /**
     * <p>
     * Add new keyframe to this {@link AnimationFrames}.
     * </p>
     * 
     * @param progress1 A point of the animation frame.
     * @param progress2 A point of the animation frame.
     * @param progress3 A point of the animation frame.
     * @param style A style state at the point.
     * @return Chainable API.
     */
    public AnimationFrames frame(int progress1, int progress2, int progress3, Style style) {
        frames.push(new Frame(style, progress1, progress2, progress3));

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("@keyframes ").append(name).append("{");
        for (int i = 0; i < frames.length(); i++) {
            builder.append(frames.get(i));
        }
        builder.append("}");
        return builder.toString();
    }

    /**
     * @version 2015/10/06 14:49:35
     */
    private static class Frame {

        /** The progress info. */
        private final int[] progress;

        /** The style. */
        private final StyleRule style;

        /**
         * <p>
         * Build new animation frame.
         * </p>
         * 
         * @param style A current style.
         * @param progress A current progress.
         */
        private Frame(Style style, int... progress) {
            this.progress = progress;
            this.style = StyleRule.create("$", style, true);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < progress.length; i++) {
                builder.append(progress[i]).append("%");

                if (i + 1 != progress.length) {
                    builder.append(",");
                }
            }

            builder.append("{");
            for (int i = 0; i < style.properties.size(); i++) {
                builder.append(style.properties.key(i)).append(":").append(style.properties.value(i)).append(";");
            }
            builder.append("}");

            return builder.toString();
        }
    }
}
