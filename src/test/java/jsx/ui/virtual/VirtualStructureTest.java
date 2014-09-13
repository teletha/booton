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
        VirtualStructure root〡 = new VirtualStructure();
        root〡.asis.〡("text");

        VirtualElement root = root〡.getRoot();
        assert root.children.items.length() == 1;
        assertAsText(root.children.items.get(0), "text");
    }

    @Test
    public void texts() throws Exception {
        VirtualStructure root〡 = new VirtualStructure();
        root〡.asis.〡("first", "second");

        VirtualElement root = root〡.getRoot();
        assert root.children.items.length() == 2;
        assertAsText(root.children.items.get(0), "first");
        assertAsText(root.children.items.get(1), "second");
    }

    @Test
    public void textSequencialCall() throws Exception {
        VirtualStructure root〡 = new VirtualStructure();
        root〡.asis.〡("first");
        root〡.asis.〡("second");

        VirtualElement root = root〡.getRoot();
        assert root.children.items.length() == 2;
        assertAsText(root.children.items.get(0), "first");
        assertAsText(root.children.items.get(1), "second");
    }

    @Test
    public void widgetText() throws Exception {
        VirtualStructure root〡 = new VirtualStructure();
        root〡.asis.〡(widget(sub〡 -> {
            sub〡.asis.〡("widget text");
        }));

        VirtualElement root = root〡.getRoot();
        assert root.children.items.length() == 1;
        assertAsText(root.children.items.get(0), "widget text");
    }

    @Test
    public void boxText() throws Exception {
        VirtualStructure root〡 = new VirtualStructure();
        root〡.hbox.〡("text");

        VirtualElement root = root〡.getRoot();
        assert root.children.items.length() == 1;
        assertAsElement(root.children.items.get(0), "hbox", e -> {
            assertAsText(e.children.items.get(0), "text");
        });
    }

    @Test
    public void boxTextSequentialCall() throws Exception {
        VirtualStructure root〡 = new VirtualStructure();
        root〡.hbox.〡("first");
        root〡.hbox.〡("second");

        VirtualElement root = root〡.getRoot();
        assert root.children.items.length() == 2;
        assertAsElement(root.children.items.get(0), "hbox", e -> {
            assertAsText(e.children.items.get(0), "first");
        });
        assertAsElement(root.children.items.get(1), "hbox", e -> {
            assertAsText(e.children.items.get(0), "second");
        });
    }

    @Test
    public void boxTextNestedCall() throws Exception {
        VirtualStructure root〡 = new VirtualStructure();
        root〡.hbox.〡(widget(sub〡 -> {
            sub〡.hbox.〡("nested text");
        }));

        VirtualElement root = root〡.getRoot();
        assert root.children.items.length() == 1;
        assertAsElement(root.children.items.get(0), "hbox", e -> {
            assertAsElement(e.children.items.get(0), "hbox", text -> {
                assertAsText(text.children.items.get(0), "nested text");
            });
        });
    }

    /**
     * <p>
     * Assertion helper for {@link VirtualElement}.
     * </p>
     * 
     * @param node
     * @param name
     * @param child
     */
    private void assertAsElement(VirtualNode node, String name, Consumer<VirtualElement> child) {
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
    private static Widget widget(Consumer<VirtualStructure> dsl) {
        return new WidgetDelegator(dsl);
    }

    /**
     * @version 2014/09/13 2:07:14
     */
    private static class WidgetDelegator extends Widget {

        private final Consumer<VirtualStructure> delegator;

        /**
         * @param delegator
         */
        private WidgetDelegator(Consumer<VirtualStructure> delegator) {
            this.delegator = delegator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize(VirtualStructure $〡) {
            delegator.accept($〡);
        }
    }

}
