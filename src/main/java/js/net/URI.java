/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.net;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:03:20
 */
@JavaAPIProvider(java.net.URI.class)
class URI {
    // Note: Comments containing the word "ASSERT" indicate places where a
    // throw of an InternalError should be replaced by an appropriate assertion
    // statement once asserts are enabled in the build.

    static final long serialVersionUID = -6052424284110960213L;

    // -- Properties and components of this instance --

    // Components of all URIs: [<scheme>:]<scheme-specific-part>[#<fragment>]
    private transient String scheme; // null ==> relative URI

    private transient String fragment;

    // Hierarchical URI components: [//<authority>]<path>[?<query>]
    private transient String authority; // Registry or server

    // Server-based authority: [<userInfo>@]<host>[:<port>]
    private transient String userInfo;

    private transient String host; // null ==> registry-based

    private transient int port = -1; // -1 ==> undefined

    // Remaining components of hierarchical URIs
    private transient String path; // null ==> opaque

    private transient String query;

    // The remaining fields may be computed on demand

    private volatile transient String schemeSpecificPart;

    private volatile transient int hash; // Zero ==> undefined

    private volatile transient String decodedUserInfo = null;

    private volatile transient String decodedAuthority = null;

    private volatile transient String decodedPath = null;

    private volatile transient String decodedQuery = null;

    private volatile transient String decodedFragment = null;

    private volatile transient String decodedSchemeSpecificPart = null;

    /**
     * The string form of this URI.
     *
     * @serial
     */
    private volatile String string; // The only serializable field

    // -- Constructors and factories --

    private URI() {
    } // Used internally

