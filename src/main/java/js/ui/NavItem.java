/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.ui;

import booton.css.CSS;
import booton.translator.web.jQuery;

/**
 * @version 2012/12/15 9:59:53
 */
public class NavItem {

    /** The container element. */
    protected final jQuery container;

    /**
     * 
     */
    public NavItem(jQuery root) {
        this.container = root.child("ul").addClass(Style.class);
    }

    /**
     * <p>
     * Add navigation menu.
     * </p>
     * 
     * @param label
     * @param uri
     */
    public NavItem add(String label, String uri) {
        jQuery item = container.child("li");
        item.child("a").attr("href", uri).text(label);

        return new NavItem(item);
    }

    /**
     * @version 2012/12/14 23:51:44
     */
    private static class Style extends CSS {

        {
            margin.size(0, px);
            padding.size(0, px);
            listStyle.none();
        }
    }
}
