/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.tool;

import java.nio.file.Path;

import kiss.Extensible;
import kiss.I;

/**
 * @version 2013/02/01 22:00:46
 */
public abstract class ImageScannerBase implements Extensible {

    /** The lol root directory. */
    private static final Path LoL = I.locate("f:\\Game\\League of Legends");

    /** The image root directory. */
    protected static final Path Output = I.locate("src/main/resources/teemowork");

    /** The latest version directory. */
    protected static final Path Latest;

    /** The latest image directory. */
    protected static final Path Images;

    static {
        I.load(ImageScannerBase.class, true);

        Path path = null;

        for (Path version : I.walkDirectory(LoL.resolve("RADS/projects/lol_air_client/releases"), "*")) {
            path = version;
        }
        Latest = path;
        Images = path.resolve("deploy/assets/images");
    }

    /**
     * <p>
     * Scan images.
     * </p>
     */
    protected abstract void process();

    /**
     * <p>
     * </p>
     * 
     * @param args
     */
    public static void main(String[] args) {
        for (ImageScannerBase scanner : I.find(ImageScannerBase.class)) {
            scanner.process();
        }
    }
}
