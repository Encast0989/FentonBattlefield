package net.fenton.battlefield.Player;

import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Class.InstantKillBow;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Encast (2016-12-27), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 2:20 PM
 */
public class ClassDistributor {

    private static ClassDistributor instance;
    public static ClassDistributor getInstance() {
        return instance;
    }

    public ClassDistributor() {
        instance = this;
    }

    public void giveKit(Player p, BattlefieldClassData.BFClass bfClass) {
        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        BattlefieldClassData.getInstance().getClassByName(bfClass).getByLevel(bfp.getClassLevel()
                .getLevelByName(bfClass)).applyItems(p);
        InstantKillBow.getInstance().applyByLevel(p, bfp.getArrowLevel());
        if(bfp.hasFishingRod()) {
            p.getInventory().addItem(new ItemStack(Material.FISHING_ROD));
        }
        //TODO Fire a ClassRecievedEvent in the future?
    }
}
