package io.github.LGCMcLovin.MSDropParty;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.scheduler.*;

import java.util.*;

/**
 * Created by Ben Byers on 8/31/2014.
 */
public class Party extends BukkitRunnable {
    private Integer FINE_CURVE = 10;
    public Party(Long time){
        new Timers(this).runTaskLater(MSDropParty.getPlugin(),time);
    }
    Random random = new Random();
    @Override
    public void run() {
        for (Player player:Bukkit.getOnlinePlayers()) {     // We get all players online and we run this for each of them
            World world = player.getWorld();                // Get player world
            ArrayList<ItemStats> drops = new ArrayList<>(); // This will contain all the drops that have qualified
            Integer randFrequency = random.nextInt(100);    // This generates a number with a cap of 100 and is used for percentage if time
            for (ItemStats item : Config.getFreqList()) {   // For each item on the list
                if (randFrequency < item.getFreq()) {       // This checks the items set frequency to the current frequency, then adds it to the qualification list
                    if (randFrequency <= FINE_CURVE){       // This adds a curve to the generation of the drops list, for items under the curve.
                        if(item.getFreq() <= FINE_CURVE)    // the reason for this being if something is 1% and we get 1%, then everything above
                            drops.add(item);                // would be added making it nearly impossible to get. This just balances it a little more
                    }else{                                  // We will only add the items the are below 10% but greater than the cutoff
                        drops.add(item);                    // Adding everything to list if above 10%, and meets the cutoff
                    }
                }
            }
            if(!drops.isEmpty()){
                ItemStats selected =  drops.get(random.nextInt(drops.size())); //Now we take the size of the list of qualifying drops and randomly pick one
                ItemStack dropped = selected.getItemStack(); // Get the picked itemstack
                Location drop = selected.random(player.getLocation()); // Get the location to be dropped with
                world.dropItemNaturally(drop,dropped);//This drops the item in a natural way
            }
        }
        /*
        All of the processing happens here to spawn items.
         */
    }
}
