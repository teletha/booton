/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.Locale.Category;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:01:43
 */
@JavaAPIProvider(java.util.Locale.class)
class Locale {

    /**
     * Useful constant for country.
     */
    public static final Locale US = new Locale("en", "US");

    /**
     * Useful constant for the root locale. The root locale is the locale whose language, country,
     * and variant are empty ("") strings. This is regarded as the base locale of all locales, and
     * is used as the language/country neutral locale for the locale sensitive operations.
     *
     * @since 1.6
     */
    public static final Locale ROOT = new Locale("", "");

    /** The base language. */
    private String language = "en";

    /** The base country. */
    private String country = "US";

    /**
     * @param language
     * @param country
     */
    private Locale(String language, String country) {
        this.language = language;
        this.country = country;
    }

    /**
     * Returns the country/region code for this locale, which should either be the empty string, an
     * uppercase ISO 3166 2-letter code, or a UN M.49 3-digit code.
     * 
     * @return The country/region code, or the empty string if none is defined.
     * @see #getDisplayCountry
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the language code of this Locale.
     * <p>
     * <b>Note:</b> ISO 639 is not a stable standard&mdash; some languages' codes have changed.
     * Locale's constructor recognizes both the new and the old codes for the languages whose codes
     * have changed, but this function always returns the old code. If you want to check for a
     * specific language whose code has changed, don't do
     * 
     * <pre>
     * if (locale.getLanguage().equals("he")) // BAD!
     *    ...
     * </pre>
     * Instead, do
     * 
     * <pre>
     * if (locale.getLanguage().equals(new Locale("he").getLanguage()))
     *    ...
     * </pre>
     * 
     * @return The language code, or the empty string if none is defined.
     * @see #getDisplayLanguage
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Returns a well-formed IETF BCP 47 language tag representing this locale.
     * <p>
     * If this <code>Locale</code> has a language, country, or variant that does not satisfy the
     * IETF BCP 47 language tag syntax requirements, this method handles these fields as described
     * below:
     * <p>
     * <b>Language:</b> If language is empty, or not <a href="#def_language" >well-formed</a> (for
     * example "a" or "e2"), it will be emitted as "und" (Undetermined).
     * <p>
     * <b>Country:</b> If country is not <a href="#def_region">well-formed</a> (for example "12" or
     * "USA"), it will be omitted.
     * <p>
     * <b>Variant:</b> If variant <b>is</b> <a href="#def_variant">well-formed</a>, each sub-segment
     * (delimited by '-' or '_') is emitted as a subtag. Otherwise:
     * <ul>
     * <li>if all sub-segments match <code>[0-9a-zA-Z]{1,8}</code> (for example "WIN" or
     * "Oracle_JDK_Standard_Edition"), the first ill-formed sub-segment and all following will be
     * appended to the private use subtag. The first appended subtag will be "lvariant", followed by
     * the sub-segments in order, separated by hyphen. For example, "x-lvariant-WIN",
     * "Oracle-x-lvariant-JDK-Standard-Edition".
     * <li>if any sub-segment does not match <code>[0-9a-zA-Z]{1,8}</code>, the variant will be
     * truncated and the problematic sub-segment and all following sub-segments will be omitted. If
     * the remainder is non-empty, it will be emitted as a private use subtag as above (even if the
     * remainder turns out to be well-formed). For example, "Solaris_isjustthecoolestthing" is
     * emitted as "x-lvariant-Solaris", not as "solaris".</li>
     * </ul>
     * <p>
     * <b>Special Conversions:</b> Java supports some old locale representations, including
     * deprecated ISO language codes, for compatibility. This method performs the following
     * conversions:
     * <ul>
     * <li>Deprecated ISO language codes "iw", "ji", and "in" are converted to "he", "yi", and "id",
     * respectively.
     * <li>A locale with language "no", country "NO", and variant "NY", representing Norwegian
     * Nynorsk (Norway), is converted to a language tag "nn-NO".</li>
     * </ul>
     * <p>
     * <b>Note:</b> Although the language tag created by this method is well-formed (satisfies the
     * syntax requirements defined by the IETF BCP 47 specification), it is not necessarily a valid
     * BCP 47 language tag. For example,
     * 
     * <pre>
     *   new Locale("xx", "YY").toLanguageTag();</pre>
     * will return "xx-YY", but the language subtag "xx" and the region subtag "YY" are invalid
     * because they are not registered in the IANA Language Subtag Registry.
     *
     * @return a BCP47 language tag representing the locale
     * @see #forLanguageTag(String)
     * @since 1.7
     */
    public String toLanguageTag() {
        return language + "-" + country;
    }

    /**
     * Returns {@code true} if this {@code Locale} has any <a href="#def_extensions">
     * extensions</a>.
     *
     * @return {@code true} if this {@code Locale} has any extensions
     * @since 1.8
     */
    public boolean hasExtensions() {
        return localeExtensions != null;
    }

