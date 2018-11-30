package de.ops.alphacore.commands;

import de.ops.alphacore.listener.PingListener;
import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.Config;
import de.ops.alphacore.things.ConfigManager;
import de.ops.alphacore.things.Rank;
import de.ops.alphacore.things.RankSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AlphaCoreRlCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        ConfigManager cm = new ConfigManager();
        Config config = new Config();
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("alphacore.rl")) {
               player.sendMessage(Main.getPlugin().getPrefix() + "§cReloading...");
                config.reload();
                RankSystem.setPrefix();
                player.sendMessage(Main.getPlugin().getPrefix() + "aReload complete");
            }
        }else{
            System.out.println(Main.getPlugin().getconsolePrefix() + "Reloading");
            config.reload();
            RankSystem.setPrefix();
            System.out.println("Reload complete");
        }
        return false;
    }




}


