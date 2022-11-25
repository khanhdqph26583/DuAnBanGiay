/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDon;
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
     public List<HoaDonChiTiet> getHD(){
         return hoaDonRepo.getHD();
     }
      public void ClickSpVaoHd(String masp){
           hoaDonRepo.ClickSpVaoHd(masp);
      }
       public void bttaoGH(){
           hoaDonRepo.bttaoGH();
       }
      public Integer addHoaDon2(HoaDon hd){
         return hoaDonRepo.addHoaDon2(hd);
      }
      public List<GioHang> getGH(){
         return hoaDonRepo.getGH();
     }
      

}
