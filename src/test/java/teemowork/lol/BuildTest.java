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
 * @version 2013/01/27 9:19:11
 */
public class BuildTest {

    @Test
    public void build() throws Exception {
        Item item = new Item(0, "").set(Version.P1154)
                .set(AD, 10)
                .add(new Ability("a", false).set(Version.P1154).set(AD, 10));

        Build build = new Build();
        build.set(0, item);
        build.setVersion(Version.P1154);

        assert build.get(AD).calcurated == 20;
    }
}
