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
import teemowork.lol.VariableResolver.Diff;
import teemowork.lol.VariableResolver.Fixed;
import teemowork.lol.VariableResolver.Per1Level;
import teemowork.lol.VariableResolver.Per2Level;
import teemowork.lol.VariableResolver.Per3Level;
import teemowork.lol.VariableResolver.Per4Level;
import teemowork.lol.VariableResolver.Per6Level;

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
    Playful("Playful", E),

    /** The skill name. */
    Trickster("Trickster", E),

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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
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
        SkillStatus status = new SkillStatus(this, getStatus(version));

        versions[version.ordinal()] = status;

        return status;
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
    private static final Variable amplify(Status status, double base) {
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
    private static final Variable amplify(Status status, double base, double diff) {
        return amplify(status, new Diff(base, diff));
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
    private static final Variable amplify(Status status, VariableResolver resolver) {
        Variable amplifier = new Variable();
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
    private static final Variable amplify(Status status, double base, double diff, Variable amplifier) {
        Variable one = amplify(status, base, diff);
        one.amplifiers.add(amplifier);

        return one;
    }

    static {
        version = P0000;
        EssenceTheft.update()
                .passive("スキルが敵ユニットに当たる度に" + EssenceTheft + "のチャージを1つ得る(1回のスキルで得られる上限は3チャージまで)。9チャージの状態でスキルを使用すると、チャージを全て消費して使用したスキルに{1}が追加される。")
                .variable(1, SV, 35)
                .cost(Charge, 9, 0)
                .conditional(1);
        OrbOfDeception.update()
                .active("指定方向にオーブを放ち当たった敵ユニットに{1}を与える。オーブは行きと帰りでそれぞれにヒット判定があり、帰りの場合は{2}を与える。")
                .variable(1, MagicDamage, 40, 25, ap(0.33))
                .variable(2, TrueDamage, 40, 25, ap(0.33))
                .cd(7, 0)
                .mana(70, 5)
                .range(880);
        FoxFire.update()
                .active("Ahriの周囲を回る3本の鬼火を放つ。鬼火は5秒間持続し、近くの敵ユニットに自動的に突撃して{1}を与える。鬼火が同一対象に突撃した場合、2発目以降は本来の50%分の魔法DMを与える(同一対象に3発hitで合計200%の魔法DM)。Ahriの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。")
                .variable(1, MagicDamage, 40, 25, ap(0.4))
                .cd(9, -1)
                .mana(60, 0)
                .range(800);
        Charm.update()
                .active("指定方向に投げキッスを放ち、当たった敵ユニットに{1}と{2}を与え自分の方向に移動させる。また" + Status.Charm + "した対象には{3}が付与される。")
                .variable(1, MagicDamage, 60, 30, ap(0.35))
                .variable(2, Status.Charm, 1, 0.25)
                .variable(3, Slow, 50)
                .cd(12, 0)
                .mana(50, 15)
                .range(975);
        SpiritRush.update()
                .active("指定方向にダッシュした後、{2}の敵ユニット(敵Championを優先)3体に{1}を与える。このスキルは10秒の間、3回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2～3発目はマナコスト無しで使用可能。")
                .variable(1, MagicDamage, 85, 40, ap(0.35))
                .variable(2, Radius, 500)
                .cd(110, -15)
                .mana(100, 0)
                .range(450);

        TwinDisciplines.update()
                .passive("{1}を得る。また通常攻撃に{2}が付与される。")
                .variable(1, SV, 6, 0, bounusAD(0.167))
                .variable(2, MagicDamage, 0, 0, amplify(AD, 0.06, 0, ap(0.00167)));
        MarkOftheAssassin.update()
                .active("対象の敵ユニットにカマを投げつけ{1}とマーク({4})を与える。マークが付いた対象に通常攻撃または" + CrescentSlash.name + "でダメージを与えたとき、マークを消費して{2}を与え、{3}する。")
                .variable(1, MagicDamage, 45, 25, ap(0.4))
                .variable(2, MagicDamage, 45, 25, ap(0.4))
                .variable(3, RestoreEnergy, 20, 5)
                .variable(4, Time, 6)
                .cd(6, -0.5)
                .cost(Energy, 60, 0)
                .range(600);
        TwilightShroud.update()
                .active("指定地点に8秒間煙を発生させ{1}のユニットに以下の効果を与える。Akaliは{2}と{3}、ステルスの効果を得る。敵ユニットには{4}を与える。")
                .variable(1, Radius, 300)
                .variable(2, AR, 10, 10)
                .variable(3, MR, 10, 10)
                .variable(4, Slow, 14, 4)
                .cd(20, 0)
                .cost(Energy, 80, -5)
                .range(700);
        CrescentSlash.update()
                .active("{2}の敵ユニットに{1}を与える。")
                .variable(1, PhysicalDamage, 30, 25, ap(0.3), ad(0.6))
                .variable(2, Radius, 325, 0)
                .cd(7, -1)
                .cost(Energy, 60, -5);
        ShadowDance.update()
                .active("対象の敵ユニットまで高速で移動し{1}を与える。使用時にチャージを消費する。チャージは{2}毎に又は敵Championキル/アシストで増加し最大で3つまでチャージされる。チャージ増加時間はCD低減の影響を受ける。")
                .variable(1, MagicDamage, 100, 75, ap(0.5))
                .variable(2, CDRAwareTime, 25, -5)
                .cd(2, -0.5)
                .cost(Charge, 1, 0)
                .range(800);

        Trample.update()
                .passive("スキルを使用すると3秒間他のユニットをすり抜けられるようになり、{2}の敵ユニットと建物に毎秒{1}を与える。ミニオンとモンスターに対しては与えるダメージが2倍になる。")
                .variable(1, MagicDamage, 6, 0, ap(0.1), amplify(Lv, 1))
                .variable(2, Radius, 182.5);
        Pulverize.update()
                .active("{4}の敵ユニットに{1}を与え、{2}後に{3}を与える。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, Knockup, 1)
                .variable(3, Stun, 0.5, 0)
                .variable(4, Radius, 365)
                .cd(17, -1)
                .mana(70, 10);
        Headbutt.update()
                .active("対象の敵ユニットに突撃し{1}と{2}を与える。")
                .variable(1, MagicDamage, 55, 55, ap(0.7))
                .variable(2, Knockback, 650)
                .cd(14, -1)
                .mana(70, 10)
                .range(650);
        TriumphantRoar.update()
                .active("{1}する。{3}の味方ユニットは{2}する。近くの敵ユニットが死ぬとCDが2秒解消される。")
                .variable(1, RestoreHealth, 60, 30, ap(0.2))
                .variable(2, RestoreHealth, 30, 15, ap(0.1))
                .variable(3, Radius, 575)
                .cd(12, 0)
                .mana(40, 10);
        UnbreakableWill.update()
                .active("7秒間Alistarは{1}及び{2}を得る。StunなどのDisable中でも使用可能。使用時に自身にかかっているCC(Stun, Slow, Taunt, Fear, Snare, Silence, Suppression)を解除する。")
                .variable(1, AD, 60, 10)
                .variable(2, DamageReductionRatio, 50, 10)
                .cd(120, -20)
                .mana(100, 0);

        CursedTouch.update()
                .passive("通常攻撃した対象に3秒間{1}を与える。レベル1、7、13で低下値が上昇する。")
                .variable(1, MRReduction, new Per6Level(15, 5))
                .conditional(1);
        BandageToss.update()
                .active("指定方向に包帯を飛ばし、当たった敵ユニットに{1}及び{2}を与え、そこまで移動する。")
                .variable(1, MagicDamage, 80, 60, ap(0.7))
                .variable(2, Stun, 1)
                .mana(80, 10)
                .cd(16, -2)
                .range(1100);
        Despair.update()
                .active("毎秒、{3}の敵ユニットに{1} + 対象の最大Healthの{2}を与える。")
                .variable(1, MagicDamage, 8, 4)
                .variable(2, TargetHealth, 1.5, 0.3, ap(0.01))
                .variable(3, Radius, 350)
                .mana(8)
                .cd(1)
                .type(SkillType.Toggle);
        Tantrum.update()
                .passive("{1}を得る。")
                .variable(1, PhysicalDamageReduction, 2, 2)
                .active("{3}の敵ユニットに{2}を与える。Amumuが通常攻撃でダメージを受けるたびにこのスキルのCDが0.5秒解消される。")
                .variable(2, MagicDamage, 75, 25, ap(0.5))
                .variable(3, Radius, 400)
                .mana(35)
                .cd(10, -1);
        CurseOftheSadMummy.update()
                .active("{2}の敵ユニットに{1}を与え、2秒間通常攻撃と移動を封じる。")
                .variable(1, MagicDamage, 150, 100, ap(0.8))
                .variable(2, Radius, 600)
                .mana(100, 50)
                .cd(150, -20);

        Rebirth.update()
                .passive("死亡時に卵になり6秒かけて復活する。復活中は{1}及び{2}を得る。復活中にHPが0になった場合は死亡する。レベル1、5、8、12、15で増加AR/MRが上昇する。")
                .variable(1, AR, new Per4Level(-40, 15))
                .variable(2, MR, new Per4Level(-40, 15))
                .cd(240)
                .conditional(1)
                .conditional(2);
        FlashFrost.update()
                .active("指定方向に貫通する氷を飛ばし、氷に触れた敵ユニットに{1}を与え、{3}間{2}と{4}にする。氷が飛んでいる最中に再度スキルを使用するか、最大距離まで飛ぶと氷が破裂し、破裂地点の{6}の敵ユニットにさらに{1}と{5}を与え、{3}間{2}と{4}にする。")
                .variable(1, MagicDamage, 60, 30, ap(0.5))
                .variable(2, Slow, 20)
                .variable(3, Time, 3)
                .variable(4, Chill, 0)
                .variable(5, Stun, 1)
                .variable(6, Radius, 150)
                .mana(80, 20)
                .cd(12, -1)
                .range(1100);
        Crystalize.update()
                .active("指定地点に5秒間{1}の壁を作りユニットを通れなくする。また、指定地点の視界を得る。")
                .variable(1, Length, 400, 100)
                .mana(70, 20)
                .cd(25)
                .range(1000);
        Frostbite.update()
                .active("対象の敵ユニットに{1}を与える。対象が" + Chill + "の場合は{2}を与える。")
                .variable(1, MagicDamage, 55, 30, ap(0.5))
                .variable(2, MagicDamage, 110, 60, ap(1.0))
                .mana(50, 10)
                .cd(5)
                .range(650);
        GlacialStorm.update()
                .active("指定地点の{6}の敵ユニットに毎秒{1}を与え、{4}間{2}と{3}、{5}にする。")
                .variable(1, MagicDamage, 80, 40, ap(0.25))
                .variable(2, ASReduction, 20, 0)
                .variable(3, Slow, 20)
                .variable(4, Time, 1)
                .variable(5, Chill, 0)
                .variable(6, Radius, 300)
                .mana(75)
                .cd(6)
                .range(625)
                .type(SkillType.Toggle);

        Pyromania.update()
                .passive("スキルを使用するたびにスタックが1貯まり、4スタック時に" + MoltenShield + "以外のスキルを使用すると、スタックを全て消費してそのスキルに{1}が追加される。")
                .variable(1, Stun, 1.75);
        Disintegrate.update()
                .active("対象の敵ユニットに{1}を与える。このスキルでLHを取ると消費した分のマナが回復する。")
                .variable(1, MagicDamage, 85, 40, ap(0.7))
                .mana(60, 5)
                .cd(4)
                .range(625);
        Incinerate.update()
                .active("指定方向扇形45°の{1}の敵ユニットに{2}を与える。")
                .variable(1, Radius, 625)
                .variable(2, MagicDamage, 80, 50, ap(0.75))
                .mana(70, 10)
                .cd(8);
        MoltenShield.update()
                .active("{1}間{2}と{3}を得て、効果時間中に通常攻撃をしてきた敵ユニットに{4}を与える。")
                .variable(1, Time, 5)
                .variable(2, AR, 20, 10)
                .variable(3, MR, 20, 10)
                .variable(4, MagicDamage, 20, 10, ap(0.2))
                .mana(20)
                .cd(10);
        SummonTibbers.update()
                .active("指定地点の{1}の敵ユニットに{2}を与え、操作可能なTibbersを召喚する。Tibbersは{3}間持続し、{4}の敵ユニットに毎秒{5}を与える。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 200, 125, ap(0.7))
                .variable(3, Time, 45, 0)
                .variable(4, Radius, 200)
                .variable(5, MagicDamage, 35, 0, ap(0.2))
                .mana(125, 50)
                .cd(120)
                .range(600);

        Focus.update()
                .passive("3秒毎に{1}を得る（最大100%）。通常攻撃を行うとリセットされる。上昇値は3レベル毎に増加する。")
                .variable(1, Critical, new Per3Level(3, 3))
                .conditional(1);
        FrostShot.update()
                .active("通常攻撃に{2}間の{1}を付与する。")
                .variable(1, Slow, 15, 5)
                .variable(2, Time, 2)
                .mana(8)
                .type(SkillType.Toggle);
        Volley.update()
                .active("指定方向扇形57.5°の方向に非貫通の矢7本を飛ばし当たった敵ユニットに{1}と{2}(" + FrostShot + "のLvに依存)を与える。" + FrostShot + "を覚えていない場合はスローは発生しない。")
                .variable(1, PhysicalDamage, 40, 10, ad(1))
                .variable(2, Slow, 0)
                .mana(60)
                .cd(16, -3)
                .range(1200);
        Hawkshot.update()
                .passive("敵を倒した際に追加で{1}を得る。")
                .variable(1, Gold, 1, 1)
                .active("指定地点に偵察鷹を放つ。鷹は指定した地点の視界を5秒間確保する。また飛行中の鷹も視界を持つ。")
                .cd(60)
                .range(2500, 750);
        EnchantedCrystalArrow.update()
                .active("指定方向に敵Championにのみ当たる矢を飛ばし、当たった敵Championに{1}と{2}(飛距離に比例して１～3.5秒)と{3}間の{4}を与える。また敵Champion命中時に矢が爆発し、{5}の敵ユニットに{6}と{3}間の{4}を与える。飛行中の矢は視界を持つ。")
                .variable(1, MagicDamage, 250, 175, ap(1))
                .variable(2, Stun, 0)
                .variable(3, Time, 3)
                .variable(4, Slow, 50)
                .variable(5, Radius, 250)
                .variable(6, MagicDamage, 125, 87.5, ap(0.5))
                .mana(150)
                .cd(100, -10)
                .range(-1);

        ManaBarrier.update()
                .passive(" HPが20%以下になった際、{1}を張る。このシールドは10秒間持続する。")
                .variable(1, Shield, 0, 0, amplify(CurrentMana, 50))
                .cd(90);
        RocketGrab.update()
                .active("指定方向に腕を飛ばし、当たった敵ユニットに{1}と{2}を与え自分の位置まで引き寄せる。またこのスキル命中時に対象の視界を得る。")
                .variable(1, MagicDamage, 80, 55, ap(1))
                .variable(2, Stun, 1)
                .mana(120)
                .cd(20, -1)
                .range(925);
        Overdrive.update()
                .active("8秒間自身の{1} {2}増加する。")
                .variable(1, MSRatio, 16, 4)
                .variable(2, ASRatio, 30, 8)
                .mana(75)
                .cd(15);
        PowerFist.update()
                .active("次の通常攻撃のダメージが{1}増加し、対象に{2}を与える。")
                .variable(1, PhysicalDamage, 0, 0, ad(1))
                .variable(2, Knockup, 1, 0)
                .mana(25)
                .cd(9, -1);
        StaticField.update()
                .passive("{1}の敵ユニット1体（対象はランダム）に2.5秒ごとに{2}を与える。")
                .variable(1, Radius, 450)
                .variable(2, MagicDamage, 100, 100, ap(0.25))
                .active("{3}の敵ユニットに{4}と{5}を与える。効果後はCDが解消されるまでPassiveの効果がなくなる。")
                .variable(3, Radius, 600)
                .variable(4, MagicDamage, 250, 125, ap(1))
                .variable(5, Silence, 0.5)
                .mana(150)
                .cd(30);

        Blaze.update()
                .passive("スキルが当たった敵ユニットを炎上させ、毎秒{1}与える。この効果は4秒間続く。炎上している敵ユニットにスキルが命中すると追加効果が発生する。(Minionに対しては毎秒80DMが上限)")
                .variable(1, MagicDamage, 0, 0, amplify(TargetHealth, 0.02));
        Sear.update()
                .active("指定方向に火球を投射し、当たった敵ユニットに{1}を与える。敵が炎上していた場合、{2}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.65))
                .variable(2, Stun, 2)
                .mana(50)
                .cd(8, -0.5)
                .range(1025);
        PillarOfFlame.update()
                .active("指定地点に炎の柱を作り出し、0.5秒後に{1}の敵ユニットに{2}を与える。敵が炎上していた場合、代わりに{3}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 75, 45, ap(0.6))
                .variable(3, MagicDamage, 94, 56, ap(0.75))
                .mana(70, 10)
                .cd(10)
                .range(900);
        Conflagration.update()
                .active("対象の敵ユニットに{1}を与える。敵が炎上していた場合、{2}の敵にも{1}を与える。")
                .variable(1, MagicDamage, 70, 35, ap(0.55))
                .variable(2, Radius, 200)
                .mana(60, 5)
                .cd(12, -1)
                .range(625);
        Pyroclasm.update()
                .active("対象の敵ユニットに火炎弾を放つ。火炎弾は近くの敵ユニットに4回まで跳ね、その度に{1}を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。敵が炎上していた場合、敵Championに優先して跳ね返るようになる。")
                .variable(1, MagicDamage, 150, 100, ap(0.5))
                .mana(100, 50)
                .cd(105, -15)
                .range(750);

        Headshot.update()
                .passive("通常攻撃{1}回毎にダメージが増加する(Minionには250%、Championには150%)。茂みから通常攻撃を行うと2回分としてカウントされる。レベル1、7、13でダメージが増加するまでの攻撃回数が減少する。")
                .variable(1, Count, new Per6Level(8, -1));
        PiltoverPeacemaker.update()
                .active("1秒詠唱後、指定方向に貫通する弾を発射し当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%減少していき最小で{2}を与える。")
                .variable(1, PhysicalDamage, 20, 40, ad(1.3))
                .variable(2, PhysicalDamage, 10, 20, ad(0.65))
                .mana(50, 10)
                .cd(10, -1)
                .range(1250);
        YordleSnapTrap.update()
                .active("指定地点に罠を仕掛ける。敵Championが罠の{4}に入ると発動して、対象に{1}かけて{2}と{3}を与え、9秒間対象の位置が見える。罠は3個まで置け、4分間持続する。")
                .variable(1, Time, 1.5)
                .variable(2, MagicDamage, 80, 50, ap(0.6))
                .variable(3, Snare, 1.5)
                .variable(4, Radius, 135)
                .mana(50)
                .cd(20, -3)
                .range(800);
        CaliberNet.update()
                .active("指定方向にネットを飛ばし当たった敵ユニットに{1}と{3}間{2}を与え、Caitlynはネットを飛ばした方向の反対側にジャンプ({4})する。")
                .variable(1, MagicDamage, 80, 50, ap(0.8))
                .variable(2, Slow, 50)
                .variable(3, Time, 1, 0.25)
                .variable(4, Distance, 400)
                .mana(75)
                .cd(18, -2)
                .range(850);
        AceinTheHole.update()
                .active("0.5秒詠唱後に対象の敵Championの視界を得て、更に1秒詠唱後対象に目掛けて敵Championにのみ当たる弾を発射し、当たった敵Championに{1}を与える。ターゲットとの射線を遮ると間に入った敵Championに当たる。")
                .variable(1, PhysicalDamage, 250, 225, bounusAD(2))
                .mana(100)
                .cd(90, -15)
                .range(2000, 500);

        ArcaneMastery.update().passive("スキルを使用すると使用した以外のスキルのCDが1秒解消される。");
        Overload.update()
                .active("対象の敵ユニットに{1}を与える。")
                .passive("{2}を得る。")
                .variable(1, MagicDamage, 60, 25, ap(0.4), amplify(Mana, 0.065))
                .variable(2, CDR, 2, 2)
                .mana(60)
                .cd(3.5)
                .range(650);
        RunePrison.update()
                .active("対象の敵ユニットに{1}及び{2}を与える。")
                .variable(1, MagicDamage, 60, 35, ap(0.6), amplify(Mana, 0.045))
                .variable(2, Snare, 0.75, 0.25)
                .mana(80, 10)
                .cd(14)
                .range(625);
        SpellFlux.update()
                .active("対象の敵ユニットに魔法弾を飛ばし{1}及び{2}を与える。魔法弾は{3}の敵ユニット及び自身に4回まで跳ね返る(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返り、また自身から跳ね返った弾は敵Championを優先で狙う。")
                .variable(1, MagicDamage, 50, 20, ap(0.35), amplify(Mana, 0.01))
                .variable(2, MRReduction, 12, 3)
                .variable(3, Radius, 400)
                .mana(60, 10)
                .cd(14)
                .range(675);
        DesperatePower.update()
                .active("{1}間、{2}及び{3}を得る。更にスキルに50%のスプラッシュダメージ({4})が付与される。")
                .variable(1, Time, 5, 1)
                .variable(2, SV, 15, 5)
                .variable(3, MS, 35, 10)
                .variable(4, Radius, 200)
                .cd(70, -10);

        /** Cassiopeia */
        DeadlyCadence.update().passive("スキル使用後の5秒間、全てのスキルのコストが1スタックにつき10%低減する。");
        NoxiousBlast.update()
                .active("指定地点に0.5秒後に毒を発生させ、{1}の敵ユニットに毒を与え3秒かけて{2}を与える。このスキルがChampionにヒットした場合、3秒間{3}増加する。")
                .variable(1, Radius, 75)
                .variable(2, MagicDamage, 75, 40, ap(0.8))
                .variable(3, MSRatio, 15, 2.5)
                .mana(35, 10)
                .cd(3)
                .range(850);
        Miasma.update()
                .active("指定地点に7秒間持続する毒霧を吹き出す。毒霧は徐々に範囲(100～175)が広がり、毒霧の上を通過した敵に2秒間持続する毒を付与し{1}と{2}の{3}を与える。また指定地点の視界を得る。")
                .variable(1, MagicDamage, 25, 10, ap(0.15))
                .variable(2, Time, 2)
                .variable(3, Slow, 15, 5)
                .mana(70, 10)
                .cd(9)
                .range(850);
        TwinFang.update()
                .active("対象の敵ユニットに{1}を与える。対象が毒を受けている場合、CDが0.5秒になる。")
                .variable(1, MagicDamage, 50, 35, ap(0.55))
                .mana(50, 10)
                .cd(5)
                .range(700);
        PetrifyingGaze.update()
                .active("眼からビームを放ち、指定方向扇形83°の範囲内の敵ユニットに{1}を与え、こちらを向いている敵に更に{2}を与える。後ろを向いていた場合スロー{3}の{4}を与える。")
                .variable(1, MagicDamage, 200, 125, ap(0.6))
                .variable(2, Stun, 2)
                .variable(3, Time, 2)
                .variable(4, Slow, 60)
                .mana(120, 40)
                .cd(130, -10)
                .range(750);

        /** Cho'Gath */
        Carnivore.update()
                .passive("敵ユニットを倒すと{1}{2}する。")
                .variable(1, RestoreHealth, 17, 0, amplify(Lv, 3))
                .variable(2, RestoreMana, 3.25, 0, amplify(Lv, 0.25));
        Rupture.update()
                .active("指定地点に0.5秒後にトゲを出現させ、{1}の敵ユニットに{2}、{3}を与えて、{4}間{5}にする。また指定地点の視界を得る。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(1))
                .variable(3, Knockup, 1)
                .variable(4, Time, 3)
                .variable(5, Slow, 60)
                .mana(90)
                .cd(9)
                .range(950);
        FeralScream.update()
                .active("前方扇形60°の領域の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 50, ap(0.7))
                .variable(2, Silence, 1.5, 0.25)
                .mana(70, 10)
                .cd(13)
                .range(700);
        VorpalSpikes.update()
                .active("通常攻撃時に前方にトゲを飛ばし当たった敵ユニットに{1}を与える。トゲを飛ばす範囲はUltのスタック数に比例し増加する。")
                .variable(1, MagicDamage, 20, 15, ap(0.3))
                .cd(0.5)
                .range(500)
                .type(SkillType.Toggle);
        Feast.update()
                .active("対象の敵ユニットに{1}を与える。対象がChampion以外の場合は{2}を与える。このスキルで敵を倒すとスタックが1増えて{3}と{4}が増加する。死亡するとスタックが半分(端数切り上げ)消失する。")
                .variable(1, TrueDamage, 300, 175, ap(0.7))
                .variable(2, TrueDamage, 1000, 0, ap(0.7))
                .variable(3, Health, 90, 30)
                .variable(4, Range, 4, 2.15)
                .mana(100)
                .cd(60)
                .range(150);

        /** Corki */
        HextechShrapnelShells.update().passive("通常攻撃に{1}が付与される。建物には無効。").variable(1, TrueDamage, 0, 0, ad(0.1));
        PhosphorusBomb.update()
                .active("指定した{1}の敵ユニットに{2}を与え、6秒間指定地点の視界を得る。また、Championに当たった場合、6秒間そのChampionの視界を得る。このスキルで敵のステルスを看破する事はできない。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 80, 50, ap(0.5))
                .mana(80, 10)
                .cd(8)
                .range(600);
        Valkyrie.update()
                .active("指定地点まで高速で移動し{1}、通過地点を2.5秒間炎上させる。炎上地点の上にいる敵ユニットに毎秒{2}を与える。")
                .variable(1, Distance, 800)
                .variable(2, MagicDamage, 60, 30, ap(0.4))
                .mana(100)
                .cd(26, -3)
                .range(800);
        GatlingGun.update()
                .active("4秒間、Corkiの前方にいる敵ユニットに0.5秒毎に{1}を与える(最大8hit)。ダメージを与える度に対象ユニットに{2}を与える。この効果は2秒間持続し、8回までスタックする。")
                .variable(1, PhysicalDamage, 10, 6, bounusAD(0.02))
                .variable(2, ARReduction, 1, 1)
                .mana(60, 5)
                .cd(16)
                .range(600);
        MissileBarrage.update()
                .active("指定方向にミサイルを発射し、当たった敵ユニットの{1}に{2}を与える。使用時にスタックを消費する。スタックは{3}毎に1つ増加し最大7つまでスタックされる。4発毎に大きいミサイル(効果範囲2倍、ダメージ50%上昇)を発射させる。スタック増加時間はCD低減の影響を受ける。")
                .variable(1, Radius, 150, 0)
                .variable(2, MagicDamage, 120, 70, ap(0.3), amplify(AD, 0.2))
                .variable(3, CDRAwareTime, 12)
                .mana(30, 5)
                .cd(1.2)
                .range(1200);

        /** Darius */
        Hemorrhage.update()
                .passive("通常攻撃またはスキルでダメージを与えた敵ユニットに出血スタックを付与する。出血スタックが付与された敵ユニットは毎秒{1}を受ける。出血スタックは最大5回までスタックし、5秒間持続する。また、出血スタックを受けている敵Champion数に応じて{2}ずつ増加していく。")
                .variable(1, MagicDamage, 2.4, 0, amplify(Lv, 0.3), bounusAD(0.06))
                .variable(2, MSRatio, 5)
                .conditional(2);
        Decimate.update()
                .active("斧を振り回し周囲の敵ユニットに{1}を与える。斧の刃に当たった敵Championに対しては{2}を与える。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.7))
                .variable(2, PhysicalDamage, 105, 52.5, bounusAD(1.05))
                .mana(40)
                .cd(9, -1)
                .range(425);
        CripplingStrike.update()
                .active("次の通常攻撃に{1}を追加し、{2}間{3}と{4}が付与される。対象の出血スタック数1個につき、このスキルのCDが1秒短縮される。")
                .variable(1, PhysicalDamage, 0, 0, ad(0.2))
                .variable(2, Time, 2)
                .variable(3, ASReduction, 20, 5)
                .variable(4, Slow, 20, 5)
                .mana(30, 5)
                .cd(8);
        Apprehend.update()
                .passive("{1}を得る。")
                .variable(1, ARPenRatio, 5, 5)
                .active("前方範囲内の敵ユニットをDariusがいる方向に引き寄せる。")
                .mana(45)
                .cd(24, -3)
                .range(550);
        NoxianGuillotine.update()
                .active("対象の敵Championに跳躍し、{1}を与える。対象の出血スタック数1個につき、このスキルのダメージが20%増加する(最大でダメージ2倍)。このスキルで敵Championのキルを取った場合、このスキルのCDが解消される。")
                .variable(1, TrueDamage, 160, 90, bounusAD(0.75))
                .mana(100)
                .cd(100, -10)
                .range(475);

        /** Diana */
        MoonsilverBlade.update()
                .passive("{1}増加する。通常攻撃3回毎に周囲にいる敵ユニットに{2}を与える。")
                .variable(1, ASRatio, 20)
                .variable(2, MagicDamage, new Per1Level(new int[] {20, 25, 30, 40, 50, 65, 80, 95, 110, 125, 140, 155,
                        175, 195, 215, 240, 265, 290}));
        CrescentStrike.update()
                .active("指定地点に弧を描くエネルギーを放ち、当たった敵ユニットとその{2}に{1}とMoonlight(3秒)を与える。またMoonlightが付与されている敵ユニットの位置が見える。")
                .variable(1, MagicDamage, 60, 35, ap(0.7))
                .variable(2, Radius, 50)
                .mana(55)
                .cd(10, -1)
                .range(830);
        PaleCascade.update()
                .active("5秒間ダメージを軽減する{1}を張ると同時に、Dianaの周りを回る3つの球体を召喚する。敵ユニットが触れた球体は爆発し、{2}の敵ユニットに{3}を与える。球体が全て爆発するとシールドが張りなおされる。")
                .variable(1, Shield, 55, 25, ap(0.45))
                .variable(2, Radius, 400)
                .variable(3, MagicDamage, 20, 14, ap(0.2))
                .mana(60, 10)
                .cd(10);
        Moonfall.update()
                .active("{1}にいるすべての敵ユニットをDianaがいる方向に引き寄せた後、{2}間{3}を与える。")
                .variable(1, Radius, 500)
                .variable(2, Time, 2)
                .variable(3, Slow, 35, 5)
                .mana(70)
                .cd(26, -2);
        LunarRush.update()
                .active("対象の敵ユニットの元までテレポートし、{1}を与える。対象にMoonlightが付与されていた場合、すべての敵ユニットに付与されたMoonlightを消費してこのスキルのCDが解消される。")
                .variable(1, MagicDamage, 100, 60, ap(0.6))
                .mana(50, 15)
                .cd(25, -5)
                .range(825);

        /** Dr.Mundo */
        AdrenalineRush.update().passive("毎秒{1}する。").variable(1, RestoreHealth, 0, 0, amplify(Health, 0.003));
        InfectedCleaver.update()
                .active("指定方向に包丁を投げ、当たった敵ユニットに{1}と{2}間の{3}を与える。最小DMは{5}。ミニオンやモンスターへの最大DMは{6}。命中すると{7}する。")
                .variable(1, MagicDamage, 0, 0, amplify(TargetCurrentHealth, 0.15, 0.03))
                .variable(2, Time, 2)
                .variable(3, Slow, 40)
                .variable(5, MagicDamage, 80, 50)
                .variable(6, MagicDamage, 300, 100)
                .variable(7, RestoreHealth, 25, 5)
                .cost(Health, 50, 10)
                .cd(4)
                .range(1000);
        BurningAgony.update()
                .active("{1}の敵ユニットに毎秒{2}を与える。また{3}を得る。")
                .variable(1, Radius, 325)
                .variable(2, MagicDamage, 35, 15, ap(0.2))
                .variable(3, Tenacity, 10, 5)
                .cost(Health, 10, 5)
                .cd(4)
                .type(SkillType.Toggle);
        Masochism.update()
                .active("5秒間{1}を得る。")
                .variable(1, AD, 40, 15, amplify(MissingHealth, 0.4, 0.15))
                .cost(Health, 35, 10)
                .cd(7);
        Sadism.update()
                .active("12秒かけて{1}し、{2}を得る。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.4, 0.15))
                .variable(2, MSRatio, 15, 10)
                .cd(75)
                .cost(CurrentHealth, 20, 0);

        /** Draven */
        WickedBlades.update()
                .passive("クリティカル時または" + SpinningAxe + "使用時の通常攻撃に毎秒{1}が付与される。毎秒ダメージは4秒間持続する。")
                .variable(1, PhysicalDamage, 7.5, 0, amplify(Lv, 1));
        SpinningAxe.update()
                .active("次に行う通常攻撃に追加{1}が付与される。このスキルによる通常攻撃が敵ユニットに命中すると、斧がDravenの近くに跳ね返る。その斧をキャッチするとBlood RushのCDが解消され、更に次の通常攻撃もSpinning Axeの効果を受けるようになる。このスキルは連続で使用する事で最大2回分までチャージできる。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, 0.45, 0.1))
                .mana(45)
                .cd(12, -1);
        BloodRush.update()
                .active("1.5秒間{1}増加し、3秒間{2}増加する。移動速度増加は1.5秒かけて元に戻る。")
                .variable(1, MSRatio, 40, 5)
                .variable(2, ASRatio, 20, 5)
                .mana(40)
                .cd(12);
        StandAside.update()
                .active("指定方向に貫通する斧を投げ、当たった敵ユニットに{1}と{2}と2秒間{3}を与える。このノックバックは斧から弾かれる形で左右に吹き飛ぶ。")
                .variable(1, PhysicalDamage, 70, 35, bounusAD(0.5))
                .variable(2, Knockback, 0)
                .variable(3, Slow, 20, 5)
                .mana(70)
                .cd(18, -1)
                .range(1050);
        WhirlingDeath.update()
                .active("指定方向に地面を這う貫通する斧を投げ、当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに8%ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定があり、斧が飛んでいる最中に再度このスキルを使用するか、敵Championに命中した時点で斧が反転してDravenの元に戻ってくる。反転した際、低下ダメージはリセットされる。また移動中の斧は視界を持つ。")
                .variable(1, PhysicalDamage, 175, 100, bounusAD(1.1))
                .mana(120)
                .cd(110)
                .range(-1);

        /** Elise */
        SpiderSwarm.update()
                .passive("Human Form時に使用したスキルが敵ユニットに命中するとSpiderlingのチャージを1得る。Spider Formになるとチャージ数に比例したSpiderlingを召喚する。召喚される数はSpider Form(Ult)のレベルに比例し増加する。召喚されたSpiderlingは死亡するとチャージが減るが、再度Human Formに戻ると再度チャージ状態に戻る。");
        Neurotoxin.update()
                .active("対象の敵ユニットに毒を放ち{1}を与える。")
                .variable(1, MagicDamage, 50, 45, amplify(TargetCurrentHealth, 8, 0, amplify(AP, 0.03)))
                .mana(80, 5)
                .cd(6)
                .range(475);
        VolatileSpiderling.update()
                .active("指定地点に蜘蛛を放つ。蜘蛛は敵ユニットに当たるか3秒間経過すると爆発し、範囲内の敵ユニットに{1}を与える。蜘蛛は指定地点に移動した後、最も近くにいる敵ユニットに向かって移動する。また蜘蛛は視界を持つ。")
                .variable(1, MagicDamage, 75, 50, ap(0.8))
                .mana(60, 10)
                .cd(12)
                .range(950);
        Cocoon.update()
                .active("指定方向に糸を飛ばし当たった敵ユニットの視界を得て、{1}を与える。")
                .variable(1, Stun, 1.5)
                .mana(50)
                .cd(14, -1)
                .range(1075);
        SpiderForm.update()
                .active("EliseがSpider Formに変身し射程125のMeleeになる。その間は通常攻撃に追加{1}が付与され、{2}と{3}、{4}を得る。またこのスキルに比例しSpiderlingの最大チャージ数、攻撃力が増加し、Spiderlingが受けるAoEダメージが低減される。")
                .variable(1, MagicDamage, 10, 10, ap(0.3))
                .variable(2, AR, 10, 5)
                .variable(3, MR, 10, 5)
                .variable(4, MS, 10)
                .cd(4);
        VenomousBite.update()
                .active("対象の敵ユニットに飛びつき{1} + {2}を与える。対象の減っているHPに比例しダメージが増加する。")
                .variable(1, MagicDamage, 50, 45)
                .variable(2, TargetMissingHealth, 8, 0, ap(0.03))
                .cd(6)
                .range(475);
        SkitteringFrenzy.update()
                .passive("Spiderlingの{1}増加する。")
                .variable(1, ASRatio, 5, 5)
                .active("3秒間EliseとSpiderlingの{2}増加する。また、その間Spiderlingが攻撃を行うたびにEliseの{3}する。")
                .variable(2, ASRatio, 60, 20)
                .variable(3, RestoreHealth, 4, 0, ap(0.02))
                .cd(12);
        Rappel.update()
                .active("EliseとSpiderlingが上空に退避し(ターゲット不可になる)指定の方法で降下する。上空にいる間は射程内の視界を得る地面をクリックした場合: 最大2秒間上空に待機し、初期位置へ降下する。この間、敵ユニットをターゲットし裏側に降下できる。敵ユニットをクリックした場合: 即座に下降し裏側に降り立つ。")
                .cd(26, -2)
                .range(1075);
        HumanForm.update().active("EliseがHuman Formに変身し射程550のRangedになる。").cd(4);

        /** Evelynn */
        ShadowWalk.update()
                .passive("Evelynnがステルス状態になる。スキルを使うか、ダメージを受けるか与えるかすると、6秒間ステルスが解除された状態になる。敵Championに範囲700まで近づくとステルス状態でも敵Championに視認されるようになる。また、ステルス中は毎秒{1}していく。")
                .variable(1, RestoreMana, 0, 0, amplify(Mana, 0.01));
        HateSpike.update()
                .active("視界内にいる最も近くにいる敵ユニット1体に向けて棘を放ち、直線状にいる敵ユニットに{1}を与える。Evelynnが敵ユニットをターゲットしている場合は、その対象に向けて棘が放たれる。")
                .variable(1, MagicDamage, 40, 20, ap(0.45), bounusAD(0.5))
                .mana(16, 6)
                .cd(1.5)
                .range(400);
        DarkFrenzy.update()
                .passive("敵Championにスキルを当てるたびに{1}増加する。移動速度増加は3秒間持続し、最大4スタックする。")
                .variable(1, MS, 4, 4)
                .active("3秒間{2}増加し、ユニットをすり抜けられるようになり、更にスローの効果を受けなくなる。敵Championキル/アシスト時に、このスキルのCDが解消される。")
                .variable(2, MSRatio, 30, 10)
                .cd(15);
        Ravage.update()
                .active("対象の敵ユニットに2回連続で{1}を与え、3秒間{2}増加する。")
                .variable(1, MagicDamage, 35, 20, ap(0.5), bounusAD(0.5))
                .variable(2, ASRatio, 60, 15)
                .mana(50, 5)
                .cd(9)
                .range(225);
        AgonysEmbrace.update()
                .active("指定{1}の敵ユニットに{2}と2秒間の{3}を与え、このスキルを命中させた敵Champion毎に6秒間持続する{4}を得る。")
                .variable(1, Radius, 500)
                .variable(2, MagicDamage, 0, 0, amplify(TargetCurrentHealth, 15, 5, ap(0.01)))
                .variable(3, Slow, 30, 20)
                .variable(4, Shield, 150, 75)
                .mana(100)
                .cd(150, -30)
                .range(650);

        /** Ezreal */
        RisingSpellForce.update()
                .passive("ユニット(敵味方問わず)にスキルを当てる度に5秒間{1}増加する。この効果は5回分までスタックする。")
                .variable(1, ASRatio, 10)
                .conditional(1);
        MysticShot.update()
                .active("指定方向に魔法の矢を飛ばし、当たった敵ユニットに{1}を与える。このスキルが命中すると、EzrealのすべてのスキルのCD待ち時間が1秒解消される。このスキルはOn-Hit Effectsの影響を受ける。")
                .variable(1, PhysicalDamage, 35, 20, ap(0.2), ad(1))
                .mana(28, 3)
                .cd(6, -0.5)
                .range(1150);
        EssenceFlux.update()
                .active("指定方向にChampionにのみ当たる貫通するエネルギーを飛ばし、当たった味方Championは5秒間{1}増加し、敵Championに{2}を与える。")
                .variable(1, ASRatio, 20, 5)
                .variable(2, MagicDamage, 70, 45, ap(0.8))
                .mana(50, 10)
                .cd(9)
                .range(1000);
        ArcaneShift.update()
                .active("指定地点にテレポートし、テレポート先から一番近い敵ユニット({1})1体に{2}を与える。")
                .variable(1, Radius, 750)
                .variable(2, MagicDamage, 75, 50, ap(0.75))
                .mana(90)
                .cd(19, -2)
                .range(475);
        TrueshotBarrage.update()
                .active("1秒詠唱後、指定方向に射程無限の貫通する魔法の矢を飛ばし当たった敵ユニットに{1}を与える。ダメージは敵に当たるごとに10%ずつ減り、最大で30%まで低下する。また飛行中の矢は視界を持つ。")
                .variable(1, MagicDamage, 350, 150, ap(0.9), bounusAD(1))
                .mana(100)
                .cd(80)
                .range(-1);

        /** Fiddlesticks */
        Dread.update().passive("{1}の敵ユニットに{2}を与える。").variable(1, Radius, 1000).variable(2, Status.MRReduction, 10);
        Terrify.update().active("対象の敵ユニットに{1}を与える。").variable(1, Fear, 1, 0.5).mana(65, 10).cd(15, -1).range(575);
        Drain.update()
                .active("対象の敵ユニットに最大5秒間毎秒{1}を与え、{2}する。敵が離れる({3})と詠唱が中断される。")
                .variable(1, MagicDamage, 60, 30, ap(0.45))
                .variable(2, RestoreHealth, 0, 0, amplify(Damage, 60, 5))
                .variable(3, Radius, 750)
                .mana(80, 10)
                .cd(10, -1)
                .range(475)
                .type(SkillType.Channel);
        DarkWind.update()
                .active("対象の敵ユニットにカラスを飛ばし{1}と{2}を与える。カラスは{4}の敵ユニットに4回まで跳ね返りその度に効果を与える(最大5hit)。この跳ね返りは同一ユニットに何度も跳ね返る。ミニオンとモンスターに対しては{3}を与える。")
                .variable(1, MagicDamage, 65, 20, ap(0.45))
                .variable(2, Silence, 1.2)
                .variable(3, MagicDamage, 97.5, 30, ap(0.675))
                .variable(4, Radius, 450)
                .mana(50, 20)
                .cd(15, -1)
                .range(750);
        Crowstorm.update()
                .active("1.5秒詠唱後に指定地点にテレポートし、{1}の敵ユニットに5秒間毎秒{2}を与える。最大DMは{3}となる。")
                .variable(1, Radius, 600)
                .variable(2, MagicDamage, 125, 100, ap(0.45))
                .variable(3, MagicDamage, 625, 500, ap(2.25))
                .mana(150, 50)
                .cd(150, -10)
                .range(800)
                .type(SkillType.Channel);

        /** Fiora */
        Duelist.update()
                .passive("通常攻撃またはLungeでダメージを与えると、6秒かけて{1}する。対象がChampionの場合、この効果は4回までスタックする。")
                .variable(1, RestoreHealth, 7, 0, amplify(Lv, 1));
        Lunge.update()
                .active("対象の敵ユニットへダッシュし{1}を与える。このスキルは4秒の間、もう1度だけ使用できる。2度目は消費MN無しで使用可能。")
                .variable(1, PhysicalDamage, 40, 25, bounusAD(0.6))
                .mana(60)
                .cd(16, -2)
                .range(600);
        Riposte.update()
                .passive("{1}を得る。")
                .variable(1, AD, 15, 5)
                .active("1.5秒の間に受ける通常攻撃を一度だけ無効化し、その相手に{2}を与える。この効果は一部のミニオンとモンスターには発生しない。")
                .variable(2, MagicDamage, 60, 50, ap(1))
                .mana(45)
                .cd(10, -1);
        BurstOfSpeed.update()
                .active("3秒間{1}増加する。効果中に通常攻撃を行うかまたはLungeを使用すると3秒間{2}増加する。移動速度の増加は3回までスタックする。敵Championを倒すとこのスキルのCDが解消される。")
                .variable(1, ASRatio, 60, 15)
                .variable(2, MSRatio, 7, 2)
                .mana(55)
                .cd(15, -1);
        BladeWaltz.update()
                .active("対象の敵Championにダッシュし{1}を与え、範囲内にいる敵Championをランダムに対象とし4回{1}を与える（合計5回）。最後の攻撃は最初に対象とした敵Championで固定。同一ユニットに複数回DMを与える場合、2回目以降は25%のダメージになる。単一対象への最大DMは{2}。このスキルはOn-Hit Effectsの影響を受ける。")
                .variable(1, PhysicalDamage, 160, 170, bounusAD(1.15))
                .variable(2, PhysicalDamage, 320, 340, bounusAD(2.3))
                .mana(100)
                .cd(130, -10)
                .range(400);

        /** Fizz */
        NimbleFighter.update()
                .passive("ユニットをすり抜けるようになり、{1}を得る。この軽減は防御力計算より先に行われる。")
                .variable(1, NormalAttackDamageReduction, new Per3Level(4, 2));
        UrchinStrike.update()
                .active("対象の敵ユニットに追加{1}が付与された通常攻撃を与え、その方向に駆け抜ける。移動距離は固定。")
                .variable(1, MagicDamage, 10, 30, ap(0.6))
                .mana(50, 5)
                .cd(10, -1)
                .range(550);
        SeastoneTrident.update()
                .passive("通常攻撃に{1}が付与される。このダメージは0.5秒毎に3秒間かけて与えられる。(Minionに対しては300DMが上限)")
                .variable(1, MagicDamage, 30, 10, ap(0.35), amplify(TargetMissingHealth, 4, 1))
                .active("5秒間通常攻撃に{2}と3秒持続するHP回復量半減の効果が付与される。このダメージはPassiveと重複する。")
                .variable(2, MagicDamage, 10, 5, ap(0.35))
                .mana(40)
                .cd(10);
        Playful.update()
                .active("指定地点にジャンプする。ジャンプ中はターゲットされない状態になる。0.75秒後にその場に降下し、{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius, 250)
                .variable(2, MagicDamage, 70, 50, ap(0.75))
                .variable(3, Slow, 40, 5)
                .mana(90, 10)
                .cd(16, -2)
                .range(400);
        Trickster.update()
                .active("Playfulのジャンプ中のみ使用可能。降下する場所を別の指定地点に変更し、その{1}の敵ユニットに{2}を与える。このスキルを使用した場合Playfulのダメージとスローは発生しない。")
                .variable(1, Radius, 150)
                .variable(2, MagicDamage, 70, 50, ap(0.75))
                .cd(16, -2)
                .range(400);
        ChumTheWaters.update()
                .active("指定地点に敵Championのみに命中する魚を投げ、命中した敵Championに魚がくっつき、{1}を与える。その1.5秒後に地面から鮫が現れ、魚が命中した対象を襲い、対象とその周囲({2})の敵ユニットに{3}を与え、{4}後に1.5秒間{5}を与える。魚がくっついていた敵Champion以外のユニットには{4}の代わりに{6}を与える。魚がChampionに当たらなかった場合は指定地点に魚が残り、その地点に鮫が現れる。また魚は視界を確保し、その上を敵Championが通り過ぎると、当たった場合と同様にその敵Championにくっつき、鮫が襲いかかる。")
                .variable(1, Slow, 50, 10)
                .variable(2, Radius, 250)
                .variable(3, MagicDamage, 200, 125, ap(1))
                .variable(4, Knockup, 0)
                .variable(5, Slow, 50, 10)
                .variable(6, Knockback, 0)
                .mana(100)
                .cd(100, -15)
                .range(1275);

        /** Galio */
        RunicSkin.update().passive("{1}を得る。").variable(1, AP, 0, 0, amplify(MR, 0.5));
        ResoluteSmite.update()
                .active("指定地点に魔法弾を飛ばし、{1}の敵ユニットに{2}と2.5秒間{3}を与える。")
                .variable(1, Radius, 175)
                .variable(2, MagicDamage, 80, 55, ap(0.6))
                .variable(3, Slow, 24, 4)
                .mana(60, 5)
                .cd(7)
                .range(900);
        Bulwark.update()
                .active("4秒間対象のChampionは{1}と{2}を得て、効果中にその対象のChampionがダメージを受ける度にGalioの{3}する。自身に使用した場合はダメージを受けてから回復される。")
                .variable(1, AR, 30, 15)
                .variable(2, MR, 30, 15)
                .variable(3, RestoreHealth, 25, 15, ap(0.3))
                .mana(60)
                .cd(13)
                .range(800);
        RighteousGust.update()
                .active("指定方向に風を発生させ、当たった敵ユニットに{1}を与える。このスキルを使用すると指定した方向に5秒間持続する風が残り、その風の進行方向上にいる味方ユニットは{2}増加する。")
                .variable(1, MagicDamage, 60, 45, ap(0.5))
                .variable(2, MSRatio, 20, 8)
                .mana(70, 5)
                .cd(12)
                .range(1000);
        IdolOfDurand.update()
                .active("{1}の敵ユニットに{2}を与え、さらに2秒間詠唱を行う。詠唱中Galioは{3}を得て、詠唱中にGalioがダメージを受ける度にこのスキルのダメージが5%ずつ増加していく(最大40%増加)。また詠唱中にBulwarkを使用することが出来る。詠唱完了またはキャンセル時に、周囲の敵ユニットのTauntを解除するとともに{4}を与える。最大DMは{5}。")
                .variable(1, Radius, 600)
                .variable(2, Taunt, 2)
                .variable(3, DamageReductionRatio, 50)
                .variable(4, MagicDamage, 220, 110, ap(0.6))
                .variable(5, MagicDamage, 308, 154, ap(0.84))
                .mana(100, 50)
                .cd(170, -20)
                .type(SkillType.Channel);

        /** Gangplank */
        GrogSoakedBlade.update()
                .passive("通常攻撃時に対象にスタックを付与し、1スタックにつき毎秒{1}と{2}を与える。この効果は3秒間持続し、3回までスタックする。")
                .variable(1, MagicDamage, 3, 0, amplify(Lv, 1))
                .variable(2, Slow, 7);
        Parrrley.update()
                .active("対象の敵ユニットに{1}（クリティカルあり）を与える。このスキルで敵ユニットを倒すと消費マナの半分のマナが回復し、追加で{2}得る。このスキルはOn-Hit Effectsの影響を受ける。")
                .variable(1, PhysicalDamage, 20, 25, ad(1))
                .variable(2, Gold, 4, 1)
                .mana(50, 5)
                .cd(5)
                .range(625);
        RemoveScurvy.update()
                .active("自身のCC(Stun, Slow, Taunt, Fear, Snare, Silence, Suppression, Blind)を取り除き{1}する。StunなどのDisable中でも使用可能。")
                .variable(1, RestoreHealth, 80, 70, ap(1))
                .mana(65)
                .cd(22, -1);
        RaiseMorale.update()
                .passive("{1}を得て、{2}増加する。")
                .variable(1, AD, 8, 2)
                .variable(2, MSRatio, 3, 1)
                .active("7秒間{7}を得て、{3}増加する。{6}内の味方Championは{4}を得て{5}増加する。効果中はPassiveの効果が無効になる。")
                .variable(6, Radius, 1200)
                .variable(7, AD, 12, 7)
                .variable(3, MSRatio, 8, 3)
                .variable(4, AD, 6, 3.5)
                .variable(5, MSRatio, 4, 1.1)
                .mana(50, 5)
                .cd(25);
        CannonBarrage.update()
                .active("MAP内の指定した地点に砲撃を行い、その地点の視界({1})を得る。範囲内には7秒間砲弾が降り注ぎ（場所はランダム、計25発）、着弾した{2}にいる敵ユニットに{4}と1.25秒間{3}を与える。")
                .variable(1, Radius, 575)
                .variable(2, Radius, 275)
                .variable(3, Slow, 25)
                .variable(4, MagicDamage, 75, 45, ap(0.2))
                .mana(100)
                .cd(120, -5)
                .range(-1);

        /** Garen */
        Perseverance.update()
                .passive("9秒間敵Minion以外からダメージを受けない状態が続くと、以降敵Minion以外からダメージを受けるまで毎秒{1}し続ける。")
                .variable(1, RestoreHealth, 0, 0, amplify(Health, 0.005));
        DecisiveStrike.update()
                .active("{1}間{2}増加し、スキル使用後6秒間に行った次の通常攻撃に{3}と{4}が付与される。またこのスキル使用時に自身にかかっているスローを解除する。")
                .variable(1, Time, 1.5, 0.75)
                .variable(2, MSRatio, 35)
                .variable(3, PhysicalDamage, 30, 25, ad(0.4))
                .variable(4, Silence, 1.5, 0.25)
                .cd(8);
        Courage.update()
                .passive("{1}、{2}増加する。")
                .variable(1, ARRatio, 20)
                .variable(2, MRRatio, 20)
                .active("{3}間{4}減少し、{5}を得る。")
                .variable(3, Time, 2, 1)
                .variable(4, DamageReductionRatio, 30)
                .variable(5, Tenacity, 30)
                .cd(24, -1);
        Judgment.update()
                .active("Garenが3秒間回転し、その間近くの敵ユニットに0.5秒毎に{1}を与える(最大6hit)。このスキルにはクリティカル判定があり、クリティカル時は追加{2}を与える。回転中はユニットをすり抜ける様になるが、敵Minionをすり抜けている間は移動速度が20%低下する。Minionに与えるダメージは通常の75%。")
                .variable(1, PhysicalDamage, 10, 12.5, ad(0.35))
                .variable(2, PhysicalDamage, 0, 0, ad(0.175))
                .cd(13, -1);
        DemacianJustice.update()
                .active("対象の敵Championに{1}を与える。")
                .variable(1, MagicDamage, 175, 175, amplify(TargetMissingHealth, new Fixed(new double[] {28.6, 33.3, 40})))
                .cd(160, -40)
                .range(400);

        /** Gragas */
        HappyHour.update().passive("スキル使用後に4秒かけて{1}する。").variable(1, RestoreHealth, 0, 0, amplify(Health, 0.02));
        BarrelRoll.update()
                .active("指定地点に樽を転がし、爆発時に{1}の敵ユニットに{2}と3秒間{3}を与える。樽は5秒経つか、スキルを再度使用すると爆発する。")
                .variable(1, Radius, 375)
                .variable(2, MagicDamage, 85, 50, ap(0.9))
                .variable(3, ASReduction, 20, 5)
                .mana(80, 10)
                .cd(12, -1)
                .range(1100);
        DrunkenRage.update()
                .active("{1}する。さらに1秒詠唱後に20秒間{2}と{3}を得る。")
                .variable(1, RestoreMana, 30, 15)
                .variable(2, AD, 30, 10)
                .variable(3, DamageReductionRatio, 10, 2)
                .cd(25);
        BodySlam.update()
                .active("指定方向に突進し、衝突した敵ユニットとその周囲にいる敵ユニットに{1}と2.5秒間{2}を与える。衝突時に突進は止まる。衝突地点に複数の敵ユニットがいた場合、{3}を与える。")
                .variable(1, MagicDamage, 80, 40, ap(0.5), ad(0.66))
                .variable(2, Slow, 35)
                .variable(3, MagicDamage, 50, 25, ap(0.5))
                .mana(75)
                .cd(7)
                .range(650);
        ExplosiveCask.update()
                .active("指定地点に爆発する樽を投げ、{1}内の敵ユニットに{2}を与え、{3}させる。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 200, 125, ap(1))
                .variable(3, Knockback, 800)
                .mana(100, 25)
                .cd(100, -10)
                .range(1050);

        /** Graves */
        TrueGrit.update()
                .passive("戦闘状態になると1秒ごとにスタックが1増加し、スタック数に比例して{1}と{2}を得る。この効果は10回までスタックし、3秒間戦闘を行わないとスタックが0になる。レベル1、7、13で1スタック毎の増加AR,MRが上昇する。")
                .variable(1, AR, new Per6Level(1, 1))
                .variable(2, MR, new Per6Level(1, 1));
        Buckshot.update()
                .active("指定方向扇形の範囲に貫通する弾を3発発射し、当たった敵ユニットに{1}を与える。同一対象に対して複数hitし、2発目以降は本来の35%分の物理DMを与える(3発hitで合計{2})。")
                .variable(1, PhysicalDamage, 60, 35, bounusAD(0.8))
                .variable(2, PhysicalDamage, 102, 59.5, bounusAD(1.36))
                .mana(60, 10)
                .cd(12, -1)
                .range(750);
        Smokescreen.update()
                .active("指定地点にスモーク弾を発射し範囲内の敵ユニットに{1}を与え、4秒間持続する煙幕を残す。煙幕内にいる敵Championに視界低下とス{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.6))
                .variable(2, Slow, 15, 5)
                .mana(70)
                .cd(20, -1)
                .range(700);
        Quickdraw.update()
                .active("指定方向にダッシュし4秒間{1}増加する。このスキルは自身が通常攻撃を行う毎にCDが1秒解消される。対象が建物の場合は無効。")
                .variable(1, ASRatio, 30, 10)
                .mana(50)
                .cd(22, -2)
                .range(425);
        CollateralDamage.update()
                .active("指定方向にMinionを貫通する爆発弾を発射し、hitした敵ユニットに{1}を与える。敵Championにhitするか最大距離飛ぶとターゲット後方に扇形に爆発が広がり、範囲内の敵ユニットに{2}を与える。")
                .variable(1, PhysicalDamage, 250, 100, bounusAD(1.4))
                .variable(2, PhysicalDamage, 140, 110, bounusAD(1.2))
                .mana(100)
                .cd(100, -10)
                .range(1000);

        /** Hecarim */
        Warpath.update()
                .passive("ユニットをすり抜けるようになり、{1}を得る。レベル1、3、6、9、12、15、18で増加割合が上昇する。")
                .variable(1, AD, 0, 0, amplify(BounusMS, new Per2Level(0.1, 0.025)));
        Rampage.update()
                .active("武器を振り回し周囲の敵ユニットに物理DMを与える。このスキルが敵ユニットに命中した場合、Hecarimは短時間の間1スタックを得て、1スタックにつきこのスキルのCDが1秒低減される(最大2スタック)。スタックは6秒間増加がないと0になる。minionに与えるダメージは通常の66%に減少する。")
                .mana(25)
                .cd(4)
                .range(200);
        SpiritOfDread.update()
                .active("4秒間周囲の敵ユニットに毎秒魔法DMを与える。この効果を受けている敵ユニットがダメージを受けた場合、そのダメージの値に応じてHecarimのHPが回復する。")
                .mana(50, 10)
                .cd(14);
        DevastatingCharge.update()
                .active("Hecarimの移動速度が25%増加し、その後3秒かけて移動速度が徐々に増加(最大75%増加)、更にその後1秒間その移動速度を維持する。また次の通常攻撃のダメージはこのスキルを使用してからHecarimが移動した距離に比例したものに変更され、ノックバックが付与される。")
                .mana(60)
                .cd(24, -2);
        OnslaughtOfShadows.update()
                .active("亡霊の騎兵隊を従え指定地点に突撃し、Hecarimと騎兵に触れた敵ユニットに魔法DMを与える。指定した地点に到着すると衝撃波を放ち、周囲の敵ユニットに魔法DMと恐怖状態(1s)を与える。Hecarimが指定した地点に到着しても、騎兵隊は常に最大距離まで突撃する。恐怖状態に陥ったユニットは強制的にHecarimから遠ざかるように移動する。（魅了状態の逆）この時、Hecarimとの距離に比例して移動速度が変化する。")
                .mana(100)
                .cd(140, -20);

        /** Heimerdinger */
        TechmaturgicalRepairBots.update().passive("周囲の味方ユニットとTurretのHPregを増加させる。レベル1、6、11、15でベースの増加HPRegが上昇する。");
        H28GEvolutionTurret.update()
                .active("指定地点にTurret(砲台、近くの敵に自動攻撃・魔法DM)を設置する。使用時にスタックを消費する。設置後6秒間はTurretの攻撃速度が1.5倍になる。25秒毎にスタックが1つ増加し最大2つ(Lv3以降)までスタックされる。スタック増加時間はCD低減の影響を受ける。Turretが塔に与えるダメージは半分。Turret: Lv1/Lv2/Lv3/Lv4/Lv5消費MN: 70/80/90/100/110 + 1スタック CD: 1s Range: 250「Turret」最大HP: 295 + [15 × Lv] 魔法DM: 30/38/46/54/62 (+0.2) Range: 525AR: 30 + [1 × Lv] MR: 80 + [1 × Lv] AS: 1.250 MS: 0 視界範囲: 625【備考】Debuff(CCのみ)を無効化、Heimerdingerが攻撃するor攻撃されている場合、その対象を優先で攻撃Lv2.攻撃したユニットのAR,MRを1低下させる。AR,MR低下は2秒間持続し、50回までスタックする。Lv3.Turretの最大スタック数と設置できる上限が2に増える。Lv4.Turretの最大HP+125。Lv5.50%のスプラッシュダメージが付与される。")
                .mana(70, 10)
                .cd(1)
                .range(525);
        HextechMicroRockets.update().active("視界内にいる最も近い敵ユニット3体に魔法DMを与える。").mana(65, 20).cd(10).range(1000);
        CH1ConcussionGrenade.update()
                .active("指定地点に手榴弾を投げ、破裂した箇所にいる敵ユニットに魔法DMとブラインド効果を与え、真ん中のユニットにはさらにスタン(1.5s)を与える。また指定地点の視界を得る。")
                .mana(80, 10)
                .cd(13, -1)
                .range(925);
        UPGRADE.update()
                .passive("HeimerdingerのスキルのCDが短縮される。CD低減: 10/15/20%")
                .active("設置したTurretのHPが最大まで回復し、10秒間Turretの攻撃にスロー(20/25/30%)が付与され、Hextech Micro-Rocketsの同時攻撃可能数が5体に増加し、CH-1 Concussion Grenadeの弾速が増加(+250)する。")
                .mana(90)
                .cd(120, -15);

        /** Irelia */
        IonianFervor.update()
                .passive("Ireliaの視界内(範囲1200)に敵Championがいる数に応じてCC(Stun, Slow, Taunt, Fear, Snare, Silence, Blind)の効果時間が短くなる。効果の上限は最大3人まで。");
        Bladesurge.update()
                .active("対象の敵ユニットに突進し、物理DMを与える。このスキルで敵を倒したとき、このスキルのCDが解消されると共にManaが35回復する。また、このスキルはOn-Hit Effectsの影響を受ける。")
                .mana(60, 5)
                .cd(14, -2)
                .range(650);
        HitenStyle.update()
                .passive("通常攻撃を行う度にHPが回復する。回復HP: 5/7/9/11/13")
                .active("6秒間通常攻撃にTrueDMが付与され、PassiveのHP回復量が倍になる。")
                .mana(40)
                .cd(15);
        EquilibriumStrike.update()
                .active("対象の敵ユニットに魔法DMを与える。対象の残HP%がIreliaより高かった場合スタンを与え、低かった場合はスロー(60%)を与える。")
                .mana(50, 5)
                .cd(8)
                .range(425);
        TranscendentBlades.update()
                .active("指定方向に貫通する刃を飛ばし、当たった敵ユニットに物理DMを与える。このスキルは15秒の間、4回まで連続して使用できる(但し、一度使用する度に0.5秒のCDが発生する)。2〜4発目はマナコスト無しで使用可能。また、与えたダメージの10%(Championに対しては25%)が回復する。")
                .mana(100)
                .cd(70, -10)
                .range(1000);

        /** Janna */
        Tailwind.update().passive("すべての味方Championの移動速度を3%増加させる。");
        HowlingGale.update()
                .active("指定方向に竜巻を発生させ、触れた敵ユニットに魔法DMと打ち上げ効果を与える。竜巻は設置後に再度スキル使用ですぐに飛ばすことができるが、溜めた時間に比例して魔法DM、射程距離、打ち上げ時間が増加する。")
                .mana(90, 15)
                .cd(14, -1)
                .range(1100);
        Zephyr.update()
                .passive("自身の移動速度が増加しユニットを通過できるようになる。増加MS: 4/7/10/13/16%")
                .active("対象の敵ユニットに魔法DMとスロー(3s)を与える。またこのスキルがCDの間はPassiveの効果が無くなる。")
                .mana(40, 10)
                .cd(12, -1)
                .range(600);
        EyeOfTheStorm.update()
                .active("対象の味方Championか塔に5秒間シールドを付与する。シールドが持続している間は対象の攻撃力を5秒間増加させる。")
                .mana(70, 10)
                .cd(10)
                .range(800);
        Monsoon.update().active("周囲の敵ユニットを吹き飛ばし4秒間詠唱する。詠唱中は周囲の味方ユニットのHPを毎秒回復する。").mana(150, 75).cd(150, -15);

        /** Jarvan IV */
        MartialCadence.update()
                .passive("通常攻撃に{1}(最大400DM)が付与される。同一の対象には6秒に一度しか発動しない。レベル1、7、13で追加物理DMの増加値が上昇する。")
                .variable(1, PhysicalDamage, 0, 0, amplify(TargetCurrentHealth, new Per6Level(6, 2)));
        DragonStrike.update()
                .active("槍を突き出して直線上の敵ユニットに物理DMを与え、3秒間ARを低下させる。また、Demacian Standardの旗にヒットした場合、旗の位置まで突進し、進路上の敵ユニットに打ち上げ(0.75s)を与える。")
                .mana(45, 5)
                .cd(10, -1)
                .range(770);
        GoldenAegis.update()
                .active("自身に5秒間ダメージを軽減するシールドを付与すると同時に、周囲の敵ユニットにスロー(2s)を与える。シールドの耐久値は周囲にいる敵Championの数に比例して増加する。")
                .mana(65)
                .cd(20, -2);
        DemacianStandard.update()
                .passive("Jarvan IVの攻撃速度とARが増加する。増加攻撃速度: 10/13/16/19/22% 増加AR: 10/13/16/19/22")
                .active("指定地点に旗を投げ、範囲内の敵ユニットに魔法DMを与える。旗は8秒間その場に残り視界を確保するとともに、周囲の味方ChampionにPassiveの効果を与える。")
                .mana(55)
                .cd(13)
                .range(830);
        Cataclysm.update()
                .active("対象の敵Championまで跳躍して物理DMを与え、3.5秒間その周囲に通行不可能の円形の地形を作る。再度このスキルを使用すると地形を破壊できる。")
                .mana(100, 25)
                .cd(120, -15)
                .range(650);

        /** Jax */
        RelentlessAssault.update()
                .passive("通常攻撃を行う度にスタックが1増加し、スタック数に比例して攻撃速度増加(最大6スタック)。スタックは2.5秒増加がないと0になる。またレベルで1スタック毎の増加攻撃速度が上昇する。");
        LeapStrike.update().active("対象のユニットまで飛びかかる。対象が敵ユニットの場合、物理DMを与える。").mana(65).cd(10, -1).range(700);
        Empower.update().active("使用後に最初に行った通常攻撃かLeap Strikeに追加魔法DMを付与する。建物には無効。").mana(30).cd(7, -1);
        CounterStrike.update()
                .active("2秒間、Jaxが受けるタワー以外の通常攻撃を回避(無効化)し、AoEダメージを25%低減、さらに効果終了時に周囲の敵ユニットに物理DMとスタン(1s)を与える。スキルを使用してから1秒経つと再使用できるようになり、任意に効果を終了できる。通常攻撃を回避する度にこのスキルのダメージが20%ずつ増加する(上限は100%、最大で2倍ダメージ)。")
                .mana(70, 5)
                .cd(18, -2);
        GrandmastersMight.update()
                .passive("通常攻撃3回目ごとに追加で魔法DMを与える。建物には無効。追加魔法DM: 100/160/220 (+0.7)")
                .active("8秒間JaxのARとMRが増加する。")
                .mana(100)
                .cd(80);

        /** Jayce */
        HextechCapacitor.update().passive("Transformを使用すると1.25秒の間移動速度が40だけ増加し、ユニットをすり抜けるようになる。");
        ToTheSkies.update()
                .passive("kies!(Mercury Hammer)")
                .active("対象の敵ユニットに飛びかかり、対象と周囲の敵ユニットに物理DMとスロー(2s)を与える。物理DM: 20/65/110/155/200 + [増加攻撃力 × 100%]スロー: 30/35/40/45/50%消費MN: 40/45/50/55/60 CD: 16/14/12/10/8s Range: 600Shock Blast(Mercury Cannon)Active:指定方向に雷のオーブを飛ばし、敵ユニットに命中するか一定距離で爆発し、周囲の敵ユニット物理DMを与える。オーブがAcceleration Gateによって生成されたゲートを通過した場合、弾速、射程距離、爆発範囲、与えるDMが各40%増加する。")
                .mana(55, 5)
                .cd(8)
                .range(1050, 420);
        LightningField.update()
                .passive("g Field(Mercury Hammer)Passive:通常攻撃ごとにマナを回復する。回復MN: 6/8/10/12/14")
                .active("4秒間雷のオーラを身にまとい、周囲の敵ユニットに毎秒魔法DMを与える。毎秒魔法DM: 25/42.5/60/77.5/95 (+0.25) 効果範囲: 285消費MN: 40 CD: 10sHyper Charge(Mercury Cannon)Active:Jayceの攻撃速度が最大まで上昇する。3回通常攻撃を行うと効果が解消される。また効果中は通常攻撃で与えるダメージが変化する。")
                .mana(40)
                .cd(14, -2);
        ThunderingBlow.update()
                .passive("ng Blow(Mercury Hammer)")
                .active("対象の敵ユニットに最大HPに比例した魔法DMと短い距離のノックバックを与える。魔法DM: [増加攻撃力 × 100%] + [対象の最大HP × 8/11/14/17/20%](Minionに対しては200/300/400/500/600DMが上限) ノックバック距離:消費MN: 40/50/60/70/80 CD: 14/13/12/11/10s Range: 240Acceleration Gate(Mercury Cannon)Active:4秒間持続するゲート（通りぬけ可能）を生成し、触れた味方ユニットは移動速度が3秒間上昇する。移動速度は3秒かけて元に戻る。")
                .mana(50)
                .cd(14, -1)
                .range(650);
        TransformMercuryCannon.update()
                .passive("m: Mercury Cannon(Mercury Hammer)")
                .active("Jayceの射程が500(ranged)になる。また、次の通常攻撃に敵のARとMRを低下する効果(5s)を付与する。低下AR/MR: 10/15/20/25%消費MN: 無し CD: 6sTransform: Mercury Hammer(Mercury Cannon)Active:Jayceの射程が125(melee)になり、その間はARとMRが増加する。また、次の通常攻撃に追加魔法DMを付与する。")
                .cd(6);

        /** Karma */
        InnerFlame.update().passive("HPの割合に反比例してAPが上昇する。レベル1、3、6、9、12、15で最大値が上昇する。");
        HeavenlyWave.update()
                .active("指定方向扇形60°の範囲内の敵ユニットに魔法DMを与える。Mantra Bonus:自身と効果範囲内の味方ユニットのHPを回復する。回復量は対象のHP残量によって変化する。")
                .mana(70, 5)
                .cd(6);
        SpiritBond.update()
                .active("対象のユニットと自身を繋ぐビームを発生させる。ビームは5秒間持続し、自身及び味方ユニットにはMS増加、敵ユニットにはMS低下を与える。ビームに触れたChampion(敵味方問わず)にも同様の効果を与え、それが敵ユニットだった場合は更に魔法DMを与える。ビームを繋ぐ対象がステルス状態または距離1000まで離れた場合、効果が途切れる。Mantra Bonus:MS増加/MS低下の効果が2倍になる。")
                .mana(65, 10)
                .cd(15, -1)
                .range(800);
        SoulShield.update()
                .active("対象の味方ユニットに5秒間持続するシールドを付与する。Mantra Bonus:味方ユニットにシールドを付与した際、その味方ユニットの周囲にいる敵ユニットに魔法DMを与える。")
                .mana(80, 10)
                .cd(10)
                .range(650);
        Mantra.update()
                .active("次に使用するスキルにMantra Bonusを付与する。Lv1から使用でき、スキルポイントを割り振ることはできない。30/25/20秒毎にスタック数が1つ増加し最大で2つまでスタックされる。スタック増加時間はCD低減の影響を受ける。レベル1、7、13でスタック増加時間が短縮される。")
                .cd(0.25);

        /** Karthus */
        DeathDefied.update().passive("死亡後7秒間スキルが使用可能。この状態ではスキルコストがなくなる。");
        LayWaste.update()
                .active("指定地点を0.5秒後に爆発させ範囲内の敵ユニットに魔法DMを与える。対象が1体の場合はダメージが2倍になる。また、指定地点の視界を得る。")
                .mana(20, 6)
                .cd(1)
                .range(875);
        WallOfPain.update()
                .active("指定地点に壁（通りぬけ可能）を5秒間生成し、触れた敵ユニットにMR低下(15%,5s)とスロー(5s)を与える。スローの効果は5秒かけて元に戻る。また、指定地点の視界を得る。")
                .mana(100)
                .cd(18)
                .range(1000);
        Defile.update()
                .passive("ff:敵ユニットを倒すとMNが回復する。回復MN: 20/27/34/41/48Toggle On:周囲の敵ユニットに毎秒魔法DMを与える。")
                .mana(30, 12)
                .cd(0.5);
        Requiem.update().active("3秒詠唱後にすべての敵Championに魔法DMを与える。").mana(150, 25).cd(200, -20);

        /** Kassadin */
        VoidStone.update().passive("自身が受ける魔法DMを15%軽減し、4秒間軽減した分のダメージを攻撃速度(%)に加算する。");
        NullSphere.update().active("対象の敵ユニットに魔法DMとサイレンスを与える。").mana(70, 10).cd(9).range(650);
        NetherBlade.update()
                .passive("通常攻撃ごとにマナを回復する。対象がChampionの場合は回復量が3倍になる。回復MN: 8/11/14/17/20")
                .active("5秒間、通常攻撃に追加魔法DMが付与される。建物には無効。")
                .mana(25)
                .cd(12);
        ForcePulse.update()
                .active("指定方向扇形80°の範囲内の敵ユニットに魔法DMとスロー(3s)を与える。近くのChampion（敵味方自分問わず）がスキルを使用するとスタックが増え、6スタックまで溜まると使用可能。スキル使用時にスタックは0になる。")
                .mana(80)
                .cd(6);
        Riftwalk.update()
                .active("指定地点にテレポートし、テレポート先の周囲の敵ユニットに魔法DMを与える。スキル使用時にスタックが増加し、1スタックごとに消費MNと魔法DMが増加していく。（最大10スタック）スタックは8秒間増加がないと0になる。")
                .mana(100)
                .cd(7, -1)
                .range(700);

        /** Katarina */
        Voracity.update().passive("敵Championキル/アシスト時に、すべてのスキルのCDが15秒解消される。");
        BouncingBlade.update()
                .active("対象の敵ユニットにナイフを飛ばし魔法DMとDebuff(4s)を与える。ナイフは近くの敵ユニット（範囲400）に4回まで跳ね返り、その度にダメージとDebuffを与える。ナイフが与えるダメージは跳ね返る度に10%低下する。Debuffが付与された敵ユニットにKatarinaが通常攻撃またはスキルでダメージを与えると、付与されたDebuffを消費して追加魔法DMを与える。")
                .cd(10, -0.5)
                .range(675);
        SinisterSteel.update()
                .active("周囲にいる敵ユニットに魔法DMを与える。このスキルが敵Championに命中した場合、Katarinaの移動速度が1秒間増加する。")
                .cd(4)
                .range(375);
        Shunpo.update()
                .active("対象のユニットの後方までワープし、それが敵ユニットの場合は魔法DMを与える。またこのスキル使用後、Katarinaが受けるダメージが15%低減される。この効果は1.5秒間持続する。")
                .cd(12, -1.5)
                .range(700);
        DeathLotus.update()
                .active("Katarinaが最大2秒間回転する。その間は0.2秒毎に周囲にいる最も近い敵Champion3体にナイフを連続で飛ばし、都度魔法DMとHP回復量-50%(3s)を与える。※ チャネリングスキル。チャネリングが中断されるか効果時間が過ぎるまで効果が持続する。")
                .cd(60, -5);

        /** Kayle */
        HolyFervor.update()
                .passive("敵Championに通常攻撃を行う度に、ArmorとMagic resistを3%低下させるDebuffを付与する。この効果は5秒間持続し、5回までスタックする。");
        Reckoning.update()
                .active("対象の敵ユニットに魔法DMとスロー(35%,4s)を与える。このスキルのスローがかかった敵ユニットに対しては、Kayleが対象のユニットに与えるダメージが増加する。")
                .mana(70, 5)
                .cd(8)
                .range(650);
        DivineBlessing.update().active("対象の味方ChampionのHPを回復し、3秒間移動速度を増加させる。").mana(60, 10).cd(15).range(1000);
        RighteousFury.update()
                .active("10秒間Kayleの通常攻撃の射程が525に伸びる(Ranged化)。更に通常攻撃に追加魔法DMが付与され、スプラッシュ効果が付く。塔を攻撃する時はスプラッシュ効果は発生しない。")
                .mana(45)
                .cd(16);
        Intervention.update().active("対象の味方Championを無敵(ダメージ無効)にする。").mana(100, -25).cd(90, -15).range(1200);

        /** Kennen */
        MarkOftheStorm.update()
                .passive("スキルヒット時対象に雷スタックを追加する。スタックが3つ溜まると対象をスタン(1s)させ、Kennenの「気」が25回復する。スタックは8秒間増加がないと0になる。同一の敵Championを7秒以内に2度スタンさせると、2度目のスタン効果時間は0.5sに低下する。");
        ThunderingShuriken.update().active("指定方向に手裏剣を飛ばし、当たった敵ユニットに魔法DMと雷スタックを与える。").cd(8, -1).range(900);
        ElectricalSurge.update()
                .passive("回毎の通常攻撃時に追加魔法DMと雷スタックを与える効果を追加する。追加魔法DM: [攻撃力 × 40/50/60/70/80%]")
                .active("近くの雷スタックの付与されている敵ユニットに魔法DMと雷スタックを与える。")
                .cd(14, -2)
                .range(800);
        LightningRush.update()
                .active("2.5秒間移動速度が増加し、ユニットを通り抜けられるようになる。この間は通常攻撃が不可能になり、Kennenに触れた敵ユニットに魔法DMと雷スタックを与え、一度だけKennenの「気」が40回復する。また、このスキルを使用すると4秒間AR,MRが上昇する。Minionに与えるダメージは半分。")
                .cd(10, -1);
        SlicingMaelstrom.update()
                .active("Kennenの周囲に嵐を発生させ、0.5/0.4/0.33秒毎に範囲内にいる敵Champion一人をランダムに雷を落とし魔法DMと雷スタックを与える。同一の対象には3回までしかヒットしない。また、範囲内に複数の対象がいる場合、同一の対象に連続してはヒットしない。雷スタックはヒットする毎に蓄積する。")
                .cd(120);

        /** Kha'Zix */
        UnseenThreat.update()
                .passive("自身が敵チームの視界から消えた時に発動する。次の敵Championに対する通常攻撃かEvolved Void Spikeに追加魔法DMとスロー(25%,2s)を付与する。この効果は敵チームの視界に現れても効果が消費されるまでは失われない。");
        TasteTheirFear.update()
                .passive("敵チームの中で孤立している敵ユニットにマークを付与する。効果範囲: ???")
                .active("対象の敵ユニットに物理DMを与える。マークが付与されている敵ユニットのマークの範囲内に他の敵ユニットがいない場合、DMが増加する。物理DM: 70/100/130/160/190 + [増加攻撃力 × 150%]物理DM(マーク付): 100/145/190/235/280 + [増加攻撃力 × 200%]Evolved Enlarged Claws孤立した敵ユニットに与えるDMが増加し、更にこのスキルの射程と通常攻撃の射程が50だけ増加する。")
                .mana(25)
                .cd(3.5)
                .range(325, 50);
        VoidSpike.update()
                .active("指定方向に敵ユニットに命中すると爆発する針を発射し、周囲の敵ユニットに物理DMを与える。自身が爆発範囲内にいる場合は更に自身のHPを回復する。物理DM: 75/115/155/195/235 + [増加攻撃力 × 90%] 効果範囲: ???回復HP: 40/70/100/130/160 (+0.5)Evolved Spike Racks指定方向に対して扇形になるような3方向に針を発射するようになり、また爆発にUnseen Threatの追加魔法DMとスローを付与する。")
                .mana(60, 10)
                .cd(8)
                .range(1000);
        Leap.update()
                .active("指定地点にジャンプし、周囲の敵ユニットに物理DMを与える。物理DM: 65/100/135/170/205 + [増加攻撃力 × 80%] 効果範囲: ???Evolved Wings射程が400増加し、またkillやassistを取った場合にこのスキルのCDが解消されるようになる。")
                .mana(50)
                .cd(22, -2)
                .range(600, 400);
        VoidAssault.update()
                .passive("このスキルを取得、またはランクが上がる毎に、いずれかのスキルを選んでEvolve(進化)させることができる。")
                .active("使用後1秒間ステルス状態になり、移動速度が40%増加する。この際にUnseen Threatの効果が発動する。また使用後10秒以内であれば、消費mana無しでもう一度だけこのスキルを使用することができる。Evolved Active Camouflage10秒以内に再度使用可能な回数が2回に増加し、またステルス状態の間に受けるDMを40%軽減するようになる。")
                .mana(100)
                .cd(3);

        /** Kog'Maw */
        IcathianSurprise.update()
                .passive("死亡すると4秒後に自爆して周囲の敵ユニットに{1}を与える。自爆するまでの間は徐々に移動速度が増加する(最大時40%増加)。")
                .variable(1, TrueDamage, 100, 0, amplify(Lv, 25));
        CausticSpittle.update()
                .passive("{1}を得る。")
                .variable(1, ASRatio, 10, 5)
                .active("対象の敵ユニットに{2}を与え、4秒間{3}と{4}を与える。")
                .variable(2, MagicDamage, 60, 50, ap(0.7))
                .variable(3, ARReduction, 5, 5)
                .variable(4, MRReduction, 5, 5)
                .mana(60)
                .cd(8)
                .range(625);
        BioArcaneBarrage.update()
                .active("8秒間通常攻撃の射程が{1}増加し、通常攻撃時に{2}を追加で与える。")
                .variable(1, Range, 130, 20)
                .variable(2, MagicDamage, 0, 0, amplify(TargetHealth, 2, 1, ap(0.01)))
                .mana(50)
                .cd(17)
                .range(130, 20);
        VoidOoze.update()
                .active("指定方向に貫通する弾を発射し、当たった敵ユニットに{1}を与える。弾の通過点に4秒間持続する液体が残り、その上にいる敵ユニットに{2}を与える。")
                .variable(1, MagicDamage, 60, 50, ap(0.7))
                .variable(2, Slow, 20, 8)
                .mana(80, 10)
                .cd(12)
                .range(1400);
        LivingArtillery.update()
                .active("指定地点を砲撃し、{1}の敵ユニットに{2}を敵Championには{3}を与え、4秒間そのユニットの視界を得る。このスキルを使うたびにスタックが増加し、1スタックにつきこのスキルの消費マナが40ずつ増加していく。スタックは6秒間持続する。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 80, 40, ap(0.3), bounusAD(0.5))
                .variable(3, MagicDamage, 180, 90, ap(0.3), bounusAD(0.5))
                .mana(40)
                .cd(2, -0.5)
                .range(1400, 300);

        /** LeBlanc */
        MirrorImage.update().passive("HPが40%以下になったとき0.5秒間ステルス状態になり、自分の分身を作り出す。分身は8秒間持続し、分身が敵にダメージを与えることはできない。").cd(60);
        SigilOfSilence.update()
                .active("対象の敵ユニットに魔法DMと3.5秒間持続するマークを付与する。マークが付いている間に再度スキルでダメージを与えると、マークを消費して追加魔法DMとサイレンス(2s)を付与する。")
                .mana(70, 5)
                .cd(6)
                .range(700);
        Distortion.update()
                .active("指定地点まで高速で移動し、移動先の周囲にいる敵ユニットに魔法DMを与える。3秒間以内にもう一度このスキルを使用すると元居た地点に戻る。")
                .mana(80, 5)
                .cd(18, -2)
                .range(600);
        EtherealChains.update()
                .active("指定方向に鎖を放ち、当たった敵ユニットに魔法DMとスロー(25%,2s)を与え対象と鎖で繋がれる。2秒間対象が鎖の範囲内(範囲1000)に留まっていた場合、対象に追加魔法DMとSnareを与える。")
                .mana(80)
                .cd(10)
                .range(950);
        Mimic.update()
                .active("直前に使ったスキルを、威力を増した状態で再使用する。Distortionとして使用した場合、それぞれDistortionとDistortion:Mimicを使用した地点に戻る事ができる。")
                .mana(100, -50)
                .cd(40, -8);

        /** Lee Sin */
        Flurry.update().passive("スキルを使用すると攻撃速度が40%増加し通常攻撃の度に「気」が15回復する。この効果は3秒経つか2回通常攻撃を行うと解消される。");
        SonicWave.update()
                .active("指定方向に気を飛ばし当たった敵ユニットに物理DMを与える。このスキルが敵ユニットに当たった場合、3秒間Resonating Strikeが使用可能になる。また3秒間対象の視界を得る。物理DM: 50/80/110/140/170 + [増加攻撃力 × 90%]消費「気」: 50 CD: 11/10/9/8/7s Range: 975Resonating Strike:Sonic Waveが当たった敵ユニットにダッシュし、物理DMを与える。対象が受けているダメージに比例してダメージが増加する。")
                .cd(11, -1)
                .range(1100);
        Safeguard.update()
                .active("対象の味方ユニットまで移動し、対象と自身にダメージを軽減するシールドを付与する。自身を対象とした場合はシールドのみが付与される。このスキル使用後、3秒間Iron Willが使用可能になる。シールド耐久値: 40/80/120/160/200 (+0.8)消費「気」: 50 CD: 9s Range: 700Iron Will:5秒間Life StealとSpell Vampが増加する。")
                .cd(9)
                .range(700);
        Tempest.update()
                .active("周囲の敵ユニットに魔法DMを与え、4秒間そのユニットの視界を得る。このスキルが敵ユニットに当たった場合、3秒間Crippleが使用可能になる。魔法DM: 60/95/130/165/200 + [増加攻撃力 × 100%] 効果範囲: 450消費「気」: 50 CD: 10sCripple:Tempestが当たった敵ユニットにスロー、攻撃速度低下(4s)を与える。これらの速度低下は時間と共に戻っていく。")
                .cd(10);
        DragonsRage.update()
                .active("対象の敵Championに物理DMを与え、ノックバックさせる。ノックバックした対象に触れた敵ユニットにも物理DMを与え、打ち上げる。")
                .cd(90, -15)
                .range(375);

        /** Leona */
        Sunlight.update()
                .passive("スキルでダメージを与えた敵ユニットに、3.5秒間持続するDebuffを付与する。この敵ユニットに対してLeona以外の味方Championがダメージを与えると、付与されたDebuffを消費して追加魔法DMを与える。追加魔法DMは2レベル毎に増加する。");
        ShieldOfDaybreak.update().active("次の通常攻撃に追加魔法DMとスタン(1.25s)が付与される。").mana(45, 5).cd(11, -1);
        Eclipse.update()
                .active("3秒間LeonaのARとMRが増加し、効果終了時に周囲の敵ユニットに魔法DMを与える。魔法DMが敵ユニットに命中した場合、ARとMR増加の効果時間が3秒延長される。")
                .mana(60)
                .cd(14);
        ZenithBlade.update()
                .active("指定方向に貫通するエネルギーを飛ばし当たった敵ユニットに魔法DMを与える。このスキルが敵Championに命中した場合、その敵Championの元までLeonaが移動する。また移動中は対象の敵ChampionにSnareを与える。複数の敵Championに命中した場合は最後に命中した敵Championの元に移動する。")
                .mana(60)
                .cd(13, -1)
                .range(875);
        SolarFlare.update()
                .active("わずかな間をおいて、指定地点を中心とした一定範囲内の敵ユニットに魔法DMとスロー(80%,1.5s)を与える。中心部のユニットには、スローの代わりにスタン(1.5s)を与える。")
                .mana(100, 50)
                .cd(90, -15)
                .range(1200);

        /** Lulu */
        PixFaerieCompanion.update()
                .passive("Pixという妖精がお供になる。Pixが付いている味方Championが通常攻撃を行った場合、Pixは同一の敵ユニットの方向に3発の弾を放つ。この弾は敵ユニットを追尾するが、弾の進行方向上にいる敵ユニットにも当たる。建物を攻撃した場合はPixは弾を撃たない。");
        Glitterlance.update()
                .active("指定方向に貫通するエネルギーを発射し当たった敵ユニットに魔法DMとスロー(80%)を与える。スローの効果は時間と共に元に戻る。またPixがいる位置からもこのスキルが発射される(Pixが放つ方向はPixから見て指定した地点)。同一の対象に2回ヒットはしない。")
                .mana(40, 10)
                .cd(7)
                .range(925);
        Whimsy.update()
                .active("対象の味方Championに使用した場合、5秒間対象の味方Championの移動速度とAPを増加させる。敵Championに使用した場合、一定時間無力な動物に変化させ(Polymorph)、その間通常攻撃とスキルを封じ、基本移動速度を60下げる。")
                .mana(65, 5)
                .cd(18, -1.5)
                .range(650);
        HelpPix.update()
                .active("対象の味方ユニットに使用した場合、6秒間対象の味方ユニットにPixを付けると同時にシールドを付与する。敵ユニットに使用した場合、Pixが敵ユニットに付くと同時に魔法DMを与え、6秒間その敵ユニットの視界を得る。")
                .mana(60, 10)
                .cd(10)
                .range(650);
        WildGrowth.update()
                .active("対象の味方Championを7秒間巨大化させ、同時に対象の近くにいる敵ユニットに打ち上げ(1.5s)を与える。巨大化した味方Championは最大HPが増加し、周囲の敵ユニットに継続的にスローを与える。スローの効果は範囲内から出ても1秒間持続する。")
                .mana(150)
                .cd(110, -15)
                .range(900);

        /** Lux */
        Illumination.update()
                .passive("スキルでダメージを与えた敵ユニットに6秒間持続するDebuffを付与する。この敵ユニットに対して通常攻撃かFinal Sparkでダメージを与えると、付与されたDebuffを消費して追加魔法DMを与える。");
        LightBinding.update()
                .active("指定方向に光の玉を飛ばし、当たった敵ユニットに魔法DMとSnare(2s)を与える。光の玉は一度だけ敵ユニットを貫通し、2体目のユニットには半分の魔法DMとSnare(1s)を与える。")
                .mana(50, 10)
                .cd(15, -1)
                .range(1175);
        PrismaticBarrier.update()
                .active("指定方向に杖を投げ、自身と当たった味方Championにダメージを軽減するシールドを付与する。行きと帰りそれぞれに判定があり、シールドは3秒間持続する。")
                .mana(60)
                .cd(14, -1)
                .range(1000);
        LucentSingularity.update()
                .active("指定地点に光の玉を設置し、範囲内の敵ユニットにスローを与える。光の玉は5秒経つか再度スキルを使用する事で爆発し、範囲内の敵ユニットに魔法DMを与える。光の玉は視界を確保する。")
                .mana(70, 15)
                .cd(10)
                .range(1100);
        FinalSpark.update()
                .active("1秒詠唱後、指定方向の直線状にいるすべての敵ユニットに魔法DMを与える。また効果範囲内の視界を確保する。Hitした敵がIlluminationのデバフを受けていた場合はその分の追加ダメージを与えたうえ、新たにIlluminationのデバフを与える。")
                .mana(100)
                .cd(80, -20)
                .range(3000);

        /** Malphite */
        GraniteShield.update().passive("最大HPの10%分ダメージを軽減するシールドを纏う。10秒間ダメージを受けないとシールドが修復される。");
        SeismicShard.update()
                .active("対象の敵ユニットに魔法DMとスロー(4s)を与える。また、このスキルで減少させた移動速度を自身の移動速度に加算する。移動速度増加は4秒間持続する。")
                .mana(70, 5)
                .cd(8)
                .range(625);
        BrutalStrikes.update()
                .passive("通常攻撃時に対象の周囲にいる敵ユニットにもダメージを与える。建物を攻撃する際にはスプラッシュ効果は発生しない。スプラッシュ物理DM: [攻撃力 × 30/38/46/54/62%] 効果範囲: 200")
                .active("6秒間攻撃力とARが増加する。")
                .mana(50, 5)
                .cd(14);
        GroundSlam.update().active("周囲の敵ユニットに魔法DMとAS低下(3s)を与える。").mana(50, 5).cd(7);
        UnstoppableForce.update()
                .active("指定地点に突撃し範囲内の敵ユニットに魔法DMを与えると共に打ち上げ(1s)後、スタン(0.5s)を与える。")
                .mana(100)
                .cd(130, -15)
                .range(1000);

        /** Malzahar */
        SummonVoidling.update()
                .passive("スキルを4回使う度にVoidlingを召喚する。Voidlingは21秒間持続し、また召喚から7秒後にDMとARが1.5倍、14秒後にASが2倍に増加する。「Voidling」最大HP: 200 + [50 × Lv]通常攻撃DM: 20 + [5 × Lv] + [増加攻撃力 × 100%]AR: 30 MR: 50 AS: 0.831 MS: 451【備考】任意の操作不可。攻撃する優先順位は、Ultを掛けた相手、Malefic Visionsを掛けた相手、Malzaharがターゲットしている相手の順。");
        CallOftheVoid.update()
                .active("指定した地点の左右から挟み込む様に2本の波動が出現し、当たった敵ユニットに魔法DMとサイレンスを与える。また、指定した場所の視界を得る。")
                .mana(80, 10)
                .cd(9)
                .range(900);
        NullZone.update()
                .active("指定範囲に5秒間持続するダメージゾーンを発生させ、上にいる敵ユニットに毎秒魔法DM(対象の最大HP比例)を与える。")
                .mana(90, 10)
                .cd(14)
                .range(800);
        MaleficVisions.update()
                .active("対象の敵ユニットに4秒かけて魔法DMを与える。効果中に敵ユニットが死亡した場合、MalzaharのMNが回復し、近くの敵ユニットに効果が移り変わる。移る度に4秒のタイマーはリセットされる。")
                .mana(60, 15)
                .cd(15, -2)
                .range(650);
        NetherGrasp.update()
                .active("対象の敵Championに2.5秒かけて魔法DMを与える。チャネリングが続いている間は対象にサプレッション(最大2.5s)を与え続ける。※ チャネリングスキル。チャネリングが中断されるか効果時間が過ぎるまで効果が持続する。魔法DM: 250/400/550 (+1.3)※表記魔法DMは2.5秒間当て続けた場合の合計ダメージ。0.5秒毎に計5回のダメージ判定。")
                .mana(150)
                .cd(120, -20)
                .range(700);

        /** Maokai */
        SapMagic.update()
                .passive("近くのChampion（敵味方自分問わず）がスキルを使用するとスタックが増え、5スタックまで溜まった状態で通常攻撃を行うと自身の最大HPの7%分が回復する。このスキル発動時にスタックは0になる。建物を攻撃した場合は発動しない。");
        ArcaneSmash.update()
                .active("周囲の敵ユニットと指定方向の敵ユニットに魔法DMとスロー(2s)を与える。周囲の敵ユニットには更に打ち上げ（ノックバック）を与える。")
                .mana(55)
                .cd(6)
                .range(700);
        TwistedAdvance.update().active("対象の敵ユニットまで高速移動し魔法DMとSnareを与える。").mana(75, 5).cd(13).range(650);
        SaplingToss.update()
                .active("指定地点に苗木を投げ、範囲内の敵ユニットに魔法DMを与える。苗木は最大35秒間その場で待機し、敵ユニットが近付くと相手に向かって移動を開始する、敵に接触するか数秒経つと爆発して周囲に魔法DMを与える。")
                .mana(70, 10)
                .cd(12)
                .range(1100);
        VengefulMaelstrom.update()
                .passive("n:指定した範囲にシールドを展開し、範囲内の味方Championが受けるダメージを20%低減させる(タワーからの攻撃以外）。解除すると範囲内の敵ユニットに魔法DMを与える。低減したダメージ量に比例して与えるダメージが増加する。")
                .mana(75)
                .cd(40, -10)
                .range(575);

        /** Master Yi */
        DoubleStrike.update().passive("通常攻撃7回毎に2回分ダメージを与える。対象が建物の場合も有効。");
        AlphaStrike.update()
                .active("対象の敵ユニットと近くの敵ユニット3体(範囲600)をランダムに対象とし魔法DMを与え、対象の近くにワープする。minionの場合は50%の確率で追加魔法DMを与える。")
                .mana(60, 10)
                .cd(18, -2)
                .range(600);
        Meditate.update()
                .active("5秒間詠唱を行い、その間自身のHPを回復する。詠唱中はARとMRが増加する。※ チャネリングスキル。チャネリングが中断されるか効果時間が過ぎるまで効果が持続する。回復HP: 200/350/500/650/800 (+2.0)※表記回復HPは5秒間詠唱した時の回復量。毎秒 40/70/100/130/160 (+0.4)ずつ回復していく。")
                .mana(50, 15)
                .cd(35);
        WujuStyle.update()
                .passive("Master Yiの攻撃力が増加する。増加AD: 15/20/25/30/35")
                .active("10秒間Master Yiの攻撃力が増加する。CDが解消されるまでPassiveの増加ダメージがなくなる。")
                .mana(40)
                .cd(25, -2);
        Highlander.update()
                .active("移動速度と攻撃速度が増加し、スローの効果を受けなくなる。効果中に敵Championを倒すとMaster YiのすべてのスキルのCDが解消される。")
                .mana(100)
                .cd(75);

        /** Miss Fortune */
        Strut.update().passive("5秒間ダメージを受けないと移動速度が25上昇する。以後、毎秒移動速度が9ずつ上昇し、5秒後に移動速度上昇値は上限の70に到達する。ダメージを受けると解除される。");
        DoubleUp.update()
                .active("対象の敵ユニットに弾丸を飛ばし物理DMを与える。弾は一度だけ跳ね返り、背後にいる敵ユニット一体(範囲500)を対象とし120%の物理DMを与える。このスキルはOn-Hit Effects(Impure Shots含む)の影響を受ける。")
                .mana(70, 5)
                .cd(9, -1)
                .range(625);
        ImpureShots.update()
                .passive("通常攻撃に追加魔法DMを与え、対象にスタックを付与する。1スタックにつき追加魔法DMが倍増していく。スタックは最大4スタック(最大4倍ダメージ)で5秒間持続する。追加魔法DM(1スタック): 6/8/10/12/14 (+0.05)")
                .active("6秒間自身の攻撃速度が増加し、通常攻撃にHP回復量-50%(3s)を付加する。")
                .mana(50)
                .cd(16);
        MakeItRain.update()
                .active("地点を指定した0.5秒後に2秒間銃弾の雨を降らし、範囲内の敵ユニットに魔法DMとスロー(1s)を与える。魔法DM: 90/145/200/255/310 (+0.8) 効果範囲: 400スロー: 20/28/36/44/52%※表記魔法DMは2秒間当て続けた場合の合計ダメージ。")
                .mana(80)
                .cd(15)
                .range(800);
        BulletTime.update()
                .active("指定方向扇形の範囲に2秒間、弾幕砲火を浴びせて範囲内の敵ユニットに物理DMを与える。弾は0.25秒毎に一発発射され、同一の対象に8回までヒットする。※ チャネリングスキル。チャネリングが中断されるか効果時間が過ぎるまで効果が持続する。")
                .mana(100)
                .cd(120, -10)
                .range(1400);

        /** Mordekaiser */
        IronMan.update()
                .passive("スキルで与えたダメージの17.5%(Championに対しては35%)をシールドに変換する。受けたダメージはHPより先にシールドがくらってくれる。シールドは最大90 + (30 × Lv)まで溜まり、1秒毎に3%ずつ低下していく。");
        MaceOfSpades.update()
                .active("次に行う通常攻撃が魔法DMになり、更に近くの敵ユニット3体(範囲600)にもダメージを与える。対象が1体だけの場合は与えるダメージが65%上昇する。")
                .cd(8, -1);
        CreepingDeath.update()
                .active("対象の味方ユニットに6秒間持続するシールドを付与する。付与されたユニットはAR,MRが増加し、近くの敵ユニットに毎秒魔法DMを与える。")
                .cd(20, -2)
                .range(750);
        SiphonOfDestruction.update().active("指定方向扇形の範囲内の敵ユニットに魔法DMを与える。").cd(6).range(700);
        ChildrenOftheGrave.update()
                .active("対象の敵Championに魔法DMを与え、その後10秒間、毎秒魔法DMを与える。効果中に対象が死ぬとThe Spiritを生成、30秒間従わせる。（RまたはALT押しながらクリックで任意の操作可能）また、このスキルで与えたダメージの100%が回復する。魔法DM: 対象の最大HPの12/14.5/17% (+0.02)%毎秒魔法DM: 対象の最大HPの1.2/1.45/1.7% (+0.002)%消費HP: 無し CD: 120/105/90s Range: 850「The Spirit」AD: 元になったChampのAD + MordekaiserのADの75%AP: 元になったChampのAP + MordekaiserのAPの75%HP: 元になったChampのHP + MordekaiserのHPの15%行動範囲: 1125【備考】敵Championの一部アイテムとスキルの効果を引き継ぐ。また、The Spiritを従えている間、Mordekaiserは元になったChampのADとAPの20％を得る。")
                .cd(120, -15)
                .range(850);

        /** Morgana */
        SoulSiphon.update().passive("{1}を得る。レベル1、7、13で増加値が上昇する。").variable(1, SV, new Per6Level(10, 5));
        DarkBinding.update()
                .active("指定方向に魔法弾を飛ばし、当たった敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 80, 55, ap(0.9))
                .variable(2, Snare, 2, 0.25)
                .mana(60, 15)
                .cd(11)
                .range(1300);
        TormentedSoil.update()
                .active("指定地点に5秒間持続する黒い沼({3})を発生させ、上にいる敵ユニットに毎秒{1}と{2}を与える。MR低下は2秒間持続し、5回までスタックする。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, MRReduction, 4, 1)
                .variable(3, Radius, 350)
                .mana(70, 15)
                .cd(10)
                .range(900);
        BlackShield.update()
                .active("対象の味方Championに5秒間持続する{1}を発生させ、すべてのCC(Stun, Slow, Taunt, Fear, Snare, 打ち上げ、ノックバック, Silence, Blind, Suppression)を防御する。")
                .variable(1, MagicShield, 95, 65, ap(0.7))
                .mana(50)
                .cd(23, -2)
                .range(750);
        SoulShackles.update()
                .active("周囲の敵Championに{1}と３秒間{2}を与え対象と糸で繋がれる。3秒間対象が糸の範囲内({3})に留まっていた場合、対象に{1}とスタン{4}を与える。")
                .variable(1, MagicDamage, 175, 75, ap(0.7))
                .variable(2, Slow, 20)
                .variable(3, Radius, 1000)
                .variable(4, Stun, 1.5)
                .mana(100, 50)
                .cd(120, -10)
                .range(600);

        /** Nami */
        SurgingTides.update()
                .passive("スキルが味方Championに命中した際に、対象は1.5秒間{1}増加する。レベル1/7/13で増加量が上昇する。")
                .variable(1, MS, new Per6Level(40, 5))
                .conditional(1);
        AquaPrison.update()
                .active("指定地点に泡を投げ、範囲内の敵ユニットに{1}と{2}を与える。")
                .variable(1, MagicDamage, 75, 55, ap(0.65))
                .variable(2, Stun, 1.25)
                .mana(60)
                .cd(14, -1)
                .range(875);
        EbbandFlow.update()
                .active("対象の味方Championまたは敵Championに、Championにのみ3回まで跳ね返る({3})水流を発射する。水流が味方Championに命中した場合は{1}し、敵Championに命中した場合は{2}を与える。水流は同一のChampionには一度しか跳ね返らず、味方Championに命中した場合は一番近くの敵Championに、敵Championに命中した場合は一番近くの味方Championに跳ね返る。")
                .variable(1, RestoreHealth, 65, 30, ap(0.3))
                .variable(2, MagicDamage, 70, 40, ap(0.5))
                .variable(3, Radius, 875)
                .mana(70, 15)
                .cd(9)
                .range(725);
        TidecallersBlessing.update()
                .active("対象の味方Championの通常攻撃に{1}と1秒間の{2}を付与する。この効果は5秒経つか3回通常攻撃を行うと解消される。")
                .variable(1, MagicDamage, 25, 15, ap(0.2))
                .variable(2, Slow, 15, 5)
                .mana(55, 5)
                .cd(11)
                .range(800);
        TidalWave.update()
                .active("指定方向に津波を発生させ、命中した敵ユニットに{1}と{2}を与えた後2～4秒間{3}与える。スローの効果時間は当たるまでの津波の移動距離に比例して効果時間が長くなる。")
                .variable(1, Knockup, 1)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, Slow, 50, 10)
                .mana(100, 50)
                .cd(140, -20)
                .range(2550);

        /** Nasus */
        SoulEater.update().passive("{1}を得る。レベル1、7、13で増加値が上昇する。").variable(1, LS, new Per6Level(14, 3));
        SiphoningStrike.update()
                .active("次に行う通常攻撃に{1}を付与する。このスキルを使用しLHをとると増加ダメージが+3されていく。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+6)になる。")
                .variable(1, PhysicalDamage, 30, 20, amplify(Stack, 3))
                .mana(20, 5)
                .cd(8, -1);
        Wither.update()
                .active("対象の敵Championの{1}と{2}を5秒間低下させる。また効果中は毎秒低下値が上昇していく。")
                .variable(1, ASRatio, 35, 0, amplify(Duration, 3, 3))
                .variable(2, Slow, 35, 0, amplify(Duration, 3, 3))
                .mana(80)
                .cd(15, -1)
                .range(700);
        SpiritFire.update()
                .active("指定地点に魔法陣を呼び出し{1}の敵ユニットに{2}を与える。魔方陣は5秒間持続し、上にいる敵ユニットに{3}と毎秒{4}を与える。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 55, 40, ap(0.6))
                .variable(3, Status.ARReduction, 20, 5)
                .variable(4, MagicDamage, 11, 8, ap(0.12))
                .mana(70, 15)
                .cd(12)
                .range(650);
        FuryOftheSands.update()
                .active("15秒間自身の周りに砂嵐を発生させ{1}増加し、周囲の敵ユニットに毎秒{2}を与える。また効果中はこのスキルで与えたダメージの5%を自身の攻撃力に加える。毎秒ダメージの上限は240、増加攻撃力の上限は300。")
                .variable(1, Health, 300, 150)
                .variable(2, MagicDamage, 0, 0, amplify(TargetHealth, 3, 1, ap(0.01)))
                .mana(150)
                .cd(120);

        /** Nautilus */
        StaggeringBlow.update()
                .passive("通常攻撃に{1}と{2}が付与される。同一の対象には12秒に一度しか発動しない。レベル1、7、13で効果時間が上昇する。")
                .variable(1, PhysicalDamage, 2, 0, amplify(Lv, 6))
                .variable(2, Snare, new Per6Level(0.5, 0.25));
        DredgeLine.update()
                .active("指定方向に錨を投げ、最初に命中した敵ユニットに{1}を与えNautilusの方向に引き寄せる。またNautilus自身も敵ユニットの方向に移動する。錨が壁に命中した場合、壁の方向にNautilusが移動しこのスキルのCDが半分になる。")
                .variable(1, MagicDamage, 60, 45, ap(0.75))
                .mana(60, 10)
                .cd(18, -2)
                .range(950);
        TitansWrath.update()
                .active("10秒間{1}を得る。シールドが持続している間は通常攻撃時に対象とその周囲({2})にいる敵ユニットに{3}を与える。この魔法DMは2秒間かけて与えられる。")
                .variable(1, Shield, 100, 50, amplify(BounusHealth, 0.1))
                .variable(2, Radius, 350)
                .variable(3, MagicDamage, 30, 15, ap(0.4))
                .mana(80)
                .cd(26, -2);
        Riptide.update()
                .active("周囲を爆発させ命中した敵ユニットに{1}と２秒間{2}を与える。スローの効果は2秒かけて元に戻る。爆発はNautilusを中心に3回まで発生し、同一対象に対して複数hitする。2発目以降は本来の50%分の魔法DMを与える(3発hitで{3})。")
                .variable(1, MagicDamage, 60, 40, ap(0.5))
                .variable(2, Slow, 30, 5)
                .variable(3, MagicDamage, 120, 80, ap(1))
                .mana(60, 10)
                .cd(10)
                .range(400);
        DepthCharge.update()
                .active("対象の敵Championに衝撃波を放ち、移動中の衝撃波に当たった敵ユニットに{1}と{2}を与える。衝撃波が対象の敵Championに当たると爆発し、対象とその周囲にいる敵ユニットに{3}と{2}を与える。対象の敵Championには{2}と同時に{4}を与える。")
                .variable(1, MagicDamage, 125, 50, ap(0.4))
                .variable(2, Knockup, 1)
                .variable(3, MagicDamage, 200, 125, ap(0.8))
                .variable(4, Stun, 1, 0.5)
                .mana(100)
                .cd(140, -30)
                .range(850);

        /** Nidalee */
        Prowl.update().passive("茂みに入ると移動速度が15%増加する。この効果は茂みから出ても2秒間持続する。");
        JavelinToss.update()
                .passive("Toss(Human)")
                .active("指定方向に槍を投げて当たった敵ユニットに魔法DMを与える。槍がhitした時のNidaleeとターゲットの間の距離に比例して与えるダメージが増加する。(最大2.5倍)最小魔法DM: 55/95/140/185/230 (+0.65)最大魔法DM: 137.5/237.5/350/462.5/575 (+1.625)消費MN: 50/60/70/80/90 CD: 6s Range: 1500Takedown(Cougar)Active:次に行う通常攻撃のダメージが増加する。対象が受けているダメージに比例してダメージが増加する。")
                .mana(50, 10)
                .cd(5)
                .range(1500);
        Bushwhack.update()
                .passive("k(Human)")
                .active("指定地点に罠を仕掛ける。敵ユニットが罠を踏むと発動し、対象の敵ユニットとその周囲の敵ユニットに2秒かけて魔法DMを与え、12秒間ARとMRを低下させ視界を得る。罠は4分間持続する。罠を設置してから2秒間の間は罠は発動しない。魔法DM: 80/125/170/215/260 (+0.4) 低下AR,MR: 20/25/30/35/40% 罠起動範囲:消費MN: 60/75/90/105/120 CD: 18s Range: 900Pounce(Cougar)Active:前方に飛びかかり着地地点の敵ユニットに魔法DMを与える。")
                .mana(60, 15)
                .cd(3.5)
                .range(350);
        PrimalSurge.update()
                .passive("urge(Human)")
                .active("対象の味方ChampionのHPを回復し、7秒間攻撃速度を増加させる。回復HP: 50/85/120/155/190 (+0.7)増加攻撃速度: 20/30/40/50/60%消費MN: 60/80/100/120/140 CD: 10s Range: 600Swipe(Cougar)Active:前方扇形180°の範囲内の敵ユニットに魔法DMを与える。")
                .mana(60, 20)
                .cd(6)
                .range(600);
        AspectOfTheCougar.update()
                .active("HumanからCougarに、CougarからHumanに変身する。Cougar時はスキルの効果が変わり、通常攻撃の射程距離が125(Melee)になり、移動速度が20、ARとMRが10/20/30上昇する。Cougarスキルはこのスキルのレベルに比例し威力が増加する。")
                .cd(4);

        /** Nocturne */
        UmbraBlades.update()
                .passive("10秒に1度、通常攻撃のダメージが120%に増加し、周囲200の敵ユニットにダメージを与える範囲攻撃になる。この効果がヒットした敵の数に応じて自身のHPを回復する。また、通常攻撃を行うごとに、このスキルのCDが1秒減少する。建物を攻撃する時はこの効果は発生しない。レベル1、7、13でHP回復量が上昇する。")
                .cd(10);
        Duskbringer.update()
                .active("指定方向に影の刃を投げて当たった敵ユニットに物理DMを与える。刃の軌跡には5秒間持続するDusk Trailが残り、刃がヒットした敵Championの動いた軌道上にもDusk Trailが残るようになる。Dusk Trailの上ではNocturneは他ユニットをすり抜けるようになり、また攻撃力と移動速度が増加する。")
                .mana(60, 5)
                .cd(10)
                .range(1200);
        ShroudOfDarkness.update()
                .passive("攻撃速度が増加する。増加AS: 20/25/30/35/40%")
                .active("Nocturneに1.5秒間持続するスペルシールドを付与し、その間一度だけ敵のスキルを無効化する。無効化した場合、5秒間Passiveの増加攻撃速度が2倍になる。")
                .mana(50)
                .cd(20, -2);
        UnspeakableHorror.update()
                .active("対象の敵ユニットに2秒かけて魔法DMを与え、2秒間対象が一定範囲内(範囲465)に留まり続けていれば、更にFearを与える。魔法DM: 50/100/150/200/250 (+1.0)※表記魔法DMは2秒間当て続けた場合の合計ダメージ。")
                .mana(60, 5)
                .cd(15, -1)
                .range(425);
        Paranoia.update()
                .active("4秒間すべての敵Championの視界範囲を低下させ、また自分以外の視界を得られなくする。効果中に範囲内にいる敵Championを指定すると対象の位置まで移動し、到着時に対象に物理DMを与える。")
                .mana(100)
                .cd(180, -40)
                .range(2000, 750);

        /** Nunu */
        Visionary.update().passive("通常攻撃を行うたびにスタックが増加する(最大5スタック)。5スタックの状態でスキルを使用すると、スタックを消費して対象のスキルの消費マナが0になる。");
        Consume.update().active("対象の敵MinionかPet及び中立クリープ1体にTrue Damageを与え、自身のHPを回復する。").mana(60).cd(16, -2).range(125);
        BloodBoil.update()
                .active("対象の味方ユニットの攻撃速度と移動速度を12秒間上昇させる。自分以外に使用した場合は自身にも同様の効果が発生する。")
                .mana(50)
                .cd(15)
                .range(700);
        IceBlast.update().active("対象の敵ユニットに魔法DMと攻撃速度低下(25%,3s)、スロー(3s)を与える。").mana(75, 10).cd(6).range(550);
        AbsoluteZero.update()
                .active("最大3秒詠唱を行い、詠唱完了またはキャンセル時に範囲内の敵ユニットに魔法DMを与える。ダメージは詠唱した時間に比例し増加する。また詠唱中は範囲内の敵ユニットに攻撃速度低下(25%)、スロー(50%)を与える。")
                .mana(150)
                .cd(150, -30);

        /** Olaf */
        BerserkerRage.update().passive("{1}を得る。").variable(1, ASRatio, 0, 0, amplify(MissingHealth, 1));
        Undertow.update()
                .active("指定地点に貫通する斧を投げ、当たった敵ユニットに{1}と2.5秒間{2}を与える。このスローは2.5秒かけて元に戻る。投げた斧は指定地点に7秒間留まり、斧を回収するとこのスキルのCDが4.5秒解消される。")
                .variable(1, PhysicalDamage, 80, 45, bounusAD(1))
                .variable(2, Slow, 24, 4)
                .mana(55, 5)
                .cd(8)
                .range(1000);
        ViciousStrikes.update()
                .active("6秒間{1}と{2}と{3}を得る。")
                .variable(1, AD, 7, 7, amplify(Health, 0.01))
                .variable(2, LS, 9, 3)
                .variable(3, SV, 9, 3)
                .mana(40, 5)
                .cd(16);
        RecklessSwing.update()
                .active("対象の敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 100, 60)
                .cost(Health, 40, 24)
                .cd(9, -1)
                .range(325);
        Ragnarok.update()
                .active("6秒間{1}と{2}と{3}を得て、すべてのCC(Stun, Slow, Taunt, Fear, Snare, 打ち上げ、ノックバック, Silence, Blind, Suppression)を無効化する。既にCCを受けていた場合はそれらを解除する。StunなどのDisable中でも使用可能。")
                .variable(1, ARPen, 10, 10)
                .variable(2, AR, 30, 15)
                .variable(3, MR, 30, 15)
                .mana(100, -25)
                .cd(100);

        /** Orianna */
        ClockworkWindup.update()
                .passive("通常攻撃に追加魔法DMが付与される。4秒以内に同一の対象を連続して攻撃すると、追加魔法DMが20%上昇していく(最大+40%)。追加魔法の基礎DMは4/7/10/13/16レベル時に増加する。建物には無効。");
        CommandAttack.update()
                .active("指定した地点にBallを移動させ、移動中のBallに触れた敵ユニットと指定範囲にいる敵ユニットに魔法DMを与える。ダメージは敵に当たるごとに10%づつ減少する（最大60%減少）。BallはOriannaから一定距離離れなければその場に待機して視界を確保し続ける。")
                .mana(50)
                .cd(6, -0.75)
                .range(825);
        CommandDissonance.update()
                .active("Ballの存在する地点にフィールドを展開しBallの周囲にいる敵ユニットに魔法DMを与える。フィールドは3秒間持続し、フィールドの上の味方ユニットは移動速度が上昇、敵ユニットにはスローを与える。フィールドから出た場合、この効果は2秒かけて元に戻る。")
                .mana(70, 10)
                .cd(9);
        CommandProtect.update()
                .passive("Ballが付いている味方ChampionのARとMRが増加する。増加AR,MR: 10/15/20/25/30")
                .active("対象の味方ChampionまでBallを移動させ、4秒間持続するダメージを軽減するシールドを付与する。また、移動中のBallに触れた敵ユニットに魔法DMを与える。Ballは対象がOriannaから一定距離離れなければ貼り付き続ける。")
                .mana(60)
                .cd(9)
                .range(1120);
        CommandShockwave.update()
                .active("約0.5秒詠唱後にBallから衝撃波を発生させ、Ballの周囲にいる敵ユニットに魔法DMを与えると共に、Ballの方向に打ち上げ（ノックバック）させる。")
                .mana(100, 25)
                .cd(120, -15);

        /** Pantheon */
        AegisProtection.update()
                .passive("通常攻撃を行うかスキルを使用するたびにスタックが1増加(最大4スタック)し、4スタック時に40DM以上の通常攻撃を受けるとスタックを消費して通常攻撃のダメージを無効化する。");
        SpearShot.update().active("対象の敵ユニットに槍を投げ物理DMを与える。").mana(45).cd(4).range(600);
        AegisOfZeonia.update()
                .active("対象の敵Championに飛びかかり魔法DMとスタン(1s)を与え、Aegis Protectionを発動する。")
                .mana(55)
                .cd(13, -1)
                .range(600);
        HeartseekerStrike.update()
                .passive("敵ユニットのHPが15%以下の時は通常攻撃が必ずクリティカルになり、またSpear Shotのダメージが1.5倍になる。")
                .active("指定方向に0.75秒間槍を突き出し、範囲内の敵ユニットに物理DMを最大3回与える(0.25秒毎に1ヒット)。対象がChampionの場合、与えるダメージが2倍になる。※ チャネリングスキル。チャネリングが中断されるか効果時間が過ぎるまで効果が持続する。")
                .mana(45, 5)
                .cd(10, -1)
                .range(400);
        GrandSkyfall.update()
                .active("地点を指定して2秒後にジャンプし、その1.5秒後に指定地点の周囲に魔法DM、スロー(35%,1s)を与えつつ落下(ワープ)する。DMは指定地点から離れるほど低減され、範囲最端では50%となる。ジャンプ前にキャンセルすると、消費した分のマナが回復し、このスキルのCDは10秒になる。")
                .mana(125)
                .cd(150, -15)
                .range(5500);

        /** Poppy */
        ValiantFighter.update().passive("現在HPの10%を超えるダメージを受けた際、その超過分のダメージを50%低減する。塔の攻撃には無効。");
        DevastatingBlow.update().active("次に行う通常攻撃が魔法DMになり、追加魔法DMが付与される。追加魔法DMは対象の最大HPに比例する。").mana(55).cd(8, -1);
        ParagonOfDemacia.update()
                .passive("通常攻撃を行うか、ダメージを受ける度にスタックが1増加する(最大10)。スタック数に比例して自身の攻撃力とARが増加する。スタックは5秒間増加がないと0になる。増加攻撃力,AR(1スタック毎): 1.5/2/2.5/3/3.5")
                .active("スタックを最大(10)まで増加させ、5秒間移動速度が増加する。")
                .mana(70, 5)
                .cd(12);
        HeroicCharge.update()
                .active("対象の敵ユニットに突撃しノックバックと魔法DMを与える。ノックバック時に壁にぶつかった場合、追加魔法DMとスタン(1.5s)を与える。")
                .mana(60, 5)
                .cd(12, -1)
                .range(525);
        DiplomaticImmunity.update()
                .active("対象の敵Championを数秒間ターゲットし、その対象に与えるダメージが増加する。効果中は対象以外からのすべての攻撃を無効化する(対象のPetからはダメージを受ける)。")
                .mana(100)
                .cd(140, -20)
                .range(900);

        /** Rammus */
        SpikedShell.update().passive("{1}を得る。").variable(1, AD, 0, 0, amplify(AR, 0.45));
        Powerball.update()
                .active("使用してから7秒間Rammusが回転し、その間徐々に移動速度が増加する(最大時85%増加)。回転中に最初に当たった敵ユニットとRammusの周囲({1})にいる敵ユニットに{2}、{3}、3秒間の{4}を与える。回転中にスキル再使用または、Defensive Ball Curlを使用すると回転がキャンセルされる。")
                .variable(1, Radius, 200)
                .variable(2, MagicDamage, 100, 50, ap(1))
                .variable(3, Knockup, 0.75)
                .variable(4, Slow, 20, 5)
                .mana(70, 10)
                .cd(10);
        DefensiveBallCurl.update()
                .active("6秒間{1}と{2}を得て、Rammusを通常攻撃した敵ユニットに{3}を与える。効果中にPowerballを使用すると効果がキャンセルされる。また、このスキルを再使用することで効果をキャンセルできる。")
                .variable(1, AR, 40, 20)
                .variable(2, MR, 40, 20)
                .variable(3, MagicDamage, 15, 10, amplify(AR, 0.1))
                .mana(40)
                .cd(14);
        PuncturingTaunt.update()
                .active("対象の敵ユニットに{1}と{2}を与える。")
                .variable(1, Taunt, 1, 0.5)
                .variable(2, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(12)
                .range(325);
        Tremors.update()
                .active("8秒間地震を発生させ{1}の敵ユニット及び建物に毎秒{2}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 65, 65, ap(0.3))
                .mana(120)
                .cd(60);

        /** Renekton */
        ReignOfAnger.update()
                .passive("通常攻撃ごとにFuryが5増加する。12秒間戦闘を行わないとFuryは毎秒2.5減少する。Furyの最大値は100、Furyが50以上ある場合にスキルを使用すると、Furyを50消費してスキルが強化される。また、RenektonのHPが50%以下になるとFuryの増加量が50%増加する。建物を攻撃した場合はFuryは増加しない。");
        CullTheMeek.update()
                .active("武器を振り回し周囲の敵ユニットに物理DMを与え、与えたダメージの5%を回復する(上限あり)。対象がChampionの場合、HP回復量が20%になる。当たったユニット1体につきFuryが5増加する。(最大25)Fury消費時:与えるダメージが50%増加し、HP回復量が2倍、回復上限が3倍に増加する。但し、Fury増加効果は無くなる。")
                .cd(8);
        RuthlessPredator.update()
                .active("次に行う通常攻撃が2回攻撃になり、スタン(0.75s)が付与される。このスキルはOn-Hit Effectsの影響を受ける。Fury消費時:攻撃回数が3回に増加し、スタンの効果時間が延長(1.5s)される。但し、Fury増加効果は無くなる。")
                .cd(13, -1);
        SliceandDice.update()
                .active("指定方向にダッシュし触れた敵ユニットに物理DMを与える(Slice)。このスキルが敵にヒットした場合、4秒間の間だけ再度使用できる(Dice)。Fury消費時:Diceで与えるダメージが50%増加し、4秒間敵ユニットのARを減少させる効果が追加される。SliceではFuryを消費しない。")
                .cd(18, -1)
                .range(450);
        Dominus.update().active("15秒間サイズが大きくなり、スキルの射程が増加する。更にHPが増加し周囲に毎秒魔法DMを与える。また、毎秒5Furyを得る。").cd(120);

        /** Rengar */
        UnseenPredator.update()
                .passive("ステルス状態または茂みの中から相手を攻撃する際には、通常攻撃の射程が増加し相手に飛びつくようになる。この効果はステルス状態が解除された、また茂みから出た後0.5秒の間でも発生し、またステルス状態や茂みの中の視界が取られていた場合でも発生する。増加後射程: 600(Bonetooth Necklaceが9 Trophies以上の場合は750)また、Rengarがスキルで敵ユニットにダメージを与える度に1 Ferocityを得て(最大5 Ferocity)、5 Ferocity時にはFerocityを消費して強化(Empowered)されたスキルを使用することが出来る。");
        Savagery.update()
                .active("次の通常攻撃に追加物理DMを付与し、次の通常攻撃から4秒間攻撃速度が増加する。追加物理DM: 30/60/90/120/150増加AS: 30/35/40/45/50%CD: 8/7.5/7/6.5/6sEmpoweredActive:次の通常攻撃に追加物理DMを付与し、次の通常攻撃から4秒間攻撃速度が増加する。攻撃速度増加効果は通常のSavageryと重複する。")
                .cd(8, -0.5);
        BattleRoar.update()
                .active("周囲の敵ユニットに魔法DMを与える。また、このスキルが敵ユニットに命中すると、3秒間自身のArmorとMagic Resistが増加する。魔法DM: 50/80/110/140/170 (+0.8) 効果範囲: 500増加AR/MR: 15/22/29/36/43CD: 15/14/13/12/11sEmpoweredActive:周囲の敵ユニットに魔法DMを与え、自身のHPを回復する。また、このスキルが敵ユニットに命中すると、3秒間自身のArmorとMagic Resistが増加する。ArmorとMagic Resistの増加効果は通常のBattle Roarと重複しない。")
                .cd(15, -1);
        BolaStrike.update()
                .active("対象の敵ユニットに投げ縄を投げ、物理DMとスロー(2.5s)を与える。スローは時間経過と共に元に戻る。物理DM: 60/105/150/195/240 + [増加攻撃力 × 70%]スロー: 50/55/60/65/70%CD: 12/11/10/9/8s Range: 575EmpoweredActive:対象の敵ユニットに投げ縄を投げ、物理DMとスネア(1s)とスロー(2.5s)を与える。スローは時間経過と共に元に戻る。")
                .cd(12, -1)
                .range(575);
        ThrillOftheHunt.update()
                .active("1秒後に自身が最大7秒間(Bonetooth Necklaceが14 Trophiesの場合10秒間)ステルス状態になり、自身を中心とした広範囲内の敵Champion全員の視界を得る。ステルス準備中に攻撃を行うかダメージを受ける度に、ステルス状態になるのに必要な時間が1秒増加する。ステルス準備開始から3秒経過するとダメージを受けていてもステルス状態になる。ステルス状態の間は移動速度が増加し、0.75秒毎に1 Ferocityを得る。これらの効果はステルス状態が解除されると終了する。")
                .cd(140, -35);

        /** Riven */
        RunicBlade.update()
                .passive("スキルを使用するごとに1チャージを得る。チャージがある状態で通常攻撃を行うと、チャージを消費して通常攻撃に{1}が付与される。チャージは最大3スタックされ、通常攻撃ごとに1チャージずつ消費される。チャージは5秒間増加または消費がないと0になる。建物には無効。")
                .variable(1, PhysicalDamage, 0, 0, amplify(AD, new Per2Level(0.2, 0.05)));
        BrokenWings.update()
                .active("前方にステップし、{1}の敵ユニットを剣で切りつけて{2}を与える。このスキルは短期間の間、3回まで連続して使用できる。3度目の使用でジャンプを行い、着地時に{3}の敵ユニットに{2}と{4}を与える。また、スキルを使用する度にオートアタックタイマーがリセットされる。最大DMは{5}。")
                .variable(1, Radius, 112.5)
                .variable(2, PhysicalDamage, 30, 25, bounusAD(0.7))
                .variable(3, Radius, 150)
                .variable(4, Knockback, 225)
                .variable(5, PhysicalDamage, 90, 75, bounusAD(2.1))
                .cd(1)
                .range(260);
        KiBurst.update()
                .active("{1}の敵ユニットに{2}と{3}を与える。")
                .variable(1, Radius, 125)
                .variable(2, PhysicalDamage, 50, 30, bounusAD(1))
                .variable(3, Stun, 0.75)
                .cd(11, -1);
        Valor.update()
                .active("指定方向にダッシュ({1})し、2.5秒間{2}が付与される。")
                .variable(1, Distance, 325)
                .variable(2, Shield, 70, 30, bounusAD(1))
                .cd(10, -1)
                .range(325);
        BladeOftheExile.update()
                .active("15秒間折れた剣の刃を再生させ、{1}増加し、射程が増加する(通常攻撃: {2} Broken Wings: {3} Ki Burst: {4})。また、このスキルを再度使用することで一度だけ0.5秒後に指定方向に巨大な衝撃波を発生させ、範囲内の敵ユニットに{5}与える。対象が受けているダメージに比例して与えるダメージが増加して、最大DMは{6}。")
                .variable(1, AD, 0, 0, ad(0.2))
                .variable(2, Range, 200)
                .variable(3, Range, 325)
                .variable(4, Range, 270)
                .variable(5, PhysicalDamage, 80, 40, bounusAD(0.6))
                .variable(6, PhysicalDamage, 240, 120, bounusAD(1.8))
                .cd(110, -30);

        /** Rumble */
        JunkyardTitan.update()
                .passive("Ult以外のスキルを使うとHeatが20増加し、それが50以上になると「Danger Zone」状態に入り全てのスキルに追加効果がつくようになる。Heatが100になると6秒間スキルが使用不可能になり、通常攻撃に追加魔法DMが付与される。Heatは時間によって減少していく。追加魔法DMは建物には無効。");
        Flamespitter.update()
                .active("3秒間前方の範囲を火炎放射器で焼き払い、範囲内の敵ユニットに毎秒魔法DMを与える。minionに与えるダメージは半分。「Danger Zone」中は25%分の追加ダメージが入る。")
                .cd(6)
                .range(600);
        ScrapShield.update()
                .active("2秒間ダメージを軽減するシールドを付与し、更に1秒間自身の移動速度が上昇する。「Danger Zone」状態ではシールドの耐久値と移動速度上昇効果が25%分上昇する。")
                .cd(6);
        ElectroHarpoon.update()
                .active("指定方向に銛を放ち当たった敵ユニットに魔法DMとスロー(3s)を与える。このスキルは3秒の間、2回まで連続して使用できる(但し、一度使用する度に1秒のCDが発生する)。2発目はHeatが増加しない。また、このスキルによるスローはスタックする。「Danger Zone」状態ではスローとダメージが25%分上昇する。")
                .cd(10)
                .range(850);
        TheEqualizer.update()
                .active("指定した位置から指定方向に向かってロケットを打ち出し、当たった敵ユニットに魔法DMとスロー(35%)を与える。また5秒間ロケットの着弾した地面に炎が残り、その上にいる敵ユニットに毎秒魔法DMとスロー(35%)を与える。")
                .cd(105, -15)
                .range(1750);

        /** Sejuani */
        Frost.update().passive("通常攻撃にFrostを付与する。Frost状態の敵ユニットはスロー(10%、3s)を受ける。");
        ArcticAssault.update()
                .active("指定方向に突進し、接触した全ての敵ユニットに魔法DMとFrostを与え、対象がMinionの場合は更にノックバックさせる。敵Championに当たるか最大距離だけ移動すると突進は止まる。")
                .mana(70, 5)
                .cd(19, -2)
                .range(700);
        NorthernWinds.update()
                .active("6秒間極寒の嵐を周囲に召還し、周囲の敵ユニットに毎秒魔法DMを与える。魔法DMは敵ユニットがFrostまたはPermafrostの時には50%増加する。")
                .mana(40)
                .cd(10);
        Permafrost.update()
                .active("周囲の敵ユニットのFrostをPermafrostにし、魔法DMを与える。Permafrost状態の敵ユニットは強力なスロー(3s)を受ける。")
                .mana(55)
                .cd(11);
        GlacialPrison.update()
                .active("指定方向に武器を投げ、最大距離飛ぶか敵Championに命中するとその場で氷が爆発し、周囲の敵ユニットに魔法DMとスタン(1s)を与え、Frostにする。武器が直撃した敵Championはスタン効果時間が2sになる。")
                .mana(100)
                .cd(130, -15)
                .range(1150);

        /** Shaco */
        Backstab.update().passive("対象の背後から攻撃した場合にダメージが20%増加する。");
        Deceive.update()
                .active("指定地点にテレポートし、その後3.5秒間ステルス状態になる。また、スキル使用後6秒以内に通常攻撃を行うと必ずクリティカルになる。その際のクリティカルダメージはレベル毎に変化する。")
                .mana(90, -10)
                .range(400);
        JackInTheBox.update()
                .active("指定地点に60秒持続する人形を設置する。人形は設置後2秒でステルス状態となり、敵ユニットがステルス状態の人形から範囲300以内に近づくと、人形のステルスが解除されると同時に近くの敵ユニットにFearを与え、5秒間通常攻撃を行った後に破壊される。")
                .mana(60)
                .cd(16)
                .range(425);
        TwoShivPoison.update()
                .passive("通常攻撃時にスロー(2s)を与える。対象がChampion以外の場合、更に命中率低下(値はスローと同じ)を与える。命中率低下を受けたユニットは一定確率で通常攻撃が外れる(ブラインドと同じ)。スロー,命中率低下: 10/15/20/25/30%")
                .active("対象の敵ユニットに魔法DMとスロー(Passiveと同じ効果、3s)を与える。効果後はCDが解消されるまでPassiveの効果が無くなる。")
                .mana(50, 5)
                .cd(8)
                .range(625);
        Hallucinate.update()
                .active("18秒間持続する自身のイリュージョン(敵からの見た目は本体と同じ)を作成する。（RまたはALT押しながらクリックで任意の操作可能）イリュージョンは本体の75%の攻撃力を持ち、150%のダメージを受ける。また本体の一部アイテムの効果を引き継ぐ。イリュージョン死亡または効果時間終了時に爆発し、近くの敵ユニットに魔法DMを与える。イリュージョンが塔に与えるダメージは半分。このスキルを使用してもステルスは解除されない。")
                .mana(100)
                .cd(100, -10);

        /** Shen */
        KiStrike.update()
                .passive("9秒に1度通常攻撃に「気」回復効果と追加魔法DMが付与される。このスキルはShenが通常攻撃を行う度にCDが1秒解消される。CD解消は建物を攻撃した場合は発生しない。LV1/7/13で「気」回復量が増加する。")
                .cd(9);
        VorpalBlade.update()
                .active("対象の敵ユニットに魔法DMと5秒間持続するDebuffを与える。Debuffが付与された対象に通常攻撃またはダメージスペルで攻撃をすると、攻撃した味方ChampionのHPが3秒かけて回復する。このスキルでLHを取った場合、回復HPの33%の回復効果を得る。")
                .cd(6, -0.5)
                .range(475);
        Feint.update().active("3秒間DMを軽減するシールドを自身に付与する。シールドが持続している間はKi StrikeのCD解消効果が1秒から2秒になる。").cd(9, -1);
        ShadowDash.update()
                .active("指定地点まで素早く移動し接触した敵Championに魔法DMとTaunt(1.5s)を与える。ShenはTaunt効果中の対象から受ける通常攻撃のダメージを半減する。またこのスキルが敵Championに命中する度に「気」が40回復する。")
                .cd(16, -2)
                .range(600);
        StandUnited.update().active("MAP内の味方Championを指定し対象に5秒間持続するシールドを付与する。その後3秒詠唱しそこまでワープする。").cd(200, -20);

        /** Shyvana */
        FuryOftheDragonborn.update()
                .passive("Shyvanaは通常攻撃時に次の効果を得る。・Twin Bite：CDを0.5秒解消させる。対象が建物の場合は無効。・Burnout：効果時間が1秒延長される。最大4秒延長できる。対象が建物の場合も有効。・Flame Breath：Flame BreathのAR低下を受けている敵ユニットに対し、Flame Breathのダメージの15%分の追加魔法DMが発生する。・Dragon's Descent：通常攻撃時に2Furyを得る。また、Human formの時には1.5秒毎に1Furyを得る。");
        TwinBite.update()
                .active("次に行う通常攻撃が2回攻撃になる。このスキルはOn-Hit Effectsの影響を受ける。2回目の物理DM: [攻撃力 × 80/85/90/95/100%]Dragon Form:対象の周囲にいる敵ユニットにも同様の効果を与える。")
                .cd(10, -1);
        Burnout.update()
                .active("3秒間周囲の敵ユニットに毎秒魔法DMを与え、その間Shyvanaの移動速度が増加する。移動速度上昇は時間経過と共に減少する。毎秒魔法DM: 25/40/55/70/85 + [増加攻撃力 × 20%] 効果範囲: 325MS増加: 30/35/40/45/50%Dragon Form:Shyvanaの通り道を5秒間炎上させ、その上にいる敵ユニットにも毎秒魔法DMを与える。")
                .cd(12);
        FlameBreath.update()
                .active("指定方向に火球を放ち当たった敵ユニットに魔法DMを与え、4秒間対象のARを15%減少させる。魔法DM: 80/125/170/215/260 (+0.6)Dragon Form:Shyvanaの前方の扇状の範囲を巻き込む範囲攻撃となる。")
                .cd(12, -1)
                .range(700);
        DragonsDescent.update()
                .passive("ARとMRが増加する。 AR/MR増加はDragon Formの時は2倍になる。増加AR,MR: 10/15/20また、このスキルのLv1取得時に100Furyを得る。")
                .active("このスキルはHuman formでFuryが100貯まった時のみ使用可能。Dragon Formに変身し、指定地点まで飛んで移動する。その際の移動経路上にいる敵ユニットに魔法DMを与え、移動地点の方向にノックバックさせる。Dragon Formでは毎秒6Fury減少し、0になるとHuman Formに戻る。")
                .range(1000);

        /** Singed */
        EmpoweredBulwark.update().passive("最大MNの25%分、HPが上昇する。");
        PoisonTrail.update().passive("n:Singedの通り道に3.25秒間持続する毒を撒き、触れた敵ユニットに毎秒魔法DMを与える。毎秒魔法DMは3秒間持続する。").mana(13).cd(1);
        MegaAdhesive.update()
                .active("指定範囲に5秒間持続する粘着剤を撒き、範囲内の敵ユニットにスローを与え続ける。スローは範囲外に出てからも1秒間持続する。")
                .mana(70, 10)
                .cd(14)
                .range(1000);
        Fling.update().active("対象の敵ユニット魔法DMを与え、Singedの後ろに投げ飛ばす。").mana(100, 10).cd(10).range(125);
        InsanityPotion.update()
                .active("25秒間Singedの各能力(AP、AR、MR、移動速度、HP回復速度、MN回復速度)が上昇し、受けるCC(Stun, Slow, Taunt, Fear, Snare, Silence, Blind)の効果時間が低減される。")
                .mana(150)
                .cd(100);

        /** Sion */
        FeelNoPain.update().passive("40%の確率で受ける通常攻撃のダメージを軽減する。この軽減は防御力計算より先に行われる。レベル1、7、13で軽減DMが上昇する。");
        CrypticGaze.update().active("対象の敵ユニットに魔法DMとスタン(1.5s)を与える。").mana(100).cd(12, -1).range(550);
        DeathsCaress.update()
                .active("ダメージを軽減するシールドを自身に付与する。10秒間シールドが残っていた場合、シールドが破裂し近くの敵ユニットに魔法DMを与える。使用から4秒後以降に再度使用で、即座にシールドを破裂させる。")
                .mana(70, 10);
        Enrage.update()
                .passive("n:Sionの攻撃力が増加する。使用中にLHをとるとSionの最大HPが増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+2/3/4/5/6)になる。このスキルはマナの代わりにHPを消費する。");
        Cannibalism.update()
                .active("20秒間Sionのライフスティールと攻撃速度が増加し、近くの味方ユニット(範囲200)を通常攻撃で与えたダメージの一定割合分回復させる。")
                .mana(100)
                .cd(90);

        /** Sivir */
        FleetOfFoot.update().passive("敵Championに通常攻撃でダメージを与えると、2秒間移動速度が50増加する。");
        BoomerangBlade.update()
                .active("指定方向にブーメランを投げ、当たった敵ユニットに物理DMを与える。ダメージは敵に当たるごとに20%ずつ減り、最大で40%まで低下する。行きと帰りそれぞれに攻撃判定がある。")
                .mana(70, 10)
                .cd(9)
                .range(1200);
        Ricochet.update()
                .active("次に行う通常攻撃に追加物理DMが付与され、5回跳ね返る(範囲450)ようになる。この追加ダメージはCriticalHitによって増幅される。On-Hit Effectsの効果は最初に当たったユニットにのみ発動し、跳ね返る毎にダメージが20%ずつ低下する。")
                .mana(40)
                .cd(7, -1);
        SpellShield.update()
                .active("Sivirに3秒間持続するスペルシールドを付与し、その間一度だけ敵のスキルを無効化する。無効化した場合自身のMNが150回復する。")
                .mana(75)
                .cd(22, -3);
        OnTheHunt.update()
                .active("10秒間自身と近くの味方ユニットの攻撃速度と移動速度を上昇するオーラを発生させる。一度範囲内に入れば、Sivirから離れても効果が持続する。")
                .mana(100)
                .cd(100, -10)
                .range(1200);

        /** Skarner */
        Energize.update().passive("通常攻撃を行うたびに、 Skarnerのすべてのスキルのクールダウンが0.5秒解消される(対象がChampionの場合は1秒)。建物に対しては無効。");
        CrystalSlash.update()
                .active("Skarnerの近くにいるすべての敵ユニットに物理DMを与える。このスキルが敵ユニットにヒットした場合、5秒間Crystal Energyのスタックを得る。スタックがある状態で再度このスキルを使用すると、追加魔法DMとスロー(2s)が付与される。")
                .mana(20, 2)
                .cd(3.5)
                .range(350);
        CrystallineExoskeleton.update().active("6秒間自身にシールドを張る。シールドが残っている間MS/ASが増加する。").mana(60).cd(18);
        Fracture.update()
                .active("指定方向に貫通するエネルギーを飛ばし、当たった敵ユニットに魔法DMと6秒間持続するマークを付与する。自身がマークが付いた敵ユニットを攻撃するか、このスキルで敵ユニットを倒した場合、マークを消費して自身のHPを回復する。HP回復量はマークを消費する度に50%ずつ低下していく。")
                .mana(50, 5)
                .cd(10)
                .range(600);
        Impale.update()
                .active("対象の敵Championに魔法DMとサプレッション(1.75s)を与える。効果中は対象の敵Championを引っ張る事が出来る。また、効果終了時に追加魔法DMを与える。")
                .mana(100, 25)
                .cd(130, -10)
                .range(350);

        /** Sona */
        PowerChord.update()
                .passive("Auraを切り替えても、以前のAuraの効果が1秒間持続する。切替時は他のAuraスキルが0.5秒間CDになる。また、3回スキルを使用した後の通常攻撃に追加魔法DMと、そのとき展開しているAuraに応じた追加効果が発生する。");
        HymnOfValor.update()
                .passive("Aura:周囲の味方ChampionのAD,APを増加させる。増加AD,AP: 4/8/12/16/20")
                .active("最も近い敵ユニット2体に魔法DMを与える。Sonaの通常攻撃範囲内に敵Championがいる場合、それらを優先して狙う。魔法DM: 50/100/150/200/250 (+0.7)消費MN: 45/50/55/60/65 CD: 7s Range: 700Power Chord - Stacatto:追加魔法DMが2倍になる。")
                .mana(45, 5)
                .cd(7)
                .range(700);
        AriaOfPerseverance.update()
                .passive("Aura:周囲の味方ChampionのAR,MRを増加させる。増加AR,MR: 3/6/9/12/15")
                .active("近くにいる最もHPが減っている味方Champion1体とSonaのHPを回復する。HPを回復した対象と自身は3秒間、AuraのAR,MR増加が2倍になる。回復HP: 40/60/80/100/120 (+0.25)消費MN: 60/65/70/75/80 CD: 7s Range: 900Power Chord - Diminuendo:対象が与えるダメージを20%低下するDebuffを付与する。この効果は4秒間持続する。")
                .mana(60, 5)
                .cd(7)
                .range(900);
        SongOfCelerity.update()
                .passive("Aura:周囲の味方Championの移動速度を増加させる。増加移動速度: 4/8/12/16/20")
                .active("1.5秒間周囲の味方ユニットの移動速度を増加させる。増加移動速度: 6/8/10/12/14% 効果範囲: 850消費MN: 65 CD: 7sPower Chord - Tempo:スロー(40%,2s)効果を付与する。")
                .mana(65)
                .cd(7);
        Crescendo.update().active("前方範囲の敵Championに魔法DMを与え、1.5秒間強制的に踊らせる(スタン)。").mana(100, 50).cd(140, -20).range(1000);

        /** Soraka */
        Consecration.update().passive("周囲の味方Champion(範囲1000)のMRを16上昇させる。");
        Starcall.update()
                .active("周囲の敵ユニットに魔法DMを与え、スタックを1つ増加させる。スタック1つにつきMRが低下する。スタックは5秒間持続し最大10まで増加する。")
                .mana(20, 15)
                .cd(2.5)
                .range(675);
        AstralBlessing.update().active("対象の味方ユニットのHPを回復し、3秒間ARを増加させる。").mana(80, 30).cd(20).range(750);
        Infuse.update()
                .active("対象の味方Championに使用するとmanaを回復する。敵ユニットに使用すると魔法DMとサイレンスを与える。このスキルはSoraka自身を対象とすることが出来ない。")
                .mana(40, 40)
                .cd(10)
                .range(725);
        Wish.update().active("味方Champion全員のHPを回復する。").mana(100, 75).cd(160, -15);

        /** Swain */
        CarrionRenewal.update().passive("敵ユニットを倒す毎に自身のmanaが回復する。").mana(9);
        Decrepify.update()
                .active("Swainの位置にビームを吐くカラスを設置し、対象の敵ユニットに毎秒魔法DMとスローを与える。3秒経つか対象のユニットがカラスの有効範囲外(900)に移動すると効果が切れる。")
                .mana(60, 10)
                .cd(8)
                .range(625);
        Nevermove.update().active("地点を指定した0.5秒後に範囲内の敵ユニットに魔法DMとSnare(2s)を与える。").mana(80, 10).cd(18, -2).range(900);
        Torment.update()
                .active("対象の敵ユニットに4秒かけて(表示は4秒間の合計DM)魔法DMを与える。また、効果中はSwainが対象のユニットに与えるダメージが増加する。")
                .mana(65, 5)
                .cd(10)
                .range(625);
        RavenousFlock.update()
                .passive("n:Swainがカラスに変身し、近くにいる敵ユニット3体(敵Championを優先)に毎秒魔法DMを与える。また、与えたダメージの25%(Championに対しては75%)が回復する。")
                .cd(8)
                .range(700);

        /** Syndra */
        Transcendent.update()
                .passive("各スキルを最高ランクまで上げると追加効果が発生する。・Dark Sphere：Championに対するDMが15%増加する。・Force of Will：スローの効果時間が2sになる。・Scatter the Weak：扇形範囲の横幅が50%増加する。・Unleashed Power：射程が75増加する。");
        DarkSphere.update()
                .active("指定地点にDark Sphereを召喚し、周囲の敵ユニットに魔法DMを与える。Dark Sphereはその後6秒間持続する。")
                .mana(40, 10)
                .cd(4)
                .range(800);
        ForceOfWill.update()
                .active("指定したDark Sphereか敵minionまたは中立モンスター(DragonとBaronには無効)のいずれかを自身まで引き寄せ、最大5秒間引っ張り続ける。この際Dark Sphereを引き寄せた場合、そのDark Sphereの持続時間は引き寄せてから6秒間に更新される。その後再度地点を指定することで指定地点に引き寄せたものを投げ、その周囲の敵ユニットに魔法DMとスロー(1.5s)を与える。また指定地点の視界を得る。")
                .mana(60, 10)
                .cd(12, -1);
        ScatterTheWeak.update()
                .active("指定方向扇形の範囲にいる敵ユニットに魔法DMを与え、ノックバックさせる。ノックバック距離はSyndraに近い地点にいるほど増加する。扇形の範囲内にDark Sphereがあった場合同様にノックバックさせ、それに当たった敵ユニットに同様の魔法DM(このスキルのDMとは重複しない)とスタン(1.5s)を与える。")
                .mana(50)
                .cd(18, -1.5)
                .range(650);
        UnleashedPower.update()
                .active("自身の周辺にDark Sphereを3つ召喚し、指定した敵Championに向けて自身の周囲に存在する全てのDark Sphereを向かわせ、魔法DMを与える。この際に召喚したDark Sphereは6秒間持続する。")
                .mana(100)
                .cd(100, -10)
                .range(675);

        /** Talon */
        Mercy.update().passive("スロー、スタン、スネア、サプレッションを受けている状態の敵ユニットに対しては通常攻撃のダメージが10%上昇する。");
        NoxianDiplomacy.update()
                .active("次の通常攻撃に追加物理DMが付与される。対象がChampionの場合、更に6秒間対象を出血させその間毎秒物理DMを与える。また出血中の対象の視界を得る。")
                .mana(40, 5)
                .cd(8, -1);
        Rake.update()
                .active("前方指定範囲に飛んだ後すぐ戻る刃を投げ当たった敵ユニットに物理DMとスロー(2s)を与える。刃は戻り際にも判定がある。")
                .mana(60, 5)
                .cd(10)
                .range(600);
        Cutthroat.update()
                .active("対象の敵ユニットに跳躍しサイレンス(1s)とマーク(3s)を与える。マークがついた敵ユニットに対してはTalonが与えるダメージが増加する。")
                .mana(35, 5)
                .cd(18, -2)
                .range(700);
        ShadowAssault.update()
                .active("Talonの周囲に8本の刃を投げ当たった敵ユニットに物理DMを与え、同時に2.5秒間ステルスになりその間移動速度が40%増加する。ステルスが解除される、または敵ユニットを攻撃すると刃がTalonの元に戻ってくる。刃は戻り際にも判定がある。")
                .mana(80, 10)
                .cd(75, -10)
                .range(1000);

        /** Taric */
        Gemcraft.update().passive("通常攻撃をすると{1}する。").variable(1, RestoreMana, 0, 0, amplify(Damage, 0.075));
        Imbue.update()
                .active("対象の味方ユニットとTaricの{1}する。自身に使用した場合は{2}する。このスキルは自身が通常攻撃を行う毎にCDが1秒解消される。対象が敵Championの場合は3秒解消される。")
                .variable(1, RestoreHealth, 60, 40, ap(0.6))
                .variable(2, RestoreHealth, 84, 56, ap(0.84))
                .mana(80, 15)
                .cd(20, -1)
                .range(750);
        Shatter.update()
                .passive("Taricは{1}を得て、更に近くの味方Championの{1}を増加させる{2}のAuraを得る。(Taric自身はAuraと合わせて2倍の効果を得る)")
                .variable(1, AR, 10, 5)
                .variable(2, Radius, 1000)
                .active("{3}の敵ユニットに{4}を与え、4秒間{5}を与える。効果後はCDが解消されるまでPassiveのTaric自身の増加ARが無くなる。")
                .variable(3, Radius, 400)
                .variable(4, MagicDamage, 60, 45, ap(0.6))
                .variable(5, ARReduction, 10, 5)
                .mana(50, 10)
                .cd(10);
        Dazzle.update()
                .active("対象の敵ユニットに{1}と{2}を与える。魔法DMは対象との距離が近いほど増加し、距離が遠いほど低下する。最大DMは{3}。")
                .variable(1, MagicDamage, 80, 60, ap(0.8))
                .variable(2, Stun, 1.5)
                .variable(3, MagicDamage, 40, 30, ap(0.3))
                .mana(95)
                .cd(14, -1)
                .range(625);
        Radiance.update()
                .active("{1}の敵ユニットに{2}を与える。スキル使用後の10秒間、{3}と{4}を得て、更に近くの味方Championの{5}と{6}を増加させるAura({7})を展開する。")
                .variable(1, Radius, 400)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, AD, 30, 20)
                .variable(4, AP, 30, 20)
                .variable(5, AD, 15, 10)
                .variable(6, AP, 15, 10)
                .variable(7, Radius, 1000)
                .mana(100)
                .cd(60);

        /** Teemo */
        Camouflage.update().passive("2秒間動かないとステルス状態になる。何か行動を行うか、強制的に移動させられるとステルスが解除され、ステルス解除後3秒間攻撃速度が40%増加する。");
        BlindingDart.update().active("対象の敵ユニットに魔法DMとブラインドを与える。").mana(70, 10).cd(8).range(680);
        MoveQuick.update()
                .passive("Teemoの移動速度が増加する。敵Championかタワーからダメージを受けると5秒間効果が切れる。増加移動速度: 10/14/18/22/26%")
                .active("3秒間Passiveの増加移動速度が倍になる。移動速度が倍の間は敵Championやタワーからのダメージで効果が切れない。")
                .mana(40)
                .cd(17);
        ToxicShot.update().passive("通常攻撃時に追加魔法DMと毒が付与される。毒は4秒間持続し、毎秒魔法DMを与える。");
        NoxiousTrap.update()
                .active("指定地点に10分間持続するキノコの罠を仕掛ける(設置後1秒でステルス状態となる)。使用時にスタックを消費する。敵ユニットがステルス状態の罠を踏むと破裂し、周囲のユニットに4秒かけて魔法DMとスロー(4s)を与える。一定時間毎にスタック数が1つ増加し最大3つまでスタックされる。スタック増加時間はCD低減の影響を受ける。設置したキノコはChampionの通常攻撃でのみダメージを与えられる。")
                .cd(1)
                .range(230);

        /** Thresh */
        Damnation.update()
                .passive("レベルアップでArmorを得る事ができない。自身の周囲で敵ユニットが死んだ場合、一定の確率で魂（Soul）を落とす。魂へ近づくかDark Passageのランタンを魂の近くに置くとその魂を回収する事ができ、自身のArmorとAbility Powerが上昇する。落とした魂は15秒間持続し、敵チームがThreshの視界を得ていた場合、敵チームからも視認することができる。");
        DeathSentence.update()
                .passive("通常攻撃に追加魔法DMを付与する。このDMはDamnationのスタック数と、自身が前回敵ユニットに通常攻撃をしてから経過した時間に比例して増加する。建物を攻撃した場合は追加魔法DMは発生せず、時間がリセットされる事もない。追加魔法DM(最小): Damnationのスタック数追加魔法DM(最大): Damnationのスタック数 + [攻撃力 × 80/110/140/170/200%]")
                .active("指定方向に鎌を投げ、命中した敵ユニットに魔法DMとスタン(1.5s)を与え、対象を1.5秒かけて自身の方へ引き寄せる。このスキルを再度使用すると対象のユニットへ飛びつく。")
                .mana(80)
                .cd(18, -1.5)
                .range(1075);
        DarkPassage.update()
                .active("指定地点に6秒間持続するランタンを設置する。味方Championがランタンを指定すると、ランタンとその味方Championが自身の方へと引き寄せられる。更にランタンの周囲にいる魂を自動的に回収し、味方Championにダメージを一定値軽減するシールドを付与する。シールドを得られるのは1ユニットにつき1回のみ。自身がランタンから距離1500以上離れるとランタンは自動的に自身の下へと戻る。")
                .mana(40)
                .cd(22, -1.5)
                .range(950);
        Flay.update()
                .active("自身後方から前方への帯状領域内の敵ユニットに魔法DMを与える。また自身後方にいる敵ユニットは自身に近づく向きに、自身前方にいる敵ユニットには自身から遠ざかる向きにノックバックさせ、スロー(1.5s)を与える。")
                .mana(60, 5)
                .cd(9);
        TheBox.update()
                .active("自身の周囲に五角形の壁を創り出し、最初に壁に触れた敵Championに魔法DMとスロー(99%,2s)を与える。2つ目以降の壁に触れた敵championには半分の魔法DMとスロー(99%,1s)を与える。敵が触れた部分の壁は破壊され消滅する。")
                .mana(100)
                .cd(150, -10);

        /** Tristana */
        DrawaBead.update().passive("レベルに比例し通常攻撃とExplosive Shot(E)の射程が上昇する。");
        RapidFire.update().active("7秒間Tristanaの攻撃速度が大幅に上昇する。").mana(50).cd(20);
        RocketJump.update()
                .active("指定地点にジャンプしジャンプ先の周囲の敵ユニットに魔法DMとスロー(60%,2.5s)を与える。キルかアシストをとるとこのスキルのCDが解消される。")
                .mana(80)
                .cd(22, -2)
                .range(800);
        ExplosiveShot.update()
                .passive("通常攻撃で敵ユニットを倒した時にそのユニットの周囲の敵ユニットに魔法DMを与える。魔法DM: 50/75/100/125/150 (+0.25)")
                .active("対象の敵ユニットに5秒かけて魔法DMを与え、その間HP回復量を50%低下させる。")
                .mana(50, 10)
                .cd(16)
                .range(616);
        BusterShot.update().active("対象の敵ユニットに魔法DMを与え、対象とその周囲(範囲200)の敵ユニットをノックバックさせる。").mana(100).cd(60).range(700);

        /** Trundle */
        Decompose.update().passive("Trundleの範囲1000以内で敵ユニットが死んだとき、自身のHPを回復する。レベル1、5、9、12、15で回復する割合が上昇する。");
        RabidBite.update()
                .active("次の通常攻撃のダメージが変更され、攻撃後自身の攻撃力が8秒間増加し、攻撃を受けたユニットの攻撃力をその半分だけ減少させる。建物には無効。")
                .mana(30)
                .cd(4);
        Contaminate.update()
                .active("指定範囲に8秒間持続する呪いを振りまく。範囲内に入っている間、自身の攻撃速度と移動速度が上昇し、受けるCC(Stun, Slow, Taunt, Fear, Snare, Silence, Blind)の効果時間が低減される。")
                .mana(60)
                .cd(15)
                .range(900);
        PillarOfFilth.update()
                .active("指定地点に7秒間持続する通行不可能なビーコンを設置し、ビーコンの周囲にいる敵ユニットにスローを与える。また、指定地点の視界を得る。")
                .mana(60)
                .cd(23, -3)
                .range(1000);
        Agony.update()
                .active("対象の敵ユニットのHPを一定量(魔法DM)、ARとMRを割合で奪う。その後6秒間かけて、合計で最初に吸収した量と同じだけのHP、AR、MRを奪う(つまり合計で2倍)。この効果は対象が吸収を受けている間続く。")
                .mana(75)
                .cd(80, -10)
                .range(700);

        /** Tryndamere */
        BattleFury.update()
                .passive("通常攻撃時に5Fury、クリティカル時に10Fury、Spinning Slashが敵ユニットに命中するたびに2Furyを得る。敵ユニットを倒すと追加で10Furyを得る。Furyの上限は100、8秒間戦闘を行わないと毎秒5Furyずつ減少していく。また、Furyの割合に比例してクリティカルの確率が上昇する。建物を攻撃した場合はFuryは増加しない。");
        Bloodlust.update()
                .passive("Tryndamereの攻撃力が増加し、更にHPの減少割合に比例して攻撃力が上昇する(瀕死時程攻撃力UP)。増加AD: 5/10/15/20/25 + [HP損傷率(%) × 0.15/0.2/0.25/0.3/0.35]")
                .active("Furyをすべて消費しHPを回復する。")
                .cd(12);
        MockingShout.update().active("4秒間近くの敵Championの攻撃力を下げ、後ろを向いている敵Championには更にスロー(4s)を与える。").cd(14).range(850);
        SpinningSlash.update()
                .active("指定地点まで武器を振り回しながら移動し、当たった敵ユニットに物理DMを与える。このスキルはクリティカルが発生するたびにCDが2秒解消される。")
                .cd(13, -1)
                .range(660);
        UndyingRage.update()
                .active("5秒間HPが1未満にならなくなる(死ななくなる)。また、このスキル使用時にFuryが増加する。このスキルの使用は状態異常によって阻害されない。")
                .cd(110, -10);

        /** Twisted Fate */
        LoadedDice.update().passive("味方Championが敵を倒した時に取得するGoldが2増加する。");
        WildCards.update().active("指定向き3方向に貫通するカードを飛ばし、当たった敵ユニットに魔法DMを与える。").mana(60, 10).cd(6).range(1450);
        PickACard.update()
                .active("使用するとBlue、Red、Goldの3種のカードを選択し始め、再度使用でカードが決定する。決定したカードにより次の通常攻撃が魔法DMに変換され、以下の効果が追加される。Blue Card: マナが回復する。魔法DM: 40/60/80/100/120 (+0.4) + [攻撃力 × 100%]回復マナ: 26/39/52/65/78 + [攻撃力 × 65%]Red Card: 範囲攻撃になり、更にスロー(2.5s)の効果。魔法DM: 30/45/60/75/90 (+0.4) + [攻撃力 × 100%]スロー: 30/35/40/45/50%効果範囲: 100Gold Card: スタンの効果。")
                .mana(40, 15)
                .cd(6);
        StackedDeck.update().passive("CD待ち時間が低下し、攻撃速度が増加し、通常攻撃4回毎に追加魔法DMを与える。");
        Destiny.update()
                .active("一定時間すべての敵Champion(ステルス中のChampion含む)の視界を得る。効果中に再度使用で「Gate」が発動する。効果中は敵Championの頭上にアイコンが表示される。効果時間: 6/8/10s消費MN: 150/125/100 CD: 150/135/120s Range: 無限[Gate]2秒間移動・攻撃が不可能になった後、指定した地点にワープする。")
                .mana(150, -25)
                .cd(150, -15)
                .range(5500);

        /** Twitch */
        DeadlyVenom.update().passive("通常攻撃時に毒を付与し、毎秒Trueダメージを与える。毒は6回までスタックし、6秒持続する。レベル1、6、11、16で毎秒ダメージが増加する。");
        Ambush.update()
                .active("使用から1.25秒後にステルス状態になる。ステルス状態ではTwitchの移動速度が20%増加し、ステルスを解除すると5秒間攻撃速度が増加する。ステルス準備中に攻撃を行うかダメージを受けると、ステルス状態になるのに再度1.25秒必要になる。ステルス準備開始から5秒経過するとダメージを受けていてもステルス状態になる。")
                .mana(60);
        VenomCask.update()
                .active("指定地点に毒の入った瓶を投げつけ、範囲内の敵ユニットにスロー(3s)と毒を2スタック分与える。また、指定した地点の視界を得る。")
                .mana(50)
                .cd(13, -1)
                .range(950);
        Expunge.update().active("毒をスタックされている近くの敵ユニットに物理DMを与える。ダメージはスタック数に比例し増加する。").mana(50, 10).cd(12, -1).range(1200);
        SprayandPray.update()
                .active("7秒間Twitchの攻撃力が増加し射程が850に長くなり、通常攻撃が敵ユニットを貫通するようになる。対象との直線上にいる敵ユニットにもダメージと毒スタックを与える。ダメージは敵に当たるごとに20%減少する。最小で40%。")
                .mana(100, 25)
                .cd(120, -10);

        /** Udyr */
        MonkeysAgility.update()
                .passive("スキルを使用する度に攻撃速度が10%増加し、ARとMRが4%増加する。この効果は5秒間持続し、3回までスタックする。また、スキルを使用するとその他のCD待ちでないスキルが1秒間のCDになる。");
        TigerStance.update()
                .passive("Persistent Effect:Udyrの攻撃速度が増加する。増加攻撃速度: 20/25/30/35/40%Activation:5秒間Udyrの攻撃速度が増加する(Persistent Effectと重複)。また、次の通常攻撃に追加魔法DMを付与する。このダメージは2秒かけて与えられる。建物には無効。")
                .mana(55, -5)
                .cd(6);
        TurtleStance.update()
                .passive("Persistent Effect:通常攻撃でクリティカルが発生しなくなるが、通常攻撃で与えたダメージの一定割合のHPとMNが回復する。回復HP: 10/12/14/16/18% 回復MN: 5/6/7/8/9%Activation:自身に5秒間持続するシールドを付与しダメージを軽減する。")
                .mana(55, -5)
                .cd(6);
        BearStance.update()
                .passive("Persistent Effect:通常攻撃にスタン(1s)が付与される。この効果は同一の対象に6秒に1度しか発動しない。Activation:一定時間移動速度が増加する。")
                .mana(55, -5)
                .cd(6);
        PhoenixStance.update()
                .passive("Persistent Effect:通常攻撃を3回行うごとに火を吹き前方の敵ユニットに魔法DMを与える。魔法DM: 40/80/120/160/200 (+0.25)Activation:5秒間周囲の敵ユニットに毎秒魔法DMを与える。またその間は攻撃力とAPが増加する。")
                .mana(55, -5)
                .cd(6);

        /** Urgot */
        ZaunTouchedBoltAugmenter.update()
                .passive("通常攻撃またはAcid Hunterでダメージを与えた対象に、与えるダメージを15%低下するDebuffを付与する。この効果は2.5秒間持続する。");
        AcidHunter.update()
                .active("指定方向にミサイルを飛ばし当たった敵ユニットに物理DMを与える。Noxian Corrosive Chargeの効果を受けている敵ユニットの近くを指定して使用すると、その敵ユニット目掛けてミサイルが飛んでいく。")
                .mana(40)
                .cd(2)
                .range(1000);
        TerrorCapacitor.update()
                .active("自身にシールドを付与し、7秒間ダメージを軽減する。シールドが残っている間は通常攻撃とAcid Hunterにスロー(1s)が付与される。")
                .mana(55, 5)
                .cd(16, -1);
        NoxianCorrosiveCharge.update()
                .active("指定範囲に爆弾を飛ばし当たった敵ユニットに5秒間かけて物理DMを与え、その間対象のARを下げる。また指定地点の視界を得る。")
                .mana(50, 5)
                .cd(15, -1)
                .range(900);
        HyperKineticPositionReverser.update()
                .active("対象の敵Championにサプレッションを付与しUrgotのAR,MRが5秒間上昇し、1s詠唱後に敵Championと自分の位置を入れ替える。入れ替わった後は敵Championにスロー(40%,3s)を与える。サプレッションはUrgotが詠唱している間持続する。")
                .mana(120)
                .cd(120)
                .range(550, 150);

        /** Varus */
        LivingVengeance.update()
                .passive("敵ユニットを倒すと3秒間攻撃速度が20%増加する。敵Championをキル/アシストした場合は効果時間が6秒、増加攻撃速度が40%に増加する。この効果はスタックしない。");
        PiercingArrow.update()
                .active("最初にスキルを使用すると狙いを付ける。この間は通常攻撃や他のスキルを使用できなくなり、Varusの移動速度が20%低下するが、狙いを付けている間は徐々にこのスキルのダメージと射程距離が増加していく(2秒で最大)。再度このスキルを使用することで指定方向に貫通する矢を放ち、当たった敵ユニットに物理DMを与える。ダメージは敵に当たるごとに15%減少する。最小で33%。狙いを付けて4秒間経過した場合はこのスキルは失敗しCDになるが、消費したマナの半分が回復する。")
                .mana(70, 5)
                .cd(16, -2)
                .range(850);
        BlightedQuiver.update()
                .passive("通常攻撃に追加魔法DMと6秒間持続する疫病が付与される。疫病は3回までスタックする。疫病のスタックが付与されている敵ユニットにVarusの他のスキルが命中した場合、疫病のスタックを消費して対象の最大HPに比例した魔法DMを与える。");
        HailOfArrows.update()
                .active("指定地点に矢の雨を放ち、範囲内の敵ユニットに物理DMを与える。指定地点は4秒間呪われ、範囲内の敵ユニットにスローとHP回復量-50%を付与する。")
                .mana(80)
                .cd(18, -2)
                .range(925);
        ChainOfCorruption.update()
                .active("指定方向に腐敗の蔓を投げつけ、当たった敵Championに魔法DMとSnare(2s)を与える。当たった敵Championからは徐々に腐敗が広がり、腐敗に触れた敵Championにも蔓が当たった敵Championと同様の効果を与える。")
                .mana(120)
                .cd(120, -15)
                .range(1075);

        /** Vayne */
        NightHunter.update().passive("敵Championに向かって移動する際に移動速度が30増加する。");
        Tumble.update().active("指定地点にローリングし、次の通常攻撃のダメージが上昇する。6秒間攻撃を行わないとCDになる。").mana(40).cd(6, -1);
        SilverBolts.update().passive("同じターゲットに3回連続して通常攻撃またはスキルで攻撃すると、ターゲットの最大HPに比例したTrue Damageを与える。");
        Condemn.update()
                .active("対象の敵ユニットをヘビークロスボウで狙撃し物理DMとノックバックを与える。ノックバックした敵が壁等に当たると追加で物理DMとスタン(1.5s)を与える。")
                .mana(90)
                .cd(20, -2)
                .range(450);
        FinalHour.update()
                .active("一定時間Vayneの攻撃力が上昇し、Tumbleのローリングにステルス(1s)が付与され、Night Hunterの移動速度増加が3倍になる。")
                .mana(80)
                .cd(70);

        /** Veigar */
        Equilibrium.update().passive("manaを1%失う毎に自身のmana回復量が1%上昇する。");
        BalefulStrike.update()
                .passive("敵Championを倒すとAPが増加する。増加AP: 1/2/3/4/5")
                .active("対象の敵ユニットに魔法DMを与える。このスキルでLHを取るとAPが1増加する。対象が敵Champion/SiegeまたはSuperMinion/Buffを持った中立クリープの場合、増加値は2倍(+2)になる。")
                .mana(60, 5)
                .cd(8, -1)
                .range(650);
        DarkMatter.update()
                .active("指定地点に1.2秒後に隕石を降らし、当たった敵ユニットに魔法DMを与える。また隕石が落下するまでの間、指定地点の視界を得る。")
                .mana(70, 10)
                .cd(10)
                .range(900);
        EventHorizon.update().active("指定範囲に3秒間魔法陣を呼び出し、魔法陣の縁に触れた敵ユニットにスタンを与える。").mana(80, 10).cd(20, -1).range(650);
        PrimordialBurst.update()
                .active("対象の敵Championに魔法DMを与える。敵ChampionのAPに比例してダメージが増加する。")
                .mana(125, 50)
                .cd(130, -20)
                .range(650);

        /** Vi */
        BlastShield.update()
                .passive("敵ユニットにスキルでダメージを与えると、3秒間自身に最大HPの10%のダメージを軽減するシールドが展開される。レベル1/7/12でCDが減少する。")
                .cd(18, -5);
        VaultBreaker.update()
                .active("発動すると自身の移動速度が15%減少し、このスキルのダメージと射程が徐々に増加する(1.25sで最大)。再度使用で指定した方向へとダッシュし、命中した全ての敵ユニットに物理DMを与える。ダッシュ中に敵Championに衝突するとその時点で停止し、対象をノックバックさせる。このスキルにはDenting Blowsの効果が適用され、Minionや中立クリープに与えるダメージは75%に減少する。")
                .mana(50, 10)
                .cd(18, -2.5)
                .range(50);
        DentingBlows.update().passive("同一対象に3回連続して通常攻撃を行うと、対象の最大HPに比例した追加物理DMを与えると共に4秒間対象のARを20%減少させ、自身の攻撃速度が4秒間増加する。");
        ExcessiveForce.update()
                .active("チャージを1つ消費することで、次の通常攻撃のダメージが増加し、対象とその後方扇形範囲にいる敵ユニットにもダメージを与える範囲攻撃になる。チャージは一定時間ごとに増加し、最大2つまでスタックされる。")
                .mana(60)
                .cd(1)
                .range(600);
        AssaultandBattery.update()
                .active("対象の敵Championに突撃し、物理DMと打ち上げ(1.25s)を与える。一連の動作中は自身が受けるCCを無効化し、また対象のChampion以外でViに触れた敵ユニットには75%のダメージを与え、左右に吹き飛ばす。")
                .mana(100, 25)
                .cd(130, -25)
                .range(700);

        /** Viktor */
        EvolvingTechnology.update()
                .passive("Viktorは最初からHex Coreという、自身のステータスとスキルの効果を強化するアイテムを所持している。Hex Coreは1度だけショップで1000Gを消費して以下の３通りのいずれかにアップグレードすることが出来る。Hex CoreはViktorのアイテムスロットを1つ占有し、売却することは出来ない。Hex Core : +3 ability power per levelAugment: Power+3 ability power per level、+220 health、+6 health regen per 5sを得る。また、Power Transfer使用・命中時に移動速度が3秒間30%増加する。Augment: Gravity+3 ability power per level、+200 mana、+10% cooldown reduction、+5 mana regen per 5sを得る。また、Gravity Fieldの射程が30%増加する。Augment: Death+3 ability power per level、+45 ability powerを得る。また、Death Rayにダメージの30%分の追加魔法DMが付与される。このダメージは4秒間かけて与える。");
        PowerTransfer.update()
                .active("対象の敵ユニットに魔法DMを与え、ダメージの40%をシールドとして得る。シールドは3秒間持続する。")
                .mana(45, 5)
                .cd(9, -1)
                .range(600);
        GravityField.update()
                .active("0.25秒詠唱後、指定範囲に4秒間持続する重力束縛装置を呼び出し、範囲内の敵ユニットにスローを与え、0.5秒毎にスタックを付与する。スタックが3溜まった敵ユニットにはスタン(1.5s)を与える。")
                .mana(65)
                .cd(17, -1)
                .range(625);
        DeathRay.update()
                .active("指定地点から指定方向にビームを発射し、ビームが通過する線上の敵ユニットに魔法DMを与える。また、ビームが通過した地点の視界を得る。")
                .mana(70, 10)
                .cd(13, -1)
                .range(700);
        ChaosStorm.update()
                .active("指定地点に7秒間持続する特異点を呼び出し、範囲内の敵ユニットに魔法DMとサイレンス(0.5s)を与える。特異点は周囲の敵ユニットに毎秒魔法DMを与え、また近くにいる敵Championを自動的に追尾する。このスキルがActiveの間に再度地点を指定することで、特異点を指定した地点に手動で移動させる事が出来る。")
                .mana(125, 50)
                .cd(120)
                .range(700);

        /** Vladimir */
        CrimsonPact.update()
                .passive(BounusHealth + "に比例して{1}を、" + AP + "に比例して{2}を得る。")
                .variable(1, AP, 0, 0, amplify(BounusHealth, 0.025))
                .variable(2, Health, 0, 0, ap(1.4));
        Transfusion.update()
                .active("対象の敵ユニットに{1}を与え、{2}する。")
                .variable(1, MagicDamage, 90, 35, ap(0.6))
                .variable(2, RestoreHealth, 15, 10, ap(0.25))
                .cd(10, -1.5)
                .range(600);
        SanguinePool.update()
                .active("Vladimirが2秒間血の海に沈む。その間はターゲットされなくなり、{1}内にいる敵ユニットに0.5秒毎に{2}と{3}間の{4}を与え続ける。また、与えたダメージの12.5%Healthが回復する。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 20, 13.75, amplify(BounusHealth, 0.00375))
                .variable(3, Time, 1)
                .variable(4, Slow, 40)
                .cost(CurrentHealth, 20, 0)
                .cd(26, -3);
        TidesOfBlood.update()
                .active("{1}の敵ユニットに{2}を与える。使用する度にスタックが増加し、1スタックにつきこのスキルの基礎魔法DMとHPコストが25%増加し、{4}と{3}を得るく(最大4スタック)。スタックは10秒増加が無いと0になる。このスキルは周囲に敵ユニットがいなくても使用可能。")
                .variable(1, Radius, 0)
                .variable(2, MagicDamage, 60, 25, ap(0.45))
                .variable(3, HregRatio, 4, 1)
                .variable(4, RestoreHealthRatio, 4, 1)
                .cost(Health, 30, 10)
                .cd(4.5)
                .range(620);
        Hemoplague.update()
                .active("指定地点の{1}の敵ユニットに疫病を付与し、その敵ユニットは5秒間受けるダメージが12%増加する。効果終了時に{2}を与える。ダメージ増加効果のため実際には{3}を与える。")
                .variable(1, Radius, 300)
                .variable(2, MagicDamage, 150, 100, ap(0.7))
                .variable(3, MagicDamage, 168, 112, ap(0.784))
                .cd(150, -15)
                .range(700);

        /** Volibear */
        ChosenOftheStorm.update().passive("VolibearのHPが30%以下になったとき、6秒間かけて最大HPの30%を回復する。").cd(120);
        RollingThunder.update()
                .active("4秒間Volibearの移動速度が15%増加する。敵Championに向かって移動する場合は45%に増加する。また次の通常攻撃に追加物理DMを付与し、対象をVolibearの後ろに投げ飛ばす。4秒間攻撃を行わないとCDになる。")
                .mana(40)
                .cd(12, -1);
        Frenzy.update()
                .passive("通常攻撃でダメージを与える度にスタックが1増加し、スタック数に比例して攻撃速度が増加する(最大3スタック)。スタックは4秒持続する。増加攻撃速度(1スタック): 8/11/14/17/20%")
                .active("スタックが最大まで溜まった時のみ使用可能。対象の敵ユニットにVolibearの増加HPに比例した物理DMを与える。対象が失っているHP1%につきダメージが1%上昇する。")
                .mana(35)
                .cd(17)
                .range(400);
        MajesticRoar.update()
                .active("周囲の敵ユニットに魔法DMとスロー(3s)を与える。対象がMinionの場合、さらにFear(3s)を与える。")
                .mana(60, 5)
                .cd(11)
                .range(425);
        ThunderClaws.update()
                .active("12秒間Volibearが通常攻撃した対象に雷を放ち魔法DMを与える。雷は対象の付近の敵ユニット(敵Championを優先、範囲300)3体にも連鎖し同様のダメージを与える。建物を攻撃する時は効果は発生しない。")
                .mana(100)
                .cd(100, -10);

        /** Warwick */
        EternalThirst.update()
                .passive("通常攻撃に追加魔法DMとHP回復効果が付与され、対象にスタックを付与する。1スタックにつき追加魔法DMと回復効果が増加していく。スタックは4秒持続し、最大3つまでスタックされる。建物を攻撃した場合は無効。");
        HungeringStrike.update()
                .active("対象の敵ユニットに魔法DMを与え、与えたダメージの80%が回復する。魔法DM: 75/125/175/225/275 (+1.0)(対象がChampionの場合は次の計算式と比較し大きいほうとなる。")
                .mana(70, 10)
                .cd(10, -1)
                .range(400);
        HuntersCall.update().active("10秒間自身と近くの味方Championの攻撃速度を増加させる。").mana(35).cd(24, -2);
        BloodScent.update()
                .passive("n:範囲内にHPが50%以下の敵Championがいるとその視界を得て、Warwickの移動速度が増加する。このスキルで敵のステルスを看破する事はできず、ステルス中の敵Championの視界を得ることもできない。")
                .cd(4);
        InfiniteDuress.update()
                .active("対象の敵Championに突撃し、1.8秒かけて5回魔法DMを与える(0.36秒毎に1ヒット)。チャネリングが続いている間は対象にサプレッション(最大1.8s)を与え続け、WarwickのLSが30%増加する。このスキルは1ヒット毎にOn-Hit Effectsの影響を受ける。※ チャネリングスキル。チャネリングが中断されるか効果時間が過ぎるまで効果が持続する。")
                .mana(100, 25)
                .cd(90, -10)
                .range(700);

        /** Wukong */
        StoneSkin.update()
                .passive("Wukongの視界内(範囲1400)にいる敵Championの数に比例して、WukongのArmorとMagic Resistが増加する。レベル1、7、13で増加値が上昇する。");
        CrushingBlow.update()
                .active("次の通常攻撃の射程とダメージが増加し、対象のArmorを30%低下させる効果が付与される。Armor低下は3秒間持続する。")
                .mana(40)
                .cd(9, -1)
                .range(300);
        Decoy.update()
                .active("Wukongが1.5秒間ステルス状態になり、その間ユニットを通過できるようになる。同時にWukongがいた場所に分身(操作不可能)を作り出す。分身は1.5秒経過すると消滅し、その際に分身の周囲の敵に魔法DMを与える。")
                .mana(50, 5)
                .cd(18, -2);
        NimbusStrike.update()
                .active("対象の敵ユニットまでダッシュし物理DMを与える。対象の敵ユニットの近くにいる敵ユニット2体にもWukongの幻影が飛び、同様のダメージを与える。また、スキル使用後4秒間攻撃速度が上昇する。")
                .mana(45, 5)
                .cd(8)
                .range(625);
        Cyclone.update()
                .active("4秒間Wukongが回転する。回転中は近くにいる敵ユニットに0.5秒毎に物理DMと打ち上げ(1.5s)を与える(最大8hit)。打ち上げ効果は同一の対象に1度までしか発生しない。また、このスキルを使用してから0.5秒毎にWukongの移動速度が5%ずつ上昇していく(最大40%)。")
                .mana(100)
                .cd(120, -15);

        /** Xerath */
        AscendedForm.update().passive("APの15%分、ARが上昇する。");
        Arcanopulse.update()
                .active("0.75秒詠唱後指定方向にビームを放ち、直線状の敵ユニットすべてに魔法DMを与える。")
                .mana(65, 5)
                .cd(7, -0.5)
                .range(900, 400);
        LocusOfPower.update()
                .active("0.5秒詠唱後に移動が不可能になる代わりに、全てのスキルの射程が400増加し、Magic Penetrationが増加する。この効果は8秒経過するか、再度このスキルを使用する事で解除される。このスキルが解除された時に自身の移動速度が2秒間35%増加する。")
                .cd(20, -4);
        MageChains.update()
                .active("対象の敵ユニットに魔法DMとマーク(3s)を与える。マークがついている敵ユニットにXerathのスキルが命中した場合、マークを消費して対象にスタン(1.5s)を与える。")
                .mana(70, 5)
                .cd(12, -1)
                .range(600, 400);
        ArcaneBarrage.update()
                .active("地点を指定して0.5秒後に範囲内の敵ユニットに魔法DMを与える。このスキルは12秒の間、3回まで連続して使用できる(但し、一度使用する度に0.35秒のCDが発生する)。2〜3発目はマナコスト無しで使用可能。また、指定地点の視界を得る。")
                .mana(150, 30)
                .cd(80, -10)
                .range(900, 400);

        /** Xin Zhao */
        Challenge.update()
                .passive("通常攻撃または" + AudaciousCharge + "で指定した敵ユニットに{1}を与える。この効果はスタックせず、3秒間持続し、また1体の敵ユニットにしか発動しない。")
                .variable(1, ARReductionRatio, 15);
        ThreeTalonStrike.update()
                .active("次の3回の通常攻撃に{1}が追加され、3回目の攻撃で{2}を与える。効果中に通常攻撃を行う度に、このスキル以外のCDが1秒解消される。")
                .variable(1, PhysicalDamage, 15, 15, ad(0.2))
                .variable(2, Knockup, 1)
                .mana(30)
                .cd(9, -1);
        BattleCry.update()
                .passive("通常攻撃3回ごとに{1}する。")
                .variable(1, RestoreHealth, 26, 6, ap(0.7))
                .active("5秒間{2}増加する。")
                .variable(2, ASRatio, 40, 10)
                .mana(40)
                .cd(16, -1);
        AudaciousCharge.update()
                .active("対象の敵ユニットに突進し、{1}の敵ユニットに{2}と2秒間{3}を与える。")
                .variable(1, Radius, 225)
                .variable(2, MagicDamage, 70, 40, ap(0.6))
                .variable(3, Slow, 25, 5)
                .mana(70)
                .cd(13, -1)
                .range(600);
        CrescentSweep.update()
                .active("槍を振り回し{3}の敵ユニットに{1}と{2}を与え、このスキルを命中させた敵Championの数に比例して6秒間{4}と{5}を得る。" + Challenge + "効果中の敵ユニットに対しては" + Knockback + "は発動しない。")
                .variable(1, PhysicalDamage, 125, 100, bounusAD(1), amplify(TargetCurrentHealth, 0.15))
                .variable(2, Knockback, 0)
                .variable(3, Radius, 375)
                .variable(4, AR, 15, 5)
                .variable(5, MR, 15, 5)
                .mana(100)
                .cd(100, -10);

        /** Yorick */
        UnholyCovenant.update()
                .passive("(召喚中のGhoulsの数×5)%の被ダメージ軽減および通常攻撃のダメージ増加効果を得る。召喚したGhoulは5秒間持続し、また毎秒最大HPの20%が減少していく。同じ種類のGhoulを召喚した場合、先に召喚したGhoulが消滅する。ペット「Ghouls」HP: [YorickのHP × 35%] 攻撃力: [Yorickの攻撃力 × 35%]AR: 10 + (2 × Lv) MR: 20 + (2 × Lv)AS: 0.670 MS: 300/340/410/433 (レベル1、6、9、12で移動速度が上昇する。)【備考】任意の操作不可、スロー無効化、AoEスキルのダメージを50%低減。Ghoulsは敵ユニットの通行を妨げない（引っかからずにすり抜ける）。");
        OmenOfWar.update()
                .active("次の通常攻撃時のダメージが増加し、通常攻撃時と同時にSpectral Ghoulを召喚する。Spectral GhoulはYorickの他のGhoulと比べて攻撃力が高く、移動速度が速い。Spectral Ghoulが生存している間、Yorick自身の移動速度も上昇する。")
                .mana(40)
                .cd(9, -1);
        OmenOfPestilence.update()
                .active("指定範囲を爆発させ範囲内の敵ユニットに魔法DMとスロー(1.5s)を与え、同時にその地点にDecaying Ghoulを召喚する。Decaying Ghoulは近くの敵ユニットに継続的にスローを与える。")
                .mana(55, 5)
                .cd(12)
                .range(600);
        OmenOfFamine.update()
                .active("対象の敵ユニットに魔法DMを与え、与えたダメージの40%を回復し、対象の背後にRavenous Ghoulを召喚する。Ravenous Ghoulは、通常攻撃を行うたびにYorickのHPを回復する。回復量はRavenous Ghoulの攻撃力の半分となり、敵Championを攻撃した場合は回復量が2倍になる。")
                .mana(55, 5)
                .cd(10, -1)
                .range(550);
        OmenOfDeath.update()
                .active("対象の味方Champion一人の姿形を持ったRevenant(死霊)を召喚する（RまたはALT押しながら右クリックで任意の操作可能）。Revenantは10秒間持続し、対象の味方Championの一定割合の攻撃力を持つ。Revenantが生存している間に対象となった味方Championが死亡した場合、Revenantが消滅し、死亡した味方ChampionはHPとMNが最大の状態で蘇生される。蘇生した味方Championは10秒経過すると消滅する。消費MN: 100 CD: 120/105/90s Range: 900ペット「Revenant」攻撃力: 元になったChampの45/60/75%【備考】元になったChampionのステータス・一部アイテムとスキルの効果を引き継ぐ。")
                .mana(100)
                .cd(120, -15)
                .range(900);

        /** Zed */
        ContemptforTheWeak.update()
                .passive("HPが50%以下の敵ユニットへの通常攻撃に対象の最大HPに比例した追加魔法DMを付与する。同一の対象には10秒に一度しか発動しない。レベル1、7、17でDMが上昇する。");
        RazorShuriken.update()
                .active("Zedと「影」から指定方向に貫通する手裏剣を飛ばし、当たった敵ユニットに物理DMを与える。手裏剣は一度敵ユニットに当たるとそれ以降の敵ユニットには80%のDMを与える。物理DM: 75/110/145/180/215 + [増加攻撃力 × 100%]Living Shadow:Zedと「影」が同一の対象に手裏剣を命中させた場合、「影」が与えるDMは半分になり「気」が回復する。")
                .cd(6)
                .range(900);
        LivingShadow.update()
                .passive("{1}を得る。")
                .variable(1, AD, 0, 0, amplify(BounusAD, 0.05, 0.05))
                .active("Zedの「影」が指定方向にダッシュし、4秒間その場に留まる。再度このスキルを使用するとZedと「影」の位置が入れ替わる。「影」はZedが通常スキルを使用すると同時に同じスキルを使用する。この時スキルがZedのスキルと同一の敵ユニットに命中した場合、「気」が回復する。回復効果はスキル1回毎に1度のみ発動する。")
                .cd(22, -1.5)
                .range(550);
        ShadowSlash.update()
                .active("Zedと「影」から衝撃波を発生させ、周囲の敵ユニットに物理DMを与える。ZedのShadow Slashは敵ユニットに当たる度にLiving ShadowのCDを1秒解消させる。「影」のShadow Slashはダメージと共に周囲の敵ユニットにスロー(1.5s)を与える。物理DM: 60/90/120/150/180 + [増加攻撃力 × 90%]スロー: 20/25/30/35/40%Living Shadow:Zedと「影」が同一の対象にShadow Slashを命中させた場合、DMは重複しないがスローの効果が上昇し、「気」が回復する。")
                .cd(3)
                .range(290);
        DeathMark.update()
                .active("対象の敵Championにダッシュしマークを付与する。ダッシュ中はターゲット不可状態になる。また対象の背後に4秒間持続する「影」を召喚する。再度このスキルを使用するとZedと「影」の位置が入れ替わる。付与から3秒後にマークは消費され、対象にマークが付与されている間にZedと「影」が与えた物理DMと魔法DMの合計に比例した物理DMを与える。")
                .cd(120, -20)
                .range(625);

        /** Ziggs */
        ShortFuse.update().passive("12秒毎に通常攻撃に追加魔法DMが付与される。Ziggsがスキルを使う度にCDが4秒低減される。建物に対しては150%のDMを与える。").cd(12);
        BouncingBomb.update()
                .active("指定地点に跳ねながら転がる爆弾を投げ、爆発時に周囲の敵ユニットに魔法DMを与える。敵に当たらなかった場合には投げた方向に2回までバウンドする。")
                .mana(50, 10)
                .cd(6, -0.5)
                .range(850);
        SatchelCharge.update()
                .active("指定地点に火薬を投げ、爆発時に周囲の敵ユニットに魔法DMを与え、ノックバックさせる。Ziggsが範囲内にいた場合は自分もノックバックを受ける(Ziggsにダメージは無し)。火薬は4秒経つか、スキルを再度使用すると爆発する。また火薬は視界を確保する。")
                .mana(65)
                .cd(26, -2)
                .range(1000);
        HexplosiveMinefield.update()
                .active("指定範囲に11個の近接地雷を円形にばら撒き、敵ユニットが地雷に触れると魔法DMとスロー(1.5s)を与える。同ユニットが2個目以降に踏む地雷のダメージは本来の40%となる。地雷は爆発するか10秒経つと消滅する。")
                .mana(70, 10)
                .cd(16)
                .range(900);
        MegaInfernoBomb.update()
                .active("指定地点に巨大な爆弾を投下し、範囲内の敵ユニットに魔法DMを与える。爆発の中心点から離れた位置にいる敵ユニットには80%のDMを与える。")
                .mana(100)
                .cd(120, -15)
                .range(5300);

        /** Zilean */
        HeightenedLearning.update().passive("すべての味方Championが取得する{1}増加する。").variable(1, ExperimentRatio, 8);
        TimeBomb.update()
                .active("対象のユニットに爆弾をつけ、4秒後に対象(味方ユニットの場合ダメージ無し)とその周辺{1}の敵ユニットに{2}を与える。対象が死亡した場合は即座に爆発する。")
                .variable(1, Radius, 330)
                .variable(2, MagicDamage, 90, 55, ap(0.9))
                .mana(70, 15)
                .cd(10)
                .range(700);
        Rewind.update().active(Rewind + "以外のスキルのCDを10秒解消する。").mana(50).cd(18, -3);
        TimeWarp.update()
                .active("味方Championに使用した場合は{2}間{1}増加し、敵Championに使用した場合は{2}間{3}を与える。")
                .variable(1, MSRatio, 55)
                .variable(2, Time, 2.5, 0.75)
                .variable(3, Slow, 55)
                .mana(80)
                .cd(20)
                .range(700);
        ChronoShift.update()
                .active("対象の味方Championが使用してから7秒以内に死亡した場合、2秒後にその場で{1}して復活する。")
                .variable(1, RestoreHealth, 600, 150, ap(2))
                .mana(125, 25)
                .cd(180)
                .range(900);

        /** Zyra */
        RiseOftheThorns.update()
                .passive("死亡すると2秒後にその場で植物に変形し、指定方向に一度だけ貫通する光線を放つことができる。光線に当たった敵ユニットに{1}を与える。")
                .variable(1, TrueDamage, 80, 0, amplify(Lv, 20))
                .range(1500);
        DeadlyBloom.update()
                .active("地面から棘を出現させ、指定範囲内の敵ユニットに{1}を与える。種にHitした場合Thorn Spitterに成長し、{3}の敵を自動攻撃して{2}を与える。Thorn Spitterは10秒間持続する。")
                .variable(1, MagicDamage, 75, 40, ap(0.6))
                .variable(2, MagicDamage, 26, 0, amplify(Lv, 6), ap(0.6))
                .variable(3, Radius, 650)
                .mana(75, 5)
                .cd(7, -0.5)
                .range(825);
        RampantGrowth.update()
                .passive("{1}を得る。")
                .variable(1, CDR, 4, 4)
                .active("指定地点に30秒持続する種を植える。他のスキルを種に当てることで成長させることができる。敵Championが種を踏んだ場合、視界を2秒間得る。{2}毎にチャージが1つ増加し最大2つまでチャージされる。種が植物に成長し、同一ユニットに複数の植物がDMを与える場合、2体目以降は50%のダメージを与える。")
                .variable(2, CDRAwareTime, 17, -1)
                .range(825)
                .cost(Charge, 1, 0);
        GraspingRoots.update()
                .active("指定方向に蔓を放ち、当たった全ての敵ユニットに{1}と{2}を与える。種にHitした場合Vine Lasherに成長し、{3}の敵を自動攻撃して{4}と2秒間{5}を与える。Vine Lasherは10秒間持続する。")
                .variable(1, MagicDamage, 60, 35, ap(0.5))
                .variable(2, Snare, 0.75, 0.25)
                .variable(3, Radius, 250)
                .variable(4, MagicDamage, 26, 0, amplify(Lv, 6), ap(0.2))
                .variable(5, Slow, 30)
                .mana(70, 5)
                .cd(14, -1)
                .range(1100);
        Stranglethorns.update()
                .active("指定地点に藪を召還し、{1}の全ての敵に{2}を与え、2秒後に{3}。成長した植物にHitした場合、その植物の攻撃速度が50%増加する。")
                .variable(1, Radius, 700)
                .variable(2, MagicDamage, 180, 85, ap(0.75))
                .variable(3, Knockup, 0)
                .mana(100, 20)
                .cd(130, -10)
                .range(700);

    }
}
