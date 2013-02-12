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

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/02/06 13:53:39
 */
public class SkillVariable {

    /** The variable id. */
    final int id;

    /** The variable type. */
    public Status status;

    /** The value enumerator. */
    public SkillVariableResolver resolver;

    /** The amplifier types. */
    public final List<SkillAmplifier> amplifiers = new ArrayList();

    /**
     * @param id
     */
    SkillVariable(int id) {
        this.id = id;
    }
}
