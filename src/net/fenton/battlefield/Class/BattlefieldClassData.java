package net.fenton.battlefield.Class;

import net.fenton.battlefield.Class.Agrotis.*;
import net.fenton.battlefield.Class.Archer.*;
import net.fenton.battlefield.Class.Axerier.*;
import net.fenton.battlefield.Class.Blasty.*;
import net.fenton.battlefield.Class.Blaze.*;
import net.fenton.battlefield.Class.Kivos.*;
import net.fenton.battlefield.Class.Molesir.*;
import net.fenton.battlefield.Class.Oucher.*;
import net.fenton.battlefield.Class.Relyt.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 2:59 PM
 */
public class BattlefieldClassData {

    public enum BFClass {
        AGROTIS("AGROTIS", "Agrotis", "§a", "§aAgrotis", "[AGRO]"),
        ARCHER("ARCHER", "Archer", "§a", "§aArcher", "[ARCH]"),
        AXERIER("AXERIER", "Axerier", "§a", "§aAxerier", "[AXER]"),
        BLASTY("BLASTY", "Blasty", "§a", "§aBlasty", "[BLAS]"),
        KIVOS("KIVOS", "Kivos", "§a", "§aKivos", "[KIVO]"),
        MOLESIR("MOLESIR", "Molesir", "§a", "§aMolesir", "[MOLE]"),
        OUCHER("OUCHER", "Oucher", "§a", "§aOucher", "[OUCH]"),
        RELYT("RELYT", "Relyt", "§a", "§aRelyt", "[RELY]"),
        BLAZE("BLAZE", "Blaze", "§6", "§6Blaze", "[BLAZ]");

        private String dbName;
        private String name;
        private String colour;
        private String colouredName;
        private String prefix;

        BFClass(String dbName, String name, String colour, String colouredName, String prefix) {
            this.dbName = dbName;
            this.name = name;
            this.colour = colour;
            this.colouredName = colouredName;
            this.prefix = prefix;
        }

        public String getDbName() {
            return dbName;
        }

        public String getName() {
            return name;
        }

        public String getColour() {
            return colour;
        }

        public String getColouredName() {
            return colouredName;
        }

        public String getPrefix() {
            return prefix;
        }
    }

    private static BattlefieldClassData instance;
    public static BattlefieldClassData getInstance() {
        return instance;
    }
    private Map<BFClass, Boolean> classStatus;

    private Map<BFClass, ClassInformation> classes;

    public BattlefieldClassData() {
        instance = this;
        classes = new HashMap<>();
        setupClasses();
    }

    public void setupClasses() {
        classes.put(BFClass.AGROTIS, new ClassInformation(true, false, new AgrotisI(), new AgrotisII(), new AgrotisIII(), new AgrotisIV(), new AgrotisV()));
        classes.put(BFClass.ARCHER, new ClassInformation(true, false, new ArcherI(), new ArcherII(), new ArcherIII(), new ArcherIV(), new ArcherV()));
        classes.put(BFClass.AXERIER, new ClassInformation(true, false, new AxerierI(), new AxerierII(), new AxerierIII(), new AxerierIV(), new AxerierV()));
        classes.put(BFClass.BLASTY, new ClassInformation(true, false, new BlastyI(), new BlastyII(), new BlastyIII(), new BlastyIV(), new BlastyV()));
        classes.put(BFClass.KIVOS, new ClassInformation(true, false, new KivosI(), new KivosII(), new KivosIII(), new KivosIV(), new KivosV()));
        classes.put(BFClass.MOLESIR, new ClassInformation(true, false, new MolesirI(), new MolesirII(), new MolesirIII(), new MolesirIV(), new MolesirV()));
        classes.put(BFClass.OUCHER, new ClassInformation(true, false, new OucherI(), new OucherII(), new OucherIII(), new OucherIV(), new OucherV()));
        classes.put(BFClass.RELYT, new ClassInformation(true, false, new RelytI(), new RelytII(), new RelytIII(), new RelytIV(), new RelytV()));
        classes.put(BFClass.BLAZE, new ClassInformation(true, true, new BlazeI(), new BlazeII(), new BlazeIII(), new BlazeIV(), new BlazeV()));
    }

    public Map<BFClass, ClassInformation> getClasses() {
        return classes;
    }

    public ClassInformation getClassByName(BFClass bfClass) {
        return classes.get(bfClass);
    }
}
