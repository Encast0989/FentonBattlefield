package net.fenton.battlefield.Class;

import net.fenton.core.enhancedbukkit.FentonItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

/**
 * Created by Encast (2016-12-27), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 3:18 PM
 */
public class InstantKillBow {

    private static InstantKillBow instance;
    public static InstantKillBow getInstance() {
        return instance;
    }

    public InstantKillBow() {
        instance = this;
    }

    public void getLevelOne(Player p) {
        ItemStack bow = FentonItemStack.createStack().createItemStack(Material.BOW, 1, "§cInstant Kill Bow §b[1]",
                Arrays.asList(" ", "§7Shoot the bow to instant kill a", "§7player on contact!"));
        p.getInventory().addItem(bow, new ItemStack(Material.ARROW, 1));
    }

    public void getLevelTwo(Player p) {
        ItemStack bow = FentonItemStack.createStack().createItemStack(Material.BOW, 1, "§cInstant Kill Bow §b[2]",
                Arrays.asList(" ", "§7Shoot the bow to instant kill a", "§7player on contact!"));
        p.getInventory().addItem(bow, new ItemStack(Material.ARROW, 2));
    }

    public void getLevelThree(Player p) {
        ItemStack bow = FentonItemStack.createStack().createItemStack(Material.BOW, 1, "§cInstant Kill Bow §b[3]",
                Arrays.asList(" ", "§7Shoot the bow to instant kill a", "§7player on contact!"));
        p.getInventory().addItem(bow, new ItemStack(Material.ARROW, 3));
    }

    public void getLevelFour(Player p) {
        ItemStack bow = FentonItemStack.createStack().createItemStack(Material.BOW, 1, "§cInstant Kill Bow §b[4]",
                Arrays.asList(" ", "§7Shoot the bow to instant kill a", "§7player on contact!"));
        p.getInventory().addItem(bow, new ItemStack(Material.ARROW, 4));
    }

    public void getLevelFive(Player p) {
        ItemStack bow = FentonItemStack.createStack().createItemStack(Material.BOW, 1, "§cInstant Kill Bow §b[5]",
                Arrays.asList(" ", "§7Shoot the bow to instant kill a", "§7player on contact!"));
        p.getInventory().addItem(bow, new ItemStack(Material.ARROW, 5));
    }

    public void applyByLevel(Player p, int level) {
        switch(level) {
            case 1:
                getLevelOne(p);
                break;
            case 2:
                getLevelTwo(p);
                break;
            case 3:
                getLevelThree(p);
                break;
            case 4:
                getLevelFour(p);
                break;
            case 5:
                getLevelFive(p);
                break;
            default:
                getLevelOne(p);
                break;
        }
    }
}
