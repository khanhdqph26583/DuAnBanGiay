/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import ViewModel.ThongkeViewModel;
import domainmodel.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;

/**
 *
 * @author c
 */
public class ThongkeRepositoty {

    public List<ThongkeViewModel> getall() {
        String sql = "SELECT dbo.SanPham.Ma, dbo.SanPham.Ten, dbo.HoaDonChiTiet.SoLuong, dbo.HOADON.trangthai\n"
                + "FROM     dbo.HOADON INNER JOIN\n"
                + "                  dbo.HoaDonChiTiet ON dbo.HOADON.MaHD = dbo.HoaDonChiTiet.MaHD CROSS JOIN\n"
                + "                  dbo.SanPham";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            List<ThongkeViewModel> sp = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(new ThongkeViewModel(rs.getString(1), rs.getString(2), rs.getInt(3),rs.getString(4)));
            }
            rs.close();
            return sp;
        } catch (Exception e) {
        }
        return null;
    }
}
