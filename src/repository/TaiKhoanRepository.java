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

            TaiKhoan taiKhoan1 = new TaiKhoan();
            taiKhoan1.setUsername(username);
            taiKhoan1.setPassword(password);
            taiKhoan.add(taiKhoan1);
        }
        return taiKhoan;
    }

    public TaiKhoan getAccountByUserName(String username) throws SQLException {
        for (TaiKhoan taiKhoan : getLogin()) {
            //Nếu tài khoản trùng với tên cần tìm thì trả về 
            if (taiKhoan.getUsername().equalsIgnoreCase(username)) {
                return taiKhoan;
            }
        }
        return null;
    }
}
