/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package View;

import Dao.LoaiDao;
import Dao.MauDao;
import Dao.TenSuaDao;
import Dao.ViDao;
import Model.Loai;
import Model.Mau;
import Model.TenSua;
import Model.Vi;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuanb
 */
public class ThuocTich extends java.awt.Dialog {

    private DefaultTableModel defaultTableModel;
    MauDao mauDao;
    ViDao viDao;
    LoaiDao loaiDao;
    TenSuaDao tensuaDao;
    int index = -1;

    /**
     * Creates new form ThuocTich
     */
    public ThuocTich(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        mauDao = new MauDao();
        viDao = new ViDao();
        loaiDao = new LoaiDao();
        tensuaDao = new TenSuaDao();
        fillTableMau();
        fillTableVi();
        fillTableLoai();
        fillTableTenSua();

    }

    private Mau getFormMau() {
        Mau mau = new Mau();
        if (index != -1) {
            mau.setId(Integer.parseInt(txtIDMau.getText()));
        }
        mau.setTenMau(txtTenMau.getText());
        return mau;
    }

    private Vi getFormVi() {
        Vi vi = new Vi();
        if (index != -1) {
            vi.setId(Integer.parseInt(txtIDVi.getText()));
        }
        vi.setTenVi(txtTenVi.getText());
        return vi;
    }

    private Loai getFormLoai() {
        Loai loai = new Loai();
        if (index != -1) {
            loai.setId(Integer.parseInt(txtIDLoai.getText()));
        }
        loai.setTenLoai(txtTenLoai.getText());
        return loai;
    }

    private TenSua getFormTenSua() {
        TenSua tenSua = new TenSua();
        if (index != -1) {
            tenSua.setId(Integer.parseInt(txtIDSua.getText()));
        }
        tenSua.setTenSua(txtTenSua.getText());
        return tenSua;
    }

    private void setFormMau(int index) {
        if (index != -1) {
            String idMau = tblMau.getValueAt(index, 0).toString();
            String tenMau = tblMau.getValueAt(index, 1).toString();
            txtIDMau.setText(idMau);
            txtTenMau.setText(tenMau);
        }
    }

    private void setFormVi(int index) {
        if (index != -1) {
            String idVi = tblVi.getValueAt(index, 0).toString();
            String tenVi = tblVi.getValueAt(index, 1).toString();

            txtIDVi.setText(idVi);
            txtTenVi.setText(tenVi);
        }
    }

    private void setFormLoai(int index) {
        if (index != -1) {
            String idLoai = tblLoai.getValueAt(index, 0).toString();
            String tenLoai = tblLoai.getValueAt(index, 1).toString();

            txtIDLoai.setText(idLoai);
            txtTenLoai.setText(tenLoai);
        }
    }

    private void setFormTenSua(int index) {
        if (index != -1) {
            String idTenSua = tblTenSua.getValueAt(index, 0).toString();
            String tenTenSua = tblTenSua.getValueAt(index, 1).toString();

            txtIDLoai.setText(idTenSua);
            txtTenLoai.setText(tenTenSua);
        }
    }

