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

/**
 * @version 2013/01/26 21:15:39
 */
public class ModelTestUtil {

    public static final Patch OldPatch = new Patch(1, 2013, 1, 10, "Old", null);

    public static final Patch CurrentPatch = new Patch(2, 2013, 1, 20, "Current", OldPatch);

    public static final Patch NewPatch = new Patch(3, 2013, 1, 30, "New", CurrentPatch);

    /**
     * <p>
     * Create empty champ for test.
     * </p>
     * 
     * @return
     */
    public static Champion createChamp() {
        return new Champion("Tester");
    }
}
