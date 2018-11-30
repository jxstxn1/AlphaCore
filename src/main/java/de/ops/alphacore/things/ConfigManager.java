package de.ops.alphacore.things;


import de.ops.alphacore.main.Main;


public class ConfigManager {


    private Config config = new Config("config.yml", Main.getPlugin());
    private Config playerData = new Config("Config/PlayerData.yml", Main.getPlugin());
    private Config ger = new Config("Config/languages/ger.yml", Main.getPlugin());
    private Config eng = new Config("Config/languages/eng.yml", Main.getPlugin());
    private Config fr = new Config("Config/languages/fr.yml", Main.getPlugin());
    private Config nl = new Config("Config/languages/nl.yml", Main.getPlugin());
    private Config hu = new Config("Config/languages/hu.yml", Main.getPlugin());
    private Config ru = new Config("Config/languages/ru.yml", Main.getPlugin());
    private Config tu = new Config("Config/languages/tu.yml", Main.getPlugin());


    //
    public void ConfigEnabler() {
        if (config.getString("Language") == null) {
            config.setString("Language", "ger");
            System.out.println(Main.getPlugin().getconsolePrefix() + "Setze Config wertde");
        }
         if (config.getBoolean("saveIPs") == false) {
            config.setBoolean("saveIPs", false);
        }
    }


    //Multilingualer Configteil


    //Global

    public String getNoPerm() {

        String s = config.getString("Language");
        if ("ger".equalsIgnoreCase(s)) {


            return ger.getString("noperm");


        } else if ("eng".equalsIgnoreCase(s)) {
            return eng.getString("noperm");

        } else if ("fr".equalsIgnoreCase(s)) {
            return fr.getString("noperm");

        } else if ("hu".equalsIgnoreCase(s)) {
            return hu.getString("noperm");
        } else if ("nl".equalsIgnoreCase(s)) {
            return nl.getString("noperm");

        } else if ("ru".equalsIgnoreCase(s)) {
            return ru.getString("noperm");
        } else if ("tu".equalsIgnoreCase(s)) {
            return tu.getString("noperm");

        } else {
            return eng.getString("noperm");

        }
    }

    public String getNotInConsole() {
        Main.getPlugin().saveConfig();

        String s = config.getString("Language");
        if ("ger".equalsIgnoreCase(s)) {

            return ger.getString("notInConsole");

        } else if ("eng".equalsIgnoreCase(s)) {
            return eng.getString("notInConsole");

        } else if ("fr".equalsIgnoreCase(s)) {
            return fr.getString("notInConsole");

        } else if ("hu".equalsIgnoreCase(s)) {
            return hu.getString("notInConsole");

        } else if ("nl".equalsIgnoreCase(s)) {
            return nl.getString("notInConsole");

        } else if ("ru".equalsIgnoreCase(s)) {
            return ru.getString("notInConsole");

        } else if ("tu".equalsIgnoreCase(s)) {
            return tu.getString("notInConsole");

        } else {
            return eng.getString("notInConsole");

        }
    }

    public String getUsage() {

        String s = config.getString("Language");
        if ("ger".equalsIgnoreCase(s)) {

            return ger.getString("lang.usage");

        } else if ("eng".equalsIgnoreCase(s)) {
            return eng.getString("lang.usage");

        } else if ("fr".equalsIgnoreCase(s)) {
            return fr.getString("lang.usage");

        } else if ("hu".equalsIgnoreCase(s)) {
            return hu.getString("lang.usage");

        } else if ("nl".equalsIgnoreCase(s)) {
            return nl.getString("lang.usage");

        } else if ("ru".equalsIgnoreCase(s)) {
            return ru.getString("lang.usage");

        } else if ("tu".equalsIgnoreCase(s)) {
            return tu.getString("lang.usage");

        } else {
            return eng.getString("lang.usage");

        }
    }


