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

import static teemowork.model.ItemAbility.*;
import static teemowork.model.Status.*;
import static teemowork.model.Version.*;

import java.util.List;

import js.util.ArrayList;

/**
 * @version 2013/01/27 0:43:53
 */
public class Item {

    /** The item manager. */
    private static final List<Item> items = new ArrayList();

    /** Abyssal Scepter */
    public static final Item AbyssalScepter = new Item(3001, "Abyssal Scepter");

    /** Aegis of the Legion */
    public static final Item AegisOftheLegion = new Item(3105, "Aegis of the Legion");

    /** Amplifying Tome */
    public static final Item AmplifyingTome = new Item(1052, "Amplifying Tome");

    /** Archangel's Staff */
    public static final Item ArchangelsStaff = new Item(3003, "Archangel's Staff");

    /** Athene's Unholy Grail */
    public static final Item AthenesUnholyGrail = new Item(3174, "Athene's Unholy Grail");

    /** Atma's Impaler */
    public static final Item AtmasImpaler = new Item(3005, "Atma's Impaler");

    /** Augment: Power */
    public static final Item AugmentPower = new Item(3196, "Augment: Power");

    /** Augment: Gravity */
    public static final Item AugmentGravity = new Item(3197, "Augment: Gravity");

    /** Augment: Death */
    public static final Item AugmentDeath = new Item(3198, "Augment: Death");

    /** Avarice Blade */
    public static final Item AvariceBlade = new Item(3093, "Avarice Blade");

    /** B. F. Sword */
    public static final Item BFSword = new Item(1038, "B. F. Sword");

    /** Banner of Command */
    public static final Item BannerOfCommand = new Item(3060, "Banner of Command");

    /** Banshee's Veil */
    public static final Item BansheesVeil = new Item(3102, "Banshee's Veil");

    /** Berserker's Greaves */
    public static final Item BerserkersGreaves = new Item(3006, "Berserker's Greaves");

    /** Bilgewater Cutlass */
    public static final Item BilgewaterCutlass = new Item(3144, "Bilgewater Cutlass");

    /** The Black Cleaver */
    public static final Item TheBlackCleaver = new Item(3071, "The Black Cleaver");

    /** Blade of the Ruined King */
    public static final Item BladeOftheRuinedKing = new Item(3153, "Blade of the Ruined King");

    /** Blasting Wand */
    public static final Item BlastingWand = new Item(1026, "Blasting Wand");

    /** The Bloodthirster */
    public static final Item TheBloodthirster = new Item(3072, "The Bloodthirster");

    /** Bonetooth Necklace */
    public static final Item BonetoothNecklace = new Item(3166, "Bonetooth Necklace");

    /** Boots of Mobility */
    public static final Item BootsOfMobility = new Item(3117, "Boots of Mobility");

    /** Boots of Speed */
    public static final Item BootsOfSpeed = new Item(1001, "Boots of Speed");

    /** Boots of Swiftness */
    public static final Item BootsOfSwiftness = new Item(3009, "Boots of Swiftness");

    /** Brawler's Gloves */
    public static final Item BrawlersGloves = new Item(1051, "Brawler's Gloves");

    /** The Brutalizer */
    public static final Item TheBrutalizer = new Item(3134, "The Brutalizer");

    /** Catalyst the Protector */
    public static final Item CatalystTheProtector = new Item(3010, "Catalyst the Protector");

    /** Chain Vest */
    public static final Item ChainVest = new Item(1031, "Chain Vest");

    /** Chalice of Harmony */
    public static final Item ChaliceOfHarmony = new Item(3028, "Chalice of Harmony");

    /** Cloak of Agility */
    public static final Item CloakOfAgility = new Item(1018, "Cloak of Agility");

    /** Cloth Armor */
    public static final Item ClothArmor = new Item(1029, "Cloth Armor");

    /** Crystalline Flask */
    public static final Item CrystallineFlask = new Item(2041, "Crystalline Flask");

    /** Dagger */
    public static final Item Dagger = new Item(1042, "Dagger");

    /** Deathfire Grasp */
    public static final Item DeathfireGrasp = new Item(3128, "Deathfire Grasp");

    /** Doran's Blade */
    public static final Item DoransBlade = new Item(1055, "Doran's Blade");

    /** Doran's Ring */
    public static final Item DoransRing = new Item(1056, "Doran's Ring");

    /** Doran's Shield */
    public static final Item DoransShield = new Item(1054, "Doran's Shield");