    /**
     * Returns a copy of this {@code Locale} with no <a href="#def_extensions"> extensions</a>. If
     * this {@code Locale} has no extensions, this {@code Locale} is returned.
     *
     * @return a copy of this {@code Locale} with no extensions, or {@code this} if {@code this} has
     *         no extensions
     * @since 1.8
     */
    public Locale stripExtensions() {
        return hasExtensions() ? Locale.getInstance(baseLocale, null) : this;
    }

    /**
     * Gets the current value of the default locale for this instance of the Java Virtual Machine.
     * <p>
     * The Java Virtual Machine sets the default locale during startup based on the host
     * environment. It is used by many locale-sensitive methods if no locale is explicitly
     * specified. It can be changed using the {@link #setDefault(java.util.Locale) setDefault}
     * method.
     * 
     * @return the default locale for this instance of the Java Virtual Machine
     */
    public static Locale getDefault() {
        return US;
    }

    /**
     * Gets the current value of the default locale for the specified Category for this instance of
     * the Java Virtual Machine.
     * <p>
     * The Java Virtual Machine sets the default locale during startup based on the host
     * environment. It is used by many locale-sensitive methods if no locale is explicitly
     * specified. It can be changed using the setDefault(Locale.Category, Locale) method.
     * 
     * @param category - the specified category to get the default locale
     * @throws NullPointerException - if category is null
     * @return the default locale for the specified Category for this instance of the Java Virtual
     *         Machine
     * @see #setDefault(Locale.Category, Locale)
     * @since 1.7
     */
    public static Locale getDefault(Category category) {
        return getDefault();
    }

