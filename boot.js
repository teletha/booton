/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
"use strict";

//====================================================================
// Global Functions
//====================================================================
/**
 * Create the instance of the specified functional interface.
 *
 * @param {Class} interfaceClass An interface class.
 * @param {String} interfaceMethodName A single abstract method name.
 * @param {String} lambdaMethodName A lambda method name.
 * @param {Object} lambdaMethodHolder A lambda method holder object. This is optional.
 * @param {Array} params A list of parameters. This is optional.
 * @return {Object} A created instance of the specified functional interface.
 */
function λ(interfaceClass, interfaceMethodName, lambdaMethodName, lambdaMethodHolder, params) {
  // create lambda instance from interface definition
  var lambda = Object.create(interfaceClass.prototype);
  
  if (lambdaMethodName.charAt(0) === '$') {
    // for constructor
    lambda[interfaceMethodName] = function() {
      // create new instance
      var instance = Object.create(lambdaMethodHolder);
      
      // invoke constructor
      instance[lambdaMethodName].apply(instance, arguments);
      
      // return it
      return instance;
    };    
  } else {
    // for method
    if (lambdaMethodHolder !== undefined) {
      // assign lambda method with partial application (context and parameters)
      lambda[interfaceMethodName] = Function.prototype.bind.apply(lambdaMethodHolder[lambdaMethodName], [lambdaMethodHolder].concat(params));
    } else {
      lambda[interfaceMethodName] = function() {
        var args = Array.prototype.slice.call(arguments);
        
        return args[0][lambdaMethodName].apply(args.shift(), args);
      };
    }
  }
  return lambda;
}

/**
 * Initialize the specified array. (all elements are initialized by 0, false or null)
 *
 * @param {String} type A type of new array.
 * @param {Array or Number} array A new array or A length of new array.
 * @param {Object} initia A initial item value of new array.
 * @return {Array} A initialized array.
 */
function Φ(type, array, initial) {
  // fill by initial value if needed
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
}


function boot(global) {  
  /**
   * Define user properties.
   */
  function define(object, properties, protect) {
    if (object) {
      Object.keys(properties).forEach(function(name) {
        if (name != "$" && (!protect || !object[name])) {
          Object.defineProperty(object, name, {
            configurable: false,
            enumerable: protect,
            writable: true,
            value: properties[name]
          });
        }
      });
    }
  }


  //====================================================================
  // Map Extensions
  //====================================================================



  //====================================================================
  // Error Extensions
  //====================================================================
  Error.stackTraceLimit = 100;
  
  
  //====================================================================
  // Window Extensions
  //====================================================================
  window.requestAnimationFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame;
  window.language = window.navigator.userLanguage || window.navigator.language || window.navigator.browserLanguage;


  //====================================================================
  // Element Extensions
  //====================================================================
  define(Element.prototype, {
  	matches: Element.prototype.webkitMatchesSelector
          || Element.prototype.mozMatchesSelector
          || Element.prototype.msMatchesSelector
  }, true);

  
  //====================================================================
  // SVGElement Extensions
  //====================================================================
  // For IE
  define(SVGElement.prototype, {
  	getElementsByClassName: HTMLElement.prototype.getElementsByClassName
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
     * @param {Object} definition A class definition.
     * @param {Object} metadata A metadata definition.
     * @param {} nativeClass A native object name.
     */
    define: function(name, superClassName, interfaces, definition, metadata, nativeClass) {
      if (boot.hasOwnProperty(name)) {
        return;
      }
    
      // Default superClass is javascript native Object.
      var superClass = boot.direct[superClassName] || Object;

      // This is actual counstructor of class to define.
      function Class() {
        // Invoke the specified constructor function.
        this["$" + arguments[arguments.length - 1]].apply(this, arguments);
      }

      // We must store static initialization function.
      var init;

      // We must copy the properties over onto the new prototype.
      // At first, from superClass definition.
      var prototype = Class.prototype = Object.create(superClass.prototype);
      
      var types = interfaces.split(" ");
      
      for (var i = 0; i < types.length; i++) {
        var interfaceClass = boot[types[i]];
        
        if (interfaceClass) {
          define(prototype, interfaceClass.prototype, true);
        }
      }

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
      
      // bypass mapping to avoid invoking static initializer when some class extends this class
      boot.direct[name] = Class;

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
            init();
            init = null;

            // API definition
            return Class;
          }
        });
      }
      
      // real name mapping
      boot.names[metadata.$[1]] = name;

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
            value: new boot.A(name, prototype, metadata.$, superClass.$, metadata, 0)
          });
          return Class["$"];
        }
      });
      
      // Imports Java-defined methods for Native Class. (i.e. Window, Element, WebStorage etc...)
      if (nativeClass) {
        var clazz = global[nativeClass];

        if (clazz) {
          define(clazz.prototype, Class.prototype);
          
          // FIXME: Object.$ causes "too much recursion error".
          // This is temporary solution.
          if (clazz !== Object) {
            Object.defineProperty(clazz, "$", {
              configurable: true,
              get: function() {
                return Class.$;
              }
            });
          }

          // define function uses not "for-in loop" but "Object.keys" to enumerate properties,
          // so Class.prototype property hides prototype chained properties.
          // The class which has class-tree (i.e. Element <- Node) must also imports methods
          // from super class.
          while (superClass != Object) {
            define(clazz.prototype, superClass.prototype, true);
            
            superClass = superClass.super;
          }
        } else {
          // extension class
          boot.extensions.push(Class);
        }
      }
      
      Class.super = superClass;
    },
    
    /**
     * <p>
     * Helper property to map from the specified Java class name to javascript runtime class name.
     * </p>
     */
    names: {},
    direct: {},
        
    /**
     * <p>
     * Helper property to hold extension classes.
     * </p>
     */
    extensions: [],

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
     * Helper method to call delegator function.
     * </p>
     *
     * @param {Function} delegator The delegator function.
     * @param {Object} instance The actual delegator instance.
     * @return {Function} The delegated function with lexical scope.
     */
	  delegate: function(delegator, instance) {
	    return function() {
	      return delegator.call(instance, this, arguments);
	    };
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
