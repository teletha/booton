/*
 * Copyright (C) 2015 Nameless Production Committee
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
}
