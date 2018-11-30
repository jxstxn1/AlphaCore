package de.ops.alphacore.commands;

import de.ops.alphacore.main.Main;
//import org.apache.commons.lang3.EnumUtils;
import de.ops.alphacore.things.Rank;
import de.ops.alphacore.things.RankSystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.apache.commons.lang.enums.EnumUtils.*;
import static org.bukkit.Bukkit.getOfflinePlayer;
import static org.bukkit.Bukkit.isHardcore;

public class RankCommand implements CommandExecutor {
// rank <player> <rank>

//alphacore.setrank.


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.isOp()) {
                if (args.length == 2) {

                    if (args[1].equalsIgnoreCase("User")) {
                        if (player.hasPermission("alphacore.setrank.user")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.User);
                           RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");

                        }

                    } else if (args[1].equalsIgnoreCase("Premium")) {
                        if (player.hasPermission("alphacore.setrank.premium")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.Premium);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }


                    } else if (args[1].equalsIgnoreCase("YouTuber")) {
                        if (player.hasPermission("alphacore.setrank.youtuber")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.YouTuber);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }
                    } else if (args[1].equalsIgnoreCase("Archi")) {
                        if (player.hasPermission("alphacore.setrank.Archi")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.Archi);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }
                    } else if (args[1].equalsIgnoreCase("Supp")) {
                        if (player.hasPermission("alphacore.setrank.Supp")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.SUPPORTER);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }
                    } else if (args[1].equalsIgnoreCase("Mod")) {
                        if (player.hasPermission("alphacore.setrank.Mod")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.MOD);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }
                    } else if (args[1].equalsIgnoreCase("Dev")) {
                        if (player.hasPermission("alphacore.setrank.Dev")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.DEV);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }
                    } else if (args[1].equalsIgnoreCase("Manager")) {
                        if (player.hasPermission("alphacore.setrank.Manager")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.MANAGER);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }
                    } else if (args[1].equalsIgnoreCase("Admin")) {
                        if (player.hasPermission("alphacore.setrank.Admin")) {
                            RankSystem.setRank1(Bukkit.getOfflinePlayer(args[0]).getUniqueId(), Rank.ADMIN);
                            RankSystem.setPrefix();
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aRang geändert.");
                        }
                    } else {
                        player.sendMessage(Main.getPlugin().getPrefix() + "§cDiesen Rang gibt es nicht.");
                    }


                }

            }

        }
        return false;
    }


}
