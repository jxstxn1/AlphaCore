package de.ops.alphacore.main;

import javax.net.ssl.SNIServerName;

import de.ops.alphacore.commands.*;
import de.ops.alphacore.listener.PingListener;
import de.ops.alphacore.log.SchemRankSystem;
import de.ops.alphacore.things.Rank;
import de.ops.alphacore.things.RankSystem;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginBase;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.ops.alphacore.listener.RankListener;
import de.ops.alphacore.things.Config;
import de.ops.alphacore.things.ConfigManager;
import org.bukkit.scoreboard.Scoreboard;

public class Main extends JavaPlugin {




    /*
    <AlphaCore a core plugin for minecraft server.>
    Copyright (C) <2018>  <Justin, Leonhard, Zeanon>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
            (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

   */


    public static Config messages;
    private static Config cfg;


    private static Main plugin;

    //Werte
    private String consolePrefix = "[AlphaCore] ";
    private String prefix = "§aAlphaCore§7 | ";
    private String noperm = "§cDu hast nicht die benötigten Rechte, um diesen Befehl auszuführen.";
    private String version = "0.0.5.1.1";
    private String help = "§7Nutze §6/help§7  für Hilfe";
    private String serverName = "Test";

    // OnEnable

    @Override
    public void onEnable() {
       Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix + "§620% - §a Getting Systemproperties");
        System.out.println(" ");
        if (System.getProperty("os.name").contains("Linux")) {
            Bukkit.getConsoleSender().sendMessage(consolePrefix + "§dUsing §aAlphaCore§d-Server-Edition ");
        } else {
            Bukkit.getConsoleSender().sendMessage(consolePrefix + "§dUsing §aAlphaCore§d-Client-Edition ");
        }

        System.out.println(" ");

        plugin = this;
        Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix + "§640% - §aLoading Commands");

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("gm").setExecutor(new GMCommands());
        getCommand("webpw").setExecutor(new WebPWCommand());
        getCommand("login").setExecutor(new LogInCommand());
        getCommand("ban").setExecutor(new BannCommand());
        getCommand("setrank").setExecutor(new RankCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("money").setExecutor(new Money());
        getCommand("setmoney").setExecutor(new Setmoney());
        getCommand("language").setExecutor(new LanguageCommand());
        //


        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new RankListener(), this);
        pluginManager.registerEvents(new PingListener(), this);
        //
        Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix + "§660% - §aLoading Configs");
        ConfigManager cm = new ConfigManager();
        cm.ConfigEnabler();
        Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix + "§670% - §aLoading Ranks");
        //

        Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix + "§680% - §aLoading Languages");

        SchemRankSystem.registerSchematic("WSV1", "TestUser");


        Bukkit.getServer().getConsoleSender().sendMessage(consolePrefix + "§aAlphaCore§5 " + version + " §aerfolgreich aktiviert.");


    }


    public Main() {

    }


    // Getter&Setter
    public static Main getPlugin() {
        return plugin;
    }

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    public String getconsolePrefix() {
        return consolePrefix;
    }

    public void setconsolePrefix(String consolePrefix) {
        this.consolePrefix = consolePrefix;
    }

    public String getNoperm() {
        return noperm;
    }

    public void setNopern(String noperm) {
        this.noperm = noperm;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }
}


