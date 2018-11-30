package de.ops.alphacore.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.Config;
import de.ops.alphacore.things.HashFunctions;

public class LogInCommand implements CommandExecutor{
    public static Config messages;
    public static Config cfg;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;

            System.out.print("Test1");

            if(args.length == 2) {

                //Hier wird gehasht.
                Player target = Bukkit.getPlayer(args[0]);
                HashFunctions hashfunctions = new HashFunctions();
                String hash = hashfunctions.getHash(args[1].getBytes(), "SHA-512");
                System.out.println(hash);
                messages = new Config("Config/PlayerData.yml", Main.getPlugin());
                if(hash.equals(messages.getString(target.getUniqueId().toString()+ ".pw"))) {
                    p.sendMessage(Main.getPlugin().getPrefix() + "§aDu bist erfolgreich als §6" + target.getName() + "§a eingeloggt" );

                }else {
                    p.sendMessage(Main.getPlugin().getPrefix() + "§cDas angegebene Password oder der angegebene Benutzername ist falsch.");
                }


            }else {
                p.sendMessage(Main.getPlugin().getPrefix() + "Benutzung: §6/login <Spielername>");
            }

        }





        return false;
    }

}
