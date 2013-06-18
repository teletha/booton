/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import js.util.jQuery;
import jsx.application.Page;
import jsx.application.PageInfo;
import teemowork.model.Item;
import teemowork.model.Version;

/**
 * @version 2013/06/13 16:43:49
 */
public class ItemDetail extends Page {

    /** The target item. */
    private Item item;

    /**
     * 
     */
    @PageInfo(path = "Item/*")
    public ItemDetail(String name) {
        this.item = Item.getByName(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "Item/" + item.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        root.child(new ItemView(item, item.getDescriptor(Version.Latest), null));
    }
}
