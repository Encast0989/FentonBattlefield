package net.fenton.battlefield.bfclass.Agrotis;

import net.fenton.battlefield.bfclass.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
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
 * bfclass created at: 5:13 PM
 */
public class AgrotisIII extends BattlefieldClass {

    public AgrotisIII() {
        super("Agrotis III", 3, false, 10_000, new ItemStack(Material.IRON_HOE));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_HELMET, 1,
                99, 33, 33, "", null), ArmourSlot.HELMET);
        addWearableItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1,
                99, 33, 33, "", null), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.IRON_BOOTS, 1, "", enchants,
                null), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.DAMAGE_ALL, 3);
        addItem(FentonItemStack.createStack().createItemStack(Material.STONE_HOE, 1, "", enchants, null));
    }
}
