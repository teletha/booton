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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import js.lang.Global;
import js.lang.NativeObject;
import js.util.jQuery;
import kiss.ClassListener;
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
 * @version 2013/04/12 16:03:36
 */
public class Javascript {

    /** The all cached scripts. */
    private static final Map<Class, Javascript> scripts = I.aware(new ConcurrentHashMap());

    /** The local identifier counter for {@link Javascript}. */
    private static int counter = 0;

    // initialization
    static {
        // Load Booton module
        I.load(Global.class, false);

        // Define Class class at first. It is ensured that Class definition is assigned in 'boot.A'
        // variable.
        getScript(Class.class);
    }

    /** The actual script class to translate. */
    public final Class source;

    /** The flag whether javascript has native class or not. */
    public final boolean isJavascritpNative;

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

    /** The actual Javascript source code to be translated. This is initialized lazy */
    private String code;

    /**
     * Create Javascript as the specified Java class is source.
     * 
     * @param source A Java class as source.
     */
    private Javascript(Class source) {
        this.source = source;
        this.id = counter++;
        this.isJavascritpNative = isJavascriptNative();

        // copy all member fields for override mechanism
        Javascript script = getScript(source.getSuperclass());

        if (script != null) {
            fields.addAll(script.fields);
        }

        for (Field field : source.getDeclaredFields()) {
            order(fields, field.getName().hashCode() + source.hashCode());
        }
    }

