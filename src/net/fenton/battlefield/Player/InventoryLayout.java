package net.fenton.battlefield.player;

import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 4:40 PM
 */
public class InventoryLayout {

    private static InventoryLayout instance;
    public static InventoryLayout getInstance() {
        return instance;
    }

    public InventoryLayout() {
        instance = this;
    }

    public void setMainInventory(Player p) {
        ItemStack gameMenu = FentonItemStack.createStack()
                .createItemStack(Material.STAINED_CLAY, 1, (short) 5, "§2Game menu §7(Click)",
                        Arrays.asList(" ", "§7Click to view special games and", "§7ongoing/upcoming §7Special Events§7."));
        ItemStack profile = FentonItemStack.createStack().createItemStack(Material.BOOK, 1, "§2Profile §7(Click)",
                Arrays.asList(" ", "§7Click to view your §2Profile§7."));
        ItemStack shop = FentonItemStack.createStack()
                .createItemStack(Material.DIAMOND, 1, "§bShop §7(Click)",
                        Arrays.asList(" ", "§7Click to view or purchase an item."));
        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.DURABILITY, 1);
        ItemStack join = FentonItemStack.createStack()
                .createItemStack(Material.REDSTONE_BLOCK, 1, "§cJoin §7(Click)",
                        enchants, Arrays.asList(" ", "§7Click to join the Battlefield Arena.",
                                "§7Your class and extra purchases will", "§7be applied upon joining."));
        p.getInventory().clear();
        p.getInventory().setArmorContents(new ItemStack[] {new ItemStack(Material.AIR), new ItemStack(Material.AIR),
                new ItemStack(Material.AIR), new ItemStack(Material.AIR)});
        p.getInventory().setItem(0, gameMenu);
        p.getInventory().setItem(1, profile);
        p.getInventory().setItem(4, shop);
        p.getInventory().setItem(8, join);
    }
}
