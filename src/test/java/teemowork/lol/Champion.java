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

import static teemowork.lol.Skill.*;

/**
 * @version 2013/01/27 9:55:21
 */
public enum Champion {
    /** The champion name. */
    Ahri("Ahri", EssenceTheft, OrbOfDeception, FoxFire, Charm, SpiritRush),

    /** The champion name. */
    Akali("Akali", TwinDisciplines, MarkOftheAssassin, TwilightShroud, CrescentSlash, ShadowDance),

    /** The champion name. */
    Alistar("Alistar", Trample, Pulverize, Headbutt, TriumphantRoar, UnbreakableWill),

    /** The champion name. */
    Amumu("Amumu", CursedTouch, BandageToss, Despair, Tantrum, CurseOftheSadMummy),

    /** The champion name. */
    Anivia("Anivia", Rebirth, FlashFrost, Crystalize, Frostbite, GlacialStorm),

    /** The champion name. */
    Annie("Annie", Pyromania, Disintegrate, Incinerate, MoltenShield, SummonTibbers),

    /** The champion name. */
    Ashe("Ashe", Focus, FrostShot, Volley, Hawkshot, EnchantedCrystalArrow),

    /** The champion name. */
    Blitzcrank("Blitzcrank", ManaBarrier, RocketGrab, Overdrive, PowerFist, StaticField),

    /** The champion name. */
    Brand("Brand", Blaze, Sear, PillarOfFlame, Conflagration, Pyroclasm),

    /** The champion name. */
    Caitlyn("Caitlyn", Headshot, PiltoverPeacemaker, YordleSnapTrap, CaliberNet, AceinTheHole),

    /** The champion name. */
    Cassiopeia("Cassiopeia", DeadlyCadence, NoxiousBlast, Miasma, TwinFang, PetrifyingGaze),

    /** The champion name. */
    ChoGath("Cho'Gath", Carnivore, Rupture, FeralScream, VorpalSpikes, Feast),

    /** The champion name. */
    Corki("Corki", HextechShrapnelShells, PhosphorusBomb, Valkyrie, GatlingGun, MissileBarrage),

    /** The champion name. */
    Darius("Darius", Hemorrhage, Decimate, CripplingStrike, Apprehend, NoxianGuillotine),

    /** The champion name. */
    Diana("Diana", MoonsilverBlade, CrescentStrike, PaleCascade, Moonfall, LunarRush),

    /** The champion name. */
    DrMundo("Dr.Mundo", AdrenalineRush, InfectedCleaver, BurningAgony, Masochism, Sadism),

    /** The champion name. */
    Draven("Draven", WickedBlades, SpinningAxe, BloodRush, StandAside, WhirlingDeath),

    /** The champion name. */
    Elise("Elise", SpiderSwarm, NeurotoxinVenomousBite, VolatileSpiderlingSkitteringFrenzy, CocoonRappel,
            SpiderFormHumanForm),

    /** The champion name. */
    Evelynn("Evelynn", ShadowWalk, HateSpike, DarkFrenzy, Ravage, AgonysEmbrace),

    /** The champion name. */
    Ezreal("Ezreal", RisingSpellForce, MysticShot, EssenceFlux, ArcaneShift, TrueshotBarrage),

    /** The champion name. */
    Fiddlesticks("Fiddlesticks", Dread, Terrify, Drain, DarkWind, Crowstorm),

    /** The champion name. */
    Fiora("Fiora", Duelist, Lunge, Riposte, BurstOfSpeed, BladeWaltz),

    /** The champion name. */
    Fizz("Fizz", NimbleFighter, UrchinStrike, SeastoneTrident, PlayfulTrickster, ChumTheWaters),

    /** The champion name. */
    Galio("Galio", RunicSkin, ResoluteSmite, Bulwark, RighteousGust, IdolOfDurand),

    /** The champion name. */
    Gangplank("Gangplank", GrogSoakedBlade, Parrrley, RemoveScurvy, RaiseMorale, CannonBarrage),

    /** The champion name. */
    Garen("Garen", Perseverance, DecisiveStrike, Courage, Judgment, DemacianJustice),

    /** The champion name. */
    Gragas("Gragas", HappyHour, BarrelRoll, DrunkenRage, BodySlam, ExplosiveCask),

    /** The champion name. */
    Graves("Graves", TrueGrit, Buckshot, Smokescreen, Quickdraw, CollateralDamage),

