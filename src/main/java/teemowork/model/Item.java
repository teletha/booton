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

import java.util.List;

import js.util.ArrayList;
import teemowork.model.variable.Variable;
import teemowork.model.variable.VariableHolder;
import teemowork.model.variable.VariableResolver;
import teemowork.model.variable.VariableResolver.Diff;

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

    /** Seeker's Armguard */
    public static final Item SeekersArmguard = new Item(3191, "Seeker's Armguard");

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
     * Calcurate item total cost.
     * </p>
     * 
     * @param version
     * @return
     */
    public double getTotalCost(Version version) {
        ItemStatus status = getStatus(version);

        double sum = status.get(Cost);

        for (Item material : status.build) {
            sum += material.getTotalCost(version);
        }
        return sum;
    }

    /**
     * <p>
     * Update status.
     * </p>
     * 
     * @param version A update version.
     * @return A champion descriptor.
     */
    ItemStatus update() {
        ItemStatus status = new ItemStatus(getStatus(P0000));

        versions[P0000.ordinal()] = status;

        return status;
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

    /**
     * <p>
     * Create skill AD amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AD rate.
     * @return
     */
    private static final Variable ad(double rate) {
        return amplify(AD, rate);
    }

    /**
     * <p>
     * Create skill AD amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AD rate.
     * @return
     */
    private static final Variable bounusAD(double rate) {
        return amplify(BounusAD, rate);
    }

    /**
     * <p>
     * Create skill AP amplifier. This pattern is used frequently.
     * </p>
     * 
     * @param rate An AP rate.
     * @return
     */
    private static final Variable ap(double rate) {
        return amplify(AP, rate);
    }

    /**
     * <p>
     * Create skill amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @return
     */
    private static final VariableHolder amplify(Status status, double base) {
        return amplify(status, base, 0);
    }

    /**
     * <p>
     * Create skill amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    private static final VariableHolder amplify(Status status, double base, double diff) {
        return amplify(status, new Diff(base, diff, 1));
    }

    /**
     * <p>
     * Create skill amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    private static final VariableHolder amplify(Status status, VariableResolver resolver) {
        VariableHolder amplifier = new VariableHolder();
        amplifier.setStatus(status);
        amplifier.setResolver(resolver);

        return amplifier;
    }

    /**
     * <p>
     * Create skill amplifier.
     * </p>
     * 
     * @param status A status type.
     * @param base A base value of amplifier rate.
     * @param diff A diff value of amplifier rate.
     * @return
     */
    private static final Variable amplify(Status status, double base, double diff, VariableHolder amplifier) {
        Variable one = amplify(status, base, diff);
        one.getAmplifiers().add(amplifier);

        return one;
    }

    static {
        AbyssalScepter.update().build(BlastingWand, NegatronCloak).cost(980).set(AP, 70).set(MR, 45);
        AegisOftheLegion.update()
                .build(EmblemOfValor, NullMagicMantle, RubyCrystal)
                .cost(625)
                .set(Health, 250)
                .set(AR, 20)
                .set(MR, 20)
                .passive("Insight", "{1}を得る。")
                .variable(1, AP, 0, 0, amplify(Mana, 0.03))
                .passive("Mana Charge", "スキル使用時及びMana消費時に最大Manaが6だけ増加する(最大+750)。CD: 3s");
        AmplifyingTome.update().cost(435).set(AP, 20);
        ArchangelsStaff.update()
                .build(TearOftheGoddess, BlastingWand)
                .cost(1140)
                .set(AP, 60)
                .set(Mreg, 10)
                .set(Mana, 250);
        AthenesUnholyGrail.update()
                .build(ChaliceOfHarmony, FiendishCodex)
                .cost(900)
                .set(AP, 60)
                .set(Mreg, 15)
                .set(MR, 40);
        AtmasImpaler.update().build(AvariceBlade, ChainVest).cost(780).set(AR, 45).set(Critical, 15);
        AugmentDeath.update().build(TheHexCore).cost(1000).set(AP, 45);
        AugmentGravity.update().build(TheHexCore).cost(1000).set(CDR, 10).set(Mreg, 5).set(Mana, 200);
        AugmentPower.update().build(TheHexCore).cost(1000).set(Health, 220).set(Hreg, 6);
        AvariceBlade.update().build(BrawlersGloves).cost(400).set(Critical, 10);
        BFSword.update().cost(1550).set(AD, 45);
        BannerOfCommand.update().build(FiendishCodex, EmblemOfValor).cost(890).set(AP, 40).set(CDR, 10).set(AR, 30);
        BansheesVeil.update()
                .build(NegatronCloak, CatalystTheProtector)
                .cost(600)
                .set(Health, 400)
                .set(Mana, 300)
                .set(MR, 45);
        BerserkersGreaves.update().build(BootsOfSpeed, Dagger).cost(150).set(ASRatio, 20);
        BilgewaterCutlass.update().build(Pickaxe, VampiricScepter).cost(250).set(LS, 10).set(AD, 40);
        BladeOftheRuinedKing.update().build(BilgewaterCutlass).cost(975).set(LS, 10).set(AD, 45);
        BlastingWand.update().cost(860).set(AP, 40);
        BonetoothNecklace.update().cost(800).set(AD, 5);
        BootsOfMobility.update().build(BootsOfSpeed).cost(650);
        BootsOfSpeed.update().cost(350);
        BootsOfSwiftness.update().build(BootsOfSpeed).cost(650);
        BrawlersGloves.update().cost(400).set(Critical, 8);
        CatalystTheProtector.update().build(RubyCrystal, SapphireCrystal).cost(325).set(Health, 200).set(Mana, 300);
        ChainVest.update().cost(720).set(AR, 40);
        ChaliceOfHarmony.update().build(FaerieCharm, FaerieCharm, NullMagicMantle).cost(120).set(Mreg, 7).set(MR, 25);
        CloakOfAgility.update().cost(730).set(Critical, 15);
        ClothArmor.update().cost(300).set(AR, 15);
        CrystallineFlask.update().cost(345);
        Dagger.update().cost(400).set(ASRatio, 12);
        DeathfireGrasp.update().build(FiendishCodex, NeedlesslyLargeRod).cost(680).set(AP, 120).set(CDR, 10);
        DoransBlade.update().cost(475).set(AD, 10).set(Health, 80);
        DoransRing.update().cost(475).set(AP, 15).set(Health, 80).set(Mreg, 3);
        DoransShield.update().cost(475).set(Health, 100).set(Hreg, 8).set(AR, 5);
        EleisasMiracle.update().build(PhilosophersStone).cost(400).set(Mreg, 15).set(Hreg, 10);
        ElixirOfBrilliance.update().cost(250);
        ElixirOfFortitude.update().cost(250);
        EmblemOfValor.update().build(ClothArmor, RejuvenationBead).cost(170).set(AR, 20);
        ExecutionersCalling.update().build(AvariceBlade, LongSword).cost(700).set(AD, 25).set(Critical, 20);
        FaerieCharm.update().cost(180).set(Mreg, 3);
        FiendishCodex.update().build(AmplifyingTome).cost(385).set(AP, 30);
        FrozenHeart.update().build(GlacialShroud, WardensMail).cost(550).set(CDR, 20).set(AR, 95).set(Mana, 400);
        FrozenMallet.update().build(Phage, GiantsBelt).cost(835).set(AD, 30).set(Health, 700);
        GiantsBelt.update().cost(1000).set(Health, 380);
        GlacialShroud.update().build(SapphireCrystal, ChainVest).cost(230).set(AR, 45).set(Mana, 300);
        GuardianAngel.update().build(NullMagicMantle, ChainVest).cost(1480).set(AR, 50).set(MR, 30);
        GuinsoosRageblade.update().build(BlastingWand, Pickaxe).cost(865).set(AD, 30).set(AP, 40);
        HauntingGuise.update().build(RubyCrystal, AmplifyingTome).cost(575).set(AP, 25).set(Health, 200);
        HealthPotion.update().cost(35);
        Hexdrinker.update().build(LongSword, NullMagicMantle).cost(550).set(AD, 25).set(MR, 25);
        HextechGunblade.update()
                .build(BilgewaterCutlass, HextechRevolver)
                .cost(275)
                .set(LS, 10)
                .set(AD, 45)
                .set(AP, 65);
        HextechRevolver.update().build(AmplifyingTome, AmplifyingTome).cost(330).set(AP, 40);
        HuntersMachete.update().cost(300);
        IcebornGauntlet.update()
                .build(Sheen, GlacialShroud)
                .cost(640)
                .set(AP, 40)
                .set(CDR, 10)
                .set(AR, 60)
                .set(Mana, 500);
        InfinityEdge.update().build(BFSword, CloakOfAgility, Pickaxe).cost(645).set(AD, 70).set(Critical, 25);
        IonianBootsOfLucidity.update().build(BootsOfSpeed).cost(700);
        KagesLuckyPick.update().build(AmplifyingTome).cost(330).set(AP, 25);
        Kindlegem.update().build(RubyCrystal).cost(375).set(Health, 200);
        LastWhisper.update().build(LongSword, Pickaxe).cost(1025).set(AD, 40);
        LiandrysTorment.update().build(HauntingGuise, AmplifyingTome).cost(980).set(AP, 50).set(Health, 300);
        LichBane.update().build(Sheen, BlastingWand).cost(880).set(AP, 80).set(Mana, 250).set(MSRatio, 5);
        LocketOftheIronSolari.update()
                .build(Kindlegem, ClothArmor, RejuvenationBead)
                .cost(670)
                .set(Health, 425)
                .set(CDR, 10)
                .set(AR, 35);
        LongSword.update().cost(400).set(AD, 10);
        MadredsRazors.update().build(ClothArmor, HuntersMachete).cost(100).set(AR, 25);
        Malady.update().build(Dagger, Dagger, AmplifyingTome).cost(800).set(AP, 25).set(ASRatio, 45);
        ManaManipulator.update().build(FaerieCharm, FaerieCharm).cost(40);
        Manamune.update().build(TearOftheGoddess, LongSword).cost(1000).set(AD, 20).set(Mreg, 7).set(Mana, 250);
        ManaPotion.update().cost(35);
        MawOfMalmortius.update().build(Hexdrinker, Pickaxe).cost(975).set(AD, 55).set(MR, 36);
        MejaisSoulstealer.update().build(AmplifyingTome).cost(800).set(AP, 20);
        MercurialScimitar.update().build(QuicksilverSash, BFSword).cost(600).set(AD, 60).set(MR, 45);
        MercurysTreads.update().build(BootsOfSpeed, NullMagicMantle).cost(450).set(MR, 25);
        MikaelsCrucible.update()
                .build(SapphireCrystal, ChaliceOfHarmony)
                .cost(920)
                .set(Mreg, 9)
                .set(Mana, 300)
                .set(MR, 40);
        Morellonomicon.update()
                .build(FaerieCharm, FiendishCodex, KagesLuckyPick)
                .cost(435)
                .set(AP, 75)
                .set(CDR, 20)
                .set(Mreg, 12);
        Muramana.update().build(Manamune).cost(0).set(AD, 20).set(Mreg, 7).set(Mana, 1000);
        NashorsTooth.update().build(Stinger, FiendishCodex).cost(200).set(AP, 65).set(ASRatio, 50);
        NeedlesslyLargeRod.update().cost(1600).set(AP, 80);
        NegatronCloak.update().cost(720).set(MR, 40);
        NinjaTabi.update().build(BootsOfSpeed, ClothArmor).cost(350).set(AR, 25);
        NullMagicMantle.update().cost(400).set(MR, 20);
        Ohmwrecker.update()
                .build(RubyCrystal, BlastingWand, PhilosophersStone)
                .cost(800)
                .set(AP, 50)
                .set(Health, 350)
                .set(Mreg, 15)
                .set(Hreg, 15);
        OraclesElixir.update().cost(400);
        Phage.update().build(RubyCrystal, LongSword).cost(590).set(AD, 20).set(Health, 200);
        PhantomDancer.update()
                .build(CloakOfAgility, Zeal, Dagger)
                .cost(495)
                .set(ASRatio, 50)
                .set(MSRatio, 5)
                .set(Critical, 30);
        PhilosophersStone.update().build(FaerieCharm, RejuvenationBead).cost(340).set(Mreg, 9).set(Hreg, 7);
        Pickaxe.update().cost(875).set(AD, 25);
        QuicksilverSash.update().build(NegatronCloak).cost(830).set(MR, 45);
        RabadonsDeathcap.update().build(BlastingWand, NeedlesslyLargeRod).cost(840).set(AP, 120);
        RanduinsOmen.update().build(GiantsBelt, WardensMail).cost(1000).set(Health, 500).set(AR, 70);
        RavenousHydra.update().build(Tiamat, VampiricScepter).cost(400).set(LS, 10).set(AD, 75).set(Hreg, 15);
        RecurveBow.update().cost(950).set(ASRatio, 30);
        RejuvenationBead.update().cost(180).set(Hreg, 5);
        RodOfAges.update()
                .build(CatalystTheProtector, BlastingWand)
                .cost(740)
                .set(AP, 60)
                .set(Health, 450)
                .set(Mana, 450);
        RubyCrystal.update().cost(475).set(Health, 180);
        RubySightstone.update().build(RubyCrystal, Sightstone).cost(125).set(Health, 360);
        RunaansHurricane.update().build(Dagger, RecurveBow, Dagger).cost(1000).set(ASRatio, 70);
        RunicBulwark.update()
                .build(NullMagicMantle, AegisOftheLegion)
                .cost(650)
                .set(Health, 400)
                .set(AR, 20)
                .set(MR, 30);
        RylaisCrystalScepter.update()
                .build(BlastingWand, AmplifyingTome, GiantsBelt)
                .cost(605)
                .set(AP, 80)
                .set(Health, 500);
        SapphireCrystal.update().cost(400).set(Mana, 200);
        SeekersArmguard.update().build(AmplifyingTome, ClothArmor, ClothArmor).cost(125).set(AP, 25).set(AR, 30);
        SeraphsEmbrace.update().build(ArchangelsStaff).cost(0).set(AP, 60).set(Mreg, 10).set(Mana, 1000);
        ShardOfTrueIce.update().build(KagesLuckyPick, ManaManipulator).cost(535).set(AP, 45);
        Sheen.update().build(SapphireCrystal, AmplifyingTome).cost(425).set(AP, 25).set(Mana, 200);
        ShurelyasReverie.update()
                .build(Kindlegem, PhilosophersStone)
                .cost(550)
                .set(Health, 250)
                .set(CDR, 10)
                .set(Mreg, 10)
                .set(Hreg, 10);
        Sightstone.update().build(RubyCrystal).cost(475).set(Health, 180);
        SightWard.update().cost(75);
        SorcerersShoes.update().build(BootsOfSpeed).cost(750);
        SpiritOftheAncientGolem.update()
                .build(SpiritStone, GiantsBelt)
                .cost(600)
                .set(Health, 500)
                .set(Mreg, 7)
                .set(Hreg, 14)
                .set(AR, 30);
        SpiritOftheElderLizard.update()
                .build(SpiritStone, Pickaxe)
                .cost(725)
                .set(AD, 50)
                .set(CDR, 10)
                .set(Mreg, 7)
                .set(Hreg, 14);
        SpiritOftheSpectralWraith.update()
                .build(SpiritStone, HextechRevolver)
                .cost(100)
                .set(AP, 50)
                .set(CDR, 10)
                .set(Mreg, 10);
        SpiritStone.update().build(HuntersMachete, FaerieCharm, RejuvenationBead).cost(40).set(Mreg, 7).set(Hreg, 14);
        SpiritVisage.update().build(Kindlegem, NegatronCloak).cost(630).set(Health, 200).set(CDR, 20).set(MR, 50);
        StatikkShiv.update().build(Zeal, AvariceBlade).cost(525).set(ASRatio, 40).set(MSRatio, 6).set(Critical, 20);
        Stinger.update().build(Dagger, Dagger).cost(450).set(ASRatio, 40);
        SunfireCape.update().build(ChainVest, GiantsBelt).cost(930).set(Health, 450).set(AR, 45);
        SwordOftheDivine.update().build(RecurveBow, Dagger).cost(850).set(ASRatio, 45);
        SwordOftheOccult.update().build(LongSword).cost(800).set(AD, 10);
        TearOftheGoddess.update().build(SapphireCrystal, FaerieCharm).cost(120).set(Mreg, 7).set(Mana, 250);
        TheBlackCleaver.update().build(TheBrutalizer, RubyCrystal).cost(1188).set(AD, 50).set(Health, 200).set(CDR, 10);
        TheBloodthirster.update().build(BFSword, VampiricScepter).cost(850).set(LS, 12).set(AD, 70);
        TheBrutalizer.update().build(LongSword, LongSword).cost(537).set(AD, 25);
        TheHexCore.update().cost(0);
        Thornmail.update().build(ChainVest, ClothArmor).cost(1180).set(AR, 100);
        Tiamat.update()
                .build(Pickaxe, LongSword, RejuvenationBead, RejuvenationBead)
                .cost(665)
                .set(AD, 50)
                .set(Hreg, 15);
        TrinityForce.update()
                .build(Zeal, Sheen, Phage)
                .cost(3)
                .set(AD, 30)
                .set(AP, 30)
                .set(Health, 250)
                .set(ASRatio, 30)
                .set(Mana, 200)
                .set(MSRatio, 8)
                .set(Critical, 10);
        TwinShadows.update().build(KagesLuckyPick, NullMagicMantle).cost(735).set(AP, 40).set(MSRatio, 6);
        VampiricScepter.update().build(LongSword).cost(400).set(LS, 10).set(AD, 10);
        VisionWard.update().cost(125);
        VoidStaff.update().build(BlastingWand, AmplifyingTome).cost(1000).set(AP, 70);
        WardensMail.update().build(ClothArmor, ClothArmor).cost(500).set(AR, 50);
        WarmogsArmor.update()
                .build(GiantsBelt, RubyCrystal, RejuvenationBead, RejuvenationBead)
                .cost(995)
                .set(Health, 1000);
        WillOftheAncients.update().build(KagesLuckyPick, HextechRevolver).cost(585).set(AP, 50);
        WitsEnd.update().build(RecurveBow, NullMagicMantle).cost(850).set(ASRatio, 40).set(MR, 25);
        WrigglesLantern.update().build(VampiricScepter, MadredsRazors).cost(100).set(LS, 10).set(AD, 15).set(AR, 30);
        YoumuusGhostblade.update()
                .build(AvariceBlade, TheBrutalizer)
                .cost(563)
                .set(AD, 30)
                .set(CDR, 10)
                .set(Critical, 15);
        Zeal.update().build(BrawlersGloves, Dagger).cost(375).set(ASRatio, 18).set(MSRatio, 5).set(Critical, 10);
        ZekesHerald.update().build(VampiricScepter, Kindlegem).cost(900).set(Health, 250).set(CDR, 20);
        Zephyr.update().build(Stinger, LongSword).cost(1200).set(AD, 20).set(CDR, 10).set(ASRatio, 50).set(MSRatio, 10);
        ZhonyasHourglass.update().build(NeedlesslyLargeRod, SeekersArmguard).cost(650).set(AP, 120).set(AR, 50);
    }
}
