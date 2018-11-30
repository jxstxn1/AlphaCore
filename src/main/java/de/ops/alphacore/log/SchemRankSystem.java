package de.ops.alphacore.log;

import de.ops.alphacore.main.Main;
import de.ops.alphacore.things.Config;

public class SchemRankSystem {
    public static Config config = new Config("Config/schemRanks.yml", Main.getPlugin());

public static void increaseSchematicRank(String schemName) {
    config.setInt(schemName + ".rank", config.getInt("schem.rank") + 1);
}


public static void decreaseSchematicRank(String schemName){
config.setInt(schemName + ".rank", config.getInt("schem.rank")-1);
}

public static void setSchematicRank(String schemName, int rank){
    config.setInt(schemName + ".rank", rank);
}

public static int getSchematicRank (String schemName){
return config.getInt(schemName+ ".rank");
}

public static void registerSchematic(String schemName, String besitzer){
    config.setString(schemName + ".name",schemName);
    config.setString(schemName +"schem.owner", besitzer);
    config.setInt(schemName + ".rank", 0);
    config.setInt(schemName+ ".wonFights", 0);
}

public static int getSchemWins(String schemName){
   return  config.getInt(schemName + ".wonFights");
    }
public static String getSchemOwner(String schemName){
return config.getString(schemName + ".owner");
}
}
