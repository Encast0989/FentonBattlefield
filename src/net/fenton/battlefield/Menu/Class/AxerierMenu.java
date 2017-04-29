package net.fenton.battlefield.Menu.Class;

import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Menu.ClassMenu;
import net.fenton.battlefield.Player.BFPlayer;
import net.fenton.battlefield.Player.BFPlayerData;
import net.fenton.core.inventory.FentonInventory;
import net.fenton.core.inventory.FentonInventoryHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2016-12-30), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 4:11 PM
 */
public class AxerierMenu extends FentonInventory {

    public AxerierMenu() {
        super("AxerierClass", false, 45);
    }

    @Override
    public void openInventory(Player player) {
        Inventory i = getInventory();
        ClassMenu.getInstance().openInventory(player, i, BattlefieldClassData.BFClass.AXERIER);
    }

    @Override
    public void onClick(Player p, ItemStack i) {
        if(i.hasItemMeta()) {
            String name = ChatColor.stripColor(i.getItemMeta().getDisplayName());
            if(name.equalsIgnoreCase("Go back to shop")) {
                FentonInventoryHandler.getInstance().getMenuByID("BF:RegularClassMenu").openInventory(p);
            } else if(name.equalsIgnoreCase("Axerier UPGRADE")) {
                BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                if(bfp.getClassLevel().getLevelByName(BattlefieldClassData.BFClass.AXERIER) < 5) {
                    ClassMenu.getInstance().upgradeClass(p, BattlefieldClassData.BFClass.AXERIER,
                            (bfp.getClassLevel().getLevelByName(BattlefieldClassData.BFClass.AXERIER) + 1));
                } else {
                    p.sendMessage("§cYou already have the max level for this class!");
                }
            } else if(name.equalsIgnoreCase("Ability UPGRADE")) {
                BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                if(bfp.getClassLevel().getAbilityLevelByName(BattlefieldClassData.BFClass.AXERIER) < 5) {
                    ClassMenu.getInstance().upgradeAbility(p, BattlefieldClassData.BFClass.AXERIER,
                            (bfp.getClassLevel().getAbilityLevelByName(BattlefieldClassData.BFClass.AXERIER) + 1));
                } else {
                    p.sendMessage("§cYou already have the max ability level for this class!");
                }
            } else if(name.equalsIgnoreCase("Axerier")) {
                p.sendMessage("§cYou already have the max level for this class!");
            } else if(name.equalsIgnoreCase("Choose Class")) {
                ClassMenu.getInstance().chooseClass(p, BattlefieldClassData.BFClass.AXERIER);
            }
        }
    }
}
