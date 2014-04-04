/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.PropertyResourceBundle;
import java.util.spi.ResourceBundleControlProvider;

import kiss.I;
import kiss.Manageable;
import kiss.Singleton;
import sun.reflect.CallerSensitive;
import booton.translator.JavaAPIProvider;

/**
 * @version 2014/03/12 3:11:10
 */
@JavaAPIProvider(java.util.ResourceBundle.class)
abstract class ResourceBundle {

    /**
     * The parent bundle of this bundle. The parent bundle is searched by {@link #getObject
     * getObject} when this bundle does not contain a particular resource.
     */
    protected ResourceBundle parent = null;

    private Map<String, String> bundle = new HashMap();

    /**
     * Returns an enumeration of the keys.
     *
     * @return an <code>Enumeration</code> of the keys contained in this <code>ResourceBundle</code>
     *         and its parent bundles.
     */
    public abstract Enumeration<String> getKeys();

    /**
     * Determines whether the given <code>key</code> is contained in this
     * <code>ResourceBundle</code> or its parent bundles.
     *
     * @param key the resource <code>key</code>
     * @return <code>true</code> if the given <code>key</code> is contained in this
     *         <code>ResourceBundle</code> or its parent bundles; <code>false</code> otherwise.
     * @exception NullPointerException if <code>key</code> is <code>null</code>
     * @since 1.6
     */
    public boolean containsKey(String key) {
        Objects.nonNull(key);

        return bundle.containsKey(key);
    }

    /**
     * Gets a string for the given key from this resource bundle or one of its parents. Calling this
     * method is equivalent to calling <blockquote>
     * <code>(String) {@link #getObject(java.lang.String) getObject}(key)</code>. </blockquote>
     *
     * @param key the key for the desired string
     * @exception NullPointerException if <code>key</code> is <code>null</code>
     * @exception MissingResourceException if no object for the given key can be found
     * @exception ClassCastException if the object found for the given key is not a string
     * @return the string for the given key
     */
    public final String getString(String key) {
        return bundle.get(key);
    }

    private static Control getDefaultControl(String baseName) {
        return new Control();
    }

