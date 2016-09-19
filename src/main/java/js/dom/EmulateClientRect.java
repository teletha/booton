/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.dom;

/**
 * @version 2013/10/05 10:34:15
 */
class EmulateClientRect extends ClientRect {

    private float width;

    private float height;

    private float top;

    private float right;

    private float bottom;

    private float left;

    /**
     * 
     */
    public EmulateClientRect() {
    }

    /**
     * 
     */
    public EmulateClientRect(float width, float height, float top, float right, float bottom, float left) {
        this.width = width;
        this.height = height;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float width() {
        return width;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float height() {
        return height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float top() {
        return top;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float right() {
        return right;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float bottom() {
        return bottom;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float left() {
        return left;
    }
}
