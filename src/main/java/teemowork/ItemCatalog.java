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

import static teemowork.model.Status.*;
import js.application.Page;
import js.application.PageInfo;
import js.util.jQuery;
import teemowork.model.Item;
import teemowork.model.ItemStatus;
import teemowork.model.Version;
import booton.css.CSS;

/**
 * @version 2013/02/19 18:31:47
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
    public void load(jQuery root) {
        for (Item item : Item.getAll()) {
            ItemStatus status = item.getStatus(Version.Latest);

            jQuery element = root.child(Styles.ItemPanel.class);
            jQuery icons = element.child(Styles.IconPanel.class);
            icons.child(Styles.Icon.class).css("background-image", "url(" + item.getIcon() + ")");

            jQuery descriptions = element.child(Styles.DescriptionPanel.class);
            jQuery names = descriptions.child(Styles.Names.class);
            names.child(Styles.Name.class).text(item.name);

            double cost = status.get(Cost);
            double total = item.getTotalCost(Version.Latest);

            names.child(Styles.TotalCost.class).text(total);

            if (cost != total) {
                names.append("(");
                names.child(Styles.Cost.class).text(cost);
                names.append(")");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "ItemCatalog";
    }

    /**
     * @version 2013/02/16 9:51:18
     */
    private static final class Styles {

        /** The skill icon size. */
        private static final int IconSize = 45;

        /**
         * @version 2013/02/16 9:52:23
         */
        private static class ItemPanel extends CSS {

            {
                display.table();
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class IconPanel extends CSS {

            {
                display.tableCell();
                padding.right(IconSize / 5, px);
                cursor.pointer();
            }
        }

        /**
         * @version 2013/02/16 9:52:23
         */
        private static class DescriptionPanel extends CSS {

            {
                display.tableCell();
                text.verticalAlign.top();
                box.height(60, px);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Names extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Name extends CSS {

            {
                margin.right(0.5, em);
                font.weight.bold();
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class TotalCost extends CSS {

            {
                margin.right(0.5, em);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Cost extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Icon extends CSS {

            private int size = 44;

            {
                display.inlineBlock();
                box.size(size, px);
                background.contain().size(size + 2, px).horizontal(-1, px).vertical(-1, px);
                border.radius(5, px).color(50, 50, 50).width(1, px).solid();
                text.verticalAlign.middle();
            }
        }
    }
}
