package io.github.LGCMcLovin.MSDropParty;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 * Created by Allen on 8/23/2014.
 */
public class Commander implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        switch(args[0]){
            case "add":
                //add function to add item in hand to items list;
                break;
            case "rem":
                //add function to remove item in hand from items list;
                break;
            case "start":
                //add function to start Drop party;
                break;

        }  {
            return false;
        }
    }}