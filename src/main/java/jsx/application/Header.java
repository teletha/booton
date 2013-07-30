/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import static js.lang.Global.*;
import js.dom.Element;
import jsx.application.HeaderStyle.MenuLink;
import jsx.application.HeaderStyle.SubMenu;
import jsx.application.HeaderStyle.SubMenuGroup;
import jsx.application.HeaderStyle.TopMenu;
import jsx.application.HeaderStyle.TopMenuGroup;

/**
 * @version 2013/07/30 21:32:12
 */
public class Header {

    /** The application header. */
    private final Element container;

    /**
     * @param root
     */
    public Header() {
        container = document.getElementById("Header").add(TopMenuGroup.class);
    }

    /**
     * <p>
     * Add navigation menu.
     * </p>
     * 
     * @param label
     * @param uri
     */
    public Menu add(String label, String uri) {
        Element item = container.child("li").add(TopMenu.class);
        item.child("a").add(MenuLink.class).attr("href", uri).text(label);

        return new Menu(item);
    }

    /**
     * @version 2013/07/30 21:32:24
     */
    public class Menu {

        /** The container element. */
        private final Element container;

        /**
     * 
     */
        private Menu(Element root) {
            this.container = root.child("ul").add(SubMenuGroup.class);
        }

        /**
         * <p>
         * Add navigation menu.
         * </p>
         * 
         * @param label
         * @param uri
         */
        public Menu add(String label, String uri) {
            Element item = container.child("li").add(SubMenu.class);
            item.child("a").add(MenuLink.class).attr("href", uri).text(label);

            return new Menu(item);
        }
    }
}
