package net.fenton.battlefield.Player;

import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Player.ClassInfo.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 4:02 PM
 */
public class BFClassLevel {

    private AgrotisClass agrotis;
    private ArcherClass archer;
    private AxerierClass axerier;
    private BlastyClass blasty;
    private KivosClass kivos;
    private MolesirClass molesir;
    private OucherClass oucher;
    private RelytClass relyt;
    private BlazeClass blaze;

    public BFClassLevel(AgrotisClass agrotis, ArcherClass archer, AxerierClass axerier,
                        BlastyClass blasty, KivosClass kivos, MolesirClass molesir,
                        OucherClass oucher, RelytClass relyt, BlazeClass blaze) {
        this.agrotis = agrotis;
        this.archer = archer;
        this.axerier = axerier;
        this.blasty = blasty;
        this.kivos = kivos;
        this.molesir = molesir;
        this.oucher = oucher;
        this.relyt = relyt;
        this.blaze = blaze;
    }

    public AgrotisClass getAgrotis() {
        return agrotis;
    }

    public ArcherClass getArcher() {
        return archer;
    }

    public AxerierClass getAxerier() {
        return axerier;
    }

    public BlastyClass getBlasty() {
        return blasty;
    }

    public KivosClass getKivos() {
        return kivos;
    }

    public MolesirClass getMolesir() {
        return molesir;
    }

    public OucherClass getOucher() {
        return oucher;
    }

    public RelytClass getRelyt() {
        return relyt;
    }

    public BlazeClass getBlaze() {
        return blaze;
    }

    public int getLevelByName(BattlefieldClassData.BFClass bfClass) {
        switch(bfClass) {
            case AGROTIS:
                return getAgrotis().getLevel();
            case ARCHER:
                return getArcher().getLevel();
            case AXERIER:
                return getAxerier().getLevel();
            case BLASTY:
                return getBlasty().getLevel();
            case KIVOS:
                return getKivos().getLevel();
            case MOLESIR:
                return getMolesir().getLevel();
            case OUCHER:
                return getOucher().getLevel();
            case RELYT:
                return getRelyt().getLevel();
            case BLAZE:
                return getBlaze().getLevel();
            default:
                return getRelyt().getLevel();
        }
    }

    public void setClassLevel(BattlefieldClassData.BFClass bfClass, int level) {
        switch(bfClass) {
            case AGROTIS:
                getAgrotis().setLevel(level);
                break;
            case ARCHER:
                getArcher().setLevel(level);
                break;
            case AXERIER:
                getAxerier().setLevel(level);
                break;
            case BLASTY:
                getBlasty().setLevel(level);
                break;
            case KIVOS:
                getKivos().setLevel(level);
                break;
            case MOLESIR:
                getMolesir().setLevel(level);
                break;
            case OUCHER:
                getOucher().setLevel(level);
                break;
            case RELYT:
                getRelyt().setLevel(level);
                break;
            case BLAZE:
                getBlaze().setLevel(level);
                break;
            default:
                break;
        }
    }

    public int getAbilityLevelByName(BattlefieldClassData.BFClass bfClass) {
        switch(bfClass) {
            case AGROTIS:
                return getAgrotis().getAbilityLevel();
            case ARCHER:
                return getArcher().getAbilityLevel();
            case AXERIER:
                return getAxerier().getAbilityLevel();
            case BLASTY:
                return getBlasty().getAbilityLevel();
            case KIVOS:
                return getKivos().getAbilityLevel();
            case MOLESIR:
                return getMolesir().getAbilityLevel();
            case OUCHER:
                return getOucher().getAbilityLevel();
            case RELYT:
                return getRelyt().getAbilityLevel();
            case BLAZE:
                return getBlaze().getAbilityLevel();
            default:
                return getRelyt().getAbilityLevel();
        }
    }

    public void setAbilityLevelByName(BattlefieldClassData.BFClass bfClass, int level) {
        switch(bfClass) {
            case AGROTIS:
                getAgrotis().setAbilityLevel(level);
                break;
            case ARCHER:
                getArcher().setAbilityLevel(level);
                break;
            case AXERIER:
                getAxerier().setAbilityLevel(level);
                break;
            case BLASTY:
                getBlasty().setAbilityLevel(level);
                break;
            case KIVOS:
                getKivos().setAbilityLevel(level);
                break;
            case MOLESIR:
                getMolesir().setAbilityLevel(level);
                break;
            case OUCHER:
                getOucher().setAbilityLevel(level);
                break;
            case RELYT:
                getRelyt().setAbilityLevel(level);
                break;
            case BLAZE:
                getBlaze().setAbilityLevel(level);
                break;
            default:
                break;
        }
    }

    public void setAllClassLevels(int level) {
        getAgrotis().setLevel(level);
        getArcher().setLevel(level);
        getAxerier().setLevel(level);
        getBlasty().setLevel(level);
        getKivos().setLevel(level);
        getMolesir().setLevel(level);
        getOucher().setLevel(level);
        getRelyt().setLevel(level);
        getBlaze().setLevel(level);
    }

    public Map<String, Object> toMap() {
        Map<String, Object> data = new HashMap<>();
        for(BattlefieldClassData.BFClass bfClass : BattlefieldClassData.BFClass.values()) {
            Map<String, Object> classData = new HashMap<>();
            classData.put("class_level", getLevelByName(bfClass));
            classData.put("ability_level", getAbilityLevelByName(bfClass));
            data.put(bfClass.getDbName().toLowerCase(), classData);
        }
        return data;
    }
}
