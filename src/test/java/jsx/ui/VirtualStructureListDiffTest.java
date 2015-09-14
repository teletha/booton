/*
 * Copyright (C) 2015 Nameless Production Committee
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
import org.junit.runner.RunWith;

import booton.sample.Person;
import booton.soeur.ScriptRunner;
import jsx.style.Style;

/**
 * @version 2014/09/13 14:10:28
 */
@RunWith(ScriptRunner.class)
public class VirtualStructureListDiffTest extends DiffTestBase {

    /** Empty style. */
    private static final Style style = () -> {
    };

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
        VirtualStructure prev = bean(person);

        person.setName("Asagi");
        person.setAge(15);
        VirtualStructure next = bean(person);

        assertDiff(prev, next, 2);
    }

    @Test
    public void changeBeanObject() {
        Person person = new Person();
        person.setName("Yukina");
        person.setAge(14);
        VirtualStructure prev = bean(person);

        person = new Person();
        person.setName("Asagi");
        person.setAge(15);
        VirtualStructure next = bean(person);

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
    private <T> VirtualStructure single(List<String> items) {
        VirtualStructure $〡 = new VirtualStructure();
        $〡.nbox.〡(style, SingleBox.class, items);

        return $〡;
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
            $〡.nbox.〡(style, model1);
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
    private <T> VirtualStructure multi(List<String> items) {
        VirtualStructure $〡 = new VirtualStructure();
        $〡.nbox.〡(style, MultiBox.class, items);

        return $〡;
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
            $〡.nbox.〡(style, model1 + "1");
            $〡.nbox.〡(style, model1 + "2");
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
    private <T> VirtualStructure nest(List<String> items) {
        VirtualStructure $〡 = new VirtualStructure();
        $〡.nbox.〡(style, NestBox.class, items);

        return $〡;
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

            $〡.nbox.〡(style, SingleBox.class, items);
            $〡.nbox.〡(style, SingleBox.class, items);
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
    private <T> VirtualStructure bean(Person item) {
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
    private <T> VirtualStructure bean(List<Person> items) {
        VirtualStructure $〡 = new VirtualStructure();
        $〡.nbox.〡(style, PersonBox.class, items);

        return $〡;
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
            $〡.nbox.〡(style, model1.getName(), " is ", model1.getAge(), " years old.");
        }
    }
}
