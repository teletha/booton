/*
 * Copyright (C) 2023 The SINOBU Development Team
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          https://opensource.org/licenses/MIT
 */
package kiss;

import static java.lang.Boolean.FALSE;
import static java.time.format.DateTimeFormatter.ISO_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.System.Logger.Level;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

/**
 * <p>
 * Sinobu is not obsolete framework but utility, which can manipulate objects as a
 * extremely-condensed facade.
 * </p>
 * <dl>
 * <dt>Instantiation and Management</dt>
 * <dd>
 * <p>
 * Usually, the container which manages the object uses “get” method to provide such functionality.
 * However, Sinobu uses {@link #make(Class)}. This difference of method name indicates the
 * difference of the way for the management of objects, which also greatly affects the default
 * lifestyle (called Scope in other containers).
 * </p>
 * <p>
 * We do not provides the functionalities related to object lifecycle through Sinobu, because we
 * believe that it is better to use functionalities equipped in Java as much as possible. For
 * example, if you want to receive initialization callbacks, it is better to use constructor.
 * </p>
 * </dd>
 * <dt>Dependency Injection</dt>
 * <dd>
 * <p>
 * Sinobu supports Constructor Injection <em>only</em>. The Constructor Injection is a dependency
 * injection variant where an object gets all its dependencies via the constructor. We can say that
 * there is no possibility that Operation Injection, Field Injection and Interface Injection will be
 * supported in the days to come. This is one of the most important policy in Sinobu. The following
 * is a benefit of Constructor Injection:
 * </p>
 * <ul>
 * <li>It makes a strong dependency contract</li>
 * <li>It makes effective use of constructor in object lifecycle</li>
 * <li>It makes JavaBeans property clean</li>
 * <li>It makes testing easy, since dependencies can be passed in as Mock Object</li>
 * </ul>
 * <p>
 * The following is a deficit of Constructor Injection:
 * </p>
 * <ul>
 * <li>It can't resolve circular dependency</li>
 * </ul>
 * </dd>
 * </dl>
 */
public class JSKiss {

    // Candidates of Method Name
    //
    // annotate accept alert allow approve associate avoid attend affect agree acquire add afford
    // bind bundle
    // create class copy collect config convert
    // delete define deny describe detach dispatch drive drop dub depend die disrupt draw decline
    // edit error ensure examine exclude exist embed enhance enter evolve exchange expect extend
    // enregister
    // find fetch
    // get gain give go grant glance gaze grab garnish
    // hash have handle hold halt hang hasten
    // i18n include infer improve indicate inspire integrate introduce invite identify interpret
    // json join
    // kick know knock keep knot knit
    // locate load log launch lead leave live look list
    // make mock map
    // name note near notice narrow neglect
    // observe opt organize overcome offer order open obtain
    // parse pair plug
    // quiet
    // read refer reject recover retry run register
    // save staple schedule set signal scrape scan
    // transform type take tap task talk transport turn traverse transmit trigger think
    // unload use unite undo
    // vanish view value vouch vary vindicate
    // write warn walk watch wrap wise
    // xml
    // yield
    // zip zoom zone

    /** No Operation */
    public static final WiseRunnable NoOP = new Subscriber()::vandalize;

    /** The default language in this vm environment. */
    public static final Variable<String> Lang = Variable.of(Locale.getDefault().getLanguage());

    /** The user-defined extra log appender. */
    public static WiseTriConsumer<String, Level, CharBuffer> Logger;

    /** The automatic saver references. */
    static final WeakHashMap<Object, Disposable> autosaver = new WeakHashMap();

    /** The circularity dependency graph per thread. */
    static final ThreadLocal<Deque<Class>> dependencies = ThreadLocal.withInitial(ArrayDeque::new);

    /** The logger manager. */
    static final Map<String, Subscriber> logs = new ConcurrentHashMap<>();

    /** In-memory cache for dynamic bundles. */
    static final Map<String, Subscriber> bundles = new ConcurrentHashMap();

    /** Coordinator of bundle save timing */
    static final Signaling<Subscriber> translate = new Signaling();

