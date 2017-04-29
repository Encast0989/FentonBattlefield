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
 * Class created at: 3:51 PM
 */
public class BlastyV extends BattlefieldClass {

    public BlastyV() {
        super("Blasty V", 5, false, 50_000, new ItemStack(Material.TNT));

        Map<Enchantment, Integer> chestplate = new HashMap<>();
        chestplate.put(Enchantment.DURABILITY, 10);

        Map<Enchantment, Integer> leggings = new HashMap<>();
        leggings.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        Map<Enchantment, Integer> sword = new HashMap<>();
        leggings.put(Enchantment.DURABILITY, 1);

        addWearableItem(FentonItemStack.createStack()
                .createLeatherArmour(Material.LEATHER_HELMET, 1, Color.AQUA, "", null), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack()
                .createItemStack(Material.DIAMOND_CHESTPLATE, 1, "", chestplate, null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack()
                .createItemStack(Material.CHAINMAIL_LEGGINGS, 1, "", leggings, null), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack()
                .createLeatherArmour(Material.LEATHER_BOOTS, 1, Color.AQUA, "", null), ArmourSlot.BOOTS);

        addItem(FentonItemStack.createStack()
                .createItemStack(Material.IRON_SWORD, 1, "", sword, null));
    }
}
