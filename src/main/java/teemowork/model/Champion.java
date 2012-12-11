/*
 * Copyright (C) 2012 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package teemowork.model;

import java.util.Collection;
import java.util.Map;

import js.util.HashMap;

/**
 * @version 2012/11/27 18:19:08
 */
public class Champion {

    /** The item manager. */
    private static final Map<String, Champion> champions = new HashMap();

    /** The name. */
    public final String name;

    /** The current status. */
    ChampionStatus status;

    /**
     * <p>
     * Create with initial status.
     * </p>
     * 
     * @param name
     */
    private Champion(String name) {
        this.name = name;

        // register by name
        champions.put(name, this);
    }

    public String getSystemName() {
        return name.replace("\\.", "").replace("\\s", "").replace("\\'", "");
    }

    /**
     * <p>
     * Retrieve item by name.
     * </p>
     * 
     * @param name
     * @return
     */
    public static Champion getByName(String name) {
        return champions.get(name);
    }

    /**
     * <p>
     * Retrieve all items.
     * </p>
     * 
     * @return
     */
    public static Collection<Champion> getAll() {
        return champions.values();
    }

    /** The champion definition. */
    public static Champion Ahri = new Champion("Ahri");

    /** The champion definition. */
    public static Champion Akali = new Champion("Akali");

    /** The champion definition. */
    public static Champion Alistar = new Champion("Alistar");

    /** The champion definition. */
    public static Champion Amumu = new Champion("Amumu");

    /** The champion definition. */
    public static Champion Ashe = new Champion("Ashe");

    /** The champion definition. */
    public static Champion Blitzcrank = new Champion("Blitzcrank");

    /** The champion definition. */
    public static Champion Brand = new Champion("Brand");

    /** The champion definition. */
    public static Champion Caitlyn = new Champion("Caitlyn");

    /** The champion definition. */
    public static Champion Cassiopeia = new Champion("Cassiopeia");

    /** The champion definition. */
    public static Champion Chogath = new Champion("Chogath");

    /** The champion definition. */
    public static Champion Corki = new Champion("Corki");

    /** The champion definition. */
    public static Champion Darius = new Champion("Darius");

    /** The champion definition. */
    public static Champion Diana = new Champion("Diana");

    /** The champion definition. */
    public static Champion DrMundo = new Champion("Dr.Mundo");

    /** The champion definition. */
    public static Champion Elise = new Champion("Elise");

    /** The champion definition. */
    public static Champion Evelynn = new Champion("Evelynn");

    /** The champion definition. */
    public static Champion Ezreal = new Champion("Ezreal");

    /** The champion definition. */
    public static Champion Fiddlesticks = new Champion("Fiddlesticks");

    /** The champion definition. */
    public static Champion Fiora = new Champion("Fiora");

    /** The champion definition. */
    public static Champion Fizz = new Champion("Fizz");

    /** The champion definition. */
    public static Champion Galio = new Champion("Galio");

    /** The champion definition. */
    public static Champion Gangplank = new Champion("Gangplank");

    /** The champion definition. */
    public static Champion Garen = new Champion("Garen");

    /** The champion definition. */
    public static Champion Gragas = new Champion("Gragas");

    /** The champion definition. */
    public static Champion Graves = new Champion("Graves");

    /** The champion definition. */
    public static Champion Hecarim = new Champion("Hecarim");

    /** The champion definition. */
    public static Champion Heimerdinger = new Champion("Heimerdinger");

    /** The champion definition. */
    public static Champion Irelia = new Champion("Irelia");

    /** The champion definition. */
    public static Champion Janna = new Champion("Janna");

    /** The champion definition. */
    public static Champion JarvanIV = new Champion("Jarvan IV");

    /** The champion definition. */
    public static Champion Jax = new Champion("Jax");

    /** The champion definition. */
    public static Champion Jayce = new Champion("Jayce");

    /** The champion definition. */
    public static Champion Karma = new Champion("Karma");

    /** The champion definition. */
    public static Champion Karthus = new Champion("Karthus");

    /** The champion definition. */
    public static Champion Kassadin = new Champion("Kassadin");

    /** The champion definition. */
    public static Champion Katarina = new Champion("Katarina");

    /** The champion definition. */
    public static Champion Kayle = new Champion("Kayle");

    /** The champion definition. */
    public static Champion Kennen = new Champion("Kennen");

    /** The champion definition. */
    public static Champion KhaZix = new Champion("Kha'zix");

    /** The champion definition. */
    public static Champion KogMaw = new Champion("Kog'maw");

    /** The champion definition. */
    public static Champion LeBlanc = new Champion("LeBlanc");

    /** The champion definition. */
    public static Champion LeeSin = new Champion("Lee Sin");

    /** The champion definition. */
    public static Champion Leona = new Champion("Leona");

    /** The champion definition. */
    public static Champion Lulu = new Champion("Lulu");

