/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import jsx.style.Style;

/**
 * @version 2014/09/12 11:00:18
 */
class VirtualStructureStyle extends Style {

    /**
     * @version 2014/09/12 19:20:09
     */
    void HBOX() {
        // display.flex();
    }

    /**
     * @version 2014/09/12 19:20:11
     */
    void VBOX() {
        // display.flex().direction.column();
    }

    /**
     * @version 2014/09/12 19:20:14
     */
    void SBOX() {
        // position.relative();
        //
        // children(() -> {
        // position.absolute();
        // });
    }
}
