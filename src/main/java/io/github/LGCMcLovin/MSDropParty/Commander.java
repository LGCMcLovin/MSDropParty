package io.github.LGCMcLovin.MSDropParty;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

/**
 * Created by Allen on 8/23/2014.
 */
public class Commander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        switch(args[0]){
            case "add":
                ItemStats itemStats = new ItemStats(Integer.getInteger(args[1]),Short.parseShort(args[2]),args[3],Double.parseDouble(args[4]));
                Config.addItem(itemStats);
                //add function to add item in hand to items list;
                return true;
            case "rem":
                if(!args[1].isEmpty()){ //If args 1 exists do this
                    Config.removeItem(new ItemStack(Integer.getInteger(args[1]),0,Short.parseShort(args[2])));
                }else{
                    Config.removeItem(((Player)commandSender).getPlayer().getItemInHand());
                }
                //add function to remove item in hand from items list;
                return true;
            case "start":
                new Party(Long.getLong(args[1]));
                //add function to start Drop party;
                return true;
            case "list":
                commandSender.sendMessage(Config.frequency);
                return true;
            default:
                //return error message here
                return false;


        }

    }
}