/*
 * Copyright (C) 2015 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package js.time;

import java.time.ZoneOffset;
import java.time.zone.ZoneRulesException;
import java.time.zone.ZoneRulesProvider;

/**
 * @version 2014/04/29 9:49:42
 */
// @JavaAPIProvider(java.time.ZoneId.class)
abstract class ZoneId {

    // -----------------------------------------------------------------------
    /**
     * Gets the unique time-zone ID.
     * <p>
     * This ID uniquely defines this object. The format of an offset based ID is defined by
     * {@link ZoneOffset#getId()}.
     *
     * @return the time-zone unique ID, not null
     */
    public abstract String getId();

    /**
     * Gets the time-zone rules for this ID allowing calculations to be performed.
     * <p>
     * The rules provide the functionality associated with a time-zone, such as finding the offset
     * for a given instant or local date-time.
     * <p>
     * A time-zone can be invalid if it is deserialized in a Java Runtime which does not have the
     * same rules loaded as the Java Runtime that stored it. In this case, calling this method will
     * throw a {@code ZoneRulesException}.
     * <p>
     * The rules are supplied by {@link ZoneRulesProvider}. An advanced provider may support dynamic
     * updates to the rules without restarting the Java Runtime. If so, then the result of this
     * method may change over time. Each individual call will be still remain thread-safe.
     * <p>
     * {@link ZoneOffset} will always return a set of rules where the offset never changes.
     *
     * @return the rules, not null
     * @throws ZoneRulesException if no rules are available for this ID
     */
    public abstract ZoneRules getRules();

    /**
     * Checks if this time-zone ID is equal to another time-zone ID.
     * <p>
     * The comparison is based on the ID.
     *
     * @param obj the object to check, null returns false
     * @return true if this is equal to the other time-zone ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            ZoneId other = (ZoneId) obj;
            return getId().equals(other.getId());
        }
        return false;
    }

    /**
     * A hash code for this time-zone ID.
     *
     * @return a suitable hash code
     */
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
