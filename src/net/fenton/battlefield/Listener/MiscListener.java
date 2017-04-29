package net.fenton.battlefield.Listener;

import net.fenton.battlefield.Core;
import net.fenton.battlefield.Player.BFPlayer;
import net.fenton.battlefield.Player.BFPlayerData;
import net.fenton.battlefield.Player.InventoryLayout;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 3:05 PM
 */
public class MiscListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE) && p.getInventory().contains(Material.EYE_OF_ENDER)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE) && p.getInventory().contains(Material.EYE_OF_ENDER)) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerItemDamage(PlayerItemDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onArrowHit(EntityDamageEvent e) {
        if(e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)) {
            e.setDamage((e.getDamage() / 2));
        }
    }

    @EventHandler
    public void onVoidFall(PlayerMoveEvent e) {
        if(e.getTo().getY() <= -45.0) {
            Player p = e.getPlayer();
            BFPlayer data = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
            data.addDeaths(1);
            data.setInGame(false);
            p.getInventory().clear();
            ItemStack[] clearArmour = new ItemStack[] {new ItemStack(Material.AIR), new ItemStack(Material.AIR),
                    new ItemStack(Material.AIR), new ItemStack(Material.AIR)};
            p.getInventory().setArmorContents(clearArmour);
            p.teleport(Core.getInstance().getSpawnLocation());
            InventoryLayout.getInstance().setMainInventory(p);
            p.sendMessage("§cYou have died to the void!");
            Bukkit.getServer().broadcastMessage("§c" + p.getName() + " §efell into the void");
        }
    }
}
