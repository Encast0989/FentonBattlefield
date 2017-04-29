package net.fenton.battlefield.Class.Relyt;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2017-01-16 6:15 PM)
 */
public class RelytIII extends BattlefieldClass {

    public RelytIII() {
        super("Relyt III", 3, false, 10_000, FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.ORANGE, "", null));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.DAMAGE_ALL, 1);

        addWearableItem(new ItemStack(Material.CHAINMAIL_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.ORANGE,
                "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(new ItemStack(Material.GOLD_LEGGINGS), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.IRON_BOOTS), ArmourSlot.BOOTS);

        addItem(FentonItemStack.createStack().createItemStack(Material.WOOD_SWORD, 1, "", enchants, null));
    }
}
