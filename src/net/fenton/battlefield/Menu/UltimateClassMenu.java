package net.fenton.battlefield.Menu;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Player.BFPlayer;
import net.fenton.battlefield.Player.BFPlayerData;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import net.fenton.core.inventory.FentonInventory;
import net.fenton.core.inventory.FentonInventoryHandler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Encast (2017-01-12 4:17 PM)
 */
public class UltimateClassMenu extends FentonInventory {

    public UltimateClassMenu() {
        super("Ultimate Classes", false, 45);
    }

    @Override
    public void openInventory(Player player) {
        BFPlayer p = BFPlayerData.getInstance().getPlayers().get(player.getUniqueId());
        Inventory i = getInventory();
        int currentSlot = 11;
        for(BattlefieldClassData.BFClass bf : BattlefieldClassData.BFClass.values()) {
            BattlefieldClass c = BattlefieldClassData.getInstance().getClassByName(bf)
                    .getByLevel((p.getClassLevel().getLevelByName(bf)));
            if(!BattlefieldClassData.getInstance().getClassByName(bf).isUltimate()) {
                continue;
            }
            ItemStack item = c.getDisplayItem();
            ItemMeta m = item.getItemMeta();
            m.setDisplayName("§6" + bf.getName() + (!BattlefieldClassData.getInstance().getClassByName(bf).isEnabled() ? " §c§lDISABLED" : ""));
            List<String> lore = new ArrayList<>();
            lore.add((p.getClassLevel().getLevelByName(bf) > 0 ? ("§6Level: " + p.getClassLevel().getLevelByName(bf)) : "§cNot unlocked!"));
            lore.add("§8Items:");
            c.getWearableItems().values().forEach(wearableItem -> {
                lore.add("§7- " + wearableItem.getType().name().replaceAll("_", " ").toLowerCase());
                if(wearableItem.getEnchantments() != null) {
                    for(Enchantment e : wearableItem.getEnchantments().keySet()) {
                        lore.add("  §7• " + e.getName().replaceAll("_", " ").toLowerCase() + " " + wearableItem.getEnchantments().get(e));
                    }
                }
            });
            c.getItems().forEach(normalItem -> {
                lore.add("§7- " + normalItem.getType().name().replaceAll("_", " ").toLowerCase());
                if(normalItem.getEnchantments() != null) {
                    for(Enchantment e : normalItem.getEnchantments().keySet()) {
                        lore.add("  §7• " + e.getName().replaceAll("_", " ").toLowerCase() + " " + normalItem.getEnchantments().get(e));
                    }
                }
            });
            NumberFormat format = NumberFormat.getIntegerInstance();
            lore.add(" ");
            if(c.getLevel() < 5) {
                lore.add("§6Next Upgrade: §e" + format.format(BattlefieldClassData.getInstance().getClassByName(bf)
                        .getByLevel(p.getClassLevel().getLevelByName(bf) + 1).getCost()) + " Coins");
            } else {
                lore.add("§aFully Max");
            }
            lore.add(" ");
            lore.add("§6Click to view class menu");
            m.setLore(lore);
            item.setItemMeta(m);
            i.setItem(currentSlot, item);
            if(currentSlot == 15) {
                currentSlot = 20; //TODO Change in future, if needed, to get a better looking inventory layout.
            } else {
                currentSlot++;
            }
        }
        ItemStack goBack = FentonItemStack.createStack().createItemStack(Material.DIAMOND, 1, "§bGo back to Shop", null);
        i.setItem(40, goBack);
        player.openInventory(i);
    }

    @Override
    public void onClick(Player p, ItemStack i) {
        if(i.hasItemMeta()) {
            String name = ChatColor.stripColor(i.getItemMeta().getDisplayName());
            if (name.startsWith("Blaze")) {
                FentonInventoryHandler.getInstance().getMenuByID("BF:BlazeMenu").openInventory(p);
            } else if(name.startsWith("Go back to Shop")) {
                FentonInventoryHandler.getInstance().getMenuByID("BF:Shop").openInventory(p);
            } else {
                p.sendMessage("§cComing Soon!");
            }
        }
    }
}
