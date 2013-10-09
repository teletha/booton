/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package booton.translator;

import static booton.Obfuscator.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import js.lang.Global;
import js.lang.NativeObject;
import js.lang.NativeString;
import kiss.ClassListener;
import kiss.Extensible;
import kiss.I;
import kiss.Manageable;
import kiss.Singleton;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Type;

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
 * But the following words can use safely in many javascript engines (IE10+, Gecko10+, Webkit5+).
 * <p>
 * <p>
 * abstract, boolean, byte, char, double, final, float, goto, implements, int, interface, long,
 * native, package, private, protected, public, short, static, synchronized, throws, transient,
 * volatile
 * </p>
 * 
 * @version 2013/09/24 15:56:44
 */
public class Javascript {

    /** The primitive types. */
    private static final List<Class<?>> primitives = Arrays.asList(int.class, long.class, float.class, double.class, boolean.class, byte.class, short.class, char.class, void.class);

    /** The fixed id for primitives. */
    private static final List<Integer> primitiveIds = Arrays.asList(8, 9, 5, 3, 25, 1, 18, 2, 21);

    /** The dependency manager. */
    private static final DepenedencyManager manager = I.make(DepenedencyManager.class);

    /** The all cached scripts. */
    private static final Map<Class, Javascript> scripts = I.aware(new ConcurrentHashMap());

    /** The local identifier counter for {@link Javascript}. */
    private static int counter = 0;

    /** The compiling route. */
    private static Deque<Javascript> compiling = new ArrayDeque();

    // initialization
    static {
        // Load Booton module
        I.load(Global.class, false);

        // Define Class class at first. It is ensured that Class definition is
        // assigned in 'boot.A' variable.
        getScript(Class.class);
        getScript(Object.class);
    }

    /** The actual script class to translate. */
    public final Class<?> source;

    /** The identifier of this script. */
    private final int id;

    /** The all dependency scripts. */
    private final Set<Class> dependencies = new LinkedHashSet();

    /** The constructor list of this script. */
    private final List<Integer> constructors = new ArrayList();

    /** The method list of this script. */
    private static final List<Integer> methods = new ArrayList();

    /** The field list of this script. */
    private final List<Integer> fields = new ArrayList();

    /** The actual Javascript source code to be translated. This is initialized lazy. */
    private String code;

    /**
     * Create Javascript as the specified Java class is source.
     * 
     * @param source A Java class as source.
     */
    private Javascript(Class source) {
        this.source = source;

        Class reverted = JavaAPIProviders.revert(source);

        if (reverted.isPrimitive()) {
            this.id = primitiveIds.get(primitives.indexOf(reverted));
        } else {
            while (primitiveIds.indexOf(counter) != -1) {
                // skip preserved id for primitives
                counter++;
            }
            this.id = counter++;
        }

        // copy all member fields for override mechanism
        if (!source.getName().equals("js.lang.JSObject")) {
            Javascript script = getScript(source.getSuperclass());

            if (script != null) {
                fields.addAll(script.fields);
            }
        }

        for (Field field : source.getDeclaredFields()) {
            order(fields, field.getName().hashCode() + source.hashCode());
        }
    }

