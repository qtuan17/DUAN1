/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JPanel;
import View.SanPhamPanel;
import javax.swing.JFrame;

/**
 *
 * @author tuanb
 */
public class TrangChuJFrame extends javax.swing.JFrame {

    private JPanel childPanel;

    /**
     * Creates new form TrangChuJFrame
     */
    public TrangChuJFrame() {
        initComponents();
        setLocationRelativeTo(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNavigate = new javax.swing.JPanel();
        btnNV = new javax.swing.JButton();
        btnKM = new javax.swing.JButton();
        btnBH = new javax.swing.JButton();
        btnHD = new javax.swing.JButton();
        btnTK = new javax.swing.JButton();
        btnSP = new javax.swing.JButton();
        btnChangePass = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();
        btnSignout = new javax.swing.JButton();
        panelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelNavigate.setBackground(new java.awt.Color(0, 153, 153));

        btnNV.setBackground(new java.awt.Color(0, 153, 153));
        btnNV.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnNV.setForeground(new java.awt.Color(255, 255, 255));
        btnNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/User.png"))); // NOI18N
        btnNV.setText("Nhân viên");
        btnNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNVActionPerformed(evt);
            }
        });

        btnKM.setBackground(new java.awt.Color(0, 153, 153));
        btnKM.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnKM.setForeground(new java.awt.Color(255, 255, 255));
        btnKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Label.png"))); // NOI18N
        btnKM.setText("Khuyến mãi");
        btnKM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKMActionPerformed(evt);
            }
        });

        btnBH.setBackground(new java.awt.Color(0, 153, 153));
        btnBH.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnBH.setForeground(new java.awt.Color(255, 255, 255));
        btnBH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Basket.png"))); // NOI18N
        btnBH.setText("Bán hàng");
        btnBH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBHMouseClicked(evt);
            }
        });
        btnBH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBHActionPerformed(evt);
            }
        });

        btnHD.setBackground(new java.awt.Color(0, 153, 153));
        btnHD.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnHD.setForeground(new java.awt.Color(255, 255, 255));
        btnHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Price list.png"))); // NOI18N
        btnHD.setText("Hóa đơn");
        btnHD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHDMouseClicked(evt);
            }
        });
        btnHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHDActionPerformed(evt);
            }
        });

        btnTK.setBackground(new java.awt.Color(0, 153, 153));
        btnTK.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnTK.setForeground(new java.awt.Color(255, 255, 255));
        btnTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Diagram.png"))); // NOI18N
        btnTK.setText("Thống kê");
        btnTK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        btnSP.setBackground(new java.awt.Color(0, 153, 153));
        btnSP.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnSP.setForeground(new java.awt.Color(255, 255, 255));
        btnSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Application form.png"))); // NOI18N
        btnSP.setText("Sản phẩm");
        btnSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSPMouseClicked(evt);
            }
        });
        btnSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPActionPerformed(evt);
            }
        });

        btnChangePass.setBackground(new java.awt.Color(0, 153, 153));
        btnChangePass.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnChangePass.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePass.setText("Đổi mật khẩu");
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(255, 255, 255));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("My Shop");
        lbTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnSignout.setBackground(new java.awt.Color(0, 153, 153));
        btnSignout.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnSignout.setForeground(new java.awt.Color(255, 255, 255));
        btnSignout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Log out.png"))); // NOI18N
        btnSignout.setText("Đăng xuất");
        btnSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNavigateLayout = new javax.swing.GroupLayout(panelNavigate);
        panelNavigate.setLayout(panelNavigateLayout);
        panelNavigateLayout.setHorizontalGroup(
            panelNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavigateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelNavigateLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnSignout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChangePass, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelNavigateLayout.setVerticalGroup(
            panelNavigateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNavigateLayout.createSequentialGroup()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(btnSP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnKM, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(btnChangePass, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSignout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNavigate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNavigate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNVActionPerformed
         
        try {
            showPanel(new NhanVienPanel(this, rootPaneCheckingEnabled));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNVActionPerformed

    private void btnSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPActionPerformed

    }//GEN-LAST:event_btnSPActionPerformed

    private void btnKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKMActionPerformed
        // TODO add your handling code here:
//        showPanel(new PanelKM());
    }//GEN-LAST:event_btnKMActionPerformed

    private void btnBHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBHActionPerformed
        // TODO add your handling code here:
//        showPanel(new BanHangJPanel());
    }//GEN-LAST:event_btnBHActionPerformed

    private void btnHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHDActionPerformed
        // TODO add your handling code here:
//        showPanel(new PanelHoaDon());
    }//GEN-LAST:event_btnHDActionPerformed

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        // TODO add your handling code here:
//        showPanel(new ThongKeJPanel());
    }//GEN-LAST:event_btnTKActionPerformed

    private void btnSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignoutActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSignoutActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        // TODO add your handling code here:
//        showPanel(new DoiMatKhauJPanel());
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSPMouseClicked
        try {
            showPanel(new SanPhamPanel(this, rootPaneCheckingEnabled));
        } catch (Exception e) {
            System.out.println("ỗi c view ồi");
        }

    }//GEN-LAST:event_btnSPMouseClicked

    private void btnHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHDMouseClicked
        // TODO add your handling code here:
        try {
            showPanel(new HoaDonPanel(this, rootPaneCheckingEnabled));
        } catch (Exception e) {
            System.out.println("Đây là Hóa đơn");
        }
    }//GEN-LAST:event_btnHDMouseClicked

    private void btnBHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBHMouseClicked
        // TODO add your handling code here:
        try {
            showPanel(new BanHangPanel(this, rootPaneCheckingEnabled));
        } catch (Exception e) {
            System.out.println("Bán sữa");
        }
    }//GEN-LAST:event_btnBHMouseClicked
    private void showPanel(JPanel panel) {
        childPanel = panel;
        panelMain.removeAll();
        panelMain.add(childPanel);
        panelMain.validate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChuJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChuJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBH;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnHD;
    private javax.swing.JButton btnKM;
    private javax.swing.JButton btnNV;
    private javax.swing.JButton btnSP;
    private javax.swing.JButton btnSignout;
    private javax.swing.JButton btnTK;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelNavigate;
    // End of variables declaration//GEN-END:variables

}
