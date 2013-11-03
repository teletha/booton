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

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/03 1:11:17
 */
@JavaAPIProvider(Throwable.class)
class JSThrowable {

    /** The error message. */
    private final String message;

    /** The cause error. */
    private Throwable cause;

    /** The stacktrace info. */
    private StackTraceElement[] stacktrace;

    /**
     * The list of suppressed exceptions, as returned by {@link #getSuppressed()}. The list is
     * initialized to a zero-element unmodifiable sentinel list. When a serialized Throwable is read
     * in, if the {@code suppressedExceptions} field points to a zero-element list, the field is
     * reset to the sentinel value.
     * 
     * @serial
     * @since 1.7
     */
    private List<Throwable> suppressedExceptions;

    /**
     * 
     */
    public JSThrowable() {
        this("", null);
    }

    /**
     * @param message
     */
    public JSThrowable(String message) {
        this(message, null);
    }

    /**
     * @param cause
     */
    public JSThrowable(Throwable cause) {
        this("", cause);
    }

    /**
     * @param message
     * @param cause
     */
    public JSThrowable(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
        this.stacktrace = createStackTrace(Global.error(), true);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public JSThrowable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        this(message, cause);
    }

    /**
     * {@inheritDoc}
     */
    public String getMessage() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    public String getLocalizedMessage() {
        return message;
    }

    /**
     * {@inheritDoc}
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * Provides programmatic access to the stack trace information printed by
     * {@link #printStackTrace()}. Returns an array of stack trace elements, each representing one
     * stack frame. The zeroth element of the array (assuming the array's length is non-zero)
     * represents the top of the stack, which is the last method invocation in the sequence.
     * Typically, this is the point at which this throwable was created and thrown. The last element
     * of the array (assuming the array's length is non-zero) represents the bottom of the stack,
     * which is the first method invocation in the sequence.
     * <p>
     * Some virtual machines may, under some circumstances, omit one or more stack frames from the
     * stack trace. In the extreme case, a virtual machine that has no stack trace information
     * concerning this throwable is permitted to return a zero-length array from this method.
     * Generally speaking, the array returned by this method will contain one element for every
     * frame that would be printed by {@code printStackTrace}. Writes to the returned array do not
     * affect future calls to this method.
     * 
     * @return an array of stack trace elements representing the stack trace pertaining to this
     *         throwable.
     * @since 1.4
     */
    public StackTraceElement[] getStackTrace() {
        return stacktrace;
    }

