/*
 * Copyright (C) 2009 Nameless Production Committee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package booton;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import kiss.Extensible;
import kiss.I;
import booton.css.Alignment;
import booton.css.BackgroundRepeat;
import booton.css.Color;
import booton.css.Display;
import booton.css.Height;
import booton.css.HorizontalAlignment;
import booton.css.TextDecoration;
import booton.css.TextTransform;
import booton.css.Unit;
import booton.css.Units;
import booton.css.WhiteSpace;
import booton.css.Width;
import booton.translator.Javascript;

/**
 * @version 2009/08/25 18:38:49
 */
public class CSS implements Extensible {

    /** The property holder. */
    private Map<String, Object> properties = new TreeMap();

    /**
     * <p>
     * The display CSS property specifies the type of rendering box used for an element. In HTML,
     * default display property values are taken from behaviors described in the HTML specifications
     * or from the browser/user default stylesheet. The default value in XML is inline.
     * </p>
     * <p>
     * In addition to the many different display box types, the value none lets you turn off the
     * display of an element; when you use none, all child elements also have their display turned
     * off. The document is rendered as though the element doesn't exist in the document tree.
     * </p>
     * 
     * @param display
     */
    protected final void set(Display display) {
        properties.put("display", display);
    }

    /**
     * <p>
     * The width CSS property specifies the width of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-width and max-width properties override width.
     * </p>
     * 
     * @param size
     * @param unit
     */
    protected final void setWidth(double size, Unit unit) {
        properties.put("width", compute(size, unit));
    }

    /**
     * <p>
     * The width CSS property specifies the width of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-width and max-width properties override width.
     * </p>
     * 
     * @param width
     */
    protected final void set(Width width) {
        properties.put("width", width);
    }

    protected Display display;

    /**
     * <p>
     * The height CSS property specifies the height of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-height and max-height properties override height.
     * </p>
     * 
     * @param size
     * @param unit
     */
    protected final void setHeight(double size, Unit unit) {
        properties.put("height", compute(size, unit));
    }

    /**
     * <p>
     * The height CSS property specifies the height of the content area of an element. The content
     * area is inside the padding, border, and margin of the element.
     * </p>
     * <p>
     * The min-height and max-height properties override height.
     * </p>
     * 
     * @param height
     */
    protected final void set(Height height) {
        properties.put("height", height);
    }

    /**
     * <p>
     * This property describes the foreground color of an element's text content.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final void color(int color) {
        color(new Color(color));
    }

    /**
     * <p>
     * This property describes the foreground color of an element's text content.
     * </p>
     * 
     * @param value
     * @return
     */

    protected final void color(Color color) {
        properties.put("color", color);
    }

    /**
     * <p>
     * This property sets the background color of an element, either a <color> value or the keyword
     * 'transparent', to make the underlying colors shine through.
     * </p>
     * 
     * @param color
     * @return
     */
    protected final void background_color(int color) {
        background_color(new Color(color));
    }

    /**
     * <p>
     * This property sets the background color of an element, either a <color> value or the keyword
     * 'transparent', to make the underlying colors shine through.
     * </p>
     * 
     * @param color
     * @return
     */
    protected final void background_color(Color color) {
        properties.put("background-color", color);
    }

    /**
     * <p>
     * This property sets the background image of an element. When setting a background image,
     * authors should also specify a background color that will be used when the image is
     * unavailable. When the image is available, it is rendered on top of the background color.
     * (Thus, the color is visible in the transparent parts of the image).
     * </p>
     * 
     * @param uri
     * @return
     */
    protected final void background_image(URI uri) {
        properties.put("background-image", "url(" + uri.toASCIIString() + ')');
    }

    /**
     * <p>
     * The tiling and positioning of the background-image on inline elements is undefined in this
     * specification. A future level of CSS may define the tiling and positioning of the
     * background-image on inline elements.
     * </p>
     * 
     * @param value
     * @return
     */
    protected final void background_repeat(BackgroundRepeat value) {
        properties.put("background-repeat", value);
    }

    /**
     * <p>
     * If a background image is specified, this property specifies whether it is fixed with regard
     * to the viewport ('fixed') or scrolls along with the containing block ('scroll').
     * </p>
     * 
     * @param value
     * @return
     */
    protected final void background_attachment(boolean fixed) {
        properties.put("background-attachment", fixed ? "fixed" : "scroll");
    }

    /**
     * <p>
     * If a background image has been specified, this property specifies its initial position. If
     * only one value is specified, the second value is assumed to be 'center'. If at least one
     * value is not a keyword, then the first value represents the horizontal position and the
     * second represents the vertical position. Negative <percentage> and <length> values are
     * allowed.
     * </p>
     * 
     * @param repeat
     * @return
     */
    protected final void background_position(double horizontal, Units unit) {
        properties.put("background-position", compute(horizontal, unit));
    }

