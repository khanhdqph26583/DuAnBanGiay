/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.SanPham;
import java.sql.*;
import java.util.ArrayList;
import utilities.DBConnection;
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

                listSanpham.add(sp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<SanphamProduct>) listSanpham;
    }

    public String insert ( SanPham a, SanphamProduct c) {
        listSanpham = new ArrayList<>();

        listAnh = new ArrayList<>();
        String insert = 
                 "declare @idanh Uniqueidentifier\n"
                + "set @idanh=(select id from anh where ten=?)"
                + "insert into SANPHAM(Ma,Ten) values(?,?)"
                + "declare @idsp Uniqueidentifier\n"
                + "set @idsp =(select id from SanPham where Ma=?)\n"
                + "insert into chitietSP (Idsp,IdSize,IdMauSac,IdDongSP,idAnh,MaDanhMuc,ThoiGianBH,soluong,Gia) values"
                + "(@idsp,?,?,?,@idanh,?,?,?,?)";

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
            
            pst.executeUpdate();
            return "Thanh cong";
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "That bai";
        }
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
