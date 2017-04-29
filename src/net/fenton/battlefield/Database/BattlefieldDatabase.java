package net.fenton.battlefield.Database;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.fenton.battlefield.Class.BattlefieldClassData;
import net.fenton.battlefield.Core;
import net.fenton.battlefield.Player.*;
import net.fenton.battlefield.Player.ClassInfo.*;
import org.bson.Document;
import org.bukkit.entity.Player;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

/**
 * Created by Encast (2017-02-03 3:30 PM)
 */
public class BattlefieldDatabase {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> players;

    public void connect() {
        client = net.fenton.core.Core.getInstance().getMainMongoInstance().getClient();

        // default = battlefield
        database = client.getDatabase("fenton");
        // default = players
        players = database.getCollection("bfplayers");
    }

    public void disconnect() {
        client.close();
    }

    private void newPlayer(Player p) {
        Document data = players.find(eq("uuid", p.getUniqueId().toString())).first();
        if(data == null) {
            BFPlayer dummyPlayer = BFDefaultPlayer.getInstance().getDummyPlayer();
            Document player = new Document("uuid", p.getUniqueId().toString());
            player.put("name", p.getName());
            player.put("kills", 0);
            player.put("deaths", 0);
            player.put("coins", 0.0);
            player.put("energy", 0);
            player.put("current_class", BattlefieldClassData.BFClass.AGROTIS.getDbName());
            player.put("classes", dummyPlayer.getClassLevel().toMap());
            player.put("fishing_rod", false);
            player.put("arrow_level", 0);
            player.put("kill_effect", KillEffect.SPEED.getDbName());
            player.put("general_stats", dummyPlayer.getStats().toMap());
            players.insertOne(player);
        }

        BFClassLevel level = new BFClassLevel(new AgrotisClass(1, 1), new ArcherClass(1, 1), new AxerierClass(1, 1), new BlastyClass(1, 1),
                new KivosClass(1, 1), new MolesirClass(1, 1), new OucherClass(1, 1), new RelytClass(1, 1), new BlazeClass(0, 1));
        BFPlayer player = new BFPlayer(BattlefieldClassData.BFClass.AGROTIS, 0, 0, 0, level, 0, 0, false, false, false,
                KillEffect.SPEED, new BFPlayerStats(0));
        BFPlayerData.getInstance().addPlayer(p.getUniqueId(), player);
    }

    public void retrievePlayer(Player p) {
        Document data = players.find(eq("uuid", p.getUniqueId().toString())).first();
        if(data != null) {
            Document classData = data.get("classes", Document.class);

            // Classes
            AgrotisClass agrotisClass = new AgrotisClass(
                    classData.get(BattlefieldClassData.BFClass.AGROTIS.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.AGROTIS.getDbName().toLowerCase(), Document.class).getInteger("ability_level"));
            ArcherClass archerClass = new ArcherClass(
                    classData.get(BattlefieldClassData.BFClass.ARCHER.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.ARCHER.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );
            AxerierClass axerierClass = new AxerierClass(
                    classData.get(BattlefieldClassData.BFClass.AXERIER.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.AXERIER.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );
            BlastyClass blastyClass = new BlastyClass(
                    classData.get(BattlefieldClassData.BFClass.BLASTY.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.BLASTY.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );
            BlazeClass blazeClass = new BlazeClass(
                    classData.get(BattlefieldClassData.BFClass.BLAZE.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.BLAZE.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );
            KivosClass kivosClass = new KivosClass(
                    classData.get(BattlefieldClassData.BFClass.KIVOS.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.KIVOS.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );
            MolesirClass molesirClass = new MolesirClass(
                    classData.get(BattlefieldClassData.BFClass.MOLESIR.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.MOLESIR.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );
            OucherClass oucherClass = new OucherClass(
                    classData.get(BattlefieldClassData.BFClass.OUCHER.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.OUCHER.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );
            RelytClass relytClass = new RelytClass(
                    classData.get(BattlefieldClassData.BFClass.RELYT.getDbName().toLowerCase(), Document.class).getInteger("class_level"),
                    classData.get(BattlefieldClassData.BFClass.RELYT.getDbName().toLowerCase(), Document.class).getInteger("ability_level")
            );

            BFClassLevel level = new BFClassLevel(agrotisClass, archerClass, axerierClass,
                    blastyClass, kivosClass, molesirClass, oucherClass, relytClass, blazeClass);

            Document generalStats = data.get("general_stats", Document.class);

            // BFPlayer
            BFPlayer playerData = new BFPlayer(BattlefieldClassData.BFClass.valueOf(data.getString("current_class")),
                    data.getInteger("kills"), data.getInteger("deaths"), data.getDouble("coins"), level,
                    data.getInteger("energy"), data.getInteger("arrow_level"), data.getBoolean("fishing_rod"), false,
                    false, KillEffect.valueOf(data.getString("kill_effect")),
                    new BFPlayerStats(generalStats.getDouble("total_coins")));
            BFPlayerData.getInstance().addPlayer(p.getUniqueId(), playerData);

            players.updateOne(eq("uuid", p.getUniqueId().toString()), set("name", p.getName()));
        } else {
            newPlayer(p);
        }
    }

    /*
            player.put("name", p.getName());
            player.put("kills", 0);
            player.put("deaths", 0);
            player.put("coins", 0.0);
            player.put("energy", 0);
            player.put("current_class", BattlefieldClassData.BFClass.AGROTIS.getDbName());
            player.put("classes", dummyPlayer.getClassLevel().toMap());
            player.put("fishing_rod", false);
            player.put("arrow_level", 0);
            player.put("kill_effect", KillEffect.SPEED.getDbName());
            player.put("general_stats", dummyPlayer.getStats().toMap());
     */
    public void savePlayer(Player p, boolean removeUser, boolean setOPMode) {
        BFPlayer bfp = BFPlayerData.getInstance().getPlayers().get(p.getUniqueId());
        if(!bfp.isOpMode()) {
            players.updateOne(eq("uuid", p.getUniqueId().toString()), combine(
                    set("kills", bfp.getKills()),
                    set("deaths", bfp.getDeaths()),
                    set("coins", bfp.getCoins()),
                    set("energy", bfp.getEnergy()),
                    set("current_class", bfp.getCurrentClass().getDbName()),
                    set("classes", new Document(bfp.getClassLevel().toMap())),
                    set("fishing_rod", bfp.hasFishingRod()),
                    set("arrow_level", bfp.getArrowLevel()),
                    set("kill_effect", bfp.getKillEffect().getDbName()),
                    set("general_stats", new Document(bfp.getStats().toMap()))
            ));
        }
        if(removeUser) {
            BFPlayerData.getInstance().remove(p.getUniqueId());
            return;
        }
        if(setOPMode) {
            bfp.setOpMode(true);
            bfp.getClassLevel().setAllClassLevels(5);
            p.sendMessage("§aYou are now in OP Mode.");
            p.sendMessage("§aOP Mode grants you all max classes, but you do not gain stats.");
        }
    }
}
