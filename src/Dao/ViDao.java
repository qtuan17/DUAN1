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
}
