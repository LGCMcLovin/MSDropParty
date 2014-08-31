package io.github.LGCMcLovin.MSDropParty;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
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
    private static ArrayList<ItemStats> itemList;
    public static void enable(){
        file.options().copyDefaults(true);
        MSDP.saveConfig();
        loadItems();
    }
// Calls for Drop party item list
    public static void loadItems() {
        if(itemList.isEmpty())
            itemList = new ArrayList<ItemStats>();
        for (String entry : items) {
            String[] data = entry.split(" ");
            int id = Integer.getInteger(data[0].split(":")[0]);
            Short meta = Short.parseShort(data[0].split(":")[1]);
            ItemStack itemStack = new ItemStack(id, 1, meta);
            Double freq = Double.parseDouble(data[2]);
            ItemStats itemStats = new ItemStats(id,meta,data[1],freq);
            if (!itemList.contains(itemStats))
                itemList.add(itemStats);
        }
    }

    public static ArrayList<ItemStats> getItemList() {
        return itemList;
    }

    public static boolean addItem(ItemStats data) {
        if(itemList.isEmpty())
            itemList = new ArrayList<>();
        if (itemList.contains(data)){
            return false;
        }else{
            itemList.add(data);
            items.add(data.toString());
            MSDP.saveConfig();
            return true;
        }
    }
    public static boolean removeItem(int id){
        if (!itemList.isEmpty()){
            if (itemList.get(id)!=null){
                itemList.remove(id);
                items.remove(id);
                MSDP.saveConfig();
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

}
