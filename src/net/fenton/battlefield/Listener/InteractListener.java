package net.fenton.battlefield.Listener;

import net.fenton.battlefield.BattlefieldSettings;
import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Player.BFPlayer;
import net.fenton.battlefield.Player.BFPlayerData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 2:47 PM
 */
public class InteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem().hasItemMeta()) {
            if(e.getItem().getItemMeta().hasDisplayName()) {
                ItemStack i = e.getItem();
                if(ChatColor.stripColor(i.getItemMeta().getDisplayName()).startsWith("Join")) {
                    BFPlayer bfPlayer = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                    BattlefieldClassData.BFClass bfClass = bfPlayer.getCurrentClass();
                    if(BattlefieldClassData.getInstance().getClassByName(bfClass).isEnabled()) {
                        BattlefieldClass c = BattlefieldClassData.getInstance().getClassByName(bfClass)
                                .getByLevel(bfPlayer.getClassLevel().getLevelByName(bfClass));
                        p.getInventory().clear();
                        ItemStack[] clearArmour = new ItemStack[] {new ItemStack(Material.AIR), new ItemStack(Material.AIR),
                                new ItemStack(Material.AIR), new ItemStack(Material.AIR)};
                        p.getInventory().setArmorContents(clearArmour);
                        c.applyItems(p);
                        bfPlayer.setInGame(true);
                        p.teleport(new Location(Bukkit.getServer().getWorld("FenG-BF"), 1317.5d, 75.5d, 25.2d, -23.5f, 2.7f));

                        // Battlefield Settings: speed
                        if(BattlefieldSettings.getInstance().isPermanentSpeed()) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1, true, false), true);
                        }
                    } else {
                        p.sendMessage("§cSeems like you're using a kit that is currently disabled. " +
                                "Please switch your current class before joining again.");
                    }
                }
            }
        }
    }
}
