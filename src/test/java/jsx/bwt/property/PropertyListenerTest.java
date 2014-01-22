/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.property;

import kiss.I;

import org.junit.Test;

/**
 * @version 2014/01/20 11:07:12
 */
public class PropertyListenerTest {

    @Test
    public void notification() throws Exception {
        VoiceActor actor = I.make(VoiceActor.class);
        actor.setAge(17);
        actor.setName("Yukarin");
    }
}
