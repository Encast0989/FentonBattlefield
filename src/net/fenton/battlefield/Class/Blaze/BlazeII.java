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
public class BlazeII extends BattlefieldClass {

    public BlazeII() {
        super("Blaze II", 2, true, 5000, new ItemStack(Material.BLAZE_POWDER));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_PROJECTILE, 1);

        addWearableItem(new ItemStack(Material.GOLD_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.ORANGE, "", null, enchants), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1,
                Color.ORANGE, "", null), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.CHAINMAIL_BOOTS), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.DAMAGE_ALL, 1);
        addItem(FentonItemStack.createStack().createItemStack(Material.STONE_SPADE, 1, "", enchants, null));
        addItem(new ItemStack(Material.BOW));
        addItem(new ItemStack(Material.ARROW, 10));
    }
}