    /**
     * <p>
     * If a background image has been specified, this property specifies its initial position. If
     * only one value is specified, the second value is assumed to be 'center'. If at least one
     * value is not a keyword, then the first value represents the horizontal position and the
     * second represents the vertical position. Negative <percentage> and <length> values are
     * allowed.
     * </p>
     * 
     * @param repeat
     * @return
     */
    protected final void background_position(double horizontal, Units horizontalUnit, double vertical, Units verticalUnit) {
        properties.put("background-position", compute(horizontal, horizontalUnit) + " " + compute(vertical, verticalUnit));
    }

    /**
     * <p>
     * The 'background' property is a shorthand property for setting the individual background
     * properties (i.e., 'background-color', 'background-image', 'background-repeat',
     * 'background-attachment' and 'background-position') at the same place in the style sheet.
     * </p>
     * 
     * @param image
     * @param repeat
     * @param attachment
     * @param horizontal
     * @param horizontalUnit
     * @param vertical
     * @param verticalUnit
     * @return
     */
    protected final void background(URI image, BackgroundRepeat repeat, double horizontal, Units horizontalUnit, double vertical, Units verticalUnit) {
        background(image, repeat, false, horizontal, horizontalUnit, vertical, verticalUnit);
    }

    /**
     * <p>
     * The 'background' property is a shorthand property for setting the individual background
     * properties (i.e., 'background-color', 'background-image', 'background-repeat',
     * 'background-attachment' and 'background-position') at the same place in the style sheet.
     * </p>
     * 
     * @param image
     * @param repeat
     * @param attachment
     * @param horizontal
     * @param horizontalUnit
     * @param vertical
     * @param verticalUnit
     * @return
     */
    protected final void background(URI image, BackgroundRepeat repeat, boolean fixed, double horizontal, Units horizontalUnit, double vertical, Units verticalUnit) {
        background(null, image, repeat, fixed, horizontal, horizontalUnit, vertical, verticalUnit);
    }

    /**
     * <p>
     * The 'background' property is a shorthand property for setting the individual background
     * properties (i.e., 'background-color', 'background-image', 'background-repeat',
     * 'background-attachment' and 'background-position') at the same place in the style sheet.
     * </p>
     * 
     * @param color
     * @param image
     * @param repeat
     * @param attachment
     * @param horizontal
     * @param horizontalUnit
     * @param vertical
     * @param verticalUnit
     * @return
     */
    protected final void background(Color color, URI image, BackgroundRepeat repeat, boolean fixed, double horizontal, Units horizontalUnit, double vertical, Units verticalUnit) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    protected final void margin(double size, Unit unit) {
        properties.put("margin", compute(size, unit));
    }

    protected final void margin(double top, Unit topUnit, double right, Unit rightUnit, double bottom, Unit bottomUnit, double left, Unit leftUnit) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <dl>
     * <dt>Value</dt>
     * <dd>&lt;length&gt; | &lt;percentage&gt; | inherit</dd>
     * <dt>Initial</dt>
     * <dd>0</dd>
     * <dt>Applies to</dt>
     * <dd>block-level elements, table cells and inline blocks</dd>
     * <dt>Inherited</dt>
     * <dd>yes</dd>
     * <dt>Percentages</dt>
     * <dd>refer to width of containing block</dd>
     * <dt>Media</dt>
     * <dd>visual</dd>
     * <dt>Computed value</dt>
     * <dd>the percentage as specified or the absolute length</dd>
     * </dl>
     * <p>
     * This property specifies the indentation of the first line of text in a block. More precisely,
     * it specifies the indentation of the first box that flows into the block's first line box. The
     * box is indented with respect to the left (or right, for right-to-left layout) edge of the
     * line box. User agents should render this indentation as blank space.
     * </p>
     * <p>
     * Values have the following meanings:
     * </p>
     * <dl>
     * <dt>&lt;length&gt;</dt>
     * <dd>The indentation is a fixed length.</dd>
     * <dt>&lt;percentage&gt;</dt>
     * <dd>The indentation is a percentage of the containing block width.</dd>
     * </dl>
     * <p>
     * The value of 'text-indent' may be negative, but there may be implementation-specific limits.
     * If the value of 'text-indent' is either negative or exceeds the width of the block, that
     * first box, described above, can overflow the block. The value of 'overflow' will affect
     * whether such text that overflows the block is visible.
     * </p>
     */
    protected final void text_indent(double size, Units unit) {
        properties.put("text-indet", compute(size, unit));
    }

    /**
     * This property describes how inline content of a block is aligned. Values have the following
     * meanings:
     */
    protected final void text_align(Alignment value) {
        properties.put("text-align", value);
    }

