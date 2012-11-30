/*
 * Copyright (C) 2009 Nameless Production Committee.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package booton.translator.constructor;

import org.junit.Test;

import booton.translator.ScriptTranslatorTestcase;
import booton.translator.api.ObjectScript;

/**
 * @version 2009/08/11 20:45:42
 */
public class ConstructorTest extends ScriptTranslatorTestcase {

    @Test
    public void NoParameterTopLevelClass() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new NoParameter().toString();
            }
        });
    }

    @Test
    public void ImplicitConstructorOfPublicMember() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new ImplicitConstructorOfPublicMember().toString();
            }
        });
    }

    /**
     * @version 2009/08/19 20:36:42
     */
    public static class ImplicitConstructorOfPublicMember {

        public String toString() {
            return "No Param Public Member";
        }
    }

    @Test
    public void ImplicitConstructorOfProtectedMember() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new ImplicitConstructorOfProtectedMember().toString();
            }
        });
    }

    /**
     * @version 2009/08/19 20:36:42
     */
    protected static class ImplicitConstructorOfProtectedMember {

        public String toString() {
            return "No Param Protected Member";
        }
    }

    @Test
    public void ImplicitConstructorOfPackageMember() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new ImplicitConstructorOfPackageMember().toString();
            }
        });
    }

    /**
     * @version 2009/08/19 20:36:42
     */
    static class ImplicitConstructorOfPackageMember {

        public String toString() {
            return "No Param Package Member";
        }
    }

    @Test
    public void ImplicitConstructorOfPrivateMember() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new ImplicitConstructorOfPrivateMember().toString();
            }
        });
    }

    /**
     * <p>
     * Private class defines <em>private</em> constructor implicitly, so compiler generates
     * <em>package private</em> access constructor.
     * </p>
     * 
     * @version 2009/08/19 20:36:42
     */
    private static class ImplicitConstructorOfPrivateMember {

        public String toString() {
            return "No Param Private Member";
        }
    }

    @Test
    public void ExplicitConstructorOfPrivateMember() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new ExplicitConstructorOfPrivateMember().toString();
            }
        });
    }

    /**
     * <p>
     * This class defines <em>private</em> constructor explicitly, so compiler generates
     * <em>package private</em> access constructor.
     * </p>
     * 
     * @version 2009/08/19 20:36:42
     */
    private static class ExplicitConstructorOfPrivateMember {

        private ExplicitConstructorOfPrivateMember() {
            // do nothing
        }

        public String toString() {
            return "No Param Private Member";
        }
    }

    @Test
    public void Parameter() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new Parameter(value).toString();
            }
        });
    }

    /**
     * @version 2009/08/19 20:36:42
     */
    private static class Parameter {

        private final String param;

        public Parameter(String param) {
            this.param = param;
        }

        public String toString() {
            return "Parameter [param=" + param + "]";
        }
    }

    @Test
    public void Parameters() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new Parameters(value, 1).toString();
            }
        });
    }

    /**
     * @version 2009/08/19 20:36:42
     */
    private static class Parameters {

        private final String param;

        private final int index;

        public Parameters(String param, int index) {
            this.param = param;
            this.index = index;
        }

        /**
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Parameters [index=" + index + ", param=" + param + "]";
        }
    }

    @Test
    public void Overload1() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new Overload().toString();
            }
        });
    }

    @Test
    public void Overload2() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new Overload(value).toString();
            }
        });
    }

    @Test
    public void Overload3() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new Overload(value, 1).toString();
            }
        });
    }

    @Test
    public void Overload4() {
        test("script", new ObjectScript<String>() {

            public String act(String value) {
                return new Overload(value, value).toString();
            }
        });
    }

    /**
     * @version 2009/08/19 20:36:42
     */
    private static class Overload {

        private final String param;

        private final int index;

        public Overload() {
            this("", 0);
        }

        public Overload(String param) {
            this(param, 0);
        }

        public Overload(String param, int index) {
            this.param = param;
            this.index = index;
        }

        public Overload(String param, String index) {
            this.param = param;
            this.index = index.length();
        }

        /**
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Parameters [index=" + index + ", param=" + param + "]";
        }
    }

    @Test
    public void Extend1() {
        test("CHILD", new ObjectScript<String>() {

            /**
             * @see booton.translator.api.ObjectScript#act(java.lang.Object)
             */
            public String act(String value) {
                Child external = new Child(value);

                return external.toString();
            }
        });
    }

    @Test
    public void Extend2() {
        test("CHILD", new ObjectScript<String>() {

            /**
             * @see booton.translator.api.ObjectScript#act(java.lang.Object)
             */
            public String act(String value) {
                Child external = new Child(2, value);

                return external.toString();
            }
        });
    }

    /**
     * @version 2009/08/11 20:48:12
     */
    protected static class Base {

        protected final String name;

        /**
         * @param name
         */
        public Base(String name) {
            this.name = name;
        }

        /**
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "ExternalClass [name=" + name + "]";
        }
    }

    /**
     * @version 2009/08/11 20:48:12
     */
    protected static class Child extends Base {

        /**
         * @param name
         */
        public Child(String name) {
            super(name);
        }

        /**
         * @param name
         */
        public Child(int type, String name) {
            super(name);
        }

        /**
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "ChildClass [name=" + name + "]";
        }
    }

    @Test
    public void Local() {
        test(new ObjectScript<String>() {

            private String value = "outer";

            public String act(String value) {
                return new Inner().toString();
            }

            /**
             * @version 2009/08/31 13:16:33
             */
            class Inner {

                /**
                 * @see java.lang.Object#toString()
                 */
                @Override
                public String toString() {
                    return value;
                }
            }
        });
    }

    @Test
    public void Anonymous() {
        test(new ObjectScript<String>() {

            public String act(String value) {
                return new Object() {

                    public String toString() {
                        return "Anonymous";
                    };
                }.toString();
            }
        });
    }

    @Test
    public void AnonymousWIthOuterAccess() {
        test("Hitagi", new ObjectScript<String>() {

            public String act(final String value) {
                return new Object() {

                    public String toString() {
                        return value;
                    };
                }.toString();
            }
        });
    }

}
