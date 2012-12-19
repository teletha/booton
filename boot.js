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
  // Object Extensions
  //====================================================================
  // Global object identifier
  var hashcode = 0;
  
  define(Object.prototype, {
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
    }
  });

  //====================================================================
  // ECMAScript6 Extensions
  //====================================================================
  
  
  //====================================================================
  // Booton Extensions
  //====================================================================
  define(boot, {
    /**
     * <p>
     * Create new Array object from the specified Array-like object.
     * </p>
     * 
     * @param {Object} object
     * @return {Array} A new created Array.
     */
    toArray: function(object) {
      var result = [];

      if (object != null) {
        var i = object.length;

        while (i) {
          result[--i] = object[i];
        }
      }

      // API definition
      return result;
    },
    
    /**
     * <p>
     * Define class in booton core library namespace.
     * </p>
     * 
     * @param {String} subclassName A fully qualified class name of a class to defien.
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
      var subclassPrototype;

      // F is a temporary constructor. It have the prototype of superclass, and does not have the
      // unnecessary (perhaps it will produce an evil) initialization executable code.
      function F() {
      }

      F.prototype = superclass.prototype;

      // We must copy the properties over onto the new prototype.
      // At first, from superclass definition.
      subclassPrototype = new F();
      subclassPrototype.constructor = Class; // Class is defined later
      // Then, from user defined subclass definition.
      for ( var i in subclass) {
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
          subclassPrototype[i] = subclass[i];
        }
      }

      // This is actual counstructor of the specified subclass.
      function Class() {
        var params = boot.toArray(arguments);
      
        // invoke specified constructor
        this["$" + params.pop()].apply(this, params);
      }

      Class.prototype = subclassPrototype;
      
      boot[name] = Class;

      // API definition
      if (init) init.call(Class);
    },

    /**
     * <p>
     * Define properties in javascript native object prototype.
     * </p>
     * 
     * @param {String} name A fully qualified class name of a class to defien.
     * @param {Object} properties A property definition.
     */
    defineNative: function(name, properties) {
      if (global[name]) {
        define(global[name].prototype, properties);
      }
    }
  });
}

// Activate Initialization
boot(Function("return this")());
