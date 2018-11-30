package de.ops.alphacore.listener;

import de.ops.alphacore.BanManager.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {


    public void onPlayerJoin(PlayerJoinEvent e){
        Player p= e.getPlayer();
        if(BanManager.isBanned(p.getUniqueId().toString())){
            BanManager.unban(p.getUniqueId().toString());
        }
    }

}
