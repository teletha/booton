/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License"),
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import static teemowork.lol.Status.*;
import static teemowork.lol.Version.*;

/**
 * @version 2013/01/27 0:43:53
 */
public enum Item {

    /** Abyssal Scepter */
    AbyssalScepter(3001, "Abyssal Scepter"),

    /** Aegis of the Legion */
    AegisOftheLegion(3105, "Aegis of the Legion"),

    /** Amplifying Tome */
    AmplifyingTome(1052, "Amplifying Tome"),

    /** Archangel's Staff */
    ArchangelsStaff(3003, "Archangel's Staff"),

    /** Athene's Unholy Grail */
    AthenesUnholyGrail(3174, "Athene's Unholy Grail"),

    /** Atma's Impaler */
    AtmasImpaler(3005, "Atma's Impaler"),

    /** Augment: Power */
    AugmentPower(3196, "Augment: Power"),

    /** Augment: Gravity */
    AugmentGravity(3197, "Augment: Gravity"),

    /** Augment: Death */
    AugmentDeath(3198, "Augment: Death"),

    /** Avarice Blade */
    AvariceBlade(3093, "Avarice Blade"),

    /** B. F. Sword */
    BFSword(1038, "B. F. Sword"),

    /** Banner of Command */
    BannerOfCommand(3060, "Banner of Command"),

    /** Banshee's Veil */
    BansheesVeil(3102, "Banshee's Veil"),

    /** Berserker's Greaves */
    BerserkersGreaves(3006, "Berserker's Greaves"),

    /** Berserker's Greaves Homeguard */
    BerserkersGreavesHomeguard(3250, "Berserker's Greaves Homeguard"),

    /** Berserker's Greaves Captain */
    BerserkersGreavesCaptain(3251, "Berserker's Greaves Captain"),

    /** Berserker's Greaves Furor */
    BerserkersGreavesFuror(3252, "Berserker's Greaves Furor"),

    /** Berserker's Greaves Distortion */
    BerserkersGreavesDistortion(3253, "Berserker's Greaves Distortion"),

    /** Berserker's Greaves Alacrity */
    BerserkersGreavesAlacrity(3254, "Berserker's Greaves Alacrity"),

    /** Bilgewater Cutlass */
    BilgewaterCutlass(3144, "Bilgewater Cutlass"),

    /** The Black Cleaver */
    TheBlackCleaver(3071, "The Black Cleaver"),

    /** Blackfire Torch */
    BlackfireTorch(3188, "Blackfire Torch"),

    /** Blade of the Ruined King */
    BladeOftheRuinedKing(3153, "Blade of the Ruined King"),

    /** Blasting Wand */
    BlastingWand(1026, "Blasting Wand"),

    /** The Bloodthirster */
    TheBloodthirster(3072, "The Bloodthirster"),

    /** Bonetooth Necklace */
    BonetoothNecklace(3166, "Bonetooth Necklace"),

    /** Boots of Mobility */
    BootsOfMobility(3117, "Boots of Mobility"),

    /** Boots of Mobility Homeguard */
    BootsOfMobilityHomeguard(3270, "Boots of Mobility Homeguard"),

    /** Boots of Mobility Captain */
    BootsOfMobilityCaptain(3271, "Boots of Mobility Captain"),

    /** Boots of Mobility Furor */
    BootsOfMobilityFuror(3272, "Boots of Mobility Furor"),

    /** Boots of Mobility Distortion */
    BootsOfMobilityDistortion(3273, "Boots of Mobility Distortion"),

    /** Boots of Mobility Alacrity */
    BootsOfMobilityAlacrity(3274, "Boots of Mobility Alacrity"),

    /** Boots of Speed */
    BootsOfSpeed(1001, "Boots of Speed"),

    /** Boots of Swiftness */
    BootsOfSwiftness(3009, "Boots of Swiftness"),

    /** Boots of Swiftness Homeguard */
    BootsOfSwiftnessHomeguard(3280, "Boots of Swiftness Homeguard"),

    /** Boots of Swiftness Captain */
    BootsOfSwiftnessCaptain(3281, "Boots of Swiftness Captain"),

    /** Boots of Swiftness Furor */
    BootsOfSwiftnessFuror(3282, "Boots of Swiftness Furor"),

