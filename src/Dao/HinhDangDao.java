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
    public int create(HinhDang hinhDang){
        int rowedit = 0;
        String sql = "INSERT INTO HinhDang (HinhDang, TrangThai) VALUES \n"
                + "(?,1)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hinhDang.getHinhDang());
            rowedit = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowedit;
    }
    public int update( HinhDang hinhDang){
        int editHD = 0;
        String sql = "UPDATE HinhDang set HinhDang = ? WHERE HinhDang_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hinhDang.getHinhDang());
            preparedStatement.setInt(2, hinhDang.getId());
            editHD = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editHD;
    }
    public int delete(HinhDang hinhDang){
        int xoahd = 0;
        String sql = "UPDATE HinhDang set trangthai = ? WHERE HinhDang_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, hinhDang.getId());
            xoahd = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xoahd;
    }
    public int khoiphuc(HinhDang hinhDang) {
        int khoiphuc = 0;
        String sql = "UPDATE HinhDang set trangthai = ? WHERE HinhDang_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, hinhDang.getId());
            khoiphuc = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khoiphuc;
    }
}
