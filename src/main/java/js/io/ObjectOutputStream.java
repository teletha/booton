/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.io;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/08 8:37:18
 */
@JavaAPIProvider(java.io.ObjectOutputStream.class)
class ObjectOutputStream {
    /**
     * Write the non-static and non-transient fields of the current class to this stream. This may
     * only be called from the writeObject method of the class being serialized. It will throw the
     * NotActiveException if it is called otherwise.
     *
     * @throws IOException if I/O errors occur while writing to the underlying {@code OutputStream}
     */
    public void defaultWriteObject() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a boolean.
     *
     * @param val the boolean to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeBoolean(boolean val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes an 8 bit byte.
     *
     * @param val the byte value to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeByte(int val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a 16 bit short.
     *
     * @param val the short value to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeShort(int val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a 16 bit char.
     *
     * @param val the char value to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeChar(int val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a 32 bit int.
     *
     * @param val the integer value to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeInt(int val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a 64 bit long.
     *
     * @param val the long value to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeLong(long val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a 32 bit float.
     *
     * @param val the float value to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeFloat(float val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a 64 bit double.
     *
     * @param val the double value to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeDouble(double val) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a String as a sequence of bytes.
     *
     * @param str the String of bytes to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeBytes(String str) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Writes a String as a sequence of chars.
     *
     * @param str the String of chars to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeChars(String str) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Primitive data write of this String in <a href="DataInput.html#modified-utf-8">modified
     * UTF-8</a> format. Note that there is a significant difference between writing a String into
     * the stream as primitive data or as an Object. A String instance written by writeObject is
     * written into the stream as a String initially. Future writeObject() calls write references to
     * the string into the stream.
     *
     * @param str the String to be written
     * @throws IOException if I/O errors occur while writing to the underlying stream
     */
    public void writeUTF(String str) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Write the specified object to the ObjectOutputStream. The class of the object, the signature
     * of the class, and the values of the non-transient and non-static fields of the class and all
     * of its supertypes are written. Default serialization for a class can be overridden using the
     * writeObject and the readObject methods. Objects referenced by this object are written
     * transitively so that a complete equivalent graph of objects can be reconstructed by an
     * ObjectInputStream.
     * <p>
     * Exceptions are thrown for problems with the OutputStream and for classes that should not be
     * serialized. All exceptions are fatal to the OutputStream, which is left in an indeterminate
     * state, and it is up to the caller to ignore or recover the stream state.
     *
     * @throws InvalidClassException Something is wrong with a class used by serialization.
     * @throws NotSerializableException Some object to be serialized does not implement the
     *             java.io.Serializable interface.
     * @throws IOException Any exception thrown by the underlying OutputStream.
     */
    public final void writeObject(Object obj) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
