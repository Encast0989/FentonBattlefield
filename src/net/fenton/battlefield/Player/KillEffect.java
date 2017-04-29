package net.fenton.battlefield.player;

/**
 * Created by Encast (2017-02-02 3:48 PM)
 */
public enum KillEffect {

    SPEED("SPEED", "§bSpeed"),
    RESISTANCE_STRENGTH("RESISTANCE_STRENGTH", "§4Resistance + Strength");

    //TODO Add int[] for the duration.

    private String dbName;
    private String name;

    KillEffect(String dbName, String name) {
        this.dbName = dbName;
        this.name = name;
    }

    public String getDbName() {
        return dbName;
    }

    public String getName() {
        return name;
    }
}