    /** Eleisa's Miracle */
    public static final Item EleisasMiracle = new Item(3173, "Eleisa's Miracle");

    /** Elixir of Brilliance */
    public static final Item ElixirOfBrilliance = new Item(2039, "Elixir of Brilliance");

    /** Elixir of Fortitude */
    public static final Item ElixirOfFortitude = new Item(2037, "Elixir of Fortitude");

    /** Emblem of Valor */
    public static final Item EmblemOfValor = new Item(3097, "Emblem of Valor");

    /** Executioner's Calling */
    public static final Item ExecutionersCalling = new Item(3123, "Executioner's Calling");

    /** Faerie Charm */
    public static final Item FaerieCharm = new Item(1004, "Faerie Charm");

    /** Fiendish Codex */
    public static final Item FiendishCodex = new Item(3108, "Fiendish Codex");

    /** Frozen Heart */
    public static final Item FrozenHeart = new Item(3110, "Frozen Heart");

    /** Frozen Mallet */
    public static final Item FrozenMallet = new Item(3022, "Frozen Mallet");

    /** Giant's Belt */
    public static final Item GiantsBelt = new Item(1011, "Giant's Belt");

    /** Glacial Shroud */
    public static final Item GlacialShroud = new Item(3024, "Glacial Shroud");

    /** Guardian Angel */
    public static final Item GuardianAngel = new Item(3026, "Guardian Angel");

    /** Guinsoo's Rageblade */
    public static final Item GuinsoosRageblade = new Item(3124, "Guinsoo's Rageblade");

    /** Haunting Guise */
    public static final Item HauntingGuise = new Item(3136, "Haunting Guise");

    /** Health Potion */
    public static final Item HealthPotion = new Item(2003, "Health Potion");

    /** The Hex Core */
    public static final Item TheHexCore = new Item(3200, "The Hex Core");

    /** Hexdrinker */
    public static final Item Hexdrinker = new Item(3155, "Hexdrinker");

    /** Hextech Gunblade */
    public static final Item HextechGunblade = new Item(3146, "Hextech Gunblade");

    /** Hextech Revolver */
    public static final Item HextechRevolver = new Item(3145, "Hextech Revolver");

    /** Hunter's Machete */
    public static final Item HuntersMachete = new Item(1039, "Hunter's Machete");

    /** Iceborn Gauntlet */
    public static final Item IcebornGauntlet = new Item(3025, "Iceborn Gauntlet");

    /** Infinity Edge */
    public static final Item InfinityEdge = new Item(3031, "Infinity Edge");

    /** Ionian Boots of Lucidity */
    public static final Item IonianBootsOfLucidity = new Item(3158, "Ionian Boots of Lucidity");

    /** Kage's Lucky Pick */
    public static final Item KagesLuckyPick = new Item(3098, "Kage's Lucky Pick");

    /** Kindlegem */
    public static final Item Kindlegem = new Item(3067, "Kindlegem");

    /** Last Whisper */
    public static final Item LastWhisper = new Item(3035, "Last Whisper");

    /** Liandry's Torment */
    public static final Item LiandrysTorment = new Item(3151, "Liandry's Torment");

    /** Lich Bane */
    public static final Item LichBane = new Item(3100, "Lich Bane");

    /** Locket of the Iron Solari */
    public static final Item LocketOftheIronSolari = new Item(3190, "Locket of the Iron Solari");

    /** Long Sword */
    public static final Item LongSword = new Item(1036, "Long Sword");

    /** Madred's Razors */
    public static final Item MadredsRazors = new Item(3106, "Madred's Razors");

    /** Malady */
    public static final Item Malady = new Item(3114, "Malady");

    /** Mana Manipulator */
    public static final Item ManaManipulator = new Item(3037, "Mana Manipulator");

    /** Mana Potion */
    public static final Item ManaPotion = new Item(2004, "Mana Potion");

    /** Manamune */
    public static final Item Manamune = new Item(3004, "Manamune");

    /** Maw of Malmortius */
    public static final Item MawOfMalmortius = new Item(3156, "Maw of Malmortius");

    /** Mejai's Soulstealer */
    public static final Item MejaisSoulstealer = new Item(3041, "Mejai's Soulstealer");

    /** Mercurial Scimitar */
    public static final Item MercurialScimitar = new Item(3139, "Mercurial Scimitar");

    /** Mercury's Treads */
    public static final Item MercurysTreads = new Item(3111, "Mercury's Treads");

    /** Mikael's Crucible */
    public static final Item MikaelsCrucible = new Item(3222, "Mikael's Crucible");

