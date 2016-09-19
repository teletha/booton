/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;

/**
 * @version 2013/12/12 15:53:53
 */
abstract class JSAnnotatedElement implements AnnotatedElement {

    /** The property name at Java definition. */
    protected final String name;

    /** The property name at JavaScript runtime. */
    protected final String nameJS;

    /** The modifier value. */
    protected final int modifiers;

    /** The metadata definition in runtime. */
    protected final NativeArray<?> metadata;

    /** The annotation definition in runtime. */
    protected final NativeObject annotations;

    /** The cache for declared {@link Annotation}. */
    private Map<Class, Annotation> privateAnnotations;

    /** The cache for declaration {@link TypeVariable}. */
    private List<Type> types;

    /**
     * <p>
     * Create {@link AnnotatedElement} in Javascript runtime.
     * </p>
     * 
     * @param name The property name at Java definition.
     * @param nameJS The property name at JavaScript runtime.
     * @param metadata A metadata difinition.
     * @param annotations
     */
    protected JSAnnotatedElement(String name, String nameJS, NativeArray<?> metadata, int indexForAnnotation) {
        this.name = name;
        this.nameJS = nameJS;
        this.metadata = metadata;
        this.annotations = metadata.get(indexForAnnotation, new NativeObject());
        this.modifiers = metadata.getAsInt(0, 0);
    }

    /**
     * Returns the Java language modifiers for this class or interface, encoded in an integer. The
     * modifiers consist of the Java Virtual Machine's constants for {@code public},
     * {@code protected}, {@code private}, {@code final}, {@code static}, {@code abstract} and
     * {@code interface}; they should be decoded using the methods of class {@code Modifier}.
     * <p>
     * If the underlying class is an array class, then its {@code public}, {@code private} and
     * {@code protected} modifiers are the same as those of its component type. If this
     * {@code Class} represents a primitive type or void, its {@code public} modifier is always
     * {@code true}, and its {@code protected} and {@code private} modifiers are always
     * {@code false}. If this object represents an array class, a primitive type or void, then its
     * {@code final} modifier is always {@code true} and its interface modifier is always
     * {@code false}. The values of its other modifiers are not determined by this specification.
     * <p>
     * The modifier encodings are defined in <em>The Java Virtual Machine
     * Specification</em>, table 4.1.
     * 
     * @return the {@code int} representing the modifiers for this class
     * @see java.lang.reflect.Modifier
     * @since JDK1.1
     */
    public final int getModifiers() {
        return modifiers;
    }

    /**
     * Returns an array of {@code TypeVariable} objects that represent the type variables declared
     * by the generic declaration represented by this {@code GenericDeclaration} object, in
     * declaration order. Returns an array of length 0 if the underlying generic declaration
     * declares no type variables.
     * 
     * @return an array of {@code TypeVariable} objects that represent the type variables declared
     *         by this generic declaration
     * @throws java.lang.reflect.GenericSignatureFormatError if the generic signature of this
     *             generic declaration does not conform to the format specified in <cite>The
     *             Java&trade; Virtual Machine Specification</cite>
     * @since 1.5
     */
    public final TypeVariable<Class>[] getTypeParameters() {
        if (types == null) {
            types = new Signature(metadata.get(1, ""), (GenericDeclaration) this).types;
            metadata.deleteProperty(1);
        }
        return types.toArray(new TypeVariable[types.size()]);
    }

    /**
     * <p>
     * Returns this element's annotation for the specified type if such an annotation is present,
     * else null.
     * </p>
     * 
     * @param annotationClass The Class object corresponding to the annotation type.
     * @return This element's annotation for the specified annotation type if present on this
     *         element, else null.
     */
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        Objects.requireNonNull(annotationClass);