    /** Boots of Swiftness Distortion */
    BootsOfSwiftnessDistortion(3283, "Boots of Swiftness Distortion"),

    /** Boots of Swiftness Alacrity */
    BootsOfSwiftnessAlacrity(3284, "Boots of Swiftness Alacrity"),

    /** Brawler's Gloves */
    BrawlersGloves(1051, "Brawler's Gloves"),

    /** The Brutalizer */
    TheBrutalizer(3134, "The Brutalizer"),

    /** Catalyst the Protector */
    CatalystTheProtector(3010, "Catalyst the Protector"),

    /** Chain Vest */
    ChainVest(1031, "Chain Vest"),

    /** Chalice of Harmony */
    ChaliceOfHarmony(3028, "Chalice of Harmony"),

    /** Cloak of Agility */
    CloakOfAgility(1018, "Cloak of Agility"),

    /** Cloth Armor */
    ClothArmor(1029, "Cloth Armor"),

    /** Crystalline Flask */
    CrystallineFlask(2041, "Crystalline Flask"),

    /** Dagger */
    Dagger(1042, "Dagger"),

    /** Deathfire Grasp */
    DeathfireGrasp(3128, "Deathfire Grasp"),

    /** Doran's Blade */
    DoransBlade(1055, "Doran's Blade"),

    /** Doran's Ring */
    DoransRing(1056, "Doran's Ring"),

    /** Doran's Shield */
    DoransShield(1054, "Doran's Shield"),

    /** Eleisa's Miracle */
    EleisasMiracle(3173, "Eleisa's Miracle"),

    /** Elixir of Brilliance */
    ElixirOfBrilliance(2039, "Elixir of Brilliance"),

    /** Elixir of Fortitude */
    ElixirOfFortitude(2037, "Elixir of Fortitude"),

    /** Emblem of Valor */
    EmblemOfValor(3097, "Emblem of Valor"),

    /** Entropy */
    Entropy(3184, "Entropy"),

    /** Executioner's Calling */
    ExecutionersCalling(3123, "Executioner's Calling"),

    /** Faerie Charm */
    FaerieCharm(1004, "Faerie Charm"),

    /** Fiendish Codex */
    FiendishCodex(3108, "Fiendish Codex"),

    /** Frozen Heart */
    FrozenHeart(3110, "Frozen Heart"),

    /** Frozen Mallet */
    FrozenMallet(3022, "Frozen Mallet"),

    /** Giant's Belt */
    GiantsBelt(1011, "Giant's Belt"),

    /** Glacial Shroud */
    GlacialShroud(3024, "Glacial Shroud"),

    /** Grez's Spectral Lantern */
    GrezsSpectralLantern(3159, "Grez's Spectral Lantern"),

    /** Guardian Angel */
    GuardianAngel(3026, "Guardian Angel"),

    /** Guinsoo's Rageblade */
    GuinsoosRageblade(3124, "Guinsoo's Rageblade"),

    /** Haunting Guise */
    HauntingGuise(3136, "Haunting Guise"),

    /** Health Potion */
    HealthPotion(2003, "Health Potion"),

    /** The Hex Core */
    TheHexCore(3200, "The Hex Core"),

    /** Hexdrinker */
    Hexdrinker(3155, "Hexdrinker"),

    /** Hextech Gunblade */
    HextechGunblade(3146, "Hextech Gunblade"),

    /** Hextech Revolver */
    HextechRevolver(3145, "Hextech Revolver"),

    /** Hextech Sweeper */
    HextechSweeper(3187, "Hextech Sweeper"),

    /** Hunter's Machete */
    HuntersMachete(1039, "Hunter's Machete"),

    /** Iceborn Gauntlet */
    IcebornGauntlet(3025, "Iceborn Gauntlet"),

    /** Ichor of Illumination */
    IchorOfIllumination(2048, "Ichor of Illumination"),

    /** Ichor of Rage */
    IchorOfRage(2040, "Ichor of Rage"),

    /** Infinity Edge */
    InfinityEdge(3031, "Infinity Edge"),

    /** Ionian Boots of Lucidity */
    IonianBootsOfLucidity(3158, "Ionian Boots of Lucidity"),

