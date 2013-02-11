/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.lol;

import static teemowork.lol.SkillKey.*;
import static teemowork.lol.Status.*;
import static teemowork.lol.Version.*;

/**
 * @version 2013/01/27 20:32:01
 */
public enum Skill {

    /** The skill name. */
    EssenceTheft("Essence Theft", Passive),

    /** The skill name. */
    OrbOfDeception("Orb of Deception", Q),

    /** The skill name. */
    FoxFire("Fox-Fire", W),

    /** The skill name. */
    Charm("Charm", E),

    /** The skill name. */
    SpiritRush("Spirit Rush", R),

    /** The skill name. */
    TwinDisciplines("Twin Disciplines", Passive),

    /** The skill name. */
    MarkOftheAssassin("Mark of the Assassin", Q),

    /** The skill name. */
    TwilightShroud("Twilight Shroud", W),

    /** The skill name. */
    CrescentSlash("Crescent Slash", E),

    /** The skill name. */
    ShadowDance("Shadow Dance", R),

    /** The skill name. */
    Trample("Trample", Passive),

    /** The skill name. */
    Pulverize("Pulverize", Q),

    /** The skill name. */
    Headbutt("Headbutt", W),

    /** The skill name. */
    TriumphantRoar("Triumphant Roar", E),

    /** The skill name. */
    UnbreakableWill("Unbreakable Will", R),

    /** The skill name. */
    CursedTouch("Cursed Touch", Passive),

    /** The skill name. */
    BandageToss("Bandage Toss", Q),

    /** The skill name. */
    Despair("Despair", W),

    /** The skill name. */
    Tantrum("Tantrum", E),

    /** The skill name. */
    CurseOftheSadMummy("Curse of the Sad Mummy", R),

    /** The skill name. */
    Rebirth("Rebirth", Passive),

    /** The skill name. */
    FlashFrost("Flash Frost", Q),

    /** The skill name. */
    Crystalize("Crystalize", W),

    /** The skill name. */
    Frostbite("Frostbite", E),

    /** The skill name. */
    GlacialStorm("Glacial Storm", R),

    /** The skill name. */
    Pyromania("Pyromania", Passive),

    /** The skill name. */
    Disintegrate("Disintegrate", Q),

    /** The skill name. */
    Incinerate("Incinerate", W),

    /** The skill name. */
    MoltenShield("Molten Shield", E),

    /** The skill name. */
    SummonTibbers("Summon: Tibbers", R),

    /** The skill name. */
    Focus("Focus", Passive),

    /** The skill name. */
    FrostShot("Frost Shot", Q),

    /** The skill name. */
    Volley("Volley", W),

    /** The skill name. */
    Hawkshot("Hawkshot", E),

    /** The skill name. */
    EnchantedCrystalArrow("Enchanted Crystal Arrow", R),

    /** The skill name. */
    ManaBarrier("Mana Barrier", Passive),

    /** The skill name. */
    RocketGrab("Rocket Grab", Q),

    /** The skill name. */
    Overdrive("Overdrive", W),

    /** The skill name. */
    PowerFist("Power Fist", E),

    /** The skill name. */
    StaticField("Static Field", R),

    /** The skill name. */
    Blaze("Blaze", Passive),

    /** The skill name. */
    Sear("Sear", Q),

    /** The skill name. */
    PillarOfFlame("Pillar of Flame", W),

    /** The skill name. */
    Conflagration("Conflagration", E),

    /** The skill name. */
    Pyroclasm("Pyroclasm", R),

    /** The skill name. */
    Headshot("Headshot", Passive),

    /** The skill name. */
    PiltoverPeacemaker("Piltover Peacemaker", Q),

    /** The skill name. */
    YordleSnapTrap("Yordle Snap Trap", W),

    /** The skill name. */
    CaliberNet("90 Caliber Net", E),

    /** The skill name. */
    AceinTheHole("Ace in the Hole", R),

    /** The skill name. */
    DeadlyCadence("Deadly Cadence", Passive),

    /** The skill name. */
    NoxiousBlast("Noxious Blast", Q),

    /** The skill name. */
    Miasma("Miasma", W),

    /** The skill name. */
    TwinFang("Twin Fang", E),

    /** The skill name. */
    PetrifyingGaze("Petrifying Gaze", R),

    /** The skill name. */
    Carnivore("Carnivore", Passive),

    /** The skill name. */
    Rupture("Rupture", Q),

    /** The skill name. */
    FeralScream("Feral Scream", W),

    /** The skill name. */
    VorpalSpikes("Vorpal Spikes", E),

    /** The skill name. */
    Feast("Feast", R),

    /** The skill name. */
    HextechShrapnelShells("Hextech Shrapnel Shells", Passive),

    /** The skill name. */
    PhosphorusBomb("Phosphorus Bomb", Q),

    /** The skill name. */
    Valkyrie("Valkyrie", W),

    /** The skill name. */
    GatlingGun("Gatling Gun", E),

    /** The skill name. */
    MissileBarrage("Missile Barrage", R),

    /** The skill name. */
    Hemorrhage("Hemorrhage", Passive),

    /** The skill name. */
    Decimate("Decimate", Q),

    /** The skill name. */
    CripplingStrike("Crippling Strike", W),

    /** The skill name. */
    Apprehend("Apprehend", E),

    /** The skill name. */
    NoxianGuillotine("Noxian Guillotine", R),

    /** The skill name. */
    MoonsilverBlade("Moonsilver Blade", Passive),

    /** The skill name. */
    CrescentStrike("Crescent Strike", Q),

    /** The skill name. */
    PaleCascade("Pale Cascade", W),

    /** The skill name. */
    Moonfall("Moonfall", E),

    /** The skill name. */
    LunarRush("Lunar Rush", R),

    /** The skill name. */
    AdrenalineRush("Adrenaline Rush", Passive),

    /** The skill name. */
    InfectedCleaver("Infected Cleaver", Q),

    /** The skill name. */
    BurningAgony("Burning Agony", W),

    /** The skill name. */
    Masochism("Masochism", E),

    /** The skill name. */
    Sadism("Sadism", R),

    /** The skill name. */
    WickedBlades("Wicked Blades", Passive),

    /** The skill name. */
    SpinningAxe("Spinning Axe", Q),

    /** The skill name. */
    BloodRush("Blood Rush", W),

    /** The skill name. */
    StandAside("Stand Aside", E),

    /** The skill name. */
    WhirlingDeath("Whirling Death", R),

