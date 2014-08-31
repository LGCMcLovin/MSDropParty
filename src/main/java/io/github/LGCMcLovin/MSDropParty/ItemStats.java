package io.github.LGCMcLovin.MSDropParty;

/**
 * Created by Allen on 8/31/2014.
 */
public class ItemStats {
    private int min;
    private int max;
    private double freq;
    public ItemStats(String s, double d){
        min = Integer.getInteger(s.split("-")[0]);
        max = Integer.getInteger(s.split("-")[1]);
        freq = d;
    }
}
