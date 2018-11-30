package de.ops.alphacore.commands;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.MoneySystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.BatchUpdateException;


public class Money implements CommandExecutor {




    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length == 0){

                player.sendMessage(Main.getPlugin().getPrefix() + "Du hast §6"+ MoneySystem.getMoney(player.getUniqueId()) );
            }else if(args.length == 1){
            if(!args[0].equalsIgnoreCase("pay")) {
                player.sendMessage(Main.getPlugin().getPrefix() + "§aDer Spieler hat §6" + MoneySystem.getMoney(Bukkit.getOfflinePlayer(args[0]).getUniqueId()) + "§a Coins");
            }else{
                player.sendMessage(Main.getPlugin().getPrefix() + "§cBenutzung: /money pay <Spieler> [Betrag]");
            }
            }else if(args.length == 3){
                if(args[0].equalsIgnoreCase("pay")){

               int amount = 0;
                    try{
                 amount =  Integer.parseInt(args[2]);
               }catch (NumberFormatException e){
                        player.sendMessage(Main.getPlugin().getPrefix() + "§cDu kannst keine Buchstaben überweisen.");
                    }

                    if(amount <= MoneySystem.getMoney(player.getUniqueId())){
                       
                        if(Bukkit.getOfflinePlayer(args[1]).hasPlayedBefore()) {
                            MoneySystem.setMoney(player.getUniqueId(), MoneySystem.getMoney(player.getUniqueId()) - amount);
                            MoneySystem.setMoney(Bukkit.getOfflinePlayer(args[1]).getUniqueId(), MoneySystem.getMoney(Bukkit.getOfflinePlayer(args[1]).getUniqueId()) + amount);
                            Player target = Bukkit.getPlayer(args[1]);
                            if (target != null) {
                                player.sendMessage(Main.getPlugin().getPrefix() + "§aDu hast  §6" + Bukkit.getPlayer(args[1]).getName() + "§9" + amount + "§a Coins überwiesen");//<- Change
                                target.sendMessage(Main.getPlugin().getPrefix() + "§6" + player.getName() + "§ahat dir §9" + amount + "Coins überwiesen.");
                            } else {
                                player.sendMessage(Main.getPlugin().getPrefix() + "§aDu hast §6" + Bukkit.getOfflinePlayer(args[1]).getName() + "§9 " + amount + "§a Coins überwiesen");
                            }



                       }else{
                           player.sendMessage(Main.getPlugin().getPrefix() + "§cDieser Spieler war noch nie auf unserem Netzwerk.");
                       }
                   }else{
                       System.out.println(MoneySystem.getMoney(player.getUniqueId()));
                       player.sendMessage(Main.getPlugin().getPrefix() + "§cDazu hast du nicht genügend Geld.");
                    }


                }else{
                    player.sendMessage(Main.getPlugin().getPrefix() + "§a Benutzung: §6/money pay <Spieler> [Betrag]");
                }
            }else
                player.sendMessage(Main.getPlugin().getPrefix() + "§cBenutzung §6/money <Spieler>");
        }else{
            System.out.println(Main.getPlugin().getconsolePrefix() + "Du kannst diesen Befehl nicht in der Konsole benutzen");
        }




        return false;
    }
}
