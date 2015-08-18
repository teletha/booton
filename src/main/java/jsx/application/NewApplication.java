/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import static js.lang.Global.*;

import java.lang.reflect.Method;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import js.dom.DocumentFragment;
import js.dom.UIAction;
import js.lang.NativeArray;
import jsx.ui.Widget;
import kiss.Codec;
import kiss.I;
import kiss.Interceptor;
import kiss.Manageable;
import kiss.Singleton;

/**
 * @version 2015/08/18 10:27:23
 */
@Manageable(lifestyle = Singleton.class)
public abstract class NewApplication {

    /** The application configuration. */
    final Config config = new Config();

    /** The path router. */
    private final NativeArray<PageRoute> router = new NativeArray();

    /**
     * Initialize application.
     */
    protected NewApplication() {
        root: for (Method method : getClass().getMethods()) {
            if (method.isAnnotationPresent(Route.class)) {
                // Return type must be Widget
                if (!Widget.class.isAssignableFrom(method.getReturnType())) {
                    continue;
                }

                StringBuilder pattern = new StringBuilder(method.getName());

                // All parameters must be decodable.
                Class[] parameTypes = method.getParameterTypes();
                Codec[] codecs = new Codec[parameTypes.length];

                for (int i = 0; i < codecs.length; i++) {
                    Codec codec = I.find(Codec.class, parameTypes[i]);

                    if (codec == null) {
                        continue root;
                    }
                    codecs[i] = codec;
                    pattern.append("/").append("([^/].+)");
                }

                router.push(new PageRoute(pattern.toString(), codecs, method));
            }
        }

        // Activate router system.
        window.observe(UIAction.HashChange).to(event -> {
            dispatch(location.hash);
        });
    }

    /**
     * <p>
     * Dispatch page by the specified path.
     * </p>
     * 
     * @param path
     */
    void dispatch(String path) {
        if (path.length() != 0 && path.startsWith("#")) {
            path = path.substring(1);
        }

        if (path.length() == 0) {
            show(null);
            return;
        }

        System.out.println("Change " + path);

        for (int i = 0; i < router.length(); i++) {
            Widget widget = router.get(i).dispatch(path);

            if (widget != null) {
                return;
            }
        }

        show(null);
    }

    /**
     * <p>
     * Show the specified {@link Widget}.
     * </p>
     * 
     * @param widget
     */
    private void show(Widget widget) {
        if (widget == null && config.defaultPage != null) {
            widget = config.defaultPage.get();
        }

        if (widget == null) {
            throw new IllegalAccessError("The default page is not found. Use Config#defaultPage method.");
        }

        // create element cradle
        DocumentFragment cradle = document.createDocumentFragment();

        // build page element
        widget.renderIn(cradle.child("div"));

        // clear old page and append new page
        document.getElementById("Content").empty().append(cradle);
    }

    /**
     * <p>
     * Initialize application.
     * </p>
     * 
     * @param applicationClass An application class to start.
     * @param configurator You can configure your application.
     */
    protected static <A extends NewApplication> void initialize(Class<A> applicationClass, BiConsumer<Config, A> configurator) {
        A application = I.make(applicationClass);

        // Configure application
        configurator.accept(application.config, application);

        // View initial page by URL.
        application.dispatch(location.hash);
    }

    /**
     * @version 2015/08/18 14:47:12
     */
    private class PageRoute {

        /** The path pattern. */
        private final Pattern pattern;

        /** The parameter pattern. */
        private final Codec[] codecs;

        /** The dispatch method. */
        private final Method method;

        /**
         * @param pattern
         * @param codecs
         * @param method
         */
        private PageRoute(String pattern, Codec[] codecs, Method method) {
            this.pattern = Pattern.compile(pattern);
            this.codecs = codecs;
            this.method = method;
        }

        /**
         * <p>
         * Dispatch by the specified path pattern.
         * </p>
         */
        private Widget dispatch(String path) {
            Matcher matcher = pattern.matcher(path);

            if (!matcher.matches() || matcher.groupCount() != codecs.length) {
                return null;
            }

            Object[] parameters = new Object[codecs.length];

            for (int i = 0; i < codecs.length; i++) {
                parameters[i] = codecs[i].decode(matcher.group(i + 1));
            }

            try {
                return (Widget) method.invoke(NewApplication.this, parameters);
            } catch (Exception e) {
                throw I.quiet(e);
            }
        }
    }

    /**
     * @version 2015/08/18 15:38:18
     */
    protected static class Config {

        /** The defualt page dispatcher. */
        private Supplier<Widget> defaultPage;

        /**
         * <p>
         * Set default page.
         * </p>
         * 
         * @param dispatcher
         */
        public void defaultPage(Supplier<Widget> dispatcher) {
            if (dispatcher != null) {
                this.defaultPage = dispatcher;
            }
        }
    }

    /**
     * @version 2015/08/18 16:48:41
     */
    @Manageable(lifestyle = Singleton.class)
    static class Router extends Interceptor<Route> {

        /**
         * {@inheritDoc}
         */
        @Override
        protected Object invoke(Object... params) {
            Object widget = super.invoke(params);

            if (that instanceof NewApplication && widget instanceof Widget) {
                // rebuild path
                StringBuilder builder = new StringBuilder("#").append(name);

                for (Object param : params) {
                    builder.append("/").append(I.find(Codec.class, param.getClass()).encode(param));
                }

                // update history if needed
                String path = builder.toString();

                if (!location.hash.equals(path)) {
                    history.pushState("", "", path);
                }

                // render widget
                ((NewApplication) that).show((Widget) widget);
            }
            return widget;
        }
    }
}
