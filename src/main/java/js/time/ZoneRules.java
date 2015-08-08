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

import java.time.zone.ZoneOffsetTransitionRule;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @version 2015/08/08 16:35:39
 */
// @JavaAPIProvider(java.time.zone.ZoneRules.class)
class ZoneRules {

    /**
     * The last year to have its transitions cached.
     */
    private static final int LAST_CACHED_YEAR = 2100;

    /**
     * The transitions between standard offsets (epoch seconds), sorted.
     */
    private final long[] standardTransitions;

    /**
     * The standard offsets.
     */
    private final ZoneOffset[] standardOffsets;

    /**
     * The transitions between instants (epoch seconds), sorted.
     */
    private final long[] savingsInstantTransitions;

    /**
     * The transitions between local date-times, sorted. This is a paired array, where the first
     * entry is the start of the transition and the second entry is the end of the transition.
     */
    private final LocalDateTime[] savingsLocalTransitions;

    /**
     * The wall offsets.
     */
    private final ZoneOffset[] wallOffsets;

    /**
     * The last rule.
     */
    private final ZoneOffsetTransitionRule[] lastRules;

    /**
     * The map of recent transitions.
     */
    private final transient ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache = new ConcurrentHashMap<Integer, ZoneOffsetTransition[]>();

    /**
     * The zero-length long array.
     */
    private static final long[] EMPTY_LONG_ARRAY = new long[0];

    /**
     * The zero-length lastrules array.
     */
    private static final ZoneOffsetTransitionRule[] EMPTY_LASTRULES = new ZoneOffsetTransitionRule[0];

    /**
     * The zero-length ldt array.
     */
    private static final LocalDateTime[] EMPTY_LDT_ARRAY = new LocalDateTime[0];

    /**
     * Creates an instance.
     *
     * @param baseStandardOffset the standard offset to use before legal rules were set, not null
     * @param baseWallOffset the wall offset to use before legal rules were set, not null
     * @param standardOffsetTransitionList the list of changes to the standard offset, not null
     * @param transitionList the list of transitions, not null
     * @param lastRules the recurring last rules, size 16 or less, not null
     */
    ZoneRules(ZoneOffset baseStandardOffset, ZoneOffset baseWallOffset, List<ZoneOffsetTransition> standardOffsetTransitionList, List<ZoneOffsetTransition> transitionList, List<ZoneOffsetTransitionRule> lastRules) {
        super();

        // convert standard transitions

        this.standardTransitions = new long[standardOffsetTransitionList.size()];

        this.standardOffsets = new ZoneOffset[standardOffsetTransitionList.size() + 1];
        this.standardOffsets[0] = baseStandardOffset;
        for (int i = 0; i < standardOffsetTransitionList.size(); i++) {
            this.standardTransitions[i] = standardOffsetTransitionList.get(i).toEpochSecond();
            this.standardOffsets[i + 1] = standardOffsetTransitionList.get(i).getOffsetAfter();
        }

        // convert savings transitions to locals
        List<LocalDateTime> localTransitionList = new ArrayList<>();
        List<ZoneOffset> localTransitionOffsetList = new ArrayList<>();
        localTransitionOffsetList.add(baseWallOffset);
        for (ZoneOffsetTransition trans : transitionList) {
            if (trans.isGap()) {
                localTransitionList.add(trans.getDateTimeBefore());
                localTransitionList.add(trans.getDateTimeAfter());
            } else {
                localTransitionList.add(trans.getDateTimeAfter());
                localTransitionList.add(trans.getDateTimeBefore());
            }
            localTransitionOffsetList.add(trans.getOffsetAfter());
        }
        this.savingsLocalTransitions = localTransitionList.toArray(new LocalDateTime[localTransitionList.size()]);
        this.wallOffsets = localTransitionOffsetList.toArray(new ZoneOffset[localTransitionOffsetList.size()]);

        // convert savings transitions to instants
        this.savingsInstantTransitions = new long[transitionList.size()];
        for (int i = 0; i < transitionList.size(); i++) {
            this.savingsInstantTransitions[i] = transitionList.get(i).toEpochSecond();
        }

        // last rules
        if (lastRules.size() > 16) {
            throw new IllegalArgumentException("Too many transition rules");
        }
        this.lastRules = lastRules.toArray(new ZoneOffsetTransitionRule[lastRules.size()]);
    }

