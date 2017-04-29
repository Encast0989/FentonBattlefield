package net.fenton.battlefield.Class;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Encast (2017-02-02 11:38 AM)
 */
public enum BattlefieldAbility {

    // Agrotis
    TEMPER_I("Temper I", BattlefieldClassData.BFClass.AGROTIS, 1, Arrays.asList(" ", "Gain strength I for 1.5 seconds.")),
    TEMPER_II("Temper II", BattlefieldClassData.BFClass.AGROTIS, 2, Arrays.asList(" ", "Gain strength I for 2 seconds.")),
    TEMPER_III("Temper III", BattlefieldClassData.BFClass.AGROTIS, 3, Arrays.asList(" ", "Gain strength I for 2.5 seconds.")),
    TEMPER_IV("Temper IV", BattlefieldClassData.BFClass.AGROTIS, 4, Arrays.asList(" ", "Gain strength I for 3 seconds.")),
    TEMPER_V("Temper V", BattlefieldClassData.BFClass.AGROTIS, 5, Arrays.asList(" ", "Gain strength I for 5 seconds.")),

    // Archer
    ARROW_RAID_I("Arrow Raid I", BattlefieldClassData.BFClass.ARCHER, 1, Arrays.asList(" ", "Left click the shoot x3 arrows.")),
    ARROW_RAID_II("Arrow Raid II", BattlefieldClassData.BFClass.ARCHER, 2, Arrays.asList(" ", "Left click the shoot x5 arrows.")),
    ARROW_RAID_III("Arrow Raid III", BattlefieldClassData.BFClass.ARCHER, 3, Arrays.asList(" ", "Left click the shoot x7 arrows.")),
    ARROW_RAID_IV("Arrow Raid IV", BattlefieldClassData.BFClass.ARCHER, 4, Arrays.asList(" ", "Left click the shoot x9 arrows.")),
    ARROW_RAID_V("Arrow Raid V", BattlefieldClassData.BFClass.ARCHER, 5, Arrays.asList(" ", "Left click the shoot x11 arrows.")),

    // Axerier
    AXE_PIERCE_I("Axe Pierce I", BattlefieldClassData.BFClass.AXERIER, 1, Arrays.asList(" ", "+1 heart of damage on hits.")),
    AXE_PIERCE_II("Axe Pierce II", BattlefieldClassData.BFClass.AXERIER, 2, Arrays.asList(" ", "+1.5 heart of damage on hits.")),
    AXE_PIERCE_III("Axe Pierce III", BattlefieldClassData.BFClass.AXERIER, 3, Arrays.asList(" ", "+2 heart of damage on hits.")),
    AXE_PIERCE_IV("Axe Pierce IV", BattlefieldClassData.BFClass.AXERIER, 4, Arrays.asList(" ", "+3 heart of damage on hits.")),
    AXE_PIERCE_V("Axe Pierce V", BattlefieldClassData.BFClass.AXERIER, 5, Arrays.asList(" ", "+4 heart of damage on hits.")),

    // Blasty
    TNT_HAVEN_I("TNT Haven I", BattlefieldClassData.BFClass.BLASTY, 1, Arrays.asList(" ", "Receive 1 TNT (10 tick explosion).")),
    TNT_HAVEN_II("TNT Haven II", BattlefieldClassData.BFClass.BLASTY, 2, Arrays.asList(" ", "Receive 3 TNT (10 tick explosion).")),
    TNT_HAVEN_III("TNT Haven III", BattlefieldClassData.BFClass.BLASTY, 3, Arrays.asList(" ", "Receive 5 TNT (10 tick explosion).")),
    TNT_HAVEN_IV("TNT Haven IV", BattlefieldClassData.BFClass.BLASTY, 4, Arrays.asList(" ", "Receive 7 TNT (10 tick explosion).")),
    TNT_HAVEN_V("TNT Haven V", BattlefieldClassData.BFClass.BLASTY, 5, Arrays.asList(" ", "Receive 10 TNT (10 tick explosion).")),

    // Blaze
    FIREBALL_I("Fireball I", BattlefieldClassData.BFClass.BLAZE, 1, Arrays.asList(" ", "Shoot 1 fireball at a player. (100 energy)")),
    FIREBALL_II("Fireball II", BattlefieldClassData.BFClass.BLAZE, 2, Arrays.asList(" ", "Shoot 1 fireball at a player. (80 energy)")),
    FIREBALL_III("Fireball III", BattlefieldClassData.BFClass.BLAZE, 3, Arrays.asList(" ", "Shoot 1 fireball at a player. (60 energy)")),
    FIREBALL_IV("Fireball IV", BattlefieldClassData.BFClass.BLAZE, 4, Arrays.asList(" ", "Shoot 1 fireball at a player. (40 energy)")),
    FIREBALL_V("Fireball V", BattlefieldClassData.BFClass.BLAZE, 5, Arrays.asList(" ", "Shoot 1 fireball at a player. (30 energy)")),

