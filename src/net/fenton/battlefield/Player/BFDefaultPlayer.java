package net.fenton.battlefield.player;

import net.fenton.battlefield.bfclass.BattlefieldClassData;
import net.fenton.battlefield.player.ClassInfo.*;

/**
 * Created by Encast (2017-02-03 3:40 PM)
 */
public class BFDefaultPlayer {

    private static BFDefaultPlayer instance;
    public static BFDefaultPlayer getInstance() {
        return instance;
    }

    private BFPlayer bfp;

    public BFDefaultPlayer() {
        instance = this;

        BFClassLevel level = new BFClassLevel(new AgrotisClass(1, 1), new ArcherClass(1, 1), new AxerierClass(1, 1), new BlastyClass(1, 1),
                new KivosClass(1, 1), new MolesirClass(1, 1), new OucherClass(1, 1), new RelytClass(1, 1), new BlazeClass(0, 1));
        this.bfp = new BFPlayer(BattlefieldClassData.BFClass.AGROTIS, 100, 0, 0,
                level, 0, 0, false, false, false,
                KillEffect.SPEED, new BFPlayerStats(0));
    }

    public BFPlayer getDummyPlayer() {
        return this.bfp;
    }
}
