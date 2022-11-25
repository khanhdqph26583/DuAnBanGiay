/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author HP probook
 */
public class HoaDonChiTiet {

    private String maHD;
    private String TenKH;
    private String TenSP;
    private Date NgayTao;
    private BigDecimal TongTien;
    private BigDecimal TienCanTra;
    private BigDecimal TienKhachDua;
    private BigDecimal TIenThua;
    private int TrangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHD, String TenKH, String TenSP, Date NgayTao, BigDecimal TongTien, BigDecimal TienCanTra, BigDecimal TienKhachDua, BigDecimal TIenThua, int TrangThai) {
        this.maHD = maHD;
        this.TenKH = TenKH;
        this.TenSP = TenSP;
        this.NgayTao = NgayTao;
        this.TongTien = TongTien;
        this.TienCanTra = TienCanTra;
        this.TienKhachDua = TienKhachDua;
        this.TIenThua = TIenThua;
        this.TrangThai = TrangThai;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public BigDecimal getTongTien() {
        return TongTien;
    }

    public void setTongTien(BigDecimal TongTien) {
        this.TongTien = TongTien;
    }

    public BigDecimal getTienCanTra() {
        return TienCanTra;
    }

    public void setTienCanTra(BigDecimal TienCanTra) {
        this.TienCanTra = TienCanTra;
    }

    public BigDecimal getTienKhachDua() {
        return TienKhachDua;
    }

    public void setTienKhachDua(BigDecimal TienKhachDua) {
        this.TienKhachDua = TienKhachDua;
    }

    public BigDecimal getTIenThua() {
        return TIenThua;
    }

    public void setTIenThua(BigDecimal TIenThua) {
        this.TIenThua = TIenThua;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    public String TrangThai(){
        if(this.getTrangThai()==1){
            return "ĐÃ TT";
        }
        if(this.getTrangThai()==0){
            return "ĐÃ HỦY";
        }else{
            return "CHỜ TT";
        }
    }

  

}
