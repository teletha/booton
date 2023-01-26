/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.sample.Person;
import booton.soeur.ScriptRunner;

/**
 * @version 2013/10/02 9:48:35
 */
@RunWith(ScriptRunner.class)
public class KissTest {

    @Test
    public void make() throws Exception {
        Person person = I.make(Person.class);
        person.setAge(10);

        assert person.getAge() == 10;
    }

    @Test
    public void prototype() throws Exception {
        PrototypeClass object1 = I.make(PrototypeClass.class);
        PrototypeClass object2 = I.make(PrototypeClass.class);

        assert object1 != object2;
    }

    @Test
    public void singleton() throws Exception {
        SingletonClass object1 = I.make(SingletonClass.class);
        SingletonClass object2 = I.make(SingletonClass.class);

        assert object1 == object2;
    }

    @Test
    public void constructorInjetion() throws Exception {
        Injector injector = I.make(Injector.class);

        assert injector.singleton == I.make(SingletonClass.class);
    }

    @Test
    public void lifestyleInjection() throws Exception {
        LifestyleInjector injector = I.make(LifestyleInjector.class);

        assert injector.singleton.get() == I.make(SingletonClass.class);
    }

    /**
     * @version 2013/09/25 19:16:21
     */
    private static class PrototypeClass {
    }

    /**
     * @version 2013/09/25 19:16:21
     */
    @Managed(Singleton.class)
    private static class SingletonClass {
    }

    /**
     * @version 2013/09/25 20:47:13
     */
    private static class Injector {

        private SingletonClass singleton;

        /**
         * @param singleton
         */
        private Injector(SingletonClass singleton) {
            this.singleton = singleton;
        }
    }

    /**
     * @version 2013/09/25 20:47:13
     */
    private static class LifestyleInjector {

        private Lifestyle<SingletonClass> singleton;

        /**
         * @param singleton
         */
        private LifestyleInjector(Lifestyle<SingletonClass> singleton) {
            this.singleton = singleton;
        }
    }
}
