package io.github.LGCMcLovin.MSDropParty;

import org.bukkit.scheduler.*;

/**
 * Created by Ben Byers on 8/31/2014.
 */
public class Timers extends BukkitRunnable{
    int TIME_TO_WAIT = 10; //The time to wait between drops.
    Party party;
    public Timers(Party p){
        party = p;
        party.runTaskTimer(MSDropParty.getPlugin(),0,TIME_TO_WAIT);
    }
    @Override
    public void run() {
        party.cancel();
    }
}
