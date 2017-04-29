package net.fenton.battlefield.Class.Oucher;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2017-01-16 6:52 PM)
 */
public class OucherIII extends BattlefieldClass {

    public OucherIII() {
        super("Oucher III", 3, false, 10_000, FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.BLUE, "", null));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(new ItemStack(Material.GOLD_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.BLUE, "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(new ItemStack(Material.GOLD_LEGGINGS), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_BOOTS, 1,
                Color.BLUE, "", null, enchants), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.DAMAGE_ALL, 1);
        addItem(FentonItemStack.createStack().createItemStack(Material.STONE_SWORD, 1, "", enchants, null));
    }
}
