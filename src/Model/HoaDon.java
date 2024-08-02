package Model;

import java.util.Date;
import java.util.List;

public class HoaDon {

    private int hoaDonId;
    private int nguoiDungId;
    private String TenKH;
    private String Sdt;
    private String DiaChi;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int PTTT;
    private int TongTien;
    private int trangThai;
    private List<HoaDonChiTiet> hoaDonChiTietList; // Danh sách chi tiết hóa đơn

    public HoaDon() {
    }

    public HoaDon(int hoaDonId, int nguoiDungId, String TenKH, String Sdt, String DiaChi, Date ngayTao, Date ngayThanhToan, int PTTT, int TongTien, int trangThai) {
        this.hoaDonId = hoaDonId;
        this.nguoiDungId = nguoiDungId;
        this.TenKH = TenKH;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.PTTT = PTTT;
        this.TongTien = TongTien;
        this.trangThai = trangThai;
    }

    public HoaDon(int hoaDonId, int nguoiDungId, String TenKH, String Sdt, String DiaChi, Date ngayTao, Date ngayThanhToan, int PTTT, int TongTien, int trangThai, List<HoaDonChiTiet> hoaDonChiTietList) {
        this.hoaDonId = hoaDonId;
        this.nguoiDungId = nguoiDungId;
        this.TenKH = TenKH;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.PTTT = PTTT;
        this.TongTien = TongTien;
        this.trangThai = trangThai;
        this.hoaDonChiTietList = hoaDonChiTietList;
    }

    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public int getNguoiDungId() {
        return nguoiDungId;
    }

    public void setNguoiDungId(int nguoiDungId) {
        this.nguoiDungId = nguoiDungId;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getPTTT() {
        return PTTT;
    }

    public void setPTTT(int PTTT) {
        this.PTTT = PTTT;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<HoaDonChiTiet> getHoaDonChiTietList() {
        return hoaDonChiTietList;
    }

    public void setHoaDonChiTietList(List<HoaDonChiTiet> hoaDonChiTietList) {
        this.hoaDonChiTietList = hoaDonChiTietList;
    }

}
