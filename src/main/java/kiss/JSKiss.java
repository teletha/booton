/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import kiss.model.ClassUtil;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/08/02 12:39:06
 */
@JavaAPIProvider(I.class)
class JSKiss {

    /** The mapping from extension point to extensions. */
    private static final Table<Class, Class> extensions = new Table();

    /** The mapping from extension point to assosiated extension mapping. */
    private static final Table<Integer, Class> keys = new Table();

    /** The circularity dependency graph per thread. */
    private static final ThreadSpecific<Deque<Class>> dependencies = new ThreadSpecific(ArrayDeque.class);

    /** The cache between Model and Lifestyle. */
    private static final ConcurrentHashMap<Class, Lifestyle> lifestyles = new ConcurrentHashMap();

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
     * @param extensionPoint An extension point class. The <a
     *            href="Extensible#ExtensionPoint">Extension Point</a> class is only accepted,
     *            otherwise this method will return empty list.
     * @return All Extensions of the given Extension Point or empty list.
     * @throws NullPointerException If the Extension Point is <code>null</code>.
     */
    public static <E extends Extensible> List<E> find(Class<E> extensionPoint) {
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
     * @param extensionPoint An Extension Point class. The <a
     *            href="Extensible#ExtensionPoint">Extension Point</a> class is only accepted,
     *            otherwise this method will return <code>null</code>.
     * @param key An <a href="Extensible.html#ExtensionKey">Extension Key</a> class.
     * @return A associated Extension of the given Extension Point and the given Extension Key or
     *         <code>null</code>.
     */
    public static <E extends Extensible> E find(Class<E> extensionPoint, Class key) {
        Class<E> clazz = keys.find(Objects.hash(extensionPoint, key));

        return clazz == null ? null : make(clazz);
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
        return makeLifestyle(modelClass).resolve();
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

        if (lifestyle != null) return lifestyle; // use cache

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

        // If this model is non-private or final class, we can extend it for interceptor mechanism.
        if (((Modifier.PRIVATE | Modifier.FINAL) & modifier) == 0) {
            Table<Method, Annotation> interceptables = ClassUtil.getAnnotations(actualClass);

            // Enhance the actual model class if needed.
            if (!interceptables.isEmpty()) {
                // If this exception will be thrown, it is bug of this program. So we must rethrow
                // the wrapped error in here.
                throw new Error("Write intercept code!");
                // actualClass = define(actualClass, interceptables);
            }
        }

        // Construct dependency graph for the current thred.
        Deque<Class> dependency = dependencies.resolve();
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
                Manageable manageable = (Manageable) actualClass.getAnnotation(Manageable.class);

                // Create new lifestyle for the actual model class
                lifestyle = make(manageable == null ? Prototype.class : manageable.lifestyle());
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
}
