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
 * @version 2013/11/29 14:01:53
 */
public class Item extends Describable<ItemDescriptor> {

    /** The counter for id. */
    private static int counter = 0;

    /** The item manager. */
    private static final List<Item> items = new ArrayList();

    /** Abyssal Scepter */
    public static final Item AbyssalScepter = new Item(3001, "Abyssal Scepter", item -> {
        item.build(BlastingWand, NegatronCloak)
                .cost(980)
                .abilityPower(70)
                .magicRegist(45)
                .abilities(Ability.AbyssalAura);
    });

    /** Aegis of the Legion */
    public static final Item AegisOftheLegion = new Item(3105, "Aegis of the Legion", item -> {
        item.build(EmblemOfValor, NullMagicMantle, RubyCrystal)
                .cost(625)
                .health(250)
                .armor(20)
                .magicRegist(20)
                .abilities(Ability.Legion)

                .update(P310)
                .cost(375)
                .health(200)
                .magicRegist(0)

                .update(P314)
                .build(RejuvenationBead, ClothArmor, RubyCrystal, NullMagicMantle)
                .cost(595);
    });

    /** Amplifying Tome */
    public static final Item AmplifyingTome = new Item(1052, "Amplifying Tome", item -> {
        item.cost(435).abilityPower(20);
    });

    /** Archangel's Staff */
    public static final Item ArchangelsStaff = new Item(3003, "Archangel's Staff", item -> {
        item.build(TearOftheGoddess, BlastingWand)
                .cost(1140)
                .abilityPower(60)
                .manaRegen(10)
                .mana(250)
                .abilities(Ability.ArchangelInsight, Ability.ManaCharge);
    });

    /** Athene's Unholy Grail */
    public static final Item AthenesUnholyGrail = new Item(3174, "Athene's Unholy Grail", item -> {
        item.build(ChaliceOfHarmony, FiendishCodex)
                .cost(900)
                .abilityPower(60)
                .manaRegen(15)
                .magicRegist(40)
                .cooldownReduction(20)
                .abilities(Ability.AtheneRestore, Ability.ManaFont);
    });

    /** Atma's Impaler */
    public static final Item AtmasImpaler = new Item(3005, "Atma's Impaler", item -> {
        item.build(AvariceBlade, ChainVest).cost(780).armor(45).critical(15).abilities(Ability.AtamDamage);
    });

    /** Augment: Power */
    public static final Item AugmentPower = new Item(3196, "Augment: Power", item -> {
        item.build(TheHexCore).cost(1000).abilityPower(45).abilities(Ability.HexCorePower, Ability.HexCoreDeath);
    });

    /** Augment: Gravity */
    public static final Item AugmentGravity = new Item(3197, "Augment: Gravity", item -> {
        item.build(TheHexCore)
                .cost(1000)
                .cooldownReduction(10)
                .manaRegen(5)
                .mana(200)
                .abilities(Ability.HexCorePower, Ability.HexCoreGravity);
    });

    /** Augment: Death */
    public static final Item AugmentDeath = new Item(3198, "Augment: Death", item -> {
        item.build(TheHexCore)
                .cost(1000)
                .health(220)
                .healthRegen(6)
                .abilities(Ability.HexCorePower, Ability.HexCoreTransfer);
    });

    /** Avarice Blade */
    public static final Item AvariceBlade = new Item(3093, "Avarice Blade", item -> {
        item.build(BrawlersGloves).cost(400).critical(10).abilities(Ability.Avarice, Ability.Greed);
    });

    /** B. F. Sword */
    public static final Item BFSword = new Item(1038, "B. F. Sword", item -> {
        item.cost(1550).attackDamage(45);
    });

    /** Banner of Command */
    public static final Item BannerOfCommand = new Item(3060, "Banner of Command", item -> {
        item.build(FiendishCodex, EmblemOfValor)
                .cost(890)
                .abilityPower(40)
                .cooldownReduction(10)
                .armor(30)
                .abilities(Ability.AegisValor, Ability.Promote)

                .update(P314)
                .build(FiendishCodex, BlastingWand)
                .cost(720)
                .abilityPower(80)
                .cooldownReduction(20)
                .armor(0);
    });

    /** Banshee's Veil */
    public static final Item BansheesVeil = new Item(3102, "Banshee's Veil", item -> {
        item.build(NegatronCloak, CatalystTheProtector)
                .cost(600)
                .health(400)
                .mana(300)
                .magicRegist(45)
                .abilities(Ability.BansheeShield)

                .update(P310)
                .build(SpectresCowl, RubyCrystal)
                .cost(875)
                .health(450)
                .magicRegist(55)
                .mana(0)
                .abilities(Ability.BansheeShield, Ability.BansheeRegene);
    });

    /** Berserker's Greaves */
    public static final Item BerserkersGreaves = new Item(3006, "Berserker's Greaves", item -> {
        item.build(BootsOfSpeed, Dagger).cost(150).attackSpeed(20).abilities(Ability.EnhancedMovement2)

        .update(P308).cost(175);
    });

