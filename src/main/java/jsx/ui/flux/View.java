/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.flux;

import jsx.style.StyleDSL;
import jsx.ui.StructureDSL;

/**
 * @version 2016/04/07 12:08:10
 */
public class View<Model, StyleDefinition extends StyleDSL> extends StructureDSL {

    StyleDefinition $;
}
