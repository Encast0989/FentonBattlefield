package net.fenton.battlefield.Listener;

import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Core;
import net.fenton.battlefield.Player.*;
import net.fenton.core.event.fentonevent.PostLoginEvent;
import net.fenton.core.nms.PacketResource;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by Encast (2016-12-27), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 3:15 PM
 */
public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PostLoginEvent e) {
        //TODO Add applying/removing (removing to player quit) of extra hearts. <- Or do it in the join clicking listener.
        Player p = e.getPlayer();

        // Retrieving player data
        Core.getInstance().getBattlefieldDatabase().retrievePlayer(p);

        InventoryLayout.getInstance().setMainInventory(p);
        BFPlayerData.getInstance().getPlayers().get(p.getUniqueId()).showGameScoreboard(p);
        p.setGameMode(GameMode.SURVIVAL);
        p.teleport(Core.getInstance().getSpawnLocation());
        new BukkitRunnable() {
            @Override
            public void run() {
                PacketResource.getPackets().sendTabHeaderFooter(p, "§2§lFenton Network",
                        "§6You are currently playing §3§lBATTLEFIELD");
                p.setPlayerListName(p.getPlayerListName() + " §e" + BattlefieldClassData.BFClass.AGROTIS.getPrefix()); //TODO Change later for actual class.
            }
        }.runTaskLater(Core.getInstance(), 20);
    }
}
