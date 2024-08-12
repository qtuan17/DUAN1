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
import Dao.TenSuaDao;
import Dao.ViDao;
import Model.ChiTietSua;
import Model.Hang;
import Model.HinhDang;
import Model.Loai;
import Model.Mau;
import Model.TenSua;
import Model.Vi;
import ViewModel.Chitietview;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuanb
 */
public class SanPhamPanel extends javax.swing.JPanel {

    private DefaultTableModel model;
    MauDao mauDao;
    ViDao viDao;
    LoaiDao loaiDao;
    TenSuaDao tensuaDao;
    HangDao hangDao;
    HinhDangDao hinhDangDao;
    ChiTietSuaDao chiTietSuaDao;
    int index = -1;

    public SanPhamPanel(java.awt.Frame parent, boolean modal) throws Exception {
        initComponents();
        
        mauDao = new MauDao();
        viDao = new ViDao();
        loaiDao = new LoaiDao();
        tensuaDao = new TenSuaDao();
        hangDao = new HangDao();
        hinhDangDao = new HinhDangDao();
        chiTietSuaDao = new ChiTietSuaDao();
        fillTableMau();
        fillTableVi();
        fillTableLoai();
        fillTableTenSua();
        fillTableChiTietSua();
        fillTableHang();
        fillTableHinhDang();

        getCBBTenMau();
        getCbbLoai();
        getCbbHang();
        getCbbVi();
        getCbbHinhDang();
        getCbbTen();

    }

    SanPhamPanel() {
        initComponents();
        
    }

    public void getCBBTenMau() {
        List<Mau> lstMau = mauDao.filAll();
        for (Mau mau : lstMau) {
            cbbTenMau.addItem(mau.getTenMau());
        }

    }

    public int getIDMau() {
        List<Mau> lstMau = mauDao.filAll();
        int id = -1;
        int index = cbbTenMau.getSelectedIndex();
        Mau maus = lstMau.get(index);
        id = maus.getId();
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

    public void getCbbTen() {
        List<TenSua> lstSua = tensuaDao.filAll();
        for (TenSua sua : lstSua) {
            cbbTenSua.addItem(sua.getTenSua());
        }
    }

    public int getIDTen() {
        int id = -1;
        List<TenSua> lstSua = tensuaDao.filAll();
        int index = cbbTenSua.getSelectedIndex();
        TenSua sua = lstSua.get(index);
        id = sua.getId();
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

    private Mau getFormMau() {
        Mau mau = new Mau();
        if (index != -1) {
            mau.setId(Integer.parseInt(txtIDMau.getText()));
        }
        mau.setTenMau(txtTenMau.getText());
        return mau;
    }
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
    private Loai getFormLoai() {
        Loai loai = new Loai();
        if (index != -1) {
            loai.setId(Integer.parseInt(txtIDLoai.getText()));
        }
        loai.setTenLoai(txtTenLoai.getText());
        return loai;
    }
//

    private TenSua getFormTenSua() {
        TenSua tenSua = new TenSua();
        if (index != -1) {
            tenSua.setId(Integer.parseInt(txtIDTenSua1.getText()));
        }
        tenSua.setTenSua(txtTenSua1.getText());
        return tenSua;
    }
//    private ChiTietSua getFormChiTietSua() {
//        ChiTietSua chiTietSua = new ChiTietSua();
//        if (index != -1) {
//            chiTietSua.setId(Integer.parseInt(txt.getText()));
//        }
//        size.setTenSize(txtTenLoai.getText());
//        return size;
//    }
//    private void setFormChiTietSua(int index) {
//        if (index != -1) {
//            String idChiTietSua = tblChiTietSua.getValueAt(index, 0).toString();
//            String tenSua = tblChiTietSua.getValueAt(index, 1).toString();
//            txtIDChiTietSua.setText(idChiTietSua);
//            txtTenSua.setText(tenSua);
//        }
//    }

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
            String idVi = tblViSua.getValueAt(index, 0).toString();
            String tenVi = tblViSua.getValueAt(index, 1).toString();

            txtIDViSua.setText(idVi);
            txtTenViSua.setText(tenVi);
        }
    }
//

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