    /**
     * <p>
     * Write this script into the specified output. This method write out dependency scripts of this
     * script too.
     * </p>
     * 
     * @param outout A script output.
     * @param requirements A list of required script classes.
     */
    public void writeTo(Path output, Class... requirements) {
        try {
            writeTo(Files.newBufferedWriter(output, I.$encoding), new HashSet(), requirements);
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
     * @param requirements A list of required script classes.
     */
    public void writeTo(Appendable output, Class... requirements) {
        writeTo(output, new HashSet(), requirements);
    }

    /**
     * <p>
     * Write this script into the specified output. This method write out dependency scripts of this
     * script too.
     * </p>
     * 
     * @param outout A script output.
     * @param requirements A list of required script classes.
     */
    void writeTo(Appendable output, Set<Class> defined, Class... requirements) {
        // record compile route
        compiling.addFirst(this);

        try {
            manager.add(requirements);

            try {
                // Record all defined classes to prevent duplicated definition.
                write(output, defined);

                // Write bootstrap method if needed.
                output.append("try {");
                try {
                    output.append(writeMethodCode(source, "jsmain")).append(";");
                } catch (Exception e) {
                    // ignore missing "jsmain" method
                }
                output.append("} catch(e) {");
                output.append(writeMethodCode(Thread.class, "handleUncaughtException", Object.class, "e")).append(";");
                output.append("}");
            } catch (Exception e) {
                throw I.quiet(e);
            }
            I.quiet(output);
        } finally {
            // record compile route
            compiling.removeFirst();
        }
    }

    /**
     * <p>
     * Helper method to write dependency scripts into the specified output.
     * </p>
     * 
     * @param output A script output.
     * @param defined
     */
    private void write(Appendable output, Set defined) throws IOException {
        // record compile route
        compiling.addFirst(this);

        try {
            // compile script
            compile();

            // write super class
            if (!source.getName().equals("js.lang.JSObject")) {
                Javascript script = Javascript.getScript(source.getSuperclass());

                if (script != null && !defined.contains(script.source)) {
                    script.write(output, defined);
                }
            }

            // require interfaces
            for (Class interfaceType : source.getInterfaces()) {
                require(interfaceType);
            }

            // write this class
            if (defined.add(source)) {
                output.append(code);
            }

            // write dependency classes
            for (Class depndency : dependencies) {
                Javascript script = Javascript.getScript(depndency);

                if (script != null && !defined.contains(script.source)) {
                    script.write(output, defined);
                }
            }
        } finally {
            // record compile route
            compiling.removeFirst();
        }
    }

    /**
     * <p>
     * Translate the java byte code to the javascript code.
     * </p>
     */
    private synchronized void compile() {
        if (code == null) {
            ScriptWriter code = new ScriptWriter();

            if (source.isInterface()) {
                compileInterface(code);
            } else {
                compileClass(code, source.getSuperclass(), null);
            }

            // create cache
            this.code = code.toString();
        }
    }

    Javascript recompile(byte[] bytes) {
        ScriptWriter code = new ScriptWriter();
        compileClass(code, source.getSuperclass(), bytes);

        // create cache
        this.code = code.toString();

        return this;
    }

    /**
     * <p>
     * Compile java class to javascript.
     * </p>
     * 
     * @param code
     * @param parent A parent class.
     */
    private void compileClass(ScriptWriter code, Class parent, byte[] bytes) {
        // compute related class names
        String className = computeSimpleClassName(source);
        String superClassName = parent == Object.class ? "" : computeSimpleClassName(parent);

        // write class definition
        code.comment(source + " " + className);
        code.append("boot.define(").string(className).append(",\"", superClassName, "\",");

        // write constructors, fields and methods
        try {
            code.append('{');
            ClassReader reader;

            if (bytes == null) {
                reader = new ClassReader(source.getName());
            } else {
                reader = new ClassReader(bytes);
            }
            reader.accept(new JavaClassCompiler(this, code), 0);

            code.append('}');
        } catch (TranslationError e) {
            e.write("\r\n");

            for (Javascript script : compiling) {
                e.write(" at ", script.source.getName());
            }

            throw e;
        } catch (Throwable e) {
            TranslationError error = new TranslationError(e);
            error.write("Can't compile ", source.getName() + ".");

            for (Javascript script : compiling) {
                error.write(" at ", script.source.getName());
            }

            throw error;
        }

        for (Annotation annotation : source.getAnnotations()) {
            require(annotation.annotationType());
        }

        // write metadata
        code.append(",").append(new JavaMetadataCompiler(source));

        // write native class enhancement
        JavascriptAPIProvider provider = source.getAnnotation(JavascriptAPIProvider.class);

        if (provider != null) {
            String nativeClasses = provider.value().length() != 0 ? provider.value() : source.getSimpleName();

            code.append(",").string(nativeClasses);
        }

        // End class definition
        code.append(");");
        code.line();
    }

    /**
     * <p>
     * Compile java class to javascript.
     * </p>
     * 
     * @param code
     * @param parent A parent class.
     */
    private void compileInterface(ScriptWriter code) {
        // compute related class names
        String className = Javascript.computeSimpleClassName(source);

        // write interface definition
        code.comment(source);
        code.append("boot.define(").string(className).append(",\"\",");

        // write constructors, fields and methods
        try {
            code.append('{');

            if (source.isAnnotation()) {
                Method[] methods = source.getDeclaredMethods();

                for (int i = 0; i < methods.length; i++) {
                    code.comment(methods[i]);
                    code.append(computeMethodName(methods[i])).append(":");

                    Object value = methods[i].getDefaultValue();

                    if (value == null) {
                        code.append("null");
                    } else {
                        code.append("function() {return " + JavaMetadataCompiler.compileValue(value) + ";}");
                    }

                    if (i < methods.length - 1) {
                        code.separator();
                    }
                }
            }
            code.append('}');
        } catch (Exception e) {
            throw I.quiet(e);
        }

        // write metadata
        code.append(",").append(new JavaMetadataCompiler(source));

        // End class definition
        code.append(");");
        code.line();
    }

    /**
     * {@inheritDoc}
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
     * Write method calling code.
     * </p>
     * 
     * @param type A target class.
     * @param name A target method name.
     * @param contextAndParameters A parameter code.
     * @return
     */
    public static final String writeMethodCode(Class type, String name, Object... contextAndParameters) {
        Object context = null;
        Object[] parameters = contextAndParameters;

        if (contextAndParameters.length % 2 == 1) {
            context = contextAndParameters[0];
            parameters = Arrays.copyOfRange(contextAndParameters, 1, contextAndParameters.length);
        }

        try {
            Class[] types = new Class[parameters.length / 2];
            String[] params = new String[parameters.length / 2];

            for (int i = 0; i < parameters.length; i = i + 2) {
                types[i / 2] = (Class) parameters[i];
                params[i / 2] = String.valueOf(parameters[i + 1]);
            }

            Class source = getScript(type).source;

            // Search original or alias method by name and parameter types.
            Method method;

            try {
                method = source.getDeclaredMethod(name, types);
            } catch (NoSuchMethodException e) {
                try {
                    method = source.getDeclaredMethod("$alias$" + name, types);
                } catch (NoSuchMethodException error) {
                    throw I.quiet(e);
                }
            }

            // Write method invocation code.
            String code;

            if (Modifier.isStatic(method.getModifiers())) {
                code = computeClassName(source);
            } else if (context == null) {
                code = "new " + computeClassName(source) + "(0)";
            } else {
                code = context.toString();
            }
            return code + "." + computeMethodName(method) + "(" + I.join(",", params) + ")";
        } catch (Exception e) {
            throw I.quiet(e);
        }
    }

    /**
     * <p>
     * Require the specified java source code.
     * </p>
     * 
     * @param dependency A dependency class.
     */
    public static final void require(Class dependency) {
        while (dependency.isArray()) {
            dependency = dependency.getComponentType();
        }

        Javascript current = compiling.peekFirst();

        if (dependency != current.source) {
            current.dependencies.add(dependency);
        }
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
        source = JavaAPIProviders.convert(source);

        // check Native Class
        if (source == null || source.isArray() || TranslatorManager.hasTranslator(source)) {
            return null;
        }

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

    /**
     * <p>
     * Compute the identified qualified class object for ECMAScript.
     * </p>
     * 
     * @param clazz A class with fully qualified class name(e.g. java.lang.String).
     * @return An identified class object for ECMAScript.
     */
    public static final String computeClass(Class clazz) {
        int dimension = 0;

        while (clazz.isArray()) {
            dimension++;
            clazz = clazz.getComponentType();
        }

        String type = computeClassName(clazz) + ".$";

        if (dimension != 0) {
            for (int i = 0; i < dimension; i++) {
                type = writeMethodCode(Class.class, "getArrayClass", type);
            }
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
    public static final String computeClassName(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(JavaAPIProvider.class)) {
            JavascriptAPIProvider provider = clazz.getAnnotation(JavascriptAPIProvider.class);

            if (provider != null && clazz != Object.class) {
                String name = provider.value();

                if (name.length() == 0) {
                    name = clazz.getSimpleName();
                }
                return name;
            }
        }
        return "boot." + computeSimpleClassName(clazz);
    }

    /**
     * <p>
     * Compute the identified simple class name for ECMAScript.
     * </p>
     * 
     * @param clazz A class with fully qualified class name(e.g. java.lang.String).
     * @return An identified class name for ECMAScript.
     */
    public static final String computeSimpleClassName(Class clazz) {
        if (clazz == NativeObject.class) {
            return "";
        }

        if (clazz == NativeString.class) {
            clazz = String.class;
        }

        String prefix = "";

        while (clazz.isArray()) {
            prefix += "[";
            clazz = clazz.getComponentType();
        }

        Javascript script = getScript(clazz);

        if (script == null) {
            return clazz.getSimpleName();
        } else {
            return prefix + mung32(script.id);
        }
    }

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
    public static final String computeMethodName(Constructor<?> constructor) {
        return computeMethodName(constructor.getDeclaringClass(), "<init>", Type.getConstructorDescriptor(constructor));
    }

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
    public static final String computeMethodName(Method method) {
        return computeMethodName(method.getDeclaringClass(), method.getName(), Type.getMethodDescriptor(method));
    }

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
        // convert an alias to an actual method name
        if (name.startsWith("$alias$")) {
            name = name.substring(7);
        }

        if (TranslatorManager.isNativeMethod(owner, name, description)) {
            return name;
        }

        if (name.charAt(0) == '<') {
            if (name.charAt(1) == 'c') {
                // class initializer
                return "";
            } else {
                // constructor
                return "$" + order(getScript(owner).constructors, description.hashCode());
            }
        } else {
            // method
            description = JavaAPIProviders.validateMethod(owner, name, description);

            return mung32(order(methods, name.hashCode() ^ description.hashCode()));
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
    public static final String computeFieldName(Field field) {
        return computeFieldName(field.getDeclaringClass(), field.getName());
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
            Field field = owner.getDeclaredField(fieldName);

            // validate field declaration
            JavaAPIProviders.validateField(owner, field);

            Javascript js = getScript(owner);

            return mung16(order(js.fields, fieldName.hashCode() + js.source.hashCode()));
        } catch (NoSuchFieldException e) {
            return computeFieldName(owner.getSuperclass(), fieldName);
        }
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

    /**
     * @version 2013/09/27 15:27:16
     */
    @Manageable(lifestyle = Singleton.class)
    private static class DepenedencyManager implements ClassListener<Require> {

        /** The extensions. */
        private final Set<Class> collection = new HashSet();

        /**
         * {@inheritDoc}
         */
        @Override
        public void load(Class clazz) {
            collection.add(clazz);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void unload(Class clazz) {
            collection.remove(clazz);
        }

        /**
         * <p>
         * Collect all required classes.
         * </p>
         * 
         * @param requirements
         */
        private void add(Class... requirements) {
            Set<Class> list = new HashSet();
            list.addAll(collection);
            list.addAll(Arrays.asList(requirements));

            for (Class clazz : list) {
                if (Extensible.class.isAssignableFrom(clazz)) {
                    for (Class<Extensible> extension : I.collect((Class<Extensible>) clazz)) {
                        require(extension);
                    }
                }
                require(clazz);
            }
        }
    }
}
