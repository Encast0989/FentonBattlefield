package net.fenton.battlefield.bfclass.Blaze;

import net.fenton.battlefield.bfclass.BattlefieldClass;
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
public class BlazeI extends BattlefieldClass {

    public BlazeI() {
        super("Blaze I", 1, true, 1000, new ItemStack(Material.BLAZE_POWDER));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.DAMAGE_ALL, 1);

        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.ORANGE, "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1,
                Color.ORANGE, "", null), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.CHAINMAIL_BOOTS), ArmourSlot.BOOTS);

        addItem(FentonItemStack.createStack().createItemStack(Material.WOOD_SPADE, 1, "", enchants, null));
        addItem(new ItemStack(Material.BOW));
        addItem(new ItemStack(Material.ARROW, 6));
    }
}
