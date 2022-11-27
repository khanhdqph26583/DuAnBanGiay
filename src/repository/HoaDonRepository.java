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
import viewmodel.bangSPinHoaDon;
import viewmodel.HoaDonChiTiet;
import viewmodel.GioHang;
import domainmodel.KhuyenMai;

/**
 *
 * @author Admin
 */
public class HoaDonRepository {

    DBConnection dbConnection;
    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst = null;
    List<bangSPinHoaDon> listSP = null;
    List<HoaDonChiTiet> listHDCT = null;
    List<GioHang> listGH = null;
    List<KhuyenMai> listKM = null;

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

    public Integer addHoaDon2(HoaDon hd) {
        Integer ketQua = -1;
        try {
            Connection connection = DBConnection.getConnection();
            String sql = "update hoadon set ngaytao=?,tongtien=?,sdt=?,GHICHU=?,TenKH=?,MaKM=?,MaNV=? where mahd=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(8, hd.getMaHD());
            ps.setDate(1, new Date(hd.getNgayTao().getTime()));
            ps.setBigDecimal(2, hd.getTongTien());
            ps.setString(3, hd.getSdt());
            ps.setString(4, hd.getGhiChu());
            ps.setString(5, hd.getTenKH());
            ps.setString(6, hd.getMaKM());
            ps.setString(7, hd.getMaNV());

            ketQua = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    public List<bangSPinHoaDon> getSP() {
        listSP = new ArrayList<>();
        try {
            String sql = "select a.ma, a.ten,e.ten,c.Ten,i.SoSize,b.Gia,b.SoLuong,MoTa from SanPham a join ChiTietSP b on a.Id=b.IdSP\n"
                    + "join MauSac c on c.Id=b.IdMauSac\n"
                    + "join DanhMuc d on d.MaDanhMuc=b.MaDanhMuc\n"
                    + "join DongSP e on e.Id=b.IdDongSP\n"
                    + "join Size i on i.Id=b.IdSize";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                bangSPinHoaDon b = new bangSPinHoaDon();
                b.setMaSP(rs.getString(1));
                b.setTenSP(rs.getString(2));
                b.setHang(rs.getString(3));
                b.setMauSac(rs.getString(4));
                b.setSize(rs.getInt(5));
                b.setGia(rs.getFloat(6));
                b.setSoLuong(rs.getInt(7));
                b.setMoTa(rs.getString(8));

                listSP.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listSP;
    }

    public List<HoaDonChiTiet> getHD() {
        listHDCT = new ArrayList<>();
        try {
            String sql = "select a.mahd,tenkh,d.Ten,b.SoLuong,a.MaNV,ngaytao,TongTien,a.TienCanTra,TienKhachDua,TienThua,a.TRANGTHAI\n"
                    + "from HOADON a join HoaDonChiTiet b on a.MaHD=b.MaHD\n"
                    + "join ChiTietSP c on c.Id=b.IdChiTietSP\n"
                    + "join SanPham d on d.Id=c.IdSP";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet b = new HoaDonChiTiet();
                b.setMaHD(rs.getString(1));
                b.setTenKH(rs.getString(2));
                b.setTenSP(rs.getString(3));
                b.setSl(rs.getInt(4));
                b.setMaNV(rs.getString(5));
                b.setNgayTao(rs.getDate(6));
                b.setTongTien(rs.getDouble(7));
                b.setTienCanTra(rs.getDouble(8));
                b.setTienKhachDua(rs.getDouble(9));
                b.setTIenThua(rs.getDouble(10));
                b.setTrangThai(rs.getInt(11));

                listHDCT.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHDCT;
    }

    public List<GioHang> getGH() {
        listGH = new ArrayList<>();
        try {
            String sql = "select d.Ten,j.Ten,e.Ten,f.SoSize,b.SoLuong,b.SoLuong*Gia from GioHang a left join GioHangChiTiet b on a.id=b.IdGioHang\n"
                    + "   left join ChiTietSP c on c.id=b.IdChiTietSP\n"
                    + "   left join SanPham d  on d.id=c.IdSP\n"
                    + "   left join MauSac e on e.id=c.IdMauSac\n"
                    + "	  left join DongSP j on j.Id=c.IdDongSP\n"
                    + "   left join Size f on f.Id=c.IdSize";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                GioHang b = new GioHang();
                b.setTenSP(rs.getString(1));
                b.setHang(rs.getString(2));
                b.setMauSac(rs.getString(3));
                b.setSize(rs.getInt(4));
                b.setSoLuong(rs.getInt(5));
                b.setGia(rs.getFloat(6));

                listGH.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGH;
    }

    public List<GioHang> ClickHd(String ma) {
        listGH = new ArrayList<>();
        try {
            String sql = "select d.Ten,e.Ten,m.Ten,f.SoSize,b.SoLuong,c.gia from HOADON a join HoaDonChiTiet b on a.MaHD=b.MaHD\n"
                    + "join ChiTietSP c on c.id=b.IdChiTietSP\n"
                    + "join SanPham d on d.Id=c.IdSP\n"
                    + "join DongSP e on e.Id =c.IdDongSP\n"
                    + "join Size f on f.Id=c.IdSize\n"
                    + "join MauSac m on m.Id=c.IdMauSac\n"
                    + "where a.MaHD=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setObject(1, ma);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                GioHang b = new GioHang();
                b.setTenSP(rs.getString(1));
                b.setHang(rs.getString(2));
                b.setMauSac(rs.getString(3));
                b.setSize(rs.getInt(4));
                b.setSoLuong(rs.getInt(5));
                b.setGia(rs.getFloat(6));
                listGH.add(b);

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGH;
    }

    public void ClickSpVaoHd(String masp) {
        try {

            String sql = "if exists(select*from GioHang where MaGH='GH')\n"
                    + "begin\n"
                    + "print 'chua co'\n"
                    + "end\n"
                    + "else\n"
                    + "begin\n"
                    + " insert into GioHang(MaGH) values('GH')\n"
                    + "end"
                    + " declare @giohang table (ma nvarchar(50) ,soluong nvarchar(50))\n"
                    + " insert into @giohang  select d.Ma,b.SoLuong from GioHang a left join GioHangChiTiet b on a.id=b.IdGioHang\n"
                    + " left join ChiTietSP c on c.id=b.IdChiTietSP\n"
                    + " left join SanPham d  on d.id=c.IdSP\n"
                    + " left join MauSac e on e.id=c.IdMauSac;\n"
                    + "  select*from @giohang		\n"
                    + "					\n"
                    + "  if exists(select*from @giohang where ma=? )\n"
                    + "                    begin\n"
                    + "                    declare @gan1 UNIQUEIDENTIFIER,@gan2 UNIQUEIDENTIFIER\n"
                    + "                    set @gan1=(select Id from SanPham where Ma=?)\n"
                    + "                    set  @gan2=(select Id from ChiTietSP where IdSP=@gan1)\n"
                    + "                    update GioHangChiTiet set SoLuong=SoLuong+1 where IdChiTietSP=@gan2\n"
                    + "                     update ChiTietSP set SoLuong=SoLuong-1 where IdSP=@gan1 \n"
                    + "                    end\n"
                    + "                    else\n"
                    + "                    begin\n"
                    + "                    declare @gan3 UNIQUEIDENTIFIER,@gan4 UNIQUEIDENTIFIER,@gan5 UNIQUEIDENTIFIER\n"
                    + "                    set @gan3=(select Id from SanPham where Ma=?)\n"
                    + "                    set @gan4=(select Id from GioHang where MaGH='GH')\n"
                    + "                    set  @gan5=(select Id from ChiTietSP where IdSP=@gan3)\n"
                    + "                    insert into GioHangChiTiet(IdGioHang,IdChiTietSP,SoLuong) values(@gan4,@gan5,1)\n"
                    + "                    update ChiTietSP set SoLuong=SoLuong-1 where IdSP=@gan3 \n"
                    + "                    end";
            pst = dbConnection.getConnection().prepareStatement(sql);
            pst.setObject(1, masp);
            pst.setObject(2, masp);
            pst.setObject(3, masp);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public List<KhuyenMai> getKM() {
        listKM = new ArrayList<>();
        try {
            String sql = "select*from khuyenmai";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                KhuyenMai b = new KhuyenMai();
                b.setMaKM(rs.getString(1));
                b.setTenKM(rs.getString(2));
                b.setSoTienGiam(rs.getDouble(3));
                b.setNgayBD(rs.getDate(4));
                b.setNgayKT(rs.getDate(5));
                b.setTrangThai(rs.getInt(6));

                listKM.add(b);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKM;
    }

    public void getKMsoTienGiam(String ma) {
        listKM = new ArrayList<>();
        try {
            String sql = "select SoTienGiam from KhuyenMai\n"
                    + "where MaKM=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setObject(1, ma);
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void bttaoGH() {
        try {
            String delete = "delete from GioHangChiTiet\n"
                    + "delete from GioHang";

            pst = dbConnection.getConnection().prepareStatement(delete);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void xoaSPkhoiGH(String ten, int sl) {
        try {
            String delete = "declare @idSP UNIQUEIDENTIFIER,@idctsp UNIQUEIDENTIFIER\n"
                    + "	set @idsp=(select id from sanpham where ten=?)\n"
                    + "	set @idctsp=(select id from ChiTietSP where idsp=@idsp)\n"
                    + "	delete GIOHANGCHITIET where IdChiTietSP=@idctsp\n"
                    + "	update ChiTietSP set SoLuong=SoLuong + ?\n"
                    + "                    	where IdSP=@idsp";

            pst = dbConnection.getConnection().prepareStatement(delete);
            pst.setObject(1, ten);
            pst.setObject(2, sl);

            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void Themhd(HoaDonChiTiet v) {
        try {
            String insert
                    = " insert into  HoaDon(MaHD,NgayTao,TongTien,SDT,TenKH,MaKM,MaNV,TienCanTra,TienKhachDua,TienThua,TRANGTHAI) \n"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)";
            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, v.getMaHD());
            pst.setObject(2, v.getNgayTao());
            pst.setObject(3, v.getTongTien());
            pst.setObject(4, v.getSDT());
            pst.setObject(5, v.getTenKH());
            pst.setObject(6, v.getMaKM());
            pst.setObject(7, v.getMaNV());
            pst.setObject(8, v.getTienCanTra());
            pst.setObject(9, v.getTienKhachDua());
            pst.setObject(10, v.getTIenThua());
            pst.setObject(11, v.getTrangThai());
            listHDCT.add(v);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void Themhdct(String masp, String mahd, int sl) {
        try {
            String insert = "declare @idspct UNIQUEIDENTIFIER\n"
                    + "                    \n"
                    + " set @idspct=(select b.Id from SanPham a join ChiTietSP b on a.Id=b.IdSP where a.Ten=?)\n"
                    + " insert into HoaDonChiTiet(MaHD,IdChiTietSP,SoLuong) values (?,@idspct,?)";

            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, masp);
            pst.setObject(2, mahd);
            pst.setObject(3, sl);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public void ThanhToanCho(double tienKD, double tienThua, String mahd) {
        try {
            String insert = "update hoadon set TienKhachDua=?, TienThua=?,TRANGTHAI=2\n"
                    + "where MaHD=?";

            pst = dbConnection.getConnection().prepareStatement(insert);
            pst.setObject(1, tienKD);
            pst.setObject(2, tienThua);
            pst.setObject(3, mahd);

            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public String HuyHD(String ten, int sl) {
        try {
            String delete = "	declare @idSP UNIQUEIDENTIFIER\n"
                    + "	set @idSP=(select Id from sanpham where Ten=?)\n"
                    + "	update ChiTietSP set SoLuong=SoLuong + ?\n"
                    + "	where IdSP=@idsp";
            pst = dbConnection.getConnection().prepareStatement(delete);
            pst.setObject(1, ten);
            pst.setObject(2, sl);

            pst.executeUpdate();
            return "Huy thanh cong";
        } catch (SQLException ex) {

            Logger.getLogger(HoaDonRepository.class.getName()).log(Level.SEVERE, null, ex);
            return "Huy that bai";
        }

    }

    public static void main(String[] args) {
        List<HoaDonChiTiet> list = new HoaDonRepository().getHD();
        for (HoaDonChiTiet sPinHoaDon : list) {
            System.out.println(sPinHoaDon.toString());
        }
    }

}
