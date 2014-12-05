/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import booton.sample.Person;

/**
 * @version 2014/09/13 14:10:28
 */
// @RunWith(ScriptRunner.class)
public class VirtualStructureListDiffTest extends DiffTestBase2 {

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

        assertDiff(multi(prev), multi(next), 3);
    }

    @Test
    public void addNestBox() {
        List<String> prev = Arrays.asList("1", "2", "3");
        List<String> next = Arrays.asList("A", "1", "B", "2");

        assertDiff(nest(prev), nest(next), 3);
    }

    @Test
    public void changeBeanProperty() {
        Person person = new Person();

        person.setName("Yukina");
        person.setAge(14);
        VirtualStructure2 prev = bean(person);

        person.setName("Asagi");
        person.setAge(15);
        VirtualStructure2 next = bean(person);

        assertDiff(prev, next, 2);
    }

    @Test
    public void changeBeanObject() {
        Person person = new Person();
        person.setName("Yukina");
        person.setAge(14);
        VirtualStructure2 prev = bean(person);

        person = new Person();
        person.setName("Asagi");
        person.setAge(15);
        VirtualStructure2 next = bean(person);

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
    private <T> VirtualStructure2 single(List<String> items) {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(VirtualStructureStyle.HBOX, SingleBox.class, items);

        return $;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class SingleBox extends Widget1<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.hbox.〡(model1);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure2 $) {
            $.e(VirtualStructureStyle.HBOX, model1);
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
    private <T> VirtualStructure2 multi(List<String> items) {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(VirtualStructureStyle.HBOX, MultiBox.class, items);

        return $;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class MultiBox extends Widget1<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.hbox.〡(model1 + "1");
            $〡.hbox.〡(model1 + "2");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure2 $) {
            $.e(VirtualStructureStyle.HBOX, model1 + "1");
            $.e(VirtualStructureStyle.HBOX, model1 + "2");
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
    private <T> VirtualStructure2 nest(List<String> items) {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(VirtualStructureStyle.HBOX, NestBox.class, items);

        return $;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class NestBox extends Widget1<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            List<String> items = Arrays.asList(model1 + "A", model1 + "B");

            $〡.hbox.〡(SingleBox.class, items);
            $〡.vbox.〡(SingleBox.class, items);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure2 $) {
            List<String> items = Arrays.asList(model1 + "A", model1 + "B");

            $.e(VirtualStructureStyle.HBOX, SingleBox.class, items);
            $.e(VirtualStructureStyle.VBOX, SingleBox.class, items);
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
    private <T> VirtualStructure2 bean(Person item) {
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
    private <T> VirtualStructure2 bean(List<Person> items) {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(VirtualStructureStyle.HBOX, PersonBox.class, items);

        return $;
    }

    /**
     * @version 2014/09/13 14:11:31
     */
    private static class PersonBox extends Widget1<Person> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.hbox.〡(model1.getName(), " is ", model1.getAge(), " years old.");
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure2 $) {
            $.e(VirtualStructureStyle.HBOX, model1.getName(), " is ", model1.getAge(), " years old.");
        }
    }
}
