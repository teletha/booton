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
     * @param Title
     */
    private ChampionStatus update(Champion champion) {
        // update champion status
        champion.status = new ChampionStatus(this, champion.status);

        // Chainable API
        return champion.status;
    }

    /** The patch. */
    public static Patch P0000 = new Patch(1510, 2012, 11, 13, "Initial", null);

    static {
        P0000.updateItem(RubyCrystal).cost(475).health(180);
        P0000.updateItem(HauntingGuise).health(200).ap(25);

        P0000.update(Champion.Ahri)
                .health(380, 80)
                .hreg(5.5, 0.6)
                .mana(230, 50)
                .mreg(6.25, 0.6)
                .ad(50, 3)
                .as(0.668, 2)
                .ar(10, 3.5)
                .mr(30, 0)
                .range(550)
                .ms(330);
        P0000.update(Champion.Akali)
                .health(445, 85)
                .hreg(7.25, 0.65)
                .energy(200)
                .ereg(50)
                .ad(53, 3.2)
                .as(0.694, 3.1)
                .ar(16.5, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Alistar)
                .health(442, 102)
                .hreg(7.25, 0.85)
                .mana(215, 38)
                .mreg(6.45, 0.45)
                .ad(55.03, 3.62)
                .as(0.625, 3.62)
                .ar(14.5, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(325);
        P0000.update(Champion.Amumu)
                .health(472, 84)
                .hreg(7.45, 0.85)
                .mana(220, 40)
                .mreg(6.5, 0.525)
                .ad(47, 3.8)
                .as(0.638, 2.18)
                .ar(18, 3.3)
                .mr(30, 1.25)
                .range(125)
                .ms(335);
        P0000.update(Champion.Anivia)
                .health(350, 70)
                .hreg(4.65, 0.55)
                .mana(257, 53)
                .mreg(7.0, 0.6)
                .ad(48, 3.2)
                .as(0.625, 1.68)
                .ar(10.5, 4)
                .mr(30, 0)
                .range(600)
                .ms(325);
        P0000.update(Champion.Annie)
                .health(384, 76)
                .hreg(4.5, 0.55)
                .mana(250, 50)
                .mreg(6.9, 0.6)
                .ad(49, 2.625)
                .as(0.579, 1.36)
                .ar(12.5, 4)
                .mr(30, 0)
                .range(625)
                .ms(335);
        P0000.update(Champion.Ashe)
                .health(395, 79)
                .hreg(4.5, 0.55)
                .mana(173, 35)
                .mreg(6.3, 0.4)
                .ad(46.3, 2.85)
                .as(0.658, 3.34)
                .ar(11.5, 3.4)
                .mr(30, 0)
                .range(600)
                .ms(325);
        P0000.update(Champion.Blitzcrank)
                .health(423, 95)
                .hreg(7.25, 0.75)
                .mana(260, 40)
                .mreg(6.6, 0.5)
                .ad(55.66, 3.5)
                .as(0.625, 1.13)
                .ar(14.5, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(325);
        P0000.update(Champion.Brand)
                .health(380, 76)
                .hreg(4.5, 0.55)
                .mana(250, 45)
                .mreg(7, 0.6)
                .ad(51.66, 3)
                .as(0.625, 1.36)
                .ar(12, 3.5)
                .mr(30, 0)
                .range(550)
                .ms(340);
        P0000.update(Champion.Caitlyn)
                .health(390, 80)
                .hreg(4.75, 0.55)
                .mana(255, 35)
                .mreg(6.5, 0.55)
                .ad(47, 3)
                .as(0.668, 3)
                .ar(13, 3.5)
                .mr(30, 0)
                .range(650)
                .ms(325);
        P0000.update(Champion.Cassiopeia)
                .health(380, 75)
                .hreg(4.85, 0.5)
                .mana(250, 50)
                .mreg(7.1, 0.75)
                .ad(47, 3.2)
                .as(0.644, 1.68)
                .ar(11.5, 4)
                .mr(30, 0)
                .range(550)
                .ms(335);
        P0000.update(Champion.Chogath)
                .health(440, 80)
                .hreg(7.5, 0.85)
                .mana(205, 40)
                .mreg(6.45, 0.45)
                .ad(54.1, 4.2)
                .as(0.625, 1.44)
                .ar(19, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Corki)
                .health(375, 82)
                .hreg(4.5, 0.55)
                .mana(243, 37)
                .mreg(6.5, 0.55)
                .ad(48.2, 3)
                .as(0.658, 2.3)
                .ar(13.5, 3.5)
                .mr(30, 0)
                .range(550)
                .ms(325);
        P0000.update(Champion.Darius)
                .health(426, 93)
                .hreg(8.25, 0.95)
                .mana(200, 37.5)
                .mreg(6, 0.35)
                .ad(50, 3.5)
                .as(0.679, 2.6)
                .ar(20, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(340);
        P0000.update(Champion.Diana)
                .health(438, 90)
                .hreg(7, 0.85)
                .mana(230, 40)
                .mreg(7, 0.6)
                .ad(48, 3)
                .as(0.625, 2.25)
                .ar(16, 3.6)
                .mr(30, 1.25)
                .range(150)
                .ms(345);
        P0000.update(Champion.DrMundo)
                .health(433, 89)
                .hreg(6.5, 0.75)
                .ad(56.23, 3)
                .as(0.625, 2.8)
                .ar(17, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Draven)
                .health(420, 82)
                .hreg(5, 0.7)
                .mana(240, 42)
                .mreg(6.95, 0.65)
                .ad(46.5, 3.5)
                .as(0.679, 2.6)
                .ar(16, 3.3)
                .mr(30, 0)
                .range(550)
                .ms(330);
        P0000.update(Champion.Elise)
                .health(395, 80)
                .hreg(4.7, 0.6)
                .mana(240, 50)
                .mreg(6.8, 0.65)
                .ad(47.5, 3)
                .as(0.625, 1.75)
                .ar(12.65, 3.35)
                .mr(30, 0)
                .range(550)
                .ms(335);
        P0000.update(Champion.Evelynn)
                .health(414, 86)
                .hreg(6.95, 0.55)
                .mana(180, 42)
                .mreg(7.1, 0.6)
                .ad(48, 3.3)
                .as(0.658, 3.84)
                .ar(12.5, 4)
                .mr(30, 1.25)
                .range(125)
                .ms(340);
        P0000.update(Champion.Ezreal)
                .health(350, 80)
                .hreg(5.5, 0.55)
                .mana(235, 45)
                .mreg(7, 0.65)
                .ad(47.2, 3)
                .as(0.665, 2.8)
                .ar(12, 3.5)
                .mr(30, 0)
                .range(550)
                .ms(330);
        P0000.update(Champion.Fiddlesticks)
                .health(390, 80)
                .hreg(4.6, 0.6)
                .mana(251, 59)
                .mreg(6.9, 0.65)
                .ad(45.95, 2.625)
                .as(0.625, 2.11)
                .ar(11, 3.5)
                .mr(30, 0)
                .range(480)
                .ms(335);
        P0000.update(Champion.Fiora)
                .health(450, 85)
                .hreg(6.3, 0.8)
                .mana(220, 40)
                .mreg(7.25, 0.5)
                .ad(54.5, 3.2)
                .as(0.672, 3)
                .ar(15.5, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Fizz)
                .health(414, 86)
                .hreg(7.0, 0.7)
                .mana(200, 40)
                .mreg(6.15, 0.45)
                .ad(53, 3)
                .as(0.658, 3.1)
                .ar(13, 3.4)
                .mr(30, 1.25)
                .range(175)
                .ms(335);
        P0000.update(Champion.Galio)
                .health(435, 85)
                .hreg(7.45, 0.75)
                .mana(235, 50)
                .mreg(7, 0.7)
                .ad(56.3, 3.375)
                .as(0.638, 1.2)
                .ar(17, 3.5)
                .mr(30, 0)
                .range(125)
                .ms(335);
        P0000.update(Champion.Gangplank)
                .health(495, 81)
                .hreg(425, 0.75)
                .mana(215, 40)
                .mreg(6.5, 0.7)
                .ad(54, 3)
                .as(0.651, 2.75)
                .ar(16.5, 3.3)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Garen)
                .health(455, 96)
                .hreg(7.5, 0.75)
                .ad(52.5, 3.5)
                .as(0.625, 2.9)
                .ar(19, 2.7)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Gragas)
                .health(434, 89)
                .hreg(7.25, 0.85)
                .mana(221, 47)
                .mreg(6.45, 0.45)
                .ad(55.78, 3.375)
                .as(0.651, 2.05)
                .ar(16, 3.6)
                .mr(30, 0)
                .range(125)
                .ms(340);
        P0000.update(Champion.Graves)
                .health(410, 84)
                .hreg(5.5, 0.7)
                .mana(255, 40)
                .mreg(6.75, 0.7)
                .ad(51, 3.1)
                .as(0.625, 2.9)
                .ar(15, 3.2)
                .mr(30, 0)
                .range(525)
                .ms(330);
        P0000.update(Champion.Hecarim)
                .health(440, 95)
                .hreg(8, 0.75)
                .mana(210, 40)
                .mreg(6.5, 0.6)
                .ad(56, 3.2)
                .as(0.67, 2.5)
                .ar(16, 4)
                .mr(30, 1.25)
                .range(175)
                .ms(345);
        P0000.update(Champion.Heimerdinger)
                .health(350, 75)
                .hreg(4.5, 0.55)
                .mana(240, 65)
                .mreg(7, 0.65)
                .ad(49.24, 3)
                .as(0.625, 1.21)
                .ar(7, 3)
                .mr(30, 0)
                .range(550)
                .ms(325);
        P0000.update(Champion.Irelia)
                .health(456, 90)
                .hreg(7.5, 0.65)
                .mana(230, 35)
                .mreg(7, 0.65)
                .ad(56, 3.3)
                .as(0.665, 3.2)
                .ar(15, 3.75)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Janna)
                .health(356, 78)
                .hreg(4.5, 0.55)
                .mana(302, 64)
                .mreg(6.9, 0.6)
                .ad(49, 2.95)
                .as(0.625, 2.61)
                .ar(9, 3.8)
                .mr(30, 0)
                .range(475)
                .ms(335);
        P0000.update(Champion.JarvanIV)
                .health(420, 90)
                .hreg(7, 0.7)
                .mana(235, 40)
                .mreg(6, 0.45)
                .ad(50, 3.4)
                .as(0.658, 2.5)
                .ar(14, 3)
                .mr(30, 1.25)
                .range(175)
                .ms(340);
        P0000.update(Champion.Jax)
                .health(463, 98)
                .hreg(7.45, 0.55)
                .mana(230, 35)
                .mreg(6.4, 0.7)
                .ad(56.3, 3.375)
                .as(0.638, 3.4)
                .ar(18, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Jayce)
                .health(420, 90)
                .hreg(6, 0.8)
                .mana(240, 40)
                .mreg(7, 0.7)
                .ad(46.5, 3.5)
                .as(0.658, 3)
                .ar(12.5, 3.5)
                .mr(30, 0)
                .range(125)
                .ms(335);
        P0000.update(Champion.Karma)
                .health(410, 86)
                .hreg(4.7, 0.55)
                .mana(240, 60)
                .mreg(6.8, 0.65)
                .ad(50, 3.3)
                .as(0.625, 2.3)
                .ar(15, 3.5)
                .mr(30, 0)
                .range(425)
                .ms(335);
        P0000.update(Champion.Karthus)
                .health(390, 75)
                .hreg(5.5, 0.55)
                .mana(270, 61)
                .mreg(6.5, 0.6)
                .ad(42.2, 3.25)
                .as(0.625, 2.11)
                .ar(11, 3.5)
                .mr(30, 0)
                .range(450)
                .ms(335);
        P0000.update(Champion.Kassadin)
                .health(433, 78)
                .hreg(6.95, 0.5)
                .mana(230, 45)
                .mreg(6.9, 0.6)
                .ad(52.3, 3.9)
                .as(0.638, 3.7)
                .ar(14, 3.2)
                .mr(30, 1.25)
                .range(125)
                .ms(340);
        P0000.update(Champion.Katarina)
                .health(395, 83)
                .hreg(6.95, 0.55)
                .ad(53, 3.2)
                .as(0.658, 2.74)
                .ar(14.75, 4)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Kayle)
                .health(418, 93)
                .hreg(7, 0.75)
                .mana(255, 40)
                .mreg(6.9, 0.525)
                .ad(53.3, 2.8)
                .as(0.638, 2.5)
                .ar(17, 3.5)
                .mr(30, 0.75)
                .range(125)
                .ms(335);
        P0000.update(Champion.Kennen)
                .health(403, 79)
                .hreg(4.65, 0.65)
                .energy(200)
                .ereg(50)
                .ad(51.3, 3.3)
                .as(0.69, 3.4)
                .ar(14, 3.75)
                .mr(30, 0)
                .range(550)
                .ms(335);
        P0000.update(Champion.KhaZix)
                .health(430, 85)
                .hreg(6.25, 0.75)
                .mana(260, 40)
                .mreg(6.75, 0.5)
                .ad(50, 3.1)
                .as(0.665, 2.7)
                .ar(15, 3)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.KogMaw)
                .health(440, 84)
                .hreg(5, 0.55)
                .mana(295, 40)
                .mreg(7.5, 0.7)
                .ad(46, 3)
                .as(0.665, 2.65)
                .ar(13, 3.53)
                .mr(30, 0)
                .range(500)
                .ms(340);
        P0000.update(Champion.LeBlanc)
                .health(390, 75)
                .hreg(4.5, 0.55)
                .mana(250, 50)
                .mreg(6.9, 0.6)
                .ad(51, 3.1)
                .as(0.625, 1.4)
                .ar(12, 3.5)
                .mr(30, 0)
                .range(525)
                .ms(335);
        P0000.update(Champion.LeeSin)
                .health(428, 85)
                .hreg(6.25, 075)
                .ereg(200)
                .ereg(50)
                .ad(55.8, 3.2)
                .as(0.651, 3)
                .ar(16, 3.7)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Leona)
                .health(430, 87)
                .hreg(9, 0.85)
                .mana(235, 40)
                .mreg(8, 0.7)
                .ad(55, 3)
                .as(0.625, 2.9)
                .ar(18, 3.1)
                .mr(30, 1.25)
                .range(125)
                .ms(335);
        P0000.update(Champion.Lulu)
                .health(415, 82)
                .hreg(6, 0.72)
                .mana(200, 50)
                .mreg(6, 0.6)
                .ad(44.4, 2.6)
                .as(0.625, 2.2)
                .ar(9, 3.7)
                .mr(30, 0)
                .range(550)
                .ms(325);
        P0000.update(Champion.Lux)
                .health(345, 79)
                .hreg(4.5, 0.55)
                .mana(250, 50)
                .mreg(6, 0.6)
                .ad(50, 3.3)
                .as(0.625, 1.36)
                .ar(8, 4)
                .mr(30, 0)
                .range(550)
                .ms(340);
        P0000.update(Champion.Malphite)
                .health(423, 90)
                .hreg(7.45, 0.55)
                .mana(215, 40)
                .mreg(6.4, 0.55)
                .ad(56.3, 3.375)
                .as(0.638, 3.4)
                .ar(18, 3.75)
                .mr(30, 1.25)
                .range(125)
                .ms(335);
        P0000.update(Champion.Malzahar)
                .health(380, 80)
                .hreg(4.5, 0.55)
                .mana(250, 45)
                .mreg(7, 0.6)
                .ad(51.66, 3)
                .as(0.625, 1.36)
                .ar(15, 3.5)
                .mr(30, 0)
                .range(550)
                .ms(340);
        P0000.update(Champion.Maokai)
                .health(421, 90)
                .hreg(7.25, 0.85)
                .mana(250, 46)
                .mreg(6.45, 0.45)
                .ad(58, 3.3)
                .as(0.694, 2.13)
                .ar(18, 4)
                .mr(30, 0)
                .range(125)
                .ms(335);
        P0000.update(Champion.MasterYi)
                .health(444, 86)
                .hreg(6.75, 0.65)
                .mana(199, 36)
                .mreg(6.5, 0.45)
                .ad(55.12, 3.1)
                .as(0.679, 2.98)
                .ar(16.3, 3.7)
                .mr(30, 1.25)
                .range(125)
                .ms(355);
        P0000.update(Champion.MissFortune)
                .health(435, 85)
                .hreg(5.1, 0.65)
                .mana(212, 38)
                .mreg(6.95, 0.65)
                .ad(46.5, 3)
                .as(0.658, 3.01)
                .ar(15, 3)
                .mr(30, 0)
                .range(550)
                .ms(325);
        P0000.update(Champion.Mordekaiser)
                .health(421, 80)
                .hreg(7.45, 0.55)
                .ad(51.7, 3.5)
                .as(0.694, 3)
                .ar(15, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(340);
        P0000.update(Champion.Morgana)
                .health(403, 86)
                .hreg(4.7, 0.6)
                .mana(240, 60)
                .mreg(6.8, 0.65)
                .ad(51.58, 3.5)
                .as(0.579, 1.53)
                .ar(15, 3.8)
                .mr(30, 0)
                .range(425)
                .ms(335);
        P0000.update(Champion.Nami)
                .health(365, 74)
                .hreg(4.5, 055)
                .mana(305, 43)
                .mreg(6.9, 0.6)
                .ad(48, 3.1)
                .as(0.644, 2.6)
                .ar(9, 4)
                .mr(30, 0)
                .range(550)
                .ms(330);
        P0000.update(Champion.Nasus)
                .health(410, 90)
                .hreg(7.5, 0.9)
                .mana(200, 45)
                .mreg(6.6, 0.5)
                .ad(53.3, 3.5)
                .as(0.638, 3.48)
                .ar(15, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Nautilus)
                .health(432, 86)
                .hreg(7.45, 0.55)
                .mana(200, 50)
                .mreg(7.45, 0.7)
                .ad(52, 3.3)
                .as(0.613, 0.98)
                .ar(12, 3.25)
                .mr(30, 1.25)
                .range(175)
                .ms(325);
        P0000.update(Champion.Nidalee)
                .health(370, 90)
                .hreg(5.0, 0.6)
                .mana(220, 45)
                .mreg(7, 0.5)
                .ad(49, 3.5)
                .as(0.672, 3.22)
                .ar(11, 3.5)
                .mr(30, 10.75)
                .range(525)
                .ms(335);
        P0000.update(Champion.Nocturne)
                .health(430, 85)
                .hreg(7, 0.75)
                .mana(215, 35)
                .mreg(6, 0.45)
                .ad(54, 3.1)
                .as(0.668, 2.7)
                .ar(17, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Nunu)
                .health(437, 108)
                .hreg(7.05, 0.8)
                .mana(213, 42)
                .mreg(6.6, 0.5)
                .ad(51.6, 3.4)
                .as(0.625, 2.25)
                .ar(16.5, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(340);
        P0000.update(Champion.Olaf)
                .health(441, 93)
                .hreg(7, 0.9)
                .mana(225, 45)
                .mreg(6.5, 0.575)
                .ad(54.1, 3.5)
                .as(0.694, 2.7)
                .ar(17, 3)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Orianna)
                .health(385, 79)
                .hreg(5.95, 0.55)
                .mana(250, 50)
                .mreg(7, 0.5)
                .ad(44, 2.6)
                .as(0.658, 3.5)
                .ar(8, 3)
                .mr(30, 0)
                .range(525)
                .ms(325);
        P0000.update(Champion.Pantheon)
                .health(433, 87)
                .hreg(6.75, 0.65)
                .mana(210, 34)
                .mreg(6.6, 0.45)
                .ad(50.7, 2.9)
                .as(0.679, 2.95)
                .ar(17.1, 3.9)
                .mr(30, 1.25)
                .range(155)
                .ms(355);
        P0000.update(Champion.Poppy)
                .health(423, 81)
                .hreg(7.45, 0.55)
                .mana(185, 30)
                .mreg(6.4, 0.45)
                .ad(56.3, 3.375)
                .as(0.638, 3.35)
                .ar(18, 4)
                .mr(30, 0)
                .range(125)
                .ms(345);
        P0000.update(Champion.Rammus)
                .health(420, 86)
                .hreg(8, 0.55)
                .mana(255, 33)
                .mreg(4.5, 0.3)
                .ad(50, 3.5)
                .as(0.625, 2.22)
                .ar(21, 3.8)
                .mr(30, 1.25)
                .range(125)
                .ms(335);
        P0000.update(Champion.Renekton)
                .health(426, 87)
                .hreg(6.7, 0.75)
                .ad(53.12, 3.1)
                .as(0.665, 2.65)
                .ar(15.2, 3.8)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Rengar)
                .health(435, 85)
                .hreg(4, 0.4)
                .ad(55, 3)
                .as(0.679, 2.85)
                .ar(16, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Riven)
                .health(414, 86)
                .hreg(10.4, 0.9)
                .ad(54, 2.75)
                .as(0.625, 3.5)
                .ar(15, 3.1)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Rumble)
                .health(450, 80)
                .hreg(7, 0.7)
                .ad(55.32, 3.2)
                .as(0.644, 1.85)
                .ar(16, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(345);
        P0000.update(Champion.Ryze)
                .health(360, 86)
                .hreg(4.35, 0.55)
                .mana(250, 55)
                .mreg(7, 0.6)
                .ad(52, 3)
                .as(0.625, 2.11)
                .ar(11, 3.9)
                .mr(30, 0)
                .range(550)
                .ms(335);
        P0000.update(Champion.Sejuani)
                .health(450, 85)
                .hreg(7.35, 0.85)
                .mana(220, 40)
                .mreg(6.45, 0.45)
                .ad(54, 3.4)
                .as(0.67, 1.45)
                .ar(20.5, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(340);
        P0000.update(Champion.Shaco)
                .health(441, 84)
                .hreg(7.45, 0.55)
                .mana(270, 40)
                .mreg(6.4, 0.45)
                .ad(51.7, 3.5)
                .as(0.694, 3)
                .ar(15, 3.5)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Shen)
                .health(428, 85)
                .hreg(7.45, 0.55)
                .energy(200)
                .ereg(50)
                .ad(54.5, 3.375)
                .as(0.651, 3.4)
                .ar(15, 4)
                .mr(30, 0)
                .range(125)
                .ms(335);
        P0000.update(Champion.Shyvana)
                .health(435, 95)
                .hreg(7.2, 0.8)
                .ad(54.5, 3.4)
                .as(0.658, 3.4)
                .ar(17.6, 3.4)
                .mr(30, 1.25)
                .range(125)
                .ms(350);
        P0000.update(Champion.Singed)
                .health(405, 82)
                .hreg(7.1, 0.55)
                .mana(215, 45)
                .mreg(6.6, 0.55)
                .ad(56.65, 3.375)
                .as(0.613, 1.81)
                .ar(18, 3.5)
                .mr(30, 0)
                .range(125)
                .ms(345);
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
