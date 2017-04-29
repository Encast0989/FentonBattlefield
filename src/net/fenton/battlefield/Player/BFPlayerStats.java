package net.fenton.battlefield.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Encast (2017-01-16 5:36 PM)
 */
public class BFPlayerStats {

    private double total_coins;

    public BFPlayerStats(double total_coins) {
        this.total_coins = total_coins;
    }

    public double getTotalCoins() {
        return total_coins;
    }

    public void addTotalCoins(double total_coins) {
        this.total_coins += total_coins;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> data = new HashMap<>();
        data.put("total_coins", total_coins);
        return data;
    }
}
