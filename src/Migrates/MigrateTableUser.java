package Migrates;

import Services.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MigrateTableUser {
    public static void migrateTableUser() {
        //get connection from ConnectDB.java
        Connection conn = ConnectDB.getConnection();
        //create table user
        String sql = "CREATE TABLE users (id int NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, email varchar(255) NOT NULL, password varchar(255) NOT NULL, role varchar(255) NOT NULL, address varchar(255) NOT NULL, phone varchar(255) NOT NULL, code varchar(255) NOT NULL, PRIMARY KEY (id))";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Table users created");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        migrateTableUser();
    }
}