    /** Ionian Boots of Lucidity Homeguard */
    IonianBootsOfLucidityHomeguard(3275, "Ionian Boots of Lucidity Homeguard"),

    /** Ionian Boots of Lucidity Captain */
    IonianBootsOfLucidityCaptain(3276, "Ionian Boots of Lucidity Captain"),

    /** Ionian Boots of Lucidity Furor */
    IonianBootsOfLucidityFuror(3277, "Ionian Boots of Lucidity Furor"),

    /** Ionian Boots of Lucidity Distortion */
    IonianBootsOfLucidityDistortion(3278, "Ionian Boots of Lucidity Distortion"),

    /** Ionian Boots of Lucidity Alacrity */
    IonianBootsOfLucidityAlacrity(3279, "Ionian Boots of Lucidity Alacrity"),

    /** Kage's Lucky Pick */
    KagesLuckyPick(3098, "Kage's Lucky Pick"),

    /** Kindlegem */
    Kindlegem(3067, "Kindlegem"),

    /** Kitae's Bloodrazor */
    KitaesBloodrazor(3186, "Kitae's Bloodrazor"),

    /** Last Whisper */
    LastWhisper(3035, "Last Whisper"),

    /** Liandry's Torment */
    LiandrysTorment(3151, "Liandry's Torment"),

    /** Lich Bane */
    LichBane(3100, "Lich Bane"),

    /** The Lightbringer */
    TheLightbringer(3185, "The Lightbringer"),

    /** Locket of the Iron Solari */
    LocketOftheIronSolari(3190, "Locket of the Iron Solari"),

    /** Long Sword */
    LongSword(1036, "Long Sword"),

    /** Lord Van Damm's Pillager */
    LordVanDammsPillager(3104, "Lord Van Damm's Pillager"),

    /** Madred's Bloodrazor */
    MadredsBloodrazor(3126, "Madred's Bloodrazor"),

    /** Madred's Razors */
    MadredsRazors(3106, "Madred's Razors"),

    /** Malady */
    Malady(3114, "Malady"),

    /** Mana Manipulator */
    ManaManipulator(3037, "Mana Manipulator"),

    /** Mana Potion */
    ManaPotion(2004, "Mana Potion"),

    /** Manamune */
    Manamune(3004, "Manamune"),

    /** Maw of Malmortius */
    MawOfMalmortius(3156, "Maw of Malmortius"),

    /** Mejai's Soulstealer */
    MejaisSoulstealer(3041, "Mejai's Soulstealer"),

    /** Mercurial Scimitar */
    MercurialScimitar(3139, "Mercurial Scimitar"),

    /** Mercury's Treads */
    MercurysTreads(3111, "Mercury's Treads"),

    /** Mercury's Treads Homeguard */
    MercurysTreadsHomeguard(3265, "Mercury's Treads Homeguard"),

    /** Mercury's Treads Captain */
    MercurysTreadsCaptain(3266, "Mercury's Treads Captain"),

    /** Mercury's Treads Furor */
    MercurysTreadsFuror(3267, "Mercury's Treads Furor"),

    /** Mercury's Treads Distortion */
    MercurysTreadsDistortion(3268, "Mercury's Treads Distortion"),

    /** Mercury's Treads Alacrity */
    MercurysTreadsAlacrity(3269, "Mercury's Treads Alacrity"),

    /** Mikael's Crucible */
    MikaelsCrucible(3222, "Mikael's Crucible"),

    /** Morellonomicon */
    Morellonomicon(3165, "Morellonomicon"),

    /** Muramana */
    Muramana(3042, "Muramana"),

    /** Nashor's Tooth */
    NashorsTooth(3115, "Nashor's Tooth"),

    /** Needlessly Large Rod */
    NeedlesslyLargeRod(1058, "Needlessly Large Rod"),

    /** Negatron Cloak */
    NegatronCloak(1057, "Negatron Cloak"),

    /** Ninja Tabi */
    NinjaTabi(3047, "Ninja Tabi"),

    /** Ninja Tabi Homeguard */
    NinjaTabiHomeguard(3260, "Ninja Tabi Homeguard"),

    /** Ninja Tabi Captain */
    NinjaTabiCaptain(3261, "Ninja Tabi Captain"),

