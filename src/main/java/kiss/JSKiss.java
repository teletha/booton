/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import static js.lang.Global.*;

import java.lang.annotation.Annotation;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptException;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.MapProperty;
import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

import booton.translator.JavaAPIProvider;
import js.lang.Global;
import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeFunction.Delegator;
import js.lang.NativeObject;
import js.lang.reflect.Reflections;
import kiss.model.ClassUtil;
import kiss.model.Model;
import kiss.model.Property;
import kiss.model.PropertyWalker;

/**
 * @version 2013/08/02 12:39:06
 */
@JavaAPIProvider(I.class)
class JSKiss {

    public static ScheduledExecutorService $scheduler = Executors.newScheduledThreadPool(1);

    /** The cache for Module, Model and Lifestyle. */
    static final Modules modules = new Modules();

    /** The mapping from extension point to extensions. */
    private static Table<Class, Class> extensions;

    /** The mapping from extension point to assosiated extension mapping. */
    private static final Table<String, Class> keys = new Table();

    /** The circularity dependency graph per thread. */
    static final ThreadSpecific<Deque<Class>> dependencies = new ThreadSpecific(ArrayDeque.class);

    /** The cache between Model and Lifestyle. */
    private static final ConcurrentHashMap<Class, Lifestyle> lifestyles = new ConcurrentHashMap();

    /** The task manager. */
    private static final ScheduledExecutorService parallel = Executors.newScheduledThreadPool(4);

    static {
        // built-in lifestyles
        lifestyles.put(List.class, new Prototype(ArrayList.class));
        lifestyles.put(Map.class, new Prototype(HashMap.class));
        lifestyles.put(Prototype.class, new Prototype(Prototype.class));
        lifestyles.put(ListProperty.class, () -> {
            return new SimpleListProperty(FXCollections.observableArrayList());
        });
        lifestyles.put(ObservableList.class, FXCollections::observableArrayList);
        lifestyles.put(MapProperty.class, () -> {
            return new SimpleMapProperty(FXCollections.observableHashMap());
        });
        lifestyles.put(ObservableMap.class, FXCollections::observableHashMap);
        lifestyles.put(SetProperty.class, () -> {
            return new SimpleSetProperty(FXCollections.observableSet());
        });
        lifestyles.put(ObservableSet.class, FXCollections::observableSet);
        lifestyles.put(Locale.class, () -> Locale.getDefault());
    }

