/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2009/04/12 16:26:19
 */
public class Person {

    private int age;

    private String name;

    private List<Person> friends = new ArrayList();

    /**
     * Get the age property of this {@link Person}.
     * 
     * @return The age prperty.
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

    /**
     * Get the name property of this {@link Person}.
     * 
     * @return The name prperty.
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
     * Get the friends property of this {@link Person}.
     * 
     * @return The friends property.
     */
    public List<Person> getFriends() {
        return friends;
    }

    /**
     * Set the friends property of this {@link Person}.
     * 
     * @param friends The friends value to set.
     */
    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
}
