/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.toedter.calendar.JCalendar;
import domainmodel.HoaDon;
import domainmodel.KhuyenMai;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.math.BigDecimal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import service.IHoaDonService;
import service.impl.HoaDonService;
import viewmodel.GioHang;
import viewmodel.bangSPinHoaDon;
import viewmodel.HoaDonChiTiet;

/**
 *
 * @author HP probook
 */
public class BanGiay extends javax.swing.JPanel {

    /**
     * Creates new form BanGiay
     */
    public BanGiay() {
        initComponents();
        dtmSP = (DefaultTableModel) tblSP.getModel();
        listSP = hoaDonService.getSP();
        dtmGH = (DefaultTableModel) tblGH.getModel();
        listGH = hoaDonService.getGH();
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        listKM = hoaDonService.getKM();
        cbxKM.setModel(new DefaultComboBoxModel(listKM.toArray()));
        loadHDCT();
        loadSP();
        loadGH();

    }
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultTableModel dtmSP = new DefaultTableModel();
    private DefaultTableModel dtmHDCT = new DefaultTableModel();
    private DefaultTableModel dtmGH = new DefaultTableModel();
    private DefaultComboBoxModel boxModel = new DefaultComboBoxModel();

    private IHoaDonService hoaDonService = new HoaDonService();
    List<bangSPinHoaDon> listSP = new ArrayList<>();
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    List<HoaDonChiTiet> listHDCT2 = new ArrayList<>();

    List<GioHang> listGH = new ArrayList<>();
    List<KhuyenMai> listKM = new ArrayList<>();

    public void loadSP() {
        dtmSP.setRowCount(0);
        dtmSP = (DefaultTableModel) tblSP.getModel();
        listSP = hoaDonService.getSP();
        for (bangSPinHoaDon s : listSP) {
            dtmSP.addRow(new Object[]{s.getMaSP(), s.getTenSP(), s.getHang(), s.getMauSac(), s.getSize(),
                s.getGia(), s.getSoLuong(), s.getMoTa()});
        }
    }

    public void loadGH() {
        dtmGH.setRowCount(0);
        dtmGH = (DefaultTableModel) tblGH.getModel();
        listGH = hoaDonService.getGH();
        for (GioHang s : listGH) {
            dtmGH.addRow(new Object[]{s.getTenSP(), s.getHang(), s.getMauSac(),
                s.getSize(), s.getSoLuong(), s.getGia()
            });
        }
    }

    public void loadHDCT() {
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (HoaDonChiTiet s : listHDCT) {
            dtmHDCT.addRow(new Object[]{s.getMaHD(), s.getTenKH(), s.getTenSP(), s.getSl(), s.getMaNV(),
                s.getNgayTao(), s.getTongTien(), s.getTienCanTra(), s.getTienKhachDua(),
                s.getTIenThua(), s.TrangThai()
            });
        }
    }

    HoaDonChiTiet ThongTinHD() {
        HoaDonChiTiet h = new HoaDonChiTiet();
        h.setMaHD(txtMaHD.getText());
        h.setNgayTao(ngaytao.getDate());
        h.setTongTien(Double.valueOf(txtTongTien.getText()));
        h.setSDT(txtSDT.getText());
        h.setTenKH(txtTenKH.getText());
        h.setMaKM(cbxKM.getSelectedItem().toString());
        h.setTienCanTra(Double.valueOf(txtTienCanTra.getText()));
        h.setTienKhachDua(Double.valueOf(txtTienKD.getText()));
        h.setTIenThua(Double.valueOf(txtTienThua.getText()));
        h.setTienCanTra(Double.valueOf(txtTienCanTra.getText()));
        h.setTrangThai(TrangThai());
        h.setMaNV(txtMaNV.getText());

        listHDCT.add(h);
        return h;
    }

