package net.fenton.battlefield.Class.Kivos;

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
 * Class created at: 5:20 PM
 */
public class KivosV extends BattlefieldClass {

    public KivosV() {
        super("Kivos V", 5, false, 50_000, new ItemStack(Material.IRON_LEGGINGS));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(FentonItemStack.createStack().createItemStack(Material.IRON_HELMET, 1, "", enchants, null), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.PURPLE,
                "", null), ArmourSlot.CHESTPLATE);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.DIAMOND_LEGGINGS, 1, "",
                enchants, null), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.IRON_BOOTS, 1, "", null), ArmourSlot.BOOTS);

        addItem(new ItemStack(Material.STONE_SWORD));
    }
}
