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

import static js.lang.Global.*;
import static teemowork.lol.Status.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import js.application.Page;
import js.application.PageInfo;
import js.util.ArrayList;
import js.util.jQuery;
import js.util.jQuery.Event;
import js.util.jQuery.Listener;
import teemowork.lol.Champion;
import teemowork.lol.ChampionGroup;
import teemowork.lol.ChampionStatus;
import teemowork.lol.Status;
import teemowork.lol.Version;
import booton.css.CSS;

/**
 * @version 2013/02/15 15:12:54
 */
public class ChampionComparing extends Page {

    private static final Status[] STATUS = {Health, Mana, AD, AS, AR, MR, MS, Range};

    /** The champion list. */
    private List<Row> rows = new ArrayList();

    /** The root element. */
    private jQuery body;

    /** The current sort key. */
    private Sorter sorter;

    private ChampionGroup group = ChampionGroup.RANGED;

    /**
     * 
     */
    @PageInfo(path = "ChampionComparing")
    public ChampionComparing() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(jQuery root) {
        jQuery table = root.child(Styles.Table.class);
        jQuery head = table.child(Styles.Head.class);
        head.child(Styles.NoIcon.class);
        head.child(Styles.Name.class).text("Name");

        for (final Status value : STATUS) {
            head.child(Styles.Status.class).text(value.name).click(new Listener() {

                @Override
                public void handler(Event event) {
                    sort(value);
                }
            });
        }

        body = table.child(Styles.Body.class);

        // create row
        for (Champion champion : Champion.getAll()) {
            ChampionStatus status = champion.getStatus(Version.Latest);

            jQuery row = $("<div>").addClass(Styles.Row.class);
            row.child(Styles.Icon.class).css("background-image", "url(" + champion.getIcon() + ")");
            row.child(Styles.Name.class).text(champion.name);

            for (Status value : STATUS) {
                row.child(Styles.Status.class).text(status.get(value));
            }
            rows.add(new Row(champion, row));
        }
        update();
    }

    /**
     * <p>
     * Update view.
     * </p>
     */
    private void update() {
        body.empty();

        for (Row row : rows) {
            if (group == null || group.contains(row.champion)) {
                body.append(row.element);
            }
        }
    }

    /**
     * <p>
     * Sort list by the specified key.
     * </p>
     * 
     * @param key
     */
    private void sort(Status key) {
        if (sorter != null && sorter.key == key) {
            sorter.order = sorter.order * -1;
        } else {
            sorter = new Sorter(key);
        }
        Collections.sort(rows, sorter);

        update();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "ChampionComparing";
    }

    /**
     * @version 2013/02/16 9:53:56
     */
    private static class Row {

        /** The associated champion. */
        private final Champion champion;

        /** The current status. */
        private final ChampionStatus status;

        /** The actual element. */
        private final jQuery element;

        /**
         * @param champion
         * @param element
         */
        private Row(Champion champion, jQuery element) {
            this.champion = champion;
            this.status = champion.getStatus(Version.Latest);
            this.element = element;
        }
    }

    /**
     * @version 2013/02/16 10:58:44
     */
    private static class Sorter implements Comparator<Row> {

        /** The sort key. */
        private final Status key;

        /** The sort order. */
        private int order = 1;

        /**
         * @param key
         */
        private Sorter(Status key) {
            this.key = key;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int compare(Row o1, Row o2) {
            double value1 = o1.status.get(key);
            double value2 = o2.status.get(key);

            if (value1 == value2) {
                return 0;
            } else if (value1 < value2) {
                return order;
            } else {
                return order * -1;
            }
        }
    }

    /**
     * @version 2013/02/16 9:51:18
     */
    private static final class Styles {

        /**
         * @version 2013/02/16 9:52:23
         */
        private static class Table extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Head extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/16 9:52:23
         */
        private static class Body extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Row extends CSS {

            {

            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Name extends CSS {

            {
                display.inlineBlock();
                box.width(7, em);
                text.verticalAlign.middle();
                padding.left(20, px);
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
                background.contain().size(size + 4, px).horizontal(-2, px).vertical(-2, px);
                border.radius(5, px).color(50, 50, 50).width(1, px).solid();
                text.verticalAlign.middle();
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class NoIcon extends CSS {

            {
                display.inlineBlock();
                box.size(40, px);
            }
        }

        /**
         * @version 2013/02/16 10:00:01
         */
        private static class Status extends CSS {

            {
                display.inlineBlock();
                box.width(4, em);
                text.verticalAlign.middle();
            }
        }
    }
}