    /** The champion definition. */
    public static Champion Lux = new Champion("Lux");

    /** The champion definition. */
    public static Champion Malphite = new Champion("Malphite");

    /** The champion definition. */
    public static Champion Maokai = new Champion("Maokai");

    /** The champion definition. */
    public static Champion MasterYi = new Champion("Master Yi");

    /** The champion definition. */
    public static Champion MissFortune = new Champion("Miss Fortune");

    /** The champion definition. */
    public static Champion Mordekaiser = new Champion("Mordekaiser");

    /** The champion definition. */
    public static Champion Morgana = new Champion("Morgana");

    /** The champion definition. */
    public static Champion Nasus = new Champion("Nasus");

    /** The champion definition. */
    public static Champion Nautilus = new Champion("Nautilus");

    /** The champion definition. */
    public static Champion Nidalee = new Champion("Nidalee");

    /** The champion definition. */
    public static Champion Nocturne = new Champion("Nocturne");

    /** The champion definition. */
    public static Champion Nunu = new Champion("Nunu");

    /** The champion definition. */
    public static Champion Olaf = new Champion("Olaf");

    /** The champion definition. */
    public static Champion Orianna = new Champion("Orianna");

    /** The champion definition. */
    public static Champion Pantheon = new Champion("Pantheon");

    /** The champion definition. */
    public static Champion Poppy = new Champion("Poppy");

    /** The champion definition. */
    public static Champion Rammus = new Champion("Rammus");

    /** The champion definition. */
    public static Champion Renekton = new Champion("Renekton");

    /** The champion definition. */
    public static Champion Rengar = new Champion("Rengar");

    /** The champion definition. */
    public static Champion Riven = new Champion("Riven");

    /** The champion definition. */
    public static Champion Rumble = new Champion("Rumble");

    /** The champion definition. */
    public static Champion Ryze = new Champion("Ryze");

    /** The champion definition. */
    public static Champion Sejuani = new Champion("Sejuani");

    /** The champion definition. */
    public static Champion Shaco = new Champion("Shaco");

    /** The champion definition. */
    public static Champion Shen = new Champion("Shen");

    /** The champion definition. */
    public static Champion Shyvana = new Champion("Shyvana");

    /** The champion definition. */
    public static Champion Singed = new Champion("Singed");

    /** The champion definition. */
    public static Champion Sion = new Champion("Sion");

    /** The champion definition. */
    public static Champion Sivir = new Champion("Sivir");

    /** The champion definition. */
    public static Champion Skarner = new Champion("Skarner");

    /** The champion definition. */
    public static Champion Sona = new Champion("Sona");

    /** The champion definition. */
    public static Champion Soraka = new Champion("Soraka");

    /** The champion definition. */
    public static Champion Swain = new Champion("Swain");

    /** The champion definition. */
    public static Champion Syndra = new Champion("Syndra");

    /** The champion definition. */
    public static Champion Talon = new Champion("Talon");

    /** The champion definition. */
    public static Champion Taric = new Champion("Taric");

    /** The champion definition. */
    public static Champion Teemo = new Champion("Teemo");

    /** The champion definition. */
    public static Champion Tristana = new Champion("Tristana");

    /** The champion definition. */
    public static Champion Trundle = new Champion("Trundle");

    /** The champion definition. */
    public static Champion Tryndamere = new Champion("Tryndamere");

    /** The champion definition. */
    public static Champion TwistedFate = new Champion("Twisted Fate");

    /** The champion definition. */
    public static Champion Twitch = new Champion("Twitch");

    /** The champion definition. */
    public static Champion Udyr = new Champion("Udyr");

    /** The champion definition. */
    public static Champion Urgot = new Champion("Urgot");

    /** The champion definition. */
    public static Champion Varus = new Champion("Varus");

    /** The champion definition. */
    public static Champion Vayne = new Champion("Vayne");

    /** The champion definition. */
    public static Champion Veigar = new Champion("Veigar");

    /** The champion definition. */
    public static Champion Viktor = new Champion("Viktor");

    /** The champion definition. */
    public static Champion Vladimir = new Champion("Vladimir");

    /** The champion definition. */
    public static Champion Volibear = new Champion("Volibear");

    /** The champion definition. */
    public static Champion Warwick = new Champion("Warwick");

    /** The champion definition. */
    public static Champion Wukong = new Champion("Wukong");

    /** The champion definition. */
    public static Champion Xerath = new Champion("Xerath");

    /** The champion definition. */
    public static Champion XinZhao = new Champion("Xin Zhao");

    /** The champion definition. */
    public static Champion Yorick = new Champion("Yorick");

    /** The champion definition. */
    public static Champion Zed = new Champion("Zed");

    /** The champion definition. */
    public static Champion Ziggs = new Champion("Ziggs");

    /** The champion definition. */
    public static Champion Zilean = new Champion("Zilean");

    /** The champion definition. */
    public static Champion Zyra = new Champion("Zyra");
}