    /** Ninja Tabi Furor */
    NinjaTabiFuror(3262, "Ninja Tabi Furor"),

    /** Ninja Tabi Distortion */
    NinjaTabiDistortion(3263, "Ninja Tabi Distortion"),

    /** Ninja Tabi Alacrity */
    NinjaTabiAlacrity(3264, "Ninja Tabi Alacrity"),

    /** Null-Magic Mantle */
    NullMagicMantle(1033, "Null-Magic Mantle"),

    /** Odyn's Veil */
    OdynsVeil(3180, "Odyn's Veil"),

    /** Ohmwrecker */
    Ohmwrecker(3056, "Ohmwrecker"),

    /** Oracle's Elixir */
    OraclesElixir(2042, "Oracle's Elixir"),

    /** Oracle's Extract */
    OraclesExtract(2047, "Oracle's Extract"),

    /** Overlord's Bloodmail */
    OverlordsBloodmail(3084, "Overlord's Bloodmail"),

    /** Phage */
    Phage(3044, "Phage"),

    /** Phantom Dancer */
    PhantomDancer(3046, "Phantom Dancer"),

    /** Philosopher's Stone */
    PhilosophersStone(3096, "Philosopher's Stone"),

    /** Pickaxe */
    Pickaxe(1037, "Pickaxe"),

    /** Prospector's Blade */
    ProspectorsBlade(1062, "Prospector's Blade"),

    /** Prospector's Ring */
    ProspectorsRing(1063, "Prospector's Ring"),

    /** Quicksilver Sash */
    QuicksilverSash(3140, "Quicksilver Sash"),

    /** Rabadon's Deathcap */
    RabadonsDeathcap(3089, "Rabadon's Deathcap"),

    /** Randuin's Omen */
    RanduinsOmen(3143, "Randuin's Omen"),

    /** Ravenous Hydra */
    RavenousHydra(3074, "Ravenous Hydra"),

    /** Recurve Bow */
    RecurveBow(1043, "Recurve Bow"),

    /** Rejuvenation Bead */
    RejuvenationBead(1006, "Rejuvenation Bead"),

    /** Rod of Ages */
    RodOfAges(3027, "Rod of Ages"),

    /** Ruby Crystal */
    RubyCrystal(1028, "Ruby Crystal"),

    /** Ruby Sightstone */
    RubySightstone(2045, "Ruby Sightstone"),

    /** Runaan's Hurricane */
    RunaansHurricane(3085, "Runaan's Hurricane"),

    /** Runic Bulwark */
    RunicBulwark(3107, "Runic Bulwark"),

    /** Rylai's Crystal Scepter */
    RylaisCrystalScepter(3116, "Rylai's Crystal Scepter"),

    /** Sanguine Blade */
    SanguineBlade(3181, "Sanguine Blade"),

    /** Sapphire Crystal */
    SapphireCrystal(1027, "Sapphire Crystal"),

    /** Seraph's Embrace */
    SeraphsEmbrace(3040, "Seraph's Embrace"),

    /** Shard of True Ice */
    ShardOfTrueIce(3092, "Shard of True Ice"),

    /** Sheen */
    Sheen(3057, "Sheen"),

    /** Shurelya's Reverie */
    ShurelyasReverie(3069, "Shurelya's Reverie"),

    /** Sight Ward */
    SightWard(2044, "Sight Ward"),

    /** Sightstone */
    Sightstone(2049, "Sightstone"),

    /** Sorcerer's Shoes */
    SorcerersShoes(3020, "Sorcerer's Shoes"),

    /** Sorcerer's Shoes Homeguard */
    SorcerersShoesHomeguard(3255, "Sorcerer's Shoes Homeguard"),

    /** Sorcerer's Shoes Captain */
    SorcerersShoesCaptain(3256, "Sorcerer's Shoes Captain"),

    /** Sorcerer's Shoes Furor */
    SorcerersShoesFuror(3257, "Sorcerer's Shoes Furor"),

    /** Sorcerer's Shoes Distortion */
    SorcerersShoesDistortion(3258, "Sorcerer's Shoes Distortion"),

    /** Sorcerer's Shoes Alacrity */
    SorcerersShoesAlacrity(3259, "Sorcerer's Shoes Alacrity"),

    /** Spirit Stone */
    SpiritStone(1080, "Spirit Stone"),

