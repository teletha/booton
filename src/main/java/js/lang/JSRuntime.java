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

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/12/31 0:37:41
 */
@JavaAPIProvider(Runtime.class)
class JSRuntime {

    /** The singleton. */
    private static final JSRuntime runtime = new JSRuntime();

    /**
     * Returns the runtime object associated with the current Java application. Most of the methods
     * of class <code>Runtime</code> are instance methods and must be invoked with respect to the
     * current runtime object.
     * 
     * @return the <code>Runtime</code> object associated with the current Java application.
     */
    public static Runtime getRuntime() {
        return (Runtime) (Object) runtime;
    }

    /**
     * Returns the number of processors available to the Java virtual machine.
     * <p>
     * This value may change during a particular invocation of the virtual machine. Applications
     * that are sensitive to the number of available processors should therefore occasionally poll
     * this property and adjust their resource usage appropriately.
     * </p>
     * 
     * @return the maximum number of processors available to the virtual machine; never smaller than
     *         one
     * @since 1.4
     */
    public int availableProcessors() {
        return 1;
    }
}
