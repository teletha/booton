/*
 * Copyright (C) 2013 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License"),
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import static teemowork.model.Skill.*;
import static teemowork.model.Status.*;
import static teemowork.model.Version.*;

import java.util.ArrayList;
import java.util.List;

import js.dom.Element;

/**
 * 3.15準拠
 * 
 * @version 2013/06/14 8:39:54
 */
public class Champion {

    /** The counter for id. */
    private static int counter = 0;

    /** The champion manager. */
    private static final List<Champion> champions = new ArrayList();

    /** The champion name. */
    public static final Champion Aatrox = new Champion("Aatrox", BloodWell, DarkFlight, BloodThirst, BladesOfTorment, Massacre);

    /** The champion name. */
    public static final Champion Ahri = new Champion("Ahri", EssenceTheft, OrbOfDeception, FoxFire, Skill.Charm, SpiritRush);

    /** The champion name. */
    public static final Champion Akali = new Champion("Akali", TwinDisciplines, MarkOftheAssassin, TwilightShroud, CrescentSlash, ShadowDance);

    /** The champion name. */
    public static final Champion Alistar = new Champion("Alistar", Trample, Pulverize, Headbutt, TriumphantRoar, UnbreakableWill);

    /** The champion name. */
    public static final Champion Amumu = new Champion("Amumu", CursedTouch, BandageToss, Despair, Tantrum, CurseOftheSadMummy);

    /** The champion name. */
    public static final Champion Anivia = new Champion("Anivia", Rebirth, FlashFrost, Crystalize, Frostbite, GlacialStorm);

    /** The champion name. */
    public static final Champion Annie = new Champion("Annie", Pyromania, Disintegrate, Incinerate, MoltenShield, SummonTibbers);

    /** The champion name. */
    public static final Champion Ashe = new Champion("Ashe", Focus, FrostShot, Volley, Hawkshot, EnchantedCrystalArrow);

    /** The champion name. */
    public static final Champion Blitzcrank = new Champion("Blitzcrank", ManaBarrier, RocketGrab, Overdrive, PowerFist, StaticField);

    /** The champion name. */
    public static final Champion Brand = new Champion("Brand", Blaze, Sear, PillarOfFlame, Conflagration, Pyroclasm);

    /** The champion name. */
    public static final Champion Caitlyn = new Champion("Caitlyn", Headshot, PiltoverPeacemaker, YordleSnapTrap, CaliberNet, AceinTheHole);

    /** The champion name. */
    public static final Champion Cassiopeia = new Champion("Cassiopeia", DeadlyCadence, NoxiousBlast, Miasma, TwinFang, PetrifyingGaze);

    /** The champion name. */
    public static final Champion ChoGath = new Champion("Cho'Gath", Carnivore, Rupture, FeralScream, VorpalSpikes, Feast);

    /** The champion name. */
    public static final Champion Corki = new Champion("Corki", HextechShrapnelShells, PhosphorusBomb, Valkyrie, GatlingGun, MissileBarrage);

    /** The champion name. */
    public static final Champion Darius = new Champion("Darius", Hemorrhage, Decimate, CripplingStrike, Apprehend, NoxianGuillotine);

    /** The champion name. */
    public static final Champion Diana = new Champion("Diana", MoonsilverBlade, CrescentStrike, PaleCascade, Moonfall, LunarRush);

    /** The champion name. */
    public static final Champion Draven = new Champion("Draven", LeagueOfDraven, SpinningAxe, BloodRush, StandAside, WhirlingDeath);

    /** The champion name. */
    public static final Champion DrMundo = new Champion("Dr.Mundo", AdrenalineRush, InfectedCleaver, BurningAgony, Masochism, Sadism);

    /** The champion name. */
    public static final Champion Elise = new Champion("Elise", SpiderSwarm, Neurotoxin, VolatileSpiderling, Cocoon, SpiderForm);

    /** The champion name. */
    public static final Champion EliseSpider = new Champion("Elise", true, SpiderSwarm, VenomousBite, SkitteringFrenzy, Rappel, HumanForm);

    /** The champion name. */
    public static final Champion Evelynn = new Champion("Evelynn", ShadowWalk, HateSpike, DarkFrenzy, Ravage, AgonysEmbrace);

