package net.fenton.battlefield.bfclass;

import net.fenton.battlefield.player.BFPlayer;
import net.fenton.battlefield.player.BFPlayerData;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 2:44 PM
 */
public abstract class BattlefieldClass {

    public enum ArmourSlot {
        HELMET("helmet"),
        CHESTPLATE("chestplate"),
        LEGGINGS("leggings"),
        BOOTS("boots");

        private String identifierName;

        ArmourSlot(String identifierName) {
            this.identifierName = identifierName;
        }

        public String getIdentifierName() {
            return identifierName;
        }
    }

    private String name;
    private int level;
    private boolean ultimate;
    private double cost;
    private ItemStack displayItem;
    private Map<ArmourSlot, ItemStack> wearableItems;
    private List<ItemStack> items;

    public BattlefieldClass(String name, int level, boolean ultimate, double cost, ItemStack displayItem) {
        this.name = name;
        this.level = level;
        this.ultimate = ultimate;
        this.cost = cost;
        this.displayItem = displayItem;
        wearableItems = new HashMap<>();
        items = new ArrayList<>();
    }

    public void addWearableItem(ItemStack item, ArmourSlot slot) {
        wearableItems.put(slot, item);
    }

    public void addItem(ItemStack item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public boolean isUltimate() {
        return ultimate;
    }

    public double getCost() {
        return cost;
    }

    public ItemStack getDisplayItem() {
        return displayItem;
    }

    public Map<ArmourSlot, ItemStack> getWearableItems() {
        return wearableItems;
    }

    public List<ItemStack> getItems() {
        return items;
    }

    public final void applyItems(Player p) {
        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        p.getInventory().setHelmet(wearableItems.get(ArmourSlot.HELMET));
        p.getInventory().setChestplate(wearableItems.get(ArmourSlot.CHESTPLATE));
        p.getInventory().setLeggings(wearableItems.get(ArmourSlot.LEGGINGS));
        p.getInventory().setBoots(wearableItems.get(ArmourSlot.BOOTS));

        for(ItemStack item : items) {
            p.getInventory().addItem(item);
        }
        if(bfp.hasFishingRod()) {
            Map<Enchantment, Integer> enchants = new HashMap<>();
            enchants.put(Enchantment.DAMAGE_ALL, 2);
            p.getInventory().addItem(FentonItemStack.createStack().createItemStack(Material.FISHING_ROD, 1, "§cFishing Rod",
                    enchants, null));
        }
        //TODO Add instant kill bow.
    }
}
