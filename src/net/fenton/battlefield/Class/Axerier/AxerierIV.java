package net.fenton.battlefield.Class.Axerier;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 5:06 PM
 */
public class AxerierIV extends BattlefieldClass {

    public AxerierIV() {
        super("AxerierClass IV", 4, false, 20_000, new ItemStack(Material.WOOD_AXE));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(FentonItemStack.createStack().createItemStack(Material.DIAMOND_HELMET, 1, "", enchants, null), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.FUCHSIA,
                "", null), ArmourSlot.CHESTPLATE);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1, Color.FUCHSIA,
                "", null, enchants), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.IRON_BOOTS, 1, "", null), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.KNOCKBACK, 1);
        addItem(FentonItemStack.createStack().createItemStack(Material.IRON_AXE, 1, "", enchants, null));
    }
}
