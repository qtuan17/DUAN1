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

    private PreparedStatement preparedStatement = null;
    private Connection connection = null;
    private ResultSet resultSet = null;

    public NguoiDungDao() throws Exception {
        connection = util.DBContext.getConnection();
    }

    public List<NguoiDung> findAll() {
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
        } finally {
            closeResources();
        }
        return lstNguoiDung;
    }

    public int create(NguoiDung nguoiDung) {
        int rowsAffected = 0;
        String sql = "INSERT INTO NguoiDung (ChucVu_ID, TaiKhoan, MatKhau, HoTen, NgaySinh, GioiTinh, Email, SDT, CCCD) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, nguoiDung.getChucVu_ID());
            preparedStatement.setString(2, nguoiDung.getTaiKhoan());
            preparedStatement.setString(3, nguoiDung.getMatKhau());
            preparedStatement.setString(4, nguoiDung.getHoTen());
            preparedStatement.setDate(5, new Date(nguoiDung.getNgaySinh().getTime())); // Chuyển đổi java.util.Date thành java.sql.Date
            preparedStatement.setString(6, nguoiDung.getGioiTinh());
            preparedStatement.setString(7, nguoiDung.getEmail());
            preparedStatement.setInt(8, nguoiDung.getSDT());
            preparedStatement.setInt(9, nguoiDung.getCCCD());

            rowsAffected = preparedStatement.executeUpdate(); // Thực hiện câu lệnh SQL
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return rowsAffected;
    }

    public NguoiDung selectByUserName(String TaiKhoan) {
        String sql = "SELECT * FROM NguoiDung WHERE TaiKhoan = ?";
        List<NguoiDung> lnv = selectBySql(sql, TaiKhoan);
        return lnv.size() > 0 ? lnv.get(0) : null;

    }

    private void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<NguoiDung> selectBySql(String sql, Object... args) {
        List<NguoiDung> lnv = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBContext.query(sql, args);
            } finally {
                rs.getStatement();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lnv;
    }
}
