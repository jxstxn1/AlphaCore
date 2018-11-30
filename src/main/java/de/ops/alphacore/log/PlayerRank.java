package de.ops.alphacore.log;

import de.ops.alphacore.things.ConfigManager;

import java.util.UUID;

public class PlayerRank {

    ConfigManager cm = new ConfigManager();


    public int getWSKRank(UUID uuid) {
return cm.getPlayerData().getInt(uuid.toString() + ".wskrank");
    }

    public void setWSKRank(UUID uuid, int WSKRank) {
        cm.getPlayerData().setInt(uuid.toString() + ".wskrank" , WSKRank);

    }




}
