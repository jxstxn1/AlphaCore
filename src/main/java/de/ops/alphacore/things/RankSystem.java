package de.ops.alphacore.things;

import java.util.UUID;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


import de.ops.alphacore.main.Main;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class RankSystem {
    static ConfigManager cm = new ConfigManager();
    static Scoreboard sb;


    public static void setRank(Player player, Rank rank) {


        cm.getPlayerData().setString(player.getUniqueId().toString() + ".rank", rank.name());

    }

    public static void setRank1(UUID uuid, Rank rank) {
        cm.getPlayerData().setString(uuid.toString() + ".rank", rank.name());

    }


    public static Rank getRank(Player player) {
        return Rank.valueOf(cm.getPlayerData().getString(player.getUniqueId().toString() + ".rank"));
    }


    public static void setPrefix() {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Team Admin = board.registerNewTeam("01Admin");
        final Team Manager = board.registerNewTeam("02Manager");
        Team Dev = board.registerNewTeam("03Dev");
        Team Mod = board.registerNewTeam("04Mod");
        final Team Supp = board.registerNewTeam("05Supp");
        Team Archi = board.registerNewTeam("06Archi");
        final Team YouTuber = board.registerNewTeam("07YouTuber");
        final Team Premium = board.registerNewTeam("08Premium");
        final Team User = board.registerNewTeam("09User");


        Admin.setPrefix("§4Admin §7| §4");
        Admin.setSuffix("§e §7[§eTeam§7]");
        Manager.setPrefix("§5Manager §7| §5");
        Dev.setPrefix("§bDev §7| §b");
        Mod.setPrefix("§cMod §7| §c");
        Supp.setPrefix("§1Supp §7| §1");
        Archi.setPrefix("§5Archi §7| §5");
        YouTuber.setPrefix("§dYouTuber §7| §d");
        Premium.setPrefix("§6Premium §7| §6");
        User.setPrefix("§7User §7| §7");
        Bukkit.getOnlinePlayers().forEach(p -> {
            switch (getRank(p)) {

                case ADMIN:
                    Admin.addEntry(p.getName());
                    break;
                case MANAGER:
                    Manager.addEntry(p.getName());
                    break;
                case DEV:
                    Dev.addEntry(p.getName());
                    break;
                case MOD:
                    Mod.addEntry(p.getName());
                    break;
                case SUPPORTER:
                    Supp.addEntry(p.getName());
                    break;
                case Archi:
                    Archi.addEntry(p.getName());
                    break;
                case YouTuber:
                    YouTuber.addEntry(p.getName());
                    break;
                case Premium:
                    Premium.addEntry(p.getName());
                    break;
                case User:
                    User.addEntry(p.getName());
                    break;
            }
            p.setScoreboard(board);
        });
    }


}








