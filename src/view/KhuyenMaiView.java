/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodel.KhuyenMai;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.KhuyenMaiServiceImpl;
import service.IKhuyenMaiService;
import utilities.XDate;

/**
 *
 * @author AS
 */
public class KhuyenMaiView extends javax.swing.JFrame {

    /**
     * Creates new form KhuyenMaiView
     */
    private DefaultTableModel defaultTableModel;
    List<KhuyenMai> list = new ArrayList<>();
    IKhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();

    public KhuyenMaiView() {
        initComponents();

        loadData(khuyenMaiService.getAll());
    }

    public void loadData(List<KhuyenMai> list) {
        defaultTableModel = (DefaultTableModel) tbKhuyenMai.getModel();
        defaultTableModel.setRowCount(0);
        for (KhuyenMai khuyenMai : list) {
            defaultTableModel.addRow(new Object[]{
                khuyenMai.getMaKM(),
                khuyenMai.getTenKM(),
                khuyenMai.getSoTienGiam(),
                khuyenMai.getNgayBD(),
                khuyenMai.getNgayKT(),
                khuyenMai.getTrangThai()
            });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhuyenMai = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        txtSoTienGiam = new javax.swing.JTextField();
        txtNgayKT = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        txtNgayBD = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã KM", "Tên KM", "Số tiền giảm", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tbKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhuyenMai);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Khuyến Mãi");

        jLabel2.setText("Mã khuyến mãi");

        jLabel3.setText("Số tiền giảm");

        jLabel4.setText("Ngày bắt đầu");

        jLabel5.setText("Ngày kết thúc");

        jLabel6.setText("Trạng thái");

        jLabel7.setText("Tên khuyến mãi");

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnThem)
                                            .addComponent(txtSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(37, 37, 37)
                                            .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(38, 38, 38)
                                            .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(btnSua)
                                .addGap(102, 102, 102)
                                .addComponent(btnXoa))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabel1)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkMaKhuyenMai(String ma) {
        List<KhuyenMai> list = new ArrayList<>();
        list = khuyenMaiService.getAll();
        for (KhuyenMai km : list) {
            if (ma.equals(km.getMaKM())) {
                JOptionPane.showMessageDialog(this, "exitsted");
                return false;
            }
        }
        return true;
    }

//    private KhuyenMai getDataContol() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String ngayBD = sdf.format(txtNgayBD.getText());
//        String ngayKT = sdf.format(txtNgayKT.getText());
//        return new KhuyenMai(txtMaKM.getText(), txtTenKM.getText(), new BigDecimal(txtSoTienGiam.getText()), ngayBD.getDate, Integer.valueOf(txtTrangThai.getText()));
//    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        KhuyenMai km = new KhuyenMai();
           km.setMaKM(txtMaKM.getText());
        km.setTenKM(txtTenKM.getText());
        XDate validator1 = new XDate(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        XDate validator2 = new XDate(DateTimeFormatter.ofPattern("d-M-yyyy"));
        if (validator1.isValid(txtNgayBD.getText()) && validator2.isValid(txtNgayBD.getText()) && validator1.isValid(txtNgayKT.getText()) && validator2.isValid(txtNgayKT.getText())) {
            for (int i = 0; i < fillter.length; i++) {
                if (txtNgayBD.getText().substring(0, txtNgayBD.getText().lastIndexOf("-")).equals(fillter[i])) {
                    JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày tháng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    break;
                }
                 if (txtNgayKT.getText().substring(0, txtNgayKT.getText().lastIndexOf("-")).equals(fillter[i])) {
                    JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày tháng", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
            return;
        }
        new BigDecimal(txtSoTienGiam.getText());
        km.setTrangThai(Integer.parseInt(txtTrangThai.getText()));
        khuyenMaiService.add(km);
        JOptionPane.showMessageDialog(this, "Thêm thành công!");
        loadData(khuyenMaiService.getAll());

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        int row = tbKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Click on table,please");
        } else {
            KhuyenMai km = new KhuyenMai();

            km.setMaKM(txtMaKM.getText());
            km.setTenKM(txtTenKM.getText());
            new BigDecimal(txtSoTienGiam.getText());
            km.setNgayBD(new Date(txtNgayBD.getText()));
            km.setNgayKT(new Date(txtNgayKT.getText()));
            km.setTrangThai(Integer.parseInt(txtTrangThai.getText()));

            khuyenMaiService.update(km, tbKhuyenMai.getValueAt(row, 0).toString());
            loadData(khuyenMaiService.getAll());
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        }
//            if (checkEmptyctsp()) {
//                int index = tb_qlsp_chitietsp.getSelectedRow();
//                lctsp = iChiTietSPService.getAll();
//                ChiTietSP ctsp = lctsp.get(index);
//                ctsp.setSanPham((SanPham) cb_ctsp_sp.getSelectedItem());
//                ctsp.setNsx((NSX) cb_ctsp_nsx.getSelectedItem());
//                ctsp.setMauSac((MauSac) cb_ctsp_mausac.getSelectedItem());
//                ctsp.setDongSP((DongSP) cb_ctsp_dongsp.getSelectedItem());
//                ctsp.setNamBH(Integer.parseInt(txt_ctsp_nambh.getText()));
//                ctsp.setSoLuongTon(Integer.parseInt(txt_SLton.getText()));
//                ctsp.setGiaNhap(Double.parseDouble(txt_ctsp_gianhap.getText()));
//                ctsp.setGiaBan(Double.parseDouble(txt_ctsp_giaban.getText()));
//                ctsp.setMoTa(txt_ctsp_mota.getText());
//                iChiTietSPService.update(ctsp, ctsp.getId());
//
//                JOptionPane.showMessageDialog(this, " update success");
//                load_QLSP_CTSP(iChiTietSPService.getAll());
//            } else {
//                JOptionPane.showMessageDialog(this, "update Fail");
//            }
//        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tbKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Click on table,please");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Chắc chắn xoá?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                khuyenMaiService.delete((String) tbKhuyenMai.getValueAt(row, 0));
                loadData(khuyenMaiService.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Fail!");
            }
        }
//        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiMouseClicked
        // TODO add your handling code here:

        List<KhuyenMai> km = new ArrayList<>();
        int row = tbKhuyenMai.getSelectedRow();

        txtMaKM.setText((String) tbKhuyenMai.getValueAt(row, 0));
        txtTenKM.setText((String) tbKhuyenMai.getValueAt(row, 1));
        //BigDecimal soTienGiam = 
        String soTienGiam = String.valueOf(tbKhuyenMai.getValueAt(row, 2));
        String ngayBD = String.valueOf(tbKhuyenMai.getValueAt(row, 3));
        txtSoTienGiam.setText(soTienGiam);
        txtNgayBD.setText(ngayBD);
        txtNgayKT.setText(String.valueOf(tbKhuyenMai.getValueAt(row, 4)));
        txtTrangThai.setText(String.valueOf(tbKhuyenMai.getValueAt(row, 5)));
    }//GEN-LAST:event_tbKhuyenMaiMouseClicked

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
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhuyenMaiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhuyenMaiView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKhuyenMai;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtNgayBD;
    private javax.swing.JTextField txtNgayKT;
    private javax.swing.JTextField txtSoTienGiam;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables

    String[] fillter = {
        "30-02", "31-02", "31-04", "31-06", "31-09", "31-11",
        "30/02", "31/02", "31/04", "31/06", "31/09", "31/11",
        "30-2", "31-2", "31-4", "31-6", "31-9",
        "30/2", "31/2", "31/4", "31/6", "31/9"
    };
}