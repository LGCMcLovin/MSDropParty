package io.github.LGCMcLovin.MSDropParty;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.util.Vector;

import java.util.*;

/**
 * Created by Allen on 8/31/2014.
 */
public class ItemStats {
    private int min;
    private int max;
    private double freq;
    private int id;
    private short meta;
    private ItemStack itemStack;
    public ItemStats(int idi, short metai, String s, double d){
        id = idi;
        meta = metai;
        min = Integer.getInteger(s.split("-")[0]);
        max = Integer.getInteger(s.split("-")[1]);
        itemStack = new ItemStack(id, 1, meta);
        freq = d;
    }
    public Location random(Location loc){
        Random random = new Random();
        int result = random.nextInt((max - min) + 1) + min;
        return loc.add(new Vector(result,result,result));
    }

    public double getFreq() {
        return freq;
    }

    public int getMax() {
        return max;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getMin() {
        return min;
    }

    public int getId() {
        return id;
    }

    public short getMeta() {
        return meta;
    }

    public void setFreq(double freq) {
        this.freq = freq;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMeta(short meta) {
        this.meta = meta;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public String toString() {
        String stringified;
        stringified = id+":"+meta+" "+min+"-"+max+" "+freq;
        return stringified;
    }
}
