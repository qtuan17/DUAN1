/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Dao.ChiTietSuaDao;
import Dao.HangDao;
import Dao.HinhDangDao;
import Dao.LoaiDao;
import Dao.MauDao;
import Dao.SizeDao;
import Dao.TenSuaDao;
import Dao.ViDao;
import Model.Hang;
import Model.HinhDang;
import Model.Loai;
import Model.Mau;
import Model.Size;
import Model.Vi;
import ViewModel.Chitietview;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuanb
 */
public class ThuocTinhSuaa extends javax.swing.JPanel {
    
    private DefaultTableModel model;
    MauDao mauDao;
    ViDao viDao;
    LoaiDao loaiDao;
    TenSuaDao tensuaDao;
    SizeDao sizeDao;
    ChiTietSuaDao chiTietSuaDao;
    HangDao hangDao;
    HinhDangDao hinhDangDao;
    int index = -1;
    /**
     * Creates new form ThuocTinhSuaa
     */
    public ThuocTinhSuaa() throws Exception {
        initComponents();
        
        mauDao = new MauDao();
        viDao = new ViDao();
        loaiDao = new LoaiDao();
        tensuaDao = new TenSuaDao();
        sizeDao = new SizeDao();
        chiTietSuaDao = new ChiTietSuaDao();
        hangDao = new HangDao();
        hinhDangDao = new HinhDangDao();
        fillTablesize();
        fillTableMau();
        fillTableVi();
//        fillTableLoai();
//        fillTableTenSua();
        fillTableChiTietSua();
        fillTableHang();
        fillTableHinhDang();

        getCBBTenMau();
        getCbbLoai();
        getCbbHang();
        getCbbVi();
        getCbbHinhDang();
        getCbbSize();
//        setVisible(true);
    }

//    void ThuocTinhSua() throws Exception{
//        
//    }
    public void getCBBTenMau() {
        List<Mau> lstTenSua = mauDao.filAll();
        for (Mau tenSua : lstTenSua) {
            cbbTenMau.addItem(tenSua.getTenMau());
        }

    }

    public int getIDMau() {
        List<Mau> lstMau = mauDao.filAll();
        int id = -1;
        int index = cbbTenMau.getSelectedIndex();
        Mau maus = lstMau.get(index);
        id = maus.getId();
//        System.out.println("line 74: "+id);
        return id;
    }

    public void getCbbSize() {
        List<Size> lstSize = sizeDao.filAll();
        for (Size size : lstSize) {
            cbbSize.addItem(size.getTenSize());
        }
    }

    public int getIDSize() {
        int id = -1;
        List<Size> lstSizes = sizeDao.filAll();
        int index = cbbSize.getSelectedIndex();
        Size size = lstSizes.get(index);
        id = size.getId();
        return id;
    }

    public void getCbbLoai() {
        List<Loai> lstLoai = loaiDao.filAll();
        for (Loai loai : lstLoai) {
            cbbLoai.addItem(loai.getTenLoai());
        }
    }

    public int getIDLoai() {
        int id = -1;
        List<Loai> lstLoai = loaiDao.filAll();
        int index = cbbLoai.getSelectedIndex();
        Loai loais = lstLoai.get(index);
        id = loais.getId();
        return id;
    }

    public void getCbbHang() {
        List<Hang> lstHang = hangDao.filAll();
        for (Hang hang : lstHang) {
            cbbHang.addItem(hang.getTenHang());
        }
    }

    public int getIDHang() {
        int id = -1;
        List<Hang> lstHang = hangDao.filAll();
        int index = cbbHang.getSelectedIndex();
        Hang hang = lstHang.get(index);
        id = hang.getId();
        return id;
    }

    public void getCbbVi() {
        List<Vi> lstVis = viDao.filAll();
        for (Vi vi : lstVis) {
            cbbVi.addItem(vi.getTenVi());
        }
    }

