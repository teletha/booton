/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.virtual;

import static booton.virtual.PatchType.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2014/08/28 22:50:20
 */
public class Diff {

    /**
     * @param left
     * @param right
     */
    public static Patch diff(VNode left, VNode right) {
        return null;
    }

    private static void walk(VNode a, VNode b, List<List<Patch>> patch, int index) {
        if (a == b) {
            // same object
        }

        List<Patch> apply = patch.get(index);

        if (b == null) {
            apply = appendPatch(apply, new Patch(REMOVE, a, b));
            destroyWidget(a, patch, index);
        }
    }

    private static void destroyWidget(VNode vNode, List<List<Patch>> patch, int index) {

    }

    private static List<Patch> appendPatch(List<Patch> apply, Patch patch) {
        if (apply == null) {
            apply = new ArrayList();
        }
        apply.add(patch);

        return apply;
    }
}
