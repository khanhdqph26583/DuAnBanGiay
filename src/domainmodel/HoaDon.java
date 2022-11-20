/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private String maHD;
    private Date ngayTao;
    private BigDecimal tongTien;
    private String sdt;
    private String ghiChu;
    private String tenKH;
    private String maKM;
    private String maNV;

    public HoaDon() {
    }

    public HoaDon(String maHD, Date ngayTao, BigDecimal tongTien, String sdt, String ghiChu, String tenKH, String maKM, String maNV) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tongTien = tongTien;
        this.sdt = sdt;
        this.ghiChu = ghiChu;
        this.tenKH = tenKH;
        this.maKM = maKM;
        this.maNV = maNV;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKH(String maKM) {
        this.maKM = maKM;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgayTao(String date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
