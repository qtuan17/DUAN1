/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.Hang;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuanb
 */


public class HangDao {
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    public Connection connection = null;
    
    public HangDao() throws Exception {
        connection = util.DBContext.getConnection();
    }
    
    public List<Hang> filAll(){
        List<Hang> hangs = new ArrayList<>();
        String sql = "SELECT * FROM Hang";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                Hang hang = new Hang(
                        resultSet.getInt("Hang_ID"),
                        resultSet.getString("TenHang"),
                        resultSet.getInt("TrangThai")
                );
                hangs.add(hang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hangs;
    }
    
    public int create(Hang hang) {
        int themhang = 0;
        String sql = "INSERT INTO Hang (TenHang, TrangThai) VALUES \n"
                + "(?, 1)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hang.getTenHang());
            themhang = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themhang;
    }
    public int update(Hang hang) {
        int edithang = 0;
        String sql = "UPDATE Hang set TenHang = ? WHERE Hang_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hang.getTenHang());
            preparedStatement.setInt(2, hang.getId());
            edithang = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return edithang;
    }
    
    public int delete(Hang hang){
        int xoa = 0;
        String sql = "UPDATE TenSua set trangthai = ? WHERE TenSua_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, hang.getId());
            xoa = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xoa;
    }
    
    public int khoiphuc(Hang hang) {
        int khoiphuc = 0;
        String sql = "UPDATE Hang set trangthai = ? WHERE Hang_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, hang.getId());
            khoiphuc = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khoiphuc;
    }
}
