/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.TaiKhoan;
import java.sql.SQLException;
import java.util.List;
import repository.TaiKhoanRepository;

/**
 *
 * @author Admin
 */
public class TaiKhoanService {

    private final TaiKhoanRepository taiKhoanRepository = new TaiKhoanRepository();

    public List<TaiKhoan> getLog() throws SQLException {
        return taiKhoanRepository.getLogin();
    }

    public boolean xacThuc(String username, String password) throws SQLException {
        TaiKhoan taiKhoan = taiKhoanRepository.getAccountByUserName(username);
        if (taiKhoan != null) {
            return taiKhoan.getPassword().equals(password);
        }
        return false;
    }
}
