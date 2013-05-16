/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/05/16 16:20:51
 */
@JavaAPIProvider(System.class)
class JSSystem {

    /**
     * The "standard" output stream. This stream is already open and ready to accept output data.
     * Typically this stream corresponds to display output or another output destination specified
     * by the host environment or user.
     * <p>
     * For simple stand-alone Java applications, a typical way to write a line of output data is:
     * <blockquote>
     * 
     * <pre>
     *     System.out.println(data)
     * </pre>
     * </blockquote>
     * <p>
     * See the <code>println</code> methods in class <code>PrintStream</code>.
     * 
     * @see java.io.PrintStream#println()
     * @see java.io.PrintStream#println(boolean)
     * @see java.io.PrintStream#println(char)
     * @see java.io.PrintStream#println(char[])
     * @see java.io.PrintStream#println(double)
     * @see java.io.PrintStream#println(float)
     * @see java.io.PrintStream#println(int)
     * @see java.io.PrintStream#println(long)
     * @see java.io.PrintStream#println(java.lang.Object)
     * @see java.io.PrintStream#println(java.lang.String)
     */
    public final PrintStream out = new PrintStream((OutputStream) null);

    /**
     * Copies an array from the specified source array, beginning at the specified position, to the
     * specified position of the destination array. A subsequence of array components are copied
     * from the source array referenced by <code>src</code> to the destination array referenced by
     * <code>dest</code>. The number of components copied is equal to the <code>length</code>
     * argument. The components at positions <code>srcPos</code> through
     * <code>srcPos+length-1</code> in the source array are copied into positions
     * <code>destPos</code> through <code>destPos+length-1</code>, respectively, of the destination
     * array.
     * <p>
     * If the <code>src</code> and <code>dest</code> arguments refer to the same array object, then
     * the copying is performed as if the components at positions <code>srcPos</code> through
     * <code>srcPos+length-1</code> were first copied to a temporary array with <code>length</code>
     * components and then the contents of the temporary array were copied into positions
     * <code>destPos</code> through <code>destPos+length-1</code> of the destination array.
     * <p>
     * If <code>dest</code> is <code>null</code>, then a <code>NullPointerException</code> is
     * thrown.
     * <p>
     * If <code>src</code> is <code>null</code>, then a <code>NullPointerException</code> is thrown
     * and the destination array is not modified.
     * <p>
     * Otherwise, if any of the following is true, an <code>ArrayStoreException</code> is thrown and
     * the destination is not modified:
     * <ul>
     * <li>The <code>src</code> argument refers to an object that is not an array.
     * <li>The <code>dest</code> argument refers to an object that is not an array.
     * <li>The <code>src</code> argument and <code>dest</code> argument refer to arrays whose
     * component types are different primitive types.
     * <li>The <code>src</code> argument refers to an array with a primitive component type and the
     * <code>dest</code> argument refers to an array with a reference component type.
     * <li>The <code>src</code> argument refers to an array with a reference component type and the
     * <code>dest</code> argument refers to an array with a primitive component type.
     * </ul>
     * <p>
     * Otherwise, if any of the following is true, an <code>IndexOutOfBoundsException</code> is
     * thrown and the destination is not modified:
     * <ul>
     * <li>The <code>srcPos</code> argument is negative.
     * <li>The <code>destPos</code> argument is negative.
     * <li>The <code>length</code> argument is negative.
     * <li><code>srcPos+length</code> is greater than <code>src.length</code>, the length of the
     * source array.
     * <li><code>destPos+length</code> is greater than <code>dest.length</code>, the length of the
     * destination array.
     * </ul>
     * <p>
     * Otherwise, if any actual component of the source array from position <code>srcPos</code>
     * through <code>srcPos+length-1</code> cannot be converted to the component type of the
     * destination array by assignment conversion, an <code>ArrayStoreException</code> is thrown. In
     * this case, let <b><i>k</i></b> be the smallest nonnegative integer less than length such that
     * <code>src[srcPos+</code><i>k</i><code>]</code> cannot be converted to the component type of
     * the destination array; when the exception is thrown, source array components from positions
     * <code>srcPos</code> through <code>srcPos+</code><i>k</i><code>-1</code> will already have
     * been copied to destination array positions <code>destPos</code> through <code>destPos+</code>
     * <i>k</I><code>-1</code> and no other positions of the destination array will have been
     * modified. (Because of the restrictions already itemized, this paragraph effectively applies
     * only to the situation where both arrays have component types that are reference types.)
     * 
     * @param src the source array.
     * @param srcPos starting position in the source array.
     * @param dest the destination array.
     * @param destPos starting position in the destination data.
     * @param length the number of array elements to be copied.
     * @exception IndexOutOfBoundsException if copying would cause access of data outside array
     *                bounds.
     * @exception ArrayStoreException if an element in the <code>src</code> array could not be
     *                stored into the <code>dest</code> array because of a type mismatch.
     * @exception NullPointerException if either <code>src</code> or <code>dest</code> is
     *                <code>null</code>.
     */
    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            Array.set(dest, destPos + 1, Array.get(src, srcPos + i));
        }
    }
}
