/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

/**
 * @version 2014/10/15 15:21:31
 */
public interface StyleDeclaration {

    /**
     * <p>
     * Declare style definitions.
     * </p>
     */
    public void declare();

    /**
     * <p>
     * Compute identical name by the specified class and method name.
     * </p>
     * 
     * @param declaredClass
     * @param declarationMethodName
     * @return
     */
    public static String computeStyleClassName(Class declaredClass, String declarationMethodName) {
        while (declaredClass.getSuperclass() != Style.class) {
            declaredClass = declaredClass.getSuperclass();
        }
        return declaredClass.getName().replace('.', '_').concat("_").concat(declarationMethodName);
    }
}
