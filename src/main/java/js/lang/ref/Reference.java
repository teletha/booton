/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.ref;

import java.lang.ref.ReferenceQueue;

import booton.translator.JavaAPIProvider;

/**
 * @version 2014/02/26 14:23:09
 */
@JavaAPIProvider(java.lang.ref.Reference.class)
class Reference<T> {

    private T referent;

    /**
     * <p>
     * Hide constructor.
     * </p>
     * 
     * @param referent
     */
    Reference(T referent) {
        this(referent, null);
    }

    /**
     * <p>
     * Hide constructor.
     * </p>
     * 
     * @param referent
     * @param queue
     */
    Reference(T referent, ReferenceQueue<? super T> queue) {
        this.referent = referent;
    }

    /**
     * Returns this reference object's referent. If this reference object has been cleared, either
     * by the program or by the garbage collector, then this method returns <code>null</code>.
     *
     * @return The object to which this reference refers, or <code>null</code> if this reference
     *         object has been cleared
     */
    public T get() {
        return referent;
    }

    /**
     * Ensures that the object referenced by the given reference remains
     * <a href="package-summary.html#reachability"><em>strongly reachable</em></a>, regardless of
     * any prior actions of the program that might otherwise cause the object to become unreachable;
     * thus, the referenced object is not reclaimable by garbage collection at least until after the
     * invocation of this method. Invocation of this method does not itself initiate garbage
     * collection or finalization.
     * <p>
     * This method establishes an ordering for
     * <a href="package-summary.html#reachability"><em>strong reachability</em></a> with respect to
     * garbage collection. It controls relations that are otherwise only implicit in a program --
     * the reachability conditions triggering garbage collection. This method is designed for use in
     * uncommon situations of premature finalization where using {@code synchronized} blocks or
     * methods, or using other synchronization facilities are not possible or do not provide the
     * desired control. This method is applicable only when reclamation may have visible effects,
     * which is possible for objects with finalizers (See Section {@jls 12.6} of <cite>The Java
     * Language Specification</cite>) that are implemented in ways that rely on ordering control for
     * correctness.
     *
     * @apiNote Finalization may occur whenever the virtual machine detects that no reference to an
     *          object will ever be stored in the heap: The garbage collector may reclaim an object
     *          even if the fields of that object are still in use, so long as the object has
     *          otherwise become unreachable. This may have surprising and undesirable effects in
     *          cases such as the following example in which the bookkeeping associated with a class
     *          is managed through array indices. Here, method {@code action} uses a
     *          {@code reachabilityFence} to ensure that the {@code Resource} object is not
     *          reclaimed before bookkeeping on an associated {@code ExternalResource} has been
     *          performed; in particular here, to ensure that the array slot holding the
     *          {@code ExternalResource} is not nulled out in method {@link Object#finalize}, which
     *          may otherwise run concurrently. <pre> {@code
     * class Resource {
     *   private static ExternalResource[] externalResourceArray = ...
     *
     *   int myIndex;
     *   Resource(...) {
     *     myIndex = ...
     *     externalResourceArray[myIndex] = ...;
     *     ...
     *   }
     *   protected void finalize() {
     *     externalResourceArray[myIndex] = null;
     *     ...
     *   }
     *   public void action() {
     *     try {
     *       // ...
     *       int i = myIndex;
     *       Resource.update(externalResourceArray[i]);
     *     } finally {
     *       Reference.reachabilityFence(this);
     *     }
     *   }
     *   private static void update(ExternalResource ext) {
     *     ext.status = ...;
     *   }
     * }}</pre> Here, the invocation of {@code reachabilityFence} is nonintuitively placed
     *          <em>after</em> the call to {@code update}, to ensure that the array slot is not
     *          nulled out by {@link Object#finalize} before the update, even if the call to
     *          {@code action} was the last use of this object. This might be the case if, for
     *          example a usage in a user program had the form {@code new Resource().action();}
     *          which retains no other reference to this {@code Resource}. While probably overkill
     *          here, {@code reachabilityFence} is placed in a {@code finally} block to ensure that
     *          it is invoked across all paths in the method. In a method with more complex control
     *          paths, you might need further precautions to ensure that {@code reachabilityFence}
     *          is encountered along all of them.
     *          <p>
     *          It is sometimes possible to better encapsulate use of {@code reachabilityFence}.
     *          Continuing the above example, if it were acceptable for the call to method
     *          {@code update} to proceed even if the finalizer had already executed (nulling out
     *          slot), then you could localize use of {@code reachabilityFence}: <pre> {@code
     * public void action2() {
     *   // ...
     *   Resource.update(getExternalResource());
     * }
     * private ExternalResource getExternalResource() {
     *   ExternalResource ext = externalResourceArray[myIndex];
     *   Reference.reachabilityFence(this);
     *   return ext;
     * }}</pre>
     *          <p>
     *          Method {@code reachabilityFence} is not required in constructions that themselves
     *          ensure reachability. For example, because objects that are locked cannot, in
     *          general, be reclaimed, it would suffice if all accesses of the object, in all
     *          methods of class {@code Resource} (including {@code finalize}) were enclosed in
     *          {@code synchronized (this)} blocks. (Further, such blocks must not include infinite
     *          loops, or themselves be unreachable, which fall into the corner case exceptions to
     *          the "in general" disclaimer.) However, method {@code reachabilityFence} remains a
     *          better option in cases where this approach is not as efficient, desirable, or
     *          possible; for example because it would encounter deadlock.
     * @param ref the reference. If {@code null}, this method has no effect.
     * @since 9
     * @jls 12.6 Finalization of Class Instances
     */
    public static void reachabilityFence(Object ref) {
        // Does nothing. This method is annotated with @ForceInline to eliminate
        // most of the overhead that using @DontInline would cause with the
        // HotSpot JVM, when this fence is used in a wide variety of situations.
        // HotSpot JVM retains the ref and does not GC it before a call to
        // this method, because the JIT-compilers do not have GC-only safepoints.
    }
}