    /** The champion name. */
    public static final Champion Ezreal = new Champion("Ezreal", RisingSpellForce, MysticShot, EssenceFlux, ArcaneShift, TrueshotBarrage);

    /** The champion name. */
    public static final Champion Fiddlesticks = new Champion("Fiddlesticks", Dread, Terrify, Drain, DarkWind, Crowstorm);

    /** The champion name. */
    public static final Champion Fiora = new Champion("Fiora", Duelist, Lunge, Riposte, BurstOfSpeed, BladeWaltz);

    /** The champion name. */
    public static final Champion Fizz = new Champion("Fizz", NimbleFighter, UrchinStrike, SeastoneTrident, Playful, Trickster, ChumTheWaters);

    /** The champion name. */
    public static final Champion Galio = new Champion("Galio", RunicSkin, ResoluteSmite, Bulwark, RighteousGust, IdolOfDurand);

    /** The champion name. */
    public static final Champion Gangplank = new Champion("Gangplank", GrogSoakedBlade, Parrrley, RemoveScurvy, RaiseMorale, CannonBarrage);

    /** The champion name. */
    public static final Champion Garen = new Champion("Garen", Perseverance, DecisiveStrike, Courage, Judgment, DemacianJustice);

    /** The champion name. */
    public static final Champion Gragas = new Champion("Gragas", HappyHour, BarrelRoll, DrunkenRage, BodySlam, ExplosiveCask);

    /** The champion name. */
    public static final Champion Graves = new Champion("Graves", TrueGrit, Buckshot, Smokescreen, Quickdraw, CollateralDamage);

    /** The champion name. */
    public static final Champion Hecarim = new Champion("Hecarim", Warpath, Rampage, SpiritOfDread, DevastatingCharge, OnslaughtOfShadows);

    /** The champion name. */
    public static final Champion Heimerdinger = new Champion("Heimerdinger", TechmaturgicalRepairBots, H28GEvolutionTurret, HextechMicroRockets, CH1ConcussionGrenade, UPGRADE);

    /** The champion name. */
    public static final Champion Irelia = new Champion("Irelia", IonianFervor, Bladesurge, HitenStyle, EquilibriumStrike, TranscendentBlades);

    /** The champion name. */
    public static final Champion Janna = new Champion("Janna", Tailwind, HowlingGale, Zephyr, EyeOfTheStorm, Monsoon);

    /** The champion name. */
    public static final Champion JarvanIV = new Champion("Jarvan IV", MartialCadence, DragonStrike, GoldenAegis, DemacianStandard, Cataclysm);

    /** The champion name. */
    public static final Champion Jax = new Champion("Jax", RelentlessAssault, LeapStrike, Empower, CounterStrike, GrandmastersMight);

    /** The champion name. */
    public static final Champion Jayce = new Champion("Jayce", HextechCapacitor, ToTheSkies, LightningField, ThunderingBlow, TransformMercuryCannon);

    /** The champion name. */
    public static final Champion JayceCannon = new Champion("Jayce", true, HextechCapacitor, ShockBlast, HyperCharge, AccelerationGate, TransformMercuryHammer);

    /** The champion name. */
    public static final Champion Jinx = new Champion("Jinx", GetExcited, Switcheroo, Zap, FlameChompers, SuperMegaDeathRocket);

    /** The champion name. */
    public static final Champion Karma = new Champion("Karma", GatheringFire, InnerFlame, FocusedResolve, Inspire, Mantra);

    /** The champion name. */
    public static final Champion Karthus = new Champion("Karthus", DeathDefied, LayWaste, WallOfPain, Defile, Requiem);

    /** The champion name. */
    public static final Champion Kassadin = new Champion("Kassadin", VoidStone, NullSphere, NetherBlade, ForcePulse, Riftwalk);

    /** The champion name. */
    public static final Champion Katarina = new Champion("Katarina", Voracity, BouncingBlade, SinisterSteel, Shunpo, DeathLotus);

    /** The champion name. */
    public static final Champion Kayle = new Champion("Kayle", HolyFervor, Reckoning, DivineBlessing, RighteousFury, Intervention);