    // Kivos
    SHARP_END_I("Sharp End I", BattlefieldClassData.BFClass.KIVOS, 1, Arrays.asList(" ", "+1 sharpness (1 max).")),
    SHARP_END_II("Sharp End II", BattlefieldClassData.BFClass.KIVOS, 2, Arrays.asList(" ", "+1 sharpness (2 max).")),
    SHARP_END_III("Sharp End III", BattlefieldClassData.BFClass.KIVOS, 3, Arrays.asList(" ", "+1 sharpness (3 max).")),
    SHARP_END_IV("Sharp End IV", BattlefieldClassData.BFClass.KIVOS, 4, Arrays.asList(" ", "+1 sharpness (4 max).")),
    SHARP_END_V("Sharp End V", BattlefieldClassData.BFClass.KIVOS, 5, Arrays.asList(" ", "+1 sharpness (5 max).")),

    // Molesir
    RESISTANCE_I("Resistance I", BattlefieldClassData.BFClass.MOLESIR, 1, Arrays.asList(" ", "Gain resistance II for 2 seconds.")),
    RESISTANCE_II("Resistance II", BattlefieldClassData.BFClass.MOLESIR, 2, Arrays.asList(" ", "Gain resistance II for 3 seconds.")),
    RESISTANCE_III("Resistance III", BattlefieldClassData.BFClass.MOLESIR, 3, Arrays.asList(" ", "Gain resistance II for 4 seconds.")),
    RESISTANCE_IV("Resistance IV", BattlefieldClassData.BFClass.MOLESIR, 4, Arrays.asList(" ", "Gain resistance II for 5 seconds.")),
    RESISTANCE_V("Resistance V", BattlefieldClassData.BFClass.MOLESIR, 5, Arrays.asList(" ", "Gain resistance II for 7 seconds.")),

    // Oucher
    BLOOD_DRAIN_I("Blood Drain I", BattlefieldClassData.BFClass.OUCHER, 1, Arrays.asList(" ", "Next hit drains 2.5 hearts from the enemy player.")),
    BLOOD_DRAIN_II("Blood Drain II", BattlefieldClassData.BFClass.OUCHER, 2, Arrays.asList(" ", "Next hit drains 3.5 hearts from the enemy player.")),
    BLOOD_DRAIN_III("Blood Drain III", BattlefieldClassData.BFClass.OUCHER, 3, Arrays.asList(" ", "Next hit drains 4 hearts from the enemy player.")),
    BLOOD_DRAIN_IV("Blood Drain IV", BattlefieldClassData.BFClass.OUCHER, 4, Arrays.asList(" ", "Next hit drains 5 hearts from the enemy player.")),
    BLOOD_DRAIN_V("Blood Drain V", BattlefieldClassData.BFClass.OUCHER, 5, Arrays.asList(" ", "Next hit drains 6 hearts from the enemy player.")),

    // Relyt
    ICE_I("Ice I", BattlefieldClassData.BFClass.RELYT, 1, Arrays.asList(" ", "Next hit slows the player for 2 seconds.")),
    ICE_II("Ice II", BattlefieldClassData.BFClass.RELYT, 2, Arrays.asList(" ", "Next hit slows the player for 3 seconds.")),
    ICE_III("Ice III", BattlefieldClassData.BFClass.RELYT, 3, Arrays.asList(" ", "Next hit slows the player for 4 seconds.")),
    ICE_IV("Ice IV", BattlefieldClassData.BFClass.RELYT, 4, Arrays.asList(" ", "Next hit slows the player for 5 seconds.")),
    ICE_V("Ice V", BattlefieldClassData.BFClass.RELYT, 5, Arrays.asList(" ", "Next hit slows the player for 7 seconds."));

    private String name;
    private BattlefieldClassData.BFClass bfClass;
    private int level;
    private List<String> description;

    BattlefieldAbility(String name, BattlefieldClassData.BFClass bfClass, int level, List<String> description) {
        this.name = name;
        this.bfClass = bfClass;
        this.level = level;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public BattlefieldClassData.BFClass getBfClass() {
        return bfClass;
    }

    public int getLevel() {
        return level;
    }

    public List<String> getDescription() {
        return description;
    }
}
