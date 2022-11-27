/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDon;
import domainmodel.KhuyenMai;
import java.util.List;
import repository.HoaDonRepository;
import service.IHoaDonService;
import viewmodel.GioHang;
import viewmodel.HoaDonChiTiet;
import viewmodel.bangSPinHoaDon;

/**
 *
 * @author Admin
 */
public class HoaDonService implements IHoaDonService {
    
    private HoaDonRepository hoaDonRepo = new HoaDonRepository();
    
    @Override
    public List<HoaDon> view() {
        return hoaDonRepo.getAll();
    }
    
    @Override
    public Integer add(HoaDon hd) {
        return hoaDonRepo.addHoaDon(hd);
    }
    
    public List<bangSPinHoaDon> getSP() {
        return hoaDonRepo.getSP();
    }
    
    public List<HoaDonChiTiet> getHD() {
        return hoaDonRepo.getHD();
    }
    
    public void ClickSpVaoHd(String masp) {
        hoaDonRepo.ClickSpVaoHd(masp);
    }
    
    public void bttaoGH() {
        hoaDonRepo.bttaoGH();
    }
    
    public Integer addHoaDon2(HoaDon hd) {
        return hoaDonRepo.addHoaDon2(hd);
    }
    
    public List<GioHang> getGH() {
        return hoaDonRepo.getGH();
    }
    
    public void Themhd(HoaDonChiTiet v) {
        hoaDonRepo.Themhd(v);
    }
    
    public void Themhdct(String masp, String mahd, int sl) {
        hoaDonRepo.Themhdct(masp, mahd, sl);
    }
    
    public String HuyHD(String ten, int sl) {
        return hoaDonRepo.HuyHD(ten, sl);
    }

    public List<KhuyenMai> getKM() {
        return hoaDonRepo.getKM();
        
    }

    public void ThanhToanCho(double tienKD, double tienThua, String mahd) {
        hoaDonRepo.ThanhToanCho(tienKD, tienThua, mahd);
    }
     public void getKMsoTienGiam(String ma){
         hoaDonRepo.getKMsoTienGiam(ma);
     }
     public void xoaSPkhoiGH(String ten, int sl){
         hoaDonRepo.xoaSPkhoiGH(ten, sl);
     }
      public List<GioHang> ClickHd(String ma){
         return hoaDonRepo.ClickHd(ma);
      }
    
}
