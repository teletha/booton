/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.widget;

/**
 * @version 2013/06/29 13:11:10
 */
public interface Subscribable extends Terminable {

    public void subscribe(Publishable publishable);
}