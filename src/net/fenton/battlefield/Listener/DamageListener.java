package net.fenton.battlefield.listener;

import net.fenton.battlefield.player.BFPlayer;
import net.fenton.battlefield.player.BFPlayerData;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 12:59 PM
 */
public class DamageListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getDamager() instanceof Player || e.getDamager() instanceof Arrow ||
                    e.getDamager() instanceof FishHook) {
                Player p = (Player) e.getEntity();
                Entity d = e.getDamager();
                if(e.getDamager() == e.getEntity()) {
                    e.setCancelled(true);
                    return;
                }
                if(d instanceof Player) {
                    if(BFPlayerData.getInstance().getPlayers().get(p.getUniqueId()).isInGame() &&
                            BFPlayerData.getInstance().getPlayers().get(d.getUniqueId()).isInGame()) {
                        e.setCancelled(false);
                        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                        if(bfp.getEnergy() < 100) {
                            bfp.addEnergy(5);
//                            if(bfp.getEnergy() == 100) {
//                                p.playSound(p.getLocation(), Sound.CREEPER_HISS, 5, 1);
//                                p.sendMessage("§c> §b§lYou now have full energy! §c<");
//                                BattlefieldAbilityHandler.getInstance().fullEnergy(p);
//                            }
                        }
                    } else {
                        e.setCancelled(true);
                    }
                } else {
                    if(BFPlayerData.getInstance().getPlayers().get(p.getUniqueId()).isInGame()) {
                        e.setCancelled(false);
                    }
                }
            } else {
                e.setCancelled(true);
            }
        }
    }
}