    /** The skill name. */
    SpiderSwarm("Spider Swarm", Passive),

    /** The skill name. */
    Neurotoxin("Neurotoxin", Q),

    /** The skill name. */
    VenomousBite("Venomous Bite", Q),

    /** The skill name. */
    VolatileSpiderling("Volatile Spiderling", W),

    /** The skill name. */
    SkitteringFrenzy("Skittering Frenzy", W),

    /** The skill name. */
    Cocoon("Cocoon", E),

    /** The skill name. */
    Rappel("Rappel", E),

    /** The skill name. */
    SpiderForm("Spider Form", R),

    /** The skill name. */
    HumanForm("Human Form", R),

    /** The skill name. */
    ShadowWalk("Shadow Walk", Passive),

    /** The skill name. */
    HateSpike("Hate Spike", Q),

    /** The skill name. */
    DarkFrenzy("Dark Frenzy", W),

    /** The skill name. */
    Ravage("Ravage", E),

    /** The skill name. */
    AgonysEmbrace("Agony's Embrace", R),

    /** The skill name. */
    RisingSpellForce("Rising Spell Force", Passive),

    /** The skill name. */
    MysticShot("Mystic Shot", Q),

    /** The skill name. */
    EssenceFlux("Essence Flux", W),

    /** The skill name. */
    ArcaneShift("Arcane Shift", E),

    /** The skill name. */
    TrueshotBarrage("Trueshot Barrage", R),

    /** The skill name. */
    Dread("Dread", Passive),

    /** The skill name. */
    Terrify("Terrify", Q),

    /** The skill name. */
    Drain("Drain", W),

    /** The skill name. */
    DarkWind("Dark Wind", E),

    /** The skill name. */
    Crowstorm("Crowstorm", R),

    /** The skill name. */
    Duelist("Duelist", Passive),

    /** The skill name. */
    Lunge("Lunge", Q),

    /** The skill name. */
    Riposte("Riposte", W),

    /** The skill name. */
    BurstOfSpeed("Burst of Speed", E),

    /** The skill name. */
    BladeWaltz("Blade Waltz", R),

    /** The skill name. */
    NimbleFighter("Nimble Fighter", Passive),

    /** The skill name. */
    UrchinStrike("Urchin Strike", Q),

    /** The skill name. */
    SeastoneTrident("Seastone Trident", W),

    /** The skill name. */
    PlayfulTrickster("Playful / Trickster", E),

    /** The skill name. */
    ChumTheWaters("Chum the Waters", R),

    /** The skill name. */
    RunicSkin("Runic Skin", Passive),

    /** The skill name. */
    ResoluteSmite("Resolute Smite", Q),

    /** The skill name. */
    Bulwark("Bulwark", W),

    /** The skill name. */
    RighteousGust("Righteous Gust", E),

    /** The skill name. */
    IdolOfDurand("Idol of Durand", R),

    /** The skill name. */
    GrogSoakedBlade("Grog Soaked Blade", Passive),

    /** The skill name. */
    Parrrley("Parrrley", Q),

    /** The skill name. */
    RemoveScurvy("Remove Scurvy", W),

    /** The skill name. */
    RaiseMorale("Raise Morale", E),

    /** The skill name. */
    CannonBarrage("Cannon Barrage", R),

    /** The skill name. */
    Perseverance("Perseverance", Passive),

    /** The skill name. */
    DecisiveStrike("Decisive Strike", Q),

    /** The skill name. */
    Courage("Courage", W),

    /** The skill name. */
    Judgment("Judgment", E),

    /** The skill name. */
    DemacianJustice("Demacian Justice", R),

    /** The skill name. */
    HappyHour("Happy Hour", Passive),

    /** The skill name. */
    BarrelRoll("Barrel Roll", Q),

    /** The skill name. */
    DrunkenRage("Drunken Rage", W),

    /** The skill name. */
    BodySlam("Body Slam", E),

    /** The skill name. */
    ExplosiveCask("Explosive Cask", R),

    /** The skill name. */
    TrueGrit("True Grit", Passive),

    /** The skill name. */
    Buckshot("Buckshot", Q),

    /** The skill name. */
    Smokescreen("Smokescreen", W),

    /** The skill name. */
    Quickdraw("Quickdraw", E),

    /** The skill name. */
    CollateralDamage("Collateral Damage", R),

    /** The skill name. */
    Warpath("Warpath", Passive),

    /** The skill name. */
    Rampage("Rampage", Q),

    /** The skill name. */
    SpiritOfDread("Spirit of Dread", W),

    /** The skill name. */
    DevastatingCharge("Devastating Charge", E),

    /** The skill name. */
    OnslaughtOfShadows("Onslaught of Shadows", R),

    /** The skill name. */
    TechmaturgicalRepairBots("Techmaturgical Repair Bots", Passive),

    /** The skill name. */
    H28GEvolutionTurret("H-28G Evolution Turret", Q),

    /** The skill name. */
    HextechMicroRockets("Hextech Micro-Rockets", W),

    /** The skill name. */
    CH1ConcussionGrenade("CH-1 Concussion Grenade", E),

    /** The skill name. */
    UPGRADE("UPGRADE!!!", R),

    /** The skill name. */
    IonianFervor("Ionian Fervor", Passive),

    /** The skill name. */
    Bladesurge("Bladesurge", Q),

    /** The skill name. */
    HitenStyle("Hiten Style", W),

    /** The skill name. */
    EquilibriumStrike("Equilibrium Strike", E),

    /** The skill name. */
    TranscendentBlades("Transcendent Blades", R),

    /** The skill name. */
    Tailwind("Tailwind", Passive),

    /** The skill name. */
    HowlingGale("Howling Gale", Q),

    /** The skill name. */
    Zephyr("Zephyr", W),

    /** The skill name. */
    EyeOfTheStorm("Eye Of The Storm", E),

    /** The skill name. */
    Monsoon("Monsoon", R),

    /** The skill name. */
    MartialCadence("Martial Cadence", Passive),

    /** The skill name. */
    DragonStrike("Dragon Strike", Q),

    /** The skill name. */
    GoldenAegis("Golden Aegis", W),

    /** The skill name. */
    DemacianStandard("Demacian Standard", E),

    /** The skill name. */
    Cataclysm("Cataclysm", R),

    /** The skill name. */
    RelentlessAssault("Relentless Assault", Passive),

    /** The skill name. */
    LeapStrike("Leap Strike", Q),

    /** The skill name. */
    Empower("Empower", W),

