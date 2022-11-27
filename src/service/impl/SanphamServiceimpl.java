/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.Anh;
import domainmodel.ChiTietSP;
import domainmodel.SanPham;
import java.util.List;
import repository.SanPhamRepository;
import service.SanphamService;
import viewmodel.SanphamProduct;

/**
 *
 * @author PC DUNG
 */
public class SanphamServiceimpl implements SanphamService{

    SanPhamRepository repository=new SanPhamRepository();

    @Override
    public List<SanphamProduct> getAllSp() {
        return repository.getListSP();
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String insert( SanPham a, SanphamProduct c) {
        return repository.insert( a, c);
    }
    

  

  

 

  

   
    
    
   


   

  
  
    
}