    /**
     * Sets the stack trace elements that will be returned by {@link #getStackTrace()} and printed
     * by {@link #printStackTrace()} and related methods. This method, which is designed for use by
     * RPC frameworks and other advanced systems, allows the client to override the default stack
     * trace that is either generated by {@link #fillInStackTrace()} when a throwable is constructed
     * or deserialized when a throwable is read from a serialization stream.
     * <p>
     * If the stack trace of this {@code Throwable}
     * {@linkplain Throwable#Throwable(String, Throwable, boolean, boolean) is not writable},
     * calling this method has no effect other than validating its argument.
     * 
     * @param stackTrace the stack trace elements to be associated with this {@code Throwable}. The
     *            specified array is copied by this call; changes in the specified array after the
     *            method invocation returns will have no affect on this {@code Throwable}'s stack
     *            trace.
     * @throws NullPointerException if {@code stackTrace} is {@code null} or if any of the elements
     *             of {@code stackTrace} are {@code null}
     * @since 1.4
     */
    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stacktrace = stackTrace;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return message;
    }

    /**
     * Prints this throwable and its backtrace to the standard error stream. This method prints a
     * stack trace for this {@code Throwable} object on the error output stream that is the value of
     * the field {@code System.err}. The first line of output contains the result of the
     * {@link #toString()} method for this object. Remaining lines represent data previously
     * recorded by the method {@link #fillInStackTrace()}. The format of this information depends on
     * the implementation, but the following example may be regarded as typical: <blockquote>
     * 
     * <pre>
     * java.lang.NullPointerException
     *         at MyClass.mash(MyClass.java:9)
     *         at MyClass.crunch(MyClass.java:6)
     *         at MyClass.main(MyClass.java:3)
     * </pre>
     * 
     * </blockquote> This example was produced by running the program:
     * 
     * <pre>
     * class MyClass {
     *     public static void main(String[] args) {
     *         crunch(null);
     *     }
     *     static void crunch(int[] a) {
     *         mash(a);
     *     }
     *     static void mash(int[] b) {
     *         System.out.println(b[0]);
     *     }
     * }
     * </pre>
     * 
     * The backtrace for a throwable with an initialized, non-null cause should generally include
     * the backtrace for the cause. The format of this information depends on the implementation,
     * but the following example may be regarded as typical:
     * 
     * <pre>
     * HighLevelException: MidLevelException: LowLevelException
     *         at Junk.a(Junk.java:13)
     *         at Junk.main(Junk.java:4)
     * Caused by: MidLevelException: LowLevelException
     *         at Junk.c(Junk.java:23)
     *         at Junk.b(Junk.java:17)
     *         at Junk.a(Junk.java:11)
     *         ... 1 more
     * Caused by: LowLevelException
     *         at Junk.e(Junk.java:30)
     *         at Junk.d(Junk.java:27)
     *         at Junk.c(Junk.java:21)
     *         ... 3 more
     * </pre>
     * 
     * Note the presence of lines containing the characters {@code "..."}. These lines indicate that
     * the remainder of the stack trace for this exception matches the indicated number of frames
     * from the bottom of the stack trace of the exception that was caused by this exception (the
     * "enclosing" exception). This shorthand can greatly reduce the length of the output in the
     * common case where a wrapped exception is thrown from same method as the "causative exception"
     * is caught. The above example was produced by running the program:
     * 
     * <pre>
     * public class Junk {
     *     public static void main(String args[]) {
     *         try {
     *             a();
     *         } catch(HighLevelException e) {
     *             e.printStackTrace();
     *         }
     *     }
     *     static void a() throws HighLevelException {
     *         try {
     *             b();
     *         } catch(MidLevelException e) {
     *             throw new HighLevelException(e);
     *         }
     *     }
     *     static void b() throws MidLevelException {
     *         c();
     *     }
     *     static void c() throws MidLevelException {
     *         try {
     *             d();
     *         } catch(LowLevelException e) {
     *             throw new MidLevelException(e);
     *         }
     *     }
     *     static void d() throws LowLevelException {
     *        e();
     *     }
     *     static void e() throws LowLevelException {
     *         throw new LowLevelException();
     *     }
     * }
     *
     * class HighLevelException extends Exception {
     *     HighLevelException(Throwable cause) { super(cause); }
     * }
     *
     * class MidLevelException extends Exception {
     *     MidLevelException(Throwable cause)  { super(cause); }
     * }
     *
     * class LowLevelException extends Exception {
     * }
     * </pre>
     * 
     * As of release 7, the platform supports the notion of <i>suppressed exceptions</i> (in
     * conjunction with the {@code try}-with-resources statement). Any exceptions that were
     * suppressed in order to deliver an exception are printed out beneath the stack trace. The
     * format of this information depends on the implementation, but the following example may be
     * regarded as typical:
     * 
     * <pre>
     * Exception in thread "main" java.lang.Exception: Something happened
     *  at Foo.bar(Foo.java:10)
     *  at Foo.main(Foo.java:5)
     *  Suppressed: Resource$CloseFailException: Resource ID = 0
     *          at Resource.close(Resource.java:26)
     *          at Foo.bar(Foo.java:9)
     *          ... 1 more
     * </pre>
     * 
     * Note that the "... n more" notation is used on suppressed exceptions just at it is used on
     * causes. Unlike causes, suppressed exceptions are indented beyond their
     * "containing exceptions."
     * <p>
     * An exception can have both a cause and one or more suppressed exceptions:
     * 
     * <pre>
     * Exception in thread "main" java.lang.Exception: Main block
     *  at Foo3.main(Foo3.java:7)
     *  Suppressed: Resource$CloseFailException: Resource ID = 2
     *          at Resource.close(Resource.java:26)
     *          at Foo3.main(Foo3.java:5)
     *  Suppressed: Resource$CloseFailException: Resource ID = 1
     *          at Resource.close(Resource.java:26)
     *          at Foo3.main(Foo3.java:5)
     * Caused by: java.lang.Exception: I did it
     *  at Foo3.main(Foo3.java:8)
     * </pre>
     * Likewise, a suppressed exception can have a cause:
     * 
     * <pre>
     * Exception in thread "main" java.lang.Exception: Main block
     *  at Foo4.main(Foo4.java:6)
     *  Suppressed: Resource2$CloseFailException: Resource ID = 1
     *          at Resource2.close(Resource2.java:20)
     *          at Foo4.main(Foo4.java:5)
     *  Caused by: java.lang.Exception: Rats, you caught me
     *          at Resource2$CloseFailException.<init>(Resource2.java:45)
     *          ... 2 more
     * </pre>
     */
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /**
     * Prints this throwable and its backtrace to the specified print stream.
     * 
     * @param stream {@code PrintStream} to use for output
     */
    public void printStackTrace(PrintStream stream) {
        for (StackTraceElement element : stacktrace) {
            System.out.println(element);
        }
    }

    /**
     * Appends the specified exception to the exceptions that were suppressed in order to deliver
     * this exception. This method is thread-safe and typically called (automatically and
     * implicitly) by the {@code try}-with-resources statement.
     * <p>
     * The suppression behavior is enabled <em>unless</em> disabled
     * {@linkplain #Throwable(String, Throwable, boolean, boolean) via a constructor}. When
     * suppression is disabled, this method does nothing other than to validate its argument.
     * <p>
     * Note that when one exception {@linkplain #initCause(Throwable) causes} another exception, the
     * first exception is usually caught and then the second exception is thrown in response. In
     * other words, there is a causal connection between the two exceptions. In contrast, there are
     * situations where two independent exceptions can be thrown in sibling code blocks, in
     * particular in the {@code try} block of a {@code try}-with-resources statement and the
     * compiler-generated {@code finally} block which closes the resource. In these situations, only
     * one of the thrown exceptions can be propagated. In the {@code try}-with-resources statement,
     * when there are two such exceptions, the exception originating from the {@code try} block is
     * propagated and the exception from the {@code finally} block is added to the list of
     * exceptions suppressed by the exception from the {@code try} block. As an exception unwinds
     * the stack, it can accumulate multiple suppressed exceptions.
     * <p>
     * An exception may have suppressed exceptions while also being caused by another exception.
     * Whether or not an exception has a cause is semantically known at the time of its creation,
     * unlike whether or not an exception will suppress other exceptions which is typically only
     * determined after an exception is thrown.
     * <p>
     * Note that programmer written code is also able to take advantage of calling this method in
     * situations where there are multiple sibling exceptions and only one can be propagated.
     * 
     * @param exception the exception to be added to the list of suppressed exceptions
     * @throws IllegalArgumentException if {@code exception} is this throwable; a throwable cannot
     *             suppress itself.
     * @throws NullPointerException if {@code exception} is {@code null}
     * @since 1.7
     */
    public final synchronized void addSuppressed(Throwable exception) {
        if (exception == (Object) this) {
            throw new IllegalArgumentException("Self-suppression not permitted", exception);
        }

        if (exception == null) {
            throw new NullPointerException("Cannot suppress a null exception.");
        }

        if (suppressedExceptions == null) {
            suppressedExceptions = new ArrayList();
        }
        suppressedExceptions.add(exception);
    }

    /**
     * <p>
     * Create stack trace ement from the specified {@link NativeError}.
     * </p>
     * 
     * @param error A native error.
     * @param user A flag for user constructed error.
     * @return
     */
    static StackTraceElement[] createStackTrace(NativeError error, boolean user) {
        Pattern pattern = null;
        String[] lines;
        String stack = error.getStackTrace();

        if (stack != null) {
            lines = stack.split("\n");
        } else {
            lines = new String[] {error.getName() + "@" + error.getFileName() + ":" + error.getLineNumber(), "", ""};
        }

        int start = 0;
        int end = lines.length - 1;

        if (error.hasProperty("columnNumber")) {
            // firefox
            pattern = Pattern.compile("\\.?(.+)?@(.+):(.+)");
            end--;
        } else if (error.hasProperty("sourceURL")) {
            // webkit
        } else if (error.hasProperty("number")) {
            // ie
            pattern = Pattern.compile("\\s*at\\s*(.+)\\s\\((.+):(.+):(.+)\\)");
            start++;
        } else if (error.getStackTrace().contains("@")) {
            // html unit
            pattern = Pattern.compile("(.+)?@(.+):(.+)");
            end--;

            if (user) {
                start = start + 5;
            }
        } else {
            // blink
            pattern = Pattern.compile("\\s*at\\s*([^\\s]+).+\\((.+):(.+):(.+)\\)");
            start++;
        }

        List<JSStackTraceElement> elements = new ArrayList();

        for (int i = start; i < end; i++) {
            Matcher matcher = pattern.matcher(lines[i].trim());

            if (matcher.matches()) {
                String method = matcher.group(1);

                if (method == null) {
                    method = "";
                }

                int index = method.lastIndexOf(".");
                method = index == -1 ? method : method.substring(index + 1);

                elements.add(new JSStackTraceElement("", method, matcher.group(2), Integer.parseInt(matcher.group(3))));
            }
        }

        if (user) {
            // remove the sequence of Throwable construction
            int index = -1;

            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getMethodName().equals("Class") && elements.get(i)
                        .getFileName()
                        .contains("boot.js")) {
                    index = i;
                    break;
                }
            }
            elements = elements.subList(index + 1, elements.size());
        }
        return elements.toArray(new StackTraceElement[elements.size()]);
    }

    /**
     * <p>
     * Convert to {@link Throwable} object if the specified error is native.
     * </p>
     * 
     * @param error A native error object or not.
     * @return A wrapped {@link Throwable} object.
     */
    static Throwable wrap(Object error) {
        Throwable throwable;

        if (error instanceof Throwable) {
            throwable = (Throwable) error;
        } else {
            NativeError nativeError = (NativeError) error;
            throwable = new InternalError(nativeError.getMessage());
            throwable.setStackTrace(createStackTrace(nativeError, false));
        }
        return throwable;
    }
}