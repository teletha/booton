/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator.array;

import org.junit.Test;

import booton.translator.Param;
import booton.translator.ScriptTester;
import booton.translator.Scriptable;

/**
 * @version 2012/12/01 3:14:42
 */
@SuppressWarnings("unused")
public class StringArrayTest extends ScriptTester {

    @Test
    public void Array() {
        test(new Scriptable() {

            public String[] act() {
                String[] array = new String[2];
                array[0] = "1";
                array[1] = "2";

                return array;
            }
        });
    }

    @Test
    public void ArrayWithExpression() {
        test(new Scriptable() {

            private String field = "value";

            public String[] act() {
                String[] array = new String[4];
                array[0] = field + field;
                array[1] = field.substring(field.length() - 3);
                array[2] = field.concat(field);
                array[3] = field.replace('a', 'o');

                return array;
            }
        });
    }

    @Test
    public void ArrayByShorthand() {
        test(new Scriptable() {

            public String[] act() {
                return new String[] {"a", "b"};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithFirstNull() {
        test(new Scriptable() {

            public String[] act() {
                return new String[] {null, "end"};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithlastNull() {
        test(new Scriptable() {

            public String[] act() {
                return new String[] {"start", null};
            }
        });
    }

    @Test
    public void ArrayByShorthandWithAllNull() {
        test(new Scriptable() {

            public String[] act() {
                return new String[] {null, null};
            }
        });
    }

    @Test
    public void ArrayWithExpressionByShorthand() {
        test(new Scriptable() {

            private String field = "value";

            public String[] act() {
                return new String[] {field + field, field.substring(1), field.concat("@"), field.replace('a', 'e')};
            }
        });
    }

    @Test
    public void ArraySoMany() {
        test(new Scriptable() {

            public String[] act() {
                return new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
            }
        });
    }

    @Test
    public void MultiDimensionArray() {
        test(new Scriptable() {

            public String[][] act() {
                String[][] array = new String[3][2];
                array[0] = new String[] {"a", "b"};
                array[1] = new String[] {"c", "d"};
                array[2] = new String[] {"e", "f"};

                return array;
            }
        });
    }

    @Test
    public void MultiDimensionArrayByShorthand() {
        test(new Scriptable() {

            public String[][] act() {
                return new String[][] { {"a", "b"}, {"c", "d", "e"}};
            }
        });
    }

    @Test
    public void ArrayAccess() {
        test(new Scriptable() {

            public String act(String value) {
                String[] array = {"first", value};

                return array[1];
            }
        });
    }

    @Test
    public void ArrayLength() {
        test(new Scriptable() {

            public int act(@Param(ints = {0, 1, 10}) int value) {
                return new String[value].length;
            }
        });
    }

    @Test
    public void ArrayFor() {
        test(new Scriptable() {

            public String act() {
                String sum = "";
                String[] array = {"a", "b", "c"};

                for (int i = 0; i < array.length; i++) {
                    sum += array[i];
                }
                return sum;
            }
        });
    }

    @Test
    public void ArrayForEach() {
        test(new Scriptable() {

            public String act() {
                String sum = "";
                String[] array = {"a", "b", "c"};

                for (String item : array) {
                    sum += item;
                }
                return sum;
            }
        });
    }
}
