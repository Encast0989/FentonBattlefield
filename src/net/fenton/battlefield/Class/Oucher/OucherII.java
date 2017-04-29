package net.fenton.battlefield.Class.Oucher;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2017-01-16 6:52 PM)
 */
public class OucherII extends BattlefieldClass {

    public OucherII() {
        super("Oucher II", 2, false, 2000, FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.BLUE, "", null));

        addWearableItem(new ItemStack(Material.GOLD_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.BLUE, "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1,
                Color.BLUE, "", null), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_BOOTS, 1,
                Color.BLUE, "", null), ArmourSlot.BOOTS);

        addItem(new ItemStack(Material.STONE_SWORD));
    }
}
