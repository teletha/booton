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

import java.io.Flushable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;

import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.XMLFilterImpl;

import com.sun.org.apache.xml.internal.serializer.TreeWalker;

import kiss.I;
import kiss.XML;

/**
 * @version 2012/12/17 1:49:14
 */
public class XMLWriter extends XMLFilterImpl implements LexicalHandler {

    /** The line separator character */
    protected static final String EOL = System.getProperty("line.separator");

    /** The event state for other. */
    private static final int OTHER = 0;

    /** The event state for start element. */
    private static final int START = 1;

    /** The event state for end element. */
    private static final int END = 2;

    /** The event state for character. */
    private static final int CHARACTER = 3;

    /** The output stream. */
    protected final Appendable out;

    /** The previous sax event state. */
    private int state = CHARACTER;

    /** The number of node depth. */
    private int depth = 0;

    /** The marker of last block element's depth. */
    private int last = 0;

    /** The amount of breaks in a current text node. */
    private int breaks = 0;

    /** The counter of namespace declarations in the current element. */
    private int count = 0;

    /** The namespace list. */
    private final ArrayList<String> namespaces = new ArrayList();

    /**
     * Create XMLFormatter instance.
     */
    public XMLWriter(Appendable out) {
        this.out = out;
    }

    /**
     * <p>
     * You can override this method to omit xml declaration.
     * </p>
     * {@inheritDoc}
     */
    @Override
    public void startDocument() {
        try {
            // write xml declaration
            out.append("<?xml version=\"1.0\" encoding=\"").append(StandardCharsets.UTF_8.name()).append("\"?>").append(EOL);
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endDocument() {
        if (out instanceof Flushable) {
            try {
                ((Flushable) out).flush();
            } catch (IOException e) {
                throw I.quiet(e);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startPrefixMapping(String prefix, String uri) {
        count++;
        namespaces.add(prefix); // add prefix
        namespaces.add(uri); // add uri
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endPrefixMapping(String prefix) {
        namespaces.remove(namespaces.size() - 1); // remove uri
        namespaces.remove(namespaces.size() - 1); // remove prefix
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startElement(String uri, String local, String name, Attributes atts) {
        try {
            int prev = checkEvent(START);

            if (prev == CHARACTER) {
                if (breaks != 0) writeIndent();
            } else {
                if (!asCharacter(uri, local)) {
                    out.append(EOL);
                    writeIndent();

                    // mark position
                    last = depth;
                }
            }

            // start output
            out.append('<').append(name);

            for (int i = 0; i < atts.getLength(); i++) {
                // exclude xmlns declarations
                if (!XMLConstants.XMLNS_ATTRIBUTE_NS_URI.equals(atts.getURI(i))) {
                    // decide attribute name
                    name = atts.getQName(i); // attribute name reuses name variable for footprint

                    if (name.length() == 0) name = atts.getLocalName(i);
                    // write attribute
                    out.append(' ').append(name).append('=').append('"');
                    name = atts.getValue(i); // attribute value reuses name variable for footprint
                    if (name != null) write(name.toCharArray(), 0, name.length());
                    out.append('"');
                }
            }

            // write namespace declaration
            if (count != 0) {
                root: for (int i = namespaces.size() - count * 2; i < namespaces.size(); i += 2) {
                    name = namespaces.get(i); // prefix reuses name variable for footprint
                    uri = namespaces.get(i + 1); // uri reuses uri variable for footprint

                    // check duplication namespace declaration
                    for (int j = 0; j < i; j += 2) {
                        if (name == namespaces.get(j) && uri == namespaces.get(j + 1)) continue root;
                    }

                    // start writing namespace declaration
                    out.append(" xmlns");

                    if (name.length() != 0) {
                        out.append(':').append(name);
                    }
                    out.append('=').append('"').append(uri).append('"');
                }

                // reset namespace declaration count
                count = 0;
            }
        } catch (IOException e) {
            throw I.quiet(e);
        }
        depth++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endElement(String uri, String local, String name) {
        depth--;

        try {
            int prev = checkEvent(END, uri, local);

            // if the previous sax event is start element, pass through.
            if (prev == START) return;

            // decide to write a break
            if (last == depth + 1 && !asCharacter(uri, local)) {
                out.append(EOL);
                writeIndent();
                // remark position
                last = depth;
            }

            // start output
            out.append('<').append('/').append(name).append('>');
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void characters(char[] ch, int start, int length) {
        try {
            int prev = checkEvent(CHARACTER);

            if (isIgnorableNode(ch, start, length)) {
                if (breaks == 0) write(ch, start, length);

                // change state
                this.state = (prev == START) ? OTHER : prev;
            } else if (asBlock(ch, start, length)) {
                for (String line : new String(ch, start, length).split("\r|\n|\r\n")) {
                    out.append(EOL);
                    writeIndent();
                    out.append(line);
                }

                // change state
                this.state = OTHER;
            } else {
                write(ch, start, length);
            }
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void processingInstruction(String target, String data) {
        try {
            checkEvent(OTHER);
            out.append(EOL);

            // start output
            out.append("<?").append(target);

            if (data != null) {
                out.append(' ').append(data);
            }
            out.append("?>");
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startDTD(String name, String publicId, String systemId) {
        try {
            checkEvent(OTHER);
            out.append(EOL);
            writeIndent();
            out.append("<!DOCTYPE ").append(name);

            // write publicId
            if (publicId == null) {
                out.append(" SYSTEM");
            } else {
                out.append(" PUBLIC \"").append(publicId).append('"');
            }

            // write systemId
            if (systemId != null) {
                out.append(" \"").append(systemId).append('"');
            }
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endDTD() {
        try {
            checkEvent(OTHER);
            out.append('>');
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startEntity(String name) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endEntity(String name) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startCDATA() {
        try {
            checkEvent(CHARACTER);
            out.append("<![CDATA[");
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endCDATA() {
        try {
            checkEvent(CHARACTER);
            out.append("]]>");
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void comment(char[] ch, int start, int length) {
        try {
            int prev = checkEvent(OTHER);

            if (prev != CHARACTER || breaks != 0) {
                out.append(EOL);
                writeIndent();
            }

            // write comment
            out.append("<!--");

            for (int i = start; i < length; i++) {
                out.append(ch[i]);

                if (ch[i] == '\r' || ch[i] == '\n') {
                    writeIndent();
                }
            }
            out.append("-->");
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * Check whether the text is treated as a block or not. You can override this method to
     * manipulate a format of serialization.
     * 
     * @param ch A charactor sequence to parse.
     * @param start A start position of parsing.
     * @param length A length.
     * @return Is this text node treated as a block?
     */
    protected boolean asBlock(char[] ch, int start, int length) {
        return false;
    }

    /**
     * Check whether the element is treated as a character or not. You can override this method to
     * manipulate a format of serialization.
     * 
     * @param uri A namespace uri.
     * @param local A locale name.
     * @return Is this element treated as a character?
     */
    protected boolean asCharacter(String uri, String local) {
        return false;
    }

    /**
     * Check whether the element is not abbreviated or not. You can override this method to
     * manipulate a format of serialization.
     * 
     * @param uri A namespace uri.
     * @param local A local name.
     * @return Whether the element is not abbreviated or not.
     */
    protected boolean asPair(String uri, String local) {
        return false;
    }

    /**
     * Check whether the node is a ignorable whitespaceFilter or not, and breaks a number of line
     * feeds.
     * 
     * @param ch A charactor sequence to parse.
     * @param start A start position of parsing.
     * @param length A length.
     * @return Whether this characters is a ignorable whitespaceFilter or not.
     */
    protected boolean isIgnorableNode(char[] ch, int start, int length) {
        // reset
        breaks = 0;

        for (int i = 0; i < length; i++) {
            char c = ch[start + i];

            if (c == '\n') {
                breaks++;
                continue;
            }
            if (c == '\r' || !Character.isWhitespace(c)) return false;
        }
        return true;
    }

    /**
     * Helper method to write an appropriate indentCharcter for current node.
     * 
     * @throws IOException Output error.
     */
    protected void writeIndent() throws IOException {
        for (int i = 0; i < depth * 2; i++) {
            out.append(' ');
        }
    }

    /**
     * DOCUMENT.
     * 
     * @param callState A state where this method is called.
     * @return A previous state.
     * @throws IOException Output error.
     */
    protected int checkEvent(int callState) throws IOException {
        return checkEvent(callState, null, null);
    }

    /**
     * DOCUMENT.
     * 
     * @param callState A state where this method is called.
     * @param uri A namespace uri.
     * @param local A local name.
     * @return A previous state.
     * @throws IOException Output error.
     */
    protected int checkEvent(int callState, String uri, String local) throws IOException {
        // check whether a previous node is a start element or not
        if (state != START) {
            int prev = state;
            state = callState;

            return prev;
        }

        // write a end charactor of a start element.
        if (callState == END) {
            // check the element is pair
            if (asPair(uri, local)) {
                out.append('>');
                state = callState;
                return CHARACTER;
            }
            out.append('/').append('>');
        } else {
            out.append('>');
        }
        int prev = state;
        state = callState;
        return prev;
    }

    /**
     * <p>
     * Encode predefined entities and write a specific part of an array of characters.
     * </p>
     * 
     * @param data A data to parse and write.
     * @param start A start position.
     * @param length A length.
     * @throws IOException Output error.
     */
    protected void write(char[] data, int start, int length) throws IOException {
        for (int i = start; i < start + length; i++) {
            switch (data[i]) {
            case '&':
                out.append("&amp;");
                break;

            case '<':
                out.append("&lt;");
                break;

            case '>':
                out.append("&gt;");
                break;

            case '"':
                out.append("&quot;");
                break;

            case '\'':
                out.append("&apos;");
                break;

            default:
                out.append(data[i]);
            }
        }
    }

    public void write(XML xml) {
        try {
            startDocument();
            TreeWalker walker = new TreeWalker(this);

            Field nodes = XML.class.getDeclaredField("nodes");
            nodes.setAccessible(true);

            for (Node node : (List<Node>) nodes.get(xml)) {
                walker.traverse(node);
            }
            endDocument();
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }
}
