/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import js.dom.DocumentFragment;
import jsx.application.Page;
import jsx.application.PageInfo;
import teemowork.model.Describable;
import teemowork.model.Descriptor;
import teemowork.model.Skill;
import teemowork.model.Version;

/**
 * @version 2013/12/13 20:08:37
 */
public class PatchHistory extends Page {

    /**
     * 
     */
    @PageInfo(path = "history")
    public PatchHistory() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getPageId() {
        return "history";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void load(DocumentFragment root) {
        Version[] versions = Version.values();

        for (int i = versions.length - 2; 21 < i; i--) {
            Version current = versions[i];
            Version previous = versions[i - 1];

            compare(current, previous);
        }
    }

    /**
     * <p>
     * Comapre version.
     * </p>
     * 
     * @param current
     * @param previous
     */
    private void compare(Version current, Version previous) {
        for (Describable describable : current.info) {
            if (describable instanceof Skill) {
                Descriptor currentDescriptor = describable.getDescriptor(current);
                Descriptor previousDescriptor = describable.getDescriptor(previous);

            }
        }
    }

    private void comapre(Skill current, Skill previous) {

    }
}
