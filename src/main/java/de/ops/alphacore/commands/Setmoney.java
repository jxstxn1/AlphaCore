package de.ops.alphacore.commands;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.MoneySystem;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Setmoney implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
           Player player = (Player) sender;
           if(player.hasPermission("alphacore.setmoney")){
               if(args.length == 2){
                   Player  target =  Bukkit.getPlayer(args[0]);
                   if(target != null){

                       int amount = 0;
                       try{
                           amount = Integer.parseInt(args[1]);
                       }catch(NumberFormatException e){
                           player.sendMessage(Main.getPlugin().getPrefix() + "§c Du kannst hier keine Buchstaben eingeben.");
                       }


                       MoneySystem.setMoney(target.getUniqueId(), amount);
                       player.sendMessage(Main.getPlugin().getPrefix() + "§aErfolg");
                   }

               }else{
                   player.sendMessage ("Unkown command. Type /help for help");
               }
           }

        }




        return false;
    }
}
