/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.junit.runner.RunWith;

import booton.soeur.ScriptRunner;

/**
 * @version 2016/11/07 12:02:18
 */
@RunWith(ScriptRunner.class)
public class ProxyTest {

    /** The simple handler. */
    private InvocationHandler proxy = new InvocationHandler() {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return "PROXY";
        }
    };

    /** The simple handler. */
    private InvocationHandler echo = new InvocationHandler() {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            assert proxy != null;
            assert method != null;
            assert args != null;

            return args[0];
        }
    };

    @Test
    public void proxy() throws Exception {
        Machine machine = (Machine) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Machine.class, Bird.class}, proxy);
        assert Proxy.isProxyClass(machine.getClass());
        assert Proxy.getInvocationHandler(machine) == proxy;
        assert machine instanceof Machine;
        assert machine.echo("ignored").equals("PROXY");
        assert machine.defaults().equals("PROXY");
        assert machine instanceof Bird;
        assert((Bird) machine).tweet("ignored").equals("PROXY");
        assert machine instanceof Object;
    }

    @Test
    public void equality() throws Exception {
        Machine machine1 = (Machine) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Machine.class}, proxy);
        Machine machine2 = (Machine) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Machine.class}, proxy);
        Machine machine3 = (Machine) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Machine.class}, echo);
        Machine machine4 = (Machine) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Machine.class, Bird.class}, proxy);
        Machine machine5 = (Machine) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Bird.class, Machine.class}, proxy);

        assert machine1 != machine2;
        assert machine1 != machine3;
        assert machine1 != machine4;
        assert machine5 != machine4;
        assert machine1.getClass() == machine2.getClass();
        assert machine1.getClass() == machine3.getClass();
        assert machine1.getClass() != machine4.getClass();
        assert machine5.getClass() != machine4.getClass();
        assert Proxy.getInvocationHandler(machine1) == Proxy.getInvocationHandler(machine2);
        assert Proxy.getInvocationHandler(machine1) != Proxy.getInvocationHandler(machine3);
        assert Proxy.getInvocationHandler(machine1) == Proxy.getInvocationHandler(machine4);
        assert Proxy.getInvocationHandler(machine5) == Proxy.getInvocationHandler(machine4);
    }

    @Test
    public void handler() throws Exception {
        Machine machine = (Machine) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Machine.class}, echo);

        assert machine instanceof Machine == true;
        assert machine instanceof Bird == false;
        assert machine.echo("echo").equals("echo");
    }

    @Test
    public void extend() throws Exception {
        Chicken chicken = (Chicken) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[] {Chicken.class}, proxy);

        assert chicken instanceof Bird;
        assert chicken instanceof Chicken;
        assert!(chicken instanceof Machine);
        assert chicken.tweet("koke-").equals("PROXY");
        assert chicken.talk("moti ummai").equals("PROXY");
    }

    /**
     * @version 2016/11/07 12:03:17
     */
    private static interface Machine {

        String echo(String message);

        default String defaults() {
            return "default";
        }
    }

    /**
     * @version 2016/11/07 12:03:15
     */
    private static interface Bird {

        String tweet(String message);
    }

    /**
     * @version 2016/11/07 12:03:13
     */
    private static interface Chicken extends Bird {

        String talk(String message);
    }
}
