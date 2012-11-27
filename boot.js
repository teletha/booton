boot = {};

/**
 * <p>
 * Define class in booton core library namespace.
 * </p>
 * 
 * @param {String} subclassName A fully qualified class name of a class to defien.
 * @param {String} superclassName A fully qualified class name of super class.
 * @param {Object} subclass A class definition.
 */
boot.defineClass = function(superclass, subclass) {
	// default superclass is Object class
	if (!subclass) {
		subclass = superclass;
		superclass = Object;
	}

	var subclassPrototype;

	// F is a temporary constructor. It have the prototype of superclass, and doesn't have the
	// unnecessary (perhaps it will produce an
	// evil) initialization executable code.
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
				subclass[i].call(Class);
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

	// API definition
	return Class;
};

/**
 * <p>
 * Create new Array object from the specified Array-like object.
 * </p>
 * 
 * @param {Object} object
 * @return {Array} A new created Array.
 */
boot.toArray = function(object) {
	var result = [];

	if (object != null) {
		var i = object.length;

		while (i) {
			result[--i] = object[i];
		}
	}

	// API definition
	return result;
};

/**
 * <h2>String Method Enhancement</h2>
 * <p>
 * Booton enhances the built-in class, except for Object and Array.
 * </p>
 */
if (!String.prototype.trim) {
	/**
	 * <p>
	 * The trim method returns the string stripped of whitespace from both ends. trim does not
	 * affect the value of the string itself.
	 * </p>
	 * 
	 * @return {String}
	 */
	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, "");
	};

	/**
	 * <p>
	 * The trimRight method returns the string stripped of whitespace from its right end. trimRight
	 * does not affect the value of the string itself.
	 * </p>
	 * 
	 * @return {String}
	 */
	String.prototype.trimRight = function() {
		return this.replace(/\s+$/, "");
	};

	/**
	 * <p>
	 * The trimLeft method returns the string stripped of whitespace from its left end. trimLeft
	 * does not affect the value of the string itself.
	 * </p>
	 * 
	 * @return {String}
	 */
	String.prototype.trimLeft = function() {
		return this.replace(/^\s+/, "");
	};
}

if (!String.prototype.endsWith) {
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
	String.prototype.startsWith = function(prefix) {
		return prefix.length <= this.length && prefix == this.substring(0, prefix.length);
	};

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
	String.prototype.endsWith = function(suffix) {
		return suffix.length <= this.length && suffix == this.slice(~suffix.length + 1);
	};
}