        if (privateAnnotations == null) {
            getDeclaredAnnotations();
        }
        return (A) privateAnnotations.get(annotationClass);
    }

    /**
     * <p>
     * Returns all annotations present on this element. (Returns an array of length zero if this
     * element has no annotations.) The caller of this method is free to modify the returned array;
     * it will have no effect on the arrays returned to other callers.
     * </p>
     * 
     * @return All annotations present on this element.
     */
    @Override
    public Annotation[] getAnnotations() {
        return getDeclaredAnnotations();
    }

    /**
     * <p>
     * Returns all annotations that are directly present on this element. Unlike the other methods
     * in this interface, this method ignores inherited annotations. (Returns an array of length
     * zero if no annotations are directly present on this element.) The caller of this method is
     * free to modify the returned array; it will have no effect on the arrays returned to other
     * callers.
     * </p>
     * 
     * @return All annotations directly present on this element.
     */
    @Override
    public final Annotation[] getDeclaredAnnotations() {
        if (privateAnnotations == null) {
            privateAnnotations = new HashMap();

            for (String name : annotations.keys()) {
                Class type = JSClass.forName(name);

                privateAnnotations.put(type, (Annotation) Proxy
                        .newProxyInstance(null, new Class[] {type}, new AnnotationProxy(type, annotations.getProperty(name))));
            }
        }
        return privateAnnotations.values().toArray(new Annotation[privateAnnotations.size()]);
    }

    /**
     * Returns this element's annotation(s) for the specified type if such annotations are either
     * <em>directly present</em> or <em>indirectly present</em>. This method ignores inherited
     * annotations. If there are no specified annotations directly or indirectly present on this
     * element, the return value is an array of length 0. The difference between this method and
     * {@link #getDeclaredAnnotation(Class)} is that this method detects if its argument is a
     * <em>repeatable annotation type</em> (JLS 9.6), and if so, attempts to find one or more
     * annotations of that type by "looking through" a container annotation if one is present. The
     * caller of this method is free to modify the returned array; it will have no effect on the
     * arrays returned to other callers.
     * 
     * @implSpec The default implementation may call {@link #getDeclaredAnnotation(Class)} one or
     *           more times to find a directly present annotation and, if the annotation type is
     *           repeatable, to find a container annotation. If annotations of the annotation type
     *           {@code annotationClass} are found to be both directly and indirectly present, then
     *           {@link #getDeclaredAnnotations()} will get called to determine the order of the
     *           elements in the returned array.
     *           <p>
     *           Alternatively, the default implementation may call
     *           {@link #getDeclaredAnnotations()} a single time and the returned array examined for
     *           both directly and indirectly present annotations. The results of calling
     *           {@link #getDeclaredAnnotations()} are assumed to be consistent with the results of
     *           calling {@link #getDeclaredAnnotation(Class)}.
     * @param <T> the type of the annotation to query for and return if directly or indirectly
     *            present
     * @param annotationClass the Class object corresponding to the annotation type
     * @return all this element's annotations for the specified annotation type if directly or
     *         indirectly present on this element, else an array of length zero
     * @throws NullPointerException if the given annotation class is null
     * @since 1.8
     */
    @Override
    public <T extends Annotation> T[] getDeclaredAnnotationsByType(Class<T> annotationClass) {
        T[] annotations;
        T annotation = getDeclaredAnnotation(annotationClass);

        if (annotation != null) {
            annotations = (T[]) Array.newInstance(annotationClass, 1);
            annotations[0] = annotation;
        } else {
            Repeatable repeatable = annotationClass.getAnnotation(Repeatable.class);
            Annotation container = getDeclaredAnnotation(repeatable.value());

            if (container == null) {
                annotations = (T[]) Array.newInstance(annotationClass, 0);
            } else {
                try {
                    annotations = (T[]) container.annotationType().getMethod("value").invoke(container);
                } catch (Exception e) {
                    // If this exception will be thrown, it is bug of this program. So we must
                    // rethrow the wrapped error in here.
                    throw new Error(e);
                }
            }
        }
        return annotations;
    }

    /**
     * <p>
     * Helper method to conver {@link Type} to {@link Class}.
     * </p>
     * 
     * @param types
     * @return
     */
    protected List convert(Type[] types) {
        List<Class> classes = new ArrayList();

        for (Type type : types) {
            classes.add(Signature.convert(type));
        }
        return classes;
    }

    /**
     * @version 2013/09/24 11:02:00
     */
    protected static class AnnotationProxy implements InvocationHandler {

        /** The annotation class. */
        private final Class<? extends Annotation> type;

        /** The properties. */
        private final NativeObject object;

        /**
         * @param type
         * @param object
         */
        protected AnnotationProxy(Class type, Object object) {
            this.type = type;
            this.object = (NativeObject) object;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // from user value
            NativeFunction function = object.getPropertyAs(NativeFunction.class, ((JSMethod) (Object) method).nameJS);

            if (function != null) {
                Object value = function.apply(null);
                Class type = method.getReturnType();

                if (type.isAnnotation()) {
                    return Proxy.newProxyInstance(null, new Class[] {type}, new AnnotationProxy(type, value));
                } else if (type.isArray() && type.getComponentType().isAnnotation()) {
                    Object[] objects = (Object[]) value;
                    type = type.getComponentType();
                    Object array = Array.newInstance(type, objects.length);

                    for (int i = 0; i < objects.length; i++) {
                        Array.set(array, i, Proxy.newProxyInstance(null, new Class[] {type}, new AnnotationProxy(type, objects[i])));
                    }
                    return array;
                } else {
                    return value;
                }
            }

            String name = method.getName();

            if (name.equals("annotationType")) {
                return type;
            }

            // from default value
            return type.getMethod(name).invoke(((JSClass) (Object) type).prototype);
        }
    }
}
