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
        String query = "SELECT * FROM HoaDon";
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
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonId);
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
        }
        return hoaDon;
    }

    public void addHoaDon(HoaDon hoaDon) throws SQLException {
        String query = "INSERT INTO HoaDon (NguoiDung_ID, NgayTao, NgayThanhToan, TrangThai) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, hoaDon.getNguoiDungId());
            pstmt.setDate(2, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            pstmt.setDate(3, new java.sql.Date(hoaDon.getNgayThanhToan().getTime()));
            pstmt.setInt(4, hoaDon.getTrangThai());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int hoaDonId = generatedKeys.getInt(1);
                    for (HoaDonChiTiet chiTiet : hoaDon.getHoaDonChiTietList()) {
                        chiTiet.setHoaDonId(hoaDonId);
                        addHoaDonChiTiet(chiTiet);
                    }
                }
            }
        }
    }

    public void updateHoaDon(HoaDon hoaDon) throws SQLException {
        String query = "UPDATE HoaDon SET NguoiDung_ID = ?, NgayTao = ?, NgayThanhToan = ?, TrangThai = ? WHERE HoaDon_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDon.getNguoiDungId());
            pstmt.setDate(2, new java.sql.Date(hoaDon.getNgayTao().getTime()));
            pstmt.setDate(3, new java.sql.Date(hoaDon.getNgayThanhToan().getTime()));
            pstmt.setInt(4, hoaDon.getTrangThai());
            pstmt.setInt(5, hoaDon.getHoaDonId());
            pstmt.executeUpdate();

            // Xóa các chi tiết hóa đơn cũ trước khi thêm mới
            deleteHoaDonChiTietByHoaDonId(hoaDon.getHoaDonId());
            for (HoaDonChiTiet chiTiet : hoaDon.getHoaDonChiTietList()) {
                addHoaDonChiTiet(chiTiet);
            }
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

    private void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) throws SQLException {
        String query = "INSERT INTO HoaDonChiTiet (Sua_ID, HoaDon_ID, GiaHienTai, ThoiGianDat, SoLuong) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonChiTiet.getSuaId());
            pstmt.setInt(2, hoaDonChiTiet.getHoaDonId());
            pstmt.setInt(3, hoaDonChiTiet.getGiaHienTai());
            pstmt.setDate(4, new java.sql.Date(hoaDonChiTiet.getThoiGianDat().getTime()));
            pstmt.setInt(5, hoaDonChiTiet.getSoLuong());
            pstmt.executeUpdate();
        }
    }

    private void updateHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) throws SQLException {
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

    private void deleteHoaDonChiTietByHoaDonId(int hoaDonId) throws SQLException {
        String query = "DELETE FROM HoaDonChiTiet WHERE HoaDon_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, hoaDonId);
            pstmt.executeUpdate();
        }
    }
}
