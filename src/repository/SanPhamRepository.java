/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Anh;
import domainmodel.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;
import viewmodel.SanphamProduct;

/**
 *
 * @author Admin
 */
public class SanPhamRepository {

    DBConnection DB;
    List<SanphamProduct> listSanpham = null;
//    List<Anh> listAnh=null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public ArrayList<SanphamProduct> getListSP() {

        listSanpham = new ArrayList<>();
        String sql = "select sanpham.Ma,SanPham.ten,anh.UrlImage,mota,gia,size.sosize,mausac.ten,dongsp.ten,danhmuc.ten,thoigianbh,trangthai from chitietsp\n"
                + "join size on size.id=chitietsp.id\n"
                + "join anh on anh.id=chitietsp.id\n"
                + "join danhmuc on danhmuc.madanhmuc=chitietsp.madanhmuc\n"
                + "join sanpham on sanpham.id=chitietsp.id\n"
                + "join mausac on mausac.id=chitietsp.id\n"
                + "join DongSP on DongSP.Id=ChiTietSP.id";

        try {
            pst = DB.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SanphamProduct sp = new SanphamProduct();
                sp.setIdSp(rs.getString(1));
                sp.setTenSp(rs.getNString(2));
                sp.setAnh(rs.getBytes(3));
                sp.setMoTa(rs.getNString(4));
                sp.setGia(rs.getDouble(5));
                sp.setSoSize(rs.getInt(6));
                sp.setTenMausac(rs.getNString(7));
                sp.setTenDongsp(rs.getNString(8));
                sp.setTenDanhmuc(rs.getNString(9));
                sp.setThoiGianBH(rs.getInt(10));
                sp.setTrangThai(rs.getInt(11));
                 listSanpham.add(sp);
            }

           
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SanphamProduct>) listSanpham;
    }

    
    
//    public String themAnh(Anh a) {
//
//        String sql = "insert into anh(id,UrlImage,ten) values(newid(),?,?)";
//        try {
//            pst = DBConnection.getConnection().prepareStatement(sql);
//            pst.setBytes(1, a.getUrlImage());
//            pst.setString(2, a.getTen());
//
//            listAnh.add(a);
//            pst.executeUpdate();
//            return "Thêm thành công";
//        } catch (SQLException ex) {
//            Logger.getLogger(AnhRepository.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
//        return "Thêm thất bại";
//    }
//    public String add(SanphamProduct sp){
//        listSanpham=new ArrayList<>();
//        String sql="";
//    }
//    
    public static void main(String[] args) {
        for (SanphamProduct arg : new SanPhamRepository().getListSP()) {
            System.out.println(arg);
        }
    }

}
