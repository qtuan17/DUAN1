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
}
