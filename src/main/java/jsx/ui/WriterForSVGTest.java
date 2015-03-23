/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

/**
 * @version 2015/03/23 11:41:40
 */
public class WriterForSVGTest {

    {
        new SVG() {

            {
                path().start(10, 10).line(90, 90);
            }
        };
    }
}
