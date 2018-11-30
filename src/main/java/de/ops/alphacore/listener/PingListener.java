package de.ops.alphacore.listener;

import de.ops.alphacore.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class PingListener implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e){

        e.setMaxPlayers(100);
        e.setMotd("§e§lWarKing.de §a- §3Dein offizieller WarShip-Server \n§aOpen-Alpha");
        try{
e.setServerIcon(Bukkit.loadServerIcon(new File("icon.jpg")));
        }catch(Exception e1){
            System.out.println(Main.getPlugin().getconsolePrefix() + "There was a problem with the Server-Motd");
        }


    }

}
