/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import static js.lang.Global.*;
import js.dom.Element;
import js.ui.FormUIStyle.InputForm;
import js.ui.FormUIStyle.SelectArrow;
import js.util.Raphael;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;

/**
 * @version 2013/03/28 1:31:15
 */
public class Select extends FormUI<Select> {

    /**
     * <p>
     * Create input form.
     * </p>
     */
    public Select() {
        form.add(InputForm.class).set("type", "input").set("readonly", "true").set("value", "aaa");

        Element e = root.child(SelectArrow.class);
        Raphael paper = $(e, 40, 40);
        final Raphael outline = paper.path("M23.963,20.834L17.5,9.64c-0.825-1.429-2.175-1.429-3,0L8.037,20.834c-0.825,1.429-0.15,2.598,1.5,2.598h12.926C24.113,23.432,24.788,22.263,23.963,20.834z")
                .attr("fill", "none")
                .attr("stroke", "#aaa")
                .attr("stroke-width", "3")
                .attr("stroke-linejoin", "round")
                .attr("opacity", "0");

        paper.path("M23.963,20.834L17.5,9.64c-0.825-1.429-2.175-1.429-3,0L8.037,20.834c-0.825,1.429-0.15,2.598,1.5,2.598h12.926C24.113,23.432,24.788,22.263,23.963,20.834z")
                .attr("fill", "#000")
                .attr("stroke", "none");

        $(e).mouseenter(new Listener() {

            @Override
            public void handler(js.util.jQuery.Event event) {
                outline.attr("opacity", "1");
            }
        }).mouseleave(new Listener() {

            @Override
            public void handler(Event event) {
                outline.attr("opacity", "0");
            }
        });

        // SVG svg = new SVG(SelectArrow.class);
        // final Path path = svg.path()
        // .fill("none")
        // .stroke("#00ff00")
        // .strokeWidth(3)
        // .strokeLineJoin("round")
        // .line("M8.037,11.166L14.5,22.359C15.325,23.789,16.675,23.789,17.5,22.359L23.963,11.165000000000001C24.789,9.736,24.113,8.567,22.463,8.567H9.537C7.886,8.568,7.211,9.737,8.037,11.166Z");
        // path.getElement().addEventListener("mouseenter", new Listener() {
        //
        // @Override
        // public void handleEvent(Event event) {
        // path.getElement().set("style", "opacity:1;");
        // }
        // });
        // path.getElement().addEventListener("mouseout", new Listener() {
        //
        // @Override
        // public void handleEvent(Event event) {
        // path.getElement().set("style", "opacity:0;");
        // }
        // });
        //
        // Path path2 = svg.path()
        // .fill("#333333")
        // .stroke("none")
        // .line("M8.037,11.166L14.5,22.359C15.325,23.789,16.675,23.789,17.5,22.359L23.963,11.165000000000001C24.789,9.736,24.113,8.567,22.463,8.567H9.537C7.886,8.568,7.211,9.737,8.037,11.166Z");
        //
        // path2.getElement().addEventListener("mouseenter", new Listener() {
        //
        // @Override
        // public void handleEvent(Event event) {
        // path.getElement().set("style", "opacity:1;");
        // }
        // });

        // root.append(svg);
    }
}
