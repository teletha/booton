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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import js.dom.Element;

/**
 * @version 2013/12/01 12:39:38
 */
public class Item extends Describable<ItemDescriptor> {

    /** The counter for id. */
    private static int counter = 0;

    /** The item manager. */
    private static final List<Item> items = new ArrayList();

    /** Abyssal Scepter */
    public static final Item AbyssalScepter = new Item(3001, "Abyssal Scepter", item -> {
        item.build(Item.BlastingWand, Item.NegatronCloak).cost(980).abilityPower(70).magicRegist(45).add(ability -> {
            ability.aura("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 700).variable(2, MRReduction, 20);
        });
    });

    /** Aegis of the Legion */
    public static final Item AegisOftheLegion = new Item(3105, "Aegis of the Legion", item -> {
        item.build(Item.EmblemOfValor, Item.NullMagicMantle, Item.RubyCrystal)
                .cost(625)
                .health(250)
                .armor(20)
                .magicRegist(20)
                .add(Ability.Legion)

                .update(P310)
                .cost(375)
                .health(200)
                .magicRegist(0)

                .update(P314)
                .build(Item.RejuvenationBead, Item.ClothArmor, Item.RubyCrystal, Item.NullMagicMantle)
                .cost(595);
    });

    /** Amplifying Tome */
    public static final Item AmplifyingTome = new Item(1052, "Amplifying Tome", item -> {
        item.cost(435).abilityPower(20);
    });

    /** Archangel's Staff */
    public static final Item ArchangelsStaff = new Item(3003, "Archangel's Staff", item -> {
        item.build(Item.TearOftheGoddess, Item.BlastingWand)
                .cost(1140)
                .abilityPower(60)
                .manaRegen(10)
                .mana(250)
                .add(Ability.ArchangelInsight)
                .add(Ability.ManaCharge);
    });

    /** Athene's Unholy Grail */
    public static final Item AthenesUnholyGrail = new Item(3174, "Athene's Unholy Grail", item -> {
        item.build(Item.ChaliceOfHarmony, Item.FiendishCodex)
                .cost(900)
                .abilityPower(60)
                .manaRegen(15)
                .magicRegist(40)
                .cooldownReduction(20)
                .add(Ability.AtheneRestore)
                .add(Ability.ManaFont);
    });

    /** Atma's Impaler */
    public static final Item AtmasImpaler = new Item(3005, "Atma's Impaler", item -> {
        item.build(Item.AvariceBlade, Item.ChainVest).cost(780).armor(45).critical(15).add(ability -> {
            ability.passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Health, 0.015));
        });
    });

    /** Augment: Power */
    public static final Item AugmentPower = new Item(3196, "Augment: Power", item -> {
        item.build(Item.HexCore).cost(1000).abilityPower(45).add(Ability.HexCorePower).add(Ability.HexCoreDeath);
    });

    /** Augment: Gravity */
    public static final Item AugmentGravity = new Item(3197, "Augment: Gravity", item -> {
        item.build(Item.HexCore)
                .cost(1000)
                .cooldownReduction(10)
                .manaRegen(5)
                .mana(200)
                .add(Ability.HexCorePower)
                .add(Ability.HexCoreGravity);
    });

    /** Augment: Death */
    public static final Item AugmentDeath = new Item(3198, "Augment: Death", item -> {
        item.build(Item.HexCore)
                .cost(1000)
                .health(220)
                .healthRegen(6)
                .add(Ability.HexCorePower)
                .add(Ability.HexCoreTransfer);
    });

    /** Avarice Blade */
    public static final Item AvariceBlade = new Item(3093, "Avarice Blade", item -> {
        item.build(BrawlersGloves).cost(400).critical(10).add(Ability.Avarice).add(Ability.Greed);
    });

    /** B. F. Sword */
    public static final Item BFSword = new Item(1038, "B. F. Sword", item -> {
        item.cost(1550).attackDamage(45);
    });

    /** Banner of Command */
    public static final Item BannerOfCommand = new Item(3060, "Banner of Command", item -> {
        item.build(Item.FiendishCodex, Item.EmblemOfValor)
                .cost(890)
                .abilityPower(40)
                .cooldownReduction(10)
                .armor(30)
                .add(Ability.AegisValor)
                .add(Ability.Promote)

                .update(P314)
                .build(Item.FiendishCodex, Item.BlastingWand)
                .cost(720)
                .abilityPower(80)
                .cooldownReduction(20)
                .armor(0);
    });

    /** Banshee's Veil */
    public static final Item BansheesVeil = new Item(3102, "Banshee's Veil", item -> {
        item.build(Item.NegatronCloak, Item.CatalystTheProtector)
                .cost(600)
                .health(400)
                .mana(300)
                .magicRegist(45)
                .add(ability -> {
                    ability.passive("敵Championからのスキルを無効化するシールドを張る。シールドはスキルを無効化すると消費され、25秒間敵Championからダメージを受けないと再生する。");
                })

                .update(P310)
                .build(Item.SpectresCowl, Item.RubyCrystal)
                .cost(875)
                .health(450)
                .magicRegist(55)
                .mana(0)
                .add(ability -> {
                    ability.passive("Championからダメージを受けると10秒間{1}を得る。").variable(-1, Hreg, 45);
                });
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreaves = new Item(3006, "Berserker's Greaves", item -> {
        item.build(Item.BootsOfSpeed, Item.Dagger).cost(150).attackSpeed(20).add(Ability.EnhancedMovement2)

        .update(P308).cost(175);
    });

    /** Bilgewater Cutlass */
    public static final Item BilgewaterCutlass = new Item(3144, "Bilgewater Cutlass", item -> {
        item.build(Item.LongSword, Item.VampiricScepter)
                .cost(200)
                .lifeSteal(12)
                .attackDamage(25)
                .add(ability -> {
                    ability.active("対象の敵Champion({0})に{1}と2秒間{2}与える。{3}。")
                            .variable(0, Radius, 550)
                            .variable(1, MagicDamage, 100)
                            .variable(2, MSSlowRatio, 25)
                            .variable(3, ItemCD, 90)

                            .update(P310A)
                            .variable(0, Radius, 450);
                })

                .update(P314)
                .price(240, 980);
    });

    /** The Black Cleaver */
    public static final Item BlackCleaver = new Item(3071, "The Black Cleaver", item -> {
        item.build(Item.Brutalizer, Item.RubyCrystal)
                .cost(1188)
                .attackDamage(50)
                .health(200)
                .cooldownReduction(10)
                .add(ability -> {
                    ability.ununique()
                            .passive("敵Championに物理DMを与えた際、{1}を与える。5回（計25％）までスタックし、4秒間持続する。")
                            .variable(1, ARReductionRatio, 5);
                })
                .add(ability -> {
                    ability.passive("{1}を得る。").variable(1, ARPen, 10);
                });
    });

    /** Blade of the Ruined King */
    public static final Item BladeOftheRuinedKing = new Item(3153, "Blade of the Ruined King", item -> {
        item.build(BilgewaterCutlass, Item.Dagger, Item.Dagger)
                .cost(1000)
                .lifeSteal(15)
                .attackDamage(25)
                .attackSpeed(40)
                .add(ability -> {
                    ability.passive("通常攻撃に{1}(Minionに対しては60が上限)を付与する。")
                            .variable(1, PhysicalDamage, 0, 0, amplify(TargetCurrentHealthRatio, 5));
                })
                .add(ability -> {
                    ability.active("対象の敵Champion({1})に{2}(下限100)を与え、{3}する。また{5}間{4}を与え、自身の移動速度がその分だけ増加する。{6}。")
                            .variable(1, Radius, 550)
                            .variable(2, PhysicalDamage, 0, 0, amplify(TargetMaxHealthRatio, 15))
                            .variable(3, RestoreHealth, 0, 0, amplify(DealtDamage, 1))
                            .variable(4, MSSlowRatio, 30)
                            .variable(5, Time, 4)
                            .variable(6, ItemCD, 60)

                            .update(P310)
                            .variable(5, Time, 3)

                            .update(P310A)
                            .variable(1, Radius, 450)
                            .variable(6, ItemCD, 90);
                });
    });

    /** Blasting Wand */
    public static final Item BlastingWand = new Item(1026, "Blasting Wand", item -> {
        item.cost(860).abilityPower(40);
    });

    /** The Bloodthirster */
    public static final Item Bloodthirster = new Item(3072, "The Bloodthirster", item -> {
        item.build(BFSword, Item.VampiricScepter)
                .cost(850)
                .lifeSteal(12)
                .attackDamage(70)
                .add(ability -> {
                    ability.ununique()
                            .passive("敵ユニットを倒す度に{1}と{2}を得る。この効果は30回分までスタックし、死亡すると半分のスタックが失われる。")
                            .variable(1, AD, 0, 0, amplify(Stack, 1))
                            .variable(2, LS, 0, 0, amplify(Stack, 0.2));
                });
    });

    /** Bonetooth Necklace */
    public static final Item BonetoothNecklace = new Item(3166, "Bonetooth Necklace", item -> {
        item.cost(800)
                .attackDamage(5)
                .add(ability -> {
                    ability.passive("{1}を得る。").variable(1, AD, 0, 0, amplify(Lv, 2));
                })
                .add(ability -> {
                    ability.passive("キルまたはアシスト時に1 trophyを得て、死亡時に1 trophyを失う（最大値は14）。その数に応じて追加効果を得る。<br>3 : {1}と{2}を得る。<br>6 : {3}を得る。<br>9 : Unseen Predatorの射程が150増加する。<br>14 : Ultの効果時間が3秒増加する。またUltを使用した次にスキルを使用する際に1 Ferocityを追加で得る。")
                            .variable(1, ARPen, 10)
                            .variable(2, CDR, 5)
                            .variable(3, MS, 25);
                });
    });

    /** Boots of Mobility */
    public static final Item BootsOfMobility = new Item(3117, "Boots of Mobility", item -> {
        item.build(Item.BootsOfSpeed).cost(650).add(Ability.EnhancedMovement5)

        .update(P308).cost(675)

        .update(P403).cost(475);
    });

    /** Boots of Speed */
    public static final Item BootsOfSpeed = new Item(1001, "Boots of Speed", item -> {
        item.cost(350).add(Ability.EnhancedMovement1)

        .update(P308).cost(325);
    });

    /** Boots of Swiftness */
    public static final Item BootsOfSwiftness = new Item(3009, "Boots of Swiftness", item -> {
        item.build(BootsOfSpeed).cost(650).add(Ability.EnhancedMovement3).add(Ability.SlowResist)

        .update(P308).cost(675);
    });

    /** Brawler's Gloves */
    public static final Item BrawlersGloves = new Item(1051, "Brawler's Gloves", item -> {
        item.cost(400).critical(8);
    });

    /** The Brutalizer */
    public static final Item Brutalizer = new Item(3134, "The Brutalizer", item -> {
        item.build(LongSword, LongSword).cost(547).attackDamage(25).add(ability -> {
            ability.passive("{1}と{2}を得る。").variable(1, CDR, 10).variable(2, ARPen, 10);
        })

        .update(P314).price(617, 936);
    });

    /** Catalyst the Protector */
    public static final Item CatalystTheProtector = new Item(3010, "Catalyst the Protector", item -> {
        item.build(RubyCrystal, SapphireCrystal).cost(325).health(200).mana(300).add(Ability.ValorsReward);
    });

    /** Chain Vest */
    public static final Item ChainVest = new Item(1031, "Chain Vest", item -> {
        item.cost(720).armor(40);
    });

    /** Chalice of Harmony */
    public static final Item ChaliceOfHarmony = new Item(3028, "Chalice of Harmony", item -> {
        item.build(FaerieCharm, FaerieCharm, NullMagicMantle)
                .cost(120)
                .manaRegen(7)
                .magicRegist(25)
                .add(Ability.ManaFont);
    });

    /** Cloak of Agility */
    public static final Item CloakOfAgility = new Item(1018, "Cloak of Agility", item -> {
        item.cost(730).critical(15);
    });

    /** Cloth Armor */
    public static final Item ClothArmor = new Item(1029, "Cloth Armor", item -> {
        item.cost(300).armor(15);
    });

    /** Crystalline Flask */
    public static final Item CrystallineFlask = new Item(2041, "Crystalline Flask", item -> {
        item.cost(345)
                .add(ability -> {
                    ability.active("チャージを一つ消費して12秒かけて{1}し、{2}する。")
                            .variable(1, Status.RestoreHealth, 120)
                            .variable(2, RestoreMana, 60);
                })
                .add(ability -> {
                    ability.passive("購入時及びショップを訪れる度に3つのチャージを得る。");
                });
    });

    /** Dagger */
    public static final Item Dagger = new Item(1042, "Dagger", item -> {
        item.cost(400).attackSpeed(12);
    });

    /** Deathfire Grasp */
    public static final Item DeathfireGrasp = new Item(3128, "Deathfire Grasp", item -> {
        item.build(Item.FiendishCodex, Item.NeedlesslyLargeRod)
                .cost(680)
                .abilityPower(120)
                .cooldownReduction(10)
                .add(ability -> {
                    ability.active("対象の敵Champion({1})に{2}を与え、4秒間被魔法DMが20%増加するdebuffを与える。{3}。")
                            .variable(1, Radius, 750)
                            .variable(2, MagicDamage, 0, 0, amplify(TargetMaxHealthRatio, 15))
                            .variable(3, ItemCD, 60);
                });
    });

    /** Doran's Blade */
    public static final Item DoransBlade = new Item(1055, "Doran's Blade", item -> {
        item.cost(475).attackDamage(10).health(80).add(ability -> {
            ability.ununique().passive("敵ユニットに対して通常攻撃をする毎に{1}する。").variable(1, RestoreHealth, 5)

            .update(P314).passive("敵ユニットに対して通常攻撃をする毎にMeleeは{1}し、Rangedは{2}する。").variable(2, RestoreHealth, 3);
        })

        .update(P314).cost(440).attackDamage(8);
    });

    /** Doran's Ring */
    public static final Item DoransRing = new Item(1056, "Doran's Ring", item -> {
        item.cost(475).abilityPower(15).health(80).manaRegen(3).add(ability -> {
            ability.ununique().passive("敵ユニットを倒すと{1}する。").variable(1, RestoreMana, 5)

            .update(P308).variable(1, RestoreMana, 4);
        })

        .update(P308).cost(400).health(60);
    });

    /** Doran's Shield */
    public static final Item DoransShield = new Item(1054, "Doran's Shield", item -> {
        item.cost(475).health(100).healthRegen(8).armor(5).add(ability -> {
            ability.passive("敵Championからの{1}する。").variable(1, AttackDamageReduction, 6)

            .update(P308).variable(1, AttackDamageReduction, 8);
        })

        .update(P308).cost(440).armor(0).healthRegen(10)

        .update(P403).health(80).healthRegen(6);
    });

    /** Eleisa's Miracle */
    public static final Item EleisasMiracle = new Item(3173, "Eleisa's Miracle", item -> {
        item.build(Item.PhilosophersStone)
                .cost(400)
                .manaRegen(15)
                .healthRegen(10)
                .add(Ability.Aid)
                .add(Ability.EleisasBlessing)

                .update(P314)
                .deprecated();
    });

    /** Elixir of Brilliance */
    public static final Item ElixirOfBrilliance = new Item(2039, "Elixir of Brilliance", item -> {
        item.cost(250).add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して180秒間、{1} と{2}を得る。")
                    .variable(1, AP, 24, 0, amplify(Lv, 0.9))
                    .variable(2, CDR, 10);
        });
    });

    /** Elixir of Fortitude */
    public static final Item ElixirOfFortitude = new Item(2037, "Elixir of Fortitude", item -> {
        item.cost(350).add(ability -> {
            ability.ununique()
                    .active("このアイテムを消費して180秒間、{1}と{2}を得る。")
                    .variable(1, Health, 113, 0, amplify(Lv, 6.7))
                    .variable(2, AD, 15);
        });
    });

    /** Emblem of Valor */
    public static final Item EmblemOfValor = new Item(3097, "Emblem of Valor", item -> {
        item.build(ClothArmor, RejuvenationBead).cost(170).armor(20).add(Ability.Valor)

        .update(P314).deprecated();
    });

    /** Executioner's Calling */
    public static final Item ExecutionersCalling = new Item(3123, "Executioner's Calling", item -> {
        item.build(AvariceBlade, Item.LongSword).cost(700).attackDamage(25).critical(20).add(ability -> {
            ability.passive("敵Championに対する通常攻撃に{1}を付与する。").variable(1, Wounds, 1.5);
        })

        .update(P314).price(740, 1330);
    });

    /** Faerie Charm */
    public static final Item FaerieCharm = new Item(1004, "Faerie Charm", item -> {
        item.cost(180).manaRegen(3);
    });

    /** Fiendish Codex */
    public static final Item FiendishCodex = new Item(3108, "Fiendish Codex", item -> {
        item.build(AmplifyingTome).cost(385).abilityPower(30).add(ability -> {
            ability.passive("{1}を得る。").variable(1, CDR, 10);
        });
    });

    /** Frozen Heart */
    public static final Item FrozenHeart = new Item(3110, "Frozen Heart", item -> {
        item.build(Item.GlacialShroud, Item.WardensMail)
                .cost(550)
                .cooldownReduction(20)
                .armor(95)
                .mana(400)
                .add(Ability.FrozenHeartPassive);
    });

    /** Frozen Mallet */
    public static final Item FrozenMallet = new Item(3022, "Frozen Mallet", item -> {
        item.build(Item.Phage, Item.GiantsBelt).cost(835).attackDamage(30).health(700).add(Ability.Icy2)

        .update(P310A).build(Item.GiantsBelt, Item.Pickaxe, Item.RubyCrystal).cost(950);
    });

    /** Giant's Belt */
    public static final Item GiantsBelt = new Item(1011, "Giant's Belt", item -> {
        item.cost(1000).health(380);
    });

    /** Glacial Shroud */
    public static final Item GlacialShroud = new Item(3024, "Glacial Shroud", item -> {
        item.build(SapphireCrystal, ChainVest).cost(230).armor(45).mana(300).add(ability -> {
            ability.passive("{1}を得る。").variable(1, CDR, 10);
        });
    });

    /** Guardian Angel */
    public static final Item GuardianAngel = new Item(3026, "Guardian Angel", item -> {
        item.build(Item.NullMagicMantle, ChainVest)
                .cost(1480)
                .armor(50)
                .magicRegist(30)
                .add(ability -> {
                    ability.passive("Healthが0になった際、4秒後に{1}と{2}を得て復活する。{3}。")
                            .variable(-1, Health, 0, 0, amplify(Health, 0.3))
                            .variable(-2, Mana, 0, 0, amplify(Mana, 0.3))
                            .variable(3, ItemCD, 300);
                })

                .update(P310)
                .build(Item.NegatronCloak, ChainVest)
                .cost(1310)
                .magicRegist(40);
    });

    /** Guinsoo's Rageblade */
    public static final Item GuinsoosRageblade = new Item(3124, "Guinsoo's Rageblade", item -> {
        item.build(BlastingWand, Item.Pickaxe)
                .cost(865)
                .attackDamage(30)
                .abilityPower(40)
                .add(ability -> {
                    ability.ununique()
                            .passive("通常攻撃またはスキル使用時にスタックが1増加する。1スタックにつき{1}し{2}を得る。スタックは8秒持続し、最大8スタックまで増加する。")
                            .variable(-1, ASRatio, 4)
                            .variable(-2, AP, 4);
                })
                .add(ability -> {
                    ability.passive("自身のHealthが50%以下になった際に、戦闘状態が終わるまでの間{1}し{2}と{3}を得る。8秒間戦闘を行わないと解除される。{4}。")
                            .variable(-1, ASRatio, 20)
                            .variable(-2, LS, 10)
                            .variable(-3, SV, 10)
                            .variable(4, ItemCD, 30);
                });
    });

    /** Haunting Guise */
    public static final Item HauntingGuise = new Item(3136, "Haunting Guise", item -> {
        item.build(Item.RubyCrystal, AmplifyingTome).cost(575).abilityPower(25).health(200).add(Ability.EyesOfPain);
    });

    /** Health Potion */
    public static final Item HealthPotion = new Item(2003, "Health Potion", item -> {
        item.cost(35).add(Ability.PortionHealth);
    });

    /** The Hex Core */
    public static final Item HexCore = new Item(3200, "The Hex Core", item -> {
        item.cost(0).add(Ability.TheHexCorePassive);
    });

    /** Hexdrinker */
    public static final Item Hexdrinker = new Item(3155, "Hexdrinker", item -> {
        item.build(Item.LongSword, Item.NullMagicMantle)
                .cost(550)
                .attackDamage(25)
                .magicRegist(25)
                .add(Ability.Lifeline1)

                .update(P314)
                .price(590, 945);
    });

    /** Hextech Gunblade */
    public static final Item HextechGunblade = new Item(3146, "Hextech Gunblade", item -> {
        item.build(BilgewaterCutlass, Item.HextechRevolver)
                .cost(800)
                .lifeSteal(12)
                .attackDamage(45)
                .abilityPower(65)
                .add(ability -> {
                    ability.passive("{1}を得る。敵Championに通常攻撃でダメージを与えるか、単体対象かつDoTではないダメージスキルを使用するたびに、このアイテムのUNIQUE ActiveのCDが3秒解消する。")
                            .variable(1, SV, 20);
                })
                .add(ability -> {
                    ability.active("対象の敵Champion({1})に{2}と2秒間{3}を与える。{4}。")
                            .variable(1, Radius, 700)
                            .variable(2, MagicDamage, 150, 0, ap(0.4))
                            .variable(3, MSSlowRatio, 40)
                            .variable(4, ItemCD, 60);
                });
    });

    /** Hextech Revolver */
    public static final Item HextechRevolver = new Item(3145, "Hextech Revolver", item -> {
        item.build(AmplifyingTome, AmplifyingTome).cost(330).abilityPower(40).add(Ability.HextechRevolverPassive);
    });

    /** Hunter's Machete */
    public static final Item HuntersMachete = new Item(1039, "Hunter's Machete", item -> {
        item.cost(300).add("Butcher", ability -> {
            ability.passive("モンスターへのダメージが10%増加する。");
        }).add(Ability.Rend)

        .update(P308).remove(Ability.Rend).add(Ability.Maim);
    });

    /** Iceborn Gauntlet */
    public static final Item IcebornGauntlet = new Item(3025, "Iceborn Gauntlet", item -> {
        item.build(Item.Sheen, GlacialShroud)
                .cost(700)
                .abilityPower(30)
                .cooldownReduction(10)
                .armor(70)
                .mana(500)
                .add(Ability.Spellblade);
    });

    /** Infinity Edge */
    public static final Item InfinityEdge = new Item(3031, "Infinity Edge", item -> {
        item.build(BFSword, CloakOfAgility, Item.Pickaxe)
                .cost(645)
                .attackDamage(70)
                .critical(25)
                .add(Ability.InfinityEdgePassive);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsOfLucidity = new Item(3158, "Ionian Boots of Lucidity", item -> {
        item.build(BootsOfSpeed).cost(700).add(Ability.IonianCDR).add(Ability.EnhancedMovement2)

        .update(P306).cost(650)

        .update(P308).cost(675);
    });

    /** Kage's Lucky Pick */
    public static final Item KagesLuckyPick = new Item(3098, "Kage's Lucky Pick", item -> {
        item.build(AmplifyingTome).cost(330).abilityPower(25).add(Ability.LuckyShadow)

        .update(P314).deprecated();
    });

    /** Kindlegem */
    public static final Item Kindlegem = new Item(3067, "Kindlegem", item -> {
        item.build(Item.RubyCrystal).cost(375).health(200).add(Ability.KindlegemPassive);
    });

    /** Last Whisper */
    public static final Item LastWhisper = new Item(3035, "Last Whisper", item -> {
        item.build(Item.LongSword, Item.Pickaxe).cost(1025).attackDamage(40).add(Ability.LastWhisperPassive)

        .update(P314).price(1065, 1610);
    });

    /** Liandry's Torment */
    public static final Item LiandrysTorment = new Item(3151, "Liandry's Torment", item -> {
        item.build(HauntingGuise, AmplifyingTome)
                .cost(980)
                .abilityPower(50)
                .health(300)
                .add(Ability.EyesOfPain)
                .add(Ability.LiandrysTormentPassive);
    });

    /** Lich Bane */
    public static final Item LichBane = new Item(3100, "Lich Bane", item -> {
        item.build(Item.Sheen, BlastingWand)
                .cost(940)
                .abilityPower(80)
                .mana(250)
                .movementSpeed(5)
                .add(Ability.LichSpellblade);
    });

    /** Locket of the Iron Solari */
    public static final Item LocketOftheIronSolari = new Item(3190, "Locket of the Iron Solari", item -> {
        item.build(Kindlegem, ClothArmor, Item.RejuvenationBead)
                .cost(520)
                .health(300)
                .cooldownReduction(10)
                .armor(35)
                .healthRegen(5)
                .add(Ability.SolariActive)

                .update(P310)
                .build(AegisOftheLegion)
                .cost(600)
                .health(300)
                .armor(20)
                .cooldownReduction(10)
                .healthRegen(0)
                .add(Ability.Legion);
    });

    /** Long Sword */
    public static final Item LongSword = new Item(1036, "Long Sword", item -> {
        item.cost(400).attackDamage(10)

        .update(P314).cost(360);
    });

    /** Madred's Razors */
    public static final Item MadredsRazors = new Item(3106, "Madred's Razors", item -> {
        item.build(ClothArmor, HuntersMachete).price(100, 490).armor(25).add(Ability.Maim).add(Ability.Rend)

        .update(P308).remove(Ability.Maim).add(Ability.MaimForMadredsRazors)

        .update(P314).remove(Ability.Rend);
    });

    /** Malady */
    public static final Item Malady = new Item(3114, "Malady", item -> {
        item.build(Dagger, Dagger, AmplifyingTome)
                .cost(800)
                .abilityPower(25)
                .attackSpeed(45)
                .add(Ability.MaladyPassive)

                .update(P308)
                .deprecated();
    });

    /** Mana Manipulator */
    public static final Item ManaManipulator = new Item(3037, "Mana Manipulator", item -> {
        item.build(FaerieCharm, FaerieCharm).cost(40).add(Ability.ManaWarp)

        .update(P307).build(FaerieCharm).cost(120).add(Ability.ManaWarp)

        .update(P314).deprecated();
    });

    /** Mana Potion */
    public static final Item ManaPotion = new Item(2004, "Mana Potion", item -> {
        item.cost(35).add(Ability.PortionMana);
    });

    /** Manamune */
    public static final Item Manamune = new Item(3004, "Manamune", item -> {
        item.build(Item.TearOftheGoddess, LongSword)
                .cost(1000)
                .attackDamage(20)
                .manaRegen(7)
                .mana(250)
                .add(Ability.Awe)
                .add(Ability.ManamuneManaCharge)

                .update(P314)
                .price(1040, 1470);
    });

    /** Maw of Malmortius */
    public static final Item MawOfMalmortius = new Item(3156, "Maw of Malmortius", item -> {
        item.build(Hexdrinker, Item.Pickaxe)
                .cost(975)
                .attackDamage(55)
                .magicRegist(36)
                .add(Ability.MawOfMalmortiusPassive)
                .add(Ability.Lifeline2)

                .update(P309)
                .attackDamage(60)
                .magicRegist(40);
    });

    /** Mejai's Soulstealer */
    public static final Item MejaisSoulstealer = new Item(3041, "Mejai's Soulstealer", item -> {
        item.build(AmplifyingTome).cost(800).abilityPower(20).add(Ability.MejaisSoulstealerPassive);
    });

    /** Mercurial Scimitar */
    public static final Item MercurialScimitar = new Item(3139, "Mercurial Scimitar", item -> {
        item.build(Item.QuicksilverSash, BFSword).cost(600).attackDamage(60).magicRegist(45).add(Ability.Quicksilver2);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreads = new Item(3111, "Mercury's Treads", item -> {
        item.build(BootsOfSpeed, Item.NullMagicMantle)
                .cost(450)
                .magicRegist(25)
                .add(Ability.EnhancedMovement2)
                .add(Ability.TenacityPassive)

                .update(P308)
                .cost(475);
    });

    /** Mikael's Crucible */
    public static final Item MikaelsCrucible = new Item(3222, "Mikael's Crucible", item -> {
        item.build(ChaliceOfHarmony, Item.SapphireCrystal)
                .cost(920)
                .manaRegen(9)
                .mana(300)
                .magicRegist(40)
                .add(Ability.ManaFont)
                .add(Ability.MikaelsCrucibleActive)

                .update(P307)
                .build(ChaliceOfHarmony, Item.PhilosophersStone)
                .cost(920)
                .manaRegen(18)
                .healthRegen(7)
                .magicRegist(40)

                .update(P314)
                .build(ChaliceOfHarmony)
                .cost(720)
                .manaRegen(12)
                .healthRegen(0);
    });

    /** Morellonomicon */
    public static final Item Morellonomicon = new Item(3165, "Morellonomicon", item -> {
        item.build(FaerieCharm, FiendishCodex, KagesLuckyPick)
                .cost(435)
                .abilityPower(75)
                .cooldownReduction(20)
                .manaRegen(12)
                .add(Ability.MorellonomiconPassive);
    });

    /** Muramana */
    public static final Item Muramana = new Item(3042, "Muramana", item -> {
        item.build(Manamune)
                .cost(0)
                .attackDamage(20)
                .manaRegen(7)
                .mana(1000)
                .add(Ability.Awe)
                .add(Ability.MuramanaToggle);
    });

    /** Nashor's Tooth */
    public static final Item NashorsTooth = new Item(3115, "Nashor's Tooth", item -> {
        item.build(Item.Stinger, FiendishCodex)
                .cost(430)
                .abilityPower(65)
                .attackSpeed(50)
                .add(Ability.NashorsToothPassive)

                .update(P308)
                .cost(920)
                .abilityPower(60);
    });

    /** Needlessly Large Rod */
    public static final Item NeedlesslyLargeRod = new Item(1058, "Needlessly Large Rod", item -> {
        item.cost(1600).abilityPower(80);
    });

    /** Negatron Cloak */
    public static final Item NegatronCloak = new Item(1057, "Negatron Cloak", item -> {
        item.cost(720).magicRegist(40);
    });

    /** Ninja Tabi */
    public static final Item NinjaTabi = new Item(3047, "Ninja Tabi", item -> {
        item.build(BootsOfSpeed, ClothArmor)
                .cost(350)
                .armor(25)
                .add(Ability.NinjaTabiPassive)
                .add(Ability.EnhancedMovement2)

                .update(P308)
                .cost(375);
    });

    /** Null-Magic Mantle */
    public static final Item NullMagicMantle = new Item(1033, "Null-Magic Mantle", item -> {
        item.cost(400).magicRegist(20);
    });

    /** Ohmwrecker */
    public static final Item Ohmwrecker = new Item(3056, "Ohmwrecker", item -> {
        item.build(Item.RubyCrystal, BlastingWand, Item.PhilosophersStone)
                .cost(800)
                .abilityPower(50)
                .health(350)
                .manaRegen(15)
                .healthRegen(15)
                .add(Ability.OhmwreckerActive)

                .update(P314)
                .build(Item.RubyCrystal, BlastingWand)
                .cost(665)
                .abilityPower(50)
                .health(350)
                .manaRegen(0)
                .healthRegen(0);
    });

    /** Oracle's Elixir */
    public static final Item OraclesElixir = new Item(2042, "Oracle's Elixir", item -> {
        item.cost(400).add(Ability.OraclesElixirActive)

        .update(P314).deprecated();
    });

    /** Phage */
    public static final Item Phage = new Item(3044, "Phage", item -> {
        item.build(RubyCrystal, LongSword).cost(590).attackDamage(20).health(200).add(Ability.Icy1)

        .update(P310A).cost(375).clear().add(Ability.Rage)

        .update(P312).cost(475)

        .update(P314).price(490, 928);
    });

    /** Phantom Dancer */
    public static final Item PhantomDancer = new Item(3046, "Phantom Dancer", item -> {
        item.build(CloakOfAgility, Item.Zeal, Dagger)
                .cost(495)
                .attackSpeed(50)
                .movementSpeed(5)
                .critical(30)
                .add(Ability.PhantomDancerPassive);
    });

    /** Philosopher's Stone */
    public static final Item PhilosophersStone = new Item(3096, "Philosopher's Stone", item -> {
        item.build(FaerieCharm, RejuvenationBead).cost(340).manaRegen(9).healthRegen(7).add(Ability.Transmute)

        .update(P314).deprecated();
    });

    /** Pickaxe */
    public static final Item Pickaxe = new Item(1037, "Pickaxe", item -> {
        item.cost(875).attackDamage(25);
    });

    /** Quicksilver Sash */
    public static final Item QuicksilverSash = new Item(3140, "Quicksilver Sash", item -> {
        item.build(NegatronCloak).cost(830).magicRegist(45).add(Ability.Quicksilver1);
    });

    /** Rabadon's Deathcap */
    public static final Item RabadonsDeathcap = new Item(3089, "Rabadon's Deathcap", item -> {
        item.build(BlastingWand, NeedlesslyLargeRod).cost(840).abilityPower(120).add(Ability.RabadonsDeathcapPassive);
    });

    /** Randuin's Omen */
    public static final Item RanduinsOmen = new Item(3143, "Randuin's Omen", item -> {
        item.build(GiantsBelt, Item.WardensMail)
                .cost(1000)
                .health(500)
                .armor(70)
                .add(Ability.ColdSteel2)
                .add(Ability.RanduinsOmenAvtive);
    });

    /** Ravenous Hydra */
    public static final Item RavenousHydra = new Item(3074, "Ravenous Hydra", item -> {
        item.build(Item.Tiamat, Item.VampiricScepter)
                .cost(200)
                .lifeSteal(12)
                .attackDamage(75)
                .healthRegen(15)
                .add(Ability.RavenousHydraPassive)
                .add(Ability.Cleave)
                .add(Ability.Crescent)

                .update(P306)
                .cost(600);
    });

    /** Recurve Bow */
    public static final Item RecurveBow = new Item(1043, "Recurve Bow", item -> {
        item.cost(950).attackSpeed(30)

        .update(P308).cost(900);
    });

    /** Rejuvenation Bead */
    public static final Item RejuvenationBead = new Item(1006, "Rejuvenation Bead", item -> {
        item.cost(180).healthRegen(5);
    });

    /** Rod of Ages */
    public static final Item RodOfAges = new Item(3027, "Rod of Ages", item -> {
        item.build(CatalystTheProtector, BlastingWand)
                .cost(740)
                .abilityPower(60)
                .health(450)
                .mana(450)
                .add(Ability.ValorsReward)
                .add(ability -> {
                    ability.ununique()
                            .passive("1分毎に{1}と{2}と{3}を得る。この効果は10回まで発生する。")
                            .variable(1, Health, 0, 0, amplify(Stack, 20))
                            .variable(2, Mana, 0, 0, amplify(Stack, 20))
                            .variable(3, AP, 0, 0, amplify(Stack, 2));
                });
    });

    /** Ruby Crystal */
    public static final Item RubyCrystal = new Item(1028, "Ruby Crystal", item -> {
        item.cost(475).health(180)

        .update(P403).cost(400).health(150);
    });

    /** Ruby Sightstone */
    public static final Item RubySightstone = new Item(2045, "Ruby Sightstone", item -> {
        item.build(RubyCrystal, Item.Sightstone)
                .cost(125)
                .health(360)
                .add(Ability.WardRefresh2)
                .add(Ability.GhostWard2)

                .update(P314)
                .remove(Ability.GhostWard2)
                .add(Ability.GhostWard1)

                .update(P403)
                .cost(325)
                .health(400);
    });

    /** Runaan's Hurricane */
    public static final Item RunaansHurricane = new Item(3085, "Runaan's Hurricane", item -> {
        item.build(Dagger, RecurveBow, Dagger).cost(700).attackSpeed(70).add(Ability.RunaansHurricanePassive);
    });

    /** Runic Bulwark */
    public static final Item RunicBulwark = new Item(3107, "Runic Bulwark", item -> {
        item.build(NullMagicMantle, AegisOftheLegion)
                .cost(400)
                .health(300)
                .armor(20)
                .magicRegist(30)
                .add(Ability.BulwarkLegion)

                .update(P310)
                .deprecated();
    });

    /** Rylai's Crystal Scepter */
    public static final Item RylaisCrystalScepter = new Item(3116, "Rylai's Crystal Scepter", item -> {
        item.build(BlastingWand, AmplifyingTome, GiantsBelt)
                .cost(605)
                .abilityPower(80)
                .health(500)
                .add(Ability.RylaisCrystalScepterPassive);
    });

    /** Sapphire Crystal */
    public static final Item SapphireCrystal = new Item(1027, "Sapphire Crystal", item -> {
        item.cost(400).mana(200);
    });

    /** Seraph's Embrace */
    public static final Item SeraphsEmbrace = new Item(3040, "Seraph's Embrace", item -> {
        item.build(ArchangelsStaff)
                .cost(0)
                .abilityPower(60)
                .manaRegen(10)
                .mana(1000)
                .add(Ability.Insight)
                .add(Ability.ManaShield);
    });

    /** Seeker's Armguard */
    public static final Item SeekersArmguard = new Item(3191, "Seeker's Armguard", item -> {
        item.build(AmplifyingTome, ClothArmor, ClothArmor)
                .cost(125)
                .abilityPower(20)
                .armor(30)
                .add(Ability.SeekersArmguardPassive);
    });

    /** Shard of True Ice */
    public static final Item ShardOfTrueIce = new Item(3092, "Shard of True Ice", item -> {
        item.build(KagesLuckyPick, ManaManipulator)
                .cost(535)
                .abilityPower(45)
                .add(Ability.LuckyShadow)
                .add(Ability.ManaWarp)
                .add(Ability.ShardOfTrueIceActive);
    });

    /** Sheen */
    public static final Item Sheen = new Item(3057, "Sheen", item -> {
        item.build(SapphireCrystal, AmplifyingTome).cost(365).abilityPower(25).mana(200).add(Ability.SheenSpellblade);
    });

    /** Shurelya's Reverie */
    public static final Item ShurelyasReverie = new Item(3069, "Shurelya's Reverie", item -> {
        item.build(Kindlegem, PhilosophersStone)
                .cost(550)
                .health(250)
                .cooldownReduction(10)
                .manaRegen(10)
                .healthRegen(10)
                .add(Ability.ShurelyasReverieAvtive)

                .update(P314)
                .deprecated();
    });

    /** Sight Ward */
    public static final Item StealthWard = new Item(2044, "Stealth Ward", item -> {
        item.cost(75).add(Ability.StealthWardAvtive);
    });

    /** Sightstone */
    public static final Item Sightstone = new Item(2049, "Sightstone", item -> {
        item.build(RubyCrystal).cost(475).health(180).add(Ability.WardRefresh1).add(Ability.GhostWard1)

        .update(P403).health(150).cost(400);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoes = new Item(3020, "Sorcerer's Shoes", item -> {
        item.build(BootsOfSpeed).cost(750).set(MRPen, 15).add(Ability.EnhancedMovement2)

        .update(P308).cost(775);
    });

    /** Spectre's Cowl */
    public static final Item SpectresCowl = new Item(9997, "Spectre's Cowl", item -> {
        item.build(NegatronCloak, RubyCrystal).cost(205).health(200).magicRegist(45).add(Ability.SpectresCowlPassive);
    });

    /** Spirit Stone */
    public static final Item SpiritStone = new Item(1080, "Spirit Stone", item -> {
        item.build(HuntersMachete, FaerieCharm, RejuvenationBead)
                .price(40, 490)
                .manaRegen(7)
                .healthRegen(14)
                .add(Ability.Rend)
                .add("Butcher", ability -> {
                    ability.passive("モンスターへのダメージが20%増加する。");
                })

                .update(P308)
                .remove(Ability.Rend)
                .add(Ability.Maim)

                .update(P401)
                .healthRegen(0)
                .manaRegen(0)
                .add(Ability.Spirit)
                .remove(Ability.Maim);
    });

    /** Spirit of the Ancient Golem */
    public static final Item SpiritOftheAncientGolem = new Item(3207, "Spirit of the Ancient Golem", item -> {
        item.build(SpiritStone, Kindlegem)
                .cost(450)
                .health(500)
                .manaRegen(7)
                .healthRegen(14)
                .cooldownReduction(10)
                .add(Ability.Butcher)
                .add(Ability.TenacityPassive)

                .update(P314)
                .health(350)
                .add(Ability.GoldIncome)
                .add(Ability.Conservation)

                .update(P401)
                .healthRegen(0)
                .manaRegen(0)
                .add(Ability.Spirit);
    });

    /** Spirit of the Elder Lizard */
    public static final Item SpiritOftheElderLizard = new Item(3209, "Spirit of the Elder Lizard", item -> {
        item.build(SpiritStone, LongSword, LongSword)
                .cost(500)
                .attackDamage(45)
                .cooldownReduction(10)
                .manaRegen(7)
                .healthRegen(14)
                .add(Ability.Butcher)
                .add(Ability.Incinerate)

                .update(P308)
                .attackDamage(35)

                .update(P314)
                .price(580, 800)
                .attackDamage(30)
                .add(Ability.GoldIncome)
                .add(Ability.BountyHunter)

                .update(P315)
                .remove(Ability.BountyHunter)
                .add(Ability.Conservation)

                .update(P401)
                .healthRegen(0)
                .manaRegen(0)
                .add(Ability.Spirit);
    });

    /** Spirit of the Spectral Wraith */
    public static final Item SpiritOftheSpectralWraith = new Item(3206, "Spirit of the Spectral Wraith", item -> {
        item.build(SpiritStone, HextechRevolver)
                .cost(100)
                .abilityPower(50)
                .cooldownReduction(10)
                .manaRegen(10)
                .add(Ability.Butcher)
                .add(ability -> {
                    ability.passive("サモナースペルのSmiteのCDを20%減少させる。");
                })
                .add(ability -> {
                    ability.passive("{1}を得る。").variable(1, SV, 20);
                })

                .update(P308)
                .abilityPower(40)

                .update(P314)
                .build(SpiritStone, FiendishCodex)
                .price(480, 800)
                .abilityPower(50)
                .healthRegen(14)
                .manaRegen(7)
                .clear()
                .add(Ability.Butcher)
                .add(Ability.GoldIncome)
                .add(Ability.BountyHunter)
                .add(Ability.Spirit)

                .update(P315)
                .remove(Ability.BountyHunter)
                .add(Ability.Conservation)

                .update(P401)
                .healthRegen(0)
                .manaRegen(0)

                .add(ability -> {
                    ability.passive("巨大モンスターを倒すたびに{1}を得る。(最大で30)").variable(1, AP, 2);
                });
    });

    /** Spirit Visage */
    public static final Item SpiritVisage = new Item(3065, "Spirit Visage", item -> {
        item.build(Kindlegem, NegatronCloak)
                .cost(630)
                .health(200)
                .cooldownReduction(20)
                .magicRegist(50)
                .add(Ability.SpiritVisagePassive)

                .update(P310)
                .build(SpectresCowl, Kindlegem)
                .cost(375)
                .health(400)
                .magicRegist(55)
                .healthRegen(20)

                .update(P310A)
                .cost(500)

                .update(P401)
                .cooldownReduction(10);
    });

    /** Statikk Shiv */
    public static final Item StatikkShiv = new Item(3087, "Statikk Shiv", item -> {
        item.build(Item.Zeal, AvariceBlade)
                .cost(525)
                .attackSpeed(40)
                .movementSpeed(6)
                .critical(20)
                .add(Ability.StatikkShivPassive);
    });

    /** Stinger */
    public static final Item Stinger = new Item(3101, "Stinger", item -> {
        item.build(Dagger, Dagger).cost(450).attackSpeed(40).add(Ability.StingerPassive);
    });

    /** Sunfire Cape */
    public static final Item SunfireCape = new Item(3068, "Sunfire Cape", item -> {
        item.build(ChainVest, GiantsBelt).cost(930).health(450).armor(45).add(Ability.SunfireCapePassive);
    });

    /** Sword of the Divine */
    public static final Item SwordOftheDivine = new Item(3131, "Sword of the Divine", item -> {
        item.build(RecurveBow, Dagger)
                .cost(850)
                .attackSpeed(45)
                .add(Ability.SwordOftheDivinePassive)
                .add(Ability.SwordOftheDivineActive);
    });

    /** Sword of the Occult */
    public static final Item SwordOftheOccult = new Item(3141, "Sword of the Occult", item -> {
        item.build(LongSword).cost(800).attackDamage(10).add(Ability.SwordOftheOccultPassive)

        .update(P314).price(840, 840);
    });

    /** Tear of the Goddess */
    public static final Item TearOftheGoddess = new Item(3070, "Tear of the Goddess", item -> {
        item.build(SapphireCrystal, FaerieCharm).cost(120).manaRegen(7).mana(250).add(Ability.TearManaCharge)

        .update(P403).manaRegen(6);
    });

    /** Thornmail */
    public static final Item Thornmail = new Item(3075, "Thornmail", item -> {
        item.build(ChainVest, ClothArmor)
                .cost(1180)
                .armor(100)
                .add(ability -> {
                    ability.passive("敵の通常攻撃受けるとその攻撃者に{1}を与える。")
                            .variable(1, MagicDamage, 0, 0, amplify(ReceivedOriginalDamageRatio, 30));
                });
    });

    /** Tiamat */
    public static final Item Tiamat = new Item(3077, "Tiamat", item -> {
        item.build(Pickaxe, LongSword, RejuvenationBead, RejuvenationBead)
                .cost(665)
                .attackDamage(50)
                .healthRegen(15)
                .add(Ability.Cleave)
                .add(Ability.Crescent)

                .update(P306)
                .cost(265)
                .attackDamage(40)

                .update(P314)
                .price(305, 1330);
    });

    /** Trinity Force */
    public static final Item TrinityForce = new Item(3078, "Trinity Force", item -> {
        item.build(Item.Zeal, Sheen, Phage)
                .cost(3)
                .attackDamage(30)
                .abilityPower(30)
                .health(250)
                .attackSpeed(30)
                .mana(200)
                .movementSpeed(8)
                .critical(10)
                .add(Ability.Icy1)
                .add(Ability.TrinitySpellblade)

                .update(P310A)
                .remove(Ability.Icy1)
                .add(Ability.Rage);
    });

    /** Twin Shadows */
    public static final Item TwinShadows = new Item(3023, "Twin Shadows", item -> {
        item.build(KagesLuckyPick, NullMagicMantle)
                .cost(735)
                .abilityPower(40)
                .movementSpeed(6)
                .magicRegist(40)
                .add(Ability.Hunt)

                .update(P314)
                .build(AmplifyingTome, AmplifyingTome, NullMagicMantle)
                .cost(730)
                .abilityPower(50);
    });

    /** Vampiric Scepter */
    public static final Item VampiricScepter = new Item(1053, "Vampiric Scepter", item -> {
        item.build(LongSword).cost(400).lifeSteal(10).attackDamage(10)

        .update(P314).price(440, 560);
    });

    /** Vision Ward */
    public static final Item VisionWard = new Item(2043, "Vision Ward", item -> {
        item.cost(125).add(Ability.VisionWardAvtive)

        .update(P314).cost(100);
    });

    /** Void Staff */
    public static final Item VoidStaff = new Item(3135, "Void Staff", item -> {
        item.build(BlastingWand, AmplifyingTome).cost(1000).abilityPower(70).add(ability -> {
            ability.passive("{1}を得る。").variable(1, MRPenRatio, 35);
        });
    });

    /** Warden's Mail */
    public static final Item WardensMail = new Item(3082, "Warden's Mail", item -> {
        item.build(ClothArmor, ClothArmor).cost(500).armor(50).add(Ability.ColdSteel1)

        .update(P310).cost(400);
    });

    /** Warmog's Armor */
    public static final Item WarmogsArmor = new Item(3083, "Warmog's Armor", item -> {
        item.build(GiantsBelt, RubyCrystal, RejuvenationBead, RejuvenationBead).cost(995).health(1000).add(ability -> {
            ability.passive("{1}を得る。").variable(1, Hreg, 0, 0, amplify(Health, 0.01));
        });
    });

    /** Will of the Ancients */
    public static final Item WillOftheAncients = new Item(3152, "Will of the Ancients", item -> {
        item.build(KagesLuckyPick, HextechRevolver)
                .cost(585)
                .abilityPower(50)
                .add(ability -> {
                    ability.aura("{1}の味方Championに{2}と{3}を与える。")
                            .variable(1, Radius, 1100)
                            .variable(2, AP, 30)
                            .variable(3, SV, 20);
                })

                .update(P314)
                .build(HextechRevolver, FaerieCharm, FaerieCharm)
                .cost(440)
                .abilityPower(50)
                .manaRegen(10)
                .cooldownReduction(10)
                .spellVamp(20)
                .clear();
    });

    /** Wit's End */
    public static final Item WitsEnd = new Item(3091, "Wit's End", item -> {
        item.build(RecurveBow, NullMagicMantle).cost(850).attackSpeed(40).magicRegist(25).add(Ability.WitsEndPassive)

        .update(P308).build(RecurveBow, NullMagicMantle, Dagger).cost(700).attackSpeed(42);
    });

    /** Wriggle's Lantern */
    public static final Item WrigglesLantern = new Item(3154, "Wriggle's Lantern", item -> {
        item.build(VampiricScepter, MadredsRazors)
                .cost(100)
                .lifeSteal(10)
                .attackDamage(15)
                .armor(30)
                .add(Ability.MaimForMadredsRazors)
                .add(ability -> {
                    ability.active("{2}間持続する" + StealthWard.name + "を指定地点に設置する。{1}。")
                            .variable(1, ItemCD, 180)
                            .variable(2, Time, 180)

                            .update(P308)
                            .variable(1, ItemCD, 90)
                            .variable(2, Time, 90)

                            .update(P314)
                            .variable(1, ItemCD, 180)
                            .variable(2, Time, 180);
                })

                .update(P308)
                .cost(500)
                .attackDamage(25)
                .lifeSteal(15)
                .armor(25)
                .remove(Ability.MaimForMadredsRazors)
                .add("Maim", ability -> {
                    ability.passive("モンスターへ通常攻撃をする度に{1}を与える。")
                            .variable(1, MagicDamage, 100)

                            .update(P314)
                            .passive("モンスターへ通常攻撃をする度に{1}を与え、{2}する。")
                            .variable(1, MagicDamage, 100)
                            .variable(2, RestoreHealth, 10);
                })

                .update(P314)
                .build(MadredsRazors, Dagger, Dagger)
                .price(150, 720)
                .armor(20)
                .attackSpeed(25)
                .attackDamage(0)
                .lifeSteal(0)
                .add(Ability.GoldIncome)
                .add(ability -> {
                    ability.passive("モンスターからの収入が40%増加する。");
                });
    });

    /** Youmuu's Ghostblade */
    public static final Item YoumuusGhostblade = new Item(3142, "Youmuu's Ghostblade", item -> {
        item.build(AvariceBlade, Brutalizer)
                .cost(563)
                .attackDamage(30)
                .cooldownReduction(10)
                .critical(15)
                .add(Ability.YoumuusGhostbladePassive)
                .add(Ability.YoumuusGhostbladeActive);
    });

    /** Zeal */
    public static final Item Zeal = new Item(3086, "Zeal", item -> {
        item.build(BrawlersGloves, Dagger).cost(375).attackSpeed(18).movementSpeed(5).critical(10);
    });

    /** Zeke's Herald */
    public static final Item ZekesHerald = new Item(3050, "Zeke's Herald", item -> {
        item.build(VampiricScepter, Kindlegem).cost(900).health(250).cooldownReduction(20).add(Ability.ZekesHeraldAura);
    });

    /** Zephyr */
    public static final Item Zephyr = new Item(3172, "Zephyr", item -> {
        item.build(Stinger, Pickaxe)
                .cost(725)
                .attackDamage(25)
                .cooldownReduction(10)
                .attackSpeed(50)
                .movementSpeed(10)
                .add(Ability.TenacityPassive);
    });

    /** Zhonya's Hourglass */
    public static final Item ZhonyasHourglass = new Item(3157, "Zhonya's Hourglass", item -> {
        item.build(NeedlesslyLargeRod, SeekersArmguard).cost(500).abilityPower(120).armor(50).add(Ability.Stasis);
    });

    /** Spellthief's Edge */
    public static final Item SpellthiefsEdge = new Item(3303, "Spellthief's Edge", item -> {
        item.price(365, 145)
                .abilityPower(10)
                .manaRegen(3)
                .goldGeneration(2)
                .add(Ability.GoldIncome)
                .add("Tribute", ability -> {
                    ability.passive("Championに通常攻撃を行うと{1}獲得する（CD{2}）。ミニオンを倒すとこの効果は10秒間無効になる。")
                            .variable(1, Gold, 4)
                            .variable(2, Time, 10)

                            .update(P403)
                            .passive("敵Championか建物に通常攻撃かスキルを使用すると{2}を与え{1}獲得する。この効果は30秒に3度まで発生し、ミニオンを倒すと12秒間無効になる。")
                            .variable(1, Gold, 5)
                            .variable(2, TrueDamage, 10);
                })

                .update(P403)
                .abilityPower(5)
                .manaRegen(2);
    });

    /** Frostfang */
    public static final Item Frostfang = new Item(3098, "Frostfang", item -> {
        item.build(SpellthiefsEdge)
                .price(485, 425)
                .abilityPower(20)
                .manaRegen(7)
                .goldGeneration(4)
                .add(Ability.GoldIncome)
                .add("Tribute", ability -> {
                    ability.passive("Championに通常攻撃を行うと{1}獲得する（CD{2}）。ミニオンを倒すとこの効果は10秒間無効になる。")
                            .variable(1, Gold, 8)
                            .variable(2, Time, 10)

                            .update(P403)
                            .passive("敵Championか建物に通常攻撃かスキルを使用すると{2}を与え{1}獲得する。この効果は30秒に3度まで発生し、ミニオンを倒すと12秒間無効になる。")
                            .variable(1, Gold, 10)
                            .variable(2, TrueDamage, 15);
                })

                .update(P403)
                .price(500, 425)
                .abilityPower(10)
                .manaRegen(5);
    });

    /** Frost Queen's Claim */
    public static final Item FrostQueensClaim = new Item(3092, "Frost Queen's Claim", item -> {
        item.build(Frostfang, AmplifyingTome)
                .price(715, 800)
                .abilityPower(50)
                .manaRegen(10)
                .goldGeneration(4)
                .add(Ability.GoldIncome)
                .add("Tribute", ability -> {
                    ability.passive("Championに通常攻撃を行うと{1}獲得する（{2}）。ミニオンを倒すとこの効果は10秒間無効になる。")
                            .variable(1, Gold, 8)
                            .variable(2, ItemCD, 10)

                            .update(P403)
                            .passive("敵Championか建物に通常攻撃かスキルを使用すると{2}を与え{1}獲得する。この効果は30秒に3度まで発生する。")
                            .variable(1, Gold, 10)
                            .variable(2, TrueDamage, 15);
                })

                .update(P403)
                .price(315, 800)
                .build(Frostfang, FiendishCodex)
                .abilityPower(40)
                .cooldownReduction(10)
                .add(ability -> {
                    ability.active("対象とその{1}の敵に{2}と2秒かけて減衰する{3}を与える。{4}")
                            .variable(1, Radius)
                            .variable(2, MagicDamage, 50, 0, amplify(Lv, 5, 5))
                            .variable(3, MSSlowRatio, 80)
                            .variable(4, ItemCD, 60);
                });;
    });

    /** Ancient Coin */
    public static final Item AncientCoin = new Item(3301, "Ancient Coin", item -> {
        item.price(365, 145)
                .healthRegen(5)
                .manaRegen(3)
                .add(Ability.GoldIncome)
                .add("Favor", ability -> {
                    ability.passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得する。")
                            .variable(1, Gold, 2)

                            .update(P403)
                            .passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得し、{2}する。")
                            .variable(1, Gold, 2)
                            .variable(2, RestoreHealth, 5);
                })

                .update(P403)
                .healthRegen(0);
    });

    /** Nomad's Medallion */
    public static final Item NomadsMedallion = new Item(3096, "Nomad's Medallion", item -> {
        item.build(AncientCoin)
                .price(485, 340)
                .healthRegen(8)
                .manaRegen(11)
                .goldGeneration(2)
                .add(Ability.GoldIncome)
                .add("Favor", ability -> {
                    ability.passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得する。")
                            .variable(1, Gold, 4)

                            .update(P403)
                            .passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得し、{2}する。")
                            .variable(1, Gold, 3)
                            .variable(2, RestoreHealth, 5);
                })

                .update(P403)
                .price(500, 340)
                .healthRegen(5)
                .manaRegen(7);
    });

    /** Talisman of Ascension */
    public static final Item TalismanOfAscension = new Item(3069, "Talisman of Ascension", item -> {
        item.build(NomadsMedallion, FaerieCharm)
                .price(970, 800)
                .healthRegen(10)
                .manaRegen(15)
                .cooldownReduction(20)
                .goldGeneration(2)
                .add(Ability.GoldIncome)
                .add("Favor", ability -> {
                    ability.passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得する。")
                            .variable(1, Gold, 4)

                            .update(P403)
                            .passive("周囲であなたが殺すことなくミニオンが死んだ場合に{1}獲得し、{2}する。")
                            .variable(1, Gold, 3)
                            .variable(2, RestoreHealth, 10);
                })
                .add(ability -> {
                    ability.active("{1}の味方は3秒間{2}する。{3}")
                            .variable(1, Radius, 600)
                            .variable(2, MSRatio, 40)
                            .variable(3, ItemCD, 60);
                })

                .update(P403)
                .manaRegen(15);
    });

    /** Relic Shield */
    public static final Item RelicShield = new Item(3302, "Relic Shield", item -> {
        item.price(365, 146)
                .health(50)
                .healthRegen(6)
                .add(Ability.GoldIncome)
                .add("Spoils of War", ability -> {
                    ability.passive("60秒毎に最大2つまでスタックが貯まる。スタックがある状態でミニオンを倒すと最寄りの味方Championはあなたが獲得した金額+5Goｌdを獲得し、{1}する。また、Healthが{2}以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                            .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02))
                            .variable(2, Value, 200, 0, ad(1))

                            .update(P403)
                            .passive("60秒毎に最大2つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、Healthが200以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                            .variable(1, RestoreHealth, 40);
                })

                .update(P403)
                .health(75)
                .healthRegen(0);
    });

    /** Targon's Brace */
    public static final Item TargonsBrace = new Item(9999, "Targon's Brace", item -> {
        item.build(RelicShield)
                .price(485, 340)
                .health(175)
                .healthRegen(12)
                .add(Ability.GoldIncome)
                .add("Spoils of War", ability -> {
                    ability.passive("30秒毎に最大3つまでスタックが貯まる。スタックがある状態でミニオンを倒すと最寄りの味方Championはあなたが獲得した金額+10Goｌdを獲得し、{1}する。また、Healthが{2}以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                            .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02))
                            .variable(2, Value, 200, 0, ad(1))

                            .update(P403)
                            .passive("30秒毎に最大3つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、Healthが200以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                            .variable(1, RestoreHealth, 50);
                })

                .update(P403)
                .price(500, 340)
                .health(175)
                .healthRegen(8);
    });

    /** Face of the Mountain */
    public static final Item FaceOfTheMountain = new Item(3401, "Face of the Mountain", item -> {
        item.build(TargonsBrace, RubyCrystal)
                .price(675, 800)
                .health(375)
                .healthRegen(25)
                .cooldownReduction(10)
                .add(Ability.GoldIncome)
                .add("Spoils of War", ability -> {
                    ability.passive("30秒毎に最大4つまでスタックが貯まる。スタックがある状態でミニオンを倒すと最寄りの味方Championはあなたが獲得した金額+10Goｌdを獲得し、{1}する。また、Healthが{2}以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                            .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02))
                            .variable(2, Value, 200, 0, ad(1))

                            .update(P403)
                            .passive("30秒毎に最大4つまでスタックが貯まる。スタックがある状態でミニオンを倒すとあなたと最寄りの味方Championは共にゴールドを獲得し、{1}する。また、Healthが200以下のミニオンにMeleeが通常攻撃を行うと、そのミニオンを倒すことが出来る。近くに味方がいない場合、これらの効果は発動しない。")
                            .variable(1, RestoreHealth, 50, 0, amplify(HealthRatio, 0.01));
                })
                .add("Deadly Phalanx", ability -> {
                    ability.active("あなたは{1}を失う。対象の味方は4秒間{2}を得る。また、4秒後にその味方の周囲の敵に{3}を与える。{4}")
                            .variable(1, CurrentHealthRatio, 20)
                            .variable(2, Shield, 0, 0, amplify(Health, 0.1))
                            .variable(3, MagicDamage, 0, 0, amplify(Health, 0.1))
                            .variable(4, ItemCD, 60)

                            .update(P403)
                            .active("対象の味方は4秒間{2}を得る。また、4秒後にその味方の周囲の敵に{3}を与える。{4}")
                            .variable(1, HealthRatio, 10)
                            .variable(2, Shield, 0, 0, amplify(Health, 0.1))
                            .variable(3, MagicDamage, 0, 0, ad(1), ap(0.3))
                            .variable(4, ItemCD, 60);
                });
    });

    // lazy initialization
    static {
        try {
            for (Field field : Item.class.getFields()) {
                if (Modifier.isStatic(field.getModifiers())) {
                    Item item = (Item) field.get(null);
                    item.descriptor.accept(item.update());
                }
            }
        } catch (Exception e) {
            // If this exception will be thrown, it is bug of this program. So we must rethrow the
            // wrapped error in here.
            throw new Error(e);
        }
    }

    /** The sequencial id. */
    public final int position;

    /** The item id. */
    public final int id;

    /** The item name. */
    public final String name;

    /** The item description. */
    private final Consumer<ItemDescriptor> descriptor;

    /**
     * <p>
     * Create constructor.
     * </p>
     * 
     * @param id
     * @param name
     */
    Item(int id, String name, Consumer<ItemDescriptor> descriptor) {
        this.position = counter++;
        this.id = id;
        this.name = name;
        this.descriptor = descriptor;

        items.add(this);
    }

    /**
     * <p>
     * Apply icon image.
     * </p>
     */
    public void applyIcon(Element element) {
        element.css("background-image", "url(src/main/resources/teemowork/items.jpg)")
                .css("background-position", position / (counter - 1) * 100 + "% 0%")
                .css("background-size", "cover")
                .css("background-origin", "border-box");
    }

    public String getIcon() {
        return "src/main/resources/teemowork/items.jpg";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMaxLevel() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ItemDescriptor createDescriptor(Version version, ItemDescriptor previous) {
        return new ItemDescriptor(this, previous, version);
    }

    /**
     * <p>
     * Calcurate item total cost.
     * </p>
     * 
     * @param version
     * @return
     */
    public double getTotalCost(Version version) {
        ItemDescriptor status = getDescriptor(version);

        double sum = status.get(Cost);

        for (Item material : status.getBuild()) {
            sum += material.getTotalCost(version);
        }
        return sum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * <p>
     * List up all Items.
     * </p>
     * 
     * @return
     */
    public static List<Item> getAll() {
        return items;
    }

    /**
     * <p>
     * Find Item by name.
     * </p>
     * 
     * @param name A Item name.
     * @return A matched Item.
     */
    public static Item getByName(String name) {
        for (Item item : items) {
            if (item.name.equals(name)) {
                return item;
            }
        }
        return null;
    }
}
