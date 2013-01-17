/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.js;

import java.lang.reflect.Constructor;

/**
 * <p>
 * {@link Class} code in Javascript runtime. This class doesn't provide all functionalities.
 * </p>
 * 
 * @version 2013/01/17 15:58:55
 */
public class JSClass extends JSAnnotatedElement {

    /** The class definition in runtime. */
    private final NativeObject clazz;

    /** The annotation in runtime. */
    private final NativeObject annotations;

    /**
     * @param name
     * @param clazz
     * @param annotations
     */
    private JSClass(String name, NativeObject clazz, NativeObject annotations) {
        super(name, annotations.getPropertyAs(NativeArray.class, "$"));

        this.clazz = clazz;
        this.annotations = annotations;
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
        NativeArray<String> names = clazz.keys();

        for (int i = 0; i < names.length(); i++) {
            String name = names.get(i);

            if (name.startsWith("$")) {
                container.push(new JSConstructor(this, name, clazz.getPropertyAs(NativeFunction.class, name), annotations.getPropertyAs(NativeArray.class, name)));
            }
        }
        return (Constructor[]) (Object) container;
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

    public Object newInstance() {
        return null;
    }

    public Constructor getConstructor() {
        return null;
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
        return null;
    }
}