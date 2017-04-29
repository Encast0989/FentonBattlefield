package net.fenton.battlefield.menu;

import net.fenton.battlefield.player.BFPlayer;
import net.fenton.battlefield.player.BFPlayerData;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import net.fenton.core.inventory.FentonInventory;
import net.fenton.core.inventory.FentonInventoryHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Encast (2016-12-27), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 3:34 PM
 */
public class ShopMenu extends FentonInventory {

    public ShopMenu() {
        super("Shop", false, 45);
    }

    @Override
    public void openInventory(Player player) {
        BFPlayer p = BFPlayerData.getInstance().getPlayers().get(player.getUniqueId());
        Inventory i = getInventory();
        ItemStack regularClass = FentonItemStack.createStack().createItemStack(Material.IRON_CHESTPLATE, 1, "§aRegular Classes",
                Arrays.asList(" ", "§7Click to view §aRegular §7classes.", " ", "§7Requirement: None"));
        ItemStack ultimateClass = FentonItemStack.createStack().createItemStack(Material.GOLD_CHESTPLATE, 1, "§6Ultimate Classes",
                Arrays.asList(" ", "§7Click to view §6Ultimate §7classes.", "§7These classes cost x2.5 more!",
                        " ", "§7Requirement: 250 kills minimum"));
        i.setItem(11, regularClass);
        i.setItem(15, ultimateClass);
        List<String> lore = new ArrayList<>();
        if(!p.hasFishingRod()) {
            Arrays.asList(" ", "§8Items:",
                    "§7- Fishing Rod", "§7NOTE: After purchasing, this will",
                    "§7apply for ALL classes!", " ", "§6Cost: §e30000 Coins");
            lore.add(" ");
            lore.add("§8Items:");
            lore.add("§7- Fishing Rod");
            lore.add("§7  • Sharpness 2");
            lore.add(" ");
            lore.add("§7NOTE: After purchasing, this will");
            lore.add("§7apply for ALL classes!");
            lore.add(" ");
            lore.add("§6Cost: §e30,000 Coins");
        } else {
            lore.add(" ");
            lore.add("§aPurchased");
        }
        ItemStack fishing_rod = FentonItemStack.createStack()
                .createItemStack(Material.FISHING_ROD, 1, "§2Fishing Rod", lore);
        ItemStack bow = FentonItemStack.createStack()
                .createItemStack(Material.BOW, 1, "§2Instant Kill Bow", Arrays.asList(" ", "§6Cost: §e30,000 Coins", "§cComing Soon!"));
        ItemStack killeffect = FentonItemStack.createStack().createItemStack(Material.IRON_SWORD, 1, "§9Kill Effect",
                Arrays.asList(" ", "§cComing Soon!"));
        DecimalFormat format = new DecimalFormat("#.##");
        ItemStack stats = FentonItemStack.createStack().createItemStack(Material.DIAMOND, 1, "§eYour Statistics",
                Arrays.asList(" ", "§eKills: §b" + p.getKills(),
                        "§eDeaths: §b" + p.getDeaths(),
                        "§eKDR: §b" + (p.getDeaths() >= 1 ? format.format((p.getKills() / p.getDeaths())) : "Infinite"),
                        "§eCurrent Coins: §b" + format.format(p.getCoins()),
                        "§eTotal Coins: §b" + format.format(p.getStats().getTotalCoins())));
        i.setItem(30, fishing_rod);
        i.setItem(32, bow);
        i.setItem(36, killeffect);
        i.setItem(44, stats);

        player.openInventory(i);
    }

    @Override
    public void onClick(Player p, ItemStack i) {
        if(i.hasItemMeta()) {
            String name = ChatColor.stripColor(i.getItemMeta().getDisplayName());
            if(name.startsWith("Regular Classes")) {
                FentonInventoryHandler.getInstance().getMenuByID("BF:RegularClassMenu").openInventory(p);
            } else if(name.startsWith("Ultimate Classes")) {
                BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                if(bfp.getKills() >= 250) {
                    FentonInventoryHandler.getInstance().getMenuByID("BF:UltimateClassMenu").openInventory(p);
                } else {
                    p.sendMessage("§cYou don't have the required kills!");
                }
            } else if(name.startsWith("Fishing Rod")) {
                BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                if(!bfp.hasFishingRod()) {
                    if(bfp.getCoins() >= 30_000) {
                        bfp.setFishingRod(true);
                        bfp.removeCoins(30_000);
                        p.sendMessage("§aYou have purchased the §3Fishing Rod§a!");
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
                        FentonInventoryHandler.getInstance().getMenuByID("BF:Shop").openInventory(p);
                    } else {
                        p.sendMessage("§cYou do not have coins to purchase this!");
                    }
                } else {
                    p.sendMessage("§cYou have already purchased this!");
                }
            } else if(name.startsWith("Instant Kill Bow")) {
                //TODO
                p.sendMessage("§cComing Soon!");
            } else if(name.startsWith("Your Statistics")) {
                //NOTHING
            } else {
                p.sendMessage("§cComing Soon!");
            }
        }
    }
}
