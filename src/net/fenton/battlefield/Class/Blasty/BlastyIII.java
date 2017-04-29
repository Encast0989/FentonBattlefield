package net.fenton.battlefield.Class.Blasty;

import net.fenton.battlefield.Class.BattlefieldClass;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 3:38 PM
 */
public class BlastyIII extends BattlefieldClass {

    public BlastyIII() {
        super("Blasty III", 3, false, 10_000, new ItemStack(Material.TNT));

        addWearableItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE), ArmourSlot.CHESTPLATE);
        addWearableItem(new ItemStack(Material.CHAINMAIL_LEGGINGS), ArmourSlot.LEGGINGS);

        addItem(new ItemStack(Material.STONE_SWORD));
    }
}