    /** Morellonomicon */
    public static final Item Morellonomicon = new Item(3165, "Morellonomicon");

    /** Muramana */
    public static final Item Muramana = new Item(3042, "Muramana");

    /** Nashor's Tooth */
    public static final Item NashorsTooth = new Item(3115, "Nashor's Tooth");

    /** Needlessly Large Rod */
    public static final Item NeedlesslyLargeRod = new Item(1058, "Needlessly Large Rod");

    /** Negatron Cloak */
    public static final Item NegatronCloak = new Item(1057, "Negatron Cloak");

    /** Ninja Tabi */
    public static final Item NinjaTabi = new Item(3047, "Ninja Tabi");

    /** Null-Magic Mantle */
    public static final Item NullMagicMantle = new Item(1033, "Null-Magic Mantle");

    /** Ohmwrecker */
    public static final Item Ohmwrecker = new Item(3056, "Ohmwrecker");

    /** Oracle's Elixir */
    public static final Item OraclesElixir = new Item(2042, "Oracle's Elixir");

    /** Phage */
    public static final Item Phage = new Item(3044, "Phage");

    /** Phantom Dancer */
    public static final Item PhantomDancer = new Item(3046, "Phantom Dancer");

    /** Philosopher's Stone */
    public static final Item PhilosophersStone = new Item(3096, "Philosopher's Stone");

    /** Pickaxe */
    public static final Item Pickaxe = new Item(1037, "Pickaxe");

    /** Quicksilver Sash */
    public static final Item QuicksilverSash = new Item(3140, "Quicksilver Sash");

    /** Rabadon's Deathcap */
    public static final Item RabadonsDeathcap = new Item(3089, "Rabadon's Deathcap");

    /** Randuin's Omen */
    public static final Item RanduinsOmen = new Item(3143, "Randuin's Omen");

    /** Ravenous Hydra */
    public static final Item RavenousHydra = new Item(3074, "Ravenous Hydra");

    /** Recurve Bow */
    public static final Item RecurveBow = new Item(1043, "Recurve Bow");

    /** Rejuvenation Bead */
    public static final Item RejuvenationBead = new Item(1006, "Rejuvenation Bead");

    /** Rod of Ages */
    public static final Item RodOfAges = new Item(3027, "Rod of Ages");

    /** Ruby Crystal */
    public static final Item RubyCrystal = new Item(1028, "Ruby Crystal");

    /** Ruby Sightstone */
    public static final Item RubySightstone = new Item(2045, "Ruby Sightstone");

    /** Runaan's Hurricane */
    public static final Item RunaansHurricane = new Item(3085, "Runaan's Hurricane");

    /** Runic Bulwark */
    public static final Item RunicBulwark = new Item(3107, "Runic Bulwark");

    /** Rylai's Crystal Scepter */
    public static final Item RylaisCrystalScepter = new Item(3116, "Rylai's Crystal Scepter");

    /** Sapphire Crystal */
    public static final Item SapphireCrystal = new Item(1027, "Sapphire Crystal");

    /** Seraph's Embrace */
    public static final Item SeraphsEmbrace = new Item(3040, "Seraph's Embrace");

    /** Shard of True Ice */
    public static final Item ShardOfTrueIce = new Item(3092, "Shard of True Ice");

    /** Sheen */
    public static final Item Sheen = new Item(3057, "Sheen");

    /** Shurelya's Reverie */
    public static final Item ShurelyasReverie = new Item(3069, "Shurelya's Reverie");

    /** Sight Ward */
    public static final Item SightWard = new Item(2044, "Sight Ward");

    /** Sightstone */
    public static final Item Sightstone = new Item(2049, "Sightstone");

    /** Sorcerer's Shoes */
    public static final Item SorcerersShoes = new Item(3020, "Sorcerer's Shoes");

    /** Spirit Stone */
    public static final Item SpiritStone = new Item(1080, "Spirit Stone");

    /** Spirit of the Ancient Golem */
    public static final Item SpiritOftheAncientGolem = new Item(3207, "Spirit of the Ancient Golem");

    /** Spirit of the Elder Lizard */
    public static final Item SpiritOftheElderLizard = new Item(3209, "Spirit of the Elder Lizard");

    /** Spirit of the Spectral Wraith */
    public static final Item SpiritOftheSpectralWraith = new Item(3206, "Spirit of the Spectral Wraith");

    /** Spirit Visage */
    public static final Item SpiritVisage = new Item(3065, "Spirit Visage");

