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

    /** The dummy. */
    private static final JSSecurityManager security = new JSSecurityManager();

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
    public static PrintStream out = new PrintStream(new DummyOutputStream());

    /**
     * The "standard" error output stream. This stream is already open and ready to accept output
     * data.
     * <p>
     * Typically this stream corresponds to display output or another output destination specified
     * by the host environment or user. By convention, this output stream is used to display error
     * messages or other information that should come to the immediate attention of a user even if
     * the principal output stream, the value of the variable <code>out</code>, has been redirected
     * to a file or other destination that is typically not continuously monitored.
     */
    public static PrintStream err = new PrintStream(new DummyOutputStream());

    /**
     * Reassigns the "standard" output stream.
     * <p>
     * First, if there is a security manager, its <code>checkPermission</code> method is called with
     * a <code>RuntimePermission("setIO")</code> permission to see if it's ok to reassign the
     * "standard" output stream.
     * 
     * @param out the new standard output stream
     * @throws SecurityException if a security manager exists and its <code>checkPermission</code>
     *             method doesn't allow reassigning of the standard output stream.
     * @see SecurityManager#checkPermission
     * @see java.lang.RuntimePermission
     * @since JDK1.1
     */
    public static void setOut(PrintStream stream) {
        out = stream;
    }

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
            Array.set(dest, destPos + i, Array.get(src, srcPos + i));
        }
    }

    /**
     * Returns the current time in milliseconds. Note that while the unit of time of the return
     * value is a millisecond, the granularity of the value depends on the underlying operating
     * system and may be larger. For example, many operating systems measure time in units of tens
     * of milliseconds.
     * <p>
     * See the description of the class <code>Date</code> for a discussion of slight discrepancies
     * that may arise between "computer time" and coordinated universal time (UTC).
     * 
     * @return the difference, measured in milliseconds, between the current time and midnight,
     *         January 1, 1970 UTC.
     * @see java.util.Date
     */
    public static long currentTimeMillis() {
        return NativeDate.now();
    }

    /**
     * Returns the same hash code for the given object as would be returned by the default method
     * hashCode(), whether or not the given object's class overrides hashCode(). The hash code for
     * the null reference is zero.
     * 
     * @param object object for which the hashCode is to be calculated
     * @return the hashCode
     * @since JDK1.1
     */
    public static int identityHashCode(Object object) {
        return object.hashCode();
    }

    /**
     * Gets the system security interface.
     * 
     * @return if a security manager has already been established for the current application, then
     *         that security manager is returned; otherwise, <code>null</code> is returned.
     * @see #setSecurityManager
     */
    public static SecurityManager getSecurityManager() {
        return (SecurityManager) (Object) security;
    }

    /**
     * Returns the current value of the running Java Virtual Machine's high-resolution time source,
     * in nanoseconds.
     * <p>
     * This method can only be used to measure elapsed time and is not related to any other notion
     * of system or wall-clock time. The value returned represents nanoseconds since some fixed but
     * arbitrary <i>origin</i> time (perhaps in the future, so values may be negative). The same
     * origin is used by all invocations of this method in an instance of a Java virtual machine;
     * other virtual machine instances are likely to use a different origin.
     * <p>
     * This method provides nanosecond precision, but not necessarily nanosecond resolution (that
     * is, how frequently the value changes) - no guarantees are made except that the resolution is
     * at least as good as that of {@link #currentTimeMillis()}.
     * <p>
     * Differences in successive calls that span greater than approximately 292 years
     * (2<sup>63</sup> nanoseconds) will not correctly compute elapsed time due to numerical
     * overflow.
     * <p>
     * The values returned by this method become meaningful only when the difference between two
     * such values, obtained within the same instance of a Java virtual machine, is computed.
     * <p>
     * For example, to measure how long some code takes to execute:
     * 
     * <pre> {@code
     * long startTime = System.nanoTime();
     * // ... the code being measured ...
     * long estimatedTime = System.nanoTime() - startTime;}</pre>
     * <p>
     * To compare two nanoTime values
     * 
     * <pre> {@code
     * long t0 = System.nanoTime();
     * ...
     * long t1 = System.nanoTime();}</pre>
     * one should use {@code t1 - t0 < 0}, not {@code t1 < t0}, because of the possibility of
     * numerical overflow.
     * 
     * @return the current value of the running Java Virtual Machine's high-resolution time source,
     *         in nanoseconds
     * @since 1.5
     */
    public static long nanoTime() {
        return currentTimeMillis();
    }

    /**
     * @version 2013/05/16 19:27:00
     */
    private static class DummyOutputStream extends OutputStream {

        /**
         * {@inheritDoc}
         */
        @Override
        public void write(int b) throws IOException {
            // dummy
        }
    }
}
