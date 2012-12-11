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

import static teemowork.model.Item.*;

import java.util.Map;

import js.util.HashMap;

/**
 * @version 2012/12/06 23:07:37
 */
public class Patch {

    /** The update number. */
    public final int number;

    /** The update name. */
    public final String name;

    /** The previous {@link Patch}. */
    private final Patch previous;

    /** The champion list. */
    private final Map<String, Champion> champions = new HashMap();

    /** The item list. */
    private final Map<String, Item> items = new HashMap();

    /**
     * Create patch information.
     */
    private Patch(int number, int year, int month, int day, String name, Patch previous) {
        this.number = number;
        this.name = name;
        this.previous = previous;
    }

    /**
     * <p>
     * Update item.
     * </p>
     * 
     * @param name
     */
    private Item updateItem(String name) {
        Item item = new Item(name, this);
        items.put(name, item);

        return item;
    }

    /**
     * <p>
     * Update item.
     * </p>
     * 
     * @param name
     */
    private Champion update(Champion champion) {
        // update champion status
        champion.status = new ChampionStatus(this, champion.status);

        // Chainable API
        return champion;
    }

    /** The patch. */
    public static Patch P0000 = new Patch(1510, 2012, 11, 13, "Initial", null);

    static {
        P0000.updateItem(RubyCrystal).cost(475).health(180);
        P0000.updateItem(HauntingGuise).health(200).ap(25);

        P0000.update(Champion.Ahri);
        P0000.update(Champion.Akali);
        P0000.update(Champion.Alistar);
        P0000.update(Champion.Amumu);
        P0000.update(Champion.Ashe);
        P0000.update(Champion.Blitzcrank);
        P0000.update(Champion.Brand);
        P0000.update(Champion.Caitlyn);
        P0000.update(Champion.Cassiopeia);
        P0000.update(Champion.Chogath);
        P0000.update(Champion.Corki);
        P0000.update(Champion.Darius);
        P0000.update(Champion.Diana);
        P0000.update(Champion.DrMundo);
        P0000.update(Champion.Elise);
        P0000.update(Champion.Evelynn);
        P0000.update(Champion.Ezreal);
        P0000.update(Champion.Fiddlesticks);
        P0000.update(Champion.Fiora);
        P0000.update(Champion.Fizz);
        P0000.update(Champion.Galio);
        P0000.update(Champion.Gangplank);
        P0000.update(Champion.Garen);
        P0000.update(Champion.Gragas);
        P0000.update(Champion.Graves);
        P0000.update(Champion.Hecarim);
        P0000.update(Champion.Heimerdinger);
        P0000.update(Champion.Irelia);
        P0000.update(Champion.Janna);
        P0000.update(Champion.JarvanIV);
        P0000.update(Champion.Jax);
        P0000.update(Champion.Jayce);
        P0000.update(Champion.Karma);
        P0000.update(Champion.Karthus);
        P0000.update(Champion.Kassadin);
        P0000.update(Champion.Katarina);
        P0000.update(Champion.Kayle);
        P0000.update(Champion.Kennen);
        P0000.update(Champion.KhaZix);
        P0000.update(Champion.KogMaw);
        P0000.update(Champion.LeBlanc);
        P0000.update(Champion.LeeSin);
        P0000.update(Champion.Leona);
        P0000.update(Champion.Lulu);
        P0000.update(Champion.Lux);
        P0000.update(Champion.Malphite);
        P0000.update(Champion.Maokai);
        P0000.update(Champion.MasterYi);
        P0000.update(Champion.MissFortune);
        P0000.update(Champion.Mordekaiser);
        P0000.update(Champion.Morgana);
        P0000.update(Champion.Nasus);
        P0000.update(Champion.Nautilus);
        P0000.update(Champion.Nidalee);
        P0000.update(Champion.Nocturne);
        P0000.update(Champion.Nunu);
        P0000.update(Champion.Olaf);
        P0000.update(Champion.Orianna);
        P0000.update(Champion.Pantheon);
        P0000.update(Champion.Poppy);
        P0000.update(Champion.Rammus);
        P0000.update(Champion.Renekton);
        P0000.update(Champion.Rengar);
        P0000.update(Champion.Riven);
        P0000.update(Champion.Rumble);
        P0000.update(Champion.Ryze);
        P0000.update(Champion.Sejuani);
        P0000.update(Champion.Shaco);
        P0000.update(Champion.Shen);
        P0000.update(Champion.Shyvana);
        P0000.update(Champion.Singed);
        P0000.update(Champion.Sion);
        P0000.update(Champion.Sivir);
        P0000.update(Champion.Skarner);
        P0000.update(Champion.Sona);
        P0000.update(Champion.Soraka);
        P0000.update(Champion.Swain);
        P0000.update(Champion.Syndra);
        P0000.update(Champion.Talon);
        P0000.update(Champion.Taric);
        P0000.update(Champion.Teemo);
        P0000.update(Champion.Tristana);
        P0000.update(Champion.Trundle);
        P0000.update(Champion.Tryndamere);
        P0000.update(Champion.TwistedFate);
        P0000.update(Champion.Twitch);
        P0000.update(Champion.Udyr);
        P0000.update(Champion.Urgot);
        P0000.update(Champion.Varus);
        P0000.update(Champion.Vayne);
        P0000.update(Champion.Veigar);
        P0000.update(Champion.Viktor);
        P0000.update(Champion.Vladimir);
        P0000.update(Champion.Volibear);
        P0000.update(Champion.Warwick);
        P0000.update(Champion.Wukong);
        P0000.update(Champion.Xerath);
        P0000.update(Champion.XinZhao);
        P0000.update(Champion.Yorick);
        P0000.update(Champion.Zed);
        P0000.update(Champion.Ziggs);
        P0000.update(Champion.Zilean);
        P0000.update(Champion.Zyra);
    }

    /** The patch. */
    public static Patch P1520 = new Patch(1520, 2012, 12, 03, "Preseason 3", P0000);

    static {
        P1520.updateItem(ShardOfTrueIce);
        P1520.updateItem(LiandrysTorment);
        P1520.updateItem(HauntingGuise);
    }

    /** The latest patch. */
    public static Patch Latest = P1520;
}