    /**
     * This property describes decorations that are added to the text of an element using the
     * element's color. When specified on an inline element, it affects all the boxes generated by
     * that element; for all other elements, the decorations are propagated to an anonymous inline
     * box that wraps all the in-flow inline children of the element, and to any block-level in-flow
     * descendants. It is not, however, further propagated to floating and absolutely positioned
     * descendants, nor to the contents of 'inline-table' and 'inline-block' descendants.
     */
    protected final void text_decoration(TextDecoration value) {
        properties.put("text-decoration", value);
    }

    /**
     * This property specifies spacing behavior between text characters. Values have the following
     * meanings:
     */
    protected final void letter_spacing(double size, Unit unit) {
        properties.put("letter-spacing", compute(size, unit));
    }

    /**
     * This property specifies spacing behavior between words. Values have the following meanings:
     */
    protected final void word_spacing(double size, Unit unit) {
        properties.put("word-spacing", compute(size, unit));
    }

    /**
     * Newlines in the source can be represented by a carriage return (U+000D), a linefeed (U+000A)
     * or both (U+000D U+000A) or by some other mechanism that identifies the beginning and end of
     * document segments, such as the SGML RECORD-START and RECORD-END tokens. The CSS 'white-space'
     * processing model assumes all newlines have been normalized to line feeds.
     */
    protected final void white_space(WhiteSpace value) {
        properties.put("white-space", value);
    }

    /**
     * <p>
     * The format of an RGB value in the functional notation is 'rgb(' followed by a comma-separated
     * list of three numerical values (either three integer values or three percentage values)
     * followed by ')'. The integer value 255 corresponds to 100%, and to F or FF in the hexadecimal
     * notation: rgb(255,255,255) = rgb(100%,100%,100%) = #FFF. White space characters are allowed
     * around the numerical values.
     * </p>
     * 
     * @param red
     * @param green
     * @param blue
     */
    protected final Color rgb(int red, int green, int blue) {
        return new Color(red, green, blue);
    }

    /** The color keyword. */
    protected final Color aqua = rgb(0, 255, 255);

    /** The color keyword. */
    protected final Color black = rgb(0, 0, 0);

    /** The color keyword. */
    protected final Color blue = rgb(0, 0, 255);

    /** The color keyword. */
    protected final Color fuchsia = rgb(255, 0, 255);

    /** The color keyword. */
    protected final Color gray = rgb(128, 128, 128);

    /** The color keyword. */
    protected final Color green = rgb(0, 128, 0);

    /** The color keyword. */
    protected final Color lime = rgb(0, 255, 0);

    /** The color keyword. */
    protected final Color maroon = rgb(128, 0, 0);

    /** The color keyword. */
    protected final Color navy = rgb(0, 0, 128);

    /** The color keyword. */
    protected final Color olive = rgb(128, 128, 0);

    /** The color keyword. */
    protected final Color orange = rgb(255, 165, 0);

    /** The color keyword. */
    protected final Color purple = rgb(128, 0, 128);

    /** The color keyword. */
    protected final Color red = rgb(255, 0, 0);

    /** The color keyword. */
    protected final Color silver = rgb(192, 192, 192);

    /** The color keyword. */
    protected final Color teal = rgb(0, 128, 128);

    /** The color keyword. */
    protected final Color white = rgb(255, 255, 255);

    /** The color keyword. */
    protected final Color yellow = rgb(255, 255, 0);

    /**
     * <p>
     * URI values (Uniform Resource Identifiers, see [RFC3986], which includes URLs, URNs, etc) in
     * this specification are denoted by <uri>. The functional notation used to designate URIs in
     * property values is "url()".
     * </p>
     * 
     * @param url
     * @return
     */
    protected final URI url(String url) {
        try {
            return new URI(url);
        } catch (URISyntaxException e) {
            throw I.quiet(e);
        }
    }

    /** The image is repeated both horizontally and vertically. */
    protected final BackgroundRepeat repeat = new BackgroundRepeat("repeat");

    /** The image is repeated horizontally only. */
    protected final BackgroundRepeat repeat_x = new BackgroundRepeat("repeat-x");

    /** The image is repeated vertically only. */
    protected final BackgroundRepeat repeat_y = new BackgroundRepeat("repeat-y");

    /** The image is not repeated: only one copy of the image is drawn. */
    protected final BackgroundRepeat no_repeat = new BackgroundRepeat("no-repeat");

    /** Equivalent to '0%' for the horizontal position. */
    protected final HorizontalAlignment left = new HorizontalAlignment("left");

    /** Equivalent to '50%' for the horizontal position. */
    protected final HorizontalAlignment center = new HorizontalAlignment("center");

    /** Equivalent to '100%' for the horizontal position. */
    protected final HorizontalAlignment right = new HorizontalAlignment("right");

    protected final Alignment justify = new Alignment("justify");

