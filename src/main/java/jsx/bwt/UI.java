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

import static js.lang.Global.*;
import js.dom.Element;
import jsx.event.Publishable;

/**
 * @version 2013/07/29 2:28:28
 */
public abstract class UI extends Publishable {

    /** The root container element for this user interface. */
    public final Element root;

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
        WindowManager.applyTooltip(root, content.root);
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