    /** Bilgewater Cutlass */
    public static final Item BilgewaterCutlass = new Item(3144, "Bilgewater Cutlass", item -> {
        item.build(LongSword, VampiricScepter).cost(150).lifeSteal(12).attackDamage(25).abilities(Ability.Bilgewater);
    });

    /** The Black Cleaver */
    public static final Item TheBlackCleaver = new Item(3071, "The Black Cleaver", item -> {
        item.build(TheBrutalizer, RubyCrystal)
                .cost(1188)
                .attackDamage(50)
                .health(200)
                .cooldownReduction(10)
                .abilities(Ability.TheBlackCleaverPassive, Ability.TheBlackCleaverUniquePassive);
    });

    /** Blade of the Ruined King */
    public static final Item BladeOftheRuinedKing = new Item(3153, "Blade of the Ruined King", item -> {
        item.build(BilgewaterCutlass, Dagger, Dagger)
                .cost(1000)
                .lifeSteal(15)
                .attackDamage(25)
                .attackSpeed(40)
                .abilities(Ability.BotRKPassive, Ability.BotRKActive);
    });

    /** Blasting Wand */
    public static final Item BlastingWand = new Item(1026, "Blasting Wand", item -> {
        item.cost(860).abilityPower(40);
    });

    /** The Bloodthirster */
    public static final Item TheBloodthirster = new Item(3072, "The Bloodthirster", item -> {
        item.build(BFSword, VampiricScepter)
                .cost(850)
                .lifeSteal(12)
                .attackDamage(70)
                .abilities(Ability.TheBloodthirsterPassive);
    });

    /** Bonetooth Necklace */
    public static final Item BonetoothNecklace = new Item(3166, "Bonetooth Necklace", item -> {
        item.cost(800).attackDamage(5).abilities(Ability.BonetoothNecklaceDamage, Ability.BonetoothNecklaceSpecial);
    });

    /** Boots of Mobility */
    public static final Item BootsOfMobility = new Item(3117, "Boots of Mobility", item -> {
        item.build(BootsOfSpeed).cost(650).abilities(Ability.EnhancedMovement5)

        .update(P308).cost(675);
    });

    /** Boots of Speed */
    public static final Item BootsOfSpeed = new Item(1001, "Boots of Speed", item -> {
        item.cost(350).abilities(Ability.EnhancedMovement1)

        .update(P308).cost(325);
    });

    /** Boots of Swiftness */
    public static final Item BootsOfSwiftness = new Item(3009, "Boots of Swiftness", item -> {
        item.build(BootsOfSpeed).cost(650).abilities(Ability.EnhancedMovement3, Ability.SlowResist)

        .update(P308).cost(675);
    });

    /** Brawler's Gloves */
    public static final Item BrawlersGloves = new Item(1051, "Brawler's Gloves", item -> {
        item.cost(400).critical(8);
    });

    /** The Brutalizer */
    public static final Item TheBrutalizer = new Item(3134, "The Brutalizer", item -> {
        item.build(LongSword, LongSword).cost(537).attackDamage(25).abilities(Ability.TheBrutalizerPassive);
    });

    /** Catalyst the Protector */
    public static final Item CatalystTheProtector = new Item(3010, "Catalyst the Protector", item -> {
        item.build(RubyCrystal, SapphireCrystal).cost(325).health(200).mana(300).abilities(Ability.ValorsReward);
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
                .abilities(Ability.ManaFont);
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
        item.cost(345).abilities(Ability.CrystallineFlaskActive, Ability.CrystallineFlaskCharge);
    });

    /** Dagger */
    public static final Item Dagger = new Item(1042, "Dagger", item -> {
        item.cost(400).attackSpeed(12);
    });

    /** Deathfire Grasp */
    public static final Item DeathfireGrasp = new Item(3128, "Deathfire Grasp", item -> {
        item.build(FiendishCodex, NeedlesslyLargeRod)
                .cost(680)
                .abilityPower(120)
                .cooldownReduction(10)
                .abilities(Ability.DeathfireGraspActive);
    });

    /** Doran's Blade */
    public static final Item DoransBlade = new Item(1055, "Doran's Blade", item -> {
        item.cost(475).attackDamage(10).health(80).abilities(Ability.DransBladePassive)

        .update(P314).cost(440).attackDamage(8);
    });

    /** Doran's Ring */
    public static final Item DoransRing = new Item(1056, "Doran's Ring", item -> {
        item.cost(475).abilityPower(15).health(80).manaRegen(3).abilities(Ability.DransRingPassive)

        .update(P308).cost(400).health(60);
    });

    /** Doran's Shield */
    public static final Item DoransShield = new Item(1054, "Doran's Shield", item -> {
        item.cost(475).health(100).healthRegen(8).armor(5).abilities(Ability.DransShieldPassive)

        .update(P308).cost(440).armor(0).healthRegen(10);
    });

    /** Eleisa's Miracle */
    public static final Item EleisasMiracle = new Item(3173, "Eleisa's Miracle", item -> {
        item.build(PhilosophersStone)
                .cost(400)
                .manaRegen(15)
                .healthRegen(10)
                .abilities(Ability.Aid, Ability.EleisasBlessing)

                .update(P314)
                .deprecated();
    });

