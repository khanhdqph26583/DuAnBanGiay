/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.HoaDon;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DBConnection;

/**
 *
 * @author Admin
 */
public class HoaDonRepository {

    public List<HoaDon> getAll() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try {
            String sql = "SELECT * FROM HoaDon";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("MaHD");
                Date ngayTao = rs.getDate("NgayTao");
                BigDecimal tongTien = rs.getBigDecimal("TongTien");
                String sdt = rs.getString("SDT");
                String ghiChu = rs.getString("GHICHU");
                String tenKH = rs.getString("TenKH");
                String maKM = rs.getString("MaKM");
                String maNV = rs.getString("MaNV");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHD(maHD);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setTongTien(tongTien);
                hoaDon.setSdt(sdt);
                hoaDon.setGhiChu(ghiChu);
                hoaDon.setTenKH(tenKH);
                hoaDon.setMaKH(maKM);
                hoaDon.setMaNV(maNV);

                listHoaDon.add(hoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHoaDon;
    }

    public Integer addHoaDon(HoaDon hd) {
        Integer ketQua = -1;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "insert into HOADON(MaHD,NgayTao,TongTien,SDT,GHICHU,TenKH,MaKM,MaNV)values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setDate(2, new Date(hd.getNgayTao().getTime()));
            ps.setBigDecimal(3, hd.getTongTien());
            ps.setString(4, hd.getSdt());
            ps.setString(5, hd.getGhiChu());
            ps.setString(6, hd.getTenKH());
            ps.setString(7, hd.getMaKM());
            ps.setString(8, hd.getMaNV());

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }
}
