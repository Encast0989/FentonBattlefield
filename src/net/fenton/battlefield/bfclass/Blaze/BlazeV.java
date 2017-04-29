package net.fenton.battlefield.bfclass.Blaze;

import net.fenton.battlefield.bfclass.BattlefieldClass;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2017-01-10 4:45 PM)
 */
public class BlazeV extends BattlefieldClass {

    public BlazeV() {
        super("Blaze V", 5, true, 125_000, new ItemStack(Material.BLAZE_POWDER));

        Map<Enchantment, Integer> enchants = new HashMap<>();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        addWearableItem(FentonItemStack.createStack().createItemStack(Material.IRON_HELMET, 1, "",
                enchants, null), ArmourSlot.HELMET);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_FIRE, 2);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.CHAINMAIL_CHESTPLATE, 1, "",
                enchants, null), ArmourSlot.CHESTPLATE);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.GOLD_LEGGINGS, 1, "",
                enchants, null), ArmourSlot.LEGGINGS);
        enchants.clear();
        enchants.put(Enchantment.PROTECTION_FIRE, 2);
        addWearableItem(FentonItemStack.createStack().createItemStack(Material.CHAINMAIL_BOOTS, 1, "", enchants, null), ArmourSlot.BOOTS);

        enchants.clear();
        enchants.put(Enchantment.DAMAGE_ALL, 2);
        addItem(FentonItemStack.createStack().createItemStack(Material.DIAMOND_SPADE, 1, "", enchants, null));
        enchants.clear();
        enchants.put(Enchantment.ARROW_FIRE, 1);
        enchants.put(Enchantment.ARROW_DAMAGE, 1);
        addItem(FentonItemStack.createStack().createItemStack(Material.BOW, 1, "", enchants, null));
        addItem(new ItemStack(Material.ARROW, 22));
    }
}