    /** The skill name. */
    CounterStrike("Counter Strike", E),

    /** The skill name. */
    GrandmastersMight("Grandmaster's Might", R),

    /** The skill name. */
    HextechCapacitor("Hextech Capacitor", Passive),

    /** The skill name. */
    ToTheSkies("To the Skies!", Q),

    /** The skill name. */
    ShockBlast("Shock Blast", Q),

    /** The skill name. */
    LightningField("Lightning Field", W),

    /** The skill name. */
    HyperCharge("Hyper Charge", W),

    /** The skill name. */
    ThunderingBlow("Thundering Blow", E),

    /** The skill name. */
    AccelerationGate("Acceleration Gate", E),

    /** The skill name. */
    TransformMercuryCannon("Transform: Mercury Cannon", R),

    /** The skill name. */
    TransformMercuryHammer("Transform: Mercury Hammer", R),

    /** The skill name. */
    InnerFlame("Inner Flame", Passive),

    /** The skill name. */
    HeavenlyWave("Heavenly Wave", Q),

    /** The skill name. */
    SpiritBond("Spirit Bond", W),

    /** The skill name. */
    SoulShield("Soul Shield", E),

    /** The skill name. */
    Mantra("Mantra", R),

    /** The skill name. */
    DeathDefied("Death Defied", Passive),

    /** The skill name. */
    LayWaste("Lay Waste", Q),

    /** The skill name. */
    WallOfPain("Wall of Pain", W),

    /** The skill name. */
    Defile("Defile", E),

    /** The skill name. */
    Requiem("Requiem", R),

    /** The skill name. */
    VoidStone("Void Stone", Passive),

    /** The skill name. */
    NullSphere("Null Sphere", Q),

    /** The skill name. */
    NetherBlade("Nether Blade", W),

    /** The skill name. */
    ForcePulse("Force Pulse", E),

    /** The skill name. */
    Riftwalk("Riftwalk", R),

    /** The skill name. */
    Voracity("Voracity", Passive),

    /** The skill name. */
    BouncingBlade("Bouncing Blade", Q),

    /** The skill name. */
    SinisterSteel("Sinister Steel", W),

    /** The skill name. */
    Shunpo("Shunpo", E),

    /** The skill name. */
    DeathLotus("Death Lotus", R),

    /** The skill name. */
    HolyFervor("Holy Fervor", Passive),

    /** The skill name. */
    Reckoning("Reckoning", Q),

    /** The skill name. */
    DivineBlessing("Divine Blessing", W),

    /** The skill name. */
    RighteousFury("Righteous Fury", E),

    /** The skill name. */
    Intervention("Intervention", R),

    /** The skill name. */
    MarkOftheStorm("Mark of the Storm", Passive),

    /** The skill name. */
    ThunderingShuriken("Thundering Shuriken", Q),

    /** The skill name. */
    ElectricalSurge("Electrical Surge", W),

    /** The skill name. */
    LightningRush("Lightning Rush", E),

    /** The skill name. */
    SlicingMaelstrom("Slicing Maelstrom", R),

    /** The skill name. */
    UnseenThreat("Unseen Threat", Passive),

    /** The skill name. */
    TasteTheirFear("Taste Their Fear", Q),

    /** The skill name. */
    VoidSpike("Void Spike", W),

    /** The skill name. */
    Leap("Leap", E),

    /** The skill name. */
    VoidAssault("Void Assault", R),

    /** The skill name. */
    IcathianSurprise("Icathian Surprise", Passive),

    /** The skill name. */
    CausticSpittle("Caustic Spittle", Q),

    /** The skill name. */
    BioArcaneBarrage("Bio-Arcane Barrage", W),

    /** The skill name. */
    VoidOoze("Void Ooze", E),

    /** The skill name. */
    LivingArtillery("Living Artillery", R),

    /** The skill name. */
    MirrorImage("Mirror Image", Passive),

    /** The skill name. */
    SigilOfSilence("Sigil of Silence", Q),

    /** The skill name. */
    Distortion("Distortion", W),

    /** The skill name. */
    EtherealChains("Ethereal Chains", E),

    /** The skill name. */
    Mimic("Mimic", R),

    /** The skill name. */
    Flurry("Flurry", Passive),

    /** The skill name. */
    SonicWave("Sonic Wave", Q),

    /** The skill name. */
    ResonatingStrike("Resonating Strike", Q),

    /** The skill name. */
    Safeguard("Safeguard", W),

    /** The skill name. */
    IronWill("Iron Will", W),

    /** The skill name. */
    Tempest("Tempest", E),

    /** The skill name. */
    Cripple("Cripple", E),

    /** The skill name. */
    DragonsRage("Dragon's Rage", R),

    /** The skill name. */
    Sunlight("Sunlight", Passive),

    /** The skill name. */
    ShieldOfDaybreak("Shield of Daybreak", Q),

    /** The skill name. */
    Eclipse("Eclipse", W),

    /** The skill name. */
    ZenithBlade("Zenith Blade", E),

    /** The skill name. */
    SolarFlare("Solar Flare", R),

    /** The skill name. */
    PixFaerieCompanion("Pix, Faerie Companion", Passive),

    /** The skill name. */
    Glitterlance("Glitterlance", Q),

    /** The skill name. */
    Whimsy("Whimsy", W),

    /** The skill name. */
    HelpPix("Help, Pix!", E),

    /** The skill name. */
    WildGrowth("Wild Growth", R),

    /** The skill name. */
    Illumination("Illumination", Passive),

    /** The skill name. */
    LightBinding("Light Binding", Q),

    /** The skill name. */
    PrismaticBarrier("Prismatic Barrier", W),

    /** The skill name. */
    LucentSingularity("Lucent Singularity", E),

    /** The skill name. */
    FinalSpark("Final Spark", R),

    /** The skill name. */
    GraniteShield("Granite Shield", Passive),

    /** The skill name. */
    SeismicShard("Seismic Shard", Q),

    /** The skill name. */
    BrutalStrikes("Brutal Strikes", W),

    /** The skill name. */
    GroundSlam("Ground Slam", E),

    /** The skill name. */
    UnstoppableForce("Unstoppable Force", R),

    /** The skill name. */
    SummonVoidling("Summon Voidling", Passive),

    /** The skill name. */
    CallOftheVoid("Call of the Void", Q),

    /** The skill name. */
    NullZone("Null Zone", W),

    /** The skill name. */
    MaleficVisions("Malefic Visions", E),

    /** The skill name. */
    NetherGrasp("Nether Grasp", R),

