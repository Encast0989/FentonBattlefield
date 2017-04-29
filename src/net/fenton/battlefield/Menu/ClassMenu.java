package net.fenton.battlefield.menu;

import net.fenton.api.Fenton;
import net.fenton.battlefield.bfclass.BattlefieldAbility;
import net.fenton.battlefield.bfclass.BattlefieldClass;
import net.fenton.battlefield.bfclass.BattlefieldClassData;
import net.fenton.battlefield.bfclass.BattlefieldAbilityHandler;
import net.fenton.battlefield.player.BFPlayer;
import net.fenton.battlefield.player.BFPlayerData;
import net.fenton.core.enhancedbukkit.FentonItemStack;
import net.fenton.core.inventory.FentonInventoryHandler;
import net.fenton.core.player.FentonPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * bfclass created at: 9:25 PM
 */
public class ClassMenu {

    private static ClassMenu instance;
    public static ClassMenu getInstance() {
        return instance;
    }

    public ClassMenu() {
        instance = this;
    }
    //TODO description to bf ability
    public void openInventory(Player p, Inventory i, BattlefieldClassData.BFClass bfClass) {
        BFPlayer bfPlayer = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        BattlefieldClass c = BattlefieldClassData.getInstance().getClassByName(bfClass)
                .getByLevel(bfPlayer.getClassLevel().getLevelByName(bfClass));
        BattlefieldClass c2 = BattlefieldClassData.getInstance().getClassByName(bfClass)
                .getByLevel(bfPlayer.getClassLevel().getLevelByName(bfClass) + 1);
        DecimalFormat format = new DecimalFormat("#");
        // Go back
        ItemStack goBack = FentonItemStack.createStack()
                .createItemStack(Material.DIAMOND, 1, "§bGo back to Shop", null);

        ItemStack classStack = FentonItemStack.createStack().createItemStack(Material.WOOL, 1, (short) 10,
                "§5" + bfClass.getName() + " §6§lUPGRADE", Arrays.asList(" ", "§9§lCLICK §7to upgrade " + bfClass.getName() + "!"));
        ItemStack abilityStack = FentonItemStack.createStack().createItemStack(Material.WOOL, 1, (short) 10,
                "§5Ability §6§lUPGRADE", Arrays.asList(" ", "§9§lCLICK §7to upgrade " + bfClass.getName() + " Ability!"));
        ItemStack layoutStack = FentonItemStack.createStack().createItemStack(Material.WOOL, 1, (short) 9,
                "§bEdit Layout", Arrays.asList(" ", "§cComing Soon!"));

        int slotCount = 11;
        // bfclass
        for(BattlefieldClassData.BFClass classType : BattlefieldClassData.BFClass.values()) {
            if(classType == bfClass) {
                for(BattlefieldClass classes : BattlefieldClassData.getInstance().getClassByName(classType).getClasses()) {
                    ItemStack item;
                    if(c.getLevel() == 5) {
                        item = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
                    } else if(c.getLevel() >= 1) {
                        if(classes.getLevel() <= c.getLevel()) {
                            item = new ItemStack(Material.STAINED_CLAY, 1, (short) 11);
                        } else {
                            item = new ItemStack(Material.STAINED_CLAY, 1, (short) 9);
                        }
                    } else {
                        item = new ItemStack(Material.STAINED_CLAY, 1, (short) 9);
                    }
                    ItemMeta m = item.getItemMeta();
                    m.setDisplayName(bfClass.getColour() + classes.getName());
                    List<String> lore = new ArrayList<>();
                    lore.add("§6Level: " + c.getLevel() + (classes.getLevel() <= c.getLevel() ? " §aPurchased" : " §6Cost: " + format.format(classes.getCost()) + " Coins"));
                    lore.add("§8Armour:");
                    for(ItemStack stack : classes.getWearableItems().values()) {
                        lore.add("§7- " + stack.getType().name().toLowerCase().replaceAll("_", " "));
                        if(stack.getEnchantments() != null) {
                            for(Enchantment enchant : stack.getEnchantments().keySet()) {
                                lore.add("  §7• " + enchant.getName().toLowerCase().replaceAll("_", " ") + " " + stack.getEnchantments().get(enchant));
                            }
                        }
                    }
                    lore.add("§8Items:");
                    for(ItemStack stack : classes.getItems()) {
                        lore.add("§7- " + stack.getType().name().toLowerCase());
                        if(stack.getEnchantments() != null) {
                            for(Enchantment enchant : stack.getEnchantments().keySet()) {
                                lore.add("  §7• " + enchant.getName().toLowerCase().replaceAll("_", " ") + " " + stack.getEnchantments().get(enchant));
                            }
                        }
                    }
                    m.setLore(lore);
                    item.setItemMeta(m);
                    i.setItem(slotCount, item);
                    slotCount++;
                    if(slotCount == 16) {
                        slotCount = 20;
                    }
                }
            }
        }

        // Ability
        for(BattlefieldAbility ability : BattlefieldAbility.values()) {
            if(ability.getBfClass() == bfClass) {
                ItemStack item;
                if(bfPlayer.getClassLevel().getAbilityLevelByName(bfClass) == 5) {
                    item = new ItemStack(Material.STAINED_CLAY, 1, (short) 4);
                } else if(ability.getLevel() <= bfPlayer.getClassLevel().getAbilityLevelByName(bfClass)) {
                    item = new ItemStack(Material.STAINED_CLAY, 1, (short) 11);
                } else {
                    item = new ItemStack(Material.STAINED_CLAY, 1, (short) 9);
                }
                ItemMeta m = item.getItemMeta();
                m.setDisplayName("§5" + ability.getName());
                List<String> lore = new ArrayList<>();
                lore.add((ability.getLevel() <= bfPlayer.getClassLevel().getAbilityLevelByName(bfClass) ? "§aPurchased"
                        : ("§6Cost: " + format.format(BattlefieldAbilityHandler.getInstance().getCostByLevel(ability.getLevel()))
                        + " Coins")));
                for(String l : ability.getDescription()) {
                    lore.add("§7" + l);
                }
                m.setLore(lore);
                item.setItemMeta(m);
                i.setItem(slotCount, item);
                slotCount++;
            }
        }

        // Choose class
        ItemStack chooseClass = FentonItemStack.createStack().createItemStack(Material.LAPIS_BLOCK, 1, "§eChoose bfclass",
                        Arrays.asList(" ", "§7Click to choose " + bfClass.getName() + " as your", "§7class."));
        // Setting items
        i.setItem(10, classStack);
        i.setItem(16, layoutStack);
        i.setItem(19, abilityStack);
        i.setItem(39, goBack);
        i.setItem(41, chooseClass);

        // Opening inventory
        p.openInventory(i);
    }

