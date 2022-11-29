/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Anh;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.List;
import utilities.DBConnection;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class AnhRepository {
     DBConnection DB;
//    List<SanphamProduct> listSanpham = null;
    List<Anh> listAnh=null;
    ResultSet rs = null;
    PreparedStatement pst = null;
      
    
    public List<Anh> getListAnh() {
        listAnh = new ArrayList<>();
        String sql = "select id,UrlImage,ten from anh";
        try {
            pst = DB.getConnection().prepareStatement(sql);
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
//            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);
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
//            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "Thêm thất bại";
    }
    public String update(Anh g){
        String update="update Anh set  UrlImage=?,ten=? where id=?";
        
         try {
             pst=DB.getConnection().prepareStatement(update);
             pst.setBytes(1, g.getUrlImage());
             pst.setObject(2, g.getTen());
             pst.setObject(3, g.getId());
             pst.executeUpdate();
             return "Sửa ảnh thành công";
         } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(AnhRepository.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
             return "Sửa ảnh thất bại";
         }
    }
}
