/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import static js.lang.Global.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import js.util.ArrayList;
import js.util.HashMap;
import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Class} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/01/17 15:58:55
 */
@JavaAPIProvider(Class.class)
class JSClass<T> extends JSAnnotatedElement {

    /** The class definition in runtime. */
    private final NativeObject clazz;

    /** The annotation in runtime. */
    private final NativeObject annotations;

    /** The super class. */
    private final Class superclass;

    /** The interface classes. */
    private final Class[] interfaces;

    /** The cache for enum constants. */
    private Map<String, Enum> enumerationConstants;

    /**
     * <p>
     * Create native class.
     * </p>
     * 
     * @param name
     * @param clazz
     * @param annotations
     */
    private JSClass(String name, NativeObject clazz, NativeObject annotations, Class superclass, String[] interfaces) {
        super(name, annotations.getPropertyAs(NativeArray.class, "$"));

        this.clazz = clazz;
        this.annotations = annotations;
        this.superclass = superclass;
        this.interfaces = new Class[interfaces.length];

        for (int i = 0; i < interfaces.length; i++) {
            this.interfaces[i] = forName(interfaces[i]);
        }
    }

    /**
     * <p>
     * Returns an array containing Constructor objects reflecting all the public constructors of the
     * class represented by this Class object. An array of length 0 is returned if the class has no
     * public constructors, or if the class is an array class, or if the class reflects a primitive
     * type or void. Note that while this method returns an array of Constructor<T> objects (that is
     * an array of constructors from this class), the return type of this method is Constructor<?>[]
     * and not Constructor<T>[] as might be expected. This less informative return type is necessary
     * since after being returned from this method, the array could be modified to hold Constructor
     * objects for different classes, which would violate the type guarantees of Constructor<T>[].
     * </p>
     * 
     * @return The array of Constructor objects representing the public constructors of this class.
     */
    public Constructor[] getConstructors() {
        NativeArray<JSConstructor> container = new NativeArray();

        for (String name : clazz.keys()) {
            if (name.startsWith("$")) {
                container.push(new JSConstructor(name, clazz, clazz.getPropertyAs(NativeFunction.class, name), annotations.getPropertyAs(NativeArray.class, name)));
            }
        }
        return (Constructor[]) (Object) container;
    }

