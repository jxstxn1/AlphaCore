package de.ops.alphacore.commands;

import de.ops.alphacore.things.ConfigManager;
import de.ops.alphacore.things.RankSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.Config;

import static de.ops.alphacore.main.Main.getPlugin;


public class HealCommand implements CommandExecutor {

    ConfigManager cm = new ConfigManager();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (args.length == 0) {
                if (p.hasPermission("heal.self") || p.hasPermission("heal.*")) {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.sendMessage(getPlugin().getPrefix() + cm.getHealed());
                } else
                    p.sendMessage(cm.getNoPerm());

            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    if (p.hasPermission("heal.others") || p.hasPermission("heal.*")) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage(getPlugin().getPrefix() + cm.getHealedOther());
                        p.sendMessage(Main.getPlugin().getPrefix() + cm.getHealedByOther());

                    } else
                        p.sendMessage(cm.getNoPerm());

                } else
                    p.sendMessage(getPlugin().getPrefix() + cm.getNotOnline());
            } else
                p.sendMessage(getPlugin().getPrefix() + cm.getUsage());

        } else
            System.out.println(getPlugin().getconsolePrefix() + cm.getNotInConsole());

        return false;

    }

}
