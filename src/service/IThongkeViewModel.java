/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import ViewModel.ThongkeViewModel;
import java.util.Date;
import java.util.List;
import viewmodel.BieudoViewModel;
import viewmodel.ThongKeTable2;
import viewmodel.ThongKenowViewModel;

/**
 *
 * @author c
 */
public interface IThongkeViewModel {
    List<ThongkeViewModel> getall();
    
    List<ThongKeTable2> getalltable2();
    
    List<ThongKenowViewModel> showttday1();
    
    List<ThongKenowViewModel> showttday7();
    
    List<ThongKenowViewModel> showttday30();
    
    List<ThongKenowViewModel> showttcustom(Date date1,Date date2);
    
    List<ThongKenowViewModel> showhoadoncustom(Date date1,Date date2);
    
    List<ThongKenowViewModel> showtthoadonday1();
    
    List<ThongKenowViewModel> showtthoadonday7();
    
    List<ThongKenowViewModel> showtthoadonday30();
    
    List<BieudoViewModel> showttbieudo();
    
    List<BieudoViewModel> showttbieudo2021();
    
    List<BieudoViewModel> showdoanhthu2022();
    
    List<BieudoViewModel> showtime2022();
    
    List<BieudoViewModel> showdoanhtu2020();
    
    List<BieudoViewModel> showtime2020();
    
    List<BieudoViewModel> showdoanhtu2019();
    
    List<BieudoViewModel> showdoanhtu2018();
}
