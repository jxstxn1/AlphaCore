package de.ops.alphacore.commands;


import java.util.Calendar;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



import de.ops.alphacore.main.Main;
import net.md_5.bungee.api.ChatColor;

public class BannCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 2) {
                Player target = Bukkit.getPlayer(args[0]);
                int action = 0;
                try {
                    action = Integer.parseInt(args[1]);
                }catch(NumberFormatException e) {
                    player.sendMessage(Main.getPlugin().getPrefix() + "§cDer Banntyp muss eine Zahl sein.");

                }

                switch (action) {
                    case 1: //PermaBann
                        if(player.hasPermission("alphacore.ban.perm || alphacore.ban.*")) {
                            target.kickPlayer(ChatColor.RED + "Du wurdest \ngebannt.");
                            Calendar cal = Calendar.getInstance();
                            cal.set(2018, 12, 11 );

                            java.util.Date date = cal.getTime();

                            Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(target.getName(),"§cDu wurdest wegen\n §4Wiederholtem Spam§c \nvon " + Main.getPlugin().getServerName() + "\n§cgebannt",date,null);

                            player.sendMessage(Main.getPlugin().getPrefix() + "§aSpieler wurde wegen §3Wiederholtem Spam §agebannt.");


                        }else {
                            player.sendMessage(Main.getPlugin().getNoperm());
                        }
                        break;

                    default:
                        break;
                }




            }else {
                player.sendMessage(Main.getPlugin().getPrefix() + "§4Benutzung §6/ban <Spieler> <Reason>");
            }
        }else {
            System.out.println(Main.getPlugin().getconsolePrefix() + "Du kannst diesen Befehl nicht in der Konsole verwenden.");
        }
        return false;
    }

}