    /** The skill name. */
    SapMagic("Sap Magic", Passive),

    /** The skill name. */
    ArcaneSmash("Arcane Smash", Q),

    /** The skill name. */
    TwistedAdvance("Twisted Advance", W),

    /** The skill name. */
    SaplingToss("Sapling Toss", E),

    /** The skill name. */
    VengefulMaelstrom("Vengeful Maelstrom", R),

    /** The skill name. */
    DoubleStrike("Double Strike", Passive),

    /** The skill name. */
    AlphaStrike("Alpha Strike", Q),

    /** The skill name. */
    Meditate("Meditate", W),

    /** The skill name. */
    WujuStyle("Wuju Style", E),

    /** The skill name. */
    Highlander("Highlander", R),

    /** The skill name. */
    Strut("Strut", Passive),

    /** The skill name. */
    DoubleUp("Double Up", Q),

    /** The skill name. */
    ImpureShots("Impure Shots", W),

    /** The skill name. */
    MakeItRain("Make It Rain", E),

    /** The skill name. */
    BulletTime("Bullet Time", R),

    /** The skill name. */
    IronMan("Iron Man", Passive),

    /** The skill name. */
    MaceOfSpades("Mace of Spades", Q),

    /** The skill name. */
    CreepingDeath("Creeping Death", W),

    /** The skill name. */
    SiphonOfDestruction("Siphon of Destruction", E),

    /** The skill name. */
    ChildrenOftheGrave("Children of the Grave", R),

    /** The skill name. */
    SoulSiphon("Soul Siphon", Passive),

    /** The skill name. */
    DarkBinding("Dark Binding", Q),

    /** The skill name. */
    TormentedSoil("Tormented Soil", W),

    /** The skill name. */
    BlackShield("Black Shield", E),

    /** The skill name. */
    SoulShackles("Soul Shackles", R),

    /** The skill name. */
    SurgingTides("Surging Tides", Passive),

    /** The skill name. */
    AquaPrison("Aqua Prison", Q),

    /** The skill name. */
    EbbandFlow("Ebb and Flow", W),

    /** The skill name. */
    TidecallersBlessing("Tidecaller's Blessing", E),

    /** The skill name. */
    TidalWave("Tidal Wave", R),

    /** The skill name. */
    SoulEater("Soul Eater", Passive),

    /** The skill name. */
    SiphoningStrike("Siphoning Strike", Q),

    /** The skill name. */
    Wither("Wither", W),

    /** The skill name. */
    SpiritFire("Spirit Fire", E),

    /** The skill name. */
    FuryOftheSands("Fury of the Sands", R),

    /** The skill name. */
    StaggeringBlow("Staggering Blow", Passive),

    /** The skill name. */
    DredgeLine("Dredge Line", Q),

    /** The skill name. */
    TitansWrath("Titan's Wrath", W),

    /** The skill name. */
    Riptide("Riptide", E),

    /** The skill name. */
    DepthCharge("Depth Charge", R),

    /** The skill name. */
    Prowl("Prowl", Passive),

    /** The skill name. */
    JavelinToss("Javelin Toss", Q),

    /** The skill name. */
    Takedown("Takedown", Q),

    /** The skill name. */
    Bushwhack("Bushwhack", W),

    /** The skill name. */
    Pounce("Pounce", W),

    /** The skill name. */
    PrimalSurge("Primal Surge", E),

    /** The skill name. */
    Swipe("Swipe", E),

    /** The skill name. */
    AspectOfTheCougar("Aspect Of The Cougar", R),

    /** The skill name. */
    UmbraBlades("Umbra Blades", Passive),

    /** The skill name. */
    Duskbringer("Duskbringer", Q),

    /** The skill name. */
    ShroudOfDarkness("Shroud of Darkness", W),

    /** The skill name. */
    UnspeakableHorror("Unspeakable Horror", E),

    /** The skill name. */
    Paranoia("Paranoia", R),

    /** The skill name. */
    Visionary("Visionary", Passive),

    /** The skill name. */
    Consume("Consume", Q),

    /** The skill name. */
    BloodBoil("Blood Boil", W),

    /** The skill name. */
    IceBlast("Ice Blast", E),

    /** The skill name. */
    AbsoluteZero("Absolute Zero", R),

    /** The skill name. */
    BerserkerRage("Berserker Rage", Passive),

    /** The skill name. */
    Undertow("Undertow", Q),

    /** The skill name. */
    ViciousStrikes("Vicious Strikes", W),

    /** The skill name. */
    RecklessSwing("Reckless Swing", E),

    /** The skill name. */
    Ragnarok("Ragnarok", R),

    /** The skill name. */
    ClockworkWindup("Clockwork Windup", Passive),

    /** The skill name. */
    CommandAttack("Command: Attack", Q),

    /** The skill name. */
    CommandDissonance("Command: Dissonance", W),

    /** The skill name. */
    CommandProtect("Command: Protect", E),

    /** The skill name. */
    CommandShockwave("Command: Shockwave", R),

    /** The skill name. */
    AegisProtection("Aegis Protection", Passive),

    /** The skill name. */
    SpearShot("Spear Shot", Q),

    /** The skill name. */
    AegisOfZeonia("Aegis of Zeonia", W),

    /** The skill name. */
    HeartseekerStrike("Heartseeker Strike", E),

    /** The skill name. */
    GrandSkyfall("Grand Skyfall", R),

    /** The skill name. */
    ValiantFighter("Valiant Fighter", Passive),

    /** The skill name. */
    DevastatingBlow("Devastating Blow", Q),

    /** The skill name. */
    ParagonOfDemacia("Paragon of Demacia", W),

    /** The skill name. */
    HeroicCharge("Heroic Charge", E),

    /** The skill name. */
    DiplomaticImmunity("Diplomatic Immunity", R),

    /** The skill name. */
    SpikedShell("Spiked Shell", Passive),

    /** The skill name. */
    Powerball("Powerball", Q),

    /** The skill name. */
    DefensiveBallCurl("Defensive Ball Curl", W),

    /** The skill name. */
    PuncturingTaunt("Puncturing Taunt", E),

    /** The skill name. */
    Tremors("Tremors", R),

    /** The skill name. */
    ReignOfAnger("Reign of Anger", Passive),

    /** The skill name. */
    CullTheMeek("Cull the Meek", Q),

    /** The skill name. */
    RuthlessPredator("Ruthless Predator", W),

    /** The skill name. */
    SliceandDice("Slice and Dice", E),

