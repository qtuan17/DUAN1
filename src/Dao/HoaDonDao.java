package Dao;

import Model.HoaDon;
import Model.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author tuanb
 */
public class HoaDonDao {

    public PreparedStatement preparedStatement = null;
    public Connection connection = null;
    public ResultSet resultSet = null;

    public HoaDonDao() throws Exception {
        connection = util.DBContext.getConnection();
    }

    public List<HoaDon> getAllHoaDon() throws SQLException {
        List<HoaDon> hoaDons = new ArrayList<>();
        String query = "SELECT * FROM HoaDon WHERE TrangThai = 0";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon(
                        rs.getInt("HoaDon_ID"),
                        rs.getInt("NguoiDung_ID"),
                        rs.getString("TenKH"),
                        rs.getString("Sdt"),
                        rs.getString("DiaChi"),
                        rs.getDate("NgayTao"),
                        rs.getDate("NgayThanhToan"),
                        rs.getInt("PTTT"),
                        rs.getInt("TongTien"),
                        rs.getInt("TrangThai")
                );
                hoaDon.setHoaDonChiTietList(getHoaDonChiTietByHoaDonId(hoaDon.getHoaDonId()));
                hoaDons.add(hoaDon);
            }
        }
        return hoaDons;
    }

    public HoaDon getHoaDonById(int hoaDonId) throws SQLException {
        HoaDon hoaDon = null;
        String query = "SELECT * FROM HoaDon WHERE HoaDon_ID = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    hoaDon = new HoaDon(
                            rs.getInt("hoaDonId"),
                            rs.getInt("nguoiDungId"),
                            rs.getString("TenKH"),
                            rs.getString("Sdt"),
                            rs.getString("DiaChi"),
                            rs.getDate("ngayTao"),
                            rs.getDate("ngayThanhToan"),
                            rs.getInt("PTTT"),
                            rs.getInt("TongTien"),
                            rs.getInt("TrangThai")
                    );
                    hoaDon.setHoaDonChiTietList(getHoaDonChiTietByHoaDonId(hoaDonId));
                }
            }
        } catch (SQLException e) {
            System.out.println("lay chi tiet hoa don that bai: " + e);
        }
        return hoaDon;
    }

    public void addEmptyHoaDon() {
        try {
            long millis = System.currentTimeMillis();
            String query = "INSERT INTO HoaDon (NguoiDung_ID, NgayTao, NgayThanhToan, TrangThai) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, 1);
            pstmt.setDate(2, new java.sql.Date(millis));
            pstmt.setDate(3, new java.sql.Date(millis));
            pstmt.setInt(4, 0);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Loi tao hoa don" + e);
        }
    }

    public void addHoaDon(String tenKH, String sdt, String diaChi) {
        long millis = System.currentTimeMillis();
        String query = "INSERT INTO HoaDon (NguoiDung_ID, TenKH, sdt, DiaChi, NgayTao, TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, 1);
            pstmt.setString(2, tenKH);
            pstmt.setString(3, sdt);
            pstmt.setString(4, diaChi);
            pstmt.setDate(5, new java.sql.Date(millis));
            pstmt.setInt(6, 0);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Loi tao hoa don" + e);
        }
    }

    public void deleteHoaDon(int hoaDonId) throws SQLException {
        deleteHoaDonChiTietByHoaDonId(hoaDonId);
        String query = "DELETE FROM HoaDon WHERE HoaDon_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonId);
            pstmt.executeUpdate();
        }
    }

    private List<HoaDonChiTiet> getHoaDonChiTietByHoaDonId(int hoaDonId) throws SQLException {
        List<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        String query = "SELECT * FROM HoaDonChiTiet WHERE HoaDon_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(
                            rs.getInt("HoaDonChiTiet_ID"),
                            rs.getInt("Sua_ID"),
                            rs.getInt("HoaDon_ID"),
                            rs.getInt("GiaHienTai"),
                            rs.getDate("ThoiGianDat"),
                            rs.getInt("SoLuong")
                    );
                    hoaDonChiTiets.add(hoaDonChiTiet);
                }
            }
        }
        return hoaDonChiTiets;
    }

    public void updateHoaDon(int hoaDonId, int tongTien) {
        String query = "UPDATE HoaDon SET TrangThai = 1, TongTien = ? where HoaDon_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setInt(1, tongTien);
            pstmt.setInt(2, hoaDonId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("lỗi update hóa đơn: " + e);
        }
    }

    public boolean checkGioHang(int idHoaDon, int idSanPham) {
        String query = "SELECT * FROM HoaDonChiTiet WHERE HoaDon_ID = ? and Sua_ID = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, idHoaDon);
            pstmt.setInt(2, idSanPham);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("looix check gio hang: " + e);
            return false;
        }
    }

    public void addHoaDonChiTiet(int suaId, int hoaDonId, int gia) {
        long millis = System.currentTimeMillis();
        String query = "INSERT INTO HoaDonChiTiet (Sua_ID, HoaDon_ID, GiaHienTai, ThoiGianDat, SoLuong) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, suaId);
            pstmt.setInt(2, hoaDonId);
            pstmt.setInt(3, gia);
            pstmt.setDate(4, new java.sql.Date(millis));
            pstmt.setInt(5, 1);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("lỗi add hóa đơn: " + e);
        }
    }

    public void updateSoLuong(int sanPhamId, int hoaDonId) {
        String query = "UPDATE HoaDonChiTiet SET SoLuong = SoLuong + 1 WHERE HoaDon_ID = ? and Sua_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonId);
            pstmt.setInt(2, sanPhamId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("lỗi update số lượng: " + e);
        }
    }

    public List<HoaDonChiTiet> getHoaDonChiTiet(int hoaDonId) {
        String query = "SELECT * FROM HoaDonChiTiet WHERE HoaDon_ID = ?";
        List<HoaDonChiTiet> listHoaDon = new ArrayList();
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, hoaDonId);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                HoaDonChiTiet hoaDon = new HoaDonChiTiet(result.getInt(1), result.getInt(2), result.getInt(3), result.getInt(4),
                        result.getDate(5), result.getInt(6));
                listHoaDon.add(hoaDon);
            }
            return listHoaDon;
        } catch (Exception e) {
            System.out.println("looix lay hoa don chi tiet: " + e);
            return null;
        }
    }

    public int getGiaSanPham(int suaId) {
        String query = "SELECT * FROM ChiTietSua WHERE Sua_ID = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, suaId);
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                return result.getInt("Gia");
            }
        } catch (Exception e) {
            System.out.println("loi get gia san pham: " + e);
        }
        return 0;
    }

    public void updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) throws SQLException {
        String query = "UPDATE HoaDonChiTiet SET Sua_ID = ?, HoaDon_ID = ?, GiaHienTai = ?, ThoiGianDat = ?, SoLuong = ? WHERE HoaDonChiTiet_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonChiTiet.getSuaId());
            pstmt.setInt(2, hoaDonChiTiet.getHoaDonId());
            pstmt.setInt(3, hoaDonChiTiet.getGiaHienTai());
            pstmt.setDate(4, new java.sql.Date(hoaDonChiTiet.getThoiGianDat().getTime()));
            pstmt.setInt(5, hoaDonChiTiet.getSoLuong());
            pstmt.setInt(6, hoaDonChiTiet.getHoaDonChiTietId());
            pstmt.executeUpdate();
        }
    }

    public void deleteHoaDonChiTietByHoaDonId(int hoaDonId) throws SQLException {
        String query = "DELETE FROM HoaDonChiTiet WHERE HoaDon_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonId);
            pstmt.executeUpdate();
        }
    }
}
