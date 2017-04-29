package net.fenton.battlefield.Class.Relyt;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2017-01-16 6:15 PM)
 */
public class RelytI extends BattlefieldClass {

    public RelytI() {
        super("Relyt I", 1, false, 0, FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.ORANGE, "", null));

        addWearableItem(new ItemStack(Material.CHAINMAIL_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1, Color.ORANGE,
                "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1, Color.ORANGE,
                "", null), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.CHAINMAIL_BOOTS), ArmourSlot.BOOTS);

        addItem(new ItemStack(Material.WOOD_SWORD));
    }
}