    /**
     * Constructs a URI by parsing the given string.
     * <p>
     * This constructor parses the given string exactly as specified by the grammar in
     * <a href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>, Appendix&nbsp;A,
     * <b><i>except for the following deviations:</i></b>
     * </p>
     * <ul>
     * <li>
     * <p>
     * An empty authority component is permitted as long as it is followed by a non-empty path, a
     * query component, or a fragment component. This allows the parsing of URIs such as
     * {@code "file:///foo/bar"}, which seems to be the intent of RFC&nbsp;2396 although the grammar
     * does not permit it. If the authority component is empty then the user-information, host, and
     * port components are undefined.
     * </p>
     * </li>
     * <li>
     * <p>
     * Empty relative paths are permitted; this seems to be the intent of RFC&nbsp;2396 although the
     * grammar does not permit it. The primary consequence of this deviation is that a standalone
     * fragment such as {@code "#foo"} parses as a relative URI with an empty path and the given
     * fragment, and can be usefully <a href="#resolve-frag">resolved</a> against a base URI.
     * <li>
     * <p>
     * IPv4 addresses in host components are parsed rigorously, as specified by
     * <a href="http://www.ietf.org/rfc/rfc2732.txt">RFC&nbsp;2732</a>: Each element of a
     * dotted-quad address must contain no more than three decimal digits. Each element is further
     * constrained to have a value no greater than 255.
     * </p>
     * </li>
     * <li>
     * <p>
     * Hostnames in host components that comprise only a single domain label are permitted to start
     * with an <i>alphanum</i> character. This seems to be the intent of
     * <a href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a> section&nbsp;3.2.2 although
     * the grammar does not permit it. The consequence of this deviation is that the authority
     * component of a hierarchical URI such as {@code s://123}, will parse as a server-based
     * authority.
     * </p>
     * </li>
     * <li>
     * <p>
     * IPv6 addresses are permitted for the host component. An IPv6 address must be enclosed in
     * square brackets ({@code '['} and {@code ']'}) as specified by
     * <a href="http://www.ietf.org/rfc/rfc2732.txt">RFC&nbsp;2732</a>. The IPv6 address itself must
     * parse according to <a href="http://www.ietf.org/rfc/rfc2373.txt">RFC&nbsp;2373</a>. IPv6
     * addresses are further constrained to describe no more than sixteen bytes of address
     * information, a constraint implicit in RFC&nbsp;2373 but not expressible in the grammar.
     * </p>
     * </li>
     * <li>
     * <p>
     * Characters in the <i>other</i> category are permitted wherever RFC&nbsp;2396 permits
     * <i>escaped</i> octets, that is, in the user-information, path, query, and fragment
     * components, as well as in the authority component if the authority is registry-based. This
     * allows URIs to contain Unicode characters beyond those in the US-ASCII character set.
     * </p>
     * </li>
     * </ul>
     *
     * @param str The string to be parsed into a URI
     * @throws NullPointerException If {@code str} is {@code null}
     * @throws URISyntaxException If the given string violates RFC&nbsp;2396, as augmented by the
     *             above deviations
     */
    public URI(String str) throws URISyntaxException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Constructs a hierarchical URI from the given components.
     * <p>
     * If a scheme is given then the path, if also given, must either be empty or begin with a slash
     * character ({@code '/'}). Otherwise a component of the new URI may be left undefined by
     * passing {@code null} for the corresponding parameter or, in the case of the {@code port}
     * parameter, by passing {@code -1}.
     * <p>
     * This constructor first builds a URI string from the given components according to the rules
     * specified in <a href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * section&nbsp;5.2, step&nbsp;7:
     * </p>
     * <ol>
     * <li>
     * <p>
     * Initially, the result string is empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a scheme is given then it is appended to the result, followed by a colon character (
     * {@code ':'}).
     * </p>
     * </li>
     * <li>
     * <p>
     * If user information, a host, or a port are given then the string {@code "//"} is appended.
     * </p>
     * </li>
     * <li>
     * <p>
     * If user information is given then it is appended, followed by a commercial-at character (
     * {@code '@'}). Any character not in the <i>unreserved</i>, <i>punct</i>, <i>escaped</i>, or
     * <i>other</i> categories is <a href="#quote">quoted</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a host is given then it is appended. If the host is a literal IPv6 address but is not
     * enclosed in square brackets ({@code '['} and {@code ']'}) then the square brackets are added.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a port number is given then a colon character ({@code ':'}) is appended, followed by the
     * port number in decimal.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a path is given then it is appended. Any character not in the <i>unreserved</i>,
     * <i>punct</i>, <i>escaped</i>, or <i>other</i> categories, and not equal to the slash
     * character ({@code '/'}) or the commercial-at character ({@code '@'}), is quoted.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a query is given then a question-mark character ({@code '?'}) is appended, followed by the
     * query. Any character that is not a <a href="#legal-chars">legal URI character</a> is quoted.
     * </p>
     * </li>
     * <li>
     * <p>
     * Finally, if a fragment is given then a hash character ({@code '#'}) is appended, followed by
     * the fragment. Any character that is not a legal URI character is quoted.
     * </p>
     * </li>
     * </ol>
     * <p>
     * The resulting URI string is then parsed as if by invoking the {@link #URI(String)}
     * constructor and then invoking the {@link #parseServerAuthority()} method upon the result;
     * this may cause a {@link URISyntaxException} to be thrown.
     * </p>
     *
     * @param scheme Scheme name
     * @param userInfo User name and authorization information
     * @param host Host name
     * @param port Port number
     * @param path Path
     * @param query Query
     * @param fragment Fragment
     * @throws URISyntaxException If both a scheme and a path are given but the path is relative, if
     *             the URI string constructed from the given components violates RFC&nbsp;2396, or
     *             if the authority component of the string is present but cannot be parsed as a
     *             server-based authority
     */
    public URI(String scheme, String userInfo, String host, int port, String path, String query, String fragment)
            throws URISyntaxException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Constructs a hierarchical URI from the given components.
     * <p>
     * If a scheme is given then the path, if also given, must either be empty or begin with a slash
     * character ({@code '/'}). Otherwise a component of the new URI may be left undefined by
     * passing {@code null} for the corresponding parameter.
     * <p>
     * This constructor first builds a URI string from the given components according to the rules
     * specified in <a href="http://www.ietf.org/rfc/rfc2396.txt">RFC&nbsp;2396</a>,
     * section&nbsp;5.2, step&nbsp;7:
     * </p>
     * <ol>
     * <li>
     * <p>
     * Initially, the result string is empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a scheme is given then it is appended to the result, followed by a colon character (
     * {@code ':'}).
     * </p>
     * </li>
     * <li>
     * <p>
     * If an authority is given then the string {@code "//"} is appended, followed by the authority.
     * If the authority contains a literal IPv6 address then the address must be enclosed in square
     * brackets ({@code '['} and {@code ']'}). Any character not in the <i>unreserved</i>,
     * <i>punct</i>, <i>escaped</i>, or <i>other</i> categories, and not equal to the commercial-at
     * character ({@code '@'}), is <a href="#quote">quoted</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a path is given then it is appended. Any character not in the <i>unreserved</i>,
     * <i>punct</i>, <i>escaped</i>, or <i>other</i> categories, and not equal to the slash
     * character ({@code '/'}) or the commercial-at character ({@code '@'}), is quoted.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a query is given then a question-mark character ({@code '?'}) is appended, followed by the
     * query. Any character that is not a <a href="#legal-chars">legal URI character</a> is quoted.
     * </p>
     * </li>
     * <li>
     * <p>
     * Finally, if a fragment is given then a hash character ({@code '#'}) is appended, followed by
     * the fragment. Any character that is not a legal URI character is quoted.
     * </p>
     * </li>
     * </ol>
     * <p>
     * The resulting URI string is then parsed as if by invoking the {@link #URI(String)}
     * constructor and then invoking the {@link #parseServerAuthority()} method upon the result;
     * this may cause a {@link URISyntaxException} to be thrown.
     * </p>
     *
     * @param scheme Scheme name
     * @param authority Authority
     * @param path Path
     * @param query Query
     * @param fragment Fragment
     * @throws URISyntaxException If both a scheme and a path are given but the path is relative, if
     *             the URI string constructed from the given components violates RFC&nbsp;2396, or
     *             if the authority component of the string is present but cannot be parsed as a
     *             server-based authority
     */
    public URI(String scheme, String authority, String path, String query, String fragment) throws URISyntaxException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Constructs a hierarchical URI from the given components.
     * <p>
     * A component may be left undefined by passing {@code null}.
     * <p>
     * This convenience constructor works as if by invoking the seven-argument constructor as
     * follows: <blockquote> {@code new}
     * {@link #URI(String, String, String, int, String, String, String) URI}
     * {@code (scheme, null, host, -1, path, null, fragment);} </blockquote>
     *
     * @param scheme Scheme name
     * @param host Host name
     * @param path Path
     * @param fragment Fragment
     * @throws URISyntaxException If the URI string constructed from the given components violates
     *             RFC&nbsp;2396
     */
    public URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
    }

    /**
     * Constructs a URI from the given components.
     * <p>
     * A component may be left undefined by passing {@code null}.
     * <p>
     * This constructor first builds a URI in string form using the given components as follows:
     * </p>
     * <ol>
     * <li>
     * <p>
     * Initially, the result string is empty.
     * </p>
     * </li>
     * <li>
     * <p>
     * If a scheme is given then it is appended to the result, followed by a colon character (
     * {@code ':'}).
     * </p>
     * </li>
     * <li>
     * <p>
     * If a scheme-specific part is given then it is appended. Any character that is not a
     * <a href="#legal-chars">legal URI character</a> is <a href="#quote">quoted</a>.
     * </p>
     * </li>
     * <li>
     * <p>
     * Finally, if a fragment is given then a hash character ({@code '#'}) is appended to the
     * string, followed by the fragment. Any character that is not a legal URI character is quoted.
     * </p>
     * </li>
     * </ol>
     * <p>
     * The resulting URI string is then parsed in order to create the new URI instance as if by
     * invoking the {@link #URI(String)} constructor; this may cause a {@link URISyntaxException} to
     * be thrown.
     * </p>
     *
     * @param scheme Scheme name
     * @param ssp Scheme-specific part
     * @param fragment Fragment
     * @throws URISyntaxException If the URI string constructed from the given components violates
     *             RFC&nbsp;2396
     */
    public URI(String scheme, String ssp, String fragment) throws URISyntaxException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Creates a URI by parsing the given string.
     * <p>
     * This convenience factory method works as if by invoking the {@link #URI(String)} constructor;
     * any {@link URISyntaxException} thrown by the constructor is caught and wrapped in a new
     * {@link IllegalArgumentException} object, which is then thrown.
     * <p>
     * This method is provided for use in situations where it is known that the given string is a
     * legal URI, for example for URI constants declared within in a program, and so it would be
     * considered a programming error for the string not to parse as such. The constructors, which
     * throw {@link URISyntaxException} directly, should be used situations where a URI is being
     * constructed from user input or from some other source that may be prone to errors.
     * </p>
     *
     * @param str The string to be parsed into a URI
     * @return The new URI
     * @throws NullPointerException If {@code str} is {@code null}
     * @throws IllegalArgumentException If the given string violates RFC&nbsp;2396
     */
    public static URI create(String str) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Tells whether or not this URI is absolute.
     * <p>
     * A URI is absolute if, and only if, it has a scheme component.
     * </p>
     *
     * @return {@code true} if, and only if, this URI is absolute
     */
    public boolean isAbsolute() {
        return scheme != null;
    }

    /**
     * Constructs a URL from this URI.
     * <p>
     * This convenience method works as if invoking it were equivalent to evaluating the expression
     * {@code new URL(this.toString())} after first checking that this URI is absolute.
     * </p>
     *
     * @return A URL constructed from this URI
     * @throws IllegalArgumentException If this URL is not absolute
     * @throws MalformedURLException If a protocol handler for the URL could not be found, or if
     *             some other error occurred while constructing the URL
     */
    public URL toURL() throws MalformedURLException {
        if (!isAbsolute()) throw new IllegalArgumentException("URI is not absolute");
        return new URL(toString());
    }
}
