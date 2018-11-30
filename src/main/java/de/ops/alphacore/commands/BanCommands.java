package de.ops.alphacore.commands;

import de.ops.alphacore.BanManager.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;


public class BanCommands implements CommandExecutor {





    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("ban")) {
            if (args.length >= 2) {
                String playername = args[0];
                if(BanManager.isBanned(getUUID(playername))){
                    sender.sendMessage("§7" + playername + "§7ist bereits gebannt");
                    return true;
                }
                String reason = "";
                for (int i = 1; i < args.length; i++) {
                    reason += args[i] + "";
                }
                BanManager.ban(getUUID(playername), playername, reason, -1);
                sender.sendMessage("§7Du hast §e" + playername + "§4PERMANENT §7gebannt!");
                return true;
            }
            sender.sendMessage("§cAktion nicht möglich! Benutze /ban <Spieler> <Grund> um einen Spieler zu bannen");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("tempban")){
            if (args.length >= 4){
                String playername = args[0];
                long value;
                try{
                    value = Integer.valueOf(args[1]);
                }catch (NumberFormatException e){
                    sender.sendMessage("§cAktion nicht möglich! <Zahlenwert> muss eine Zahl sein!");
                    return true;
                }
                if (value >= 500){
                    sender.sendMessage("§cDie Zahl muss unter 500 liegen, du kannst aber auch die Einheit ändern");
                }
                String unitString = args[2];
                String reason = "";
                for (int i= 3; i< args.length; i++){
                    reason += args[i] + " ";
                }
                List<String> unitList = BanUnit.getUnitsAsString();
                if (unitList.contains(unitString.toLowerCase())){
                    BanUnit unit= BanUnit.getUnit(unitString);
                    long seconds = value * unit.getToSecond();
                    BanManager.ban(getUUID(playername), playername, reason, seconds);
                    sender.sendMessage("§7Du hast §e" + playername + "§4TEMPORÄR §7gebannt! Dauer: §c" +value + unit.getName());
                    return true;
                }
                sender.sendMessage("§cAktion nicht möglich! <Einheit> existiert nicht!");
                return true;
            }
            sender.sendMessage("§cAktion nicht möglich! Benutze /tempban <Spieler> <Zahlenwert> <Einheit> <Grund> um einen Spieler zu vorübergehend bannen");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("check")){
            if (args.length ==1) {
                if (args[0].equalsIgnoreCase("list")){
                    List<String> list= BanManager.getBannedPlayers();
                    if (list.size() == 0){
                        sender.sendMessage("§cAktuell ist niemand gebannt");
                    }
                    sender.sendMessage("§7--------§6§1Ban-Liste §7 --------");
                    for (String allBanned : BanManager.getBannedPlayers()){
                        sender.sendMessage("§e" + allBanned + "§7(Grund: §r" +BanManager.getReason(getUUID(allBanned))+"§7Benutze /unban <Spielername> um einen dieser Spieler zu entbannen");
                    }
                    return true;
                }
                String playername = args[0];
                sender.sendMessage("§7--------§6§1Ban-Infos §7 --------");
                sender.sendMessage("§eName: §r" +playername);
                sender.sendMessage("§eGebannt:§r" + (BanManager.isBanned(getUUID(playername)) ? "§aGEBANNT" : "§cNICHT GEBANNT"));
                if (BanManager.isBanned(getUUID(playername))){
                    sender.sendMessage("§eGrund §r" + BanManager.getReason(getUUID(playername)));
                    sender.sendMessage("§eDauer§r" + BanManager.getRemainingTime(getUUID(playername)));
                }




                return true;
            }
            sender.sendMessage("§cAktion nicht möglich! Benutze /check <Spieler> oder /list <Spieler> um gebannte Spieler angezeigt zu bekommen");
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("unban")) {
            if(args.length == 1){
                String playername = args[0];
                if (BanManager.isBanned(getUUID(playername))){
                    sender.sendMessage("§c Dieser Spieler ist nicht gebannt!");
                }
                BanManager.unban(getUUID(playername));
                sender.sendMessage("§7Du hast§e" +playername+"§7 entbannt!");
                return true;
            }
            sender.sendMessage("§cBenutze /unban <Spieler> um  einen Spieler zu entbannen");

            return true;
        }

        return true;
    }

    private String getUUID(String playername){
        return Bukkit.getOfflinePlayer(playername).getUniqueId().toString();
    }

}
