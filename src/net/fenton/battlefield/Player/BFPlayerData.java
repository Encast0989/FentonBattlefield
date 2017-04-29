package net.fenton.battlefield.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Encast (2016-12-26), All Rights Reserved.
 * <p>
 * Claiming this code as one's own is strictly forbidden.
 * <p>
 * Class created at: 4:11 PM
 */
public class BFPlayerData {

    private static BFPlayerData instance;
    public static BFPlayerData getInstance() {
        return instance;
    }

    private Map<UUID, BFPlayer> players;

    public BFPlayerData() {
        instance = this;
        players = new HashMap<>();
    }

    public Map<UUID, BFPlayer> getPlayers() {
        return players;
    }

    public void addPlayer(UUID uuid, BFPlayer data) {
        players.put(uuid, data);
    }

    public void remove(UUID uuid) {
        players.remove(uuid);
    }
}
