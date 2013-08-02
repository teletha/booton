/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Status.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jsx.bwt.widget.EventHub;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableResolver;

/**
 * @version 2013/03/28 23:46:05
 */
public class Build extends EventHub implements StatusCalculator {

    /** The selected champion. */
    public Champion champion;

    /** The version. */
    private Version version = Version.Latest;

    /** The level. */
    private int level = 1;

    /** The item list. */
    private Item[] items = new Item[6];

    /** The item list. */
    private int[] itemCounts = {1, 1, 1, 1, 1, 1};

    /** The skill order. */
    private int[] skills = new int[18];

    /** The skill level. */
    private int[] skillLevel = {0, 0, 0, 0, 0};

    /** The skill level. */
    private boolean[] skillActivation = {false, false, false, false, false};

    /** The mastery. */
    private MasterySet mastery;

    /** The rune list. */
    private List<Rune> marks = new ArrayList();

    /** The rune list. */
    private List<Rune> glyphs = new ArrayList();

    /** The rune list. */
    private List<Rune> seals = new ArrayList();

    /** The rune list. */
    private List<Rune> quintessences = new ArrayList();

    /** The first cache for computed value. */
    private List<Computed> cache = new ArrayList(Status.values().length);

    /**
     * @param champion
     */
    public Build(Champion champion) {
        this.champion = champion;

        for (int i = 0; i < 5; i++) {
            skillLevel[i] = champion.skills[i].getMinLevel();
        }

        items[0] = Item.LastWhisper;
        items[1] = Item.LichBane;
        items[2] = Item.GuinsoosRageblade;
        items[3] = Item.TrinityForce;
        items[4] = Item.RabadonsDeathcap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLevel(Skill skill) {
        return skillLevel[skill.key.ordinal()];
    }

    /**
     * Set the level property of this {@link Build}.
     * 
     * @param level The level value to set.
     */
    public void setLevel(int level) {
        if (0 < level && level < 19) {
            this.level = level;

            publish(this);
        }
    }

    /**
     * Get the patch property of this {@link Build}.
     * 
     * @return The patch property.
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Set the patch property of this {@link Build}.
     * 
     * @param version The patch value to set.
     */
    public void setVersion(Version version) {
        if (version != null) {
            this.version = version;

            publish(this);
        }
    }

    /**
     * <p>
     * Compute build status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    public Computed get(Status status) {
        // Computed value = cache.get(status.ordinal());
        //
        // if (value != null) {
        // return value;
        // }

        switch (status) {
        case BaseAD:
            return new Computed(0, get(AD).base, status);

        case Lv:
            return new Computed(level, level, Lv);

        case DealtDamageRatio:
        case Tenacity:
            return new Computed(base(status), sum(status), status);

        case MissingManaPercentage:
        case MissingHealthPercentage:
        case TargetAP:
        case TargetMaxHealthRatio:
        case TargetCurrentHealthRatio:
        case TargetMissingHealthRatio:
        case TargetMissingHealthPercentage:
        case AttackDamageRatio:
        case CurrentManaRatio:
        case Stack:
        case ConsumedStack:
        case Duration:
        case Energy:
        case Ereg:
        case EnemyChampion:
        case Time:
            return new Computed(0, 0, status);

        case BounusAD:
            return new Computed(0, get(AD).increased, status);

        case BounusAR:
            return new Computed(0, get(AR).increased, status);

        case BounusMR:
            return new Computed(0, get(MR).increased, status);

        case BounusHealth:
            return new Computed(0, get(Health).increased, status);

        case BounusMS:
            return new Computed(0, get(MS).increased, status);

        case MS:
            double baseMS = base(status);
            double computedMS = (baseMS + sum(status) + sum(MSPerLv) * level) * (1 + sum(MSRatio) / 100);

            // calcurate movement speed cap
            if (490 < computedMS) {
                computedMS = computedMS * 0.5 + 230;
            } else if (415 < computedMS) {
                computedMS = computedMS * 0.8 + 83;
            } else if (computedMS < 220) {
                computedMS = computedMS * 0.5 + 110;
            }
            return new Computed(baseMS, computedMS, status);

        case AS:
            double baseAS = champion.getStatus(version).get(AS);
            double levelAS = champion.getStatus(version).get(ASPerLv) * (level - 1);

            return new Computed(baseAS * (1 + levelAS / 100), Math.min(2.5, baseAS * (1 + (levelAS + sum(ASRatio)) / 100)), status);

        default:
            double base = base(status);
            double computed = (base + sum(status) + sum(status.per()) * level) * (1 + sum(status.ratio()) / 100);

            return new Computed(base, computed, status);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculate(Status status) {
        return get(status).value;
    }

    public Item getItem(int index) {
        return items[index];
    }

    /**
     * <p>
     * Set item.
     * </p>
     * 
     * @param index A index to store item.
     * @param item A item to store.
     */
    public void setItem(int index, Item item) {
        if (0 <= index && index <= 5) {
            items[index] = item;
            itemCounts[index] = 1;

            publish(this);
        }
    }

    /**
     * <p>
     * Increase skill level.
     * </p>
     * 
     * @param skill
     */
    public void up(Skill skill) {
        int index = skill.key.ordinal();
        int now = skillLevel[index];

        if (now < skill.getMaxLevel()) {
            skillLevel[index] = now + 1;

            publish(this);
        }
    }

    /**
     * <p>
     * Decrease skill level.
     * </p>
     * 
     * @param skill
     */
    public void down(Skill skill) {
        int index = skill.key.ordinal();
        int now = skillLevel[index];

        if (skill.getMinLevel() < now) {
            skillLevel[index] = now - 1;

            publish(this);
        }
    }

    /**
     * <p>
     * Compute champion base status.
     * </p>
     * 
     * @param status A target status.
     * @return A computed value.
     */
    private double base(Status status) {
        switch (status) {
        case MSRatio:
        case Energy:
        case Ereg:
        case DealtDamageRatio:
            return champion.getStatus(version).get(status);

        default:
            double value = champion.getStatus(version).get(status) + champion.getStatus(version).get(status.per()) * level;

            if (champion == Champion.EliseSpider) {
                value += computeVariable(status, Skill.SpiderForm);
            }

            if (champion == Champion.NidaleeCougar) {
                value += computeVariable(status, Skill.AspectOfTheCougar);
            }

            if (champion == Champion.Jayce) {
                value += computeVariable(status, Skill.TransformMercuryHammer);
            }
            return value;
        }
    }

    /**
     * <p>
     * Compute sum of the specified improvements.
     * </p>
     * 
     * @param improvementType A target type.
     * @return A sum value.
     */
    private double sum(Status status) {
        double sum = 0;

        // ===================================
        // Item
        // ===================================
        Set<String> names = new HashSet();

        for (int i = 0; i < 6; i++) {
            Item item = items[i];

            if (item != null) {
                ItemDescriptor itemDescriptor = item.getDescriptor(version);

                // compute item status
                sum = status.compute(sum, itemDescriptor.get(status));

                for (Ability ability : itemDescriptor.getAbilities()) {
                    AbilityDescriptor abilityDescriptor = ability.getDescriptor(version);

                    if (abilityDescriptor.isUnique() && !names.add(ability.name)) {
                        continue;
                    }

                    // compute ability status
                    sum = status.compute(sum, sum(abilityDescriptor.getPassive(), status));
                }
            }
        }

        // ===================================
        // Skill
        // ===================================
        for (int i = 0; i < champion.skills.length; i++) {
            Skill skill = champion.skills[i];
            SkillDescriptor skillStatus = skill.getDescriptor(version);

            // form passive
            sum = status.compute(sum, sum(skillStatus.getPassive(), skill, status));

            // from active
            if (skillActivation[i]) {
                sum = status.compute(sum, sum(skillStatus.getActive(), skill, status));
            }
        }
        return sum;
    }

    /**
     * <p>
     * Compute sum value from the specified skill variables.
     * </p>
     * 
     * @param tokens A descriptor tokens.
     * @param skill A current processing skill.
     * @param status A target status.
     * @return A computed value.
     */
    private double sum(List tokens, Status status) {
        double sum = 0;

        for (Object token : tokens) {
            if (token instanceof Variable) {
                Variable variable = (Variable) token;
                Status variableStatus = variable.getStatus();

                if (variableStatus == status && !variable.isConditional()) {
                    sum = variableStatus.compute(sum, variable.calculate(1, this));
                }
            }
        }
        return sum;
    }

    /**
     * <p>
     * Compute sum value from the specified skill variables.
     * </p>
     * 
     * @param tokens A descriptor tokens.
     * @param skill A current processing skill.
     * @param status A target status.
     * @return A computed value.
     */
    private double sum(List tokens, Skill skill, Status status) {
        double sum = 0;

        for (Object token : tokens) {
            if (token instanceof Variable) {
                Variable variable = (Variable) token;
                Status variableStatus = variable.getStatus();

                if (variableStatus == status && !variable.isConditional()) {
                    VariableResolver resolver = variable.getResolver();
                    int level = resolver.isSkillLevelBased() ? getLevel(skill) : resolver.convertLevel(this);

                    if (level != 0) {
                        sum = variableStatus.compute(sum, calculateVariable(skill, variable, level));
                    }
                }
            }
        }
        return sum;
    }

    /**
     * <p>
     * Compute skill variable value by using this build.
     * </p>
     * 
     * @param skill A current processing skill.
     * @param variable A current processing variable.
     * @param level A current skill level.
     * @return
     */
    public double calculateVariable(Skill skill, Variable variable, int level) {
        // avoid circular dependency
        if (DependencyManager.use(skill)) {
            return 0;
        }

        double value = variable.calculate(level, this);

        // avoid circular dependency
        DependencyManager.unuse(skill);

        // API definition
        return value;
    }

    /**
     * <p>
     * Compute status from skill variable.
     * </p>
     * 
     * @param status A target status.
     * @param skill A target skill.
     * @return A calcurated value.
     */
    private double computeVariable(Status status, Skill skill) {
        double value = 0;
        int level = skillLevel[skill.key.ordinal()];

        if (0 < level) {
            SkillDescriptor skillStatus = skill.getDescriptor(version);

            for (Object token : skillStatus.getActive()) {
                if (token instanceof Variable) {
                    Variable variable = (Variable) token;

                    if (variable.getStatus() == status) {
                        value += calculateVariable(skill, variable, skillLevel[skill.key.ordinal()]);
                    }
                }
            }
        }

        // API definition
        return value;
    }

    /**
     * <p>
     * Push skill key.
     * </p>
     * 
     * @param key
     */
    public void active(SkillKey key) {
        int index = key.ordinal();
        skillActivation[index] = !skillActivation[index];

        // assure minimun skill level
        if (skillActivation[index] && skillLevel[index] == 0) {
            skillLevel[index] = 1;
        }

        if (key == SkillKey.R) {
            if (champion == Champion.Nidalee) {
                champion = Champion.NidaleeCougar;
            } else if (champion == Champion.NidaleeCougar) {
                champion = Champion.Nidalee;
            }

            if (champion == Champion.Elise) {
                champion = Champion.EliseSpider;
            } else if (champion == Champion.EliseSpider) {
                champion = Champion.Elise;
            }

            if (champion == Champion.Jayce) {
                champion = Champion.JayceCannon;
            } else if (champion == Champion.JayceCannon) {
                champion = Champion.Jayce;
            }
        }

        publish(this);
    }

    /**
     * <p>
     * Retrieve skill activation state.
     * </p>
     * 
     * @param skill A target skill.
     * @return
     */
    public boolean isActive(Skill skill) {
        return skillActivation[skill.key.ordinal()];
    }

    /**
     * @version 2013/01/25 13:42:02
     */
    public class Computed {

        /** The champion base value. */
        public final double base;

        /** The computed value. */
        public final double value;

        /** The increased value. */
        public final double increased;

        /**
         * @param base A base value.
         * @param value A computed value.
         */
        private Computed(double base, double value, Status status) {
            this.base = status.round(base);
            this.value = status.round(value);
            this.increased = status.round(value - base);

            cache.set(status.ordinal(), this);
        }

        /**
         * <p>
         * Retrieve computed value as String expression.
         * </p>
         * 
         * @return A computed value.
         */
        public String value() {
            return String.valueOf(value);
        }

        /**
         * <p>
         * Retrieve base value as String expression.
         * </p>
         * 
         * @return A base value.
         */
        public String base() {
            return String.valueOf(base);
        }

        /**
         * <p>
         * Retrieve increased value as String expression.
         * </p>
         * 
         * @return A increased value.
         */
        public String increased() {
            return String.valueOf(increased);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return value();
        }
    }
}