    /** Elixir of Brilliance */
    public static final Item ElixirOfBrilliance = new Item(2039, "Elixir of Brilliance", item -> {
        item.cost(250).abilities(Ability.ElixirOfBrillianceActive);
    });

    /** Elixir of Fortitude */
    public static final Item ElixirOfFortitude = new Item(2037, "Elixir of Fortitude", item -> {
        item.cost(350).abilities(Ability.ElixirOfFortitudeActive);
    });

    /** Emblem of Valor */
    public static final Item EmblemOfValor = new Item(3097, "Emblem of Valor", item -> {
        item.build(ClothArmor, RejuvenationBead).cost(170).armor(20).abilities(Ability.Valor);
    });

    /** Executioner's Calling */
    public static final Item ExecutionersCalling = new Item(3123, "Executioner's Calling", item -> {
        item.build(AvariceBlade, LongSword)
                .cost(700)
                .attackDamage(25)
                .critical(20)
                .abilities(Ability.ExecutionersCallingPassive);
    });

    /** Faerie Charm */
    public static final Item FaerieCharm = new Item(1004, "Faerie Charm", item -> {
        item.cost(180).manaRegen(3);
    });

    /** Fiendish Codex */
    public static final Item FiendishCodex = new Item(3108, "Fiendish Codex", item -> {
        item.build(AmplifyingTome).cost(385).abilityPower(30).abilities(Ability.FiendishCodexPassive);
    });

    /** Frozen Heart */
    public static final Item FrozenHeart = new Item(3110, "Frozen Heart", item -> {
        item.build(GlacialShroud, WardensMail)
                .cost(550)
                .cooldownReduction(20)
                .armor(95)
                .mana(400)
                .abilities(Ability.FrozenHeartPassive);
    });

    /** Frozen Mallet */
    public static final Item FrozenMallet = new Item(3022, "Frozen Mallet", item -> {
        item.build(Phage, GiantsBelt).cost(835).attackDamage(30).health(700).abilities(Ability.Icy2)

        .update(P310A).build(GiantsBelt, Pickaxe, RubyCrystal).cost(950);
    });

    /** Giant's Belt */
    public static final Item GiantsBelt = new Item(1011, "Giant's Belt", item -> {
        item.cost(1000).health(380);
    });

    /** Glacial Shroud */
    public static final Item GlacialShroud = new Item(3024, "Glacial Shroud", item -> {
        item.build(SapphireCrystal, ChainVest).cost(230).armor(45).mana(300).abilities(Ability.GlacialShroudPassive);
    });

    /** Guardian Angel */
    public static final Item GuardianAngel = new Item(3026, "Guardian Angel", item -> {
        item.build(NullMagicMantle, ChainVest)
                .cost(1480)
                .armor(50)
                .magicRegist(30)
                .abilities(Ability.GuardianAngelPassive)

                .update(P310)
                .build(NegatronCloak, ChainVest)
                .cost(1310)
                .magicRegist(40);
    });

    /** Guinsoo's Rageblade */
    public static final Item GuinsoosRageblade = new Item(3124, "Guinsoo's Rageblade", item -> {
        item.build(BlastingWand, Pickaxe)
                .cost(865)
                .attackDamage(30)
                .abilityPower(40)
                .abilities(Ability.GuinsooPassive, Ability.GuinsooUniquePassive);
    });

    /** Haunting Guise */
    public static final Item HauntingGuise = new Item(3136, "Haunting Guise", item -> {
        item.build(RubyCrystal, AmplifyingTome).cost(575).abilityPower(25).health(200).abilities(Ability.EyesOfPain);
    });

    /** Health Potion */
    public static final Item HealthPotion = new Item(2003, "Health Potion", item -> {
        item.cost(35).abilities(Ability.PortionHealth);
    });

    /** The Hex Core */
    public static final Item TheHexCore = new Item(3200, "The Hex Core", item -> {
        item.cost(0).abilities(Ability.TheHexCorePassive);
    });

    /** Hexdrinker */
    public static final Item Hexdrinker = new Item(3155, "Hexdrinker", item -> {
        item.build(LongSword, NullMagicMantle).cost(550).attackDamage(25).magicRegist(25).abilities(Ability.Lifeline1);
    });

    /** Hextech Gunblade */
    public static final Item HextechGunblade = new Item(3146, "Hextech Gunblade", item -> {
        item.build(BilgewaterCutlass, HextechRevolver)
                .cost(800)
                .lifeSteal(12)
                .attackDamage(45)
                .abilityPower(65)
                .abilities(Ability.GunbladePassive, Ability.Reload, Ability.GunbladeActive);
    });

    /** Hextech Revolver */
    public static final Item HextechRevolver = new Item(3145, "Hextech Revolver", item -> {
        item.build(AmplifyingTome, AmplifyingTome).cost(330).abilityPower(40).abilities(Ability.HextechRevolverPassive);
    });

    /** Hunter's Machete */
    public static final Item HuntersMachete = new Item(1039, "Hunter's Machete", item -> {
        item.cost(300).abilities(Ability.Butcher1, Ability.Rend)

        .update(P308).abilities(Ability.Butcher1, Ability.Maim1);
    });

