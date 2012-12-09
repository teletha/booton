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
package booton.translator;

import static org.objectweb.asm.ClassReader.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import kiss.I;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;

import booton.translator.js.JsError;
import booton.translator.js.NativeObject;

/**
 * <h2>The Reserved words in ECMA Script Third Edition</h2>
 * <p>
 * The following words are reserved.
 * </p>
 * <p>
 * abstract, boolean, break, byte, case, catch, char, class, const, continue, debugger, default,
 * delete, do, double, else, enum, export, extends, false, final, finally, float, for, function,
 * goto, if, implements, import, in, instanceof, int, interface, label, long, native, new, null,
 * package, private, protected, public, return, short, static, super, switch, synchronized, this,
 * throw, throws, transient, true, try, typeof, var, void, volatile, while, with
 * <p>
 * <p>
 * But the following words can use safely in many javascript engines (IE6+, Gecko1.5+, Webkit3.0+).
 * <p>
 * <p>
 * abstract, boolean, byte, char, double, final, float, goto, implements, int, interface, long,
 * native, package, private, protected, public, short, static, synchronized, throws, transient,
 * volatile
 * </p>
 * 
 * @version 2012/12/02 16:32:42
 */
public class Javascript {

    /** The all cached scripts. */
    private static final Map<Class, Javascript> scripts = I.aware(new ConcurrentHashMap());

    /**
     * The sorterd hash of unsafe words in ECMA Script. These values are calculated and hard-coded
     * to reduce footprint size and process time at runtime. See {@link UnsafeWordCalculator} for
     * more detail.
     */
    private static final int[] unsafe = {62, 133, 141, 6355, 8379, 48643, 48854, 53444, 60708, 363787};

    /** The character list of number whihc base is 16. */
    private static final char[] lowers = new char[16];

    /** The character list of number whihc base is 16. */
    private static final char[] uppers = new char[16];

    /** The local identifier counter for {@link Javascript}. */
    private static int counter = 0;

    // initialization
    static {
        // Load Booton module
        I.load(Javascript.class, true);

        // Allocate characters
        for (int i = 0; i < 16; i++) {
            lowers[i] = (char) (i + 97);
            uppers[i] = (char) (i + 65);
        }
    }

    /** The actual script class to translate. */
    public final Class source;

    /** The identifier of this script. */
    private final int id;

    /** The all dependency scripts. */
    private final Set<Class> dependencies = new HashSet();

    /** The constructor list of this script. */
    private final List<Integer> constructors = new ArrayList();

    /** The method list of this script. */
    private static final List<Integer> methods = new ArrayList();

    /** The field list of this script. */
    private final List<Integer> fields = new ArrayList();

    /** The actual Javascript source code to be translated. This is initialized lazy */
    private String code;

    /**
     * Create Javascript as the specified Java class is source.
     * 
     * @param source A Java class as source.
     */
    private Javascript() {
        this(Object.class);
    }

    /**
     * Create Javascript as the specified Java class is source.
     * 
     * @param source A Java class as source.
     */
    private Javascript(Class source) {
        this.source = source;
        this.id = counter++;
    }

    /**
     * Require the specified java source code.
     * 
     * @param dependency A dependency class.
     */
    public void require(Class dependency) {
        dependency = switchClass(dependency);

        if (!TranslatorManager.hasTranslator(dependency) && !dependency.isArray()) {
            dependencies.add(dependency);
        }
    }

