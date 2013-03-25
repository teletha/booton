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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import kiss.I;
import sun.awt.image.BufferedImageGraphicsConfig;
import teemowork.tool.image.Scalr.Method;

/**
 * @version 2013/03/25 11:51:38
 */
public class ImageConverter {

    /** The original file. */
    private final Path file;

    /** The current image. */
    private BufferedImage image;

    /**
     * @param file
     */
    public ImageConverter(Path file) {
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
    public ImageConverter trim(int size) {
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
    public ImageConverter trim(int top, int right, int bottom, int left) {
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
    public ImageConverter resizeX(int size) throws Exception {
        image = Scalr.resize(image, Method.ULTRA_QUALITY, size);

        // image = createCompatibleImage(image);
        //
        // image = blurImage(image);
        // image = resize(image, size, size);

        // Image screen = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
        // BufferedImage shrinkImage = new BufferedImage(size, size, image.getType());
        // shrinkImage.createGraphics().drawImage(screen, 0, 0, null);
        // image = shrinkImage;

        // BufferedImage shrinkImage = new BufferedImage(size, size, image.getType());
        // Graphics2D g2d = shrinkImage.createGraphics();
        // g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
        // RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        // g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
        // RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        // g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        // g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        // RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        // g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        // RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        // g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
        // RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        // g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
        // RenderingHints.VALUE_STROKE_NORMALIZE);
        // g2d.drawImage(image, 0, 0, size, size, null);
        // image = shrinkImage;

        // ResampleOp op = new ResampleOp(size, size);
        // op.setFilter(new BiCubicFilter());
        // op.setUnsharpenMask(AdvancedResizeOp.UnsharpenMask.Normal);
        // image = op.filter(image, null);
        // System.out.println(image);

        return this;
    }

    private static BufferedImage resize(BufferedImage image, int width, int height) {
        int type = image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.setComposite(AlphaComposite.Src);

        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(image, 0, 0, width, height, null);
        g.dispose();
        return resizedImage;
    }

    public static BufferedImage blurImage(BufferedImage image) {
        float ninth = 1.0f / 9.0f;
        float[] blurKernel = {ninth, ninth, ninth, ninth, ninth, ninth, ninth, ninth, ninth};

        Map map = new HashMap();

        map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RenderingHints hints = new RenderingHints(map);
        BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, blurKernel), ConvolveOp.EDGE_NO_OP, hints);
        return op.filter(image, null);
    }

    private static BufferedImage createCompatibleImage(BufferedImage image) {
        GraphicsConfiguration gc = BufferedImageGraphicsConfig.getConfig(image);
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage result = gc.createCompatibleImage(w, h, Transparency.TRANSLUCENT);
        Graphics2D g2 = result.createGraphics();
        g2.drawRenderedImage(image, null);
        g2.dispose();
        return result;
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

            ImageIO.write(screen, "jpg", path.toFile());
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }
}
