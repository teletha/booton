/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.util.Objects;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/10/23 19:09:55
 */
@JavaAPIProvider(java.lang.StackTraceElement.class)
class JSStackTraceElement {

    // Normally initialized by VM (public constructor added in 1.5)
    private String declaringClass;

    private String methodName;

    private String fileName;

    private int lineNumber;

    /**
     * Creates a stack trace element representing the specified execution point.
     * 
     * @param declaringClass the fully qualified name of the class containing the execution point
     *            represented by the stack trace element
     * @param methodName the name of the method containing the execution point represented by the
     *            stack trace element
     * @param fileName the name of the file containing the execution point represented by the stack
     *            trace element, or {@code null} if this information is unavailable
     * @param lineNumber the line number of the source line containing the execution point
     *            represented by this stack trace element, or a negative number if this information
     *            is unavailable. A value of -2 indicates that the method containing the execution
     *            point is a native method
     * @throws NullPointerException if {@code declaringClass} or {@code methodName} is null
     * @since 1.5
     */
    public JSStackTraceElement(String declaringClass, String methodName, String fileName, int lineNumber) {
        this.declaringClass = Objects.requireNonNull(declaringClass, "Declaring class is null");
        this.methodName = Objects.requireNonNull(methodName, "Method name is null");
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    /**
     * Returns the name of the source file containing the execution point represented by this stack
     * trace element. Generally, this corresponds to the {@code SourceFile} attribute of the
     * relevant {@code class} file (as per <i>The Java Virtual Machine Specification</i>, Section
     * 4.7.7). In some systems, the name may refer to some source code unit other than a file, such
     * as an entry in source repository.
     * 
     * @return the name of the file containing the execution point represented by this stack trace
     *         element, or {@code null} if this information is unavailable.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Returns the line number of the source line containing the execution point represented by this
     * stack trace element. Generally, this is derived from the {@code LineNumberTable} attribute of
     * the relevant {@code class} file (as per <i>The Java Virtual Machine Specification</i>,
     * Section 4.7.8).
     * 
     * @return the line number of the source line containing the execution point represented by this
     *         stack trace element, or a negative number if this information is unavailable.
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Returns the fully qualified name of the class containing the execution point represented by
     * this stack trace element.
     * 
     * @return the fully qualified name of the {@code Class} containing the execution point
     *         represented by this stack trace element.
     */
    public String getClassName() {
        return declaringClass;
    }

    /**
     * Returns the name of the method containing the execution point represented by this stack trace
     * element. If the execution point is contained in an instance or class initializer, this method
     * will return the appropriate <i>special method name</i>, {@code <init>} or {@code <clinit>},
     * as per Section 3.9 of <i>The Java Virtual Machine Specification</i>.
     * 
     * @return the name of the method containing the execution point represented by this stack trace
     *         element.
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Returns true if the method containing the execution point represented by this stack trace
     * element is a native method.
     * 
     * @return {@code true} if the method containing the execution point represented by this stack
     *         trace element is a native method.
     */
    public boolean isNativeMethod() {
        return lineNumber == -2;
    }

    /**
     * Returns a string representation of this stack trace element. The format of this string
     * depends on the implementation, but the following examples may be regarded as typical:
     * <ul>
     * <li>
     *   {@code "MyClass.mash(MyClass.java:9)"} - Here, {@code "MyClass"} is the
     * <i>fully-qualified name</i> of the class containing the execution point represented by this
     * stack trace element, {@code "mash"} is the name of the method containing the execution point,
     * {@code "MyClass.java"} is the source file containing the execution point, and {@code "9"} is
     * the line number of the source line containing the execution point.
     * <li>
     *   {@code "MyClass.mash(MyClass.java)"} - As above, but the line number is unavailable.
     * <li>
     *   {@code "MyClass.mash(Unknown Source)"} - As above, but neither the file name nor the line
     * number are available.
     * <li>
     *   {@code "MyClass.mash(Native Method)"} - As above, but neither the file name nor the line
     * number are available, and the method containing the execution point is known to be a native
     * method.
     * </ul>
     * 
     * @see Throwable#printStackTrace()
     */
    public String toString() {
        return getClassName() + "." + methodName + (isNativeMethod() ? "(Native Method)"
                : (fileName != null && lineNumber >= 0 ? "(" + fileName + ":" + lineNumber + ")"
                        : (fileName != null ? "(" + fileName + ")" : "(Unknown Source)")));
    }

    /**
     * Returns true if the specified object is another {@code StackTraceElement} instance
     * representing the same execution point as this instance. Two stack trace elements {@code a}
     * and {@code b} are equal if and only if:
     * 
     * <pre>{@code
     *     equals(a.getFileName(), b.getFileName()) &&
     *     a.getLineNumber() == b.getLineNumber()) &&
     *     equals(a.getClassName(), b.getClassName()) &&
     *     equals(a.getMethodName(), b.getMethodName())
     * }</pre>
     * 
     * where {@code equals} has the semantics of {@link java.util.Objects#equals(Object, Object)
     * Objects.equals}.
     * 
     * @param obj the object to be compared with this stack trace element.
     * @return true if the specified object is another {@code StackTraceElement} instance
     *         representing the same execution point as this instance.
     */
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof JSStackTraceElement)) return false;
        JSStackTraceElement e = (JSStackTraceElement) obj;
        return e.declaringClass.equals(declaringClass) && e.lineNumber == lineNumber && Objects.equals(methodName, e.methodName) && Objects.equals(fileName, e.fileName);
    }

    /**
     * Returns a hash code value for this stack trace element.
     */
    public int hashCode() {
        int result = 31 * declaringClass.hashCode() + methodName.hashCode();
        result = 31 * result + Objects.hashCode(fileName);
        result = 31 * result + lineNumber;
        return result;
    }
}
