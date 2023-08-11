package view;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDiaLog_BoLoc extends javax.swing.JFrame {

    public JDiaLog_BoLoc() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_xacnhan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        ckb_mahoadon = new javax.swing.JCheckBox();
        txt_mahd = new javax.swing.JTextField();
        ckb_makh = new javax.swing.JCheckBox();
        txt_makh = new javax.swing.JTextField();
        txt_tenkh = new javax.swing.JTextField();
        ckb_tenkh = new javax.swing.JCheckBox();
        ckb_manv = new javax.swing.JCheckBox();
        txt_manv = new javax.swing.JTextField();
        txt_tongtiento = new javax.swing.JTextField();
        ckb_trangthai = new javax.swing.JCheckBox();
        ckb_tongtien = new javax.swing.JCheckBox();
        ckb_ngayden = new javax.swing.JCheckBox();
        ckb_phong = new javax.swing.JCheckBox();
        txt_phong = new javax.swing.JTextField();
        txt_ngaydento = new com.toedter.calendar.JDateChooser();
        txt_ngaydenfrom = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_tongtienfrom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bộ Lọc");
        jLabel2.setPreferredSize(new java.awt.Dimension(105, 50));
        jPanel1.add(jLabel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(339, 50));

        btn_xacnhan.setBackground(new java.awt.Color(255, 255, 255));
        btn_xacnhan.setFont(new java.awt.Font("Montserrat", 1, 12)); // NOI18N
        btn_xacnhan.setText("Xác Nhận");
        btn_xacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(255, Short.MAX_VALUE)
                .addComponent(btn_xacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_xacnhan)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        ckb_mahoadon.setBackground(new java.awt.Color(255, 255, 255));
        ckb_mahoadon.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_mahoadon.setText("Mã Hoá Đơn:");

        txt_mahd.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        ckb_makh.setBackground(new java.awt.Color(255, 255, 255));
        ckb_makh.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_makh.setText("Mã Khách Hàng:");
        ckb_makh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_makhActionPerformed(evt);
            }
        });

        txt_makh.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        txt_tenkh.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        ckb_tenkh.setBackground(new java.awt.Color(255, 255, 255));
        ckb_tenkh.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_tenkh.setText("Tên Khách Hàng:");

        ckb_manv.setBackground(new java.awt.Color(255, 255, 255));
        ckb_manv.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_manv.setText("Nhân Viên Thực Hiện:");

        txt_manv.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        txt_tongtiento.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        ckb_trangthai.setBackground(new java.awt.Color(255, 255, 255));
        ckb_trangthai.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_trangthai.setText("Trạng thái hoá đơn");

        ckb_tongtien.setBackground(new java.awt.Color(255, 255, 255));
        ckb_tongtien.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_tongtien.setText("Tổng tiền:");

        ckb_ngayden.setBackground(new java.awt.Color(255, 255, 255));
        ckb_ngayden.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_ngayden.setText("Ngày đến:");

        ckb_phong.setBackground(new java.awt.Color(255, 255, 255));
        ckb_phong.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N
        ckb_phong.setText("Phòng:");

        txt_phong.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        txt_ngaydento.setDateFormatString("yyyy-MM-dd");
        txt_ngaydento.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        txt_ngaydenfrom.setDateFormatString("yyyy-MM-dd");
        txt_ngaydenfrom.setFont(new java.awt.Font("Montserrat Medium", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 2, 8)); // NOI18N
        jLabel1.setText("to");

        jLabel3.setFont(new java.awt.Font("Dialog", 2, 8)); // NOI18N
        jLabel3.setText("from");

        jLabel4.setFont(new java.awt.Font("Dialog", 2, 8)); // NOI18N
        jLabel4.setText("from");

        txt_tongtienfrom.setFont(new java.awt.Font("Montserrat Medium", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Dialog", 2, 8)); // NOI18N
        jLabel5.setText("to");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ckb_makh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ckb_mahoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ckb_tenkh, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_mahd)
                            .addComponent(txt_makh)
                            .addComponent(txt_tenkh, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ckb_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_manv))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ckb_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_phong))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ckb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ckb_ngayden, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ngaydenfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ngaydento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ckb_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_tongtienfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 2, Short.MAX_VALUE))
                            .addComponent(txt_tongtiento))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ckb_mahoadon)
                    .addComponent(txt_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckb_makh)
                    .addComponent(txt_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckb_tenkh)
                    .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckb_manv)
                    .addComponent(txt_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckb_phong)
                    .addComponent(txt_phong, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckb_ngayden)
                    .addComponent(txt_ngaydenfrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngaydento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckb_tongtien)
                    .addComponent(txt_tongtienfrom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tongtiento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(ckb_trangthai)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckb_makhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_makhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ckb_makhActionPerformed

    private void btn_xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhanActionPerformed
        try {
            StringBuilder sql = new StringBuilder("");
            if (ckb_mahoadon.isSelected()) {
                String condition1 = "hd.MaHoaDon LIKE '%" + txt_mahd.getText() + "%'";
                sql.append(" WHERE ").append(condition1);
            }
            
            if (ckb_makh.isSelected()) {
                String condition2 = "kh.MaKhachHang LIKE '%" + txt_makh.getText() + "%'";
                if (sql.toString().contains("WHERE")) {
                    sql.append(" AND ").append(condition2);
                } else {
                    sql.append(" WHERE ").append(condition2);
                }
            }
            
            if (ckb_tenkh.isSelected()) {
                String condition3 = "kh.TenKhachHang LIKE '%" + txt_tenkh.getText() + "%'";
                if (sql.toString().contains("WHERE")) {
                    sql.append(" AND ").append(condition3);
                } else {
                    sql.append(" WHERE ").append(condition3);
                }
            }
            if (ckb_manv.isSelected()) {
                String condition4 = "pdp.MaNhanVien LIKE '%" + txt_manv.getText() + "%'";
                if (sql.toString().contains("WHERE")) {
                    sql.append(" AND ").append(condition4);
                } else {
                    sql.append(" WHERE ").append(condition4);
                }
            }
            if (ckb_phong.isSelected()) {
                String condition5 = "pdp.MaPhong = '" + txt_phong.getText() + "'";
                if (sql.toString().contains("WHERE")) {
                    sql.append(" AND ").append(condition5);
                } else {
                    sql.append(" WHERE ").append(condition5);
                }
            }
            if (ckb_ngayden.isSelected()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String fromDate = dateFormat.format(txt_ngaydenfrom.getDate());
                String toDate = dateFormat.format(txt_ngaydento.getDate());
                String dateCondition = "pdp.NgayDen BETWEEN '" + fromDate + "' AND '" + toDate + "'";
                if (sql.toString().contains("WHERE")) {
                    sql.append(" AND ").append(dateCondition);
                } else {
                    sql.append(" WHERE ").append(dateCondition);
                }
            }
            if (ckb_tongtien.isSelected()) {
                String fromMoney = txt_tongtienfrom.getText();
                String toMoney = txt_tongtiento.getText();
                String Condition7 = "hd.TongTien BETWEEN " + fromMoney + " AND " + toMoney;
                if (sql.toString().contains("WHERE")) {
                    sql.append(" AND ").append(Condition7);
                } else {
                    sql.append(" WHERE ").append(Condition7);
                }
            }
            if (ckb_trangthai.isSelected()) {
                String condition8 = " hd.TongTien - hd.TienCoc != 0 ";
                if (sql.toString().contains("WHERE")) {
                    sql.append(" AND ").append(condition8);
                } else {
                    sql.append(" WHERE ").append(condition8);
                }
            }
            
            String finalSql = sql.toString();
            JP_HoaDon.LayNguon(finalSql);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(JDiaLog_BoLoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDiaLog_BoLoc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_xacnhanActionPerformed

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
            java.util.logging.Logger.getLogger(JDiaLog_BoLoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDiaLog_BoLoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDiaLog_BoLoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDiaLog_BoLoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JDiaLog_BoLoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xacnhan;
    private javax.swing.JCheckBox ckb_mahoadon;
    private javax.swing.JCheckBox ckb_makh;
    private javax.swing.JCheckBox ckb_manv;
    private javax.swing.JCheckBox ckb_ngayden;
    private javax.swing.JCheckBox ckb_phong;
    private javax.swing.JCheckBox ckb_tenkh;
    private javax.swing.JCheckBox ckb_tongtien;
    private javax.swing.JCheckBox ckb_trangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_mahd;
    private javax.swing.JTextField txt_makh;
    private javax.swing.JTextField txt_manv;
    private com.toedter.calendar.JDateChooser txt_ngaydenfrom;
    private com.toedter.calendar.JDateChooser txt_ngaydento;
    private javax.swing.JTextField txt_phong;
    private javax.swing.JTextField txt_tenkh;
    private javax.swing.JTextField txt_tongtienfrom;
    private javax.swing.JTextField txt_tongtiento;
    // End of variables declaration//GEN-END:variables
}
