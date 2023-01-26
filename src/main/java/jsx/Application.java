/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx;

import static java.util.Objects.*;
import static js.lang.Global.*;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

import js.dom.DocumentFragment;
import jsx.ui.User;
import jsx.ui.Widget;
import kiss.Decoder;
import kiss.Encoder;
import kiss.I;
import kiss.Managed;
import kiss.Singleton;
import kiss.Variable;
import kiss.model.Model;

/**
 * @version 2016/11/09 11:43:55
 */
@Managed(Singleton.class)
public abstract class Application<Router extends ApplicationRouter> {

    /** The cache for widget. */
    private static final Map<Integer, Widget> cache = new HashMap();

    /** The application router. */
    public final Router router;

    /** The route info. */
    private final Map<Integer, Route> routes = new HashMap();

    /** The error route. */
    private final Route error = params -> errorWidget().get();

    /**
     * Initialize application.
     */
    protected Application() {
        Type[] types = Model.collectParameters(getClass(), Application.class);

        if (types.length != 1) {
            throw new IllegalArgumentException("Application must have single router interface parameter.");
        }

        Class routerInterface = (Class) types[0];

        if (routerInterface.isInterface() == false) {
            throw new IllegalArgumentException("Application must have single router interface parameter");
        }

        // collect route methods
        root: for (Method method : routerInterface.getMethods()) {
            // router method must return Widget type and default
            if (method.isDefault() && Widget.class.isAssignableFrom(method.getReturnType())) {
                // all parameters must be decodable.
                Class[] parameTypes = method.getParameterTypes();
                Decoder[] decoders = new Decoder[parameTypes.length];

                for (int i = 0; i < decoders.length; i++) {
                    Decoder decoder = I.find(Decoder.class, parameTypes[i]);

                    if (decoder == null) {
                        continue root;
                    }
                    decoders[i] = decoder;
                }
                routes.put(hash(method.getName(), method.getParameterCount()), new MethodRoute(method, decoders));
            }
        }

        // create router proxy for API access
        router = (Router) Proxy.newProxyInstance(null, new Class[] {routerInterface}, this::router);

        // activate router system.
        window.addEventListener(User.HashChange, this::dispatch);
    }

    /**
     * <p>
     * Retrieve the default widget.
     * </p>
     */
    protected abstract Supplier<Widget> defaultWidget();

    /**
     * <p>
     * Retrieve the general error widget.
     * </p>
     * 
     * @return
     */
    protected Supplier<Widget> errorWidget() {
        return defaultWidget();
    }

    /**
     * <p>
     * Dispatch widget by the specified path.
     * </p>
     */
    final void dispatch() {
        String path = location.hash;

        if (path.length() != 0) {
            path = path.substring(1);
        }
        String[] parts = path.split("/");
        int key = hash(parts[0], parts.length - 1);

        routes.getOrDefault(key, error).dispatch(parts);
    }

    private final Widget invoke(Class clazz, Object router, Method method, Object[] params) {
        try {
            return (Widget) MethodHandles.lookup().in(clazz).unreflectSpecial(method, clazz).bindTo(router).invokeWithArguments(params);
        } catch (Throwable e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Convert from URI to Widget.
     * </p>
     * 
     * @param router An actual router.
     * @param method A invoked route method.
     * @param params A list of invocation context parameters.
     * @return The requested widget.
     */
    private final Widget router(Object router, Method method, Object[] params) throws Throwable {
        Class<?> clazz = method.getDeclaringClass();

        if (clazz == ApplicationRouter.class) {
            return invoke(clazz, router, method, params);
        }

        // rebuild path
        StringBuilder builder = new StringBuilder("#").append(method.getName());

        for (Object param : params) {
            builder.append("/").append(I.find(Encoder.class, param.getClass()).encode(param));
        }
        String path = builder.toString();

        // update history if needed
        if (!location.hash.equals(path)) {
            history.pushState("", "", path);
        }

        // create widget by path
        Widget widget = invoke(clazz, router, method, params);

        // rendering widget element
        Widget w = Variable.of(widget).or(defaultWidget());

        // create element cradle
        DocumentFragment cradle = document.createDocumentFragment();

        w.renderIn(cradle.child("div"));

        // clear old page and append new page
        document.contentElement().empty().append(cradle);

        return widget;
    }

    /**
     * <p>
     * Initialize application.
     * </p>
     * 
     * @param applicationClass An application class to start.
     * @param configurator You can configure your application.
     */
    public static <A extends Application> void initialize(Class<A> applicationClass) {
        A application = I.make(applicationClass);

        // View initial page by URL.
        application.dispatch();
    }

    /**
     * <p>
     * Caching widget by the specified keys.
     * </p>
     * 
     * @param builder A widget builder.
     * @param keys A list of keys.
     * @return
     */
    static Widget cache(Supplier<Widget> builder, Object... keys) {
        return cache.computeIfAbsent(Objects.hash(keys), hash -> builder.get());
    }

    /**
     * @version 2016/11/08 15:48:39
     */
    private interface Route {

        /**
         * <p>
         * Dispatch by the specified path pattern.
         * </p>
         */
        Widget dispatch(String[] path);
    }

    /**
     * @version 2016/11/08 15:48:51
     */
    private class MethodRoute implements Route {

        /** The dispatch method. */
        private final Method method;

        /** The parameter pattern. */
        private final Decoder[] decoders;

        /**
         * <p>
         * Build route metadata.
         * </p>
         * 
         * @param method A route method.
         * @param decoders A list of route parameters.
         */
        private MethodRoute(Method method, Decoder[] decoders) {
            this.decoders = decoders;
            this.method = method;
        }

        /**
         * <p>
         * Dispatch by the specified path pattern.
         * </p>
         */
        @Override
        public Widget dispatch(String[] path) {
            try {
                Object[] parameters = new Object[decoders.length];

                for (int i = 0; i < decoders.length; i++) {
                    parameters[i] = decoders[i].decode(path[i + 1]);
                }

                return (Widget) method.invoke(router, parameters);
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
    }
}
