/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt.property;

/**
 * @version 2014/01/20 11:18:17
 */
public class VoiceActor {

    /** The actor name. */
    private String name;

    /** The actor age. */
    private int age;

    /**
     * Get the name property of this {@link VoiceActor}.
     * 
     * @return The name property.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name property of this {@link VoiceActor}.
     * 
     * @param name The name value to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the age property of this {@link VoiceActor}.
     * 
     * @return The age property.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age property of this {@link VoiceActor}.
     * 
     * @param age The age value to set.
     */
    public void setAge(int age) {
        this.age = age;
    }
}
