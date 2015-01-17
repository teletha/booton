/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.ui.piece;

import jsx.ui.LowLevelWidget;
import jsx.ui.VirtualStructure;

/**
 * @version 2014/09/11 8:59:42
 */
public class Image extends LowLevelWidget<Image> {

    /**
     * @param name
     */
    public Image() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String virtualizeName() {
        return "img";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void virtualizeStructure(VirtualStructure descriptor) {
    }

}