    /**
     * <p>
     * Make the {@link Map} which has {@link Class} key be recognized to the module unloading event
     * and disposes the key which is associated with the module automatically.
     * </p>
     * <p>
     * This method has same syntax of {@link Collections#synchronizedMap(Map)}.
     * </p>
     * 
     * @param map A target {@link Map} object to be aware of module unloading event.
     * @return The given {@link Map} object.
     */
    public static <M extends Map<Class, ?>> M aware(M map) {
        return map;
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
     * @throws NullPointerException If the Extension Point is <code>null</code>.
     */
    public static <E extends Extensible> List<E> find(Class<E> extensionPoint) {
        initialize();

        // Skip null check because this method can throw NullPointerException.
        List<Class> classes = extensions.get(extensionPoint);

        // instantiate all found extesions
        List list = new ArrayList(classes.size());

        for (Class extension : classes) {
            list.add(make(extension));
        }
        return list;
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
        initialize();

        Class<E> clazz = keys.find(extensionPoint.getName().concat(key.getName()));

        return clazz == null ? null : make(clazz);
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
     * @return All Extension classes of the given Extension Point or empty list.
     * @throws NullPointerException If the Extension Point is <code>null</code>.
     */
    public static <E extends Extensible> List<Class<E>> findAs(Class<E> extensionPoint) {
        initialize();

        // Skip null check because this method can throw NullPointerException.
        List<Class> classes = extensions.get(extensionPoint);

        // instantiate all found extesions
        List list = new ArrayList(classes.size());

        for (Class extension : classes) {
            list.add(extension);
        }
        return list;
    }

    /**
     * <p>
     * Gets a <em>type-safe and refactoring-safe</em> resource bundle (<em>not</em>
     * {@link java.util.ResourceBundle}) corresponding to the specified resource bundle class.
     * </p>
     * <p>
     * Conceptually, i18n method uses the following strategy for locating and instantiating resource
     * bundles:
     * </p>
     * <p>
     * i18n method uses the bundle class name and the default locale (obtained from
     * <code>I.make(Locale.class)</code>)) to generate a sequence of candidate bundle names. If the
     * default locale's language, country, and variant are all empty strings, then the bundle class
     * name is the only candidate bundle name. Otherwise, the following sequence is generated from
     * the attribute values of the default locale (language, country, and variant):
     * </p>
     * <ol>
     * <li>bundleClassSimpleName + "_" + language + "_" + country + "_" + variant</li>
     * <li>bundleClassSimpleName + "_" + language + "_" + country</li>
     * <li>bundleClassSimpleName + "_" + language</li>
     * <li>bundleClassSimpleName</li>
     * </ol>
     * <p>
     * Candidate bundle names where the final component is an empty string are omitted. For example,
     * if country is an empty string, the second candidate bundle name is omitted.
     * </p>
     * <p>
     * i18n method then iterates over the candidate bundle names to find the first one for which it
     * can instantiate an actual resource bundle. For each candidate bundle name, it attempts to
     * create a resource bundle:
     * </p>
     * <ol>
     * <li>First, it attempts to find a class using the candidate bundle name. If such a class can
     * be found and loaded using {@link I#find(Class)}, is assignment compatible with the given
     * bundle class, and can be instantiated, i18n method creates a new instance of this class and
     * uses it as the result resource bundle.</li>
     * </ol>
     * <p>
     * If the following classes are provided:
     * </p>
     * <ul>
     * <li>MyResources.class</li>
     * <li>MyResources_fr.class</li>
     * <li>MyResources_fr_CH.class</li>
     * </ul>
     * <p>
     * The contents of all files are valid (that is non-abstract subclasses of {@link Extensible}
     * for the ".class" files). The default locale is Locale("en", "GB").
     * </p>
     * <p>
     * Calling i18n method with the shown locale argument values instantiates resource bundles from
     * the following sources:
     * </p>
     * <ol>
     * <li>Locale("fr", "CH"): result MyResources_fr_CH.class</li>
     * <li>Locale("fr", "FR"): result MyResources_fr.class</li>
     * <li>Locale("es"): result MyResources.class</li>
     * </ol>
     *
     * @param <B> A resource bundle.
     * @param bundleClass A resource bundle class. <code>null</code> will throw
     *            {@link NullPointerException}.
     * @return A suitable resource bundle class for the given bundle class and locale.
     * @throws NullPointerException If the bundle class is <code>null</code>.
     */
    public static <B extends Extensible> B i18n(Class<B> bundleClass) {
        String lang = "_".concat(make(Locale.class).getLanguage());

        for (Class clazz : extensions.get(bundleClass)) {
            if (clazz.getName().endsWith(lang)) {
                bundleClass = clazz;
                break;
            }
        }
        return make(bundleClass);
    }

    /**
     * <p>
     * Returns a string containing the string representation of each of items, using the specified
     * separator between each.
     * </p>
     * 
     * @param delimiter A sequence of characters that is used to separate each of the elements in
     *            the resulting String.
     * @param items A {@link Iterable} items.
     * @return A concat expression.
     * @throws NullPointerException If items is <code>null</code>.
     */
    public static String join(CharSequence delimiter, CharSequence... items) {
        return join(delimiter, Arrays.asList(items));
    }

    /**
     * <p>
     * Returns a string containing the string representation of each of items, using the specified
     * separator between each.
     * </p>
     * 
     * @param delimiter A sequence of characters that is used to separate each of the elements in
     *            the resulting String.
     * @param items A {@link Iterable} items.
     * @return A concat expression.
     * @throws NullPointerException If items is <code>null</code>.
     */
    public static String join(CharSequence delimiter, Iterable items) {
        StringBuilder builder = new StringBuilder();
        Iterator iterator = items.iterator();

        if (iterator.hasNext()) {
            builder.append(iterator.next());

            while (iterator.hasNext()) {
                builder.append(delimiter).append(iterator.next());
            }
        }
        return builder.toString();
    }

    /**
     * <p>
     * Locate the specified file URL and return the plain {@link Path} object.
     * </p>
     *
     * @param filePath A location path.
     * @return A located {@link Path}.
     * @throws NullPointerException If the given file path is null.
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkWrite(String)} method does not allow a file to be
     *             created.
     */
    public static Path locate(URL filePath) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Locate the specified file path and return the plain {@link Path} object.
     * </p>
     *
     * @param filePath A location path.
     * @return A located {@link Path}.
     * @throws NullPointerException If the given file path is null.
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkWrite(String)} method does not allow a file to be
     *             created.
     */
    public static Path locate(String filePath) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Creates a new abstract file somewhere beneath the system's temporary directory (as defined by
     * the <code>java.io.tmpdir</code> system property).
     * </p>
     *
     * @return A newly created temporary file which is not exist yet.
     * @throws SecurityException If a security manager exists and its
     *             {@link SecurityManager#checkWrite(String)} method does not allow a file to be
     *             created.
     */
    public static Path locateTemporary() {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
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
     * @param <M>
     * @param modelClass
     * @return A instance of the specified model class. This instance is managed by Sinobu.
     * @throws NullPointerException If the model class is <code>null</code>.
     * @throws IllegalArgumentException If the model class is non-accessible or final class.
     * @throws UnsupportedOperationException If the model class is inner-class.
     * @throws ClassCircularityError If the model has circular dependency.
     * @throws InstantiationException If Sinobu can't instantiate(resolve) the model class.
     */
    public static <M> M make(Class<M> modelClass) {
        return makeLifestyle(modelClass).get();
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
     * @param <M>
     * @param modelClass
     * @return A instance of the specified model class. This instance is managed by Sinobu.
     * @throws NullPointerException If the model class is <code>null</code>.
     * @throws IllegalArgumentException If the model class is non-accessible or final class.
     * @throws UnsupportedOperationException If the model class is inner-class.
     * @throws ClassCircularityError If the model has circular dependency.
     * @throws InstantiationException If Sinobu can't instantiate(resolve) the model class.
     */
    static <M> Lifestyle<M> makeLifestyle(Class<M> modelClass) {
        // At first, we must confirm the cached lifestyle associated with the model class. If
        // there is no such cache, we will try to create newly lifestyle.
        Lifestyle<M> lifestyle = lifestyles.get(modelClass);

        if (lifestyle != null) {
            return lifestyle; // use cache
        }

        // Skip null check because this method can throw NullPointerException.
        // if (modelClass == null) throw new NullPointerException("NPE");

        // The model class have some preconditions to have to meet.
        if (modelClass.isLocalClass()) {
            throw new UnsupportedOperationException(modelClass + " is  inner class.");
        }

        int modifier = modelClass.getModifiers();

        // In the second place, we must find the actual model class which is associated with this
        // model class. If the actual model class is a concreate, we can use it directly.
        Class<M> actualClass = modelClass;

        // if (((Modifier.ABSTRACT | Modifier.INTERFACE) & modifier) != 0) {
        // // TODO model provider finding strategy
        // // This strategy is decided at execution phase.
        // actualClass = make(Modules.class).find(modelClass);
        //
        // // updata to the actual model class's modifier
        // modifier = actualClass.getModifiers();
        // }

        // If this model is non-private or final class, we can extend it for interceptor mechanism.
        if (((Modifier.PRIVATE | Modifier.FINAL) & modifier) == 0) {
            Table<Method, Annotation> interceptables = ClassUtil.getAnnotations(actualClass);

            // Enhance the actual model class if needed.
            if (!interceptables.isEmpty()) {
                define(actualClass, interceptables);
            }
        }

        // Construct dependency graph for the current thred.
        Deque<Class> dependency = dependencies.get();
        dependency.add(actualClass);

        // Don't use 'contains' method check here to resolve singleton based
        // circular reference. So we must judge it from the size of context. If the
        // context contains too many classes, it has a circular reference
        // independencies.
        if (16 < dependency.size()) {
            // Deque will be contain repeated Classes so we must shrink it with
            // maintaining its class order.
            throw new ClassCircularityError(new LinkedHashSet(dependency).toString());
        }

        try {
            // At first, we should search the associated lifestyle from extension points.
            lifestyle = find(Lifestyle.class, modelClass);

            // Then, check its Manageable annotation.
            if (lifestyle == null) {
                // If the actual model class doesn't provide its lifestyle explicitly, we use
                // Prototype lifestyle which is default lifestyle in Sinobu.
                Manageable manageable = actualClass.getAnnotation(Manageable.class);

                // Create new lifestyle for the actual model class
                lifestyle = (Lifestyle<M>) make((Class) (manageable == null ? Prototype.class : manageable.lifestyle()));
            }

            // Trace dependency graph to detect circular dependencies.
            Constructor constructor = ClassUtil.getMiniConstructor(actualClass);

            if (constructor != null) {
                for (Class param : constructor.getParameterTypes()) {
                    if (param != Lifestyle.class && param != Class.class) {
                        makeLifestyle(param);
                    }
                }
            }

            // This lifestyle is safe and has no circular dependencies.
            lifestyles.putIfAbsent(modelClass, lifestyle);

            // API definition
            return lifestyles.get(modelClass);
        } finally {
            dependency.pollLast();
        }
    }

    /**
     * <p>
     * Findthe first parameter name of lambda method.
     * </p>
     * 
     * @param object A lambda instance.
     * @return A parameter name.
     */
    static String method(Object object) {
        return "type";
    }

    /**
     * <p>
     * Observe the specified {@link ObservableValue}.
     * </p>
     * <p>
     * An implementation of {@link ObservableValue} may support lazy evaluation, which means that
     * the value is not immediately recomputed after changes, but lazily the next time the value is
     * requested.
     * </p>
     * 
     * @param observable A target to observe.
     * @return A observable event stream.
     */
    public static <E extends javafx.beans.Observable> Events<E> observe(E observable) {
        if (observable == null) {
            return Events.NEVER;
        }

        return new Events<>(observer -> {
            // create actual listener
            InvalidationListener listener = value -> {
                observer.accept((E) value);
            };

            observable.addListener(listener); // register listener

            return () -> {
                observable.removeListener(listener); // unregister listener
            };
        });
    }

    /**
     * <p>
     * Observe the specified {@link ObservableValue}.
     * </p>
     * <p>
     * An implementation of {@link ObservableValue} may support lazy evaluation, which means that
     * the value is not immediately recomputed after changes, but lazily the next time the value is
     * requested.
     * </p>
     * 
     * @param observable A target to observe.
     * @return A observable event stream.
     */
    public static <E> Events<E> observe(ObservableValue<E> observable) {
        if (observable == null) {
            return Events.NEVER;
        }

        return new Events<>(observer -> {
            // create actual listener
            ChangeListener<E> listener = (o, oldValue, newValue) -> {
                observer.accept(newValue);
            };

            observable.addListener(listener); // register listener

            // notify the current value
            E value = observable.getValue();

            if (value != null) {
                listener.changed(observable, null, value);
            }

            return () -> {
                observable.removeListener(listener); // unregister listener
            };
        });
    }

    /**
     * <p>
     * Create value set.
     * </p>
     * 
     * @param param1 A first parameter.
     * @return
     */
    public static <Param1> Unary<Param1> pair(Param1 param1) {
        return new Unary(param1);
    }

    /**
     * <p>
     * Create value set.
     * </p>
     * 
     * @param param1 A first parameter.
     * @param param2 A second parameter.
     * @return
     */
    public static <Param1, Param2> Binary<Param1, Param2> pair(Param1 param1, Param2 param2) {
        return new Binary(param1, param2);
    }

    /**
     * <p>
     * Create value set.
     * </p>
     * 
     * @param param1 A first parameter.
     * @param param2 A second parameter.
     * @param param3 A third parameter.
     * @return
     */
    public static <Param1, Param2, Param3> Ternary<Param1, Param2, Param3> pair(Param1 param1, Param2 param2, Param3 param3) {
        return new Ternary(param1, param2, param3);
    }

    /**
     * <p>
     * Close the specified object quietly if it is {@link AutoCloseable}. Equivalent to
     * {@link AutoCloseable#close()}, except any exceptions will be ignored. This is typically used
     * in finally block like the following.
     * </p>
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
            return (RuntimeException) throwable;
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
     * <p>
     * Transform any type object into the specified type possible.
     * </p>
     * 
     * @param <M> A output type you want to transform into.
     * @param input A target object.
     * @param output A target type.
     * @return A transformed object.
     * @throws NullPointerException If the output type is <code>null</code>.
     */
    public static <M> M transform(Object input, Class<M> output) {
        // check null
        if (input == null) {
            return null;
        }

        Model inputModel = Model.load(input.getClass());
        Model outputModel = Model.load(output);

        // no conversion
        if (inputModel == outputModel) {
            return (M) input;
        }

        Codec inputCodec = inputModel.getCodec();
        Codec<M> outputCodec = outputModel.getCodec();

        // check whether each model are attribute model or not
        if (inputCodec == null && outputCodec == null) {
            // we should copy property values

            // create destination object
            M m = make(output);

            // copy actually
            inputModel.walk(input, new Copy(m, outputModel));

            // API definition
            return m;
        } else {
            // type conversion
            if (output == String.class) {
                return (M) ((inputCodec != null) ? inputCodec.encode(input) : input.toString());
            }

            if (inputModel.type == String.class && outputCodec != null) {
                try {
                    return outputCodec.decode((String) input);
                } catch (Exception e) {
                    // ignore
                }
            }
            return (M) input;
        }
    }

    /**
     * <p>
     * Load the file as an additional classpath into JVM. If the file indicates the classpath which
     * is already loaded, that will do nothing at all. The classpath can accept directory or archive
     * (like Jar). If it is <code>null</code> or a file, this method does nothing.
     * </p>
     * <p>
     * There are two advantages in the classpath loaded by this method. One is that you can add
     * classpath dynamically and the other is that you can listen to the specified class loading
     * event.
     * </p>
     * <p>
     * Generally, JVM collects classpath information from various sources (environment variable,
     * command line option and so on). However those means can't add or remove a classpath
     * dynamically. This method removes such limitations.
     * </p>
     * <p>
     * <em>NOTE</em> : System class loader in JVM can recognize the classpath which is specified by
     * usual means, but not by this method. Because Sinobu manages additional classpath for enabling
     * dynamic manipulation.
     * </p>
     * 
     * @param classPath A classpath to load.
     * @param filter Filter classes by package of the specified class.
     * @return A managed {@link ClassLoader}.
     * @see #unload(Path)
     * @see kiss.ClassListener#load(Class)
     * @see java.lang.ClassLoader#getSystemClassLoader()
     */
    public static ClassLoader load(Class classPath, boolean filter) {
        // reset
        extensions = null;

        // API definition
        return null;
    }

    /**
     * <p>
     * Define interceptor code.
     * </p>
     * 
     * @param source
     * @param interceptors
     */
    private static void define(Class source, Table<Method, Annotation> interceptors) {
        try {
            NativeObject prototype = Reflections.getPrototype(source);

            for (Entry<Method, List<Annotation>> entry : interceptors.entrySet()) {
                Method method = entry.getKey();
                List<Annotation> annotations = entry.getValue();

                if (!annotations.isEmpty()) {
                    InterceptorFunction function = new InterceptorFunction(method.getName(),
                            MethodHandles.lookup().unreflect(method),
                            annotations.toArray(new Annotation[annotations.size()]));
                    prototype.setProperty(Reflections.getPropertyName(method), new NativeFunction(function));
                }
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * Lazy initialization.
     */
    private static void initialize() {
        if (extensions == null) {
            extensions = new Table();

            for (Class<? extends Extensible> extension : search(Extensible.class)) {
                load(extension);
            }
        }
    }

    private static void load(Class extension) {
        // search and collect information for all extension points
        for (Class extensionPoint : ClassUtil.getTypes(extension)) {
            if (Arrays.asList(extensionPoint.getInterfaces()).contains(Extensible.class)) {
                // register new extension
                extensions.push(extensionPoint, extension);

                // register extension key
                Class[] params = ClassUtil.getParameter(extension, extensionPoint);

                if (params.length != 0 && params[0] != Object.class) {
                    keys.push(extensionPoint.getName().concat(params[0].getName()), extension);

                    // The user has registered a newly custom lifestyle, so we should update
                    // lifestyle for this extension key class. Normally, when we update some data,
                    // it is desirable to store the previous data to be able to restore it later.
                    // But, in this case, the contextual sensitive instance that the lifestyle emits
                    // changes twice on "load" and "unload" event from the point of view of the
                    // user. So the previous data becomes all but meaningless for a cacheable
                    // lifestyles (e.g. Singleton and ThreadSpecifiec). Therefore we we completely
                    // refresh lifestyles associated with this extension key class.
                    if (extensionPoint == Lifestyle.class) {
                        lifestyles.remove(params[0]);
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Find all sub class of the specified class.
     * </p>
     * 
     * @param type A type to search.
     * @return A list of found classes.
     */
    private static <T> List<Class<? extends T>> search(Class<T> type) {
        List<Class<? extends T>> matched = new ArrayList();
        NativeArray extensions = boot.getPropertyAs(NativeArray.class, "extensions");

        for (int i = 0; i < extensions.length(); i++) {
            NativeObject object = (NativeObject) extensions.get(i);

            if (object != null) {
                Class clazz = object.getPropertyAs(Class.class, "$");

                if (((Modifier.INTERFACE | Modifier.ABSTRACT) & clazz.getModifiers()) == 0 && type != clazz && type
                        .isAssignableFrom(clazz)) {
                    matched.add(clazz);
                }
            }
        }
        return matched;
    }

    /**
     * <p>
     * Reads Java object tree from the given XML or JSON input.
     * </p>
     * 
     * @param input A serialized Java object tree data as XML or JSON. If the input is incompatible
     *            with Java object, this method ignores the input. <code>null</code> will throw
     *            {@link NullPointerException}. The empty or invalid format data will throw
     *            {@link ScriptException}.
     * @param output A root Java object. All properties will be assigned from the given data deeply.
     *            If the input is incompatible with Java object, this method ignores the input.
     *            <code>null</code> will throw {@link java.lang.NullPointerException}.
     * @return A root Java object.
     * @throws NullPointerException If the input data or the root Java object is <code>null</code>.
     * @throws ScriptException If the input data is empty or invalid format.
     */
    public static <M> M read(CharSequence input, M output) {
        try {
            return read(Model.load(output.getClass()), output, Global.JSON.parse(input.toString()));
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Read property and write it.
     * </p>
     * 
     * @param java
     * @param js
     * @return
     */
    private static <T> T read(Model model, T java, NativeObject js) throws Exception {
        for (String name : js.keys()) {
            Object value;
            Property property = model.getProperty(name);

            if (property != null) {
                if (property.isAttribute()) {
                    value = transform(js.getProperty(property.name), property.model.type);
                } else {
                    value = read(property.model, make(property.model.type), js.getPropertyAs(NativeObject.class, property.name));
                }

                // assign value
                model.set(java, property, value);
            }
        }
        return java;
    }

    /**
     * <p>
     * Execute the specified task in background {@link Thread}.
     * </p>
     * 
     * @param task A task to execute.
     */
    public static Future<?> schedule(Runnable task) {
        return schedule(0, TimeUnit.MILLISECONDS, true, task);
    }

    /**
     * <p>
     * Execute the specified task in background {@link Thread} with the specified delay.
     * </p>
     * 
     * @param time A delay time.
     * @param unit A delay time unit.
     * @param parallelExecution The <code>true</code> will execute task in parallel,
     *            <code>false</code> will execute task in serial.
     * @param task A task to execute.
     */
    public static Future<?> schedule(long time, TimeUnit unit, boolean parallelExecution, Runnable task) {
        return parallel.schedule(task, time, unit);
    }

    /**
     * <p>
     * Execute the specified task infinitely in background {@link Thread} with the specified delay
     * and period.
     * </p>
     *
     * @param delay A initial delay time.
     * @param period A period time.
     * @param unit A delay time unit.
     * @param parallelExecution The <code>true</code> will execute task in parallel,
     *            <code>false</code> will execute task in serial.
     * @param task A task to execute.
     */
    public static Future<?> schedule(long delay, long period, TimeUnit unit, boolean parallelExecution, Runnable task) {
        return parallel.scheduleAtFixedRate(task, delay, period, unit);
    }

    /**
     * <p>
     * Writes Java object tree to the given output as XML or JSON.
     * </p>
     * <p>
     * If the output object implements {@link AutoCloseable}, {@link AutoCloseable#close()} method
     * will be invoked certainly.
     * </p>
     * 
     * @param input A Java object. All properties will be serialized deeply. <code>null</code> will
     *            throw {@link java.lang.NullPointerException}.
     * @param output A serialized data output. <code>null</code> will throw
     *            {@link NullPointerException}.
     * @param json <code>true</code> will produce JSON expression, <code>false</code> will produce
     *            XML expression.
     * @throws NullPointerException If the input Java object or the output is <code>null</code> .
     */
    public static void write(Object input, Appendable output, boolean json) {
        if (output == null) {
            throw new NullPointerException();
        }

        Model model = Model.load(input.getClass());
        Property property = new Property(model, model.name);

        // traverse configuration as json
        new JSON(output).walk(model, property, input);
    }

    /**
     * @version 2013/09/26 14:55:33
     */
    private static class InterceptorFunction implements Delegator {

        /** The method name. */
        private final String name;

        /** The method handle. */
        private final MethodHandle method;

        /** The annotations. */
        private final Annotation[] annotations;

        /**
         * @param name
         * @param method
         * @param annotations
         */
        private InterceptorFunction(String name, MethodHandle method, Annotation[] annotations) {
            this.name = name;
            this.method = method;
            this.annotations = annotations;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object delegate(Object that, Object[] arguments) {
            return Interceptor.invoke(name, method, that, arguments, annotations);
        }
    }

    /**
     * @version 2013/10/01 15:53:27
     */
    private static class Copy implements PropertyWalker {

        /** The current model. */
        private Model model;

        /** The curret object. */
        private Object object;

        /**
         * @param model
         * @param object
         */
        private Copy(Object object, Model model) {
            this.model = model;
            this.object = object;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void walk(Model model, Property property, Object node) {
            Property dest = this.model.getProperty(property.name);

            // never check null because PropertyWalker traverses existing properties
            this.model.set(object, dest, I.transform(node, dest.model.type));
        }
    }
}
