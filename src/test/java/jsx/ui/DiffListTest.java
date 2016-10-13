/*
 * Copyright (C) 2016 Nameless Production Committee
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
import jsx.style.StyleDSL;

/**
 * @version 2016/09/26 16:34:09
 */
@RunWith(ScriptRunner.class)
public class DiffListTest extends DiffTestBase {

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
        VirtualWidget prev = bean(person);

        person.setName("Asagi");
        person.setAge(15);
        VirtualWidget next = bean(person);

        assertDiff(prev, next, 2);
    }

    /**
     * <p>
     * Create structure for single box list.
     * </p>
     * 
     * @param items A list items.
     * @return A created structure.
     */
    private <T> VirtualWidget single(List<String> items) {
        return make(() -> {
            box(style, contents(items, SingleBox::new));
        });
    }

    /**
     * @version 2015/10/05 0:48:29
     */
    private static class SingleBox extends Widget<StyleDSL> {

        private String text;

        /**
         * @param text
         */
        private SingleBox(String text) {
            super(text);

            this.text = text;
        }

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            {
                text(style, text);
            }
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
    private <T> VirtualWidget multi(List<String> items) {
        return make(() -> {
            box(style, contents(items, MultiBox::new));
        });
    }

    /**
     * @version 2015/10/05 0:50:19
     */
    private static class MultiBox extends Widget<StyleDSL> {

        private String text;

        /**
         * @param text
         */
        private MultiBox(String text) {
            super(text);

            this.text = text;
        }

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            {
                text(style, text + "1");
                text(style, text + "2");
            }
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
    private <T> VirtualWidget nest(List<String> items) {
        return make(() -> {
            box(style, contents(items, NestBox::new));
        });
    }

    /**
     * @version 2015/10/05 0:51:22
     */
    private static class NestBox extends Widget<StyleDSL> {

        private String text;

        /**
         * @param text
         */
        private NestBox(String text) {
            super(text);

            this.text = text;
        }

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            {
                List<String> items = Arrays.asList(text + "A", text + "B");

                box(style, contents(SingleBox.class, items));
                box(style, contents(SingleBox.class, items));
            }
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
    private <T> VirtualWidget bean(Person item) {
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
    private <T> VirtualWidget bean(List<Person> items) {
        return make(() -> {
            box(style, contents(items, PersonBox::new));
        });
    }

    /**
     * @version 2016/09/26 16:33:50
     */
    private static class PersonBox extends Widget<StyleDSL> {

        private Person person;

        /**
         * @param person
         */
        private PersonBox(Person person) {
            super(person);

            this.person = person;
        }

        /**
         * @version 2016/09/25 13:58:55
         */
        private class View extends StructureDSL {

            {
                text(style, person.getName(), " is ", person.getAge(), " years old.");
            }
        }
    }
}