    /**
     * Constructor.
     *
     * @param standardTransitions the standard transitions, not null
     * @param standardOffsets the standard offsets, not null
     * @param savingsInstantTransitions the standard transitions, not null
     * @param wallOffsets the wall offsets, not null
     * @param lastRules the recurring last rules, size 15 or less, not null
     */
    private ZoneRules(long[] standardTransitions, ZoneOffset[] standardOffsets, long[] savingsInstantTransitions, ZoneOffset[] wallOffsets, ZoneOffsetTransitionRule[] lastRules) {
        super();

        this.standardTransitions = standardTransitions;
        this.standardOffsets = standardOffsets;
        this.savingsInstantTransitions = savingsInstantTransitions;
        this.wallOffsets = wallOffsets;
        this.lastRules = lastRules;

        if (savingsInstantTransitions.length == 0) {
            this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        } else {
            // convert savings transitions to locals
            List<LocalDateTime> localTransitionList = new ArrayList<>();
            for (int i = 0; i < savingsInstantTransitions.length; i++) {
                ZoneOffset before = wallOffsets[i];
                ZoneOffset after = wallOffsets[i + 1];
                ZoneOffsetTransition trans = new ZoneOffsetTransition(savingsInstantTransitions[i], before, after);
                if (trans.isGap()) {
                    localTransitionList.add(trans.getDateTimeBefore());
                    localTransitionList.add(trans.getDateTimeAfter());
                } else {
                    localTransitionList.add(trans.getDateTimeAfter());
                    localTransitionList.add(trans.getDateTimeBefore());
                }
            }
            this.savingsLocalTransitions = localTransitionList.toArray(new LocalDateTime[localTransitionList.size()]);
        }
    }

    /**
     * Creates an instance of ZoneRules that has fixed zone rules.
     *
     * @param offset the offset this fixed zone rules is based on, not null
     * @return the zone rules, not null
     * @see #isFixedOffset()
     */
    private ZoneRules(ZoneOffset offset) {
        this.standardOffsets = new ZoneOffset[1];
        this.standardOffsets[0] = offset;
        this.standardTransitions = EMPTY_LONG_ARRAY;
        this.savingsInstantTransitions = EMPTY_LONG_ARRAY;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = standardOffsets;
        this.lastRules = EMPTY_LASTRULES;
    }

    /**
     * Obtains an instance of a ZoneRules.
     *
     * @param baseStandardOffset the standard offset to use before legal rules were set, not null
     * @param baseWallOffset the wall offset to use before legal rules were set, not null
     * @param standardOffsetTransitionList the list of changes to the standard offset, not null
     * @param transitionList the list of transitions, not null
     * @param lastRules the recurring last rules, size 16 or less, not null
     * @return the zone rules, not null
     */
    public static ZoneRules of(ZoneOffset baseStandardOffset, ZoneOffset baseWallOffset, List<ZoneOffsetTransition> standardOffsetTransitionList, List<ZoneOffsetTransition> transitionList, List<ZoneOffsetTransitionRule> lastRules) {
        Objects.requireNonNull(baseStandardOffset, "baseStandardOffset");
        Objects.requireNonNull(baseWallOffset, "baseWallOffset");
        Objects.requireNonNull(standardOffsetTransitionList, "standardOffsetTransitionList");
        Objects.requireNonNull(transitionList, "transitionList");
        Objects.requireNonNull(lastRules, "lastRules");
        return new ZoneRules(baseStandardOffset, baseWallOffset, standardOffsetTransitionList, transitionList, lastRules);
    }

    /**
     * Obtains an instance of ZoneRules that has fixed zone rules.
     *
     * @param offset the offset this fixed zone rules is based on, not null
     * @return the zone rules, not null
     * @see #isFixedOffset()
     */
    public static ZoneRules of(ZoneOffset offset) {
        Objects.requireNonNull(offset, "offset");
        return new ZoneRules(offset);
    }
}
