/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.virtual;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.sample.Person;
import booton.soeur.ScriptRunner;

/**
 * @version 2014/09/13 14:10:28
 */
@RunWith(ScriptRunner.class)
public class VirtualStructureListDiffTest extends DiffTestBase {

    @Test
    public void add() {
        List<String> prev = Arrays.asList("1", "2");
        List<String> next = Arrays.asList("0", "1", "2", "3", "4");

        assertDiff(single(prev), single(next), 3);
    }

    @Test
    public void addMultiBox() {
        List<String> prev = Arrays.asList("1", "2");
        List<String> next = Arrays.asList("A", "1", "B", "2", "C");

        assertDiff(multi(prev), multi(next), 6);
    }

    @Test
    public void addNestBox() {
        List<String> prev = Arrays.asList("1", "2", "3");
        List<String> next = Arrays.asList("A", "1", "B", "2");

        assertDiff(nest(prev), nest(next), 6);
    }

    @Test
    public void changeBeanProperty() {
        Person person = new Person();

        person.setName("Yukina");
        person.setAge(14);
        StructureDSL prev = bean(person);

        person.setName("Asagi");
        person.setAge(15);
        StructureDSL next = bean(person);

        assertDiff(prev, next, 2);
    }

    @Test
    public void changeBeanObject() {
        Person person = new Person();
        person.setName("Yukina");
        person.setAge(14);
        StructureDSL prev = bean(person);

        person = new Person();
        person.setName("Asagi");
        person.setAge(15);
        StructureDSL next = bean(person);

        assertDiff(prev, next, 1);
    }

    /**
     * <p>
     * Create structure for single box list.
     * </p>
     * 
     * @param items A list items.
     * @return A created structure.
     */
    private <T> StructureDSL single(List<String> items) {
        StructureDSL $〡 = new StructureDSL();
        $〡.hbox.〡(SingleBox.class, items);

        return $〡;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class SingleBox extends Widget<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(StructureDSL $〡) {
            $〡.hbox.〡(model);
        }
    }

    /**
     * <p>
     * Create structure for multi box list.
     * </p>
     * 
     * @param items A list items.
     * @return A created structure.
     */
    private <T> StructureDSL multi(List<String> items) {
        StructureDSL $〡 = new StructureDSL();
        $〡.hbox.〡(MultiBox.class, items);

        return $〡;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class MultiBox extends Widget<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(StructureDSL $〡) {
            $〡.hbox.〡(model + "1");
            $〡.hbox.〡(model + "2");
        }
    }

    /**
     * <p>
     * Create structure for nest box list.
     * </p>
     * 
     * @param items A list items.
     * @return A created structure.
     */
    private <T> StructureDSL nest(List<String> items) {
        StructureDSL $〡 = new StructureDSL();
        $〡.hbox.〡(NestBox.class, items);

        return $〡;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class NestBox extends Widget<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(StructureDSL $〡) {
            List<String> items = Arrays.asList(model + "A", model + "B");

            $〡.hbox.〡(SingleBox.class, items);
            $〡.vbox.〡(SingleBox.class, items);
        }
    }

    /**
     * <p>
     * Create structure for bean box list.
     * </p>
     * 
     * @param item A bean item.
     * @return A created structure.
     */
    private <T> StructureDSL bean(Person item) {
        return bean(Arrays.asList(item));
    }

    /**
     * <p>
     * Create structure for bean box list.
     * </p>
     * 
     * @param items A list items.
     * @return A created structure.
     */
    private <T> StructureDSL bean(List<Person> items) {
        StructureDSL $〡 = new StructureDSL();
        $〡.hbox.〡(PersonBox.class, items);

        return $〡;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class PersonBox extends Widget<Person> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(StructureDSL $〡) {
            $〡.hbox.〡(model.getName(), " is ", model.getAge(), " years old.");
        }
    }
}
