/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2014/08/21 15:28:54
 */
public class VirtualElement {

    /** The attributes list. */
    private final List<String[]> attributes = new ArrayList();

    /** The child elements. */
    private final List<VirtualElement> children = new ArrayList();
}
