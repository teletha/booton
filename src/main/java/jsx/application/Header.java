/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import static js.lang.Global.*;
import jsx.jQuery;
import jsx.application.HeaderStyle.MenuLink;
import jsx.application.HeaderStyle.SubMenu;
import jsx.application.HeaderStyle.SubMenuGroup;
import jsx.application.HeaderStyle.TopMenu;
import jsx.application.HeaderStyle.TopMenuGroup;

/**
 * @version 2012/12/15 9:58:38
 */
public class Header {

    /** The application header. */
    private final jQuery container;

    /**
     * @param root
     */
    public Header() {
        container = $("#Header").add(TopMenuGroup.class);
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
        jQuery item = container.child("li").add(TopMenu.class);
        item.child("a").add(MenuLink.class).attr("href", uri).text(label);

        return new Menu(item);
    }

    /**
     * @version 2012/12/15 9:59:53
     */
    public class Menu {

        /** The container element. */
        private final jQuery container;

        /**
     * 
     */
        private Menu(jQuery root) {
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
            jQuery item = container.child("li").add(SubMenu.class);
            item.child("a").add(MenuLink.class).attr("href", uri).text(label);

            return new Menu(item);
        }
    }
}
