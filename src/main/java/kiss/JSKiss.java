/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import static js.lang.Global.boot;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import javax.script.ScriptException;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import booton.translator.JavaAPIProvider;
import js.lang.Global;
import js.lang.NativeArray;
import js.lang.NativeObject;
import kiss.model.Model;
import kiss.model.Property;

/**
 * @version 2013/08/02 12:39:06
 */
@JavaAPIProvider(I.class)
class JSKiss {

    /** No Operation */
    public static final Runnable NoOP = () -> {
        // no operation
    };

    public static ScheduledExecutorService $scheduler = Executors.newScheduledThreadPool(1);

    /** The definitions for extensions. */
    private static Map extensions;

    /** The circularity dependency graph per thread. */
    static final ThreadSpecific<Deque<Class>> dependencies = new ThreadSpecific(ArrayDeque.class);

    /** The cache between Model and Lifestyle. */
    private static final ConcurrentHashMap<Class, Lifestyle> lifestyles = new ConcurrentHashMap();

    /** The task manager. */
    private static final ScheduledExecutorService parallel = Executors.newScheduledThreadPool(4);

    /** The associatable object holder. */
    private static final WeakHashMap<Object, WeakHashMap> associatables = new WeakHashMap();

    /** The list of primitive classes. (except for void type) */
    private static final Class[] primitives = {boolean.class, int.class, long.class, float.class, double.class, byte.class, short.class,
            char.class, void.class};

    /** The list of wrapper classes. (except for void type) */
    private static final Class[] wrappers = {Boolean.class, Integer.class, Long.class, Float.class, Double.class, Byte.class, Short.class,
            Character.class, Void.class};

    /** The holder for lambda reference. */
    private static final Map<Class, Executable> executables = new ConcurrentHashMap();

    static {
        // built-in lifestyles
        lifestyles.put(List.class, ArrayList::new);
        lifestyles.put(Map.class, HashMap::new);
        lifestyles.put(Set.class, HashSet::new);
        lifestyles.put(Lifestyle.class, new Prototype(Prototype.class));
        lifestyles.put(Prototype.class, new Prototype(Prototype.class));
    }

    /**
     * <p>
     * Create {@link Predicate} which accpets any item.
     * </p>
     * 
     * @return An acceptable {@link Predicate}.
     */
    public static <V> Predicate<V> accept() {
        return e -> true;
    }

    /**
     * <p>
     * Retrieve the associated value with the specified object by the specified type.
     * </p>
     *
     * @param host A host object.
     * @param type An association type.
     * @return An associated value.
     */
    public static <V> V associate(Object host, Class<V> type) {
        WeakHashMap<Class<V>, V> association = associatables.computeIfAbsent(host, key -> new WeakHashMap());
        return association.computeIfAbsent(type, I::make);
    }

    /**
     * <p>
     * Create the partial applied {@link Consumer}.
     * </p>
     *
     * @param function A target function.
     * @param param A parameter to apply.
     * @return A partial applied function.
     */
    public static <Param> Runnable bind(Consumer<Param> function, Param param) {
        return function == null ? NoOP : () -> function.accept(param);
    }

    /**
     * <p>
     * Create the partial applied {@link Consumer}.
     * </p>
     *
     * @param function A target function.
     * @param param A parameter to apply.
     * @return A partial applied function.
     */
    public static <Param1, Param2> Runnable bind(BiConsumer<Param1, Param2> function, Param1 param1, Param2 param2) {
        return function == null ? NoOP : () -> function.accept(param1, param2);
    }

    /**
     * <p>
     * Create the partial applied {@link Function}.
     * </p>
     *
     * @param function A target function.
     * @param param A parameter to apply.
     * @return A partial applied function.
     */
    public static <Param, Return> Supplier<Return> bind(Function<Param, Return> function, Param param) {
        Objects.requireNonNull(function);
        return () -> function.apply(param);
    }

    /**
     * <p>
     * Create the partial applied {@link Function}.
     * </p>
     *
     * @param function A target function.
     * @param param A parameter to apply.
     * @return A partial applied function.
     */
    public static <Param1, Param2, Return> Supplier<Return> bind(BiFunction<Param1, Param2, Return> function, Param1 param1, Param2 param2) {
        Objects.requireNonNull(function);
        return () -> function.apply(param1, param2);
    }

    /**
     * <p>
     * Bundle all given funcitons into single function.
     * </p>
     * 
     * @param functions A list of functions to bundle.
     * @return A bundled function.
     */
    public static <F> F bundle(F... functions) {
        return bundle((Class<F>) functions.getClass().getComponentType(), functions);
    }

