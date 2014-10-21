/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.style;

/**
 * @version 2014/10/21 16:48:37
 */
public class RuleSetDeclaration extends StyleDeclaration {

    /**
     * <p>
     * The :hover CSS pseudo-class matches when the user designates an element with a pointing
     * device, but does not necessarily activate it. This style may be overridden by any other
     * link-related pseudo-classes, that is :link, :visited, and :active, appearing in subsequent
     * rules. In order to style appropriately links, you need to put the :hover rule after the :link
     * and :visited rules but before the :active one, as defined by the LVHA-order: :link — :visited
     * — :hover — :active.
     * </p>
     */
    protected final void hover(Runnable sub) {
        sub("$:hover", sub);
    }

    /**
     * <p>
     * Create sub rule set.
     * </p>
     * 
     * @param selector
     * @return
     */
    private final void sub(String selector, Runnable sub) {
        // store current rule set
        StyleDeclarable declarable = PropertyDefinition.declarable;

        // create new rule set for sub rule
        StyleDeclarable rules =

        // create sub rule set

        sub.run();

        // restore parent rule set
        PropertyDefinition.declarable = declarable;
    }
}