    /** Iceborn Gauntlet */
    public static final Item IcebornGauntlet = new Item(3025, "Iceborn Gauntlet", item -> {
        item.build(Sheen, GlacialShroud)
                .cost(700)
                .abilityPower(30)
                .cooldownReduction(10)
                .armor(70)
                .mana(500)
                .abilities(Ability.Spellblade);
    });

    /** Infinity Edge */
    public static final Item InfinityEdge = new Item(3031, "Infinity Edge", item -> {
        item.build(BFSword, CloakOfAgility, Pickaxe)
                .cost(645)
                .attackDamage(70)
                .critical(25)
                .abilities(Ability.InfinityEdgePassive);
    });

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsOfLucidity = new Item(3158, "Ionian Boots of Lucidity", item -> {
        item.build(BootsOfSpeed).cost(700).abilities(Ability.IonianCDR, Ability.EnhancedMovement2)

        .update(P306).cost(650)

        .update(P308).cost(675);
    });

    /** Kage's Lucky Pick */
    public static final Item KagesLuckyPick = new Item(3098, "Kage's Lucky Pick", item -> {
        item.build(AmplifyingTome).cost(330).abilityPower(25).abilities(Ability.LuckyShadow);
    });

    /** Kindlegem */
    public static final Item Kindlegem = new Item(3067, "Kindlegem", item -> {
        item.build(RubyCrystal).cost(375).health(200).abilities(Ability.KindlegemPassive);
    });

    /** Last Whisper */
    public static final Item LastWhisper = new Item(3035, "Last Whisper", item -> {
        item.build(LongSword, Pickaxe).cost(1025).attackDamage(40).abilities(Ability.LastWhisperPassive);
    });

    /** Liandry's Torment */
    public static final Item LiandrysTorment = new Item(3151, "Liandry's Torment", item -> {
        item.build(HauntingGuise, AmplifyingTome)
                .cost(980)
                .abilityPower(50)
                .health(300)
                .abilities(Ability.EyesOfPain, Ability.LiandrysTormentPassive);
    });

    /** Lich Bane */
    public static final Item LichBane = new Item(3100, "Lich Bane", item -> {
        item.build(Sheen, BlastingWand)
                .cost(940)
                .abilityPower(80)
                .mana(250)
                .movementSpeed(5)
                .abilities(Ability.LichSpellblade);
    });

    /** Locket of the Iron Solari */
    public static final Item LocketOftheIronSolari = new Item(3190, "Locket of the Iron Solari", item -> {
        item.build(Kindlegem, ClothArmor, RejuvenationBead)
                .cost(520)
                .health(300)
                .cooldownReduction(10)
                .armor(35)
                .healthRegen(5)
                .abilities(Ability.SolariActive)

                .update(P310)
                .build(AegisOftheLegion)
                .cost(600)
                .health(300)
                .armor(20)
                .cooldownReduction(10)
                .healthRegen(0)
                .abilities(Ability.SolariActive, Ability.Legion);
    });

    /** Long Sword */
    public static final Item LongSword = new Item(1036, "Long Sword", item -> {
        item.cost(400).attackDamage(10)

        .update(P314).cost(360);
    });

    /** Madred's Razors */
    public static final Item MadredsRazors = new Item(3106, "Madred's Razors", item -> {
        item.build(ClothArmor, HuntersMachete).cost(100).armor(25).abilities(Ability.Maim1, Ability.Rend)

        .update(P308).abilities(Ability.Maim2);
    });

    /** Malady */
    public static final Item Malady = new Item(3114, "Malady", item -> {
        item.build(Dagger, Dagger, AmplifyingTome)
                .cost(800)
                .abilityPower(25)
                .attackSpeed(45)
                .abilities(Ability.MaladyPassive)

                .update(P308)
                .deprecated();
    });

    /** Mana Manipulator */
    public static final Item ManaManipulator = new Item(3037, "Mana Manipulator", item -> {
        item.build(FaerieCharm, FaerieCharm).cost(40).abilities(Ability.ManaWarp)

        .update(P307).build(FaerieCharm).cost(120).abilities(Ability.ManaWarp)

        .update(P314).deprecated();
    });

    /** Mana Potion */
    public static final Item ManaPotion = new Item(2004, "Mana Potion", item -> {
        item.cost(35).abilities(Ability.PortionMana);
    });

    /** Manamune */
    public static final Item Manamune = new Item(3004, "Manamune", item -> {
        item.build(TearOftheGoddess, LongSword)
                .cost(1000)
                .attackDamage(20)
                .manaRegen(7)
                .mana(250)
                .abilities(Ability.Awe, Ability.ManamuneManaCharge);
    });

    /** Maw of Malmortius */
    public static final Item MawOfMalmortius = new Item(3156, "Maw of Malmortius", item -> {
        item.build(Hexdrinker, Pickaxe)
                .cost(975)
                .attackDamage(55)
                .magicRegist(36)
                .abilities(Ability.MawOfMalmortiusPassive, Ability.Lifeline2)

                .update(P309)
                .attackDamage(60)
                .magicRegist(40);
    });

