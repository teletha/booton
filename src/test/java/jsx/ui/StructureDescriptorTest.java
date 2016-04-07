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

import static jsx.ui.StructureDescriptor.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;
import jsx.style.StyleDescriptor;

/**
 * @version 2015/10/04 23:56:49
 */
@RunWith(ScriptRunner.class)
public class StructureDescriptorTest extends DiffTestBase {

    @Test
    public void textContents() throws Exception {
        VirtualWidget root = make(() -> {
            text("test");
        });

        assert root.items.length() == 1;
        assertAsText(root.items.get(0), "test");
    }

    @Test
    public void textSequencialCall() throws Exception {
        VirtualWidget root = make(() -> {
            text("first");
            text("second");
        });

        assert root.items.length() == 2;
        assertAsText(root.items.get(0), "first");
        assertAsText(root.items.get(1), "second");
    }

    @Test
    public void widgetText() throws Exception {
        VirtualWidget root = make(() -> {
            widget(make(Sub1.class, () -> {
                text("widget text");
            }));
        });

        assert root.items.length() == 1;
        assertAsElement(root, 0, "widget", c -> {
            assertAsText(c.items.get(0), "widget text");
        });
    }

    @Test
    public void boxText() throws Exception {
        VirtualWidget root = make(() -> {
            box(style, contents("text", "contents"));
        });

        assert root.items.length() == 1;
        assertAsElement(root, 0, "span", e -> {
            assertAsText(e.items.get(0), "text");
            assertAsText(e.items.get(1), "contents");
        });
    }

    @Test
    public void boxTextSequentialCall() throws Exception {
        VirtualWidget root = make(() -> {
            box(style, contents("first"));
            box(style, contents("second"));
        });

        assert root.items.length() == 2;
        assertAsElement(root, 0, "span", e -> {
            assertAsText(e.items.get(0), "first");
        });
        assertAsElement(root, 1, "span", e -> {
            assertAsText(e.items.get(0), "second");
        });
    }

    @Test
    public void boxTextNestedCall() throws Exception {
        VirtualWidget root = make(() -> {
            box(style, () -> {
                box(style, contents("nested text"));
            });
        });

        assert root.items.length() == 1;
        assertAsElement(root, 0, "span", e -> {
            assertAsElement(e, 0, "span", text -> {
                assertAsText(text.items.get(0), "nested text");
            });
        });
    }

    @Test
    public void boxWidgetText() throws Exception {
        VirtualWidget root = make(() -> {
            widget(make(Sub1.class, () -> {
                box(style, contents("nested text"));
            }));
        });

        assert root.items.length() == 1;
        assertAsElement(root, 0, "widget", e -> {
            assertAsElement(e, 0, "span", nest -> {
                assertAsText(nest.items.get(0), "nested text");
            });
        });
    }

    @Test
    public void group() throws Exception {
        List<String> items = Arrays.asList("first", "second", "third");

        VirtualWidget root = make(() -> {
            box(contents(SubString.class, items));
        });

        assert root.items.length() == 1;
        assertAsElement(root, 0, "span", e -> {
            assert e.items.length() == 3;
            assertAsElement(e, 0, "widget", text -> {
                assertAsText(text.items.get(0), "first");
            });
            assertAsElement(e, 1, "widget", text -> {
                assertAsText(text.items.get(0), "second");
            });
            assertAsElement(e, 2, "widget", text -> {
                assertAsText(text.items.get(0), "third");
            });
        });
    }

    @Test
    public void range() throws Exception {
        VirtualWidget root = make(() -> {
            box(contents(0, 3, i -> {
                text(style, "text" + i);
            }));
        });

        assert root.items.length() == 1;
        assertAsElement(root, 0, "span", e -> {
            assert e.items.length() == 3;

            assertAsElement(e, 0, "span", child -> {
                assertAsText(child.items.get(0), "text0");
            });
            assertAsElement(e, 1, "span", child -> {
                assertAsText(child.items.get(0), "text1");
            });
            assertAsElement(e, 2, "span", child -> {
                assertAsText(child.items.get(0), "text2");
            });
        });
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
        int index = virtual.attributes.key(name);
        assert index != -1;
        assert virtual.attributes.value(index).equals(value);
    }

    /**
     * @version 2015/10/04 23:32:12
     */
    private static class Sub1 extends DSLWidget {
    }

    /**
     * @version 2015/10/04 23:50:43
     */
    private static class SubString extends Widget1<StyleDescriptor, String> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected void virtualize() {
            text(model1);
        }
    }
}