    /** The champion name. */
    Hecarim("Hecarim", Warpath, Rampage, SpiritOfDread, DevastatingCharge, OnslaughtOfShadows),

    /** The champion name. */
    Heimerdinger("Heimerdinger", TechmaturgicalRepairBots, H28GEvolutionTurret, HextechMicroRockets,
            CH1ConcussionGrenade, UPGRADE),

    /** The champion name. */
    Irelia("Irelia", IonianFervor, Bladesurge, HitenStyle, EquilibriumStrike, TranscendentBlades),

    /** The champion name. */
    Janna("Janna", Tailwind, HowlingGale, Zephyr, EyeOfTheStorm, Monsoon),

    /** The champion name. */
    JarvanIV("Jarvan IV", MartialCadence, DragonStrike, GoldenAegis, DemacianStandard, Cataclysm),

    /** The champion name. */
    Jax("Jax", RelentlessAssault, LeapStrike, Empower, CounterStrike, GrandmastersMight),

    /** The champion name. */
    Jayce("Jayce", HextechCapacitor, ToTheSkiesShockBlast, LightningFieldHyperCharge, ThunderingBlowAccelerationGate,
            TransformMercuryCannonTransformMercuryHammer),

    /** The champion name. */
    Karma("Karma", InnerFlame, HeavenlyWave, SpiritBond, SoulShield, Mantra),

    /** The champion name. */
    Karthus("Karthus", DeathDefied, LayWaste, WallOfPain, Defile, Requiem),

    /** The champion name. */
    Kassadin("Kassadin", VoidStone, NullSphere, NetherBlade, ForcePulse, Riftwalk),

    /** The champion name. */
    Katarina("Katarina", Voracity, BouncingBlade, SinisterSteel, Shunpo, DeathLotus),

    /** The champion name. */
    Kayle("Kayle", HolyFervor, Reckoning, DivineBlessing, RighteousFury, Intervention),

    /** The champion name. */
    Kennen("Kennen", MarkOftheStorm, ThunderingShuriken, ElectricalSurge, LightningRush, SlicingMaelstrom),

    /** The champion name. */
    KhaZix("Kha'Zix", UnseenThreat, TasteTheirFear, VoidSpike, Leap, VoidAssault),

    /** The champion name. */
    KogMaw("Kog'Maw", IcathianSurprise, CausticSpittle, BioArcaneBarrage, VoidOoze, LivingArtillery),

    /** The champion name. */
    LeBlanc("LeBlanc", MirrorImage, SigilOfSilence, Distortion, EtherealChains, Mimic),

    /** The champion name. */
    LeeSin("Lee Sin", Flurry, SonicWaveResonatingStrike, SafeguardIronWill, TempestCripple, DragonsRage),

    /** The champion name. */
    Leona("Leona", Sunlight, ShieldOfDaybreak, Eclipse, ZenithBlade, SolarFlare),

    /** The champion name. */
    Lulu("Lulu", PixFaerieCompanion, Glitterlance, Whimsy, HelpPix, WildGrowth),

    /** The champion name. */
    Lux("Lux", Illumination, LightBinding, PrismaticBarrier, LucentSingularity, FinalSpark),

    /** The champion name. */
    Malphite("Malphite", GraniteShield, SeismicShard, BrutalStrikes, GroundSlam, UnstoppableForce),

    /** The champion name. */
    Malzahar("Malzahar", SummonVoidling, CallOftheVoid, NullZone, MaleficVisions, NetherGrasp),

    /** The champion name. */
    Maokai("Maokai", SapMagic, ArcaneSmash, TwistedAdvance, SaplingToss, VengefulMaelstrom),

    /** The champion name. */
    MasterYi("Master Yi", DoubleStrike, AlphaStrike, Meditate, WujuStyle, Highlander),

    /** The champion name. */
    MissFortune("Miss Fortune", Strut, DoubleUp, ImpureShots, MakeItRain, BulletTime),

    /** The champion name. */
    Mordekaiser("Mordekaiser", IronMan, MaceOfSpades, CreepingDeath, SiphonOfDestruction, ChildrenOftheGrave),

    /** The champion name. */
    Morgana("Morgana", SoulSiphon, DarkBinding, TormentedSoil, BlackShield, SoulShackles),

    /** The champion name. */
    Nami("Nami", SurgingTides, AquaPrison, EbbandFlow, TidecallersBlessing, TidalWave),

    /** The champion name. */
    Nasus("Nasus", SoulEater, SiphoningStrike, Wither, SpiritFire, FuryOftheSands),

