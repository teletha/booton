/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static js.dom.UIAction.*;
import static js.lang.Global.*;
import js.dom.ClientRect;
import js.dom.Element;
import jsx.application.PageUnload;
import jsx.bwt.view.PopupViewStyle;
import jsx.event.Publishable;
import jsx.event.Subscribe;
import jsx.event.SubscribeUI;

/**
 * @version 2013/06/12 9:11:13
 */
public class WindowManager {

    /** The popup area. */
    private static Element popup;

    /** The popup target. */
    private final Element target;

    /** The popup content. */
    private final Element content;

    /**
     * 
     */
    private WindowManager(Element target, Element content) {
        if (popup == null) {
            popup = document.createElement("div").add(PopupViewStyle.Bottom.class);
            document.getElementsByTagName("body").item(0).append(popup);
        }

        this.target = target;
        this.content = content;

        Publishable.Global.register(this);
    }

    /**
     * 
     */
    @SubscribeUI(type = PointerEnter)
    private void show() {
        popup.append(content);
        popup.add(PopupViewStyle.Show.class);

        ClientRect popupArea = popup.position();
        ClientRect targetArea = target.position();

        popup.css("top", targetArea.bottom() + 15 + "px")
                .css("left", targetArea.left() - popupArea.width() / 2 + targetArea.width() / 2 + "px");
    }

    /**
     * 
     */
    @SubscribeUI(type = PointerLeave)
    private void hide() {
        popup.remove(PopupViewStyle.Show.class);
        content.remove();
    }

    /**
     * 
     */
    @Subscribe(PageUnload.class)
    private void unload() {
        Publishable.Global.unregister(this);
        target.off();
        hide();
    }

    public static void applyTooltip(Element target, Element content) {
        if (target != null && content != null) {
            target.bind(new WindowManager(target, content));
        }
    }

    /**
     * @version 2013/10/10 12:44:47
     */
    private static class Popup {

    }
}