    /** Mejai's Soulstealer */
    public static final Item MejaisSoulstealer = new Item(3041, "Mejai's Soulstealer", item -> {
        item.build(AmplifyingTome).cost(800).abilityPower(20).abilities(Ability.MejaisSoulstealerPassive);
    });

    /** Mercurial Scimitar */
    public static final Item MercurialScimitar = new Item(3139, "Mercurial Scimitar", item -> {
        item.build(QuicksilverSash, BFSword).cost(600).attackDamage(60).magicRegist(45).abilities(Ability.Quicksilver2);
    });

    /** Mercury's Treads */
    public static final Item MercurysTreads = new Item(3111, "Mercury's Treads", item -> {
        item.build(BootsOfSpeed, NullMagicMantle)
                .cost(450)
                .magicRegist(25)
                .abilities(Ability.EnhancedMovement2, Ability.TenacityPassive)

                .update(P308)
                .cost(475);
    });

    /** Mikael's Crucible */
    public static final Item MikaelsCrucible = new Item(3222, "Mikael's Crucible", item -> {
        item.build(ChaliceOfHarmony, SapphireCrystal)
                .cost(920)
                .manaRegen(9)
                .mana(300)
                .magicRegist(40)
                .abilities(Ability.ManaFont, Ability.MikaelsCrucibleActive)

                .update(P307)
                .build(ChaliceOfHarmony, PhilosophersStone)
                .cost(920)
                .manaRegen(18)
                .healthRegen(7)
                .magicRegist(40)
                .abilities(Ability.ManaFont, Ability.MikaelsCrucibleActive)

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
                .abilities(Ability.MorellonomiconPassive);
    });

    /** Muramana */
    public static final Item Muramana = new Item(3042, "Muramana", item -> {
        item.build(Manamune)
                .cost(0)
                .attackDamage(20)
                .manaRegen(7)
                .mana(1000)
                .abilities(Ability.Awe, Ability.MuramanaToggle);
    });

    /** Nashor's Tooth */
    public static final Item NashorsTooth = new Item(3115, "Nashor's Tooth", item -> {
        item.build(Stinger, FiendishCodex)
                .cost(430)
                .abilityPower(65)
                .attackSpeed(50)
                .abilities(Ability.NashorsToothPassive)

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
                .abilities(Ability.NinjaTabiPassive, Ability.EnhancedMovement2)

                .update(P308)
                .cost(375);
    });

    /** Null-Magic Mantle */
    public static final Item NullMagicMantle = new Item(1033, "Null-Magic Mantle", item -> {
        item.cost(400).magicRegist(20);
    });

    /** Ohmwrecker */
    public static final Item Ohmwrecker = new Item(3056, "Ohmwrecker", item -> {
        item.build(RubyCrystal, BlastingWand, PhilosophersStone)
                .cost(800)
                .abilityPower(50)
                .health(350)
                .manaRegen(15)
                .healthRegen(15)
                .abilities(Ability.OhmwreckerActive)

                .update(P314)
                .build(RubyCrystal, BlastingWand)
                .cost(665)
                .abilityPower(50)
                .health(350)
                .manaRegen(0)
                .healthRegen(0)
                .abilities(Ability.OhmwreckerActive);
    });

    /** Oracle's Elixir */
    public static final Item OraclesElixir = new Item(2042, "Oracle's Elixir", item -> {
        item.cost(400).abilities(Ability.OraclesElixirActive)

        .update(P314).deprecated();
    });

    /** Phage */
    public static final Item Phage = new Item(3044, "Phage", item -> {
        item.build(RubyCrystal, LongSword).cost(590).attackDamage(20).health(200).abilities(Ability.Icy1)

        .update(P310A).cost(375).abilities(Ability.Rage)

        .update(P312).cost(475);
    });

    /** Phantom Dancer */
    public static final Item PhantomDancer = new Item(3046, "Phantom Dancer", item -> {
        item.build(CloakOfAgility, Zeal, Dagger)
                .cost(495)
                .attackSpeed(50)
                .movementSpeed(5)
                .critical(30)
                .abilities(Ability.PhantomDancerPassive);
    });

    /** Philosopher's Stone */
    public static final Item PhilosophersStone = new Item(3096, "Philosopher's Stone", item -> {
        item.build(FaerieCharm, RejuvenationBead).cost(340).manaRegen(9).healthRegen(7).abilities(Ability.Transmute)

        .update(P314).deprecated();
    });

    /** Pickaxe */
    public static final Item Pickaxe = new Item(1037, "Pickaxe", item -> {
        item.cost(875).attackDamage(25);
    });

    /** Quicksilver Sash */
    public static final Item QuicksilverSash = new Item(3140, "Quicksilver Sash", item -> {
        item.build(NegatronCloak).cost(830).magicRegist(45).abilities(Ability.Quicksilver1);
    });

    /** Rabadon's Deathcap */
    public static final Item RabadonsDeathcap = new Item(3089, "Rabadon's Deathcap", item -> {
        item.build(BlastingWand, NeedlesslyLargeRod)
                .cost(840)
                .abilityPower(120)
                .abilities(Ability.RabadonsDeathcapPassive);
    });