    /** The skill name. */
    Dominus("Dominus", R),

    /** The skill name. */
    UnseenPredator("Unseen Predator", Passive),

    /** The skill name. */
    Savagery("Savagery", Q),

    /** The skill name. */
    BattleRoar("Battle Roar", W),

    /** The skill name. */
    BolaStrike("Bola Strike", E),

    /** The skill name. */
    ThrillOftheHunt("Thrill of the Hunt", R),

    /** The skill name. */
    RunicBlade("Runic Blade", Passive),

    /** The skill name. */
    BrokenWings("Broken Wings", Q),

    /** The skill name. */
    KiBurst("Ki Burst", W),

    /** The skill name. */
    Valor("Valor", E),

    /** The skill name. */
    BladeOftheExile("Blade of the Exile", R),

    /** The skill name. */
    JunkyardTitan("Junkyard Titan", Passive),

    /** The skill name. */
    Flamespitter("Flamespitter", Q),

    /** The skill name. */
    ScrapShield("Scrap Shield", W),

    /** The skill name. */
    ElectroHarpoon("Electro-Harpoon", E),

    /** The skill name. */
    TheEqualizer("The Equalizer", R),

    /** The skill name. */
    ArcaneMastery("Arcane Mastery", Passive),

    /** The skill name. */
    Overload("Overload", Q),

    /** The skill name. */
    RunePrison("Rune Prison", W),

    /** The skill name. */
    SpellFlux("Spell Flux", E),

    /** The skill name. */
    DesperatePower("Desperate Power", R),

    /** The skill name. */
    Frost("Frost", Passive),

    /** The skill name. */
    ArcticAssault("Arctic Assault", Q),

    /** The skill name. */
    NorthernWinds("Northern Winds", W),

    /** The skill name. */
    Permafrost("Permafrost", E),

    /** The skill name. */
    GlacialPrison("Glacial Prison", R),

    /** The skill name. */
    Backstab("Backstab", Passive),

    /** The skill name. */
    Deceive("Deceive", Q),

    /** The skill name. */
    JackInTheBox("Jack In The Box", W),

    /** The skill name. */
    TwoShivPoison("Two-Shiv Poison", E),

    /** The skill name. */
    Hallucinate("Hallucinate", R),

    /** The skill name. */
    KiStrike("Ki Strike", Passive),

    /** The skill name. */
    VorpalBlade("Vorpal Blade", Q),

    /** The skill name. */
    Feint("Feint", W),

    /** The skill name. */
    ShadowDash("Shadow Dash", E),

    /** The skill name. */
    StandUnited("Stand United", R),

    /** The skill name. */
    FuryOftheDragonborn("Fury of the Dragonborn", Passive),

    /** The skill name. */
    TwinBite("Twin Bite", Q),

    /** The skill name. */
    Burnout("Burnout", W),

    /** The skill name. */
    FlameBreath("Flame Breath", E),

    /** The skill name. */
    DragonsDescent("Dragon's Descent", R),

    /** The skill name. */
    EmpoweredBulwark("Empowered Bulwark", Passive),

    /** The skill name. */
    PoisonTrail("Poison Trail", Q),

    /** The skill name. */
    MegaAdhesive("Mega Adhesive", W),

    /** The skill name. */
    Fling("Fling", E),

    /** The skill name. */
    InsanityPotion("Insanity Potion", R),

    /** The skill name. */
    FeelNoPain("Feel No Pain", Passive),

    /** The skill name. */
    CrypticGaze("Cryptic Gaze", Q),

    /** The skill name. */
    DeathsCaress("Death's Caress", W),

    /** The skill name. */
    Enrage("Enrage", E),

    /** The skill name. */
    Cannibalism("Cannibalism", R),

    /** The skill name. */
    FleetOfFoot("Fleet of Foot", Passive),

    /** The skill name. */
    BoomerangBlade("Boomerang Blade", Q),

    /** The skill name. */
    Ricochet("Ricochet", W),

    /** The skill name. */
    SpellShield("Spell Shield", E),

    /** The skill name. */
    OnTheHunt("On The Hunt", R),

    /** The skill name. */
    Energize("Energize", Passive),

    /** The skill name. */
    CrystalSlash("Crystal Slash", Q),

    /** The skill name. */
    CrystallineExoskeleton("Crystalline Exoskeleton", W),

    /** The skill name. */
    Fracture("Fracture", E),

    /** The skill name. */
    Impale("Impale", R),

    /** The skill name. */
    PowerChord("Power Chord", Passive),

    /** The skill name. */
    HymnOfValor("Hymn of Valor", Q),

    /** The skill name. */
    AriaOfPerseverance("Aria of Perseverance", W),

    /** The skill name. */
    SongOfCelerity("Song of Celerity", E),

    /** The skill name. */
    Crescendo("Crescendo", R),

    /** The skill name. */
    Consecration("Consecration", Passive),

    /** The skill name. */
    Starcall("Starcall", Q),

    /** The skill name. */
    AstralBlessing("Astral Blessing", W),

    /** The skill name. */
    Infuse("Infuse", E),

    /** The skill name. */
    Wish("Wish", R),

    /** The skill name. */
    CarrionRenewal("Carrion Renewal", Passive),

    /** The skill name. */
    Decrepify("Decrepify", Q),

    /** The skill name. */
    Nevermove("Nevermove", W),

    /** The skill name. */
    Torment("Torment", E),

    /** The skill name. */
    RavenousFlock("Ravenous Flock", R),

    /** The skill name. */
    Transcendent("Transcendent", Passive),

    /** The skill name. */
    DarkSphere("Dark Sphere", Q),

    /** The skill name. */
    ForceOfWill("Force of Will", W),

    /** The skill name. */
    ScatterTheWeak("Scatter the Weak", E),

    /** The skill name. */
    UnleashedPower("Unleashed Power", R),

    /** The skill name. */
    Mercy("Mercy", Passive),

    /** The skill name. */
    NoxianDiplomacy("Noxian Diplomacy", Q),

    /** The skill name. */
    Rake("Rake", W),

    /** The skill name. */
    Cutthroat("Cutthroat", E),

    /** The skill name. */
    ShadowAssault("Shadow Assault", R),

    /** The skill name. */
    Gemcraft("Gemcraft", Passive),

    /** The skill name. */
    Imbue("Imbue", Q),

    /** The skill name. */
    Shatter("Shatter", W),

    /** The skill name. */
    Dazzle("Dazzle", E),

