/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import static js.lang.Global.*;

import java.lang.reflect.Field;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

import booton.translator.JavaAPIProvider;
import js.lang.NativeArray;
import js.lang.NativeObject;

/**
 * <p>
 * {@link Field} representation in Javascript runtime. This class doesn't provide all
 * functionalities.
 * </p>
 * 
 * @version 2013/09/11 0:21:14
 */
@JavaAPIProvider(Field.class)
class JSField extends JSAccessibleObject {

    /** The cache for field {@link Class}. */
    private Class field;

    /** The cache for field {@link Type}. */
    private Type fieldType;

    /**
     * <p>
     * Create native field.
     * </p>
     * 
     * @param nameJS
     * @param metadata
     */
    JSField(String nameJS, Class owner, NativeArray metadata) {
        super((String) metadata.get(1), nameJS, owner, metadata, 3);
    }

    /**
     * Returns a {@code Class} object that identifies the declared type for the field represented by
     * this {@code Field} object.
     * 
     * @return a {@code Class} object identifying the declared type of the field represented by this
     *         object
     */
    public Class<?> getType() {
        if (field == null) {
            field = Signature.convert(getGenericType());
        }
        return field;
    }

    /**
     * Returns a {@code Type} object that represents the declared type for the field represented by
     * this {@code Field} object.
     * <p>
     * If the {@code Type} is a parameterized type, the {@code Type} object returned must accurately
     * reflect the actual type parameters used in the source code.
     * <p>
     * If the type of the underlying field is a type variable or a parameterized type, it is
     * created. Otherwise, it is resolved.
     * 
     * @return a {@code Type} object that represents the declared type for the field represented by
     *         this {@code Field} object
     * @throws GenericSignatureFormatError if the generic field signature does not conform to the
     *             format specified in <cite>The Java&trade; Virtual Machine Specification</cite>
     * @throws TypeNotPresentException if the generic type signature of the underlying field refers
     *             to a non-existent type declaration
     * @throws MalformedParameterizedTypeException if the generic signature of the underlying field
     *             refers to a parameterized type that cannot be instantiated for any reason
     * @since 1.5
     */
    public Type getGenericType() {
        if (fieldType == null) {
            fieldType = (Type) new Signature(metadata.get(2, ""), owner).types.get(0);
            metadata.deleteProperty(2);
        }
        return fieldType;
    }

