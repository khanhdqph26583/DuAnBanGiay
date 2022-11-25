/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPham;
import java.sql.*;
import java.util.ArrayList;
import utilities.DBConnection;

/**
 *
 * @author Admin
 */
public class SanPhamRepository {

    public ArrayList<SanPham> getListSP() {
        ArrayList<SanPham> list = new ArrayList<>();
        String sql = "select SanPham.Ma, SanPham.Ten, Size.SoSize, MauSac.Ten, "
                + "DanhMuc.MoTa, ChiTietSP.Gia, ChiTietSP.TrangThai"
                + " from SanPham join ChiTietSP on SanPham.Id = ChiTietSP.IdSP "
                + "join Size on Size.Id = ChiTietSP.IdSize join MauSac on "
                + "MauSac.Id = ChiTietSP.IdMauSac"
                + " join DanhMuc on DanhMuc.MaDanhMuc = ChiTietSP.MaDanhMuc";
        try{
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            SanPham sanPham = new SanPham();
            sanPham.setMa(rs.getString("Ma"));
            sanPham.setTen(rs.getString("Ten"));
        }
        }catch(Exception e){
            e.getMessage();
        }
        return list;
    }
}