    public int getIDVi() {
        int id = -1;
        List<Vi> lstVis = viDao.filAll();
        int index = cbbVi.getSelectedIndex();
        Vi vi = lstVis.get(index);
        id = vi.getId();
        return id;
    }

    public void getCbbHinhDang() {
        List<HinhDang> lstHinhDang = hinhDangDao.filAll();
        for (HinhDang hinhDang : lstHinhDang) {
            cbbHinhDang.addItem(hinhDang.getHinhDang());
        }
    }

    public int getIDHinhDang() {
        int id = -1;
        List<HinhDang> lstHinhDangs = hinhDangDao.filAll();
        int index = cbbHinhDang.getSelectedIndex();
        HinhDang hinhDang = lstHinhDangs.get(index);
        id = hinhDang.getId();
        return id;
    }

    private Hang getFormHang() {
        Hang hang = new Hang();
        if (index != -1) {
            hang.setId(Integer.parseInt(txtIDHang.getText()));
        }
        hang.setTenHang(txtTenHang.getText());
        return hang;
    }

    private HinhDang getFormHinhDang() {
        HinhDang hinhDang = new HinhDang();
        if (index != -1) {
            hinhDang.setId(Integer.parseInt(txtIDHinhDang.getText()));
        }
        hinhDang.setHinhDang(txtTenHinhdang.getText());
        return hinhDang;
    }
//    private Mau getFormMau() {
//        Mau mau = new Mau();
//        if (index != -1) {
//            mau.setId(Integer.parseInt(txtIDChiTietSua.getText()));
//        }
//        mau.setTenMau(txtTenSua.getText());
//        return mau;
//    }
//

    private Vi getFormVi() {
        Vi vi = new Vi();
        if (index != -1) {
            vi.setId(Integer.parseInt(txtIDViSua.getText()));
        }
        vi.setTenVi(txtTenViSua.getText());
        return vi;
    }

//
//    private Loai getFormLoai() {
//        Loai loai = new Loai();
//        if (index != -1) {
//            loai.setId(Integer.parseInt(txtIDLoai.getText()));
//        }
//        loai.setTenLoai(txtTenLoai.getText());
//        return loai;
//    }
//
//    private TenSua getFormTenSua() {
//        TenSua tenSua = new TenSua();
//        if (index != -1) {
//            tenSua.setId(Integer.parseInt(txtIDSua.getText()));
//        }
//        tenSua.setTenSua(txtTenSua.getText());
//        return tenSua;
//    }
    private Size getFormSize() {
        Size size = new Size();
        if (index != -1) {
            size.setId(Integer.parseInt(txtIDSize.getText()));
        }
        size.setTenSize(txtTenSize.getText());
        return size;
    }
//    private void setFormChiTietSua(int index) {
//        if (index != -1) {
//            String idChiTietSua = tblChiTietSua.getValueAt(index, 0).toString();
//            String tenSua = tblChiTietSua.getValueAt(index, 1).toString();
//            txtIDChiTietSua.setText(idChiTietSua);
//            txtTenSua.setText(tenSua);
//        }
//    }
//
//    private void setFormMau(int index) {
//        if (index != -1) {
//            String idMau = tblChiTietSua.getValueAt(index, 0).toString();
//            String tenMau = tblChiTietSua.getValueAt(index, 1).toString();
//            txtIDChiTietSua.setText(idMau);
//            txtTenSua.setText(tenMau);
//        }
//    }

    private void setFormVi(int index) {
        if (index != -1) {
            String idVi = tblViSua.getValueAt(index, 0).toString();
            String tenVi = tblViSua.getValueAt(index, 1).toString();

            txtIDViSua.setText(idVi);
            txtTenViSua.setText(tenVi);
        }
    }
//
//    private void setFormLoai(int index) {
//        if (index != -1) {
//            String idLoai = tblLoai.getValueAt(index, 0).toString();
//            String tenLoai = tblLoai.getValueAt(index, 1).toString();
//
//            txtIDLoai.setText(idLoai);
//            txtTenLoai.setText(tenLoai);
//        }
//    }
//
//    private void setFormTenSua(int index) {
//        if (index != -1) {
//            String idTenSua = tblTenSua.getValueAt(index, 0).toString();
//            String tenTenSua = tblTenSua.getValueAt(index, 1).toString();
//
//            txtIDSua.setText(idTenSua);
//            txtTenSua.setText(tenTenSua);
//        }
//    }

