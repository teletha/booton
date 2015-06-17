/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/07/07 11:55:50
 */
@RunWith(ScriptRunner.class)
public class MathTest {

    @Test
    public void abs() throws Exception {
        assert Math.abs(1) == 1;
        assert Math.abs(1F) == 1F;
        assert Math.abs(1D) == 1D;
        assert Math.abs(1L) == 1L;

        assert Math.abs(-10) == 10;
        assert Math.abs(-10F) == 10F;
        assert Math.abs(-10D) == 10D;
        assert Math.abs(-10L) == 10L;
    }

    @Test
    public void max() throws Exception {
        assert Math.max(2, 3) == 3;
        assert Math.max(3L, 2L) == 3L;
        assert Math.max(2F, 3F) == 3F;
        assert Math.max(3D, 2D) == 3D;
    }

    @Test
    public void round() throws Exception {
        assert Math.round(2.3) == 2;
    }
}
