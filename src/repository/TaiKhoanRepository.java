/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.TaiKhoan;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
import utilities.DBConnection;

/**
 *
 * @author Admin
 */
public class TaiKhoanRepository {

    public List<TaiKhoan> getLogin() throws SQLException {
        List<TaiKhoan> taiKhoan = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "select * from TaiKhoan";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            String email = rs.getString("email");

            TaiKhoan taiKhoan1 = new TaiKhoan();
            taiKhoan1.setUsername(username);
            taiKhoan1.setPassword(password);
            taiKhoan1.setEmail(email);
            taiKhoan.add(taiKhoan1);
        }
        return taiKhoan;
    }

    public TaiKhoan getAccountByUserName(String username) throws SQLException {
        for (TaiKhoan taiKhoan : getLogin()) {
            if (taiKhoan.getUsername().equalsIgnoreCase(username)) {
                return taiKhoan;
            }
        }
        return null;
    }
    
    public boolean dangKi(TaiKhoan tk) throws SQLException {
        int check = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "INSERT TaiKhoan(username, password, email, roll) VALUES (?, ?, ?, 'staff')";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, tk.getUsername());
        ps.setString(2, tk.getPassword());
        ps.setString(3, tk.getEmail());

        check = ps.executeUpdate();
        ps.close();
        connection.close();
        return true;
    }
    
    public boolean updateMK(String tk) throws SQLException {
        int check = 0;

        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE TaiKhoan SET password='12345' WHERE username=?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, tk);

        check = ps.executeUpdate();
        ps.close();
        connection.close();
        return check > 0;
    }
}
