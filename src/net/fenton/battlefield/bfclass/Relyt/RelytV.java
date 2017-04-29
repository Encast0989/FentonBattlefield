package net.fenton.battlefield.bfclass.Relyt;

import net.fenton.battlefield.bfclass.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2017-01-16 6:16 PM)
 */
public class RelytV extends BattlefieldClass {

    public RelytV() {
        super("Relyt V", 5, false, 50_000, FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.ORANGE, "", null));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(FentonItemStack.createStack().createItemStack(Material.DIAMOND_HELMET, 1, "",
                enchants, null), ArmourSlot.HELMET);
        addWearableItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE), ArmourSlot.CHESTPLATE);
        addWearableItem(new ItemStack(Material.CHAINMAIL_LEGGINGS), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.IRON_BOOTS), ArmourSlot.BOOTS);

        addItem(FentonItemStack.createStack().createItemStack(Material.IRON_SWORD, 1, "", null));
    }
}