    /**
     * <p>
     * Bundle all given funcitons into single function.
     * </p>
     * 
     * @param functions A list of functions to bundle.
     * @return A bundled function.
     */
    public static <F> F bundle(Collection<F> functions) {
        return bundle(findNCA(functions, Class::isInterface), functions);
    }

    // /**
    // * <p>
    // * Find the nearest common ancestor class of the given classes.
    // * </p>
    // *
    // * @param <X> A type.
    // * @param classes A list of classes.
    // * @return A nearest common ancestor class.
    // */
    // private static <X> Class findNCA(X... classes) {
    // return classes.getClass().getComponentType();
    // }

    /**
     * <p>
     * Find the nearest common ancestor class of the given classes.
     * </p>
     * 
     * @param <X> A type.
     * @param items A list of items.
     * @return A nearest common ancestor class.
     */
    private static <X> Class<X> findNCA(Collection<X> items, Predicate<Class> filter) {
        if (filter == null) {
            filter = accept();
        }

        Set<Class> types = null;
        Iterator<X> iterator = items.iterator();

        if (iterator.hasNext()) {
            types = Model.collectTypes(iterator.next().getClass());
            types.removeIf(filter.negate());

            while (iterator.hasNext()) {
                types.retainAll(Model.collectTypes(iterator.next().getClass()));
            }
        }
        return types == null || types.isEmpty() ? null : types.iterator().next();
    }

    /**
     * <p>
     * Bundle all given typed funcitons into single typed function.
     * </p>
     * 
     * @param type A function type.
     * @param functions A list of functions to bundle.
     * @return A bundled function.
     */
    public static <F> F bundle(Class<F> type, F... functions) {
        return bundle(type, Arrays.asList(functions));
    }

    /**
     * <p>
     * Bundle all given typed funcitons into single typed function.
     * </p>
     * 
     * @param type A function type.
     * @param functions A list of functions to bundle.
     * @return A bundled function.
     */
    public static <F> F bundle(Class<F> type, Collection<F> functions) {
        return make(type, (proxy, method, args) -> {
            Object result = null;

            if (functions != null) {
                for (Object fun : functions) {
                    if (fun != null) {
                        result = method.invoke(fun, args);
                    }
                }
            }
            return result;
        });
    }

    /**
     * <p>
     * Create the specified {@link Collection} with the specified items.
     * </p>
     * 
     * @param type A {@link Collection} type.
     * @param items A list of itmes.
     * @return The new created {@link Collection}.
     */
    public static <T extends Collection<V>, V> T collect(Class<T> type, V... items) {
        T collection = I.make(type);

        if (items != null) {
            for (V item : items) {
                collection.add(item);
            }
        }
        return collection;
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

        return I.signal(findBy(extensionPoint)).flatIterable(Ⅱ::ⅰ).map(I::make).toList();
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

        if (extensionPoint != null && key != null) {
            Ⅱ<List<Class<E>>, Map<Class, Supplier<E>>> extensions = findBy(extensionPoint);

            for (Class type : Model.collectTypes(key)) {
                Supplier<E> supplier = extensions.ⅱ.get(type);

                if (supplier != null) {
                    return supplier.get();
                }
            }

            if (extensionPoint != ExtensionFactory.class) {
                ExtensionFactory<E> factory = find(ExtensionFactory.class, extensionPoint);

                if (factory != null) {
                    return factory.create(key);
                }
            }
        }
        return null;
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

        return new ArrayList(findBy(extensionPoint).ⅰ);
    }

    /**
     * <p>
     * Find the extension definition for the specified extension point.
     * </p>
     * 
     * @param extensionPoint A target extension point.
     * @return A extension definition.
     */
    private static <E extends Extensible> Ⅱ<List<Class<E>>, Map<Class, Supplier<E>>> findBy(Class<E> extensionPoint) {
        initialize();

        return (Ⅱ) extensions.computeIfAbsent(extensionPoint, p -> pair(new ArrayList(), new HashMap()));
    }

    public static <P> Consumer<P> imitateConsumer(Runnable lambda) {
        return p -> {
            if (lambda != null) lambda.run();
        };
    }

    public static <P, R> Function<P, R> imitateFunction(Consumer<P> function) {
        return p -> {
            function.accept(p);
            return null;
        };
    }

