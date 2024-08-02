package Dao;

import Model.HoaDonChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author tuanb
 */
public class HoaDonChiTietDao {
    private Connection connection;

    public HoaDonChiTietDao(Connection connection) {
        this.connection = connection;
    }

    public List<HoaDonChiTiet> getHoaDonChiTietByHoaDonId(int hoaDonId) throws SQLException {
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

    public void addHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet) throws SQLException {
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
