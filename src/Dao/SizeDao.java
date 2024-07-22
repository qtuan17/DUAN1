/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Size;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeDao {
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    public Connection connection = null;
    
    public SizeDao() throws Exception{
        connection = util.DBContext.getConnection();
    }
    
    public List<Size> filAll(){
        List<Size> sizes = new ArrayList<>();
        String sql = "SELECT * FROM Size";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("size 34");
                Size size = new Size(
                        resultSet.getInt("Size_ID"),
                        resultSet.getString("TenSize"),
                        resultSet.getInt("TrangThai")
                );
                System.out.println(size.getTenSize());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizes;
    }
    
    public int create(Size size) {
        int themsize = 0;
        String sql = "INSERT INTO Size (TenSize, TrangThai) VALUES \n"
                + "(?, 1)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, size.getTenSize());
            themsize = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themsize;
    }
    public int update(Size size) {
        int editsize = 0;
        String sql = "UPDATE Size set TenSize = ? WHERE TenSize_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, size.getTenSize());
            preparedStatement.setInt(2, size.getId());
            editsize = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editsize;
    }
    public int delete(Size size){
        int xoa = 0;
        String sql = "UPDATE Size set trangthai = ? WHERE TenSize_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, size.getId());
            xoa = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xoa;
    }
}
