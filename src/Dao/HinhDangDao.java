/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author tuanb
 */
import Model.HinhDang;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HinhDangDao {
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    public Connection connection = null;
    
    public HinhDangDao() throws Exception {
        connection = util.DBContext.getConnection();
    }
    
    public List<HinhDang> filAll(){
        List<HinhDang> hinhDangs = new ArrayList<>();
        String sql = "SELECT * FROM HinhDang";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                HinhDang hinhDang = new HinhDang(
                        resultSet.getInt("HinhDang_ID"),
                        resultSet.getString("HinhDang"),
                        resultSet.getInt("TrangThai")
                );
                hinhDangs.add(hinhDang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hinhDangs;
    }
}