            txtIDTenSua1.setText(idTenSua);
            txtTenSua1.setText(tenTenSua);
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

    private ChiTietSua getFormChiTietSua() {
        try {
            int gia = Integer.parseInt(txtGia.getText());
            int soLuong = Integer.parseInt(txtSoLuong.getText());
            String stringHanSD = txtHanSuDung.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date hanSD = dateFormat.parse(stringHanSD);
            java.sql.Date sqlDate = new java.sql.Date(hanSD.getTime());
            ChiTietSua sua = new ChiTietSua(1, this.getIDTen(), this.getIDMau(), this.getIDLoai(), this.getIDHang(),
                    this.getIDVi(), this.getIDHinhDang(), 1, gia, soLuong, sqlDate);
            return sua;
        } catch (Exception e) {
            System.out.println("Date time sai định dạng");
            JOptionPane.showMessageDialog(this, "Datetime sai định dạng (yyyy-MM-dd)");
            return null;
        }
    }

    void fillTableMau() {
        model = (DefaultTableModel) tblMau.getModel();
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

    void fillTableLoai() {
        model = (DefaultTableModel) tblLoai.getModel();
        model.setRowCount(0);
        try {
            List<Loai> loais = loaiDao.filAll();
            if (loais.isEmpty()) {
                System.out.println("List Loai null");
            }
            for (Loai loai : loais) {
                Object[] row = {
                    loai.getId(),
                    loai.getTenLoai(),
                    loai.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillTableTenSua() {
        model = (DefaultTableModel) tblTenSua.getModel();
        model.setRowCount(0);
        try {
            List<TenSua> tenSuas = tensuaDao.filAll();
            if (tenSuas.isEmpty()) {
                System.out.println("List tensua null");
            }
            for (TenSua tenSua : tenSuas) {
                Object[] row = {
                    tenSua.getId(),
                    tenSua.getTenSua(),
                    tenSua.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng"
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
                    chiTietSua.getGia(),
                    chiTietSua.getHanSuDung(),
                    chiTietSua.getTrangThai() == 1 ? "Còn Hàng" : "Hết Hàng",};
                modelchitietSua.addRow(row);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbbTenMau = new javax.swing.JComboBox<>();
        cbbLoai = new javax.swing.JComboBox<>();
        cbbHang = new javax.swing.JComboBox<>();
        cbbVi = new javax.swing.JComboBox<>();
        cbbHinhDang = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtHanSuDung = new javax.swing.JTextField();
        cbbTenSua = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        tbl2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblLoai = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtIDLoai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        btnThemLoai = new javax.swing.JButton();
        btnSuaLoai = new javax.swing.JButton();
        btnXoaLoai = new javax.swing.JButton();
        btnKhoiPhucLoai = new javax.swing.JButton();
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
        btnKhoiPhucHang = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblHinhDang = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtIDHinhDang = new javax.swing.JTextField();
        btnThemHinhDang = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtTenHinhdang = new javax.swing.JTextField();
        btnSuaHinhDang = new javax.swing.JButton();
        btnXoaHinhDang = new javax.swing.JButton();
        btnKhoiPhucHinhDang = new javax.swing.JButton();
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
        jPanel14 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblTenSua = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        txtIDTenSua1 = new javax.swing.JTextField();
        btnThemsua = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtTenSua1 = new javax.swing.JTextField();
        btnSuasua = new javax.swing.JButton();
        btnXoasua = new javax.swing.JButton();
        btnKhoiPhucTenSua = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblMau = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        txtIDMau = new javax.swing.JTextField();
        btnThemMau = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txtTenMau = new javax.swing.JTextField();
        btnSuaMau = new javax.swing.JButton();
        btnXoaMaua = new javax.swing.JButton();
        btnKhoiPhucMau1 = new javax.swing.JButton();

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

        btnThemAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add.png"))); // NOI18N
        btnThemAll.setMnemonic('T');
        btnThemAll.setText("Thêm ");
        btnThemAll.setAutoscrolls(true);
        btnThemAll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThemAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemAllActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên Sữa");

        btnSuaAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Edit.png"))); // NOI18N
        btnSuaAll.setText("Sửa");
        btnSuaAll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSuaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaAllActionPerformed(evt);
            }
        });

        btnXoaMau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        btnXoaMau.setText("Xóa");
        btnXoaMau.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauActionPerformed(evt);
            }
        });

        tblChiTietSua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên Sữa", "Tên Màu", "Tên Loại", "Hãng", "Vị Sữa", "Hình Dáng", "Giá", " Hạn Sử Dụng", "Trạng Thái"
            }
        ));
        tblChiTietSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietSuaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTietSua);

        jLabel5.setText("Tên Loại");

        jLabel10.setText("Tên Màu");

        jLabel11.setText("Tên Hãng");

        jLabel13.setText("Hình Dáng");

        jLabel18.setText("Tên Vị");

        jLabel19.setText("Giá");

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

        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        jLabel1.setText("Hạn Sử Dụng");

        jLabel4.setText("Số Lượng");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 3, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnThemAll, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(txtIDChiTietSua, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbTenMau, 0, 143, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbLoai, 0, 143, Short.MAX_VALUE)
                                    .addComponent(cbbTenSua, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(147, 147, 147)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbbHang, 0, 143, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGia)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)
                                            .addComponent(cbbHinhDang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                        .addGap(146, 146, 146)
                                        .addComponent(txtHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbbVi, 0, 143, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(146, 146, 146)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel4))
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 401, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDChiTietSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbHinhDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTenSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemAll, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuaAll, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tbl1Layout = new javax.swing.GroupLayout(tbl1);
        tbl1.setLayout(tbl1Layout);
        tbl1Layout.setHorizontalGroup(
            tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(580, Short.MAX_VALUE))
        );
        tbl1Layout.setVerticalGroup(
            tbl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Quản Lí Sữa", tbl1);

        tbl2.setPreferredSize(new java.awt.Dimension(1000, 669));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Loại"));

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
        jScrollPane5.setViewportView(tblLoai);

        jLabel8.setText("ID");

        txtIDLoai.setEnabled(false);
        txtIDLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDLoaiActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên Loại");

        txtTenLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenLoaiActionPerformed(evt);
            }
        });

        btnThemLoai.setBackground(new java.awt.Color(102, 255, 102));
        btnThemLoai.setText("Thêm");
        btnThemLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiActionPerformed(evt);
            }
        });

        btnSuaLoai.setText("Sửa");
        btnSuaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiActionPerformed(evt);
            }
        });

        btnXoaLoai.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaLoai.setText("Xóa");
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

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSuaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhoiPhucLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
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
                .addContainerGap(59, Short.MAX_VALUE))
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
        btnThemHang.setMnemonic('T');
        btnThemHang.setText("Thêm");
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

        btnSuaHang.setText("Sửa");
        btnSuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHangActionPerformed(evt);
            }
        });

        btnXoaHang.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaHang.setText("Xóa");
        btnXoaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHangActionPerformed(evt);
            }
        });

        btnKhoiPhucHang.setText("Khôi Phục");
        btnKhoiPhucHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BangHangLayout = new javax.swing.GroupLayout(BangHang);
        BangHang.setLayout(BangHangLayout);
        BangHangLayout.setHorizontalGroup(
            BangHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BangHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BangHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIDHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addGroup(BangHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnThemHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhoiPhucHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhoiPhucHang)))
                .addContainerGap(43, Short.MAX_VALUE))
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
                "ID", "Tên Hình", "Trạng Thái"
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

        btnThemHinhDang.setBackground(new java.awt.Color(102, 255, 102));
        btnThemHinhDang.setMnemonic('T');
        btnThemHinhDang.setText("Thêm");
        btnThemHinhDang.setAutoscrolls(true);
        btnThemHinhDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHinhDangActionPerformed(evt);
            }
        });

        jLabel17.setText("Tên Hình Dáng");

        txtTenHinhdang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHinhdangActionPerformed(evt);
            }
        });

        btnSuaHinhDang.setText("Sửa");
        btnSuaHinhDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHinhDangActionPerformed(evt);
            }
        });

        btnXoaHinhDang.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaHinhDang.setText("Xóa");
        btnXoaHinhDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHinhDangActionPerformed(evt);
            }
        });

        btnKhoiPhucHinhDang.setText("Khôi Phục");
        btnKhoiPhucHinhDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucHinhDangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIDHinhDang, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTenHinhdang))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnThemHinhDang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaHinhDang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaHinhDang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhoiPhucHinhDang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addComponent(txtTenHinhdang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnThemHinhDang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaHinhDang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaHinhDang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhoiPhucHinhDang))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Vị"));

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

        btnXoaViSua.setBackground(new java.awt.Color(255, 51, 51));
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
                .addGap(0, 59, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên Sữa"));

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
        jScrollPane9.setViewportView(tblTenSua);

        jLabel22.setText("ID");

        txtIDTenSua1.setEnabled(false);
        txtIDTenSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDTenSua1ActionPerformed(evt);
            }
        });

        btnThemsua.setBackground(new java.awt.Color(102, 255, 102));
        btnThemsua.setMnemonic('T');
        btnThemsua.setText("Thêm");
        btnThemsua.setAutoscrolls(true);
        btnThemsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemsuaActionPerformed(evt);
            }
        });

        jLabel23.setText("Tên Sữa");

        txtTenSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSua1ActionPerformed(evt);
            }
        });

        btnSuasua.setText("Sửa");
        btnSuasua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuasuaActionPerformed(evt);
            }
        });

        btnXoasua.setBackground(new java.awt.Color(255, 51, 51));
        btnXoasua.setText("Xóa");
        btnXoasua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoasuaActionPerformed(evt);
            }
        });

        btnKhoiPhucTenSua.setText("Khôi Phục");
        btnKhoiPhucTenSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucTenSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIDTenSua1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSua1)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSuasua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addComponent(btnThemsua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnXoasua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKhoiPhucTenSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDTenSua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnThemsua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuasua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoasua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhoiPhucTenSua))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Màu"));

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
        jScrollPane10.setViewportView(tblMau);

        jLabel24.setText("ID");

        txtIDMau.setEnabled(false);
        txtIDMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDMauActionPerformed(evt);
            }
        });

        btnThemMau.setBackground(new java.awt.Color(102, 255, 102));
        btnThemMau.setMnemonic('T');
        btnThemMau.setText("Thêm");
        btnThemMau.setAutoscrolls(true);
        btnThemMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMauActionPerformed(evt);
            }
        });

        jLabel25.setText("Tên Màu");

        txtTenMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenMauActionPerformed(evt);
            }
        });

        btnSuaMau.setText("Sửa");
        btnSuaMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaMauActionPerformed(evt);
            }
        });

        btnXoaMaua.setBackground(new java.awt.Color(255, 51, 51));
        btnXoaMaua.setText("Xóa");
        btnXoaMaua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaMauaActionPerformed(evt);
            }
        });

        btnKhoiPhucMau1.setText("Khôi Phục");
        btnKhoiPhucMau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoiPhucMau1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIDMau, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMau)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnKhoiPhucMau1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaMaua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaMau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemMau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnThemMau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSuaMau)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaMaua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKhoiPhucMau1))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tbl2Layout = new javax.swing.GroupLayout(tbl2);
        tbl2.setLayout(tbl2Layout);
        tbl2Layout.setHorizontalGroup(
            tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BangHang, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(tbl2Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tbl2Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        tbl2Layout.setVerticalGroup(
            tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl2Layout.createSequentialGroup()
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(tbl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BangHang, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(88, 88, 88))
        );

        jTabbedPane2.addTab("Quản Lí Chi Tiết Sữa", tbl2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1428, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDChiTietSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDChiTietSuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDChiTietSuaActionPerformed

    private void btnThemAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemAllActionPerformed
        ChiTietSua chiTietSua = getFormChiTietSua();
        if (chiTietSua != null) {
            int addChiTietSua = chiTietSuaDao.create(chiTietSua);
            if (addChiTietSua > 0) {
                System.out.println("ADD THanh COng");
                fillTableChiTietSua();
            }
            JOptionPane.showMessageDialog(btnThemAll, "Thêm thành công");
        }

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
                // TODO add your handling code here:
//                ChiTietSua chiTietSua = getFormChiTietSua();
//                int edit = chiTietSuaDao.delete(chiTietSua);
//                if (edit > 0) {
//                    System.out.println("DELETE THanh COng");
//                    fillTableChiTietSua();
//                }
    }//GEN-LAST:event_btnXoaMauActionPerformed

    private void tblChiTietSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietSuaMouseClicked
        // TODO add your handling code here:
        index = tblChiTietSua.getSelectedRow();
        setFormMau(index);
    }//GEN-LAST:event_tblChiTietSuaMouseClicked

    private void cbbTenMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenMauActionPerformed
        // TODO add your handling code here:
        System.out.println("line 1298L: " + getIDMau());
    }//GEN-LAST:event_cbbTenMauActionPerformed

    private void cbbLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiActionPerformed
        // TODO add your handling code here:
        System.out.println("Loai id: " + getIDLoai());
    }//GEN-LAST:event_cbbLoaiActionPerformed

    private void cbbHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbHangActionPerformed
        // TODO add your handling code here:
        System.out.println("Loai id: " + getIDHang());
    }//GEN-LAST:event_cbbHangActionPerformed

    private void cbbViActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbViActionPerformed
        // TODO add your handling code here:
        System.out.println("Vị id: " + getIDVi());
    }//GEN-LAST:event_cbbViActionPerformed

    private void tblLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiMouseClicked
        // TODO add your handling code here:
        index = tblLoai.getSelectedRow();
        setFormLoai(index);
    }//GEN-LAST:event_tblLoaiMouseClicked

    private void txtIDLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDLoaiActionPerformed

    private void txtTenLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenLoaiActionPerformed

    private void btnThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiActionPerformed
        // TODO add your handling code here:
        Loai loai = getFormLoai();
        int addloai = loaiDao.create(loai);
        if (addloai > 0) {
            System.out.println("ADD THanh COng");
            fillTableLoai();
        }
    }//GEN-LAST:event_btnThemLoaiActionPerformed

    private void btnSuaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoaiActionPerformed
        // TODO add your handling code here:
        Loai loai = getFormLoai();
        int edit = loaiDao.update(loai);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableLoai();
        }
    }//GEN-LAST:event_btnSuaLoaiActionPerformed

    private void btnXoaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiActionPerformed
        // TODO add your handling code here:
        Loai loai = getFormLoai();
        int delete = loaiDao.delete(loai);
        if (delete > 0) {
            System.out.println("DELETE THanh COng");
            fillTableLoai();
        }
    }//GEN-LAST:event_btnXoaLoaiActionPerformed

    private void btnKhoiPhucLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucLoaiActionPerformed
        // TODO add your handling code here:
        if (index != -1) {
            Loai loai = getFormLoai();
            int edit = loaiDao.khoiphuc(loai);
            if (edit > 0) {
                System.out.println("KHoi Phuc THanh COng");
                fillTableLoai();
            }
        }
    }//GEN-LAST:event_btnKhoiPhucLoaiActionPerformed

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

    private void btnKhoiPhucHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucHangActionPerformed
        // TODO add your handling code here:
        if (index != -1) {
            Hang hang = getFormHang();
            int edit = hangDao.khoiphuc(hang);
            if (edit > 0) {
                System.out.println("KHoi Phuc THanh COng");
                fillTableHang();
            }
        }
    }//GEN-LAST:event_btnKhoiPhucHangActionPerformed

    private void tblHinhDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHinhDangMouseClicked
        // TODO add your handling code here:
        index = tblHinhDang.getSelectedRow();
        setFormHinhDang(index);
    }//GEN-LAST:event_tblHinhDangMouseClicked

    private void txtIDHinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDHinhDangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDHinhDangActionPerformed

    private void btnThemHinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHinhDangActionPerformed
        // TODO add your handling code here:
        HinhDang hinhDang = getFormHinhDang();
        int addHinhDang = hinhDangDao.create(hinhDang);
        if (addHinhDang > 0) {
            System.out.println("ADD THanh COng");
            fillTableHinhDang();
        }
    }//GEN-LAST:event_btnThemHinhDangActionPerformed

    private void txtTenHinhdangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHinhdangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHinhdangActionPerformed

    private void btnSuaHinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHinhDangActionPerformed
        // TODO add your handling code here:
        HinhDang hinhDang = getFormHinhDang();
        int edit = hinhDangDao.update(hinhDang);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableHinhDang();
        }
    }//GEN-LAST:event_btnSuaHinhDangActionPerformed

    private void btnXoaHinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHinhDangActionPerformed
        // TODO add your handling code here:
        HinhDang hinhDang = getFormHinhDang();
        int edit = hinhDangDao.delete(hinhDang);
        if (edit > 0) {
            System.out.println("DELETE THanh COng");
            fillTableHinhDang();
        }
    }//GEN-LAST:event_btnXoaHinhDangActionPerformed

    private void btnKhoiPhucHinhDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucHinhDangActionPerformed
        // TODO add your handling code here:
        if (index != -1) {
            HinhDang hinhDang = getFormHinhDang();
            int edit = hinhDangDao.khoiphuc(hinhDang);
            if (edit > 0) {
                System.out.println("KHoi Phuc THanh COng");
                fillTableHinhDang();
            }
        }
    }//GEN-LAST:event_btnKhoiPhucHinhDangActionPerformed

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
        if (index != -1) {
            Vi vi = getFormVi();
            int edit = viDao.khoiphuc(vi);
            if (edit > 0) {
                System.out.println("KHoi Phuc THanh COng");
                fillTableVi();
            }
        }
    }//GEN-LAST:event_btnKhoiPhucVisuaActionPerformed

    private void tblTenSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTenSuaMouseClicked
        // TODO add your handling code here:
        index = tblTenSua.getSelectedRow();
        setFormTenSua(index);
    }//GEN-LAST:event_tblTenSuaMouseClicked

    private void txtIDTenSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDTenSua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDTenSua1ActionPerformed

    private void btnThemsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemsuaActionPerformed
        // TODO add your handling code here:
        TenSua tenSua = getFormTenSua();
        int addTenSua = tensuaDao.create(tenSua);
        if (addTenSua > 0) {
            System.out.println("ADD THanh COng");
            fillTableTenSua();
        }
    }//GEN-LAST:event_btnThemsuaActionPerformed

    private void txtTenSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSua1ActionPerformed

    private void btnSuasuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuasuaActionPerformed
        // TODO add your handling code here:
        TenSua tenSua = getFormTenSua();
        int edit = tensuaDao.update(tenSua);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableTenSua();
        }
    }//GEN-LAST:event_btnSuasuaActionPerformed

    private void btnXoasuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoasuaActionPerformed
        // TODO add your handling code here:
        TenSua tenSua = getFormTenSua();
        int edit = tensuaDao.delete(tenSua);
        if (edit > 0) {
            System.out.println("DELETE THanh COng");
            fillTableTenSua();
        }
    }//GEN-LAST:event_btnXoasuaActionPerformed

    private void btnKhoiPhucTenSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucTenSuaActionPerformed
        // TODO add your handling code here:
        if (index != -1) {
            TenSua tenSua = getFormTenSua();
            int edit = tensuaDao.khoiphuc(tenSua);
            if (edit > 0) {
                System.out.println("KHoi Phuc THanh COng");
                fillTableTenSua();
            }
        }
    }//GEN-LAST:event_btnKhoiPhucTenSuaActionPerformed

    private void tblMauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauMouseClicked
        // TODO add your handling code here:
        index = tblMau.getSelectedRow();
        setFormMau(index);
    }//GEN-LAST:event_tblMauMouseClicked

    private void txtIDMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDMauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDMauActionPerformed

    private void btnThemMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMauActionPerformed
        // TODO add your handling code here:
        Mau mau = getFormMau();
        int addMau = mauDao.create(mau);
        if (addMau > 0) {
            System.out.println("ADD THanh COng");
            fillTableMau();
        }
    }//GEN-LAST:event_btnThemMauActionPerformed

    private void txtTenMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenMauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenMauActionPerformed

    private void btnSuaMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaMauActionPerformed
        // TODO add your handling code here:
        Mau mau = getFormMau();
        int edit = mauDao.update(mau);
        if (edit > 0) {
            System.out.println("edit THanh COng");
            fillTableMau();
        }
    }//GEN-LAST:event_btnSuaMauActionPerformed

    private void btnXoaMauaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaMauaActionPerformed
        // TODO add your handling code here:
        Mau mau = getFormMau();
        int edit = mauDao.delete(mau);
        if (edit > 0) {
            System.out.println("DELETE THanh COng");
            fillTableMau();
        }
    }//GEN-LAST:event_btnXoaMauaActionPerformed

    private void btnKhoiPhucMau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoiPhucMau1ActionPerformed
        // khoi phuc

        if (index != -1) {
            Mau mau = getFormMau();
            int edit = mauDao.khoiphuc(mau);
            if (edit > 0) {
                System.out.println("KHoi Phuc THanh COng");
                fillTableMau();
            }
        }
    }//GEN-LAST:event_btnKhoiPhucMau1ActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BangHang;
    private javax.swing.JButton btnKhoiPhucHang;
    private javax.swing.JButton btnKhoiPhucHinhDang;
    private javax.swing.JButton btnKhoiPhucLoai;
    private javax.swing.JButton btnKhoiPhucMau1;
    private javax.swing.JButton btnKhoiPhucTenSua;
    private javax.swing.JButton btnKhoiPhucVisua;
    private javax.swing.JButton btnSuaAll;
    private javax.swing.JButton btnSuaHang;
    private javax.swing.JButton btnSuaHinhDang;
    private javax.swing.JButton btnSuaLoai;
    private javax.swing.JButton btnSuaMau;
    private javax.swing.JButton btnSuaVisua;
    private javax.swing.JButton btnSuasua;
    private javax.swing.JButton btnThemAll;
    private javax.swing.JButton btnThemHang;
    private javax.swing.JButton btnThemHinhDang;
    private javax.swing.JButton btnThemLoai;
    private javax.swing.JButton btnThemMau;
    private javax.swing.JButton btnThemVisua;
    private javax.swing.JButton btnThemsua;
    private javax.swing.JButton btnXoaHang;
    private javax.swing.JButton btnXoaHinhDang;
    private javax.swing.JButton btnXoaLoai;
    private javax.swing.JButton btnXoaMau;
    private javax.swing.JButton btnXoaMaua;
    private javax.swing.JButton btnXoaViSua;
    private javax.swing.JButton btnXoasua;
    private javax.swing.JComboBox<String> cbbHang;
    private javax.swing.JComboBox<String> cbbHinhDang;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JComboBox<String> cbbTenMau;
    private javax.swing.JComboBox<String> cbbTenSua;
    private javax.swing.JComboBox<String> cbbVi;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel tbl1;
    private javax.swing.JPanel tbl2;
    private javax.swing.JTable tblChiTietSua;
    private javax.swing.JTable tblHang;
    private javax.swing.JTable tblHinhDang;
    private javax.swing.JTable tblLoai;
    private javax.swing.JTable tblMau;
    private javax.swing.JTable tblTenSua;
    private javax.swing.JTable tblViSua;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtHanSuDung;
    private javax.swing.JTextField txtIDChiTietSua;
    private javax.swing.JTextField txtIDHang;
    private javax.swing.JTextField txtIDHinhDang;
    private javax.swing.JTextField txtIDLoai;
    private javax.swing.JTextField txtIDMau;
    private javax.swing.JTextField txtIDTenSua1;
    private javax.swing.JTextField txtIDViSua;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenHang;
    private javax.swing.JTextField txtTenHinhdang;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTenMau;
    private javax.swing.JTextField txtTenSua1;
    private javax.swing.JTextField txtTenViSua;
    // End of variables declaration//GEN-END:variables
}
