package de.ops.alphacore.commands;


import javax.tools.DocumentationTool.Location;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import de.ops.alphacore.main.Main;

public class SetSpawnCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("tutorial.setspawn")){
				if(args.length == 0) {
					
					FileConfiguration cfg = Main.getPlugin().getConfig();
				    org.bukkit.Location loc = p.getLocation();
					
					cfg.set("Spawn.World", loc.getWorld().getName());
					cfg.set("Spawn.X", loc.getX());
					cfg.set("Spawn.Y", loc.getY());
					cfg.set("Spawn.Z", loc.getZ());
					cfg.set("Spawn.Yaw", loc.getYaw());
					cfg.set("Spawn.Pitch", loc.getPitch());
					Main.getPlugin().saveConfig();
					
					p.sendMessage(Main.getPlugin().getPrefix() + "§a Du hast den Spawn erfolgreich umgesetzt!");
					
					
					
					
				}else
					p.sendMessage(Main.getPlugin().getPrefix() + "§c Benutzung: /setspawn");
			}else 
				p.sendMessage(Main.getPlugin().getNoperm());
		}
		
		
		
		
		
		
		return false;
	}

}