    public int TrangThai() {

        try {
            double tkd = Double.valueOf(txtTienKD.getText());
            double tct = Double.valueOf(txtTienCanTra.getText());
            if (tkd < tct) {
                return 2;
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public void New() {
        hoaDonService.bttaoGH();
        txtTongTien.setText("");
        txtSDT.setText("");
        txtGhiChu.setText("");
        txtMaNV.setText("");
        txtTenKH.setText("");
        txtMaHD.setText("");
        txtTienCanTra.setText("");
        txtTienKD.setText("0");
        // txtTienThua.setText("");
        txtTienGiam.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ngaytao = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTienKD = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienCanTra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTienGiam = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        cbxKM = new javax.swing.JComboBox<>();
        btnThanhToan = new javax.swing.JButton();
        btnChoTT = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblMa = new javax.swing.JLabel();
        btnXuatHd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGH = new javax.swing.JTable();
        btnTaoGh = new javax.swing.JButton();
        btnBoSP = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        cbxDaTT = new javax.swing.JCheckBox();
        cbxChoTT = new javax.swing.JCheckBox();
        cbxTatCa = new javax.swing.JCheckBox();
        txtTim = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();

        setForeground(java.awt.Color.white);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblSP.setBackground(new java.awt.Color(22, 143, 241));
        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SP", "TÊN SP", "HÃNG", "MÀU SẮC", "SIZE", "ĐƠN GIÁ", "SỐ LƯỢNG", "MÔ TẢ"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(22, 143, 241));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(22, 143, 241));

        jLabel1.setText("MAHD");

        jLabel2.setText("NGÀY TẠO");

        jLabel3.setText("TỔNG");

        txtTienThua.setText("0");

        jLabel4.setText("TIỀN CT");

        jLabel5.setText("TIỀN KD");

        jLabel6.setText("TIỀN THỪA");

        txtTienKD.setText("0");
        txtTienKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKDActionPerformed(evt);
            }
        });

        jLabel7.setText("MAKM");

        jLabel8.setText("MANV");

        jLabel9.setText("TIỀN GIẢM");

        jLabel10.setText("TÊN KH");

        jLabel11.setText("SDT");

        jLabel12.setText("GHI CHÚ");

        txtTienGiam.setText("0");

        cbxKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxKMActionPerformed(evt);
            }
        });

        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        btnChoTT.setText("CHUYỂN TT");
        btnChoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoTTActionPerformed(evt);
            }
        });

        btnHuy.setText("HỦY TT");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnXuatHd.setText("XUẤT HĐ");
        btnXuatHd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnXuatHd)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(40, 40, 40)
                                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblMa))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel6)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(txtTienKD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtTienCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(ngaytao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(48, 48, 48)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTienGiam, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbxKM, javax.swing.GroupLayout.Alignment.TRAILING, 0, 83, Short.MAX_VALUE)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnThanhToan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(btnChoTT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMa)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTienCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan)
                    .addComponent(btnChoTT)
                    .addComponent(btnHuy))
                .addGap(26, 26, 26)
                .addComponent(btnXuatHd)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giỏ hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblGH.setBackground(new java.awt.Color(22, 143, 241));
        tblGH.setForeground(new java.awt.Color(22, 143, 241));
        tblGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TÊN SP", "HÃNG", "MÀU SẮC", "SIZE", "SL", "GIÁ"
            }
        ));
        jScrollPane3.setViewportView(tblGH);

        btnTaoGh.setText("TẠO GH");
        btnTaoGh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoGhActionPerformed(evt);
            }
        });

        btnBoSP.setText("XÓA SP");
        btnBoSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTaoGh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBoSP)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoGh)
                    .addComponent(btnBoSP))
                .addGap(236, 236, 236))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setAutoCreateRowSorter(true);
        tblHoaDon.setBackground(new java.awt.Color(22, 143, 241));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ HD", "TÊN KH", "TÊN SP", "SL", "MANV", "NGÀY TT", "TỔNG", "CẦN TRẢ", "TIỀN KD", "TIỀN THỪA", "TRẠNG THÁI"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        buttonGroup1.add(cbxDaTT);
        cbxDaTT.setText("ĐÃ THANH TOÁN");
        cbxDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDaTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbxChoTT);
        cbxChoTT.setText("CHỜ THANH TOÁN");
        cbxChoTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxChoTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbxTatCa);
        cbxTatCa.setText("TẤT CẢ");
        cbxTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTatCaActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxDaTT)
                .addGap(18, 18, 18)
                .addComponent(cbxChoTT)
                .addGap(18, 18, 18)
                .addComponent(cbxTatCa)
                .addGap(43, 43, 43)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnTim)
                .addGap(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDaTT)
                    .addComponent(cbxChoTT)
                    .addComponent(cbxTatCa)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoGhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoGhActionPerformed
        // TODO add your handling code here:

