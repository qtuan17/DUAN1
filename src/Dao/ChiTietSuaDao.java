/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author tuanb
 */
import Model.ChiTietSua;
import ViewModel.Chitietview;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSuaDao {

    public PreparedStatement preparedStatement = null;
    public Connection connection = null;
    public ResultSet resultSet = null;

    public ChiTietSuaDao() throws Exception {
        connection = util.DBContext.getConnection();
    }

    public List<Chitietview> filAll() {
        List<Chitietview> chiTietSuaDaos = new ArrayList<>();
        String sql = "select a.Sua_ID,c.TenSua,d.TenMau,b.TenLoai,f.TenHang,g.TenVi,h.HinhDang,a.TrangThai,a.Gia,a.HanSuDung,a.SoLuong from ChiTietSua a\n"
                + "INNER JOIN Loai b on a.Loai_ID = b.Loai_ID\n"
                + "INNER JOIN TenSua c on a.TenSua_ID = c.TenSua_ID\n"
                + "INNER JOIN Mau d on a.Mau_ID = d.Mau_ID\n"
                + "INNER JOIN Hang f on a.Hang_ID = f.Hang_ID\n"
                + "INNER JOIN Vi g on a.Vi_ID = g.Vi_ID\n"
                + "INNER JOIN HinhDang h on a.HinhDang_ID = h.HinhDang_ID\n";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Chitietview chiTietSua = new Chitietview(
                        resultSet.getInt("Sua_ID"),
                        resultSet.getString("TenSua"),
                        resultSet.getString("TenMau"),
                        resultSet.getString("TenHang"),
                        resultSet.getString("TenLoai"),
                        resultSet.getString("TenVi"),
                        resultSet.getString("HinhDang"),
                        resultSet.getInt("Gia"),
                        resultSet.getInt("SoLuong"),
                        resultSet.getDate("HanSuDung"),
                        resultSet.getInt("TrangThai")
                );
                chiTietSuaDaos.add(chiTietSua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietSuaDaos;
    }

    public int create(ChiTietSua chiTietSua) {
        int themsua = 0;
        String sql = "INSERT INTO ChiTietSua (TenSua_ID,Mau_ID,Loai_ID,Hang_ID,Vi_ID,HinhDang_ID,Gia, HanSuDung, TrangThai) VALUES \n"
                + "(?,?,?,?,?,?,?,?,?,?,1)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chiTietSua.getTenSua());
            preparedStatement.setInt(2, chiTietSua.getTenMau());
            preparedStatement.setInt(3, chiTietSua.getTenLoai());
            preparedStatement.setInt(4, chiTietSua.getTenHang());
            preparedStatement.setInt(5, chiTietSua.getTenVi());
            preparedStatement.setInt(6, chiTietSua.getHinhDang());
            preparedStatement.setInt(8, chiTietSua.getGia());
            preparedStatement.setDate(9, chiTietSua.getHanSuDung());
            preparedStatement.setInt(8, chiTietSua.getTrangThai());
            themsua = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themsua;
    }
};
