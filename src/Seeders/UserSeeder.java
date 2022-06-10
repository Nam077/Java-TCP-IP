package Seeders;

import Services.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserSeeder {
    //get connection from ConnectDB.java
    Connection conn = ConnectDB.getConnection();
    //make 100 fake data for table users
    public void seedUsers() {
        for (int i = 0; i < 100; i++) {
            String name = "name" + i;
            String email = " email" + i + "@gmail.com";
            String password = "password" + i;
            String role = "role" + i;
            String address = "address" + i;
            String phone = "phone" + i;
            String code = "code" + i;
            String sql = "INSERT INTO users (name, email, password, role, address, phone, code) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, password);
                pst.setString(4, role);
                pst.setString(5, address);
                pst.setString(6, phone);
                pst.setString(7, code);
                int rs = pst.executeUpdate();
                if (rs > 0) {
                    System.out.println("Inserted");
                } else {
                    System.out.println("Not Inserted");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        UserSeeder userSeeder = new UserSeeder();
        userSeeder.seedUsers();
    }
}
