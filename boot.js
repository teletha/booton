"use strict";

function boot(global) {  
  /**
   * Define user properties.
   */
  function define(object, properties) {
    Object.keys(properties).forEach(function(name) {
      if (!object[name]) {
        Object.defineProperty(object, name, {
          configurable: false,
          enumerable: false,
          writable: true,
          value: properties[name]
        });
      }
    });
  }
  
  //====================================================================
  // String Extensions
  //====================================================================
  define(String.prototype, {
    /**
     * Retrieve the object identifier.
     *
     * @return An identifier.
     */
    hashCode: function() {
      if (this.$hashCode !== undefined) return this.$hashCode;

      var hash = 0;
      
      for (var i = 0; i < this.length; i++) {
        hash = 31 * hash + this.charCodeAt(i);
      }
      return this.$hashCode = hash;
    },

    /**
     * <p>
     * Tests if this string starts with the specified prefix.
     * </p>
     * 
     * @param {String} prefix A prefix to test.
     * @return {boolean} true if the character sequence represented by the argument is a prefix of
     *         the character sequence represented by this string; false otherwise. Note also that
     *         true will be returned if the argument is an empty string or is equal to this String
     *         object as determined by the equals(Object) method.
     */
    startsWith: function(prefix) {
        return prefix.length <= this.length && prefix == this.substring(0, prefix.length);
    },

    /**
     * <p>
     * Tests if this string ends with the specified suffix.
     * </p>
     * 
     * @param {String} suffix A suffix to test.
     * @return {boolean} <code>true</code> if the character sequence represented by the argument
     *         is a suffix of the character sequence represented by this object; false otherwise.
     *         Note that the result will be true if the argument is the empty string or is equal to
     *         this String object as determined by the equals(Object) method.
     */
    endsWith: function(suffix) {
        return suffix.length <= this.length && suffix == this.slice(~suffix.length + 1);
    }
  });

  //====================================================================
  // Array Extensions
  //====================================================================

  //====================================================================
  // WebSocket Extensions
  //====================================================================
  define(WebSocket, {
    /**
     * Establish connection by WebSocket.
     */
    connect: function(uri, listener) {
      var connection = new WebSocket(uri);
      connection.onopen = listener.open;
      connection.onclose = listener.close;
      connection.onerror = listener.error;
      connection.onmessage = listener.message;
    }
  });

  
  //====================================================================
  // Object Extensions
  //====================================================================
  // Global object identifier
  var hashcode = 0;
  
  define(Object.prototype, {
    /** The Class metadata for reflection. */
    $: 1,
  
    /** The identifier for this object. */
    $hashCode: undefined,
  
    /**
     * Retrieve the object identifier.
     *
     * @return An identifier.
     */
    hashCode: function() {
      return this.$hashCode !== undefined ? this.$hashCode : this.$hashCode = hashcode++;
    },
    
    /**
     * Test whether this object is equals to the specified object or not.
     *
     * @param other A test object.
     * @return A result.
     */
    equals: function(other) {
      return this == other;
    },

    /**
     * Create object expression.
     *
     * @return A string expression.
     */
    toString: function() {
      return this.constructor.name + "#" + this.hashCode();
    },

    /**
     * List up all property keys.
     *
     * @return A property name array.
     */ 
    keys: function() {
      return Object.keys(this);
    },
    
    /**
     * Retrieve the class object.
     * 
     * @return A Class object.
     */
    getClass: function() {
      return this.constructor;
    }
  });
  
  //====================================================================
  // Class Extensions
  //====================================================================
  var Clazz = {
    /**
     * Actual class name.
     */
    $Name: name,
    
    /**
     * Create new instatnce of this class.
     *
     * @param id A constructor id.
     * @param args An array of arguments.
     * @return A created instance.
     */
    newInstance: function(id, args) {
      args = args || [];
      args.push(id);

      var instance = Object.create(this.prototype);
      this.apply(instance, args);
      return instance;
    },

    getMethods: function() {
      var methods = [];
      var that = this.prototype;
      
      Object.keys(that).forEach(function(name) {
        var property = that[name];
          
        if (!name.startsWith("$") && jQuery.isFunction(property)) {
          methods.push(property);
        }
      });

      return methods;
    }
  };

  //====================================================================
  // ECMAScript6 Extensions
  //====================================================================
  
  
  //====================================================================
  // Booton Extensions
  //====================================================================
  define(boot, {
    /**
     * <p>
     * Define class in booton core library namespace.
     * </p>
     * 
     * @param {String} subclassName A fully qualified class name of a class to define.
     * @param {String} superclassName A fully qualified class name of super class.
     * @param {Object} subclass A class definition.
     */
    define: function(name, superclass, subclass) {
      // default superclass is Object class
      if (!subclass) {
        subclass = superclass;
        superclass = Object;
      }

      var init;

      // This is actual counstructor of the specified subclass.
      function Class() {
        var params = Array.prototype.slice.call(arguments);

        // invoke specified constructor
        this["$" + params.pop()].apply(this, params);
      }

      // We must copy the properties over onto the new prototype.
      // At first, from superclass definition.
      var prototype = Class.prototype = Object.create(superclass.prototype);
      prototype.constructor = Class;

      // Then, from user defined subclass definition.
      for (var i in subclass) {
        // static method
        if (i.charAt(0) == "_") {
          if (i.length == 1) {
            // invoke static initializer
            init = subclass[i];
          } else {
            // define static method
            Class[i.substring(1)] = subclass[i];
          }
        } else {
          // define member method
          prototype[i] = subclass[i];
          subclass[i].$Name = i;
        }
      }

      boot[name] = Class;

      define(Class, {
        _: new boot.A(name, Class, 0)
      });
      

      // API definition
      if (init) init.call(Class);
    },

    /**
     * <p>
     * Define properties in javascript native object prototype.
     * </p>
     * 
     * @param {String} name A fully qualified class name of a class to define.
     * @param {Object} properties A property definition.
     */
    defineNative: function(name, properties) {
      if (global[name]) {
        define(global[name].prototype, properties);
      }
    },

    /**
     * <p>
     * Define annotation with class definition.
     * </p>
     * 
     * @param {String} name A fully qualified class name of a class to define.
     * @param {Object} properties A property definition.
     */
    defineAnnotation: function(name, definition) {
      boot[name].$A = definition;
    }
  });
}

// Activate Initialization
boot(Function("return this")());