    /** Randuin's Omen */
    public static final Item RanduinsOmen = new Item(3143, "Randuin's Omen", item -> {
        item.build(GiantsBelt, WardensMail)
                .cost(1000)
                .health(500)
                .armor(70)
                .abilities(Ability.ColdSteel2, Ability.RanduinsOmenAvtive);
    });

    /** Ravenous Hydra */
    public static final Item RavenousHydra = new Item(3074, "Ravenous Hydra", item -> {
        item.build(Tiamat, VampiricScepter)
                .cost(200)
                .lifeSteal(12)
                .attackDamage(75)
                .healthRegen(15)
                .abilities(Ability.RavenousHydraPassive, Ability.Cleave, Ability.Crescent)

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
                .abilities(Ability.RodOfAgesPassive, Ability.ValorsReward);
    });

    /** Ruby Crystal */
    public static final Item RubyCrystal = new Item(1028, "Ruby Crystal", item -> {
        item.cost(475).health(180);
    });

    /** Ruby Sightstone */
    public static final Item RubySightstone = new Item(2045, "Ruby Sightstone", item -> {
        item.build(RubyCrystal, Sightstone).cost(125).health(360).abilities(Ability.WardRefresh2, Ability.GhostWard2)

        .update(P314).abilities(Ability.WardRefresh2, Ability.GhostWard1);
    });

    /** Runaan's Hurricane */
    public static final Item RunaansHurricane = new Item(3085, "Runaan's Hurricane", item -> {
        item.build(Dagger, RecurveBow, Dagger).cost(700).attackSpeed(70).abilities(Ability.RunaansHurricanePassive);
    });

    /** Runic Bulwark */
    public static final Item RunicBulwark = new Item(3107, "Runic Bulwark", item -> {
        item.build(NullMagicMantle, AegisOftheLegion)
                .cost(400)
                .health(300)
                .armor(20)
                .magicRegist(30)
                .abilities(Ability.BulwarkLegion)

                .update(P310)
                .deprecated();
    });

    /** Rylai's Crystal Scepter */
    public static final Item RylaisCrystalScepter = new Item(3116, "Rylai's Crystal Scepter", item -> {
        item.build(BlastingWand, AmplifyingTome, GiantsBelt)
                .cost(605)
                .abilityPower(80)
                .health(500)
                .abilities(Ability.RylaisCrystalScepterPassive);
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
                .abilities(Ability.Insight, Ability.ManaShield);
    });

    /** Seeker's Armguard */
    public static final Item SeekersArmguard = new Item(3191, "Seeker's Armguard", item -> {
        item.build(AmplifyingTome, ClothArmor, ClothArmor)
                .cost(125)
                .abilityPower(20)
                .armor(30)
                .abilities(Ability.SeekersArmguardPassive);
    });

    /** Shard of True Ice */
    public static final Item ShardOfTrueIce = new Item(3092, "Shard of True Ice", item -> {
        item.build(KagesLuckyPick, ManaManipulator)
                .cost(535)
                .abilityPower(45)
                .abilities(Ability.LuckyShadow, Ability.ManaWarp, Ability.ShardOfTrueIceActive);
    });

    /** Sheen */
    public static final Item Sheen = new Item(3057, "Sheen", item -> {
        item.build(SapphireCrystal, AmplifyingTome)
                .cost(365)
                .abilityPower(25)
                .mana(200)
                .abilities(Ability.SheenSpellblade);
    });

    /** Shurelya's Reverie */
    public static final Item ShurelyasReverie = new Item(3069, "Shurelya's Reverie", item -> {
        item.build(Kindlegem, PhilosophersStone)
                .cost(550)
                .health(250)
                .cooldownReduction(10)
                .manaRegen(10)
                .healthRegen(10)
                .abilities(Ability.ShurelyasReverieAvtive)

                .update(P314)
                .deprecated();
    });

    /** Sight Ward */
    public static final Item StealthWard = new Item(2044, "Stealth Ward", item -> {
        item.cost(75).abilities(Ability.StealthWardAvtive);
    });

    /** Sightstone */
    public static final Item Sightstone = new Item(2049, "Sightstone", item -> {
        item.build(RubyCrystal).cost(475).health(180).abilities(Ability.WardRefresh1, Ability.GhostWard1);
    });

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoes = new Item(3020, "Sorcerer's Shoes", item -> {
        item.build(BootsOfSpeed).cost(750).set(MRPen, 15).abilities(Ability.EnhancedMovement2)

        .update(P308).cost(775);
    });

    /** Spectre's Cowl */
    public static final Item SpectresCowl = new Item(9999, "Spectre's Cowl", item -> {
        item.build(NegatronCloak, RubyCrystal)
                .cost(205)
                .health(200)
                .magicRegist(45)
                .abilities(Ability.SpectresCowlPassive);
    });