    /**
     * Gets a resource bundle using the specified base name, the default locale, and the caller's
     * class loader. Calling this method is equivalent to calling <blockquote>
     * <code>getBundle(baseName, Locale.getDefault(), this.getClass().getClassLoader())</code>,
     * </blockquote> except that <code>getClassLoader()</code> is run with the security privileges
     * of <code>ResourceBundle</code>. See {@link #getBundle(String, Locale, ClassLoader) getBundle}
     * for a complete description of the search and instantiation strategy.
     *
     * @param baseName the base name of the resource bundle, a fully qualified class name
     * @exception java.lang.NullPointerException if <code>baseName</code> is <code>null</code>
     * @exception MissingResourceException if no resource bundle for the specified base name can be
     *                found
     * @return a resource bundle for the given base name and the default locale
     */
    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Gets a resource bundle using the specified base name and locale, and the caller's class
     * loader. Calling this method is equivalent to calling <blockquote>
     * <code>getBundle(baseName, locale, this.getClass().getClassLoader())</code>, </blockquote>
     * except that <code>getClassLoader()</code> is run with the security privileges of
     * <code>ResourceBundle</code>. See {@link #getBundle(String, Locale, ClassLoader) getBundle}
     * for a complete description of the search and instantiation strategy.
     *
     * @param baseName the base name of the resource bundle, a fully qualified class name
     * @param locale the locale for which a resource bundle is desired
     * @exception NullPointerException if <code>baseName</code> or <code>locale</code> is
     *                <code>null</code>
     * @exception MissingResourceException if no resource bundle for the specified base name can be
     *                found
     * @return a resource bundle for the given base name and locale
     */
    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName, Locale locale) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Gets a resource bundle using the specified base name, locale, and class loader.
     * <p>
     * This method behaves the same as calling
     * {@link #getBundle(String, Locale, ClassLoader, Control)} passing a default instance of
     * {@link Control} unless another {@link Control} is provided with the
     * {@link ResourceBundleControlProvider} SPI. Refer to the description of <a
     * href="#modify_default_behavior">modifying the default behavior</a>.
     * <p>
     * <a name="default_behavior">The following describes the default behavior</a>.
     * <p>
     * <code>getBundle</code> uses the base name, the specified locale, and the default locale
     * (obtained from {@link java.util.Locale#getDefault() Locale.getDefault}) to generate a
     * sequence of <a name="candidates"><em>candidate bundle names</em></a>. If the specified
     * locale's language, script, country, and variant are all empty strings, then the base name is
     * the only candidate bundle name. Otherwise, a list of candidate locales is generated from the
     * attribute values of the specified locale (language, script, country and variant) and appended
     * to the base name. Typically, this will look like the following:
     *
     * <pre>
     *     baseName + "_" + language + "_" + script + "_" + country + "_" + variant
     *     baseName + "_" + language + "_" + script + "_" + country
     *     baseName + "_" + language + "_" + script
     *     baseName + "_" + language + "_" + country + "_" + variant
     *     baseName + "_" + language + "_" + country
     *     baseName + "_" + language
     * </pre>
     * <p>
     * Candidate bundle names where the final component is an empty string are omitted, along with
     * the underscore. For example, if country is an empty string, the second and the fifth
     * candidate bundle names above would be omitted. Also, if script is an empty string, the
     * candidate names including script are omitted. For example, a locale with language "de" and
     * variant "JAVA" will produce candidate names with base name "MyResource" below.
     *
     * <pre>
     *     MyResource_de__JAVA
     *     MyResource_de
     * </pre>
     * In the case that the variant contains one or more underscores ('_'), a sequence of bundle
     * names generated by truncating the last underscore and the part following it is inserted after
     * a candidate bundle name with the original variant. For example, for a locale with language
     * "en", script "Latn, country "US" and variant "WINDOWS_VISTA", and bundle base name
     * "MyResource", the list of candidate bundle names below is generated:
     *
     * <pre>
     * MyResource_en_Latn_US_WINDOWS_VISTA
     * MyResource_en_Latn_US_WINDOWS
     * MyResource_en_Latn_US
     * MyResource_en_Latn
     * MyResource_en_US_WINDOWS_VISTA
     * MyResource_en_US_WINDOWS
     * MyResource_en_US
     * MyResource_en
     * </pre>
     * <blockquote><b>Note:</b> For some <code>Locale</code>s, the list of candidate bundle names
     * contains extra names, or the order of bundle names is slightly modified. See the description
     * of the default implementation of {@link Control#getCandidateLocales(String, Locale)
     * getCandidateLocales} for details.</blockquote>
     * <p>
     * <code>getBundle</code> then iterates over the candidate bundle names to find the first one
     * for which it can <em>instantiate</em> an actual resource bundle. It uses the default
     * controls' {@link Control#getFormats getFormats} method, which generates two bundle names for
     * each generated name, the first a class name and the second a properties file name. For each
     * candidate bundle name, it attempts to create a resource bundle:
     * <ul>
     * <li>First, it attempts to load a class using the generated class name. If such a class can be
     * found and loaded using the specified class loader, is assignment compatible with
     * ResourceBundle, is accessible from ResourceBundle, and can be instantiated,
     * <code>getBundle</code> creates a new instance of this class and uses it as the
     * <em>result resource
     * bundle</em>.
     * <li>Otherwise, <code>getBundle</code> attempts to locate a property resource file using the
     * generated properties file name. It generates a path name from the candidate bundle name by
     * replacing all "." characters with "/" and appending the string ".properties". It attempts to
     * find a "resource" with this name using
     * {@link java.lang.ClassLoader#getResource(java.lang.String) ClassLoader.getResource}. (Note
     * that a "resource" in the sense of <code>getResource</code> has nothing to do with the
     * contents of a resource bundle, it is just a container of data, such as a file.) If it finds a
     * "resource", it attempts to create a new {@link PropertyResourceBundle} instance from its
     * contents. If successful, this instance becomes the <em>result resource bundle</em>.
     * </ul>
     * <p>
     * This continues until a result resource bundle is instantiated or the list of candidate bundle
     * names is exhausted. If no matching resource bundle is found, the default control's
     * {@link Control#getFallbackLocale getFallbackLocale} method is called, which returns the
     * current default locale. A new sequence of candidate locale names is generated using this
     * locale and and searched again, as above.
     * <p>
     * If still no result bundle is found, the base name alone is looked up. If this still fails, a
     * <code>MissingResourceException</code> is thrown.
     * <p>
     * <a name="parent_chain"> Once a result resource bundle has been found, its
     * <em>parent chain</em> is instantiated</a>. If the result bundle already has a parent (perhaps
     * because it was returned from a cache) the chain is complete.
     * <p>
     * Otherwise, <code>getBundle</code> examines the remainder of the candidate locale list that
     * was used during the pass that generated the result resource bundle. (As before, candidate
     * bundle names where the final component is an empty string are omitted.) When it comes to the
     * end of the candidate list, it tries the plain bundle name. With each of the candidate bundle
     * names it attempts to instantiate a resource bundle (first looking for a class and then a
     * properties file, as described above).
     * <p>
     * Whenever it succeeds, it calls the previously instantiated resource bundle's
     * {@link #setParent(java.util.ResourceBundle) setParent} method with the new resource bundle.
     * This continues until the list of names is exhausted or the current bundle already has a
     * non-null parent.
     * <p>
     * Once the parent chain is complete, the bundle is returned.
     * <p>
     * <b>Note:</b> <code>getBundle</code> caches instantiated resource bundles and might return the
     * same resource bundle instance multiple times.
     * <p>
     * <b>Note:</b>The <code>baseName</code> argument should be a fully qualified class name.
     * However, for compatibility with earlier versions, Sun's Java SE Runtime Environments do not
     * verify this, and so it is possible to access <code>PropertyResourceBundle</code>s by
     * specifying a path name (using "/") instead of a fully qualified class name (using ".").
     * <p>
     * <a name="default_behavior_example"> <strong>Example:</strong></a>
     * <p>
     * The following class and property files are provided:
     * 
     * <pre>
     *     MyResources.class
     *     MyResources.properties
     *     MyResources_fr.properties
     *     MyResources_fr_CH.class
     *     MyResources_fr_CH.properties
     *     MyResources_en.properties
     *     MyResources_es_ES.class
     * </pre>
     * The contents of all files are valid (that is, public non-abstract subclasses of
     * <code>ResourceBundle</code> for the ".class" files, syntactically correct ".properties"
     * files). The default locale is <code>Locale("en", "GB")</code>.
     * <p>
     * Calling <code>getBundle</code> with the locale arguments below will instantiate resource
     * bundles as follows:
     * <table summary="getBundle() locale to resource bundle mapping">
     * <tr>
     * <td>Locale("fr", "CH")</td>
     * <td>MyResources_fr_CH.class, parent MyResources_fr.properties, parent MyResources.class</td>
     * </tr>
     * <tr>
     * <td>Locale("fr", "FR")</td>
     * <td>MyResources_fr.properties, parent MyResources.class</td>
     * </tr>
     * <tr>
     * <td>Locale("de", "DE")</td>
     * <td>MyResources_en.properties, parent MyResources.class</td>
     * </tr>
     * <tr>
     * <td>Locale("en", "US")</td>
     * <td>MyResources_en.properties, parent MyResources.class</td>
     * </tr>
     * <tr>
     * <td>Locale("es", "ES")</td>
     * <td>MyResources_es_ES.class, parent MyResources.class</td>
     * </tr>
     * </table>
     * <p>
     * The file MyResources_fr_CH.properties is never used because it is hidden by the
     * MyResources_fr_CH.class. Likewise, MyResources.properties is also hidden by
     * MyResources.class.
     *
     * @param baseName the base name of the resource bundle, a fully qualified class name
     * @param locale the locale for which a resource bundle is desired
     * @param loader the class loader from which to load the resource bundle
     * @return a resource bundle for the given base name and locale
     * @exception java.lang.NullPointerException if <code>baseName</code>, <code>locale</code>, or
     *                <code>loader</code> is <code>null</code>
     * @exception MissingResourceException if no resource bundle for the specified base name can be
     *                found
     * @since 1.2
     */
    public static ResourceBundle getBundle(String baseName, Locale locale, ClassLoader loader) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * @version 2014/03/12 8:37:39
     */
    @JavaAPIProvider(java.util.ResourceBundle.Control.class)
    @Manageable(lifestyle = Singleton.class)
    private static class Control {

        /**
         * The default format <code>List</code>, which contains the strings
         * <code>"java.class"</code> and <code>"java.properties"</code>, in this order. This
         * <code>List</code> is {@linkplain Collections#unmodifiableList(List) unmodifiable}.
         *
         * @see #getFormats(String)
         */
        public static final List<String> FORMAT_DEFAULT = Collections.unmodifiableList(Arrays.asList("java.class", "java.properties"));

        /**
         * The class-only format <code>List</code> containing <code>"java.class"</code>. This
         * <code>List</code> is {@linkplain Collections#unmodifiableList(List) unmodifiable}.
         *
         * @see #getFormats(String)
         */
        public static final List<String> FORMAT_CLASS = Collections.unmodifiableList(Arrays.asList("java.class"));

        /**
         * The properties-only format <code>List</code> containing <code>"java.properties"</code>.
         * This <code>List</code> is {@linkplain Collections#unmodifiableList(List) unmodifiable}.
         *
         * @see #getFormats(String)
         */
        public static final List<String> FORMAT_PROPERTIES = Collections.unmodifiableList(Arrays.asList("java.properties"));

        /**
         * Returns a <code>ResourceBundle.Control</code> in which the {@link #getFormats(String)
         * getFormats} method returns the specified <code>formats</code>. The <code>formats</code>
         * must be equal to one of {@link Control#FORMAT_PROPERTIES}, {@link Control#FORMAT_CLASS}
         * or {@link Control#FORMAT_DEFAULT}. <code>ResourceBundle.Control</code> instances returned
         * by this method are singletons and thread-safe.
         * <p>
         * Specifying {@link Control#FORMAT_DEFAULT} is equivalent to instantiating the
         * <code>ResourceBundle.Control</code> class, except that this method returns a singleton.
         *
         * @param formats the formats to be returned by the
         *            <code>ResourceBundle.Control.getFormats</code> method
         * @return a <code>ResourceBundle.Control</code> supporting the specified
         *         <code>formats</code>
         * @exception NullPointerException if <code>formats</code> is <code>null</code>
         * @exception IllegalArgumentException if <code>formats</code> is unknown
         */
        public static final Control getControl(List<String> formats) {
            return I.make(Control.class);
        }

        /**
         * Returns a <code>List</code> of <code>Locale</code>s as candidate locales for
         * <code>baseName</code> and <code>locale</code>. This method is called by the
         * <code>ResourceBundle.getBundle</code> factory method each time the factory method tries
         * finding a resource bundle for a target <code>Locale</code>.
         * <p>
         * The sequence of the candidate locales also corresponds to the runtime resource lookup
         * path (also known as the <I>parent chain</I>), if the corresponding resource bundles for
         * the candidate locales exist and their parents are not defined by loaded resource bundles
         * themselves. The last element of the list must be a {@linkplain Locale#ROOT root locale}
         * if it is desired to have the base bundle as the terminal of the parent chain.
         * <p>
         * If the given locale is equal to <code>Locale.ROOT</code> (the root locale), a
         * <code>List</code> containing only the root <code>Locale</code> must be returned. In this
         * case, the <code>ResourceBundle.getBundle</code> factory method loads only the base bundle
         * as the resulting resource bundle.
         * <p>
         * It is not a requirement to return an immutable (unmodifiable) <code>List</code>. However,
         * the returned <code>List</code> must not be mutated after it has been returned by
         * <code>getCandidateLocales</code>.
         * <p>
         * The default implementation returns a <code>List</code> containing <code>Locale</code>s
         * using the rules described below. In the description below, <em>L</em>, <em>S</em>,
         * <em>C</em> and <em>V</em> respectively represent non-empty language, script, country, and
         * variant. For example, [<em>L</em>, <em>C</em>] represents a <code>Locale</code> that has
         * non-empty values only for language and country. The form <em>L</em>("xx") represents the
         * (non-empty) language value is "xx". For all cases, <code>Locale</code>s whose final
         * component values are empty strings are omitted.
         * <ol>
         * <li>For an input <code>Locale</code> with an empty script value, append candidate
         * <code>Locale</code>s by omitting the final component one by one as below:
         * <ul>
         * <li>[<em>L</em>, <em>C</em>, <em>V</em>]</li>
         * <li>[<em>L</em>, <em>C</em>]</li>
         * <li>[<em>L</em>]</li>
         * <li> <code>Locale.ROOT</code></li>
         * </ul>
         * </li>
         * <li>For an input <code>Locale</code> with a non-empty script value, append candidate
         * <code>Locale</code>s by omitting the final component up to language, then append
         * candidates generated from the <code>Locale</code> with country and variant restored:
         * <ul>
         * <li>[<em>L</em>, <em>S</em>, <em>C</em>, <em>V</em>]</li>
         * <li>[<em>L</em>, <em>S</em>, <em>C</em>]</li>
         * <li>[<em>L</em>, <em>S</em>]</li>
         * <li>[<em>L</em>, <em>C</em>, <em>V</em>]</li>
         * <li>[<em>L</em>, <em>C</em>]</li>
         * <li>[<em>L</em>]</li>
         * <li> <code>Locale.ROOT</code></li>
         * </ul>
         * </li>
         * <li>For an input <code>Locale</code> with a variant value consisting of multiple subtags
         * separated by underscore, generate candidate <code>Locale</code>s by omitting the variant
         * subtags one by one, then insert them after every occurrence of <code> Locale</code>s with
         * the full variant value in the original list. For example, if the the variant consists of
         * two subtags <em>V1</em> and <em>V2</em>:
         * <ul>
         * <li>[<em>L</em>, <em>S</em>, <em>C</em>, <em>V1</em>, <em>V2</em>]</li>
         * <li>[<em>L</em>, <em>S</em>, <em>C</em>, <em>V1</em>]</li>
         * <li>[<em>L</em>, <em>S</em>, <em>C</em>]</li>
         * <li>[<em>L</em>, <em>S</em>]</li>
         * <li>[<em>L</em>, <em>C</em>, <em>V1</em>, <em>V2</em>]</li>
         * <li>[<em>L</em>, <em>C</em>, <em>V1</em>]</li>
         * <li>[<em>L</em>, <em>C</em>]</li>
         * <li>[<em>L</em>]</li>
         * <li> <code>Locale.ROOT</code></li>
         * </ul>
         * </li>
         * <li>Special cases for Chinese. When an input <code>Locale</code> has the language "zh"
         * (Chinese) and an empty script value, either "Hans" (Simplified) or "Hant" (Traditional)
         * might be supplied, depending on the country. When the country is "CN" (China) or "SG"
         * (Singapore), "Hans" is supplied. When the country is "HK" (Hong Kong SAR China), "MO"
         * (Macau SAR China), or "TW" (Taiwan), "Hant" is supplied. For all other countries or when
         * the country is empty, no script is supplied. For example, for <code>Locale("zh", "CN")
         * </code>, the candidate list will be:
         * <ul>
         * <li>[<em>L</em>("zh"), <em>S</em>("Hans"), <em>C</em>("CN")]</li>
         * <li>[<em>L</em>("zh"), <em>S</em>("Hans")]</li>
         * <li>[<em>L</em>("zh"), <em>C</em>("CN")]</li>
         * <li>[<em>L</em>("zh")]</li>
         * <li> <code>Locale.ROOT</code></li>
         * </ul>
         * For <code>Locale("zh", "TW")</code>, the candidate list will be:
         * <ul>
         * <li>[<em>L</em>("zh"), <em>S</em>("Hant"), <em>C</em>("TW")]</li>
         * <li>[<em>L</em>("zh"), <em>S</em>("Hant")]</li>
         * <li>[<em>L</em>("zh"), <em>C</em>("TW")]</li>
         * <li>[<em>L</em>("zh")]</li>
         * <li> <code>Locale.ROOT</code></li>
         * </ul>
         * </li>
         * <li>Special cases for Norwegian. Both <code>Locale("no", "NO",
         * "NY")</code> and <code>Locale("nn", "NO")</code> represent Norwegian Nynorsk. When a
         * locale's language is "nn", the standard candidate list is generated up to [<em>L</em>
         * ("nn")], and then the following candidates are added:
         * <ul>
         * <li>[<em>L</em>("no"), <em>C</em>("NO"), <em>V</em>("NY")]</li>
         * <li>[<em>L</em>("no"), <em>C</em>("NO")]</li>
         * <li>[<em>L</em>("no")]</li>
         * <li> <code>Locale.ROOT</code></li>
         * </ul>
         * If the locale is exactly <code>Locale("no", "NO", "NY")</code>, it is first converted to
         * <code>Locale("nn", "NO")</code> and then the above procedure is followed.
         * <p>
         * Also, Java treats the language "no" as a synonym of Norwegian Bokm&#xE5;l "nb". Except
         * for the single case <code>Locale("no",
         * "NO", "NY")</code> (handled above), when an input <code>Locale</code> has language "no"
         * or "nb", candidate <code>Locale</code>s with language code "no" and "nb" are interleaved,
         * first using the requested language, then using its synonym. For example,
         * <code>Locale("nb", "NO", "POSIX")</code> generates the following candidate list:
         * <ul>
         * <li>[<em>L</em>("nb"), <em>C</em>("NO"), <em>V</em>("POSIX")]</li>
         * <li>[<em>L</em>("no"), <em>C</em>("NO"), <em>V</em>("POSIX")]</li>
         * <li>[<em>L</em>("nb"), <em>C</em>("NO")]</li>
         * <li>[<em>L</em>("no"), <em>C</em>("NO")]</li>
         * <li>[<em>L</em>("nb")]</li>
         * <li>[<em>L</em>("no")]</li>
         * <li> <code>Locale.ROOT</code></li>
         * </ul>
         * <code>Locale("no", "NO", "POSIX")</code> would generate the same list except that locales
         * with "no" would appear before the corresponding locales with "nb".</li>
         * </ol>
         * <p>
         * The default implementation uses an {@link ArrayList} that overriding implementations may
         * modify before returning it to the caller. However, a subclass must not modify it after it
         * has been returned by <code>getCandidateLocales</code>.
         * <p>
         * For example, if the given <code>baseName</code> is "Messages" and the given
         * <code>locale</code> is <code>Locale("ja",&nbsp;"",&nbsp;"XX")</code>, then a
         * <code>List</code> of <code>Locale</code>s:
         * 
         * <pre>
         *     Locale("ja", "", "XX")
         *     Locale("ja")
         *     Locale.ROOT
         * </pre>
         * is returned. And if the resource bundles for the "ja" and "" <code>Locale</code>s are
         * found, then the runtime resource lookup path (parent chain) is:
         * 
         * <pre>{@code
         *     Messages_ja -> Messages
         * }</pre>
         *
         * @param baseName the base name of the resource bundle, a fully qualified class name
         * @param locale the locale for which a resource bundle is desired
         * @return a <code>List</code> of candidate <code>Locale</code>s for the given
         *         <code>locale</code>
         * @exception NullPointerException if <code>baseName</code> or <code>locale</code> is
         *                <code>null</code>
         */
        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            if (baseName == null) {
                throw new NullPointerException();
            }
            return new ArrayList<>(CANDIDATES_CACHE.get(locale.getBaseLocale()));
        }

        /**
         * Converts the given <code>baseName</code> and <code>locale</code> to the bundle name. This
         * method is called from the default implementation of the
         * {@link #newBundle(String, Locale, String, ClassLoader, boolean) newBundle} and
         * {@link #needsReload(String, Locale, String, ClassLoader, ResourceBundle, long)
         * needsReload} methods.
         * <p>
         * This implementation returns the following value:
         * 
         * <pre>
         *     baseName + "_" + language + "_" + script + "_" + country + "_" + variant
         * </pre>
         * where <code>language</code>, <code>script</code>, <code>country</code>, and
         * <code>variant</code> are the language, script, country, and variant values of
         * <code>locale</code>, respectively. Final component values that are empty Strings are
         * omitted along with the preceding '_'. When the script is empty, the script value is
         * omitted along with the preceding '_'. If all of the values are empty strings, then
         * <code>baseName</code> is returned.
         * <p>
         * For example, if <code>baseName</code> is <code>"baseName"</code> and <code>locale</code>
         * is <code>Locale("ja",&nbsp;"",&nbsp;"XX")</code>, then
         * <code>"baseName_ja_&thinsp;_XX"</code> is returned. If the given locale is
         * <code>Locale("en")</code>, then <code>"baseName_en"</code> is returned.
         * <p>
         * Overriding this method allows applications to use different conventions in the
         * organization and packaging of localized resources.
         *
         * @param baseName the base name of the resource bundle, a fully qualified class name
         * @param locale the locale for which a resource bundle should be loaded
         * @return the bundle name for the resource bundle
         * @exception NullPointerException if <code>baseName</code> or <code>locale</code> is
         *                <code>null</code>
         */
        public String toBundleName(String baseName, Locale locale) {
            if (locale == Locale.ROOT) {
                return baseName;
            }

            String language = locale.getLanguage();
            String script = locale.getScript();
            String country = locale.getCountry();
            String variant = locale.getVariant();

            if (language == "" && country == "" && variant == "") {
                return baseName;
            }

            StringBuilder sb = new StringBuilder(baseName);
            sb.append('_');
            if (script != "") {
                if (variant != "") {
                    sb.append(language)
                            .append('_')
                            .append(script)
                            .append('_')
                            .append(country)
                            .append('_')
                            .append(variant);
                } else if (country != "") {
                    sb.append(language).append('_').append(script).append('_').append(country);
                } else {
                    sb.append(language).append('_').append(script);
                }
            } else {
                if (variant != "") {
                    sb.append(language).append('_').append(country).append('_').append(variant);
                } else if (country != "") {
                    sb.append(language).append('_').append(country);
                } else {
                    sb.append(language);
                }
            }
            return sb.toString();
        }

        /**
         * Converts the given <code>bundleName</code> to the form required by the
         * {@link ClassLoader#getResource ClassLoader.getResource} method by replacing all
         * occurrences of <code>'.'</code> in <code>bundleName</code> with <code>'/'</code> and
         * appending a <code>'.'</code> and the given file <code>suffix</code>. For example, if
         * <code>bundleName</code> is <code>"foo.bar.MyResources_ja_JP"</code> and
         * <code>suffix</code> is <code>"properties"</code>, then
         * <code>"foo/bar/MyResources_ja_JP.properties"</code> is returned.
         *
         * @param bundleName the bundle name
         * @param suffix the file type suffix
         * @return the converted resource name
         * @exception NullPointerException if <code>bundleName</code> or <code>suffix</code> is
         *                <code>null</code>
         */
        public String toResourceName(String bundleName, String suffix) {
            return bundleName.replace('.', '/') + '.' + suffix;
        }

        /**
         * Determines if the expired <code>bundle</code> in the cache needs to be reloaded based on
         * the loading time given by <code>loadTime</code> or some other criteria. The method
         * returns <code>true</code> if reloading is required; <code>false</code> otherwise.
         * <code>loadTime</code> is a millisecond offset since the <a href="Calendar.html#Epoch">
         * <code>Calendar</code> Epoch</a>. The calling <code>ResourceBundle.getBundle</code>
         * factory method calls this method on the <code>ResourceBundle.Control</code> instance used
         * for its current invocation, not on the instance used in the invocation that originally
         * loaded the resource bundle.
         * <p>
         * The default implementation compares <code>loadTime</code> and the last modified time of
         * the source data of the resource bundle. If it's determined that the source data has been
         * modified since <code>loadTime</code>, <code>true</code> is returned. Otherwise,
         * <code>false</code> is returned. This implementation assumes that the given
         * <code>format</code> is the same string as its file suffix if it's not one of the default
         * formats, <code>"java.class"</code> or <code>"java.properties"</code>.
         *
         * @param baseName the base bundle name of the resource bundle, a fully qualified class name
         * @param locale the locale for which the resource bundle should be instantiated
         * @param format the resource bundle format to be loaded
         * @param loader the <code>ClassLoader</code> to use to load the bundle
         * @param bundle the resource bundle instance that has been expired in the cache
         * @param loadTime the time when <code>bundle</code> was loaded and put in the cache
         * @return <code>true</code> if the expired bundle needs to be reloaded; <code>false</code>
         *         otherwise.
         * @exception NullPointerException if <code>baseName</code>, <code>locale</code>,
         *                <code>format</code>, <code>loader</code>, or <code>bundle</code> is
         *                <code>null</code>
         */
        public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
            return false;
        }
    }
}
