/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss.model;

import static java.lang.reflect.Modifier.*;

import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

import javafx.beans.value.WritableValue;

import booton.translator.JavaAPIProvider;
import kiss.ClassVariable;
import kiss.Decoder;
import kiss.Encoder;
import kiss.I;
import kiss.Table;
import kiss.Ⅲ;

/**
 * @version 2016/09/10 19:25:13
 */
@JavaAPIProvider(Model.class)
public class JSModel<M> {

    /** The model repository. */
    static final ClassVariable<Model> models = new ClassVariable();

    /** The {@link Class} which is represented by this {@link Model}. */
    public final Class<M> type;

    /** The human readable identifier of this object model. */
    public final String name;

    /** The attribute type or object type. */
    public final boolean attribute;

    /** The unmodifiable properties list of this object model. */
    private List<Property> properties = Collections.EMPTY_LIST;

    /**
     * Create Model instance.
     * 
     * @param type A target class to analyze as model.
     * @throws NullPointerException If the specified model class is <code>null</code>.
     */
    JSModel(Class type) {
        // Skip null check because this method can throw NullPointerException.
        // if (type == null) throw new NullPointerException("Model class shouldn't be null.");
        this.type = type;
        this.name = type.getSimpleName();
        this.attribute = I.find(Decoder.class, type) != null;
    }

