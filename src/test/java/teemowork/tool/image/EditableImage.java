/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.tool.image;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;

import kiss.I;

/**
 * @version 2013/03/25 11:51:38
 */
public class EditableImage {

    private static final Map<Key, Object> hints = new HashMap();

    static {
        hints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        hints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        hints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
    }

    /** The original file. */
    private final Path file;

    /** The current image. */
    private BufferedImage image;

    /**
     * 
     */
    public EditableImage() {
        file = null;
        image = new EmptyImage();
    }

    /**
     * @param file
     */
    public EditableImage(Path file) {
        try {
            this.file = file;
            this.image = ImageIO.read(file.toFile());
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Triming.
     * </p>
     * 
     * @param size
     */
    public EditableImage trim(int size) {
        return trim(size, size, size, size);
    }

    /**
     * <p>
     * Trim image.
     * </p>
     * 
     * @param top A triming pixel size of top side.
     * @param right A triming pixel size of right side.
     * @param bottom A triming pixel size of bottom side.
     * @param left A triming pixel size of left side.
     */
    public EditableImage trim(int top, int right, int bottom, int left) {
        int width = image.getWidth();
        int height = image.getHeight();

        image = image.getSubimage(left, top, width - left - right, height - top - bottom);

        return this;
    }

    /**
     * <p>
     * Resize image by horizontal length with keeping aspect ratio.
     * </p>
     * 
     * @param size
     */
    public EditableImage resize(int size) {
        BufferedImage screen = new BufferedImage(size, size, image.getType());
        Graphics2D graphics = screen.createGraphics();
        graphics.setRenderingHints(hints);
        graphics.drawImage(image, 0, 0, size, size, null);
        image = screen;

        return this;
    }

    /**
     * <p>
     * Concatenate horizontaly.
     * </p>
     * 
     * @param image2
     */
    public EditableImage concat(EditableImage target) {
        BufferedImage screen = new BufferedImage(image.getWidth() + target.image.getWidth(), Math.max(image.getHeight(), target.image.getHeight()), image.getType());
        Graphics2D graphics = screen.createGraphics();
        graphics.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        graphics.drawImage(target.image, image.getWidth(), 0, target.image.getWidth(), target.image.getHeight(), null);
        image = screen;

        return this;
    }

    /**
     * <p>
     * Write current image.
     * </p>
     * 
     * @param output
     */
    public void write(Path output) {
        if (output != null && image != null) {
            String[] names = I.call(output);

            switch (names[1].toLowerCase()) {
            case "jpg":
            case "jpeg":
                writeJPG(output);
                break;

            default:
                break;
            }
        }
    }

    /**
     * <p>
     * Write current image.
     * </p>
     * 
     * @param type
     */
    public void write(Path directory, ImageType type) {
        if (directory != null && type != null && image != null) {
            write(directory.resolve(I.call(file)[0] + "." + type.name().toLowerCase()));
        }
    }

    /**
     * <p>
     * Helper method to write jpeg file.
     * </p>
     * 
     * @param path
     */
    private void writeJPG(Path path) {
        try {
            BufferedImage screen = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            screen.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);

            JPEGImageWriteParam param = new JPEGImageWriteParam(Locale.getDefault());
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(0.9f);

            ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
            writer.setOutput(ImageIO.createImageOutputStream(path.toFile()));
            writer.write(null, new IIOImage(screen, null, null), param);
            writer.dispose();
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * @version 2013/03/26 0:27:37
     */
    private static class EmptyImage extends BufferedImage {

        /**
         * 
         */
        private EmptyImage() {
            super(1, 1, BufferedImage.TYPE_INT_RGB);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getWidth() {
            return 0;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int getHeight() {
            return 0;
        }

    }
}
