package io.github.LGCMcLovin.MSDropParty;

import org.apache.commons.collections.ArrayStack;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LGC_McLovin on 8/30/2014.
 */
public class Config {
    static Plugin MSDP = MSDropParty.getPlugin();
    static FileConfiguration file = MSDP.getConfig();
    static List<String> items = file.getStringList("Items");
    static String frequency = file.getString("AutoDPFrequency");
    static List<String> blacklist = file.getStringList("Blacklist");
    public static void enable(){
        file.options().copyDefaults(true);
        MSDP.saveConfig();
    }
// Calls for Drop party item list
    public static HashMap<ItemStack, ItemStats> getItems(){
        HashMap<ItemStack, ItemStats> itemList = new HashMap<ItemStack, ItemStats>();
        for(String entry:items){
            String[] data = entry.split(" ");
            ItemStack itemStack = new ItemStack(Integer.getInteger(data[0]));
            Double freq = Double.parseDouble(data[2]);
            ItemStats itemStats = new ItemStats(data[1], freq);
            if(!itemList.containsKey(itemStack))
            itemList.put(itemStack, itemStats);
        
        }

        return itemList;

    }

}
