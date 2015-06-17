/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * @version 2014/01/25 9:31:23
 */
public class FXSample extends Application {

    public static void main(String[] args) {
        launch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage stage) throws Exception {
        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        // engine.load("http://modernizr.github.io/Modernizr/test/index.html");
        engine.load("http://localhost:10021/index.html");

        stage.setScene(new Scene(view));
        stage.show();
    }
}
