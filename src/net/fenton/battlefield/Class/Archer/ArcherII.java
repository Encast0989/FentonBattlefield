package net.fenton.battlefield.Class.Archer;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 5:17 PM
 */
public class ArcherII extends BattlefieldClass {

    public ArcherII() {
        super("Archer II", 2, false, 2000, new ItemStack(Material.BOW));

        addWearableItem(new ItemStack(Material.CHAINMAIL_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.LIME, "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.LIME, "", null), ArmourSlot.LEGGINGS);
        addWearableItem(new ItemStack(Material.CHAINMAIL_BOOTS), ArmourSlot.BOOTS);

        addItem(new ItemStack(Material.WOOD_AXE));
        addItem(new ItemStack(Material.BOW));
        addItem(new ItemStack(Material.ARROW, 24));
    }
}
