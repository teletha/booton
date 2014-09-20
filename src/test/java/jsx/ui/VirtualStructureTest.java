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

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2014/09/11 14:57:41
 */
@RunWith(ScriptRunner.class)
public class VirtualStructureTest {

    @Test
    public void text() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.asis.〡("text");

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 1;
        assertAsText(root.items.get(0), "text");
    }

    @Test
    public void texts() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.asis.〡("first", "second");

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 2;
        assertAsText(root.items.get(0), "first");
        assertAsText(root.items.get(1), "second");
    }

    @Test
    public void textSequencialCall() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.asis.〡("first");
        root〡.asis.〡("second");

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 2;
        assertAsText(root.items.get(0), "first");
        assertAsText(root.items.get(1), "second");
    }

    @Test
    public void widgetText() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.asis.〡(widget(sub〡 -> {
            sub〡.asis.〡("widget text");
        }));

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 1;
        assertAsText(root.items.get(0), "widget text");
    }

    @Test
    public void boxText() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.hbox.〡("text");

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "hbox", e -> {
            assertAsText(e.items.get(0), "text");
        });
    }

    @Test
    public void boxTextSequentialCall() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.hbox.〡("first");
        root〡.hbox.〡("second");

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 2;
        assertAsElement(root, 0, "hbox", e -> {
            assertAsText(e.items.get(0), "first");
        });
        assertAsElement(root, 1, "hbox", e -> {
            assertAsText(e.items.get(0), "second");
        });
    }

    @Test
    public void boxTextNestedCall() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.hbox.〡(() -> {
            root〡.hbox.〡("nested text");
        });

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "hbox", e -> {
            assertAsElement(e, 0, "hbox", text -> {
                assertAsText(text.items.get(0), "nested text");
            });
        });
    }

    @Test
    public void boxWidgetText() throws Exception {
        StructureDSL root〡 = new StructureDSL();
        root〡.hbox.〡(widget(sub〡 -> {
            sub〡.hbox.〡("nested text");
        }));

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "hbox", e -> {
            assertAsElement(e, 0, "hbox", text -> {
                assertAsText(text.items.get(0), "nested text");
            });
        });
    }

    @Test
    public void group() throws Exception {
        List<String> items = Arrays.asList("first", "second", "third");

        StructureDSL root〡 = new StructureDSL();
        root〡.hbox.〡(StringWidget.class, items);

        VirtualElement root = root〡.getRoot();
        assert root.items.length() == 1;
        assertAsElement(root, 0, "hbox", e -> {
            assert e.items.length() == 3;
            assertAsElement(e, 0, "hbox", text -> {
                assertAsText(text.items.get(0), "first");
            });
            assertAsElement(e, 1, "hbox", text -> {
                assertAsText(text.items.get(0), "second");
            });
            assertAsElement(e, 2, "hbox", text -> {
                assertAsText(text.items.get(0), "third");
            });
        });
    }

    /**
     * @version 2014/09/13 12:18:58
     */
    private static class StringWidget extends UI<String> {

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
     * Helper method to create widget.
     * </p>
     * 
     * @param dsl
     * @return
     */
    private static UI widget(Consumer<StructureDSL> dsl) {
        return new WidgetDelegator(dsl);
    }

    /**
     * @version 2014/09/13 2:07:14
     */
    private static class WidgetDelegator extends UI {

        private final Consumer<StructureDSL> delegator;

        /**
         * @param delegator
         */
        private WidgetDelegator(Consumer<StructureDSL> delegator) {
            this.delegator = delegator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(StructureDSL $〡) {
            delegator.accept($〡);
        }
    }
}