    /**
     * Returns a locale for the specified IETF BCP 47 language tag string.
     * <p>
     * If the specified language tag contains any ill-formed subtags, the first such subtag and all
     * following subtags are ignored. Compare to {@link Locale.Builder#setLanguageTag} which throws
     * an exception in this case.
     * <p>
     * The following <b>conversions</b> are performed:
     * <ul>
     * <li>The language code "und" is mapped to language "".
     * <li>The language codes "he", "yi", and "id" are mapped to "iw", "ji", and "in" respectively.
     * (This is the same canonicalization that's done in Locale's constructors.)
     * <li>The portion of a private use subtag prefixed by "lvariant", if any, is removed and
     * appended to the variant field in the result locale (without case normalization). If it is
     * then empty, the private use subtag is discarded:
     *
     * <pre>
     *     Locale loc;
     *     loc = Locale.forLanguageTag("en-US-x-lvariant-POSIX");
     *     loc.getVariant(); // returns "POSIX"
     *     loc.getExtension('x'); // returns null
     *
     *     loc = Locale.forLanguageTag("de-POSIX-x-URP-lvariant-Abc-Def");
     *     loc.getVariant(); // returns "POSIX_Abc_Def"
     *     loc.getExtension('x'); // returns "urp"
     * </pre>
     * <li>When the languageTag argument contains an extlang subtag, the first such subtag is used
     * as the language, and the primary language subtag and other extlang subtags are ignored:
     *
     * <pre>
     *     Locale.forLanguageTag("ar-aao").getLanguage(); // returns "aao"
     *     Locale.forLanguageTag("en-abc-def-us").toString(); // returns "abc_US"
     * </pre>
     * <li>Case is normalized except for variant tags, which are left unchanged. Language is
     * normalized to lower case, script to title case, country to upper case, and extensions to
     * lower case.
     * <li>If, after processing, the locale would exactly match either ja_JP_JP or th_TH_TH with no
     * extensions, the appropriate extensions are added as though the constructor had been called:
     *
     * <pre>
     *    Locale.forLanguageTag("ja-JP-x-lvariant-JP").toLanguageTag();
     *    // returns "ja-JP-u-ca-japanese-x-lvariant-JP"
     *    Locale.forLanguageTag("th-TH-x-lvariant-TH").toLanguageTag();
     *    // returns "th-TH-u-nu-thai-x-lvariant-TH"
     * </pre>
     * </ul>
     * <p>
     * This implements the 'Language-Tag' production of BCP47, and so supports grandfathered
     * (regular and irregular) as well as private use language tags. Stand alone private use tags
     * are represented as empty language and extension 'x-whatever', and grandfathered tags are
     * converted to their canonical replacements where they exist.
     * <p>
     * Grandfathered tags with canonical replacements are as follows:
     * <table summary="Grandfathered tags with canonical replacements">
     * <tbody align="center">
     * <tr>
     * <th>grandfathered tag</th>
     * <th>&nbsp;</th>
     * <th>modern replacement</th>
     * </tr>
     * <tr>
     * <td>art-lojban</td>
     * <td>&nbsp;</td>
     * <td>jbo</td>
     * </tr>
     * <tr>
     * <td>i-ami</td>
     * <td>&nbsp;</td>
     * <td>ami</td>
     * </tr>
     * <tr>
     * <td>i-bnn</td>
     * <td>&nbsp;</td>
     * <td>bnn</td>
     * </tr>
     * <tr>
     * <td>i-hak</td>
     * <td>&nbsp;</td>
     * <td>hak</td>
     * </tr>
     * <tr>
     * <td>i-klingon</td>
     * <td>&nbsp;</td>
     * <td>tlh</td>
     * </tr>
     * <tr>
     * <td>i-lux</td>
     * <td>&nbsp;</td>
     * <td>lb</td>
     * </tr>
     * <tr>
     * <td>i-navajo</td>
     * <td>&nbsp;</td>
     * <td>nv</td>
     * </tr>
     * <tr>
     * <td>i-pwn</td>
     * <td>&nbsp;</td>
     * <td>pwn</td>
     * </tr>
     * <tr>
     * <td>i-tao</td>
     * <td>&nbsp;</td>
     * <td>tao</td>
     * </tr>
     * <tr>
     * <td>i-tay</td>
     * <td>&nbsp;</td>
     * <td>tay</td>
     * </tr>
     * <tr>
     * <td>i-tsu</td>
     * <td>&nbsp;</td>
     * <td>tsu</td>
     * </tr>
     * <tr>
     * <td>no-bok</td>
     * <td>&nbsp;</td>
     * <td>nb</td>
     * </tr>
     * <tr>
     * <td>no-nyn</td>
     * <td>&nbsp;</td>
     * <td>nn</td>
     * </tr>
     * <tr>
     * <td>sgn-BE-FR</td>
     * <td>&nbsp;</td>
     * <td>sfb</td>
     * </tr>
     * <tr>
     * <td>sgn-BE-NL</td>
     * <td>&nbsp;</td>
     * <td>vgt</td>
     * </tr>
     * <tr>
     * <td>sgn-CH-DE</td>
     * <td>&nbsp;</td>
     * <td>sgg</td>
     * </tr>
     * <tr>
     * <td>zh-guoyu</td>
     * <td>&nbsp;</td>
     * <td>cmn</td>
     * </tr>
     * <tr>
     * <td>zh-hakka</td>
     * <td>&nbsp;</td>
     * <td>hak</td>
     * </tr>
     * <tr>
     * <td>zh-min-nan</td>
     * <td>&nbsp;</td>
     * <td>nan</td>
     * </tr>
     * <tr>
     * <td>zh-xiang</td>
     * <td>&nbsp;</td>
     * <td>hsn</td>
     * </tr>
     * </tbody>
     * </table>
     * <p>
     * Grandfathered tags with no modern replacement will be converted as follows:
     * <table summary="Grandfathered tags with no modern replacement">
     * <tbody align="center">
     * <tr>
     * <th>grandfathered tag</th>
     * <th>&nbsp;</th>
     * <th>converts to</th>
     * </tr>
     * <tr>
     * <td>cel-gaulish</td>
     * <td>&nbsp;</td>
     * <td>xtg-x-cel-gaulish</td>
     * </tr>
     * <tr>
     * <td>en-GB-oed</td>
     * <td>&nbsp;</td>
     * <td>en-GB-x-oed</td>
     * </tr>
     * <tr>
     * <td>i-default</td>
     * <td>&nbsp;</td>
     * <td>en-x-i-default</td>
     * </tr>
     * <tr>
     * <td>i-enochian</td>
     * <td>&nbsp;</td>
     * <td>und-x-i-enochian</td>
     * </tr>
     * <tr>
     * <td>i-mingo</td>
     * <td>&nbsp;</td>
     * <td>see-x-i-mingo</td>
     * </tr>
     * <tr>
     * <td>zh-min</td>
     * <td>&nbsp;</td>
     * <td>nan-x-zh-min</td>
     * </tr>
     * </tbody>
     * </table>
     * <p>
     * For a list of all grandfathered tags, see the IANA Language Subtag Registry (search for
     * "Type: grandfathered").
     * <p>
     * <b>Note</b>: there is no guarantee that <code>toLanguageTag</code> and
     * <code>forLanguageTag</code> will round-trip.
     *
     * @param languageTag the language tag
     * @return The locale that best represents the language tag.
     * @throws NullPointerException if <code>languageTag</code> is <code>null</code>
     * @see #toLanguageTag()
     * @see java.util.Locale.Builder#setLanguageTag(String)
     * @since 1.7
     */
    public static Locale forLanguageTag(String languageTag) {
        int index = languageTag.indexOf('-');

        if (index == -1) {
            return new Locale(languageTag, null);
        } else {
            return new Locale(languageTag.substring(0, index), languageTag.substring(index + 1));
        }
    }

}
