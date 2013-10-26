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

import java.security.Permission;

import booton.translator.JavaAPIProvider;

/**
 * @version 2013/09/24 16:10:33
 */
@JavaAPIProvider(SecurityManager.class)
class JSSecurityManager {

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to access
     * members.
     * <p>
     * The default policy is to allow access to PUBLIC members, as well as access to classes that
     * have the same class loader as the caller. In all other cases, this method calls
     * <code>checkPermission</code> with the <code>RuntimePermission("accessDeclaredMembers")
     * </code> permission.
     * <p>
     * If this method is overridden, then a call to <code>super.checkMemberAccess</code> cannot be
     * made, as the default implementation of <code>checkMemberAccess</code> relies on the code
     * being checked being at a stack depth of 4.
     * 
     * @param clazz the class that reflection is to be performed on.
     * @param which type of access, PUBLIC or DECLARED.
     * @exception SecurityException if the caller does not have permission to access members.
     * @exception NullPointerException if the <code>clazz</code> argument is <code>null</code>.
     * @see java.lang.reflect.Member
     * @since JDK1.1
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkMemberAccess(Class<?> clazz, int which) {
        // do nothing
    }

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to access the
     * package specified by the argument.
     * <p>
     * This method is used by the <code>loadClass</code> method of class loaders.
     * <p>
     * This method first gets a list of restricted packages by obtaining a comma-separated list from
     * a call to <code>java.security.Security.getProperty("package.access")</code>, and checks to
     * see if <code>pkg</code> starts with or equals any of the restricted packages. If it does,
     * then <code>checkPermission</code> gets called with the
     * <code>RuntimePermission("accessClassInPackage."+pkg)</code> permission.
     * <p>
     * If this method is overridden, then <code>super.checkPackageAccess</code> should be called as
     * the first line in the overridden method.
     * 
     * @param pkg the package name.
     * @exception SecurityException if the calling thread does not have permission to access the
     *                specified package.
     * @exception NullPointerException if the package name argument is <code>null</code>.
     * @see java.lang.ClassLoader#loadClass(java.lang.String, boolean) loadClass
     * @see java.security.Security#getProperty getProperty
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkPackageAccess(String pkg) {
        // do nothing
    }

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to create a new
     * class loader.
     * <p>
     * This method calls <code>checkPermission</code> with the
     * <code>RuntimePermission("createClassLoader")</code> permission.
     * <p>
     * If you override this method, then you should make a call to
     * <code>super.checkCreateClassLoader</code> at the point the overridden method would normally
     * throw an exception.
     * 
     * @exception SecurityException if the calling thread does not have permission to create a new
     *                class loader.
     * @see java.lang.ClassLoader#ClassLoader()
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkCreateClassLoader() {
        // do nothing
    }

    /**
     * Throws a <code>SecurityException</code> if the requested access, specified by the given
     * permission, is not permitted based on the security policy currently in effect.
     * <p>
     * This method calls <code>AccessController.checkPermission</code> with the given permission.
     * 
     * @param perm the requested permission.
     * @exception SecurityException if access is not permitted based on the current security policy.
     * @exception NullPointerException if the permission argument is <code>null</code>.
     * @since 1.2
     */
    public void checkPermission(Permission perm) {
        // do nothing
    }
}