    /** The champion name. */
    public static final Champion Kennen = new Champion("Kennen", MarkOftheStorm, ThunderingShuriken, ElectricalSurge, LightningRush, SlicingMaelstrom);

    /** The champion name. */
    public static final Champion KhaZix = new Champion("Kha'Zix", UnseenThreat, TasteTheirFear, VoidSpike, Leap, VoidAssault);

    /** The champion name. */
    public static final Champion KogMaw = new Champion("Kog'Maw", IcathianSurprise, CausticSpittle, BioArcaneBarrage, VoidOoze, LivingArtillery);

    /** The champion name. */
    public static final Champion LeBlanc = new Champion("LeBlanc", MirrorImage, SigilOfSilence, Distortion, EtherealChains, Mimic);

    /** The champion name. */
    public static final Champion LeeSin = new Champion("Lee Sin", Flurry, SonicWave, ResonatingStrike, Safeguard, IronWill, Tempest, Cripple, DragonsRage);

    /** The champion name. */
    public static final Champion Leona = new Champion("Leona", Sunlight, ShieldOfDaybreak, Eclipse, ZenithBlade, SolarFlare);

    /** The champion name. */
    public static final Champion Lissandra = new Champion("Lissandra", Iceborn, IceShard, RingOfFrost, GlacialPath, FrozenTomb);

    /** The champion name. */
    public static final Champion Lucian = new Champion("Lucian", Lightslinger, PiercingLight, ArdentBlaze, RelentlessPursuit, TheCulling);

    /** The champion name. */
    public static final Champion Lulu = new Champion("Lulu", PixFaerieCompanion, Glitterlance, Whimsy, HelpPix, WildGrowth);

    /** The champion name. */
    public static final Champion Lux = new Champion("Lux", Illumination, LightBinding, PrismaticBarrier, LucentSingularity, FinalSpark);

    /** The champion name. */
    public static final Champion Malphite = new Champion("Malphite", GraniteShield, SeismicShard, BrutalStrikes, GroundSlam, UnstoppableForce);

    /** The champion name. */
    public static final Champion Malzahar = new Champion("Malzahar", SummonVoidling, CallOftheVoid, NullZone, MaleficVisions, NetherGrasp);

    /** The champion name. */
    public static final Champion Maokai = new Champion("Maokai", SapMagic, ArcaneSmash, TwistedAdvance, SaplingToss, VengefulMaelstrom);

    /** The champion name. */
    public static final Champion MasterYi = new Champion("Master Yi", DoubleStrike, AlphaStrike, Meditate, WujuStyle, Highlander);

    /** The champion name. */
    public static final Champion MissFortune = new Champion("Miss Fortune", Strut, DoubleUp, ImpureShots, MakeItRain, BulletTime);

    /** The champion name. */
    public static final Champion Mordekaiser = new Champion("Mordekaiser", IronMan, MaceOfSpades, CreepingDeath, SiphonOfDestruction, ChildrenOftheGrave);

    /** The champion name. */
    public static final Champion Morgana = new Champion("Morgana", SoulSiphon, DarkBinding, TormentedSoil, BlackShield, SoulShackles);

    /** The champion name. */
    public static final Champion Nami = new Champion("Nami", SurgingTides, AquaPrison, EbbandFlow, TidecallersBlessing, TidalWave);

    /** The champion name. */
    public static final Champion Nasus = new Champion("Nasus", SoulEater, SiphoningStrike, Wither, SpiritFire, FuryOftheSands);

    /** The champion name. */
    public static final Champion Nautilus = new Champion("Nautilus", StaggeringBlow, DredgeLine, TitansWrath, Riptide, DepthCharge);

    /** The champion name. */
    public static final Champion Nidalee = new Champion("Nidalee", Prowl, JavelinToss, Bushwhack, PrimalSurge, AspectOfTheCougar);

    /** The champion name. */
    public static final Champion NidaleeCougar = new Champion("Nidalee", true, Prowl, Takedown, Pounce, Swipe, AspectOfTheCougarInCougar);

    /** The champion name. */
    public static final Champion Nocturne = new Champion("Nocturne", UmbraBlades, Duskbringer, ShroudOfDarkness, UnspeakableHorror, Paranoia);

    /** The champion name. */
    public static final Champion Nunu = new Champion("Nunu", Visionary, Consume, BloodBoil, IceBlast, AbsoluteZero);

