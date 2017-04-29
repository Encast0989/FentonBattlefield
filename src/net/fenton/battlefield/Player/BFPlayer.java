package net.fenton.battlefield.Player;

import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Core;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.text.NumberFormat;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 4:01 PM
 */
public class BFPlayer {

    private BattlefieldClassData.BFClass currentClass;
    private int kills;
    private int deaths;
    private double coins;
    private BFClassLevel classLevel;
    private int energy;
    private int arrowLevel;
    private boolean fishingRod;
    private boolean inGame;
    private boolean opMode;
    private KillEffect killEffect;
    private BFPlayerStats stats;

    public BFPlayer(BattlefieldClassData.BFClass currentClass, int kills, int deaths, double coins, BFClassLevel classLevel,
                    int energy, int arrowLevel, boolean fishingRod, boolean inGame, boolean opMode, KillEffect killEffect, BFPlayerStats stats) {
        this.currentClass = currentClass;
        this.kills = kills;
        this.deaths = deaths;
        this.coins = coins;
        this.classLevel = classLevel;
        this.energy = energy;
        this.arrowLevel = arrowLevel;
        this.fishingRod = fishingRod;
        this.inGame = inGame;
        this.opMode = opMode;
        this.killEffect = killEffect;
        this.stats = stats;
    }