    /** The skill name. */
    Radiance("Radiance", R),

    /** The skill name. */
    Camouflage("Camouflage", Passive),

    /** The skill name. */
    BlindingDart("Blinding Dart", Q),

    /** The skill name. */
    MoveQuick("Move Quick", W),

    /** The skill name. */
    ToxicShot("Toxic Shot", E),

    /** The skill name. */
    NoxiousTrap("Noxious Trap", R),

    /** The skill name. */
    Damnation("Damnation", Passive),

    /** The skill name. */
    DeathSentence("Death Sentence", Q),

    /** The skill name. */
    DarkPassage("Dark Passage", W),

    /** The skill name. */
    Flay("Flay", E),

    /** The skill name. */
    TheBox("The Box", R),

    /** The skill name. */
    DrawaBead("Draw a Bead", Passive),

    /** The skill name. */
    RapidFire("Rapid Fire", Q),

    /** The skill name. */
    RocketJump("Rocket Jump", W),

    /** The skill name. */
    ExplosiveShot("Explosive Shot", E),

    /** The skill name. */
    BusterShot("Buster Shot", R),

    /** The skill name. */
    Decompose("Decompose", Passive),

    /** The skill name. */
    RabidBite("Rabid Bite", Q),

    /** The skill name. */
    Contaminate("Contaminate", W),

    /** The skill name. */
    PillarOfFilth("Pillar of Filth", E),

    /** The skill name. */
    Agony("Agony", R),

    /** The skill name. */
    BattleFury("Battle Fury", Passive),

    /** The skill name. */
    Bloodlust("Bloodlust", Q),

    /** The skill name. */
    MockingShout("Mocking Shout", W),

    /** The skill name. */
    SpinningSlash("Spinning Slash", E),

    /** The skill name. */
    UndyingRage("Undying Rage", R),

    /** The skill name. */
    LoadedDice("Loaded Dice", Passive),

    /** The skill name. */
    WildCards("Wild Cards", Q),

    /** The skill name. */
    PickACard("Pick A Card", W),

    /** The skill name. */
    StackedDeck("Stacked Deck", E),

    /** The skill name. */
    Destiny("Destiny", R),

    /** The skill name. */
    DeadlyVenom("Deadly Venom", Passive),

    /** The skill name. */
    Ambush("Ambush", Q),

    /** The skill name. */
    VenomCask("Venom Cask", W),

    /** The skill name. */
    Expunge("Expunge", E),

    /** The skill name. */
    SprayandPray("Spray and Pray", R),

    /** The skill name. */
    MonkeysAgility("Monkey's Agility", Passive),

    /** The skill name. */
    TigerStance("Tiger Stance", Q),

    /** The skill name. */
    TurtleStance("Turtle Stance", W),

    /** The skill name. */
    BearStance("Bear Stance", E),

    /** The skill name. */
    PhoenixStance("Phoenix Stance", R),

    /** The skill name. */
    ZaunTouchedBoltAugmenter("Zaun-Touched Bolt Augmenter", Passive),

    /** The skill name. */
    AcidHunter("Acid Hunter", Q),

    /** The skill name. */
    TerrorCapacitor("Terror Capacitor", W),

    /** The skill name. */
    NoxianCorrosiveCharge("Noxian Corrosive Charge", E),

    /** The skill name. */
    HyperKineticPositionReverser("Hyper-Kinetic Position Reverser", R),

    /** The skill name. */
    LivingVengeance("Living Vengeance", Passive),

    /** The skill name. */
    PiercingArrow("Piercing Arrow", Q),

    /** The skill name. */
    BlightedQuiver("Blighted Quiver", W),

    /** The skill name. */
    HailOfArrows("Hail of Arrows", E),

    /** The skill name. */
    ChainOfCorruption("Chain of Corruption", R),

    /** The skill name. */
    NightHunter("Night Hunter", Passive),

    /** The skill name. */
    Tumble("Tumble", Q),

    /** The skill name. */
    SilverBolts("Silver Bolts", W),

    /** The skill name. */
    Condemn("Condemn", E),

    /** The skill name. */
    FinalHour("Final Hour", R),

    /** The skill name. */
    Equilibrium("Equilibrium", Passive),

    /** The skill name. */
    BalefulStrike("Baleful Strike", Q),

    /** The skill name. */
    DarkMatter("Dark Matter", W),

    /** The skill name. */
    EventHorizon("Event Horizon", E),

    /** The skill name. */
    PrimordialBurst("Primordial Burst", R),

    /** The skill name. */
    BlastShield("Blast Shield", Passive),

    /** The skill name. */
    VaultBreaker("Vault Breaker", Q),

    /** The skill name. */
    DentingBlows("Denting Blows", W),

    /** The skill name. */
    ExcessiveForce("Excessive Force", E),

    /** The skill name. */
    AssaultandBattery("Assault and Battery", R),

    /** The skill name. */
    EvolvingTechnology("Evolving Technology", Passive),

    /** The skill name. */
    PowerTransfer("Power Transfer", Q),

    /** The skill name. */
    GravityField("Gravity Field", W),

    /** The skill name. */
    DeathRay("Death Ray", E),

    /** The skill name. */
    ChaosStorm("Chaos Storm", R),

    /** The skill name. */
    CrimsonPact("Crimson Pact", Passive),

    /** The skill name. */
    Transfusion("Transfusion", Q),

    /** The skill name. */
    SanguinePool("Sanguine Pool", W),

    /** The skill name. */
    TidesOfBlood("Tides of Blood", E),

    /** The skill name. */
    Hemoplague("Hemoplague", R),

    /** The skill name. */
    ChosenOftheStorm("Chosen of the Storm", Passive),

    /** The skill name. */
    RollingThunder("Rolling Thunder", Q),

    /** The skill name. */
    Frenzy("Frenzy", W),

    /** The skill name. */
    MajesticRoar("Majestic Roar", E),

    /** The skill name. */
    ThunderClaws("Thunder Claws", R),

    /** The skill name. */
    EternalThirst("Eternal Thirst", Passive),

    /** The skill name. */
    HungeringStrike("Hungering Strike", Q),

    /** The skill name. */
    HuntersCall("Hunters Call", W),

    /** The skill name. */
    BloodScent("Blood Scent", E),

    /** The skill name. */
    InfiniteDuress("Infinite Duress", R),

    /** The skill name. */
    StoneSkin("Stone Skin", Passive),

    /** The skill name. */
    CrushingBlow("Crushing Blow", Q),

    /** The skill name. */
    Decoy("Decoy", W),

