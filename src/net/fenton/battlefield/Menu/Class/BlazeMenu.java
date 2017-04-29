package net.fenton.battlefield.menu.Class;

import net.fenton.battlefield.bfclass.BattlefieldClassData;
import net.fenton.battlefield.menu.ClassMenu;
import net.fenton.battlefield.player.BFPlayer;
import net.fenton.battlefield.player.BFPlayerData;
import net.fenton.core.inventory.FentonInventory;
import net.fenton.core.inventory.FentonInventoryHandler;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2017-01-10 5:15 PM)
 */
public class BlazeMenu extends FentonInventory {

    public BlazeMenu() {
        super("Blaze", false, 45);
    }

    @Override
    public void openInventory(Player p) {
        Inventory i = getInventory();
        ClassMenu.getInstance().openInventory(p, i, BattlefieldClassData.BFClass.BLAZE);
    }

    @Override
    public void onClick(Player p, ItemStack i) {
        if(i.hasItemMeta()) {
            String name = ChatColor.stripColor(i.getItemMeta().getDisplayName());
            if(name.equalsIgnoreCase("Go back to shop")) {
                FentonInventoryHandler.getInstance().getMenuByID("BF:UltimateClassMenu").openInventory(p);
            } else if(name.equalsIgnoreCase("Blaze UPGRADE")) {
                BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                if(bfp.getClassLevel().getLevelByName(BattlefieldClassData.BFClass.BLAZE) < 5) {
                    ClassMenu.getInstance().upgradeClass(p, BattlefieldClassData.BFClass.BLAZE,
                            (bfp.getClassLevel().getLevelByName(BattlefieldClassData.BFClass.BLAZE) + 1));
                } else {
                    p.sendMessage("§cYou already have the max level for this class!");
                }
            } else if(name.equalsIgnoreCase("Ability UPGRADE")) {
                BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
                if(bfp.getClassLevel().getAbilityLevelByName(BattlefieldClassData.BFClass.BLAZE) < 5) {
                    ClassMenu.getInstance().upgradeAbility(p, BattlefieldClassData.BFClass.BLAZE,
                            (bfp.getClassLevel().getAbilityLevelByName(BattlefieldClassData.BFClass.BLAZE) + 1));
                } else {
                    p.sendMessage("§cYou already have the max ability level for this class!");
                }
            } else if(name.equalsIgnoreCase("Blaze")) {
                p.sendMessage("§cYou already have the max level for this class!");
            } else if(name.equalsIgnoreCase("Choose bfclass")) {
                ClassMenu.getInstance().chooseClass(p, BattlefieldClassData.BFClass.BLAZE);
            }
        }
    }
}
