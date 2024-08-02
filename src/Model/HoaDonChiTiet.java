package Model;

import java.util.Date;

public class HoaDonChiTiet {
    private int hoaDonChiTietId;
    private int suaId;
    private int hoaDonId;
    private int giaHienTai;
    private Date thoiGianDat;
    private int soLuong;

    public HoaDonChiTiet(int hoaDonChiTietId, int suaId, int hoaDonId, int giaHienTai, Date thoiGianDat, int soLuong) {
        this.hoaDonChiTietId = hoaDonChiTietId;
        this.suaId = suaId;
        this.hoaDonId = hoaDonId;
        this.giaHienTai = giaHienTai;
        this.thoiGianDat = thoiGianDat;
        this.soLuong = soLuong;
    }

    // Getters và Setters
    public int getHoaDonChiTietId() {
        return hoaDonChiTietId;
    }

    public void setHoaDonChiTietId(int hoaDonChiTietId) {
        this.hoaDonChiTietId = hoaDonChiTietId;
    }

    public int getSuaId() {
        return suaId;
    }

    public void setSuaId(int suaId) {
        this.suaId = suaId;
    }

    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public int getGiaHienTai() {
        return giaHienTai;
    }

    public void setGiaHienTai(int giaHienTai) {
        this.giaHienTai = giaHienTai;
    }

    public Date getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Date thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
