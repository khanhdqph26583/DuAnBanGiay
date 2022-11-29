/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.util.Vector;

/**
 *
 * @author Admin
 */
public class Size {

    private String id;
    private String ma;
    private Integer soSize;

    public Size() {
    }

    public Size(String id, String ma, Integer soSize) {
        this.id = id;
        this.ma = ma;
        this.soSize = soSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Integer getSoSize() {
        return soSize;
    }

    public void setSoSize(Integer soSize) {
        this.soSize = soSize;
    }

<<<<<<< HEAD
    public Object[] todatatable() {
        return new Object[]{id, ma, soSize};
    }
    
=======
    
    @Override
    public String toString() {
        return "" + soSize + "";
    }

   

    



>>>>>>> 8e2328f44792158f5a4708fc67d6bea3cf39cba0
}
