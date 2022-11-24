/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utilities.DBConnection;
import domainmodel.Anh;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AnhRepository {

    DBConnection dBConnection;
    PreparedStatement pst = null;
    ResultSet rs = null;
    List<Anh> listAnh = null;

    public List<Anh> getListAnh() {
        listAnh = new ArrayList<>();
        String sql = "select id,UrlImage,ten from anh";
        try {
            pst = dBConnection.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Anh a = new Anh();
                a.setId(rs.getString("id"));
                a.setUrlImage(rs.getBytes("UrlImage"));
                a.setTen(rs.getString("ten"));
                listAnh.add(a);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAnh;
    }

    public String themAnh(Anh a) {

        String sql = "insert into anh(id,UrlImage,ten) values(newid(),?,?)";
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setBytes(1, a.getUrlImage());
            pst.setString(2, a.getTen());

            listAnh.add(a);
            pst.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Thêm thất bại";
    }

    public String SuaAnh( Anh anh) {

        String sql = "update Anh set UrlImage=?,ten=? where id=?";
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setBytes(1, anh.getUrlImage());
            pst.setString(2, anh.getTen());
            pst.setString(3, anh.getId());

            pst.executeUpdate();
            return "Thêm thành công";
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Thêm thất bại";
    }

    public String XoaAnh(String id) {

        String sql = "delete anh where id=?";
        try {
            pst = DBConnection.getConnection().prepareStatement(sql);

            pst.setObject(1, id);

            pst.executeUpdate();
            return "Xoa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Xoa thất bại";
    }

}
