/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Anh;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IAnhService {

    public List<Anh> getListAnh();

    public String themAnh(Anh a);

    public String SuaAnh( Anh anh);

    public String XoaAnh(String id);
}
