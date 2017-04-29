package net.fenton.battlefield.Class;

import net.fenton.battlefield.Player.BFPlayer;
import net.fenton.battlefield.Player.BFPlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by Encast (2017-02-02 11:38 AM)
 */
public class BattlefieldAbilityHandler implements Listener {

    private static BattlefieldAbilityHandler instance;
    public static BattlefieldAbilityHandler getInstance() {
        return instance;
    }

    public BattlefieldAbilityHandler() {
        instance = this;
    }

    // FREE - 5000 - 20,000 - 45,000 - 75,000
    final private double LEVEL_ONE = 0;
    final private double LEVEL_TWO = 5000;
    final private double LEVEL_THREE = 20_000;
    final private double LEVEL_FOUR = 45_000;
    final private double LEVEL_FIVE = 75_000;

    public double getCostByLevel(int level) {
        switch(level) {
            case 1:
                return LEVEL_ONE;
            case 2:
                return LEVEL_TWO;
            case 3:
                return LEVEL_THREE;
            case 4:
                return LEVEL_FOUR;
            case 5:
                return LEVEL_FIVE;
            default:
                return LEVEL_ONE;
        }
    }

    public void fullEnergy(Player p) {
        //TODO
    }

    // Agrotis
    @EventHandler
    public void onAgrotisAbilityUse(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem() != null) {
            BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
            if(BattlefieldClassData.getInstance().getClassByName(BattlefieldClassData.BFClass.AGROTIS)
                    .getByLevel(bfp.getClassLevel().getAgrotis().getLevel()).getItems().contains(e.getItem())) {
                if(bfp.getEnergy() == 100) {
                    PotionEffect effect;
                    p.sendMessage("§aActivated Temper!");
                    switch(bfp.getClassLevel().getAgrotis().getAbilityLevel()) {
                        case 1:
                            effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 30, 0, true, false);
                            p.addPotionEffect(effect);
                            bfp.setEnergy(0);
                            break;
                        case 2:
                            effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0, true, false);
                            p.addPotionEffect(effect);
                            bfp.setEnergy(0);
                            break;
                        case 3:
                            effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 50, 0, true, false);
                            p.addPotionEffect(effect);
                            bfp.setEnergy(0);
                            break;
                        case 4:
                            effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60, 0, true, false);
                            p.addPotionEffect(effect);
                            bfp.setEnergy(0);
                            break;
                        case 5:
                            effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0, true, false);
                            p.addPotionEffect(effect);
                            bfp.setEnergy(0);
                            break;
                        default:
                            p.sendMessage("§cSomething happened while trying to active your ability!");
                            break;
                    }
                }
            }
        }
    }

    // Archer
    // Axerier
    // Blasty
    // Blaze
    // Kivos
    // Molesir
    // Oucher
    // Relyt
}
