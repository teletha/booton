"use strict";

function boot(global) {  
  /**
   * Define user properties.
   */
  function define(object, properties) {
    if (object) {
      Object.keys(properties).forEach(function(name) {
        if (name != "$") {
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
  // Booton Core Library
  //====================================================================
  define(boot, {
    /**
     * <p>
     * Define class in booton core library namespace.
     * </p>
     * 
     * @param {String} name A simple class name of a class to define.
     * @param {String} superClassName A simple parent class name.
     * @param {Array}  interfaces A list of interface name.
     * @param {Object} definition A class definition.
     * @param {Object} annotation A annotation definition.
     * @param {} nativeClasses
     */
    define: function(name, superClassName, interfaces, definition, annotation, nativeClasses) {
      if (boot.hasOwnProperty(name)) {
        return;
      }
    
      // Default superClass is native Object class.
      var superClass = superClassName.length === 0 ? Object : boot[superClassName];

      // This is actual counstructor of class to define.
      function Class() {
        var params = Array.prototype.slice.call(arguments);
        var name = params.pop();
        
        // Invoke the specified constructor function.
        this["$" + name].apply(this, params);
      }

      // We must store static initialization function.
      var init;

      // We must copy the properties over onto the new prototype.
      // At first, from superClass definition.
      var prototype = Class.prototype = Object.create(superClass.prototype);

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
            value: new boot.A(name, prototype, annotation || {}, superClass.$, interfaces, 0)
          });
          return Class["$"];
        }
      });
      
      // Imports Java-defined methods for Native Class. (i.e. Window, Element, WebStorage etc...)
      if (nativeClasses) {
        nativeClasses.split(" ").forEach(function(nativeClass) {
          var clazz = global[nativeClass];

          if (clazz) {
            define(clazz.prototype, Class.prototype);
            define(clazz, Class);

            // define function uses not "for-in loop" but "Object.keys" to enumerate properties,
            // so Class.prototype property hides prototype chained properties.
            // The class which has class-tree (i.e. Element <- Node) must also imports methods
            // from super class.
            if (superClass != Object) {
              define(clazz.prototype, superClass.prototype);
            }
          }
        });
      }
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
     * Initialize the specified array. (all elements are initialized by 0, false or null)
     * </p>
     *
     * @param {String} type A type of new array.
     * @param {Array or Number} array A new array or A length of new array.
     * @param {Object} initia A initial item value of new array.
     * @return {Array} A initialized array.
     */
    array: function(type, array, initial) {
	    if (initial !== undefined) {
	      var length = array, array = [], i = 0;
	      
        for (; i < length; i++) {
          array[i] = initial;
        }
	    }
	    
	    // set Class information
	    array.$ = "[" + type;
    
      // API definition
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