    /** The champion name. */
    public static final Champion Olaf = new Champion("Olaf", BerserkerRage, Undertow, ViciousStrikes, RecklessSwing, Ragnarok);

    /** The champion name. */
    public static final Champion Orianna = new Champion("Orianna", ClockworkWindup, CommandAttack, CommandDissonance, CommandProtect, CommandShockwave);

    /** The champion name. */
    public static final Champion Pantheon = new Champion("Pantheon", AegisProtection, SpearShot, AegisOfZeonia, HeartseekerStrike, GrandSkyfall);

    /** The champion name. */
    public static final Champion Poppy = new Champion("Poppy", ValiantFighter, DevastatingBlow, ParagonOfDemacia, HeroicCharge, DiplomaticImmunity);

    /** The champion name. */
    public static final Champion Quinn = new Champion("Quinn", Harrier, BlindingAssault, HeightenedSenses, Vault, TagTeam);

    /** The champion name. */
    public static final Champion Rammus = new Champion("Rammus", SpikedShell, Powerball, DefensiveBallCurl, PuncturingTaunt, Tremors);

    /** The champion name. */
    public static final Champion Renekton = new Champion("Renekton", ReignOfAnger, CullTheMeek, RuthlessPredator, SliceandDice, Dominus);

    /** The champion name. */
    public static final Champion Rengar = new Champion("Rengar", UnseenPredator, Savagery, BattleRoar, BolaStrike, ThrillOftheHunt);

    /** The champion name. */
    public static final Champion Riven = new Champion("Riven", RunicBlade, BrokenWings, KiBurst, Valor, BladeOftheExile);

    /** The champion name. */
    public static final Champion Rumble = new Champion("Rumble", JunkyardTitan, Flamespitter, ScrapShield, ElectroHarpoon, TheEqualizer);

    /** The champion name. */
    public static final Champion Ryze = new Champion("Ryze", ArcaneMastery, Overload, RunePrison, SpellFlux, DesperatePower);

    /** The champion name. */
    public static final Champion Sejuani = new Champion("Sejuani", FrostArnor, ArcticAssault, FlailOfTheNorthernWinds, Permafrost, GlacialPrison);

    /** The champion name. */
    public static final Champion Shaco = new Champion("Shaco", Backstab, Deceive, JackInTheBox, TwoShivPoison, Hallucinate);

    /** The champion name. */
    public static final Champion Shen = new Champion("Shen", KiStrike, VorpalBlade, Feint, ShadowDash, StandUnited);

    /** The champion name. */
    public static final Champion Shyvana = new Champion("Shyvana", Dragonborn, TwinBite, Burnout, FlameBreath, DragonsDescent);

    /** The champion name. */
    public static final Champion Singed = new Champion("Singed", EmpoweredBulwark, PoisonTrail, MegaAdhesive, Fling, InsanityPotion);

    /** The champion name. */
    public static final Champion Sion = new Champion("Sion", FeelNoPain, CrypticGaze, DeathsCaress, Enrage, Cannibalism);

    /** The champion name. */
    public static final Champion Sivir = new Champion("Sivir", FleetOfFoot, BoomerangBlade, Ricochet, Skill.SpellShield, OnTheHunt);

    /** The champion name. */
    public static final Champion Skarner = new Champion("Skarner", Energize, CrystalSlash, CrystallineExoskeleton, Fracture, Impale);

    /** The champion name. */
    public static final Champion Sona = new Champion("Sona", PowerChord, HymnOfValor, AriaOfPerseverance, SongOfCelerity, Crescendo);

    /** The champion name. */
    public static final Champion Soraka = new Champion("Soraka", Salvation, Starcall, AstralBlessing, Infuse, Wish);

    /** The champion name. */
    public static final Champion Swain = new Champion("Swain", CarrionRenewal, Decrepify, Nevermove, Torment, RavenousFlock);

    /** The champion name. */
    public static final Champion Syndra = new Champion("Syndra", Transcendent, DarkSphere, ForceOfWill, ScatterTheWeak, UnleashedPower);

    /** The champion name. */
    public static final Champion Talon = new Champion("Talon", Mercy, NoxianDiplomacy, Rake, Cutthroat, ShadowAssault);

