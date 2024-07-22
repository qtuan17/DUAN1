/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tuanb
 */
public class HinhDang {
    private int id;
    private String HinhDang;
    private int TrangThai;

    public HinhDang() {
    }

    public HinhDang(int id, String HinhDang, int TrangThai) {
        this.id = id;
        this.HinhDang = HinhDang;
        this.TrangThai = TrangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHinhDang() {
        return HinhDang;
    }

    public void setHinhDang(String HinhDang) {
        this.HinhDang = HinhDang;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
