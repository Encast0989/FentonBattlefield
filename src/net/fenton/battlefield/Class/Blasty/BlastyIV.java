package net.fenton.battlefield.Class.Blasty;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 3:41 PM
 */
public class BlastyIV extends BattlefieldClass {

    public BlastyIV() {
        super("Blasty IV", 4, false, 20_000, new ItemStack(Material.TNT));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(FentonItemStack.createStack()
                .createLeatherArmour(Material.LEATHER_HELMET, 1, Color.AQUA, "", null), ArmourSlot.HELMET);
        addWearableItem(new ItemStack(Material.IRON_CHESTPLATE), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack()
                .createItemStack(Material.CHAINMAIL_LEGGINGS, 1, "", enchants, null), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack()
                .createLeatherArmour(Material.LEATHER_BOOTS, 1, Color.AQUA, "", null), ArmourSlot.BOOTS);

        addItem(new ItemStack(Material.STONE_SWORD));
    }
}
