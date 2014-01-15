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
import static teemowork.model.Version.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;

/**
 * @version 2013/12/01 12:39:34
 */
public class Ability extends Describable<AbilityDescriptor> {

    /** The ability. */
    public static final Ability AegisValor = new Ability("Valor", item -> {
        item.aura("{1}の味方ユニットは{2}を得る。味方ミニオンは与えるダメージが15%増加する。").variable(1, Radius).variable(2, Hreg, 10)

        .update(P314).passive("{1}の味方ミニオンは与えるダメージが15%増加する。");
    });

    /** The ability. */
    public static final Ability Aid = new Ability("Aid", item -> {
        item.passive("サモナースペルのHeal, Clairvoyance, ClarityのCDを30%減少させる。");
    });

    /** The ability. */
    public static final Ability ArchangelInsight = new Ability("Insight", item -> {
        item.passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Mana, 0.03));
    });

    /** The ability. */
    public static final Ability AtheneRestore = new Ability(item -> {
        item.passive("キルまたはアシスト時に{1}する。").variable(1, RestoreMana, 0, 0, amplify(Mana, 0.12));
    });

    /** The ability. */
    public static final Ability Avarice = new Ability("Avarice", item -> {
        item.passive("{1}を得る。").variable(1, GoldPer10Sec, 3);
    });

    /** The ability. */
    public static final Ability Awe = new Ability("Awe", item -> {
        item.passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Mana, 0.02));
    });

    /** The ability. */
    public static final Ability BountyHunter = new Ability("Bounty Hunter", item -> {
        item.passive("キル、アシストもしくは伝説のモンスターを倒すと{1}を、巨大モンスターを倒すと{2}を得る。").variable(1, Gold, 40).variable(2, Gold, 10);
    });

    /** The ability. */
    public static final Ability BulwarkLegion = new Ability("Legion", item -> {
        item.aura("{1}の味方ユニットは{2}、{3}、{4}を得る。味方ミニオンに対しては効果が1.5倍になる。")
                .variable(1, Radius, 1100)
                .variable(2, AR, 10)
                .variable(3, MR, 25)
                .variable(4, Hreg, 10);
    });

    /** The ability. */
    public static final Ability Butcher = new Ability("Butcher", item -> {
        item.passive("中立モンスターに対するダメージが{1}上昇する。").variable(1, Percentage, 25)

        .update(P308).variable(1, Percentage, 30);
    });

    /** The ability. */
    public static final Ability Cleave = new Ability("Cleave", item -> {
        item.passive("通常攻撃は{1}のユニットに{2}を与える。ダメージは攻撃対象から離れるにつれて減少し、最小で{3}になる。")
                .variable(1, Radius, 385)
                .variable(2, PhysicalDamage, 0, 0, ad(0.6))
                .variable(3, PhysicalDamage, 0, 0, amplify(AD, 0.2));
    });

    /** The ability. */
    public static final Ability ColdSteel1 = new Ability("Cold Steel", item -> {
        item.passive("通常攻撃を受けた際に対象に{2}間{1}を与える。").variable(1, ASSlowRatio, 15).variable(2, Time, 1.5)

        .update(P310).variable(2, Time, 1);
    });

    /** The ability. */
    public static final Ability ColdSteel2 = new Ability("Cold Steel", item -> {
        item.passive("通常攻撃を受けた際に対象に{3}間{1}と{2}を与える。")
                .variable(1, ASSlowRatio, 15)
                .variable(2, MSSlowRatio, 10)
                .variable(3, Time, 1.5)

                .update(P310)
                .variable(3, Time, 1);
    });

    /** The ability. */
    public static final Ability Conservation = new Ability("Conservation", item -> {
        item.passive("1.5秒毎に最大80までスタックが貯まる。巨大モンスターを倒した時、最大40スタックを消費して、消費したスタックに等しい収入を得る。");
    });

    /** The ability. */
    public static final Ability Crescent = new Ability("Crescent", item -> {
        item.active("{1}のユニットに{2}を与える。ダメージは自身から離れるにつれて減少し、最小で{3}になる。{4}。")
                .variable(1, Radius, 400)
                .variable(2, PhysicalDamage, 0, 0, ad(1))
                .variable(3, PhysicalDamage, 0, 0, amplify(AD, 0.6))
                .variable(4, ItemCD, 10);
    });

    /** The ability. */
    public static final Ability EleisasBlessing = new Ability("Eleisa's Blessing", item -> {
        item.passive("このアイテムを所持した状態でレベルを3上げるとこのアイテムは消費されるが、アイテムの効果はその後もそのまま得られるようになる。");
    });

    /** The ability. */
    public static final Ability EnhancedMovement1 = new Ability("Enhanced Movement", item -> {
        item.passive("{1}する。").variable(1, MS, 25);
    });

    /** The ability. */
    public static final Ability EnhancedMovement2 = new Ability("Enhanced Movement", item -> {
        item.passive("{1}する。").variable(1, MS, 45);
    });

    /** The ability. */
    public static final Ability EnhancedMovement3 = new Ability("Enhanced Movement", item -> {
        item.passive("{1}する。").variable(1, MS, 60);
    });

    /** The ability. */
    public static final Ability EnhancedMovement5 = new Ability("Enhanced Movement", item -> {
        item.passive("{1}する。5秒間戦闘をしなければ、{2}する。").variable(1, MS, 45).variable(2, MS, 105);
    });

    /** The ability. */
    public static final Ability EyesOfPain = new Ability("Eyes of Pain", item -> {
        item.passive("{1}を得る。").variable(1, MRPen, 15);
    });

    /** The ability. */
    public static final Ability FrozenHeartPassive = new Ability(item -> {
        item.aura("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 700).variable(2, ASSlowRatio, 20);
    });

    /** The ability. */
    public static final Ability GhostWard1 = new Ability("Ghost Ward", item -> {
        item.active("チャージを1つ消費して" + Item.StealthWard.name + "と同様の効果があるオブジェクトを指定地点に設置する。このアイテムによって同時に設置できるWardの数は最大2個までで、3個目を設置するとこのアイテムによって設置された一番古いWardが消滅する。")

                .update(P314)
                .active("チャージを1つ消費して" + Item.StealthWard.name + "と同様の効果があるオブジェクトを指定地点に設置する。");
    });

    /** The ability. */
    public static final Ability GhostWard2 = new Ability("Ghost Ward", item -> {
        item.active("チャージを1つ消費して" + Item.StealthWard.name + "と同様の効果があるオブジェクトを指定地点に設置する。このアイテムによって同時に設置できるWardの数は最大3個までで、4個目を設置するとこのアイテムによって設置された一番古いWardが消滅する。");
    });

    /** The ability. */
    public static final Ability GoldIncome = new Ability("Gold Income", item -> {
        item.passive("収入増加アイテムはひとつしか保有できない。");
    });

    /** The ability. */
    public static final Ability Greed = new Ability("Greed", item -> {
        item.passive("キルを取る毎に{1}を得る。").variable(1, Gold, 2);
    });

    /** The ability. */
    public static final Ability HexCoreDeath = new Ability(item -> {
        item.ununique().passive("Death Rayにダメージ30%分の魔法ダメージが追加される。このダメージは4秒間かけて与えられる。");
    });

    /** The ability. */
    public static final Ability HexCoreGravity = new Ability(item -> {
        item.ununique().passive("Gravity Fieldの射程が30%増加する。");
    });

    /** The ability. */
    public static final Ability HexCorePower = new Ability(item -> {
        item.ununique().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 3));
    });

    /** The ability. */
    public static final Ability HexCoreTransfer = new Ability(item -> {
        item.ununique().passive("Power Transfe使用・命中時に3秒間{1}する。").variable(1, MSRatio, 30);
    });

    /** The ability. */
    public static final Ability HextechRevolverPassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, SV, 12);
    });

    /** The ability. */
    public static final Ability Hunt = new Ability("Hunt", item -> {
        item.active("6秒間持続する無敵のゴーストを2体召喚する。ゴーストは最も近くにいる最大2人の敵Championの元まで移動していき(移動速度は450)、ゴーストが敵Championに触れた場合ゴーストが消滅し、その敵Championに2.5秒{1}を与え、2.5秒間対象の視界を得る。{2}。")
                .variable(1, MSSlowRatio, 40)
                .variable(2, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability Icy1 = new Ability("Icy", item -> {
        item.passive("25%の確率で通常攻撃に2秒間{1}(Rangedは{2})を付与する。").variable(1, MSSlowRatio, 30).variable(2, MSSlowRatio, 20);
    });

    /** The ability. */
    public static final Ability Icy2 = new Ability("Icy", item -> {
        item.passive("通常攻撃に1.5秒間{1}(Rangedは{2})を付与する。").variable(1, MSSlowRatio, 40).variable(2, MSSlowRatio, 30);
    });

    /** The ability. */
    public static final Ability Incinerate = new Ability("Incinerate", item -> {
        item.passive("通常攻撃またはDoTではないスキルによってダメージを与えた場合、3秒かけて{1}を与える。").variable(1, TrueDamage, 6, 0, amplify(Lv, 2))

        .update(P314).passive("物理ダメージを与えた場合、3秒かけて{1}を与える。").variable(1, PhysicalDamage, 14, 0, amplify(Lv, 2));
    });

    /** The ability. */
    public static final Ability InfinityEdgePassive = new Ability(item -> {
        item.passive("{1}する。").variable(1, CriticalDamageRatio, 50);
    });

    /** The ability. */
    public static final Ability Insight = new Ability("Insight", item -> {
        item.passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Mana, 0.03));
    });

    /** The ability. */
    public static final Ability IonianCDR = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, CDR, 15);
    });

    /** The ability. */
    public static final Ability KindlegemPassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, CDR, 15);
    });

    /** The ability. */
    public static final Ability LastWhisperPassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, ARPenRatio, 35);
    });

    /** The ability. */
    public static final Ability Legion = new Ability("Legion", item -> {
        item.aura("{1}の味方ユニットは{2}、{3}、{4}を得る。味方ミニオンに対しては効果が1.5倍になる。")
                .variable(1, Radius, 1100)
                .variable(2, AR, 10)
                .variable(3, MR, 15)
                .variable(4, Hreg, 10)

                .update(P310)
                .passive("{1}の味方Championは{3}、{4}を得る。")
                .variable(3, MR, 20);
    });

    /** The ability. */
    public static final Ability LiandrysTormentPassive = new Ability(item -> {
        item.passive("敵ユニットにスキルでダメージを与えた際に3秒かけて{1}を与える(ミニオンやモンスターに対しては上限300)。対象が移動阻害効果を受けている場合、ダメージは2倍になる。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetCurrentHealthRatio, 6));
    });

    /** The ability. */
    public static final Ability LichSpellblade = new Ability("Spellblade", item -> {
        item.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。").variable(1, MagicDamage, 50, 0, ap(0.75)).variable(2, ItemCD, 2);
    });

    /** The ability. */
    public static final Ability Lifeline1 = new Ability("Lifeline", item -> {
        item.passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。{2}。")
                .variable(1, MagicShield, 250)
                .variable(2, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability Lifeline2 = new Ability("Lifeline", item -> {
        item.passive("魔法ダメージを受けて自身のHealthが30%以下になった場合、5秒間{1}を得る。{2}。")
                .variable(1, MagicShield, 400)
                .variable(2, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability LuckyShadow = new Ability("Lucky Shadow", item -> {
        item.passive("{1}を得る。").variable(1, Status.GoldPer10Sec, 4);
    });

    /** The ability. */
    public static final Ability Maim = new Ability("Maim", item -> {
        item.passive("ミニオンやモンスターに対して通常攻撃をした際、25%の確率で{1}を与える。").variable(1, MagicDamage, 300)

        .update(P308).passive("モンスターへ通常攻撃をする度に{1}を与える。").variable(1, MagicDamage, 10)

        .update(P314).passive("モンスターへ通常攻撃をする度に{1}を与え、{2}する。").variable(2, RestoreHealth, 5);
    });

    /** The ability. */
    public static final Ability MaimForMadredsRazors = new Ability("Maim", item -> {
        item.passive("ミニオンやモンスターに対して通常攻撃をした際、25%の確率で{1}を与える。").variable(1, MagicDamage, 500)

        .update(P308).passive("モンスターへ通常攻撃をする度に{1}を与える。").variable(1, MagicDamage, 60)

        .update(P314).passive("モンスターへ通常攻撃をする度に{1}を与え、{2}する。").variable(2, RestoreHealth, 5);
    });

    /** The ability. */
    public static final Ability MaladyPassive = new Ability(item -> {
        item.passive("通常攻撃に{1}と{2}を与える。MR減少は7回までスタックし、8秒間持続する。")
                .variable(1, MagicDamage, 15, 0, ap(0.1))
                .variable(2, MRReduction, 4);
    });

    /** The ability. */
    public static final Ability ManaCharge = new Ability("Mana Charge", item -> {
        item.passive("スキル使用時及びマナ消費時に最大Manaが6増加する(最大増加量は750)。{1}。").variable(1, ItemCD, 3)

        .update(P309).passive("スキル使用時及びマナ消費時に最大Manaが8増加する(最大増加量は750)。{1}。").variable(1, ItemCD, 4);
    });

    /** The ability. */
    public static final Ability ManaFont = new Ability("Mana Font", item -> {
        item.passive("{1}する。").variable(1, MregRatio, 0, 0, amplify(MissingManaPercentage, 0.01));
    });

    /** The ability. */
    public static final Ability ManamuneManaCharge = new Ability("Mana Charge", item -> {
        item.passive("通常攻撃時、スキル使用時及びマナ消費時に最大Manaが4増加する(最大増加量は750)。{1}。").variable(1, ItemCD, 3)

        .update(P309).variable(1, ItemCD, 4);
    });

    /** The ability. */
    public static final Ability ManaPotion = new Ability(item -> {
        item.ununique().active("15秒かけてManaを100回復する");
    });

    /** The ability. */
    public static final Ability ManaShield = new Ability("Mana Shield", item -> {
        item.active("現在のManaの20%を消費し、3秒間{1}を得る。{2}。")
                .variable(1, Shield, 150, 0, amplify(Status.CurrentManaRatio, 0.2))
                .variable(2, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability ManaWarp = new Ability("Mana Warp", item -> {
        item.aura("{1}の味方Championは{2}を得る。").variable(1, Radius, 1100).variable(2, Hreg, 6);
        ManaWarp.update(P307).variable(2, Hreg, 5);
    });

    /** The ability. */
    public static final Ability MawOfMalmortiusPassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, AD, 0, 0, amplify(MissingHealthPercentage, 0.4))

        .update(P309).passive("{1}を得る。(最大35)").variable(1, AD, 0, 0, amplify(MissingHealthPercentage, 0.5));
    });

    /** The ability. */
    public static final Ability MejaisSoulstealerPassive = new Ability(item -> {
        item.passive("キル時2スタック、アシスト時1スタックを得て、死亡時に3割を失う（最大20スタック）。{1}を得て、20スタック時は{2}を得る。")
                .variable(1, AP, 0, 0, amplify(Stack, 8))
                .variable(2, CDR, 15);
    });

    /** The ability. */
    public static final Ability MikaelsCrucibleActive = new Ability(item -> {
        item.active("対象の味方Champion({1})のStun, Snare, Taunt, Fear, Silence, Slowを全て解除し、{2}する。{3}")
                .variable(1, Radius, 800)
                .variable(2, RestoreHealth, 150, 0, amplify(TargetMissingHealthRatio, 15))
                .variable(3, ItemCD, 180)

                .update(P307)
                .variable(2, RestoreHealth, 150, 0, amplify(TargetMaxHealthRatio, 10));
    });

    /** The ability. */
    public static final Ability MorellonomiconPassive = new Ability(item -> {
        item.passive("HPが40%以下の敵Championに魔法DMを与えると{1}を与える。").variable(1, Wounds, 4);
    });

    /** The ability. */
    public static final Ability MuramanaToggle = new Ability(item -> {
        item.ununique()
                .passive("現在のManaの3%を消費して、通常攻撃または単体対象かつDoTではないダメージスキルに{1}を付与する。")
                .variable(1, PhysicalDamage, 0, 0, amplify(Status.CurrentManaRatio, 6));
    });

    /** The ability. */
    public static final Ability NashorsToothPassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, CDR, 20)

        .update(P308).passive("{1}を得る。通常攻撃に{2}を付与する。").variable(2, MagicDamage, 15, 0, ap(0.15));
    });

    /** The ability. */
    public static final Ability NinjaTabiPassive = new Ability(item -> {
        item.passive("{1}する。").variable(1, AttackDamageReductionRatio, 10);
    });

    /** The ability. */
    public static final Ability OhmwreckerActive = new Ability(item -> {
        item.active("一番近くのTowerからの攻撃を2.5秒間防ぐ。この効果は同一のTowerに対して7.5秒に一度しか使えない。{1}。").variable(1, ItemCD, 120);
    });

    /** The ability. */
    public static final Ability OraclesElixirActive = new Ability(item -> {
        item.ununique().active("このアイテムを消費して{1}のStealth状態の敵が味方に見えるようになる。5分経つか、死亡すると効果が切れる。").variable(1, Radius, 750)

        .update(P309).active("このアイテムを消費して{1}のStealth状態の敵が味方に見えるようになる。4分経つと効果が切れる。").variable(1, Radius, 600);
    });

    /** The ability. */
    public static final Ability PhantomDancerPassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, IgnoreUnitCollision);
    });

    /** The ability. */
    public static final Ability PortionHealth = new Ability(item -> {
        item.ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreHealth, 150);
    });

    /** The ability. */
    public static final Ability PortionMana = new Ability(item -> {
        item.ununique().active("このアイテムを消費して15秒かけて{1}する。").variable(1, RestoreMana, 100);
    });

    /** The ability. */
    public static final Ability Promote = new Ability("Promote", item -> {
        item.active("近くのSiege MinionをAnti-Turret-Minionに変身させる。Anti-Turret-Minionが敵ユニットを倒した場合、そのゴールドが得られる。またAnti-Turret Minionはタワーを最優先で攻撃する。{1}。")
                .variable(1, ItemCD, 180);
    });

    /** The ability. */
    public static final Ability Quicksilver1 = new Ability("Quicksilver", item -> {
        item.active("自身のDebuffをすべて除去する。{1}。").variable(1, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability Quicksilver2 = new Ability("Quicksilver", item -> {
        item.active("自身のDebuffをすべて除去する。通常攻撃がMeleeのChampionが使用した場合、1秒間{1}する。{2}。")
                .variable(1, MSRatio, 50)
                .variable(2, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability RabadonsDeathcapPassive = new Ability(item -> {
        item.passive("{1}する。").variable(1, APRatio, 30);
    });

    /** The ability. */
    public static final Ability Rage = new Ability("Rage", item -> {
        item.update(P310A)
                .passive("通常攻撃をする毎に2秒間{1}する。ミニオンかモンスター、Championを倒すと2秒間{2}する。")
                .variable(1, MS, 20)
                .variable(2, MS, 60)

                .update(P312)
                .passive("通常攻撃をする毎に2秒間{1}する。ミニオンかモンスター、Championを倒すと2秒間{2}する。Rangedは半分の効果になる。");
    });

    /** The ability. */
    public static final Ability RanduinsOmenAvtive = new Ability(item -> {
        item.active("{1}の敵ユニットに2秒間{2}を与える。この効果時間は、自身のArmor+Magic Resistの値100につき1秒増加する。{3}。")
                .variable(1, Radius, 525)
                .variable(2, MSSlowRatio, 35)
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability RavenousHydraPassive = new Ability(item -> {
        item.ununique().passive("このアイテムによって与えられたダメージはLife Stealの効果を受ける。");
    });

    /** The ability. */
    public static final Ability Rend = new Ability("Rend", item -> {
        item.passive("中立モンスターに対する通常攻撃に{1}を付与する。").variable(1, TrueDamage, 10);
    });

    /** The ability. */
    public static final Ability RunaansHurricanePassive = new Ability(item -> {
        item.passive("通常攻撃をした際に、{1}の2体の敵ユニットに{2}を与える。これはOn-Hit Effectの効果を受ける。")
                .variable(1, Radius, 375)
                .variable(2, PhysicalDamage, 10, 0, ad(0.5));
    });

    /** The ability. */
    public static final Ability RylaisCrystalScepterPassive = new Ability(item -> {
        item.passive("スキルでダメージを与えた際に1.5秒間{1}を与える。対象が複数のスキルまたは秒間ダメージスキルの場合、{2} を与える。")
                .variable(1, MSSlowRatio, 35)
                .variable(2, MSSlowRatio, 15);
    });

    /** The ability. */
    public static final Ability SeekersArmguardPassive = new Ability(item -> {
        item.passive("敵ユニットを倒す度に{1}と{2}を得る。この効果は30回分までスタックする。")
                .variable(1, AP, 0, 0, amplify(Stack, 0.5))
                .variable(2, AR, 0, 0, amplify(Stack, 0.5));
    });

    /** The ability. */
    public static final Ability ShardOfTrueIceActive = new Ability(item -> {
        item.active("対象の味方ユニット({0})の周辺に4秒間持続する吹雪を発生させ、{1}にいる敵ユニットに{2}を与える。{3}。")
                .variable(0, Radius, 800)
                .variable(1, Radius, 200)
                .variable(2, MSSlowRatio, 30)
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability SheenSpellblade = new Ability("Spellblade", item -> {
        item.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。")
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 1))
                .variable(2, ItemCD, 2);
    });

    /** The ability. */
    public static final Ability ShurelyasReverieAvtive = new Ability(item -> {
        item.active("{1}の味方Championは3秒間{2}する。{3}。")
                .variable(1, Radius, 600)
                .variable(2, MSRatio, 40)
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability SlowResist = new Ability("Slow Resist", item -> {
        item.passive("{1}を得る。").variable(1, Status.MSSlowReductionRatio, 25);
    });

    /** The ability. */
    public static final Ability SolariActive = new Ability(item -> {
        item.active("自身と{1}の味方Championは5秒間{2}を得る。{3}。")
                .variable(1, Radius, 600)
                .variable(2, Shield, 50, 0, amplify(Lv, 10))
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability SpectresCowlPassive = new Ability(item -> {
        item.update(P310).passive("Championからダメージを受けると10秒間{1}を得る。").variable(-1, Hreg, 15);
    });

    /** The ability. */
    public static final Ability Spellblade = new Ability("Spellblade", item -> {
        item.passive("スキル使用後の通常攻撃に、周囲の敵ユニットに{1}を与える効果を付与し、範囲内の敵ユニットに{2}を与える円形のフィールド（Melee{3} Ranged{4}）を2秒間形成する。{5}。")
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 1.25))
                .variable(2, MSSlowRatio, 30)
                .variable(3, Radius, 285)
                .variable(4, Radius, 210)
                .variable(5, ItemCD, 2);
    });

    /** The ability. */
    public static final Ability SpiritVisagePassive = new Ability(item -> {
        item.passive("{1}する。").variable(1, RestoreHealthRatio, 20);
    });

    /** The ability. */
    public static final Ability Stasis = new Ability("Stasis", item -> {
        item.active("2.5秒間、自身を行動不能かつ無敵(ダメージ無効, ターゲット不可)にする。{1}。").variable(1, ItemCD, 90);
    });

    /** The ability. */
    public static final Ability StatikkShivPassive = new Ability(item -> {
        item.passive("移動または通常攻撃を行うとその度にチャージが貯まっていく。 チャージが100に達した時、次の通常時に対象に雷を放ち{1}を与える。雷は対象の付近の敵ユニット({2})3体にも連鎖し同様のダメージを与える。雷によるダメージはクリティカルの影響を受ける。雷を放った後はチャージは0になる。建物を攻撃する時はチャージは増加するが雷は発生しない。")
                .variable(1, MagicDamage, 100)
                .variable(2, Radius, 300);
    });

    /** The ability. */
    public static final Ability StealthWardAvtive = new Ability(item -> {
        item.ununique()
                .active("このアイテムを消費して、視界1100を持つオブジェクトを指定地点に設置する。オブジェクトは設置から約3秒後にステルス状態になり、3分間持続する。")

                .update(P314)
                .active("このアイテムを消費して、視界1100を持つオブジェクトを指定地点に設置する。オブジェクトは設置から約3秒後にステルス状態になり、3分間持続する。各プレイヤーは3つまでしか設置出来ず、5つしか携帯出来ない。");

    });

    /** The ability. */
    public static final Ability StingerPassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, CDR, 10);
    });

    /** The ability. */
    public static final Ability SunfireCapePassive = new Ability(item -> {
        item.aura("{1}の敵ユニットに毎秒{2}を与える。").variable(1, Radius, 400).variable(2, MagicDamage, 40)

        .update(P410).variable(2, MagicDamage, 25, 0, amplify(Lv, 1));
    });

    /** The ability. */
    public static final Ability SwordOftheDivineActive = new Ability(item -> {
        item.active("3秒間または3回Critical Strikeが出るまでの間、{1}し{2}する。{3}。")
                .variable(1, ASRatio, 100)
                .variable(2, Critical, 100)
                .variable(3, ItemCD, 60);
    });

    /** The ability. */
    public static final Ability SwordOftheDivinePassive = new Ability(item -> {
        item.ununique().passive("UNIQUE ActiveがCD待ちの間は能力上昇が無くなる。敵Championキル時(アシストでは無効)に、UNIQUE Activeの現在のCDが50%解消される。");
    });

    /** The ability. */
    public static final Ability SwordOftheOccultPassive = new Ability(item -> {
        item.passive("キルを得た際に2スタック、アシストを得た際に1スタックを得て(最大20スタック)、死亡時にその3割を失う。{1}を得る。20スタック時には{2}する。")
                .variable(1, AD, 0, 0, amplify(Stack, 5))
                .variable(2, MSRatio, 15);
    });

    /** The ability. */
    public static final Ability TearManaCharge = new Ability("Mana Charge", item -> {
        item.passive("スキル使用時またはmana消費時に最大Manaが4増加する(最大増加量は750)。{1}。").variable(1, ItemCD, 3)

        .update(P309).variable(1, ItemCD, 4);
    });

    /** The ability. */
    public static final Ability TenacityPassive = new Ability("Tenacity", item -> {
        item.passive("{1} を得る。").variable(1, Status.Tenacity, 35);
    });

    /** The ability. */
    public static final Ability TheHexCorePassive = new Ability(item -> {
        item.ununique().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(Lv, 3));
    });

    /** The ability. */
    public static final Ability Transmute = new Ability("Transmute", item -> {
        item.passive("{1}を得る。").variable(1, GoldPer10Sec, 5);
    });

    /** The ability. */
    public static final Ability TrinitySpellblade = new Ability("Spellblade", item -> {
        item.passive("スキル使用後の通常攻撃に、{1}を付与する。{2}。")
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 1.5))
                .variable(2, ItemCD, 2)

                .update(P310A)
                .variable(1, PhysicalDamage, 0, 0, amplify(BaseAD, 2));
    });

    /** The ability. */
    public static final Ability Valor = new Ability("Valor", item -> {
        item.aura("{1}の味方ユニットは{2}を得る。").variable(1, Radius).variable(2, Hreg, 7);
    });

    /** The ability. */
    public static final Ability ValorsReward = new Ability("Valor's Reward", item -> {
        item.passive("レベルアップ時に8秒かけて{1}し、{2}する。").variable(1, RestoreHealth, 150).variable(2, RestoreMana, 200);
    });

    /** The ability. */
    public static final Ability VisionWardAvtive = new Ability(item -> {
        item.ununique()
                .active("このアイテムを消費して、ステルスを看破できる視界1000を持つオブジェクトを指定地点に設置する。オブジェクトは設置から約3秒後にステルス状態になり、3分間持続する。")

                .update(P314)
                .active("このアイテムを消費して、ステルスを看破できる視界1000を持ち耐久値5のオブジェクトを指定地点に設置する。これは永久に持続する。各プレイヤーは1個しか設置出来ず、2個しか携帯出来ない。");

    });

    /** The ability. */
    public static final Ability WardRefresh1 = new Ability("Ward Refresh", item -> {
        item.passive("購入時及びショップを訪れる度に4つのチャージを得る。");
    });

    /** The ability. */
    public static final Ability WardRefresh2 = new Ability("Ward Refresh", item -> {
        item.passive("購入時及びショップを訪れる度に5つのチャージを得る。");
    });

    /** The ability. */
    public static final Ability WitsEndPassive = new Ability(item -> {
        item.passive("通常攻撃は追加{1}を与え、{2}を得る。MRの増加は4回までスタックし、5秒間持続する。")
                .variable(1, MagicDamage, 42)
                .variable(2, MR, 0, 0, amplify(Stack, 5))

                .update(P308)
                .passive("通常攻撃は追加{1}を与え、{2}を得る。また対象の敵に{3}を与える。MRの増減は5回までスタックし、5秒間持続する。")
                .variable(3, MRReduction, 0, 0, amplify(Stack, 5));
    });

    /** The ability. */
    public static final Ability YoumuusGhostbladeActive = new Ability(item -> {
        item.active("Meleeなら6秒間、Rangedなら4秒間{1}と{2}を得る。{3}。")
                .variable(1, MSRatio, 20)
                .variable(2, ASRatio, 40)
                .variable(3, ItemCD, 45);
    });

    /** The ability. */
    public static final Ability YoumuusGhostbladePassive = new Ability(item -> {
        item.passive("{1}を得る。").variable(1, ARPen, 20);
    });

    /** The ability. */
    public static final Ability ZekesHeraldAura = new Ability(item -> {
        item.aura("{1}の味方Championは{2}と{3}を得る。").variable(1, Radius, 1200).variable(2, AD, 20).variable(3, LS, 10);
    });

    /** The ability. */
    public static final Ability Spirit = new Ability(item -> {
        item.passive("モンスターにダメージを与えると{1}し{2}する。(範囲攻撃の場合は効果が半減する)")
                .variable(1, RestoreHealth, 0, 0, amplify(DealtDamage, 0.08))
                .variable(2, RestoreMana, 0, 0, amplify(DealtDamage, 0.04));
    });

    // lazy initialization
    static {
        try {
            for (Field field : Ability.class.getFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    Ability ability = (Ability) field.get(null);
                    ability.descriptor.accept(ability.update());
                }
            }
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /** The ability name. */
    public final String name;

    /** The ability descriptor. */
    private final Consumer<AbilityDescriptor> descriptor;

    /**
     * Create new ability with invisible name.
     */
    Ability(Consumer<AbilityDescriptor> descriptor) {
        this(null, descriptor);
    }

    /**
     * Create new ability with visible name.
     */
    Ability(String name, Consumer<AbilityDescriptor> descriptor) {
        this.name = name == null ? "#" + descriptor.hashCode() : name;
        this.descriptor = descriptor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbilityDescriptor createDescriptor(Version version, AbilityDescriptor previous) {
        return new AbilityDescriptor(this, previous, version);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return 0;
    }
}
