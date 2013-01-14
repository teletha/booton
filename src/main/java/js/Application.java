/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js;

import static booton.translator.web.WebSupport.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import js.application.Header;
import js.lang.Classes;
import js.util.ArrayList;
import booton.translator.web.jQuery;
import booton.translator.web.jQuery.Event;
import booton.translator.web.jQuery.Listener;

/**
 * @version 2012/12/11 14:19:29
 */
public abstract class Application {

    /** The page router. */
    private static final Router router = new Router();

    /**
     * <p>
     * Entry point for this application.
     * </p>
     */
    public void jsmain() {
        $(window).on("hashchange", router);
        router.dispatch(location.hash);
    }

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
     * Register page with uri pattern.
     * </p>
     * 
     * @param pattern
     * @param page
     */
    protected final void register(String pattern, Class<? extends Page> page) {
        router.routes.add(new Route(pattern, page));
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
     * @version 2013/01/10 12:15:45
     */
    private static class Router implements Listener {

        /** The page router. */
        private final List<Route> routes = new ArrayList();

        /** The current page. */
        private Page current;

        /**
         * <p>
         * URI dispatcher.
         * </p>
         * {@inheritDoc}
         */
        @Override
        public void handler(Event event) {
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

            for (Route route : routes) {
                Page page = route.match(pageId);

                if (page != null) {
                    // create element cradle
                    jQuery cradle = $(document.createDocumentFragment());

                    // build page element
                    page.load(cradle);

                    // clear old page and append new page
                    $("#Content").empty().append(cradle);

                    return;
                }
            }
        }

        @Deprecated
        private void dispatch(Page page) {
            // create element cradle
            jQuery cradle = $(document.createDocumentFragment());

            // build page element
            current = page;
            current.load(cradle);

            // clear old page and append new page
            $("#Content").empty().append(cradle);

        }
    }

    /**
     * @version 2013/01/09 23:30:29
     */
    private static class Route {

        /** The page pattern. */
        private final Pattern pattern;

        /** The page class. */
        private final Class<? extends Page> page;

        /**
         * @param pattern
         * @param page
         */
        private Route(String pattern, Class<? extends Page> page) {
            this.pattern = Pattern.compile(pattern.replaceAll("\\*", "([^/].+)"));
            this.page = page;
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
                    return Classes.newInstance(page, wildcards.toArray());
                } catch (Exception e) {
                    System.out.println(e);
                    return null;
                }
            }
        }
    }
}