    /** The champion name. */
    Nautilus("Nautilus", StaggeringBlow, DredgeLine, TitansWrath, Riptide, DepthCharge),

    /** The champion name. */
    Nidalee("Nidalee", Prowl, JavelinTossTakedown, BushwhackPounce, PrimalSurgeSwipe, AspectOfTheCougar),

    /** The champion name. */
    Nocturne("Nocturne", UmbraBlades, Duskbringer, ShroudOfDarkness, UnspeakableHorror, Paranoia),

    /** The champion name. */
    Nunu("Nunu", Visionary, Consume, BloodBoil, IceBlast, AbsoluteZero),

    /** The champion name. */
    Olaf("Olaf", BerzerkerRage, Undertow, ViciousStrikes, RecklessSwing, Ragnarok),

    /** The champion name. */
    Orianna("Orianna", ClockworkWindup, CommandAttack, CommandDissonance, CommandProtect, CommandShockwave),

    /** The champion name. */
    Pantheon("Pantheon", AegisProtection, SpearShot, AegisOfZeonia, HeartseekerStrike, GrandSkyfall),

    /** The champion name. */
    Poppy("Poppy", ValiantFighter, DevastatingBlow, ParagonOfDemacia, HeroicCharge, DiplomaticImmunity),

    /** The champion name. */
    Rammus("Rammus", SpikedShell, Powerball, DefensiveBallCurl, PuncturingTaunt, Tremors),

    /** The champion name. */
    Renekton("Renekton", ReignOfAnger, CullTheMeek, RuthlessPredator, SliceandDice, Dominus),

    /** The champion name. */
    Rengar("Rengar", UnseenPredator, Savagery, BattleRoar, BolaStrike, ThrillOftheHunt),

    /** The champion name. */
    Riven("Riven", RunicBlade, BrokenWings, KiBurst, Valor, BladeOftheExile),

    /** The champion name. */
    Rumble("Rumble", JunkyardTitan, Flamespitter, ScrapShield, ElectroHarpoon, TheEqualizer),

    /** The champion name. */
    Ryze("Ryze", ArcaneMastery, Overload, RunePrison, SpellFlux, DesperatePower),

    /** The champion name. */
    Sejuani("Sejuani", Frost, ArcticAssault, NorthernWinds, Permafrost, GlacialPrison),

    /** The champion name. */
    Shaco("Shaco", Backstab, Deceive, JackInTheBox, TwoShivPoison, Hallucinate),

    /** The champion name. */
    Shen("Shen", KiStrike, VorpalBlade, Feint, ShadowDash, StandUnited),

    /** The champion name. */
    Shyvana("Shyvana", FuryOftheDragonborn, TwinBite, Burnout, FlameBreath, DragonsDescent),

    /** The champion name. */
    Singed("Singed", EmpoweredBulwark, PoisonTrail, MegaAdhesive, Fling, InsanityPotion),

    /** The champion name. */
    Sion("Sion", FeelNoPain, CrypticGaze, DeathsCaress, Enrage, Cannibalism),

    /** The champion name. */
    Sivir("Sivir", FleetOfFoot, BoomerangBlade, Ricochet, SpellShield, OnTheHunt),

    /** The champion name. */
    Skarner("Skarner", Energize, CrystalSlash, CrystallineExoskeleton, Fracture, Impale),

    /** The champion name. */
    Sona("Sona", PowerChord, HymnOfValor, AriaOfPerseverance, SongOfCelerity, Crescendo),

    /** The champion name. */
    Soraka("Soraka", Consecration, Starcall, AstralBlessing, Infuse, Wish),

    /** The champion name. */
    Swain("Swain", CarrionRenewal, Decrepify, Nevermove, Torment, RavenousFlock),

    /** The champion name. */
    Syndra("Syndra", Transcendent, DarkSphere, ForceOfWill, ScatterTheWeak, UnleashedPower),

    /** The champion name. */
    Talon("Talon", Mercy, NoxianDiplomacy, Rake, Cutthroat, ShadowAssault),

    /** The champion name. */
    Taric("Taric", Gemcraft, Imbue, Shatter, Dazzle, Radiance),

    /** The champion name. */
    Teemo("Teemo", Camouflage, BlindingDart, MoveQuick, ToxicShot, NoxiousTrap),

    /** The champion name. */
    Thresh("Thresh", Damnation, DeathSentence, DarkPassage, Flay, TheBox),

