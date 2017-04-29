package net.fenton.battlefield.Class.Archer;

import net.fenton.battlefield.Class.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 5:17 PM
 */
public class ArcherIII extends BattlefieldClass {

    public ArcherIII() {
        super("Archer III", 3, false, 10_000, new ItemStack(Material.BOW));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_PROJECTILE, 1);

        addWearableItem(new ItemStack(Material.IRON_HELMET), ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.LIME, "", null), ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.LIME, "", null), ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.IRON_BOOTS, 1, "",
                enchants, null), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.ARROW_DAMAGE, 1);
        addItem(new ItemStack(Material.WOOD_AXE));
        addItem(FentonItemStack.createStack().createItemStack(Material.BOW, 1, "", enchants, null));
        addItem(new ItemStack(Material.ARROW, 32));
    }
}
