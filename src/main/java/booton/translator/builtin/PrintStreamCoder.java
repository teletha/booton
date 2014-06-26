/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.builtin;

import java.io.OutputStream;
import java.io.PrintStream;

import booton.translator.Javascript;
import booton.translator.Translator;

/**
 * @version 2013/05/20 12:41:55
 */
public class PrintStreamCoder extends Translator<PrintStream> {

    /**
     * Creates a new print stream. This stream will not flush automatically.
     * 
     * @param out The output stream to which values and objects will be printed
     * @see java.io.PrintWriter#PrintWriter(java.io.OutputStream)
     */
    public String PrintStream(OutputStream out) {
        return "console";
    }

    /**
     * Prints a boolean and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(boolean)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>boolean</code> to be printed
     */
    public String println(boolean x) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints a character and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(char)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>char</code> to be printed.
     */
    public String println(char x) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints an integer and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(int)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>int</code> to be printed.
     */
    public String println(int x) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints a long and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(long)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x a The <code>long</code> to be printed.
     */
    public String println(long x) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints a float and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(float)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>float</code> to be printed.
     */
    public String println(float x) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints a double and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(double)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>double</code> to be printed.
     */
    public String println(double x) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints an array of characters and then terminate the line. This method behaves as though it
     * invokes <code>{@link #print(char[])}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x an array of chars to print.
     */
    public String println(char x[]) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints a String and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(String)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>String</code> to be printed.
     */
    public String println(String x) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints a string. If the argument is <code>null</code> then the string <code>"null"</code> is
     * printed. Otherwise, the string's characters are converted into bytes according to the
     * platform's default character encoding, and these bytes are written in exactly the manner of
     * the <code>{@link #write(int)}</code> method.
     * 
     * @param s The <code>String</code> to be printed
     */
    public String print(String s) {
        return that + ".log(" + param(0) + ")";
    }

    /**
     * Prints an Object and then terminate the line. This method calls at first String.valueOf(x) to
     * get the printed object's string value, then behaves as though it invokes
     * <code>{@link #print(String)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>Object</code> to be printed.
     */
    public String println(Object x) {
        return that + ".log(" + Javascript.writeMethodCode(String.class, "valueOf", Object.class, param(0)) + ")";
    }

    /**
     * Writes a formatted string to this output stream using the specified format string and
     * arguments.
     * <p>
     * The locale always used is the one returned by {@link java.util.Locale#getDefault()
     * Locale.getDefault()}, regardless of any previous invocations of other formatting methods on
     * this object.
     *
     * @param format A format string as described in <a href="../util/Formatter.html#syntax">Format
     *            string syntax</a>
     * @param args Arguments referenced by the format specifiers in the format string. If there are
     *            more arguments than format specifiers, the extra arguments are ignored. The number
     *            of arguments is variable and may be zero. The maximum number of arguments is
     *            limited by the maximum dimension of a Java array as defined by <cite>The
     *            Java&trade; Virtual Machine Specification</cite>. The behaviour on a <tt>null</tt>
     *            argument depends on the <a href="../util/Formatter.html#syntax">conversion</a>.
     * @throws java.util.IllegalFormatException If a format string contains an illegal syntax, a
     *             format specifier that is incompatible with the given arguments, insufficient
     *             arguments given the format string, or other illegal conditions. For specification
     *             of all possible formatting errors, see the <a
     *             href="../util/Formatter.html#detail">Details</a> section of the formatter class
     *             specification.
     * @throws NullPointerException If the <tt>format</tt> is <tt>null</tt>
     * @return This output stream
     * @since 1.5
     */
    public String format(String format, Object... args) {
        return that + ".log(" + param(0) + ")";
    }

}
