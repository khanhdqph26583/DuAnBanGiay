/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

/**
 *
 * @author Admin
 */
public class Anh {

    private String id;
    private byte[] urlImage;
    private String ten;

    public Anh() {
    }

    public Anh(String id, byte[] urlImage, String ten) {
        this.id = id;
        this.urlImage = urlImage;
        this.ten = ten;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(byte[] urlImage) {
        this.urlImage = urlImage;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
