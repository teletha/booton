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
import java.util.function.Consumer;

import jsx.style.Style;

import org.junit.Test;

/**
 * @version 2014/09/11 14:57:41
 */
// @RunWith(ScriptRunner.class)
public class VirtualStructure2Test {

    private static final Style style = () -> {
    };

    @Test
    public void text() throws Exception {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e("text");

        VirtualElement root = $.getRoot();
        assert root.items.length() == 1;
        assertAsText(root.items.get(0), "text");
    }

    @Test
    public void textSequencialCall() throws Exception {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e("first");
        $.e("second");

        VirtualElement root = $.getRoot();
        assert root.items.length() == 2;
        assertAsText(root.items.get(0), "first");
        assertAsText(root.items.get(1), "second");
    }

    @Test
    public void widgetText() throws Exception {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(widget($$ -> {
            $$.e(style, "widget text");
        }));

        VirtualElement root = $.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "div", c -> {
            assertAsText(c.items.get(0), "widget text");
        });
    }

    @Test
    public void boxText() throws Exception {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(style, "text");

        VirtualElement root = $.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "div", e -> {
            assertAsText(e.items.get(0), "text");
        });
    }

    @Test
    public void boxTextSequentialCall() throws Exception {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(style, "first");
        $.e(style, "second");

        VirtualElement root = $.getRoot();
        assert root.items.length() == 2;
        assertAsElement(root, 0, "div", e -> {
            assertAsText(e.items.get(0), "first");
        });
        assertAsElement(root, 1, "div", e -> {
            assertAsText(e.items.get(0), "second");
        });
    }

    @Test
    public void boxTextNestedCall() throws Exception {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(style, () -> {
            $.e(style, "nested text");
        });

        VirtualElement root = $.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "div", e -> {
            assertAsElement(e, 0, "div", text -> {
                assertAsText(text.items.get(0), "nested text");
            });
        });
    }

    @Test
    public void boxWidgetText() throws Exception {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(style, widget($$ -> {
            $$.e(style, "nested text");
        }));

        VirtualElement root = $.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "div", e -> {
            assertAsElement(e, 0, "div", w -> {
                assertAsText(w.items.get(0), "nested text");
            });
        });
    }

    @Test
    public void group() throws Exception {
        List<String> items = Arrays.asList("first", "second", "third");

        VirtualStructure2 $ = new VirtualStructure2();
        $.e(style, StringWidget.class, items);

        VirtualElement root = $.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "div", e -> {
            assert e.items.length() == 3;
            assertAsElement(e, 0, "div", text -> {
                assertAsText(text.items.get(0), "first");
            });
            assertAsElement(e, 1, "div", text -> {
                assertAsText(text.items.get(0), "second");
            });
            assertAsElement(e, 2, "div", text -> {
                assertAsText(text.items.get(0), "third");
            });
        });
    }

    @Test
    public void loop() {
        VirtualStructure2 $ = new VirtualStructure2();
        $.e(style, () -> {
            for (int i = 0; i < 3; i++) {
                $.e(style, "text" + i);
            }
        });

        VirtualElement root = $.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "div", e -> {
            assert e.items.length() == 3;

            assertAsElement(e, 0, "div", child -> {
                assertAsText(child.items.get(0), "text0");
            });
            assertAsElement(e, 1, "div", child -> {
                assertAsText(child.items.get(0), "text1");
            });
            assertAsElement(e, 2, "div", child -> {
                assertAsText(child.items.get(0), "text2");
            });
        });
    }

    /**
     * @version 2014/09/13 12:18:58
     */
    private static class StringWidget extends Widget1<String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            $〡.asis.〡(model1);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure2 $) {
            $.e(style, model1);
        }
    }

    /**
     * <p>
     * Assertion helper for {@link VirtualElement}.
     * </p>
     * 
     * @param e
     * @param index
     * @param name
     * @param child
     */
    private void assertAsElement(VirtualElement e, int index, String name, Consumer<VirtualElement> child) {
        VirtualNode node = e.items.get(index);
        assert node instanceof VirtualElement;

        VirtualElement virtual = (VirtualElement) node;
        assert virtual.name.equals(name);
        child.accept(virtual);
    }

    /**
     * <p>
     * Assertion helper for {@link VirtualText}.
     * </p>
     * 
     * @param node
     * @param expectedText
     */
    private void assertAsText(VirtualNode node, String expectedText) {
        assert node instanceof VirtualText;

        VirtualText virtual = (VirtualText) node;
        assert virtual.text.equals(expectedText);
    }

    /**
     * <p>
     * Assertion helper for {@link VirtualElement}.
     * </p>
     * 
     * @param node
     * @param name
     * @param value
     */
    private void assertAttribute(VirtualNode node, String name, String value) {
        assert node instanceof VirtualElement;

        VirtualElement virtual = (VirtualElement) node;
        int index = virtual.attributes.names.indexOf(name);
        assert index != -1;
        assert virtual.attributes.values.get(index).equals(value);
    }

    /**
     * <p>
     * Helper method to create widget.
     * </p>
     * 
     * @param dsl
     * @return
     */
    private static Widget widget(Consumer<VirtualStructure2> dsl) {
        return new WidgetDelegator(dsl);
    }

    /**
     * @version 2014/09/13 2:07:14
     */
    private static class WidgetDelegator extends Widget {

        private final Consumer<VirtualStructure2> delegator;

        /**
         * @param delegator
         */
        private WidgetDelegator(Consumer<VirtualStructure2> delegator) {
            this.delegator = delegator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure2 $$) {
            delegator.accept($$);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error();
        }
    }
}
