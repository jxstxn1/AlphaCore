package de.ops.alphacore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.Config;
import de.ops.alphacore.things.HashFunctions;

public class WebPWCommand implements CommandExecutor {
	public static Config messages = new Config("Config/PlayerData.yml", Main.getPlugin());
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length == 1) {
				HashFunctions hashfunctions = new HashFunctions();
				String hash = hashfunctions.getHash(args[0].getBytes(), "SHA-512");


				messages.setString(player.getUniqueId().toString() + ".pw", hash);
				messages.save();

				player.sendMessage(Main.getPlugin().getPrefix() + "§aDu hast dein Password erfolgreich gesetzt.");

			} else {
				player.sendMessage(Main.getPlugin().getPrefix() + "§cBenutzung §6/webpw <Password>");

			}
		}

		return false;
	}

}
