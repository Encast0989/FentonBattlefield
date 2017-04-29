package net.fenton.battlefield.bfclass.Kivos;

import net.fenton.battlefield.bfclass.BattlefieldClass;
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
 * bfclass created at: 5:19 PM
 */
public class KivosI extends BattlefieldClass {

    public KivosI() {
        super("Kivos I", 1, false, 0, new ItemStack(Material.IRON_LEGGINGS));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.PURPLE,
                "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1, Color.PURPLE,
                "", null, enchants), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_BOOTS, 1, Color.PURPLE,
                "", null), ArmourSlot.BOOTS);

        addItem(new ItemStack(Material.WOOD_SWORD));
    }
}