    /**
     * <p>
     * Helper method to detect whether this script implements {@link JavascriptNative} directly or
     * not.
     * </p>
     * 
     * @return A result.
     */
    private boolean isJavascriptNative() {
        for (Class type : source.getInterfaces()) {
            if (type == JavascriptNative.class) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Require the specified java source code.
     * </p>
     * 
     * @param dependency A dependency class.
     */
    public void require(Class dependency) {
        dependencies.add(dependency);
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
            writeTo(Files.newBufferedWriter(output, I.$encoding), requirements);
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
        // Any class requires Class class.
        require(Class.class);

        if (requirements != null) {
            for (Class requirement : requirements) {
                require(requirement);
            }
        }

        // Record all defined classes to prevent duplicated definition.
        write(output, new HashSet());

        // Write bootstrap method if needed.
        try {
            Method main = source.getMethod("jsmain");
            String className = Javascript.computeClassName(source);
            String methodName = Javascript.computeMethodName(source, main.getName(), Type.getMethodDescriptor(main));

            output.append("try {");
            if (Modifier.isStatic(main.getModifiers())) {
                output.append(className + "." + methodName + "();");
            } else {
                output.append("new " + className + "(0)." + methodName + "();");
            }
            output.append("} catch(e) {console.log(e)}");
        } catch (Exception e) {
            // do nothing
        }

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

        defined.add(source);

        for (Class depndency : dependencies) {
            if (defined.add(depndency)) {
                Javascript script = Javascript.getScript(depndency);

                // write dependency scripts ahead
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
            ScriptBuffer code = new ScriptBuffer();

            if (isJavascritpNative) {
                compileNative(code);
            } else if (source.isInterface()) {
                compileInterface(code);
            } else {
                compileClass(code, source.getSuperclass());
            }

            // create cache
            this.code = code.toString();
        }
    }

    /**
     * <p>
     * Compile java class to javascript.
     * </p>
     * 
     * @param code
     * @param parent A parent class.
     */
    private void compileClass(ScriptBuffer code, Class parent) {
        if (source.isArray()) {
            return;
        }

        // compute related class names
        String className = Javascript.computeSimpleClassName(source);
        String superClass = parent == null || parent == Object.class ? "" : computeSimpleClassName(parent);

        // write class definition
        code.append("boot.define(").string(className).append(",").string(superClass).append(",", interfaces(), ",");

        // write constructors, fields and methods
        try {
            code.append('{');
            new ClassReader(source.getName()).accept(new JavaClassCompiler(this, code), 0);
            code.append('}');
        } catch (IOException e) {
            throw I.quiet(e);
        }

        // write annotation
        JavaAnnotationCompiler annotation = new JavaAnnotationCompiler(this, source);

        if (annotation.hasAnnotation()) {
            code.append(',').append(annotation);
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
    private void compileInterface(ScriptBuffer code) {
        // compute related class names
        String className = Javascript.computeSimpleClassName(source);

        // write interface definition
        code.append("boot.define(").string(className).append(",\"\",").append(interfaces()).append(",");

        // write constructors, fields and methods
        try {
            code.append('{');
            Method[] methods = source.getDeclaredMethods();

            for (int i = 0; i < methods.length; i++) {
                code.append(computeMethodName(methods[i])).append(":null");

                if (i < methods.length - 1) {
                    code.append(",");
                }
            }
            code.append('}');
        } catch (Exception e) {
            throw I.quiet(e);
        }

        // write annotation
        JavaAnnotationCompiler annotation = new JavaAnnotationCompiler(this, source);

        if (annotation.hasAnnotation()) {
            code.append(',').append(annotation);
        }

        // End class definition
        code.append(");");
        code.line();
    }

    /**
     * <p>
     * Compile java class for {@link JavascriptNative}.
     * </p>
     * 
     * @param code
     */
    private void compileNative(ScriptBuffer code) {
        // Start class definition
        code.append("boot.defineNative(\"").append(source.getSimpleName()).append("\",{");

        try {
            new ClassReader(source.getName()).accept(new JavaClassCompiler(this, code), 0);
        } catch (IOException e) {
            throw I.quiet(e);
        }

        // End class definition
        code.append("});");
    }

    /**
     * <p>
     * Compute interface definition.
     * </p>
     * 
     * @return
     */
    private String interfaces() {
        List<String> list = new ArrayList();

        for (Class type : source.getInterfaces()) {
            if (!JavascriptNative.class.isAssignableFrom(type)) {
                require(type);

                list.add("\"" + computeSimpleClassName(type) + "\"");
            }
        }
        return "[" + I.join(list, ",") + "]";
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
     * Compile the specified Java class to Javascript source code.
     * </p>
     * 
     * @param source A Java class to compile.
     * @return A compiled Javascript source.
     */
    public static final Javascript getScript(Class source) {
        source = JavaAPIProviders.convert(source);

        // check Native Class
        if (source == null || TranslatorManager.hasTranslator(source)) {
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
        if (clazz == Object.class) {
            return "Object";
        }

        if (clazz == Number.class) {
            return "Number";
        }
        return computeClassName(clazz) + ".$";
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
        if (clazz == jQuery.class) {
            return "$";
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
    public static final String computeMethodName(Constructor constructor) {
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
            JavaAPIProviders.validateMethod(owner, name, description);

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

            // transient prefix
            String prefix = Modifier.isTransient(field.getModifiers()) ? "$" : "";

            return prefix + mung16(order(js.fields, fieldName.hashCode() + js.source.hashCode()));
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
     * @version 2013/04/14 14:04:15
     */
    @Manageable(lifestyle = Singleton.class)
    private static class JavaAPIProviders implements ClassListener<JavaAPIProvider> {

        /** The mapping between Java class and JS implementation class. */
        private static final Map<Class, Definition> definitions = new HashMap();

        /**
         * {@inheritDoc}
         */
        @Override
        public void load(Class<JavaAPIProvider> clazz) {
            definitions.put(clazz.getAnnotation(JavaAPIProvider.class).value(), new Definition(clazz));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void unload(Class<JavaAPIProvider> clazz) {
            definitions.remove(clazz.getAnnotation(JavaAPIProvider.class).value());
        }

        /**
         * <p>
         * Convert Java class to Javascript runtime class (normaly, it is simplified).
         * </p>
         * 
         * @param type A target class to convert.
         * @return A converted class.
         */
        private static Class convert(Class type) {
            Definition definition = definitions.get(type);

            return definition == null ? type : definition.clazz;
        }

        /**
         * <p>
         * Validate method implementation in Javascript class.
         * </p>
         * 
         * @param owner
         * @param name
         * @param description
         */
        private static void validateMethod(Class owner, String name, String description) {
            Definition definition = definitions.get(owner);

            if (definition != null && !definition.methods.contains(name + description)) {
                TranslationError error = new TranslationError();
                error.write("You must define the method in " + definition.clazz + ".");
                error.writeMethod(name, Type.getReturnType(description), Type.getArgumentTypes(description));

                throw error;
            }
        }

        /**
         * <p>
         * Validate method implementation in Javascript class.
         * </p>
         * 
         * @param owner
         * @param name
         * @param description
         */
        private static void validateField(Class owner, Field field) {
            Definition definition = definitions.get(owner);

            if (definition != null && !definition.fields.contains(field.getName())) {
                TranslationError error = new TranslationError();
                error.write("You must define the field in ", definition.clazz, ".");
                error.write("");
                error.writeField(field);

                throw error;
            }
        }

        /**
         * <p>
         * Cache for API definitions.
         * </p>
         * 
         * @version 2013/04/14 14:07:33
         */
        private static class Definition {

            /** The actual provider class. */
            private final Class clazz;

            /** The method signatures. */
            private final Set<String> methods = new HashSet();

            /** The method signatures. */
            private final Set<String> fields = new HashSet();

            /**
             * @param clazz
             */
            private Definition(Class clazz) {
                this.clazz = clazz;

                for (Method method : clazz.getMethods()) {
                    methods.add(method.getName() + Type.getMethodDescriptor(method));
                }

                for (Field field : clazz.getFields()) {
                    fields.add(field.getName());
                }
            }
        }
    }
}