    void init() {
        // To avoid StackOverFlowException caused by circular reference of Model, you must define
        // this model in here.
        models.set(type, (Model) (Object) this);

        try {
            // examine all methods without private, final, static or native
            Map<String, Method[]> candidates = new HashMap();

            for (Class clazz : Model.collectTypes(type)) {
                for (Method method : clazz.getDeclaredMethods()) {
                    // exclude the method which modifier is final, static, private or native
                    if (((STATIC | PRIVATE | NATIVE) & method.getModifiers()) == 0) {
                        // exclude the method which is created by compiler
                        if (!method.isBridge() && !method.isSynthetic()) {
                            // if (method.getAnnotations().length != 0) {
                            // intercepts.add(method);
                            // }

                            int length = 1;
                            String prefix = "set";
                            String name = method.getName();

                            if (method.getGenericReturnType() != Void.TYPE) {
                                length = 0;
                                prefix = name.charAt(0) == 'i' ? "is" : "get";
                            }

                            // exclude the method (by name)
                            if (prefix.length() < name.length() && name.startsWith(prefix) && !Character
                                    .isLowerCase(name.charAt(prefix.length()))) {
                                // exclude the method (by parameter signature)
                                if (method.getGenericParameterTypes().length == length) {
                                    // compute property name
                                    name = Introspector.decapitalize(name.substring(prefix.length()));

                                    // store a candidate of property accessor
                                    Method[] methods = candidates.get(name);

                                    if (methods == null) {
                                        methods = new Method[2];
                                        candidates.put(name, methods);
                                    }

                                    if (methods[length] == null) {
                                        methods[length] = method;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Lookup look = MethodHandles.lookup();

            // build valid properties
            ArrayList properties = new ArrayList(); // don't use type parameter to reduce footprint

            for (Entry<String, Method[]> entry : candidates.entrySet()) {
                Method[] methods = entry.getValue();

                if (methods[0] != null && methods[1] != null && ((methods[0].getModifiers() | methods[1].getModifiers()) & FINAL) == 0) {
                    // create model for the property
                    try {
                        Model model = of(methods[0].getGenericReturnType(), type);

                        if (of(methods[1].getGenericParameterTypes()[0], type).type.isAssignableFrom(model.type)) {
                            methods[0].setAccessible(true);
                            methods[1].setAccessible(true);

                            // this property is valid
                            Property property = new Property(model, entry.getKey(), methods);
                            property.accessors = new MethodHandle[] {look.unreflect(methods[0]), look.unreflect(methods[1])};

                            // register it
                            properties.add(property);
                        }
                    } catch (Exception e) {
                        throw I.quiet(e);
                    }
                }
            }

            // Search field properties.
            for (Field field : type.getFields()) {
                // exclude the field which modifier is static, private or native
                int modifier = field.getModifiers();

                if (((STATIC | PRIVATE | NATIVE) & modifier) == 0) {
                    Model fieldModel = of(field.getGenericType(), type);

                    if (WritableValue.class.isAssignableFrom(fieldModel.type)) {
                        // property
                        Property property = new Property(of(fieldModel.type.getMethod("getValue").getGenericReturnType(), field
                                .getGenericType()), field.getName());
                        property.accessors = new MethodHandle[] {look.unreflectGetter(field), null};
                        property.type = 2;

                        // register it
                        properties.add(property);
                    } else if ((FINAL & modifier) == 0) {
                        // field
                        field.setAccessible(true);

                        Property property = new Property(fieldModel, field.getName(), field);
                        property.accessors = new MethodHandle[] {look.unreflectGetter(field), look.unreflectSetter(field)};
                        property.type = 1;

                        // register it
                        properties.add(property);
                    }
                }
            }

            // trim and sort property list
            properties.trimToSize();
            Collections.sort(properties);

            // exposed property list must be unmodifiable
            this.properties = Collections.unmodifiableList(properties);
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * Find the property which has the specified name in this object model. If the suitable property
     * is not found, <code>null</code> is returned.
     * 
     * @param propertyName A name of property.
     * @return A suitable property or <code>null</code>.
     */
    public Property property(String propertyName) {
        // check whether this model is attribute or not.
        for (Property property : properties) {
            if (property.name.equals(propertyName)) {
                return property;
            }
        }

        // API definition
        return null;
    }

    /**
     * <p>
     * List up all properties.
     * </p>
     * 
     * @return
     */
    public List<Property> properties() {
        return this.properties;
    }

    /**
     * <p>
     * Retrieve {@link Decoder} for this model.
     * </p>
     * 
     * @return An associated {@link Decoder}.
     */
    public M decode(String value) {
        return ((Decoder<M>) I.find(Decoder.class, type)).decode(value);
    }

    /**
     * <p>
     * Retrieve {@link Encoder} for this model.
     * </p>
     * 
     * @return An associated {@link Encoder}.
     */
    public String encode(M value) {
        return I.find(Encoder.class, type).encode(value);
    }

    /**
     * Returns the value of the given property in the given object.
     * 
     * @param object A object as source. This value must not be <code>null</code>,
     * @param property A property. This value must not be <code>null</code>,
     * @return A resolved property value. This value may be <code>null</code>.
     * @throws IllegalArgumentException If the given object can't resolve the given property.
     */
    public Object get(M object, Property property) {
        if (object == null || property == null) {
            return null;
        }

        try {
            if (property.type == 2) {
                // property access
                return ((WritableValue) property.accessors[0].invoke(object)).getValue();
            } else {
                // field or method access
                return property.accessors[0].invoke(object);
            }
        } catch (Throwable e) {
            throw I.quiet(e);
        }
    }

    /**
     * Change the given property in the given object to the given new property value.
     * 
     * @param object A object as source. This value must not be <code>null</code>,
     * @param property A property. This value must not be <code>null</code>,
     * @param value A new property value that you want to set. This value accepts <code>null</code>.
     * @throws IllegalArgumentException If the given object can't resolve the given property.
     */
    public void set(M object, Property property, Object value) {
        if (object != null && property != null) {
            try {
                if (property.type == 2) {
                    // property access
                    ((WritableValue) property.accessors[0].invoke(object)).setValue(value);
                } else {
                    // field or method access
                    Class type = property.model.type;

                    if ((!type.isPrimitive() && !type.isEnum()) || value != null) {
                        property.accessors[1].invoke(object, value);
                    }
                }
            } catch (Throwable e) {
                throw I.quiet(e);
            }
        }
    }

    /**
     * Iterate over all properties in the given object and propagate the property and it's value to
     * the given {@link PropertyWalker}.
     * 
     * @param object A object as source. This value must not be <code>null</code>,
     * @param walker A property iterator. This value accepts <code>null</code>.
     * @see PropertyWalker#walk(Model, Property, Object)
     */
    public void walk(M object, Consumer<Ⅲ<Model<M>, Property, Object>> walker) {
        // check whether this model is attribute or not.
        if (walker != null) {
            for (Property property : properties) {
                Object value = get(object, property);

                if (value != null) walker.accept(I.pair((Model) (Object) this, property, value));
            }
        }
    }

    /**
     * <p>
     * Utility method to retrieve the cached model. If the model of the given class is not found,
     * {@link IllegalArgumentException} will be thrown.
     * </p>
     * <p>
     * If the given model has no cached information, it will be created automatically. This
     * operation is thread-safe.
     * </p>
     * <p>
     * Note : All classes do not necessary have each information. Some classes might share same
     * {@link Model} object. (e.g. AutoGenerated Class)
     * </p>
     * 
     * @param modelClass A model class.
     * @return The information about the given model class.
     * @throws NullPointerException If the given model class is null.
     * @throws IllegalArgumentException If the given model class is not found.
     */
    public static <M> Model<M> of(M modelType) {
        return of((Class<M>) modelType.getClass());
    }

    /**
     * <p>
     * Utility method to retrieve the cached model. If the model of the given class is not found,
     * {@link IllegalArgumentException} will be thrown.
     * </p>
     * <p>
     * If the given model has no cached information, it will be created automatically. This
     * operation is thread-safe.
     * </p>
     * <p>
     * Note : All classes do not necessary have each information. Some classes might share same
     * {@link Model} object. (e.g. AutoGenerated Class)
     * </p>
     * 
     * @param modelClass A model class.
     * @return The information about the given model class.
     * @throws NullPointerException If the given model class is null.
     * @throws IllegalArgumentException If the given model class is not found.
     */
    public static <M> Model<M> of(Class<? super M> modelClass) {
        // check whether the specified model class is enhanced or not
        if (modelClass.isSynthetic()) {
            modelClass = modelClass.getSuperclass();
        }

        // check cache
        Model model = models.get(modelClass);

        if (model == null) {
            // create new model
            if (List.class.isAssignableFrom(modelClass)) {
                model = new ListModel(modelClass, Model.collectParameters(modelClass, List.class), List.class);
            } else if (Map.class.isAssignableFrom(modelClass)) {
                model = new MapModel(modelClass, Model.collectParameters(modelClass, Map.class), Map.class);
            } else {
                model = new Model(modelClass);
                model.init();
            }
        }

        // API definition
        return model;
    }

    /**
     * <p>
     * Utility method to retrieve the cached model. If the model of the given type is not found,
     * {@link IllegalArgumentException} will be thrown.
     * </p>
     * 
     * @param type A target type to analyze.
     * @param base A declaration class.
     * @return A cached model information.
     * @throws IllegalArgumentException If the given model type is null.
     * @see TypeVariable
     */
    static Model of(Type type, Type base) {
        // class
        if (type instanceof Class) {
            return of((Class) type);
        }

        // parameterized type
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterized = (ParameterizedType) type;
            Class clazz = (Class) parameterized.getRawType();

            // ListModel
            if (List.class.isAssignableFrom(clazz)) {
                return new ListModel(clazz, parameterized.getActualTypeArguments(), base);
            }

            // MapModel
            if (Map.class.isAssignableFrom(clazz)) {
                return new MapModel(clazz, parameterized.getActualTypeArguments(), base);
            }

            // ClassModel
            return of(clazz);
        }

        // wildcard type
        if (type instanceof WildcardType) {
            WildcardType wildcard = (WildcardType) type;

            Type[] types = wildcard.getLowerBounds();

            if (types.length != 0) {
                return of(types[0], base);
            }

            types = wildcard.getUpperBounds();

            if (types.length != 0) {
                return of(types[0], base);
            }
        }

        // variable type
        if (type instanceof TypeVariable) {
            TypeVariable variable = (TypeVariable) type;
            TypeVariable[] variables = variable.getGenericDeclaration().getTypeParameters();

            for (int i = 0; i < variables.length; i++) {
                // use equals method instead of "==".
                //
                // +++ From TypeVariable Javadoc +++
                // Multiple objects may be instantiated at run-time to represent a given type
                // variable. Even though a type variable is created only once, this does not imply
                // any requirement to cache instances representing the type variable. However, all
                // instances representing a type variable must be equal() to each other. As a
                // consequence, users of type variables must not rely on the identity of instances
                // of classes implementing this interface.
                if (variable.equals(variables[i])) {
                    if (base == variable.getGenericDeclaration()) {
                        return of(variable.getBounds()[0], base);
                    } else {
                        return of(Model.collectParameters(base, variable.getGenericDeclaration())[i], base);
                    }
                }
            }
        }

        // generic array type
        if (type instanceof GenericArrayType) {
            return of(((GenericArrayType) type).getGenericComponentType(), base);
        }

        // If this error will be thrown, it is bug of this program. Please send a bug report to us.
        throw new Error();
    }

    /**
     * <p>
     * Collect all annotated methods and thire annotations.
     * </p>
     * 
     * @param clazz A target class.
     * @return A table of method and annnotations.
     */
    public static Table<Method, Annotation> collectAnnotatedMethods(Class clazz) {
        Table<Method, Annotation> table = new Table();

        for (Class type : collectTypes(clazz)) {
            for (Method method : type.getDeclaredMethods()) {
                // exclude the method which is created by compiler
                // exclude the private method which is not declared in the specified class
                if (!method.isBridge() && !method
                        .isSynthetic() && (((method.getModifiers() & Modifier.PRIVATE) == 0) || method.getDeclaringClass() == clazz)) {
                    Annotation[] annotations = method.getAnnotations();

                    if (annotations.length != 0) {
                        List<Annotation> list = new ArrayList();

                        // disclose container annotation
                        for (Annotation annotation : annotations) {
                            try {
                                Class annotationType = annotation.annotationType();
                                Method value = annotationType.getMethod("value");
                                Class returnType = value.getReturnType();

                                if (returnType.isArray()) {
                                    Class<?> componentType = returnType.getComponentType();
                                    Repeatable repeatable = componentType.getAnnotation(Repeatable.class);

                                    if (repeatable != null && repeatable.value() == annotationType) {
                                        value.setAccessible(true);

                                        Collections.addAll(list, (Annotation[]) value.invoke(annotation));
                                        continue;
                                    }
                                }
                            } catch (Exception e) {
                                // do nothing
                            }
                            list.add(annotation);
                        }

                        // check method overriding
                        for (Method candidate : table.keySet()) {
                            if (candidate.getName().equals(method.getName()) && Arrays
                                    .deepEquals(candidate.getParameterTypes(), method.getParameterTypes())) {
                                method = candidate; // detect overriding
                                break;
                            }
                        }

                        add: for (Annotation annotation : list) {
                            Class annotationType = annotation.annotationType();

                            if (!annotationType.isAnnotationPresent(Repeatable.class)) {
                                for (Annotation item : table.get(method)) {
                                    if (item.annotationType() == annotationType) {
                                        continue add;
                                    }
                                }
                            }

                            table.push(method, annotation);
                        }
                    }
                }
            }
        }
        return table;
    }

    /**
     * <p>
     * > Collect all constructors which are defined in the specified {@link Class}. If the given
     * class is interface, primitive types, array class or <code>void</code>,
     * <code>empty array</code> will be return.
     * </p>
     * 
     * @param <T> A class type.
     * @param clazz A target class.
     * @return A collected constructors.
     */
    public static <T> Constructor<T>[] collectConstructors(Class<T> clazz) {
        Constructor[] constructors = clazz.getDeclaredConstructors();
        Arrays.sort(constructors, Comparator.<Constructor> comparingInt(Constructor::getParameterCount));
        return constructors;
    }

    /**
     * <p>
     * Collect all classes which are extended or implemented by the target class.
     * </p>
     * 
     * @param clazz A target class. <code>null</code> will be return the empty set.
     * @return A set of classes, with predictable bottom-up iteration order.
     */
    public static Set<Class> collectTypes(Class clazz) {
        // check null
        if (clazz == null) {
            return Collections.EMPTY_SET;
        }

        // container
        Set<Class> set = new LinkedHashSet(); // order is important

        // add current class
        set.add(clazz);

        // add super class
        set.addAll(collectTypes(clazz.getSuperclass()));

        // add interface classes
        for (Class c : clazz.getInterfaces()) {
            set.addAll(collectTypes(c));
        }

        // API definition
        return set;
    }

    /**
     * <p>
     * List up all target types which are implemented or extended by the specified class.
     * </p>
     * 
     * @param type A class type which implements(extends) the specified target interface(class).
     *            <code>null</code> will be return the zero-length array.
     * @param target A target type to list up types. <code>null</code> will be return the
     *            zero-length array.
     * @return A list of actual types.
     */
    public static Type[] collectParameters(Type type, GenericDeclaration target) {
        return collectParameters(type, target, type);
    }

    /**
     * <p>
     * List up all target types which are implemented or extended by the specified class.
     * </p>
     * 
     * @param clazz A class type which implements(extends) the specified target interface(class).
     *            <code>null</code> will be return the zero-length array.
     * @param target A target type to list up types. <code>null</code> will be return the
     *            zero-length array.
     * @param base A base class type.
     * @return A list of actual types.
     */
    private static Type[] collectParameters(Type clazz, GenericDeclaration target, Type base) {
        // check null
        if (clazz == null || clazz == target) {
            return new Class[0];
        }

        // compute actual class
        Class raw = clazz instanceof Class ? (Class) clazz : Model.of(clazz, base).type;

        // collect all types
        Set<Type> types = new HashSet();
        types.add(clazz);
        types.add(raw.getGenericSuperclass());
        Collections.addAll(types, raw.getGenericInterfaces());

        // check them all
        for (Type type : types) {
            // check ParameterizedType
            if (type instanceof ParameterizedType) {
                ParameterizedType param = (ParameterizedType) type;
                param.getOwnerType();

                // check raw type
                if (target == param.getRawType()) {
                    Type[] args = param.getActualTypeArguments();

                    for (int i = 0; i < args.length; i++) {
                        if (args[i] instanceof TypeVariable) {
                            args[i] = Model.of(args[i], base).type;
                        }
                    }
                    return args;
                }
            }
        }

        // search from superclass
        Type[] parameters = collectParameters(raw.getGenericSuperclass(), target, base);

        if (parameters.length != 0) {
            return parameters;
        }

        // search from interfaces
        for (Type type : raw.getInterfaces()) {
            parameters = collectParameters(type, target, base);

            if (parameters.length != 0) {
                return parameters;
            }
        }
        return parameters;
    }
}
