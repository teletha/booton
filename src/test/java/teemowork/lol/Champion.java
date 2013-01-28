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
import static teemowork.lol.Status.*;
import static teemowork.lol.Version.*;

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

    /** The descriptor. */
    private final ChampionDescriptor[] descriptors = new ChampionDescriptor[Version.values().length];

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

    /**
     * <p>
     * Retrieve a descriptor at the specified version.
     * </p>
     */
    public ChampionDescriptor getDescriptor(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ChampionDescriptor descriptor = descriptors[i];

            if (descriptor != null) {
                return descriptor;
            }
        }
        return null;
    }

    /**
     * <p>
     * Update descriptor..
     * </p>
     * 
     * @param version A update version.
     * @return A champion descriptor.
     */
    private ChampionDescriptor update(Version version) {
        ChampionDescriptor descriptor = new ChampionDescriptor(getDescriptor(version));

        descriptors[version.ordinal()] = descriptor;

        return descriptor;
    }

    static {
        Ahri.update(P0000)
                .set(Health, 380, 80)
                .set(Hreg, 5.5, 0.6)
                .set(Mana, 230, 50)
                .set(Mreg, 6.25, 0.6)
                .set(AD, 50, 3)
                .set(AS, 0.668, 2)
                .set(AR, 10, 3.5)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Akali.update(P0000)
                .set(Health, 445, 85)
                .set(Hreg, 7.25, 0.65)
                .set(Energy, 200)
                .set(Ereg, 50)
                .set(AD, 53, 3.2)
                .set(AS, 0.694, 3.1)
                .set(AR, 16.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Alistar.update(P0000)
                .set(Health, 442, 102)
                .set(Hreg, 7.25, 0.85)
                .set(Mana, 215, 38)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 55.03, 3.62)
                .set(AS, 0.625, 3.62)
                .set(AR, 14.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 325);
        Amumu.update(P0000)
                .set(Health, 472, 84)
                .set(Hreg, 7.45, 0.85)
                .set(Mana, 220, 40)
                .set(Mreg, 6.5, 0.525)
                .set(AD, 47, 3.8)
                .set(AS, 0.638, 2.18)
                .set(AR, 18, 3.3)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 335);
        Anivia.update(P0000)
                .set(Health, 350, 70)
                .set(Hreg, 4.65, 0.55)
                .set(Mana, 257, 53)
                .set(Mreg, 7.0, 0.6)
                .set(AD, 48, 3.2)
                .set(AS, 0.625, 1.68)
                .set(AR, 10.5, 4)
                .set(MR, 30, 0)
                .set(Range, 600)
                .set(MS, 325);
        Annie.update(P0000)
                .set(Health, 384, 76)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 250, 50)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 49, 2.625)
                .set(AS, 0.579, 1.36)
                .set(AR, 12.5, 4)
                .set(MR, 30, 0)
                .set(Range, 625)
                .set(MS, 335);
        Ashe.update(P0000)
                .set(Health, 395, 79)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 173, 35)
                .set(Mreg, 6.3, 0.4)
                .set(AD, 46.3, 2.85)
                .set(AS, 0.658, 3.34)
                .set(AR, 11.5, 3.4)
                .set(MR, 30, 0)
                .set(Range, 600)
                .set(MS, 325);
        Blitzcrank.update(P0000)
                .set(Health, 423, 95)
                .set(Hreg, 7.25, 0.75)
                .set(Mana, 260, 40)
                .set(Mreg, 6.6, 0.5)
                .set(AD, 55.66, 3.5)
                .set(AS, 0.625, 1.13)
                .set(AR, 14.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 325);
        Brand.update(P0000)
                .set(Health, 380, 76)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 250, 45)
                .set(Mreg, 7, 0.6)
                .set(AD, 51.66, 3)
                .set(AS, 0.625, 1.36)
                .set(AR, 12, 3.5)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 340);
        Caitlyn.update(P0000)
                .set(Health, 390, 80)
                .set(Hreg, 4.75, 0.55)
                .set(Mana, 255, 35)
                .set(Mreg, 6.5, 0.55)
                .set(AD, 47, 3)
                .set(AS, 0.668, 3)
                .set(AR, 13, 3.5)
                .set(MR, 30, 0)
                .set(Range, 650)
                .set(MS, 325);
        Cassiopeia.update(P0000)
                .set(Health, 380, 75)
                .set(Hreg, 4.85, 0.5)
                .set(Mana, 250, 50)
                .set(Mreg, 7.1, 0.75)
                .set(AD, 47, 3.2)
                .set(AS, 0.644, 1.68)
                .set(AR, 11.5, 4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 335);
        ChoGath.update(P0000)
                .set(Health, 440, 80)
                .set(Hreg, 7.5, 0.85)
                .set(Mana, 205, 40)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 54.1, 4.2)
                .set(AS, 0.625, 1.44)
                .set(AR, 19, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Corki.update(P0000)
                .set(Health, 375, 82)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 243, 37)
                .set(Mreg, 6.5, 0.55)
                .set(AD, 48.2, 3)
                .set(AS, 0.658, 2.3)
                .set(AR, 13.5, 3.5)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 325);
        Darius.update(P0000)
                .set(Health, 426, 93)
                .set(Hreg, 8.25, 0.95)
                .set(Mana, 200, 37.5)
                .set(Mreg, 6, 0.35)
                .set(AD, 50, 3.5)
                .set(AS, 0.679, 2.6)
                .set(AR, 20, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 340);
        Diana.update(P0000)
                .set(Health, 438, 90)
                .set(Hreg, 7, 0.85)
                .set(Mana, 230, 40)
                .set(Mreg, 7, 0.6)
                .set(AD, 48, 3)
                .set(AS, 0.625, 2.25)
                .set(AR, 16, 3.6)
                .set(MR, 30, 1.25)
                .set(Range, 150)
                .set(MS, 345);
        DrMundo.update(P0000)
                .set(Health, 433, 89)
                .set(Hreg, 6.5, 0.75)
                .set(AD, 56.23, 3)
                .set(AS, 0.625, 2.8)
                .set(AR, 17, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Draven.update(P0000)
                .set(Health, 420, 82)
                .set(Hreg, 5, 0.7)
                .set(Mana, 240, 42)
                .set(Mreg, 6.95, 0.65)
                .set(AD, 46.5, 3.5)
                .set(AS, 0.679, 2.6)
                .set(AR, 16, 3.3)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Elise.update(P0000)
                .set(Health, 395, 80)
                .set(Hreg, 4.7, 0.6)
                .set(Mana, 240, 50)
                .set(Mreg, 6.8, 0.65)
                .set(AD, 47.5, 3)
                .set(AS, 0.625, 1.75)
                .set(AR, 12.65, 3.35)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 335);
        Evelynn.update(P0000)
                .set(Health, 414, 86)
                .set(Hreg, 6.95, 0.55)
                .set(Mana, 180, 42)
                .set(Mreg, 7.1, 0.6)
                .set(AD, 48, 3.3)
                .set(AS, 0.658, 3.84)
                .set(AR, 12.5, 4)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 340);
        Ezreal.update(P0000)
                .set(Health, 350, 80)
                .set(Hreg, 5.5, 0.55)
                .set(Mana, 235, 45)
                .set(Mreg, 7, 0.65)
                .set(AD, 47.2, 3)
                .set(AS, 0.665, 2.8)
                .set(AR, 12, 3.5)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Fiddlesticks.update(P0000)
                .set(Health, 390, 80)
                .set(Hreg, 4.6, 0.6)
                .set(Mana, 251, 59)
                .set(Mreg, 6.9, 0.65)
                .set(AD, 45.95, 2.625)
                .set(AS, 0.625, 2.11)
                .set(AR, 11, 3.5)
                .set(MR, 30, 0)
                .set(Range, 480)
                .set(MS, 335);
        Fiora.update(P0000)
                .set(Health, 450, 85)
                .set(Hreg, 6.3, 0.8)
                .set(Mana, 220, 40)
                .set(Mreg, 7.25, 0.5)
                .set(AD, 54.5, 3.2)
                .set(AS, 0.672, 3)
                .set(AR, 15.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Fizz.update(P0000)
                .set(Health, 414, 86)
                .set(Hreg, 7.0, 0.7)
                .set(Mana, 200, 40)
                .set(Mreg, 6.15, 0.45)
                .set(AD, 53, 3)
                .set(AS, 0.658, 3.1)
                .set(AR, 13, 3.4)
                .set(MR, 30, 1.25)
                .set(Range, 175)
                .set(MS, 335);
        Galio.update(P0000)
                .set(Health, 435, 85)
                .set(Hreg, 7.45, 0.75)
                .set(Mana, 235, 50)
                .set(Mreg, 7, 0.7)
                .set(AD, 56.3, 3.375)
                .set(AS, 0.638, 1.2)
                .set(AR, 17, 3.5)
                .set(MR, 30, 0)
                .set(Range, 125)
                .set(MS, 335);
        Gangplank.update(P0000)
                .set(Health, 495, 81)
                .set(Hreg, 425, 0.75)
                .set(Mana, 215, 40)
                .set(Mreg, 6.5, 0.7)
                .set(AD, 54, 3)
                .set(AS, 0.651, 2.75)
                .set(AR, 16.5, 3.3)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Garen.update(P0000)
                .set(Health, 455, 96)
                .set(Hreg, 7.5, 0.75)
                .set(AD, 52.5, 3.5)
                .set(AS, 0.625, 2.9)
                .set(AR, 19, 2.7)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Gragas.update(P0000)
                .set(Health, 434, 89)
                .set(Hreg, 7.25, 0.85)
                .set(Mana, 221, 47)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 55.78, 3.375)
                .set(AS, 0.651, 2.05)
                .set(AR, 16, 3.6)
                .set(MR, 30, 0)
                .set(Range, 125)
                .set(MS, 340);
        Graves.update(P0000)
                .set(Health, 410, 84)
                .set(Hreg, 5.5, 0.7)
                .set(Mana, 255, 40)
                .set(Mreg, 6.75, 0.7)
                .set(AD, 51, 3.1)
                .set(AS, 0.625, 2.9)
                .set(AR, 15, 3.2)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 330);
        Hecarim.update(P0000)
                .set(Health, 440, 95)
                .set(Hreg, 8, 0.75)
                .set(Mana, 210, 40)
                .set(Mreg, 6.5, 0.6)
                .set(AD, 56, 3.2)
                .set(AS, 0.67, 2.5)
                .set(AR, 16, 4)
                .set(MR, 30, 1.25)
                .set(Range, 175)
                .set(MS, 345);
        Heimerdinger.update(P0000)
                .set(Health, 350, 75)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 240, 65)
                .set(Mreg, 7, 0.65)
                .set(AD, 49.24, 3)
                .set(AS, 0.625, 1.21)
                .set(AR, 7, 3)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 325);
        Irelia.update(P0000)
                .set(Health, 456, 90)
                .set(Hreg, 7.5, 0.65)
                .set(Mana, 230, 35)
                .set(Mreg, 7, 0.65)
                .set(AD, 56, 3.3)
                .set(AS, 0.665, 3.2)
                .set(AR, 15, 3.75)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Janna.update(P0000)
                .set(Health, 356, 78)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 302, 64)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 49, 2.95)
                .set(AS, 0.625, 2.61)
                .set(AR, 9, 3.8)
                .set(MR, 30, 0)
                .set(Range, 475)
                .set(MS, 335);
        JarvanIV.update(P0000)
                .set(Health, 420, 90)
                .set(Hreg, 7, 0.7)
                .set(Mana, 235, 40)
                .set(Mreg, 6, 0.45)
                .set(AD, 50, 3.4)
                .set(AS, 0.658, 2.5)
                .set(AR, 14, 3)
                .set(MR, 30, 1.25)
                .set(Range, 175)
                .set(MS, 340);
        Jax.update(P0000)
                .set(Health, 463, 98)
                .set(Hreg, 7.45, 0.55)
                .set(Mana, 230, 35)
                .set(Mreg, 6.4, 0.7)
                .set(AD, 56.3, 3.375)
                .set(AS, 0.638, 3.4)
                .set(AR, 18, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Jayce.update(P0000)
                .set(Health, 420, 90)
                .set(Hreg, 6, 0.8)
                .set(Mana, 240, 40)
                .set(Mreg, 7, 0.7)
                .set(AD, 46.5, 3.5)
                .set(AS, 0.658, 3)
                .set(AR, 12.5, 3.5)
                .set(MR, 30, 0)
                .set(Range, 125)
                .set(MS, 335);
        Karma.update(P0000)
                .set(Health, 410, 86)
                .set(Hreg, 4.7, 0.55)
                .set(Mana, 240, 60)
                .set(Mreg, 6.8, 0.65)
                .set(AD, 50, 3.3)
                .set(AS, 0.625, 2.3)
                .set(AR, 15, 3.5)
                .set(MR, 30, 0)
                .set(Range, 425)
                .set(MS, 335);
        Karthus.update(P0000)
                .set(Health, 390, 75)
                .set(Hreg, 5.5, 0.55)
                .set(Mana, 270, 61)
                .set(Mreg, 6.5, 0.6)
                .set(AD, 42.2, 3.25)
                .set(AS, 0.625, 2.11)
                .set(AR, 11, 3.5)
                .set(MR, 30, 0)
                .set(Range, 450)
                .set(MS, 335);
        Kassadin.update(P0000)
                .set(Health, 433, 78)
                .set(Hreg, 6.95, 0.5)
                .set(Mana, 230, 45)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 52.3, 3.9)
                .set(AS, 0.638, 3.7)
                .set(AR, 14, 3.2)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 340);
        Katarina.update(P0000)
                .set(Health, 395, 83)
                .set(Hreg, 6.95, 0.55)
                .set(AD, 53, 3.2)
                .set(AS, 0.658, 2.74)
                .set(AR, 14.75, 4)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Kayle.update(P0000)
                .set(Health, 418, 93)
                .set(Hreg, 7, 0.75)
                .set(Mana, 255, 40)
                .set(Mreg, 6.9, 0.525)
                .set(AD, 53.3, 2.8)
                .set(AS, 0.638, 2.5)
                .set(AR, 17, 3.5)
                .set(MR, 30, 0.75)
                .set(Range, 125)
                .set(MS, 335);
        Kennen.update(P0000)
                .set(Health, 403, 79)
                .set(Hreg, 4.65, 0.65)
                .set(Energy, 200)
                .set(Ereg, 50)
                .set(AD, 51.3, 3.3)
                .set(AS, 0.69, 3.4)
                .set(AR, 14, 3.75)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 335);
        KhaZix.update(P0000)
                .set(Health, 430, 85)
                .set(Hreg, 6.25, 0.75)
                .set(Mana, 260, 40)
                .set(Mreg, 6.75, 0.5)
                .set(AD, 50, 3.1)
                .set(AS, 0.665, 2.7)
                .set(AR, 15, 3)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        KogMaw.update(P0000)
                .set(Health, 440, 84)
                .set(Hreg, 5, 0.55)
                .set(Mana, 295, 40)
                .set(Mreg, 7.5, 0.7)
                .set(AD, 46, 3)
                .set(AS, 0.665, 2.65)
                .set(AR, 13, 3.53)
                .set(MR, 30, 0)
                .set(Range, 500)
                .set(MS, 340);
        LeBlanc.update(P0000)
                .set(Health, 390, 75)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 250, 50)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 51, 3.1)
                .set(AS, 0.625, 1.4)
                .set(AR, 12, 3.5)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 335);
        LeeSin.update(P0000)
                .set(Health, 428, 85)
                .set(Hreg, 6.25, 075)
                .set(Ereg, 200)
                .set(Ereg, 50)
                .set(AD, 55.8, 3.2)
                .set(AS, 0.651, 3)
                .set(AR, 16, 3.7)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Leona.update(P0000)
                .set(Health, 430, 87)
                .set(Hreg, 9, 0.85)
                .set(Mana, 235, 40)
                .set(Mreg, 8, 0.7)
                .set(AD, 55, 3)
                .set(AS, 0.625, 2.9)
                .set(AR, 18, 3.1)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 335);
        Lulu.update(P0000)
                .set(Health, 415, 82)
                .set(Hreg, 6, 0.72)
                .set(Mana, 200, 50)
                .set(Mreg, 6, 0.6)
                .set(AD, 44.4, 2.6)
                .set(AS, 0.625, 2.2)
                .set(AR, 9, 3.7)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 325);
        Lux.update(P0000)
                .set(Health, 345, 79)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 250, 50)
                .set(Mreg, 6, 0.6)
                .set(AD, 50, 3.3)
                .set(AS, 0.625, 1.36)
                .set(AR, 8, 4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 340);
        Malphite.update(P0000)
                .set(Health, 423, 90)
                .set(Hreg, 7.45, 0.55)
                .set(Mana, 215, 40)
                .set(Mreg, 6.4, 0.55)
                .set(AD, 56.3, 3.375)
                .set(AS, 0.638, 3.4)
                .set(AR, 18, 3.75)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 335);
        Malzahar.update(P0000)
                .set(Health, 380, 80)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 250, 45)
                .set(Mreg, 7, 0.6)
                .set(AD, 51.66, 3)
                .set(AS, 0.625, 1.36)
                .set(AR, 15, 3.5)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 340);
        Maokai.update(P0000)
                .set(Health, 421, 90)
                .set(Hreg, 7.25, 0.85)
                .set(Mana, 250, 46)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 58, 3.3)
                .set(AS, 0.694, 2.13)
                .set(AR, 18, 4)
                .set(MR, 30, 0)
                .set(Range, 125)
                .set(MS, 335);
        MasterYi.update(P0000)
                .set(Health, 444, 86)
                .set(Hreg, 6.75, 0.65)
                .set(Mana, 199, 36)
                .set(Mreg, 6.5, 0.45)
                .set(AD, 55.12, 3.1)
                .set(AS, 0.679, 2.98)
                .set(AR, 16.3, 3.7)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 355);
        MissFortune.update(P0000)
                .set(Health, 435, 85)
                .set(Hreg, 5.1, 0.65)
                .set(Mana, 212, 38)
                .set(Mreg, 6.95, 0.65)
                .set(AD, 46.5, 3)
                .set(AS, 0.658, 3.01)
                .set(AR, 15, 3)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 325);
        Mordekaiser.update(P0000)
                .set(Health, 421, 80)
                .set(Hreg, 7.45, 0.55)
                .set(AD, 51.7, 3.5)
                .set(AS, 0.694, 3)
                .set(AR, 15, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 340);
        Morgana.update(P0000)
                .set(Health, 403, 86)
                .set(Hreg, 4.7, 0.6)
                .set(Mana, 240, 60)
                .set(Mreg, 6.8, 0.65)
                .set(AD, 51.58, 3.5)
                .set(AS, 0.579, 1.53)
                .set(AR, 15, 3.8)
                .set(MR, 30, 0)
                .set(Range, 425)
                .set(MS, 335);
        Nami.update(P0000)
                .set(Health, 365, 74)
                .set(Hreg, 4.5, 055)
                .set(Mana, 305, 43)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 48, 3.1)
                .set(AS, 0.644, 2.6)
                .set(AR, 9, 4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Nasus.update(P0000)
                .set(Health, 410, 90)
                .set(Hreg, 7.5, 0.9)
                .set(Mana, 200, 45)
                .set(Mreg, 6.6, 0.5)
                .set(AD, 53.3, 3.5)
                .set(AS, 0.638, 3.48)
                .set(AR, 15, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Nautilus.update(P0000)
                .set(Health, 432, 86)
                .set(Hreg, 7.45, 0.55)
                .set(Mana, 200, 50)
                .set(Mreg, 7.45, 0.7)
                .set(AD, 52, 3.3)
                .set(AS, 0.613, 0.98)
                .set(AR, 12, 3.25)
                .set(MR, 30, 1.25)
                .set(Range, 175)
                .set(MS, 325);
        Nidalee.update(P0000)
                .set(Health, 370, 90)
                .set(Hreg, 5.0, 0.6)
                .set(Mana, 220, 45)
                .set(Mreg, 7, 0.5)
                .set(AD, 49, 3.5)
                .set(AS, 0.672, 3.22)
                .set(AR, 11, 3.5)
                .set(MR, 30, 10.75)
                .set(Range, 525)
                .set(MS, 335);
        Nocturne.update(P0000)
                .set(Health, 430, 85)
                .set(Hreg, 7, 0.75)
                .set(Mana, 215, 35)
                .set(Mreg, 6, 0.45)
                .set(AD, 54, 3.1)
                .set(AS, 0.668, 2.7)
                .set(AR, 17, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Nunu.update(P0000)
                .set(Health, 437, 108)
                .set(Hreg, 7.05, 0.8)
                .set(Mana, 213, 42)
                .set(Mreg, 6.6, 0.5)
                .set(AD, 51.6, 3.4)
                .set(AS, 0.625, 2.25)
                .set(AR, 16.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 340);
        Olaf.update(P0000)
                .set(Health, 441, 93)
                .set(Hreg, 7, 0.9)
                .set(Mana, 225, 45)
                .set(Mreg, 6.5, 0.575)
                .set(AD, 54.1, 3.5)
                .set(AS, 0.694, 2.7)
                .set(AR, 17, 3)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Orianna.update(P0000)
                .set(Health, 385, 79)
                .set(Hreg, 5.95, 0.55)
                .set(Mana, 250, 50)
                .set(Mreg, 7, 0.5)
                .set(AD, 44, 2.6)
                .set(AS, 0.658, 3.5)
                .set(AR, 8, 3)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 325);
        Pantheon.update(P0000)
                .set(Health, 433, 87)
                .set(Hreg, 6.75, 0.65)
                .set(Mana, 210, 34)
                .set(Mreg, 6.6, 0.45)
                .set(AD, 50.7, 2.9)
                .set(AS, 0.679, 2.95)
                .set(AR, 17.1, 3.9)
                .set(MR, 30, 1.25)
                .set(Range, 155)
                .set(MS, 355);
        Poppy.update(P0000)
                .set(Health, 423, 81)
                .set(Hreg, 7.45, 0.55)
                .set(Mana, 185, 30)
                .set(Mreg, 6.4, 0.45)
                .set(AD, 56.3, 3.375)
                .set(AS, 0.638, 3.35)
                .set(AR, 18, 4)
                .set(MR, 30, 0)
                .set(Range, 125)
                .set(MS, 345);
        Rammus.update(P0000)
                .set(Health, 420, 86)
                .set(Hreg, 8, 0.55)
                .set(Mana, 255, 33)
                .set(Mreg, 4.5, 0.3)
                .set(AD, 50, 3.5)
                .set(AS, 0.625, 2.22)
                .set(AR, 21, 3.8)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 335);
        Renekton.update(P0000)
                .set(Health, 426, 87)
                .set(Hreg, 6.7, 0.75)
                .set(AD, 53.12, 3.1)
                .set(AS, 0.665, 2.65)
                .set(AR, 15.2, 3.8)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Rengar.update(P0000)
                .set(Health, 435, 85)
                .set(Hreg, 4, 0.4)
                .set(AD, 55, 3)
                .set(AS, 0.679, 2.85)
                .set(AR, 16, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Riven.update(P0000)
                .set(Health, 414, 86)
                .set(Hreg, 10.4, 0.9)
                .set(AD, 54, 2.75)
                .set(AS, 0.625, 3.5)
                .set(AR, 15, 3.1)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Rumble.update(P0000)
                .set(Health, 450, 80)
                .set(Hreg, 7, 0.7)
                .set(AD, 55.32, 3.2)
                .set(AS, 0.644, 1.85)
                .set(AR, 16, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Ryze.update(P0000)
                .set(Health, 360, 86)
                .set(Hreg, 4.35, 0.55)
                .set(Mana, 250, 55)
                .set(Mreg, 7, 0.6)
                .set(AD, 52, 3)
                .set(AS, 0.625, 2.11)
                .set(AR, 11, 3.9)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 335);
        Sejuani.update(P0000)
                .set(Health, 450, 85)
                .set(Hreg, 7.35, 0.85)
                .set(Mana, 220, 40)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 54, 3.4)
                .set(AS, 0.67, 1.45)
                .set(AR, 20.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 340);
        Shaco.update(P0000)
                .set(Health, 441, 84)
                .set(Hreg, 7.45, 0.55)
                .set(Mana, 270, 40)
                .set(Mreg, 6.4, 0.45)
                .set(AD, 51.7, 3.5)
                .set(AS, 0.694, 3)
                .set(AR, 15, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Shen.update(P0000)
                .set(Health, 428, 85)
                .set(Hreg, 7.45, 0.55)
                .set(Energy, 200)
                .set(Ereg, 50)
                .set(AD, 54.5, 3.375)
                .set(AS, 0.651, 3.4)
                .set(AR, 15, 4)
                .set(MR, 30, 0)
                .set(Range, 125)
                .set(MS, 335);
        Shyvana.update(P0000)
                .set(Health, 435, 95)
                .set(Hreg, 7.2, 0.8)
                .set(AD, 54.5, 3.4)
                .set(AS, 0.658, 3.4)
                .set(AR, 17.6, 3.4)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Singed.update(P0000)
                .set(Health, 405, 82)
                .set(Hreg, 7.1, 0.55)
                .set(Mana, 215, 45)
                .set(Mreg, 6.6, 0.55)
                .set(AD, 56.65, 3.375)
                .set(AS, 0.613, 1.81)
                .set(AR, 18, 3.5)
                .set(MR, 30, 0)
                .set(Range, 125)
                .set(MS, 345);
        Sion.update(P0000)
                .set(Health, 403, 104)
                .set(Hreg, 7.9, 0.95)
                .set(Mana, 240, 40)
                .set(Mreg, 6.3, 0.4)
                .set(AD, 55.52, 3.1875)
                .set(AS, 0.625, 1.63)
                .set(AR, 17.75, 3.25)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Sivir.update(P0000)
                .set(Health, 378, 82)
                .set(Hreg, 4.25, 0.55)
                .set(Mana, 203, 43)
                .set(Mreg, 6.5, 0.5)
                .set(AD, 49, 2.9)
                .set(AS, 0.658, 3.28)
                .set(AR, 12.75, 3.25)
                .set(MR, 30, 0)
                .set(Range, 500)
                .set(MS, 335);
        Skarner.update(P0000)
                .set(Health, 440, 96)
                .set(Hreg, 7.5, 0.85)
                .set(Mana, 205, 40)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 54.1, 4.2)
                .set(AS, 0.625, 2.1)
                .set(AR, 19, 3.8)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Sona.update(P0000)
                .set(Health, 340, 70)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 265, 45)
                .set(Mreg, 7.0, 0.65)
                .set(AD, 47, 3)
                .set(AS, 0.644, 2.3)
                .set(AR, 6, 3.3)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Soraka.update(P0000)
                .set(Health, 375, 71)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 240, 60)
                .set(Mreg, 6.8, 0.65)
                .set(AD, 48.8, 3)
                .set(AS, 0.625, 2.14)
                .set(AR, 7.4, 3.8)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 335);
        Swain.update(P0000)
                .set(Health, 385, 78)
                .set(Hreg, 6.75, 0.65)
                .set(Mana, 240, 50)
                .set(Mreg, 6.8, 0.65)
                .set(AD, 49, 3)
                .set(AS, 0.625, 2.11)
                .set(AR, 12, 4)
                .set(MR, 30, 0)
                .set(Range, 500)
                .set(MS, 335);
        Syndra.update(P0000)
                .set(Health, 380, 78)
                .set(Hreg, 5.5, 0.6)
                .set(Mana, 250, 50)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 51, 2.9)
                .set(AS, 0.625, 2)
                .set(AR, 15, 3.4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Talon.update(P0000)
                .set(Health, 440, 85)
                .set(Hreg, 7.25, 0.75)
                .set(Mana, 260, 40)
                .set(Mreg, 6.75, 0.5)
                .set(AD, 50, 3.1)
                .set(AS, 0.668, 2.7)
                .set(AR, 17, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Taric.update(P0000)
                .set(Health, 468, 90)
                .set(Hreg, 7.1, 0.5)
                .set(Mana, 255, 56)
                .set(Mreg, 4.1, 0.4)
                .set(AD, 58, 3.5)
                .set(AS, 0.625, 2.02)
                .set(AR, 16.5, 3.2)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 340);
        Teemo.update(P0000)
                .set(Health, 383, 82)
                .set(Hreg, 4.65, 0.65)
                .set(Mana, 200, 40)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 44.5, 3)
                .set(AS, 0.690, 3.38)
                .set(AR, 14, 3.75)
                .set(MR, 30, 0)
                .set(Range, 500)
                .set(MS, 330);
        Tristana.update(P0000)
                .set(Health, 415, 82)
                .set(Hreg, 5.1, 0.65)
                .set(Mana, 193, 32)
                .set(Mreg, 6.45, 0.45)
                .set(AD, 46.5, 3)
                .set(AS, 0.658, 3.01)
                .set(AR, 15, 3)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 325);
        Trundle.update(P0000)
                .set(Health, 455, 96)
                .set(Hreg, 8, 0.85)
                .set(Mana, 206, 45)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 54.66, 3)
                .set(AS, 0.672, 2.9)
                .set(AR, 19, 2.7)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Tryndamere.update(P0000)
                .set(Health, 461, 98)
                .set(Hreg, 7.9, 0.9)
                .set(AD, 56, 3.2)
                .set(AS, 0.644, 2.9)
                .set(AR, 14.9, 3.1)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        TwistedFate.update(P0000)
                .set(Health, 384, 82)
                .set(Hreg, 4.5, 0.6)
                .set(Mana, 202, 38)
                .set(Mreg, 6.5, 0.5)
                .set(AD, 46.61, 3.3)
                .set(AS, 0.651, 3.22)
                .set(AR, 111.25, 3.15)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 330);
        Twitch.update(P0000)
                .set(Health, 389, 81)
                .set(Hreg, 5, 0.6)
                .set(Mana, 220, 40)
                .set(Mreg, 6.5, 0.45)
                .set(AD, 49, 3)
                .set(AS, 0.679, 3.38)
                .set(AR, 14, 3)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Udyr.update(P0000)
                .set(Health, 427, 99)
                .set(Hreg, 7.45, 0.75)
                .set(Mana, 220, 30)
                .set(Mreg, 6.4, 0.45)
                .set(AD, 52.91, 3.2)
                .set(AS, 0.658, 2.67)
                .set(AR, 14.75, 4)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Urgot.update(P0000)
                .set(Health, 437, 89)
                .set(Hreg, 5.5, 0.6)
                .set(Mana, 220, 55)
                .set(Mreg, 7.5, 0.65)
                .set(AD, 48, 3.6)
                .set(AS, 0.644, 2.9)
                .set(AR, 15, 3.3)
                .set(MR, 30, 0)
                .set(Range, 425)
                .set(MS, 335);
        Varus.update(P0000)
                .set(Health, 400, 82)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 250, 36)
                .set(Mreg, 6.5, 0.5)
                .set(AD, 46, 3)
                .set(AS, 0.658, 2.65)
                .set(AR, 13.5, 3.4)
                .set(MR, 30, 0)
                .set(Range, 575)
                .set(MS, 335);
        Vayne.update(P0000)
                .set(Health, 359, 83)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 173, 27)
                .set(Mreg, 6.3, 0.4)
                .set(AD, 50, 3.25)
                .set(AS, 0.658, 3.1)
                .set(AR, 9.3, 3.4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Veigar.update(P0000)
                .set(Health, 355, 82)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 250, 55)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 48.3, 2.625)
                .set(AS, 0.625, 2.24)
                .set(AR, 12.25, 3.75)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 340);
        Vi.update(P0000)
                .set(Health, 440, 85)
                .set(Hreg, 7.5, 0.9)
                .set(Mana, 220, 45)
                .set(Mreg, 7.0, 0.65)
                .set(AD, 55, 3.5)
                .set(AS, 0.643, 2.5)
                .set(AR, 16, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 350);
        Viktor.update(P0000)
                .set(Health, 385, 78)
                .set(Hreg, 6.75, 0.65)
                .set(Mana, 240, 50)
                .set(Mreg, 6.9, 0.45)
                .set(AD, 49, 3)
                .set(AS, 0.625, 2.11)
                .set(AR, 12, 4)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 335);
        Vladimir.update(P0000)
                .set(Health, 400, 85)
                .set(Hreg, 6, 0.6)
                .set(AD, 45, 3)
                .set(AS, 0.6258, 2)
                .set(AR, 12, 3.5)
                .set(MR, 30, 0)
                .set(Range, 450)
                .set(MS, 335);
        Volibear.update(P0000)
                .set(Health, 440, 86)
                .set(Hreg, 7.0, 0.65)
                .set(Mana, 220, 30)
                .set(Mreg, 7, 0.65)
                .set(AD, 54, 3.3)
                .set(AS, 0.625, 2.9)
                .set(AR, 16.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Warwick.update(P0000)
                .set(Health, 428, 98)
                .set(Hreg, 7.05, 0.8)
                .set(Mana, 190, 30)
                .set(Mreg, 7.1, 0.6)
                .set(AD, 56.76, 3.375)
                .set(AS, 0.679, 2.88)
                .set(AR, 16, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Wukong.update(P0000)
                .set(Health, 435, 85)
                .set(Hreg, 5.1, 0.65)
                .set(Mana, 202, 38)
                .set(Mreg, 6.9, 0.65)
                .set(AD, 54, 3.2)
                .set(AS, 0.658, 3)
                .set(AR, 15, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 175)
                .set(MS, 345);
        Xerath.update(P0000)
                .set(Health, 380, 80)
                .set(Hreg, 5, 0.55)
                .set(Mana, 250, 45)
                .set(Mreg, 8, 0.6)
                .set(AD, 52, 3)
                .set(AS, 0.625, 1.36)
                .set(AR, 12.6, 3.4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 340);
        XinZhao.update(P0000)
                .set(Health, 445, 87)
                .set(Hreg, 7, 0.7)
                .set(Mana, 213, 31)
                .set(Mreg, 6.6, 0.45)
                .set(AD, 52, 3.3)
                .set(AS, 0.672, 2.7)
                .set(AR, 16.2, 3.7)
                .set(MR, 30, 1.25)
                .set(Range, 175)
                .set(MS, 345);
        Yorick.update(P0000)
                .set(Health, 421, 85)
                .set(Hreg, 8.5, 0.7)
                .set(Mana, 235, 35)
                .set(Mreg, 6.5, 0.45)
                .set(AD, 51.5, 3.5)
                .set(AS, 0.625, 3)
                .set(AR, 18, 3.6)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Zed.update(P0000)
                .set(Health, 445, 85)
                .set(Hreg, 6, 0.65)
                .set(Energy, 20)
                .set(Ereg, 50)
                .set(AD, 48.6, 3.4)
                .set(AS, 0.658, 3.1)
                .set(AR, 17.5, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Ziggs.update(P0000)
                .set(Health, 390, 80)
                .set(Hreg, 5.25, 0.6)
                .set(Mana, 250, 50)
                .set(Mreg, 6.75, 0.6)
                .set(AD, 54, 3.1)
                .set(AS, 0.656, 1.7)
                .set(AR, 12, 3.3)
                .set(MR, 30, 0)
                .set(Range, 575)
                .set(MS, 330);
        Zilean.update(P0000)
                .set(Health, 380, 71)
                .set(Hreg, 4.6, 0.5)
                .set(Mana, 260, 60)
                .set(Mreg, 6.95, 0.65)
                .set(AD, 48.6, 3)
                .set(AS, 0.625, 2.13)
                .set(AR, 6.75, 3.8)
                .set(MR, 30, 0)
                .set(Range, 600)
                .set(MS, 335);
        Zyra.update(P0000)
                .set(Health, 355, 74)
                .set(Hreg, 4.85, 0.5)
                .set(Mana, 250, 50)
                .set(Mreg, 7.1, 0.75)
                .set(AD, 50, 3.2)
                .set(AS, 0.625, 1.8)
                .set(AR, 11, 3)
                .set(MR, 30, 0)
                .set(Range, 575)
                .set(MS, 325);

        Thresh.update(P1154)
                .set(Health, 452, 92)
                .set(Hreg, 9, 0.85)
                .set(Mana, 200, 50)
                .set(Mreg, 8.45, 0.85)
                .set(AD, 46, 2.2)
                .set(AS, 0.625, 2.1)
                .set(AR, 18, 0)
                .set(MR, 30, 0)
                .set(Range, 475)
                .set(MS, 325);
    }
}