    /**
     * <p>
     * Write this script into the specified output. This method write out dependency scripts of this
     * script too.
     * </p>
     * 
     * @param outout A script output.
     */
    public void writeTo(Path output) {
        try {
            writeTo(Files.newBufferedWriter(output, I.$encoding));
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Write this script into the specified output. This method write out dependency scripts of this
     * script too.
     * </p>
     * 
     * @param outout A script output.
     */
    public void writeTo(Appendable output) {
        // Record all defined classes to prevent duplicated definition.
        write(output, new HashSet(Collections.singleton(source)));

        I.quiet(output);
    }

    /**
     * <p>
     * Helper method to write dependency scripts into the specified output.
     * </p>
     * 
     * @param output A script output.
     * @param defined
     */
    private void write(Appendable output, Set defined) {
        compile();

        for (Class depndency : dependencies) {
            if (defined.add(depndency)) {
                Javascript script = Javascript.getScript(depndency);

                // write dependency scripts
                if (script != null) {
                    script.write(output, defined);
                }
            }
        }

        try {
            // write this script
            output.append(code);
        } catch (IOException e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Translate the java byte code to the javascript code.
     * </p>
     */
    private synchronized void compile() {
        if (code == null) {
            try {
                // All scripts depend on its parent classes. So we must compile it ahead.
                Class parentClass = source.getSuperclass();

                if (parentClass != null && source != NativeObject.class) {
                    Javascript parent = Javascript.getScript(parentClass);

                    if (parent != null && parent.source != NativeObject.class) {
                        // compile ahead
                        parent.compile();

                        // add dependency
                        dependencies.add(parent.source);

                        // copy all member fields and methods for override mechanism
                        // methods.addAll(parent.methods);
                        fields.addAll(parent.fields);
                    }
                }

                if (source.isInterface()) {
                    for (Method method : source.getDeclaredMethods()) {
                        order(fields, method.getName().hashCode() ^ Type.getMethodDescriptor(method).hashCode());
                    }
                }

                // Then, we can compile this script.
                ScriptBuffer code = new ScriptBuffer();

                // Start class definition
                code.append("boot.defineClass(\"").append(computeClassName(source).substring(5)).append("\",");

                if (parentClass != null && parentClass != Object.class) {
                    code.append(Javascript.computeClassName(parentClass)).append(',');
                }

                code.append('{');

                new ClassReader(source.getName()).accept(new JavaClassCompiler(this, code), SKIP_FRAMES);

                // End class definition
                code.append("});");

                // create cache
                this.code = code.toString();
            } catch (IOException e) {
                throw I.quiet(e);
            }
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // write out
        writeTo(builder);

        return builder.toString();
    }

    /**
     * <p>
     * Compile the specified Java class to Javascript source code.
     * </p>
     * 
     * @param source A Java class to compile.
     * @return A compiled Javascript source.
     */
    public static final Javascript getScript(Class source) {
        // check Native Class
        if (TranslatorManager.hasTranslator(source) || source.isInterface()) {
            return null;
        }

        source = switchClass(source);

        // check cache
        Javascript script = scripts.get(source);

        if (script == null) {
            script = new Javascript(source);

            // cache it
            scripts.put(source, script);
        }

        // API definition
        return script;
    }

    private static Class switchClass(Class type) {
        if (type == Object.class) {
            return NativeObject.class;
        }

        if (Throwable.class.isAssignableFrom(type)) {
            return JsError.class;
        }
        return type;
    }

    /**
     * <p>
     * Compute the identified qualified class name for ECMAScript.
     * </p>
     * 
     * @param clazz A class with fully qualified class name(e.g. java.lang.String).
     * @return An identified class name for ECMAScript.
     */
    public static final String computeClassName(Class clazz) {
        Javascript script = getScript(clazz);

        if (script == null) {
            return clazz.getSimpleName();
        } else {
            return "boot." + mung(script.id, true);
        }
    }

    /**
     * <p>
     * Compute the identified qualified method name for ECMAScript.
     * </p>
     * 
     * @param methodName A fully qualified internal name(e.g. java/lang/String).
     * @param parameters A list of parameter types.
     * @return An identified class name for ECMAScript.
     */

    /**
     * <p>
     * Compute the identified qualified method name for ECMAScript.
     * </p>
     * 
     * @param owner A {@link Class} object representing the class or interface that declares the
     *            specified method.
     * @param methodName A method name(e.g. toString, <init> and <clinit>).
     * @param description A method description of parameter types and return type. (e.g.
     *            (Ljava/lang/String;)V)
     * @return An identified class name for ECMAScript.
     */
    public static final String computeMethodName(Class owner, String name, String description) {
        if (TranslatorManager.isNativeMethod(owner, name, description)) {
            return name;
        }

        Javascript script = getScript(owner);

        if (name.charAt(0) == '<') {
            if (name.charAt(1) == 'c') {
                // class initializer
                return "";
            } else {
                // constructor
                return "$" + order(script.constructors, description.hashCode());
            }
        } else {
            // method
            return mung(order(script.methods, name.hashCode() ^ description.hashCode()), false);
        }
    }

    /**
     * <p>
     * Compute the identified qualified field name for ECMAScript.
     * </p>
     * 
     * @param owner A owner class of the specified field.
     * @param fieldName A field name in Java source code.
     * @return An identified field name for ECMAScript.
     */
    public static final String computeFieldName(Class owner, String fieldName) {
        if (TranslatorManager.isNativeField(owner, fieldName)) {
            return fieldName;
        }

        try {
            owner.getDeclaredField(fieldName);

            return mung(order(getScript(owner).fields, fieldName.hashCode() + owner.hashCode()), true);
        } catch (NoSuchFieldException e) {
            return computeFieldName(owner.getSuperclass(), fieldName);
        }
    }

    /**
     * <p>
     * Compute the identified qualified local variable name for ECMAScript.
     * </p>
     * 
     * @param order An order by which this variable was declared.
     * @param inStaticMember If this variable is declared in static member, <code>true</code>.
     * @return An identified local variable name for ECMAScript.
     */
    public static final String computeLocalVariable(int order, boolean inStaticMember) {
        // order 0 means "this", but static method doesn't have "this" variable
        if (!inStaticMember) {
            order--;
        }

        if (order == -1) {
            return "this";
        }

        // Compute local variable name
        return mung(order, true);
    }

    /**
     * <p>
     * Convert the specified number to an munged alphabetical hex number expression ('a' to 'p').
     * </p>
     * 
     * @param number A number to mung.
     * @param lower A character patter. <code>true</code> use lower case, otherwise upper case.
     * @return A munged letters.
     */
    static final String mung(int number, boolean lower) {
        int i = Arrays.binarySearch(unsafe, number);

        if (i < 0) {
            // Calculate insert index
            i = (i + 1) * -1;

            // Increse the amount of unsafe numbers which are lower than the specified number.
            number += i;

            // If the previous increment exceeds the next unsafe number, we must increse one more.
            if (i != unsafe.length && unsafe[i] <= number) {
                number++;
            }
        } else {
            // It is assured that this increment doesn't exceeds the next unsafe number because the
            // sequence of unsafe numbers has enough distance on each elements.
            number += i + 1;
        }

        int index = 8;
        char[] buffer = new char[8];

        do {
            buffer[--index] = lower ? lowers[number & 15] : uppers[number & 15];
            number >>>= 4;
        } while (number != 0);

        // build muged value
        return new String(buffer, index, (8 - index));
    }

    /**
     * <p>
     * Helper method to do numbering for the specified member's id.
     * </p>
     * 
     * @param members
     * @param id
     * @return
     */
    private static final int order(List<Integer> members, int id) {
        // check cache
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).intValue() == id) {
                return i;
            }
        }

        // register as new member
        members.add(id);

        // API definition
        return members.size() - 1;
    }
}
