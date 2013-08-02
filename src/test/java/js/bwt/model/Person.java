/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.bwt.model;

/**
 * @version 2013/08/02 9:10:14
 */
public class Person {

    private String name;

    private int age;

    /**
     * Get the name property of this {@link Person}.
     * 
     * @return The name property.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name property of this {@link Person}.
     * 
     * @param name The name value to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the age property of this {@link Person}.
     * 
     * @return The age property.
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the age property of this {@link Person}.
     * 
     * @param age The age value to set.
     */
    public void setAge(int age) {
        this.age = age;
    }
}