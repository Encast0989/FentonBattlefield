package net.fenton.battlefield.Class.Blaze;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2017-01-10 4:45 PM)
 */
public class BlazeIII extends BattlefieldClass {

    public BlazeIII() {
        super("Blaze III", 3, true, 25_000, new ItemStack(Material.BLAZE_POWDER));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        addWearableItem(new ItemStack(Material.IRON_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.ORANGE, "", null, enchants), ArmourSlot.CHESTPLATE);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1,
                Color.ORANGE, "", null, enchants), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.CHAINMAIL_BOOTS), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.DAMAGE_ALL, 1);
        addItem(FentonItemStack.createStack().createItemStack(Material.IRON_SPADE, 1, "", enchants, null));
        enchants.clear();
        enchants.put(Enchantment.ARROW_FIRE, 1);
        addItem(FentonItemStack.createStack().createItemStack(Material.BOW, 1, "", enchants, null));
        addItem(new ItemStack(Material.ARROW, 14));
    }
}
