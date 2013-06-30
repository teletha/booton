/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.bwt;

import static js.lang.Global.*;
import static jsx.bwt.UIAction.*;
import jsx.jQuery;
import jsx.jQuery.Offset;
import jsx.application.PageUnload;
import jsx.bwt.view.PopupViewStyle;
import kiss.Disposable;

/**
 * @version 2013/06/12 9:11:13
 */
public class WindowManager {

    /** The popup area. */
    private static jQuery popup;

    /** The popup target. */
    private final jQuery target;

    /** The popup content. */
    private final jQuery content;

    /**
     * 
     */
    private WindowManager(jQuery target, jQuery content) {
        if (popup == null) {
            popup = $("<div>").add(PopupViewStyle.Bottom.class);
            $("body").append(popup);
        }

        this.target = target;
        this.content = content;

        System.out.println("register");
        EventBus.Global.register(this);
    }

    /**
     * 
     */
    @Listen(MouseEnter)
    private void show() {
        popup.append(content);
        popup.add(PopupViewStyle.Show.class);

        Offset offset = target.position();
        popup.css("top", offset.top + target.outerHeight() + 15 + "px")
                .css("left", offset.left - popup.outerWidth() / 2 + target.outerWidth() / 2 + "px");

        System.out.println(popup.get(0).attr("style"));
    }

    /**
     * 
     */
    @Listen(MouseLeave)
    private void hide() {
        popup.remove(PopupViewStyle.Show.class);
        content.remove();
    }

    /**
     * 
     */
    @Subscribe(PageUnload.class)
    private void unload() {
        System.out.println("unload");

        EventBus.Global.unregister(this);
        target.unbind(this);
        hide();
    }

    public static void applyTooltip(jQuery target, jQuery content) {
        if (target != null && content != null) {
            target.bind(new WindowManager(target, content));
        }
    }

    /**
     * <p>
     * Show tooltip.
     * </p>
     * 
     * @return
     */
    public static Disposable showTooltip(jQuery target, jQuery content) {
        return null;
    }
}
