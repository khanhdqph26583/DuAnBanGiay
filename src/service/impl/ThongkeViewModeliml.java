/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import ViewModel.ThongkeViewModel;
import java.util.List;
import repository.ThongkeRepositoty;
import service.IThongkeViewModel;

/**
 *
 * @author c
 */
public class ThongkeViewModeliml implements IThongkeViewModel{

    ThongkeRepositoty rp=new ThongkeRepositoty();
    
    @Override
    public List<ThongkeViewModel> getall() {
        return rp.getall();
    }
    
}