    /** The champion name. */
    Tristana("Tristana", DrawaBead, RapidFire, RocketJump, ExplosiveShot, BusterShot),

    /** The champion name. */
    Trundle("Trundle", Decompose, RabidBite, Contaminate, PillarOfFilth, Agony),

    /** The champion name. */
    Tryndamere("Tryndamere", BattleFury, Bloodlust, MockingShout, SpinningSlash, UndyingRage),

    /** The champion name. */
    TwistedFate("Twisted Fate", LoadedDice, WildCards, PickACard, StackedDeck, Destiny),

    /** The champion name. */
    Twitch("Twitch", DeadlyVenom, Ambush, VenomCask, Expunge, SprayandPray),

    /** The champion name. */
    Udyr("Udyr", MonkeysAgility, TigerStance, TurtleStance, BearStance, PhoenixStance),

    /** The champion name. */
    Urgot("Urgot", ZaunTouchedBoltAugmenter, AcidHunter, TerrorCapacitor, NoxianCorrosiveCharge,
            HyperKineticPositionReverser),

    /** The champion name. */
    Varus("Varus", LivingVengeance, PiercingArrow, BlightedQuiver, HailOfArrows, ChainOfCorruption),

    /** The champion name. */
    Vayne("Vayne", NightHunter, Tumble, SilverBolts, Condemn, FinalHour),

    /** The champion name. */
    Veigar("Veigar", Equilibrium, BalefulStrike, DarkMatter, EventHorizon, PrimordialBurst),

    /** The champion name. */
    Vi("Vi", BlastShield, VaultBreaker, DentingBlows, ExcessiveForce, AssaultandBattery),

    /** The champion name. */
    Viktor("Viktor", EvolvingTechnology, PowerTransfer, GravityField, DeathRay, ChaosStorm),

    /** The champion name. */
    Vladimir("Vladimir", CrimsonPact, Transfusion, SanguinePool, TidesOfBlood, Hemoplague),

    /** The champion name. */
    Volibear("Volibear", ChosenOftheStorm, RollingThunder, Frenzy, MajesticRoar, ThunderClaws),

    /** The champion name. */
    Warwick("Warwick", EternalThirst, HungeringStrike, HuntersCall, BloodScent, InfiniteDuress),

    /** The champion name. */
    Wukong("Wukong", StoneSkin, CrushingBlow, Decoy, NimbusStrike, Cyclone),

    /** The champion name. */
    Xerath("Xerath", AscendedForm, Arcanopulse, LocusOfPower, MageChains, ArcaneBarrage),

    /** The champion name. */
    XinZhao("Xin Zhao", Challenge, ThreeTalonStrike, BattleCry, AudaciousCharge, CrescentSweep),

    /** The champion name. */
    Yorick("Yorick", UnholyCovenant, OmenOfWar, OmenOfPestilence, OmenOfFamine, OmenOfDeath),

    /** The champion name. */
    Zed("Zed", ContemptforTheWeak, RazorShuriken, LivingShadow, ShadowSlash, DeathMark),

    /** The champion name. */
    Ziggs("Ziggs", ShortFuse, BouncingBomb, SatchelCharge, HexplosiveMinefield, MegaInfernoBomb),

    /** The champion name. */
    Zilean("Zilean", HeightenedLearning, TimeBomb, Rewind, TimeWarp, ChronoShift),

    /** The champion name. */
    Zyra("Zyra", RiseOftheThorns, DeadlyBloom, RampantGrowth, GraspingRoots, Stranglethorns);

    /** The name. */
    public final String name;

    /** The normalized system name. */
    public final String systemName;

    /**
     * <p>
     * Create new champion.
     * </p>
     * 
     * @param name
     */
    private Champion(String name, Skill passive, Skill q, Skill w, Skill e, Skill r) {
        this.name = name;
        this.systemName = getSystemName().toLowerCase();
    }

    /**
     * <p>
     * Returns system name.
     * </p>
     * 
     * @return
     */
    public String getSystemName() {
        return name.replace("\\.", "").replace("\\s", "").replace("\\'", "");
    }

    /**
     * <p>
     * Returns splash art path.
     * </p>
     * 
     * @return
     */
    public String getSplashArt() {
        return "src/main/resources/teemowork/splash/" + getSystemName() + ".jpg";
    }

    /**
     * <p>
     * Returns icon image path.
     * </p>
     * 
     * @return
     */
    public String getIcon() {
        return "src/main/resources/teemowork/icon/" + getSystemName() + ".png";
    }
}
