package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.Hotel_Manager;
import view_nhanvien.JF_HomeKhachHang;

public class JF_DangNhap extends javax.swing.JFrame {
    public JF_DangNhap() {
        initComponents();
        this.setLocationRelativeTo(null);
        ckb_hienthimatkhau.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JCheckBox chk = (JCheckBox) e.getSource();
            if (chk.isSelected()) {
                // Hiển thị mật khẩu
                txt_MatKhau.setEchoChar((char) 0);
                ckb_hienthimatkhau.setText("Show Password");
            } else {
                // Ẩn mật khẩu
                txt_MatKhau.setEchoChar('*');
                ckb_hienthimatkhau.setText("Hide Password");
            }
        }
    });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_TaiKhoan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_MatKhau = new javax.swing.JPasswordField();
        bt_DangNhap = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ckb_hienthimatkhau = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(76, 41, 211));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 400));

        jPanel4.setBackground(new java.awt.Color(76, 41, 211));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 100));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        jLabel1.setPreferredSize(new java.awt.Dimension(400, 25));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user_50px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(76, 41, 211));
        jPanel5.setPreferredSize(new java.awt.Dimension(350, 200));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Name:");

        txt_TaiKhoan.setMargin(new java.awt.Insets(0, 5, 0, 0));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");

        txt_MatKhau.setMargin(new java.awt.Insets(0, 5, 0, 0));

        bt_DangNhap.setBackground(new java.awt.Color(239, 239, 239));
        bt_DangNhap.setFont(new java.awt.Font("Montserrat Light", 1, 13)); // NOI18N
        bt_DangNhap.setText("Đăng Nhập");
        bt_DangNhap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bt_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DangNhapActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 2, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Forgot pass, click me!");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        ckb_hienthimatkhau.setBackground(new java.awt.Color(76, 41, 211));
        ckb_hienthimatkhau.setFont(new java.awt.Font("Montserrat SemiBold", 0, 11)); // NOI18N
        ckb_hienthimatkhau.setForeground(new java.awt.Color(255, 255, 255));
        ckb_hienthimatkhau.setText("Show Password");
        ckb_hienthimatkhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckb_hienthimatkhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_TaiKhoan)
                        .addComponent(txt_MatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(ckb_hienthimatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addComponent(bt_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ckb_hienthimatkhau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);

        jPanel3.setBackground(new java.awt.Color(239, 239, 239));
        jPanel3.setPreferredSize(new java.awt.Dimension(350, 0));

        jLabel7.setBackground(new java.awt.Color(243, 237, 226));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/banner_hotel.gif"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Management");
        jLabel6.setPreferredSize(new java.awt.Dimension(400, 25));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 30)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hotel App");
        jLabel8.setPreferredSize(new java.awt.Dimension(400, 25));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DangNhapActionPerformed
        try (Connection conn = DriverManager.getConnection(Hotel_Manager.dbURL);
            PreparedStatement psNV = conn.prepareStatement("SELECT taikhoan, matkhau, manhanvien FROM taikhoan WHERE taikhoan = ? AND matkhau = ? AND LEFT(MaNhanVien, 2) = 'NV'"); 
            PreparedStatement psQL = conn.prepareStatement("SELECT taikhoan, matkhau, manhanvien FROM taikhoan WHERE taikhoan = ? AND matkhau = ? AND LEFT(MaNhanVien, 2) = 'QL'")) {
            String UN = txt_TaiKhoan.getText();
            String PW = txt_MatKhau.getText();
            psNV.setString(1, UN);
            psNV.setString(2, PW);
            psQL.setString(1, UN);
            psQL.setString(2, PW);
            ResultSet rsNV = psNV.executeQuery();
            ResultSet rsQL = psQL.executeQuery();

            if (rsNV.next()) {
                Hotel_Manager.sTenDN = rsNV.getString("taikhoan");
                Hotel_Manager.sMatKhau = rsNV.getString("matkhau");
                Hotel_Manager.sMaNhanVien = rsNV.getString("manhanvien");
                JP_DatPhong.laymanhanvien = Hotel_Manager.sMaNhanVien;
                dispose();
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // tự động đóng thông báo sau 3 giây
                Timer timer = new Timer(3000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.getRootFrame().dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                JFrame jf_Main = new Home(); // Khởi tạo JFrame chính
                jf_Main.setLocationRelativeTo(null);
                jf_Main.setVisible(true); // Hiển thị JFrame chính
            } else if (rsQL.next()) {
                Hotel_Manager.sTenDN = rsQL.getString("taikhoan");
                Hotel_Manager.sMatKhau = rsQL.getString("matkhau");
                Hotel_Manager.sMaNhanVien = rsQL.getString("manhanvien");
                JP_DatPhong.laymanhanvien = Hotel_Manager.sMaNhanVien;
                dispose();
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                // tự động đóng thông báo sau 3 giây
                Timer timer = new Timer(3000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.getRootFrame().dispose();
                    }
                });
                timer.setRepeats(false);
                timer.start();
                JFrame jf_Main1 = new JF_HomeKhachHang(); // Khởi tạo JFrame chính
                jf_Main1.setLocationRelativeTo(null);
                jf_Main1.setVisible(true); // Hiển thị JFrame chính
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu sai, vui lòng nhập lại !", "Thông Báo", JOptionPane.ERROR_MESSAGE);
                txt_TaiKhoan.requestFocus();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_bt_DangNhapActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        System.out.println("Notification: Quên mật khẩu");
        JFrame jf_QuenMatKhau = new JF_QuenMatKhau();                                    // Khởi tạo JFrame chính
        jf_QuenMatKhau.setLocationRelativeTo(null);
        jf_QuenMatKhau.setVisible(true);                                       // Hiển thị JFrame chính 
    }//GEN-LAST:event_jLabel4MouseClicked

    private void ckb_hienthimatkhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckb_hienthimatkhauActionPerformed
        
    }//GEN-LAST:event_ckb_hienthimatkhauActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_DangNhap;
    private javax.swing.JCheckBox ckb_hienthimatkhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField txt_MatKhau;
    private javax.swing.JTextField txt_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}