    /** The parallel task scheduler. */
    static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5, run -> {
        Thread t = new Thread(run);
        t.setName("Sinobu Scheduler");
        t.setDaemon(true);
        return t;
    });

    /** The cache for {@link Lifestyle}. */
    private static final Map<Class, Lifestyle> lifestyles = new ConcurrentHashMap<>();

    /** The definitions of extensions. */
    private static final Map<Class, Ⅱ> extensions = new ConcurrentHashMap<>();

    /** The list of built-in primitive and wrapper classes. */
    private static final Class[] types = {boolean.class, int.class, long.class, float.class, double.class, char.class, byte.class,
            short.class, void.class, Boolean.class, Integer.class, Long.class, Float.class, Double.class, Character.class, Byte.class,
            Short.class, Void.class};

    /** The cached environment variables. */
    private static final Properties env = new Properties();

    // initialization
    static {
        // built-in lifestyles
        lifestyles.put(List.class, ArrayList::new);
        lifestyles.put(Map.class, HashMap::new);
        lifestyles.put(Set.class, HashSet::new);
        lifestyles.put(Locale.class, Locale::getDefault);
    }

    /**
     * Initialize environment.
     */
    private JSKiss() {
    }

    /**
     * Accept any value. Use with method reference.
     * 
     * @return
     */
    public static <A> boolean accept(A a) {
        return true;
    }

    /**
     * Accept any value. Use with method reference.
     * 
     * @return
     */
    public static <A, B> boolean accept(A a, B b) {
        return true;
    }

    /**
     * Creates a new array whose elements are the concatenated elements of the two given arrays.
     * 
     * @param <T> Array element types.
     * @param one Array to be concatenated at the top.
     * @param other Array to be concatenated at the end.
     * @return Newly created array with concatenated elements.
     */
    public static <T> T[] array(T[] one, T... other) {
        if (one == null) return other;
        if (other == null) return one;

        T[] all = Arrays.copyOf(one, one.length + other.length);
        System.arraycopy(other, 0, all, one.length, other.length);
        return all;
    }

    /**
     * Create a new bundled implementation of the interface common to the given objects. Calling a
     * method of the retrieved implementation object will transparently call the same method on all
     * the given objects. In the case of a method with a return value, the result of the last
     * object's call will be used.
     * <p>
     * In situations where the compiler cannot estimate the type of the common interface, use
     * {@link I#bundle(Class, Object...)} instead, which can specify the type.
     * </p>
     * 
     * @param <T> Interface type.
     * @param items A set of objects that implement a common interface.
     * @return A bundled interface.
     * @throws IllegalArgumentException When the compiler cannot estimate the type of the common
     *             interface.
     */
    public static <T> T bundle(T... items) {
        return bundle((Class<T>) items.getClass().getComponentType(), items);
    }

    /**
     * Create a new bundled implementation of the interface common to the given objects. Calling a
     * method of the retrieved implementation object will transparently call the same method on all
     * the given objects. In the case of a method with a return value, the result of the last
     * object's call will be used.
     * 
     * @param <T> Interface type.
     * @param type Specify the common interfaces.
     * @param items A set of objects that implement a common interface.
     * @return A bundled interface.
     */
    public static <T> T bundle(Class<T> type, T... items) {
        return make(type, (proxy, method, args) -> {
            Object result = null;

            if (items != null) for (Object fun : items)
                if (fun != null) {
                    try {
                        result = method.invoke(fun, args);
                    } catch (InvocationTargetException e) {
                        throw e.getCause();
                    }
                }
            return result;
        });
    }

    /**
     * Create a new {@link Collection} to hold the specified items. Basically, the type of the
     * collection should be a real class, but if it is a {@link List} or {@link Set}, the default
     * implementation class ({@link ArrayList} , {@link HashSet}) will be used.
     * 
     * @param <T> Specify the concrete class which implements the {@link Collection}, but the
     *            {@link List} and {@link Set} interfaces may be specified as exceptions.
     * @param <V> The type of the {@link Collection}'s items.
     * @param type A {@link Collection} type.
     * @param items A list of itmes.
     * @return The new created {@link Collection}.
     * @see #list(Object...)
     * @see #set(Object...)
     */
    public static <T extends Collection<V>, V> T collect(Class<T> type, V... items) {
        T collection = I.make(type);

        if (items != null) collection.addAll(Arrays.asList(items));
        return collection;
    }

    /**
     * Copies data from {@link InputStream} to {@link OutputStream}. This method does the data
     * buffering internally, so you do not need to do the buffering explicitly.
     *
     * @param input {@link InputStream} to which data will be read from.
     * @param output {@link OutputStream} to which data will be write to.
     * @param close Whether input and output streams will be closed automatically or not.
     * @throws NullPointerException If the input or output is null.
     */
    public static void copy(InputStream input, OutputStream output, boolean close) {
        try {
            input.transferTo(output);
        } catch (Exception e) {
            throw I.quiet(e);
        } finally {
            if (close) {
                quiet(input);
                quiet(output);
            }
        }
    }

    /**
     * Copies data from {@link Readable} to {@link Appendable}. This method does the data buffering
     * internally, so you do not need to do the buffering explicitly.
     *
     * @param input {@link Readable} to which data will be read from.
     * @param output {@link Appendable} to which data will be write to.
     * @param close Whether input and output streams will be closed automatically or not.
     * @throws NullPointerException If the input or output is null.
     */
    public static void copy(Readable input, Appendable output, boolean close) {
        CharBuffer buffer = CharBuffer.allocate(8192);

        try {
            while (input.read(buffer) != -1) {
                output.append(buffer.flip());
                buffer.clear();
            }
        } catch (Exception e) {
            throw quiet(e);
        } finally {
            if (close) {
                quiet(input);
                quiet(output);
            }
        }
    }

    /**
     * Write {@link java.lang.System.Logger.Level#DEBUG} log.
     * 
     * @param msg A message log.
     */
    public static void debug(Object msg) {
        log("system", msg, 2, 2);
    }

    /**
     * Write {@link java.lang.System.Logger.Level#DEBUG} log.
     * 
     * @param name A logger name.
     * @param msg A message log.
     */
    public static void debug(String name, Object msg) {
        log(name, msg, 2, 2);
    }

    /**
     * Read environment variables based on the following priorities (sources higher in the list take
     * precedence over those located lower).
     * <ol>
     * <li>{@link System#getenv(String)}</li>
     * <li>.env property file in current working directory (optional)</li>
     * <li>.env property file on the classpath (optional)</li>
     * </ol>
     * 
     * @param name A environment variable name.
     * @return The value of the environment variable with the specified name, or <code>null</code>
     *         if it does not exist.
     */
    public static String env(String name) {
        return env.getProperty(name);
    }

    /**
     * Read environment variables based on the following priorities (sources higher in the list take
     * precedence over those located lower). If the environment variable with the specified name
     * does not exist, the value specified as the default value will be set as the new environment
     * variable and used.
     * <ol>
     * <li>{@link System#getenv(String)}</li>
     * <li>.env property file in current working directory (optional)</li>
     * <li>.env property file on the classpath (optional)</li>
     * </ol>
     * 
     * @param name A environment variable name.
     * @param defaults If the specified name is not found, set and return this default value.
     * @return The value of the environment variable with the specified name.
     */
    public static <T> T env(String name, T defaults) {
        T value = I.transform(env.getProperty(name), (Class<T>) defaults.getClass());
        if (value == null) env.setProperty(name, I.transform(value = defaults, String.class));
        return value;
    }

    /**
     * Write {@link java.lang.System.Logger.Level#ERROR} log.
     * 
     * @param msg A message log.
     */
    public static <X extends Object & Supplier<String>> void error(Object msg) {
        log("system", msg, 5, 2);
    }

    /**
     * Write {@link java.lang.System.Logger.Level#ERROR} log.
     * 
     * @param name A logger name.
     * @param msg A message log.
     */
    public static void error(String name, Object msg) {
        log(name, msg, 5, 2);
    }

    /**
     * It is a very simple template engine that can calculate a string that replaces the path of a
     * property names enclosed in "{}" with the actual value of the property. Support
     * <a href="https://mustache.github.io/mustache.5.html">Mustache Syntax</a> partially.
     * 
     * @param text A text with the path of the property names enclosed in "{}".
     * @param contexts A list of context values.
     * @return A calculated text.
     */
    public static String express(String text, Object... contexts) {
        return express(text, "{", "}", contexts, (WiseTriFunction[]) null);
    }

    /**
     * It is a very simple template engine that can calculate a string that replaces the path of a
     * property names enclosed in "{}" with the actual value of the property. Support
     * <a href="https://mustache.github.io/mustache.5.html">Mustache Syntax</a> partially.
     * 
     * @param text A text with the path of the property names enclosed in "{}".
     * @param contexts A list of context values.
     * @return A calculated text.
     */
    public static String express(String text, Object[] contexts, WiseTriFunction<Model, Object, String, Object>... resolvers) {
        return express(text, "{", "}", contexts, resolvers);
    }

    /**
     * It is a very simple template engine that can calculate a string that replaces the path of a
     * property names enclosed in "{}" with the actual value of the property. Support
     * <a href="https://mustache.github.io/mustache.5.html">Mustache Syntax</a> partially.
     * 
     * @param text A text with the path of the property names enclosed in "{}".
     * @param contexts A list of context values.
     * @return A calculated text.
     */
    public static String express(String text, String open, String close, Object[] contexts, WiseTriFunction<Model, Object, String, Object>... resolvers) {
        StringBuilder builder = new StringBuilder();
        int openStart = 0;
        int openEnd = 0;
        int closeStart = 0;
        int closeEnd = 0;

        while ((openStart = text.indexOf(open, closeEnd)) != -1) {
            openEnd = openStart + open.length();
            closeStart = text.indexOf(close, openEnd + 1);

            if (closeStart == -1) {
                break;
            } else {
                builder.append(text, closeEnd, openStart);
                closeEnd = closeStart + close.length();

                // normalize expression (remove all white space) and split it
                String path = text.substring(openEnd, closeStart).strip();
                char type = path.charAt(0);

                // ================================
                // Comment or Plain
                // ================================
                if (type == '!') {
                    if (path.charAt(1) == '!') builder.append(open).append(text, openEnd + 2, closeStart).append(close);
                    continue;
                }

                // ================================
                // Change Delimiter
                // ================================
                if (type == '=') {
                    int on = openEnd;
                    int off = text.indexOf('\n', on) + 1;
                    String[] values = text.substring(on, off).split("[= ]");
                    return builder.append(I.express(text.substring(off), values[1], values[2], contexts, resolvers)).toString();
                }

                // ================================
                // Normal or Inverted Section
                // ================================
                if (type == '#' || type == '^') path = path.substring(1);

                // ================================
                // Resolve Context by Expression
                // ================================
                Object c = null;

                // Optimization : In the case of single-pass, the regular expression-based
                // segmentation process is skipped to speed up the process.
                String[] e = path.indexOf('.') != -1 ? path.split("[\\.\\s　]+") : new String[] {path};

                // Evaluate each context. (first context has high priority)
                if (contexts != null) {
                    resolveContext: for (int i = 0; i < contexts.length; i++) {
                        if ((c = contexts[i]) != null) {
                            // Evaluate expression from head.
                            for (int j = 0; j < e.length; j++) {
                                // Special keyword for the current context
                                if (e[j].equals("this")) continue;

                                // At first, evaluate expression by property resolver
                                Model model = Model.of(c);
                                Object object = model.get(c, model.property(e[j]));

                                // If the expression cannot be evaluated by property resolver,
                                // use the user-defined resolver to try to evaluate the expression.
                                if (object == null && resolvers != null) for (int k = 0; k < resolvers.length; k++) {
                                    if ((object = resolvers[k].apply(model, c, e[j])) != null) break;
                                }

                                // Since all resolvers failed to resolve to a non-null value, we
                                // will try to resolve again in a different context.
                                if ((c = object) == null) continue resolveContext;
                            }

                            // All expression was evaluated correctly, step into next process.
                            break;
                        }
                    }
                }

                // ================================
                // Handle (Normal or Inverted) Section Block
                // ================================
                if (type == '#' || type == '^') {
                    // Trim heading whitespaces. Deletions are combined into a single operation for
                    // performance considerations.
                    int count = 0;
                    while (0 < --openStart && Character.isWhitespace(text.charAt(openStart))) {
                        count++;
                    }
                    builder.delete(builder.length() - count, builder.length());

                    // The following code is very procedural and dirty for optimization.
                    //
                    // Now that the section start tag has been found, we find the corresponding
                    // end tag. We need to calculate the depth in case there is a section with
                    // the same name in this section.
                    int depth = 1;
                    Matcher tag = Pattern
                            .compile("\\r?\\n?\\h*\\Q".concat(open).concat("\\E([#/^])\\Q").concat(path).concat(close).concat("\\E"))
                            .matcher(text.substring(closeEnd));
                    while (tag.find() && (tag.group(1).charAt(0) == '/' ? --depth : ++depth) != 0) {
                    }

                    // Extracts text inside a section tag (from just after the start tag to just
                    // before the end tag).
                    String in = text.substring(closeEnd, closeEnd + tag.start());
                    closeEnd = closeEnd + tag.end();

                    // Processes the text inside a section tag based on the context object.
                    if (type == '^') {
                        if (c == null || c == FALSE || (c instanceof List && ((List) c).isEmpty()) || (c instanceof Map && ((Map) c)
                                .isEmpty()))
                            builder.append(I.express(in, open, close, I.array(new Object[] {c}, contexts), resolvers));
                    } else if (c != null && c != FALSE) {
                        for (Object o : c instanceof List ? (List) c : c instanceof Map ? ((Map) c).values() : List.of(c)) {
                            builder.append(I.express(in, open, close, I.array(new Object[] {o}, contexts), resolvers));
                        }
                    }
                } else {
                    if (c != null) builder.append(I.transform(c, String.class));
                }
            }
        }
        return builder.append(text, closeEnd, text.length()).toString();
    }

    /**
     * <p>
     * Find all <a href="Extensible.html#Extension">Extensions</a> which are specified by the given
     * <a href="Extensible#ExtensionPoint">Extension Point</a>.
     * </p>
     * <p>
     * The returned list will be "safe" in that no references to it are maintained by Sinobu. (In
     * other words, this method must allocate a new list). The caller is thus free to modify the
     * returned list.
     * </p>
     *
     * @param <E> An Extension Point.
     * @param extensionPoint An extension point class. The
     *            <a href="Extensible#ExtensionPoint">Extension Point</a> class is only accepted,
     *            otherwise this method will return empty list.
     * @return All Extensions of the given Extension Point or empty list.
     * @throws NullPointerException If the extension point is null.
     */
    public static <E extends Extensible> List<E> find(Class<E> extensionPoint) {
        return I.signal(findBy(extensionPoint)).flatIterable(Ⅱ::ⅰ).skip(e -> Modifier.isAbstract(e.getModifiers())).map(I::make).toList();
    }

    /**
     * <p>
     * Find the <a href="Extensible.html#Extension">Extension</a> which are specified by the given
     * <a href="Extensible#ExtensionPoint">Extension Point</a> and the given key.
     * </p>
     *
     * @param <E> An Extension Point.
     * @param extensionPoint An Extension Point class. The
     *            <a href="Extensible#ExtensionPoint">Extension Point</a> class is only accepted,
     *            otherwise this method will return <code>null</code>.
     * @param key An <a href="Extensible.html#ExtensionKey">Extension Key</a> class.
     * @return A associated Extension of the given Extension Point and the given Extension Key or
     *         <code>null</code>.
     */
    public static <E extends Extensible> E find(Class<E> extensionPoint, Class key) {
        if (extensionPoint != null && key != null) {
            Ⅱ<List<Class<E>>, Map<Class, Lifestyle<E>>> extensions = findBy(extensionPoint);

            // In the majority of cases, a search query for an extension uses the extension key
            // itself, and rarely a subclass of the extension key is used. Since it is very costly
            // to obtain all types of extension key, we try to save computation resource by
            // performing a searc with the specified extension key at the beginning.
            Lifestyle<E> lifestyle = extensions.ⅱ.get(key);
            if (lifestyle != null) return lifestyle.get();

            // search from extension factory
            if (extensionPoint != ExtensionFactory.class) {
                ExtensionFactory<E> factory = find(ExtensionFactory.class, extensionPoint);
                if (factory != null) return factory.create(key);
            }

            // Since a search query using the extension key itself did not find any extensions, we
            // extend the search by using the ancestor classes and interfaces of the extension key.
            for (Class type : Model.collectTypes(key)) {
                lifestyle = extensions.ⅱ.get(type);

                if (lifestyle != null) return lifestyle.get();
            }
        }
        return null;
    }

    /**
     * <p>
     * Find all <a href="Extensible.html#Extension">Extensions</a> classes which are specified by
     * the given <a href="Extensible#ExtensionPoint">Extension Point</a>.
     * </p>
     * <p>
     * The returned list will be "safe" in that no references to it are maintained by Sinobu. (In
     * other words, this method must allocate a new list). The caller is thus free to modify the
     * returned list.
     * </p>
     *
     * @param <E> An Extension Point.
     * @param extensionPoint An extension point class. The
     *            <a href="Extensible#ExtensionPoint">Extension Point</a> class is only accepted,
     *            otherwise this method will return empty list.
     * @return All Extension classes of the given Extension Point or empty list.
     * @throws NullPointerException If the Extension Point is <code>null</code>.
     */
    public static <E extends Extensible> List<Class<E>> findAs(Class<E> extensionPoint) {
        return new ArrayList(findBy(extensionPoint).ⅰ);
    }

    /**
     * <p>
     * Find the extension definition for the specified extension point.
     * </p>
     * 
     * @param extensionPoint A target extension point.
     * @return A extension definition.
     * @throws NullPointerException If the extension point is null.
     */
    private static <E extends Extensible> Ⅱ<List<Class<E>>, Map<Class, Lifestyle<E>>> findBy(Class<E> extensionPoint) {
        return extensions.computeIfAbsent(extensionPoint, p -> pair(new CopyOnWriteArrayList(), new ConcurrentHashMap()));
    }

    /**
     * Gets the response from the specified URL (including https), converting it to the specified
     * type. Supported types are as follows:
     * <ul>
     * <li>{@link String}</li>
     * <li>{@link InputStream}</li>
     * <li>{@link HttpResponse}</li>
     * <li>{@link XML}</li>
     * <li>{@link JSON}</li>
     * <li>Any types that can be mapped from JSON</li>
     * </ul>
     * <p>
     * It will check the Content-Encoding header and automatically decompress the body if it is
     * compressed with gzip or deflate. HTTP communication by this method is done asynchronously. It
     * is possible to process it synchronously by calling the return value's
     * {@link Signal#waitForTerminate()}.
     * </p>
     * 
     * @param <T> {@link String}, {@link InputStream}, {@link HttpResponse}, {@link XML}, or your
     *            bean class
     * @param request Request URI.
     * @param type Response handler. ({@link String}, {@link InputStream}, {@link HttpResponse},
     *            {@link XML}, or your bean class)
     * @return If the request is successful, the content will be sent. If the request is
     *         unsuccessful, an error will be sent.
     * @throws NullPointerException When one of the arguments is null.
     */
    public static <T> Signal<T> http(String request, Class<T> type, HttpClient... client) {
        return http(HttpRequest.newBuilder(URI.create(request)), type, client);
    }

    /**
     * Gets the response from the specified URL (including https), converting it to the specified
     * type. Supported types are as follows:
     * <ul>
     * <li>{@link String}</li>
     * <li>{@link InputStream}</li>
     * <li>{@link HttpResponse}</li>
     * <li>{@link XML}</li>
     * <li>{@link JSON}</li>
     * <li>Any types that can be mapped from JSON</li>
     * </ul>
     * <p>
     * It will check the Content-Encoding header and automatically decompress the body if it is
     * compressed with gzip or deflate. HTTP communication by this method is done asynchronously. It
     * is possible to process it synchronously by calling the return value's
     * {@link Signal#waitForTerminate()}.
     * </p>
     * 
     * @param <T> {@link String}, {@link InputStream}, {@link HttpResponse}, {@link XML}, or your
     *            bean class
     * @param request Request builder.
     * @param type Response handler. ({@link String}, {@link InputStream}, {@link HttpResponse},
     *            {@link XML}, or your bean class)
     * @return If the request is successful, the content will be sent. If the request is
     *         unsuccessful, an error will be sent.
     * @throws NullPointerException When one of the arguments is null.
     */
    public static <T> Signal<T> http(HttpRequest.Builder request, Class<T> type, HttpClient... client) {
        throw new Error();
    }

    /**
     * Connect to the specified URI by Websocket. The status of the communication is transmitted to
     * {@link Signal}. Once the connection is established, it performs a 'open' callback.
     * 
     * @param uri URI to connect.
     * @param open Called only once, when a connection is established.
     * @return Communication status.
     * @throws NullPointerException if uri or client is null.
     */
    public static Signal<String> http(String uri, Consumer<WebSocket> open, HttpClient... client) {
        throw new Error();
    }

    /**
     * Write {@link java.lang.System.Logger.Level#INFO} log.
     * 
     * @param msg A message log.
     */
    public static void info(Object msg) {
        log("system", msg, 3, 2);
    }

    /**
     * Write {@link java.lang.System.Logger.Level#INFO} log.
     * 
     * @param name A logger name.
     * @param msg A message log.
     */
    public static void info(String name, Object msg) {
        log(name, msg, 3, 2);
    }

    /**
     * Parse the specified JSON format text.
     * 
     * @param input A json format text. <code>null</code> will throw {@link NullPointerException}.
     *            The empty or invalid format data will throw {@link IllegalStateException}.
     * @return A parsed {@link JSON}.
     * @throws NullPointerException If the input data or the root Java object is <code>null</code>.
     * @throws IllegalStateException If the input data is empty or invalid format.
     */
    public static JSON json(String input) {
        try {
            return input.charAt(0) == 'h' ? I.http(input, JSON.class).to().acquire() : new JSON().parse(null, input, null);
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * Parse the specified JSON format text.
     * 
     * @param input A json format text. <code>null</code> will throw {@link NullPointerException}.
     *            The empty or invalid format data will throw {@link IllegalStateException}.
     * @return A parsed {@link JSON}.
     * @throws NullPointerException If the input data or the root Java object is <code>null</code>.
     * @throws IllegalStateException If the input data is empty or invalid format.
     */
    public static <T> T json(String input, Class<T> type) {
        try {
            return new JSON().parse(null, input, type);
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * Parse the specified JSON format text.
     * 
     * @param input A json format text. <code>null</code> will throw {@link NullPointerException}.
     *            The empty or invalid format data will throw {@link IllegalStateException}.
     * @return A parsed {@link JSON}.
     * @throws NullPointerException If the input data or the root Java object is <code>null</code>.
     * @throws IllegalStateException If the input data is empty or invalid format.
     */
    public static JSON json(Path input) {
        try {
            return json(Files.newBufferedReader(input));
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * Parse the specified JSON format text.
     * 
     * @param input A json format text. <code>null</code> will throw {@link NullPointerException}.
     *            The empty or invalid format data will throw {@link IllegalStateException}.
     * @return A parsed {@link JSON}.
     * @throws NullPointerException If the input data or the root Java object is <code>null</code>.
     * @throws IllegalStateException If the input data is empty or invalid format.
     */
    public static JSON json(InputStream input) {
        return json(new InputStreamReader(input, StandardCharsets.UTF_8));
    }

    /**
     * Parse the specified JSON format text.
     * 
     * @param input A json format text. <code>null</code> will throw {@link NullPointerException}.
     *            The empty or invalid format data will throw {@link IllegalStateException}.
     * @return A parsed {@link JSON}.
     * @throws NullPointerException If the input data or the root Java object is <code>null</code>.
     * @throws IllegalStateException If the input data is empty or invalid format.
     */
    public static JSON json(Reader input) {
        return json(input, null);
    }

    /**
     * Parse the specified JSON format text.
     * 
     * @param input A json format text. <code>null</code> will throw {@link NullPointerException}.
     *            The empty or invalid format data will throw {@link IllegalStateException}.
     * @return A parsed {@link JSON}.
     * @throws NullPointerException If the input data or the root Java object is <code>null</code>.
     * @throws IllegalStateException If the input data is empty or invalid format.
     */
    public static <T> T json(Reader input, Class<T> type) {
        try {
            return new JSON().parse(input, null, type);
        } catch (IOException e) {
            throw I.quiet(e);
        } finally {
            I.quiet(input);
        }
    }

    /**
     * Create {@link ArrayList} with the specified items.
     * 
     * @param items A list of itmes.
     * @return The new created {@link ArrayList}.
     */
    public static <V> List<V> list(V... items) {
        return collect(List.class, items);
    }

    /**
     * <p>
     * Load all {@link Extensible} types from the specified source.
     * </p>
     * <p>
     * You can create the special service loader file "META-INF/services/kiss.Extensible" which
     * enumerates pre-scanned class names.
     * </p>
     *
     * @param source A source class to indicate the class set which are loaded.
     * @return Call {@link Disposable#dispose()} to unload the registered extension.
     * @see Extensible
     * @see ExtensionFactory
     * @see #find(Class)
     * @see #find(Class, Class)
     * @see #findAs(Class)
     */
    public static Disposable load(URL source) {
        URLClassLoader loader = URLClassLoader.newInstance(new URL[] {source});
        return load(source, "", loader).add(((WiseRunnable) loader::close)::run);
    }

    /**
     * <p>
     * Load all {@link Extensible} types from the specified source.
     * </p>
     * <p>
     * You can create the special service loader file "META-INF/services/kiss.Extensible" which
     * enumerates pre-scanned class names.
     * </p>
     *
     * @param source A source class to indicate the class set which are loaded.
     * @return Call {@link Disposable#dispose()} to unload the registered extension.
     * @see Extensible
     * @see ExtensionFactory
     * @see #find(Class)
     * @see #find(Class, Class)
     * @see #findAs(Class)
     */
    public static Disposable load(Class source) {
        return load(source.getProtectionDomain().getCodeSource().getLocation(), source.getPackage().getName(), source.getClassLoader());
    }

    /**
     * <p>
     * Load all {@link Extensible} typs from the specified source.
     * </p>
     * <p>
     * You can create the special service loader file "META-INF/services/kiss.Extensible" which
     * enumerates pre-scanned class names.
     * </p>
     *
     * @param source A source class to indicate the class set which are loaded.
     * @return Call {@link Disposable#dispose()} to unload the registered extension.
     * @see Extensible
     * @see ExtensionFactory
     * @see #find(Class)
     * @see #find(Class, Class)
     * @see #findAs(Class)
     */
    @SuppressWarnings("resource")
    private static Disposable load(URL source, String pattern, ClassLoader loader) {
        // =======================================
        // List up extension class names
        // =======================================
        Signal<String> names;

        try {
            // Scan at runtime
            File file = new File(source.toURI());

            if (file.isFile())
                // from jar file
                names = I.signal(new ZipFile(file).entries()::asIterator).map(entry -> entry.getName().replace('/', '.'));
            else {
                // from class directory
                int prefix = file.getPath().length() + 1;
                names = I.signal(file)
                        .recurseMap(entry -> entry.flatArray(File::listFiles))
                        .take(File::isFile)
                        .map(entry -> entry.getPath().substring(prefix).replace(File.separatorChar, '.'));
            }
            names = names.take(name -> name.endsWith(".class")).map(name -> name.substring(0, name.length() - 6));
        } catch (Throwable e) {
            // FALLBACK
            // Read from pre-scanned file "kiss.Extensible" as service provider interface.
            names = I.signal(ServiceLoader.load(Extensible.class).stream()::iterator).map(Provider::type).map(Class::getName);
        }

        // =======================================
        // Register class as extension
        // =======================================
        Disposable disposer = Disposable.empty();

        for (String name : names.toSet())
            // exclude out of the specified package
            if (name.startsWith(pattern)) {
                try {
                    disposer.add(loadE((Class) loader.loadClass(name)));
                } catch (Throwable e) {
                    // ignore
                }
            }
        return disposer;
    }

    /**
     * Load the specified extension, all implemented extension points are recognized automatically.
     * 
     * @param extension A target extension.
     * @return Call {@link Disposable#dispose()} to unload the registered extension.
     */
    static <E extends Extensible> Disposable loadE(Class<E> extension) {
        // fast check : exclude non-initializable class
        if (extension.isEnum() || extension.isAnonymousClass()) return null;

        // slow check : exclude non-extensible class
        if (!Extensible.class.isAssignableFrom(extension)) return null;

        Disposable disposer = Disposable.empty();

        // search and collect information for all extension points
        for (Class<E> extensionPoint : Model.collectTypes(extension))
            if (Arrays.asList(extensionPoint.getInterfaces()).contains(Extensible.class)) {
                // register as new extension
                Ⅱ<List<Class<E>>, Map<Class, Lifestyle<E>>> extensions = findBy(extensionPoint);

                // exclude duplication
                if (extensions.ⅰ.contains(extension)) return null;

                // register extension
                extensions.ⅰ.add(extension);
                disposer.add(() -> extensions.ⅰ.remove(extension));

                // register extension key
                Type[] params = Model.collectParameters(extension, extensionPoint);

                if (params.length != 0 && params[0] != Object.class) {
                    Class clazz = (Class) params[0];

                    // register extension by key
                    disposer.add(load(extensionPoint, clazz, I.makeLifestyle(extension)));

                    // The user has registered a newly custom lifestyle, so we
                    // should update lifestyle for this extension key class.
                    // Normally, when we update some data, it is desirable to store
                    // the previous data to be able to restore it later.
                    // But, in this case, the contextual sensitive instance that
                    // the lifestyle emits changes twice on "load" and "unload"
                    // event from the point of view of the user.
                    // So the previous data becomes all but meaningless for a
                    // cacheable lifestyles (e.g. Singleton and ThreadSpecifiec).
                    // Therefore we we completely refresh lifestyles associated with
                    // this extension key class.
                    if (extensionPoint == Lifestyle.class) {
                        lifestyles.remove(clazz);
                        disposer.add(() -> lifestyles.remove(clazz));
                    }
                }
            }
        return disposer;
    }

    /**
     * Register extension with key.
     * 
     * @param extensionPoint A extension point.
     * @param extensionKey A extension key,
     * @param extension A extension to register.
     * @return A disposer to unregister.
     */
    private static <E extends Extensible> Disposable load(Class<E> extensionPoint, Class extensionKey, Lifestyle<E> extension) {
        findBy(extensionPoint).ⅱ.put(extensionKey, extension);
        return () -> findBy(extensionPoint).ⅱ.remove(extensionKey);
    }

    /** The display name for log level. */
    private static final char[] L = "TRACEDEBUGINFO WARN ERROR".toCharArray();

    /**
     * Generic logging helper.
     * 
     * @param name The logger name.
     * @param msg The actual log message.
     * @param o The log level. {@link Level#ordinal()}
     */
    static void log(String name, Object msg, int o, int deep) {
        // ================================================
        // Look up logger by name
        // ================================================
        Subscriber<Writer> log = logs.computeIfAbsent(name, key -> {
            Subscriber s = new Subscriber();
            s.a = new byte[] {
                    // =================================================
                    // Logger Specific Configuration
                    // =================================================
                    // It is possible to reflect user settings by delaying the reading of settings
                    // until the stage of actual logger use.

                    // Determines the level at which the caller information is used.
                    (byte) I.env(key.concat(".caller"), I.env("*.caller", Level.OFF)).ordinal(),

                    // Determines the level at which the file output is used.
                    (byte) I.env(key.concat(".file"), I.env("*.file", Level.INFO)).ordinal(),

                    // Determines the level at which the console output is used.
                    (byte) I.env(key.concat(".console"), I.env("*.console", Level.INFO)).ordinal(),

                    // Determines the level at which the user-defined extra output is used.
                    (byte) I.env(key.concat(".extra"), I.env("*.extra", Level.OFF)).ordinal()

                    // =================================================
            };
            return s;
        });

        // ================================================
        // Discard by logger's level
        // ================================================
        if (log.a[1] <= o || log.a[2] <= o || (log.a[3] <= o && Logger != null)) synchronized (log) {
            long ms = System.currentTimeMillis();

            try {
                if (log.index <= ms) {
                    // As a new day begins, we will refresh the data for each day that can be
                    // reused.
                    LocalDateTime day = LocalDate.now().atStartOfDay();

                    // Set the next update time.
                    log.index = (day.atZone(ZoneId.systemDefault()).toEpochSecond() + 3600 * 24) * 1000;

                    // Reuse all parts that use the same characters each time. Dates and
                    // separators are the same throughout the day, so generate them first and
                    // reuse them thereafter.
                    log.chars = CharBuffer.allocate(1024 * 24).put(day.format(ISO_LOCAL_DATE_TIME)).put(".000 DEBUG\t");

                    // Replace the output destination file at the timing of the date change.
                    if (log.a[1] <= o) {
                        // stop old file
                        if (log.obj != null) I.quiet(log.obj);

                        // create log directory
                        File dir = new File(I.env(name.concat(".dir"), I.env("*.dir", ".log")));
                        dir.mkdirs();

                        // The file output destination will be rotated daily. It will
                        // always be cached in an open state.
                        log.obj = new FileWriter(new File(dir, name.concat(day.format(ISO_DATE)).concat(".log")), env(name
                                .concat(".append"), env("*.append", true)));

                        // We also tried the following code to see if it would make a difference
                        // in writing speed, but no significant difference was observed, so no
                        // buffering is performed in writing. In the implementation of
                        // OutputStreamWriter, buffering is performed upon character encoding
                        // conversion, so it is not expected to make a big difference.
                        //
                        // new_OutputStreamWriter(new_BufferedOutputStream(new_FileOutputStream(new_File(name))));

                        // Old files should be deleted.
                        int i = I.env(name.concat(".rotate"), I.env("*.rotate", 90));
                        while (0 < i && (new File(dir, name.concat(day.minusDays(i++).format(ISO_DATE)).concat(".log"))
                                .delete() || i < 120)) {
                        }
                    }
                }

                // ================================================
                // Format log message
                // ================================================
                // The date and time part (YYYY-MM-ddTHH:mm:ss.SSS ) is reusable
                log.chars.clear().position(24);

                // Time - If the time is the same as the last time, the previous data will
                // be used as is to speed up the process.
                if (log.time != ms) {
                    log.time = ms;

                    // If you use DateTimeFormatter or SimpleDateFormatter, it creates an
                    // extra instances, so we parse and format the time ourselves to keep it
                    // garbage-free.
                    int m, time = (int) (ms - (log.index - 24 * 60 * 60 * 1000));

                    // Hour
                    log.chars.put(11, (char) ('0' + (m = time / (3600 * 1000)) / 10))
                            .put(12, (char) ('0' + m % 10))

                            // Minute
                            .put(14, (char) ('0' + (m = time / (60 * 1000) % 60) / 10))
                            .put(15, (char) ('0' + m % 10))

                            // Second
                            .put(17, (char) ('0' + (m = time / 1000 % 60) / 10))
                            .put(18, (char) ('0' + m % 10))

                            // Millisecond
                            .put(20, (char) ('0' + time % 1000 / 100))
                            .put(21, (char) ('0' + time % 100 / 10))
                            .put(22, (char) ('0' + time % 10));

                    // Since flushing the log to disk every time would overload IO, we decided
                    // to write the log only when the time changes.
                    //
                    // In order to reduce the footprint, we are reusing a variable to determine
                    // if we need to flush to disk.
                    ms = 0;
                }

                // Level & Message
                if (msg instanceof Supplier) msg = ((Supplier) msg).get();
                log.chars.put(L, (o - 1) * 5, 5).position(30).put(String.valueOf(msg));

                // Caller Location
                if (log.a[0] <= o) {
                    // Since javac (JDK16) doesn't infer it correctly, we'll put the
                    // toString method out there to make the type explicit, although it
                    // increases the footprint slightly.
                    log.chars.put("\tat ").put(StackWalker.getInstance().walk(s -> s.skip(deep).findAny().get()).toString());
                }

                // Cause
                if (msg instanceof Throwable) for (StackTraceElement s : ((Throwable) msg).getStackTrace()) {
                    log.chars.put("\n\tat ").put(s.toString());
                }

                // Line Feed
                log.chars.put('\n').flip();

                // ================================================
                // Output log
                // ================================================
                if (log.a[1] <= o) {
                    log.obj.append(log.chars);
                    if (ms == 0) log.obj.flush();
                }
                if (log.a[2] <= o) System.out.print(log.chars);
                if (log.a[3] <= o && Logger != null) Logger.ACCEPT(name, Level.values()[o], log.chars);
            } catch (Throwable x) {
                // ignore
            }
        }
    }

    /**
     * <p>
     * Returns a new or cached instance of the model class.
     * </p>
     * <p>
     * This method supports the top-level class and the member type. If the local class or the
     * anonymous class is passed to this argument, {@link UnsupportedOperationException} will be
     * thrown. There is a possibility that a part of this limitation will be removed in the future.
     * </p>
     *
     * @param <T> A model type.
     * @param modelClass A target class to create instance.
     * @return A instance of the specified model class. This instance is managed by Sinobu.
     * @throws NullPointerException If the model class is <code>null</code>.
     * @throws IllegalArgumentException If the model class is non-accessible or final class.
     * @throws UnsupportedOperationException If the model class is inner-class.
     * @throws ClassCircularityError If the model has circular dependency.
     */
    public static <T> T make(Class<? extends T> modelClass) {
        return makeLifestyle(modelClass).get();
    }

    /**
     * Create proxy instance.
     * 
     * @param type A model type.
     * @param handler A proxy handler.
     * @return
     * @throws NullPointerException Any parameter is null.
     */
    public static <T> T make(Class<T> type, InvocationHandler handler) {
        // no need to check null explicitly
        // Objects.requireNonNull(type);
        // Objects.requireNonNull(handler);

        // check null (type : implicitly) (handler : in Proxy#newProxyInstance)
        if (type.isInterface() == false) throw new IllegalArgumentException("Type must be interface.");
        return (T) Proxy.newProxyInstance(I.class.getClassLoader(), new Class[] {type}, handler);
    }

    /**
     * Create wise function interface.
     * 
     * @param o
     * @param target
     * @param handler
     * @return
     */
    static <F> F make(Object o, Class target, Wise handler) {
        Type type = o == null ? target : Model.collectParameters(o.getClass().getInterfaces()[0], target)[0];

        if (type instanceof ParameterizedType) type = ((ParameterizedType) type).getRawType();

        if (type == WiseRunnable.class) {
            return (F) (WiseRunnable) handler::invoke;
        } else if (type == WiseSupplier.class) {
            return (F) (WiseSupplier) handler::invoke;
        } else if (type == WiseConsumer.class) {
            return (F) (WiseConsumer) handler::invoke;
        } else if (type == WiseFunction.class) {
            return (F) (WiseFunction) handler::invoke;
        } else if (type == WiseBiConsumer.class) {
            return (F) (WiseBiConsumer) handler::invoke;
        } else if (type == WiseBiFunction.class) {
            return (F) (WiseBiFunction) handler::invoke;
        } else if (type == WiseTriConsumer.class) {
            return (F) (WiseTriConsumer) handler::invoke;
        } else {
            return (F) (WiseTriFunction) handler::invoke;
        }
    }

    /**
     * <p>
     * Returns a new or cached instance of the model class.
     * </p>
     * <p>
     * This method supports the top-level class and the member type. If the local class or the
     * anonymous class is passed to this argument, {@link UnsupportedOperationException} will be
     * thrown. There is a possibility that a part of this limitation will be removed in the future.
     * </p>
     *
     * @param <M> A model class.
     * @return A instance of the specified model class. This instance is managed by Sinobu.
     * @throws NullPointerException If the model class is <code>null</code>.
     * @throws IllegalArgumentException If the model class is non-accessible or final class.
     * @throws UnsupportedOperationException If the model class is anonymous-class.
     * @throws ClassCircularityError If the model has circular dependency.
     */
    static <M> Lifestyle<M> makeLifestyle(Class<M> modelClass) {
        // Skip null check because this method can throw NullPointerException.
        // if (modelClass == null) throw new NullPointerException("NPE");

        // At first, we must confirm the cached lifestyle associated with the model class. If
        // there is no such cache, we will try to create newly lifestyle.
        Lifestyle<M> lifestyle = lifestyles.get(modelClass);

        if (lifestyle != null) return lifestyle; // use cache

        // Skip null check because this method can throw NullPointerException.
        // if (modelClass == null) throw new NullPointerException("NPE");

        // The model class have some preconditions to have to meet.
        if (modelClass.isAnonymousClass()) throw new UnsupportedOperationException(modelClass + " is  inner class.");

        // Construct dependency graph for the current thraed.
        Deque<Class> dependency = dependencies.get();
        dependency.add(modelClass);

        try {
            // At first, we should search the associated lifestyle from extension points.
            lifestyle = find(Lifestyle.class, modelClass);

            // Then, check its Managed annotation.
            if (lifestyle == null) {
                // If the actual model class doesn't provide its lifestyle explicitly, we use
                // Prototype lifestyle which is default lifestyle in Sinobu.
                Managed managed = modelClass.getAnnotation(Managed.class);

                // Create new lifestyle for the actual model class
                lifestyle = managed == null || managed.value() == Lifestyle.class ? I.prototype(modelClass) : I.make(managed.value());
            }

            if (lifestyles.containsKey(modelClass)) {
                return lifestyles.get(modelClass);
            } else {
                lifestyles.put(modelClass, lifestyle);
                return lifestyle;
            }
        } finally {
            dependency.pollLast();
        }
    }

    /**
     * Create value set.
     *
     * @param param1 A first parameter.
     * @param param2 A second parameter.
     * @return
     */
    public static <A, B> Ⅱ<A, B> pair(A param1, B param2) {
        return new Ⅱ(param1, param2);
    }

    /**
     * Create value set.
     *
     * @param param1 A first parameter.
     * @param param2 A second parameter.
     * @param param3 A third parameter.
     * @return
     */
    public static <A, B, C> Ⅲ<A, B, C> pair(A param1, B param2, C param3) {
        return new Ⅲ(param1, param2, param3);
    }

    /**
     * Build prototype-like {@link Lifestyle} that creates a new instance every time demanded. This
     * is default lifestyle in Sinobu.
     * <p>
     * The created {@link Lifestyle} has the functionality of Dependency Injection. The Lifestyle
     * attempts to create an instance using the first constructor declared with the fewest number of
     * arguments. If the argument contains a {@link Managed} type, an instance of that type will
     * also be created automatically. This dependency injection is done at the same time when the
     * model is instantiated. But if you want to delay the creation of the dependency until it is
     * needed, you can set the argument type to Lifestyle<DEPENDENCY_TYPE>.
     * <p>
     * You may also specify a {@link Class} type as an argument if you need the currently processing
     * model type. This feature is mainly available when implementing the special generic
     * {@link Lifestyle}.
     * 
     * @param <M> A {@link Managed} class.
     * @param model A model type.
     * @return A built {@link Lifestyle} that creates a new instance every time demanded.
     * @see Singleton
     */
    public static <M> Lifestyle<M> prototype(Class<M> model) {
        // find default constructor as instantiator
        Constructor constructor = Model.collectConstructors(model)[0];
        constructor.setAccessible(true);

        Class[] types = constructor.getParameterTypes();

        return () -> {
            // constructor injection
            Object[] params = null;

            // We should use lazy initialization of parameter array to avoid that the constructor
            // without parameters doesn't create futile array instance.
            if (types.length != 0) {
                params = new Object[types.length];

                for (int i = 0; i < params.length; i++) {
                    if (types[i] == Lifestyle.class) {
                        params[i] = I.makeLifestyle((Class) Model
                                .collectParameters(constructor.getGenericParameterTypes()[i], Lifestyle.class)[0]);
                    } else if (types[i] == Class.class) {
                        params[i] = I.dependencies.get().peekLast();
                    } else if (types[i].isPrimitive()) {
                        params[i] = Array.get(Array.newInstance(types[i], 1), 0);
                    } else {
                        params[i] = I.make(types[i]);
                    }
                }
            }
            // create new instance
            return (M) constructor.newInstance(params);
        };
    }

    /**
     * <p>
     * Close the specified object quietly if it is {@link AutoCloseable}. Equivalent to
     * {@link AutoCloseable#close()}, except any exceptions will be ignored. This is typically used
     * in finally block like the following.
     * </p>
     * <p>
     * <pre>
     * AutoCloseable input = null;
     *
     * try {
     *     // some IO action
     * } catch (Exception e) {
     *     throw e;
     * } finally {
     *     I.quiet(input);
     * }
     * </pre>
     * <p>
     * Throw the specified checked exception quietly or close the specified {@link AutoCloseable}
     * object quietly.
     * </p>
     * <p>
     * This method <em>doesn't</em> wrap checked exception around unchecked exception (e.g. new
     * RuntimeException(e)) and <em>doesn't</em> shelve it. This method deceive the compiler that
     * the checked exception is unchecked one. So you can catch a raw checked exception in the
     * caller of the method which calls this method.
     * </p>
     * <p>
     * <pre>
     * private void callerWithoutErrorHandling() {
     *     methodQuietly();
     * }
     *
     * private void callerWithErrorHandling() {
     *     try {
     *         methodQuietly();
     *     } catch (Exception e) {
     *         // you can catch the checked exception here
     *     }
     * }
     *
     * private void methodQuietly() {
     *     try {
     *         // throw some cheched exception
     *     } catch (CheckedException e) {
     *         throw I.quiet(e); // rethrow checked exception quietly
     *     }
     * }
     * </pre>
     *
     * @param object A exception to throw quietly or a object to close quietly.
     * @return A pseudo unchecked exception.
     * @throws NullPointerException If the specified exception is <code>null</code>.
     */
    public static RuntimeException quiet(Object object) {
        if (object instanceof Throwable) {
            Throwable throwable = (Throwable) object;

            // retrieve original exception from the specified wrapped exception
            if (throwable instanceof InvocationTargetException) throwable = throwable.getCause();

            // throw quietly
            return I.<RuntimeException> quiet(throwable);
        }

        if (object instanceof AutoCloseable) {
            try {
                ((AutoCloseable) object).close();
            } catch (Exception e) {
                throw quiet(e);
            }
        }

        // API definition
        return null;
    }

    /**
     * Deceive complier that the specified checked exception is unchecked exception.
     *
     * @param <T> A dummy type for {@link RuntimeException}.
     * @param throwable Any error.
     * @return A runtime error.
     * @throws T Dummy error to deceive compiler.
     */
    private static <T extends Throwable> T quiet(Throwable throwable) throws T {
        throw (T) throwable;
    }

    /**
     * <p>
     * Define recursive {@link BiConsumer}.
     * </p>
     * <pre>
     * I.recurse((self, param1, param2) -> {
     *     // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <A, B> WiseBiConsumer<A, B> recurse(WiseTriConsumer<WiseBiConsumer<A, B>, A, B> function) {
        Variable<WiseBiConsumer<A, B>> ref = Variable.empty();
        ref.set(function.bindLazily(ref));
        return ref.v;
    }

    /**
     * <p>
     * Define recursive {@link BiFunction}.
     * </p>
     * <pre>
     * I.recurse((self, param1, param2) -> {
     *     // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <A, B, R> WiseBiFunction<A, B, R> recurse(WiseTriFunction<WiseBiFunction<A, B, R>, A, B, R> function) {
        Variable<WiseBiFunction<A, B, R>> ref = Variable.empty();
        ref.set(function.bindLazily(ref));
        return ref.v;
    }

    /**
     * <p>
     * Define recursive {@link Consumer}.
     * </p>
     * <pre>
     * I.recurse((self, param) -> {
     *     // your function code
     * });
     * </pre>
     * 
     * @param function A target function to convert.
     * @return A converted recursive function.
     */
    public static <A> WiseConsumer<A> recurse(WiseBiConsumer<WiseConsumer<A>, A> function) {
        Variable<WiseConsumer<A>> ref = Variable.empty();
        ref.set(function.bindLazily(ref));
        return ref.v;
    }

    /**
     * <p>
     * Define recursive {@link Function}.
     * </p>
     * <pre>
     * I.recurse((self, param) -> {
     *     // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <A, R> WiseFunction<A, R> recurse(WiseBiFunction<WiseFunction<A, R>, A, R> function) {
        Variable<WiseFunction<A, R>> ref = Variable.empty();
        ref.set(function.bindLazily(ref));
        return ref.v;
    }

    /**
     * <p>
     * Define recursive {@link Runnable}.
     * </p>
     * <pre>
     * I.recurse(self -> {
     *     // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static WiseRunnable recurse(WiseConsumer<WiseRunnable> function) {
        Variable<WiseRunnable> ref = Variable.empty();
        ref.set(function.bindLazily(ref));
        return ref.v;
    }

    /**
     * <p>
     * Define recursive {@link Supplier}.
     * </p>
     * <pre>
     * I.recurse(self -> {
     *     // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <R> WiseSupplier<R> recurse(WiseFunction<WiseSupplier<R>, R> function) {
        Variable<WiseSupplier<R>> ref = Variable.empty();
        ref.set(function.bindLazily(ref));
        return ref.v;
    }

    /**
     * Reject any value. Use with method reference.
     * 
     * @return
     */
    public static <A> boolean reject(A a) {
        return false;
    }

    /**
     * Reject any value. Use with method reference.
     * 
     * @return
     */
    public static <A, B> boolean reject(A a, B b) {
        return false;
    }

    /**
     * Execute the specified task in the sinobu managed background thread pool.
     *
     * @param task A task to execute.
     * @return A result of the executing task.
     * @see #schedule(long, TimeUnit, ScheduledExecutorService...)
     * @see #schedule(long, long, TimeUnit, boolean, ScheduledExecutorService...)
     */
    public static CompletableFuture<?> schedule(Runnable task) {
        return CompletableFuture.runAsync(task, scheduler);
    }

    /**
     * Returns an {@link Signal} that emits long value (1) after the delay time.
     *
     * @param delayTime The delay time to wait before emitting the first value of 1L
     * @param unit The time unit for delay time
     * @param scheduler The task scheduler.
     * @return {@link Signal} that emits long value (1) after the delay time
     */
    public static Signal<Long> schedule(long delayTime, TimeUnit unit, ScheduledExecutorService... scheduler) {
        return schedule(delayTime, -1, unit, false, scheduler).take(1);
    }

    /**
     * Returns an {@link Signal} that emits long value (1) after the delay time and ever increasing
     * numbers after each interval time of time thereafter.
     * 
     * @param delayTime The initial delay time to wait before emitting the first value of 1L
     * @param intervalTime The period of time between emissions of the subsequent numbers
     * @param unit the time unit for both delay time and interval time
     * @return {@link Signal} that emits long value (1) after the delay time and ever increasing
     *         numbers after each interval time of time thereafter
     */
    public static Signal<Long> schedule(long delayTime, long intervalTime, TimeUnit unit, boolean fixedRate, ScheduledExecutorService... scheduler) {
        return schedule(() -> delayTime, intervalTime, unit, fixedRate, scheduler);
    }

    /**
     * Create a time-based periodic executable scheduler. It will be executed at regular intervals
     * starting from a specified base time. (For example, if the base time is 00:05 and the interval
     * is 30 minutes, the actual execution time will be 00:05, 00:30, 01:05, 01:35, and so on.
     * 
     * @param time The base time.
     * @param interval The period of time between emissions of the subsequent numbers
     * @param unit The interval time unit.
     * @param scheduler The task scheduler.
     * @return {@link Signal} that emits long value (1) at the time and ever increasing numbers
     *         after each interval of time thereafter
     */
    public static Signal<Long> schedule(LocalTime time, long interval, TimeUnit unit, ScheduledExecutorService... scheduler) {
        return schedule(() -> {
            long now = System.currentTimeMillis();
            long start = now / 86400000 * 86400000 + time.toNanoOfDay() / 1000000;
            while (start < now) {
                start += unit.toMillis(interval);
            }
            return start - now;
        }, unit.toMillis(interval), TimeUnit.MILLISECONDS, true, scheduler);
    }

    /**
     * Returns an {@link Signal} that emits long value (1) after the delay time and ever increasing
     * numbers after each interval time of time thereafter.
     * 
     * @param delayTime The initial delay time to wait before emitting the first value of 1L
     * @param intervalTime The period of time between emissions of the subsequent numbers
     * @param unit the time unit for both delay time and interval time
     * @return {@link Signal} that emits long value (1) after the delay time and ever increasing
     *         numbers after each interval time of time thereafter
     */
    private static Signal<Long> schedule(LongSupplier delayTime, long intervalTime, TimeUnit unit, boolean fixedRate, ScheduledExecutorService... scheduler) {
        Objects.requireNonNull(unit);

        return new Signal<>((observer, disposer) -> {
            long delay = delayTime.getAsLong();
            Runnable task = I.wiseC(observer).bindLast(null);
            Future future;

            @SuppressWarnings("resource")
            ScheduledExecutorService exe = scheduler == null || scheduler.length == 0 || scheduler[0] == null ? I.scheduler : scheduler[0];

            if (intervalTime <= 0) {
                future = delay <= 0 ? CompletableFuture.runAsync(task, Runnable::run) : exe.schedule(task, delay, unit);
            } else if (fixedRate) {
                future = exe.scheduleAtFixedRate(task, delay, intervalTime, unit);
            } else {
                future = exe.scheduleWithFixedDelay(task, delay, intervalTime, unit);
            }
            return disposer.add(future);
        }).count();
    }

    /**
     * Create {@link HashSet} with the specified items.
     * 
     * @param items A list of itmes.
     * @return The new created {@link HashSet}.
     */
    public static <V> Set<V> set(V... items) {
        return collect(Set.class, items);
    }

    /**
     * Signal the specified values.
     *
     * @param values A list of values to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    public static <V> Signal<V> signal(V... values) {
        return new Signal<V>((observer, disposer) -> {
            if (!disposer.isDisposed()) observer.complete();
            return disposer;
        }).startWith(values);
    }

    /**
     * Signal the specified values.
     *
     * @param values A list of values to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    public static <V> Signal<V> signal(Iterable<V> values) {
        return I.signal((V[]) null).startWith(values);
    }

    /**
     * {@link Signal} the specified values.
     *
     * @param value A value to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    public static <V> Signal<V> signal(Supplier<V> value) {
        return I.signal((V[]) null).startWith(value);
    }

    /**
     * Returns an {@link Signal} that invokes an {@link Observer#error(Throwable)} method when the
     * {@link Observer} subscribes to it.
     *
     * @param error An error to emit.
     * @return The {@link Signal} to emit error.
     */
    public static <V> Signal<V> signalError(Throwable error) {
        return new Signal<V>((observer, disposer) -> {
            observer.error(error);
            return disposer;
        });
    }

    /**
     * Write {@link java.lang.System.Logger.Level#TRACE} log.
     * 
     * @param msg A message log.
     */
    public static void trace(Object msg) {
        log("system", msg, 1, 2);
    }

    /**
     * Write {@link java.lang.System.Logger.Level#TRACE} log.
     * 
     * @param name A logger name.
     * @param msg A message log.
     */
    public static void trace(String name, Object msg) {
        log(name, msg, 1, 2);
    }

    /**
     * Transform any type object into the specified type if possible.
     *
     * @param <In> A input type you want to transform from.
     * @param <Out> An output type you want to transform into.
     * @param input A target object.
     * @param output A target type.
     * @return A transformed object.
     * @throws NullPointerException If the output type is <code>null</code>.
     */
    public static <In, Out> Out transform(In input, Class<Out> output) {
        if (input == null) return null;

        String encoded = input instanceof String ? (String) input : find(Encoder.class, input.getClass()).encode(input);

        if (output == String.class) return (Out) encoded;

        // support abstract enum
        if (output.isAnonymousClass()) {
            Class parent = output.getEnclosingClass();
            if (parent.isEnum()) output = parent;
        }

        Decoder<Out> out = I.find(Decoder.class, output);
        return out == null ? I.make(output) : out.decode(encoded);
    }

    /**
     * The text will be automatically translated. Basic sentences must be written in English. It
     * will be translated online automatically into the language specified in the global variable
     * {@link #Lang}. Once the text is translated, it is saved to the local disk and loaded from
     * there in the future.
     * 
     * @param text Basic English sentences.
     * @param context Parameters to be assigned to variables in a sentence. (Optional)
     */
    public static Variable<String> translate(String text, Object... context) {
        throw new Error();
    }

    /**
     * Find the class by the specified fully qualified class name.
     *
     * @param fqcn A fully qualified class name to want.
     * @return The specified class.
     */
    public static Class type(String fqcn) {
        if (fqcn.indexOf('.') == -1) for (int i = 0; i < 9; i++) {
            if (types[i].getName().equals(fqcn)) return types[i];
        }

        try {
            return Class.forName(fqcn, false, ClassLoader.getSystemClassLoader());
        } catch (ClassNotFoundException e) {
            throw I.quiet(e);
        }
    }

    /**
     * Write {@link java.lang.System.Logger.Level#WARNING} log.
     * 
     * @param msg A message log.
     */
    public static void warn(Object msg) {
        log("system", msg, 4, 2);
    }

    /**
     * Write {@link java.lang.System.Logger.Level#WARNING} log.
     * 
     * @param name A logger name.
     * @param msg A message log.
     */
    public static void warn(String name, Object msg) {
        log(name, msg, 4, 2);
    }

    /**
     * Cast from {@link Runnable} to {@link WiseRunnable}.
     * 
     * @param lambda A target function.
     * @return A casted function.
     */
    public static WiseRunnable wiseR(Runnable lambda) {
        return lambda instanceof WiseRunnable ? (WiseRunnable) lambda : lambda::run;
    }

    /**
     * Cast from {@link Consumer} to {@link WiseConsumer}.
     * 
     * @param lambda A target function.
     * @return A casted function.
     */
    public static <A> WiseConsumer<A> wiseC(Consumer<A> lambda) {
        return lambda instanceof WiseConsumer ? (WiseConsumer) lambda : lambda::accept;
    }

    /**
     * Cast from {@link Runnable} to {@link WiseConsumer}. All missing parameters will be added on
     * the right side. All additional caller arguments are ignored.
     * 
     * @param lambda A target function.
     * @return A casted function.
     */
    public static <A> WiseConsumer<A> wiseC(Runnable lambda) {
        return make(null, WiseConsumer.class, I.wiseR(lambda));
    }

    /**
     * Cast from {@link Supplier} to {@link WiseSupplier}.
     * 
     * @param lambda A target function.
     * @return A casted function.
     */
    public static <R> WiseSupplier<R> wiseS(Supplier<R> lambda) {
        return lambda instanceof WiseSupplier ? (WiseSupplier) lambda : lambda::get;
    }

    /**
     * Create {@link WiseSupplier} which always return the specified value.
     * 
     * @param constant The fixed return value.
     * @return A created function.
     */
    public static <R> WiseSupplier<R> wiseS(R constant) {
        return wiseS(Variable.of(constant));
    }

    /**
     * Cast from {@link Function} to {@link WiseFunction}.
     * 
     * @param lambda A target function.
     * @return A casted function.
     */
    public static <A, R> WiseFunction<A, R> wiseF(Function<A, R> lambda) {
        return lambda instanceof WiseFunction ? (WiseFunction) lambda : lambda::apply;
    }

    /**
     * Cast from {@link Supplier} to {@link WiseFunction}. All missing parameters will be added on
     * the right side. All additional caller arguments are ignored.
     * 
     * @param lambda A target function.
     * @return A casted function.
     */
    public static <A, R> WiseFunction<A, R> wiseF(Supplier<R> lambda) {
        return make(null, WiseFunction.class, I.wiseS(lambda));
    }

    /**
     * Create {@link WiseFunction} which always return the specified value.
     * 
     * @param constant The fixed return value.
     * @return A created function.
     */
    public static <A, R> WiseFunction<A, R> wiseF(R constant) {
        return wiseF(Variable.of(constant));
    }

    /**
     * Return a non-primitive {@link Class} of the specified {@link Class} object. <code>null</code>
     * will be return <code>null</code>.
     *
     * @param type A {@link Class} object to convert to non-primitive class.
     * @return A non-primitive {@link Class} object.
     * @throws NullPointerException Parameter type is null.
     */
    public static Class wrap(Class type) {
        if (type.isPrimitive()) for (int i = 0; i < 9; i++) {
            if (types[i] == type) return types[i + 9];
        }
        return type;
    }

    /**
     * Write JSON representation of Java object.
     *
     * @param input A Java object. All properties will be serialized deeply. <code>null</code> will
     *            throw {@link java.lang.NullPointerException}.
     * @return A JSON representation of Java object.
     * @throws NullPointerException If the input Java object or the output is <code>null</code> .
     */
    public static String write(Object input) {
        StringBuilder output = new StringBuilder();
        I.write(input, output);
        return output.toString();
    }

    /**
     * <p>
     * Write JSON representation of Java object to the specified output.
     * </p>
     * <p>
     * If the output object implements {@link AutoCloseable}, {@link AutoCloseable#close()} method
     * will be invoked certainly.
     * </p>
     *
     * @param input A Java object. All properties will be serialized deeply. <code>null</code> will
     *            throw {@link java.lang.NullPointerException}.
     * @param out A serialized data output. <code>null</code> will throw
     *            {@link NullPointerException}.
     * @throws NullPointerException If the input Java object or the output is <code>null</code> .
     */
    public static void write(Object input, Appendable out) {
        Objects.requireNonNull(out);

        try {
            // traverse object as json
            Model model = Model.of(input);
            new JSON(out).write(model, new Property(model, "", null), input);
        } finally {
            // close carefuly
            I.quiet(out);
        }
    }
}