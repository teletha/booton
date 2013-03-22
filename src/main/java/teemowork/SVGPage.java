/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import js.application.Page;
import js.application.PageInfo;
import js.dom.Image;
import js.util.jQuery;
import teemowork.MasteryBuilderStyle.MasteryIcon;

/**
 * @version 2013/03/22 11:21:49
 */
public class SVGPage extends Page {

    /**
     * 
     */
    @PageInfo(path = "SVG")
    public SVGPage() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "SVG";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        System.out.println("SVG");

        Image image = root.image(MasteryIcon.class);
        image.grayscale(0.7).size(45, 45).src("src/main/resources/teemowork/mastery/s3/Fury.png");
    }
}
