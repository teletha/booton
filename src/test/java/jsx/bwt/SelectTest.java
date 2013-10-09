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

import jsx.model.SelectableModel;

import org.junit.Test;

/**
 * @version 2013/10/09 16:19:05
 */
public class SelectTest {

    @Test
    public void selection() throws Exception {
        Items items = create();

        Select select = new Select(items);
        assert select.model.getSelectionIndex() == -1;
        assert select.form.val() == null;

        items.setSelectionIndex(2);
        assert select.model.getSelectionIndex() == 2;
        assert select.form.val() != null;
        assert select.form.val().equals("3");

        items.deselect();
        assert select.model.getSelectionIndex() == 0;
        assert select.form.val().equals("1");
    }

    /**
     * <p>
     * Helper method to create items.
     * </p>
     * 
     * @return
     */
    private Items create() {
        Items items = new Items();
        items.add("1", "2", "3", "4", "5");
        return items;
    }

    /**
     * @version 2013/10/05 10:00:21
     */
    private static class Items extends SelectableModel<String> {
    }
}