    /** Spirit Stone */
    public static final Item SpiritStone = new Item(1080, "Spirit Stone", item -> {
        item.build(HuntersMachete, FaerieCharm, RejuvenationBead)
                .cost(40)
                .manaRegen(7)
                .healthRegen(14)
                .abilities(Ability.Butcher2, Ability.Rend)

                .update(P308)
                .abilities(Ability.Butcher2, Ability.Maim1);
    });

    /** Spirit of the Ancient Golem */
    public static final Item SpiritOftheAncientGolem = new Item(3207, "Spirit of the Ancient Golem", item -> {
        item.build(SpiritStone, Kindlegem)
                .cost(450)
                .health(500)
                .manaRegen(7)
                .healthRegen(14)
                .cooldownReduction(10)
                .abilities(Ability.Butcher3, Ability.TenacityPassive);
    });

    /** Spirit of the Elder Lizard */
    public static final Item SpiritOftheElderLizard = new Item(3209, "Spirit of the Elder Lizard", item -> {
        item.build(SpiritStone, LongSword, LongSword)
                .cost(500)
                .attackDamage(45)
                .cooldownReduction(10)
                .manaRegen(7)
                .healthRegen(14)
                .abilities(Ability.Butcher3, Ability.Incinerate)

                .update(P308)
                .attackDamage(35);
    });

    /** Spirit of the Spectral Wraith */
    public static final Item SpiritOftheSpectralWraith = new Item(3206, "Spirit of the Spectral Wraith", item -> {
        item.build(SpiritStone, HextechRevolver)
                .cost(100)
                .abilityPower(50)
                .cooldownReduction(10)
                .manaRegen(10)
                .abilities(Ability.SpiritOftheSpectralWraithSV, Ability.Butcher3, Ability.SpiritOftheSpectralWraithSmite)

                .update(P308)
                .abilityPower(40);
    });

    /** Spirit Visage */
    public static final Item SpiritVisage = new Item(3065, "Spirit Visage", item -> {
        item.build(Kindlegem, NegatronCloak)
                .cost(630)
                .health(200)
                .cooldownReduction(20)
                .magicRegist(50)
                .abilities(Ability.SpiritVisagePassive)

                .update(P310)
                .build(SpectresCowl, Kindlegem)
                .cost(375)
                .health(400)
                .magicRegist(55)
                .healthRegen(20)

                .update(P310A)
                .cost(500);
    });

    /** Statikk Shiv */
    public static final Item StatikkShiv = new Item(3087, "Statikk Shiv", item -> {
        item.build(Zeal, AvariceBlade)
                .cost(525)
                .attackSpeed(40)
                .movementSpeed(6)
                .critical(20)
                .abilities(Ability.StatikkShivPassive);
    });

    /** Stinger */
    public static final Item Stinger = new Item(3101, "Stinger", item -> {
        item.build(Dagger, Dagger).cost(450).attackSpeed(40).abilities(Ability.StingerPassive);
    });

    /** Sunfire Cape */
    public static final Item SunfireCape = new Item(3068, "Sunfire Cape", item -> {
        item.build(ChainVest, GiantsBelt).cost(930).health(450).armor(45).abilities(Ability.SunfireCapePassive);
    });

    /** Sword of the Divine */
    public static final Item SwordOftheDivine = new Item(3131, "Sword of the Divine", item -> {
        item.build(RecurveBow, Dagger)
                .cost(850)
                .attackSpeed(45)
                .abilities(Ability.SwordOftheDivinePassive, Ability.SwordOftheDivineActive);
    });

    /** Sword of the Occult */
    public static final Item SwordOftheOccult = new Item(3141, "Sword of the Occult", item -> {
        item.build(LongSword).cost(800).attackDamage(10).abilities(Ability.SwordOftheOccultPassive);
    });

    /** Tear of the Goddess */
    public static final Item TearOftheGoddess = new Item(3070, "Tear of the Goddess", item -> {
        item.build(SapphireCrystal, FaerieCharm).cost(120).manaRegen(7).mana(250).abilities(Ability.TearManaCharge);
    });

    /** Thornmail */
    public static final Item Thornmail = new Item(3075, "Thornmail", item -> {
        item.build(ChainVest, ClothArmor).cost(1180).armor(100).abilities(Ability.ThornmailPassive);
    });

    /** Tiamat */
    public static final Item Tiamat = new Item(3077, "Tiamat", item -> {
        item.build(Pickaxe, LongSword, RejuvenationBead, RejuvenationBead)
                .cost(665)
                .attackDamage(50)
                .healthRegen(15)
                .abilities(Ability.Cleave, Ability.Crescent)

                .update(P306)
                .cost(265)
                .attackDamage(40);
    });

    /** Trinity Force */
    public static final Item TrinityForce = new Item(3078, "Trinity Force", item -> {
        item.build(Zeal, Sheen, Phage)
                .cost(3)
                .attackDamage(30)
                .abilityPower(30)
                .health(250)
                .attackSpeed(30)
                .mana(200)
                .movementSpeed(8)
                .critical(10)
                .abilities(Ability.Icy1, Ability.TrinitySpellblade)

                .update(P310A)
                .abilities(Ability.Rage, Ability.TrinitySpellblade);
    });

