/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt;

/**
 * @version 2013/02/03 14:44:14
 */
public class Templatable {

    private Model model;

    protected void draw(Widget root) {
        root.text(model.name);
    }

    private void bind() {

    }

    private static class Model {

        @Bind
        private String name;
    }
}
