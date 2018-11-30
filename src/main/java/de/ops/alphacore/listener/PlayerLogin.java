package de.ops.alphacore.listener;

import de.ops.alphacore.BanManager.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import static de.ops.alphacore.BanManager.BanManager.getReason;
import static de.ops.alphacore.BanManager.BanManager.getRemainingTime;
//import static De.OpenSource.Action.BanManager.BanManager.getReason;
//import static De.OpenSource.Action.BanManager.BanManager.getRemainingTime;

public class PlayerLogin implements Listener {

    public void onPlayerLogin(PlayerLoginEvent e){
        Player p= e.getPlayer();
        if (BanManager.isBanned(p.getUniqueId().toString())) {
            long current = System.currentTimeMillis();
            long end = BanManager.getEnd(p.getUniqueId().toString());
            if(current < end |end == -1){
                e.disallow(PlayerLoginEvent.Result.KICK_BANNED, "§cDu wurdest vom Server gebannt!\n" +
                        "\n" +
                        "§3Grund: §e" + getReason(p.getUniqueId().toString()) +"\n" +
                        "\n" +
                        "§3Verbleibende Zeit: §3" +getRemainingTime(p.getUniqueId().toString()) + "\n" +
                        "\n" +
                        "§3 Du kannst §c§neinen§3 Entbannungsantrag im Forum schreiben!");

            }
        }
    }


}
