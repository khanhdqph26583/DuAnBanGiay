/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Anh;
import domainmodel.ChiTietSP;
import domainmodel.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.SanphamService;
import utilities.DBConnection;
import viewmodel.SanphamProduct;
import repository.AnhRepository;

/**
 *
 * @author Admin
 */
public class SanPhamRepository {

    DBConnection DB;
    List<SanphamProduct> listSanpham = null;
    List<Anh> listAnh = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public List<SanphamService> get;

    public ArrayList<SanphamProduct> getListSP() {

        listSanpham = new ArrayList<>();
        String sql = "select sanpham.Ma,SanPham.ten,\n"
                + "anh.UrlImage,mota,gia,size.sosize,mausac.ten,dongsp.ten,danhmuc.ten,thoigianbh,soluong,trangthai \n"
                + "\n"
                + "from chitietsp\n"
                + "join sanpham on sanpham.id=chitietsp.IdSP\n"
                + "join DongSP on DongSP.Id=ChiTietSP.IdDongSP\n"
                + "join size on size.id=chitietsp.IdSize\n"
                + "join danhmuc on danhmuc.madanhmuc=chitietsp.madanhmuc\n"
                + "join mausac on mausac.id=chitietsp.IdMauSac\n"
                + "left join anh on anh.id=chitietsp.IdAnh";

        try {
            pst = DB.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                SanphamProduct sp = new SanphamProduct();
                sp.setIdSp(rs.getString(1));
                sp.setTensp(rs.getString(2));
                sp.setAnh(rs.getBytes(3));
                sp.setMoTa(rs.getNString(4));
                sp.setGia(rs.getDouble(5));
                sp.setIdSize(rs.getString(6));
                sp.setIdMausac(rs.getNString(7));
                sp.setIdDongsp(rs.getNString(8));
                sp.setMaDanhmuc(rs.getNString(9));
                sp.setThoiGianBH(rs.getInt(10));
                sp.setSoluong(rs.getInt(11));
                sp.setTrangThai(rs.getInt(12));
                listSanpham.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SanphamProduct>) listSanpham;
    }

    public String insert(SanPham a, SanphamProduct c) {
        listSanpham = new ArrayList<>();

        listAnh = new ArrayList<>();
        String insert
                = "declare @idanh Uniqueidentifier\n"
                + "set @idanh=(select id from anh where ten=?)"
                + "insert into SANPHAM(Ma,Ten) values(?,?)"
                + "declare @idsp Uniqueidentifier\n"
                + "set @idsp =(select id from SanPham where Ma=?)\n"
                + "insert into chitietSP (Idsp,IdSize,IdMauSac,IdDongSP,idAnh,MaDanhMuc,ThoiGianBH,soluong,Gia,trangthai) values"
                + "(@idsp,?,?,?,@idanh,?,?,?,?,?)";

        try {
            pst = DB.getConnection().prepareStatement(insert);
            pst.setObject(1, a.getTen());

            pst.setObject(2, a.getMa());
            pst.setObject(3, a.getTen());
            pst.setObject(4, a.getMa());
            pst.setObject(5, c.getIdSize());
            pst.setObject(6, c.getIdMausac());
            pst.setObject(7, c.getIdDongsp());
            pst.setObject(8, c.getMaDanhmuc());
            pst.setObject(9, c.getThoiGianBH());
            pst.setObject(10, c.getSoluong());
            pst.setObject(11, c.getGia());
            pst.setObject(12, c.getTrangThai());

//            pst.setObject(12, c.getTrangThai());
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
    }

    public String delete(String masp) {
        String delete = "declare  @idsp UNIQUEIDENTIFIER\n"
                + "  set @idsp = (select Id from SanPham where Ma=?)\n"
                + "   delete from ChiTietSP where IdSP=@idsp\n"
                + "  delete from SanPham where Ma=?";
        try {
            pst=DB.getConnection().prepareStatement(delete);
             pst.setObject(1, masp);
            pst.setObject(2, masp);
            pst.executeUpdate();
            return "Xoa thành công";
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Xoa thất bại";
        }
    }

//    
    public String update(String ma, SanPham b, SanphamProduct d) {
        String update = "declare @idanh Uniqueidentifier\n"
                + "    set @idanh =(select id from anh where ten=?)"
                + "declare @idsp Uniqueidentifier\n"
                + "    set @idsp =(select id from SanPham where Ma=?)\n"
                + "	update SANPHAM set Ma=?,Ten=? where id=@idsp\n"
                + "  update chitietSP set IdSize=?,IdMauSac=?,IdDongSP=?,idAnh=?,MaDanhMuc=?"
                + ",ThoiGianBH=?,soluong=?,Gia=?,trangthai=? where idSp=@idsp";

        try {
            pst = DB.getConnection().prepareStatement(update);
            pst.setObject(1, b.getTen());
            pst.setObject(2, ma);

            pst.setObject(3, b.getMa());
            pst.setObject(4, b.getTen());
            pst.setObject(5, d.getIdSize());
            pst.setObject(6, d.getIdMausac());
            pst.setObject(7, d.getIdDongsp());
            pst.setObject(8, d.getMaDanhmuc());
            pst.setObject(9, d.getThoiGianBH());
            pst.setObject(10, d.getSoluong());
            pst.setObject(11, d.getGia());
            pst.setObject(12, d.getTrangThai());
            pst.executeUpdate();
            return "Sửa thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Sửa thất bại";
        }
    }
//      public String update(String ma,SanPham a) {
//        String update = ""
//                + "declare @idsp Uniqueidentifier\n"
//                + "    set @idsp =(select id from SanPham where Ma=?)\n"
//                + "	update SANPHAM set Ma=?,Ten=? where id=@idsp\n";
//              
//        
//        try {
//            pst=DB.getConnection().prepareStatement(update);
//             pst.setObject(1, ma);
//       
//           
//            pst.setObject(2, a.getMa());
//            pst.setObject(3, a.getTen());
//           
//            pst.executeUpdate();
//            return "Sửa thanh cong";
//        } catch (SQLException ex) {
//            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
//            return "Sửa thất bại";
//        }
//    }

    public static void main(String[] args) {
        for (SanphamProduct arg : new SanPhamRepository().getListSP()) {
            System.out.println(arg);
        }
    }

}
