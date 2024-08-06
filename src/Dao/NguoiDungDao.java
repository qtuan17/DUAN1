/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.NguoiDung;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NguoiDungDao {
    public PreparedStatement preparedStatement = null;
    public Connection connection = null;
    public ResultSet resultSet = null;

    public NguoiDungDao() throws Exception {
        connection = util.DBContext.getConnection();
    }

    public List<NguoiDung> filAll() {
        List<NguoiDung> lstNguoiDung = new ArrayList<>();
        String sql = "SELECT * FROM NguoiDung";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NguoiDung nguoiDung = new NguoiDung(
                        resultSet.getInt("NguoiDung_ID"),
                        resultSet.getInt("ChucVu_ID"),
                        resultSet.getString("TaiKhoan"),
                        resultSet.getString("MatKhau"),
                        resultSet.getString("HoTen"),
                        resultSet.getDate("NgaySinh"),
                        resultSet.getString("GioiTinh"),
                        resultSet.getString("Email"),
                        resultSet.getInt("SDT"),
                        resultSet.getInt("CCCD")       
                );
                lstNguoiDung.add(nguoiDung);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lstNguoiDung;
    }

//    public int create(ChiTietSua chiTietSua) {
//        int themsua = 0;
//        String sql = "INSERT INTO ChiTietSua (Loai_ID, TenSua_ID,Hang_ID,Vi_ID,Mau_ID,HinhDang_ID,Gia, HanSuDung,SoLuong,TrangThai) VALUES \n"
//                + "(?,?,?,?,?,?,?,?,?,?)";
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(2, chiTietSua.getTenSua());
//            preparedStatement.setInt(5, chiTietSua.getTenMau());
//            preparedStatement.setInt(1, chiTietSua.getTenLoai());
//            preparedStatement.setInt(3, chiTietSua.getTenHang());
//            preparedStatement.setInt(4, chiTietSua.getTenVi());
//            preparedStatement.setInt(6, chiTietSua.getHinhDang());
//            preparedStatement.setInt(7, chiTietSua.getGia());
//            preparedStatement.setDate(8, chiTietSua.getHanSuDung());
//            preparedStatement.setInt(9, chiTietSua.getSoLuong());
//            preparedStatement.setInt(10, chiTietSua.getTrangThai());
//            themsua = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return themsua;
//    }
}
