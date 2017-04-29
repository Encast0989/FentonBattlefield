package net.fenton.battlefield.bfclass.Blasty;

import net.fenton.battlefield.bfclass.BattlefieldClass;
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
 * bfclass created at: 3:14 PM
 */
public class BlastyII extends BattlefieldClass {

    public BlastyII() {
        super("Blasty II", 2, false, 2000, new ItemStack(Material.TNT));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(FentonItemStack.createStack()
                .createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.AQUA, "", null, enchants), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack()
                .createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.AQUA, "", null, enchants), ArmourSlot.CHESTPLATE);

        addItem(new ItemStack(Material.WOOD_SWORD));
    }
}