    /** Each line of text is underlined. */
    protected final TextDecoration underline = new TextDecoration("underline");

    /** Each line of text has a line above it. */
    protected final TextDecoration overline = new TextDecoration("overline");

    /** Each line of text has a line through the middle. */
    protected final TextDecoration line_through = new TextDecoration("line-through");

    /** Puts the first character of each word in uppercase; other characters are unaffected. */
    protected final TextTransform capitalize = new TextTransform("capitalize");

    /** Puts all characters of each word in uppercase. */
    protected final TextTransform uppercase = new TextTransform("uppercase");

    /** Puts all characters of each word in lowercase. */
    protected final TextTransform lowercase = new TextTransform("lowercase");

    /**
     * This value prevents user agents from collapsing sequences of white space. Lines are only
     * broken at newlines in the source, or at occurrences of "\A" in generated content.
     */
    protected final WhiteSpace pre = new WhiteSpace("pre");

    /** This value collapses white space as for 'normal', but suppresses line breaks within text. */
    protected final WhiteSpace nowarp = new WhiteSpace("nowarp");

    /**
     * This value prevents user agents from collapsing sequences of white space. Lines are broken at
     * newlines in the source, at occurrences of "\A" in generated content, and as necessary to fill
     * line boxes.
     */
    protected final WhiteSpace pre_warp = new WhiteSpace("pre-warp");

    /**
     * This value directs user agents to collapse sequences of white space. Lines are broken at
     * newlines in the source, at occurrences of "\A" in generated content, and as necessary to fill
     * line boxes.
     */
    protected final WhiteSpace pre_line = new WhiteSpace("pre-line");

    /**
     * <p>
     * The 'em' unit is equal to the computed value of the 'font-size' property of the element on
     * which it is used. The exception is when 'em' occurs in the value of the 'font-size' property
     * itself, in which case it refers to the font size of the parent element. It may be used for
     * vertical or horizontal measurement. (This unit is also sometimes called the quad-width in
     * typographic texts.)
     * </p>
     */
    protected final Unit em = new Unit("em");

    /**
     * <p>
     * The 'ex' unit is defined by the element's first available font. The 'x-height' is so called
     * because it is often equal to the height of the lowercase "x". However, an 'ex' is defined
     * even for fonts that don't contain an "x".
     * </p>
     */
    protected final Unit ex = new Unit("ex");

    /**
     * <p>
     * The x-height of a font can be found in different ways. Some fonts contain reliable metrics
     * for the x-height. If reliable font metrics are not available, UAs may determine the x-height
     * from the height of a lowercase glyph. One possible heuristics is to look at how far the glyph
     * for the lowercase "o" extends below the baseline, and subtract that value from the top of its
     * bounding box. In the cases where it is impossible or impractical to determine the x-height, a
     * value of 0.5em should be used.
     * </p>
     */
    protected final Unit px = new Unit("px");

    /**
     * <p>
     * The x-height of a font can be found in different ways. Some fonts contain reliable metrics
     * for the x-height. If reliable font metrics are not available, UAs may determine the x-height
     * from the height of a lowercase glyph. One possible heuristics is to look at how far the glyph
     * for the lowercase "o" extends below the baseline, and subtract that value from the top of its
     * bounding box. In the cases where it is impossible or impractical to determine the x-height, a
     * value of 0.5em should be used.
     * </p>
     */
    protected final Unit in = new Unit("in");

    /**
     * <p>
     * The format of a percentage value (denoted by <percentage> in this specification) is a
     * <number> immediately followed by '%'.
     * </p>
     * <p>
     * Percentage values are always relative to another value, for example a length. Each property
     * that allows percentages also defines the value to which the percentage refers. The value may
     * be that of another property for the same element, a property for an ancestor element, or a
     * value of the formatting context (e.g., the width of a containing block). When a percentage
     * value is set for a property of the root element and the percentage is defined as referring to
     * the inherited value of some property, the resultant value is the percentage times the initial
     * value of that property.
     * </p>
     */
    protected final Units percent = new Units("%");

    /**
     * Helper method to compute size.
     * 
     * @param size
     * @param unit
     * @return
     */
    private final String compute(double size, Units unit) {
        int i = (int) size;

        if (size == 0) {
            return "0";
        } else if (i == size) {
            return String.valueOf(i).concat(unit.toString());
        } else {
            return String.valueOf(size).concat(unit.toString());
        }
    }

    /**
     * <p>
     * Write css file.
     * </p>
     * 
     * @param builder
     */
    final void to(Appendable output) throws IOException {
        String className = Javascript.computeClassName(getClass()).substring(5);

        output.append('.').append(className).append('{');
        for (Entry<String, Object> entry : properties.entrySet()) {
            output.append(entry.getKey()).append(':').append(entry.getValue().toString()).append(';');
        }
        output.append('}');
    }
}
