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

/**
 * @version 2013/02/06 13:53:39
 */
public class SkillVariable extends SkillAmplifier {

    /** The variable id. */
    public final int id;

    /** The conditional variable flag. */
    public boolean isConditional = false;

    /**
     * @param id
     */
    SkillVariable(int id) {
        this.id = id;
    }
}