    /** The champion name. */
    public static final Champion Taric = new Champion("Taric", Gemcraft, Imbue, Shatter, Dazzle, Radiance);

    /** The champion name. */
    public static final Champion Teemo = new Champion("Teemo", Camouflage, BlindingDart, MoveQuick, ToxicShot, NoxiousTrap);

    /** The champion name. */
    public static final Champion Thresh = new Champion("Thresh", Damnation, DeathSentence, DarkPassage, Flay, TheBox);

    /** The champion name. */
    public static final Champion Tristana = new Champion("Tristana", DrawaBead, RapidFire, RocketJump, ExplosiveShot, BusterShot);

    /** The champion name. */
    public static final Champion Trundle = new Champion("Trundle", KingsTribute, Chomp, FrozenKingdom, PillarOfIce, Subjugate);

    /** The champion name. */
    public static final Champion Tryndamere = new Champion("Tryndamere", BattleFury, Bloodlust, MockingShout, SpinningSlash, UndyingRage);

    /** The champion name. */
    public static final Champion TwistedFate = new Champion("Twisted Fate", LoadedDice, WildCards, PickACard, StackedDeck, Destiny);

    /** The champion name. */
    public static final Champion Twitch = new Champion("Twitch", DeadlyVenom, Ambush, VenomCask, Expunge, SprayandPray);

    /** The champion name. */
    public static final Champion Udyr = new Champion("Udyr", MonkeysAgility, TigerStance, TurtleStance, BearStance, PhoenixStance);

    /** The champion name. */
    public static final Champion Urgot = new Champion("Urgot", ZaunTouchedBoltAugmenter, AcidHunter, TerrorCapacitor, NoxianCorrosiveCharge, HyperKineticPositionReverser);

    /** The champion name. */
    public static final Champion Varus = new Champion("Varus", LivingVengeance, PiercingArrow, BlightedQuiver, HailOfArrows, ChainOfCorruption);

    /** The champion name. */
    public static final Champion Vayne = new Champion("Vayne", NightHunter, Tumble, SilverBolts, Condemn, FinalHour);

    /** The champion name. */
    public static final Champion Veigar = new Champion("Veigar", Equilibrium, BalefulStrike, DarkMatter, EventHorizon, PrimordialBurst);

    /** The champion name. */
    public static final Champion Vi = new Champion("Vi", BlastShield, VaultBreaker, DentingBlows, ExcessiveForce, AssaultandBattery);

    /** The champion name. */
    public static final Champion Viktor = new Champion("Viktor", EvolvingTechnology, PowerTransfer, GravityField, DeathRay, ChaosStorm);

    /** The champion name. */
    public static final Champion Vladimir = new Champion("Vladimir", CrimsonPact, Transfusion, SanguinePool, TidesOfBlood, Hemoplague);

    /** The champion name. */
    public static final Champion Volibear = new Champion("Volibear", ChosenOftheStorm, RollingThunder, Frenzy, MajesticRoar, ThunderClaws);

    /** The champion name. */
    public static final Champion Warwick = new Champion("Warwick", EternalThirst, HungeringStrike, HuntersCall, BloodScent, InfiniteDuress);

    /** The champion name. */
    public static final Champion Wukong = new Champion("Wukong", StoneSkin, CrushingBlow, Decoy, NimbusStrike, Cyclone);

    /** The champion name. */
    public static final Champion Xerath = new Champion("Xerath", AscendedForm, Arcanopulse, LocusOfPower, ShockingOrb, RiteOfTheArcane);

    /** The champion name. */
    public static final Champion XinZhao = new Champion("Xin Zhao", Challenge, ThreeTalonStrike, BattleCry, AudaciousCharge, CrescentSweep);

    /** The champion name. */
    public static final Champion Yasuo = new Champion("Yasuo", WayOfTheWanderer, SteelTempest, WindWall, SweepingBlade, LastBreath);

    /** The champion name. */
    public static final Champion Yorick = new Champion("Yorick", UnholyCovenant, OmenOfWar, OmenOfPestilence, OmenOfFamine, OmenOfDeath);

    /** The champion name. */
    public static final Champion Zac = new Champion("Zac", CellDivision, StretchingStrike, UnstableMatter, ElasticSlingshot, LetsBounce);

