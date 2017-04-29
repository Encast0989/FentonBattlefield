package net.fenton.battlefield.Class;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 3:01 PM
 */
public class ClassInformation {

    private boolean enabled;
    private boolean ultimate;
    private BattlefieldClass[] classes;

    public ClassInformation(boolean enabled, boolean ultimate, BattlefieldClass... classes) {
        this.enabled = enabled;
        this.ultimate = ultimate;
        this.classes = classes;
    }

    public BattlefieldClass getByLevel(int level) {
        for(BattlefieldClass c : classes) {
            if(c.getLevel() == level) {
                return c;
            }
        }
        return classes[0];
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isUltimate() {
        return ultimate;
    }

    public BattlefieldClass[] getClasses() {
        return classes;
    }
}
