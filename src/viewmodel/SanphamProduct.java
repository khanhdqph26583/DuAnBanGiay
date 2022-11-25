/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.awt.Image;

/**
 *
 * @author PC DUNG
 */
public class SanphamProduct {
    private String idSp;
    private String tenSp;
    private byte[] anh;
    private String moTa;
    private Double gia;
    private int soSize;
    private String tenMausac;
    private String tenDongsp;
    private String tenDanhmuc;
    private int thoiGianBH;
    private int trangThai;

    public SanphamProduct() {
    }

    public SanphamProduct(String idSp, String tenSp, byte[] anh, String moTa, Double gia, int soSize, String tenMausac, String tenDongsp, String tenDanhmuc, int thoiGianBH, int trangThai) {
        this.idSp = idSp;
        this.tenSp = tenSp;
        this.anh = anh;
        this.moTa = moTa;
        this.gia = gia;
        this.soSize = soSize;
        this.tenMausac = tenMausac;
        this.tenDongsp = tenDongsp;
        this.tenDanhmuc = tenDanhmuc;
        this.thoiGianBH = thoiGianBH;
        this.trangThai = trangThai;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getGia() {
        return gia;
    }

    public void setGia(Double gia) {
        this.gia = gia;
    }

    public int getSoSize() {
        return soSize;
    }

    public void setSoSize(int soSize) {
        this.soSize = soSize;
    }

    public String getTenMausac() {
        return tenMausac;
    }

    public void setTenMausac(String tenMausac) {
        this.tenMausac = tenMausac;
    }

    public String getTenDongsp() {
        return tenDongsp;
    }

    public void setTenDongsp(String tenDongsp) {
        this.tenDongsp = tenDongsp;
    }

    public String getTenDanhmuc() {
        return tenDanhmuc;
    }

    public void setTenDanhmuc(String tenDanhmuc) {
        this.tenDanhmuc = tenDanhmuc;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    
   
    
    
}
