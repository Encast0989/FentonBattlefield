package net.fenton.battlefield.bfclass.Blasty;

import net.fenton.battlefield.bfclass.BattlefieldClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 2:55 PM
 */
public class BlastyI extends BattlefieldClass {

    public BlastyI() {
        super("Blasty I", 1, false, 0, new ItemStack(Material.TNT));

        addWearableItem(new ItemStack(Material.LEATHER_CHESTPLATE), ArmourSlot.CHESTPLATE);
        addWearableItem(new ItemStack(Material.LEATHER_LEGGINGS), ArmourSlot.LEGGINGS);

        addItem(new ItemStack(Material.WOOD_SWORD));
    }
}