    /** Twin Shadows */
    public static final Item TwinShadows = new Item(3023, "Twin Shadows", item -> {
        item.build(KagesLuckyPick, NullMagicMantle)
                .cost(735)
                .abilityPower(40)
                .movementSpeed(6)
                .magicRegist(40)
                .abilities(Ability.Hunt)

                .update(P314)
                .build(AmplifyingTome, AmplifyingTome, NullMagicMantle)
                .cost(730)
                .abilityPower(50);
    });

    /** Vampiric Scepter */
    public static final Item VampiricScepter = new Item(1053, "Vampiric Scepter", item -> {
        item.build(LongSword).cost(400).lifeSteal(10).attackDamage(10);
    });

    /** Vision Ward */
    public static final Item VisionWard = new Item(2043, "Vision Ward", item -> {
        item.cost(125).abilities(Ability.VisionWardAvtive)

        .update(P314).cost(100);
    });

    /** Void Staff */
    public static final Item VoidStaff = new Item(3135, "Void Staff", item -> {
        item.build(BlastingWand, AmplifyingTome).cost(1000).abilityPower(70).abilities(Ability.VoidStaffPassive);
    });

    /** Warden's Mail */
    public static final Item WardensMail = new Item(3082, "Warden's Mail", item -> {
        item.build(ClothArmor, ClothArmor).cost(500).armor(50).abilities(Ability.ColdSteel1)

        .update(P310).cost(400);
    });

    /** Warmog's Armor */
    public static final Item WarmogsArmor = new Item(3083, "Warmog's Armor", item -> {
        item.build(GiantsBelt, RubyCrystal, RejuvenationBead, RejuvenationBead)
                .cost(995)
                .health(1000)
                .abilities(Ability.WarmogsArmorPassive);
    });

    /** Will of the Ancients */
    public static final Item WillOftheAncients = new Item(3152, "Will of the Ancients", item -> {
        item.build(KagesLuckyPick, HextechRevolver)
                .cost(585)
                .abilityPower(50)
                .abilities(Ability.WillOftheAncientsAura)

                .update(P314)
                .build(HextechRevolver, FaerieCharm, FaerieCharm)
                .cost(440)
                .abilityPower(50)
                .manaRegen(10)
                .cooldownReduction(10)
                .spellVamp(20)
                .abilities();
    });

    /** Wit's End */
    public static final Item WitsEnd = new Item(3091, "Wit's End", item -> {
        item.build(RecurveBow, NullMagicMantle)
                .cost(850)
                .attackSpeed(40)
                .magicRegist(25)
                .abilities(Ability.WitsEndPassive)

                .update(P308)
                .build(RecurveBow, NullMagicMantle, Dagger)
                .cost(700)
                .attackSpeed(42);
    });

    /** Wriggle's Lantern */
    public static final Item WrigglesLantern = new Item(3154, "Wriggle's Lantern", item -> {
        item.build(VampiricScepter, MadredsRazors)
                .cost(100)
                .lifeSteal(10)
                .attackDamage(15)
                .armor(30)
                .abilities(Ability.Maim2, Ability.WrigglesLanternAvtive)

                .update(P308)
                .attackDamage(25)
                .lifeSteal(15)
                .armor(25)
                .abilities(Ability.Maim3, Ability.WrigglesLanternAvtive)
                .cost(500);
    });

    /** Youmuu's Ghostblade */
    public static final Item YoumuusGhostblade = new Item(3142, "Youmuu's Ghostblade", item -> {
        item.build(AvariceBlade, TheBrutalizer)
                .cost(563)
                .attackDamage(30)
                .cooldownReduction(10)
                .critical(15)
                .abilities(Ability.YoumuusGhostbladePassive, Ability.YoumuusGhostbladeActive);
    });

    /** Zeal */
    public static final Item Zeal = new Item(3086, "Zeal", item -> {
        item.build(BrawlersGloves, Dagger).cost(375).attackSpeed(18).movementSpeed(5).critical(10);
    });

    /** Zeke's Herald */
    public static final Item ZekesHerald = new Item(3050, "Zeke's Herald", item -> {
        item.build(VampiricScepter, Kindlegem)
                .cost(900)
                .health(250)
                .cooldownReduction(20)
                .abilities(Ability.ZekesHeraldAura);
    });

    /** Zephyr */
    public static final Item Zephyr = new Item(3172, "Zephyr", item -> {
        item.build(Stinger, Pickaxe)
                .cost(725)
                .attackDamage(25)
                .cooldownReduction(10)
                .attackSpeed(50)
                .movementSpeed(10)
                .abilities(Ability.TenacityPassive);
    });

    /** Zhonya's Hourglass */
    public static final Item ZhonyasHourglass = new Item(3157, "Zhonya's Hourglass", item -> {
        item.build(NeedlesslyLargeRod, SeekersArmguard).cost(500).abilityPower(120).armor(50).abilities(Ability.Stasis);
    });

    /** Spellthief's Edge */
    public static final Item SpellthiefsEdge = new Item(3303, "Spellthief's Edge", item -> {
        item.cost(365).abilityPower(10).manaRegen(3);
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
