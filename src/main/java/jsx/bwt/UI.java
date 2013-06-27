/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static js.lang.Global.*;
import static jsx.bwt.UIAction.*;
import jsx.jQuery;
import jsx.bwt.view.PopupViewStyle;
import jsx.jQuery.Offset;

/**
 * @version 2012/12/11 14:39:54
 */
public abstract class UI extends Publishable {

    /** The root container element for this user interface. */
    public final jQuery root;

    /** The tooltip ui. */
    private UI tooltip;

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
        this.root = $("<" + name + ">");
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
        WindowManager.applyTooltip(root, content.root);

        // if (content == null) {
        // tooltip = null;
        // root.unbind(this);
        // } else {
        // tooltip = content;
        // root.bind(this);
        // }
    }

    /**
     * <p>
     * Show tooltip.
     * </p>
     */
    @Listen(MouseEnter)
    private void showTooltip() {
        tooltip.root.add(PopupViewStyle.Bottom.class);

        root.append(tooltip);
        Offset offset = root.position();
        tooltip.root.css("top", offset.top + root.outerHeight() + 15 + "px");
        tooltip.root.css("left", offset.left - tooltip.root.outerWidth() / 2 + root.outerWidth() / 2 + "px");
    }

    /**
     * <p>
     * Hide tooltip.
     * </p>
     */
    @Listen(MouseLeave)
    private void hideTooltip() {
        tooltip.root.remove();
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
}
