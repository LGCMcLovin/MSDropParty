package io.github.LGCMcLovin.MSDropParty;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

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


}
