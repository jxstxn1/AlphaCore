package de.ops.alphacore.things;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class MoneySystem  {
   static ConfigManager cm = new ConfigManager();




    public static void setMoney(UUID uuid , int amount){
        cm.getPlayerData().setInt(uuid.toString() + ".Money", amount);

    cm.getPlayerData().save();
    }
public static int getMoney(UUID uuid){

        return cm.getPlayerData().getInt(uuid.toString() + ".Money");


    }



}
