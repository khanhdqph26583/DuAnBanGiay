/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.DanhMuc;
import domainmodel.DongSP;
import domainmodel.MauSac;
import domainmodel.Size;
import java.awt.Image;
import java.math.BigDecimal;

/**
 *
 * @author PC DUNG
 */
public class SanphamProduct {
    private String idSp;
    private String tensp;
    private byte[] anh;
    private String moTa;
    private Double gia;
    private String idSize;
    private String idMausac;
    private String idDongsp;
    private String maDanhmuc;
    private int thoiGianBH;
    private int soluong;

 
    
     public SanphamProduct() {
    }

    public SanphamProduct(String moTa, Double gia, String idSize, String idMausac, String idDongsp, String maDanhmuc, int thoiGianBH, int soluong) {
        this.moTa = moTa;
        this.gia = gia;
        this.idSize = idSize;
        this.idMausac = idMausac;
        this.idDongsp = idDongsp;
        this.maDanhmuc = maDanhmuc;
        this.thoiGianBH = thoiGianBH;
        this.soluong = soluong;
    }

 

     
    public SanphamProduct(String idSp, String tensp, byte[] anh, String moTa, Double gia, String idSize, String idMausac, String idDongsp, String maDanhmuc, int thoiGianBH, int soluong) {
        this.idSp = idSp;
        this.tensp = tensp;
        this.anh = anh;
        this.moTa = moTa;
        this.gia = gia;
        this.idSize = idSize;
        this.idMausac = idMausac;
        this.idDongsp = idDongsp;
        this.maDanhmuc = maDanhmuc;
        this.thoiGianBH = thoiGianBH;
        this.soluong = soluong;
    }

   

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
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

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdMausac() {
        return idMausac;
    }

    public void setIdMausac(String idMausac) {
        this.idMausac = idMausac;
    }

    public String getIdDongsp() {
        return idDongsp;
    }

    public void setIdDongsp(String idDongsp) {
        this.idDongsp = idDongsp;
    }

    public String getMaDanhmuc() {
        return maDanhmuc;
    }

    public void setMaDanhmuc(String maDanhmuc) {
        this.maDanhmuc = maDanhmuc;
    }

    public int getThoiGianBH() {
        return thoiGianBH;
    }

    public void setThoiGianBH(int thoiGianBH) {
        this.thoiGianBH = thoiGianBH;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

   
    

    
   
    
    
}