    private void setFormSize(int index) {
        if (index != -1) {
            String idSize = tblSize.getValueAt(index, 0).toString();
            String tenSize = tblSize.getValueAt(index, 1).toString();

            txtIDSize.setText(idSize);
            txtTenSize.setText(tenSize);
        }
    }

    private void setFormHang(int index) {
        if (index != -1) {
            String idHang = tblHang.getValueAt(index, 0).toString();
            String tenHang = tblHang.getValueAt(index, 1).toString();

            txtIDHang.setText(idHang);
            txtTenHang.setText(tenHang);
        }
    }

    private void setFormHinhDang(int index) {
        if (index != -1) {
            String idHinhDang = tblHinhDang.getValueAt(index, 0).toString();
            String hinhDang = tblHinhDang.getValueAt(index, 1).toString();

            txtIDHinhDang.setText(idHinhDang);
            txtTenHinhdang.setText(hinhDang);
        }
    }

    void fillTableMau() {
        model = (DefaultTableModel) tblChiTietSua.getModel();
        model.setRowCount(0);
        try {
            List<Mau> maus = mauDao.filAll();
            if (maus.isEmpty()) {
                System.out.println("List Mau NUll");
            }
            for (Mau mau : maus) {
                Object[] row = {
                    mau.getId(),
                    mau.getTenMau(),
                    mau.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    void fillTableHang() {
        model = (DefaultTableModel) tblHang.getModel();
        model.setRowCount(0);
        try {
            List<Hang> hangs = hangDao.filAll();
            if (hangs.isEmpty()) {
                System.out.println("List Mau NUll");
            }
            for (Hang hang : hangs) {
                Object[] row = {
                    hang.getId(),
                    hang.getTenHang(),
                    hang.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    void fillTableHinhDang() {
        model = (DefaultTableModel) tblHinhDang.getModel();
        model.setRowCount(0);
        try {
            List<HinhDang> hinhDangs = hinhDangDao.filAll();
            if (hinhDangs.isEmpty()) {
                System.out.println("List Mau NUll");
            }
            for (HinhDang hinhDang : hinhDangs) {
                Object[] row = {
                    hinhDang.getId(),
                    hinhDang.getHinhDang(),
                    hinhDang.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    void fillTablesize() {
        model = (DefaultTableModel) tblSize.getModel();
        model.setRowCount(0);
        try {
            List<Size> lstSize = sizeDao.filAll();
            if (lstSize.isEmpty()) {
                System.out.println("List size NUll");
            }
            for (Size sizes : lstSize) {
                Object[] row = {
                    sizes.getId(),
                    sizes.getTenSize(),
                    sizes.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
        }
    }

    void fillTableVi() {
        model = (DefaultTableModel) tblViSua.getModel();
        model.setRowCount(0);
        try {
            List<Vi> vis = viDao.filAll();
            if (vis.isEmpty()) {
                System.out.println("List Vi Null");

            }
            for (Vi vi : vis) {
                Object[] row = {
                    vi.getId(),
                    vi.getTenVi(),
                    vi.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//    void fillTableLoai() {
//        model = (DefaultTableModel) tblLoai.getModel();
//        model.setRowCount(0);
//        try {
//            List<Loai> loais = loaiDao.filAll();
//            if (loais.isEmpty()) {
//                System.out.println("List Loai null");
//            }
//            for (Loai loai : loais) {
//                Object[] row = {
//                    loai.getId(),
//                    loai.getTenLoai(),
//                    loai.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại"
//                };
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    void fillTableTenSua() {
//        model = (DefaultTableModel) tblTenSua.getModel();
//        model.setRowCount(0);
//        try {
//            List<TenSua> tenSuas = tensuaDao.filAll();
//            if (tenSuas.isEmpty()) {
//                System.out.println("List tensua null");
//            }
//            for (TenSua tenSua : tenSuas) {
//                Object[] row = {
//                    tenSua.getId(),
//                    tenSua.getTenSua(),
//                    tenSua.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại"
//                };
//                model.addRow(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    void fillTableChiTietSua() {
        DefaultTableModel modelchitietSua = new DefaultTableModel();
        modelchitietSua = (DefaultTableModel) tblChiTietSua.getModel();
        modelchitietSua.setRowCount(0);
        try {
            List<Chitietview> chiTietSuas = chiTietSuaDao.filAll();
            if (chiTietSuas.isEmpty()) {
                System.out.println("chi tiet null");
            }
            for (Chitietview chiTietSua : chiTietSuas) {
                Object[] row = {
                    chiTietSua.getId(),
                    chiTietSua.getTenSua(),
                    chiTietSua.getTenMau(),
                    chiTietSua.getTenLoai(),
                    chiTietSua.getTenHang(),
                    chiTietSua.getTenVi(),
                    chiTietSua.getHinhDang(),
                    chiTietSua.getTenSize(),
                    chiTietSua.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại",};
                modelchitietSua.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    void fillTableSize() {
//        DefaultTableModel modelsize = new DefaultTableModel();
//        modelsize = (DefaultTableModel) tblSize.getModel();
//        modelsize.setRowCount(0);
//        System.out.println("line 235");
//        try {
//            List<Size> sizes = sizeDao.filAll();
//            if (sizes.isEmpty()) {
//                System.out.println("list size null");
//            }
//            for (Size size : sizes) {
//                Object[] row = {
//                    size.getId(),
//                    size.getTenSize(),
//                    size.getTrangThai() == 1 ? "Tồn Tại" : "Không Tồn Tại"
//                };
//                modelsize.addRow(row);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        tbl1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIDChiTietSua = new javax.swing.JTextField();
        btnThemAll = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnSuaAll = new javax.swing.JButton();
        btnXoaMau = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietSua = new javax.swing.JTable();
        btnKhoiPhucMau = new javax.swing.JButton();
        txtTenSua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbbTenMau = new javax.swing.JComboBox<>();
        cbbLoai = new javax.swing.JComboBox<>();
        txtTrangThai = new javax.swing.JTextField();
        cbbHang = new javax.swing.JComboBox<>();
        cbbVi = new javax.swing.JComboBox<>();
        cbbHinhDang = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        tbl2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtIDSize = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenSize = new javax.swing.JTextField();
        btnThemSize = new javax.swing.JButton();
        btnSuaSize = new javax.swing.JButton();
        btnXoaSize = new javax.swing.JButton();
        BangHang = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHang = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtIDHang = new javax.swing.JTextField();
        btnThemHang = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtTenHang = new javax.swing.JTextField();
        btnSuaHang = new javax.swing.JButton();
        btnXoaHang = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblHinhDang = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtIDHinhDang = new javax.swing.JTextField();
        btnThemMau5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtTenHinhdang = new javax.swing.JTextField();
        btnSuaMau5 = new javax.swing.JButton();
        btnXoaMau5 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblViSua = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        txtIDViSua = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTenViSua = new javax.swing.JTextField();
        btnThemVisua = new javax.swing.JButton();
        btnSuaVisua = new javax.swing.JButton();
        btnXoaViSua = new javax.swing.JButton();
        btnKhoiPhucVisua = new javax.swing.JButton();

        jTabbedPane2.setFocusable(false);
        jTabbedPane2.setName("Bảng 1"); // NOI18N
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(400, 704));

        tbl1.setPreferredSize(new java.awt.Dimension(1000, 669));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("ID");

        txtIDChiTietSua.setEnabled(false);
        txtIDChiTietSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDChiTietSuaActionPerformed(evt);
            }
        });

        btnThemAll.setBackground(new java.awt.Color(102, 255, 102));
        btnThemAll.setForeground(new java.awt.Color(255, 255, 255));
        btnThemAll.setMnemonic('T');
        btnThemAll.setText("Add");
        btnThemAll.setAutoscrolls(true);
        btnThemAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemAllActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên Sữa");

        btnSuaAll.setText("Edit");
        btnSuaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaAllActionPerformed(evt);
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

        tblChiTietSua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Sữa", "Tên Màu", "Tên Loại", "Hãng", "Vị Sữa", "Hình Dáng", "Size", "Trạng Thái"
            }
        ));
        tblChiTietSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSuaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietSua);

        btnKhoiPhucMau.setText("Khôi Phục");
        btnKhoiPhucMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucMauActionPerformed(evt);
            }
        });

        txtTenSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSuaActionPerformed(evt);
            }
        });

        jLabel4.setText("Trạng Thái");

        jLabel5.setText("Tên Loại");

        jLabel10.setText("Tên Màu");

        jLabel11.setText("Tên Hãng");

        jLabel13.setText("Hình Dáng");

        jLabel18.setText("Tên Vị");

        jLabel19.setText("Size");

        cbbTenMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenMauActionPerformed(evt);
            }
        });

        cbbLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiActionPerformed(evt);
            }
        });

        txtTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiActionPerformed(evt);
            }
        });

        cbbHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbHangActionPerformed(evt);
            }
        });

        cbbVi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbViActionPerformed(evt);
            }
        });

        cbbSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDChiTietSua)
                    .addComponent(btnThemAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaMau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKhoiPhucMau, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(txtTenSua)
                    .addComponent(cbbTenMau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTrangThai)
                    .addComponent(cbbHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbVi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbHinhDang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIDChiTietSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbHinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(btnThemAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuaAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoaMau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnKhoiPhucMau)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tbl1Layout = new javax.swing.GroupLayout(tbl1);
        tbl1.setLayout(tbl1Layout);
        tbl1Layout.setHorizontalGroup(
            tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 161, Short.MAX_VALUE))
        );
        tbl1Layout.setVerticalGroup(
            tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Quản Lí Sữa", tbl1);

        tbl2.setPreferredSize(new java.awt.Dimension(1000, 669));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Vị"), "Size"));

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSize);

        jLabel8.setText("ID");

        txtIDSize.setEnabled(false);
        txtIDSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDSizeActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên Vị");

        txtTenSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSizeActionPerformed(evt);
            }
        });

        btnThemSize.setBackground(new java.awt.Color(102, 255, 102));
        btnThemSize.setText("Thêm");
        btnThemSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSizeActionPerformed(evt);
            }
        });

        btnSuaSize.setText("Sửa");

        btnXoaSize.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaSize.setText("Xóa");
        btnXoaSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIDSize, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnXoaSize)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnThemSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuaSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
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
                        .addComponent(txtIDSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaSize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaSize)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BangHang.setBorder(javax.swing.BorderFactory.createTitledBorder("Hãng"));
        BangHang.setToolTipText("");
        BangHang.setPreferredSize(new java.awt.Dimension(400, 309));

        tblHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Hãng", "Trạng Thái"
            }
        ));
        tblHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblHang);

        jLabel14.setText("ID");

        txtIDHang.setEnabled(false);
        txtIDHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDHangActionPerformed(evt);
            }
        });

        btnThemHang.setBackground(new java.awt.Color(102, 255, 102));
        btnThemHang.setForeground(new java.awt.Color(255, 255, 255));
        btnThemHang.setMnemonic('T');
        btnThemHang.setText("Add");
        btnThemHang.setAutoscrolls(true);
        btnThemHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHangActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên Hãng");

        txtTenHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenHangMouseClicked(evt);
            }
        });
        txtTenHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHangActionPerformed(evt);
            }
        });

        btnSuaHang.setText("Edit");
        btnSuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHangActionPerformed(evt);
            }
        });

        btnXoaHang.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaHang.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaHang.setText("Delete");
        btnXoaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BangHangLayout = new javax.swing.GroupLayout(BangHang);
        BangHang.setLayout(BangHangLayout);
        BangHangLayout.setHorizontalGroup(
            BangHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BangHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSuaHang)
                    .addComponent(txtIDHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(btnXoaHang)
                    .addComponent(btnThemHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BangHangLayout.setVerticalGroup(
            BangHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangHangLayout.createSequentialGroup()
                .addGroup(BangHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BangHangLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnThemHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaHang)
                        .addGap(12, 12, 12)
                        .addComponent(btnXoaHang)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Hình Dáng"));

        tblHinhDang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHinhDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHinhDangMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblHinhDang);

        jLabel16.setText("ID");

        txtIDHinhDang.setEnabled(false);
        txtIDHinhDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDHinhDangActionPerformed(evt);
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

        jLabel17.setText("Tên Hình Dáng");

        txtTenHinhdang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHinhdangActionPerformed(evt);
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
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDHinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenHinhdang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(btnThemMau5)
                    .addComponent(btnSuaMau5)
                    .addComponent(btnXoaMau5)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDHinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenHinhdang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnThemMau5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaMau5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaMau5))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Vị"), "Vị"));

        tblViSua.setModel(new javax.swing.table.DefaultTableModel(
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
        tblViSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViSuaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblViSua);

        jLabel20.setText("ID");

        txtIDViSua.setEnabled(false);
        txtIDViSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDViSuaActionPerformed(evt);
            }
        });

        jLabel21.setText("Tên Vị");

        txtTenViSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenViSuaMouseClicked(evt);
            }
        });
        txtTenViSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenViSuaActionPerformed(evt);
            }
        });

        btnThemVisua.setBackground(new java.awt.Color(102, 255, 102));
        btnThemVisua.setText("Thêm");
        btnThemVisua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVisuaActionPerformed(evt);
            }
        });

        btnSuaVisua.setText("Sửa");
        btnSuaVisua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVisuaActionPerformed(evt);
            }
        });

        btnXoaViSua.setBackground(new java.awt.Color(255, 102, 102));
        btnXoaViSua.setText("Xóa");
        btnXoaViSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaViSuaActionPerformed(evt);
            }
        });

        btnKhoiPhucVisua.setText("Khôi Phục");
        btnKhoiPhucVisua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucVisuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenViSua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDViSua, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnThemVisua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaVisua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaViSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhoiPhucVisua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDViSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenViSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemVisua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaVisua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaViSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhoiPhucVisua)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tbl2Layout = new javax.swing.GroupLayout(tbl2);
        tbl2.setLayout(tbl2Layout);
        tbl2Layout.setHorizontalGroup(
            tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 550, Short.MAX_VALUE))
        );
        tbl2Layout.setVerticalGroup(
            tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl2Layout.createSequentialGroup()
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BangHang, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lí Chi Tiết Sữa", tbl2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDChiTietSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDChiTietSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDChiTietSuaActionPerformed

    private void btnThemAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemAllActionPerformed
        // TODO add your handling code here:
        //        ChiTietSua chiTietSua = getFormChiTietSua();
        //        int addChiTietSua = chiTietSuaDao.create(chiTietSua);
        //        if (addChiTietSua > 0) {
            //            System.out.println("ADD THanh COng");
            //            fillTableChiTietSua();

            //        }
        //        JOptionPane.showMessageDialog(btnThemAll, "bạn đã thêm thành công");
    }//GEN-LAST:event_btnThemAllActionPerformed

    private void btnSuaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaAllActionPerformed
        //        // TODO add your handling code here:
        //        Mau mau = getFormMau();
        //        int edit = mauDao.update(mau);
        //        if (edit > 0) {
            //            System.out.println("edit THanh COng");
            //            fillTableMau();
            //        }
    }//GEN-LAST:event_btnSuaAllActionPerformed

    private void btnXoaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauActionPerformed
        //        // TODO add your handling code here:
        //        Mau mau = getFormMau();
        //        int edit = mauDao.delete(mau);
        //        if (edit > 0) {
            //            System.out.println("DELETE THanh COng");
            //            fillTableMau();
            //        }
    }//GEN-LAST:event_btnXoaMauActionPerformed

    private void tblChiTietSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSuaMouseClicked
        //        // TODO add your handling code here:
        //        index = tblMau.getSelectedRow();
        //        setFormMau(index);
    }//GEN-LAST:event_tblChiTietSuaMouseClicked

    private void btnKhoiPhucMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucMauActionPerformed
        // TODO add your handling code here:
        //        if (index != -1) {
            //            Mau mau = getFormMau();
            //            int edit = mauDao.khoiphuc(mau);
            //            if (edit > 0) {
                //                System.out.println("KHoi Phuc THanh COng");
                //                fillTableMau();
                //            }
            //        }
    }//GEN-LAST:event_btnKhoiPhucMauActionPerformed

    private void txtTenSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSuaActionPerformed

    private void cbbTenMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenMauActionPerformed
        // TODO add your handling code here:
        System.out.println("line 1298L: " + getIDMau());
    }//GEN-LAST:event_cbbTenMauActionPerformed

    private void cbbLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiActionPerformed
        // TODO add your handling code here:
        System.out.println("Loai id: " + getIDLoai());
    }//GEN-LAST:event_cbbLoaiActionPerformed

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed

    private void cbbHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHangActionPerformed
        // TODO add your handling code here:
        System.out.println("Loai id: " + getIDHang());
    }//GEN-LAST:event_cbbHangActionPerformed

    private void cbbViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbViActionPerformed
        // TODO add your handling code here:
        System.out.println("Vị id: " + getIDVi());
    }//GEN-LAST:event_cbbViActionPerformed

    private void cbbSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbSizeActionPerformed

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSizeMouseClicked

    private void txtIDSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDSizeActionPerformed

    private void txtTenSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSizeActionPerformed

    private void btnThemSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSizeActionPerformed
        // TODO add your handling code here:
        Size size = getFormSize();
        int addSize = sizeDao.create(size);
        if (addSize > 0) {
            System.out.println("ADD THanh COng");
            fillTablesize();
        }
    }//GEN-LAST:event_btnThemSizeActionPerformed

    private void btnXoaSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSizeActionPerformed
        // TODO add your handling code here:
        Size size = getFormSize();
        int delete = sizeDao.delete(size);
        if (delete > 0) {
            System.out.println("DELETE THanh COng");
            fillTablesize();
        }
    }//GEN-LAST:event_btnXoaSizeActionPerformed

    private void tblHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangMouseClicked
        // TODO add your handling code here:
        index = tblHang.getSelectedRow();
        setFormHang(index);
    }//GEN-LAST:event_tblHangMouseClicked

    private void txtIDHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDHangActionPerformed

    private void btnThemHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHangActionPerformed
        // TODO add your handling code here:
        Hang hang = getFormHang();
        int addHang = hangDao.create(hang);
        if (addHang > 0) {
            System.out.println("ADD THanh COng");
            fillTableHang();
        }
    }//GEN-LAST:event_btnThemHangActionPerformed

    private void txtTenHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenHangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHangMouseClicked

    private void txtTenHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHangActionPerformed

    private void btnSuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHangActionPerformed
        // TODO add your handling code here:
        Hang hang = getFormHang();
        int edit = hangDao.update(hang);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableHang();
        }
    }//GEN-LAST:event_btnSuaHangActionPerformed

    private void btnXoaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHangActionPerformed
        // TODO add your handling code here:
        Hang hang = getFormHang();
        int edit = hangDao.delete(hang);
        if (edit > 0) {
            System.out.println("DELETE THanh COng");
            fillTableHang();
        }
    }//GEN-LAST:event_btnXoaHangActionPerformed

    private void tblHinhDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHinhDangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHinhDangMouseClicked

    private void txtIDHinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDHinhDangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDHinhDangActionPerformed

    private void btnThemMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMau5ActionPerformed

    private void txtTenHinhdangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHinhdangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHinhdangActionPerformed

    private void btnSuaMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuaMau5ActionPerformed

    private void btnXoaMau5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMau5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaMau5ActionPerformed

    private void tblViSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViSuaMouseClicked
        // TODO add your handling code here:
        index = tblViSua.getSelectedRow();
        setFormVi(index);
    }//GEN-LAST:event_tblViSuaMouseClicked

    private void txtIDViSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDViSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDViSuaActionPerformed

    private void txtTenViSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenViSuaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenViSuaMouseClicked

    private void txtTenViSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenViSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenViSuaActionPerformed

    private void btnThemVisuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVisuaActionPerformed
        // TODO add your handling code here:
        Vi vi = getFormVi();
        int addVi = viDao.create(vi);
        if (addVi > 0) {
            System.out.println("ADD THanh COng");
            fillTableVi();
        }
    }//GEN-LAST:event_btnThemVisuaActionPerformed

    private void btnSuaVisuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVisuaActionPerformed
        // TODO add your handling code here:
        Vi vi = getFormVi();
        int edit = viDao.update(vi);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableVi();
        }
    }//GEN-LAST:event_btnSuaVisuaActionPerformed

    private void btnXoaViSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaViSuaActionPerformed
        // TODO add your handling code here:
        Vi vi = getFormVi();
        int edit = viDao.delete(vi);
        if (edit > 0) {
            System.out.println("DELETE THanh COng");
            fillTableVi();
        }
    }//GEN-LAST:event_btnXoaViSuaActionPerformed

    private void btnKhoiPhucVisuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucVisuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhoiPhucVisuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BangHang;
    private javax.swing.JButton btnKhoiPhucMau;
    private javax.swing.JButton btnKhoiPhucVisua;
    private javax.swing.JButton btnSuaAll;
    private javax.swing.JButton btnSuaHang;
    private javax.swing.JButton btnSuaMau5;
    private javax.swing.JButton btnSuaSize;
    private javax.swing.JButton btnSuaVisua;
    private javax.swing.JButton btnThemAll;
    private javax.swing.JButton btnThemHang;
    private javax.swing.JButton btnThemMau5;
    private javax.swing.JButton btnThemSize;
    private javax.swing.JButton btnThemVisua;
    private javax.swing.JButton btnXoaHang;
    private javax.swing.JButton btnXoaMau;
    private javax.swing.JButton btnXoaMau5;
    private javax.swing.JButton btnXoaSize;
    private javax.swing.JButton btnXoaViSua;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbHinhDang;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTenMau;
    private javax.swing.JComboBox<String> cbbVi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel tbl1;
    private javax.swing.JPanel tbl2;
    private javax.swing.JTable tblChiTietSua;
    private javax.swing.JTable tblHang;
    private javax.swing.JTable tblHinhDang;
    private javax.swing.JTable tblSize;
    private javax.swing.JTable tblViSua;
    private javax.swing.JTextField txtIDChiTietSua;
    private javax.swing.JTextField txtIDHang;
    private javax.swing.JTextField txtIDHinhDang;
    private javax.swing.JTextField txtIDSize;
    private javax.swing.JTextField txtIDViSua;
    private javax.swing.JTextField txtTenHang;
    private javax.swing.JTextField txtTenHinhdang;
    private javax.swing.JTextField txtTenSize;
    private javax.swing.JTextField txtTenSua;
    private javax.swing.JTextField txtTenViSua;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
