/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import java.io.FileDescriptor;
import java.security.Permission;

import booton.translator.JavaAPIProvider;

/**
 * @version 2016/10/09 11:57:14
 */
@JavaAPIProvider(SecurityManager.class)
class JSSecurityManager {

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to open a socket
     * connection to the specified host and port number.
     * <p>
     * A port number of <code>-1</code> indicates that the calling method is attempting to determine
     * the IP address of the specified host name.
     * <p>
     * This method calls <code>checkPermission</code> with the
     * <code>SocketPermission(host+":"+port,"connect")</code> permission if the port is not equal to
     * -1. If the port is equal to -1, then it calls <code>checkPermission</code> with the
     * <code>SocketPermission(host,"resolve")</code> permission.
     * <p>
     * If you override this method, then you should make a call to <code>super.checkConnect</code>
     * at the point the overridden method would normally throw an exception.
     *
     * @param host the host name port to connect to.
     * @param port the protocol port to connect to.
     * @exception SecurityException if the calling thread does not have permission to open a socket
     *                connection to the specified <code>host</code> and <code>port</code>.
     * @exception NullPointerException if the <code>host</code> argument is <code>null</code>.
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkConnect(String host, int port) {
        // do nothing
    }

    /**
     * Throws a <code>SecurityException</code> if the specified security context is not allowed to
     * open a socket connection to the specified host and port number.
     * <p>
     * A port number of <code>-1</code> indicates that the calling method is attempting to determine
     * the IP address of the specified host name.
     * <p>
     * If <code>context</code> is not an instance of <code>AccessControlContext</code> then a
     * <code>SecurityException</code> is thrown.
     * <p>
     * Otherwise, the port number is checked. If it is not equal to -1, the <code>context</code>'s
     * <code>checkPermission</code> method is called with a
     * <code>SocketPermission(host+":"+port,"connect")</code> permission. If the port is equal to
     * -1, then the <code>context</code>'s <code>checkPermission</code> method is called with a
     * <code>SocketPermission(host,"resolve")</code> permission.
     * <p>
     * If you override this method, then you should make a call to <code>super.checkConnect</code>
     * at the point the overridden method would normally throw an exception.
     *
     * @param host the host name port to connect to.
     * @param port the protocol port to connect to.
     * @param context a system-dependent security context.
     * @exception SecurityException if the specified security context is not an instance of
     *                <code>AccessControlContext</code> (e.g., is <code>null</code>), or does not
     *                have permission to open a socket connection to the specified <code>host</code>
     *                and <code>port</code>.
     * @exception NullPointerException if the <code>host</code> argument is <code>null</code>.
     * @see java.lang.SecurityManager#getSecurityContext()
     * @see java.security.AccessControlContext#checkPermission(java.security.Permission)
     */
    public void checkConnect(String host, int port, Object context) {
        // do nothing
    }

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to read the file
     * specified by the string argument.
     * <p>
     * This method calls <code>checkPermission</code> with the
     * <code>FilePermission(file,"read")</code> permission.
     * <p>
     * If you override this method, then you should make a call to <code>super.checkRead</code> at
     * the point the overridden method would normally throw an exception.
     *
     * @param file the system-dependent file name.
     * @exception SecurityException if the calling thread does not have permission to access the
     *                specified file.
     * @exception NullPointerException if the <code>file</code> argument is <code>null</code>.
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkRead(String file) {
        // do nothing
    }

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to read from the
     * specified file descriptor.
     * <p>
     * This method calls <code>checkPermission</code> with the
     * <code>RuntimePermission("readFileDescriptor")</code> permission.
     * <p>
     * If you override this method, then you should make a call to <code>super.checkRead</code> at
     * the point the overridden method would normally throw an exception.
     *
     * @param fd the system-dependent file descriptor.
     * @exception SecurityException if the calling thread does not have permission to access the
     *                specified file descriptor.
     * @exception NullPointerException if the file descriptor argument is <code>null</code>.
     * @see java.io.FileDescriptor
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkRead(FileDescriptor fd) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to write to the
     * file specified by the string argument.
     * <p>
     * This method calls <code>checkPermission</code> with the
     * <code>FilePermission(file,"write")</code> permission.
     * <p>
     * If you override this method, then you should make a call to <code>super.checkWrite</code> at
     * the point the overridden method would normally throw an exception.
     *
     * @param file the system-dependent filename.
     * @exception SecurityException if the calling thread does not have permission to access the
     *                specified file.
     * @exception NullPointerException if the <code>file</code> argument is <code>null</code>.
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkWrite(String file) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to write to the
     * specified file descriptor.
     * <p>
     * This method calls <code>checkPermission</code> with the
     * <code>RuntimePermission("writeFileDescriptor")</code> permission.
     * <p>
     * If you override this method, then you should make a call to <code>super.checkWrite</code> at
     * the point the overridden method would normally throw an exception.
     *
     * @param fd the system-dependent file descriptor.
     * @exception SecurityException if the calling thread does not have permission to access the
     *                specified file descriptor.
     * @exception NullPointerException if the file descriptor argument is <code>null</code>.
     * @see java.io.FileDescriptor
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkWrite(FileDescriptor fd) {
        // If this exception will be thrown, it is bug of this program. So we must rethrow the
        // wrapped error in here.
        throw new Error();
    }

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

    /**
     * Throws a <code>SecurityException</code> if the calling thread is not allowed to set the
     * socket factory used by <code>ServerSocket</code> or <code>Socket</code>, or the stream
     * handler factory used by <code>URL</code>.
     * <p>
     * This method calls <code>checkPermission</code> with the
     * <code>RuntimePermission("setFactory")</code> permission.
     * <p>
     * If you override this method, then you should make a call to
     * <code>super.checkSetFactory</code> at the point the overridden method would normally throw an
     * exception.
     * <p>
     *
     * @exception SecurityException if the calling thread does not have permission to specify a
     *                socket factory or a stream handler factory.
     * @see java.net.ServerSocket#setSocketFactory(java.net.SocketImplFactory) setSocketFactory
     * @see java.net.Socket#setSocketImplFactory(java.net.SocketImplFactory) setSocketImplFactory
     * @see java.net.URL#setURLStreamHandlerFactory(java.net.URLStreamHandlerFactory)
     *      setURLStreamHandlerFactory
     * @see #checkPermission(java.security.Permission) checkPermission
     */
    public void checkSetFactory() {
        // do nothing
    }
}
