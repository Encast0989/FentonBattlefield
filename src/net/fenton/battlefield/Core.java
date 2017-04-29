package net.fenton.battlefield;

import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Class.InstantKillBow;
import net.fenton.battlefield.Class.BattlefieldAbilityHandler;
import net.fenton.battlefield.Command.ClassStatusCommand;
import net.fenton.battlefield.Command.OPModeCommand;
import net.fenton.battlefield.Command.fenton.CoinsCommand;
import net.fenton.battlefield.Command.fenton.GameCommand;
import net.fenton.battlefield.Database.BattlefieldDatabase;
import net.fenton.battlefield.Listener.*;
import net.fenton.battlefield.Menu.Class.*;
import net.fenton.battlefield.Menu.ClassMenu;
import net.fenton.battlefield.Menu.RegularClassMenu;
import net.fenton.battlefield.Menu.ShopMenu;
import net.fenton.battlefield.Menu.UltimateClassMenu;
import net.fenton.battlefield.Player.*;
import net.fenton.core.command.fentoncommand.FentonCommandHandler;
import net.fenton.core.database.SQLCore;
import net.fenton.core.inventory.FentonInventoryHandler;
import net.fenton.core.permission.PermissionManager;
import net.fenton.core.player.rank.FentonRank;
import net.fenton.core.player.rank.FentonRankHandler;
import net.fenton.core.runnable.FentonMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * Created by Encast (2016-12-26 2:24 PM)
 *
 */
public class Core extends JavaPlugin {

    private static Core instance;
    public static Core getInstance() {
        return instance;
    }
    private int currentKillCoins = 45;

    private BattlefieldDatabase bd;

    public void onEnable() {
        instance = this;
        bd = new BattlefieldDatabase();
        bd.connect();
        registerClasses();
        registerListeners();
        registerCommands();
        registerMenus();
        registerPermissions();
        setMessages();
        FentonRankHandler.getInstance().setPrefix(false);
    }

    public void onDisable() {
        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            p.sendMessage("§cBattlefield is currently restarting. You have been kicked to the lobby.");
            getBattlefieldDatabase().savePlayer(p, true, false);
            net.fenton.core.Core.getInstance().sendPlayerToServer(p, "FenL");
        }

        if(bd != null) {
            bd.disconnect();
        }
    }

    private void registerClasses() {
        new BattlefieldClassData();
        new InstantKillBow();
        new BFPlayerData();
        new ClassDistributor();
        new InventoryLayout();
        new ClassMenu();
        new BattlefieldAbilityHandler();
        new BFDefaultPlayer();
    }

    private void registerListeners() {
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new QuitListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new KillListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DamageListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MiscListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new BattlefieldSettings(), this);
//        Bukkit.getServer().getPluginManager().registerEvents(new SpecialChest(), this);
    }

    private void registerCommands() {
        getCommand("opmode").setExecutor(new OPModeCommand());
        getCommand("cstatus").setExecutor(new ClassStatusCommand());

        FentonCommandHandler.getInstance().registerCommand(new GameCommand());
        FentonCommandHandler.getInstance().registerCommand(new CoinsCommand());
    }

    private void registerMenus() {
        FentonInventoryHandler.getInstance().registerMenu("BF:Shop", new ShopMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:AgrotisMenu", new AgrotisMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:ArcherMenu", new ArcherMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:AxerierMenu", new AxerierMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:BlastyMenu", new BlastyMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:KivosMenu", new KivosMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:MolesirMenu", new MolesirMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:OucherMenu", new OucherMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:RelytMenu", new RelytMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:BlazeMenu", new BlazeMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:RegularClassMenu", new RegularClassMenu());
        FentonInventoryHandler.getInstance().registerMenu("BF:UltimateClassMenu", new UltimateClassMenu());
    }

    public void registerPermissions() {
        PermissionManager.getInstance().registerPermission(FentonRank.MEDIA, "battlefield.command.opmode");
    }

    public void setMessages() {
        FentonMessage fa = new FentonMessage("§6[*] Report any bugs related to Battlefield on the forums!", 0, 240);
        fa.setPaused(false);
    }

    public BattlefieldDatabase getBattlefieldDatabase() {
        return bd;
    }

    public int getKillCoins() {
        return (currentKillCoins * net.fenton.core.Core.getInstance().getGlobalMultiplier());
    }

    public int getCurrentKillCoins() {
        return currentKillCoins;
    }

    public int getCurrentCoinMultiplier() {
        return net.fenton.core.Core.getInstance().getGlobalMultiplier();
    }

    public Location getSpawnLocation() {
        return new Location(Bukkit.getServer().getWorld("FenG-BF"), 1346.5d, 72d, 94.5d, -179.4f, 1.0f);
    }
}
