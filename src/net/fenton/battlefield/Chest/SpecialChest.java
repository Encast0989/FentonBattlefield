package net.fenton.battlefield.chest;

import net.fenton.battlefield.Core;
import net.fenton.battlefield.player.BFPlayerData;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Encast (2017-01-21 1:15 PM)
 */
public class SpecialChest implements Listener {

    private static SpecialChest instance;

    public static SpecialChest getInstance() {
        return instance;
    }

    private List<Location> chests;
    private Location currentTierI;

    public SpecialChest() {
        instance = this;
        chests = new ArrayList<>();
        World world = Bukkit.getServer().getWorld("FenG-BF");
        for(Chunk c : world.getLoadedChunks()) {
            for(int x = 0; x < 15; x++) {
                for(int y = 0; y < 128; y++) {
                    for(int z = 0; z < 15; z++) {
                        Block b = c.getBlock(x, y, z);
                        if(b.getType() == Material.ANVIL) {
                            chests.add(b.getLocation());
                        }
                    }
                }
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if(Bukkit.getServer().getOnlinePlayers().size() >= 1) {
                    spawnTierIChest();
                }
            }
        }.runTaskTimer(Core.getInstance(), (20 * 30), ((20 * 60) * 5));
    }

    private void spawnTierIChest() {
        if(currentTierI != null) {
            despawnTierIChest();
        }
        Random r = new Random();
        Location l = chests.get(r.nextInt(chests.size()));
        l.getBlock().setType(Material.CHEST);
        ArmorStand n = (ArmorStand) l.getWorld().spawnEntity(l, EntityType.ARMOR_STAND);
        n.setCustomName("§6§lTIER I CHEST §e(Right Click)");
        n.setCustomNameVisible(true);
        n.setVisible(false);
        currentTierI = l;
        Bukkit.getServer().broadcastMessage("§6§lA TIER I CHEST HAS SPAWNED!");
    }

    private void despawnTierIChest() {
        if(currentTierI != null) {
            currentTierI.getWorld().getNearbyEntities(currentTierI, 3, 3, 3).forEach(e -> {
                if(e.getType() == EntityType.ARMOR_STAND) {
                    e.remove();
                }
            });
            currentTierI.getBlock().setType(Material.ANVIL);
            currentTierI = null;
        }
    }

    public void spawnTierIIChest() {

    }

    public void spawnUltimateChest() {

    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getClickedBlock().getType() == Material.CHEST) {
            if(e.getClickedBlock().getLocation() == currentTierI) {
                despawnTierIChest();
                BFPlayerData.getInstance().getPlayers().get(p.getUniqueId()).addCoins(5000);
                p.sendMessage("§e+5000 Coins (Tier I chest)!");
            }
        }
    }
}
