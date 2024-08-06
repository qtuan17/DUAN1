/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author tuanb
 */
public class ChiTietSua {

    private int id;
    private int TenSua;
    private int TenMau;
    private int TenLoai;
    private int TenHang;
    private int TenVi;
    private int HinhDang;
    private int TrangThai;
    private int Gia;
    private int soLuong;
    private Date HanSuDung;

    public ChiTietSua() {
    }

    public ChiTietSua(int id, int TenSua, int TenMau, int TenLoai, int TenHang, int TenVi, int HinhDang, int TrangThai, int Gia, int soLuong, Date HanSuDung) {
        this.id = id;
        this.TenSua = TenSua;
        this.TenMau = TenMau;
        this.TenLoai = TenLoai;
        this.TenHang = TenHang;
        this.TenVi = TenVi;
        this.HinhDang = HinhDang;
        this.TrangThai = TrangThai;
        this.Gia = Gia;
        this.soLuong = soLuong;
        this.HanSuDung = HanSuDung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTenSua() {
        return TenSua;
    }

    public void setTenSua(int TenSua) {
        this.TenSua = TenSua;
    }

    public int getTenMau() {
        return TenMau;
    }

    public void setTenMau(int TenMau) {
        this.TenMau = TenMau;
    }

    public int getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(int TenLoai) {
        this.TenLoai = TenLoai;
    }

    public int getTenHang() {
        return TenHang;
    }

    public void setTenHang(int TenHang) {
        this.TenHang = TenHang;
    }

    public int getTenVi() {
        return TenVi;
    }

    public void setTenVi(int TenVi) {
        this.TenVi = TenVi;
    }

    public int getHinhDang() {
        return HinhDang;
    }

    public void setHinhDang(int HinhDang) {
        this.HinhDang = HinhDang;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getHanSuDung() {
        return HanSuDung;
    }

    public void setHanSuDung(Date HanSuDung) {
        this.HanSuDung = HanSuDung;
    }
    
    
    
}
