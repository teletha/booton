/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.live;

import static booton.translator.web.WebSupport.*;

import java.util.Date;

import booton.translator.web.WebSocket;

/**
 * @version 2013/01/08 13:33:11
 */
public class LiveCoding {

    /**
     * 
     */
    public static void jsmain() {
        connect("ws://localhost:10021/live" + window.location.pathname, new WebSocket() {

            /**
             * {@inheritDoc}
             */
            @Override
            protected void message(MessageEvent event) {
                String src = event.data;

                if (src.endsWith("css")) {
                    $("link[href^='" + src + "']").attr("href", src + "?" + new Date().getTime());
                } else {
                    window.location.reload(false);
                }
            }
        });
    }
}
