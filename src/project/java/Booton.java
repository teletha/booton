/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
import bee.api.Command;
import bee.api.Task;

/**
 * @version 2012/12/29 12:06:39
 */
public class Booton extends Task {

    /** The server port number. */
    protected int port = 10021;

    @Command
    public void develop() {
        ui.talk("eee");
    }

}
