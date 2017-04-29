package net.fenton.battlefield.Player.ClassInfo;

/**
 * Created by Encast (2017-02-02 11:25 AM)
 */
public class BlazeClass {

    private int level;
    private int ability_level;

    public BlazeClass(int level, int ability_level) {
        this.level = level;
        this.ability_level = ability_level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAbilityLevel() {
        return ability_level;
    }

    public void setAbilityLevel(int ability_level) {
        this.ability_level = ability_level;
    }
}