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
public class AgrotisV extends BattlefieldClass {

    public AgrotisV() {
        super("Agrotis V", 5, false, 50_000, new ItemStack(Material.IRON_HOE));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 3);

        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_HELMET, 1,
                99, 33, 33, "", null, enchants), ArmourSlot.HELMET);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.CHAINMAIL_CHESTPLATE, 1,
                "", enchants, null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1,
                99, 33, 33, "", null), ArmourSlot.LEGGINGS);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.DIAMOND_BOOTS, 1, "", enchants,
                null), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.DAMAGE_ALL, 4);
        addItem(FentonItemStack.createStack().createItemStack(Material.DIAMOND_HOE, 1, "", enchants, null));
    }
}