    /** The skill name. */
    NimbusStrike("Nimbus Strike", E),

    /** The skill name. */
    Cyclone("Cyclone", R),

    /** The skill name. */
    AscendedForm("Ascended Form", Passive),

    /** The skill name. */
    Arcanopulse("Arcanopulse", Q),

    /** The skill name. */
    LocusOfPower("Locus of Power", W),

    /** The skill name. */
    MageChains("Mage Chains", E),

    /** The skill name. */
    ArcaneBarrage("Arcane Barrage", R),

    /** The skill name. */
    Challenge("Challenge", Passive),

    /** The skill name. */
    ThreeTalonStrike("Three Talon Strike", Q),

    /** The skill name. */
    BattleCry("Battle Cry", W),

    /** The skill name. */
    AudaciousCharge("Audacious Charge", E),

    /** The skill name. */
    CrescentSweep("Crescent Sweep", R),

    /** The skill name. */
    UnholyCovenant("Unholy Covenant", Passive),

    /** The skill name. */
    OmenOfWar("Omen of War", Q),

    /** The skill name. */
    OmenOfPestilence("Omen of Pestilence", W),

    /** The skill name. */
    OmenOfFamine("Omen of Famine", E),

    /** The skill name. */
    OmenOfDeath("Omen of Death", R),

    /** The skill name. */
    ContemptforTheWeak("Contempt for the Weak", Passive),

    /** The skill name. */
    RazorShuriken("Razor Shuriken", Q),

    /** The skill name. */
    LivingShadow("Living Shadow", W),

    /** The skill name. */
    ShadowSlash("Shadow Slash", E),

    /** The skill name. */
    DeathMark("Death Mark", R),

    /** The skill name. */
    ShortFuse("Short Fuse", Passive),

    /** The skill name. */
    BouncingBomb("Bouncing Bomb", Q),

    /** The skill name. */
    SatchelCharge("Satchel Charge", W),

    /** The skill name. */
    HexplosiveMinefield("Hexplosive Minefield", E),

    /** The skill name. */
    MegaInfernoBomb("Mega Inferno Bomb", R),

    /** The skill name. */
    HeightenedLearning("Heightened Learning", Passive),

    /** The skill name. */
    TimeBomb("Time Bomb", Q),

    /** The skill name. */
    Rewind("Rewind", W),

    /** The skill name. */
    TimeWarp("Time Warp", E),

    /** The skill name. */
    ChronoShift("Chrono Shift", R),

    /** The skill name. */
    RiseOftheThorns("Rise of the Thorns", Passive),

    /** The skill name. */
    DeadlyBloom("Deadly Bloom", Q),

    /** The skill name. */
    RampantGrowth("Rampant Growth", W),

    /** The skill name. */
    GraspingRoots("Grasping Roots", E),

    /** The skill name. */
    Stranglethorns("Stranglethorns", R);

    /** The current writing version. */
    private static Version version;

    /** The skill name. */
    public final String name;

    /** The skill system name. */
    public final String system;

    /** The skill key type. */
    public final SkillKey key;

    /** The descriptor. */
    private SkillStatus[] versions = new SkillStatus[Version.values().length];

    /**
     * <p>
     * Create new Skill.
     * </p>
     * 
     * @param name
     */
    private Skill(String name, SkillKey key) {
        this.name = name;
        this.system = name.replaceAll(" of ", "Of").replaceAll("[\\s-,!':/]", "");
        this.key = key;
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/skill/" + system + ".jpg";
    }

    /**
     * <p>
     * Retrieve latest descriptor.
     * </p>
     */
    public SkillStatus getDescriptor() {
        return getStatus(Version.Latest);
    }

    /**
     * <p>
     * Returns skill level size.
     * </p>
     * 
     * @return
     */
    public int getMaxLevel() {
        if (key == Passive) {
            return 0;
        }
        return key == R && this != PhoenixStance ? 3 : 5;
    }

