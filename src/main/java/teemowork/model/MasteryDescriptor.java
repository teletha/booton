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
 * @version 2013/03/13 14:55:20
 */
public class MasteryDescriptor extends Descriptor<MasteryDescriptor> {

    /**
     * 
     */
    MasteryDescriptor(Mastery mastery, MasteryDescriptor previous, Version version) {
        super(mastery, previous, version);
    }
}
