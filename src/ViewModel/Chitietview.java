/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import java.util.Date;

/**
 *
 * @author tuanb
 */
public class Chitietview {

    private int id;
    private String TenSua;
    private String TenMau;
    private String TenLoai;
    private String TenHang;
    private String TenVi;
    private String HinhDang;
    private int Gia;
    private int SoLuong;
    private Date HanSuDung;
    private int TrangThai;

    public Chitietview() {
    }

    public Chitietview(int id, String TenSua, String TenMau, String TenLoai, String TenHang, String TenVi, String HinhDang, int Gia, int SoLuong, Date HanSuDung, int TrangThai) {
        this.id = id;
        this.TenSua = TenSua;
        this.TenMau = TenMau;
        this.TenLoai = TenLoai;
        this.TenHang = TenHang;
        this.TenVi = TenVi;
        this.HinhDang = HinhDang;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.HanSuDung = HanSuDung;
        this.TrangThai = TrangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSua() {
        return TenSua;
    }

    public void setTenSua(String TenSua) {
        this.TenSua = TenSua;
    }

    public String getTenMau() {
        return TenMau;
    }

    public void setTenMau(String TenMau) {
        this.TenMau = TenMau;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String TenLoai) {
        this.TenLoai = TenLoai;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getTenVi() {
        return TenVi;
    }

    public void setTenVi(String TenVi) {
        this.TenVi = TenVi;
    }

    public String getHinhDang() {
        return HinhDang;
    }

    public void setHinhDang(String HinhDang) {
        this.HinhDang = HinhDang;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public Date getHanSuDung() {
        return HanSuDung;
    }

    public void setHanSuDung(Date HanSuDung) {
        this.HanSuDung = HanSuDung;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}
