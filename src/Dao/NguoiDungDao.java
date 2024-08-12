/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.NguoiDung;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBContext;

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

    public int create(NguoiDung nguoiDung) {
        int themnv = 0;
        String sql = "INSERT INTO NguoiDung (ChucVu_ID, TaiKhoan, MatKhau, HoTen, NgaySinh, GioiTinh, Email, SDT, CCCD) VALUES \n"
                + "(?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setInt(1, nguoiDung.getIdChucVu());
            preparedStatement.setString(2, nguoiDung.getTaiKhoan());
            preparedStatement.setString(3, nguoiDung.getMatKhau());
            preparedStatement.setString(4, nguoiDung.getHoTen());
            preparedStatement.setDate(5, (Date) nguoiDung.getNgaySinh());
            preparedStatement.setString(6, nguoiDung.getGioiTinh());
            preparedStatement.setString(7, nguoiDung.getEmail());
            preparedStatement.setInt(8, nguoiDung.getSDT());
            preparedStatement.setInt(9, nguoiDung.getCCCD());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themnv;
    }

    public NguoiDung selectByUserName(String TaiKhoan) {
        String sql = "SELECT * FROM NguoiDung WHERE TaiKhoan = ?";
        List<NguoiDung> lnv = selectBySql(sql, TaiKhoan);
        return lnv.size() > 0 ? lnv.get(0) : null;
    }

    

    public List<NguoiDung> selectBySql(String sql, Object... args) {
        List<NguoiDung> lnv = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement, args);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                NguoiDung nd = mapResultSetToNguoiDung(resultSet);
                lnv.add(nd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources();
        }
        return lnv;
    }

    private void setParameters(PreparedStatement preparedStatement, Object... args) throws SQLException {
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
    }

    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private NguoiDung mapResultSetToNguoiDung(ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung();
        // Gán các giá trị từ ResultSet vào các trường của NguoiDung
        return nd;
    }
}
