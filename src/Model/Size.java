/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author tuanb
 */
public class Size {
    private int id;
    private String TenSize;
    private int TrangThai;

    public Size() {
    }

    public Size(int id, String TenSize, int TrangThai) {
        this.id = id;
        this.TenSize = TenSize;
        this.TrangThai = TrangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSize() {
        return TenSize;
    }

    public void setTenSize(String TenSize) {
        this.TenSize = TenSize;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
