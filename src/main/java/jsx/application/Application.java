/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.application;

import static js.lang.Global.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import js.dom.DocumentFragment;
import js.dom.EventListener;
import jsx.bwt.EventHub;
import jsx.bwt.UIAction;
import jsx.bwt.UIEvent;
import kiss.I;

/**
 * @version 2012/12/11 14:19:29
 */
public abstract class Application {

    /** The page router. */
    private static final Router router = new Router();

    /**
     * <p>
     * Initialize application.
     * </p>
     */
    protected Application() {
        // Collect all pages and register it.
        for (Class page : I.collect(Page.class)) {
            for (Constructor<?> constructor : page.getConstructors()) {
                PageInfo info = constructor.getAnnotation(PageInfo.class);

                if (info != null) {
                    if (info.path().contains("*")) {
                        router.wildcards.add(new Route(constructor, info));
                    } else {
                        router.route.put(info.path(), constructor);
                    }
                }
            }
        }

        // Activate router system.
        window.on(UIAction.HashChange, router);

        // View initial page by URL.
        router.dispatch(location.hash);
    }

    /**
     * <p>
     * Entry point for this application.
     * </p>
     */
    public abstract void jsmain();

    /**
     * <p>
     * Configure header part.
     * </p>
     * 
     * @param header
     */
    protected void configure(Header header) {
    }

    /**
     * <p>
     * Show page with effect.
     * </p>
     * 
     * @param page
     */
    public static void show(Page page) {
        if (page != null) {
            router.dispatch(page.getPageId());
            history.pushState("", "", "#" + page.getPageId());
        }
    }

    /**
     * @version 2013/06/17 13:57:06
     */
    private static class Router implements EventListener {

        /** The current page. */
        private static Page current;

        /** The page router. */
        private final Map<String, Constructor> route = new HashMap();

        /** The page router. */
        private final List<Route> wildcards = new ArrayList();

        /**
         * <p>
         * URI dispatcher.
         * </p>
         */
        @Override
        public void handleEvent(UIEvent event) {
            dispatch(location.hash);
        }

        /**
         * <p>
         * Dispatch page by identifier
         * </p>
         * 
         * @param pageId
         */
        private void dispatch(String pageId) {
            if (pageId.length() != 0 && pageId.startsWith("#")) {
                pageId = pageId.substring(1);
            }

            Constructor constructor = route.get(pageId);

            if (constructor != null) {
                try {
                    dispatch((Page) constructor.newInstance());
                } catch (Exception e) {
                    // do nothing
                }
            } else {
                for (Route route : wildcards) {
                    Page page = route.match(pageId);

                    if (page != null) {
                        dispatch(page);
                        return;
                    }
                }
            }
        }

        /**
         * <p>
         * Dispatch page.
         * </p>
         * 
         * @param pageId
         */
        private void dispatch(Page page) {
            // fire page unload event
            if (page != null) {
                EventHub.Global.publish(new PageUnload(page));
            }

            // fire page load event
            // window.trigger(UIAction.PageLoad);

            // create element cradle
            DocumentFragment cradle = document.createDocumentFragment();

            // build page element
            page.load(cradle);

            // clear old page and append new page
            document.getElementById("Content").empty().append(cradle);

            // record page
            current = page;
        }
    }

    /**
     * @version 2013/01/18 10:43:43
     */
    private static class Route {

        /** The page pattern. */
        private final Pattern pattern;

        /** The page constructor. */
        private Constructor constructor;

        /**
         * <p>
         * Create new route.
         * </p>
         * 
         * @param constructor
         * @param info
         */
        private Route(Constructor constructor, PageInfo info) {
            this.constructor = constructor;
            this.pattern = Pattern.compile(info.path().replaceAll("\\*", "([^/].+)"));
        }

        /**
         * <p>
         * Detect pattern matching.
         * </p>
         * 
         * @param path
         * @return
         */
        private Page match(String path) {
            Matcher matcher = pattern.matcher(path);

            if (!matcher.matches()) {
                return null;
            } else {
                List<String> wildcards = new ArrayList();

                for (int i = 0; i < matcher.groupCount(); i++) {
                    wildcards.add(matcher.group(i + 1));
                }

                try {
                    return (Page) constructor.newInstance(wildcards.toArray());
                } catch (Exception e) {
                    return null;
                }
            }
        }
    }
}
