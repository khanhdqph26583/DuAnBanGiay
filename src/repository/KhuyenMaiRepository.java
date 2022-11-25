/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import domainmodel.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;

/**
 *
 * @author AS
 */
public class KhuyenMaiRepository {

    //Connection con = DBConnection.getConnection();
    ResultSet rs = null;
    PreparedStatement ps = null;

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> listKM = new ArrayList<>();
        String sql = "SELECT *FROM KhuyenMai";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setSoTienGiam(rs.getBigDecimal(3));
                km.setNgayBD(rs.getDate(4));
                km.setNgayKT(rs.getDate(5));
                km.setTrangThai(rs.getInt(6));
                listKM.add(km);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;

    }

    public Integer add(KhuyenMai khuyenMai) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "Insert into KhuyenMai(MaKM, TenKM, SoTienGiam, NgayBD, NgayKT, TrangThai) values (?,?,?,?,?,?)";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            khuyenMai.getMaKM();
            khuyenMai.getTenKM();
            khuyenMai.getSoTienGiam();
            khuyenMai.getNgayBD();
            khuyenMai.getNgayKT();
            khuyenMai.getTrangThai();
            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public Integer update(KhuyenMai khuyenMai, String maKM) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "Update KhuyenMaiSET TenKM=?, SoTienGiam=?, NgayBD=?, NgayKT=?, TrangThai=?)WHERE MaKM =?";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, khuyenMai.getTenKM());
            ps.setBigDecimal(2, khuyenMai.getSoTienGiam());
            ps.setDate(3, new Date(khuyenMai.getNgayBD().getTime()));
            ps.setDate(4, new Date(khuyenMai.getNgayKT().getTime()));
            ps.setInt(5, khuyenMai.getTrangThai());
            ps.setString(6, maKM);

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public Integer delete(String maKM) {
        Integer ketQua = -1;
        List<KhuyenMai> listKM = new ArrayList<>();

        String sql = "DELETE FROM KhuyenMai WHERE MaKM =?";
        try {
            Connection con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            KhuyenMai khuyenMai = new KhuyenMai();
            ps.setString(1, maKM);

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

}