    public BattlefieldClassData.BFClass getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(BattlefieldClassData.BFClass currentClass) {
        this.currentClass = currentClass;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public void addKills(int kills) {
        this.kills += kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void addDeaths(int deaths) {
        this.deaths += deaths;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public void addCoins(double coins) {
        this.coins += coins;
        this.stats.addTotalCoins(coins);
    }

    public void removeCoins(double coins) {
        this.coins -= coins;
    }

    public BFClassLevel getClassLevel() {
        return classLevel;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void addEnergy(int energy) {
        this.energy += energy;
    }

    public int getArrowLevel() {
        return arrowLevel;
    }

    public void setArrowLevel(int arrowLevel) {
        this.arrowLevel = arrowLevel;
    }

    public boolean hasFishingRod() {
        return fishingRod;
    }

    public void setFishingRod(boolean fishingRod) {
        this.fishingRod = fishingRod;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean isOpMode() {
        return opMode;
    }

    public void setOpMode(boolean opMode) {
        this.opMode = opMode;
    }

    public KillEffect getKillEffect() {
        return killEffect;
    }

    public BFPlayerStats getStats() {
        return stats;
    }

    public void showGameScoreboard(Player p) {
        Scoreboard s = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        Objective o = s.registerNewObjective(p.getName(), "dummy");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName("§3§lBATTLEFIELD");
        // SCORES
        // Kills
        Team killsScore = s.registerNewTeam("kills");
        killsScore.addEntry(ChatColor.GREEN.toString());
        killsScore.setPrefix("Kills: ");
        // Deaths
        Team deathsScore = s.registerNewTeam("deaths");
        deathsScore.addEntry(ChatColor.RED.toString());
        deathsScore.setPrefix("Deaths: ");
        // Energy
//        Team energyScore = s.registerNewTeam("energy");
//        energyScore.addEntry(ChatColor.AQUA.toString());
//        deathsScore.setPrefix("Energy: ");
        // Coins
        Team coinsScore = s.registerNewTeam("coins");
        coinsScore.addEntry(ChatColor.YELLOW.toString());
        coinsScore.setPrefix("Coins: ");
        // Class
        Team classScore = s.registerNewTeam("class");
        classScore.addEntry(ChatColor.DARK_AQUA.toString());
        classScore.setPrefix("§3");

        o.getScore(" ").setScore(9);
        o.getScore(ChatColor.GREEN.toString()).setScore(8);
        o.getScore(ChatColor.RED.toString()).setScore(7);
//        o.getScore(ChatColor.AQUA.toString()).setScore(7);
        o.getScore("  ").setScore(6);
        o.getScore("Current Class:").setScore(5);
        o.getScore(ChatColor.DARK_AQUA.toString()).setScore(4);
        o.getScore("   ").setScore(3);
        o.getScore(ChatColor.YELLOW.toString()).setScore(2);
        o.getScore("    ").setScore(1);
        o.getScore("§2" + net.fenton.core.Core.getInstance().getNetworkIP()).setScore(0);

        p.setScoreboard(s);

        new BukkitRunnable() {
            int c = 0;
            int opmodec = 0;
            @Override
            public void run() {
                if(!p.isOnline()) {
                    this.cancel();
                }
                if(!isOpMode()) {
                    switch(c) {
                        case 0:
                            o.setDisplayName("§f§lB§3§lATTLEFIEL§f§lD");
                            c++;
                            break;
                        case 1:
                            o.setDisplayName("§f§lBA§3§lTTLEFIE§f§lLD");
                            c++;
                            break;
                        case 2:
                            o.setDisplayName("§f§lBAT§3§lTLEFI§f§lELD");
                            c++;
                            break;
                        case 3:
                            o.setDisplayName("§f§lBATT§3§lLEF§f§lIELD");
                            c++;
                            break;
                        case 4:
                            o.setDisplayName("§f§lBATTL§3§lE§f§lFIELD");
                            c++;
                            break;
                        case 5:
                            o.setDisplayName("§f§lBATTLEFIELD");
                            c++;
                            break;
                        case 6:
                            o.setDisplayName("§f§lBATTLEFIELD");
                            c++;
                            break;
                        case 7:
                            o.setDisplayName("§f§lBATTLEFIELD");
                            c++;
                            break;
                        case 8:
                            o.setDisplayName("§f§lBATTLEFIELD");
                            c++;
                            break;
                        case 9:
                            o.setDisplayName("§3§lBATTLEFIELD");
                            c++;
                            break;
                        case 10:
                            o.setDisplayName("§3§lBATTL§f§lE§3§lFIELD");
                            c++;
                        case 11:
                            o.setDisplayName("§3§lBATT§f§lLEF§3§lIELD");
                            c++;
                            break;
                        case 12:
                            o.setDisplayName("§3§lBAT§f§lTLEFI§3§lELD");
                            c++;
                            break;
                        case 13:
                            o.setDisplayName("§3§lBA§f§lTTLEFIE§3§lLD");
                            c++;
                            break;
                        case 14:
                            o.setDisplayName("§3§lB§f§lATTLEFIEL§3§lD");
                            c++;
                            break;
                        case 15:
                            o.setDisplayName("§f§lBATTLEFIELD");
                            c++;
                            break;
                        case 16:
                            o.setDisplayName("§3§lBATTLEFIELD");
                            c++;
                            break;
                        case 17:
                            o.setDisplayName("§f§lBATTLEFIELD");
                            c++;
                            break;
                        case 18:
                            o.setDisplayName("§3§lBATTLEFIELD");
                            c++;
                            break;
                        case 19:
                            o.setDisplayName("§3§lBATTLEFIELD");
                            c++;
                            break;
                        case 20:
                            o.setDisplayName("§3§lBATTLEFIELD");
                            c++;
                            break;
                        case 21:
                            o.setDisplayName("§3§lBATTLEFIELD");
                            c = 0;
                            break;
                        default:
                            break;
                    }
                } else {
                    switch(opmodec) {
                        case 0:
                            o.setDisplayName("§c§lOP MODE");
                            opmodec++;
                            break;
                        case 1:
                            o.setDisplayName("§f§lO§c§lP MOD§f§lE");
                            opmodec++;
                            break;
                        case 2:
                            o.setDisplayName("§f§lOP §c§lMO§f§lDE");
                            opmodec++;
                            break;
                        case 3:
                            o.setDisplayName("§f§lOP MODE");
                            opmodec++;
                            break;
                        case 4:
                            o.setDisplayName("§f§lOP MODE");
                            opmodec++;
                            break;
                        case 5:
                            o.setDisplayName("§f§lOP MODE");
                            opmodec++;
                            break;
                        case 6:
                            o.setDisplayName("§f§lOP MODE");
                            opmodec++;
                            break;
                        case 7:
                            o.setDisplayName("§c§lOP MODE");
                            opmodec++;
                            break;
                        case 8:
                            o.setDisplayName("§c§lOP MODE");
                            opmodec++;
                            break;
                        case 9:
                            o.setDisplayName("§c§lOP MODE");
                            opmodec++;
                            break;
                        case 10:
                            o.setDisplayName("§c§lOP MODE");
                            opmodec = 0;
                            break;
                    }
                }
            }
        }.runTaskTimer(Core.getInstance(), 0, 5);

        new BukkitRunnable() {
            NumberFormat nf = NumberFormat.getIntegerInstance();
            @Override
            public void run() {
                if(!p.isOnline()) {
                    this.cancel();
                }
                killsScore.setSuffix(String.valueOf(getKills()));
                deathsScore.setSuffix(String.valueOf(getDeaths()));
//                energyScore.setSuffix(String.valueOf(getEnergy()));
                coinsScore.setSuffix(nf.format(getCoins()));
                classScore.setSuffix(getCurrentClass().getColouredName());
            }
        }.runTaskTimer(Core.getInstance(), 0, 40);
    }
}
