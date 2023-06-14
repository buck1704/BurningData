package view;

import controller.QuanLyController;
import model.tbl_DoiMatKhau;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import controller.QuanLyKhachSanController;

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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_manhanvien = new javax.swing.JLabel();
        txt_tennhanvien = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_machucvu = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_gioitinh = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_ngaysinh = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_luong = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("THÔNG TIN NHÂN VIÊN ĐĂNG NHẬP");

        jLabel7.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel7.setText("Mã Nhân Viên:");

        txt_manhanvien.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_manhanvien.setText("Hiển thị mã nhân viên");

        txt_tennhanvien.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_tennhanvien.setText("Hiển thị tên nhân viên");

        jLabel8.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel8.setText("Tên Nhân Viên:");

        txt_machucvu.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_machucvu.setText("Hiển thị mã chức vụ");

        jLabel9.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel9.setText("Mã Chức Vụ:");

        txt_gioitinh.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_gioitinh.setText("Hiển thị giới tính");

        jLabel10.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel10.setText("Giới Tính:");

        jLabel11.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel11.setText("Ngày Sinh:");

        txt_ngaysinh.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_ngaysinh.setText("Hiển thị ngày sinh");

        txt_sdt.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_sdt.setText("Hiển thị sdt");

        jLabel12.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel12.setText("SĐT:");

        jLabel13.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel13.setText("Địa Chỉ:");

        txt_diachi.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_diachi.setText("Hiển thị địa chỉ ");

        jLabel14.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        jLabel14.setText("Lương:");

        txt_luong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        txt_luong.setText("Hiển thị lương");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_diachi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_luong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_gioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_machucvu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_tennhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_manhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_manhanvien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_tennhanvien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_machucvu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_gioitinh)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ngaysinh)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sdt)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_luong)
                    .addComponent(jLabel14))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thông Tin Cá Nhân", jPanel2);

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

        txtmkc.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        txtnlmkm.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Tên Đăng Nhập: ");

        txtmkm.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setText("Nhập Lại Mật khẩu Cũ:");

        txttendn.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("Nhập Lại Mật Khẩu Mới:");

        javax.swing.GroupLayout jp_doimatkhauLayout = new javax.swing.GroupLayout(jp_doimatkhau);
        jp_doimatkhau.setLayout(jp_doimatkhauLayout);
        jp_doimatkhauLayout.setHorizontalGroup(
            jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_doimatkhauLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbhtmk)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmkm)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnlmkm)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmkc)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txttendn, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_doimatkhauLayout.createSequentialGroup()
                        .addComponent(bt_DoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jp_doimatkhauLayout.setVerticalGroup(
            jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_doimatkhauLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txttendn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtmkc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, 0)
                .addComponent(txtmkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(txtnlmkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(cbhtmk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp_doimatkhauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_DoiMK)
                    .addComponent(bt_Thoat))
                .addGap(105, 105, 105))
        );

        jTabbedPane1.addTab("Đổi Mật Khẩu", jp_doimatkhau);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);

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
            QuanLyKhachSanController.DoiMatKhau(cn);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jp_doimatkhau;
    private javax.swing.JLabel txt_diachi;
    private javax.swing.JLabel txt_gioitinh;
    private javax.swing.JLabel txt_luong;
    private javax.swing.JLabel txt_machucvu;
    private javax.swing.JLabel txt_manhanvien;
    private javax.swing.JLabel txt_ngaysinh;
    private javax.swing.JLabel txt_sdt;
    private javax.swing.JLabel txt_tennhanvien;
    private javax.swing.JPasswordField txtmkc;
    private javax.swing.JPasswordField txtmkm;
    private javax.swing.JPasswordField txtnlmkm;
    private javax.swing.JTextField txttendn;
    // End of variables declaration//GEN-END:variables
}
