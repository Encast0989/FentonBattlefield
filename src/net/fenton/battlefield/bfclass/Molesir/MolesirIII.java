package net.fenton.battlefield.bfclass.Molesir;

import net.fenton.battlefield.bfclass.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2017-01-07), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 1:32 PM
 */
public class MolesirIII extends BattlefieldClass {

    public MolesirIII() {
        super("Molesir III", 3, false, 10_000, new ItemStack(Material.STONE_PICKAXE));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        addWearableItem(FentonItemStack.createStack().createItemStack(Material.GOLD_HELMET, 1,
                "", null), BattlefieldClass.ArmourSlot.HELMET);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_CHESTPLATE, 1,
                Color.WHITE, "", null), BattlefieldClass.ArmourSlot.CHESTPLATE);
        addWearableItem(FentonItemStack.createStack().createLeatherArmour(Material.LEATHER_LEGGINGS, 1,
                Color.WHITE, "", null), BattlefieldClass.ArmourSlot.LEGGINGS);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.GOLD_BOOTS, 1,
                "", enchants, null), BattlefieldClass.ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.DAMAGE_ALL, 1);
        addItem(FentonItemStack.createStack().createItemStack(Material.STONE_PICKAXE, 1, "", enchants, null));
    }
}
