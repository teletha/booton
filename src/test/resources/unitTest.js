/*
 * Copyright (C) 2016 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
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

window.performance = new Performance();
