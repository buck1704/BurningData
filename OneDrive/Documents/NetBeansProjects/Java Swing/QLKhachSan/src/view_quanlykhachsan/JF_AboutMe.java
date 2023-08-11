package view_quanlykhachsan;

import control_quanlykhachsan.Data_QuanLy;
import model_quanlykhachsan.tbl_DoiMatKhau;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import control_quanlykhachsan.Data_QuanLyKhachSan;

public class JF_AboutMe extends javax.swing.JFrame {

    List<tbl_DoiMatKhau> arrDoiMatKhau = new ArrayList<>();
    private static String id, mkc, mkm;

    public JF_AboutMe() {
        initComponents();

    }

    public void KhoaMo(boolean b) {
        txttendn.setEditable(b);
        txtmkc.setEditable(b);
        txtmkm.setEditable(b);
        txtnlmkm.setEditable(b);
        bt_DoiMK.setEnabled(!b);
        bt_Thoat.setEnabled(!b);
    }

    public void refresh(boolean b) {
        txttendn.setEditable(b);
        txtmkc.setEditable(b);
        txtmkm.setEditable(b);
        txtnlmkm.setEditable(b);
        bt_DoiMK.setEnabled(!b);
        bt_Thoat.setEnabled(!b);
    }

    public void XoaTrang() {
        txttendn.setText("");
        txtmkc.setText("");
        txtmkm.setText("");
        txtnlmkm.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jp_doimatkhau = new javax.swing.JPanel();
        cbhtmk = new javax.swing.JCheckBox();
        bt_Thoat = new javax.swing.JButton();
        bt_DoiMK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmkc = new javax.swing.JPasswordField();
        txtnlmkm = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtmkm = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txttendn = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jp_doimatkhau.setBackground(new java.awt.Color(255, 255, 255));

        cbhtmk.setBackground(new java.awt.Color(255, 255, 255));
        cbhtmk.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        cbhtmk.setText("Hiển Thị Mật Khẩu ");
        cbhtmk.setIconTextGap(7);
        cbhtmk.setMargin(new java.awt.Insets(2, -1, 2, 2));

        bt_Thoat.setLabel("Thoát");
        bt_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ThoatActionPerformed(evt);
            }
        });

        bt_DoiMK.setText("Đổi Mật Khẩu");
        bt_DoiMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DoiMKActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setText("Nhập Mật Khẩu Mới: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Tên Đăng Nhập: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setText("Nhập Lại Mật khẩu Cũ:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("Nhập Lại Mật Khẩu Mới:");

        javax.swing.GroupLayout jp_doimatkhauLayout = new javax.swing.GroupLayout(jp_doimatkhau);
        jp_doimatkhau.setLayout(jp_doimatkhauLayout);
        jp_doimatkhauLayout.setHorizontalGroup(
            jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_doimatkhauLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbhtmk)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtmkm)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnlmkm)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmkc)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttendn, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_doimatkhauLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bt_DoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jp_doimatkhauLayout.setVerticalGroup(
            jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_doimatkhauLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txttendn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtmkc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(txtmkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(txtnlmkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbhtmk)
                .addGap(18, 18, 18)
                .addGroup(jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_DoiMK)
                    .addComponent(bt_Thoat))
                .addGap(50, 50, 50))
        );

        jTabbedPane1.addTab("Đổi Mật Khẩu", jp_doimatkhau);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ThoatActionPerformed
        // TODO add your handling code here:
        dispose();
        XoaTrang();
        refresh(true);
    }//GEN-LAST:event_bt_ThoatActionPerformed

    private void bt_DoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DoiMKActionPerformed
        String id = txttendn.getText();
        String mkc = txtmkc.getText();
        String mkm = txtmkm.getText();
        String nlMkm = txtnlmkm.getText();
        // Kiểm tra mật khẩu mới nhập lại có giống với mật khẩu mới không
        if (!mkm.equals(nlMkm)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới nhập lại không trùng khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            // Thực hiện đổi mật khẩu
            tbl_DoiMatKhau cn = new tbl_DoiMatKhau(id, mkc, mkm);
            Data_QuanLyKhachSan.DoiMatKhau(cn);
            JOptionPane.showMessageDialog(this, "Bạn đã thay đổi mật khẩu thành công", "Thông Báo ", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_bt_DoiMKActionPerformed

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
            java.util.logging.Logger.getLogger(JF_AboutMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_AboutMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_AboutMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_AboutMe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_AboutMe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_DoiMK;
    private javax.swing.JButton bt_Thoat;
    private javax.swing.JCheckBox cbhtmk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jp_doimatkhau;
    private javax.swing.JPasswordField txtmkc;
    private javax.swing.JPasswordField txtmkm;
    private javax.swing.JPasswordField txtnlmkm;
    private javax.swing.JTextField txttendn;
    // End of variables declaration//GEN-END:variables
}