    /** Spirit of the Ancient Golem */
    SpiritOftheAncientGolem(3207, "Spirit of the Ancient Golem"),

    /** Spirit of the Elder Lizard */
    SpiritOftheElderLizard(3209, "Spirit of the Elder Lizard"),

    /** Spirit of the Spectral Wraith */
    SpiritOftheSpectralWraith(3206, "Spirit of the Spectral Wraith"),

    /** Spirit Visage */
    SpiritVisage(3065, "Spirit Visage"),

    /** Statikk Shiv */
    StatikkShiv(3087, "Statikk Shiv"),

    /** Stinger */
    Stinger(3101, "Stinger"),

    /** Sunfire Cape */
    SunfireCape(3068, "Sunfire Cape"),

    /** Sword of the Divine */
    SwordOftheDivine(3131, "Sword of the Divine"),

    /** Sword of the Occult */
    SwordOftheOccult(3141, "Sword of the Occult"),

    /** Tear of the Goddess */
    TearOftheGoddess(3070, "Tear of the Goddess"),

    /** Thornmail */
    Thornmail(3075, "Thornmail"),

    /** Tiamat */
    Tiamat(3077, "Tiamat"),

    /** Trinity Force */
    TrinityForce(3078, "Trinity Force"),

    /** Twin Shadows */
    TwinShadows(3023, "Twin Shadows"),

    /** Vampiric Scepter */
    VampiricScepter(1053, "Vampiric Scepter"),

    /** Vision Ward */
    VisionWard(2043, "Vision Ward"),

    /** Void Staff */
    VoidStaff(3135, "Void Staff"),

    /** Warden's Mail */
    WardensMail(3082, "Warden's Mail"),

    /** Warmog's Armor */
    WarmogsArmor(3083, "Warmog's Armor"),

    /** Wicked Hatchet */
    WickedHatchet(3122, "Wicked Hatchet"),

    /** Will of the Ancients */
    WillOftheAncients(3152, "Will of the Ancients"),

    /** Wit's End */
    WitsEnd(3091, "Wit's End"),

    /** Wooglet's Witchcap */
    WoogletsWitchcap(3090, "Wooglet's Witchcap"),

    /** Wriggle's Lantern */
    WrigglesLantern(3154, "Wriggle's Lantern"),

    /** Youmuu's Ghostblade */
    YoumuusGhostblade(3142, "Youmuu's Ghostblade"),

    /** Zeal */
    Zeal(3086, "Zeal"),

    /** Zeke's Herald */
    ZekesHerald(3050, "Zeke's Herald"),

    /** Zephyr */
    Zephyr(3172, "Zephyr"),

    /** Zhonya's Hourglass */
    ZhonyasHourglass(3157, "Zhonya's Hourglass"),

    /** Cloak and Dagger */
    CloakandDagger(3172, "Cloak and Dagger"),

    /** Elixir of Agility */
    ElixirOfAgility(2038, "Elixir of Agility"),

    /** Force of Nature */
    ForceOfNature(3109, "Force of Nature"),

    /** Heart of Gold */
    HeartOfGold(3132, "Heart of Gold"),

    /** Ionic Spark */
    IonicSpark(3178, "Ionic Spark"),

    /** Leviathan */
    Leviathan(3138, "Leviathan"),

    /** Meki Pendant */
    MekiPendant(1005, "Meki Pendant"),

    /** Moonflair Spellblade */
    MoonflairSpellblade(3170, "Moonflair Spellblade"),

    /** Regrowth Pendant */
    RegrowthPendant(1007, "Regrowth Pendant"),

    /** Soul Shroud */
    SoulShroud(3099, "Soul Shroud");

    /** The descriptor. */
    private final ItemDescriptor[] descriptors = new ItemDescriptor[Version.values().length];

    /** The item id. */
    public final int id;

    /** The item name. */
    public final String name;

