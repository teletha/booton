// replace timer related functions
window.setTimeout = Chronus.setTimeout;
window.clearTimeout = Chronus.clearTimeout;

Intl = {
  DateTimeFormat: DateTimeFormat
};

/**
 * Polyfill for matches(selector).
 */
Element.prototype.matches = function(selector) {
  var elements = document.querySelectorAll(selector);

  for (var i=0, length=elements.length; i<length; i++) {
    if (elements[i] === this) {
      return true;
    }
  }
  return false;
};
