/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.reactive.layout;

/**
 * @version 2014/09/10 16:40:37
 */
public class ChampionDetailLayout extends Layout<ChampionDetail> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void width1024() {
        lay($(w.level).align(Top, Tail));
    }
}