//        btnChoTT.setEnabled(true);
//        btnHuy.setEnabled(true);
//        btnThanhToan.setEnabled(true);
        hoaDonService.bttaoGH();

        for (GioHang g : listGH) {
            hoaDonService.HuyHD(g.getTenSP(), g.getSoLuong());
        }
        hoaDonService.bttaoGH();
        New();
        loadGH();
        loadSP();

    }//GEN-LAST:event_btnTaoGhActionPerformed

    private void btnBoSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoSPActionPerformed
        // TODO add your handling code here:
        int i = tblGH.getSelectedRow();
        hoaDonService.xoaSPkhoiGH(tblGH.getValueAt(i, 0).toString(), Integer.parseInt(tblGH.getValueAt(i, 4).toString()));
        loadGH();
        loadSP();
        int t = 0;
        for (GioHang h : listGH) {
            t = (int) (t + h.getGia());
        }
        float tiengiam = Float.valueOf(txtTienGiam.getText());
        float tienct = t - tiengiam;
        txtTongTien.setText(String.valueOf(t));
        txtSDT.setText("0342215469");
        txtGhiChu.setText("ko");
        txtMaNV.setText("nv1");
        txtTenKH.setText("hung");
        txtTienCanTra.setText(String.valueOf(tienct));
        float tienKD = Float.valueOf(txtTienKD.getText());
        float tienThua = tienKD - tienct;
        txtTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_btnBoSPActionPerformed


    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();

        if (i == -1) {
            double tkd = Double.valueOf(txtTienKD.getText());
            double tct = Double.valueOf(txtTienCanTra.getText());
            if (tkd < tct) {
                JOptionPane.showMessageDialog(this, "Không đủ tiền để thanh toán");
            } else {
                hoaDonService.Themhd(ThongTinHD());
                for (GioHang g : listGH) {
                    hoaDonService.Themhdct(g.getTenSP(), txtMaHD.getText(), g.getSoLuong());
                }
                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                loadGH();
                loadSP();
                loadHDCT();
                hoaDonService.bttaoGH();
                return;
            }

        }

        if (tblHoaDon.getValueAt(i, 10).toString().equalsIgnoreCase("CHỜ TT")) {
            double tkd = Double.valueOf(txtTienKD.getText());
            double tct = Double.valueOf(txtTienCanTra.getText());
            if (tkd < tct) {
                JOptionPane.showMessageDialog(this, "Không đủ tiền để thanh toán");
                return;
            } else {
                hoaDonService.ThanhToanCho(Double.valueOf(txtTienKD.getText()), Double.valueOf(txtTienThua.getText()), tblHoaDon.getValueAt(i, 0).toString());
                JOptionPane.showMessageDialog(this, "Hóa đơn chờ đã được thanh toán");
                loadGH();
                loadSP();
                loadHDCT();
                hoaDonService.bttaoGH();

            }
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnChoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoTTActionPerformed
        // TODO add your handling code here:
        hoaDonService.Themhd(ThongTinHD());
        for (GioHang g : listGH) {
            hoaDonService.Themhdct(g.getTenSP(), txtMaHD.getText(), g.getSoLuong());
        }
        JOptionPane.showMessageDialog(this, "Hóa đơn đã được chuyển về trạng thái chờ.");
        loadGH();
        loadHDCT();
        hoaDonService.bttaoGH();
    }//GEN-LAST:event_btnChoTTActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        for (GioHang g : listGH) {
            hoaDonService.HuyHD(g.getTenSP(), g.getSoLuong());

        }
        int in = tblHoaDon.getSelectedRow();
        hoaDonService.HuyHD2(tblHoaDon.getValueAt(in, 0).toString());
        JOptionPane.showMessageDialog(this, "Hủy hóa đơn thành công");
        New();
        loadSP();
        loadGH();
        loadHDCT();
        hoaDonService.bttaoGH();

    }//GEN-LAST:event_btnHuyActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here
        int i = tblSP.getSelectedRow();
        String soLuong = JOptionPane.showInputDialog("Số lương ", "0");

        btnChoTT.setEnabled(true);
        btnHuy.setEnabled(true);
        btnThanhToan.setEnabled(true);
        int sl = Integer.parseInt(tblSP.getValueAt(i, 6).toString());
        if (sl > 0) {
            int t = 0;

            hoaDonService.ClickSpVaoHd2(tblSP.getValueAt(i, 0).toString(), Integer.parseInt(soLuong));
            loadGH();
            loadSP();
            for (GioHang h : listGH) {
                t = (int) (t + h.getGia());
            }
            float tiengiam = Float.valueOf(txtTienGiam.getText());
            float tienct = t - tiengiam;
            txtTongTien.setText(String.valueOf(t));
            // txtSDT.setText("0342215469");
            txtGhiChu.setText("ko");
            txtMaNV.setText("nv1");
            // txtTenKH.setText("hung");
            txtTienCanTra.setText(String.valueOf(tienct));
            // float tienKD = Float.valueOf(txtTienKD.getText());
            // float tienThua = tienKD - tienct;
            // txtTienThua.setText(String.valueOf(tienThua));
            JCalendar jcalendar = new JCalendar();
            ngaytao.setDate(jcalendar.getDate());
        } else {
            JOptionPane.showMessageDialog(this, "SP đã hết cửa hàng sẽ cập nhật thêm trong thời gian tới ");
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();
        if (tblHoaDon.getValueAt(i, 10).toString().equalsIgnoreCase("ĐÃ TT")) {
            btnChoTT.setEnabled(false);
            btnHuy.setEnabled(false);
            btnThanhToan.setEnabled(false);

        } else {
            btnChoTT.setEnabled(false);
            btnHuy.setVisible(true);
            btnThanhToan.setVisible(true);

        }
        txtMaHD.setText(tblHoaDon.getValueAt(i, 0).toString());
        ngaytao.setDate((Date) tblHoaDon.getValueAt(i, 5));
        txtTenKH.setText(tblHoaDon.getValueAt(i, 1).toString());
        // txtMaNV.setText(tblHoaDon.getValueAt(i, 4).toString());
        // cbxKM.setSelectedItem(tblHoaDon.getValueAt(i,4).toString());
        txtTongTien.setText(tblHoaDon.getValueAt(i, 6).toString());
        txtTienCanTra.setText(tblHoaDon.getValueAt(i, 7).toString());
        txtTienKD.setText(tblHoaDon.getValueAt(i, 8).toString());
        txtTienThua.setText(tblHoaDon.getValueAt(i, 9).toString());
        txtMaNV.setText(tblHoaDon.getValueAt(i, 6).toString());
        dtmGH = (DefaultTableModel) tblGH.getModel();
        listGH = hoaDonService.ClickHd(tblHoaDon.getValueAt(i, 0).toString());

        dtmGH.setRowCount(0);
        for (GioHang s : listGH) {
            dtmGH.addRow(new Object[]{s.getTenSP(), s.getHang(), s.getMauSac(),
                s.getSize(), s.getSoLuong(), s.getGia() * s.getSoLuong()
            });
        }

//        btnChoTT.setEnabled(false);
//        btnHuy.setVisible(true);
//        btnThanhToan.setVisible(true);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void cbxDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDaTTActionPerformed
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (int i = 0; i < listHDCT.size(); i++) {
            if (listHDCT.get(i).getTrangThai() == 1) {

                dtmHDCT.addRow(new Object[]{listHDCT.get(i).getMaHD(), listHDCT.get(i).getTenKH(),
                    listHDCT.get(i).getTenSP(), listHDCT.get(i).getSl(), listHDCT.get(i).getMaNV(),
                    listHDCT.get(i).getNgayTao(), listHDCT.get(i).getTongTien(), listHDCT.get(i).getTienCanTra(),
                    listHDCT.get(i).getTienKhachDua(), listHDCT.get(i).getTIenThua(), listHDCT.get(i).TrangThai()});
            }
        }
    }//GEN-LAST:event_cbxDaTTActionPerformed

    private void cbxChoTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxChoTTActionPerformed
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (int i = 0; i < listHDCT.size(); i++) {
            if (listHDCT.get(i).getTrangThai() == 2) {

                dtmHDCT.addRow(new Object[]{listHDCT.get(i).getMaHD(), listHDCT.get(i).getTenKH(),
                    listHDCT.get(i).getTenSP(), listHDCT.get(i).getSl(), listHDCT.get(i).getMaNV(),
                    listHDCT.get(i).getNgayTao(), listHDCT.get(i).getTongTien(), listHDCT.get(i).getTienCanTra(),
                    listHDCT.get(i).getTienKhachDua(), listHDCT.get(i).getTIenThua(), listHDCT.get(i).TrangThai()});
            }
        }
    }//GEN-LAST:event_cbxChoTTActionPerformed

    private void cbxTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTatCaActionPerformed
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT = hoaDonService.getHD();
        for (HoaDonChiTiet s : listHDCT) {
            dtmHDCT.addRow(new Object[]{s.getMaHD(), s.getTenKH(), s.getTenSP(), s.getSl(), s.getMaNV(),
                s.getNgayTao(), s.getTongTien(), s.getTienCanTra(), s.getTienKhachDua(),
                s.getTIenThua(), s.TrangThai()
            });
        }
    }//GEN-LAST:event_cbxTatCaActionPerformed

    private void txtTienKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKDActionPerformed
        // TODO add your handling code here:
        int t = 0;
        for (GioHang h : listGH) {
            t = (int) (t + h.getGia());
        }
        float tiengiam = Float.valueOf(txtTienGiam.getText());
        float tienct = t - tiengiam;
        txtTongTien.setText(String.valueOf(t));
        txtSDT.setText("0342215469");
        txtGhiChu.setText("ko");
        txtMaNV.setText("nv1");
        txtTenKH.setText("hung");
        txtTienCanTra.setText(String.valueOf(tienct));
        float tienKD = Float.valueOf(txtTienKD.getText());
        float tienThua = tienKD - tienct;
        txtTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_txtTienKDActionPerformed

    private void cbxKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxKMActionPerformed
        // TODO add your handling code here:
        KhuyenMai km = (KhuyenMai) cbxKM.getSelectedItem();
        hoaDonService.getKMsoTienGiam(km.getMaKM());
        txtTienGiam.setText(String.valueOf(km.getSoTienGiam()));
        int t = 0;
        for (GioHang h : listGH) {
            t = (int) (t + h.getGia());
        }
        float tiengiam = Float.valueOf(txtTienGiam.getText());
        float tienct = t - tiengiam;
        txtTongTien.setText(String.valueOf(t));

        txtTienCanTra.setText(String.valueOf(tienct));
        float tienKD = Float.valueOf(txtTienKD.getText());
        float tienThua = tienKD - tienct;
        txtTienThua.setText(String.valueOf(tienThua));
    }//GEN-LAST:event_cbxKMActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        dtmHDCT.setRowCount(0);
        dtmHDCT = (DefaultTableModel) tblHoaDon.getModel();
        listHDCT2 = hoaDonService.TimHD(txtTim.getText());
     
        for (HoaDonChiTiet s : listHDCT2) {
            dtmHDCT.addRow(new Object[]{s.getMaHD(), s.getTenKH(), s.getTenSP(), s.getSl(), s.getMaNV(),
                s.getNgayTao(), s.getTongTien(), s.getTienCanTra(), s.getTienKhachDua(),
                s.getTIenThua(), s.TrangThai()
            });
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnXuatHdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHdActionPerformed
        // TODO add your handling code here:
    
        PrinterJob job=PrinterJob.getPrinterJob();
        try {
            job.print();
            
            
        } catch (PrinterException ex) {
            Logger.getLogger(BanGiay.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnXuatHdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBoSP;
    private javax.swing.JButton btnChoTT;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTaoGh;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXuatHd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbxChoTT;
    private javax.swing.JCheckBox cbxDaTT;
    private javax.swing.JComboBox<String> cbxKM;
    private javax.swing.JCheckBox cbxTatCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblMa;
    private com.toedter.calendar.JDateChooser ngaytao;
    private javax.swing.JTable tblGH;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTienCanTra;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienKD;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
