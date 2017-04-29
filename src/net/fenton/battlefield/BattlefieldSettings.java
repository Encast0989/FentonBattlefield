package net.fenton.battlefield;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Encast (2017-01-28 3:41 PM)
 */
public class BattlefieldSettings implements Listener {

    private static BattlefieldSettings instance;
    public static BattlefieldSettings getInstance() {
        return instance;
    }

    private boolean regen = true;
    private boolean extra_hearts = false;
    private boolean permanent_speed = false;

    public BattlefieldSettings() {
        instance = this;
    }

    public boolean isRegen() {
        return regen;
    }

    public void setRegen(boolean regen) {
        this.regen = regen;
    }

    public boolean isExtraHearts() {
        return extra_hearts;
    }

    public void setExtraHearts(boolean extra_hearts) {
        this.extra_hearts = extra_hearts;
        for (Player online : Bukkit.getServer().getOnlinePlayers()) {
            if(extra_hearts) {
                online.setMaxHealth(40D);
            } else {
                online.setMaxHealth(20D);
            }
        }
    }

    public boolean isPermanentSpeed() {
        return permanent_speed;
    }

    public void setPermanentSpeed(boolean permanent_speed) {
        this.permanent_speed = permanent_speed;
        for(Player online : Bukkit.getServer().getOnlinePlayers()) {
            if(permanent_speed) {
                online.removePotionEffect(PotionEffectType.SPEED);
                online.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1, true, false), true);
            } else {
                online.removePotionEffect(PotionEffectType.SPEED);
            }
        }
    }

    // Regeneration
    @EventHandler
    public void onPlayerRegeneration(EntityRegainHealthEvent e) {
        if(e.getEntity() instanceof Player) {
            if(!isRegen()) {
                if(e.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED) {
                    e.setCancelled(true);
                }
            }
        }
    }

    // Extra hearts
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(extra_hearts) {
            p.setMaxHealth(40D);
        } else {
            p.setMaxHealth(20D);
        }
    }
}
