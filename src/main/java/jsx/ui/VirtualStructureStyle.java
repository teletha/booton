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

import booton.css.CSS;

/**
 * @version 2014/09/12 11:00:18
 */
class VirtualStructureStyle {

    /**
     * @version 2014/09/12 19:20:09
     */
    class HBOX extends CSS {

        {
            display.flex();
        }
    }

    /**
     * @version 2014/09/12 19:20:11
     */
    class VBOX extends CSS {

        {
            display.flex().direction.column();
        }
    }

    /**
     * @version 2014/09/12 19:20:14
     */
    class SBOX extends CSS {

        {
            position.relative();

            children(() -> {
                position.absolute();
            });
        }
    }
}
