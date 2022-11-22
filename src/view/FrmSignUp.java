/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodel.TaiKhoan;
import java.awt.Color;
import javax.swing.JOptionPane;
import service.TaiKhoanService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utilities.DBConnection;

/**
 *
 * @author Admin
 */
public class FrmSignUp extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    private TaiKhoanService taiKhoanService = new TaiKhoanService();
    List<TaiKhoan> taiKhoans = new ArrayList<>();

    public FrmSignUp() {
        initComponents();
    }
    
    private boolean checkTK(){
        try {
            String name = txtUser.getText();
            Connection connection = DBConnection.getConnection();
            String sql = "SELECT USERNAME FROM TaiKhoan WHERE USERNAME ='" + name + "'";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery(sql);
            while (result.next()) {
                if (name.equalsIgnoreCase(txtUser.getText())) {
                    JOptionPane.showMessageDialog(this, "Username đã tồn tại");
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
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
        txtEmail = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtEmail.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        txtEmail.setText("abc@gmail.com");
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 192, 200, 30));

        txtPass.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        txtPass.setText("Password");
        txtPass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassFocusLost(evt);
            }
        });
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 261, 203, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sd.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 41));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lock_32px.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 40));

        btnSignup.setBackground(new java.awt.Color(255, 252, 196));
        btnSignup.setFont(new java.awt.Font("Roboto Slab Light", 0, 18)); // NOI18N
        btnSignup.setText("Sign up");
        btnSignup.setBorder(null);
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 110, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Sign up");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Sign in");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 50, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sign.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-secured-letter-32.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 40, 30));

        txtUser.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        txtUser.setText("Username");
        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserFocusLost(evt);
            }
        });
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 122, 203, 30));

        txtPass1.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        txtPass1.setText("Password");
        txtPass1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtPass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPass1FocusLost(evt);
            }
        });
        jPanel1.add(txtPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 335, 203, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-password-32.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 370, 460));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Hình nền cảnh núi, đồi đẹp.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        // TODO add your handling code here:
        if(checkTK()){
            TaiKhoan tk = new TaiKhoan(txtUser.getText(),txtPass.getText(), txtEmail.getText(),"stall");
                
                boolean check = taiKhoanService.dangKi(tk);
                if(check == true){
                    JOptionPane.showMessageDialog(this, "Đăng kí thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại");
                }
                taiKhoans.add(tk);
        }
    }//GEN-LAST:event_btnSignupActionPerformed

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        if (txtEmail.getText().equals("abc@gmail.com")) {
            txtEmail.setText("");
            txtEmail.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if (txtEmail.getText().equals("")) {
            txtEmail.setText("abc@gmail.com");
            txtEmail.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusGained
        // TODO add your handling code here:
        if (txtPass.getText().equals("Password")) {
            txtPass.setText("");
            txtPass.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtPassFocusGained

    private void txtPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassFocusLost
        // TODO add your handling code here:
        if (txtPass.getText().equals("")) {
            txtPass.setText("Password");
            txtPass.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtPassFocusLost

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        FrmLogin frmLogin = new FrmLogin();
        frmLogin.show();
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        FrmSignUp frmSignUp = new FrmSignUp();
        frmSignUp.show();
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void txtUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusGained
        // TODO add your handling code here:
        if (txtUser.getText().equals("Username")) {
            txtUser.setText("");
            txtUser.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtUserFocusGained

    private void txtUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserFocusLost
        // TODO add your handling code here:
        if (txtUser.getText().equals("")) {
            txtUser.setText("Username");
            txtUser.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtUserFocusLost

    private void txtPass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass1FocusGained
        // TODO add your handling code here:
        if (txtPass1.getText().equals("Password")) {
            txtPass1.setText("");
            txtPass1.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtPass1FocusGained

    private void txtPass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass1FocusLost
        // TODO add your handling code here:
        if (txtPass1.getText().equals("")) {
            txtPass1.setText("Password");
            txtPass1.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtPass1FocusLost

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
            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}