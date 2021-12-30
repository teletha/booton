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

import java.io.EOFException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotActiveException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

import booton.translator.JavaAPIProvider;

/**
 * @version 2015/08/08 8:36:56
 */
@JavaAPIProvider(java.io.ObjectInputStream.class)
class ObjectInputStream {

    /**
     * Read an object from the ObjectInputStream. The class of the object, the signature of the
     * class, and the values of the non-transient and non-static fields of the class and all of its
     * supertypes are read. Default deserializing for a class can be overriden using the writeObject
     * and readObject methods. Objects referenced by this object are read transitively so that a
     * complete equivalent graph of objects is reconstructed by readObject.
     * <p>
     * The root object is completely restored when all of its fields and the objects it references
     * are completely restored. At this point the object validation callbacks are executed in order
     * based on their registered priorities. The callbacks are registered by objects (in the
     * readObject special methods) as they are individually restored.
     * <p>
     * Exceptions are thrown for problems with the InputStream and for classes that should not be
     * deserialized. All exceptions are fatal to the InputStream and leave it in an indeterminate
     * state; it is up to the caller to ignore or recover the stream state.
     * 
     * @throws ClassNotFoundException Class of a serialized object cannot be found.
     * @throws InvalidClassException Something is wrong with a class used by serialization.
     * @throws StreamCorruptedException Control information in the stream is inconsistent.
     * @throws OptionalDataException Primitive data was found in the stream instead of objects.
     * @throws IOException Any of the usual Input/Output related exceptions.
     */
    public final Object readObject() throws IOException, ClassNotFoundException {
        return null;
    }

    /**
     * Read the non-static and non-transient fields of the current class from this stream. This may
     * only be called from the readObject method of the class being deserialized. It will throw the
     * NotActiveException if it is called otherwise.
     *
     * @throws ClassNotFoundException if the class of a serialized object could not be found.
     * @throws IOException if an I/O error occurs.
     * @throws NotActiveException if the stream is not currently reading objects.
     */
    public void defaultReadObject() throws IOException, ClassNotFoundException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads in a boolean.
     *
     * @return the boolean read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public boolean readBoolean() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads an 8 bit byte.
     *
     * @return the 8 bit byte read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public byte readByte() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads an unsigned 8 bit byte.
     *
     * @return the 8 bit byte read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public int readUnsignedByte() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads a 16 bit char.
     *
     * @return the 16 bit char read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public char readChar() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads a 16 bit short.
     *
     * @return the 16 bit short read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public short readShort() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads an unsigned 16 bit short.
     *
     * @return the 16 bit short read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public int readUnsignedShort() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads a 32 bit int.
     *
     * @return the 32 bit integer read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public int readInt() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads a 64 bit long.
     *
     * @return the read 64 bit long.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public long readLong() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads a 32 bit float.
     *
     * @return the 32 bit float read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public float readFloat() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads a 64 bit double.
     *
     * @return the 64 bit double read.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public double readDouble() throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads bytes, blocking until all bytes are read.
     *
     * @param buf the buffer into which the data is read
     * @throws NullPointerException If {@code buf} is {@code null}.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public void readFully(byte[] buf) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Reads bytes, blocking until all bytes are read.
     *
     * @param buf the buffer into which the data is read
     * @param off the start offset into the data array {@code buf}
     * @param len the maximum number of bytes to read
     * @throws NullPointerException If {@code buf} is {@code null}.
     * @throws IndexOutOfBoundsException If {@code off} is negative, {@code len} is negative, or
     *             {@code len} is greater than {@code buf.length - off}.
     * @throws EOFException If end of file is reached.
     * @throws IOException If other I/O error has occurred.
     */
    public void readFully(byte[] buf, int off, int len) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Skips bytes.
     *
     * @param len the number of bytes to be skipped
     * @return the actual number of bytes skipped.
     * @throws IOException If an I/O error has occurred.
     */
    public int skipBytes(int len) throws IOException {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }
}