    public void upgradeClass(Player p, BattlefieldClassData.BFClass bfClass, int level) {
        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        if((bfp.getClassLevel().getLevelByName(bfClass) + 1) == level) {
            if(BattlefieldClassData.getInstance().getClassByName(bfClass).isEnabled()) {
                if(bfp.getCoins() >= BattlefieldClassData.getInstance().getClassByName(bfClass).getByLevel(level).getCost()) {
                    bfp.removeCoins(BattlefieldClassData.getInstance().getClassByName(bfClass).getByLevel(level).getCost());
                    bfp.getClassLevel().setClassLevel(bfClass, level);
                    p.sendMessage("§aYou have upgraded §6" + bfClass.getName() + " §ato §3Level " + level + "§a!");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
                    FentonInventoryHandler.getInstance().getMenuByID("BF:" + bfClass.getName() + "menu").openInventory(p);
                    FentonPlayer fp = Fenton.getAPI().getPlayerHandler().getPlayers().get(p.getUniqueId());
                    if(level == 5) {
                        Bukkit.getServer().broadcastMessage(fp.getPrefixedName() + " §fhas unlocked the final level for §6" + bfClass.getName());
                        Bukkit.getServer().getOnlinePlayers().forEach(online -> online.playSound(online.getLocation(), Sound.ENDERDRAGON_GROWL, 5, 1));
                    }
                    if(bfp.getCurrentClass() != bfClass) {
                        bfp.setCurrentClass(bfClass);
                        sendClassChosenMessage(p, bfClass);
                    }
                } else {
                    p.sendMessage("§cYou do not have enough coins to purchase this upgrade.");
                }
            } else {
                p.sendMessage("§cYou cannot upgrade this class!");
            }
        } else {
            p.sendMessage("§cYou can't upgrade this class!");
        }
    }

    public void upgradeAbility(Player p, BattlefieldClassData.BFClass bfClass, int level) {
        boolean enabled = false;
        if(!enabled) {
            p.sendMessage("§cAbilities are coming soon!");
            return;
        }
        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        if((bfp.getClassLevel().getAbilityLevelByName(bfClass) + 1) == level) {
            if(BattlefieldClassData.getInstance().getClassByName(bfClass).isEnabled()) {
                if(bfp.getCoins() >= BattlefieldAbilityHandler.getInstance().getCostByLevel(level)) {
                    bfp.removeCoins(BattlefieldAbilityHandler.getInstance().getCostByLevel(level));
                    bfp.getClassLevel().setAbilityLevelByName(bfClass, level);
                    p.sendMessage("§aYou have upgraded §6" + bfClass.getName() + " Ability §ato §3Level " + level + "§a!");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 5, 1);
                    FentonInventoryHandler.getInstance().getMenuByID("BF:" + bfClass.getName() + "menu").openInventory(p);
                } else {
                    p.sendMessage("§cYou do not have enough coins to purchase this upgrade.");
                }
            } else {
                p.sendMessage("§cYou cannot upgrade this ability!");
            }
        } else {
            p.sendMessage("§cYou can't upgrade this ability!");
        }
    }

    public void chooseClass(Player p, BattlefieldClassData.BFClass bfClass) {
        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        if(BattlefieldClassData.getInstance().getClassByName(bfClass).isEnabled()) {
            if(bfp.getClassLevel().getLevelByName(bfClass) > 0) {
                if(bfp.getCurrentClass() != bfClass) {
                    bfp.setCurrentClass(bfClass);
                    p.closeInventory();
                    sendClassChosenMessage(p, bfClass);
                } else {
                    p.sendMessage("§cYou have already chosen " + bfClass.getName() + "!");
                }
            } else {
                p.sendMessage("§cYou must unlock this class before choosing it!");
            }
        } else {
            p.sendMessage("§cYou cannot choose this class!");
        }
    }

    private void sendClassChosenMessage(Player p, BattlefieldClassData.BFClass bfClass) {
        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        p.setPlayerListName(Fenton.getAPI().getPlayerHandler().getPlayer(p.getUniqueId()).getPrefixedName() + " §e" + bfClass.getPrefix());
        p.sendMessage("§bYou have chosen §6" + bfClass.getName() + " §3[" + bfp.getClassLevel().getLevelByName(bfClass) + "]§b!");
    }
}