    public static <P, R> Function<P, R> imitateFunction(Supplier<R> function) {
        return p -> function.get();
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
     * Retrieve lambda reference.
     * </p>
     * 
     * @param lambda A lambda instance.
     * @return An actual reference.
     */
    static Executable lambda(Serializable lambda) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * <p>
     * Create {@link ArrayList} with the specified items.
     * </p>
     * 
     * @param items A list of itmes.
     * @return The new created {@link ArrayList}.
     */
    public static <V> List<V> list(V... items) {
        return collect(ArrayList.class, items);
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
        // Skip null check because this method can throw NullPointerException.
        // if (modelClass == null) throw new NullPointerException("NPE");

        // At first, we must confirm the cached lifestyle associated with the model class. If
        // there is no such cache, we will try to create newly lifestyle.
        Lifestyle<M> lifestyle = lifestyles.get(modelClass);

        if (lifestyle != null) return lifestyle; // use cache

        // Skip null check because this method can throw NullPointerException.
        // if (modelClass == null) throw new NullPointerException("NPE");

        // The model class have some preconditions to have to meet.
        if (modelClass.isLocalClass()) {
            throw new UnsupportedOperationException(modelClass + " is  inner class.");
        }

        // Construct dependency graph for the current thred.
        Deque<Class> dependency = dependencies.get();
        dependency.add(modelClass);

        try {
            // At first, we should search the associated lifestyle from extension points.
            lifestyle = find(Lifestyle.class, modelClass);

            // Then, check its Manageable annotation.
            if (lifestyle == null) {
                // If the actual model class doesn't provide its lifestyle explicitly, we use
                // Prototype lifestyle which is default lifestyle in Sinobu.
                Manageable manageable = modelClass.getAnnotation(Manageable.class);

                // Create new lifestyle for the actual model class
                lifestyle = (Lifestyle) make((Class) (manageable == null ? Prototype.class : manageable.lifestyle()));
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
     * <p>
     * Create proxy instance.
     * </p>
     * 
     * @param type A model type.
     * @param handler A proxy handler.
     * @return
     */
    public static <T> T make(Class<T> type, InvocationHandler handler) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(handler);

        if (type.isInterface() == false) {
            throw new IllegalArgumentException("Type must be interface.");
        }
        return (T) Proxy.newProxyInstance(I.class.getClassLoader(), new Class[] {type}, handler);
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
    public static <E extends javafx.beans.Observable> Signal<E> observe(E observable) {
        if (observable == null) {
            return Signal.never();
        }

        return new Signal<>((observer, disposer) -> {
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
    public static <E> Signal<E> observe(ObservableValue<E> observable) {
        if (observable == null) {
            return Signal.never();
        }

        return new Signal<>((observer, disposer) -> {
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
     * @param param2 A second parameter.
     * @return
     */
    public static <Param1, Param2> Ⅱ<Param1, Param2> pair(Param1 param1, Param2 param2) {
        return new Ⅱ(param1, param2);
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
    public static <Param1, Param2, Param3> Ⅲ<Param1, Param2, Param3> pair(Param1 param1, Param2 param2, Param3 param3) {
        return new Ⅲ(param1, param2, param3);
    }

    /**
     * <p>
     * Create paired value {@link Consumer}.
     * </p>
     *
     * @param consumer A {@link BiConsumer} to make parameters paired.
     * @return A paired value {@link Consumer}.
     */
    public static <Param1, Param2> Consumer<Ⅱ<Param1, Param2>> pair(BiConsumer<Param1, Param2> consumer) {
        return params -> consumer.accept(params.ⅰ, params.ⅱ);
    }

    /**
     * <p>
     * Create paired value {@link Function}.
     * </p>
     *
     * @param funtion A {@link BiFunction} to make parameters paired.
     * @return A paired value {@link Function}.
     */
    public static <Param1, Param2, Return> Function<Ⅱ<Param1, Param2>, Return> pair(BiFunction<Param1, Param2, Return> funtion) {
        return params -> funtion.apply(params.ⅰ, params.ⅱ);
    }

    /**
     * <p>
     * Ease the checked exception on lambda.
     * </p>
     * 
     * @param lambda A checked lambda.
     * @return A unchecked lambda.
     */
    public static Runnable quiet(WiseRunnable lambda) {
        return lambda;
    }

    /**
     * <p>
     * Ease the checked exception on lambda.
     * </p>
     * 
     * @param lambda A checked lambda.
     * @return A unchecked lambda.
     */
    public static <P> Consumer<P> quiet(WiseConsumer<P> lambda) {
        return lambda;
    }

    /**
     * <p>
     * Ease the checked exception on lambda.
     * </p>
     * 
     * @param lambda A checked lambda.
     * @return A unchecked lambda.
     */
    public static <P1, P2> BiConsumer<P1, P2> quiet(WiseBiConsumer<P1, P2> lambda) {
        return lambda;
    }

    /**
     * <p>
     * Ease the checked exception on lambda.
     * </p>
     * 
     * @param lambda A checked lambda.
     * @return A unchecked lambda.
     */
    public static <R> Supplier<R> quiet(WiseSupplier<R> lambda) {
        return lambda;
    }

    /**
     * <p>
     * Ease the checked exception on lambda.
     * </p>
     * 
     * @param lambda A checked lambda.
     * @return A unchecked lambda.
     */
    public static <P, R> Function<P, R> quiet(WiseFunction<P, R> lambda) {
        return lambda;
    }

    /**
     * <p>
     * Ease the checked exception on lambda.
     * </p>
     * 
     * @param lambda A checked lambda.
     * @return A unchecked lambda.
     */
    public static <P1, P2, R> BiFunction<P1, P2, R> quiet(WiseBiFunction<P1, P2, R> lambda) {
        return lambda;
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
     * Define recursive {@link BiConsumer}.
     * </p>
     * <pre>
     * I.recurBC(self -> (param1, param2) -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <Param1, Param2> BiConsumer<Param1, Param2> recurseBC(Function<BiConsumer<Param1, Param2>, BiConsumer<Param1, Param2>> function) {
        Recursive<BiConsumer<Param1, Param2>> recursive = recursiveFunction -> function.apply((param1, param2) -> {
            recursiveFunction.apply(recursiveFunction).accept(param1, param2);
        });
        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Define recursive {@link BiFunction}.
     * </p>
     * <pre>
     * I.recurBF(self -> (param1, param2) -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <Param1, Param2, Return> BiFunction<Param1, Param2, Return> recurseBF(Function<BiFunction<Param1, Param2, Return>, BiFunction<Param1, Param2, Return>> function) {
        Recursive<BiFunction<Param1, Param2, Return>> recursive = recursiveFunction -> function.apply((param1, param2) -> {
            return recursiveFunction.apply(recursiveFunction).apply(param1, param2);
        });
        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Define recursive {@link Consumer}.
     * </p>
     * <pre>
     * I.recurC(self -> param1 -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     * @param function A target function to convert.
     * @return A converted recursive function.
     */
    public static <Param> Consumer<Param> recurseC(Function<Consumer<Param>, Consumer<Param>> function) {
        Recursive<Consumer<Param>> recursive = recursiveFunction -> function.apply(param -> {
            recursiveFunction.apply(recursiveFunction).accept(param);
        });
        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Define recursive {@link Function}.
     * </p>
     * <pre>
     * I.recurF(self -> param -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <Param, Return> Function<Param, Return> recurseF(Function<Function<Param, Return>, Function<Param, Return>> function) {
        Recursive<Function<Param, Return>> recursive = recursiveFunction -> function.apply(param -> {
            return recursiveFunction.apply(recursiveFunction).apply(param);
        });

        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Define recursive {@link Runnable}.
     * </p>
     * <pre>
     * I.recurR(self -> () -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static Runnable recurseR(Function<Runnable, Runnable> function) {
        Recursive<Runnable> recursive = recursiveFunction -> function.apply(() -> {
            recursiveFunction.apply(recursiveFunction).run();
        });
        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Define recursive {@link Supplier}.
     * </p>
     * <pre>
     * I.recurS(self -> () -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <Result> Supplier<Result> recurseS(Function<Supplier<Result>, Supplier<Result>> function) {
        Recursive<Supplier<Result>> recursive = recursiveFunction -> function.apply(() -> {
            return recursiveFunction.apply(recursiveFunction).get();
        });
        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Define recursive {@link WiseTriConsumer}.
     * </p>
     * <pre>
     * I.recurTC(self -> (param1, param2, param3) -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <Param1, Param2, Param3> WiseTriConsumer<Param1, Param2, Param3> recurseTC(Function<WiseTriConsumer<Param1, Param2, Param3>, WiseTriConsumer<Param1, Param2, Param3>> function) {
        Recursive<WiseTriConsumer<Param1, Param2, Param3>> recursive = recursiveFunction -> function.apply((param1, param2, param3) -> {
            recursiveFunction.apply(recursiveFunction).accept(param1, param2, param3);
        });
        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Define recursive {@link WiseTriFunction}.
     * </p>
     * <pre>
     * I.recurTF(self -> (param1, param2, param3) -> {
     *   // your function code
     * });
     * </pre>
     * 
     * @param function A recursive function.
     * @return A created function.
     */
    public static <Param1, Param2, Param3, Return> WiseTriFunction<Param1, Param2, Param3, Return> recurseTF(Function<WiseTriFunction<Param1, Param2, Param3, Return>, WiseTriFunction<Param1, Param2, Param3, Return>> function) {
        Recursive<WiseTriFunction<Param1, Param2, Param3, Return>> recursive = recursiveFunction -> function
                .apply((param1, param2, param3) -> {
                    return recursiveFunction.apply(recursiveFunction).apply(param1, param2, param3);
                });
        return recursive.apply(recursive);
    }

    /**
     * <p>
     * Create {@link Predicate} which rejects any item.
     * </p>
     * 
     * @return An rejectable {@link Predicate}.
     */
    public static <V> Predicate<V> reject() {
        return e -> false;
    }

    /**
     * <p>
     * Create {@link Set} with the specified items.
     * </p>
     * 
     * @param items A list of itmes.
     * @return The new created {@link Set}.
     */
    public static <V> Set<V> set(V... items) {
        Set<V> set = new HashSet();

        if (items != null) {
            for (V item : items) {
                set.add(item);
            }
        }

        return set;
    }

    /**
     * <p>
     * Transform any type object into the specified type if possible.
     * </p>
     *
     * @param <In> A input type you want to transform from.
     * @param <Out> An output type you want to transform into.
     * @param input A target object.
     * @param output A target type.
     * @return A transformed object.
     * @throws NullPointerException If the output type is <code>null</code>.
     */
    public static <In, Out> Out transform(In input, Class<Out> output) {
        if (input == null) {
            return null;
        }

        String encoded = input instanceof String ? (String) input : find(Encoder.class, input.getClass()).encode(input);

        if (output == String.class) {
            return (Out) encoded;
        }
        return ((Decoder<Out>) find(Decoder.class, output)).decode(encoded);
    }

    /**
     * <p>
     * Find the class by the specified fully qualified class name.
     * </p>
     *
     * @param fqcn A fully qualified class name to want.
     * @return The specified class.
     */
    public static Class type(String fqcn) {
        for (Class clazz : primitives) {
            if (clazz.getName().equals(fqcn)) {
                return clazz;
            }
        }

        try {
            return Class.forName(fqcn, false, null);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(fqcn);
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
        // API definition
        return null;
    }

    /**
     * Lazy initialization.
     */
    private static void initialize() {
        if (extensions == null) {
            extensions = new HashMap();

            for (Class<? extends Extensible> extension : search(Extensible.class)) {
                load(extension);
            }

            // built-in encoders
            load(ExtensionFactory.class, Encoder.class, () -> (ExtensionFactory<Encoder>) type -> {
                if (type.isEnum()) {
                    return value -> ((Enum) value).name();
                }
                switch (type.getName().hashCode()) {
                case -530663260: // java.lang.Class
                    return value -> ((Class) value).getName();
                default:
                    return String::valueOf;
                }
            });

            // built-in decoders
            load(ExtensionFactory.class, Decoder.class, () -> (ExtensionFactory<Decoder>) type -> {
                if (type.isEnum()) {
                    return value -> Enum.valueOf((Class<Enum>) type, value);
                }
                switch (type.getName().hashCode()) {
                case 64711720: // boolean
                case 344809556: // java.lang.Boolean
                    return Boolean::new;
                case 104431: // int
                case -2056817302: // java.lang.Integer
                    return Integer::new;
                case 3327612: // long
                case 398795216: // java.lang.Long
                    return Long::new;
                case 97526364: // float
                case -527879800: // java.lang.Float
                    return Float::new;
                case -1325958191: // double
                case 761287205: // java.lang.Double
                    return Double::new;
                case 3039496: // byte
                case 398507100: // java.lang.Byte
                    return Byte::new;
                case 109413500: // short
                case -515992664: // java.lang.Short
                    return Short::new;
                case 3052374: // char
                case 155276373: // java.lang.Character
                    return value -> value.charAt(0);
                case -530663260: // java.lang.Class
                    return I::type;
                case 1195259493: // java.lang.String
                    return String::new;
                case -1555282570: // java.lang.StringBuilder
                    return StringBuilder::new;
                case 1196660485: // java.lang.StringBuffer
                    return StringBuffer::new;
                case 2130072984: // java.io.File
                    return File::new;
                case 2050244018: // java.net.URL
                    return value -> {
                        try {
                            return new URL(value);
                        } catch (Exception e) {
                            throw I.quiet(e);
                        }
                    };
                case 2050244015: // java.net.URI
                    return URI::create;
                case -989675752: // java.math.BigInteger
                    return BigInteger::new;
                case -1405464277: // java.math.BigDecimal
                    return BigDecimal::new;
                case -1165211622: // java.util.Locale
                    return Locale::forLanguageTag;
                case -1023498007: // java.time.Duration
                case 1296075756: // java.time.Instant
                case -1246518012: // java.time.LocalDate
                case -1179039247: // java.time.LocalDateTime
                case -1246033885: // java.time.LocalTime
                case 649475153: // java.time.MonthDay
                case -682591005: // java.time.OffsetDateTime
                case -1917484011: // java.time.OffsetTime
                case 649503318: // java.time.Period
                case -1062742510: // java.time.Year
                case -537503858: // java.time.YearMonth
                case 1505337278: // java.time.ZonedDateTime
                    return value -> {
                        try {
                            return type.getMethod("parse", CharSequence.class).invoke(null, value);
                        } catch (Exception e) {
                            throw I.quiet(e);
                        }
                    };
                // case -89228377: // java.nio.file.attribute.FileTime
                // decoder = value -> FileTime.fromMillis(Long.valueOf(value));
                // encoder = (Encoder<FileTime>) value -> String.valueOf(value.toMillis());
                // break;
                default:
                    return null;
                }
            });
        }
    }

    private static <E extends Extensible> Disposable load(Class extension) {
        Disposable disposer = Disposable.empty();

        // search and collect information for all extension points
        for (Class<E> extensionPoint : Model.collectTypes(extension)) {
            if (Arrays.asList(extensionPoint.getInterfaces()).contains(Extensible.class)) {
                // register as new extension
                findBy(extensionPoint).ⅰ.add(extension);
                disposer.add(() -> findBy(extensionPoint).ⅰ.remove(extension));

                // register extension key
                java.lang.reflect.Type[] params = Model.collectParameters(extension, extensionPoint);

                if (params.length != 0 && params[0] != Object.class) {
                    Class clazz = (Class) params[0];

                    // register extension by key
                    disposer.add(load(extensionPoint, clazz, () -> (E) I.make(extension)));

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
        }
        return disposer;
    }

    /**
     * <p>
     * Register extension with key.
     * </p>
     * 
     * @param extensionPoint A extension point.
     * @param extensionKey A extension key,
     * @param extension A extension to register.
     * @return A disposer to unregister.
     */
    public static <E extends Extensible> Disposable load(Class<E> extensionPoint, Class extensionKey, Supplier<E> extension) {
        findBy(extensionPoint).ⅱ.put(extensionKey, extension);
        return () -> findBy(extensionPoint).ⅱ.remove(extensionKey);
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
            return read(Model.of(output), output, Global.JSON.parse(input.toString()));
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
            Property property = model.property(name);

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
     * Execute the specified task in background {@link Thread} with the specified delay.
     * </p>
     *
     * @param delay A initial delay time.
     * @param unit A delay time unit.
     * @param parallelExecution The <code>true</code> will execute task in parallel,
     *            <code>false</code> will execute task in serial.
     * @param task A task to execute.
     */
    public static Future<?> schedule(Runnable task, long interval, TimeUnit unit) {
        // return schedule.scheduleAtFixedRate(task, 0, interval, unit);
        return null;
    }

    /**
     * <p>
     * Signal the specified values.
     * </p>
     *
     * @param values A list of values to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    @SafeVarargs
    public static <V> Signal<V> signal(V... values) {
        return Signal.<V> empty().startWith(values);
    }

    /**
     * Converts a {@link Future} into a {@link Signal}.
     *
     * @param value The source {@link Future}.
     * @param <V> The type of object that the {@link Future} returns, and also the type of item to
     *            be emitted by the resulting {@link Signal}.
     * @return {@link Signal} that emits the item from the source {@link Future}.
     */
    public static <V> Signal<V> signal(Future<V> value) {
        return new Signal<>((observer, disposer) -> {
            I.schedule(() -> {
                try {
                    observer.accept(value.get());
                    observer.complete();
                } catch (Throwable e) {
                    observer.error(e);
                }
            });
            return disposer.add(() -> value.cancel(true));
        });
    }

    /**
     * Converts a {@link CompletableFuture} into a {@link Signal}.
     *
     * @param value The source {@link CompletableFuture}.
     * @param <V> The type of object that the {@link CompletableFuture} returns, and also the type
     *            of item to be emitted by the resulting {@link Signal}.
     * @return {@link Signal} that emits the item from the source {@link CompletableFuture}.
     */
    public static <V> Signal<V> signal(CompletableFuture<V> value) {
        return new Signal<>((observer, disposer) -> {
            value.whenComplete((v, e) -> {
                if (e == null) {
                    observer.accept(v);
                    observer.complete();
                } else {
                    observer.error(e);
                }
            });
            return disposer.add(() -> value.cancel(true));
        });
    }

    /**
     * <p>
     * Signal the specified values.
     * </p>
     *
     * @param values A list of values to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    public static <V> Signal<V> signal(Iterable<V> values) {
        return Signal.<V> empty().startWith(values);
    }

    /**
     * <p>
     * {@link Signal} the specified values.
     * </p>
     *
     * @param values A list of values to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    public static <V> Signal<V> signal(Supplier<V> value) {
        return Signal.<V> empty().startWith(value);
    }

    /**
     * <p>
     * Signal the specified values.
     * </p>
     *
     * @param values A list of values to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    public static <V> Signal<V> signal(Enumeration<V> values) {
        return Signal.<V> empty().startWith(values);
    }

    /**
     * <p>
     * {@link Signal} the specified values.
     * </p>
     *
     * @param values A list of values to emit.
     * @return The {@link Signal} to emit sequencial values.
     */
    public static <V> Signal<V> signal(Variable<V> value) {
        return Signal.<V> empty().startWith(value);
    }

    /**
     * Returns an {@link Signal} that emits {@code 0L} after a specified delay, and then completes.
     *
     * @param delayTime The initial delay before emitting a single {@code 0L}.
     * @param timeUnit Time units to use for {@code delay}.
     * @return {@link Signal} that {@code 0L} after a specified delay, and then completes.
     */
    public static Signal<Long> signal(long delayTime, TimeUnit timeUnit) {
        return new Signal<>((observer, disposer) -> {
            ScheduledFuture<?> future = parallel.schedule(() -> {
                observer.accept(0L);
                observer.complete();
            }, delayTime, timeUnit);

            return disposer.add(() -> future.cancel(true));
        });
    }

    /**
     * Returns an {@link Signal} that emits a {@code 0L} after the {@code delayTime} and ever
     * increasing numbers after each {@code intervalTime} of time thereafter.
     * 
     * @param delayTime The initial delay time to wait before emitting the first value of 0L
     * @param intervalTime The period of time between emissions of the subsequent numbers
     * @param timeUnit the time unit for both {@code initialDelay} and {@code period}
     * @return {@link Signal} that emits a 0L after the {@code delayTime} and ever increasing
     *         numbers after each {@code intervalTime} of time thereafter
     */
    public static Signal<Long> signal(long delayTime, long intervalTime, TimeUnit timeUnit) {
        return new Signal<>((observer, disposer) -> {
            AtomicLong count = new AtomicLong();
            ScheduledFuture<?> future = parallel.scheduleAtFixedRate(() -> {
                observer.accept(count.getAndIncrement());
            }, delayTime, intervalTime, timeUnit);

            return disposer.add(() -> future.cancel(true));
        });
    }

    /**
     * <p>
     * Traverse the tree structure.
     * </p>
     * 
     * @param root A root node to traverse.
     * @param traverser A function to navigate from a node to its children.
     * @return
     */
    public static <T> Signal<T> signal(T root, UnaryOperator<Signal<T>> traverser) {
        return signal(signal(root), traverser);
    }

    /**
     * <p>
     * Traverse the tree structure.
     * </p>
     * 
     * @param root A root node to traverse.
     * @param traverser A function to navigate from a node to its children.
     * @return
     */
    private static <T> Signal<T> signal(Signal<T> root, UnaryOperator<Signal<T>> traverser) {
        return root.merge(root.flatMap(e -> signal(traverser.apply(I.signal(e)), traverser)));
    }

    /**
     * <p>
     * Returns an {@link Signal} that invokes an {@link Observer#error(Throwable)} method when the
     * {@link Observer} subscribes to it.
     * </p>
     *
     * @param error An error to emit.
     * @return The {@link Signal} to emit error.
     */
    public static <V, E extends Throwable> Signal<V> signalError(E error) {
        return new Signal<V>((observer, disposer) -> {
            observer.error(error);
            return disposer;
        });
    }

    /**
     * Signal a sequence of logns within a specified range.
     * 
     * @param start A value of the first long in the sequence.
     * @param count A number of sequential longs to generate.
     * @return A {@link Signal} that emits a range of sequential longs
     */
    public static Signal<Integer> signalRange(int start, int count) {
        return signalRange(start, count, 1);
    }

    /**
     * Signal a sequence of logns within a specified range.
     * 
     * @param start A value of the first long in the sequence.
     * @param count A number of sequential longs to generate.
     * @param step A step value for each sequential longs to generate.
     * @return A {@link Signal} that emits a range of sequential longs
     */
    public static Signal<Integer> signalRange(int start, int count, int step) {
        return new Signal<>((observer, disposer) -> {
            for (int i = 0; i < count; i++) {
                observer.accept(start + i * step);
            }
            observer.complete();
            return disposer;
        });
    }

    /**
     * Signal a sequence of logns within a specified range.
     * 
     * @param start A value of the first long in the sequence.
     * @param count A number of sequential longs to generate.
     * @return A {@link Signal} that emits a range of sequential longs
     */
    public static Signal<Long> signalRange(long start, long count) {
        return signalRange(start, count, 1L);
    }

    /**
     * Signal a sequence of logns within a specified range.
     * 
     * @param start A value of the first long in the sequence.
     * @param count A number of sequential longs to generate.
     * @param step A step value for each sequential longs to generate.
     * @return A {@link Signal} that emits a range of sequential longs
     */
    public static Signal<Long> signalRange(long start, long count, long step) {
        return new Signal<>((observer, disposer) -> {
            for (long i = 0; i < count; i++) {
                observer.accept(start + i * step);
            }
            observer.complete();
            return disposer;
        });
    }

    /**
     * <p>
     * Down cast from {@link Runnable} to {@link WiseRunnable}.
     * </p>
     * 
     * @param lambda A target function.
     * @return A casted function.
     * @see #quiet(WiseRunnable)
     */
    public static WiseRunnable wise(Runnable lambda) {
        return lambda instanceof WiseRunnable ? (WiseRunnable) lambda : () -> lambda.run();
    }

    /**
     * <p>
     * Down cast from {@link Consumer} to {@link WiseConsumer}.
     * </p>
     * 
     * @param lambda A target function.
     * @return A casted function.
     * @see #quiet(WiseConsumer)
     */
    public static <P> WiseConsumer<P> wise(Consumer<P> lambda) {
        return lambda instanceof WiseConsumer ? (WiseConsumer) lambda : v -> lambda.accept(v);
    }

    /**
     * <p>
     * Down cast from {@link BiConsumer} to {@link WiseBiConsumer}.
     * </p>
     * 
     * @param lambda A target function.
     * @return A casted function.
     * @see #quiet(WiseBiConsumer)
     */
    public static <P1, P2> WiseBiConsumer<P1, P2> wise(BiConsumer<P1, P2> lambda) {
        return lambda instanceof WiseBiConsumer ? (WiseBiConsumer) lambda : (p1, p2) -> lambda.accept(p1, p2);
    }

    /**
     * <p>
     * Down cast from {@link Supplier} to {@link WiseSupplier}.
     * </p>
     * 
     * @param lambda A target function.
     * @return A casted function.
     * @see #quiet(WiseSupplier)
     */
    public static <R> WiseSupplier<R> wise(Supplier<R> lambda) {
        return lambda instanceof WiseSupplier ? (WiseSupplier) lambda : () -> lambda.get();
    }

    /**
     * <p>
     * Down cast from {@link Function} to {@link WiseFunction}.
     * </p>
     * 
     * @param lambda A target function.
     * @return A casted function.
     * @see #quiet(WiseFunction)
     */
    public static <P, R> WiseFunction<P, R> wise(Function<P, R> lambda) {
        return lambda instanceof WiseFunction ? (WiseFunction) lambda : p -> lambda.apply(p);
    }

    /**
     * <p>
     * Down cast from {@link BiFunction} to {@link WiseBiFunction}.
     * </p>
     * 
     * @param lambda A target function.
     * @return A casted function.
     * @see #quiet(WiseBiFunction)
     */
    public static <P1, P2, R> WiseBiFunction<P1, P2, R> wise(BiFunction<P1, P2, R> lambda) {
        return lambda instanceof WiseBiFunction ? (WiseBiFunction) lambda : (p1, p2) -> lambda.apply(p1, p2);
    }

    /**
     * <p>
     * Return a non-primitive {@link Class} of the specified {@link Class} object. <code>null</code>
     * will be return <code>null</code>.
     * </p>
     *
     * @param type A {@link Class} object to convert to non-primitive class.
     * @return A non-primitive {@link Class} object.
     */
    public static Class wrap(Class type) {
        // check primitive classes
        for (int i = 0; i < primitives.length; i++) {
            if (primitives[i] == type) {
                return wrappers[i];
            }
        }

        // the specified class is not primitive
        return type;
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
    public static void write(Object input, Appendable out) {
        Objects.nonNull(out);

        try {
            // traverse object as json
            Model model = Model.of(input);
            new JSON(out).write(model, new Property(model, ""), input);
        } finally {
            // close carefuly
            quiet(out);
        }
    }
}
