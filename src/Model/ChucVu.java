/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Set;

/**
 *
 * @author tuanb
 */

public class ChucVu {
    private int idCV;
    private String TenCV;
    private int TrangThai;

    public ChucVu() {
    }

    public ChucVu(int idCV, String TenCV, int TrangThai) {
        this.idCV = idCV;
        this.TenCV = TenCV;
        this.TrangThai = TrangThai;
    }

    public int getIdCV() {
        return idCV;
    }

    public void setIdCV(int idCV) {
        this.idCV = idCV;
    }

    public String getTenCV() {
        return TenCV;
    }

    public void setTenCV(String TenCV) {
        this.TenCV = TenCV;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    
}
