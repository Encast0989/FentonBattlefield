package net.fenton.battlefield.listener;

import net.fenton.battlefield.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Encast (2016-12-27), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 4:22 PM
 */
public class QuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Core.getInstance().getBattlefieldDatabase().savePlayer(p, true, false);
    }
}
