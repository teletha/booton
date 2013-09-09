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
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import js.lang.NativeArray;
import js.lang.NativeFunction;
import js.lang.NativeObject;
import booton.translator.JavaAPIProvider;

/**
 * <p>
 * {@link Class} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/09/07 21:27:26
 */
@JavaAPIProvider(Class.class)
class JSClass<T> extends JSAnnotatedElement implements GenericDeclaration {

    /** The prototype definition in runtime. */
    private final NativeObject prototype;

    /** The metadata definition in runtime. */
    private final NativeObject definition;

    /** The class metadata in runtime. */
    private final NativeArray<?> metadata;

    /** The modifier value. */
    private final int modifiers;

    /** The super class. */
    private final Class superclass;

    /** The type description. */
    private final String signatures;

    /** The type description. */
    private final String signaturesSuperClass;

    /** The interface classes. */
    private List<Class> interfaces;

    /** The cache fo declaring type variables. */
    List<Type> interfacesType; // package private modifier for Proxy

    /** The cache for enum constants. */
    private Map<String, Enum> enumerationConstants;

    /** The cache for array class. */
    private JSClass arrayClass;

    /** The cache for public constructors. */
    private Map<Integer, Constructor> publicConstructors;

    /** The cache for declared constructors. */
    private Map<Integer, Constructor> privateConstructors;

    /** The cache for public methods. */
    private Map<Integer, Method> publicMethods;

    /** The cache for declared methods. */
    private Map<Integer, Method> privateMethods;

    /** The cache for public fields. */
    private Map<String, Field> publicFields;

    /** The cache for declared fields. */
    private Map<String, Field> privateFields;

    /** The cache fo declaring type variables. */
    private List<TypeVariable> parameters;

    /** The cache fo declaring type variables. */
    private Type superclassType;

