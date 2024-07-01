/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tuanb
 */
public class TenSua {
    private int id;
    private String tenSua;
    private int trangThai;

    public TenSua() {
    }

    public TenSua(int id, String tenSua, int trangThai) {
        this.id = id;
        this.tenSua = tenSua;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSua() {
        return tenSua;
    }

    public void setTenSua(String tenSua) {
        this.tenSua = tenSua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
}
