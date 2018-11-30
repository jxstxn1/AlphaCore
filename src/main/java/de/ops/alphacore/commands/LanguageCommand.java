package de.ops.alphacore.commands;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class LanguageCommand implements CommandExecutor {
    ConfigManager cm = new ConfigManager();


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("alphacore.setlanguage")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("ger") || args[0].equalsIgnoreCase("eng") || args[0].equalsIgnoreCase("fr") || args[0].equalsIgnoreCase("hu") || args[0].equalsIgnoreCase("nl") || args[0].equalsIgnoreCase("ru")|| args[0].equalsIgnoreCase("tu")) {
                       cm.setPlayerLanguage(player.getUniqueId(), args[0]);


                    }else{
                        player.sendMessage(Main.getPlugin().getPrefix() + cm.getUsage() + ": §6/language <ger|eng|fr|hu|nl|ru|tu>");
                    }
                } else if (args.length == 0) {
                    player.sendMessage(Main.getPlugin().getPrefix() + cm.getYourLang() + "§7: §6" + cm.getPlayerLanguage(player.getUniqueId()));
                }else{
                    player.sendMessage(Main.getPlugin().getPrefix() + cm.getUsage());
                }
            }else{
                player.sendMessage(cm.getNoPerm());
            }
        } else {
            System.out.println(Main.getPlugin().getconsolePrefix() + cm.getNotInConsole());
        }

        return false;
    }
}