    /**
     * <p>
     * Create native class.
     * </p>
     * 
     * @param nameJS A class name in JavaScript runtime.
     * @param prototype A property definition. (constructors and methods)
     * @param metadata A class metadata.
     * @param superclass A super class of this class.
     * @param interfaces All implemented interfaces.
     * @param definition A full metadata info for class, constructors, methods and fields.
     */
    protected JSClass(String nameJS, NativeObject prototype, NativeArray<?> metadata, Class superclass, NativeObject definition) {
        super(nameJS, nameJS, (NativeObject) metadata.get(4));

        this.prototype = prototype;
        this.definition = definition;
        this.metadata = metadata;
        this.modifiers = metadata.getAsInt(0, 0);
        this.superclass = superclass;

        this.signatures = (String) metadata.get(1);
        this.signaturesSuperClass = (String) metadata.get(2);
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
    public int getModifiers() {
        return modifiers;
    }

    /**
     * Returns the class loader for the class. Some implementations may use null to represent the
     * bootstrap class loader. This method will return null in such implementations if this class
     * was loaded by the bootstrap class loader.
     * <p>
     * If a security manager is present, and the caller's class loader is not null and the caller's
     * class loader is not the same as or an ancestor of the class loader for the class whose class
     * loader is requested, then this method calls the security manager's {@code checkPermission}
     * method with a {@code RuntimePermission("getClassLoader")} permission to ensure it's ok to
     * access the class loader for the class.
     * <p>
     * If this object represents a primitive type or void, null is returned.
     * 
     * @return the class loader that loaded the class or interface represented by this object.
     * @throws SecurityException if a security manager exists and its {@code checkPermission} method
     *             denies access to the class loader for the class.
     * @see java.lang.ClassLoader
     * @see SecurityManager#checkPermission
     * @see java.lang.RuntimePermission
     */
    public ClassLoader getClassLoader() {
        return null;
    }

    /**
     * Returns a {@code Constructor} object that reflects the specified public constructor of the
     * class represented by this {@code Class} object. The {@code parameterTypes} parameter is an
     * array of {@code Class} objects that identify the constructor's formal parameter types, in
     * declared order. If this {@code Class} object represents an inner class declared in a
     * non-static context, the formal parameter types include the explicit enclosing instance as the
     * first parameter.
     * <p>
     * The constructor to reflect is the public constructor of the class represented by this
     * {@code Class} object whose formal parameter types match those specified by
     * {@code parameterTypes}.
     * 
     * @param parameterTypes the parameter array
     * @return the {@code Constructor} object of the public constructor that matches the specified
     *         {@code parameterTypes}
     * @exception NoSuchMethodException if a matching method is not found.
     * @exception SecurityException If a security manager, <i>s</i>, is present and any of the
     *                following conditions is met:
     *                <ul>
     *                <li> invocation of {@link SecurityManager#checkMemberAccess
     *                s.checkMemberAccess(this, Member.PUBLIC)} denies access to the constructor 
     *                <li> the caller's class loader is not the same as or an ancestor of the class
     *                loader for the current class and invocation of
     *                {@link SecurityManager#checkPackageAccess s.checkPackageAccess()} denies
     *                access to the package of this class
     *                </ul>
     * @since JDK1.1
     */
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        if (publicConstructors == null) {
            getConstructors();
        }

        Constructor constructor = publicConstructors.get(hash("", parameterTypes));

        if (constructor == null) {
            throw new NoSuchMethodException();
        } else {
            return constructor;
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
        if (publicConstructors == null) {
            publicConstructors = new HashMap();

            for (Constructor constructor : ((Class) (Object) this).getDeclaredConstructors()) {
                if (Modifier.isPublic(constructor.getModifiers())) {
                    publicConstructors.put(hash("", constructor.getParameterTypes()), constructor);
                }
            }
        }

        // defensive copy
        return publicConstructors.values().toArray(new Constructor[publicConstructors.size()]);
    }

    /**
     * Returns a {@code Constructor} object that reflects the specified constructor of the class or
     * interface represented by this {@code Class} object. The {@code parameterTypes} parameter is
     * an array of {@code Class} objects that identify the constructor's formal parameter types, in
     * declared order. If this {@code Class} object represents an inner class declared in a
     * non-static context, the formal parameter types include the explicit enclosing instance as the
     * first parameter.
     * 
     * @param parameterTypes the parameter array
     * @return The {@code Constructor} object for the constructor with the specified parameter list
     * @exception NoSuchMethodException if a matching method is not found.
     * @exception SecurityException If a security manager, <i>s</i>, is present and any of the
     *                following conditions is met:
     *                <ul>
     *                <li>invocation of {@link SecurityManager#checkMemberAccess
     *                s.checkMemberAccess(this, Member.DECLARED)} denies access to the declared
     *                constructor
     *                <li>the caller's class loader is not the same as or an ancestor of the class
     *                loader for the current class and invocation of
     *                {@link SecurityManager#checkPackageAccess s.checkPackageAccess()} denies
     *                access to the package of this class
     *                </ul>
     * @since JDK1.1
     */
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException,
            SecurityException {
        if (privateConstructors == null) {
            getDeclaredConstructors();
        }

        Constructor constructor = privateConstructors.get(hash("", parameterTypes));

        if (constructor == null) {
            throw new NoSuchMethodException();
        } else {
            return constructor;
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
    public Constructor[] getDeclaredConstructors() {
        if (privateConstructors == null) {
            privateConstructors = new HashMap();

            // collect non-static methods only
            for (String name : definition.keys()) {
                char ch = name.charAt(0);

                if (ch == '$' && name.length() != 1) {
                    Constructor constructor = (Constructor) (Object) new JSConstructor(name, (Class) (Object) this, prototype, prototype.getPropertyAs(NativeFunction.class, name), definition.getPropertyAs(NativeArray.class, name));
                    privateConstructors.put(hash("", constructor.getParameterTypes()), constructor);
                }
            }
        }

        // defensive copy
        return privateConstructors.values().toArray(new Constructor[privateConstructors.size()]);
    }

    /**
     * Returns a {@code Method} object that reflects the specified public member method of the class
     * or interface represented by this {@code Class} object. The {@code name} parameter is a
     * {@code String} specifying the simple name of the desired method. The {@code parameterTypes}
     * parameter is an array of {@code Class} objects that identify the method's formal parameter
     * types, in declared order. If {@code parameterTypes} is {@code null}, it is treated as if it
     * were an empty array.
     * <p>
     * If the {@code name} is "{@code <init>};"or "{@code <clinit>}" a {@code NoSuchMethodException}
     * is raised. Otherwise, the method to be reflected is determined by the algorithm that follows.
     * Let C be the class represented by this object:
     * <OL>
     * <LI>C is searched for any <I>matching methods</I>. If no matching method is found, the
     * algorithm of step 1 is invoked recursively on the superclass of C.</LI>
     * <LI>If no method was found in step 1 above, the superinterfaces of C are searched for a
     * matching method. If any such method is found, it is reflected.</LI>
     * </OL>
     * To find a matching method in a class C:&nbsp; If C declares exactly one public method with
     * the specified name and exactly the same formal parameter types, that is the method reflected.
     * If more than one such method is found in C, and one of these methods has a return type that
     * is more specific than any of the others, that method is reflected; otherwise one of the
     * methods is chosen arbitrarily.
     * <p>
     * Note that there may be more than one matching method in a class because while the Java
     * language forbids a class to declare multiple methods with the same signature but different
     * return types, the Java virtual machine does not. This increased flexibility in the virtual
     * machine can be used to implement various language features. For example, covariant returns
     * can be implemented with {@linkplain java.lang.reflect.Method#isBridge bridge methods}; the
     * bridge method and the method being overridden would have the same signature but different
     * return types.
     * <p>
     * See <em>The Java Language Specification</em>, sections 8.2 and 8.4.
     * 
     * @param name the name of the method
     * @param parameterTypes the list of parameters
     * @return the {@code Method} object that matches the specified {@code name} and
     *         {@code parameterTypes}
     * @exception NoSuchMethodException if a matching method is not found or if the name is
     *                "&lt;init&gt;"or "&lt;clinit&gt;".
     * @exception NullPointerException if {@code name} is {@code null}
     * @exception SecurityException If a security manager, <i>s</i>, is present and any of the
     *                following conditions is met:
     *                <ul>
     *                <li> invocation of {@link SecurityManager#checkMemberAccess
     *                s.checkMemberAccess(this, Member.PUBLIC)} denies access to the method <li> the
     *                caller's class loader is not the same as or an ancestor of the class loader
     *                for the current class and invocation of
     *                {@link SecurityManager#checkPackageAccess s.checkPackageAccess()} denies
     *                access to the package of this class
     *                </ul>
     * @since JDK1.1
     */
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException {
        Objects.requireNonNull(name);

        if (publicMethods == null) {
            getMethods();
        }

        Method method = publicMethods.get(hash(name, parameterTypes));

        if (method == null) {
            throw new NoSuchMethodException();
        } else {
            return method;
        }
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
        if (publicMethods == null) {
            publicMethods = new HashMap();

            for (Class type : collectTypes((Class) (Object) this, new HashSet())) {
                for (Method method : type.getDeclaredMethods()) {
                    Integer hash = hash(method.getName(), method.getParameterTypes());

                    if (Modifier.isPublic(method.getModifiers()) && !publicMethods.containsKey(hash)) {
                        publicMethods.put(hash, method);
                    }
                }
            }
        }

        // defensive copy
        return publicMethods.values().toArray(new Method[publicMethods.size()]);
    }

    /**
     * Returns a {@code Method} object that reflects the specified declared method of the class or
     * interface represented by this {@code Class} object. The {@code name} parameter is a
     * {@code String} that specifies the simple name of the desired method, and the
     * {@code parameterTypes} parameter is an array of {@code Class} objects that identify the
     * method's formal parameter types, in declared order. If more than one method with the same
     * parameter types is declared in a class, and one of these methods has a return type that is
     * more specific than any of the others, that method is returned; otherwise one of the methods
     * is chosen arbitrarily. If the name is "&lt;init&gt;"or "&lt;clinit&gt;" a
     * {@code NoSuchMethodException} is raised.
     * 
     * @param name the name of the method
     * @param parameterTypes the parameter array
     * @return the {@code Method} object for the method of this class matching the specified name
     *         and parameters
     * @exception NoSuchMethodException if a matching method is not found.
     * @exception NullPointerException if {@code name} is {@code null}
     * @exception SecurityException If a security manager, <i>s</i>, is present and any of the
     *                following conditions is met:
     *                <ul>
     *                <li>invocation of {@link SecurityManager#checkMemberAccess
     *                s.checkMemberAccess(this, Member.DECLARED)} denies access to the declared
     *                method
     *                <li>the caller's class loader is not the same as or an ancestor of the class
     *                loader for the current class and invocation of
     *                {@link SecurityManager#checkPackageAccess s.checkPackageAccess()} denies
     *                access to the package of this class
     *                </ul>
     * @since JDK1.1
     */
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Objects.requireNonNull(name);

        if (privateMethods == null) {
            getDeclaredMethods();
        }

        Method method = privateMethods.get(hash(name, parameterTypes));

        if (method == null) {
            throw new NoSuchMethodException();
        } else {
            return method;
        }
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
        if (privateMethods == null) {
            privateMethods = new HashMap();

            // collect non-static methods only
            for (String name : definition.keys()) {
                char ch = name.charAt(0);

                if (ch != '$' && ch < 'a' || 'p' < ch) {
                    Method method = (Method) (Object) new JSMethod(name, (Class) (Object) this, prototype, definition.getPropertyAs(NativeArray.class, name));
                    privateMethods.put(hash(method.getName(), method.getParameterTypes()), method);
                }
            }
        }

        // defensive copy
        return privateMethods.values().toArray(new Method[privateMethods.size()]);
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
    public Field getField(String name) throws NoSuchFieldException {
        Objects.requireNonNull(name);

        if (publicFields == null) {
            getFields();
        }

        Field field = publicFields.get(name);

        if (field == null) {
            throw new NoSuchFieldException();
        } else {
            return field;
        }
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
        if (publicFields == null) {
            publicFields = new HashMap();

            for (Class type : collectTypes((Class) (Object) this, new HashSet())) {
                for (Field field : type.getDeclaredFields()) {
                    if (Modifier.isPublic(field.getModifiers()) && !publicFields.containsKey(field.getName())) {
                        publicFields.put(field.getName(), field);
                    }
                }
            }
        }

        // defensive copy
        return publicFields.values().toArray(new Field[publicFields.size()]);
    }

    /**
     * Returns a {@code Field} object that reflects the specified declared field of the class or
     * interface represented by this {@code Class} object. The {@code name} parameter is a
     * {@code String} that specifies the simple name of the desired field. Note that this method
     * will not reflect the {@code length} field of an array class.
     * 
     * @param name the name of the field
     * @return the {@code Field} object for the specified field in this class
     * @exception NoSuchFieldException if a field with the specified name is not found.
     * @exception NullPointerException if {@code name} is {@code null}
     * @exception SecurityException If a security manager, <i>s</i>, is present and any of the
     *                following conditions is met:
     *                <ul>
     *                <li>invocation of {@link SecurityManager#checkMemberAccess
     *                s.checkMemberAccess(this, Member.DECLARED)} denies access to the declared
     *                field
     *                <li>the caller's class loader is not the same as or an ancestor of the class
     *                loader for the current class and invocation of
     *                {@link SecurityManager#checkPackageAccess s.checkPackageAccess()} denies
     *                access to the package of this class
     *                </ul>
     * @since JDK1.1
     */
    public Field getDeclaredField(String name) throws NoSuchFieldException, SecurityException {
        Objects.requireNonNull(name);

        if (privateFields == null) {
            getFields();
        }

        Field field = privateFields.get(name);

        if (field == null) {
            throw new NoSuchFieldException();
        } else {
            return field;
        }
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
        if (privateFields == null) {
            privateFields = new HashMap();

            // collect non-static methods only
            for (String name : definition.keys()) {
                char ch = name.charAt(0);

                if ('a' <= ch && ch <= 'p') {
                    Field field = (Field) (Object) new JSField(name, (Class) (Object) this, prototype, definition.getPropertyAs(NativeArray.class, name));
                    privateFields.put(field.getName(), field);
                }
            }
        }

        // defensive copy
        return privateFields.values().toArray(new Field[privateFields.size()]);
    }

    /**
     * <p>
     * Compute hash.
     * </p>
     * 
     * @param name
     * @param types
     * @return
     */
    private Integer hash(String name, Class[] types) {
        return name.hashCode() + Arrays.hashCode(types);
    }

    private Set<Class> collectTypes(Class type, Set<Class> types) {
        if (type != null && types.add(type)) {
            // super class
            collectTypes(type.getSuperclass(), types);

            // interfaces
            for (Class interfaceType : type.getInterfaces()) {
                collectTypes(interfaceType, types);
            }
        }
        return types;
    }

    /**
     * Returns true if this {@code Class} object represents an annotation type. Note that if this
     * method returns true, {@link #isInterface()} would also return true, as all annotation types
     * are also interfaces.
     * 
     * @return {@code true} if this class object represents an annotation type; {@code false}
     *         otherwise
     * @since 1.5
     */
    public boolean isAnnotation() {
        return (modifiers & JSModifier.ANNOTATION) != 0;
    }

    /**
     * Returns {@code true} if and only if the underlying class is an anonymous class.
     * 
     * @return {@code true} if and only if this class is an anonymous class.
     * @since 1.5
     */
    public boolean isAnonymousClass() {
        return (modifiers & JSModifier.ANONYMOUS) != 0;
    }

    /**
     * Determines if this {@code Class} object represents an array class.
     * 
     * @return {@code true} if this object represents an array class; {@code false} otherwise.
     * @since JDK1.1
     */
    public boolean isArray() {
        return nameJS.startsWith("[");
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
     * Returns true if and only if this class was declared as an enum in the source code.
     * 
     * @return true if and only if this class was declared as an enum in the source code
     * @since 1.5
     */
    public boolean isEnum() {
        return (modifiers & JSModifier.ENUM) != 0 && getSuperclass() == Enum.class;
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
     * Determines if the specified {@code Class} object represents an interface type.
     * 
     * @return {@code true} if this object represents an interface; {@code false} otherwise.
     */
    public boolean isInterface() {
        return Modifier.isInterface(modifiers);
    }

    /**
     * Returns {@code true} if and only if the underlying class is a local class.
     * 
     * @return {@code true} if and only if this class is a local class.
     * @since 1.5
     */
    public boolean isLocalClass() {
        return (modifiers & JSModifier.LOCAL) != 0;
    }

    /**
     * Returns {@code true} if and only if the underlying class is a member class.
     * 
     * @return {@code true} if and only if this class is a member class.
     * @since 1.5
     */
    public boolean isMemberClass() {
        return (modifiers & JSModifier.MEMBER) != 0;
    }

    /**
     * Determines if the specified {@code Class} object represents a primitive type.
     * <p>
     * There are nine predefined {@code Class} objects to represent the eight primitive types and
     * void. These are created by the Java Virtual Machine, and have the same names as the primitive
     * types that they represent, namely {@code boolean}, {@code byte}, {@code char}, {@code short},
     * {@code int}, {@code long}, {@code float}, and {@code double}.
     * <p>
     * These objects may only be accessed via the following public static final variables, and are
     * the only {@code Class} objects for which this method returns {@code true}.
     * 
     * @return true if and only if this class represents a primitive type
     * @see java.lang.Boolean#TYPE
     * @see java.lang.Character#TYPE
     * @see java.lang.Byte#TYPE
     * @see java.lang.Short#TYPE
     * @see java.lang.Integer#TYPE
     * @see java.lang.Long#TYPE
     * @see java.lang.Float#TYPE
     * @see java.lang.Double#TYPE
     * @see java.lang.Void#TYPE
     * @since JDK1.1
     */
    public boolean isPrimitive() {
        Class type = (Class) (Object) this;

        return type == int.class || type == long.class || type == float.class || type == double.class || type == boolean.class || type == short.class || type == byte.class || type == void.class;
    }

    /**
     * Returns {@code true} if this class is a synthetic class; returns {@code false} otherwise.
     * 
     * @return {@code true} if and only if this class is a synthetic class as defined by the Java
     *         Language Specification.
     * @since 1.5
     */
    public boolean isSynthetic() {
        return (modifiers & JSModifier.SYNTHETIC) != 0;
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
    @Override
    public TypeVariable<Class<T>>[] getTypeParameters() {
        if (signatures.length() == 0) {
            return (TypeVariable<Class<T>>[]) new TypeVariable[0];
        }

        if (parameters == null) {
            parameters = new Signature(signatures, this).types;
        }
        return parameters.toArray(new TypeVariable[parameters.size()]);
    }

    /**
     * Returns the {@code Class} representing the component type of an array. If this class does not
     * represent an array class this method returns null.
     * 
     * @return the {@code Class} representing the component type of this class if this class is an
     *         array
     * @see java.lang.reflect.Array
     * @since JDK1.1
     */
    public Class<?> getComponentType() {
        return isArray() ? forName(nameJS.substring(1)) : null;
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
        if ((Object) this == Object.class || isInterface()) {
            return null;
        } else if (superclass == null) {
            return Object.class;
        } else {
            return superclass;
        }
    }

    /**
     * Returns the {@code Type} representing the direct superclass of the entity (class, interface,
     * primitive type or void) represented by this {@code Class}.
     * <p>
     * If the superclass is a parameterized type, the {@code Type} object returned must accurately
     * reflect the actual type parameters used in the source code. The parameterized type
     * representing the superclass is created if it had not been created before. See the declaration
     * of {@link java.lang.reflect.ParameterizedType ParameterizedType} for the semantics of the
     * creation process for parameterized types. If this {@code Class} represents either the
     * {@code Object} class, an interface, a primitive type, or void, then null is returned. If this
     * object represents an array class then the {@code Class} object representing the
     * {@code Object} class is returned.
     * 
     * @throws java.lang.reflect.GenericSignatureFormatError if the generic class signature does not
     *             conform to the format specified in <cite>The Java&trade; Virtual Machine
     *             Specification</cite>
     * @throws TypeNotPresentException if the generic superclass refers to a non-existent type
     *             declaration
     * @throws java.lang.reflect.MalformedParameterizedTypeException if the generic superclass
     *             refers to a parameterized type that cannot be instantiated for any reason
     * @return the superclass of the class represented by this object
     * @since 1.5
     */
    public Type getGenericSuperclass() {
        if (signaturesSuperClass.length() == 0) {
            return getSuperclass();
        }

        if (superclassType == null) {
            superclassType = (Type) new Signature(signaturesSuperClass, this).types.get(0);
        }
        return superclassType;
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
        if (interfaces == null) {
            interfaces = convert(getGenericInterfaces());
        }
        return interfaces.toArray(new Class[interfaces.size()]);
    }

    /**
     * Returns the {@code Type}s representing the interfaces directly implemented by the class or
     * interface represented by this object.
     * <p>
     * If a superinterface is a parameterized type, the {@code Type} object returned for it must
     * accurately reflect the actual type parameters used in the source code. The parameterized type
     * representing each superinterface is created if it had not been created before. See the
     * declaration of {@link java.lang.reflect.ParameterizedType ParameterizedType} for the
     * semantics of the creation process for parameterized types.
     * <p>
     * If this object represents a class, the return value is an array containing objects
     * representing all interfaces implemented by the class. The order of the interface objects in
     * the array corresponds to the order of the interface names in the {@code implements} clause of
     * the declaration of the class represented by this object. In the case of an array class, the
     * interfaces {@code Cloneable} and {@code Serializable} are returned in that order.
     * <p>
     * If this object represents an interface, the array contains objects representing all
     * interfaces directly extended by the interface. The order of the interface objects in the
     * array corresponds to the order of the interface names in the {@code extends} clause of the
     * declaration of the interface represented by this object.
     * <p>
     * If this object represents a class or interface that implements no interfaces, the method
     * returns an array of length 0.
     * <p>
     * If this object represents a primitive type or void, the method returns an array of length 0.
     * 
     * @throws java.lang.reflect.GenericSignatureFormatError if the generic class signature does not
     *             conform to the format specified in <cite>The Java&trade; Virtual Machine
     *             Specification</cite>
     * @throws TypeNotPresentException if any of the generic superinterfaces refers to a
     *             non-existent type declaration
     * @throws java.lang.reflect.MalformedParameterizedTypeException if any of the generic
     *             superinterfaces refer to a parameterized type that cannot be instantiated for any
     *             reason
     * @return an array of interfaces implemented by this class
     * @since 1.5
     */
    public Type[] getGenericInterfaces() {
        if (interfacesType == null) {
            interfacesType = new Signature((String) metadata.get(3), this).types;
            metadata.deleteProperty(3);
        }
        return interfacesType.toArray(new Type[interfacesType.size()]);
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
        return "boot." + nameJS;
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
        return nameJS;
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
        return nameJS;
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

            NativeObject definition = prototype.getPropertyAs(NativeObject.class, "$");

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
     * Returns the assertion status that would be assigned to this class if it were to be
     * initialized at the time this method is invoked. If this class has had its assertion status
     * set, the most recent setting will be returned; otherwise, if any package default assertion
     * status pertains to this class, the most recent setting for the most specific pertinent
     * package default assertion status is returned; otherwise, if this class is not a system class
     * (i.e., it has a class loader) its class loader's default assertion status is returned;
     * otherwise, the system class default assertion status is returned.
     * <p>
     * Few programmers will have any need for this method; it is provided for the benefit of the JRE
     * itself. (It allows a class to determine at the time that it is initialized whether assertions
     * should be enabled.) Note that this method is not guaranteed to return the actual assertion
     * status that was (or will be) associated with the specified class when it was (or will be)
     * initialized.
     * 
     * @return the desired assertion status of the specified class.
     * @see java.lang.ClassLoader#setClassAssertionStatus
     * @see java.lang.ClassLoader#setPackageAssertionStatus
     * @see java.lang.ClassLoader#setDefaultAssertionStatus
     * @since 1.4
     */
    public boolean desiredAssertionStatus() {
        return true;
    }

    /**
     * <p>
     * Create {@link Class} for the array of this {@link Class}.
     * </p>
     * 
     * @return
     */
    protected JSClass getArrayClass() {
        if (arrayClass == null) {
            arrayClass = new JSClass("[".concat(nameJS), new NativeObject(), new NativeArray(), null, new NativeObject());
        }
        return arrayClass;
    }

    /**
     * <p>
     * Helper method to conver {@link Type} to {@link Class}.
     * </p>
     * 
     * @param types
     * @return
     */
    private List<Class> convert(Type[] types) {
        List<Class> classes = new ArrayList();

        for (Type type : types) {
            classes.add((Class) (type instanceof Class ? type : ((ParameterizedType) type).getRawType()));
        }
        return classes;
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
        int size = 0;

        while (fqcn.startsWith("[")) {
            size++;
            fqcn = fqcn.substring(1);
        }

        NativeObject definition = boot.getPropertyAs(NativeObject.class, fqcn);

        if (definition == null) {
            return (Class) (Object) new JSClass(fqcn, new NativeObject(), new NativeArray(), Object.class, new NativeObject());
        }

        JSClass clazz = (JSClass) definition.getProperty("$");

        for (int i = 0; i < size; i++) {
            clazz = clazz.getArrayClass();
        }
        return (Class) (Object) clazz;
    }
}