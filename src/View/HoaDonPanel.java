/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Dao.HoaDonDao;
import Model.HoaDon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static util.DBContext.getConnection;

/**
 *
 * @author tuanb
 */
public class HoaDonPanel extends javax.swing.JPanel {
    
    private HoaDonDao hoaDonDao;
    private DefaultTableModel tableModel;
    List<HoaDon> lstHoaDon;
    
    
    public HoaDonPanel(java.awt.Frame parent, boolean modal) throws Exception {
        initComponents();
        Connection connection = getConnection();
        hoaDonDao = new HoaDonDao();
        // Cài đặt mô hình bảng
        tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new String[] {"HoaDon_ID", "NguoiDung_ID", "NgayTao", "NgayThanhToan", "TrangThai"});
        jTable1.setModel(tableModel);
        // Load dữ liệu ban đầu
//        loadHoaDonData();
    }

    HoaDonPanel() {
        initComponents();

    }
    
    
    
//    private void loadHoaDonData() {
//        try {
//            List<HoaDon> hoaDonList = hoaDonDao.getAllHoaDon();
//            tableModel.setRowCount(0);
//            for (HoaDon hoaDon : hoaDonList) {
//                tableModel.addRow(new Object[] {
//                        hoaDon.getHoaDonId(),
//                        hoaDon.getNguoiDungId(),
//                        hoaDon.getNgayTao(),
//                        hoaDon.getNgayThanhToan(),
//                        hoaDon.getTrangThai()
//                });
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
////    private void addHoaDon() {
////        try {
////            int nguoiDungId = Integer.parseInt(txtNguoiDungId.getText());
////            java.sql.Date ngayTao = java.sql.Date.valueOf(txtNgayTao.getText());
////            java.sql.Date ngayThanhToan = java.sql.Date.valueOf(txtNgayThanhToan.getText());
////            int trangThai = Integer.parseInt(txtTrangThai.getText());
//
//            HoaDon hoaDon = new HoaDon(0, nguoiDungId, ngayTao, ngayThanhToan, trangThai);
//            hoaDonDao.addHoaDon(hoaDon);
//            loadHoaDonData();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        tbl_HoaDon = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Hóa Đơn", "ID Người Dùng", "Tên Khách", "SDT", "Địa Chỉ", "Ngày Tạo", "Ngày Thanh Toán", "Trạng Thái"
            }
        ));
        tbl_HoaDon.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Search.png"))); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã Thành Công", "Đã hủy", "Chờ" }));
        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Trạng Thái");

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 36)); // NOI18N
        jLabel4.setText("Quản Lí Hóa Đơn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel4)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(tbl_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane tbl_HoaDon;
    // End of variables declaration//GEN-END:variables
}
