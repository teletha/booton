/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static booton.translator.web.WebSupport.*;

import java.util.Collection;

import js.ui.Application;
import js.ui.ImageGrid;
import teemowork.model.Champion;
import booton.css.CSS;
import booton.translator.web.jQuery;

/**
 * @version 2012/12/11 14:23:57
 */
public class Teemowork extends Application {

    /** The champion viewer. */
    private ImageGrid champions = new ImageGrid<Champion>() {

        @Override
        protected Collection<Champion> sources() {
            return Champion.getAll();
        }

        @Override
        protected String name(Champion source) {
            return source.name;
        }

        @Override
        protected String uri(Champion source) {
            return "src/main/resources/teemowork/icon/" + source.getSystemName() + ".png";
        }
    };

    /**
     * {@inheritDoc}
     */
    @Override
    protected void jsmain() {

        for (Champion champion : Champion.getAll()) {
            jQuery item = $("<li><a class='tt-twitter' href='#'><span>" + champion.name + "</span></a></li>");
            item.appendTo("body");
        }

        $("a").addClass(MyCSS.class);
    }

    /**
     * @version 2012/12/10 16:59:19
     */
    private static class MyCSS extends CSS {

        {
            display().block();
            width.size(68, px);
            height.size(70, px);
            margin.vertical(0, px).horizontal(2, px);
            outline.none();
            background.transparent().noRepeat().top().left();
        }
    }
}