    /**
     * <p>
     * Returns an array containing Method objects reflecting all the public member methods of the
     * class or interface represented by this Class object, including those declared by the class or
     * interface and those inherited from superclasses and superinterfaces. Array classes return all
     * the (public) member methods inherited from the Object class. The elements in the array
     * returned are not sorted and are not in any particular order. This method returns an array of
     * length 0 if this Class object represents a class or interface that has no public member
     * methods, or if this Class object represents a primitive type or void.
     * </p>
     * 
     * @return The array of Method objects representing the public methods of this class.
     */
    public Method[] getMethods() {
        Class clazz = (Class) (Object) this;
        List<Method> methods = new ArrayList();

        while (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                methods.add(method);
            }
            clazz = clazz.getSuperclass();
        }
        return methods.toArray(new Method[methods.size()]);
    }

    /**
     * <p>
     * Returns an array of Method objects reflecting all the methods declared by the class or
     * interface represented by this Class object. This includes public, protected, default
     * (package) access, and private methods, but excludes inherited methods. The elements in the
     * array returned are not sorted and are not in any particular order. This method returns an
     * array of length 0 if the class or interface declares no methods, or if this Class object
     * represents a primitive type, an array class, or void. The class initialization method
     * <clinit> is not included in the returned array. If the class declares multiple public member
     * methods with the same parameter types, they are all included in the returned array.
     * </p>
     * 
     * @return The array of Method objects representing all the declared methods of this class.
     */
    public Method[] getDeclaredMethods() {
        NativeArray<JSMethod> container = new NativeArray();

        // collect non-static methods only
        for (String name : clazz.keys()) {
            if (!name.startsWith("$")) {
                container.push(new JSMethod(name, clazz, annotations.getPropertyAs(NativeArray.class, name)));
            }
        }

        // API definition
        return (Method[]) (Object) container;
    }

    /**
     * <p>
     * Returns an array containing Field objects reflecting all the accessible public fields of the
     * class or interface represented by this Class object. The elements in the array returned are
     * not sorted and are not in any particular order. This method returns an array of length 0 if
     * the class or interface has no accessible public fields, or if it represents an array class, a
     * primitive type, or void.
     * </p>
     * <p>
     * Specifically, if this Class object represents a class, this method returns the public fields
     * of this class and of all its superclasses. If this Class object represents an interface, this
     * method returns the fields of this interface and of all its superinterfaces.
     * </p>
     * <p>
     * The implicit length field for array class is not reflected by this method. User code should
     * use the methods of class Array to manipulate arrays.
     * </p>
     * 
     * @return The array of Field objects representing the public fields.
     */
    public Field getField(String name) {
        return null;
    }

    /**
     * <p>
     * Returns an array containing Field objects reflecting all the accessible public fields of the
     * class or interface represented by this Class object. The elements in the array returned are
     * not sorted and are not in any particular order. This method returns an array of length 0 if
     * the class or interface has no accessible public fields, or if it represents an array class, a
     * primitive type, or void.
     * </p>
     * <p>
     * Specifically, if this Class object represents a class, this method returns the public fields
     * of this class and of all its superclasses. If this Class object represents an interface, this
     * method returns the fields of this interface and of all its superinterfaces.
     * </p>
     * <p>
     * The implicit length field for array class is not reflected by this method. User code should
     * use the methods of class Array to manipulate arrays.
     * </p>
     * 
     * @return The array of Field objects representing the public fields.
     */
    public Field[] getFields() {
        return null;
    }

    /**
     * <p>
     * Returns an array of {@code Field} objects reflecting all the fields declared by the class or
     * interface represented by this {@code Class} object. This includes public, protected, default
     * (package) access, and private fields, but excludes inherited fields. The elements in the
     * array returned are not sorted and are not in any particular order. This method returns an
     * array of length 0 if the class or interface declares no fields, or if this {@code Class}
     * object represents a primitive type, an array class, or void.
     * </p>
     * <p>
     * See <em>The Java Language Specification</em>, sections 8.2 and 8.3.
     * </p>
     * 
     * @return the array of {@code Field} objects representing all the declared fields of this class
     * @exception SecurityException If a security manager, <i>s</i>, is present and any of the
     *                following conditions is met:
     *                <ul>
     *                <li>invocation of {@link SecurityManager#checkMemberAccess
     *                s.checkMemberAccess(this, Member.DECLARED)} denies access to the declared
     *                fields within this class
     *                <li>the caller's class loader is not the same as or an ancestor of the class
     *                loader for the current class and invocation of
     *                {@link SecurityManager#checkPackageAccess s.checkPackageAccess()} denies
     *                access to the package of this class
     *                </ul>
     * @since JDK1.1
     */
    public Field[] getDeclaredFields() throws SecurityException {
        NativeArray<JSField> container = new NativeArray();

        // collect non-static field only
        for (String name : clazz.keys()) {
            if (!name.startsWith("$")) {
                container.push(new JSField(name, clazz, annotations.getPropertyAs(NativeArray.class, name)));
            }
        }

        // API definition
        return (Field[]) (Object) container;
    }

    /**
     * <p>
     * Determines if the class or interface represented by this Class object is either the same as,
     * or is a superclass or superinterface of, the class or interface represented by the specified
     * Class parameter. It returns true if so; otherwise it returns false. If this Class object
     * represents a primitive type, this method returns true if the specified Class parameter is
     * exactly this Class object; otherwise it returns false.
     * </p>
     * <p>
     * Specifically, this method tests whether the type represented by the specified Class parameter
     * can be converted to the type represented by this Class object via an identity conversion or
     * via a widening reference conversion. See The Java Language Specification, sections 5.1.1 and
     * 5.1.4 , for details.
     * </p>
     * 
     * @param clazz The Class object to be checked.
     * @return The boolean value indicating whether objects of the type cls can be assigned to
     *         objects of this class.
     */
    public boolean isAssignableFrom(Class<?> clazz) {
        while (clazz != null) {
            // match against class
            if (this == (Object) clazz) {
                return true;
            }

            // match agains interfaces
            for (Class type : clazz.getInterfaces()) {
                if (isAssignableFrom(type)) {
                    return true;
                }
            }
            clazz = clazz.getSuperclass();
        }
        return false;
    }

    /**
     * <p>
     * Determines if the specified {@code Object} is assignment-compatible with the object
     * represented by this {@code Class}. This method is the dynamic equivalent of the Java language
     * {@code instanceof} operator. The method returns {@code true} if the specified {@code Object}
     * argument is non-null and can be cast to the reference type represented by this {@code Class}
     * object without raising a {@code ClassCastException.} It returns {@code false} otherwise.
     * </p>
     * <p>
     * Specifically, if this {@code Class} object represents a declared class, this method returns
     * {@code true} if the specified {@code Object} argument is an instance of the represented class
     * (or of any of its subclasses); it returns {@code false} otherwise. If this {@code Class}
     * object represents an array class, this method returns {@code true} if the specified
     * {@code Object} argument can be converted to an object of the array class by an identity
     * conversion or by a widening reference conversion; it returns {@code false} otherwise. If this
     * {@code Class} object represents an interface, this method returns {@code true} if the class
     * or any superclass of the specified {@code Object} argument implements this interface; it
     * returns {@code false} otherwise. If this {@code Class} object represents a primitive type,
     * this method returns {@code false}.
     * </p>
     * 
     * @param instance The object to check.
     * @return True if {@code instance} is an instance of this class.
     */
    public boolean isInstance(Object instance) {
        return isAssignableFrom(instance.getClass());
    }

    /**
     * <p>
     * Returns the Class representing the superclass of the entity (class, interface, primitive type
     * or void) represented by this Class. If this Class represents either the Object class, an
     * interface, a primitive type, or void, then null is returned. If this object represents an
     * array class then the Class object representing the Object class is returned.
     * </p>
     * 
     * @return The superclass of the class represented by this object.
     */
    public Class<? super T> getSuperclass() {
        return superclass;
    }

    /**
     * <p>
     * Determines the interfaces implemented by the class or interface represented by this object.
     * </p>
     * <p>
     * If this object represents an interface, the array contains objects representing all
     * interfaces extended by the interface. The order of the interface objects in the array
     * corresponds to the order of the interface names in the extends clause of the declaration of
     * the interface represented by this object.
     * </p>
     * <p>
     * If this object represents a class or interface that implements no interfaces, the method
     * returns an array of length 0.
     * </p>
     * <p>
     * If this object represents a primitive type or void, the method returns an array of length 0.
     * </p>
     * 
     * @return
     */
    public Class<?>[] getInterfaces() {
        return interfaces;
    }

    /**
     * <p>
     * Returns the name of the entity (class, interface, array class, primitive type, or void)
     * represented by this Class object, as a String.
     * </p>
     * <p>
     * If this class object represents a reference type that is not an array type then the binary
     * name of the class is returned, as specified by The Java™ Language Specification.
     * </p>
     * <p>
     * If this class object represents a primitive type or void, then the name returned is a String
     * equal to the Java language keyword corresponding to the primitive type or void.
     * </p>
     * 
     * @return
     */
    public String getName() {
        return "boot." + name;
    }

    /**
     * <p>
     * Returns the simple name of the underlying class as given in the source code. Returns an empty
     * string if the underlying class is anonymous.
     * </p>
     * <p>
     * The simple name of an array is the simple name of the component type with "[]" appended. In
     * particular the simple name of an array whose component type is anonymous is "[]".
     * </p>
     * 
     * @return The simple name of the underlying class.
     */
    public String getSimpleName() {
        return name;
    }

    /**
     * <p>
     * Returns the canonical name of the underlying class as defined by the Java Language
     * Specification. Returns null if the underlying class does not have a canonical name (i.e., if
     * it is a local or anonymous class or an array whose component type does not have a canonical
     * name).
     * </p>
     * 
     * @return the canonical name of the underlying class if it exists, and {@code null} otherwise.
     * @since 1.5
     */
    public String getCanonicalName() {
        return name;
    }

    /**
     * <p>
     * Creates a new instance of the class represented by this Class object. The class is
     * instantiated as if by a new expression with an empty argument list. The class is initialized
     * if it has not already been initialized.
     * </p>
     * <p>
     * Note that this method propagates any exception thrown by the nullary constructor, including a
     * checked exception. Use of this method effectively bypasses the compile-time exception
     * checking that would otherwise be performed by the compiler. The Constructor.newInstance
     * method avoids this problem by wrapping any exception thrown by the constructor in a (checked)
     * InvocationTargetException.
     * </p>
     * 
     * @return A newly allocated instance of the class represented by this object.
     */
    public Object newInstance() {
        try {
            return getConstructors()[0].newInstance();
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public Constructor getConstructor() {
        return null;
    }

    /**
     * <p>
     * Returns a map from simple name to enum constant. This package-private method is used
     * internally by Enum to implement public static <T extends Enum<T>> T valueOf(Class<T>, String)
     * efficiently.
     * </p>
     * <p>
     * Note that the map is returned by this method is created lazily on first use. Typically it
     * won't ever get created.
     * </p>
     */
    public Map<String, Enum> enumConstantDirectory() {
        if (enumerationConstants == null) {
            enumerationConstants = new HashMap();

            NativeObject definition = clazz.getPropertyAs(NativeObject.class, "$");

            for (String name : definition.keys()) {
                NativeObject value = definition.getPropertyAs(NativeObject.class, name);

                if (value.isArray()) {
                    for (Enum item : (Enum[]) (Object) value) {
                        enumerationConstants.put(item.name(), item);
                    }
                }
            }
        }
        return enumerationConstants;
    }

    /**
     * <p>
     * Returns the Class object associated with the class or interface with the given string name.
     * </p>
     * 
     * @param fqcn The fully qualified name of the desired class.
     * @return The Class object for the class with the specified name.
     */
    public static Class forName(String fqcn) {
        return (Class) boot.getPropertyAs(NativeObject.class, fqcn).getProperty("$");
    }
}