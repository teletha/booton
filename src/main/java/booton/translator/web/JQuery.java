/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.web;

import org.w3c.dom.Element;

import booton.translator.Translatable;

/**
 * @version 2012/12/02 12:49:38
 */
@Translatable
public interface JQuery {

    /**
     * <p>
     * Add elements to the set of matched elements.
     * </p>
     * 
     * @param selector A string representing a selector expression to find additional elements to
     *            add to the set of matched elements.
     * @return
     */
    public JQuery add(String selector);

    /**
     * <p>
     * Add elements to the set of matched elements.
     * </p>
     * 
     * @param selector An existing jQuery object to add to the set of matched elements.
     * @return
     */
    public JQuery add(JQuery other);

    /**
     * <p>
     * Adds the specified class(es) to each of the set of matched elements.
     * </p>
     * 
     * @param classNames One or more class names to be added to the class attribute of each matched
     *            element.
     * @return
     */
    public JQuery addClass(String classNames);

    /**
     * <p>
     * Insert content, specified by the parameter, after each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents HTML string, DOM element, or jQuery object to insert after each element in
     *            the set of matched elements.
     * @return
     */
    public JQuery after(String contents);

    /**
     * <p>
     * Insert content, specified by the parameter, after each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents HTML string, DOM element, or jQuery object to insert after each element in
     *            the set of matched elements.
     * @return
     */
    public JQuery after(Element contents);

    /**
     * <p>
     * Insert content, specified by the parameter, after each element in the set of matched
     * elements.
     * </p>
     * 
     * @param contents HTML string, DOM element, or jQuery object to insert after each element in
     *            the set of matched elements.
     * @return
     */
    public JQuery after(JQuery contents);

    /**
     * <p>
     * Get the combined text contents of each element in the set of matched elements, including
     * their descendants.
     * </p>
     * 
     * @return
     */
    public String text();

    /**
     * <p>
     * Set the content of each element in the set of matched elements to the specified text.
     * </p>
     * 
     * @param text
     * @return
     */
    public JQuery text(String text);
}
