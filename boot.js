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
  // Error Extensions
  //====================================================================
  Error.stackTraceLimit = 100;


  //====================================================================
  // Element Extensions
  //====================================================================
  define(Element.prototype, {
  	matchesSelector: Element.prototype.webkitMatchesSelector ? Element.prototype.webkitMatchesSelector
                   : Element.prototype.mozMatchesSelector ? Element.prototype.mozMatchesSelector
                   : Element.prototype.msMatchesSelector
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
      connection.onopen = listener.open.bind(listener);
      connection.onclose = listener.close.bind(listener);
      connection.onerror = listener.error.bind(listener);
      connection.onmessage = function(e) {
        listener.message(e.data);
      };
      return connection;
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
      return this.$.$;
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
      var superclass = superclassName === String ? String : superclassName.length === 0 ? Object : boot[superclassName];

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
          prototype[i] = definition[i];
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
    },

    /**
     * <p>
     * Define properties in javascript native object prototype.
     * </p>
     * 
     * @param {String} names A fully qualified class name of a class to define.
     * @param {Object} properties A property definition.
     */
    defineNative: function(names, properties, superclassName) {
      names.split(" ").forEach(function(name) {
        var clazz = global[name];

        if (clazz) {
          define(clazz.prototype, properties, true);

          if (superclassName) {
            define(clazz.prototype, boot[superclassName].prototype, true);
            define(clazz, boot[superclassName], true);
          }

          if (properties._) {
          	properties._();
          }
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
    definePolyfill: function(name, properties) {
      var prefix = ["", "Moz", "Webkit", "MS"];

      for (var i = 0; i < 4; ++i) {
        var def = global[prefix[i] + name];

        if (def) {
          // use native implementation
          global[name] = def;
          return; 
        }
      }

      // This is actual counstructor of class to define.
      function Class() {
        // Invoke the specified constructor function.
        this.$0.apply(this, arguments);
      }

      // We must store static initialization function.
      var init;

      // We must copy the properties over onto the new prototype.
      // At first, from superclass definition.
      var prototype = Class.prototype = Object.create(Object.prototype);

      // Then, from user defined class definition.
      for (var i in properties) {
        // static method
        if (i.charAt(0) == "_") {
          if (i.length == 1) {
            // invoke static initializer
            init = properties[i];
          } else {
            // define static method
            Class[i.substring(1)] = properties[i];
          }
        } else {
          // define member method
          prototype[i] = properties[i];
        }
      }
      // global[name] = Class;
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

    /**
     * <p>
     * Helper method to chech whether the specified value is Number or not.
     * </p>
     *
     * @param {Object} value The value to test.
     * @return {boolean} The result.
     */
    isNumeric: function(value) {
	  return !isNaN(parseFloat(value)) && isFinite(value);
	},

	/**
     * <p>
     * Helper method to bind a context object of the specified function.
     * </p>
     *
     * @param {String} functionName The property name of the target function.
     * @param {Object} context The context value.
     * @return {Function} The context binded function.
     */
    bind: function(functionName, context) {
	  return context[functionName].bind(context);
	},

    /**
     * <p>
     * Create primitive array with the specified size. (all elements are initialized by 0)
     * </p>
     *
     * @param {Number} size A initila size.
     * @return {Array} A initialized array.
     */
    array: function(elements, className) {
      elements.$ = className;
      return elements;
    },
    
    /**
     * <p>
     * Create array with the specified size. (all elements are initialized by 0 or null)
     * </p>
     *
     * @param {Number} size A initila size.
     * @param {Object} initial A initial value.
     * @return {Array} A initialized array.
     */
    initArray: function(size, initial) {
	  var array = [];
    
      for (var i = 0; i < size; i++) {
        array[i] = initial;
      }
      return array;
    },

    /**
     * <p>
     * Throw native error to build stack trace.
     * </p>
     */
    error: function(a) {
      try {
        a.a;
      } catch (e) {
        return e;
      }
    }
  });
}

// Activate Initialization
boot(Function("return this")());