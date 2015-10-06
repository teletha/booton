/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

import static js.lang.Global.*;

import java.util.HashSet;
import java.util.Set;

import booton.translator.JavascriptAPIProvider;
import booton.translator.JavascriptNative;
import booton.translator.JavascriptNativeProperty;
import js.lang.NativeCSSRuleList;
import jsx.style.StyleRule;
import jsx.style.value.AnimationFrames;
import jsx.style.value.Font;
import jsx.ui.Style;
import jsx.ui.WidgetLog;

/**
 * @version 2015/09/29 2:18:08
 */
@JavascriptAPIProvider(targetJavaScriptClassName = "CSSStyleSheet")
public class CSSStyleSheet implements JavascriptNative {

    /** The base stylesheet. */
    private static final CSSStyleSheet base = document.styleSheets().item(1);

    /** The style manager. */
    private static final Set<Style> styles = new HashSet();

    /** The fonts manager. */
    private static final Set<Font> fonts = new HashSet();

    /** The animations manager. */
    private static final Set<AnimationFrames> animations = new HashSet();

    /**
     * <p>
     * The list of all CSS rules contained within the style sheet. This includes both rule sets and
     * at-rules.
     * </p>
     */
    @JavascriptNativeProperty
    public NativeCSSRuleList cssRules;

    /**
     * <p>
     * Define the specified {@link AnimationFrames}.
     * </p>
     * 
     * @param animationFrame A target animationFrame to define.
     */
    public static void define(AnimationFrames animation) {
        if (animation != null && animations.add(animation)) {
            WidgetLog.DefineStyle.start();
            System.out.println(animation.toString());
            base.insertRule(animation.toString(), base.cssRules.length());
            WidgetLog.DefineStyle.stop();
        }
    }

    /**
     * <p>
     * Define the specified {@link Font}.
     * </p>
     * 
     * @param font A target font to define.
     */
    public static void define(Font font) {
        if (font != null && fonts.add(font)) {
            WidgetLog.DefineFont.start();
            // @import rule must be inserted before all other rules except for @charset rule.
            base.insertRule("@import url(" + font.uri + ");", 0);
            WidgetLog.DefineFont.stop();
        }
    }

    /**
     * <p>
     * Define the specified {@link Style}.
     * </p>
     * 
     * @param style A target style to define.
     */
    public static void define(Style style) {
        if (style != null && styles.add(style)) {
            WidgetLog.DefineStyle.start();
            define(StyleRule.create("$", style));
            WidgetLog.DefineStyle.stop();
        }
    }

    /**
     * <p>
     * Define the specified {@link StyleRule}.
     * </p>
     * 
     * @param rule A target style rule to define.
     */
    private static void define(StyleRule rule) {
        base.insertRule(rule.toString(), base.cssRules.length());

        for (int i = 0; i < rule.children.length(); i++) {
            define(rule.children.get(i));
        }
    }

    /**
     * <p>
     * Inserts a new style rule into the current style sheet.
     * </p>
     * <p>
     * For rule sets this contains both the selector and the style declaration. For at-rules, this
     * specifies both the at-identifier and the rule content. If several rules are given in the
     * DOMString in parameter a DOMException with the code SYNTAX_ERR is thrown.
     * </p>
     * 
     * @param rule A rule to be inserted (selector and declaration).
     * @param index A position to be inserted.
     */
    public native void insertRule(String rule, int index);

    /**
     * <p>
     * Removes a style rule from the current style sheet object.
     * </p>
     * 
     * @param index A position of the rule.
     */
    public native void deleteRule(int index);
}
