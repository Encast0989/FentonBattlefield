package net.fenton.battlefield.bfclass.Relyt;

import net.fenton.battlefield.bfclass.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2017-01-16 6:15 PM)
 */
public class RelytII extends BattlefieldClass {

    public RelytII() {
        super("Relyt II", 2, false, 2000, FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.ORANGE, "", null));

        addWearableItem(new ItemStack(Material.CHAINMAIL_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.ORANGE,
                "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1, Color.ORANGE,
                "", null), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.IRON_BOOTS), ArmourSlot.BOOTS);

        addItem(new ItemStack(Material.WOOD_SWORD));
    }
}
