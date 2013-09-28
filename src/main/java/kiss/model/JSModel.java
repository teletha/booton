/*
 * Copyright (C) 2013 Nameless Production Committee
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
import java.beans.Transient;
import java.io.File;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import kiss.I;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/26 13:28:35
 */
@JavaAPIProvider(Model.class)
public class JSModel {

    /** The model repository. */
    private static final Map<Class, JSModel> models = new ConcurrentHashMap();

    /** The repository of built-in codecs. */
    private static final ArrayList<Class> codecs = new ArrayList();

    // initialize
    static {
        // primitives and wrappers
        for (int i = 0; i < 8; i++) {
            codecs.add(ClassUtil.PRIMITIVES[i]);
            codecs.add(ClassUtil.WRAPPERS[i]);
        }

        // lang
        codecs.add(String.class);

        // util
        codecs.add(Locale.class);

        // net
        codecs.add(URL.class);
        codecs.add(URI.class);

        // arbitrary-precision numeric numbers
        codecs.add(BigInteger.class);
        codecs.add(BigDecimal.class);

        // io, nio
        codecs.add(File.class);
    }

    /** The {@link Class} which is represented by this {@link Model}. */
    public final Class type;

    /** The human readable identifier of this object model. */
    public final String name;

    /** The unmodifiable properties list of this object model. */
    public final List<Property> properties;

    /** The built-in codec. */
    private Codec codec = null;

