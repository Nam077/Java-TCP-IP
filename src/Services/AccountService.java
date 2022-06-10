package Services;

import Models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountService {
    //get connection from ConnectDB
    Connection conn = ConnectDB.getConnection();

    //check if email is exist
    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //insert new user to database with model Users return message
    public String insertUser(Users user) {
        String message = "";
        String sql = "INSERT INTO users (name, email, password, role, address, phone, code) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getPhone());
            pst.setString(7, user.getCode());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                message = "Inserted";
            } else {
                message = "Not Inserted";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    //update user to database with model Users return message
    public String updateUser(Users user) {
        String message = "";
        String sql = "UPDATE users SET name = ?, email = ?, password = ?, role = ?, address = ?, phone = ?, code = ? WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getPhone());
            pst.setString(7, user.getCode());
            pst.setInt(8, user.getId());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                message = "Updated";
            } else {
                message = "Not Updated";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    //delete user to database with model Users return message
    public String deleteUser(Users user) {
        String message = "";
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, user.getId());
            int rs = pst.executeUpdate();
            if (rs > 0) {
                message = "Deleted";
            } else {
                message = "Not Deleted";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    //get user from database with model Users return model Users with email
    public Users getUser(String email) {
        Users user = new Users();
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setCode(rs.getString("code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //get user from database with model Users return model Users with id
    public Users getUser(int id) {
        Users user = new Users();
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            java.sql.ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                user.setAddress(rs.getString("address"));
                user.setPhone(rs.getString("phone"));
                user.setCode(rs.getString("code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //check login with model Users return user
    public Users checkLogin(Users user) {
        Users userReturn = new Users();
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                userReturn.setId(rs.getInt("id"));
                userReturn.setName(rs.getString("name"));
                userReturn.setEmail(rs.getString("email"));
                userReturn.setPassword(rs.getString("password"));
                userReturn.setRole(rs.getString("role"));
                userReturn.setAddress(rs.getString("address"));
                userReturn.setPhone(rs.getString("phone"));
                userReturn.setCode(rs.getString("code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userReturn;
    }
}
