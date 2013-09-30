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

import js.dom.DocumentFragment;
import jsx.application.Page;
import jsx.application.PageInfo;
import teemowork.model.Item;
import teemowork.model.ItemDescriptor;
import teemowork.model.Version;

/**
 * @version 2013/06/12 12:45:51
 */
public class ItemCatalog extends Page {

    /**
     * 
     */
    @PageInfo(path = "ItemCatalog")
    public ItemCatalog() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        for (Item item : Item.getAll()) {
            ItemDescriptor descriptor = item.getDescriptor(Version.Latest);

            if (descriptor.isDeprecated()) {
                continue;
            }

            root.child(new ItemView(item, descriptor, null));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "ItemCatalog";
    }
}
