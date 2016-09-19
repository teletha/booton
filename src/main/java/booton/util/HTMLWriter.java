/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.util;

import java.io.IOException;
import java.util.Arrays;

import kiss.I;

/**
 * @version 2012/12/17 13:20:26
 */
public class HTMLWriter extends XMLWriter {

    /** The empty tags. */
    private static final String[] empties = {"area", "base", "br", "col", "command", "embed", "hr", "img", "input",
            "keygen", "link", "meta", "param", "source", "track", "wbr"};

    /**
     * @param out
     */
    public HTMLWriter(Appendable out) {
        super(out);
    }

    @Override
    public void startDocument() {
        try {
            // write xml declaration
            out.append("<!DOCTYPE html>").append(EOL);
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean asPair(String uri, String local) {
        return Arrays.binarySearch(empties, local) < 0;
    }
}