    /** Statikk Shiv */
    public static final Item StatikkShiv = new Item(3087, "Statikk Shiv");

    /** Stinger */
    public static final Item Stinger = new Item(3101, "Stinger");

    /** Sunfire Cape */
    public static final Item SunfireCape = new Item(3068, "Sunfire Cape");

    /** Sword of the Divine */
    public static final Item SwordOftheDivine = new Item(3131, "Sword of the Divine");

    /** Sword of the Occult */
    public static final Item SwordOftheOccult = new Item(3141, "Sword of the Occult");

    /** Tear of the Goddess */
    public static final Item TearOftheGoddess = new Item(3070, "Tear of the Goddess");

    /** Thornmail */
    public static final Item Thornmail = new Item(3075, "Thornmail");

    /** Tiamat */
    public static final Item Tiamat = new Item(3077, "Tiamat");

    /** Trinity Force */
    public static final Item TrinityForce = new Item(3078, "Trinity Force");

    /** Twin Shadows */
    public static final Item TwinShadows = new Item(3023, "Twin Shadows");

    /** Vampiric Scepter */
    public static final Item VampiricScepter = new Item(1053, "Vampiric Scepter");

    /** Vision Ward */
    public static final Item VisionWard = new Item(2043, "Vision Ward");

    /** Void Staff */
    public static final Item VoidStaff = new Item(3135, "Void Staff");

    /** Warden's Mail */
    public static final Item WardensMail = new Item(3082, "Warden's Mail");

    /** Warmog's Armor */
    public static final Item WarmogsArmor = new Item(3083, "Warmog's Armor");

    /** Will of the Ancients */
    public static final Item WillOftheAncients = new Item(3152, "Will of the Ancients");

    /** Wit's End */
    public static final Item WitsEnd = new Item(3091, "Wit's End");

    /** Wriggle's Lantern */
    public static final Item WrigglesLantern = new Item(3154, "Wriggle's Lantern");

    /** Youmuu's Ghostblade */
    public static final Item YoumuusGhostblade = new Item(3142, "Youmuu's Ghostblade");

    /** Zeal */
    public static final Item Zeal = new Item(3086, "Zeal");

    /** Zeke's Herald */
    public static final Item ZekesHerald = new Item(3050, "Zeke's Herald");

    /** Zephyr */
    public static final Item Zephyr = new Item(3172, "Zephyr");

    /** Zhonya's Hourglass */
    public static final Item ZhonyasHourglass = new Item(3157, "Zhonya's Hourglass");

    /** The descriptor. */
    private final ItemStatus[] versions = new ItemStatus[Version.values().length];

    /** The item id. */
    public final int id;

    /** The item name. */
    public final String name;

    /**
     * <p>
     * Create constructor.
     * </p>
     * 
     * @param i
     * @param string
     */
    Item(int id, String name) {
        this.id = id;
        this.name = name;

        items.add(this);
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/item/" + id + ".png";
    }

