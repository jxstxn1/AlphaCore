package de.ops.alphacore.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.Config;


public class GMCommands implements CommandExecutor {
    public static Config cfg;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (player.hasPermission("")) {
                    int action = 0;
                    try {
                        action = Integer.parseInt(args[0]);
                    } catch (NumberFormatException e) {
                        player.sendMessage(Main.getPlugin().getPrefix() + "§cDiesen Gamemmode gibt es nicht.");
                    }

                    switch (action) {
                        case 0:
                            player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Survival-Modus");
                            break;
                        case 1:
                            player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Kreativ-Modus");
                            break;
                        case 2:
                            player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Adventure-Modus");
                            break;
                        case 3:
                            player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Spectator-Modus");
                            break;

                        default:
                            player.sendMessage(Main.getPlugin().getPrefix() + "§cBenutzung: §6/gamemode <0/1/2/3> [Spieler]");
                            break;
                    }
                } else {
                    player.sendMessage(Main.getPlugin().getNoperm());
                }
            } else if (args.length == 2) {
                Player target = Bukkit.getPlayer(args[1]);
                if (player.hasPermission("")) {
                    if (target != null) {
                        int action = 0;
                        try {
                            action = Integer.parseInt(args[0]);
                        } catch (NumberFormatException e) {
                            player.sendMessage(Main.getPlugin().getPrefix() + "§cDiesen Gamemmode gibt es nicht.");
                        }

                        switch (action) {
                            case 0:
                                target.setGameMode(GameMode.SURVIVAL);
                                player.sendMessage(Main.getPlugin().getPrefix() + "§aDu hast§6" + target.getName()
                                        + "§ain dem §6Survival-Modus gesetzt");
                                target.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Survival-Modus");
                                break;
                            case 1:
                                target.setGameMode(GameMode.CREATIVE);
                                player.sendMessage(Main.getPlugin().getPrefix() + "§aDu hast§6 " + target.getName()
                                        + " §ain dem §6Kreativ-Modus §agesetzt");
                                target.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Creative-Modus");

                                break;
                            case 2:
                                target.setGameMode(GameMode.ADVENTURE);
                                player.sendMessage(Main.getPlugin().getPrefix() + "§aDu hast§6 " + target.getName()
                                        + " §ain dem §6Adventure-Modus §agesetzt");
                                target.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Adventure-Modus");
                                break;
                            case 3:
                                target.setGameMode(GameMode.SPECTATOR);
                                player.sendMessage(Main.getPlugin().getPrefix() + "§aDu hast§6 " + target.getName()
                                        + " §ain dem §6Spectator-Modus §agesetzt");
                                target.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist nun im §6Spectator-Modus");
                                break;

                            default:

                                player.sendMessage(
                                        Main.getPlugin().getPrefix() + "§cBenutzung: §6/gamemode <0/1/2/3> [Spieler]");
                                break;
                        }

                    }
                } else {
                    player.sendMessage(Main.getPlugin().getNoperm());
                }
            } else {
                player.sendMessage(Main.getPlugin().getPrefix() + "§cBenutzung: §6/gamemode <0/1/2/3> [Spieler]");
            }
        } else {
            System.out.println("Du kannst diesen Befehl nicht in der Konsole verwenden.");

        }

        return false;
    }
}
