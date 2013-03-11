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

import static teemowork.model.Status.*;

import java.util.List;

import org.junit.Test;

import teemowork.model.variable.Variable;

/**
 * @version 2013/01/27 20:34:23
 */
public class SkillStatusTest {

    /** The empty skill. */
    private static final Skill empty = new EmptySkill();

    @Test
    public void GetAndSet() throws Exception {
        SkillStatus skill = new SkillStatus(null, null);
        assert skill.get(Range) == 0;

        skill.set(Range, 100);
        assert skill.get(Range) == 100;
    }

    @Test
    public void Delegate() throws Exception {
        SkillStatus previous = new SkillStatus(null, null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        SkillStatus skill = new SkillStatus(null, previous);
        assert skill.get(Range) == 100;
    }

    @Test
    public void Override() throws Exception {
        SkillStatus previous = new SkillStatus(null, null);
        previous.set(Range, 100);
        assert previous.get(Range) == 100;

        SkillStatus skill = new SkillStatus(null, previous);
        skill.set(Range, 200);
        assert skill.get(Range) == 200;
        assert previous.get(Range) == 100;
    }

    @Test
    public void description() throws Exception {
        SkillStatus skill = new SkillStatus(null, null);
        skill.active("Test");

        List tokens = skill.getActive();
        assert tokens.size() == 1;
        assert tokens.get(0).equals("Test");
    }

    @Test
    public void variable() throws Exception {
        SkillStatus skill = new SkillStatus(empty, null);
        skill.active("Test{1}");
        skill.variable(1, AD, 10, 10);

        List tokens = skill.getActive();
        assert tokens.size() == 2;
        assert tokens.get(0).equals("Test");

        Object token = tokens.get(1);
        assert token instanceof Variable;

        Variable variable = (Variable) token;
        assert variable.getStatus() == AD;
        assert variable.getAmplifiers().size() == 0;
    }

    @Test
    public void variable2() throws Exception {
        SkillStatus skill = new SkillStatus(empty, null);
        skill.active("Test{1}");
        skill.variable(1, SV, 10, 10);

        List tokens = skill.getActive();
        assert tokens.size() == 2;
        assert tokens.get(0).equals("Test");

        Object token = tokens.get(1);
        assert token instanceof Variable;

        Variable variable = (Variable) token;
        assert variable.getStatus() == SV;
        assert variable.getAmplifiers().size() == 0;
    }

    /**
     * @version 2013/02/17 12:38:49
     */
    private static class EmptySkill extends Skill {

        /**
         * 
         */
        private EmptySkill() {
            super("Test Skill", SkillKey.Q);

            update();
        }

        /**
         * 
         */
        private EmptySkill(SkillKey key) {
            super("Test Skill", key);
        }
    }
}
