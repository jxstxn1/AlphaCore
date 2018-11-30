package de.ops.alphacore.things;



import net.md_5.bungee.api.ChatColor;

public enum Rank {

	ADMIN("Admin", ChatColor.DARK_RED),
	MANAGER("Manager", ChatColor.YELLOW),
	DEV("Dev", ChatColor.AQUA),
	MOD("Mod",ChatColor.RED),
	SUPPORTER("Supp", ChatColor.BLUE),
	Archi("Builder", ChatColor.GREEN),
	YouTuber("YT", ChatColor.DARK_PURPLE),
	Premium("Premium", ChatColor.GOLD),
	User("Spieler", ChatColor.GRAY);
	
	
	private String name;
	private ChatColor color;
	
	private Rank(String name, ChatColor color) {
	this.name = name;
	this.color = color;
	
	}
public String getName() {return name;}
public ChatColor getColor() {return color;}



}