    void fillTableMau() {
        defaultTableModel = (DefaultTableModel) tblMau.getModel();
        defaultTableModel.setRowCount(0);
        try {
            List<Mau> maus = mauDao.filAll();
            if (maus.isEmpty()) {
                System.out.println("List Mau NUll");
            }
            for (Mau mau : maus) {
                Object[] row = {
                    mau.getId(),
                    mau.getTenMau(),
                    mau.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại"
                };
                defaultTableModel.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    void fillTableVi() {
        defaultTableModel = (DefaultTableModel) tblVi.getModel();
        defaultTableModel.setRowCount(0);
        try {
            List<Vi> vis = viDao.filAll();
            if (vis.isEmpty()) {
                System.out.println("List Vi Null");

            }
            for (Vi vi : vis) {
                Object[] row = {
                    vi.getId(),
                    vi.getTenVi(),
                    vi.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại"
                };
                defaultTableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillTableLoai() {
        defaultTableModel = (DefaultTableModel) tblLoai.getModel();
        defaultTableModel.setRowCount(0);
        try {
            List<Loai> loais = loaiDao.filAll();
            if (loais.isEmpty()) {
                System.out.println("List Loai null");
            }
            for (Loai loai : loais) {
                Object[] row = {
                    loai.getId(),
                    loai.getTenLoai(),
                    loai.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại"
                };
                defaultTableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillTableTenSua() {
        defaultTableModel = (DefaultTableModel) tblTenSua.getModel();
        defaultTableModel.setRowCount(0);
        try {
            List<TenSua> tenSuas = tensuaDao.filAll();
            if (tenSuas.isEmpty()) {
                System.out.println("List tensua null");
            }
            for (TenSua tenSua : tenSuas) {
                Object[] row = {
                    tenSua.getId(),
                    tenSua.getTenSua(),
                    tenSua.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại"
                };
                defaultTableModel.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        tbl1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIDMau = new javax.swing.JTextField();
        btnThemMau = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTenMau = new javax.swing.JTextField();
        btnSuaMau = new javax.swing.JButton();
        btnXoaMau = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMau = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVi = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtIDVi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenVi = new javax.swing.JTextField();
        btnThemVi = new javax.swing.JButton();
        btnSuaVi = new javax.swing.JButton();
        btnXoaVi = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTenSua = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtIDSua = new javax.swing.JTextField();
        btnThemTenSua = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtTenSua = new javax.swing.JTextField();
        btnSuaMau1 = new javax.swing.JButton();
        btnXoaMau1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblLoai = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtIDLoai = new javax.swing.JTextField();
        btnThemLoai = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        btnSuaLoai = new javax.swing.JButton();
        btnXoaLoai = new javax.swing.JButton();
        btnKhoiPhucLoai = new javax.swing.JButton();
        tbl2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIDMau3 = new javax.swing.JTextField();
        btnThemMau3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTenMau3 = new javax.swing.JTextField();
        btnSuaMau3 = new javax.swing.JButton();
        btnXoaMau3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblMau3 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVi1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtIDVi1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenVi1 = new javax.swing.JTextField();
        btnThemVi1 = new javax.swing.JButton();
        btnSuaVi1 = new javax.swing.JButton();
        btnXoaVi1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMau4 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtIDMau4 = new javax.swing.JTextField();
        btnThemMau4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtTenMau4 = new javax.swing.JTextField();
        btnSuaMau4 = new javax.swing.JButton();
        btnXoaMau4 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblMau5 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtIDMau5 = new javax.swing.JTextField();
        btnThemMau5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtTenMau5 = new javax.swing.JTextField();
        btnSuaMau5 = new javax.swing.JButton();
        btnXoaMau5 = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        jLabel1.setText("ID");

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(400, 704));

        tbl1.setPreferredSize(new java.awt.Dimension(1000, 669));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Màu"));

        jLabel2.setText("ID");

        txtIDMau.setEnabled(false);
        txtIDMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMauActionPerformed(evt);
            }
        });

        btnThemMau.setBackground(new java.awt.Color(102, 255, 102));
        btnThemMau.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMau.setMnemonic('T');
        btnThemMau.setText("Add");
        btnThemMau.setAutoscrolls(true);
        btnThemMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên Màu");

        txtTenMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMauActionPerformed(evt);
            }
        });

        btnSuaMau.setText("Edit");
        btnSuaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauActionPerformed(evt);
            }
        });

        btnXoaMau.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaMau.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaMau.setText("Delete");
        btnXoaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauActionPerformed(evt);
            }
        });

        tblMau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Màu", "Trạng Thái"
            }
        ));
        tblMau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMau);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThemMau)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaMau)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaMau))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtTenMau, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtIDMau))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMau)
                    .addComponent(btnSuaMau)
                    .addComponent(btnXoaMau))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Vị"), "Vị"));

        tblVi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Vị", "Trạng Thái"
            }
        ));
        jScrollPane2.setViewportView(tblVi);

        jLabel4.setText("ID");

        txtIDVi.setEnabled(false);
        txtIDVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDViActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên Vị");

        btnThemVi.setBackground(new java.awt.Color(102, 255, 102));
        btnThemVi.setText("Thêm");
        btnThemVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemViActionPerformed(evt);
            }
        });

        btnSuaVi.setText("Sửa");

        btnXoaVi.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaVi.setText("Xóa");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnThemVi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaVi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaVi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenVi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDVi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVi)
                    .addComponent(btnSuaVi)
                    .addComponent(btnXoaVi))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên Sữa"));
        jPanel8.setToolTipText("");
        jPanel8.setPreferredSize(new java.awt.Dimension(400, 309));

        tblTenSua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Sữa", "Trạng Thái"
            }
        ));
        tblTenSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTenSuaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTenSua);

        jLabel10.setText("ID");

        txtIDSua.setEnabled(false);
        txtIDSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDSuaActionPerformed(evt);
            }
        });

        btnThemTenSua.setBackground(new java.awt.Color(102, 255, 102));
        btnThemTenSua.setForeground(new java.awt.Color(255, 255, 255));
        btnThemTenSua.setMnemonic('T');
        btnThemTenSua.setText("Add");
        btnThemTenSua.setAutoscrolls(true);
        btnThemTenSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTenSuaActionPerformed(evt);
            }
        });

        jLabel11.setText("Tên Sữa");

        txtTenSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSuaActionPerformed(evt);
            }
        });

        btnSuaMau1.setText("Edit");
        btnSuaMau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMau1ActionPerformed(evt);
            }
        });

        btnXoaMau1.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaMau1.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaMau1.setText("Delete");
        btnXoaMau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMau1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnThemTenSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaMau1)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaMau1))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtIDSua, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtTenSua))))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTenSua)
                    .addComponent(btnSuaMau1)
                    .addComponent(btnXoaMau1))
                .addGap(0, 0, 0))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại"));

        tblLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Loại", "Trạng Thái"
            }
        ));
        tblLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblLoai);

        jLabel12.setText("ID");

        txtIDLoai.setEnabled(false);
        txtIDLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDLoaiActionPerformed(evt);
            }
        });

        btnThemLoai.setBackground(new java.awt.Color(51, 204, 0));
        btnThemLoai.setForeground(new java.awt.Color(255, 255, 255));
        btnThemLoai.setMnemonic('T');
        btnThemLoai.setText("Add");
        btnThemLoai.setAutoscrolls(true);
        btnThemLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiActionPerformed(evt);
            }
        });

        jLabel13.setText("Tên Loại:");

        txtTenLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLoaiActionPerformed(evt);
            }
        });

        btnSuaLoai.setBackground(new java.awt.Color(0, 153, 255));
        btnSuaLoai.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaLoai.setText("Edit");
        btnSuaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiActionPerformed(evt);
            }
        });

        btnXoaLoai.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaLoai.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaLoai.setText("Delete");
        btnXoaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoaiActionPerformed(evt);
            }
        });

        btnKhoiPhucLoai.setText("Khôi Phục");
        btnKhoiPhucLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTenLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addComponent(txtIDLoai))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel12))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnThemLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhoiPhucLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemLoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaLoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaLoai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhoiPhucLoai)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tbl1Layout = new javax.swing.GroupLayout(tbl1);
        tbl1.setLayout(tbl1Layout);
        tbl1Layout.setHorizontalGroup(
            tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl1Layout.createSequentialGroup()
                .addGroup(tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tbl1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        tbl1Layout.setVerticalGroup(
            tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(tbl1Layout.createSequentialGroup()
                .addGroup(tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.getAccessibleContext().setAccessibleName("Hãng");

        jTabbedPane2.addTab("tab1", tbl1);

        tbl2.setPreferredSize(new java.awt.Dimension(1000, 669));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Màu"));

        jLabel6.setText("ID");

        txtIDMau3.setEnabled(false);
        txtIDMau3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMau3ActionPerformed(evt);
            }
        });

        btnThemMau3.setBackground(new java.awt.Color(102, 255, 102));
        btnThemMau3.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMau3.setMnemonic('T');
        btnThemMau3.setText("Add");
        btnThemMau3.setAutoscrolls(true);
        btnThemMau3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMau3ActionPerformed(evt);
            }
        });

        jLabel7.setText("Tên Màu");

        txtTenMau3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMau3ActionPerformed(evt);
            }
        });

        btnSuaMau3.setText("Edit");
        btnSuaMau3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMau3ActionPerformed(evt);
            }
        });

        btnXoaMau3.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaMau3.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaMau3.setText("Delete");
        btnXoaMau3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMau3ActionPerformed(evt);
            }
        });

        tblMau3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Màu", "Trạng Thái"
            }
        ));
        tblMau3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMau3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblMau3);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(btnThemMau3)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaMau3)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaMau3))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDMau3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenMau3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMau3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenMau3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMau3)
                    .addComponent(btnSuaMau3)
                    .addComponent(btnXoaMau3))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Vị"), "Vị"));

        tblVi1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Vị", "Trạng Thái"
            }
        ));
        jScrollPane5.setViewportView(tblVi1);

        jLabel8.setText("ID");

        txtIDVi1.setEnabled(false);
        txtIDVi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDVi1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên Vị");

        btnThemVi1.setBackground(new java.awt.Color(102, 255, 102));
        btnThemVi1.setText("Thêm");
        btnThemVi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVi1ActionPerformed(evt);
            }
        });

        btnSuaVi1.setText("Sửa");

        btnXoaVi1.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaVi1.setText("Xóa");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnThemVi1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaVi1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaVi1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenVi1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(txtIDVi1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDVi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenVi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVi1)
                    .addComponent(btnSuaVi1)
                    .addComponent(btnXoaVi1))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Mau"));
        jPanel12.setToolTipText("");
        jPanel12.setPreferredSize(new java.awt.Dimension(400, 309));

        tblMau4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Sữa", "Trạng Thái"
            }
        ));
        tblMau4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMau4MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblMau4);

        jLabel14.setText("ID");

        txtIDMau4.setEnabled(false);
        txtIDMau4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMau4ActionPerformed(evt);
            }
        });

        btnThemMau4.setBackground(new java.awt.Color(102, 255, 102));
        btnThemMau4.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMau4.setMnemonic('T');
        btnThemMau4.setText("Add");
        btnThemMau4.setAutoscrolls(true);
        btnThemMau4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMau4ActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên Màu");

        txtTenMau4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMau4ActionPerformed(evt);
            }
        });

        btnSuaMau4.setText("Edit");
        btnSuaMau4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMau4ActionPerformed(evt);
            }
        });

        btnXoaMau4.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaMau4.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaMau4.setText("Delete");
        btnXoaMau4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMau4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnThemMau4)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaMau4)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaMau4))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDMau4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenMau4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMau4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenMau4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMau4)
                    .addComponent(btnSuaMau4)
                    .addComponent(btnXoaMau4))
                .addGap(0, 0, 0))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Mau"));

        tblMau5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Màu", "Trạng Thái"
            }
        ));
        tblMau5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMau5MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblMau5);

        jLabel16.setText("ID");

        txtIDMau5.setEnabled(false);
        txtIDMau5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMau5ActionPerformed(evt);
            }
        });

        btnThemMau5.setBackground(new java.awt.Color(102, 255, 102));
        btnThemMau5.setForeground(new java.awt.Color(255, 255, 255));
        btnThemMau5.setMnemonic('T');
        btnThemMau5.setText("Add");
        btnThemMau5.setAutoscrolls(true);
        btnThemMau5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMau5ActionPerformed(evt);
            }
        });

        jLabel17.setText("Tên Màu");

        txtTenMau5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMau5ActionPerformed(evt);
            }
        });

        btnSuaMau5.setText("Edit");
        btnSuaMau5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMau5ActionPerformed(evt);
            }
        });

        btnXoaMau5.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaMau5.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaMau5.setText("Delete");
        btnXoaMau5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMau5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnThemMau5)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaMau5)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaMau5))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDMau5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenMau5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMau5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenMau5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMau5)
                    .addComponent(btnSuaMau5)
                    .addComponent(btnXoaMau5))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tbl2Layout = new javax.swing.GroupLayout(tbl2);
        tbl2.setLayout(tbl2Layout);
        tbl2Layout.setHorizontalGroup(
            tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl2Layout.createSequentialGroup()
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tbl2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 398, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        tbl2Layout.setVerticalGroup(
            tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tbl2Layout.createSequentialGroup()
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jTabbedPane2.addTab("tab1", tbl2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnXoaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiActionPerformed
        // TODO add your handling code here:
        Loai loai = getFormLoai();
        int edit = loaiDao.delete(loai);
        if (edit > 0) {
            System.out.println("DELETE THanh COng");
            fillTableLoai();
        }
    }//GEN-LAST:event_btnXoaLoaiActionPerformed

    private void btnSuaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoaiActionPerformed
        // TODO add your handling code here: Tuấn
        Loai loai = getFormLoai();
        int edit = loaiDao.update(loai);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableLoai();
        }
    }//GEN-LAST:event_btnSuaLoaiActionPerformed

    private void txtTenLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenLoaiActionPerformed

    private void btnThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiActionPerformed
        // TODO add your handling code here:
        Loai loai = getFormLoai();
        int btnThem = loaiDao.create(loai);
        if (btnThem > 0) {
            System.out.println("Thêm Thành Công Loại");
            fillTableLoai();
        }
    }//GEN-LAST:event_btnThemLoaiActionPerformed

    private void txtIDLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDLoaiActionPerformed

    private void tblLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiMouseClicked
        // TODO add your handling code here:
        index = tblLoai.getSelectedRow();
        setFormLoai(index);

    }//GEN-LAST:event_tblLoaiMouseClicked

    private void btnXoaMau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMau1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaMau1ActionPerformed

    private void btnSuaMau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMau1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaMau1ActionPerformed

    private void txtTenSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSuaActionPerformed

    private void btnThemTenSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTenSuaActionPerformed
        // TODO add your handling code here:
        TenSua tenSua = getFormTenSua();
        int btnThem = tensuaDao.create(tenSua);
        if (btnThem > 0) {
            System.out.println("Thêm Thành Công Tên Sữa");
            fillTableTenSua();
        }
    }//GEN-LAST:event_btnThemTenSuaActionPerformed

    private void txtIDSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDSuaActionPerformed

    private void tblTenSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTenSuaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTenSuaMouseClicked

    private void btnThemViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemViActionPerformed
        // TODO add your handling code here:
        Vi vi = getFormVi();
        int btnThem = viDao.create(vi);
        if (btnThem > 0) {
            System.out.println("Thêm Thành Công Vị");
            fillTableVi();
        }
    }//GEN-LAST:event_btnThemViActionPerformed

    private void txtIDViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDViActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDViActionPerformed

    private void tblMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauMouseClicked
        // TODO add your handling code here:
        index = tblMau.getSelectedRow();
        setFormMau(index);

    }//GEN-LAST:event_tblMauMouseClicked

    private void btnXoaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauActionPerformed
        // TODO add your handling code here:
        Mau mau = getFormMau();
        int edit = mauDao.delete(mau);
        if (edit > 0) {
            System.out.println("DELETE THanh COng");
            fillTableMau();
        }
    }//GEN-LAST:event_btnXoaMauActionPerformed

    private void btnSuaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauActionPerformed
        // TODO add your handling code here:
        Mau mau = getFormMau();
        int edit = mauDao.update(mau);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableMau();
        }
    }//GEN-LAST:event_btnSuaMauActionPerformed

    private void txtTenMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMauActionPerformed

    private void btnThemMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauActionPerformed
        // TODO add your handling code here:
        Mau mau = getFormMau();
        int addMau = mauDao.create(mau);
        if (addMau > 0) {
            System.out.println("ADD THanh COng");
            fillTableMau();
        }

    }//GEN-LAST:event_btnThemMauActionPerformed

    private void txtIDMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMauActionPerformed

    private void txtIDMau3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMau3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMau3ActionPerformed

    private void btnThemMau3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMau3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMau3ActionPerformed

    private void txtTenMau3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMau3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMau3ActionPerformed

    private void btnSuaMau3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMau3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaMau3ActionPerformed

    private void btnXoaMau3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMau3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaMau3ActionPerformed

    private void tblMau3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMau3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMau3MouseClicked

    private void txtIDVi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDVi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDVi1ActionPerformed

    private void btnThemVi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVi1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemVi1ActionPerformed

    private void tblMau4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMau4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMau4MouseClicked

    private void txtIDMau4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMau4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMau4ActionPerformed

    private void btnThemMau4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMau4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMau4ActionPerformed

    private void txtTenMau4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMau4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMau4ActionPerformed

    private void btnSuaMau4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMau4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaMau4ActionPerformed

    private void btnXoaMau4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMau4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaMau4ActionPerformed

    private void tblMau5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMau5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblMau5MouseClicked

    private void txtIDMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMau5ActionPerformed

    private void btnThemMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMau5ActionPerformed

    private void txtTenMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMau5ActionPerformed

    private void btnSuaMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaMau5ActionPerformed

    private void btnXoaMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaMau5ActionPerformed

    private void btnKhoiPhucLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucLoaiActionPerformed
        // TODO add your handling code here:
        Loai loai = getFormLoai();
        int edit = loaiDao.khoiphuc(loai);
        if (edit > 0) {
            System.out.println("KHoi Phuc THanh COng");
            fillTableLoai();
        }
    }//GEN-LAST:event_btnKhoiPhucLoaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThuocTich dialog = null;
                try {
                    dialog = new ThuocTich(new java.awt.Frame(), true);
                } catch (Exception ex) {
                    Logger.getLogger(ThuocTich.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKhoiPhucLoai;
    private javax.swing.JButton btnSuaLoai;
    private javax.swing.JButton btnSuaMau;
    private javax.swing.JButton btnSuaMau1;
    private javax.swing.JButton btnSuaMau3;
    private javax.swing.JButton btnSuaMau4;
    private javax.swing.JButton btnSuaMau5;
    private javax.swing.JButton btnSuaVi;
    private javax.swing.JButton btnSuaVi1;
    private javax.swing.JButton btnThemLoai;
    private javax.swing.JButton btnThemMau;
    private javax.swing.JButton btnThemMau3;
    private javax.swing.JButton btnThemMau4;
    private javax.swing.JButton btnThemMau5;
    private javax.swing.JButton btnThemTenSua;
    private javax.swing.JButton btnThemVi;
    private javax.swing.JButton btnThemVi1;
    private javax.swing.JButton btnXoaLoai;
    private javax.swing.JButton btnXoaMau;
    private javax.swing.JButton btnXoaMau1;
    private javax.swing.JButton btnXoaMau3;
    private javax.swing.JButton btnXoaMau4;
    private javax.swing.JButton btnXoaMau5;
    private javax.swing.JButton btnXoaVi;
    private javax.swing.JButton btnXoaVi1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel tbl1;
    private javax.swing.JPanel tbl2;
    private javax.swing.JTable tblLoai;
    private javax.swing.JTable tblMau;
    private javax.swing.JTable tblMau3;
    private javax.swing.JTable tblMau4;
    private javax.swing.JTable tblMau5;
    private javax.swing.JTable tblTenSua;
    private javax.swing.JTable tblVi;
    private javax.swing.JTable tblVi1;
    private javax.swing.JTextField txtIDLoai;
    private javax.swing.JTextField txtIDMau;
    private javax.swing.JTextField txtIDMau3;
    private javax.swing.JTextField txtIDMau4;
    private javax.swing.JTextField txtIDMau5;
    private javax.swing.JTextField txtIDSua;
    private javax.swing.JTextField txtIDVi;
    private javax.swing.JTextField txtIDVi1;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTenMau;
    private javax.swing.JTextField txtTenMau3;
    private javax.swing.JTextField txtTenMau4;
    private javax.swing.JTextField txtTenMau5;
    private javax.swing.JTextField txtTenSua;
    private javax.swing.JTextField txtTenVi;
    private javax.swing.JTextField txtTenVi1;
    // End of variables declaration//GEN-END:variables
}
