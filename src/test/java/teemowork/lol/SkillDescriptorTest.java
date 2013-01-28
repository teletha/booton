/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import static teemowork.lol.Damage.*;
import static teemowork.lol.SkillCost.*;

import org.junit.Test;

/**
 * @version 2013/01/27 20:34:23
 */
public class SkillDescriptorTest {

    @Test
    public void skill() throws Exception {
        SkillDescriptor skill = Skill.AbsoluteZero.createDescriptor(Version.P1154);

        skill.range(500);
        skill.cooldown(1.5);
        skill.cost(Mana, 16, 22, 28, 34, 40);
        skill.damage(Magic, 40, 60, 80, 100, 120);
        skill.description("Evelynn fires a line of spikes through a nearby enemy, dealing magic damage to all enemy units in its path.");
    }

    @Test
    public void name() throws Exception {
        SkillDescriptor skill = new SkillDescriptor("name");
        assert skill.name.equals("name");
    }

    @Test
    public void version() throws Exception {
        SkillDescriptor skill = new SkillDescriptor("name");

    }
}