    /**
     * Returns the value of the field represented by this {@code Field}, on the specified object.
     * The value is automatically wrapped in an object if it has a primitive type.
     * <p>
     * The underlying field's value is obtained as follows:
     * <p>
     * If the underlying field is a static field, the {@code obj} argument is ignored; it may be
     * null.
     * <p>
     * Otherwise, the underlying field is an instance field. If the specified {@code obj} argument
     * is null, the method throws a {@code NullPointerException}. If the specified object is not an
     * instance of the class or interface declaring the underlying field, the method throws an
     * {@code IllegalArgumentException}.
     * <p>
     * If this {@code Field} object is enforcing Java language access control, and the underlying
     * field is inaccessible, the method throws an {@code IllegalAccessException}. If the underlying
     * field is static, the class that declared the field is initialized if it has not already been
     * initialized.
     * <p>
     * Otherwise, the value is retrieved from the underlying instance or static field. If the field
     * has a primitive type, the value is wrapped in an object before being returned, otherwise it
     * is returned as is.
     * <p>
     * If the field is hidden in the type of {@code obj}, the field's value is obtained according to
     * the preceding rules.
     * 
     * @param obj object from which the represented field's value is to be extracted
     * @return the value of the represented field in object {@code obj}; primitive values are
     *         wrapped in an appropriate object before being returned
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof).
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     */
    public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getProperty(nameJS);
    }

    /**
     * Gets the value of a static or instance {@code boolean} field.
     * 
     * @param obj the object to extract the {@code boolean} value from
     * @return the value of the {@code boolean} field
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type
     *                {@code boolean} by a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public boolean getBoolean(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getBoolean(nameJS);
    }

    /**
     * Gets the value of a static or instance {@code byte} field.
     * 
     * @param obj the object to extract the {@code byte} value from
     * @return the value of the {@code byte} field
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type {@code byte}
     *                by a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public byte getByte(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getByte(nameJS);
    }

    /**
     * Gets the value of a static or instance field of type {@code char} or of another primitive
     * type convertible to type {@code char} via a widening conversion.
     * 
     * @param obj the object to extract the {@code char} value from
     * @return the value of the field converted to type {@code char}
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type {@code char}
     *                by a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public char getChar(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getChar(nameJS);
    }

    /**
     * Gets the value of a static or instance field of type {@code short} or of another primitive
     * type convertible to type {@code short} via a widening conversion.
     * 
     * @param obj the object to extract the {@code short} value from
     * @return the value of the field converted to type {@code short}
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type {@code short}
     *                by a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public short getShort(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getShort(nameJS);
    }

    /**
     * Gets the value of a static or instance field of type {@code int} or of another primitive type
     * convertible to type {@code int} via a widening conversion.
     * 
     * @param obj the object to extract the {@code int} value from
     * @return the value of the field converted to type {@code int}
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type {@code int} by
     *                a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public int getInt(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getInt(nameJS);
    }

    /**
     * Gets the value of a static or instance field of type {@code long} or of another primitive
     * type convertible to type {@code long} via a widening conversion.
     * 
     * @param obj the object to extract the {@code long} value from
     * @return the value of the field converted to type {@code long}
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type {@code long}
     *                by a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public long getLong(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getLong(nameJS);
    }

    /**
     * Gets the value of a static or instance field of type {@code float} or of another primitive
     * type convertible to type {@code float} via a widening conversion.
     * 
     * @param obj the object to extract the {@code float} value from
     * @return the value of the field converted to type {@code float}
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type {@code float}
     *                by a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public float getFloat(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getFloat(nameJS);
    }

    /**
     * Gets the value of a static or instance field of type {@code double} or of another primitive
     * type convertible to type {@code double} via a widening conversion.
     * 
     * @param obj the object to extract the {@code double} value from
     * @return the value of the field converted to type {@code double}
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is inaccessible.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if the field value cannot be converted to the type {@code double}
     *                by a widening conversion.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#get
     */
    public double getDouble(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return verify(obj).getDouble(nameJS);
    }

    /**
     * Sets the field represented by this {@code Field} object on the specified object argument to
     * the specified new value. The new value is automatically unwrapped if the underlying field has
     * a primitive type.
     * <p>
     * The operation proceeds as follows:
     * <p>
     * If the underlying field is static, the {@code obj} argument is ignored; it may be null.
     * <p>
     * Otherwise the underlying field is an instance field. If the specified object argument is
     * null, the method throws a {@code NullPointerException}. If the specified object argument is
     * not an instance of the class or interface declaring the underlying field, the method throws
     * an {@code IllegalArgumentException}.
     * <p>
     * If this {@code Field} object is enforcing Java language access control, and the underlying
     * field is inaccessible, the method throws an {@code IllegalAccessException}.
     * <p>
     * If the underlying field is final, the method throws an {@code IllegalAccessException} unless
     * {@code setAccessible(true)} has succeeded for this {@code Field} object and the field is
     * non-static. Setting a final field in this way is meaningful only during deserialization or
     * reconstruction of instances of classes with blank final fields, before they are made
     * available for access by other parts of a program. Use in any other context may have
     * unpredictable effects, including cases in which other parts of a program continue to use the
     * original value of this field.
     * <p>
     * If the underlying field is of a primitive type, an unwrapping conversion is attempted to
     * convert the new value to a value of a primitive type. If this attempt fails, the method
     * throws an {@code IllegalArgumentException}.
     * <p>
     * If, after possible unwrapping, the new value cannot be converted to the type of the
     * underlying field by an identity or widening conversion, the method throws an
     * {@code IllegalArgumentException}.
     * <p>
     * If the underlying field is static, the class that declared the field is initialized if it has
     * not already been initialized.
     * <p>
     * The field is set to the possibly unwrapped and widened new value.
     * <p>
     * If the field is hidden in the type of {@code obj}, the field's value is set according to the
     * preceding rules.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     */
    public void set(Object obj, Object value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setProperty(nameJS, value);
    }

    /**
     * Sets the value of a field as a {@code boolean} on the specified object. This method is
     * equivalent to {@code set(obj, zObj)}, where {@code zObj} is a {@code Boolean} object and
     * {@code zObj.booleanValue() == z}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setBoolean(Object obj, boolean value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setBoolean(nameJS, value);
    }

    /**
     * Sets the value of a field as a {@code byte} on the specified object. This method is
     * equivalent to {@code set(obj, bObj)}, where {@code bObj} is a {@code Byte} object and
     * {@code bObj.byteValue() == b}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setByte(Object obj, byte value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setByte(nameJS, value);
    }

    /**
     * Sets the value of a field as a {@code char} on the specified object. This method is
     * equivalent to {@code set(obj, cObj)}, where {@code cObj} is a {@code Character} object and
     * {@code cObj.charValue() == c}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setChar(Object obj, char value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setChar(nameJS, value);
    }

    /**
     * Sets the value of a field as a {@code short} on the specified object. This method is
     * equivalent to {@code set(obj, sObj)}, where {@code sObj} is a {@code Short} object and
     * {@code sObj.shortValue() == s}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setShort(Object obj, short value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setShort(nameJS, value);
    }

    /**
     * Sets the value of a field as an {@code int} on the specified object. This method is
     * equivalent to {@code set(obj, iObj)}, where {@code iObj} is a {@code Integer} object and
     * {@code iObj.intValue() == i}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setInt(Object obj, int value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setInt(nameJS, value);
    }

    /**
     * Sets the value of a field as a {@code long} on the specified object. This method is
     * equivalent to {@code set(obj, lObj)}, where {@code lObj} is a {@code Long} object and
     * {@code lObj.longValue() == l}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setLong(Object obj, long value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setLong(nameJS, value);
    }

    /**
     * Sets the value of a field as a {@code float} on the specified object. This method is
     * equivalent to {@code set(obj, fObj)}, where {@code fObj} is a {@code Float} object and
     * {@code fObj.floatValue() == f}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setFloat(Object obj, float value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setFloat(nameJS, value);
    }

    /**
     * Sets the value of a field as a {@code double} on the specified object. This method is
     * equivalent to {@code set(obj, dObj)}, where {@code dObj} is a {@code Double} object and
     * {@code dObj.doubleValue() == d}.
     * 
     * @param obj the object whose field should be modified
     * @param value the new value for the field of {@code obj} being modified
     * @exception IllegalAccessException if this {@code Field} object is enforcing Java language
     *                access control and the underlying field is either inaccessible or final.
     * @exception IllegalArgumentException if the specified object is not an instance of the class
     *                or interface declaring the underlying field (or a subclass or implementor
     *                thereof), or if an unwrapping conversion fails.
     * @exception NullPointerException if the specified object is null and the field is an instance
     *                field.
     * @exception ExceptionInInitializerError if the initialization provoked by this method fails.
     * @see Field#set
     */
    public void setDouble(Object obj, double value) throws IllegalArgumentException, IllegalAccessException {
        verify(obj).setDouble(nameJS, value);
    }

    /**
     * <p>
     * Verify the target object.
     * </p>
     * 
     * @param obj
     * @return
     */
    private NativeObject verify(Object obj) {
        if (Modifier.isStatic(modifiers)) obj = boot.getProperty(((JSClass) (Object) owner).nameJS);

        return (NativeObject) obj;
    }

    /**
     * Returns a string describing this {@code Field}. The format is the access modifiers for the
     * field, if any, followed by the field type, followed by a space, followed by the
     * fully-qualified name of the class declaring the field, followed by a period, followed by the
     * name of the field. For example: <pre>
     *    public static final int java.lang.Thread.MIN_PRIORITY
     *    private int java.io.FileDescriptor.fd
     * </pre>
     * <p>
     * The modifiers are placed in canonical order as specified by "The Java Language Specification"
     * . This is {@code public}, {@code protected} or {@code private} first, and then other
     * modifiers in the following order: {@code static}, {@code final}, {@code transient},
     * {@code volatile}.
     * 
     * @return a string describing this {@code Field}
     * @jls 8.3.1 Field Modifiers
     */
    @Override
    public String toString() {
        int mod = getModifiers();
        return (((mod == 0) ? "" : (Modifier.toString(mod) + " ")) + getType().getTypeName() + " " + getDeclaringClass()
                .getTypeName() + "." + getName());
    }
}
