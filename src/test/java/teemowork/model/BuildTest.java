/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.ModelTestUtil.*;

import org.junit.Test;

/**
 * @version 2013/01/26 21:13:17
 */
public class BuildTest {

    @Test
    public void build() throws Exception {
        Build build = create();
        build.
    }

    private Build create() {
        Champion champion = new Champion("Tester");
        champion.improvement = new Improvement(CurrentPatch, null);
        Build build = new Build(champion);

        return build;
    }
}
