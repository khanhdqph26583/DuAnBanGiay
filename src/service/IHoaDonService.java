/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.HoaDon;
import java.util.List;
import viewmodel.GioHang;
import viewmodel.bangSPinHoaDon;
import viewmodel.HoaDonChiTiet;

/**
 *
 * @author Admin
 */
public interface IHoaDonService {

    public List<HoaDon> view();

    public Integer add(HoaDon hd);

    public List<bangSPinHoaDon> getSP();

    public List<HoaDonChiTiet> getHD();

    public void ClickSpVaoHd(String masp);

    public Integer addHoaDon2(HoaDon hd);

    public void bttaoGH();
    public List<GioHang> getGH();
}
