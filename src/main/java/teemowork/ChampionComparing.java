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
import static teemowork.model.Status.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import js.util.jQuery;
import js.util.jQuery.Listener;
import jsx.application.Page;
import jsx.application.PageInfo;
import jsx.bwt.UIEvent;
import teemowork.ChampionComparingStyle.Body;
import teemowork.ChampionComparingStyle.Head;
import teemowork.ChampionComparingStyle.Icon;
import teemowork.ChampionComparingStyle.Name;
import teemowork.ChampionComparingStyle.NoIcon;
import teemowork.ChampionComparingStyle.RowLine;
import teemowork.ChampionComparingStyle.StatusView;
import teemowork.ChampionComparingStyle.Table;
import teemowork.model.Champion;
import teemowork.model.ChampionGroup;
import teemowork.model.ChampionStatus;
import teemowork.model.Status;
import teemowork.model.Version;

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
        jQuery table = root.child(Table.class);
        jQuery head = table.child(Head.class);
        head.child(NoIcon.class);
        head.child(Name.class).text("Name");

        for (final Status value : STATUS) {
            head.child(StatusView.class).text(value.name).click(new Listener() {

                @Override
                public void handler(UIEvent event) {
                    sort(value);
                }
            });
        }

        body = table.child(Body.class);

        // create row
        for (Champion champion : Champion.getAll()) {
            ChampionStatus status = champion.getStatus(Version.Latest);

            jQuery row = $("<div>").add(RowLine.class);
            champion.applyIcon(row.child(Icon.class));
            row.child(Name.class).text(champion.name);

            for (Status value : STATUS) {
                row.child(StatusView.class).text(status.get(value));
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
}
