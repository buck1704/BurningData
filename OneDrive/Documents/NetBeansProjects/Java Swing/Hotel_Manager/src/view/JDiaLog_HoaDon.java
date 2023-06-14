package view;

import controller.HoaDonController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static view.JP_HoaDon.conthieuString;
import static view.JP_HoaDon.giadichvuString;
import static view.JP_HoaDon.giaphongString;
import static view.JP_HoaDon.giasanphString;
import static view.JP_HoaDon.mahoadonString;
import static view.JP_HoaDon.makhachhangString;
import static view.JP_HoaDon.maphongString;
import static view.JP_HoaDon.ngaydenString;
import static view.JP_HoaDon.ngaydiString;
import static view.JP_HoaDon.songayluutruString;
import static view.JP_HoaDon.tenkhachhangString;
import static view.JP_HoaDon.tongtienString;

public class JDiaLog_HoaDon extends javax.swing.JFrame {

    public JDiaLog_HoaDon() {
        initComponents();
        lb_mahoadon.setText(mahoadonString);
        lb_makh.setText(makhachhangString);
        lb_tenkh.setText(tenkhachhangString);
        lb_maphong.setText(maphongString);
        lb_ngayden.setText(ngaydenString);
        lb_ngaydi.setText(ngaydiString);
        lb_songayo.setText(songayluutruString);
        lb_giaphong.setText(giaphongString);
        lb_giasanpham.setText(giasanphString);
        lb_giadichvu.setText(giadichvuString);
        lb_TongTien.setText(tongtienString);
        lb_Con.setText(conthieuString);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_tenkh = new javax.swing.JLabel();
        lb_maphong = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lb_ngayden = new javax.swing.JLabel();
        lb_ngaydi = new javax.swing.JLabel();
        lb_songayo = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lb_giaphong = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lb_giadichvu = new javax.swing.JLabel();
        lb_Con = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_thanhtoan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lb_giasanpham = new javax.swing.JLabel();
        lb_TongTien = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_mahoadon = new javax.swing.JLabel();
        lb_makh = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N

        lb_tenkh.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_tenkh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tenkh.setText(" ");

        lb_maphong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_maphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_maphong.setText(" ");

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel10.setText("Phòng:");

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel16.setText("Ngày Đến:");

        lb_ngayden.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_ngayden.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_ngayden.setText(" ");

        lb_ngaydi.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_ngaydi.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_ngaydi.setText(" ");

        lb_songayo.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_songayo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_songayo.setText(" ");

        jLabel26.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel26.setText("Tổng Tiền:");

        lb_giaphong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_giaphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_giaphong.setText(" ");

        jLabel21.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel21.setText("Còn:");

        lb_giadichvu.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_giadichvu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_giadichvu.setText(" ");

        lb_Con.setFont(new java.awt.Font("Montserrat Medium", 1, 18)); // NOI18N
        lb_Con.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_Con.setText(" ");

        jLabel15.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel15.setText("Ngày Đi:");

        txt_thanhtoan.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txt_thanhtoan.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jLabel14.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel14.setText("Lưu Trú:");

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel13.setText("Giá Phòng:");

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel19.setText("Tiếp tục thanh toán:");

        jButton2.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        jButton2.setText("Thanh Toán");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel24.setText("Giá Dịch Vụ:");

        jButton1.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        jButton1.setText("Quay Lại");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel20.setText("Giá Sản Phẩm:");

        lb_giasanpham.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_giasanpham.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_giasanpham.setText(" ");

        lb_TongTien.setFont(new java.awt.Font("Montserrat Medium", 0, 18)); // NOI18N
        lb_TongTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_TongTien.setText(" ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Chi Tiết Thanh Toán");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setPreferredSize(new java.awt.Dimension(105, 100));

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel3.setText("Mã Hoá Đơn:");

        lb_mahoadon.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_mahoadon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_mahoadon.setText(" ");

        lb_makh.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N
        lb_makh.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_makh.setText(" ");

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel6.setText("Mã Khách Hàng:");

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel7.setText("Người Đặt:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txt_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_mahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_ngayden, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_ngaydi, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_songayo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_giaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_giadichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_Con, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_giasanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lb_mahoadon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lb_makh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lb_tenkh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lb_maphong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lb_ngayden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(lb_ngaydi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(lb_songayo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lb_giaphong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(lb_giadichvu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(lb_giasanpham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(lb_TongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Con))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        double tiencocCSDLDouble = Double.parseDouble(JP_HoaDon.tiencocString);
        double tienconthieuDouble = Double.parseDouble(lb_Con.getText());
        double tiencocHT = Double.parseDouble(txt_thanhtoan.getText());
        double tienhientai = tiencocCSDLDouble + tiencocHT;
        if (tiencocHT > tienconthieuDouble) {
            JOptionPane.showMessageDialog(this, "Tiền thanh toán phải nhỏ hơn số tiền còn lại!", "Thông Báo", JOptionPane.ERROR_MESSAGE);
        } else {
            int kq = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn thanh toán hoá đơn này không?", "Thông Báo", JOptionPane.YES_NO_OPTION);
            if (kq == JOptionPane.YES_OPTION) {
                try {
                    HoaDonController.CapNhatHoaDon(lb_mahoadon.getText(), tienhientai);
                    JP_HoaDon.LayNguon("");
                    JPanel pa = new JP_HoaDon();
                    pa.setVisible(true);
                    dispose();
                    if (tienhientai == tiencocHT){
                        HoaDonController.CapNhatPhong(maphongString);
                    }
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(JDiaLog_HoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JDiaLog_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDiaLog_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDiaLog_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDiaLog_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new JDiaLog_HoaDon().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_Con;
    private javax.swing.JLabel lb_TongTien;
    private javax.swing.JLabel lb_giadichvu;
    private javax.swing.JLabel lb_giaphong;
    private javax.swing.JLabel lb_giasanpham;
    private javax.swing.JLabel lb_mahoadon;
    private javax.swing.JLabel lb_makh;
    private javax.swing.JLabel lb_maphong;
    private javax.swing.JLabel lb_ngayden;
    private javax.swing.JLabel lb_ngaydi;
    private javax.swing.JLabel lb_songayo;
    private javax.swing.JLabel lb_tenkh;
    private javax.swing.JTextField txt_thanhtoan;
    // End of variables declaration//GEN-END:variables
}
