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

import booton.translator.Translator;

/**
 * @version 2015/08/05 10:36:08
 */
public class NativePerformance extends NativeObject {

    /**
     * <p>
     * The now method MUST return a DOMHighResTimeStamp representing the number of milliseconds from
     * the navigationStart attribute of the PerformanceTiming interface [NavigationTiming], the
     * start of navigation of the document, to the occurrence of the call to the now method.
     * </p>
     * 
     * @return
     */
    public double now() {
        return System.nanoTime() / 1000;
    }

    /**
     * @version 2015/08/05 10:39:09
     */
    @SuppressWarnings("unused")
    private static class Coder extends Translator<NativePerformance> {

        /**
         * <p>
         * The now method MUST return a DOMHighResTimeStamp representing the number of milliseconds
         * from the navigationStart attribute of the PerformanceTiming interface [NavigationTiming],
         * the start of navigation of the document, to the occurrence of the call to the now method.
         * </p>
         * 
         * @return
         */
        public String now() {
            return that + ".now()";
        }
    }
}
