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
            String uri = "src/main/resources/teemowork/icon/" + champion.getSystemName() + ".png";

            jQuery item = $("<li><a class='tt-twitter' href='#'><span>" + champion.name + "</span></a></li>");
            item.appendTo("body");
            item.children("a").css("background-image", "url(" + uri + ")").css("background-size", "contain");
        }

        $("a").addClass(MyCSS.class);
        $("span").addClass(Span.class);
    }

    /**
     * @version 2012/12/10 16:59:19
     */
    private static class MyCSS extends CSS {

        {
            display.block();
            width.size(68, px);
            height.size(70, px);
            margin.vertical(0, px).horizontal(2, px);
            outline.none();
            background.transparent().noRepeat().top().left();
            position.relative();
        }
    }

    /**
     * @version 2012/12/10 16:59:19
     */
    private static class Span extends CSS {

        {
            width.size(100, px);
            height.auto();
            lineHeight.size(20, px);
            padding.size(10, px);
            left.size(50, percent);
            margin.left(-64, px);
            font.style.italic().size(14, px).weight(400);
            color.hex("719DAB");
            textShadow.add(1, px, 1, px, 1, px, rgba(0, 0, 0, 0.1));
            textAlign.center();
            border.width(4, px).solid().rgb(255, 255, 255);
            background.rgba(255, 255, 255, 0.3);
            textIndent.size(0, px);
            borderRadius.size(5, px);
            position.absolute();
            pointerEvents.none();
            bottom.size(100, px);
            opacity.alpha(0);
            boxShadow.offset(1, px, 1, px).blurRadius(2, px).rgba(0, 0, 0, 0.1);
        }
    }
}