    /** The champion name. */
    public static final Champion Zed = new Champion("Zed", ContemptforTheWeak, RazorShuriken, LivingShadow, ShadowSlash, DeathMark);

    /** The champion name. */
    public static final Champion Ziggs = new Champion("Ziggs", ShortFuse, BouncingBomb, SatchelCharge, HexplosiveMinefield, MegaInfernoBomb);

    /** The champion name. */
    public static final Champion Zilean = new Champion("Zilean", HeightenedLearning, TimeBomb, Rewind, TimeWarp, ChronoShift);

    /** The champion name. */
    public static final Champion Zyra = new Champion("Zyra", RiseOftheThorns, DeadlyBloom, RampantGrowth, GraspingRoots, Stranglethorns);

    /** The champion id. */
    public final int id;

    /** The name. */
    public final String name;

    /** The normalized system name. */
    public final String systemName;

    /** The skill set. */
    public final Skill[] skills;

    /** The descriptor. */
    private final ChampionStatus[] versions = new ChampionStatus[Version.values().length];

    /**
     * <p>
     * Create new champion.
     * </p>
     * 
     * @param name
     */
    Champion(String name, Skill... skills) {
        this(name, false, skills);
    }

    /**
     * <p>
     * Create new champion.
     * </p>
     * 
     * @param name
     */
    Champion(String name, boolean transformed, Skill... skills) {
        this.id = transformed ? counter : counter++;
        this.name = name;
        this.systemName = getSystemName().toLowerCase().replaceAll("[\\s'\\.]", "");
        this.skills = skills;

        if (!transformed) {
            champions.add(this);
        }
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
     * Apply icon image.
     * </p>
     */
    public void applyIcon(Element element) {
        element.css("background-image", "url(src/main/resources/teemowork/champions.jpg)")
                .css("background-position", id / (counter - 1) * 100 + "% 0%")
                .css("background-size", "cover")
                .css("background-origin", "border-box");
    }

    /**
     * <p>
     * Retrieve a descriptor at the specified version.
     * </p>
     */
    public ChampionStatus getStatus(Version version) {
        for (int i = version.ordinal(); 0 <= i; i--) {
            ChampionStatus status = versions[i];

            if (status != null) {
                return status;
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
    ChampionStatus update(Version version) {
        ChampionStatus status = new ChampionStatus(getStatus(version));
        versions[version.ordinal()] = status;

        return status;
    }

    /**
     * <p>
     * List up all champions.
     * </p>
     * 
     * @return
     */
    public static List<Champion> getAll() {
        return champions;
    }

    /**
     * <p>
     * Find champion by name.
     * </p>
     * 
     * @param name A champion name.
     * @return A matched champion.
     */
    public static Champion getByName(String name) {
        for (Champion champion : champions) {
            if (champion.systemName.equals(name)) {
                return champion;
            }
        }
        return null;
    }

    static {
        Aatrox.update(P0000)
                .set(Health, 395, 85)
                .set(Hreg, 5.75, 0.5)
                .set(Mana, 0, 0)
                .set(Mreg, 0, 0)
                .set(AD, 55, 3.2)
                .set(AS, 0.651, 3)
                .set(AR, 14, 3.8)
                .set(MR, 30, 1.25)
                .set(Range, 150)
                .set(MS, 345);
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
        Ahri.update(P315).set(Mana, 250, 50).set(Mreg, 7, 0.6);
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
                .set(MissileSpeed, 1100)
                .set(MS, 325);
        Anivia.update(P411).set(MissileSpeed, 1400);
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
        Ashe.update(P303).set(AS, 0.658, 4);
        Blitzcrank.update(P0000)
                .set(Health, 423, 95)
                .set(Hreg, 7.25, 0.75)
                .set(Mana, 200, 40)
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
        Caitlyn.update(P307).set(AS, 0.625, 4);
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
        Corki.update(P313).set(AS, 0.625, 2.3);
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
        EliseSpider.update(P0000)
                .set(Health, 395, 80)
                .set(Hreg, 4.7, 0.6)
                .set(Mana, 240, 50)
                .set(Mreg, 6.8, 0.65)
                .set(AD, 47.5, 3)
                .set(AS, 0.625, 1.75)
                .set(AR, 12.65, 3.35)
                .set(MR, 30, 0)
                .set(Range, 125)
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
                .set(AS, 0.625, 2.8)
                .set(AR, 12, 3.5)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 325);
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
                .set(Hreg, 4.25, 0.75)
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
        JayceCannon.update(P0000)
                .set(Health, 420, 90)
                .set(Hreg, 6, 0.8)
                .set(Mana, 240, 40)
                .set(Mreg, 7, 0.7)
                .set(AD, 46.5, 3.5)
                .set(AS, 0.658, 3)
                .set(AR, 12.5, 3.5)
                .set(MR, 30, 0)
                .set(Range, 500)
                .set(MS, 335);
        Jinx.update(Version.P312)
                .set(Health, 420, 80)
                .set(Hreg, 5, 0.5)
                .set(Mana, 170, 45)
                .set(Mreg, 5, 1)
                .set(AD, 50, 3)
                .set(AS, 0.625, 1)
                .set(AR, 13, 3.5)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 325);
        Jinx.update(P411).set(Health, 388, 82);
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
        Kassadin.update(P313).set(MR, 30, 0);
        Katarina.update(P0000)
                .set(Health, 395, 83)
                .set(Hreg, 6.95, 0.55)
                .set(AD, 53, 3.2)
                .set(AS, 0.658, 2.74)
                .set(AR, 14.75, 4)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
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
        Kayle.update(P303).set(MR, 30, 0);
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
        Kennen.update(P309).set(AD, 47.2, 3.3);
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
        LeBlanc.update(Version.P310A).set(Hreg, 6.5, 0.55).set(AD, 51, 3.5);
        LeeSin.update(P0000)
                .set(Health, 428, 85)
                .set(Hreg, 6.25, 0.7)
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
        Lissandra.update(P0000)
                .set(Health, 365, 84)
                .set(Hreg, 6, 0.55)
                .set(Mana, 220, 50)
                .set(Mreg, 5, 0.4)
                .set(AD, 48, 2.7)
                .set(AS, 0.625, 1.36)
                .set(AR, 10, 3.7)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 325);
        Lucian.update(P310A)
                .set(Health, 390, 80)
                .set(Hreg, 5.1, 0.65)
                .set(Mana, 230, 41)
                .set(Mreg, 6, 0.65)
                .set(AD, 46, 3)
                .set(AS, 0.638, 3.3)
                .set(AR, 15, 3)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 330);
        Lucian.update(P312).set(Mreg, 7, 0.7);
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
        Lulu.update(P306).set(Mana, 200, 55);
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
        Lux.update(P3051).set(MS, 330);
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
        MasterYi.update(P310).set(Health, 444, 92).set(Mana, 180, 42).set(AR, 15, 3).set(AS, 0.679, 2.75);
        MasterYi.update(P310A).set(AS, 0.679, 2);
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
        Morgana.update(P313).set(Range, 450).set(AS, 0.625, 1.53);
        Nami.update(P0000)
                .set(Health, 365, 74)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 305, 43)
                .set(Mreg, 6.9, 0.6)
                .set(AD, 48, 3.1)
                .set(AS, 0.644, 2.6)
                .set(AR, 9, 4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 340)
                .set(MissileSpeed, 1350);
        Nami.update(P307).set(MissileSpeed, 1500);
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
        Nautilus.update(P3051).set(AR, 19, 3.25);
        Nidalee.update(P0000)
                .set(Health, 370, 90)
                .set(Hreg, 5.0, 0.6)
                .set(Mana, 220, 45)
                .set(Mreg, 7, 0.5)
                .set(AD, 49, 3.5)
                .set(AS, 0.672, 3.22)
                .set(AR, 11, 3.5)
                .set(MR, 30, 0.75)
                .set(Range, 525)
                .set(MS, 335);
        Nidalee.update(P303).set(MR, 30, 0);
        NidaleeCougar.update(P0000)
                .set(Health, 370, 90)
                .set(Hreg, 5.0, 0.6)
                .set(Mana, 220, 45)
                .set(Mreg, 7, 0.5)
                .set(AD, 49, 3.5)
                .set(AS, 0.672, 3.22)
                .set(AR, 11, 3.5)
                .set(MR, 30, 0.75)
                .set(Range, 125)
                .set(MS, 335);
        NidaleeCougar.update(P303).set(MR, 30, 0);
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
                .set(MS, 350);
        Nunu.update(P309).set(Health, 437, 96);
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
        Olaf.update(P312).set(Mana, 190, 45);
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
        Quinn.update(P0000)
                .set(Health, 390, 85)
                .set(Hreg, 4.5, 0.55)
                .set(Mana, 210, 35)
                .set(Mreg, 6.3, 0.4)
                .set(AD, 48, 3)
                .set(AS, 0.668, 3.11)
                .set(AR, 13.5, 3.5)
                .set(MR, 30, 0)
                .set(Range, 525)
                .set(MS, 335);
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
                .set(Hreg, 5.5, 0.5)
                .set(AD, 54, 2.7)
                .set(AS, 0.625, 3.5)
                .set(AR, 15, 3.1)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 345);
        Riven.update(P411).set(AD, 51, 3);
        Riven.update(P412).set(Hreg, 2.5, 0.5);
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
        Ryze.update(P312).set(MS, 340);
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
        Sejuani.update(P306).set(Health, 440, 95).set(Hreg, 7.25, 0.85).set(AD, 52, 3.3).set(AR, 20.5, 3);
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
        Sivir.update(P313).set(AS, 0.658, 1.6);
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
        Skarner.update(P412).set(AS, 0.619, 2.1);
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
        Sona.update(P308).set(Health, 380, 70).set(AR, 8, 3.3);
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
        Soraka.update(P314).set(Health, 405, 76).set(AR, 9.4, 3.8);
        Soraka.update(P315).set(AR, 13, 3.8).set(MS, 340);
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
        Taric.update(P303).set(AD, 53, 3.5);
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
        Thresh.update(P0000)
                .set(Health, 452, 89)
                .set(Hreg, 6, 0.55)
                .set(Mana, 200, 44)
                .set(Mreg, 5, 0.7)
                .set(AD, 46, 2.2)
                .set(AS, 0.625, 2.1)
                .set(AR, 18, 0)
                .set(MR, 30, 0)
                .set(Range, 475)
                .set(MS, 335);
        Thresh.update(P310).set(Health, 411, 89).set(AR, 12, 0);
        Thresh.update(P313).set(AS, 0.625, 3);
        Thresh.update(P412).set(Range, 450);
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
        Tristana.update(P303).set(AS, 0.658, 4);
        Trundle.update(P0000)
                .set(Health, 455, 96)
                .set(Hreg, 8, 0.85)
                .set(Mana, 206, 45)
                .set(Mreg, 6.5, 0.6)
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
                .set(AS, 0.67, 2.9)
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
                .set(AR, 11.25, 3.15)
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
        Varus.update(P307).set(MS, 330);
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
        Vayne.update(P303).set(Mana, 173, 35).set(AS, 0.658, 4);
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
        Vi.update(P303).set(AD, 51, 3.5);
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
                .set(AS, 0.658, 2.9)
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
                .set(Mreg, 7, 0.6)
                .set(AD, 52, 3)
                .set(AS, 0.625, 1.36)
                .set(AR, 12.6, 3.4)
                .set(MR, 30, 0)
                .set(Range, 550)
                .set(MS, 340);
        Xerath.update(P412).set(Mana, 238, 47).set(Mreg, 6, 0.65).set(Range, 525);
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
        Yasuo.update(P315)
                .set(Health, 430, 82)
                .set(Hreg, 5, 0.9)
                .set(AD, 50, 3.2)
                .set(AS, 0.658, 4)
                .set(AR, 16, 3.4)
                .set(MR, 30, 0)
                .set(Range, 175)
                .set(MS, 350);
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
        Zac.update(P0000)
                .set(Health, 455, 95)
                .set(Hreg, 12.5, 0.55)
                .set(AD, 54, 3.375)
                .set(AS, 0.638, 1.6)
                .set(AR, 14, 3.5)
                .set(MR, 30, 1.25)
                .set(Range, 125)
                .set(MS, 335);
        Zac.update(P307).set(Hreg, 7, 0.55);
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
    }
}