    //Heal-Command
    public String getHealed() {

        String s = config.getString("Language");
        if ("ger".equalsIgnoreCase(s)) {
            ger.setString("heal.healed", "§aDu wurdest geheilt");
            return ger.getString("heal.healed");

        } else if ("eng".equalsIgnoreCase(s)) {
            System.out.println("Debugg");
            eng.setString("heal.healed", "§aYou werde healed");
            return eng.getString("heal.healed");

        } else if ("fr".equalsIgnoreCase(s)) {
            fr.setString("heal.healed", "§aTu as été guéri");
            return fr.getString("heal.healed");

        } else if ("hu".equalsIgnoreCase(s)) {
            hu.setString("heal.healed", "§aMeggyógyultál");
            return hu.getString("heal.healed");

        } else if ("nl".equalsIgnoreCase(s)) {
            nl.setString("heal.healed", "§aJe was genezen");
            return nl.getString("heal.healed");

        } else if ("ru".equalsIgnoreCase(s)) {
            ru.setString("heal.healed", "§aВы были исцелены");
            return ru.getString("heal.healed");

        } else if ("tu".equalsIgnoreCase(s)) {
            tu.setString("heal.healed", "§aİyileştiniz");
            return tu.getString("heal.healed");

        } else {

            return eng.getString("heal.healed");

        }
    }

    public String getHealedOther() {
        String s = config.getString("Language");
        if ("ger".equalsIgnoreCase(s)) {


            return ger.getString("heal.healOther");

        } else if ("eng".equalsIgnoreCase(s)) {
            return eng.getString("heal.healedOther");

        } else if ("fr".equalsIgnoreCase(s)) {
            return fr.getString("heal.healedOther");

        } else if ("hu".equalsIgnoreCase(s)) {
            return hu.getString("heal.healedOther");

        } else if ("nl".equalsIgnoreCase(s)) {
            return nl.getString("heal.healedOther");

        } else if ("ru".equalsIgnoreCase(s)) {
            return ru.getString("heal.healedOther");

        } else if ("tu".equalsIgnoreCase(s)) {
            return tu.getString("heal.healedOther");

        } else {
            return eng.getString("heal.healedOther");

        }
    }

    public String getHealedByOther() {
        String s = config.getString("Language");
        if ("ger".equalsIgnoreCase(s)) {

            return ger.getString("heal.healedByOther");

        } else if ("eng".equalsIgnoreCase(s)) {
            return eng.getString("heal.healedByOther");

        } else if ("fr".equalsIgnoreCase(s)) {
            return fr.getString("heal.healedByOther");

        } else if ("hu".equalsIgnoreCase(s)) {
            return hu.getString("heal.healedByOther");

        } else if ("nl".equalsIgnoreCase(s)) {
            return nl.getString("heal.healedByOther");

        } else if ("ru".equalsIgnoreCase(s)) {
            return ru.getString("heal.healedByOther");

        } else if ("tu".equalsIgnoreCase(s)) {
            return tu.getString("heal.healedByOther");

        } else {
            return eng.getString("heal.healByOther");

        }
    }

    public String getNotOnline() {
        String s = config.getString("Language");
        if ("ger".equalsIgnoreCase(s)) {
            System.out.println("NotOnline");
            return ger.getString("notOnline");

        } else if ("eng".equalsIgnoreCase(s)) {
            return eng.getString("notOnline");

        } else if ("fr".equalsIgnoreCase(s)) {
            return fr.getString("notOnline");

        } else if ("hu".equalsIgnoreCase(s)) {
            return hu.getString("notOnline");

        } else if ("nl".equalsIgnoreCase(s)) {
            return nl.getString("notOnline");

        } else if ("ru".equalsIgnoreCase(s)) {
            return ru.getString("notOnline");

        } else if ("tu".equalsIgnoreCase(s)) {
            return tu.getString("notOnline");

        } else {
            return eng.getString("notOnline");

        }
    }


//LanguageCommand
public void setPlayerLanguage(String language){

}

//Getter

    public Config getPlayerData() {
        return playerData;
    }

    public Config getGer() {
        return ger;
    }

    public Config getEng() {
        return eng;
    }

    public Config getFr() {
        return fr;
    }

    public Config getNl() {
        return nl;
    }

    public Config getHu() {
        return hu;
    }

    public Config getRu() {
        return ru;
    }

    public Config getTu() {
        return tu;
    }

    public Config getConfig() {
        return config;
    }
}