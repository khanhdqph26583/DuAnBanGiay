/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
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
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.KhuyenMaiServiceImpl;
import service.IKhuyenMaiService;


/**
 *
 * @author AS
 */
public class FrmKhuyenMaiView extends javax.swing.JPanel {

    /**
     * Creates new form FrmKhuyenMaiView
     */
    
    private DefaultTableModel defaultTableModel;
    private ButtonGroup buttonGroup;
    List<KhuyenMai> list = new ArrayList<>();
    IKhuyenMaiService khuyenMaiService = new KhuyenMaiServiceImpl();
    
    public FrmKhuyenMaiView() {
        initComponents();
        
        loadData(khuyenMaiService.getAll());
        buttonGroupTrangThai();
    }

    public void buttonGroupTrangThai() {
        buttonGroup = new ButtonGroup();
        buttonGroup.add(rdTrangThai_tatca);
        buttonGroup.add(rdTrangThai_dangdienra);
        buttonGroup.add(rdTrangThai_sapdienra);
        buttonGroup.add(rdTrangThai_hethan);
    }

    public void loadData(List<KhuyenMai> list) {
        defaultTableModel = (DefaultTableModel) tbKhuyenMai.getModel();
        defaultTableModel.setRowCount(0);

        for (KhuyenMai khuyenMai : list) {

            String trangThai = null;
            if (khuyenMai.getTrangThai() == 0) {
                trangThai = "Hết hạn";
            } else if(khuyenMai.getTrangThai() == 1){
                trangThai = "Đang diễn ra";
            }else{
                trangThai = "Sắp diễn ra";
                }

            defaultTableModel.addRow(new Object[]{
                khuyenMai.getMaKM(),
                khuyenMai.getTenKM(),
                khuyenMai.getSoTienGiam(),
                khuyenMai.getNgayBD(),
                khuyenMai.getNgayKT(),
                trangThai
                //khuyenMai.getTrangThai() //<1<2:"Hết hạn","Đang diễn ra","Sắp diễn ra"
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        txtSoTienGiam = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        dateNgayKT = new com.toedter.calendar.JDateChooser();
        dateNgayBD = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhuyenMai = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        rdTrangThai_tatca = new javax.swing.JRadioButton();
        rdTrangThai_dangdienra = new javax.swing.JRadioButton();
        rdTrangThai_sapdienra = new javax.swing.JRadioButton();
        rdTrangThai_hethan = new javax.swing.JRadioButton();

        jLabel1.setText("Mã khuyến mãi");

        jLabel2.setText("Trạng thái");

        jLabel3.setText("Số tiền giảm");

        jLabel4.setText("Tên khuyến mãi");

        jLabel5.setText("Ngày kết thúc");

        jLabel6.setText("Ngày bắt đầu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addComponent(txtSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(358, Short.MAX_VALUE)
                    .addComponent(dateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(19, 19, 19)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(dateNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(dateNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(111, Short.MAX_VALUE)))
        );

        tbKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Số tiền giảm", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
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

        jLabel7.setText("Trạng thái");

        rdTrangThai_tatca.setText("Tất cả");
        rdTrangThai_tatca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTrangThai_tatcaMouseClicked(evt);
            }
        });
        rdTrangThai_tatca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTrangThai_tatcaActionPerformed(evt);
            }
        });

        rdTrangThai_dangdienra.setText("Đang diễn ra");
        rdTrangThai_dangdienra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTrangThai_dangdienraMouseClicked(evt);
            }
        });

        rdTrangThai_sapdienra.setText("Sắp diễn ra");
        rdTrangThai_sapdienra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTrangThai_sapdienraMouseClicked(evt);
            }
        });

        rdTrangThai_hethan.setText("Hết hạn");
        rdTrangThai_hethan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdTrangThai_hethanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdTrangThai_sapdienra)
                    .addComponent(rdTrangThai_hethan)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7)
                        .addComponent(rdTrangThai_tatca))
                    .addComponent(rdTrangThai_dangdienra))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(rdTrangThai_tatca)
                .addGap(18, 18, 18)
                .addComponent(rdTrangThai_dangdienra)
                .addGap(18, 18, 18)
                .addComponent(rdTrangThai_sapdienra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rdTrangThai_hethan)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(btnThem)
                                .addGap(83, 83, 83)
                                .addComponent(btnSua)
                                .addGap(86, 86, 86)
                                .addComponent(btnXoa)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnXoa)
                            .addComponent(btnSua)
                            .addComponent(btnThem))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdTrangThai_tatcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTrangThai_tatcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdTrangThai_tatcaActionPerformed

    private void tbKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhuyenMaiMouseClicked
        // TODO add your handling code here:
        List<KhuyenMai> km = new ArrayList<>();
        int row = tbKhuyenMai.getSelectedRow();

        txtMaKM.setText((String) tbKhuyenMai.getValueAt(row, 0));
        txtTenKM.setText((String) tbKhuyenMai.getValueAt(row, 1));
        String soTienGiam = String.valueOf(tbKhuyenMai.getValueAt(row, 2));
        txtSoTienGiam.setText(soTienGiam);
        txtTrangThai.setText(String.valueOf(tbKhuyenMai.getValueAt(row, 5)));

        try {
            int dateRow = tbKhuyenMai.getSelectedRow();
            Date dateBD = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(tbKhuyenMai.getValueAt(dateRow, 3)));
            Date dateKT = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(tbKhuyenMai.getValueAt(dateRow, 4)));
            dateNgayBD.setDate(dateBD);
            dateNgayKT.setDate(dateKT);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_tbKhuyenMaiMouseClicked

    private void rdTrangThai_tatcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTrangThai_tatcaMouseClicked
        // TODO add your handling code here:
        loadData(khuyenMaiService.getAll());
    }//GEN-LAST:event_rdTrangThai_tatcaMouseClicked

    private void rdTrangThai_dangdienraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTrangThai_dangdienraMouseClicked
        // TODO add your handling code here:
        loadData(khuyenMaiService.dangDienRa());
    }//GEN-LAST:event_rdTrangThai_dangdienraMouseClicked

    private void rdTrangThai_sapdienraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTrangThai_sapdienraMouseClicked
        // TODO add your handling code here:
        loadData(khuyenMaiService.sapDienRa());
    }//GEN-LAST:event_rdTrangThai_sapdienraMouseClicked

    private void rdTrangThai_hethanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdTrangThai_hethanMouseClicked
        // TODO add your handling code here:
        loadData(khuyenMaiService.hetHan());
    }//GEN-LAST:event_rdTrangThai_hethanMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        KhuyenMai km = new KhuyenMai();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD = sdf.format(dateNgayBD.getDate());
        String ngayKT = sdf.format(dateNgayKT.getDate());

        km.setMaKM(txtMaKM.getText());
        km.setTenKM(txtTenKM.getText());
        km.setSoTienGiam(new BigDecimal(txtSoTienGiam.getText()));
        km.setNgayBD(ngayBD);
        km.setNgayKT(ngayKT);
        km.setTrangThai(Integer.parseInt(txtTrangThai.getText()));

        khuyenMaiService.add(km);
        JOptionPane.showMessageDialog(this, "Thêm thành công!");
        loadData(khuyenMaiService.getAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
int row = tbKhuyenMai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Click on table,please");
        } else {
            KhuyenMai km = new KhuyenMai();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayBD = sdf.format(dateNgayBD.getDate());
            String ngayKT = sdf.format(dateNgayKT.getDate());

            km.setMaKM(txtMaKM.getText());
            km.setTenKM(txtTenKM.getText());
            km.setSoTienGiam(new BigDecimal(txtSoTienGiam.getText()));
            km.setNgayBD(ngayBD);
            km.setNgayKT(ngayKT);
            km.setTrangThai(Integer.parseInt(txtTrangThai.getText()));

            khuyenMaiService.update(km, (String) tbKhuyenMai.getValueAt(row, 0));
            loadData(khuyenMaiService.getAll());
            JOptionPane.showMessageDialog(this, "Sửa thành công!");
        }        
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
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private com.toedter.calendar.JDateChooser dateNgayBD;
    private com.toedter.calendar.JDateChooser dateNgayKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdTrangThai_dangdienra;
    private javax.swing.JRadioButton rdTrangThai_hethan;
    private javax.swing.JRadioButton rdTrangThai_sapdienra;
    private javax.swing.JRadioButton rdTrangThai_tatca;
    private javax.swing.JTable tbKhuyenMai;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtSoTienGiam;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
}
