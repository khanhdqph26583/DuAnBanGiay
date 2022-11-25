/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import domainmodel.Anh;
import java.util.List;
import service.IAnhService;
import repository.AnhRepository;
/**
 *
 * @author Admin
 */
public class AnhService implements IAnhService{
    AnhRepository anhRepository=new AnhRepository();

    public AnhService() {
    }
    @Override
    public List<Anh> getListAnh(){
        return anhRepository.getListAnh();
    }
    public String themAnh(Anh a){
        return anhRepository.themAnh(a);
    }
    public String SuaAnh(Anh anh){
        return anhRepository.SuaAnh( anh);
    }
     public String XoaAnh(String id){
         return anhRepository.XoaAnh(id);
     }
}
