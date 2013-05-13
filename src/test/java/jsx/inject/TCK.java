/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package jsx.inject;

import jsx.Boot;
import junit.framework.Test;

import org.atinject.tck.Tck;
import org.atinject.tck.auto.Car;
import org.junit.Ignore;

/**
 * @version 2013/05/05 17:53:06
 */
public class TCK {

    @Ignore
    public static Test aaa() {
        Car car = new Boot().getInstance(Car.class);
        return Tck.testsFor(car, true, true);
    }
}
