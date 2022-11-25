/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.KhuyenMai;
import java.util.List;
import repository.KhuyenMaiRepository;
import service.IKhuyenMaiService;

/**
 *
 * @author AS
 */
public class KhuyenMaiServiceImpl implements IKhuyenMaiService {

    private KhuyenMaiRepository khuyenMaiRepository = new KhuyenMaiRepository();

    @Override
    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.getAll();

    }

    @Override
    public Integer add(KhuyenMai khuyenMai) {
        return khuyenMaiRepository.add(khuyenMai);
    }

    @Override
    public Integer update(KhuyenMai khuyenMai, String maKM) {
        return khuyenMaiRepository.update(khuyenMai, maKM);
    }

    @Override
    public Integer delete(String maKM) {
        return khuyenMaiRepository.delete(maKM);
    }

}
