/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2013/08/25 15:24:28
 */
@RunWith(ScriptRunner.class)
public class ObjectTest {

    @Test
    public void callEquals() throws Exception {
        Object one = new Parent();
        assert one.equals(one);

        Object two = new Parent();
        assert !one.equals(two);
    }

    @Test
    public void callHashCode() throws Exception {
        Object one = new Parent();
        assert one.hashCode() == one.hashCode();

        Object two = new Parent();
        assert one.hashCode() != two.hashCode();
    }

    @Test
    public void callGetClass() throws Exception {
        assert new Parent().getClass() == Parent.class;
        assert new Child().getClass() == Child.class;
    }

    /**
     * @version 2013/08/27 14:32:42
     */
    private static class Parent {
    }

    /**
     * @version 2013/01/16 21:36:02
     */
    private static class Child extends Parent {
    }

    @Test
    public void callFinalize() throws Throwable {
        new Exposer().callFinalize();
    }

    @Test(expected = CloneNotSupportedException.class)
    public void callClone() throws CloneNotSupportedException {
        new Exposer().callClone();
    }

    /**
     * @version 2013/08/25 15:28:54
     */
    private static class Exposer {

        private void callFinalize() throws Throwable {
            super.finalize();
        }

        private void callClone() throws CloneNotSupportedException {
            super.clone();
        }
    }
}
