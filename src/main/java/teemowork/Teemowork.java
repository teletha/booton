/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork;

import static booton.translator.web.WebSupport.*;
import js.Application;
import js.application.Header;
import js.application.Header.Menu;
import teemowork.model.Patch;
import booton.translator.annotation.PrimitiveMarker;

/**
 * @version 2012/12/11 14:23:57
 */
@PrimitiveMarker(intValue = 4)
public class Teemowork extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public void jsmain() {
        register(ChampionDetail.class);
        register(ChampionSelect.class);

        super.jsmain();

        $("body").css("padding", "0px 10%");

        Header nav = new Header();
        nav.add("< ^ v ^ > Teemowork", "test.html");
        nav.add("Patch", "#");

        Menu sub = nav.add("Data", "#");
        sub.add("Champion", "#");
        sub.add("Item", "#");
        sub.add("Mastery", "#");
        sub.add("Rune", "#");

        nav.add("Builder", "#");
        nav.add("About", "#");
        nav.add("Contact", "#");

        System.out.println(Patch.Latest);
        //
        // Class<?> clazz = ChampionDetail.class;
        //
        // for (Constructor constructor : clazz.getConstructors()) {
        // System.out.println(constructor);
        // System.out.println(constructor.isAnnotationPresent(PageInfo.class));
        // }

        // System.out.println(clazz.getSimpleName());
        //
        // for (Method method : clazz.getMethods()) {
        // System.out.println(method.getName() + "   @");
        //
        // if (method.isAnnotationPresent(Deprecated.class)) {
        // System.out.println(method.getName() + "   annotated");
        //
        // }
        // }
    }

    @Deprecated
    public void test() {
        System.out.println("called");
    }
}
