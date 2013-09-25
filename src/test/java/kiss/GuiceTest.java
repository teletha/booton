/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package kiss;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.translator.ScriptRunner;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @version 2013/09/24 13:54:25
 */
@RunWith(ScriptRunner.class)
public class GuiceTest {

    @Test
    public void make() throws Exception {
        Injector injector1 = Guice.createInjector(new GuiceSampleModule1());
        GuiceSampleService service = injector1.getInstance(GuiceSampleServiceImpl1.class);
        service.doService();
    }

    /**
     * @version 2013/09/25 10:05:41
     */
    public static class GuiceSampleModule1 extends AbstractModule {

        @Override
        protected void configure() {
            bind(Product.class).to(Book.class);
        }
    }

    /**
     * @version 2013/09/25 10:05:43
     */
    public static interface GuiceSampleService {

        public void doService();
    }

    /**
     * @version 2013/09/25 10:05:45
     */
    public static class GuiceSampleServiceImpl1 implements GuiceSampleService {

        private Product product;

        @Inject
        public GuiceSampleServiceImpl1(Product product) {
            this.product = product;
        }

        @Override
        public void doService() {
            System.out.println(product.getName());
        }
    }

    /**
     * @version 2013/09/25 10:05:49
     */
    public static interface Product {

        public String getName();
    }

    /**
     * @version 2013/09/25 10:05:52
     */
    public static class Book implements Product {

        @Override
        public String getName() {
            return "BOOK!!";
        }
    }
}
