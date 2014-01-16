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
 * @version 2013/07/29 2:28:28
 */
public abstract class UI extends Publishable {

    /** The popup area. */
    private static Element popup;

    /** The root container element for this user interface. */
    public final Element root;

    /** The tooltip content. */
    private Tooltip tooltip;

    /**
     * <p>
     * Create UI with div element.
     * </p>
     */
    protected UI() {
        this("span");
    }

    /**
     * <p>
     * Create UI with specified root element.
     * </p>
     * 
     * @param name
     */
    protected UI(String name) {
        this.root = document.createElement(name);
    }

    /**
     * <p>
     * Set tooltip content.
     * </p>
     * 
     * @param content A content to show on tooltip.
     */
    public void setTooltip(String content) {
        setTooltip(new TextUI(content));
    }

    /**
     * <p>
     * Set tooltip content.
     * </p>
     * 
     * @param content A content to show on tooltip.
     */
    public void setTooltip(UI content) {
        if (tooltip == null || tooltip.content != content) {
            if (content == null) {
                // remove tooltip
            } else {
                if (tooltip == null) {
                    // first access
                    tooltip = new Tooltip();

                    // popup event listener
                    root.on(tooltip);

                    Publishable.Global.on(tooltip);
                } else {
                    // dispose old tooptip
                }

                // set new tooltip
                tooltip.content = content;
            }
        }
    }

    /**
     * @version 2013/06/10 16:28:04
     */
    private static class TextUI extends UI {

        /**
         * @param text
         */
        private TextUI(String text) {
            root.text(text);
        }
    }

    /**
     * @version 2013/12/29 18:47:37
     */
    private class Tooltip {

        /** The popup content. */
        private UI content;

        /**
         * 
         */
        private Tooltip() {
            if (popup == null) {
                popup = document.createElement("div").add(PopupViewStyle.Bottom.class);
                document.getElementsByTagName("body").item(0).append(popup);
            }
        }

        /**
         * 
         */
        @SubscribeUI(type = PointerEnter)
        private void show() {
            popup.append(content);
            popup.add(PopupViewStyle.Show.class);

            ClientRect popupArea = popup.position();
            ClientRect targetArea = root.position();

            popup.css("top", targetArea.bottom() + 15 + "px")
                    .css("left", targetArea.left() - popupArea.width() / 2 + targetArea.width() / 2 + "px");
        }

        /**
         * 
         */
        @SubscribeUI(type = PointerLeave)
        private void hide() {
            popup.remove(PopupViewStyle.Show.class);
            content.root.remove();
        }

        /**
         * 
         */
        @Subscribe(PageUnload.class)
        private void unload() {
            Publishable.Global.off(this);
            root.unregister();
            hide();
        }
    }
}
