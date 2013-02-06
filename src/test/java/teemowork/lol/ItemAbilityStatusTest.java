/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import static teemowork.lol.Status.*;

import org.junit.Test;

/**
 * @version 2013/01/30 10:54:04
 */
public class ItemAbilityStatusTest {

    @Test
    public void ability() throws Exception {
        ItemAbilityStatus item = new ItemAbilityStatus(null);
        item.set(AD, 20);
        assert item.get(AD) == 20;
    }
}
