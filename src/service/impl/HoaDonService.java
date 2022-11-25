/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.HoaDon;
import java.util.List;
import repository.HoaDonRepository;
import service.IHoaDonService;

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

}
