package io.github.LGCMcLovin.MSDropParty;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.*;

/**
 * Created by LGC_McLovin on 8/30/2014.
 */
public class Config {
    static Plugin MSDP = MSDropParty.getPlugin();
    static FileConfiguration file = MSDP.getConfig();
    static List<String> items = file.getStringList("Items");
    static String frequency = file.getString("AutoDPFrequency");
    static List<String> blacklist = file.getStringList("Blacklist");
    private static HashMap<ItemStack,ItemStats> itemList;
    private static ArrayList<ItemStats> freqList;
    public static void enable(){
        file.options().copyDefaults(true);
        MSDP.saveConfig();
        loadItems();
        reloadFreqList();
    }
    public static void reloadFreqList(){
        freqList = new ArrayList<>();
        Set<Map.Entry<ItemStack,ItemStats>> data = Config.getItemList().entrySet();
        while(data.iterator().hasNext()){
            ItemStats drop = data.iterator().next().getValue();
            freqList.add(drop);
        }
    }
// Calls for Drop party item list
    public static void loadItems() {
        if(itemList.isEmpty())
            itemList = new HashMap<>();
        for (String entry : items) {
            String[] data = entry.split(" ");
            int id = Integer.getInteger(data[0].split(":")[0]);
            Short meta = Short.parseShort(data[0].split(":")[1]);
            Double freq = Double.parseDouble(data[2]);
            ItemStats itemStats = new ItemStats(id,meta,data[1],freq);
            if (!itemList.containsValue(itemStats))
                itemList.put(itemStats.getItemStack(), itemStats);
        }
        reloadFreqList();
    }

    public static HashMap<ItemStack,ItemStats> getItemList() {
        return itemList;
    }

    public static boolean addItem(ItemStats data) {
        if(itemList.isEmpty())
            itemList = new HashMap<>();
        if (itemList.containsValue(data)){
            return false;
        }else{
            itemList.put(data.getItemStack(), data);
            items.add(data.toString());
            MSDP.saveConfig();
            reloadFreqList();
            return true;
        }
    }
    public static boolean removeItem(ItemStack itemStack){
        if (!itemList.isEmpty()){
            if (itemList.get(itemStack)!= null){
                ItemStats itemStats = itemList.get(itemStack);
                items.remove(itemStack);
                itemList.remove(itemStats.toString());
                MSDP.saveConfig();
                reloadFreqList();
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public static ArrayList<ItemStats> getFreqList() {
        return freqList;
    }
}
