package de.ops.alphacore.listener;


import de.ops.alphacore.commands.SpawnCommand;
import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.ConfigManager;
import de.ops.alphacore.things.HashFunctions;
import de.ops.alphacore.things.RankSystem;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;


import de.ops.alphacore.things.Rank;
import org.bukkit.scoreboard.Scoreboard;

public class RankListener implements Listener {
    ConfigManager cm = new ConfigManager();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Rank rank = RankSystem.getRank(player);

        RankSystem.setPrefix();
        if (!e.getPlayer().hasPlayedBefore()) {
            RankSystem.setRank1(e.getPlayer().getUniqueId(), Rank.User);
            System.out.println("Neuer Spieler");
            cm.getPlayerData().setString(e.getPlayer().getUniqueId().toString() + ".name", player.getName());
            cm.getPlayerData().setString(player.getUniqueId().toString() + "firstplayed",String.valueOf(player.getFirstPlayed()));
        }else{
            cm.getPlayerData().setString(player.getUniqueId().toString() + ".lastplayed" , String.valueOf(player.getLastPlayed()));

        }

        //IPSaver
       if(cm.getConfig().getBoolean("saveIPs") == true){
           System.out.println("Ip wurde gespeichert.");
           System.out.println("getAdress" + player.getAddress());
           System.out.println("get Adress 2x" + player.getAddress().getAddress());
           System.out.println("get Adress, get Hostename" + player.getAddress().getAddress().getHostAddress());
           System.out.println("get Canonical host" + player.getAddress().getAddress().getCanonicalHostName());

           cm.getPlayerData().setString(player.getUniqueId() + ".ip" , player.getAddress().getHostName());
       }else{
          System.out.println("IP wurde als hash gespeichert.");
           cm.getPlayerData().setString(player.getUniqueId() + ".ip", HashFunctions.getHash(player.getAddress().getHostName().getBytes(), "SHA-512"));
       }


        //Spawn-Command & Joinmessage
        SpawnCommand.tp2Spawn(e.getPlayer());
        if (RankSystem.getRank(e.getPlayer()).equals(Rank.User)) {
            e.setJoinMessage("");
        } else {
            e.setJoinMessage(rank.getColor() + rank.getName() + "§7 | " + rank.getColor() + player.getName() + "§e ist dem Server beigetreten.");
        }
        e.getPlayer().setGameMode(GameMode.CREATIVE);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {


        Player player = e.getPlayer();
        Rank rank = RankSystem.getRank(player);


        for (Player onlinePlayers : e.getRecipients()) {

            if (RankSystem.getRank(player).equals(Rank.User)) {
                onlinePlayers.sendMessage(rank.getColor() + player.getName() + "§8 » §f" + e.getMessage());
            } else {
                onlinePlayers.sendMessage(rank.getColor() + rank.getName() + "§7 | " + rank.getColor() + player.getName() + "§8 » §f" + e.getMessage());
            }


        }
        e.setCancelled(true);

    }


}
