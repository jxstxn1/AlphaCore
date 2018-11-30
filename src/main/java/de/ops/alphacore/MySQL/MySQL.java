package de.ops.alphacore.MySQL;

import de.ops.alphacore.main.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

    public static String host = Main.mysql.getString("host");
    public static String port = Main.mysql.getString("port");
    public static String database = Main.mysql.getString("database");
    public static String username = Main.mysql.getString("username");
    public static String password = Main.mysql.getString("password");
    public static Connection con;


    //In OnEnable muss MySQL.connect();
    //In On Disable muss MySQL.disconnect();
    //Benötigt Config Namens mysql

    public static void connect(){
        if(!isConnected()) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                System.out.println("MySQL Connected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    public static void disconnect(){
        if (isConnected()){
            try {
                con.close();
                System.out.println("MySQL Disconnected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static boolean isConnected(){
        return (con == null ? false : true);
    }

    public static void update(String qry){
        if(MySQL.isConnected()) {
            try {
                con.createStatement().executeUpdate(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet getResult(String qry){
        if (isConnected()) {
            try {
                return con.createStatement().executeQuery(qry);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
            return null;

    }
    public static void createTable(){

        if(isConnected()) {
            try {
                con.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS BannedPlayers(Spielername VARCHAR(100), UUID VARCHAR(100), Ende VARCHAR(100), Grund VARCHAR");
               
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}




