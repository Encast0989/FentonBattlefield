package net.fenton.battlefield.listener;

import net.fenton.api.Fenton;
import net.fenton.battlefield.Core;
import net.fenton.battlefield.player.BFPlayer;
import net.fenton.battlefield.player.BFPlayerData;
import net.fenton.battlefield.player.InventoryLayout;
import net.fenton.battlefield.player.KillEffect;
import net.fenton.core.nms.PacketResource;
import net.fenton.core.player.FentonPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.text.DecimalFormat;

/**
 * Created by Encast (2016-12-29), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 8:32 PM
 */
public class KillListener implements Listener {

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent e) {
        Player p = e.getEntity();
        e.setDeathMessage("");
        e.getDrops().clear();
        if(e.getEntity().getKiller() != null) {
            Player k = e.getEntity().getKiller();
            BFPlayer kData = BFPlayerData.getInstance().getPlayers().get(k.getUniqueId());
            if(!kData.isOpMode()) {
                BFPlayer pData = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                pData.addDeaths(1);
                kData.addKills(1);

                pData.setInGame(false);
                // Coins
                int coins = Core.getInstance().getKillCoins();
                kData.addCoins(coins);
                // Killer Data
                FentonPlayer fpk = Fenton.getAPI().getPlayerHandler().getPlayers().get(k.getUniqueId());
                DecimalFormat format = new DecimalFormat("#.##");
                p.sendMessage("§cYou have been killed by " + fpk.getPrefixedName() + " §c(" + format.format((k.getHealth() / 2)) + "§c❤§c)");
                k.sendMessage("§e+" + coins + " coins " + (net.fenton.core.Core.getInstance().getGlobalMultiplier() > 1 ?
                        "§e(x" + net.fenton.core.Core.getInstance().getGlobalMultiplier() + " " +
                                net.fenton.core.Core.getInstance().getGlobalMultiplierMessage().trim() + "§e)" : ""));
                PacketResource.getPackets().sendActionBarPacket(k, "§e+" + coins + " coins");

                // Kill Effect
                if(kData.getKillEffect() == KillEffect.SPEED) {
                    boolean speed = false;
                    int duration = 0;
                    for(PotionEffect pe : k.getActivePotionEffects()) {
                        if(pe.getType().equals(PotionEffectType.SPEED)) {
                            speed = true;
                            duration = pe.getDuration();
                            k.removePotionEffect(PotionEffectType.SPEED);
                        }
                    }
                    PotionEffect effect = new PotionEffect(PotionEffectType.SPEED, (speed ? ((15 * 20) + duration) : (15 * 20)), 1, true, false);
                    k.addPotionEffect(effect);
                    k.sendMessage("§e+15 seconds of §fSpeed§e!");
                } else if(kData.getKillEffect() == KillEffect.RESISTANCE_STRENGTH) {
                    PotionEffect effect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 6 * 20, 1, true, false);
                    PotionEffect effect2 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3 * 20, 0, true, false);
                    k.addPotionEffect(effect);
                    k.addPotionEffect(effect2);
                    k.sendMessage("§e+15 seconds of §fSpeed§e!");
                }
                k.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
                k.sendMessage("§e+1 Golden Apple!");
                Bukkit.getServer().broadcastMessage("§a" + k.getName() + " §ekilled §c" + p.getName());
            } else {
                p.sendMessage("§cThat player is currently in OP Mode. No stats have been changed.");
                k.sendMessage("§c§lOP MODE §cYou were in OP Mode, no stats changed.");
            }
        } else {
            p.sendMessage("§cYou have died by an unknown source. D:");
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        e.setRespawnLocation(Core.getInstance().getSpawnLocation());
        InventoryLayout.getInstance().setMainInventory(p);
    }
}