    /**
     * <p>
     * Retrieve a status at the specified version.
     * </p>
     */
    public ItemStatus getStatus(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ItemStatus status = versions[i];

            if (status != null) {
                return status;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update status.
     * </p>
     * 
     * @param version A update version.
     * @return A champion descriptor.
     */
    ItemStatus update(Version version) {
        ItemStatus status = new ItemStatus(getStatus(version));

        versions[version.ordinal()] = status;

        return status;
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

    static {
        AbyssalScepter.update(P0000)
                .build(BlastingWand, NegatronCloak)
                .set(Cost, 980, 1855)
                .set(MR, 45)
                .set(AP, 70)
                .ability(AbyssalAura);
        AegisOftheLegion.update(P0000)
                .build(EmblemOfValor, NullMagicMantle, RubyCrystal)
                .set(Cost, 625, 1505)
                .set(AR, 20)
                .set(MR, 20)
                .set(Health, 250)
                .ability(Legion);
        AmplifyingTome.update(P0000).set(Cost, 435, 305).set(AP, 20);
        ArchangelsStaff.update(P0000)
                .build(TearOftheGoddess, BlastingWand)
                .set(Cost, 1140, 1890)
                .set(AP, 60)
                .set(Mana, 250)
                .set(Mreg, 10);
        AthenesUnholyGrail.update(P0000)
                .build(ChaliceOfHarmony, FiendishCodex)
                .set(Cost, 920)
                .set(MR, 40)
                .set(AP, 60)
                .set(Mreg, 15);
        AtmasImpaler.update(P0000).build(AvariceBlade, ChainVest).set(Cost, 780).set(Critical, 15);
        AugmentDeath.update(P0000).build(TheHexCore).set(Cost, 1000).set(AP, 45);
        AugmentGravity.update(P0000).build(TheHexCore).set(Cost, 1000).set(Mana, 200).set(CDR, 10).set(Mreg, 5);
        AugmentPower.update(P0000).build(TheHexCore).set(Cost, 1000).set(Hreg, 6).set(Health, 220);
        AvariceBlade.update(P0000).build(BrawlersGloves).set(Cost, 400).set(Critical, 10);
        BFSword.update(P0000).set(Cost, 1550).set(AD, 45);
        BannerOfCommand.update(P0000).build(BlastingWand, EmblemOfValor).set(Cost, 890).set(AP, 40).set(CDR, 10);
        BansheesVeil.update(P0000)
                .build(NegatronCloak, CatalystTheProtector)
                .set(Cost, 600)
                .set(MR, 45)
                .set(Mana, 300)
                .set(Health, 400);
        BerserkersGreaves.update(P0000).build(BootsOfSpeed, Dagger).set(Cost, 150).set(ASRatio, 20);
        BilgewaterCutlass.update(P0000).build(Pickaxe, VampiricScepter).set(Cost, 250).set(LS, 10).set(AD, 40);

        BladeOftheRuinedKing.update(P0000).build(BilgewaterCutlass).set(Cost, 975).set(LS, 10).set(AD, 40);
        BlastingWand.update(P0000).set(Cost, 860).set(AP, 40);
        BonetoothNecklace.update(P0000).set(Cost, 800).set(AD, 5);
        BootsOfMobility.update(P0000).build(BootsOfSpeed).set(Cost, 650);
        BootsOfSpeed.update(P0000).set(Cost, 350);
        BootsOfSwiftness.update(P0000).build(BootsOfSpeed).set(Cost, 650);
        BrawlersGloves.update(P0000).set(Cost, 400).set(Critical, 8);
        CatalystTheProtector.update(P0000)
                .build(RubyCrystal, SapphireCrystal)
                .set(Cost, 325)
                .set(Mana, 300)
                .set(Health, 200);
        ChainVest.update(P0000).set(Cost, 720);
        ChaliceOfHarmony.update(P0000).build(FaerieCharm, NullMagicMantle).set(Cost, 300).set(MR, 25).set(Mreg, 7);
        CloakOfAgility.update(P0000).set(Cost, 730).set(Critical, 15);
        ClothArmor.update(P0000).set(Cost, 300);
        CrystallineFlask.update(P0000).set(Cost, 345);
        Dagger.update(P0000).set(Cost, 400).set(ASRatio, 12);
        DeathfireGrasp.update(P0000).build(AmplifyingTome, NeedlesslyLargeRod).set(Cost, 965).set(AP, 100).set(CDR, 15);
        DoransBlade.update(P0000).set(Cost, 475).set(AD, 10).set(Health, 80);
        DoransRing.update(P0000).set(Cost, 475).set(AP, 15).set(Health, 80).set(Mreg, 3);
        DoransShield.update(P0000).set(Cost, 475).set(Hreg, 5).set(Health, 100);
        EleisasMiracle.update(P0000).build(PhilosophersStone).set(Cost, 400).set(Hreg, 10).set(Mreg, 15);
        ElixirOfBrilliance.update(P0000).set(Cost, 250);
        ElixirOfFortitude.update(P0000).set(Cost, 250);
        EmblemOfValor.update(P0000).build(ClothArmor, RejuvenationBead).set(Cost, 170);
        ExecutionersCalling.update(P0000).build(AvariceBlade, LongSword).set(Cost, 700).set(Critical, 15).set(AD, 25);
        FaerieCharm.update(P0000).set(Cost, 180).set(Mreg, 3);
        FiendishCodex.update(P0000).build(FaerieCharm, AmplifyingTome).set(Cost, 385).set(AP, 30).set(Mreg, 6);
        FrozenHeart.update(P0000).build(GlacialShroud, WardensMail).set(Cost, 500).set(Mana, 400).set(CDR, 20);
        FrozenMallet.update(P0000).build(Phage, GiantsBelt).set(Cost, 835).set(AD, 30).set(Health, 700);
        GiantsBelt.update(P0000).set(Cost, 1000).set(Health, 400);
        GlacialShroud.update(P0000).build(SapphireCrystal, ChainVest).set(Cost, 380).set(Mana, 300);
        GuardianAngel.update(P0000).build(NullMagicMantle, ChainVest).set(Cost, 1480).set(MR, 30);
        GuinsoosRageblade.update(P0000).build(BlastingWand, Pickaxe).set(Cost, 865).set(AP, 40).set(AD, 30);
        HauntingGuise.update(P0000).build(RubyCrystal, AmplifyingTome).set(Cost, 575).set(AP, 25).set(Health, 200);
        HealthPotion.update(P0000).set(Cost, 35);
        Hexdrinker.update(P0000).build(LongSword, NullMagicMantle).set(Cost, 550).set(MR, 25).set(AD, 25);
        HextechGunblade.update(P0000)
                .build(BilgewaterCutlass, HextechRevolver)
                .set(Cost, 275)
                .set(LS, 10)
                .set(AP, 65)
                .set(AD, 45);
        HextechRevolver.update(P0000).build(AmplifyingTome, AmplifyingTome).set(Cost, 330).set(AP, 40);
        HuntersMachete.update(P0000).set(Cost, 300);
        IcebornGauntlet.update(P0000)
                .build(Sheen, GlacialShroud)
                .set(Cost, 640)
                .set(AP, 40)
                .set(Mana, 500)
                .set(CDR, 15);
        InfinityEdge.update(P0000).build(BFSword, CloakOfAgility, Pickaxe).set(Cost, 645).set(Critical, 25).set(AD, 70);
        IonianBootsOfLucidity.update(P0000).build(BootsOfSpeed).set(Cost, 700);
        KagesLuckyPick.update(P0000).build(AmplifyingTome).set(Cost, 330).set(AP, 25);
        Kindlegem.update(P0000).build(RubyCrystal).set(Cost, 375).set(Health, 200);
        LastWhisper.update(P0000).build(LongSword, Pickaxe).set(Cost, 1025).set(AD, 40).set(ARPenRatio, 40);
        LiandrysTorment.update(P0000).build(HauntingGuise, AmplifyingTome).set(Cost, 980).set(AP, 60).set(Health, 300);
        LichBane.update(P0000).build(Sheen, BlastingWand).set(Cost, 880).set(AP, 80).set(MSRatio, 5).set(Mana, 250);
        LocketOftheIronSolari.update(P0000)
                .build(Kindlegem, ClothArmor, RejuvenationBead)
                .set(Cost, 670)
                .set(CDR, 10)
                .set(Health, 425);
        LongSword.update(P0000).set(Cost, 400).set(AD, 10);
        MadredsRazors.update(P0000).build(ClothArmor, HuntersMachete).set(Cost, 100);
        Malady.update(P0000).build(Dagger, Dagger, AmplifyingTome).set(Cost, 800).set(AP, 25).set(ASRatio, 45);
        ManaManipulator.update(P0000).build(FaerieCharm, FaerieCharm).set(Cost, 40);
        Manamune.update(P0000)
                .build(TearOftheGoddess, LongSword)
                .set(Cost, 1000)
                .set(AD, 20)
                .set(Mana, 250)
                .set(Mreg, 7);
        ManaPotion.update(P0000).set(Cost, 35);
        MawOfMalmortius.update(P0000).build(Hexdrinker, Pickaxe).set(Cost, 975).set(MR, 36).set(AD, 55);
        MejaisSoulstealer.update(P0000).build(AmplifyingTome).set(Cost, 800).set(AP, 20);
        MercurialScimitar.update(P0000).build(QuicksilverSash, BFSword).set(Cost, 600).set(MR, 45).set(AD, 60);
        MercurysTreads.update(P0000).build(BootsOfSpeed, NullMagicMantle).set(Cost, 450).set(MR, 25).set(MS, 50);
        MikaelsCrucible.update(P0000)
                .build(SapphireCrystal, ChaliceOfHarmony)
                .set(Cost, 920)
                .set(MR, 40)
                .set(Mana, 300)
                .set(Mreg, 9);
        Morellonomicon.update(P0000)
                .build(FiendishCodex, KagesLuckyPick)
                .set(Cost, 435)
                .set(AP, 75)
                .set(CDR, 20)
                .set(Mreg, 12);
        Muramana.update(P0000).build(Manamune).set(Cost, 0).set(AD, 20).set(Mana, 1000).set(Mreg, 7);
        NashorsTooth.update(P0000)
                .build(Stinger, FiendishCodex)
                .set(Cost, 250)
                .set(AP, 65)
                .set(ASRatio, 50)
                .set(Mreg, 10);
        NeedlesslyLargeRod.update(P0000).set(Cost, 1600).set(AP, 80);
        NegatronCloak.update(P0000).set(Cost, 810).set(MR, 45);
        NinjaTabi.update(P0000).build(BootsOfSpeed, ClothArmor).set(Cost, 350);
        NullMagicMantle.update(P0000).set(Cost, 400).set(MR, 20);
        Ohmwrecker.update(P0000).build(CatalystTheProtector, ChainVest).set(Cost, 930).set(Mana, 300).set(Health, 350);
        OraclesElixir.update(P0000).set(Cost, 400);
        Phage.update(P0000).build(RubyCrystal, LongSword).set(Cost, 590).set(AD, 20).set(Health, 200);
        PhantomDancer.update(P0000)
                .build(CloakOfAgility, Zeal, Dagger)
                .set(Cost, 495)
                .set(Critical, 30)
                .set(MSRatio, 5)
                .set(ASRatio, 50);
        PhilosophersStone.update(P0000).build(FaerieCharm, RejuvenationBead).set(Cost, 340).set(Hreg, 7).set(Mreg, 9);
        Pickaxe.update(P0000).set(Cost, 875).set(AD, 25);
        QuicksilverSash.update(P0000).build(NegatronCloak).set(Cost, 850).set(MR, 45);
        RabadonsDeathcap.update(P0000).build(BlastingWand, NeedlesslyLargeRod).set(Cost, 740).set(AP, 120);
        RanduinsOmen.update(P0000).build(GiantsBelt, WardensMail).set(Cost, 1000).set(Health, 500);
        RavenousHydra.update(P0000).build(Tiamat, VampiricScepter).set(Cost, 400).set(LS, 10).set(AD, 75).set(Hreg, 15);
        RecurveBow.update(P0000).set(Cost, 950).set(ASRatio, 30);
        RejuvenationBead.update(P0000).set(Cost, 180).set(Hreg, 5);
        RodOfAges.update(P0000)
                .build(CatalystTheProtector, BlastingWand)
                .set(Cost, 740)
                .set(AP, 60)
                .set(Mana, 450)
                .set(Health, 450);
        RubyCrystal.update(P0000).set(Cost, 475).set(Health, 180);
        RubySightstone.update(P0000).build(Sightstone).set(Cost, 125).set(Health, 300);
        RunaansHurricane.update(P0000).build(Dagger, RecurveBow, Dagger).set(Cost, 1000).set(ASRatio, 70);
        RunicBulwark.update(P0000).build(NullMagicMantle, AegisOftheLegion).set(Cost, 650).set(MR, 30).set(Health, 400);
        RylaisCrystalScepter.update(P0000)
                .build(BlastingWand, AmplifyingTome, GiantsBelt)
                .set(Cost, 605)
                .set(AP, 80)
                .set(Health, 500);
        SapphireCrystal.update(P0000).set(Cost, 400).set(Mana, 200);
        SeraphsEmbrace.update(P0000).build(ArchangelsStaff).set(Cost, 0).set(AP, 60).set(Mana, 1000).set(Mreg, 10);
        ShardOfTrueIce.update(P0000).build(KagesLuckyPick, ManaManipulator).set(Cost, 535).set(AP, 45);
        Sheen.update(P0000).build(SapphireCrystal, AmplifyingTome).set(Cost, 425).set(AP, 25).set(Mana, 200);
        ShurelyasReverie.update(P0000)
                .build(Kindlegem, PhilosophersStone)
                .set(Cost, 550)
                .set(Hreg, 10)
                .set(Health, 250)
                .set(Mreg, 10);
        Sightstone.update(P0000).set(Cost, 700).set(Health, 100);
        SightWard.update(P0000).set(Cost, 75);
        SorcerersShoes.update(P0000).build(BootsOfSpeed).set(Cost, 750);
        SpiritOftheAncientGolem.update(P0000)
                .build(SpiritStone, GiantsBelt)
                .set(Cost, 600)
                .set(Hreg, 14)
                .set(Health, 500)
                .set(Mreg, 7);
        SpiritOftheElderLizard.update(P0000)
                .build(SpiritStone, Pickaxe)
                .set(Cost, 725)
                .set(AD, 50)
                .set(Hreg, 14)
                .set(CDR, 10)
                .set(Mreg, 7);
        SpiritOftheSpectralWraith.update(P0000)
                .build(SpiritStone, HextechRevolver)
                .set(Cost, 400)
                .set(AP, 50)
                .set(CDR, 10)
                .set(Mreg, 10);
        SpiritStone.update(P0000)
                .build(HuntersMachete, FaerieCharm, RejuvenationBead)
                .set(Cost, 140)
                .set(Hreg, 14)
                .set(Mreg, 7);
        SpiritVisage.update(P0000)
                .build(Kindlegem, NegatronCloak)
                .set(Cost, 540)
                .set(MR, 50)
                .set(CDR, 15)
                .set(Health, 200);
        StatikkShiv.update(P0000)
                .build(Zeal, AvariceBlade)
                .set(Cost, 525)
                .set(Critical, 20)
                .set(MSRatio, 6)
                .set(ASRatio, 40);
        Stinger.update(P0000).build(Dagger, Dagger).set(Cost, 450).set(ASRatio, 40);
        SunfireCape.update(P0000).build(ChainVest, GiantsBelt).set(Cost, 780).set(Health, 450);
        SwordOftheDivine.update(P0000).build(RecurveBow, Dagger).set(Cost, 850).set(ASRatio, 45);
        SwordOftheOccult.update(P0000).build(LongSword).set(Cost, 800).set(AD, 10);
        TearOftheGoddess.update(P0000).build(SapphireCrystal, FaerieCharm).set(Cost, 120).set(Mana, 250).set(Mreg, 7);
        TheBlackCleaver.update(P0000)
                .build(TheBrutalizer, RubyCrystal)
                .set(Cost, 1188)
                .set(AD, 50)
                .set(CDR, 10)
                .set(Health, 250);
        TheBloodthirster.update(P0000).build(BFSword, VampiricScepter).set(Cost, 650).set(LS, 12).set(AD, 70);
        TheBrutalizer.update(P0000).build(LongSword, LongSword).set(Cost, 537).set(AD, 25);
        TheHexCore.update(P0000).set(Cost, 0);
        Thornmail.update(P0000).build(ChainVest, ClothArmor).set(Cost, 1180);
        Tiamat.update(P0000)
                .build(Pickaxe, LongSword, RejuvenationBead, RejuvenationBead)
                .set(Cost, 665)
                .set(AD, 50)
                .set(Hreg, 15);
        TrinityForce.update(P0000)
                .build(Zeal, Sheen, Phage)
                .set(Cost, 300)
                .set(Critical, 10)
                .set(AP, 30)
                .set(MSRatio, 8)
                .set(Mana, 200)
                .set(ASRatio, 30)
                .set(AD, 30)
                .set(Health, 250);
        TwinShadows.update(P0000).build(KagesLuckyPick, NullMagicMantle).set(Cost, 735).set(AP, 40).set(MSRatio, 6);
        VampiricScepter.update(P0000).build(LongSword).set(Cost, 400).set(LS, 10).set(AD, 10);
        VisionWard.update(P0000).set(Cost, 125);
        VoidStaff.update(P0000).build(BlastingWand, AmplifyingTome).set(Cost, 1000).set(AP, 70);
        WardensMail.update(P0000).build(ClothArmor, ClothArmor).set(Cost, 500);
        WarmogsArmor.update(P0000).build(GiantsBelt, RubyCrystal, RejuvenationBead).set(Cost, 995).set(Health, 1000);
        WillOftheAncients.update(P0000).build(KagesLuckyPick, HextechRevolver).set(Cost, 585).set(AP, 50);
        WitsEnd.update(P0000).build(RecurveBow, NullMagicMantle).set(Cost, 850).set(MR, 20).set(ASRatio, 40);
        WrigglesLantern.update(P0000).build(VampiricScepter, MadredsRazors).set(Cost, 100).set(LS, 10).set(AD, 15);
        YoumuusGhostblade.update(P0000)
                .build(AvariceBlade, TheBrutalizer)
                .set(Cost, 563)
                .set(Critical, 15)
                .set(AD, 30)
                .set(CDR, 10);
        Zeal.update(P0000)
                .build(BrawlersGloves, Dagger)
                .set(Cost, 375)
                .set(Critical, 10)
                .set(MSRatio, 5)
                .set(ASRatio, 18);
        ZekesHerald.update(P0000).build(VampiricScepter, Kindlegem).set(Cost, 800).set(CDR, 15).set(Health, 250);
        Zephyr.update(P0000)
                .build(Stinger, LongSword)
                .set(Cost, 1200)
                .set(MSRatio, 10)
                .set(ASRatio, 50)
                .set(AD, 20)
                .set(CDR, 10);
        ZhonyasHourglass.update(P0000).build(NeedlesslyLargeRod, ChainVest).set(Cost, 780).set(AP, 100);
    }
}
