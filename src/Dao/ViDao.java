/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author tuanb
 */
import Model.Vi;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViDao {

    public PreparedStatement preparedStatement = null;
    public Connection connection = null;
    public ResultSet resultSet = null;

    public ViDao() throws Exception {
        connection = util.DBContext.getConnection();
    }

    public List<Vi> filAll() {
        List<Vi> vis = new ArrayList<>();
        String sql = "SELECT * FROM Vi";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vi v = new Vi(resultSet.getInt("Vi_ID"),
                        resultSet.getString("TenVi"),
                        resultSet.getInt("TrangThai"));
                vis.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vis;
    }
    public int create(Vi vi){
        int rowedit = 0;
        String sql = "INSERT INTO Vi (TenVi, TrangThai) VALUES \n"
                + "(?,1)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,vi.getTenVi());
            rowedit = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowedit;
    }
    public int update(Vi vi) {
        int editvi = 0;
        String sql = "UPDATE Vi set TenVi = ? WHERE TenVi_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, vi.getTenVi());
            preparedStatement.setInt(2, vi.getId());
            editvi = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editvi;
    }
    public int delete(Vi vi){
        int xoavi = 0;
        String sql = "UPDATE Vi set trangthai = ? WHERE Vi_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setInt(2, vi.getId());
            xoavi = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xoavi;
    }
    public int khoiphuc(Vi vi) {
        int khoiphuc = 0;
        String sql = "UPDATE Vi set trangthai = ? WHERE Vi_ID = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, vi.getId());
            khoiphuc = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khoiphuc;
    }
}
