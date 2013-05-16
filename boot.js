"use strict";

function boot(global) {  
  /**
   * Define user properties.
   */
  function define(object, properties, override) {
    if (object) {
      Object.keys(properties).forEach(function(name) {
        if (!object[name] || override) {
          Object.defineProperty(object, name, {
            configurable: false,
            enumerable: false,
            writable: true,
            value: properties[name]
          });
        }
      });
    }
  }

  
  //====================================================================
  // String Extensions
  //====================================================================
  define(String.prototype, {
    /**
     * <p>
     * Returns the runtime class of this Object. The returned Class object is the object
     * that is locked by static synchronized methods of the represented class. 
     * </p>
     *
     * @return String class.
     */
    $: String,
  
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
  define(Array, {
    /**
     * <p>
     * Create primitive array with the specified size. (all elements are initialized by 0)
     * </p>
     *
     * @param {Number} size A initila size.
     * @return {Array} A initialized array.
     */
    create: function(size) {
      var array = [];
    
      for (var i = 0; i < size; i++) {
        array[i] = 0;
      }
      return array;
    },
    
    createTypedArray: function(type, size) {
      var array = [];
      
      for (var i = 0; i < size; i++) {
        array[i] = 0;
      }
      array.$ = type;
      
      return array;
    }
  });
  
  define(Array.prototype, {
    copy: function(from, dest, dfrom, length) {
      for (var i = 0; i < length; i++) {
        dest[dfrom + i] = this[from + i];
      } 
    },

    /**
     * <p>
     * Sort by the specified Java comparator.
     * </p>
     *
     * @param comparator A entry comparator.
     */
    sortBy: function(comparator) {
      this.sort(comparator.compare.bind(comparator));
    },
    
    getClass: function() {
      return new boot.A("[" + this.$, {}, {}, Object, [], 0);
    }
  });
  

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
     * Retrieve the class object.
     * 
     * @return A Class object.
     */
    getClass: function() {
      if (typeof this === "string") return boot.S.$;
      return this.$.$;
    }
  });


  //====================================================================
  // ECMAScript6 Extensions
  //====================================================================



  //====================================================================
  // Booton Debug Extensions
  //====================================================================
  var stacktrace = [];
  
  function debug(clazz, method, invoker) {
    return function() {
      stacktrace.push("start " + clazz + "#" + method);
      var result = invoker.apply(this, arguments);
      stacktrace.pop();

      return result;
    };
  }
  
  //====================================================================
  // Booton Extensions
  //====================================================================
  define(boot, {
    /**
     * <p>
     * Define class in booton core library namespace.
     * </p>
     * 
     * @param {String} name A simple class name of a class to define.
     * @param {String} superclassName A simple parent class name.
     * @param {Array}  interfaces A list of interface name.
     * @param {Object} definition A class definition.
     * @param {Object} annotation A annotation definition.
     */
    define: function(name, superclassName, interfaces, definition, annotation) {
      if (boot[name]) {
        return; // avoid to redefine
      }
    
      // Default superclass is native Object class.
      var superclass = superclassName == String ? String : superclassName.length === 0 ? Object : boot[superclassName];

      // This is actual counstructor of class to define.
      function Class() {
        var params = Array.prototype.slice.call(arguments);
        var name = params.pop();
        
        // Invoke the specified constructor function.
        this["$" + (name in this ? 0 : name)].apply(this, params);
        
        // Return function if this class is functional.
        if (name in this) {
          return function() {
            return this[name].apply(this, arguments);
          }.bind(this);
        }
      }

      // We must store static initialization function.
      var init;

      // We must copy the properties over onto the new prototype.
      // At first, from superclass definition.
      var prototype = Class.prototype = Object.create(superclass.prototype);

      // Then, from user defined class definition.
      for (var i in definition) {
        // static method
        if (i.charAt(0) == "_") {
          if (i.length == 1) {
            // invoke static initializer
            init = definition[i];
          } else {
            // define static method
            Class[i.substring(1)] = definition[i];
          }
        } else {
          // define member method
          prototype[i] = debug(name, i, definition[i]);
        }
      }
      
      // assign "prototype" constructor
      prototype.$ = Class;

      // Expose and define class at global scope.
      if (!init) {
        // The class without static initializer can assign immediately.
        boot[name] = Class;
      } else {
        // This is emuration of Java class initialization.
        // The static initializer must be invoked wheh the class is
        // accessed for the first time. 
        Object.defineProperty(boot, name, {
          configurable: true,
          enumerable: true,
          get: function() {
            // replace property
            Object.defineProperty(boot, name, {
              value: Class
            });

            // invoke static initializer at first time access.
            init.call(Class);
            init = null;

            // API definition
            return Class;
          }
        });
      }

      // Define class metadata as pseudo Class instance.
      // This variable is lazy initialized because define function requires
      // native Class class (it will be "boot.A") in all classes, but Class
      // class can't be defined at first.
      
      // "Class" variable (js function) can't directly have functionalities of
      // (Java) Class class. "Class" variable directly has static methods of the
      // defiend class, if there is method name confliction between these and the
      // instance methods of (java) Class class, we can't resolve it correctly.
      Object.defineProperty(Class, "$", {
        configurable: true,
        get: function() {
          Object.defineProperty(Class, "$", {
            value: new boot.A(name, prototype, annotation || {}, superclass.$, interfaces, 0)
          });
          
          return Class["$"];
        }
      });

      
      Object.defineProperty(Class, "toString", {
        value: function() {
          return "Class " + name;
        }
      });
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
     * Helper method for Runnable interface.
     * </p>
     * 
     * @param {String} name A fully qualified class name of a class to define.
     * @param {Object} properties A property definition.
     */
    functionalize: function(runnable) {
      return runnable.run.bind(runnable);
    },
    
    /**
     * <p>
     * Helper method to define property descriptor for Java environment.
     * </p>
     *
     * @parma {Object} object The object on which to define the property.
     * @param {String} name A fully qualified name of a property to define.
     * @param {Object} descriptor A property descriptor.
     */
    defineProperty: function(object, name, descriptor) {
      descriptor.get = descriptor.get.bind(descriptor);
      descriptor.set = descriptor.set.bind(descriptor);

      Object.defineProperty(object, name, descriptor);
    },
    
    /**
     * <p>
     * Helper method to chech whether the specified value is String or not.
     * </p>
     *
     * @param {Object} value The value to test.
     * @return {boolean} The result.
     */
    isString: function(value) {
      return typeof value === "string" || value instanceof String;
    },

    printStackTrace: function() {
      console.log(stacktrace);
    }
  });
}

// Activate Initialization
boot(Function("return this")());