    /**
     * The abiliti private List<Ability> abilities = new ArrayList(); /**
     * <p>
     * Create constructor.
     * </p>
     * 
     * @param i
     * @param string
     */
    private Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * <p>
     * Retrieve a descriptor at the specified version.
     * </p>
     */
    public ItemDescriptor getDescriptor(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ItemDescriptor descriptor = descriptors[i];

            if (descriptor != null) {
                return descriptor;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update descriptor.
     * </p>
     * 
     * @param version A update version.
     * @return A champion descriptor.
     */
    private ItemDescriptor update(Version version) {
        ItemDescriptor descriptor = new ItemDescriptor(getDescriptor(version));

        descriptors[version.ordinal()] = descriptor;

        return descriptor;
    }

    static {
        AbyssalScepter.update(P0000).build(BlastingWand, NegatronCloak).set(Cost, 980).set(MR, 45).set(AP, 70);
        AegisOftheLegion.update(P0000)
                .build(EmblemOfValor, NullMagicMantle, RubyCrystal)
                .set(Cost, 625)
                .set(MR, 20)
                .set(Health, 250);
        AmplifyingTome.update(P0000).set(Cost, 435).set(AP, 20);
        ArchangelsStaff.update(P0000)
                .build(TearOftheGoddess, BlastingWand)
                .set(Cost, 1140)
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
        BerserkersGreaves.update(P0000).build(BootsOfSpeed, Dagger).set(Cost, 150).set(AS, 20);
        BilgewaterCutlass.update(P0000).build(Pickaxe, VampiricScepter).set(Cost, 250).set(LS, 10).set(AD, 40);
        BlackfireTorch.update(P0000)
                .build(KagesLuckyPick, FiendishCodex, HauntingGuise)
                .set(Cost, 700)
                .set(AP, 80)
                .set(Health, 250)
                .set(Mreg, 10);
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
        Dagger.update(P0000).set(Cost, 400).set(AS, 12);
        DeathfireGrasp.update(P0000).build(AmplifyingTome, NeedlesslyLargeRod).set(Cost, 965).set(AP, 100).set(CDR, 15);
        DoransBlade.update(P0000).set(Cost, 475).set(AD, 10).set(Health, 80);
        DoransRing.update(P0000).set(Cost, 475).set(AP, 15).set(Health, 80).set(Mreg, 3);
        DoransShield.update(P0000).set(Cost, 475).set(Hreg, 5).set(Health, 100);
        EleisasMiracle.update(P0000).build(PhilosophersStone).set(Cost, 400).set(Hreg, 10).set(Mreg, 15);
        ElixirOfBrilliance.update(P0000).set(Cost, 250);
        ElixirOfFortitude.update(P0000).set(Cost, 250);
        EmblemOfValor.update(P0000).build(ClothArmor, RejuvenationBead).set(Cost, 170);
        Entropy.update(P0000).build(BFSword, Phage).set(Cost, 600).set(AD, 70).set(Health, 275);
        ExecutionersCalling.update(P0000).build(AvariceBlade, LongSword).set(Cost, 700).set(Critical, 15).set(AD, 25);
        FaerieCharm.update(P0000).set(Cost, 180).set(Mreg, 3);
        FiendishCodex.update(P0000).build(FaerieCharm, AmplifyingTome).set(Cost, 385).set(AP, 30).set(Mreg, 6);
        FrozenHeart.update(P0000).build(GlacialShroud, WardensMail).set(Cost, 500).set(Mana, 400).set(CDR, 20);
        FrozenMallet.update(P0000).build(Phage, GiantsBelt).set(Cost, 835).set(AD, 30).set(Health, 700);
        GiantsBelt.update(P0000).set(Cost, 1000).set(Health, 400);
        GlacialShroud.update(P0000).build(SapphireCrystal, ChainVest).set(Cost, 380).set(Mana, 300);
        GrezsSpectralLantern.update(P0000).build(ClothArmor, VampiricScepter).set(Cost, 150).set(LS, 12).set(AD, 20);
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
        HextechSweeper.update(P0000)
                .build(AmplifyingTome, AmplifyingTome, Kindlegem)
                .set(Cost, 200)
                .set(AP, 50)
                .set(Health, 300);
        HuntersMachete.update(P0000).set(Cost, 300);
        IcebornGauntlet.update(P0000)
                .build(Sheen, GlacialShroud)
                .set(Cost, 640)
                .set(AP, 40)
                .set(Mana, 500)
                .set(CDR, 15);
        IchorOfIllumination.update(P0000).set(Cost, 500);
        IchorOfRage.update(P0000).set(Cost, 500);
        InfinityEdge.update(P0000).build(BFSword, CloakOfAgility, Pickaxe).set(Cost, 645).set(Critical, 25).set(AD, 70);
        IonianBootsOfLucidity.update(P0000).build(BootsOfSpeed).set(Cost, 700);
        KagesLuckyPick.update(P0000).build(AmplifyingTome).set(Cost, 330).set(AP, 25);
        Kindlegem.update(P0000).build(RubyCrystal).set(Cost, 375).set(Health, 200);
        KitaesBloodrazor.update(P0000).build(Pickaxe, RecurveBow).set(Cost, 700).set(AS, 40).set(AD, 30);
        LastWhisper.update(P0000).build(LongSword, Pickaxe).set(Cost, 1025).set(AD, 40);
        LiandrysTorment.update(P0000).build(HauntingGuise, AmplifyingTome).set(Cost, 980).set(AP, 60).set(Health, 300);
        LichBane.update(P0000).build(Sheen, BlastingWand).set(Cost, 880).set(AP, 80).set(MS, 5).set(Mana, 250);
        LocketOftheIronSolari.update(P0000)
                .build(Kindlegem, ClothArmor, RejuvenationBead)
                .set(Cost, 670)
                .set(CDR, 10)
                .set(Health, 425);
        LongSword.update(P0000).set(Cost, 400).set(AD, 10);
        MadredsRazors.update(P0000).build(ClothArmor, HuntersMachete).set(Cost, 100);
        Malady.update(P0000).build(Dagger, Dagger, AmplifyingTome).set(Cost, 800).set(AP, 25).set(AS, 45);
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
        MercurysTreads.update(P0000).build(BootsOfSpeed, NullMagicMantle).set(Cost, 450).set(MR, 25);
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
        NashorsTooth.update(P0000).build(Stinger, FiendishCodex).set(Cost, 250).set(AP, 65).set(AS, 50).set(Mreg, 10);
        NeedlesslyLargeRod.update(P0000).set(Cost, 1600).set(AP, 80);
        NegatronCloak.update(P0000).set(Cost, 810).set(MR, 45);
        NinjaTabi.update(P0000).build(BootsOfSpeed, ClothArmor).set(Cost, 350);
        NullMagicMantle.update(P0000).set(Cost, 400).set(MR, 20);
        OdynsVeil.update(P0000)
                .build(NegatronCloak, CatalystTheProtector)
                .set(Cost, 600)
                .set(MR, 50)
                .set(Mana, 350)
                .set(Health, 350);
        Ohmwrecker.update(P0000).build(CatalystTheProtector, ChainVest).set(Cost, 930).set(Mana, 300).set(Health, 350);
        OraclesElixir.update(P0000).set(Cost, 400);
        OraclesExtract.update(P0000).set(Cost, 250);
        OverlordsBloodmail.update(P0000).build(GiantsBelt, RubyCrystal).set(Cost, 980).set(Health, 850);
        Phage.update(P0000).build(RubyCrystal, LongSword).set(Cost, 590).set(AD, 20).set(Health, 200);
        PhantomDancer.update(P0000)
                .build(CloakOfAgility, Zeal, Dagger)
                .set(Cost, 495)
                .set(Critical, 30)
                .set(MS, 5)
                .set(AS, 50);
        PhilosophersStone.update(P0000).build(FaerieCharm, RejuvenationBead).set(Cost, 340).set(Hreg, 7).set(Mreg, 9);
        Pickaxe.update(P0000).set(Cost, 875).set(AD, 25);
        ProspectorsBlade.update(P0000).set(Cost, 950).set(LS, 5).set(AD, 20);
        ProspectorsRing.update(P0000).set(Cost, 950).set(AP, 40);
        QuicksilverSash.update(P0000).build(NegatronCloak).set(Cost, 850).set(MR, 45);
        RabadonsDeathcap.update(P0000).build(BlastingWand, NeedlesslyLargeRod).set(Cost, 740).set(AP, 120);
        RanduinsOmen.update(P0000).build(GiantsBelt, WardensMail).set(Cost, 1000).set(Health, 500);
        RavenousHydra.update(P0000).build(Tiamat, VampiricScepter).set(Cost, 400).set(LS, 10).set(AD, 75).set(Hreg, 15);
        RecurveBow.update(P0000).set(Cost, 950).set(AS, 30);
        RejuvenationBead.update(P0000).set(Cost, 180).set(Hreg, 5);
        RodOfAges.update(P0000)
                .build(CatalystTheProtector, BlastingWand)
                .set(Cost, 740)
                .set(AP, 60)
                .set(Mana, 450)
                .set(Health, 450);
        RubyCrystal.update(P0000).set(Cost, 475).set(Health, 180);
        RubySightstone.update(P0000).build(Sightstone).set(Cost, 125).set(Health, 300);
        RunaansHurricane.update(P0000).build(Dagger, RecurveBow, Dagger).set(Cost, 1000).set(AS, 70);
        RunicBulwark.update(P0000).build(NullMagicMantle, AegisOftheLegion).set(Cost, 650).set(MR, 30).set(Health, 400);
        RylaisCrystalScepter.update(P0000)
                .build(BlastingWand, AmplifyingTome, GiantsBelt)
                .set(Cost, 605)
                .set(AP, 80)
                .set(Health, 500);
        SanguineBlade.update(P0000).build(BFSword, VampiricScepter).set(Cost, 500).set(LS, 15).set(AD, 65);
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
        StatikkShiv.update(P0000).build(Zeal, AvariceBlade).set(Cost, 525).set(Critical, 20).set(MS, 6).set(AS, 40);
        Stinger.update(P0000).build(Dagger, Dagger).set(Cost, 450).set(AS, 40);
        SunfireCape.update(P0000).build(ChainVest, GiantsBelt).set(Cost, 780).set(Health, 450);
        SwordOftheDivine.update(P0000).build(RecurveBow, Dagger).set(Cost, 850).set(AS, 45);
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
        TheLightbringer.update(P0000).build(BonetoothNecklace, Pickaxe).set(Cost, 300).set(LS, 12).set(AD, 50);
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
                .set(MS, 8)
                .set(Mana, 200)
                .set(AS, 30)
                .set(AD, 30)
                .set(Health, 250);
        TwinShadows.update(P0000).build(KagesLuckyPick, NullMagicMantle).set(Cost, 735).set(AP, 40).set(MS, 6);
        VampiricScepter.update(P0000).build(LongSword).set(Cost, 400).set(LS, 10).set(AD, 10);
        VisionWard.update(P0000).set(Cost, 125);
        VoidStaff.update(P0000).build(BlastingWand, AmplifyingTome).set(Cost, 1000).set(AP, 70);
        WardensMail.update(P0000).build(ClothArmor, ClothArmor).set(Cost, 500);
        WarmogsArmor.update(P0000).build(GiantsBelt, RubyCrystal, RejuvenationBead).set(Cost, 995).set(Health, 1000);
        WillOftheAncients.update(P0000).build(KagesLuckyPick, HextechRevolver).set(Cost, 585).set(AP, 50);
        WitsEnd.update(P0000).build(RecurveBow, NullMagicMantle).set(Cost, 850).set(MR, 20).set(AS, 40);
        WoogletsWitchcap.update(P0000).build(BlastingWand, BlastingWand, ChainVest).set(Cost, 1060).set(AP, 100);
        WrigglesLantern.update(P0000).build(VampiricScepter, MadredsRazors).set(Cost, 100).set(LS, 10).set(AD, 15);
        YoumuusGhostblade.update(P0000)
                .build(AvariceBlade, TheBrutalizer)
                .set(Cost, 563)
                .set(Critical, 15)
                .set(AD, 30)
                .set(CDR, 10);
        Zeal.update(P0000).build(BrawlersGloves, Dagger).set(Cost, 375).set(Critical, 10).set(MS, 5).set(AS, 18);
        ZekesHerald.update(P0000).build(VampiricScepter, Kindlegem).set(Cost, 800).set(CDR, 15).set(Health, 250);
        Zephyr.update(P0000).build(Stinger, LongSword).set(Cost, 1200).set(MS, 10).set(AS, 50).set(AD, 20).set(CDR, 10);
        ZhonyasHourglass.update(P0000).build(NeedlesslyLargeRod, ChainVest).set(Cost, 780).set(AP, 100);
    }
}
