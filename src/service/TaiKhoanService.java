/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.TaiKhoan;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public boolean updateMK(String tk) {
        try {
            return taiKhoanRepository.updateMK(tk);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean dangKi(TaiKhoan tk) {
        try {
            return taiKhoanRepository.dangKi(tk);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    public String checkEmail(String username, String email) throws SQLException {
        TaiKhoan taiKhoan = taiKhoanRepository.getAccountByUserName(username);
        if (taiKhoan != null) {
            if (taiKhoan.getEmail().equals(email)) {
                return "true";
            } else {
                return "sai email";
            }
        } else {
            return "không tồn tại";
        }

    }
}