    /**
     * Create Model instance.
     * 
     * @param type A target class to analyze as model.
     * @throws NullPointerException If the specified model class is <code>null</code>.
     */
    protected JSModel(Class type) {
        // Skip null check because this method can throw NullPointerException.
        // if (model == null) throw new NullPointerException("Model class shouldn't be null.");

        this.type = type;
        this.name = type.getSimpleName();

        // To avoid StackOverFlowException caused by circular reference of Model, you must define
        // this model in here.
        models.put(type, this);

        // search from built-in codecs
        codec = codecs.contains(type) || type.isEnum() ? new Codec(type) : I.find(Codec.class, type);

        // examine all methods without private, final, static or native
        Map<String, Method[]> candidates = new HashMap();

        for (Class clazz : ClassUtil.getTypes(type)) {
            for (Method method : clazz.getDeclaredMethods()) {
                // exclude the method which modifier is final, static, private or native
                if (((STATIC | PRIVATE | NATIVE) & method.getModifiers()) != 0) {
                    continue;
                }

                // exclude the method which is created by compiler
                if (method.isBridge() || method.isSynthetic()) {
                    continue;
                }
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
                if (name.length() <= prefix.length() || !name.startsWith(prefix) || Character.isLowerCase(name.charAt(prefix.length()))) {
                    continue;
                }

                // exclude the method (by parameter signature)
                if (method.getGenericParameterTypes().length != length) {
                    continue;
                }

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

        Lookup look = MethodHandles.lookup();

        // build valid properties
        ArrayList properties = new ArrayList(); // don't use type parameter to reduce footprint
        Iterator<Entry<String, Method[]>> iterator = candidates.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<String, Method[]> entry = iterator.next();
            Method[] methods = entry.getValue();

            if (methods[0] != null && methods[1] != null && ((methods[0].getModifiers() | methods[1].getModifiers()) & FINAL) == 0) {
                // create model for the property
                try {
                    Model model = load(methods[0].getGenericReturnType(), type);

                    if (model.type == load(methods[1].getGenericParameterTypes()[0], type).type) {
                        methods[0].setAccessible(true);
                        methods[1].setAccessible(true);

                        // this property is valid
                        Property property = new Property(model, entry.getKey());
                        property.accessors = new MethodHandle[] {look.unreflect(methods[0]), look.unreflect(methods[1])};
                        property.addAnnotation(methods[0]);
                        property.addAnnotation(methods[1]);

                        // register it
                        properties.add(property);
                    }
                } catch (Exception e) {
                    throw I.quiet(e);
                }
            }
        }

        // Search field properties.
        try {
            for (Field field : type.getFields()) {

                // exclude the field which modifier is final, static, private or native
                if (((STATIC | PRIVATE | NATIVE | FINAL) & field.getModifiers()) == 0) {
                    field.setAccessible(true);

                    Property property = new Property(load(field.getGenericType(), type), field.getName());
                    property.accessors = new MethodHandle[] {look.unreflectGetter(field), look.unreflectSetter(field)};
                    property.addAnnotation(field);

                    if ((TRANSIENT & field.getModifiers()) != 0) {
                        property.annotations.put(Transient.class, "");
                    }

                    // register it
                    properties.add(property);
                }
            }
        } catch (Exception e) {
            throw I.quiet(e);
        }

        // trim and sort property list
        properties.trimToSize();
        Collections.sort(properties);

        // exposed property list must be unmodifiable
        this.properties = Collections.unmodifiableList(properties);
    }

    /**
     * Find the property which has the specified name in this object model. If the suitable property
     * is not found, <code>null</code> is returned.
     * 
     * @param propertyName A name of property.
     * @return A suitable property or <code>null</code>.
     */
    public Property getProperty(String propertyName) {
        // check whether this model is attribute or not.
        if (getCodec() == null) {
            for (Property property : properties) {
                if (property.name.equals(propertyName)) {
                    return property;
                }
            }
        }

        // API definition
        return null;
    }

    /**
     * Check whether this object model is Collection Model or not.
     * 
     * @return A result.
     */
    public boolean isCollection() {
        return false;
    }

    /**
     * <p>
     * Retrieve codec for this model.
     * </p>
     * 
     * @return An associated codec.
     */
    public Codec getCodec() {
        return codec != null ? codec : I.find(Codec.class, type);
    }

    /**
     * Returns the value of the given property in the given object.
     * 
     * @param object A object as source. This value must not be <code>null</code>,
     * @param property A property. This value must not be <code>null</code>,
     * @return A resolved property value. This value may be <code>null</code>.
     * @throws IllegalArgumentException If the given object can't resolve the given property.
     */
    public Object get(Object object, Property property) {
        try {
            return property.accessors[0].invoke(object);
        } catch (Throwable e) {
            throw I.quiet(e);
        }
    }

    /**
     * Change the given property in the given object to the given new property value.
     * 
     * @param object A object as source. This value must not be <code>null</code>,
     * @param property A property. This value must not be <code>null</code>,
     * @param propertyValue A new property value that you want to set. This value accepts
     *            <code>null</code>.
     * @throws IllegalArgumentException If the given object can't resolve the given property.
     */
    public void set(Object object, Property property, Object propertyValue) {
        try {
            property.accessors[1].invoke(object, propertyValue);
        } catch (Throwable e) {
            throw I.quiet(e);
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
    public void walk(Object object, PropertyWalker walker) {
        // check whether this model is attribute or not.
        if (walker != null && getCodec() == null) {
            for (Property property : properties) {
                Object value = get(object, property);

                if (value != null) walker.walk((Model) (Object) this, property, value);
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
    public static Model load(Class modelClass) {
        // check whether the specified model class is enhanced or not
        if (modelClass.isSynthetic()) {
            modelClass = modelClass.getSuperclass();
        } else if (Path.class.isAssignableFrom(modelClass)) {
            modelClass = Path.class;
        }

        // check cache
        Model model = (Model) (Object) models.get(modelClass);

        if (model == null) {
            // create new model
            if (List.class.isAssignableFrom(modelClass)) {
                model = new ListModel(modelClass, ClassUtil.getParameter(modelClass, List.class)[0], List.class);
            } else if (Map.class.isAssignableFrom(modelClass)) {
                model = new MapModel(modelClass, ClassUtil.getParameter(modelClass, Map.class), Map.class);
            } else {
                model = new Model(modelClass);
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
    static Model load(Type type, Type base) {
        // class
        if (type instanceof Class) {
            return load((Class) type);
        }

        // parameterized type
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterized = (ParameterizedType) type;
            Class clazz = (Class) parameterized.getRawType();

            // ListModel
            if (List.class.isAssignableFrom(clazz)) {
                return new ListModel(clazz, parameterized.getActualTypeArguments()[0], base);
            }

            // MapModel
            if (Map.class.isAssignableFrom(clazz)) {
                return new MapModel(clazz, parameterized.getActualTypeArguments(), base);
            }

            // ClassModel
            return load(clazz);
        }

        // wildcard type
        if (type instanceof WildcardType) {
            WildcardType wildcard = (WildcardType) type;

            Type[] types = wildcard.getLowerBounds();

            if (types.length != 0) {
                return load(types[0], base);
            }

            types = wildcard.getUpperBounds();

            if (types.length != 0) {
                return load(types[0], base);
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
                        return load(variable.getBounds()[0], base);
                    } else {
                        return load(ClassUtil.getParameter(base, (Class) variable.getGenericDeclaration())[i], base);
                    }
                }
            }
        }

        // generic array type
        if (type instanceof GenericArrayType) {
            return load(((GenericArrayType) type).getGenericComponentType(), base);
        }

        // If this error will be thrown, it is bug of this program. Please send a bug report to us.
        throw new Error();
    }
}
