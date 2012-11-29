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
        evaluate(new Compilable() {

            int act() {
                return 1;
            }
        });
    }

    @Test
    public void two() {
        evaluate(new Compilable() {

            int act() {
                return 2;
            }
        });
    }

    @Test
    public void three() {
        evaluate(new Compilable() {

            int act() {
                return 3;
            }
        });
    }

    @Test
    public void four() {
        evaluate(new Compilable() {

            int act() {
                return 4;
            }
        });
    }

    @Test
    public void five() {
        evaluate(new Compilable() {

            int act() {
                return 5;
            }
        });
    }

    @Test
    public void siz() {
        evaluate(new Compilable() {

            int act() {
                return 6;
            }
        });
    }

    @Test
    public void seven() {
        evaluate(new Compilable() {

            int act() {
                return 7;
            }
        });
    }

    @Test
    public void eight() {
        evaluate(new Compilable() {

            int act() {
                return 8;
            }
        });
    }

    @Test
    public void nine() {
        evaluate(new Compilable() {

            int act() {
                return 9;
            }
        });
    }

    @Test
    public void ten() {
        evaluate(new Compilable() {

            int act() {
                return 10;
            }
        });
    }

    @Test
    public void zero() {
        evaluate(new Compilable() {

            int act() {
                return 0;
            }
        });
    }

    @Test
    public void minusOne() {
        evaluate(new Compilable() {

            int act() {
                return -1;
            }
        });
    }

    @Test
    public void minusTwo() {
        evaluate(new Compilable() {

            int act() {
                return -2;
            }
        });
    }

    @Test
    public void minusThree() {
        evaluate(new Compilable() {

            int act() {
                return -3;
            }
        });
    }
}