    /**
     * <p>
     * Retrieve a status at the specified version.
     * </p>
     */
    public SkillStatus getStatus(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            SkillStatus status = versions[i];

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
     * @return A champion descriptor.
     */
    SkillStatus update() {
        SkillStatus status = new SkillStatus(getStatus(version));

        versions[version.ordinal()] = status;

        return status;
    }

    static {
        version = P0000;
        EssenceTheft.update()
                .passive("スキルが敵ユニットに当たる度に" + EssenceTheft + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルに{1}が追加される。")
                .variable(1, SV, 35, 0)
                .cost(SkillCost.Charge, 9, 0);
        OrbOfDeception.update()
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。")
                .variable(1, MagicDamage, 40, 25, AP, 0.33)
                .variable(2, TrueDamage, 40, 25, AP, 0.33)
                .cd(7, 0)
                .cost(70, 5)
                .range(880);
        FoxFire.update()
                .active("Ahriの周囲を回る3本の鬼火を放つ。鬼火は5秒間持続し、近くの敵ユニットに自動的に突撃して{1}を与える。鬼火が同一対象に突撃した場合、2発目以降は本来の50%分の魔法DMを与える(同一対象に3発hitで合計200%の魔法DM)。Ahriの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。")
                .variable(1, MagicDamage, 40, 25, AP, 0.4)
                .cd(9, -1)
                .cost(60, 0)
                .range(800);
        Charm.update()
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}を与え、対象を{2}して自分の方向に移動させる。また魅了状態の対象には{3}が付与される。")
                .variable(1, MagicDamage, 60, 30, AP, 0.35)
                .variable(2, Status.Charm, 1, 0.25)
                .variable(3, Slow, 50, 0)
                .cd(12, 0)
                .cost(50, 15)
                .range(975);
        SpiritRush.update()
                .active("指定方向にダッシュした後、周囲の敵ユニット(範囲550,敵Championを優先)3体に{1}を与える。このスキルは10秒の間、3回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2～3発目はマナコスト無しで使用可能。")
                .variable(1, MagicDamage, 85, 40, AP, 0.35)
                .cd(110, -15)
                .cost(100, 0)
                .range(450);

        TwinDisciplines.update()
                .passive("増加ADが10以上の時、{1}を得る。その後増加AD6毎に{2}を得る。APが20以上のとき、通常攻撃に{3}が付与される。その後AP6毎にMagic Damageが1%増加する。")
                .variable(1, SV, 8, 0)
                .variable(2, SV, 1, 0)
                .variable(3, MagicDamage, 0, 0, AD, 0.08);
        MarkOftheAssassin.update()
                .active("対象の敵ユニットにカマを投げつけ{1}とマーク(6s)を与える。マークが付いた対象に通常攻撃または" + CrescentSlash.name + "でダメージを与えたとき、マークを消費して{2}を与え、{3}する。")
                .variable(1, MagicDamage, 45, 25, AP, 0.4)
                .variable(2, MagicDamage, 45, 25, AP, 0.4)
                .variable(3, RestoreEnergy, 20, 5)
                .cd(6, -0.5)
                .cost(SkillCost.Energy, 60, 0)
                .range(600);
        TwilightShroud.update()
                .active("指定地点に8秒間煙を発生させ範囲内のユニットに以下の効果を与える。AkaliはAR・MR上昇とステルスの効果を得る。敵ユニットにはスローを与える。")
                .cd(20, 0)
                .cost(SkillCost.Energy, 80, -5)
                .range(700);
        CrescentSlash.update()
                .active("周囲の敵ユニットに{1}を与える。")
                .variable(1, PhysicalDamage, 30, 25, AP, 0.3, AD, 0.6)
                .cd(7, -1)
                .cost(SkillCost.Energy, 60, -5)
                .range(325);
        ShadowDance.update()
                .active("対象の敵ユニットまで高速で移動し{1}を与える。使用時にチャージを消費する。チャージは時間経過・敵Championキル/アシストで増加し最大で3つまでチャージされる。チャージ増加時間はCD低減の影響を受ける。")
                .variable(1, MagicDamage, 100, 75, AP, 0.5)
                .cd(2, -0.5)
                .cost(SkillCost.Charge, 1, 0)
                .range(800);

        Trample.update()
                .passive("スキルを使用すると3秒間他のユニットをすり抜けられるようになり、周囲の敵ユニットと建物に毎秒{1}を与える。ミニオンとモンスターに対しては与えるダメージが2倍になる。")
                .variable(1, MagicDamage, 6, 0, AP, 0.1, Lv, 1)
                .range(182.5);
        Pulverize.update()
                .active("近くの敵ユニットに{1}を与え、{2}後に{3}を与える。")
                .variable(1, MagicDamage, 60, 45, AP, 0.5)
                .variable(2, KnockUp, 1, 0)
                .variable(3, Stun, 0.5, 0)
                .cd(17, -1)
                .cost(70, 10)
                .range(365);
        Headbutt.update()
                .active("対象の敵ユニットに突撃し{1}とノックバックを与える。")
                .variable(1, MagicDamage, 55, 55, AP, 0.7)
                .cd(14, -1)
                .cost(70, 10)
                .range(650);
        TriumphantRoar.update()
                .active("{1}する。近くの味方ユニットは{2}する。近くの敵ユニットが死ぬとCDが2秒解消される。")
                .variable(1, RestoreHealth, 60, 30, AP, 0.2)
                .variable(2, RestoreHealth, 30, 15, AP, 0.1)
                .cd(12, 0)
                .cost(40, 10)
                .range(575);
        UnbreakableWill.update()
                .active("7秒間Alistarは{1}及び{2}を得る。StunなどのDisable中でも使用可能。使用時に自身にかかっているCC(Stun, Slow, Taunt, Fear, Snare, Silence, Suppression)を解除する。")
                .variable(1, AD, 60, 10)
                .variable(2, DamageReductionRation, 50, 10)
                .cd(120, -20)
                .cost(100, 0);

        CursedTouch.update().passive("通常攻撃した対象に3秒間{1}を与える。レベル1、7、13で低下値が上昇する。").variable(1, MRReduction, 15, 5);
        BandageToss.update()
                .active("指定方向に包帯を飛ばし、当たった敵ユニットに{1}及び{2}を与え、そこまで移動する。")
                .variable(1, MagicDamage, 80, 60, AP, 0.7)
                .variable(2, Stun, 1, 0)
                .cost(80, 10)
                .cd(16, -2)
                .range(1100);
        Despair.update()
                .active("毎秒、周囲の敵ユニットに対象の最大Healthの{2} + {1}を与える。")
                .variable(1, MagicDamage, 8, 4)
                .variable(2, TargetHealth, 1.5, 0.3, AP, 0.01)
                .cost(8)
                .cd(1)
                .range(350)
                .toggle();
        Tantrum.update()
                .passive("{1}を得る。")
                .variable(1, PhysicalDamageReduction, 2, 2)
                .active("周囲の敵ユニットに{2}を与える。Amumuが通常攻撃でダメージを受けるたびにこのスキルのCDが0.5秒解消される。")
                .variable(2, MagicDamage, 75, 25, AP, 0.5)
                .cost(35)
                .cd(10, -1)
                .range(400);
        CurseOftheSadMummy.update()
                .active("周囲の敵ユニットに{1}を与え、2秒間通常攻撃と移動を封じる。")
                .variable(1, MagicDamage, 150, 100, AP, 0.8)
                .cost(100, 50)
                .cd(150, -20)
                .range(600);

        ArcaneMastery.update().passive("スキルを使用すると使用した以外のスキルのCDが1秒解消される。");
        Overload.update()
                .active("対象の敵ユニットに{1}を与える。")
                .passive("{2}を得る。")
                .variable(1, MagicDamage, 60, 25, AP, 0.4, Mana, 0.065)
                .variable(2, CDR, 2, 2)
                .cost(60)
                .cd(3.5)
                .range(650);
        RunePrison.update()
                .active("対象の敵ユニットに{1}及び{2}を与える。")
                .variable(1, MagicDamage, 60, 35, AP, 0.6, Mana, 0.045)
                .variable(2, Snare, 0.75, 0.25)
                .cost(80, 10)
                .cd(14)
                .range(625);
        SpellFlux.update()
                .active("対象の敵ユニットに魔法弾を飛ばし{1}及び{2}を与える。魔法弾は近くの敵ユニット及び自身に4回まで跳ね返る(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返り、また自身から跳ね返った弾は敵Championを優先で狙う。")
                .variable(1, MagicDamage, 50, 20, AP, 0.35, Mana, 0.01)
                .variable(2, MRReduction, 12, 3)
                .cost(60, 10)
                .cd(14)
                .range(675);
        DesperatePower.update()
                .active("{1}間、{2}及び{3}を得る。更にスキルに50%のスプラッシュダメージが付与される。")
                .variable(1, Time, 5, 1)
                .variable(2, SV, 15, 5)
                .variable(3, MS, 35, 10)
                .cd(70, -10);
    }
}
