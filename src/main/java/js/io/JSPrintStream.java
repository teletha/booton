/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.io;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import js.lang.builtin.Console;
import booton.translator.JavaAPIProvider;

/**
 * @version 2013/05/16 16:31:56
 */
@JavaAPIProvider(PrintStream.class)
class JSPrintStream extends FilterOutputStream {

    /**
     * @param out
     */
    public JSPrintStream(OutputStream out) {
        super(out);
    }

    /**
     * Terminates the current line by writing the line separator string. The line separator string
     * is defined by the system property <code>line.separator</code>, and is not necessarily a
     * single newline character (<code>'\n'</code>).
     */
    public void println() {
    }

    /**
     * Prints a boolean and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(boolean)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>boolean</code> to be printed
     */
    public void println(boolean x) {
        Console.log(x);
    }

    /**
     * Prints a character and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(char)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>char</code> to be printed.
     */
    public void println(char x) {
        Console.log(x);
    }

    /**
     * Prints an integer and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(int)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>int</code> to be printed.
     */
    public void println(int x) {
        Console.log(x);
    }

    /**
     * Prints a long and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(long)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x a The <code>long</code> to be printed.
     */
    public void println(long x) {
        Console.log(x);
    }

    /**
     * Prints a float and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(float)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>float</code> to be printed.
     */
    public void println(float x) {
        Console.log(x);
    }

    /**
     * Prints a double and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(double)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>double</code> to be printed.
     */
    public void println(double x) {
        Console.log(x);
    }

    /**
     * Prints an array of characters and then terminate the line. This method behaves as though it
     * invokes <code>{@link #print(char[])}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x an array of chars to print.
     */
    public void println(char[] x) {
        Console.log(x);
    }

    /**
     * Prints a String and then terminate the line. This method behaves as though it invokes
     * <code>{@link #print(String)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>String</code> to be printed.
     */
    public void println(String x) {
        Console.log(x);
    }

    /**
     * Prints an Object and then terminate the line. This method calls at first String.valueOf(x) to
     * get the printed object's string value, then behaves as though it invokes
     * <code>{@link #print(String)}</code> and then <code>{@link #println()}</code>.
     * 
     * @param x The <code>Object</code> to be printed.
     */
    public void println(Object x) {
        Console.log(x);
    }
}
