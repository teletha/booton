/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.primitive;

import org.junit.Test;

import booton.translator.api.Compilable;
import booton.translator.api.CompilableTester;

/**
 * @version 2012/11/30 1:40:13
 */
@SuppressWarnings("unused")
public class IntConstantTest extends CompilableTester {

    @Test
    public void one() {
        test(new Compilable() {

            int act() {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        test(new Compilable() {

            int act() {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        test(new Compilable() {

            int act() {
                return 3;
            }
        });
    }

    @Test
    public void four() {
        test(new Compilable() {

            int act() {
                return 4;
            }
        });
    }

    @Test
    public void five() {
        test(new Compilable() {

            int act() {
                return 5;
            }
        });
    }

    @Test
    public void siz() {
        test(new Compilable() {

            int act() {
                return 6;
            }
        });
    }

    @Test
    public void seven() {
        test(new Compilable() {

            int act() {
                return 7;
            }
        });
    }

    @Test
    public void eight() {
        test(new Compilable() {

            int act() {
                return 8;
            }
        });
    }

    @Test
    public void nine() {
        test(new Compilable() {

            int act() {
                return 9;
            }
        });
    }

    @Test
    public void ten() {
        test(new Compilable() {

            int act() {
                return 10;
            }
        });
    }

    @Test
    public void zero() {
        test(new Compilable() {

            int act() {
                return 0;
            }
        });
    }

    @Test
    public void minusOne() {
        test(new Compilable() {

            int act() {
                return -1;
            }
        });
    }

    @Test
    public void minusTwo() {
        test(new Compilable() {

            int act() {
                return -2;
            }
        });
    }

    @Test
    public void minusThree() {
        test(new Compilable() {

            int act() {
                return -3;
            }
        });
    }
}
