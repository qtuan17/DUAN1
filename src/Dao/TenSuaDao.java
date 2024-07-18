/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.TenSua;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TenSuaDao {
    public PreparedStatement preparedStatement= null;
    public ResultSet resultSet = null;
    public Connection connection = null;
    
    public TenSuaDao() throws Exception {
        connection = util.DBContext.getConnection();
    }
    
    public List<TenSua> filAll() {
        List<TenSua> tenSuas = new ArrayList<>();
        String sql = "SELECT * FROM TenSua";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                TenSua tenSua = new TenSua(
                        resultSet.getInt("TenSua_ID"),
                        resultSet.getString("TenSua"),
                        resultSet.getInt("TrangThai")
                );
                tenSuas.add(tenSua);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tenSuas;
    }
    
    public int create(TenSua tenSua) {
        int themsua = 0;
        String sql = "INSERT INTO TenSua (TenSua, TrangThai) VALUES \n"
                + "(?, 1)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenSua.getTenSua());
            themsua = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themsua;
    }
    public int update(TenSua tenSua) {
        int editsua = 0;
        String sql = "UPDATE TenSua set TenSua = ? WHERE TenSua_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tenSua.getTenSua());
            preparedStatement.setInt(2, tenSua.getId());
            editsua = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editsua;
    }
    public int delete(TenSua tenSua){
        int xoasua = 0;
        String sql = "UPDATE TenSua set trangthai = ? WHERE TenSua_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, tenSua.getId());
            xoasua = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xoasua;
    }
    public int khoiphuc(TenSua tenSua) {
        int khoiphuc = 0;
        String sql = "UPDATE TenSua set trangthai = ? WHERE TenSua_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, tenSua.getId());
            khoiphuc = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khoiphuc;
    }
}
